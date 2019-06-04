import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.takeFrom
import kotlinx.coroutines.*
import java.lang.management.ManagementFactory
import java.security.SecureRandom
import java.util.*

@io.ktor.util.KtorExperimentalAPI
fun main() {
    val client = HttpClient(CIO)
    logln("Hi")
    runBlocking {
        repeat(3) {
            launch {
                httpGet(client)
            }
        }
    }
    client.close()
    logln("Goodbye")
}

fun logln(s : String) {
    val rb = ManagementFactory.getRuntimeMXBean()
    println(String.format(Locale.US, "%08d", rb.uptime) + ": " + s + " (" + Thread.currentThread() + ")")
}

suspend fun httpGet(client : HttpClient) {
    val delay = SecureRandom().nextInt(10000)
    logln("Start request, delay=$delay")
    val response = client.myGet("http://httpstat.us/200?sleep=$delay")
    val len = response.size
    logln("Got response, delay=$delay, length=$len")
}

// Not inline to make the httpGet function simpler
suspend fun HttpClient.myGet(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {}
): ByteArray = get {
    url.takeFrom(urlString)
    block()
}