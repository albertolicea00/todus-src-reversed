package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.media3.muxer.MuxerUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.z17.views.imageEditor.sections.cropper.components.TouchRegion;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatio;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropProperties;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import rb.k;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u00002\u00020\u0001Bk\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\"\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010'\u001a\u00020$H\u0080@¢\u0006\u0004\b%\u0010&J\"\u0010-\u001a\u00020$2\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\bH\u0090@¢\u0006\u0004\b+\u0010,J(\u00103\u001a\u00020$2\u0006\u0010.\u001a\u00020\u00132\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130/H\u0080@¢\u0006\u0004\b1\u00102J\u0018\u00106\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b4\u00105J\u0018\u0010;\u001a\u00020$2\u0006\u00108\u001a\u000207H @¢\u0006\u0004\b9\u0010:J\u001e\u0010@\u001a\u00020$2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002070<H @¢\u0006\u0004\b>\u0010?J\u0018\u0010B\u001a\u00020$2\u0006\u00108\u001a\u000207H @¢\u0006\u0004\bA\u0010:JF\u0010K\u001a\u00020$2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u0002072\f\u0010=\u001a\b\u0012\u0004\u0012\u0002070<H @¢\u0006\u0004\bI\u0010JJ\u0010\u0010M\u001a\u00020$H @¢\u0006\u0004\bL\u0010&J\u001e\u0010R\u001a\u00020$2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020$0NH @¢\u0006\u0004\bP\u0010QJ0\u0010W\u001a\u00020$2\u0006\u0010S\u001a\u00020C2\b\b\u0002\u0010\u0016\u001a\u00020\u00062\f\u0010T\u001a\b\u0012\u0004\u0012\u00020$0NH @¢\u0006\u0004\bU\u0010VJ\u000f\u0010Z\u001a\u00020\bH\u0000¢\u0006\u0004\bX\u0010YJ\u0017\u0010]\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0013H\u0000¢\u0006\u0004\b[\u0010\\J\u000f\u0010`\u001a\u00020\u0013H\u0000¢\u0006\u0004\b^\u0010_J0\u0010d\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010a\u001a\u00020\b2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0080@¢\u0006\u0004\bb\u0010cJ7\u0010k\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u0006H\u0000¢\u0006\u0004\bi\u0010jR\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010l\u001a\u0004\bm\u0010Y\"\u0004\bn\u0010oR\"\u0010\u000b\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010\f\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR \u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020{0z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R&\u0010\u007f\u001a\u00020\u00132\u0006\u0010~\u001a\u00020\u00138F@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010_R\u0018\u0010\u0082\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010lR5\u0010\u008b\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0083\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0012\u0010!\u001a\u00020\u00138F¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010_¨\u0006\u008d\u0001"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;", "Lcu/z17/views/imageEditor/sections/cropper/components/state/TransformState;", "Landroidx/compose/ui/unit/IntSize;", "imageSize", "containerSize", "drawAreaSize", "", "maxZoom", "", "fling", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "aspectRatio", "overlayRatio", "zoomable", "pannable", "rotatable", "limitPan", "<init>", "(JJJFZLcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;FZZZZLkotlin/jvm/internal/p;)V", "Landroidx/compose/ui/geometry/Rect;", "oldRect", "newRect", "zoom", "calculateNewZoom", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;F)F", "rectOverlay", "rectDrawArea", "calculateValidImageDrawRect", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "", "bitmapWidth", "bitmapHeight", "drawAreaRect", "overlayRect", "getCropRectangle", "(IILandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "Lua/k0;", "init$views_release", "(Lab/e;)Ljava/lang/Object;", "init", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;", "cropProperties", "forceUpdate", "updateProperties$views_release", "(Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;ZLab/e;)Ljava/lang/Object;", "updateProperties", "rect", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "animateOverlayRectTo$views_release", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lab/e;)Ljava/lang/Object;", "animateOverlayRectTo", "snapOverlayRectTo$views_release", "(Landroidx/compose/ui/geometry/Rect;Lab/e;)Ljava/lang/Object;", "snapOverlayRectTo", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change", "onDown$views_release", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Lab/e;)Ljava/lang/Object;", "onDown", "", "changes", "onMove$views_release", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "onMove", "onUp$views_release", "onUp", "Landroidx/compose/ui/geometry/Offset;", "centroid", "panChange", "zoomChange", "rotationChange", "mainPointer", "onGesture-t6rOp4E$views_release", "(JJFFLandroidx/compose/ui/input/pointer/PointerInputChange;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "onGesture", "onGestureStart$views_release", "onGestureStart", "Lkotlin/Function0;", "onBoundsCalculated", "onGestureEnd$views_release", "(Llb/a;Lab/e;)Ljava/lang/Object;", "onGestureEnd", "offset", "onAnimationEnd", "onDoubleTap-M_7yMNQ$views_release", "(JFLlb/a;Lab/e;)Ljava/lang/Object;", "onDoubleTap", "isOverlayInImageDrawBounds$views_release", "()Z", "isOverlayInImageDrawBounds", "isRectInContainerBounds$views_release", "(Landroidx/compose/ui/geometry/Rect;)Z", "isRectInContainerBounds", "updateImageDrawRectFromTransformation$views_release", "()Landroidx/compose/ui/geometry/Rect;", "updateImageDrawRectFromTransformation", "animate", "animateTransformationToOverlayBounds$views_release", "(Landroidx/compose/ui/geometry/Rect;ZLandroidx/compose/animation/core/AnimationSpec;Lab/e;)Ljava/lang/Object;", "animateTransformationToOverlayBounds", "containerWidth", "containerHeight", "drawAreaWidth", "coefficient", "getOverlayFromAspectRatio$views_release", "(FFFLcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;F)Landroidx/compose/ui/geometry/Rect;", "getOverlayFromAspectRatio", "Z", "getFling$views_release", "setFling$views_release", "(Z)V", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "getAspectRatio$views_release", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "setAspectRatio$views_release", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;)V", "F", "getOverlayRatio$views_release", "()F", "setOverlayRatio$views_release", "(F)V", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector4D;", "animatableRectOverlay", "Landroidx/compose/animation/core/Animatable;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "cropRect", "Landroidx/compose/ui/geometry/Rect;", "getCropRect", "initialized", "Lcu/z17/views/imageEditor/sections/cropper/components/TouchRegion;", "<set-?>", "touchRegion$delegate", "Landroidx/compose/runtime/MutableState;", "getTouchRegion", "()Lcu/z17/views/imageEditor/sections/cropper/components/TouchRegion;", "setTouchRegion", "(Lcu/z17/views/imageEditor/sections/cropper/components/TouchRegion;)V", "touchRegion", "getOverlayRect", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CropState extends TransformState {
    public static final int $stable = 0;
    private final Animatable<Rect, AnimationVector4D> animatableRectOverlay;
    private AspectRatio aspectRatio;
    private Rect cropRect;
    private boolean fling;
    private boolean initialized;
    private float overlayRatio;

    /* JADX INFO: renamed from: touchRegion$delegate, reason: from kotlin metadata */
    private final MutableState touchRegion;

    public /* synthetic */ CropState(long j10, long j11, long j12, float f10, boolean z10, AspectRatio aspectRatio, float f11, boolean z11, boolean z12, boolean z13, boolean z14, p pVar) {
        this(j10, j11, j12, f10, z10, aspectRatio, f11, z11, z12, z13, z14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateOverlayRectTo$views_release$default(CropState cropState, Rect rect, AnimationSpec animationSpec, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateOverlayRectTo");
        }
        if ((i10 & 2) != 0) {
            animationSpec = AnimationSpecKt.tween$default(400, 0, null, 6, null);
        }
        return cropState.animateOverlayRectTo$views_release(rect, animationSpec, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTransformationToOverlayBounds$views_release$default(CropState cropState, Rect rect, boolean z10, AnimationSpec animationSpec, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTransformationToOverlayBounds");
        }
        if ((i10 & 4) != 0) {
            animationSpec = AnimationSpecKt.tween$default(400, 0, null, 6, null);
        }
        return cropState.animateTransformationToOverlayBounds$views_release(rect, z10, animationSpec, eVar);
    }

    private final float calculateNewZoom(Rect oldRect, Rect newRect, float zoom) {
        long jM5659getSizeNHjbRc = oldRect.m5659getSizeNHjbRc();
        Size.Companion companion = Size.INSTANCE;
        return (Size.m5691equalsimpl0(jM5659getSizeNHjbRc, companion.m5704getZeroNHjbRc()) || Size.m5691equalsimpl0(newRect.m5659getSizeNHjbRc(), companion.m5704getZeroNHjbRc())) ? zoom : k.d(k.d((newRect.getRight() - newRect.getLeft()) / (oldRect.getRight() - oldRect.getLeft()), 1.0f), k.d((newRect.getBottom() - newRect.getTop()) / (oldRect.getBottom() - oldRect.getTop()), 1.0f)) * zoom;
    }

    private final Rect calculateValidImageDrawRect(Rect rectOverlay, Rect rectDrawArea) {
        float right = rectDrawArea.getRight() - rectDrawArea.getLeft();
        float bottom = rectDrawArea.getBottom() - rectDrawArea.getTop();
        if (right < rectOverlay.getRight() - rectOverlay.getLeft()) {
            right = rectOverlay.getRight() - rectOverlay.getLeft();
        }
        if (bottom < rectOverlay.getBottom() - rectOverlay.getTop()) {
            bottom = rectOverlay.getBottom() - rectOverlay.getTop();
        }
        Rect rectM5666Recttz77jQw = RectKt.m5666Recttz77jQw(rectDrawArea.m5661getTopLeftF1C5BW0(), Size.m5686constructorimpl((((long) Float.floatToRawIntBits(bottom)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(right)) << 32)));
        if (rectM5666Recttz77jQw.getLeft() > rectOverlay.getLeft()) {
            rectM5666Recttz77jQw = rectM5666Recttz77jQw.translate(rectOverlay.getLeft() - rectM5666Recttz77jQw.getLeft(), 0.0f);
        }
        if (rectM5666Recttz77jQw.getRight() < rectOverlay.getRight()) {
            rectM5666Recttz77jQw = rectM5666Recttz77jQw.translate(rectOverlay.getRight() - rectM5666Recttz77jQw.getRight(), 0.0f);
        }
        if (rectM5666Recttz77jQw.getTop() > rectOverlay.getTop()) {
            rectM5666Recttz77jQw = rectM5666Recttz77jQw.translate(0.0f, rectOverlay.getTop() - rectM5666Recttz77jQw.getTop());
        }
        return rectM5666Recttz77jQw.getBottom() < rectOverlay.getBottom() ? rectM5666Recttz77jQw.translate(0.0f, rectOverlay.getBottom() - rectM5666Recttz77jQw.getBottom()) : rectM5666Recttz77jQw;
    }

    private final Rect getCropRectangle(int bitmapWidth, int bitmapHeight, Rect drawAreaRect, Rect overlayRect) {
        Rect.Companion companion = Rect.INSTANCE;
        if (y.d(drawAreaRect, companion.getZero()) || y.d(overlayRect, companion.getZero())) {
            return RectKt.m5666Recttz77jQw(Offset.INSTANCE.m5642getZeroF1C5BW0(), Size.m5686constructorimpl((((long) Float.floatToRawIntBits(bitmapHeight)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(bitmapWidth) << 32)));
        }
        Rect rectCalculateValidImageDrawRect = calculateValidImageDrawRect(overlayRect, drawAreaRect);
        float right = overlayRect.getRight() - overlayRect.getLeft();
        float bottom = overlayRect.getBottom() - overlayRect.getTop();
        float right2 = rectCalculateValidImageDrawRect.getRight() - rectCalculateValidImageDrawRect.getLeft();
        float bottom2 = rectCalculateValidImageDrawRect.getBottom() - rectCalculateValidImageDrawRect.getTop();
        float f10 = bitmapWidth;
        float left = (overlayRect.getLeft() - rectCalculateValidImageDrawRect.getLeft()) * (f10 / right2);
        float f11 = bitmapHeight;
        float f12 = f10 * (right / right2);
        return RectKt.m5666Recttz77jQw(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits((overlayRect.getTop() - rectCalculateValidImageDrawRect.getTop()) * (f11 / bottom2))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(left) << 32)), Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f11 * (bottom / bottom2))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f12) << 32)));
    }

    /* JADX INFO: renamed from: onDoubleTap-M_7yMNQ$views_release$default, reason: not valid java name */
    public static /* synthetic */ Object m10213onDoubleTapM_7yMNQ$views_release$default(CropState cropState, long j10, float f10, lb.a aVar, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDoubleTap-M_7yMNQ");
        }
        if ((i10 & 2) != 0) {
            f10 = 1.0f;
        }
        return cropState.mo10214onDoubleTapM_7yMNQ$views_release(j10, f10, aVar, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b1, code lost:
    
        if (animateTransformationToOverlayBounds$views_release$default(r4, r5, true, null, r7, 4, null) == r3) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object updateProperties$suspendImpl(cu.z17.views.imageEditor.sections.cropper.components.state.CropState r19, cu.z17.views.imageEditor.sections.cropper.components.settings.CropProperties r20, boolean r21, ab.e<? super ua.k0> r22) {
        /*
            Method dump skipped, instruction units count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.state.CropState.updateProperties$suspendImpl(cu.z17.views.imageEditor.sections.cropper.components.state.CropState, cu.z17.views.imageEditor.sections.cropper.components.settings.CropProperties, boolean, ab.e):java.lang.Object");
    }

    public static /* synthetic */ Object updateProperties$views_release$default(CropState cropState, CropProperties cropProperties, boolean z10, e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateProperties");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return cropState.updateProperties$views_release(cropProperties, z10, eVar);
    }

    public final Object animateOverlayRectTo$views_release(Rect rect, AnimationSpec<Rect> animationSpec, e<? super k0> eVar) {
        Object objAnimateTo$default = Animatable.animateTo$default(this.animatableRectOverlay, rect, animationSpec, null, null, eVar, 12, null);
        return objAnimateTo$default == bb.b.g() ? objAnimateTo$default : k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x023d  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x01bf, code lost:
    
        if (r1 == r3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0271, code lost:
    
        if (snapZoomTo$views_release(r14, r6) == r3) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateTransformationToOverlayBounds$views_release(androidx.compose.ui.geometry.Rect r26, boolean r27, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r28, ab.e<? super ua.k0> r29) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.state.CropState.animateTransformationToOverlayBounds$views_release(androidx.compose.ui.geometry.Rect, boolean, androidx.compose.animation.core.AnimationSpec, ab.e):java.lang.Object");
    }

    /* JADX INFO: renamed from: getAspectRatio$views_release, reason: from getter */
    public final AspectRatio getAspectRatio() {
        return this.aspectRatio;
    }

    public final Rect getCropRect() {
        return getCropRectangle((int) (getImageSize() >> 32), (int) (getImageSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE), getDrawAreaRect(), this.animatableRectOverlay.getTargetValue());
    }

    /* JADX INFO: renamed from: getFling$views_release, reason: from getter */
    public final boolean getFling() {
        return this.fling;
    }

    public final Rect getOverlayFromAspectRatio$views_release(float containerWidth, float containerHeight, float drawAreaWidth, AspectRatio aspectRatio, float coefficient) {
        y.i(aspectRatio, "aspectRatio");
        if (y.d(aspectRatio, AspectRatio.INSTANCE.getOriginal())) {
            float imageSize = ((int) (getImageSize() >> 32)) / ((int) (getImageSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            float fI = k.i(drawAreaWidth, containerWidth * coefficient);
            float fI2 = k.i(fI / imageSize, coefficient * containerHeight);
            return RectKt.m5666Recttz77jQw(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits((containerHeight - fI2) / 2.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits((containerWidth - fI) / 2.0f) << 32)), Size.m5686constructorimpl((((long) Float.floatToRawIntBits(fI2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fI) << 32)));
        }
        float f10 = containerWidth * coefficient;
        float f11 = coefficient * containerHeight;
        float value = aspectRatio.getValue();
        float f12 = f10 / value;
        if (f12 > f11) {
            f10 = f11 * value;
        } else {
            f11 = f12;
        }
        return RectKt.m5666Recttz77jQw(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits((containerHeight - f11) / 2.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits((containerWidth - f10) / 2.0f) << 32)), Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f10)) << 32) | (((long) Float.floatToRawIntBits(f11)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    /* JADX INFO: renamed from: getOverlayRatio$views_release, reason: from getter */
    public final float getOverlayRatio() {
        return this.overlayRatio;
    }

    public final Rect getOverlayRect() {
        return this.animatableRectOverlay.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TouchRegion getTouchRegion() {
        return (TouchRegion) this.touchRegion.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object init$views_release(e<? super k0> eVar) {
        CropState$init$1 cropState$init$1;
        CropState cropState;
        if (eVar instanceof CropState$init$1) {
            cropState$init$1 = (CropState$init$1) eVar;
            int i10 = cropState$init$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cropState$init$1.label = i10 - Integer.MIN_VALUE;
            } else {
                cropState$init$1 = new CropState$init$1(this, eVar);
            }
        } else {
            cropState$init$1 = new CropState$init$1(this, eVar);
        }
        CropState$init$1 cropState$init$2 = cropState$init$1;
        Object obj = cropState$init$2.result;
        Object objG = bb.b.g();
        int i11 = cropState$init$2.label;
        if (i11 == 0) {
            v.b(obj);
            Rect overlayRect = getOverlayRect();
            cropState$init$2.label = 1;
            cropState = this;
            if (animateTransformationToOverlayBounds$views_release$default(cropState, overlayRect, true, null, cropState$init$2, 4, null) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            cropState = this;
        }
        cropState.initialized = true;
        return k0.f43947a;
    }

    public final boolean isOverlayInImageDrawBounds$views_release() {
        return getDrawAreaRect().getLeft() <= getOverlayRect().getLeft() && getDrawAreaRect().getTop() <= getOverlayRect().getTop() && getDrawAreaRect().getRight() >= getOverlayRect().getRight() && getDrawAreaRect().getBottom() >= getOverlayRect().getBottom();
    }

    public final boolean isRectInContainerBounds$views_release(Rect rect) {
        y.i(rect, "rect");
        return rect.getLeft() >= 0.0f && rect.getRight() <= ((float) ((int) (getContainerSize() >> 32))) && rect.getTop() >= 0.0f && rect.getBottom() <= ((float) ((int) (getContainerSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    /* JADX INFO: renamed from: onDoubleTap-M_7yMNQ$views_release, reason: not valid java name */
    public abstract Object mo10214onDoubleTapM_7yMNQ$views_release(long j10, float f10, lb.a aVar, e<? super k0> eVar);

    public abstract Object onDown$views_release(PointerInputChange pointerInputChange, e<? super k0> eVar);

    /* JADX INFO: renamed from: onGesture-t6rOp4E$views_release, reason: not valid java name */
    public abstract Object mo10215onGesturet6rOp4E$views_release(long j10, long j11, float f10, float f11, PointerInputChange pointerInputChange, List<PointerInputChange> list, e<? super k0> eVar);

    public abstract Object onGestureEnd$views_release(lb.a aVar, e<? super k0> eVar);

    public abstract Object onGestureStart$views_release(e<? super k0> eVar);

    public abstract Object onMove$views_release(List<PointerInputChange> list, e<? super k0> eVar);

    public abstract Object onUp$views_release(PointerInputChange pointerInputChange, e<? super k0> eVar);

    public final void setAspectRatio$views_release(AspectRatio aspectRatio) {
        y.i(aspectRatio, "<set-?>");
        this.aspectRatio = aspectRatio;
    }

    public final void setFling$views_release(boolean z10) {
        this.fling = z10;
    }

    public final void setOverlayRatio$views_release(float f10) {
        this.overlayRatio = f10;
    }

    public final void setTouchRegion(TouchRegion touchRegion) {
        y.i(touchRegion, "<set-?>");
        this.touchRegion.setValue(touchRegion);
    }

    public final Object snapOverlayRectTo$views_release(Rect rect, e<? super k0> eVar) {
        Object objSnapTo = this.animatableRectOverlay.snapTo(rect, eVar);
        return objSnapTo == bb.b.g() ? objSnapTo : k0.f43947a;
    }

    public final Rect updateImageDrawRectFromTransformation$views_release() {
        int containerSize = (int) (getContainerSize() >> 32);
        int containerSize2 = (int) (getContainerSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        int drawAreaSize = (int) (getDrawAreaSize() >> 32);
        int drawAreaSize2 = (int) (getDrawAreaSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        float fFloatValue = getAnimatablePanX$views_release().getTargetValue().floatValue();
        float fFloatValue2 = getAnimatablePanY$views_release().getTargetValue().floatValue();
        int i10 = (containerSize - drawAreaSize) / 2;
        int i11 = (containerSize2 - drawAreaSize2) / 2;
        float fFloatValue3 = getAnimatableZoom$views_release().getTargetValue().floatValue();
        float f10 = drawAreaSize;
        float f11 = f10 * fFloatValue3;
        float f12 = drawAreaSize2;
        float f13 = fFloatValue3 * f12;
        float f14 = 2;
        return RectKt.m5666Recttz77jQw(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits((i11 - ((f13 - f12) / f14)) + fFloatValue2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits((i10 - ((f11 - f10) / f14)) + fFloatValue) << 32)), Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f11)) << 32) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) Float.floatToRawIntBits(f13)))));
    }

    public Object updateProperties$views_release(CropProperties cropProperties, boolean z10, e<? super k0> eVar) {
        return updateProperties$suspendImpl(this, cropProperties, z10, eVar);
    }

    public /* synthetic */ CropState(long j10, long j11, long j12, float f10, boolean z10, AspectRatio aspectRatio, float f11, boolean z11, boolean z12, boolean z13, boolean z14, int i10, p pVar) {
        this(j10, j11, j12, f10, (i10 & 16) != 0 ? true : z10, aspectRatio, f11, (i10 & 128) != 0 ? true : z11, (i10 & 256) != 0 ? true : z12, (i10 & 512) != 0 ? false : z13, (i10 & 1024) != 0 ? false : z14, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private CropState(long j10, long j11, long j12, float f10, boolean z10, AspectRatio aspectRatio, float f11, boolean z11, boolean z12, boolean z13, boolean z14) {
        super(j10, j11, j12, 1.0f, 0.0f, 0.0f, f10, z11, z12, z13, z14, 32, null);
        y.i(aspectRatio, "aspectRatio");
        this.fling = z10;
        this.aspectRatio = aspectRatio;
        this.overlayRatio = f11;
        Rect overlayFromAspectRatio$views_release = getOverlayFromAspectRatio$views_release((int) (j11 >> 32), (int) (j11 & MuxerUtil.UNSIGNED_INT_MAX_VALUE), (int) (j12 >> 32), this.aspectRatio, this.overlayRatio);
        Rect.Companion companion = Rect.INSTANCE;
        this.animatableRectOverlay = new Animatable<>(overlayFromAspectRatio$views_release, VectorConvertersKt.getVectorConverter(companion), null, null, 12, null);
        this.cropRect = companion.getZero();
        this.touchRegion = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TouchRegion.None, null, 2, null);
    }
}
