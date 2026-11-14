package cu.z17.views.imageEditor.sections.cropper.components.settings;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatio;
import cu.z17.views.imageEditor.sections.cropper.components.theme.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0097\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\b\u001bJI\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020#¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropDefaults;", "", "<init>", "()V", "properties", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;", "cropType", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;", "handleSize", "", "maxZoom", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "cropOutlineProperty", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropOutlineProperty;", "aspectRatio", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "overlayRatio", "pannable", "", "fling", "zoomable", "rotatable", "fixedAspectRatio", "requiredSize", "Landroidx/compose/ui/unit/IntSize;", "minDimension", "properties-7YnJbbk", "style", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropStyle;", "drawOverlay", "drawGrid", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "overlayColor", "Landroidx/compose/ui/graphics/Color;", "handleColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "style-LTESvPY", "(ZZFJJJ)Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropStyle;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CropDefaults {
    public static final int $stable = 0;
    public static final CropDefaults INSTANCE = new CropDefaults();

    private CropDefaults() {
    }

    /* JADX INFO: renamed from: style-LTESvPY$default, reason: not valid java name */
    public static /* synthetic */ CropStyle m10194styleLTESvPY$default(CropDefaults cropDefaults, boolean z10, boolean z11, float f10, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            f10 = Dp.m8823constructorimpl(1);
        }
        if ((i10 & 8) != 0) {
            j10 = ColorKt.getDefaultOverlayColor();
        }
        if ((i10 & 16) != 0) {
            j11 = ColorKt.getDefaultHandleColor();
        }
        if ((i10 & 32) != 0) {
            j12 = ColorKt.getDefaultBackgroundColor();
        }
        return cropDefaults.m10196styleLTESvPY(z10, z11, f10, j10, j11, j12);
    }

    /* JADX INFO: renamed from: properties-7YnJbbk, reason: not valid java name */
    public final CropProperties m10195properties7YnJbbk(CropType cropType, float handleSize, float maxZoom, ContentScale contentScale, CropOutlineProperty cropOutlineProperty, AspectRatio aspectRatio, float overlayRatio, boolean pannable, boolean fling, boolean zoomable, boolean rotatable, boolean fixedAspectRatio, IntSize requiredSize, IntSize minDimension) {
        y.i(cropType, "cropType");
        y.i(contentScale, "contentScale");
        y.i(cropOutlineProperty, "cropOutlineProperty");
        y.i(aspectRatio, "aspectRatio");
        return new CropProperties(cropType, handleSize, contentScale, cropOutlineProperty, aspectRatio, overlayRatio, pannable, fling, rotatable, zoomable, maxZoom, fixedAspectRatio, requiredSize, minDimension, null);
    }

    /* JADX INFO: renamed from: style-LTESvPY, reason: not valid java name */
    public final CropStyle m10196styleLTESvPY(boolean drawOverlay, boolean drawGrid, float strokeWidth, long overlayColor, long handleColor, long backgroundColor) {
        return new CropStyle(drawOverlay, drawGrid, strokeWidth, overlayColor, handleColor, backgroundColor, null, 64, null);
    }
}
