package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.muxer.MuxerUtil;
import androidx.media3.muxer.WebmConstants;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import pe.a2;
import pe.k;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$fling$2", f = "TransformState.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lpe/a2;", "<anonymous>", "(Lpe/m0;)Lpe/a2;"}, k = 3, mv = {2, 2, 0})
public final class TransformState$fling$2 extends m implements Function2 {
    final /* synthetic */ lb.a $onFlingStart;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TransformState this$0;

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$fling$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$fling$2$1", f = "TransformState.kt", l = {224}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ u0 $flingStarted;
        final /* synthetic */ lb.a $onFlingStart;
        final /* synthetic */ long $velocity;
        int label;
        final /* synthetic */ TransformState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TransformState transformState, long j10, u0 u0Var, lb.a aVar, e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.this$0 = transformState;
            this.$velocity = j10;
            this.$flingStarted = u0Var;
            this.$onFlingStart = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(u0 u0Var, lb.a aVar, Animatable animatable) {
            if (!u0Var.f36629c) {
                aVar.invoke();
                u0Var.f36629c = true;
            }
            return k0.f43947a;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass1(this.this$0, this.$velocity, this.$flingStarted, this.$onFlingStart, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                Animatable<Float, AnimationVector1D> animatablePanX$views_release = this.this$0.getAnimatablePanX$views_release();
                Float fC = cb.b.c(Float.intBitsToFloat((int) (this.$velocity >> 32)));
                DecayAnimationSpec<Float> decayAnimationSpecExponentialDecay$default = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 20.0f, 1, null);
                final u0 u0Var = this.$flingStarted;
                final lb.a aVar = this.$onFlingStart;
                Function1 function1 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.state.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TransformState$fling$2.AnonymousClass1.invokeSuspend$lambda$0(u0Var, aVar, (Animatable) obj2);
                    }
                };
                this.label = 1;
                if (animatablePanX$views_release.animateDecay(fC, decayAnimationSpecExponentialDecay$default, function1, this) == objG) {
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

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$fling$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState$fling$2$2", f = "TransformState.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_ADD_ID}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ u0 $flingStarted;
        final /* synthetic */ lb.a $onFlingStart;
        final /* synthetic */ long $velocity;
        int label;
        final /* synthetic */ TransformState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TransformState transformState, long j10, u0 u0Var, lb.a aVar, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.this$0 = transformState;
            this.$velocity = j10;
            this.$flingStarted = u0Var;
            this.$onFlingStart = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(u0 u0Var, lb.a aVar, Animatable animatable) {
            if (!u0Var.f36629c) {
                aVar.invoke();
                u0Var.f36629c = true;
            }
            return k0.f43947a;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass2(this.this$0, this.$velocity, this.$flingStarted, this.$onFlingStart, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                Animatable<Float, AnimationVector1D> animatablePanY$views_release = this.this$0.getAnimatablePanY$views_release();
                Float fC = cb.b.c(Float.intBitsToFloat((int) (this.$velocity & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
                DecayAnimationSpec<Float> decayAnimationSpecExponentialDecay$default = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 20.0f, 1, null);
                final u0 u0Var = this.$flingStarted;
                final lb.a aVar = this.$onFlingStart;
                Function1 function1 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.state.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TransformState$fling$2.AnonymousClass2.invokeSuspend$lambda$0(u0Var, aVar, (Animatable) obj2);
                    }
                };
                this.label = 1;
                if (animatablePanY$views_release.animateDecay(fC, decayAnimationSpecExponentialDecay$default, function1, this) == objG) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformState$fling$2(TransformState transformState, lb.a aVar, e<? super TransformState$fling$2> eVar) {
        super(2, eVar);
        this.this$0 = transformState;
        this.$onFlingStart = aVar;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        TransformState$fling$2 transformState$fling$2 = new TransformState$fling$2(this.this$0, this.$onFlingStart, eVar);
        transformState$fling$2.L$0 = obj;
        return transformState$fling$2;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        m0 m0Var = (m0) this.L$0;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        long jM7174calculateVelocity9UxMQ8M = this.this$0.velocityTracker.m7174calculateVelocity9UxMQ8M();
        float fM9057getXimpl = Velocity.m9057getXimpl(jM7174calculateVelocity9UxMQ8M);
        float fM9058getYimpl = Velocity.m9058getYimpl(jM7174calculateVelocity9UxMQ8M);
        long jM5618constructorimpl = Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(fM9057getXimpl)) << 32) | (((long) Float.floatToRawIntBits(fM9058getYimpl)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        u0 u0Var = new u0();
        k.d(m0Var, null, null, new AnonymousClass1(this.this$0, jM5618constructorimpl, u0Var, this.$onFlingStart, null), 3, null);
        return k.d(m0Var, null, null, new AnonymousClass2(this.this$0, jM5618constructorimpl, u0Var, this.$onFlingStart, null), 3, null);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super a2> eVar) {
        return ((TransformState$fling$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
