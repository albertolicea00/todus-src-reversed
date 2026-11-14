package cu.z17.views.imageEditor.sections.cropper.components.state;

import androidx.compose.ui.geometry.Offset;
import androidx.media3.muxer.MuxerUtil;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropData;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"cropData", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropData;", "Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;", "getCropData", "(Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;)Lcu/z17/views/imageEditor/sections/cropper/components/model/CropData;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CropStateImplKt {
    public static final CropData getCropData(CropState cropState) {
        y.i(cropState, "<this>");
        float fFloatValue = cropState.getAnimatableZoom$views_release().getTargetValue().floatValue();
        float fFloatValue2 = cropState.getAnimatablePanX$views_release().getTargetValue().floatValue();
        float fFloatValue3 = cropState.getAnimatablePanY$views_release().getTargetValue().floatValue();
        return new CropData(fFloatValue, Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(fFloatValue2)) << 32) | (((long) Float.floatToRawIntBits(fFloatValue3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), cropState.getAnimatableRotation$views_release().getTargetValue().floatValue(), cropState.getOverlayRect(), cropState.getCropRect(), null);
    }
}
