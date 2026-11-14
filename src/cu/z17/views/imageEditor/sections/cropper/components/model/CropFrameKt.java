package cu.z17.views.imageEditor.sections.cropper.components.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\u001a,\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¨\u0006\t"}, d2 = {"getOutlineContainer", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "outlineType", "Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;", "index", "", "outlines", "", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CropFrameKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutlineType.values().length];
            try {
                iArr[OutlineType.RoundedRect.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutlineType.CutCorner.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutlineType.Oval.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OutlineType.Polygon.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OutlineType.Custom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OutlineType.ImageMask.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final CropOutlineContainer<? extends CropOutline> getOutlineContainer(OutlineType outlineType, int i10, List<? extends CropOutline> outlines) {
        y.i(outlineType, "outlineType");
        y.i(outlines, "outlines");
        switch (WhenMappings.$EnumSwitchMapping$0[outlineType.ordinal()]) {
            case 1:
                return new RoundedRectOutlineContainer(i10, outlines);
            case 2:
                return new CutCornerRectOutlineContainer(i10, outlines);
            case 3:
                return new OvalOutlineContainer(i10, outlines);
            case 4:
                return new PolygonOutlineContainer(i10, outlines);
            case 5:
                return new CustomOutlineContainer(i10, outlines);
            case 6:
                return new ImageMaskOutlineContainer(i10, outlines);
            default:
                return new RectOutlineContainer(i10, outlines);
        }
    }
}
