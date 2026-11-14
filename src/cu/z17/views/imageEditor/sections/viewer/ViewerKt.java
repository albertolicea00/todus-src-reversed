package cu.z17.views.imageEditor.sections.viewer;

import android.graphics.Bitmap;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.z17.views.imageEditor.sections.viewer.ViewerKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.zoomables.ZoomModifierKt;
import cu.z17.views.zoomables.ZoomStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/graphics/Bitmap;", NewEntity.NEWS_CONFIG_SOURCE, "Lua/k0;", "Viewer", "(Landroid/graphics/Bitmap;Landroidx/compose/runtime/Composer;I)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ViewerKt {
    @Composable
    public static final void Viewer(Bitmap source, Composer composer, final int i10) {
        int i11;
        final Bitmap bitmap;
        y.i(source, "source");
        Composer composerStartRestartGroup = composer.startRestartGroup(1947774951);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(source) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1947774951, i11, -1, "cu.z17.views.imageEditor.sections.viewer.Viewer (Viewer.kt:14)");
            }
            bitmap = source;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(ZoomModifierKt.zoom$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Object) null, ZoomStateKt.rememberZoomState(0.0f, 0.0f, 0.0f, 0.0f, false, false, false, true, (Object) null, composerStartRestartGroup, 14155776, 319), true, 1, (Object) null), bitmap, null, null, null, null, 0, null, null, composerStartRestartGroup, (i11 << 3) & 112, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            bitmap = source;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: k9.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ViewerKt.Viewer$lambda$0(bitmap, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Viewer$lambda$0(Bitmap bitmap, int i10, Composer composer, int i11) {
        Viewer(bitmap, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
