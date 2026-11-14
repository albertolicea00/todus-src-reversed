package cu.z17.views.imageEditor.sections.cropper.components.image;

import android.graphics.Bitmap;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.IntRect;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"getScaledImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "imageWidth", "Landroidx/compose/ui/unit/Dp;", "imageHeight", "rect", "Landroidx/compose/ui/unit/IntRect;", "bitmap", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getScaledImageBitmap-pBklqvs", "(FFLandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/ImageBitmap;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageScopeKt {
    @Composable
    /* JADX INFO: renamed from: getScaledImageBitmap-pBklqvs, reason: not valid java name */
    public static final ImageBitmap m10177getScaledImageBitmappBklqvs(float f10, float f11, IntRect rect, ImageBitmap bitmap, ContentScale contentScale, Composer composer, int i10) {
        y.i(rect, "rect");
        y.i(bitmap, "bitmap");
        y.i(contentScale, "contentScale");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1632631259, i10, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.getScaledImageBitmap (ImageScope.kt:106)");
        }
        boolean zChanged = ((((i10 & 14) ^ 6) > 4 && composer.changed(f10)) || (i10 & 6) == 4) | composer.changed(bitmap) | ((((i10 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(rect)) || (i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i10 & 112) ^ 48) > 32 && composer.changed(f11)) || (i10 & 48) == 32) | ((((57344 & i10) ^ 24576) > 16384 && composer.changed(contentScale)) || (i10 & 24576) == 16384);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(bitmap), rect.getLeft(), rect.getTop(), rect.getWidth(), rect.getHeight());
            y.h(bitmapCreateBitmap, "createBitmap(...)");
            objRememberedValue = AndroidImageBitmap_androidKt.asImageBitmap(bitmapCreateBitmap);
            composer.updateRememberedValue(objRememberedValue);
        }
        ImageBitmap imageBitmap = (ImageBitmap) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return imageBitmap;
    }
}
