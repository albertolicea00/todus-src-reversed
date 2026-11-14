package cu.z17.views.zoomables;

import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.a2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.zoomables.ZoomState$resetWithAnimation$2", f = "ZoomStateImpl.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lpe/a2;", "<anonymous>", "(Lpe/m0;)Lpe/a2;"}, k = 3, mv = {2, 2, 0})
public final class ZoomState$resetWithAnimation$2 extends cb.m implements Function2 {
    final /* synthetic */ long $pan;
    final /* synthetic */ float $rotation;
    final /* synthetic */ float $zoom;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZoomState this$0;

    /* JADX INFO: renamed from: cu.z17.views.zoomables.ZoomState$resetWithAnimation$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.zoomables.ZoomState$resetWithAnimation$2$1", f = "ZoomStateImpl.kt", l = {132}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ long $pan;
        int label;
        final /* synthetic */ ZoomState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ZoomState zoomState, long j10, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.this$0 = zoomState;
            this.$pan = j10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.this$0, this.$pan, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                ZoomState zoomState = this.this$0;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.$pan >> 32));
                this.label = 1;
                if (zoomState.animatePanXto$views_release(fIntBitsToFloat, this) == objG) {
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

    /* JADX INFO: renamed from: cu.z17.views.zoomables.ZoomState$resetWithAnimation$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.zoomables.ZoomState$resetWithAnimation$2$2", f = "ZoomStateImpl.kt", l = {133}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ long $pan;
        int label;
        final /* synthetic */ ZoomState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ZoomState zoomState, long j10, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.this$0 = zoomState;
            this.$pan = j10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass2(this.this$0, this.$pan, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                ZoomState zoomState = this.this$0;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.$pan & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                this.label = 1;
                if (zoomState.animatePanYto$views_release(fIntBitsToFloat, this) == objG) {
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
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.zoomables.ZoomState$resetWithAnimation$2$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.zoomables.ZoomState$resetWithAnimation$2$3", f = "ZoomStateImpl.kt", l = {134}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass3 extends cb.m implements Function2 {
        final /* synthetic */ float $zoom;
        int label;
        final /* synthetic */ ZoomState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ZoomState zoomState, float f10, ab.e<? super AnonymousClass3> eVar) {
            super(2, eVar);
            this.this$0 = zoomState;
            this.$zoom = f10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass3(this.this$0, this.$zoom, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                ZoomState zoomState = this.this$0;
                float f10 = this.$zoom;
                this.label = 1;
                if (zoomState.animateZoomTo$views_release(f10, this) == objG) {
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
            return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.zoomables.ZoomState$resetWithAnimation$2$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.zoomables.ZoomState$resetWithAnimation$2$4", f = "ZoomStateImpl.kt", l = {TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass4 extends cb.m implements Function2 {
        final /* synthetic */ float $rotation;
        int label;
        final /* synthetic */ ZoomState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ZoomState zoomState, float f10, ab.e<? super AnonymousClass4> eVar) {
            super(2, eVar);
            this.this$0 = zoomState;
            this.$rotation = f10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass4(this.this$0, this.$rotation, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                ZoomState zoomState = this.this$0;
                float f10 = this.$rotation;
                this.label = 1;
                if (zoomState.animateRotationTo$views_release(f10, this) == objG) {
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
            return ((AnonymousClass4) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomState$resetWithAnimation$2(ZoomState zoomState, long j10, float f10, float f11, ab.e<? super ZoomState$resetWithAnimation$2> eVar) {
        super(2, eVar);
        this.this$0 = zoomState;
        this.$pan = j10;
        this.$zoom = f10;
        this.$rotation = f11;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        ZoomState$resetWithAnimation$2 zoomState$resetWithAnimation$2 = new ZoomState$resetWithAnimation$2(this.this$0, this.$pan, this.$zoom, this.$rotation, eVar);
        zoomState$resetWithAnimation$2.L$0 = obj;
        return zoomState$resetWithAnimation$2;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        m0 m0Var = (m0) this.L$0;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        pe.k.d(m0Var, null, null, new AnonymousClass1(this.this$0, this.$pan, null), 3, null);
        pe.k.d(m0Var, null, null, new AnonymousClass2(this.this$0, this.$pan, null), 3, null);
        pe.k.d(m0Var, null, null, new AnonymousClass3(this.this$0, this.$zoom, null), 3, null);
        return pe.k.d(m0Var, null, null, new AnonymousClass4(this.this$0, this.$rotation, null), 3, null);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super a2> eVar) {
        return ((ZoomState$resetWithAnimation$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
