import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.statement.*
import io.ktor.http.takeFrom
import kotlinx.coroutines.*
import java.lang.management.ManagementFactory
import java.security.SecureRandom
import java.util.*

fun main() {
    // Use the Coroutine based I/O client
    val client = HttpClient(CIO)
    logln("Hi")

    // runBlocking creates a new coroutine context that blocks until all
    // coroutines within it are complete, it also creates a single new active
    // coroutine
    runBlocking {
        logln("Within context top")

        // repeat is just a normal loop
        repeat(3) {

            // launch creates a new coroutine within an existing context and makes it active
            launch {
                httpGet(client)
            }
        }

        waitForCall()

        logln("Within context bottom")
    }

    // All the coroutines started in runBlocking are now complete
    client.close()
    logln("Goodbye")
}

fun callMeSometime(callback: java.lang.Runnable) {
    val delay = SecureRandom().nextInt(10000)
    logln("Setting up local delay=$delay")

    Thread({
        Thread.sleep(delay.toLong())
        logln("Calling after delay=$delay")
        callback.run()
    }, "local").start()
}

suspend fun waitForCall() =
        suspendCancellableCoroutine { cont ->
            logln("Start waitForCall")
            val callback = java.lang.Runnable {
                cont.resume(null, null)
            }
            callMeSometime(callback)
            logln("End waitForCall")
        }

suspend fun httpGet(client : HttpClient) {
    // First half of the function starts here
    val delay = SecureRandom().nextInt(10000)
    logln("Start request, delay=$delay")

    // This function call can suspend
    val response = client.myGet("http://httpstat.us/200?sleep=$delay")

    // Second half of the function starts here
    val statusCode = response.status
    logln("Got response, delay=$delay, $statusCode")
}

fun logln(s : String) {
    val rb = ManagementFactory.getRuntimeMXBean()
    println(String.format(Locale.US, "%08d", rb.uptime) + ": " + s + " (" + Thread.currentThread().name + ")")
}

// Copied from Ktor client core for JVM but not inlined to make the decompiled
// code easier to understand. This is a suspend function, meaning at one or
// more places in the middle it may return and then pick up where it left off
// later
suspend fun HttpClient.myGet(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {}
): HttpResponse = get {
    url.takeFrom(urlString)
    block()
}