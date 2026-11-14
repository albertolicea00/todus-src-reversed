package cu.z17.views.videoEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelKt;
import androidx.tracing.Trace;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.z17.compress.CompressorKt;
import cu.z17.views.imageEditor.Z17EditorState;
import cu.z17.views.utils.Z17MutableListFlow;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.m0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014¢\u0006\u0004\b\u0016\u0010\u0017JW\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014¢\u0006\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcu/z17/views/videoEditor/VideoEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "default", "calculateNewDuration", "(Landroid/content/Context;Landroid/net/Uri;JLab/e;)Ljava/lang/Object;", "Lcu/z17/views/imageEditor/Z17EditorState;", "z17EditorState", "Lua/k0;", "requestState", "(Lcu/z17/views/imageEditor/Z17EditorState;)V", "", "videoPath", TypedValues.TransitionType.S_DURATION, "Lkotlin/Function0;", "onComplete", "generateThumbnailList", "(Ljava/lang/String;JLlb/a;)V", NewEntity.NEWS_CONFIG_SOURCE, "videoPathToSave", "startMilliseconds", "endMilliseconds", "Lkotlin/Function1;", "onError", "saveVideo", "(Landroid/net/Uri;Landroid/content/Context;Ljava/lang/String;JJLkotlin/jvm/functions/Function1;Llb/a;)V", "currentSource", "cancelChanges", "(Ljava/lang/String;Llb/a;)V", "Lte/b0;", "_currentState", "Lte/b0;", "Lte/p0;", "currentState", "Lte/p0;", "getCurrentState", "()Lte/p0;", "Lcu/z17/views/utils/Z17MutableListFlow;", "Landroid/graphics/Bitmap;", "thumbnails", "Lcu/z17/views/utils/Z17MutableListFlow;", "getThumbnails", "()Lcu/z17/views/utils/Z17MutableListFlow;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoEditorViewModel extends ViewModel {
    public static final int $stable = 8;
    private final b0 _currentState;
    private final p0 currentState;
    private final Z17MutableListFlow<Bitmap> thumbnails;

    /* JADX INFO: renamed from: cu.z17.views.videoEditor.VideoEditorViewModel$calculateNewDuration$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.videoEditor.VideoEditorViewModel$calculateNewDuration$2", f = "VideoEditorViewModel.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "", "<anonymous>", "(Lpe/m0;)J"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ long $default;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, Uri uri, long j10, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$context = context;
            this.$uri = uri;
            this.$default = j10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass2(this.$context, this.$uri, this.$default, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            long j10;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.$context, this.$uri);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                y.f(strExtractMetadata);
                j10 = Long.parseLong(strExtractMetadata);
                mediaMetadataRetriever.release();
            } catch (Exception e10) {
                e10.printStackTrace();
                j10 = this.$default;
            }
            return cb.b.e(j10);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super Long> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.videoEditor.VideoEditorViewModel$cancelChanges$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.videoEditor.VideoEditorViewModel$cancelChanges$1", f = "VideoEditorViewModel.kt", l = {Trace.MAX_TRACE_LABEL_LENGTH}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ String $currentSource;
        final /* synthetic */ lb.a $onComplete;
        int label;

        /* JADX INFO: renamed from: cu.z17.views.videoEditor.VideoEditorViewModel$cancelChanges$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.videoEditor.VideoEditorViewModel$cancelChanges$1$1", f = "VideoEditorViewModel.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
        public static final class C02811 extends cb.m implements Function2 {
            final /* synthetic */ String $currentSource;
            final /* synthetic */ lb.a $onComplete;
            int label;
            final /* synthetic */ VideoEditorViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02811(VideoEditorViewModel videoEditorViewModel, String str, lb.a aVar, ab.e<? super C02811> eVar) {
                super(2, eVar);
                this.this$0 = videoEditorViewModel;
                this.$currentSource = str;
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02811(this.this$0, this.$currentSource, this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.this$0.requestState(Z17EditorState.LOADING);
                try {
                    File file = new File(this.$currentSource);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02811) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, lb.a aVar, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$currentSource = str;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return VideoEditorViewModel.this.new AnonymousClass1(this.$currentSource, this.$onComplete, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                pe.k0 k0VarB = d1.b();
                C02811 c02811 = new C02811(VideoEditorViewModel.this, this.$currentSource, this.$onComplete, null);
                this.label = 1;
                if (pe.i.g(k0VarB, c02811, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.videoEditor.VideoEditorViewModel$generateThumbnailList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.videoEditor.VideoEditorViewModel$generateThumbnailList$1", f = "VideoEditorViewModel.kt", l = {43}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class C15331 extends cb.m implements Function2 {
        final /* synthetic */ long $duration;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $videoPath;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ VideoEditorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15331(long j10, lb.a aVar, String str, VideoEditorViewModel videoEditorViewModel, ab.e<? super C15331> eVar) {
            super(2, eVar);
            this.$duration = j10;
            this.$onComplete = aVar;
            this.$videoPath = str;
            this.this$0 = videoEditorViewModel;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new C15331(this.$duration, this.$onComplete, this.$videoPath, this.this$0, eVar);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x004e  */
        /* JADX WARN: Code duplicated, block: B:15:0x0079 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x007a  */
        /* JADX WARN: Code duplicated, block: B:19:0x0081  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007a -> B:17:0x007d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                r5 = r21
                java.lang.Object r8 = bb.b.g()
                int r0 = r5.label
                r9 = 0
                r10 = 1000(0x3e8, double:4.94E-321)
                r12 = 1
                if (r0 == 0) goto L35
                if (r0 != r12) goto L2d
                int r0 = r5.I$2
                int r1 = r5.I$1
                int r2 = r5.I$0
                long r3 = r5.J$0
                java.lang.Object r6 = r5.L$1
                cu.z17.views.videoEditor.VideoEditorViewModel r6 = (cu.z17.views.videoEditor.VideoEditorViewModel) r6
                java.lang.Object r7 = r5.L$0
                java.lang.String r7 = (java.lang.String) r7
                ua.v.b(r22)
                r13 = r0
                r14 = r1
                r15 = r2
                r16 = r3
                r2 = r6
                r4 = r7
                r0 = r22
                goto L7d
            L2d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L35:
                ua.v.b(r22)
                long r0 = r5.$duration
                long r0 = r0 / r10
                r2 = 2
                long r2 = (long) r2
                long r2 = r0 / r2
                int r2 = (int) r2
                r3 = 6
                if (r2 <= r3) goto L44
                r3 = r2
            L44:
                java.lang.String r4 = r5.$videoPath
                cu.z17.views.videoEditor.VideoEditorViewModel r6 = r5.this$0
                r15 = r2
                r14 = r3
                r2 = r6
                r13 = r9
            L4c:
                if (r13 >= r14) goto L8c
                cu.z17.views.utils.VideoUtils r3 = cu.z17.views.utils.VideoUtils.INSTANCE
                long r6 = (long) r13
                long r6 = r6 * r10
                r5.L$0 = r4
                r5.L$1 = r2
                r5.J$0 = r0
                r5.I$0 = r15
                r5.I$1 = r14
                r5.I$2 = r13
                r5.I$3 = r13
                r5.I$4 = r9
                r5.label = r12
                r16 = r0
                r1 = r4
                r4 = 0
                r0 = r2
                r19 = r6
                r7 = r3
                r2 = r19
                r6 = 4
                r18 = r0
                r0 = r7
                r7 = 0
                java.lang.Object r0 = cu.z17.views.utils.VideoUtils.getThumbnailOnTime$default(r0, r1, r2, r4, r5, r6, r7)
                if (r0 != r8) goto L7a
                return r8
            L7a:
                r4 = r1
                r2 = r18
            L7d:
                android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
                if (r0 == 0) goto L88
                cu.z17.views.utils.Z17MutableListFlow r1 = r2.getThumbnails()
                r1.add(r0)
            L88:
                int r13 = r13 + r12
                r0 = r16
                goto L4c
            L8c:
                lb.a r0 = r5.$onComplete
                r0.invoke()
                ua.k0 r0 = ua.k0.f43947a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.videoEditor.VideoEditorViewModel.C15331.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C15331) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.videoEditor.VideoEditorViewModel$saveVideo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.videoEditor.VideoEditorViewModel$saveVideo$1", f = "VideoEditorViewModel.kt", l = {TsExtractor.TS_SYNC_BYTE, 84, 86, 90, 99}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class C15341 extends cb.m implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ long $endMilliseconds;
        final /* synthetic */ Function1 $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ Uri $source;
        final /* synthetic */ long $startMilliseconds;
        final /* synthetic */ String $videoPathToSave;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX INFO: renamed from: cu.z17.views.videoEditor.VideoEditorViewModel$saveVideo$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.videoEditor.VideoEditorViewModel$saveVideo$1$1", f = "VideoEditorViewModel.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
        public static final class C02821 extends cb.m implements Function2 {
            final /* synthetic */ String $temp;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02821(String str, ab.e<? super C02821> eVar) {
                super(2, eVar);
                this.$temp = str;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02821(this.$temp, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                File file = new File(this.$temp);
                if (file.exists()) {
                    file.delete();
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02821) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.z17.views.videoEditor.VideoEditorViewModel$saveVideo$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.videoEditor.VideoEditorViewModel$saveVideo$1$2", f = "VideoEditorViewModel.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Ljava/io/File;", "<anonymous>", "(Lpe/m0;)Ljava/io/File;"}, k = 3, mv = {2, 2, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ String $temp;
            final /* synthetic */ String $videoPathToSave;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(String str, String str2, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$temp = str;
                this.$videoPathToSave = str2;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$temp, this.$videoPathToSave, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return CompressorKt.copyFileUsingStream(new File(this.$temp), new File(this.$videoPathToSave));
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super File> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.z17.views.videoEditor.VideoEditorViewModel$saveVideo$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.videoEditor.VideoEditorViewModel$saveVideo$1$3", f = "VideoEditorViewModel.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
        public static final class AnonymousClass3 extends cb.m implements Function2 {
            final /* synthetic */ String $temp;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(String str, ab.e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$temp = str;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass3(this.$temp, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                File file = new File(this.$temp);
                if (file.exists()) {
                    file.delete();
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15341(String str, Uri uri, Context context, long j10, long j11, Function1 function1, lb.a aVar, ab.e<? super C15341> eVar) {
            super(2, eVar);
            this.$videoPathToSave = str;
            this.$source = uri;
            this.$context = context;
            this.$startMilliseconds = j10;
            this.$endMilliseconds = j11;
            this.$onComplete = function1;
            this.$onError = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return VideoEditorViewModel.this.new C15341(this.$videoPathToSave, this.$source, this.$context, this.$startMilliseconds, this.$endMilliseconds, this.$onComplete, this.$onError, eVar);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:30:0x00e7 A[DONT_INVERT, PHI: r1 r2
          0x00e7: PHI (r1v8 boolean) = (r1v7 boolean), (r1v12 boolean) binds: [B:28:0x00e4, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE]
          0x00e7: PHI (r2v5 java.lang.String) = (r2v4 java.lang.String), (r2v10 java.lang.String) binds: [B:28:0x00e4, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:31:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:35:0x0119  */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0106, code lost:
        
            if (r0 == r6) goto L33;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 289
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.videoEditor.VideoEditorViewModel.C15341.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C15341) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public VideoEditorViewModel() {
        b0 b0VarA = r0.a(Z17EditorState.LOADING);
        this._currentState = b0VarA;
        this.currentState = te.j.b(b0VarA);
        this.thumbnails = new Z17MutableListFlow<>(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object calculateNewDuration(Context context, Uri uri, long j10, ab.e<? super Long> eVar) {
        return pe.i.g(d1.b(), new AnonymousClass2(context, uri, j10, null), eVar);
    }

    public final void cancelChanges(String currentSource, lb.a onComplete) {
        y.i(currentSource, "currentSource");
        y.i(onComplete, "onComplete");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(currentSource, onComplete, null), 3, null);
    }

    public final void generateThumbnailList(String videoPath, long duration, lb.a onComplete) {
        y.i(videoPath, "videoPath");
        y.i(onComplete, "onComplete");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C15331(duration, onComplete, videoPath, this, null), 3, null);
    }

    public final p0 getCurrentState() {
        return this.currentState;
    }

    public final Z17MutableListFlow<Bitmap> getThumbnails() {
        return this.thumbnails;
    }

    public final void requestState(Z17EditorState z17EditorState) {
        y.i(z17EditorState, "z17EditorState");
        this._currentState.setValue(z17EditorState);
    }

    public final void saveVideo(Uri source, Context context, String videoPathToSave, long startMilliseconds, long endMilliseconds, Function1 onComplete, lb.a onError) {
        y.i(source, "source");
        y.i(context, "context");
        y.i(videoPathToSave, "videoPathToSave");
        y.i(onComplete, "onComplete");
        y.i(onError, "onError");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C15341(videoPathToSave, source, context, startMilliseconds, endMilliseconds, onComplete, onError, null), 3, null);
    }
}
