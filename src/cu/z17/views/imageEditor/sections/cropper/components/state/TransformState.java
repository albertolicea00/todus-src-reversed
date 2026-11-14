package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.a2;
import pe.n0;
import rb.k;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Stable
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0018\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J2\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0090@¢\u0006\u0004\b\u001d\u0010\u001eJ>\u0010(\u001a\u00020%2\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0080@¢\u0006\u0004\b&\u0010'J(\u0010,\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00062\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0080@¢\u0006\u0004\b*\u0010+J(\u0010/\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00062\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0080@¢\u0006\u0004\b.\u0010+J(\u00101\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00062\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0080@¢\u0006\u0004\b0\u0010+J(\u00103\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00062\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0080@¢\u0006\u0004\b2\u0010+J\u0018\u00106\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b4\u00105J\u0018\u00108\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b7\u00105J\u0018\u0010:\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b9\u00105J\u0018\u0010<\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b;\u00105J\u001f\u0010B\u001a\u00020\u00152\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\u0012H\u0000¢\u0006\u0004\b@\u0010AJ\u001e\u0010G\u001a\u00020%2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150CH\u0080@¢\u0006\u0004\bE\u0010FJ\u000f\u0010J\u001a\u00020\u0015H\u0000¢\u0006\u0004\bH\u0010IR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010K\u001a\u0004\bN\u0010MR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010K\u001a\u0004\bO\u0010MR\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010\r\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010P\u001a\u0004\bU\u0010R\"\u0004\bV\u0010TR\"\u0010\u000e\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010P\u001a\u0004\bW\u0010R\"\u0004\bX\u0010TR\"\u0010\u000f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010P\u001a\u0004\bY\u0010R\"\u0004\bZ\u0010TR+\u0010c\u001a\u00020[2\u0006\u0010\\\u001a\u00020[8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010d\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\"\u0010h\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bh\u0010e\u001a\u0004\bi\u0010g\"\u0004\bj\u0010kR\u0014\u0010l\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010eR\u0014\u0010m\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010eR&\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020o0n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR&\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020o0n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bt\u0010q\u001a\u0004\bu\u0010sR&\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020o0n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bv\u0010q\u001a\u0004\bw\u0010sR&\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020o0n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bx\u0010q\u001a\u0004\by\u0010sR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0011\u0010 \u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b}\u0010MR\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b~\u0010gR\u0011\u0010\"\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u007f\u0010gR\u0013\u0010\u0080\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010RR\u0013\u0010\u0081\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010RR\u0013\u0010\u0082\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010RR\u0013\u0010\u0083\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010R¨\u0006\u0084\u0001"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/state/TransformState;", "", "Landroidx/compose/ui/unit/IntSize;", "imageSize", "containerSize", "drawAreaSize", "", "initialZoom", "initialRotation", "minZoom", "maxZoom", "", "zoomable", "pannable", "rotatable", "limitPan", "<init>", "(JJJFFFFZZZZLkotlin/jvm/internal/p;)V", "Landroidx/compose/ui/geometry/Offset;", "lowerBound", "upperBound", "Lua/k0;", "updateBounds-AH4skO8$views_release", "(Landroidx/compose/ui/geometry/Offset;Landroidx/compose/ui/geometry/Offset;)V", "updateBounds", "centroid", "panChange", "zoomChange", "rotationChange", "updateTransformState-IUXd7x4$views_release", "(JJFFLab/e;)Ljava/lang/Object;", "updateTransformState", "pan", "zoom", Key.ROTATION, "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "Lpe/a2;", "resetWithAnimation-ULxng0E$views_release", "(JFFLandroidx/compose/animation/core/AnimationSpec;Lab/e;)Ljava/lang/Object;", "resetWithAnimation", "panX", "animatePanXto$views_release", "(FLandroidx/compose/animation/core/AnimationSpec;Lab/e;)Ljava/lang/Object;", "animatePanXto", "panY", "animatePanYto$views_release", "animatePanYto", "animateZoomTo$views_release", "animateZoomTo", "animateRotationTo$views_release", "animateRotationTo", "snapPanXto$views_release", "(FLab/e;)Ljava/lang/Object;", "snapPanXto", "snapPanYto$views_release", "snapPanYto", "snapZoomTo$views_release", "snapZoomTo", "snapRotationTo$views_release", "snapRotationTo", "", "timeMillis", "position", "addPosition-Uv8p0NA$views_release", "(JJ)V", "addPosition", "Lkotlin/Function0;", "onFlingStart", "fling$views_release", "(Llb/a;Lab/e;)Ljava/lang/Object;", "fling", "resetTracking$views_release", "()V", "resetTracking", "J", "getImageSize-YbymL2g$views_release", "()J", "getContainerSize-YbymL2g", "getDrawAreaSize-YbymL2g", "Z", "getZoomable$views_release", "()Z", "setZoomable$views_release", "(Z)V", "getPannable$views_release", "setPannable$views_release", "getRotatable$views_release", "setRotatable$views_release", "getLimitPan$views_release", "setLimitPan$views_release", "Landroidx/compose/ui/geometry/Rect;", "<set-?>", "drawAreaRect$delegate", "Landroidx/compose/runtime/MutableState;", "getDrawAreaRect", "()Landroidx/compose/ui/geometry/Rect;", "setDrawAreaRect", "(Landroidx/compose/ui/geometry/Rect;)V", "drawAreaRect", "zoomMin", "F", "getZoomMin$views_release", "()F", "zoomMax", "getZoomMax$views_release", "setZoomMax$views_release", "(F)V", "zoomInitial", "rotationInitial", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "animatablePanX", "Landroidx/compose/animation/core/Animatable;", "getAnimatablePanX$views_release", "()Landroidx/compose/animation/core/Animatable;", "animatablePanY", "getAnimatablePanY$views_release", "animatableZoom", "getAnimatableZoom$views_release", "animatableRotation", "getAnimatableRotation$views_release", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "getPan-F1C5BW0", "getZoom", "getRotation", "isZooming", "isPanning", "isRotating", "isAnimationRunning", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class TransformState {
    public static final int $stable = 0;
    private final Animatable<Float, AnimationVector1D> animatablePanX;
    private final Animatable<Float, AnimationVector1D> animatablePanY;
    private final Animatable<Float, AnimationVector1D> animatableRotation;
    private final Animatable<Float, AnimationVector1D> animatableZoom;
    private final long containerSize;

    /* JADX INFO: renamed from: drawAreaRect$delegate, reason: from kotlin metadata */
    private final MutableState drawAreaRect;
    private final long drawAreaSize;
    private final long imageSize;
    private boolean limitPan;
    private boolean pannable;
    private boolean rotatable;
    private final float rotationInitial;
    private final VelocityTracker velocityTracker;
    private final float zoomInitial;
    private float zoomMax;
    private final float zoomMin;
    private boolean zoomable;

    public /* synthetic */ TransformState(long j10, long j11, long j12, float f10, float f11, float f12, float f13, boolean z10, boolean z11, boolean z12, boolean z13, p pVar) {
        this(j10, j11, j12, f10, f11, f12, f13, z10, z11, z12, z13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animatePanXto$views_release$default(TransformState transformState, float f10, AnimationSpec animationSpec, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animatePanXto");
        }
        if ((i10 & 2) != 0) {
            animationSpec = AnimationSpecKt.tween$default(400, 0, null, 6, null);
        }
        return transformState.animatePanXto$views_release(f10, animationSpec, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animatePanYto$views_release$default(TransformState transformState, float f10, AnimationSpec animationSpec, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animatePanYto");
        }
        if ((i10 & 2) != 0) {
            animationSpec = AnimationSpecKt.tween$default(400, 0, null, 6, null);
        }
        return transformState.animatePanYto$views_release(f10, animationSpec, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateRotationTo$views_release$default(TransformState transformState, float f10, AnimationSpec animationSpec, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateRotationTo");
        }
        if ((i10 & 2) != 0) {
            animationSpec = AnimationSpecKt.tween$default(400, 0, null, 6, null);
        }
        return transformState.animateRotationTo$views_release(f10, animationSpec, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateZoomTo$views_release$default(TransformState transformState, float f10, AnimationSpec animationSpec, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateZoomTo");
        }
        if ((i10 & 2) != 0) {
            animationSpec = AnimationSpecKt.tween$default(400, 0, null, 6, null);
        }
        return transformState.animateZoomTo$views_release(f10, animationSpec, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: resetWithAnimation-ULxng0E$views_release$default, reason: not valid java name */
    public static /* synthetic */ Object m10220resetWithAnimationULxng0E$views_release$default(TransformState transformState, long j10, float f10, float f11, AnimationSpec animationSpec, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetWithAnimation-ULxng0E");
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
        float f13 = f11;
        if ((i10 & 8) != 0) {
            animationSpec = AnimationSpecKt.tween$default(400, 0, null, 6, null);
        }
        return transformState.m10228resetWithAnimationULxng0E$views_release(j11, f12, f13, animationSpec, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:38:0x0128  */
    /* JADX WARN: Code duplicated, block: B:44:0x015c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0156, code lost:
    
        if (r14.snapPanYto$views_release(r0, r3) == r4) goto L41;
     */
    /* JADX INFO: renamed from: updateTransformState-IUXd7x4$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object m10221updateTransformStateIUXd7x4$suspendImpl(cu.z17.views.imageEditor.sections.cropper.components.state.TransformState r19, long r20, long r22, float r24, float r25, ab.e<? super ua.k0> r26) {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.state.TransformState.m10221updateTransformStateIUXd7x4$suspendImpl(cu.z17.views.imageEditor.sections.cropper.components.state.TransformState, long, long, float, float, ab.e):java.lang.Object");
    }

    /* JADX INFO: renamed from: updateTransformState-IUXd7x4$views_release$default, reason: not valid java name */
    public static /* synthetic */ Object m10222updateTransformStateIUXd7x4$views_release$default(TransformState transformState, long j10, long j11, float f10, float f11, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTransformState-IUXd7x4");
        }
        if ((i10 & 8) != 0) {
            f11 = 1.0f;
        }
        return transformState.m10230updateTransformStateIUXd7x4$views_release(j10, j11, f10, f11, eVar);
    }

    /* JADX INFO: renamed from: addPosition-Uv8p0NA$views_release, reason: not valid java name */
    public final void m10223addPositionUv8p0NA$views_release(long timeMillis, long position) {
        this.velocityTracker.m7173addPositionUv8p0NA(timeMillis, position);
    }

    public final Object animatePanXto$views_release(float f10, AnimationSpec<Float> animationSpec, e<? super k0> eVar) {
        Object objAnimateTo$default;
        return (this.pannable && Float.intBitsToFloat((int) (m10227getPanF1C5BW0() >> 32)) != f10 && (objAnimateTo$default = Animatable.animateTo$default(this.animatablePanX, cb.b.c(f10), animationSpec, null, null, eVar, 12, null)) == bb.b.g()) ? objAnimateTo$default : k0.f43947a;
    }

    public final Object animatePanYto$views_release(float f10, AnimationSpec<Float> animationSpec, e<? super k0> eVar) {
        Object objAnimateTo$default;
        return (this.pannable && Float.intBitsToFloat((int) (m10227getPanF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) != f10 && (objAnimateTo$default = Animatable.animateTo$default(this.animatablePanY, cb.b.c(f10), animationSpec, null, null, eVar, 12, null)) == bb.b.g()) ? objAnimateTo$default : k0.f43947a;
    }

    public final Object animateRotationTo$views_release(float f10, AnimationSpec<Float> animationSpec, e<? super k0> eVar) {
        Object objAnimateTo$default;
        return (this.rotatable && getRotation() != f10 && (objAnimateTo$default = Animatable.animateTo$default(this.animatableRotation, cb.b.c(f10), animationSpec, null, null, eVar, 12, null)) == bb.b.g()) ? objAnimateTo$default : k0.f43947a;
    }

    public final Object animateZoomTo$views_release(float f10, AnimationSpec<Float> animationSpec, e<? super k0> eVar) {
        if (this.zoomable && getZoom() != f10) {
            Object objAnimateTo$default = Animatable.animateTo$default(this.animatableZoom, cb.b.c(k.n(f10, this.zoomMin, this.zoomMax)), animationSpec, null, null, eVar, 12, null);
            if (objAnimateTo$default == bb.b.g()) {
                return objAnimateTo$default;
            }
        }
        return k0.f43947a;
    }

    public final Object fling$views_release(lb.a aVar, e<? super a2> eVar) {
        return n0.e(new TransformState$fling$2(this, aVar, null), eVar);
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

    /* JADX INFO: renamed from: getContainerSize-YbymL2g, reason: not valid java name and from getter */
    public final long getContainerSize() {
        return this.containerSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Rect getDrawAreaRect() {
        return (Rect) this.drawAreaRect.getValue();
    }

    /* JADX INFO: renamed from: getDrawAreaSize-YbymL2g, reason: not valid java name and from getter */
    public final long getDrawAreaSize() {
        return this.drawAreaSize;
    }

    /* JADX INFO: renamed from: getImageSize-YbymL2g$views_release, reason: not valid java name and from getter */
    public final long getImageSize() {
        return this.imageSize;
    }

    /* JADX INFO: renamed from: getLimitPan$views_release, reason: from getter */
    public final boolean getLimitPan() {
        return this.limitPan;
    }

    /* JADX INFO: renamed from: getPan-F1C5BW0, reason: not valid java name */
    public final long m10227getPanF1C5BW0() {
        float fFloatValue = this.animatablePanX.getValue().floatValue();
        return Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(this.animatablePanY.getValue().floatValue())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fFloatValue) << 32));
    }

    /* JADX INFO: renamed from: getPannable$views_release, reason: from getter */
    public final boolean getPannable() {
        return this.pannable;
    }

    /* JADX INFO: renamed from: getRotatable$views_release, reason: from getter */
    public final boolean getRotatable() {
        return this.rotatable;
    }

    public final float getRotation() {
        return this.animatableRotation.getValue().floatValue();
    }

    public final float getZoom() {
        return this.animatableZoom.getValue().floatValue();
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
    public final boolean getZoomable() {
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

    public final void resetTracking$views_release() {
        this.velocityTracker.resetTracking();
    }

    /* JADX INFO: renamed from: resetWithAnimation-ULxng0E$views_release, reason: not valid java name */
    public final Object m10228resetWithAnimationULxng0E$views_release(long j10, float f10, float f11, AnimationSpec<Float> animationSpec, e<? super a2> eVar) {
        return n0.e(new TransformState$resetWithAnimation$2(this, j10, animationSpec, f10, f11, null), eVar);
    }

    public final void setDrawAreaRect(Rect rect) {
        y.i(rect, "<set-?>");
        this.drawAreaRect.setValue(rect);
    }

    public final void setLimitPan$views_release(boolean z10) {
        this.limitPan = z10;
    }

    public final void setPannable$views_release(boolean z10) {
        this.pannable = z10;
    }

    public final void setRotatable$views_release(boolean z10) {
        this.rotatable = z10;
    }

    public final void setZoomMax$views_release(float f10) {
        this.zoomMax = f10;
    }

    public final void setZoomable$views_release(boolean z10) {
        this.zoomable = z10;
    }

    public final Object snapPanXto$views_release(float f10, e<? super k0> eVar) {
        if (!this.pannable) {
            return k0.f43947a;
        }
        Object objSnapTo = this.animatablePanX.snapTo(cb.b.c(f10), eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    public final Object snapPanYto$views_release(float f10, e<? super k0> eVar) {
        if (!this.pannable) {
            return k0.f43947a;
        }
        Object objSnapTo = this.animatablePanY.snapTo(cb.b.c(f10), eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    public final Object snapRotationTo$views_release(float f10, e<? super k0> eVar) {
        if (!this.rotatable) {
            return k0.f43947a;
        }
        Object objSnapTo = this.animatableRotation.snapTo(cb.b.c(f10), eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    public final Object snapZoomTo$views_release(float f10, e<? super k0> eVar) {
        if (!this.zoomable) {
            return k0.f43947a;
        }
        Object objSnapTo = this.animatableZoom.snapTo(cb.b.c(k.n(f10, this.zoomMin, this.zoomMax)), eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    /* JADX INFO: renamed from: updateBounds-AH4skO8$views_release, reason: not valid java name */
    public void m10229updateBoundsAH4skO8$views_release(Offset lowerBound, Offset upperBound) {
        this.animatablePanX.updateBounds(lowerBound != null ? Float.valueOf(Float.intBitsToFloat((int) (lowerBound.m5636unboximpl() >> 32))) : null, upperBound != null ? Float.valueOf(Float.intBitsToFloat((int) (upperBound.m5636unboximpl() >> 32))) : null);
        this.animatablePanY.updateBounds(lowerBound != null ? Float.valueOf(Float.intBitsToFloat((int) (lowerBound.m5636unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) : null, upperBound != null ? Float.valueOf(Float.intBitsToFloat((int) (upperBound.m5636unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) : null);
    }

    /* JADX INFO: renamed from: updateTransformState-IUXd7x4$views_release, reason: not valid java name */
    public Object m10230updateTransformStateIUXd7x4$views_release(long j10, long j11, float f10, float f11, e<? super k0> eVar) {
        return m10221updateTransformStateIUXd7x4$suspendImpl(this, j10, j11, f10, f11, eVar);
    }

    private TransformState(long j10, long j11, long j12, float f10, float f11, float f12, float f13, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.imageSize = j10;
        this.containerSize = j11;
        this.drawAreaSize = j12;
        this.zoomable = z10;
        this.pannable = z11;
        this.rotatable = z12;
        this.limitPan = z13;
        float f14 = (((int) (j11 >> 32)) - ((int) (j12 >> 32))) / 2;
        this.drawAreaRect = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(RectKt.m5666Recttz77jQw(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits((((int) (j11 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - ((int) (j12 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) / 2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f14) << 32)), Size.m5686constructorimpl((((long) Float.floatToRawIntBits((int) (j12 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits((int) (j12 >> 32)) << 32))), null, 2, null);
        float fD = k.d(f12, 1.0f);
        this.zoomMin = fD;
        float fD2 = k.d(f13, 1.0f);
        this.zoomMax = fD2;
        float fN = k.n(f10, fD, fD2);
        this.zoomInitial = fN;
        float f15 = f11 % 360;
        this.rotationInitial = f15;
        this.animatablePanX = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatablePanY = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        Animatable<Float, AnimationVector1D> animatableAnimatable$default = AnimatableKt.Animatable$default(fN, 0.0f, 2, null);
        this.animatableZoom = animatableAnimatable$default;
        this.animatableRotation = AnimatableKt.Animatable$default(f15, 0.0f, 2, null);
        this.velocityTracker = new VelocityTracker();
        animatableAnimatable$default.updateBounds(Float.valueOf(fD), Float.valueOf(this.zoomMax));
        if (this.zoomMax < fD) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public /* synthetic */ TransformState(long j10, long j11, long j12, float f10, float f11, float f12, float f13, boolean z10, boolean z11, boolean z12, boolean z13, int i10, p pVar) {
        this(j10, j11, j12, (i10 & 8) != 0 ? 1.0f : f10, (i10 & 16) != 0 ? 0.0f : f11, (i10 & 32) != 0 ? 1.0f : f12, (i10 & 64) != 0 ? 10.0f : f13, (i10 & 128) != 0 ? true : z10, (i10 & 256) != 0 ? true : z11, (i10 & 512) != 0 ? true : z12, (i10 & 1024) != 0 ? false : z13, null);
    }
}
