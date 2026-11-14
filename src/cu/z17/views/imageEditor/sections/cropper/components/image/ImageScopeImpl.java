package cu.z17.views.imageEditor.sections.cropper.components.image;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import cu.todus.android.webrtc.sessions.ConstraintsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0017\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JB\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010\u0013R\u001a\u0010\b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b,\u0010\u0013R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b.\u0010\u0018R\u0014\u00100\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0013R\u0014\u00102\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0013R\u0014\u00104\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0013R\u0014\u00106\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0013¨\u00067"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/image/ImageScopeImpl;", "Lcu/z17/views/imageEditor/sections/cropper/components/image/ImageScope;", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/Dp;", "imageWidth", "imageHeight", "Landroidx/compose/ui/unit/IntRect;", "rect", "<init>", "(Landroidx/compose/ui/unit/Density;JFFLandroidx/compose/ui/unit/IntRect;Lkotlin/jvm/internal/p;)V", "component1", "()Landroidx/compose/ui/unit/Density;", "component2-msEJaDk", "()J", "component2", "component3-D9Ej5fM", "()F", "component3", "component4-D9Ej5fM", "component4", "component5", "()Landroidx/compose/ui/unit/IntRect;", "copy-wwAjIV0", "(Landroidx/compose/ui/unit/Density;JFFLandroidx/compose/ui/unit/IntRect;)Lcu/z17/views/imageEditor/sections/cropper/components/image/ImageScopeImpl;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/unit/Density;", "J", "getConstraints-msEJaDk", "F", "getImageWidth-D9Ej5fM", "getImageHeight-D9Ej5fM", "Landroidx/compose/ui/unit/IntRect;", "getRect", "getMinWidth-D9Ej5fM", ConstraintsKeys.KEY_MIN_WIDTH, "getMaxWidth-D9Ej5fM", ConstraintsKeys.KEY_MAX_WIDTH, "getMinHeight-D9Ej5fM", ConstraintsKeys.KEY_MIN_HEIGHT, "getMaxHeight-D9Ej5fM", ConstraintsKeys.KEY_MAX_HEIGHT, "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageScopeImpl implements ImageScope {
    public static final int $stable = 0;
    private final long constraints;
    private final Density density;
    private final float imageHeight;
    private final float imageWidth;
    private final IntRect rect;

    public /* synthetic */ ImageScopeImpl(Density density, long j10, float f10, float f11, IntRect intRect, p pVar) {
        this(density, j10, f10, f11, intRect);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: copy-wwAjIV0$default, reason: not valid java name */
    public static /* synthetic */ ImageScopeImpl m10172copywwAjIV0$default(ImageScopeImpl imageScopeImpl, Density density, long j10, float f10, float f11, IntRect intRect, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            density = imageScopeImpl.density;
        }
        if ((i10 & 2) != 0) {
            j10 = imageScopeImpl.constraints;
        }
        if ((i10 & 4) != 0) {
            f10 = imageScopeImpl.imageWidth;
        }
        if ((i10 & 8) != 0) {
            f11 = imageScopeImpl.imageHeight;
        }
        if ((i10 & 16) != 0) {
            intRect = imageScopeImpl.rect;
        }
        IntRect intRect2 = intRect;
        float f12 = f10;
        return imageScopeImpl.m10176copywwAjIV0(density, j10, f12, f11, intRect2);
    }

    /* JADX INFO: renamed from: component2-msEJaDk, reason: not valid java name and from getter */
    public final long getConstraints() {
        return this.constraints;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getImageWidth() {
        return this.imageWidth;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    public final float getImageHeight() {
        return this.imageHeight;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final IntRect getRect() {
        return this.rect;
    }

    /* JADX INFO: renamed from: copy-wwAjIV0, reason: not valid java name */
    public final ImageScopeImpl m10176copywwAjIV0(Density density, long constraints, float imageWidth, float imageHeight, IntRect rect) {
        y.i(density, "density");
        y.i(rect, "rect");
        return new ImageScopeImpl(density, constraints, imageWidth, imageHeight, rect, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageScopeImpl)) {
            return false;
        }
        ImageScopeImpl imageScopeImpl = (ImageScopeImpl) other;
        return y.d(this.density, imageScopeImpl.density) && Constraints.m8781equalsimpl0(this.constraints, imageScopeImpl.constraints) && Dp.m8828equalsimpl0(this.imageWidth, imageScopeImpl.imageWidth) && Dp.m8828equalsimpl0(this.imageHeight, imageScopeImpl.imageHeight) && y.d(this.rect, imageScopeImpl.rect);
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo10165getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope
    /* JADX INFO: renamed from: getImageHeight-D9Ej5fM */
    public float mo10166getImageHeightD9Ej5fM() {
        return this.imageHeight;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope
    /* JADX INFO: renamed from: getImageWidth-D9Ej5fM */
    public float mo10167getImageWidthD9Ej5fM() {
        return this.imageWidth;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope
    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM */
    public float mo10168getMaxHeightD9Ej5fM() {
        return Constraints.m8783getHasBoundedHeightimpl(mo10165getConstraintsmsEJaDk()) ? this.density.mo1342toDpu2uoSUM(Constraints.m8787getMaxHeightimpl(mo10165getConstraintsmsEJaDk())) : Dp.INSTANCE.m8842getInfinityD9Ej5fM();
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope
    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM */
    public float mo10169getMaxWidthD9Ej5fM() {
        return Constraints.m8784getHasBoundedWidthimpl(mo10165getConstraintsmsEJaDk()) ? this.density.mo1342toDpu2uoSUM(Constraints.m8788getMaxWidthimpl(mo10165getConstraintsmsEJaDk())) : Dp.INSTANCE.m8842getInfinityD9Ej5fM();
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope
    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM */
    public float mo10170getMinHeightD9Ej5fM() {
        return this.density.mo1342toDpu2uoSUM(Constraints.m8789getMinHeightimpl(mo10165getConstraintsmsEJaDk()));
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope
    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM */
    public float mo10171getMinWidthD9Ej5fM() {
        return this.density.mo1342toDpu2uoSUM(Constraints.m8790getMinWidthimpl(mo10165getConstraintsmsEJaDk()));
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope
    public IntRect getRect() {
        return this.rect;
    }

    public int hashCode() {
        return (((((((this.density.hashCode() * 31) + Constraints.m8791hashCodeimpl(this.constraints)) * 31) + Dp.m8829hashCodeimpl(this.imageWidth)) * 31) + Dp.m8829hashCodeimpl(this.imageHeight)) * 31) + this.rect.hashCode();
    }

    public String toString() {
        return "ImageScopeImpl(density=" + this.density + ", constraints=" + Constraints.m8793toStringimpl(this.constraints) + ", imageWidth=" + Dp.m8834toStringimpl(this.imageWidth) + ", imageHeight=" + Dp.m8834toStringimpl(this.imageHeight) + ", rect=" + this.rect + ")";
    }

    private ImageScopeImpl(Density density, long j10, float f10, float f11, IntRect rect) {
        y.i(density, "density");
        y.i(rect, "rect");
        this.density = density;
        this.constraints = j10;
        this.imageWidth = f10;
        this.imageHeight = f11;
        this.rect = rect;
    }
}
