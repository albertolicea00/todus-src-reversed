package cu.todus.android.uiCompose.shared;

import android.app.Activity;
import android.content.Intent;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.data.preferences.AppStateStep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/app/Activity;", "activity", "Lcu/todus/android/data/preferences/AppStateStep;", "appStep", "", "avoidFor", "Lua/k0;", "ManageAppStateChanges", "(Landroid/app/Activity;Lcu/todus/android/data/preferences/AppStateStep;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ManageAppStateChangesKt {
    @Composable
    public static final void ManageAppStateChanges(final Activity activity, final AppStateStep appStep, List<? extends AppStateStep> list, Composer composer, final int i10, final int i11) {
        int i12;
        y.i(activity, "activity");
        y.i(appStep, "appStep");
        Composer composerStartRestartGroup = composer.startRestartGroup(1383038630);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(activity) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(appStep.ordinal()) ? 32 : 16;
        }
        int i13 = i11 & 4;
        if (i13 != 0) {
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (i13 != 0) {
                list = w.n();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1383038630, i12, -1, "cu.todus.android.uiCompose.shared.ManageAppStateChanges (ManageAppStateChanges.kt:18)");
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | ((i12 & 112) == 32) | composerStartRestartGroup.changedInstance(activity);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ManageAppStateChangesKt$ManageAppStateChanges$1$1(list, appStep, activity, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(appStep, (Function2) objRememberedValue, composerStartRestartGroup, (i12 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final List<? extends AppStateStep> list2 = list;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ManageAppStateChangesKt.ManageAppStateChanges$lambda$1(activity, appStep, list2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ManageAppStateChanges$goTo(Activity activity, Class<?> cls) {
        activity.startActivity(new Intent(activity, cls));
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageAppStateChanges$lambda$1(Activity activity, AppStateStep appStateStep, List list, int i10, int i11, Composer composer, int i12) {
        ManageAppStateChanges(activity, appStateStep, list, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
