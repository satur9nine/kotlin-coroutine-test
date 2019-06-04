import io.ktor.client.request.HttpRequestBuilder;
import org.jetbrains.annotations.Nullable;
import java.security.SecureRandom;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.Unit;
import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;
import java.lang.management.ManagementFactory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import io.ktor.client.HttpClient;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function1;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.cio.CIO;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Metadata;

// 
// Decompiled by Procyon v0.5.34
// 

@Metadata(mv = { 1, 1, 15 }, bv = { 1, 0, 3 }, k = 2, d1 = { "\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\b\u001a\u00020\u0001\u001a8\u0010\t\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000fH\u0086@\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011" }, d2 = { "httpGet", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logln", "s", "", "main", "myGet", "", "urlString", "block", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-tests" })
public final class SampleKt
{
    public static final void main() {
        final HttpClient client = HttpClientKt.HttpClient$default((HttpClientEngineFactory)CIO.INSTANCE, (Function1)null, 2, (Object)null);
        logln("Hi");
        BuildersKt.runBlocking$default((CoroutineContext)null, (Function2)new SampleKt$main.SampleKt$main$1(client, (Continuation)null), 1, (Object)null);
        client.close();
        logln("Goodbye");
    }
    
    public static final void logln(@NotNull final String s) {
        Intrinsics.checkParameterIsNotNull((Object)s, "s");
        final RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        final StringBuilder sb = new StringBuilder();
        final StringCompanionObject instance = StringCompanionObject.INSTANCE;
        final Locale us = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull((Object)us, "Locale.US");
        final Locale locale = us;
        final String s2 = "%08d";
        final Object[] array = { null };
        final int n = 0;
        final RuntimeMXBean runtimeMXBean = rb;
        Intrinsics.checkExpressionValueIsNotNull((Object)runtimeMXBean, "rb");
        array[n] = runtimeMXBean.getUptime();
        final Object[] array2 = array;
        final StringBuilder sb2 = sb;
        final Locale locale2 = locale;
        final String s3 = s2;
        final Object[] array3 = array2;
        final String format = String.format(locale2, s3, Arrays.copyOf(array3, array3.length));
        Intrinsics.checkExpressionValueIsNotNull((Object)format, "java.lang.String.format(locale, format, *args)");
        System.out.println((Object)sb2.append(format).append(": ").append(s).append(" (").append(Thread.currentThread()).append(")").toString());
    }
    
