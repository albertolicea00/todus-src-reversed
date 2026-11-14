package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.compose.animation.core.AnimationSpec;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.MuxerUtil;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.a2;
import pe.k;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2", f = "TransformState.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lpe/a2;", "<anonymous>", "(Lpe/m0;)Lpe/a2;"}, k = 3, mv = {2, 2, 0})
public final class TransformState$resetWithAnimation$2 extends m implements Function2 {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ long $pan;
    final /* synthetic */ float $rotation;
    final /* synthetic */ float $zoom;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TransformState this$0;

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2$1", f = "TransformState.kt", l = {137}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ long $pan;
        int label;
        final /* synthetic */ TransformState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TransformState transformState, long j10, AnimationSpec<Float> animationSpec, e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.this$0 = transformState;
            this.$pan = j10;
            this.$animationSpec = animationSpec;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass1(this.this$0, this.$pan, this.$animationSpec, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                TransformState transformState = this.this$0;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.$pan >> 32));
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                this.label = 1;
                if (transformState.animatePanXto$views_release(fIntBitsToFloat, animationSpec, this) == objG) {
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
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2$2", f = "TransformState.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ long $pan;
        int label;
        final /* synthetic */ TransformState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TransformState transformState, long j10, AnimationSpec<Float> animationSpec, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.this$0 = transformState;
            this.$pan = j10;
            this.$animationSpec = animationSpec;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass2(this.this$0, this.$pan, this.$animationSpec, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                TransformState transformState = this.this$0;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.$pan & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                this.label = 1;
                if (transformState.animatePanYto$views_release(fIntBitsToFloat, animationSpec, this) == objG) {
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
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2$3", f = "TransformState.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS_UHD}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass3 extends m implements Function2 {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $zoom;
        int label;
        final /* synthetic */ TransformState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(TransformState transformState, float f10, AnimationSpec<Float> animationSpec, e<? super AnonymousClass3> eVar) {
            super(2, eVar);
            this.this$0 = transformState;
            this.$zoom = f10;
            this.$animationSpec = animationSpec;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass3(this.this$0, this.$zoom, this.$animationSpec, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                TransformState transformState = this.this$0;
                float f10 = this.$zoom;
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                this.label = 1;
                if (transformState.animateZoomTo$views_release(f10, animationSpec, this) == objG) {
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
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$resetWithAnimation$2$4", f = "TransformState.kt", l = {140}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass4 extends m implements Function2 {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $rotation;
        int label;
        final /* synthetic */ TransformState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(TransformState transformState, float f10, AnimationSpec<Float> animationSpec, e<? super AnonymousClass4> eVar) {
            super(2, eVar);
            this.this$0 = transformState;
            this.$rotation = f10;
            this.$animationSpec = animationSpec;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass4(this.this$0, this.$rotation, this.$animationSpec, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                TransformState transformState = this.this$0;
                float f10 = this.$rotation;
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                this.label = 1;
                if (transformState.animateRotationTo$views_release(f10, animationSpec, this) == objG) {
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
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass4) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformState$resetWithAnimation$2(TransformState transformState, long j10, AnimationSpec<Float> animationSpec, float f10, float f11, e<? super TransformState$resetWithAnimation$2> eVar) {
        super(2, eVar);
        this.this$0 = transformState;
        this.$pan = j10;
        this.$animationSpec = animationSpec;
        this.$zoom = f10;
        this.$rotation = f11;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        TransformState$resetWithAnimation$2 transformState$resetWithAnimation$2 = new TransformState$resetWithAnimation$2(this.this$0, this.$pan, this.$animationSpec, this.$zoom, this.$rotation, eVar);
        transformState$resetWithAnimation$2.L$0 = obj;
        return transformState$resetWithAnimation$2;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        m0 m0Var = (m0) this.L$0;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        k.d(m0Var, null, null, new AnonymousClass1(this.this$0, this.$pan, this.$animationSpec, null), 3, null);
        k.d(m0Var, null, null, new AnonymousClass2(this.this$0, this.$pan, this.$animationSpec, null), 3, null);
        k.d(m0Var, null, null, new AnonymousClass3(this.this$0, this.$zoom, this.$animationSpec, null), 3, null);
        return k.d(m0Var, null, null, new AnonymousClass4(this.this$0, this.$rotation, this.$animationSpec, null), 3, null);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super a2> eVar) {
        return ((TransformState$resetWithAnimation$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
