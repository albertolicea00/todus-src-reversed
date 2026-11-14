package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007HÆ\u0003J/\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0012HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006)"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/CropFrame;", "", "outlineType", "Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;", "editable", "", "cropOutlineContainer", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "<init>", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;ZLcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;)V", "getOutlineType", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;", "getEditable", "()Z", "getCropOutlineContainer", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "outlines", "", "getOutlines", "()Ljava/util/List;", "outlineCount", "getOutlineCount", "addOutline", "outline", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CropFrame {
    public static final int $stable = 0;
    private final CropOutlineContainer<? extends CropOutline> cropOutlineContainer;
    private final boolean editable;
    private final OutlineType outlineType;

    public CropFrame(OutlineType outlineType, boolean z10, CropOutlineContainer<? extends CropOutline> cropOutlineContainer) {
        y.i(outlineType, "outlineType");
        y.i(cropOutlineContainer, "cropOutlineContainer");
        this.outlineType = outlineType;
        this.editable = z10;
        this.cropOutlineContainer = cropOutlineContainer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CropFrame copy$default(CropFrame cropFrame, OutlineType outlineType, boolean z10, CropOutlineContainer cropOutlineContainer, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            outlineType = cropFrame.outlineType;
        }
        if ((i10 & 2) != 0) {
            z10 = cropFrame.editable;
        }
        if ((i10 & 4) != 0) {
            cropOutlineContainer = cropFrame.cropOutlineContainer;
        }
        return cropFrame.copy(outlineType, z10, cropOutlineContainer);
    }

    public final CropFrame addOutline(CropOutline outline) {
        y.i(outline, "outline");
        g0.r1(getOutlines()).add(outline);
        return this;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OutlineType getOutlineType() {
        return this.outlineType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEditable() {
        return this.editable;
    }

    public final CropOutlineContainer<? extends CropOutline> component3() {
        return this.cropOutlineContainer;
    }

    public final CropFrame copy(OutlineType outlineType, boolean editable, CropOutlineContainer<? extends CropOutline> cropOutlineContainer) {
        y.i(outlineType, "outlineType");
        y.i(cropOutlineContainer, "cropOutlineContainer");
        return new CropFrame(outlineType, editable, cropOutlineContainer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropFrame)) {
            return false;
        }
        CropFrame cropFrame = (CropFrame) other;
        return this.outlineType == cropFrame.outlineType && this.editable == cropFrame.editable && y.d(this.cropOutlineContainer, cropFrame.cropOutlineContainer);
    }

    public final CropOutlineContainer<? extends CropOutline> getCropOutlineContainer() {
        return this.cropOutlineContainer;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final int getOutlineCount() {
        return this.cropOutlineContainer.getSize();
    }

    public final OutlineType getOutlineType() {
        return this.outlineType;
    }

    public final List<CropOutline> getOutlines() {
        return this.cropOutlineContainer.getOutlines();
    }

    public final int getSelectedIndex() {
        return this.cropOutlineContainer.getSelectedIndex();
    }

    public int hashCode() {
        return (((this.outlineType.hashCode() * 31) + r.a(this.editable)) * 31) + this.cropOutlineContainer.hashCode();
    }

    public final void setSelectedIndex(int i10) {
        this.cropOutlineContainer.setSelectedIndex(i10);
    }

    public String toString() {
        return "CropFrame(outlineType=" + this.outlineType + ", editable=" + this.editable + ", cropOutlineContainer=" + this.cropOutlineContainer + ")";
    }

    public /* synthetic */ CropFrame(OutlineType outlineType, boolean z10, CropOutlineContainer cropOutlineContainer, int i10, p pVar) {
        this(outlineType, (i10 & 2) != 0 ? false : z10, cropOutlineContainer);
    }
}
