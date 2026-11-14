package cu.z17.views.imageEditor.sections.cropper.components.state;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.IntSize;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatio;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropProperties;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"rememberCropState", "Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;", "imageSize", "Landroidx/compose/ui/unit/IntSize;", "containerSize", "drawAreaSize", "cropProperties", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;", "keys", "", "", "rememberCropState-vKe4d9Q", "(JJJLcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CropStateKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CropType.values().length];
            try {
                iArr[CropType.Static.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Composable
    /* JADX INFO: renamed from: rememberCropState-vKe4d9Q, reason: not valid java name */
    public static final CropState m10216rememberCropStatevKe4d9Q(long j10, long j11, long j12, CropProperties cropProperties, Object[] keys, Composer composer, int i10) {
        y.i(cropProperties, "cropProperties");
        y.i(keys, "keys");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(618826356, i10, -1, "cu.z17.views.imageEditor.sections.cropper.components.state.rememberCropState (CropState.kt:27)");
        }
        float handleSize = cropProperties.getHandleSize();
        CropType cropType = cropProperties.getCropType();
        AspectRatio aspectRatio = cropProperties.getAspectRatio();
        float overlayRatio = cropProperties.getOverlayRatio();
        float maxZoom = cropProperties.getMaxZoom();
        boolean fling = cropProperties.getFling();
        boolean zoomable = cropProperties.getZoomable();
        boolean pannable = cropProperties.getPannable();
        boolean rotatable = cropProperties.getRotatable();
        boolean fixedAspectRatio = cropProperties.getFixedAspectRatio();
        IntSize intSizeM10201getMinDimensionbOM6tXw = cropProperties.m10201getMinDimensionbOM6tXw();
        boolean zChanged = false;
        for (Object obj : Arrays.copyOf(keys, keys.length)) {
            zChanged |= composer.changed(obj);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = WhenMappings.$EnumSwitchMapping$0[cropType.ordinal()] == 1 ? new StaticCropState(j10, j11, j12, aspectRatio, overlayRatio, maxZoom, fling, zoomable, pannable, rotatable, false, null) : new DynamicCropState(handleSize, j10, j11, j12, aspectRatio, overlayRatio, maxZoom, fling, zoomable, pannable, rotatable, true, fixedAspectRatio, intSizeM10201getMinDimensionbOM6tXw, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        CropState cropState = (CropState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return cropState;
    }
}
