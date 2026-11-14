package cu.z17.views.imageEditor.sections.cropper.components;

import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"handlesTouched", "", "touchRegion", "Lcu/z17/views/imageEditor/sections/cropper/components/TouchRegion;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TouchRegionKt {
    public static final boolean handlesTouched(TouchRegion touchRegion) {
        y.i(touchRegion, "touchRegion");
        return touchRegion == TouchRegion.TopLeft || touchRegion == TouchRegion.TopRight || touchRegion == TouchRegion.BottomLeft || touchRegion == TouchRegion.BottomRight;
    }
}
