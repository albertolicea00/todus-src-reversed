package cu.z17.views.pdfViewer;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import coil.compose.SingletonAsyncImagePainterKt;
import coil.request.ImageRequest;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import cu.z17.views.zoomables.ZoomModifierKt;
import cu.z17.views.zoomables.ZoomState;
import cu.z17.views.zoomables.ZoomStateKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aW\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "actualPage", "", "cacheKey", "Landroidx/compose/ui/unit/Dp;", "width", "height", "Landroid/content/Context;", "context", "", "zoomable", "Lua/k0;", "PagePdfViewer-YlGCr2M", "(Landroidx/compose/ui/Modifier;Lkotlin/Pair;Ljava/lang/String;FFLandroid/content/Context;ZLandroidx/compose/runtime/Composer;II)V", "PagePdfViewer", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PagePdfViewerKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: PagePdfViewer-YlGCr2M, reason: not valid java name */
    public static final void m10268PagePdfViewerYlGCr2M(Modifier modifier, final Pair<Integer, Bitmap> actualPage, final String cacheKey, final float f10, final float f11, final Context context, final boolean z10, Composer composer, final int i10, final int i11) {
        int i12;
        final Modifier modifier2;
        Modifier modifierZoom$default;
        y.i(actualPage, "actualPage");
        y.i(cacheKey, "cacheKey");
        y.i(context, "context");
        Composer composerStartRestartGroup = composer.startRestartGroup(-139705105);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(actualPage) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(cacheKey) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(f10) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(f11) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(context) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i12) != 599186, i12 & 1)) {
            Modifier modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-139705105, i12, -1, "cu.z17.views.pdfViewer.PagePdfViewer (PagePdfViewer.kt:31)");
            }
            if (actualPage.getSecond() != null) {
                composerStartRestartGroup.startReplaceGroup(-131199468);
                ImageRequest imageRequestBuild = new ImageRequest.Builder(context).size((int) f10, (int) f11).memoryCacheKey(cacheKey).data(actualPage.getSecond()).build();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(AspectRatioKt.aspectRatio$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier3, Color.INSTANCE.m5903getWhite0d7_KjU(), null, 2, null), 1.0f / ((float) Math.sqrt(2.0f)), false, 2, null), 0.0f, 1, null);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-130781402);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ZoomState zoomStateRememberZoomState = ZoomStateKt.rememberZoomState(0.0f, 0.0f, 0.0f, 0.0f, false, false, false, true, (Object) null, composerStartRestartGroup, 14155776, 319);
                    composerStartRestartGroup = composerStartRestartGroup;
                    modifierZoom$default = ZoomModifierKt.zoom$default((Modifier) companion, (Object) null, zoomStateRememberZoomState, true, 1, (Object) null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1112589865);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierZoom$default = Modifier.INSTANCE;
                }
                Modifier modifierThen = modifierFillMaxWidth$default.then(modifierZoom$default);
                ContentScale fit = ContentScale.INSTANCE.getFit();
                Composer composer2 = composerStartRestartGroup;
                ImageKt.Image(SingletonAsyncImagePainterKt.m9777rememberAsyncImagePainterEHKIwbg(imageRequestBuild, null, null, null, 0, null, composerStartRestartGroup, 0, 62), "Page " + (actualPage.getFirst().intValue() + 1), modifierThen, (Alignment) null, fit, 0.0f, (ColorFilter) null, composer2, 24576, LocationRequestCompat.QUALITY_LOW_POWER);
                composerStartRestartGroup = composer2;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-130331344);
                Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.m1771sizeVpY3zN4(Modifier.INSTANCE, f10, f11), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.pdfViewer.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PagePdfViewerKt.PagePdfViewer_YlGCr2M$lambda$0(modifier2, actualPage, cacheKey, f10, f11, context, z10, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PagePdfViewer_YlGCr2M$lambda$0(Modifier modifier, Pair pair, String str, float f10, float f11, Context context, boolean z10, int i10, int i11, Composer composer, int i12) {
        m10268PagePdfViewerYlGCr2M(modifier, pair, str, f10, f11, context, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
