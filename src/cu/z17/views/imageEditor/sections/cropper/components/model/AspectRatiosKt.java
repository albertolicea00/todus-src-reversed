package cu.z17.views.imageEditor.sections.cropper.components.model;

import cu.z17.views.imageEditor.sections.cropper.components.util.ShapeUtilsKt;
import java.util.List;
import kotlin.Metadata;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"aspectRatios", "", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropAspectRatio;", "getAspectRatios", "()Ljava/util/List;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AspectRatiosKt {
    private static final List<CropAspectRatio> aspectRatios;

    static {
        CropAspectRatio cropAspectRatio = new CropAspectRatio("9:16", ShapeUtilsKt.createRectShape(new AspectRatio(0.5625f)), new AspectRatio(0.5625f), null, 8, null);
        CropAspectRatio cropAspectRatio2 = new CropAspectRatio("2:3", ShapeUtilsKt.createRectShape(new AspectRatio(0.6666667f)), new AspectRatio(0.6666667f), null, 8, null);
        AspectRatio.Companion companion = AspectRatio.INSTANCE;
        aspectRatios = w.q(cropAspectRatio, cropAspectRatio2, new CropAspectRatio("Original", ShapeUtilsKt.createRectShape(companion.getOriginal()), companion.getOriginal(), null, 8, null), new CropAspectRatio("1:1", ShapeUtilsKt.createRectShape(new AspectRatio(1.0f)), new AspectRatio(1.0f), null, 8, null), new CropAspectRatio("16:9", ShapeUtilsKt.createRectShape(new AspectRatio(1.7777778f)), new AspectRatio(1.7777778f), null, 8, null), new CropAspectRatio("1.91:1", ShapeUtilsKt.createRectShape(new AspectRatio(1.91f)), new AspectRatio(1.91f), null, 8, null), new CropAspectRatio("3:2", ShapeUtilsKt.createRectShape(new AspectRatio(1.5f)), new AspectRatio(1.5f), null, 8, null), new CropAspectRatio("3:4", ShapeUtilsKt.createRectShape(new AspectRatio(0.75f)), new AspectRatio(0.75f), null, 8, null), new CropAspectRatio("3:5", ShapeUtilsKt.createRectShape(new AspectRatio(0.6f)), new AspectRatio(0.6f), null, 8, null));
    }

    public static final List<CropAspectRatio> getAspectRatios() {
        return aspectRatios;
    }
}