    @Nullable
    public static final Object httpGet(@NotNull HttpClient client, @NotNull final Continuation<? super Unit> $completion) {
        final Continuation $continuation;
        Label_0049: {
            if ($completion instanceof SampleKt$httpGet.SampleKt$httpGet$1) {
                final SampleKt$httpGet.SampleKt$httpGet$1 sampleKt$httpGet$1 = (SampleKt$httpGet.SampleKt$httpGet$1)$completion;
                if ((sampleKt$httpGet$1.label & Integer.MIN_VALUE) != 0x0) {
                    final SampleKt$httpGet.SampleKt$httpGet$1 sampleKt$httpGet$2 = sampleKt$httpGet$1;
                    sampleKt$httpGet$2.label -= Integer.MIN_VALUE;
                    break Label_0049;
                }
            }
            $continuation = (Continuation)new SampleKt$httpGet.SampleKt$httpGet$1((Continuation)$completion);
        }
        final Object result = ((SampleKt$httpGet.SampleKt$httpGet$1)$continuation).result;
        final Object coroutine_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int delay = 0;
        Object myGet$default = null;
        switch (((SampleKt$httpGet.SampleKt$httpGet$1)$continuation).label) {
            case 0: {
                ResultKt.throwOnFailure(result);
                delay = new SecureRandom().nextInt(10000);
                logln("Start request, delay=" + delay);
                final HttpClient httpClient = client;
                final String string = "http://httpstat.us/200?sleep=" + delay;
                final Function1 function1 = null;
                final Continuation continuation = $continuation;
                final int n = 2;
                final Object o = null;
                ((SampleKt$httpGet.SampleKt$httpGet$1)$continuation).L$0 = client;
                ((SampleKt$httpGet.SampleKt$httpGet$1)$continuation).I$0 = delay;
                ((SampleKt$httpGet.SampleKt$httpGet$1)$continuation).label = 1;
                if ((myGet$default = myGet$default(httpClient, string, function1, continuation, n, o)) == coroutine_SUSPENDED) {
                    return coroutine_SUSPENDED;
                }
                break;
            }
            case 1: {
                delay = ((SampleKt$httpGet.SampleKt$httpGet$1)$continuation).I$0;
                client = (HttpClient)((SampleKt$httpGet.SampleKt$httpGet$1)$continuation).L$0;
                ResultKt.throwOnFailure(result);
                myGet$default = result;
                break;
            }
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        final byte[] response = (byte[])myGet$default;
        final int len = response.length;
        logln("Got response, delay=" + delay + ", length=" + len);
        return Unit.INSTANCE;
    }
    
    @Nullable
    public static final Object myGet(@NotNull final HttpClient $this$myGet, @NotNull final String urlString, @NotNull final Function1<? super HttpRequestBuilder, Unit> block, @NotNull final Continuation<? super byte[]> $completion) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      LSampleKt$myGet$1;
        //     4: ifeq            39
        //     7: aload_3         /* $completion */
        //     8: checkcast       LSampleKt$myGet$1;
        //    11: astore          30
        //    13: aload           30
        //    15: getfield        SampleKt$myGet$1.label:I
        //    18: ldc             -2147483648
        //    20: iand           
        //    21: ifeq            39
        //    24: aload           30
        //    26: dup            
        //    27: getfield        SampleKt$myGet$1.label:I
        //    30: ldc             -2147483648
        //    32: isub           
        //    33: putfield        SampleKt$myGet$1.label:I
        //    36: goto            49
        //    39: new             LSampleKt$myGet$1;
        //    42: dup            
        //    43: aload_3         /* $completion */
        //    44: invokespecial   SampleKt$myGet$1.<init>:(Lkotlin/coroutines/Continuation;)V
        //    47: astore          $continuation
        //    49: aload           $continuation
        //    51: getfield        SampleKt$myGet$1.result:Ljava/lang/Object;
        //    54: astore          29
        //    56: invokestatic    kotlin/coroutines/intrinsics/IntrinsicsKt.getCOROUTINE_SUSPENDED:()Ljava/lang/Object;
        //    59: astore          31
        //    61: aload           $continuation
        //    63: getfield        SampleKt$myGet$1.label:I
        //    66: tableswitch {
        //                0: 92
        //                1: 313
        //                2: 644
        //          default: 797
        //        }
        //    92: aload           29
        //    94: invokestatic    kotlin/ResultKt.throwOnFailure:(Ljava/lang/Object;)V
        //    97: aload_0         /* $this$myGet */
        //    98: astore          $receiver$iv
        //   100: ldc             "http"
        //   102: astore          scheme$iv
        //   104: ldc             "localhost"
        //   106: astore          host$iv
        //   108: iconst_0       
        //   109: istore          port$iv
        //   111: ldc             "/"
        //   113: astore          path$iv
        //   115: getstatic       io/ktor/client/utils/EmptyContent.INSTANCE:Lio/ktor/client/utils/EmptyContent;
        //   118: astore          body$iv
        //   120: aload           $receiver$iv
        //   122: astore          $receiver$iv$iv
        //   124: aload           $receiver$iv$iv
        //   126: astore          12
        //   128: new             Lio/ktor/client/request/HttpRequestBuilder;
        //   131: dup            
        //   132: invokespecial   io/ktor/client/request/HttpRequestBuilder.<init>:()V
        //   135: astore          13
        //   137: aload           13
        //   139: astore          $receiver$iv
        //   141: aload           $receiver$iv
        //   143: aload           scheme$iv
        //   145: aload           host$iv
        //   147: iload           port$iv
        //   149: aload           path$iv
        //   151: aconst_null    
        //   152: bipush          16
        //   154: aconst_null    
        //   155: invokestatic    io/ktor/client/request/HttpRequestKt.url$default:(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)V
        //   158: aload           $receiver$iv
        //   160: getstatic       io/ktor/http/HttpMethod.Companion:Lio/ktor/http/HttpMethod$Companion;
        //   163: invokevirtual   io/ktor/http/HttpMethod$Companion.getGet:()Lio/ktor/http/HttpMethod;
        //   166: invokevirtual   io/ktor/client/request/HttpRequestBuilder.setMethod:(Lio/ktor/http/HttpMethod;)V
        //   169: aload           $receiver$iv
        //   171: aload           body$iv
        //   173: invokevirtual   io/ktor/client/request/HttpRequestBuilder.setBody:(Ljava/lang/Object;)V
        //   176: aload           $receiver$iv
        //   178: astore          $this$get
        //   180: iconst_0       
        //   181: istore          $i$a$-get-SampleKt$myGet$3
        //   183: aload           $this$get
        //   185: invokevirtual   io/ktor/client/request/HttpRequestBuilder.getUrl:()Lio/ktor/http/URLBuilder;
        //   188: aload_1         /* urlString */
        //   189: invokestatic    io/ktor/http/URLParserKt.takeFrom:(Lio/ktor/http/URLBuilder;Ljava/lang/String;)Lio/ktor/http/URLBuilder;
        //   192: pop            
        //   193: aload_2         /* block */
        //   194: aload           $this$get
        //   196: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   201: pop            
        //   202: nop            
        //   203: aload           13
        //   205: astore          13
        //   207: nop            
        //   208: aload           $receiver$iv$iv$iv
        //   210: aload           builder$iv$iv$iv
        //   212: aload           $continuation
        //   214: aload           $continuation
        //   216: aload_0         /* $this$myGet */
        //   217: putfield        SampleKt$myGet$1.L$0:Ljava/lang/Object;
        //   220: aload           $continuation
        //   222: aload_1         /* urlString */
        //   223: putfield        SampleKt$myGet$1.L$1:Ljava/lang/Object;
        //   226: aload           $continuation
        //   228: aload_2         /* block */
        //   229: putfield        SampleKt$myGet$1.L$2:Ljava/lang/Object;
        //   232: aload           $continuation
        //   234: aload           $receiver$iv
        //   236: putfield        SampleKt$myGet$1.L$3:Ljava/lang/Object;
        //   239: aload           $continuation
        //   241: aload           scheme$iv
        //   243: putfield        SampleKt$myGet$1.L$4:Ljava/lang/Object;
        //   246: aload           $continuation
        //   248: aload           host$iv
        //   250: putfield        SampleKt$myGet$1.L$5:Ljava/lang/Object;
        //   253: aload           $continuation
        //   255: iload           port$iv
        //   257: putfield        SampleKt$myGet$1.I$0:I
        //   260: aload           $continuation
        //   262: aload           path$iv
        //   264: putfield        SampleKt$myGet$1.L$6:Ljava/lang/Object;
        //   267: aload           $continuation
        //   269: aload           body$iv
        //   271: putfield        SampleKt$myGet$1.L$7:Ljava/lang/Object;
        //   274: aload           $continuation
        //   276: aload           $receiver$iv$iv
        //   278: putfield        SampleKt$myGet$1.L$8:Ljava/lang/Object;
        //   281: aload           $continuation
        //   283: aload           $receiver$iv$iv$iv
        //   285: putfield        SampleKt$myGet$1.L$9:Ljava/lang/Object;
        //   288: aload           $continuation
        //   290: aload           builder$iv$iv$iv
        //   292: putfield        SampleKt$myGet$1.L$10:Ljava/lang/Object;
        //   295: aload           $continuation
        //   297: iconst_1       
        //   298: putfield        SampleKt$myGet$1.label:I
        //   301: invokestatic    io/ktor/client/call/UtilsKt.call:(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
        //   304: dup            
        //   305: aload           31
        //   307: if_acmpne       434
        //   310: aload           31
        //   312: areturn        
        //   313: aload           $continuation
        //   315: getfield        SampleKt$myGet$1.L$10:Ljava/lang/Object;
        //   318: checkcast       Lio/ktor/client/request/HttpRequestBuilder;
        //   321: astore          builder$iv$iv$iv
        //   323: aload           $continuation
        //   325: getfield        SampleKt$myGet$1.L$9:Ljava/lang/Object;
        //   328: checkcast       Lio/ktor/client/HttpClient;
        //   331: astore          $receiver$iv$iv$iv
        //   333: aload           $continuation
        //   335: getfield        SampleKt$myGet$1.L$8:Ljava/lang/Object;
        //   338: checkcast       Lio/ktor/client/HttpClient;
        //   341: astore          $receiver$iv$iv
        //   343: aload           $continuation
        //   345: getfield        SampleKt$myGet$1.L$7:Ljava/lang/Object;
        //   348: checkcast       Lio/ktor/client/utils/EmptyContent;
        //   351: astore          body$iv
        //   353: aload           $continuation
        //   355: getfield        SampleKt$myGet$1.L$6:Ljava/lang/Object;
        //   358: checkcast       Ljava/lang/String;
        //   361: astore          path$iv
        //   363: aload           $continuation
        //   365: getfield        SampleKt$myGet$1.I$0:I
        //   368: istore          port$iv
        //   370: aload           $continuation
        //   372: getfield        SampleKt$myGet$1.L$5:Ljava/lang/Object;
        //   375: checkcast       Ljava/lang/String;
        //   378: astore          host$iv
        //   380: aload           $continuation
        //   382: getfield        SampleKt$myGet$1.L$4:Ljava/lang/Object;
        //   385: checkcast       Ljava/lang/String;
        //   388: astore          scheme$iv
        //   390: aload           $continuation
        //   392: getfield        SampleKt$myGet$1.L$3:Ljava/lang/Object;
        //   395: checkcast       Lio/ktor/client/HttpClient;
        //   398: astore          $receiver$iv
        //   400: aload           $continuation
        //   402: getfield        SampleKt$myGet$1.L$2:Ljava/lang/Object;
        //   405: checkcast       Lkotlin/jvm/functions/Function1;
        //   408: astore_2        /* block */
        //   409: aload           $continuation
        //   411: getfield        SampleKt$myGet$1.L$1:Ljava/lang/Object;
        //   414: checkcast       Ljava/lang/String;
        //   417: astore_1        /* urlString */
        //   418: aload           $continuation
        //   420: getfield        SampleKt$myGet$1.L$0:Ljava/lang/Object;
        //   423: checkcast       Lio/ktor/client/HttpClient;
        //   426: astore_0        /* $this$myGet */
        //   427: aload           29
        //   429: invokestatic    kotlin/ResultKt.throwOnFailure:(Ljava/lang/Object;)V
        //   432: aload           29
        //   434: checkcast       Lio/ktor/client/call/HttpClientCall;
        //   437: astore          $receiver$iv$iv$iv$iv
        //   439: aload           $receiver$iv$iv$iv$iv
        //   441: astore          19
        //   443: new             LSampleKt$myGet$$inlined$get$1;
        //   446: dup            
        //   447: invokespecial   SampleKt$myGet$$inlined$get$1.<init>:()V
        //   450: astore          base$iv$iv$iv$iv$iv
        //   452: aload           base$iv$iv$iv$iv$iv
        //   454: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   457: invokevirtual   java/lang/Class.getGenericSuperclass:()Ljava/lang/reflect/Type;
        //   460: dup            
        //   461: ifnonnull       467
        //   464: invokestatic    kotlin/jvm/internal/Intrinsics.throwNpe:()V
        //   467: astore          superType$iv$iv$iv$iv$iv
        //   469: aload           superType$iv$iv$iv$iv$iv
        //   471: dup            
        //   472: ifnonnull       486
        //   475: new             Lkotlin/TypeCastException;
        //   478: dup            
        //   479: ldc_w           "null cannot be cast to non-null type java.lang.reflect.ParameterizedType"
        //   482: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   485: athrow         
        //   486: checkcast       Ljava/lang/reflect/ParameterizedType;
        //   489: invokeinterface java/lang/reflect/ParameterizedType.getActualTypeArguments:()[Ljava/lang/reflect/Type;
        //   494: dup            
        //   495: ldc_w           "(superType as Parameteri\u2026Type).actualTypeArguments"
        //   498: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   501: invokestatic    kotlin/collections/ArraysKt.first:([Ljava/lang/Object;)Ljava/lang/Object;
        //   504: dup            
        //   505: ifnonnull       511
        //   508: invokestatic    kotlin/jvm/internal/Intrinsics.throwNpe:()V
        //   511: checkcast       Ljava/lang/reflect/Type;
        //   514: astore          reifiedType$iv$iv$iv$iv$iv
        //   516: new             Lio/ktor/client/call/TypeInfo;
        //   519: dup            
        //   520: ldc             [B.class
        //   522: invokestatic    kotlin/jvm/internal/Reflection.getOrCreateKotlinClass:(Ljava/lang/Class;)Lkotlin/reflect/KClass;
        //   525: aload           reifiedType$iv$iv$iv$iv$iv
        //   527: invokespecial   io/ktor/client/call/TypeInfo.<init>:(Lkotlin/reflect/KClass;Ljava/lang/reflect/Type;)V
        //   530: astore          23
        //   532: aload           19
        //   534: aload           23
        //   536: aload           $continuation
        //   538: aload           $continuation
        //   540: aload_0         /* $this$myGet */
        //   541: putfield        SampleKt$myGet$1.L$0:Ljava/lang/Object;
        //   544: aload           $continuation
        //   546: aload_1         /* urlString */
        //   547: putfield        SampleKt$myGet$1.L$1:Ljava/lang/Object;
        //   550: aload           $continuation
        //   552: aload_2         /* block */
        //   553: putfield        SampleKt$myGet$1.L$2:Ljava/lang/Object;
        //   556: aload           $continuation
        //   558: aload           $receiver$iv
        //   560: putfield        SampleKt$myGet$1.L$3:Ljava/lang/Object;
        //   563: aload           $continuation
        //   565: aload           scheme$iv
        //   567: putfield        SampleKt$myGet$1.L$4:Ljava/lang/Object;
        //   570: aload           $continuation
        //   572: aload           host$iv
        //   574: putfield        SampleKt$myGet$1.L$5:Ljava/lang/Object;
        //   577: aload           $continuation
        //   579: iload           port$iv
        //   581: putfield        SampleKt$myGet$1.I$0:I
        //   584: aload           $continuation
        //   586: aload           path$iv
        //   588: putfield        SampleKt$myGet$1.L$6:Ljava/lang/Object;
        //   591: aload           $continuation
        //   593: aload           body$iv
        //   595: putfield        SampleKt$myGet$1.L$7:Ljava/lang/Object;
        //   598: aload           $continuation
        //   600: aload           $receiver$iv$iv
        //   602: putfield        SampleKt$myGet$1.L$8:Ljava/lang/Object;
        //   605: aload           $continuation
        //   607: aload           $receiver$iv$iv$iv
        //   609: putfield        SampleKt$myGet$1.L$9:Ljava/lang/Object;
        //   612: aload           $continuation
        //   614: aload           builder$iv$iv$iv
        //   616: putfield        SampleKt$myGet$1.L$10:Ljava/lang/Object;
        //   619: aload           $continuation
        //   621: aload           $receiver$iv$iv$iv$iv
        //   623: putfield        SampleKt$myGet$1.L$11:Ljava/lang/Object;
        //   626: aload           $continuation
        //   628: iconst_2       
        //   629: putfield        SampleKt$myGet$1.label:I
        //   632: invokevirtual   io/ktor/client/call/HttpClientCall.receive:(Lio/ktor/client/call/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
        //   635: dup            
        //   636: aload           31
        //   638: if_acmpne       775
        //   641: aload           31
        //   643: areturn        
        //   644: aload           $continuation
        //   646: getfield        SampleKt$myGet$1.L$11:Ljava/lang/Object;
        //   649: checkcast       Lio/ktor/client/call/HttpClientCall;
        //   652: astore          $receiver$iv$iv$iv$iv
        //   654: aload           $continuation
        //   656: getfield        SampleKt$myGet$1.L$10:Ljava/lang/Object;
        //   659: checkcast       Lio/ktor/client/request/HttpRequestBuilder;
        //   662: astore          builder$iv$iv$iv
        //   664: aload           $continuation
        //   666: getfield        SampleKt$myGet$1.L$9:Ljava/lang/Object;
        //   669: checkcast       Lio/ktor/client/HttpClient;
        //   672: astore          $receiver$iv$iv$iv
        //   674: aload           $continuation
        //   676: getfield        SampleKt$myGet$1.L$8:Ljava/lang/Object;
        //   679: checkcast       Lio/ktor/client/HttpClient;
        //   682: astore          $receiver$iv$iv
        //   684: aload           $continuation
        //   686: getfield        SampleKt$myGet$1.L$7:Ljava/lang/Object;
        //   689: checkcast       Lio/ktor/client/utils/EmptyContent;
        //   692: astore          body$iv
        //   694: aload           $continuation
        //   696: getfield        SampleKt$myGet$1.L$6:Ljava/lang/Object;
        //   699: checkcast       Ljava/lang/String;
        //   702: astore          path$iv
        //   704: aload           $continuation
        //   706: getfield        SampleKt$myGet$1.I$0:I
        //   709: istore          port$iv
        //   711: aload           $continuation
        //   713: getfield        SampleKt$myGet$1.L$5:Ljava/lang/Object;
        //   716: checkcast       Ljava/lang/String;
        //   719: astore          host$iv
        //   721: aload           $continuation
        //   723: getfield        SampleKt$myGet$1.L$4:Ljava/lang/Object;
        //   726: checkcast       Ljava/lang/String;
        //   729: astore          scheme$iv
        //   731: aload           $continuation
        //   733: getfield        SampleKt$myGet$1.L$3:Ljava/lang/Object;
        //   736: checkcast       Lio/ktor/client/HttpClient;
        //   739: astore          $receiver$iv
        //   741: aload           $continuation
        //   743: getfield        SampleKt$myGet$1.L$2:Ljava/lang/Object;
        //   746: checkcast       Lkotlin/jvm/functions/Function1;
        //   749: astore_2        /* block */
        //   750: aload           $continuation
        //   752: getfield        SampleKt$myGet$1.L$1:Ljava/lang/Object;
        //   755: checkcast       Ljava/lang/String;
        //   758: astore_1        /* urlString */
        //   759: aload           $continuation
        //   761: getfield        SampleKt$myGet$1.L$0:Ljava/lang/Object;
        //   764: checkcast       Lio/ktor/client/HttpClient;
        //   767: astore_0        /* $this$myGet */
        //   768: aload           29
        //   770: invokestatic    kotlin/ResultKt.throwOnFailure:(Ljava/lang/Object;)V
        //   773: aload           29
        //   775: dup            
        //   776: ifnonnull       790
        //   779: new             Lkotlin/TypeCastException;
        //   782: dup            
        //   783: ldc_w           "null cannot be cast to non-null type kotlin.ByteArray"
        //   786: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   789: athrow         
        //   790: checkcast       [B
        //   793: nop            
        //   794: nop            
        //   795: nop            
        //   796: areturn        
        //   797: new             Ljava/lang/IllegalStateException;
        //   800: dup            
        //   801: ldc             "call to 'resume' before 'invoke' with coroutine"
        //   803: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   806: athrow         
        //    Signature:
        //  (Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1<-Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/Unit;>;Lkotlin/coroutines/Continuation<-[B>;)Ljava/lang/Object;
        //    StackMapTable: 00 0C 27 FF 00 09 00 1F 07 00 2D 07 00 6F 07 01 24 07 00 E9 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 EE 00 00 FF 00 2A 00 20 07 00 2D 07 00 6F 07 01 24 07 00 E9 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 04 07 00 EE 07 00 04 00 00 FB 00 DC FF 00 78 00 20 07 00 2D 07 00 6F 07 01 24 07 00 E9 07 00 2D 07 00 6F 07 00 6F 01 07 00 6F 07 00 F9 00 07 00 2D 07 00 2D 07 00 FE 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 04 07 00 EE 07 00 04 00 01 07 00 04 FF 00 20 00 20 07 00 2D 07 00 6F 07 01 24 07 00 E9 07 00 2D 07 00 6F 07 00 6F 01 07 00 6F 07 00 F9 00 07 00 2D 07 00 2D 07 00 FE 00 00 00 00 07 01 50 07 01 50 07 01 52 00 00 00 00 00 00 00 00 07 00 04 07 00 EE 07 00 04 00 01 07 01 75 FF 00 12 00 20 07 00 2D 07 00 6F 07 01 24 07 00 E9 07 00 2D 07 00 6F 07 00 6F 01 07 00 6F 07 00 F9 00 07 00 2D 07 00 2D 07 00 FE 00 00 00 00 07 01 50 07 01 50 07 01 52 07 01 75 00 00 00 00 00 00 00 07 00 04 07 00 EE 07 00 04 00 01 07 01 75 58 07 00 04 FF 00 84 00 20 07 00 2D 07 00 6F 07 01 24 07 00 E9 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 04 07 00 EE 07 00 04 00 00 FF 00 82 00 20 07 00 2D 07 00 6F 07 01 24 07 00 E9 07 00 2D 07 00 6F 07 00 6F 01 07 00 6F 07 00 F9 00 07 00 2D 07 00 2D 07 00 FE 00 00 00 00 07 01 50 00 00 00 00 00 00 00 00 00 00 07 00 04 07 00 EE 07 00 04 00 01 07 00 04 4E 07 00 04 FF 00 06 00 20 07 00 2D 07 00 6F 07 01 24 07 00 E9 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 04 07 00 EE 07 00 04 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:144)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Nullable
    public static /* synthetic */ Object myGet$default(final HttpClient $this$myGet, final String urlString, Function1 block, final Continuation $completion, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            block = (Function1)SampleKt$myGet.SampleKt$myGet$2.INSTANCE;
        }
        return myGet($this$myGet, urlString, (Function1<? super HttpRequestBuilder, Unit>)block, (Continuation<? super byte[]>)$completion);
    }
}
