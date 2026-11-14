package cu.z17.views.imageEditor.sections.cropper.components.settings;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0017\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJV\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b,\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010-\u001a\u0004\b.\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b0\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010/\u001a\u0004\b1\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b2\u0010\u0016R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00103\u001a\u0004\b4\u0010\u001d¨\u00065"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropStyle;", "", "", "drawOverlay", "drawGrid", "Landroidx/compose/ui/unit/Dp;", "strokeWidth", "Landroidx/compose/ui/graphics/Color;", "overlayColor", "handleColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropTheme;", "cropTheme", "<init>", "(ZZFJJJLcu/z17/views/imageEditor/sections/cropper/components/settings/CropTheme;Lkotlin/jvm/internal/p;)V", "component1", "()Z", "component2", "component3-D9Ej5fM", "()F", "component3", "component4-0d7_KjU", "()J", "component4", "component5-0d7_KjU", "component5", "component6-0d7_KjU", "component6", "component7", "()Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropTheme;", "copy-YuHiWx0", "(ZZFJJJLcu/z17/views/imageEditor/sections/cropper/components/settings/CropTheme;)Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropStyle;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDrawOverlay", "getDrawGrid", "F", "getStrokeWidth-D9Ej5fM", "J", "getOverlayColor-0d7_KjU", "getHandleColor-0d7_KjU", "getBackgroundColor-0d7_KjU", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropTheme;", "getCropTheme", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CropStyle {
    public static final int $stable = 0;
    private final long backgroundColor;
    private final CropTheme cropTheme;
    private final boolean drawGrid;
    private final boolean drawOverlay;
    private final long handleColor;
    private final long overlayColor;
    private final float strokeWidth;

    public /* synthetic */ CropStyle(boolean z10, boolean z11, float f10, long j10, long j11, long j12, CropTheme cropTheme, p pVar) {
        this(z10, z11, f10, j10, j11, j12, cropTheme);
    }

    /* JADX INFO: renamed from: copy-YuHiWx0$default, reason: not valid java name */
    public static /* synthetic */ CropStyle m10203copyYuHiWx0$default(CropStyle cropStyle, boolean z10, boolean z11, float f10, long j10, long j11, long j12, CropTheme cropTheme, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = cropStyle.drawOverlay;
        }
        if ((i10 & 2) != 0) {
            z11 = cropStyle.drawGrid;
        }
        if ((i10 & 4) != 0) {
            f10 = cropStyle.strokeWidth;
        }
        if ((i10 & 8) != 0) {
            j10 = cropStyle.overlayColor;
        }
        if ((i10 & 16) != 0) {
            j11 = cropStyle.handleColor;
        }
        if ((i10 & 32) != 0) {
            j12 = cropStyle.backgroundColor;
        }
        if ((i10 & 64) != 0) {
            cropTheme = cropStyle.cropTheme;
        }
        CropTheme cropTheme2 = cropTheme;
        long j13 = j12;
        long j14 = j11;
        float f11 = f10;
        return cropStyle.m10208copyYuHiWx0(z10, z11, f11, j10, j14, j13, cropTheme2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getDrawOverlay() {
        return this.drawOverlay;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getDrawGrid() {
        return this.drawGrid;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getOverlayColor() {
        return this.overlayColor;
    }

    /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name and from getter */
    public final long getHandleColor() {
        return this.handleColor;
    }

    /* JADX INFO: renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final CropTheme getCropTheme() {
        return this.cropTheme;
    }

    /* JADX INFO: renamed from: copy-YuHiWx0, reason: not valid java name */
    public final CropStyle m10208copyYuHiWx0(boolean drawOverlay, boolean drawGrid, float strokeWidth, long overlayColor, long handleColor, long backgroundColor, CropTheme cropTheme) {
        y.i(cropTheme, "cropTheme");
        return new CropStyle(drawOverlay, drawGrid, strokeWidth, overlayColor, handleColor, backgroundColor, cropTheme, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropStyle)) {
            return false;
        }
        CropStyle cropStyle = (CropStyle) other;
        return this.drawOverlay == cropStyle.drawOverlay && this.drawGrid == cropStyle.drawGrid && Dp.m8828equalsimpl0(this.strokeWidth, cropStyle.strokeWidth) && Color.m5867equalsimpl0(this.overlayColor, cropStyle.overlayColor) && Color.m5867equalsimpl0(this.handleColor, cropStyle.handleColor) && Color.m5867equalsimpl0(this.backgroundColor, cropStyle.backgroundColor) && this.cropTheme == cropStyle.cropTheme;
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m10209getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    public final CropTheme getCropTheme() {
        return this.cropTheme;
    }

    public final boolean getDrawGrid() {
        return this.drawGrid;
    }

    public final boolean getDrawOverlay() {
        return this.drawOverlay;
    }

    /* JADX INFO: renamed from: getHandleColor-0d7_KjU, reason: not valid java name */
    public final long m10210getHandleColor0d7_KjU() {
        return this.handleColor;
    }

    /* JADX INFO: renamed from: getOverlayColor-0d7_KjU, reason: not valid java name */
    public final long m10211getOverlayColor0d7_KjU() {
        return this.overlayColor;
    }

    /* JADX INFO: renamed from: getStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m10212getStrokeWidthD9Ej5fM() {
        return this.strokeWidth;
    }

    public int hashCode() {
        return (((((((((((r.a(this.drawOverlay) * 31) + r.a(this.drawGrid)) * 31) + Dp.m8829hashCodeimpl(this.strokeWidth)) * 31) + Color.m5873hashCodeimpl(this.overlayColor)) * 31) + Color.m5873hashCodeimpl(this.handleColor)) * 31) + Color.m5873hashCodeimpl(this.backgroundColor)) * 31) + this.cropTheme.hashCode();
    }

    public String toString() {
        return "CropStyle(drawOverlay=" + this.drawOverlay + ", drawGrid=" + this.drawGrid + ", strokeWidth=" + Dp.m8834toStringimpl(this.strokeWidth) + ", overlayColor=" + Color.m5874toStringimpl(this.overlayColor) + ", handleColor=" + Color.m5874toStringimpl(this.handleColor) + ", backgroundColor=" + Color.m5874toStringimpl(this.backgroundColor) + ", cropTheme=" + this.cropTheme + ")";
    }

    private CropStyle(boolean z10, boolean z11, float f10, long j10, long j11, long j12, CropTheme cropTheme) {
        y.i(cropTheme, "cropTheme");
        this.drawOverlay = z10;
        this.drawGrid = z11;
        this.strokeWidth = f10;
        this.overlayColor = j10;
        this.handleColor = j11;
        this.backgroundColor = j12;
        this.cropTheme = cropTheme;
    }

    public /* synthetic */ CropStyle(boolean z10, boolean z11, float f10, long j10, long j11, long j12, CropTheme cropTheme, int i10, p pVar) {
        this(z10, z11, f10, j10, j11, j12, (i10 & 64) != 0 ? CropTheme.Dark : cropTheme, null);
    }
}
