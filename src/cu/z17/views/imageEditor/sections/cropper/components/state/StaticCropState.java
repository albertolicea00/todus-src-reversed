package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputChange;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatio;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.n0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001Bm\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0090@¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u001d\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0090@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0090@¢\u0006\u0004\b\u001e\u0010\u0017JF\u0010(\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0090@¢\u0006\u0004\b&\u0010'J\u0010\u0010+\u001a\u00020\u0015H\u0090@¢\u0006\u0004\b)\u0010*J\u001e\u00100\u001a\u00020\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150,H\u0090@¢\u0006\u0004\b.\u0010/J.\u00106\u001a\u00020\u00152\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00150,H\u0090@¢\u0006\u0004\b4\u00105R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u00069"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/state/StaticCropState;", "Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;", "Landroidx/compose/ui/unit/IntSize;", "imageSize", "containerSize", "drawAreaSize", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "aspectRatio", "", "overlayRatio", "maxZoom", "", "fling", "zoomable", "pannable", "rotatable", "limitPan", "<init>", "(JJJLcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;FFZZZZZLkotlin/jvm/internal/p;)V", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change", "Lua/k0;", "onDown$views_release", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Lab/e;)Ljava/lang/Object;", "onDown", "", "changes", "onMove$views_release", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "onMove", "onUp$views_release", "onUp", "Landroidx/compose/ui/geometry/Offset;", "centroid", "panChange", "zoomChange", "rotationChange", "mainPointer", "onGesture-t6rOp4E$views_release", "(JJFFLandroidx/compose/ui/input/pointer/PointerInputChange;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "onGesture", "onGestureStart$views_release", "(Lab/e;)Ljava/lang/Object;", "onGestureStart", "Lkotlin/Function0;", "onBoundsCalculated", "onGestureEnd$views_release", "(Llb/a;Lab/e;)Ljava/lang/Object;", "onGestureEnd", "offset", "zoom", "onAnimationEnd", "onDoubleTap-M_7yMNQ$views_release", "(JFLlb/a;Lab/e;)Ljava/lang/Object;", "onDoubleTap", "doubleTapped", "Z", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StaticCropState extends CropState {
    public static final int $stable = 0;
    private boolean doubleTapped;

    public /* synthetic */ StaticCropState(long j10, long j11, long j12, AspectRatio aspectRatio, float f10, float f11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, p pVar) {
        this(j10, j11, j12, aspectRatio, f10, f11, z10, z11, z12, z13, z14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onGestureEnd$lambda$0(StaticCropState staticCropState, lb.a aVar) {
        staticCropState.setDrawAreaRect(staticCropState.updateImageDrawRectFromTransformation$views_release());
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    /* JADX INFO: renamed from: onDoubleTap-M_7yMNQ$views_release */
    public Object mo10214onDoubleTapM_7yMNQ$views_release(long j10, float f10, lb.a aVar, e<? super k0> eVar) {
        StaticCropState$onDoubleTap$1 staticCropState$onDoubleTap$1;
        lb.a aVar2;
        long j11;
        StaticCropState$onDoubleTap$1 staticCropState$onDoubleTap$2;
        float f11;
        lb.a aVar3;
        if (eVar instanceof StaticCropState$onDoubleTap$1) {
            staticCropState$onDoubleTap$1 = (StaticCropState$onDoubleTap$1) eVar;
            int i10 = staticCropState$onDoubleTap$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                staticCropState$onDoubleTap$1.label = i10 - Integer.MIN_VALUE;
            } else {
                staticCropState$onDoubleTap$1 = new StaticCropState$onDoubleTap$1(this, eVar);
            }
        } else {
            staticCropState$onDoubleTap$1 = new StaticCropState$onDoubleTap$1(this, eVar);
        }
        StaticCropState$onDoubleTap$1 staticCropState$onDoubleTap$3 = staticCropState$onDoubleTap$1;
        Object obj = staticCropState$onDoubleTap$3.result;
        Object objG = bb.b.g();
        int i11 = staticCropState$onDoubleTap$3.label;
        if (i11 != 0) {
            if (i11 == 1) {
                f11 = staticCropState$onDoubleTap$3.F$0;
                long j12 = staticCropState$onDoubleTap$3.J$0;
                lb.a aVar4 = (lb.a) staticCropState$onDoubleTap$3.L$0;
                v.b(obj);
                aVar2 = aVar4;
                j11 = j12;
                staticCropState$onDoubleTap$2 = staticCropState$onDoubleTap$3;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar3 = (lb.a) staticCropState$onDoubleTap$3.L$0;
                v.b(obj);
            }
            aVar3.invoke();
            return k0.f43947a;
        }
        v.b(obj);
        this.doubleTapped = true;
        if (getFling()) {
            resetTracking$views_release();
        }
        long jM10227getPanF1C5BW0 = m10227getPanF1C5BW0();
        float rotation = getRotation();
        aVar2 = aVar;
        staticCropState$onDoubleTap$3.L$0 = aVar2;
        j11 = j10;
        staticCropState$onDoubleTap$3.J$0 = j11;
        staticCropState$onDoubleTap$3.F$0 = f10;
        staticCropState$onDoubleTap$3.label = 1;
        staticCropState$onDoubleTap$2 = staticCropState$onDoubleTap$3;
        if (TransformState.m10220resetWithAnimationULxng0E$views_release$default(this, jM10227getPanF1C5BW0, f10, rotation, null, staticCropState$onDoubleTap$2, 8, null) != objG) {
            f11 = f10;
        }
        return objG;
        setDrawAreaRect(updateImageDrawRectFromTransformation$views_release());
        Rect overlayRect = getOverlayRect();
        staticCropState$onDoubleTap$2.L$0 = aVar2;
        staticCropState$onDoubleTap$2.J$0 = j11;
        staticCropState$onDoubleTap$2.F$0 = f11;
        staticCropState$onDoubleTap$2.label = 2;
        if (CropState.animateTransformationToOverlayBounds$views_release$default(this, overlayRect, true, null, staticCropState$onDoubleTap$2, 4, null) != objG) {
            aVar3 = aVar2;
            aVar3.invoke();
            return k0.f43947a;
        }
        return objG;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object onDown$views_release(PointerInputChange pointerInputChange, e<? super k0> eVar) {
        return k0.f43947a;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    /* JADX INFO: renamed from: onGesture-t6rOp4E$views_release */
    public Object mo10215onGesturet6rOp4E$views_release(long j10, long j11, float f10, float f11, PointerInputChange pointerInputChange, List<PointerInputChange> list, e<? super k0> eVar) {
        Object objE = n0.e(new StaticCropState$onGesture$2(this, j10, j11, f10, f11, list, pointerInputChange, null), eVar);
        return objE == bb.b.g() ? objE : k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
    
        if (cu.z17.views.imageEditor.sections.cropper.components.state.CropState.animateTransformationToOverlayBounds$views_release$default(r8, r2, true, null, r5, 4, null) == r0) goto L32;
     */
    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object onGestureEnd$views_release(final lb.a r9, ab.e<? super ua.k0> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState$onGestureEnd$1
            if (r0 == 0) goto L14
            r0 = r10
            cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState$onGestureEnd$1 r0 = (cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState$onGestureEnd$1) r0
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
            cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState$onGestureEnd$1 r0 = new cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState$onGestureEnd$1
            r0.<init>(r8, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.result
            java.lang.Object r0 = bb.b.g()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L42
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r9 = r5.L$0
            lb.a r9 = (lb.a) r9
            ua.v.b(r10)
            goto L93
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            java.lang.Object r9 = r5.L$0
            lb.a r9 = (lb.a) r9
            ua.v.b(r10)
            goto L73
        L42:
            ua.v.b(r10)
            boolean r10 = r8.doubleTapped
            if (r10 != 0) goto L96
            boolean r10 = r8.getPannable()
            if (r10 == 0) goto L75
            boolean r10 = r8.getFling()
            if (r10 == 0) goto L75
            float r10 = r8.getZoom()
            r1 = 1065353216(0x3f800000, float:1.0)
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 <= 0) goto L75
            cu.z17.views.imageEditor.sections.cropper.components.state.b r10 = new cu.z17.views.imageEditor.sections.cropper.components.state.b
            r10.<init>()
            java.lang.Object r1 = cb.l.a(r9)
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r10 = r8.fling$views_release(r10, r5)
            if (r10 != r0) goto L73
            goto L92
        L73:
            r10 = r2
            goto L7b
        L75:
            r9.invoke()
            ua.k0 r10 = ua.k0.f43947a
            goto L73
        L7b:
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
            if (r9 != r0) goto L93
        L92:
            return r0
        L93:
            ua.k0 r9 = ua.k0.f43947a
            return r9
        L96:
            ua.k0 r9 = ua.k0.f43947a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState.onGestureEnd$views_release(lb.a, ab.e):java.lang.Object");
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object onGestureStart$views_release(e<? super k0> eVar) {
        Object objE = n0.e(new StaticCropState$onGestureStart$2(null), eVar);
        return objE == bb.b.g() ? objE : k0.f43947a;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object onMove$views_release(List<PointerInputChange> list, e<? super k0> eVar) {
        return k0.f43947a;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.state.CropState
    public Object onUp$views_release(PointerInputChange pointerInputChange, e<? super k0> eVar) {
        return k0.f43947a;
    }

    public /* synthetic */ StaticCropState(long j10, long j11, long j12, AspectRatio aspectRatio, float f10, float f11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, p pVar) {
        this(j10, j11, j12, aspectRatio, f10, (i10 & 32) != 0 ? 5.0f : f11, (i10 & 64) != 0 ? false : z10, (i10 & 128) != 0 ? true : z11, (i10 & 256) != 0 ? true : z12, (i10 & 512) != 0 ? false : z13, (i10 & 1024) != 0 ? false : z14, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private StaticCropState(long j10, long j11, long j12, AspectRatio aspectRatio, float f10, float f11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        super(j10, j11, j12, f11, z10, aspectRatio, f10, z11, z12, z13, z14, null);
        y.i(aspectRatio, "aspectRatio");
    }
}
