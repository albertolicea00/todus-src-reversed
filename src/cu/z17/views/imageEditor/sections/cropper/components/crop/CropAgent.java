package cu.z17.views.imageEditor.sections.cropper.components.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropImageMask;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropPath;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropShape;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/crop/CropAgent;", "", "<init>", "()V", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "cropOutline", "Landroidx/compose/ui/geometry/Rect;", "cropRect", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/graphics/ImageBitmap;", "imageToCrop", "Lua/k0;", "drawCroppedImage", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/ImageBitmap;)V", "imageBitmap", "crop", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/geometry/Rect;Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/ImageBitmap;", "croppedImageBitmap", "", "requiredWidth", "requiredHeight", "resize", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/graphics/Paint;", "imagePaint", "Landroidx/compose/ui/graphics/Paint;", "paint", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CropAgent {
    public static final int $stable = 8;
    private final Paint imagePaint;
    private final Paint paint;

    public CropAgent() {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo5747setBlendModes9anfk8(BlendMode.INSTANCE.m5810getSrcIn0nO6VwU());
        this.imagePaint = Paint;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    private final void drawCroppedImage(CropOutline cropOutline, Rect cropRect, LayoutDirection layoutDirection, Density density, ImageBitmap imageToCrop) {
        if (cropOutline instanceof CropShape) {
            Path Path = AndroidPath_androidKt.Path();
            OutlineKt.addOutline(Path, ((CropShape) cropOutline).getShape().mo1261createOutlinePq9zytI(cropRect.m5659getSizeNHjbRc(), layoutDirection, density));
            Canvas Canvas = CanvasKt.Canvas(imageToCrop);
            android.graphics.Rect clipBounds = AndroidCanvas_androidKt.getNativeCanvas(Canvas).getClipBounds();
            y.h(clipBounds, "getClipBounds(...)");
            Canvas.saveLayer(RectHelper_androidKt.toComposeRect(clipBounds), this.imagePaint);
            Canvas.drawPath(Path, this.paint);
            Canvas.mo5725drawImaged4ec7I(imageToCrop, Offset.INSTANCE.m5642getZeroF1C5BW0(), this.imagePaint);
            Canvas.restore();
            return;
        }
        if (!(cropOutline instanceof CropPath)) {
            if (cropOutline instanceof CropImageMask) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(((CropImageMask) cropOutline).getImage()), (int) (cropRect.getRight() - cropRect.getLeft()), (int) (cropRect.getBottom() - cropRect.getTop()), true);
                y.h(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
                ImageBitmap imageBitmapAsImageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(bitmapCreateScaledBitmap);
                Canvas Canvas2 = CanvasKt.Canvas(imageToCrop);
                android.graphics.Rect clipBounds2 = AndroidCanvas_androidKt.getNativeCanvas(Canvas2).getClipBounds();
                y.h(clipBounds2, "getClipBounds(...)");
                Canvas2.saveLayer(RectHelper_androidKt.toComposeRect(clipBounds2), this.imagePaint);
                Offset.Companion companion = Offset.INSTANCE;
                Canvas2.mo5725drawImaged4ec7I(imageBitmapAsImageBitmap, companion.m5642getZeroF1C5BW0(), this.paint);
                Canvas2.mo5725drawImaged4ec7I(imageToCrop, companion.m5642getZeroF1C5BW0(), this.imagePaint);
                Canvas2.restore();
                return;
            }
            return;
        }
        Path Path2 = AndroidPath_androidKt.Path();
        j1.z(Path2, ((CropPath) cropOutline).getPath(), 0L, 2, null);
        long jM5659getSizeNHjbRc = Path2.getBounds().m5659getSizeNHjbRc();
        long jM5659getSizeNHjbRc2 = cropRect.m5659getSizeNHjbRc();
        Matrix matrix = new Matrix();
        matrix.postScale(Float.intBitsToFloat((int) (jM5659getSizeNHjbRc2 >> 32)) / Float.intBitsToFloat((int) (jM5659getSizeNHjbRc >> 32)), (cropRect.getBottom() - cropRect.getTop()) / Float.intBitsToFloat((int) (jM5659getSizeNHjbRc & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        if (!(Path2 instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        ((AndroidPath) Path2).getInternalPath().transform(matrix);
        float left = Path2.getBounds().getLeft();
        Path2.mo5764translatek4lQ0M(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(-Path2.getBounds().getTop())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(-left) << 32)));
        Canvas Canvas3 = CanvasKt.Canvas(imageToCrop);
        android.graphics.Rect clipBounds3 = AndroidCanvas_androidKt.getNativeCanvas(Canvas3).getClipBounds();
        y.h(clipBounds3, "getClipBounds(...)");
        Canvas3.saveLayer(RectHelper_androidKt.toComposeRect(clipBounds3), this.imagePaint);
        Canvas3.drawPath(Path2, this.paint);
        Canvas3.mo5725drawImaged4ec7I(imageToCrop, Offset.INSTANCE.m5642getZeroF1C5BW0(), this.imagePaint);
        Canvas3.restore();
    }

    public final ImageBitmap crop(ImageBitmap imageBitmap, Rect cropRect, CropOutline cropOutline, LayoutDirection layoutDirection, Density density) {
        y.i(imageBitmap, "imageBitmap");
        y.i(cropRect, "cropRect");
        y.i(cropOutline, "cropOutline");
        y.i(layoutDirection, "layoutDirection");
        y.i(density, "density");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), (int) cropRect.getLeft(), (int) cropRect.getTop(), (int) (cropRect.getRight() - cropRect.getLeft()), (int) (cropRect.getBottom() - cropRect.getTop()));
        y.h(bitmapCreateBitmap, "createBitmap(...)");
        Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.ARGB_8888, true);
        y.f(bitmapCopy);
        ImageBitmap imageBitmapAsImageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(bitmapCopy);
        drawCroppedImage(cropOutline, cropRect, layoutDirection, density, imageBitmapAsImageBitmap);
        return imageBitmapAsImageBitmap;
    }

    public final ImageBitmap resize(ImageBitmap croppedImageBitmap, int requiredWidth, int requiredHeight) {
        y.i(croppedImageBitmap, "croppedImageBitmap");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(croppedImageBitmap), requiredWidth, requiredHeight, true);
        y.h(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return AndroidImageBitmap_androidKt.asImageBitmap(bitmapCreateScaledBitmap);
    }
}
