package cu.z17.views.imageEditor.sections.cropper.components.draw;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.imageEditor.sections.cropper.components.draw.OverlayKt;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropImageMask;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropPath;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropShape;
import cu.z17.views.imageEditor.sections.cropper.components.util.DrawScopeUtilsKt;
import cu.z17.views.imageEditor.sections.cropper.components.util.ShapeUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.o;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u008f\u0001\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0097\u0001\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0097\u0001\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0003¢\u0006\u0004\b\u001d\u0010!\u001a\u0097\u0001\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\"2&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0003¢\u0006\u0004\b\u001d\u0010$\u001a\u009f\u0001\u0010\u0003\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140%H\u0002¢\u0006\u0004\b'\u0010(\u001a-\u0010.\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-\u001a%\u00101\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b/\u00100\u001a%\u00104\u001a\u00020\u0014*\u00020\u00132\u0006\u0010 \u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b2\u00103\u001a#\u00105\u001a\u00020\u0014*\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b5\u00106¨\u00067"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "drawOverlay", "Landroidx/compose/ui/geometry/Rect;", "rect", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "cropOutline", "drawGrid", "Landroidx/compose/ui/graphics/Color;", "transparentColor", "overlayColor", "handleColor", "Landroidx/compose/ui/unit/Dp;", "strokeWidth", "drawHandles", "", "handleSize", "Lkotlin/Function4;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lua/k0;", "onDrawGrid", "DrawingOverlay-MWhGqBo", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/geometry/Rect;Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;ZJJJFZFLlb/o;Landroidx/compose/runtime/Composer;II)V", "DrawingOverlay", "Landroidx/compose/ui/graphics/Path;", "pathHandles", "Landroidx/compose/ui/graphics/Outline;", "outline", "DrawingOverlayImpl-rwpMyLU", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/geometry/Rect;ZJJJFZFLandroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Outline;Llb/o;Landroidx/compose/runtime/Composer;II)V", "DrawingOverlayImpl", "path", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/geometry/Rect;ZJJJFZFLandroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;Llb/o;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/geometry/Rect;ZJJJFZFLandroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/ImageBitmap;Llb/o;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function1;", "drawBlock", "drawOverlay-EoZNMKA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;ZLandroidx/compose/ui/geometry/Rect;ZJJJFZFLandroidx/compose/ui/graphics/Path;Llb/o;Lkotlin/jvm/functions/Function1;)V", "imageBitmap", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "drawCropImage-5GE6KzY", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/graphics/ImageBitmap;I)V", "drawCropImage", "drawCropOutline-7EN7VTw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;I)V", "drawCropOutline", "drawCropPath-7EN7VTw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;I)V", "drawCropPath", "updateHandlePath", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;F)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OverlayKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: DrawingOverlay-MWhGqBo, reason: not valid java name */
    public static final void m10153DrawingOverlayMWhGqBo(final Modifier modifier, final boolean z10, final Rect rect, final CropOutline cropOutline, final boolean z11, final long j10, final long j11, final long j12, final float f10, final boolean z12, final float f11, final o oVar, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z13;
        boolean z14;
        int i13;
        Composer composer2;
        y.i(modifier, "modifier");
        y.i(rect, "rect");
        y.i(cropOutline, "cropOutline");
        Composer composerStartRestartGroup = composer.startRestartGroup(88687481);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            z13 = z10;
            i12 |= composerStartRestartGroup.changed(z13) ? 32 : 16;
        } else {
            z13 = z10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(rect) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= (i10 & 4096) == 0 ? composerStartRestartGroup.changed(cropOutline) : composerStartRestartGroup.changedInstance(cropOutline) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            z14 = z11;
            i12 |= composerStartRestartGroup.changed(z14) ? 16384 : 8192;
        } else {
            z14 = z11;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changed(j11) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i12 |= composerStartRestartGroup.changed(j12) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i12 |= composerStartRestartGroup.changed(f10) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i12 |= composerStartRestartGroup.changed(z12) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i11 & 6) == 0) {
            i13 = i11 | (composerStartRestartGroup.changed(f11) ? 4 : 2);
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(oVar) ? 32 : 16;
        }
        int i14 = i13;
        if (composerStartRestartGroup.shouldExecute(((i12 & 306783379) == 306783378 && (i14 & 19) == 18) ? false : true, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(88687481, i12, i14, "cu.z17.views.imageEditor.sections.cropper.components.draw.DrawingOverlay (Overlay.kt:42)");
            }
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            float fMo1345toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1345toPx0680j_4(f10);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = AndroidPath_androidKt.Path();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Path path = (Path) objRememberedValue;
            if (cropOutline instanceof CropShape) {
                composerStartRestartGroup.startReplaceGroup(684562172);
                CropShape cropShape = (CropShape) cropOutline;
                boolean zChanged = ((i12 & 896) == 256) | composerStartRestartGroup.changed(cropShape);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = cropShape.getShape().mo1261createOutlinePq9zytI(rect.m5659getSizeNHjbRc(), layoutDirection, density);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                int i15 = i12 >> 3;
                m10155DrawingOverlayImplrwpMyLU(modifier, z13, rect, z14, j10, j11, j12, fMo1345toPx0680j_4, z12, f11, path, (Outline) objRememberedValue2, oVar, composerStartRestartGroup, (i12 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (i15 & 7168) | (i15 & 57344) | (i15 & 458752) | (i15 & 3670016) | (i15 & 234881024) | ((i14 << 27) & C.ENCODING_PCM_DOUBLE), (i14 << 3) & 896);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                if (cropOutline instanceof CropPath) {
                    composer2.startReplaceGroup(685331096);
                    CropPath cropPath = (CropPath) cropOutline;
                    boolean zChanged2 = ((i12 & 896) == 256) | composer2.changed(cropPath);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                        Path Path = AndroidPath_androidKt.Path();
                        j1.z(Path, cropPath.getPath(), 0L, 2, null);
                        ShapeUtilsKt.scaleAndTranslatePath(Path, rect.getRight() - rect.getLeft(), rect.getBottom() - rect.getTop());
                        composer2.updateRememberedValue(Path);
                        objRememberedValue3 = Path;
                    }
                    int i16 = i12 >> 3;
                    m10156DrawingOverlayImplrwpMyLU(modifier, z10, rect, z11, j10, j11, j12, fMo1345toPx0680j_4, z12, f11, path, (Path) objRememberedValue3, oVar, composer2, (i12 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (i16 & 7168) | (i16 & 57344) | (i16 & 458752) | (i16 & 3670016) | (i16 & 234881024) | ((i14 << 27) & C.ENCODING_PCM_DOUBLE), (i14 << 3) & 896);
                    composer2 = composer2;
                    composer2.endReplaceGroup();
                } else {
                    if (cropOutline instanceof CropImageMask) {
                        composer2.startReplaceGroup(686164934);
                        int i17 = i12 >> 3;
                        m10154DrawingOverlayImplrwpMyLU(modifier, z10, rect, z11, j10, j11, j12, fMo1345toPx0680j_4, z12, f11, path, ((CropImageMask) cropOutline).getImage(), oVar, composer2, (i12 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (i17 & 7168) | (i17 & 57344) | (i17 & 458752) | (i17 & 3670016) | (i17 & 234881024) | ((i14 << 27) & C.ENCODING_PCM_DOUBLE), (i14 << 3) & 896);
                        composer2 = composer2;
                    } else {
                        composer2.startReplaceGroup(682494441);
                    }
                    composer2.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: g9.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverlayKt.DrawingOverlay_MWhGqBo$lambda$5(modifier, z10, rect, cropOutline, z11, j10, j11, j12, f10, z12, f11, oVar, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: DrawingOverlayImpl-rwpMyLU, reason: not valid java name */
    private static final void m10155DrawingOverlayImplrwpMyLU(final Modifier modifier, final boolean z10, final Rect rect, final boolean z11, final long j10, final long j11, final long j12, final float f10, final boolean z12, final float f11, final Path path, final Outline outline, final o oVar, Composer composer, final int i10, final int i11) {
        int i12;
        Rect rect2;
        boolean z13;
        int i13;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-944051540);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            rect2 = rect;
            i12 |= composerStartRestartGroup.changed(rect2) ? 256 : 128;
        } else {
            rect2 = rect;
        }
        if ((i10 & 3072) == 0) {
            z13 = z11;
            i12 |= composerStartRestartGroup.changed(z13) ? 2048 : 1024;
        } else {
            z13 = z11;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i12 |= composerStartRestartGroup.changed(j11) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changed(j12) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i12 |= composerStartRestartGroup.changed(f10) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i12 |= composerStartRestartGroup.changed(z12) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i12 |= composerStartRestartGroup.changed(f11) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i11 & 6) == 0) {
            i13 = i11 | (composerStartRestartGroup.changedInstance(path) ? 4 : 2);
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(outline) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(oVar) ? 256 : 128;
        }
        int i14 = i13;
        if (composerStartRestartGroup.shouldExecute(((i12 & 306783379) == 306783378 && (i14 & 147) == 146) ? false : true, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-944051540, i12, i14, "cu.z17.views.imageEditor.sections.cropper.components.draw.DrawingOverlayImpl (Overlay.kt:137)");
            }
            boolean zChangedInstance = ((i12 & 112) == 32) | ((i12 & 896) == 256) | ((i12 & 7168) == 2048) | ((57344 & i12) == 16384) | ((458752 & i12) == 131072) | ((3670016 & i12) == 1048576) | ((29360128 & i12) == 8388608) | ((234881024 & i12) == 67108864) | ((1879048192 & i12) == 536870912) | composerStartRestartGroup.changedInstance(path) | ((i14 & 896) == 256) | composerStartRestartGroup.changedInstance(outline);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                final boolean z14 = z13;
                final Rect rect3 = rect2;
                objRememberedValue = new Function1() { // from class: g9.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$8$lambda$7(z10, rect3, z14, j10, j11, j12, f10, z12, f11, path, oVar, outline, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                composer2 = composerStartRestartGroup;
            }
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composer2, i12 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: g9.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$9(modifier, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, outline, oVar, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$12$lambda$11(boolean z10, Rect rect, boolean z11, long j10, long j11, long j12, float f10, boolean z12, float f11, Path path, o oVar, final Path path2, DrawScope Canvas) {
        y.i(Canvas, "$this$Canvas");
        m10163drawOverlayEoZNMKA(Canvas, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, oVar, new Function1() { // from class: g9.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$12$lambda$11$lambda$10(path2, (DrawScope) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$12$lambda$11$lambda$10(Path path, DrawScope drawOverlay) {
        y.i(drawOverlay, "$this$drawOverlay");
        m10162drawCropPath7EN7VTw$default(drawOverlay, path, 0, 2, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$13(Modifier modifier, boolean z10, Rect rect, boolean z11, long j10, long j11, long j12, float f10, boolean z12, float f11, Path path, Path path2, o oVar, int i10, int i11, Composer composer, int i12) {
        m10156DrawingOverlayImplrwpMyLU(modifier, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, path2, oVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$16$lambda$15(boolean z10, final Rect rect, boolean z11, long j10, long j11, long j12, float f10, boolean z12, float f11, Path path, o oVar, final ImageBitmap imageBitmap, DrawScope Canvas) {
        y.i(Canvas, "$this$Canvas");
        m10163drawOverlayEoZNMKA(Canvas, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, oVar, new Function1() { // from class: g9.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$16$lambda$15$lambda$14(rect, imageBitmap, (DrawScope) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$16$lambda$15$lambda$14(Rect rect, ImageBitmap imageBitmap, DrawScope drawOverlay) {
        y.i(drawOverlay, "$this$drawOverlay");
        m10158drawCropImage5GE6KzY$default(drawOverlay, rect, imageBitmap, 0, 4, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$17(Modifier modifier, boolean z10, Rect rect, boolean z11, long j10, long j11, long j12, float f10, boolean z12, float f11, Path path, ImageBitmap imageBitmap, o oVar, int i10, int i11, Composer composer, int i12) {
        m10154DrawingOverlayImplrwpMyLU(modifier, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, imageBitmap, oVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$8$lambda$7(boolean z10, Rect rect, boolean z11, long j10, long j11, long j12, float f10, boolean z12, float f11, Path path, o oVar, final Outline outline, DrawScope Canvas) {
        y.i(Canvas, "$this$Canvas");
        m10163drawOverlayEoZNMKA(Canvas, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, oVar, new Function1() { // from class: g9.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$8$lambda$7$lambda$6(outline, (DrawScope) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$8$lambda$7$lambda$6(Outline outline, DrawScope drawOverlay) {
        y.i(drawOverlay, "$this$drawOverlay");
        m10160drawCropOutline7EN7VTw$default(drawOverlay, outline, 0, 2, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlayImpl_rwpMyLU$lambda$9(Modifier modifier, boolean z10, Rect rect, boolean z11, long j10, long j11, long j12, float f10, boolean z12, float f11, Path path, Outline outline, o oVar, int i10, int i11, Composer composer, int i12) {
        m10155DrawingOverlayImplrwpMyLU(modifier, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, outline, oVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawingOverlay_MWhGqBo$lambda$5(Modifier modifier, boolean z10, Rect rect, CropOutline cropOutline, boolean z11, long j10, long j11, long j12, float f10, boolean z12, float f11, o oVar, int i10, int i11, Composer composer, int i12) {
        m10153DrawingOverlayMWhGqBo(modifier, z10, rect, cropOutline, z11, j10, j11, j12, f10, z12, f11, oVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11));
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: drawCropImage-5GE6KzY, reason: not valid java name */
    private static final void m10157drawCropImage5GE6KzY(DrawScope drawScope, Rect rect, ImageBitmap imageBitmap, int i10) {
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (rect.m5659getSizeNHjbRc() >> 32));
        long j10 = ((long) iIntBitsToFloat) << 32;
        DrawScope.CC.B(drawScope, imageBitmap, 0L, 0L, 0L, IntSize.m8985constructorimpl((((long) ((int) Float.intBitsToFloat((int) (rect.m5659getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | j10), 0.0f, null, null, i10, 0, 750, null);
    }

    /* JADX INFO: renamed from: drawCropImage-5GE6KzY$default, reason: not valid java name */
    public static /* synthetic */ void m10158drawCropImage5GE6KzY$default(DrawScope drawScope, Rect rect, ImageBitmap imageBitmap, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = BlendMode.INSTANCE.m5794getDstOut0nO6VwU();
        }
        m10157drawCropImage5GE6KzY(drawScope, rect, imageBitmap, i10);
    }

    /* JADX INFO: renamed from: drawCropOutline-7EN7VTw, reason: not valid java name */
    private static final void m10159drawCropOutline7EN7VTw(DrawScope drawScope, Outline outline, int i10) {
        OutlineKt.m6118drawOutlinewDX37Ww$default(drawScope, outline, Color.INSTANCE.m5901getTransparent0d7_KjU(), 0.0f, null, null, i10, 28, null);
    }

    /* JADX INFO: renamed from: drawCropOutline-7EN7VTw$default, reason: not valid java name */
    public static /* synthetic */ void m10160drawCropOutline7EN7VTw$default(DrawScope drawScope, Outline outline, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = BlendMode.INSTANCE.m5811getSrcOut0nO6VwU();
        }
        m10159drawCropOutline7EN7VTw(drawScope, outline, i10);
    }

    /* JADX INFO: renamed from: drawCropPath-7EN7VTw, reason: not valid java name */
    private static final void m10161drawCropPath7EN7VTw(DrawScope drawScope, Path path, int i10) {
        DrawScope.CC.I(drawScope, path, Color.INSTANCE.m5901getTransparent0d7_KjU(), 0.0f, null, null, i10, 28, null);
    }

    /* JADX INFO: renamed from: drawCropPath-7EN7VTw$default, reason: not valid java name */
    public static /* synthetic */ void m10162drawCropPath7EN7VTw$default(DrawScope drawScope, Path path, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = BlendMode.INSTANCE.m5811getSrcOut0nO6VwU();
        }
        m10161drawCropPath7EN7VTw(drawScope, path, i10);
    }

    /* JADX INFO: renamed from: drawOverlay-EoZNMKA, reason: not valid java name */
    private static final void m10163drawOverlayEoZNMKA(DrawScope drawScope, boolean z10, final Rect rect, final boolean z11, final long j10, final long j11, long j12, final float f10, boolean z12, float f11, Path path, final o oVar, final Function1 function1) {
        DrawScopeUtilsKt.drawWithLayer(drawScope, new Function1() { // from class: g9.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OverlayKt.drawOverlay_EoZNMKA$lambda$19(j10, rect, z11, oVar, f10, j11, function1, (DrawScope) obj);
            }
        });
        if (z10) {
            DrawScope.CC.M(drawScope, j11, rect.m5661getTopLeftF1C5BW0(), rect.m5659getSizeNHjbRc(), 0.0f, new Stroke(f10, 0.0f, 0, 0, null, 30, null), null, 0, LocationRequestCompat.QUALITY_LOW_POWER, null);
            if (z12) {
                path.reset();
                updateHandlePath(path, rect, f11);
                DrawScope.CC.I(drawScope, path, j12, 0.0f, new Stroke(f10 * 2, 0.0f, StrokeCap.INSTANCE.m6218getRoundKaPHkGw(), StrokeJoin.INSTANCE.m6229getRoundLxFBmk8(), null, 18, null), null, 0, 52, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 drawOverlay_EoZNMKA$lambda$19(long j10, Rect rect, boolean z10, o oVar, float f10, long j11, Function1 function1, DrawScope drawWithLayer) {
        y.i(drawWithLayer, "$this$drawWithLayer");
        DrawScope.CC.M(drawWithLayer, j10, 0L, 0L, 0.0f, null, null, 0, 126, null);
        float left = rect.getLeft();
        float top = rect.getTop();
        drawWithLayer.getDrawContext().getTransform().translate(left, top);
        try {
            function1.invoke(drawWithLayer);
            drawWithLayer.getDrawContext().getTransform().translate(-left, -top);
            if (z10) {
                if (oVar != null) {
                    oVar.invoke(drawWithLayer, rect, Float.valueOf(f10), Color.m5856boximpl(j11));
                } else {
                    DrawScopeUtilsKt.m10231drawGridg2O1Hgs(drawWithLayer, rect, f10, j11);
                }
            }
            return k0.f43947a;
        } catch (Throwable th2) {
            drawWithLayer.getDrawContext().getTransform().translate(-left, -top);
            throw th2;
        }
    }

    private static final void updateHandlePath(Path path, Rect rect, float f10) {
        if (y.d(rect, Rect.INSTANCE.getZero())) {
            return;
        }
        path.moveTo(Float.intBitsToFloat((int) (rect.m5661getTopLeftF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5661getTopLeftF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) + f10);
        path.lineTo(Float.intBitsToFloat((int) (rect.m5661getTopLeftF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5661getTopLeftF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        path.lineTo(Float.intBitsToFloat((int) (rect.m5661getTopLeftF1C5BW0() >> 32)) + f10, Float.intBitsToFloat((int) (rect.m5661getTopLeftF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        path.moveTo(Float.intBitsToFloat((int) (rect.m5662getTopRightF1C5BW0() >> 32)) - f10, Float.intBitsToFloat((int) (rect.m5662getTopRightF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        path.lineTo(Float.intBitsToFloat((int) (rect.m5662getTopRightF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5662getTopRightF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        path.lineTo(Float.intBitsToFloat((int) (rect.m5662getTopRightF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5662getTopRightF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) + f10);
        path.moveTo(Float.intBitsToFloat((int) (rect.m5655getBottomRightF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5655getBottomRightF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - f10);
        path.lineTo(Float.intBitsToFloat((int) (rect.m5655getBottomRightF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5655getBottomRightF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        path.lineTo(Float.intBitsToFloat((int) (rect.m5655getBottomRightF1C5BW0() >> 32)) - f10, Float.intBitsToFloat((int) (rect.m5655getBottomRightF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        path.moveTo(Float.intBitsToFloat((int) (rect.m5654getBottomLeftF1C5BW0() >> 32)) + f10, Float.intBitsToFloat((int) (rect.m5654getBottomLeftF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        path.lineTo(Float.intBitsToFloat((int) (rect.m5654getBottomLeftF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5654getBottomLeftF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        path.lineTo(Float.intBitsToFloat((int) (rect.m5654getBottomLeftF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5654getBottomLeftF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - f10);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: DrawingOverlayImpl-rwpMyLU, reason: not valid java name */
    private static final void m10156DrawingOverlayImplrwpMyLU(final Modifier modifier, final boolean z10, final Rect rect, final boolean z11, final long j10, final long j11, final long j12, final float f10, final boolean z12, final float f11, final Path path, final Path path2, final o oVar, Composer composer, final int i10, final int i11) {
        int i12;
        Rect rect2;
        boolean z13;
        int i13;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2062979311);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            rect2 = rect;
            i12 |= composerStartRestartGroup.changed(rect2) ? 256 : 128;
        } else {
            rect2 = rect;
        }
        if ((i10 & 3072) == 0) {
            z13 = z11;
            i12 |= composerStartRestartGroup.changed(z13) ? 2048 : 1024;
        } else {
            z13 = z11;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i12 |= composerStartRestartGroup.changed(j11) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changed(j12) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i12 |= composerStartRestartGroup.changed(f10) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i12 |= composerStartRestartGroup.changed(z12) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i12 |= composerStartRestartGroup.changed(f11) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i11 & 6) == 0) {
            i13 = i11 | (composerStartRestartGroup.changedInstance(path) ? 4 : 2);
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(path2) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(oVar) ? 256 : 128;
        }
        int i14 = i13;
        if (composerStartRestartGroup.shouldExecute(((i12 & 306783379) == 306783378 && (i14 & 147) == 146) ? false : true, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2062979311, i12, i14, "cu.z17.views.imageEditor.sections.cropper.components.draw.DrawingOverlayImpl (Overlay.kt:172)");
            }
            boolean zChangedInstance = ((i12 & 112) == 32) | ((i12 & 896) == 256) | ((i12 & 7168) == 2048) | ((57344 & i12) == 16384) | ((458752 & i12) == 131072) | ((3670016 & i12) == 1048576) | ((29360128 & i12) == 8388608) | ((234881024 & i12) == 67108864) | ((1879048192 & i12) == 536870912) | composerStartRestartGroup.changedInstance(path) | ((i14 & 896) == 256) | composerStartRestartGroup.changedInstance(path2);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                final boolean z14 = z13;
                final Rect rect3 = rect2;
                objRememberedValue = new Function1() { // from class: g9.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$12$lambda$11(z10, rect3, z14, j10, j11, j12, f10, z12, f11, path, oVar, path2, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                composer2 = composerStartRestartGroup;
            }
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composer2, i12 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: g9.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$13(modifier, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, path2, oVar, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: DrawingOverlayImpl-rwpMyLU, reason: not valid java name */
    private static final void m10154DrawingOverlayImplrwpMyLU(final Modifier modifier, final boolean z10, final Rect rect, final boolean z11, final long j10, final long j11, final long j12, final float f10, final boolean z12, final float f11, final Path path, final ImageBitmap imageBitmap, final o oVar, Composer composer, final int i10, final int i11) {
        int i12;
        Rect rect2;
        boolean z13;
        int i13;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1803014396);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            rect2 = rect;
            i12 |= composerStartRestartGroup.changed(rect2) ? 256 : 128;
        } else {
            rect2 = rect;
        }
        if ((i10 & 3072) == 0) {
            z13 = z11;
            i12 |= composerStartRestartGroup.changed(z13) ? 2048 : 1024;
        } else {
            z13 = z11;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i12 |= composerStartRestartGroup.changed(j11) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changed(j12) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i12 |= composerStartRestartGroup.changed(f10) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i12 |= composerStartRestartGroup.changed(z12) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i12 |= composerStartRestartGroup.changed(f11) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i11 & 6) == 0) {
            i13 = i11 | (composerStartRestartGroup.changedInstance(path) ? 4 : 2);
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(imageBitmap) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(oVar) ? 256 : 128;
        }
        int i14 = i13;
        if (composerStartRestartGroup.shouldExecute(((i12 & 306783379) == 306783378 && (i14 & 147) == 146) ? false : true, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1803014396, i12, i14, "cu.z17.views.imageEditor.sections.cropper.components.draw.DrawingOverlayImpl (Overlay.kt:207)");
            }
            boolean zChangedInstance = ((i12 & 112) == 32) | ((i12 & 896) == 256) | ((i12 & 7168) == 2048) | ((57344 & i12) == 16384) | ((458752 & i12) == 131072) | ((3670016 & i12) == 1048576) | ((29360128 & i12) == 8388608) | ((234881024 & i12) == 67108864) | ((1879048192 & i12) == 536870912) | composerStartRestartGroup.changedInstance(path) | ((i14 & 896) == 256) | composerStartRestartGroup.changedInstance(imageBitmap);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                final boolean z14 = z13;
                final Rect rect3 = rect2;
                objRememberedValue = new Function1() { // from class: g9.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$16$lambda$15(z10, rect3, z14, j10, j11, j12, f10, z12, f11, path, oVar, imageBitmap, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                composer2 = composerStartRestartGroup;
            }
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composer2, i12 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: g9.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverlayKt.DrawingOverlayImpl_rwpMyLU$lambda$17(modifier, z10, rect, z11, j10, j11, j12, f10, z12, f11, path, imageBitmap, oVar, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
