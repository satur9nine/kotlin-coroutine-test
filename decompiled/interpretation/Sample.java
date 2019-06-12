/*
 * This is a rough intepretation of how what coroutines look after being
 * decompiled from JVM class files produced by the kotlin compiler.
 *
 * See Sample.kt for the original Kotlin source code and SampleKt.decomp.java
 * for the raw decompiled code.
 */

enum CoroutineStatus {
    ACTIVE, SUSPENDED, COMPLETE;
}

class Continuation {
    Object result;
    CoroutineStatus status;
}

interface Coroutine {
    // Run the coroutine synchronously
    Object invoke();

    // Allows the event loop to get the status
    Continuation getContinuation();
}

class Sample {
    void main() {
        logln("Hi");

        CoroutineEventLoop cel;

        // repeat 3 times
        for (int i = 0; i < 3; i++) {
            cel.addCoroutine(new MyCoroutine());
        }

        // This is a gross simplification of runBlocking that isn't really
        // accurate but close enough for our needs, for real code see:
        // https://github.com/Kotlin/kotlinx.coroutines/blob/1.2.1/kotlinx-coroutines-core/jvm/src/Builders.kt

        // begin event loop, exit only when all coroutine are complete
        do {
            // get the next active coroutine, if none blocks until one is ready
            Coroutine c = cel.getNextActiveCoroutine();

            // execute selected coroutine
            CoroutineStatus status = c.invoke();

            // remove this particular coroutine if it is complete
            if (status == Intrinsics.COMPLETE) {
                cel.removeCoroutine(c);
            }

            c.getContinuation().status = status;
        } while (cel.hasCoroutines());

        logln("Goodbye");
    }
}

class MyCoroutine extends Coroutine {
    class MyContinuation extends Continuation {
        int delay;
    }

    int label = 0;
    MyContinuation continuation;

    Continuation getContinuation() {
        return continuation;
    }

    Object invoke() {
        int delay = 0;

        // Obtain result possibly set by any invoked suspend functions
        Object result = continuation.result;
        Object deflt = null;

        switch (label) {
            // First half of the function starts here
            case 0:
                delay = new SecureRandom().nextInt(10000);
                logln("Start request, delay=" + delay);
                String string = "http://httpstat.us/200?sleep=" + delay;

                // save the stack
                continuation.delay = delay;
                label = 1;

                // The httpGet function takes a Continuation and when complete
                // does the following:
                //  * save result in Continuation#result
                //  * set Continuation#status to ACTIVE
                //  * notify event loop thread to wake up
                deflt = httpGet(string, continuation);
                if (deflt == Intrinsics.SUSPENDED) {
                    return Intrinsics.SUSPENDED;
                }
                break;
            // Second half of the function starts here
            case 1:
                // restore the stack
                delay = continuation.delay;
                deflt = result;
                break;
        }

        byte[] httpResponse = deflt;
        int len = httpResponse.length;
        logln("Got response, delay=" + delay + ", length=" + len);

        return Intrinsics.COMPLETE;
    }
}