package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import cu.z17.views.imageEditor.sections.cropper.components.TouchRegion;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatio;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropProperties;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.n0;
import rb.j;
import rb.k;
import ua.k0;
import ua.v;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B{\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010'\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010$\u001a\u00020#2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010&J'\u0010-\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0002H\u0002¢\u0006\u0004\b+\u0010,J'\u00101\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u001dH\u0002¢\u0006\u0004\b/\u00100J \u00108\u001a\u0002052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\fH\u0090@¢\u0006\u0004\b6\u00107J\u0018\u0010;\u001a\u0002052\u0006\u0010$\u001a\u00020#H\u0090@¢\u0006\u0004\b9\u0010:J\u001e\u0010@\u001a\u0002052\f\u0010=\u001a\b\u0012\u0004\u0012\u00020#0<H\u0090@¢\u0006\u0004\b>\u0010?J\u0018\u0010B\u001a\u0002052\u0006\u0010$\u001a\u00020#H\u0090@¢\u0006\u0004\bA\u0010:JF\u0010J\u001a\u0002052\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00022\u0006\u0010G\u001a\u00020#2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020#0<H\u0090@¢\u0006\u0004\bH\u0010IJ\u0010\u0010M\u001a\u000205H\u0090@¢\u0006\u0004\bK\u0010LJ\u001e\u0010R\u001a\u0002052\f\u0010O\u001a\b\u0012\u0004\u0012\u0002050NH\u0090@¢\u0006\u0004\bP\u0010QJ.\u0010X\u001a\u0002052\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020\u00022\f\u0010U\u001a\b\u0012\u0004\u0012\u0002050NH\u0090@¢\u0006\u0004\bV\u0010WR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010YR\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010ZR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010[R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\\R\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\\R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010]R\u0016\u0010^\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010ZR\u0016\u0010_\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010Z¨\u0006`"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/state/DynamicCropState;", "Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;", "", "handleSize", "Landroidx/compose/ui/unit/IntSize;", "imageSize", "containerSize", "drawAreaSize", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "aspectRatio", "overlayRatio", "maxZoom", "", "fling", "zoomable", "pannable", "rotatable", "limitPan", "fixedAspectRatio", "minDimension", "<init>", "(FJJJLcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;FFZZZZZZLandroidx/compose/ui/unit/IntSize;Lkotlin/jvm/internal/p;)V", "getAspectRatio", "()F", "Landroidx/compose/ui/geometry/Rect;", "rectBounds", "rectCurrent", "calculateOverlayRectInBounds", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/Offset;", "distanceToEdgeFromTouch", "Lcu/z17/views/imageEditor/sections/cropper/components/TouchRegion;", "touchRegion", "rectTemp", "overlayRect", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change", "updateOverlayRect-SDZg_ZE", "(JLcu/z17/views/imageEditor/sections/cropper/components/TouchRegion;JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/input/pointer/PointerInputChange;FZ)Landroidx/compose/ui/geometry/Rect;", "updateOverlayRect", "position", "rect", "threshold", "getTouchRegion-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;F)Lcu/z17/views/imageEditor/sections/cropper/components/TouchRegion;", "getTouchRegion", "touchPosition", "getDistanceToEdgeFromTouch-RE3cj74", "(Lcu/z17/views/imageEditor/sections/cropper/components/TouchRegion;Landroidx/compose/ui/geometry/Rect;J)J", "getDistanceToEdgeFromTouch", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;", "cropProperties", "forceUpdate", "Lua/k0;", "updateProperties$views_release", "(Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;ZLab/e;)Ljava/lang/Object;", "updateProperties", "onDown$views_release", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Lab/e;)Ljava/lang/Object;", "onDown", "", "changes", "onMove$views_release", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "onMove", "onUp$views_release", "onUp", "centroid", "panChange", "zoomChange", "rotationChange", "mainPointer", "onGesture-t6rOp4E$views_release", "(JJFFLandroidx/compose/ui/input/pointer/PointerInputChange;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "onGesture", "onGestureStart$views_release", "(Lab/e;)Ljava/lang/Object;", "onGestureStart", "Lkotlin/Function0;", "onBoundsCalculated", "onGestureEnd$views_release", "(Llb/a;Lab/e;)Ljava/lang/Object;", "onGestureEnd", "offset", "zoom", "onAnimationEnd", "onDoubleTap-M_7yMNQ$views_release", "(JFLlb/a;Lab/e;)Ljava/lang/Object;", "onDoubleTap", "F", "Z", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/geometry/Rect;", "J", "doubleTapped", "gestureInvoked", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DynamicCropState extends CropState {
    public static final int $stable = 0;
    private long distanceToEdgeFromTouch;
    private boolean doubleTapped;
    private final boolean fixedAspectRatio;
    private boolean gestureInvoked;
    private float handleSize;
    private final IntSize minDimension;
    private final Rect rectBounds;
    private Rect rectTemp;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TouchRegion.values().length];
            try {
                iArr[TouchRegion.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchRegion.BottomLeft.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TouchRegion.TopRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TouchRegion.BottomRight.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TouchRegion.Inside.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ DynamicCropState(float f10, long j10, long j11, long j12, AspectRatio aspectRatio, float f11, float f12, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, IntSize intSize, p pVar) {
        this(f10, j10, j11, j12, aspectRatio, f11, f12, z10, z11, z12, z13, z14, z15, intSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect calculateOverlayRectInBounds(Rect rectBounds, Rect rectCurrent) {
        float right = rectCurrent.getRight() - rectCurrent.getLeft();
        float bottom = rectCurrent.getBottom() - rectCurrent.getTop();
        if (right > rectBounds.getRight() - rectBounds.getLeft()) {
            right = rectBounds.getRight() - rectBounds.getLeft();
        }
        if (bottom > rectBounds.getBottom() - rectBounds.getTop()) {
            bottom = rectBounds.getBottom() - rectBounds.getTop();
        }
        Rect rectM5666Recttz77jQw = RectKt.m5666Recttz77jQw(rectCurrent.m5661getTopLeftF1C5BW0(), Size.m5686constructorimpl((((long) Float.floatToRawIntBits(bottom)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(right)) << 32)));
        if (rectM5666Recttz77jQw.getLeft() < rectBounds.getLeft()) {
            rectM5666Recttz77jQw = rectM5666Recttz77jQw.translate(rectBounds.getLeft() - rectM5666Recttz77jQw.getLeft(), 0.0f);
        }
        if (rectM5666Recttz77jQw.getTop() < rectBounds.getTop()) {
            rectM5666Recttz77jQw = rectM5666Recttz77jQw.translate(0.0f, rectBounds.getTop() - rectM5666Recttz77jQw.getTop());
        }
        if (rectM5666Recttz77jQw.getRight() > rectBounds.getRight()) {
            rectM5666Recttz77jQw = rectM5666Recttz77jQw.translate(rectBounds.getRight() - rectM5666Recttz77jQw.getRight(), 0.0f);
        }
        return rectM5666Recttz77jQw.getBottom() > rectBounds.getBottom() ? rectM5666Recttz77jQw.translate(0.0f, rectBounds.getBottom() - rectM5666Recttz77jQw.getBottom()) : rectM5666Recttz77jQw;
    }

    private final float getAspectRatio() {
        return y.d(getAspectRatio(), AspectRatio.INSTANCE.getOriginal()) ? ((int) (getImageSize() >> 32)) / ((int) (getImageSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : getAspectRatio().getValue();
    }

    /* JADX INFO: renamed from: getDistanceToEdgeFromTouch-RE3cj74, reason: not valid java name */
    private final long m10217getDistanceToEdgeFromTouchRE3cj74(TouchRegion touchRegion, Rect rect, long touchPosition) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[touchRegion.ordinal()];
        if (i10 == 1) {
            return Offset.m5630minusMKHz9U(rect.m5661getTopLeftF1C5BW0(), touchPosition);
        }
        if (i10 == 2) {
            return Offset.m5630minusMKHz9U(rect.m5654getBottomLeftF1C5BW0(), touchPosition);
        }
        if (i10 != 3) {
            return i10 != 4 ? Offset.INSTANCE.m5642getZeroF1C5BW0() : Offset.m5630minusMKHz9U(rect.m5655getBottomRightF1C5BW0(), touchPosition);
        }
        return Offset.m5630minusMKHz9U(rect.m5662getTopRightF1C5BW0(), touchPosition);
    }

    /* JADX INFO: renamed from: getTouchRegion-9KIMszo, reason: not valid java name */
    private final TouchRegion m10218getTouchRegion9KIMszo(long position, Rect rect, float threshold) {
        rb.b bVarB = j.b((-threshold) / 2, threshold);
        int i10 = (int) (position >> 32);
        if (bVarB.contains(Float.valueOf(Float.intBitsToFloat(i10) - rect.getLeft())) && bVarB.contains(Float.valueOf(Float.intBitsToFloat((int) (position & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - rect.getTop()))) {
            return TouchRegion.TopLeft;
        }
        if (bVarB.contains(Float.valueOf(rect.getRight() - Float.intBitsToFloat(i10))) && bVarB.contains(Float.valueOf(Float.intBitsToFloat((int) (position & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - rect.getTop()))) {
            return TouchRegion.TopRight;
        }
        if (bVarB.contains(Float.valueOf(rect.getRight() - Float.intBitsToFloat(i10))) && bVarB.contains(Float.valueOf(rect.getBottom() - Float.intBitsToFloat((int) (position & MuxerUtil.UNSIGNED_INT_MAX_VALUE))))) {
            return TouchRegion.BottomRight;
        }
        if (bVarB.contains(Float.valueOf(Float.intBitsToFloat(i10) - rect.getLeft())) && bVarB.contains(Float.valueOf(rect.getBottom() - Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & position))))) {
            return TouchRegion.BottomLeft;
        }
        return rect.m5652containsk4lQ0M(position) ? TouchRegion.Inside : TouchRegion.None;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onGestureEnd$lambda$0(DynamicCropState dynamicCropState, lb.a aVar) {
        dynamicCropState.setDrawAreaRect(dynamicCropState.updateImageDrawRectFromTransformation$views_release());
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: updateOverlayRect-SDZg_ZE, reason: not valid java name */
    private final Rect m10219updateOverlayRectSDZg_ZE(long distanceToEdgeFromTouch, TouchRegion touchRegion, long minDimension, Rect rectTemp, Rect overlayRect, PointerInputChange change, float aspectRatio, boolean fixedAspectRatio) {
        float fI;
        float fD;
        float fI2;
        float fD2;
        long position = change.getPosition();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (position >> 32)) + Float.intBitsToFloat((int) (distanceToEdgeFromTouch >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (position & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) + Float.intBitsToFloat((int) (distanceToEdgeFromTouch & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        int i10 = WhenMappings.$EnumSwitchMapping$0[touchRegion.ordinal()];
        if (i10 == 1) {
            float fI3 = k.i(fIntBitsToFloat, rectTemp.getRight() - ((int) (minDimension >> 32)));
            if (fixedAspectRatio) {
                fI = rectTemp.getBottom() - ((rectTemp.getRight() - fI3) / aspectRatio);
            } else {
                fI = k.i(fIntBitsToFloat2, rectTemp.getBottom() - ((int) (minDimension & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
            }
            return new Rect(fI3, fI, rectTemp.getRight(), rectTemp.getBottom());
        }
        if (i10 == 2) {
            float fI4 = k.i(fIntBitsToFloat, rectTemp.getRight() - ((int) (minDimension >> 32)));
            if (fixedAspectRatio) {
                fD = rectTemp.getTop() + ((rectTemp.getRight() - fI4) / aspectRatio);
            } else {
                fD = k.d(fIntBitsToFloat2, rectTemp.getTop() + ((int) (minDimension & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
            }
            return new Rect(fI4, rectTemp.getTop(), rectTemp.getRight(), fD);
        }
        if (i10 == 3) {
            float fD3 = k.d(fIntBitsToFloat, rectTemp.getLeft() + ((int) (minDimension >> 32)));
            if (fixedAspectRatio) {
                fI2 = rectTemp.getBottom() - ((fD3 - rectTemp.getLeft()) / aspectRatio);
            } else {
                fI2 = k.i(fIntBitsToFloat2, rectTemp.getBottom() - ((int) (minDimension & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
            }
            return new Rect(rectTemp.getLeft(), fI2, fD3, rectTemp.getBottom());
        }
        if (i10 != 4) {
            if (i10 != 5) {
                return overlayRect;
            }
            long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(change);
            return overlayRect.translate(Float.intBitsToFloat((int) (jPositionChangeIgnoreConsumed >> 32)), Float.intBitsToFloat((int) (jPositionChangeIgnoreConsumed & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        }
        float fD4 = k.d(fIntBitsToFloat, rectTemp.getLeft() + ((int) (minDimension >> 32)));
        if (fixedAspectRatio) {
            fD2 = rectTemp.getTop() + ((fD4 - rectTemp.getLeft()) / aspectRatio);
        } else {
            fD2 = k.d(fIntBitsToFloat2, rectTemp.getTop() + ((int) (minDimension & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        }
        return new Rect(rectTemp.getLeft(), rectTemp.getTop(), fD4, fD2);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    /* JADX INFO: renamed from: onDoubleTap-M_7yMNQ$views_release */
    public Object mo10214onDoubleTapM_7yMNQ$views_release(long j10, float f10, lb.a aVar, e<? super k0> eVar) {
        DynamicCropState$onDoubleTap$1 dynamicCropState$onDoubleTap$1;
        lb.a aVar2;
        long j11;
        DynamicCropState$onDoubleTap$1 dynamicCropState$onDoubleTap$2;
        float f11;
        float f12;
        long j12;
        Rect overlayRect;
        lb.a aVar3;
        if (eVar instanceof DynamicCropState$onDoubleTap$1) {
            dynamicCropState$onDoubleTap$1 = (DynamicCropState$onDoubleTap$1) eVar;
            int i10 = dynamicCropState$onDoubleTap$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dynamicCropState$onDoubleTap$1.label = i10 - Integer.MIN_VALUE;
            } else {
                dynamicCropState$onDoubleTap$1 = new DynamicCropState$onDoubleTap$1(this, eVar);
            }
        } else {
            dynamicCropState$onDoubleTap$1 = new DynamicCropState$onDoubleTap$1(this, eVar);
        }
        DynamicCropState$onDoubleTap$1 dynamicCropState$onDoubleTap$3 = dynamicCropState$onDoubleTap$1;
        Object obj = dynamicCropState$onDoubleTap$3.result;
        Object objG = bb.b.g();
        int i11 = dynamicCropState$onDoubleTap$3.label;
        if (i11 == 0) {
            v.b(obj);
            this.doubleTapped = true;
            if (getFling()) {
                resetTracking$views_release();
            }
            long jM10227getPanF1C5BW0 = m10227getPanF1C5BW0();
            float rotation = getRotation();
            aVar2 = aVar;
            dynamicCropState$onDoubleTap$3.L$0 = aVar2;
            j11 = j10;
            dynamicCropState$onDoubleTap$3.J$0 = j11;
            dynamicCropState$onDoubleTap$3.F$0 = f10;
            dynamicCropState$onDoubleTap$3.label = 1;
            dynamicCropState$onDoubleTap$2 = dynamicCropState$onDoubleTap$3;
            if (TransformState.m10220resetWithAnimationULxng0E$views_release$default(this, jM10227getPanF1C5BW0, f10, rotation, null, dynamicCropState$onDoubleTap$2, 8, null) != objG) {
                f11 = f10;
            }
            return objG;
        }
        if (i11 == 1) {
            float f13 = dynamicCropState$onDoubleTap$3.F$0;
            long j13 = dynamicCropState$onDoubleTap$3.J$0;
            lb.a aVar4 = (lb.a) dynamicCropState$onDoubleTap$3.L$0;
            v.b(obj);
            f11 = f13;
            j11 = j13;
            aVar2 = aVar4;
            dynamicCropState$onDoubleTap$2 = dynamicCropState$onDoubleTap$3;
        } else {
            if (i11 == 2) {
                f12 = dynamicCropState$onDoubleTap$3.F$0;
                j12 = dynamicCropState$onDoubleTap$3.J$0;
                lb.a aVar5 = (lb.a) dynamicCropState$onDoubleTap$3.L$0;
                v.b(obj);
                aVar2 = aVar5;
                dynamicCropState$onDoubleTap$2 = dynamicCropState$onDoubleTap$3;
                overlayRect = getOverlayRect();
                dynamicCropState$onDoubleTap$2.L$0 = aVar2;
                dynamicCropState$onDoubleTap$2.J$0 = j12;
                dynamicCropState$onDoubleTap$2.F$0 = f12;
                dynamicCropState$onDoubleTap$2.label = 3;
                if (CropState.animateTransformationToOverlayBounds$views_release$default(this, overlayRect, false, null, dynamicCropState$onDoubleTap$2, 4, null) != objG) {
                    aVar3 = aVar2;
                }
                return objG;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar3 = (lb.a) dynamicCropState$onDoubleTap$3.L$0;
            v.b(obj);
        }
        aVar2 = aVar3;
        aVar2.invoke();
        return k0.f43947a;
        setDrawAreaRect(updateImageDrawRectFromTransformation$views_release());
        if (!isOverlayInImageDrawBounds$views_release()) {
            Rect overlayFromAspectRatio$views_release = getOverlayFromAspectRatio$views_release((int) (getContainerSize() >> 32), (int) (getContainerSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE), (int) (getDrawAreaSize() >> 32), getAspectRatio(), getOverlayRatio());
            dynamicCropState$onDoubleTap$2.L$0 = aVar2;
            dynamicCropState$onDoubleTap$2.J$0 = j11;
            dynamicCropState$onDoubleTap$2.F$0 = f11;
            dynamicCropState$onDoubleTap$2.label = 2;
            if (CropState.animateOverlayRectTo$views_release$default(this, overlayFromAspectRatio$views_release, null, dynamicCropState$onDoubleTap$2, 2, null) != objG) {
                f12 = f11;
                j12 = j11;
                overlayRect = getOverlayRect();
                dynamicCropState$onDoubleTap$2.L$0 = aVar2;
                dynamicCropState$onDoubleTap$2.J$0 = j12;
                dynamicCropState$onDoubleTap$2.F$0 = f12;
                dynamicCropState$onDoubleTap$2.label = 3;
                if (CropState.animateTransformationToOverlayBounds$views_release$default(this, overlayRect, false, null, dynamicCropState$onDoubleTap$2, 4, null) != objG) {
                    aVar3 = aVar2;
                    aVar2 = aVar3;
                }
            }
            return objG;
        }
        aVar2.invoke();
        return k0.f43947a;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object onDown$views_release(PointerInputChange pointerInputChange, e<? super k0> eVar) {
        this.rectTemp = Rect.copy$default(getOverlayRect(), 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        long position = pointerInputChange.getPosition();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (position >> 32));
        long jM5618constructorimpl = Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (position & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
        setTouchRegion(m10218getTouchRegion9KIMszo(jM5618constructorimpl, getOverlayRect(), this.handleSize));
        this.distanceToEdgeFromTouch = m10217getDistanceToEdgeFromTouchRE3cj74(getTouchRegion(), this.rectTemp, jM5618constructorimpl);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    /* JADX INFO: renamed from: onGesture-t6rOp4E$views_release */
    public Object mo10215onGesturet6rOp4E$views_release(long j10, long j11, float f10, float f11, PointerInputChange pointerInputChange, List<PointerInputChange> list, e<? super k0> eVar) {
        DynamicCropState$onGesture$1 dynamicCropState$onGesture$1;
        PointerInputChange pointerInputChange2;
        List<PointerInputChange> list2;
        if (eVar instanceof DynamicCropState$onGesture$1) {
            dynamicCropState$onGesture$1 = (DynamicCropState$onGesture$1) eVar;
            int i10 = dynamicCropState$onGesture$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dynamicCropState$onGesture$1.label = i10 - Integer.MIN_VALUE;
            } else {
                dynamicCropState$onGesture$1 = new DynamicCropState$onGesture$1(this, eVar);
            }
        } else {
            dynamicCropState$onGesture$1 = new DynamicCropState$onGesture$1(this, eVar);
        }
        DynamicCropState$onGesture$1 dynamicCropState$onGesture$2 = dynamicCropState$onGesture$1;
        Object obj = dynamicCropState$onGesture$2.result;
        Object objG = bb.b.g();
        int i11 = dynamicCropState$onGesture$2.label;
        if (i11 == 0) {
            v.b(obj);
            if (getTouchRegion() == TouchRegion.None || this.gestureInvoked) {
                this.doubleTapped = false;
                long jM5642getZeroF1C5BW0 = this.gestureInvoked ? Offset.INSTANCE.m5642getZeroF1C5BW0() : j11;
                dynamicCropState$onGesture$2.L$0 = pointerInputChange;
                dynamicCropState$onGesture$2.L$1 = list;
                dynamicCropState$onGesture$2.J$0 = j10;
                dynamicCropState$onGesture$2.J$1 = j11;
                dynamicCropState$onGesture$2.F$0 = f10;
                dynamicCropState$onGesture$2.F$1 = f11;
                dynamicCropState$onGesture$2.J$2 = jM5642getZeroF1C5BW0;
                dynamicCropState$onGesture$2.label = 1;
                if (m10230updateTransformStateIUXd7x4$views_release(j10, jM5642getZeroF1C5BW0, f10, f11, dynamicCropState$onGesture$2) == objG) {
                    return objG;
                }
                pointerInputChange2 = pointerInputChange;
                list2 = list;
            }
            return k0.f43947a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        list2 = (List) dynamicCropState$onGesture$2.L$1;
        pointerInputChange2 = (PointerInputChange) dynamicCropState$onGesture$2.L$0;
        v.b(obj);
        setDrawAreaRect(updateImageDrawRectFromTransformation$views_release());
        if (getPannable() && getFling() && list2.size() == 1) {
            m10223addPositionUv8p0NA$views_release(pointerInputChange2.getUptimeMillis(), pointerInputChange2.getPosition());
        }
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a1, code lost:
    
        if (cu.z17.views.imageEditor.sections.cropper.components.state.CropState.animateTransformationToOverlayBounds$views_release$default(r8, r2, true, null, r5, 4, null) == r0) goto L38;
     */
    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object onGestureEnd$views_release(final lb.a r9, ab.e<? super ua.k0> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState$onGestureEnd$1
            if (r0 == 0) goto L14
            r0 = r10
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState$onGestureEnd$1 r0 = (cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState$onGestureEnd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState$onGestureEnd$1 r0 = new cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState$onGestureEnd$1
            r0.<init>(r8, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.result
            java.lang.Object r0 = bb.b.g()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L43
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r9 = r5.L$0
            lb.a r9 = (lb.a) r9
            ua.v.b(r10)
            goto La4
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            java.lang.Object r9 = r5.L$0
            lb.a r9 = (lb.a) r9
            ua.v.b(r10)
            goto L84
        L43:
            ua.v.b(r10)
            cu.z17.views.imageEditor.sections.cropper.components.TouchRegion r10 = r8.getTouchRegion()
            cu.z17.views.imageEditor.sections.cropper.components.TouchRegion r1 = cu.z17.views.imageEditor.sections.cropper.components.TouchRegion.None
            if (r10 == r1) goto L52
            boolean r10 = r8.gestureInvoked
            if (r10 == 0) goto La7
        L52:
            boolean r10 = r8.doubleTapped
            if (r10 != 0) goto La7
            boolean r10 = r8.getPannable()
            if (r10 == 0) goto L86
            boolean r10 = r8.getFling()
            if (r10 == 0) goto L86
            boolean r10 = r8.gestureInvoked
            if (r10 != 0) goto L86
            float r10 = r8.getZoom()
            r1 = 1065353216(0x3f800000, float:1.0)
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 <= 0) goto L86
            cu.z17.views.imageEditor.sections.cropper.components.state.a r10 = new cu.z17.views.imageEditor.sections.cropper.components.state.a
            r10.<init>()
            java.lang.Object r1 = cb.l.a(r9)
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r10 = r8.fling$views_release(r10, r5)
            if (r10 != r0) goto L84
            goto La3
        L84:
            r10 = r2
            goto L8c
        L86:
            r9.invoke()
            ua.k0 r10 = ua.k0.f43947a
            goto L84
        L8c:
            androidx.compose.ui.geometry.Rect r2 = r8.getOverlayRect()
            java.lang.Object r9 = cb.l.a(r9)
            r5.L$0 = r9
            r5.label = r10
            r3 = 1
            r4 = 0
            r6 = 4
            r7 = 0
            r1 = r8
            java.lang.Object r9 = cu.z17.views.imageEditor.sections.cropper.components.state.CropState.animateTransformationToOverlayBounds$views_release$default(r1, r2, r3, r4, r5, r6, r7)
            if (r9 != r0) goto La4
        La3:
            return r0
        La4:
            ua.k0 r9 = ua.k0.f43947a
            return r9
        La7:
            ua.k0 r9 = ua.k0.f43947a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState.onGestureEnd$views_release(lb.a, ab.e):java.lang.Object");
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object onGestureStart$views_release(e<? super k0> eVar) {
        return k0.f43947a;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object onMove$views_release(List<PointerInputChange> list, e<? super k0> eVar) {
        if (list.isEmpty()) {
            setTouchRegion(TouchRegion.None);
            return k0.f43947a;
        }
        this.gestureInvoked = list.size() > 1 && getTouchRegion() == TouchRegion.Inside;
        if (getTouchRegion() == TouchRegion.None || list.size() != 1 || this.gestureInvoked) {
            return k0.f43947a;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) g0.w0(list);
        float f10 = this.handleSize * 2;
        long jM8985constructorimpl = IntSize.m8985constructorimpl((((long) nb.c.d(f10)) << 32) | (((long) nb.c.d(f10)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        long j10 = this.distanceToEdgeFromTouch;
        long jM8994unboximpl = jM8985constructorimpl;
        TouchRegion touchRegion = getTouchRegion();
        IntSize intSize = this.minDimension;
        if (intSize != null) {
            jM8994unboximpl = intSize.m8994unboximpl();
        }
        Object objSnapOverlayRectTo$views_release = snapOverlayRectTo$views_release(m10219updateOverlayRectSDZg_ZE(j10, touchRegion, jM8994unboximpl, this.rectTemp, getOverlayRect(), pointerInputChange, getAspectRatio(), this.fixedAspectRatio), eVar);
        return objSnapOverlayRectTo$views_release == bb.b.g() ? objSnapOverlayRectTo$views_release : k0.f43947a;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object onUp$views_release(PointerInputChange pointerInputChange, e<? super k0> eVar) {
        Object objE = n0.e(new DynamicCropState$onUp$2(this, null), eVar);
        return objE == bb.b.g() ? objE : k0.f43947a;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object updateProperties$views_release(CropProperties cropProperties, boolean z10, e<? super k0> eVar) {
        this.handleSize = cropProperties.getHandleSize();
        Object objUpdateProperties$views_release = super.updateProperties$views_release(cropProperties, z10, eVar);
        return objUpdateProperties$views_release == bb.b.g() ? objUpdateProperties$views_release : k0.f43947a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private DynamicCropState(float f10, long j10, long j11, long j12, AspectRatio aspectRatio, float f11, float f12, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, IntSize intSize) {
        super(j10, j11, j12, f12, z10, aspectRatio, f11, z11, z12, z13, z14, null);
        y.i(aspectRatio, "aspectRatio");
        this.handleSize = f10;
        this.fixedAspectRatio = z15;
        this.minDimension = intSize;
        Offset.Companion companion = Offset.INSTANCE;
        this.rectBounds = RectKt.m5666Recttz77jQw(companion.m5642getZeroF1C5BW0(), Size.m5686constructorimpl((((long) Float.floatToRawIntBits((int) (j11 >> 32))) << 32) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) Float.floatToRawIntBits((int) (j11 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))))));
        this.rectTemp = Rect.INSTANCE.getZero();
        this.distanceToEdgeFromTouch = companion.m5642getZeroF1C5BW0();
    }
}
