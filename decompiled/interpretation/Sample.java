/*
 * This is a rough intepretation of how what coroutines look after being
 * decompiled from JVM class files produced by the kotlin compiler.
 *
 * See Sample.kt for the original Kotlin source code
 */

enum CoroutineStatus {
    ACTIVE, SUSPENDED, COMPLETE;
}

class Continuation {
    Object result;
}

class Sample {
    void main() {
        logln("Hi");

        CoroutineEventLoop cel;

        cel.addCoroutine(new MyCoroutine());
        cel.addCoroutine(new MyCoroutine());
        cel.addCoroutine(new MyCoroutine());

        // begin event loop, exit only when all coroutine are complete
        do {
            // get the next active coroutine, if none blocks until one is ready
            Coroutine c = cel.getNextActiveCoroutine();

            // execute selected coroutine
            Object result = c.invoke();

            if (result == Intrinsics.COMPLETE) {
                cel.removeCoroutine(c);
            }
        } while (cel.hasCoroutines());

        logln("Goodbye");
    }
}

class MyCoroutine {
    class MyContinuation extends Continuation {
        int delay;
    }

    int label = 0;
    MyContinuation continuation;

    Object invoke() {
        int delay;

        // Obtain result possibly set by any invoked suspend functions
        Object result = continuation.result;
        Object deflt = null;

        switch (label) {
            case 0:
                delay = new SecureRandom().nextInt(10000);
                logln("Start request, delay=" + delay);
                String string = "http://httpstat.us/200?sleep=" + delay;

                // save the stack
                continuation.delay = delay;
                label = 1;

                // takes a Continuation and sets the result when received
                deflt = httpGet(string, continuation);
                if (deflt == Intrinsics.SUSPENDED) {
                    return Intrinsics.SUSPENDED;
                }
                break;
            case 1:
                // restore the stack
                delay = continuation.delay;
                deflt = result;
                break;
        }

        byte[] httpResponse = deflt;
        int len = httpResponse.length;
        logln("Got response, delay=" + delay + ", length=" + len);
    }
}