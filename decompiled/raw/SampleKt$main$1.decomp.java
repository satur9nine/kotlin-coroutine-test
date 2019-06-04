import kotlinx.coroutines.CoroutineStart;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlin.jvm.functions.Function2;
import kotlin.coroutines.jvm.internal.SuspendLambda;

// 
// Decompiled by Procyon v0.5.34
// 

@DebugMetadata(f = "Sample.kt", l = {}, i = {}, s = {}, n = {}, m = "invokeSuspend", c = "SampleKt$main$1")
@Metadata(mv = { 1, 1, 15 }, bv = { 1, 0, 3 }, k = 3, d1 = { "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00f8\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004" }, d2 = { "<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;" })
static final class SampleKt$main$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private CoroutineScope p$;
    int label;
    final /* synthetic */ HttpClient $client;
    
    @Nullable
    public final Object invokeSuspend(@NotNull final Object result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0: {
                ResultKt.throwOnFailure(result);
                final CoroutineScope p$ = this.p$;
                for (int n = 3, i = 0; i < n; ++i) {
                    final int it = Boxing.boxInt(i).intValue();
                    final int n2 = 0;
                    BuildersKt.launch$default(p$, (CoroutineContext)null, (CoroutineStart)null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(null, this, p$) {
                        private CoroutineScope p$;
                        int label;
                        
                        @Nullable
                        public final Object invokeSuspend(@NotNull final Object result) {
                            final Object coroutine_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure(result);
                                    final CoroutineScope p$ = this.p$;
                                    final HttpClient $client = this.this$0.$client;
                                    this.label = 1;
                                    if (SampleKt.httpGet($client, (Continuation<? super Unit>)this) == coroutine_SUSPENDED) {
                                        return coroutine_SUSPENDED;
                                    }
                                    break;
                                }
                                case 1: {
                                    ResultKt.throwOnFailure(result);
                                    break;
                                }
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        
                        @NotNull
                        public final Continuation<Unit> create(@Nullable final Object value, @NotNull final Continuation<?> completion) {
                            Intrinsics.checkParameterIsNotNull((Object)completion, "completion");
                            final SampleKt$main$1$invokeSuspend$$inlined$repeat$lambda$1 sampleKt$main$1$invokeSuspend$$inlined$repeat$lambda$1 = new SampleKt$main$1$invokeSuspend$$inlined$repeat$lambda$1((Continuation)completion, this.this$0, this.$receiver$0$inlined);
                            final CoroutineScope coroutineScope = (CoroutineScope)value;
                            sampleKt$main$1$invokeSuspend$$inlined$repeat$lambda$1.p$ = (CoroutineScope)value;
                            return (Continuation<Unit>)sampleKt$main$1$invokeSuspend$$inlined$repeat$lambda$1;
                        }
                        
                        public final Object invoke(final Object o, final Object o2) {
                            return ((SampleKt$main$1$invokeSuspend$$inlined$repeat$lambda$1)this.create(o, (Continuation)o2)).invokeSuspend((Object)Unit.INSTANCE);
                        }
                    }, 3, (Object)null);
                }
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
    
    @NotNull
    public final Continuation<Unit> create(@Nullable final Object value, @NotNull final Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull((Object)completion, "completion");
        final SampleKt$main$1 sampleKt$main$1 = new SampleKt$main$1(this.$client, (Continuation)completion);
        (CoroutineScope)value;
        sampleKt$main$1.p$ = (CoroutineScope)value;
        return (Continuation<Unit>)sampleKt$main$1;
    }
    
    public final Object invoke(final Object o, final Object o2) {
        return ((SampleKt$main$1)this.create(o, (Continuation)o2)).invokeSuspend((Object)Unit.INSTANCE);
    }
}