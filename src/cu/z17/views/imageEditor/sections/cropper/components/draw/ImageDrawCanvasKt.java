package cu.z17.views.imageEditor.sections.cropper.components.draw;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import cu.z17.views.imageEditor.sections.cropper.components.draw.ImageDrawCanvasKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import nb.c;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/ImageBitmap;", "imageBitmap", "", "imageWidth", "imageHeight", "Lua/k0;", "ImageDrawCanvas", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ImageBitmap;IILandroidx/compose/runtime/Composer;I)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageDrawCanvasKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ImageDrawCanvas(final Modifier modifier, final ImageBitmap imageBitmap, final int i10, final int i11, Composer composer, final int i12) {
        int i13;
        y.i(modifier, "modifier");
        y.i(imageBitmap, "imageBitmap");
        Composer composerStartRestartGroup = composer.startRestartGroup(278455024);
        if ((i12 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(imageBitmap) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(i11) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 1171) != 1170, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(278455024, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.draw.ImageDrawCanvas (ImageDrawCanvas.kt:19)");
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(imageBitmap) | ((i13 & 896) == 256) | ((i13 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: g9.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ImageDrawCanvasKt.ImageDrawCanvas$lambda$1$lambda$0(imageBitmap, i10, i11, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composerStartRestartGroup, i13 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: g9.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageDrawCanvasKt.ImageDrawCanvas$lambda$2(modifier, imageBitmap, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageDrawCanvas$lambda$1$lambda$0(ImageBitmap imageBitmap, int i10, int i11, DrawScope Canvas) {
        y.i(Canvas, "$this$Canvas");
        int iD = c.d(Float.intBitsToFloat((int) (Canvas.mo6334getSizeNHjbRc() >> 32)));
        int iD2 = c.d(Float.intBitsToFloat((int) (Canvas.mo6334getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        DrawScope.CC.B(Canvas, imageBitmap, 0L, IntSize.m8985constructorimpl((((long) imageBitmap.getWidth()) << 32) | (((long) imageBitmap.getHeight()) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), IntOffset.m8941constructorimpl((((long) ((iD - i10) / 2)) << 32) | (((long) ((iD2 - i11) / 2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), IntSize.m8985constructorimpl((((long) i10) << 32) | (((long) i11) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f, null, null, 0, 0, 994, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageDrawCanvas$lambda$2(Modifier modifier, ImageBitmap imageBitmap, int i10, int i11, int i12, Composer composer, int i13) {
        ImageDrawCanvas(modifier, imageBitmap, i10, i11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1));
        return k0.f43947a;
    }
}
