package cu.todus.android.uiCompose.shared.refreshConnection;

import ab.i;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.refreshConnection.RefreshConnectionKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0005²\u0006\f\u0010\u0004\u001a\u00020\u00038\nX\u008a\u0084\u0002"}, d2 = {"Lua/k0;", "RefreshConnection", "(Landroidx/compose/runtime/Composer;I)V", "", "unableToSend", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RefreshConnectionKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RefreshConnection(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-73353022);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-73353022, i10, -1, "cu.todus.android.uiCompose.shared.refreshConnection.RefreshConnection (RefreshConnection.kt:33)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(RefreshConnection$lambda$0(FlowExtKt.collectAsStateWithLifecycle(MainRepository.INSTANCE.getInstance().getUnableToSend(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7)), (Modifier) null, EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), (String) null, ComposableSingletons$RefreshConnectionKt.INSTANCE.m10090getLambda$1441875558$app_productionPFast(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: v8.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RefreshConnectionKt.RefreshConnection$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean RefreshConnection$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RefreshConnection$lambda$1(int i10, Composer composer, int i11) {
        RefreshConnection(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
