package cu.z17.views.imageEditor.sections.cropper.components.settings;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.graphics.ImageBitmap;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropFrame;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutlineContainer;
import cu.z17.views.imageEditor.sections.cropper.components.model.CustomOutlineContainer;
import cu.z17.views.imageEditor.sections.cropper.components.model.CustomPathOutline;
import cu.z17.views.imageEditor.sections.cropper.components.model.CutCornerCropShape;
import cu.z17.views.imageEditor.sections.cropper.components.model.CutCornerRectOutlineContainer;
import cu.z17.views.imageEditor.sections.cropper.components.model.ImageMaskOutline;
import cu.z17.views.imageEditor.sections.cropper.components.model.ImageMaskOutlineContainer;
import cu.z17.views.imageEditor.sections.cropper.components.model.OutlineType;
import cu.z17.views.imageEditor.sections.cropper.components.model.OvalCropShape;
import cu.z17.views.imageEditor.sections.cropper.components.model.OvalOutlineContainer;
import cu.z17.views.imageEditor.sections.cropper.components.model.PolygonCropShape;
import cu.z17.views.imageEditor.sections.cropper.components.model.PolygonOutlineContainer;
import cu.z17.views.imageEditor.sections.cropper.components.model.PolygonProperties;
import cu.z17.views.imageEditor.sections.cropper.components.model.RectCropShape;
import cu.z17.views.imageEditor.sections.cropper.components.model.RectOutlineContainer;
import cu.z17.views.imageEditor.sections.cropper.components.model.RoundedCornerCropShape;
import cu.z17.views.imageEditor.sections.cropper.components.model.RoundedRectOutlineContainer;
import cu.z17.views.imageEditor.sections.cropper.components.util.ShapeUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import ua.r;
import va.v;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u000bJ\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropFrameFactory;", "", "", "Landroidx/compose/ui/graphics/ImageBitmap;", "defaultImages", "<init>", "(Ljava/util/List;)V", "Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;", "outlineType", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropFrame;", "createDefaultFrame", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;)Lcu/z17/views/imageEditor/sections/cropper/components/model/CropFrame;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "createCropOutlineContainer", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;)Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;", "getCropFrames", "()Ljava/util/List;", "getCropFrame", "cropFrame", "Lua/k0;", "editCropFrame", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/CropFrame;)V", "Ljava/util/List;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "cropFrames", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CropFrameFactory {
    public static final int $stable = 8;
    private final SnapshotStateList<CropFrame> cropFrames;
    private final List<ImageBitmap> defaultImages;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutlineType.values().length];
            try {
                iArr[OutlineType.Rect.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutlineType.RoundedRect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutlineType.CutCorner.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OutlineType.Oval.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OutlineType.Polygon.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OutlineType.Custom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[OutlineType.ImageMask.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CropFrameFactory(List<? extends ImageBitmap> defaultImages) {
        y.i(defaultImages, "defaultImages");
        this.defaultImages = defaultImages;
        this.cropFrames = SnapshotStateKt.mutableStateListOf();
    }

    private final CropOutlineContainer<? extends CropOutline> createCropOutlineContainer(OutlineType outlineType) {
        switch (WhenMappings.$EnumSwitchMapping$0[outlineType.ordinal()]) {
            case 1:
                return new RectOutlineContainer(0, v.e(new RectCropShape(0, "Rect")), 1, null);
            case 2:
                return new RoundedRectOutlineContainer(0, v.e(new RoundedCornerCropShape(0, "Rounded", null, null, 12, null)), 1, null);
            case 3:
                return new CutCornerRectOutlineContainer(0, v.e(new CutCornerCropShape(0, "CutCorner", null, null, 12, null)), 1, null);
            case 4:
                return new OvalOutlineContainer(0, v.e(new OvalCropShape(0, "Oval", null, null, 12, null)), 1, null);
            case 5:
                return new PolygonOutlineContainer(0, w.q(new PolygonCropShape(0, "Polygon", null, null, 12, null), new PolygonCropShape(1, "Pentagon", new PolygonProperties(5, 0.0f, 0L, 4, null), ShapeUtilsKt.createPolygonShape(5, 0.0f)), new PolygonCropShape(2, "Heptagon", new PolygonProperties(7, 0.0f, 0L, 4, null), ShapeUtilsKt.createPolygonShape(7, 0.0f)), new PolygonCropShape(3, "Octagon", new PolygonProperties(8, 0.0f, 0L, 4, null), ShapeUtilsKt.createPolygonShape(8, 0.0f))), 1, null);
            case 6:
                Paths paths = Paths.INSTANCE;
                return new CustomOutlineContainer(0, w.q(new CustomPathOutline(0, "Custom", paths.getFavorite()), new CustomPathOutline(1, "Star", paths.getStar())), 1, null);
            case 7:
                List<ImageBitmap> list = this.defaultImages;
                ArrayList arrayList = new ArrayList(x.y(list, 10));
                int i10 = 0;
                for (Object obj : list) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        w.x();
                    }
                    arrayList.add(new ImageMaskOutline(i10, "ImageMask", (ImageBitmap) obj));
                    i10 = i11;
                }
                return new ImageMaskOutlineContainer(0, arrayList, 1, null);
            default:
                throw new r();
        }
    }

    private final CropFrame createDefaultFrame(OutlineType outlineType) {
        switch (WhenMappings.$EnumSwitchMapping$0[outlineType.ordinal()]) {
            case 1:
                return new CropFrame(outlineType, false, createCropOutlineContainer(outlineType));
            case 2:
                return new CropFrame(outlineType, true, createCropOutlineContainer(outlineType));
            case 3:
                return new CropFrame(outlineType, true, createCropOutlineContainer(outlineType));
            case 4:
                return new CropFrame(outlineType, true, createCropOutlineContainer(outlineType));
            case 5:
                return new CropFrame(outlineType, true, createCropOutlineContainer(outlineType));
            case 6:
                return new CropFrame(outlineType, true, createCropOutlineContainer(outlineType));
            case 7:
                return new CropFrame(outlineType, true, createCropOutlineContainer(outlineType));
            default:
                throw new r();
        }
    }

    public final void editCropFrame(CropFrame cropFrame) {
        y.i(cropFrame, "cropFrame");
        Iterator<CropFrame> it = this.cropFrames.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().getOutlineType() == cropFrame.getOutlineType()) {
                this.cropFrames.set(i10, cropFrame);
            }
            i10++;
        }
        i10 = -1;
        this.cropFrames.set(i10, cropFrame);
    }

    public final CropFrame getCropFrame(OutlineType outlineType) {
        CropFrame next;
        y.i(outlineType, "outlineType");
        Iterator<CropFrame> it = this.cropFrames.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.getOutlineType() != outlineType);
        CropFrame cropFrame = next;
        return cropFrame == null ? createDefaultFrame(outlineType) : cropFrame;
    }

    public final List<CropFrame> getCropFrames() {
        if (this.cropFrames.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (OutlineType outlineType : OutlineType.values()) {
                arrayList.add(getCropFrame(outlineType));
            }
            this.cropFrames.addAll(arrayList);
        }
        return this.cropFrames;
    }
}
