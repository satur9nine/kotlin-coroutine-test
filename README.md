# Kotlin Coroutine Sample

This project contains a minimal application demonstrating use of Kotlin coroutines with the Ktor HTTP CIO client.

To run this application open it with IntelliJ and run it or:

On Mac OS or Linux:
```
./gradlew run
```

On Windows:
```
gradlew run
```

In IntelliJ you can use the debugger, pause the application or set breakpoints and inspect the various thread frames.

This partial trace shows the particular thread that is used to wait for various HTTP get operations to complete.

```
java.lang.RuntimeException: trace
 	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
 	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
 	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
 	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
 	at io.ktor.network.selector.ActorSelectorManager.select(ActorSelectorManager.kt:96)
 	at io.ktor.network.selector.ActorSelectorManager$select$1.invokeSuspend(ActorSelectorManager.kt)
 	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
 	at kotlinx.coroutines.DispatchedTask.run(Dispatched.kt:238)
 	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
 	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
 	at java.lang.Thread.run(Thread.java:748)
 ```