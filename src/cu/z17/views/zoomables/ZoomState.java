package cu.z17.views.zoomables;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import pe.a2;
import pe.n0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Stable
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0017\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0014\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ2\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b \u0010!J.\u0010)\u001a\u00020&2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u0002H\u0090@¢\u0006\u0004\b'\u0010(J\u0018\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b+\u0010,J\u0018\u00100\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b/\u0010,J\u0018\u00102\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b1\u0010,J\u0018\u00104\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b3\u0010,J\u0018\u00106\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b5\u0010,J\u0018\u00108\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b7\u0010,J\u0018\u0010:\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b9\u0010,J\u0018\u0010<\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b;\u0010,R\u001a\u0010\b\u001a\u00020\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\b\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010\t\u001a\u00020\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\t\u0010=\u001a\u0004\b@\u0010?R\u001a\u0010\n\u001a\u00020\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\n\u0010=\u001a\u0004\bA\u0010?R\u001a\u0010\u000b\u001a\u00020\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u000b\u0010=\u001a\u0004\bB\u0010?R\u001a\u0010C\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bG\u0010D\u001a\u0004\bH\u0010FR\u001a\u0010I\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010FR\u001a\u0010K\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bK\u0010D\u001a\u0004\bL\u0010FR&\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020N0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR&\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020N0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bS\u0010P\u001a\u0004\bT\u0010RR&\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020N0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bU\u0010P\u001a\u0004\bV\u0010RR&\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020N0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bW\u0010P\u001a\u0004\bX\u0010RR\"\u0010\u0016\u001a\u00020\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010Y\u001a\u0004\bZ\u0010\u001b\"\u0004\b[\u0010\\R\u0011\u0010#\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b]\u0010\u001bR\u0011\u0010$\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b^\u0010FR\u0011\u0010%\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b_\u0010FR\u0011\u0010`\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b`\u0010?R\u0011\u0010a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\ba\u0010?R\u0011\u0010b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bb\u0010?R\u0011\u0010c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bc\u0010?¨\u0006d"}, d2 = {"Lcu/z17/views/zoomables/ZoomState;", "", "", "initialZoom", "initialRotation", "minZoom", "maxZoom", "", "zoomable", "pannable", "rotatable", "limitPan", "<init>", "(FFFFZZZZ)V", "Landroidx/compose/ui/geometry/Offset;", "lowerBound", "upperBound", "Lua/k0;", "updateBounds-AH4skO8$views_release", "(Landroidx/compose/ui/geometry/Offset;Landroidx/compose/ui/geometry/Offset;)V", "updateBounds", "Landroidx/compose/ui/unit/IntSize;", "size", "getBounds-3WJTlbM$views_release", "(J)J", "getBounds", "getBounds-F1C5BW0", "()J", "centroid", "panChange", "zoomChange", "rotationChange", "updateZoomState-IUXd7x4", "(JJFFLab/e;)Ljava/lang/Object;", "updateZoomState", "pan", "zoom", Key.ROTATION, "Lpe/a2;", "resetWithAnimation-M_7yMNQ$views_release", "(JFFLab/e;)Ljava/lang/Object;", "resetWithAnimation", "panX", "animatePanXto$views_release", "(FLab/e;)Ljava/lang/Object;", "animatePanXto", "panY", "animatePanYto$views_release", "animatePanYto", "animateZoomTo$views_release", "animateZoomTo", "animateRotationTo$views_release", "animateRotationTo", "snapPanXto$views_release", "snapPanXto", "snapPanYto$views_release", "snapPanYto", "snapZoomTo$views_release", "snapZoomTo", "snapRotationTo$views_release", "snapRotationTo", "Z", "getZoomable$views_release", "()Z", "getPannable$views_release", "getRotatable$views_release", "getLimitPan$views_release", "zoomMin", "F", "getZoomMin$views_release", "()F", "zoomMax", "getZoomMax$views_release", "zoomInitial", "getZoomInitial$views_release", "rotationInitial", "getRotationInitial$views_release", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "animatablePanX", "Landroidx/compose/animation/core/Animatable;", "getAnimatablePanX$views_release", "()Landroidx/compose/animation/core/Animatable;", "animatablePanY", "getAnimatablePanY$views_release", "animatableZoom", "getAnimatableZoom$views_release", "animatableRotation", "getAnimatableRotation$views_release", "J", "getSize-YbymL2g$views_release", "setSize-ozmzZPI$views_release", "(J)V", "getPan-F1C5BW0", "getZoom", "getRotation", "isZooming", "isPanning", "isRotating", "isAnimationRunning", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ZoomState {
    public static final int $stable = 0;
    private final Animatable<Float, AnimationVector1D> animatablePanX;
    private final Animatable<Float, AnimationVector1D> animatablePanY;
    private final Animatable<Float, AnimationVector1D> animatableRotation;
    private final Animatable<Float, AnimationVector1D> animatableZoom;
    private final boolean limitPan;
    private final boolean pannable;
    private final boolean rotatable;
    private final float rotationInitial;
    private long size;
    private final float zoomInitial;
    private final float zoomMax;
    private final float zoomMin;
    private final boolean zoomable;

    public ZoomState() {
        this(0.0f, 0.0f, 0.0f, 0.0f, false, false, false, false, 255, null);
    }

    /* JADX INFO: renamed from: resetWithAnimation-M_7yMNQ$suspendImpl, reason: not valid java name */
    public static /* synthetic */ Object m10339resetWithAnimationM_7yMNQ$suspendImpl(ZoomState zoomState, long j10, float f10, float f11, ab.e<? super a2> eVar) {
        return n0.e(new ZoomState$resetWithAnimation$2(zoomState, j10, f10, f11, null), eVar);
    }

    /* JADX INFO: renamed from: resetWithAnimation-M_7yMNQ$views_release$default, reason: not valid java name */
    public static /* synthetic */ Object m10340resetWithAnimationM_7yMNQ$views_release$default(ZoomState zoomState, long j10, float f10, float f11, ab.e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetWithAnimation-M_7yMNQ");
        }
        if ((i10 & 1) != 0) {
            j10 = Offset.INSTANCE.m5642getZeroF1C5BW0();
        }
        long j11 = j10;
        if ((i10 & 2) != 0) {
            f10 = 1.0f;
        }
        float f12 = f10;
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        return zoomState.m10347resetWithAnimationM_7yMNQ$views_release(j11, f12, f11, eVar);
    }

    /* JADX INFO: renamed from: updateZoomState-IUXd7x4$default, reason: not valid java name */
    public static /* synthetic */ Object m10341updateZoomStateIUXd7x4$default(ZoomState zoomState, long j10, long j11, float f10, float f11, ab.e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateZoomState-IUXd7x4");
        }
        if ((i10 & 8) != 0) {
            f11 = 1.0f;
        }
        return zoomState.m10350updateZoomStateIUXd7x4(j10, j11, f10, f11, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:39:0x011c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0120  */
    /* JADX WARN: Code duplicated, block: B:46:0x015e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0190  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x018a, code lost:
    
        if (r15.snapPanYto$views_release(r2, r6) == r4) goto L49;
     */
    /* JADX INFO: renamed from: updateZoomState-IUXd7x4$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object m10342updateZoomStateIUXd7x4$suspendImpl(cu.z17.views.zoomables.ZoomState r20, long r21, long r23, float r25, float r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.zoomables.ZoomState.m10342updateZoomStateIUXd7x4$suspendImpl(cu.z17.views.zoomables.ZoomState, long, long, float, float, ab.e):java.lang.Object");
    }

    public final Object animatePanXto$views_release(float f10, ab.e<? super k0> eVar) {
        Object objAnimateTo$default;
        return (getPannable() && Float.intBitsToFloat((int) (m10345getPanF1C5BW0() >> 32)) != f10 && (objAnimateTo$default = Animatable.animateTo$default(this.animatablePanX, cb.b.c(f10), null, null, null, eVar, 14, null)) == bb.b.g()) ? objAnimateTo$default : k0.f43947a;
    }

    public final Object animatePanYto$views_release(float f10, ab.e<? super k0> eVar) {
        Object objAnimateTo$default;
        return (getPannable() && Float.intBitsToFloat((int) (m10345getPanF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) != f10 && (objAnimateTo$default = Animatable.animateTo$default(this.animatablePanY, cb.b.c(f10), null, null, null, eVar, 14, null)) == bb.b.g()) ? objAnimateTo$default : k0.f43947a;
    }

    public final Object animateRotationTo$views_release(float f10, ab.e<? super k0> eVar) {
        Object objAnimateTo$default;
        return (getRotatable() && getRotation() != f10 && (objAnimateTo$default = Animatable.animateTo$default(this.animatableRotation, cb.b.c(f10), null, null, null, eVar, 14, null)) == bb.b.g()) ? objAnimateTo$default : k0.f43947a;
    }

    public final Object animateZoomTo$views_release(float f10, ab.e<? super k0> eVar) {
        if (getZoomable() && getZoom() != f10) {
            Object objAnimateTo$default = Animatable.animateTo$default(this.animatableZoom, cb.b.c(rb.k.n(f10, this.zoomMin, this.zoomMax)), null, null, null, eVar, 14, null);
            if (objAnimateTo$default == bb.b.g()) {
                return objAnimateTo$default;
            }
        }
        return k0.f43947a;
    }

    public final Animatable<Float, AnimationVector1D> getAnimatablePanX$views_release() {
        return this.animatablePanX;
    }

    public final Animatable<Float, AnimationVector1D> getAnimatablePanY$views_release() {
        return this.animatablePanY;
    }

    public final Animatable<Float, AnimationVector1D> getAnimatableRotation$views_release() {
        return this.animatableRotation;
    }

    public final Animatable<Float, AnimationVector1D> getAnimatableZoom$views_release() {
        return this.animatableZoom;
    }

    /* JADX INFO: renamed from: getBounds-3WJTlbM$views_release, reason: not valid java name */
    public long m10343getBounds3WJTlbM$views_release(long size) {
        float f10 = 1;
        float fD = rb.k.d((((int) (size >> 32)) * (getZoom() - f10)) / 2.0f, 0.0f);
        return Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(rb.k.d((((int) (size & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) * (getZoom() - f10)) / 2.0f, 0.0f))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fD) << 32));
    }

    /* JADX INFO: renamed from: getBounds-F1C5BW0, reason: not valid java name */
    public long m10344getBoundsF1C5BW0() {
        return m10343getBounds3WJTlbM$views_release(this.size);
    }

    /* JADX INFO: renamed from: getLimitPan$views_release, reason: from getter */
    public boolean getLimitPan() {
        return this.limitPan;
    }

    /* JADX INFO: renamed from: getPan-F1C5BW0, reason: not valid java name */
    public final long m10345getPanF1C5BW0() {
        float fFloatValue = this.animatablePanX.getValue().floatValue();
        return Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(this.animatablePanY.getValue().floatValue())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fFloatValue) << 32));
    }

    /* JADX INFO: renamed from: getPannable$views_release, reason: from getter */
    public boolean getPannable() {
        return this.pannable;
    }

    /* JADX INFO: renamed from: getRotatable$views_release, reason: from getter */
    public boolean getRotatable() {
        return this.rotatable;
    }

    public final float getRotation() {
        return this.animatableRotation.getValue().floatValue();
    }

    /* JADX INFO: renamed from: getRotationInitial$views_release, reason: from getter */
    public final float getRotationInitial() {
        return this.rotationInitial;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g$views_release, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    public final float getZoom() {
        return this.animatableZoom.getValue().floatValue();
    }

    /* JADX INFO: renamed from: getZoomInitial$views_release, reason: from getter */
    public final float getZoomInitial() {
        return this.zoomInitial;
    }

    /* JADX INFO: renamed from: getZoomMax$views_release, reason: from getter */
    public final float getZoomMax() {
        return this.zoomMax;
    }

    /* JADX INFO: renamed from: getZoomMin$views_release, reason: from getter */
    public final float getZoomMin() {
        return this.zoomMin;
    }

    /* JADX INFO: renamed from: getZoomable$views_release, reason: from getter */
    public boolean getZoomable() {
        return this.zoomable;
    }

    public final boolean isAnimationRunning() {
        return isZooming() || isPanning() || isRotating();
    }

    public final boolean isPanning() {
        return this.animatablePanX.isRunning() || this.animatablePanY.isRunning();
    }

    public final boolean isRotating() {
        return this.animatableRotation.isRunning();
    }

    public final boolean isZooming() {
        return this.animatableZoom.isRunning();
    }

    /* JADX INFO: renamed from: resetWithAnimation-M_7yMNQ$views_release, reason: not valid java name */
    public Object m10347resetWithAnimationM_7yMNQ$views_release(long j10, float f10, float f11, ab.e<? super a2> eVar) {
        return m10339resetWithAnimationM_7yMNQ$suspendImpl(this, j10, f10, f11, eVar);
    }

    /* JADX INFO: renamed from: setSize-ozmzZPI$views_release, reason: not valid java name */
    public final void m10348setSizeozmzZPI$views_release(long j10) {
        this.size = j10;
    }

    public final Object snapPanXto$views_release(float f10, ab.e<? super k0> eVar) {
        if (!getPannable()) {
            return k0.f43947a;
        }
        Object objSnapTo = this.animatablePanX.snapTo(cb.b.c(f10), eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    public final Object snapPanYto$views_release(float f10, ab.e<? super k0> eVar) {
        if (!getPannable()) {
            return k0.f43947a;
        }
        Object objSnapTo = this.animatablePanY.snapTo(cb.b.c(f10), eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    public final Object snapRotationTo$views_release(float f10, ab.e<? super k0> eVar) {
        if (!getRotatable()) {
            return k0.f43947a;
        }
        Object objSnapTo = this.animatableRotation.snapTo(cb.b.c(f10), eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    public final Object snapZoomTo$views_release(float f10, ab.e<? super k0> eVar) {
        if (!getZoomable()) {
            return k0.f43947a;
        }
        Object objSnapTo = this.animatableZoom.snapTo(cb.b.c(rb.k.n(f10, this.zoomMin, this.zoomMax)), eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    /* JADX INFO: renamed from: updateBounds-AH4skO8$views_release, reason: not valid java name */
    public void m10349updateBoundsAH4skO8$views_release(Offset lowerBound, Offset upperBound) {
        this.animatablePanX.updateBounds(lowerBound != null ? Float.valueOf(Float.intBitsToFloat((int) (lowerBound.m5636unboximpl() >> 32))) : null, upperBound != null ? Float.valueOf(Float.intBitsToFloat((int) (upperBound.m5636unboximpl() >> 32))) : null);
        this.animatablePanY.updateBounds(lowerBound != null ? Float.valueOf(Float.intBitsToFloat((int) (lowerBound.m5636unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) : null, upperBound != null ? Float.valueOf(Float.intBitsToFloat((int) (upperBound.m5636unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) : null);
    }

    /* JADX INFO: renamed from: updateZoomState-IUXd7x4, reason: not valid java name */
    public Object m10350updateZoomStateIUXd7x4(long j10, long j11, float f10, float f11, ab.e<? super k0> eVar) {
        return m10342updateZoomStateIUXd7x4$suspendImpl(this, j10, j11, f10, f11, eVar);
    }

    public ZoomState(float f10, float f11, float f12, float f13, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.zoomable = z10;
        this.pannable = z11;
        this.rotatable = z12;
        this.limitPan = z13;
        float fD = rb.k.d(f12, 0.5f);
        this.zoomMin = fD;
        float fD2 = rb.k.d(f13, 1.0f);
        this.zoomMax = fD2;
        float fN = rb.k.n(f10, fD, fD2);
        this.zoomInitial = fN;
        float f14 = f11 % 360;
        this.rotationInitial = f14;
        this.animatablePanX = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatablePanY = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        Animatable<Float, AnimationVector1D> animatableAnimatable$default = AnimatableKt.Animatable$default(fN, 0.0f, 2, null);
        this.animatableZoom = animatableAnimatable$default;
        this.animatableRotation = AnimatableKt.Animatable$default(f14, 0.0f, 2, null);
        this.size = IntSize.INSTANCE.m8995getZeroYbymL2g();
        animatableAnimatable$default.updateBounds(Float.valueOf(fD), Float.valueOf(fD2));
        if (fD2 < fD) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public /* synthetic */ ZoomState(float f10, float f11, float f12, float f13, boolean z10, boolean z11, boolean z12, boolean z13, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? 0.0f : f11, (i10 & 4) != 0 ? 1.0f : f12, (i10 & 8) != 0 ? 5.0f : f13, (i10 & 16) != 0 ? true : z10, (i10 & 32) != 0 ? true : z11, (i10 & 64) != 0 ? true : z12, (i10 & 128) != 0 ? false : z13);
    }
}
