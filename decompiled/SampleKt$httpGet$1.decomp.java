import org.jetbrains.annotations.Nullable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import io.ktor.client.HttpClient;
import org.jetbrains.annotations.NotNull;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

// 
// Decompiled by Procyon v0.5.34
// 

@Metadata(mv = { 1, 1, 15 }, bv = { 1, 0, 3 }, k = 3, d1 = { "\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@\u00f8\u0001\u0000" }, d2 = { "httpGet", "", "client", "Lio/ktor/client/HttpClient;", "continuation", "Lkotlin/coroutines/Continuation;", "" })
@DebugMetadata(f = "Sample.kt", l = { 33 }, i = { 0, 0 }, s = { "L$0", "I$0" }, n = { "client", "delay" }, m = "httpGet", c = "SampleKt")
static final class SampleKt$httpGet$1 extends ContinuationImpl {
    int label;
    Object L$0;
    int I$0;
    
    @Nullable
    public final Object invokeSuspend(@NotNull final Object result) {
        this.result = result;
        this.label |= Integer.MIN_VALUE;
        return SampleKt.httpGet(null, (Continuation<? super Unit>)this);
    }
}