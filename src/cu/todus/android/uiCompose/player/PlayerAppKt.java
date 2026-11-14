package cu.todus.android.uiCompose.player;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import cu.todus.android.uiCompose.navigation.ToDusNavigationComposableKt;
import cu.todus.android.uiCompose.player.PlayerAppKt;
import cu.todus.android.uiCompose.player.screen.PlayerScreenKt;
import cu.todus.android.uiCompose.theme.WindowSize;
import cu.todus.android.uiCompose.theme.WindowsSizeUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.o;
import ua.k0;
import ua.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/uiCompose/player/PlayerParams;", "playerParams", "Lua/k0;", "PlayerApp", "(Lcu/todus/android/uiCompose/player/PlayerParams;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PlayerAppKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WindowSize.values().length];
            try {
                iArr[WindowSize.Compact.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WindowSize.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WindowSize.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PlayerApp(final PlayerParams playerParams, Composer composer, final int i10) {
        int i11;
        float bottom;
        y.i(playerParams, "playerParams");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1232716820);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(playerParams) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1232716820, i11, -1, "cu.todus.android.uiCompose.player.PlayerApp (PlayerApp.kt:25)");
            }
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composerStartRestartGroup, 0);
            final WindowSize windowSizeRememberWindowSizeClass = WindowsSizeUtilKt.rememberWindowSizeClass(composerStartRestartGroup, 0);
            WindowInsets.Companion companion = WindowInsets.INSTANCE;
            if (WindowInsets_androidKt.isImeVisible(companion, composerStartRestartGroup, 6)) {
                composerStartRestartGroup.startReplaceGroup(770117390);
                composerStartRestartGroup.endReplaceGroup();
                bottom = Dp.m8823constructorimpl(0);
            } else {
                composerStartRestartGroup.startReplaceGroup(770119428);
                bottom = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(companion, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getBottom();
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(BackgroundKt.m1205backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), 0.0f, 0.0f, 0.0f, bottom, 7, null);
            boolean zChanged = composerStartRestartGroup.changed(windowSizeRememberWindowSizeClass.ordinal()) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | ((i11 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: l8.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PlayerAppKt.PlayerApp$lambda$0$0(windowSizeRememberWindowSizeClass, navHostControllerRememberNavController, playerParams, (NavGraphBuilder) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            NavHostKt.NavHost(navHostControllerRememberNavController, "player", modifierM1729paddingqDBjuR0$default, null, null, null, null, null, null, null, (Function1) objRememberedValue, composerStartRestartGroup, 48, 0, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: l8.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlayerAppKt.PlayerApp$lambda$1(playerParams, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PlayerApp$lambda$0$0(final WindowSize windowSize, final NavHostController navHostController, final PlayerParams playerParams, NavGraphBuilder NavHost) {
        y.i(NavHost, "$this$NavHost");
        ToDusNavigationComposableKt.toDusNavigationComposable$default(NavHost, "player", null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(1991409047, true, new o() { // from class: l8.d
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PlayerAppKt.PlayerApp$lambda$0$0$0(windowSize, navHostController, playerParams, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 126, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PlayerApp$lambda$0$0$0(WindowSize windowSize, NavHostController navHostController, PlayerParams playerParams, AnimatedContentScope toDusNavigationComposable, NavBackStackEntry it, Composer composer, int i10) {
        y.i(toDusNavigationComposable, "$this$toDusNavigationComposable");
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1991409047, i10, -1, "cu.todus.android.uiCompose.player.PlayerApp.<anonymous>.<anonymous>.<anonymous> (PlayerApp.kt:46)");
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[windowSize.ordinal()];
        if (i11 == 1) {
            composer.startReplaceGroup(-1811316723);
            PlayerScreenKt.PlayerScreen(navHostController, playerParams, null, composer, 0, 4);
            composer.endReplaceGroup();
        } else if (i11 == 2) {
            composer.startReplaceGroup(-1811310035);
            PlayerScreenKt.PlayerScreen(navHostController, playerParams, null, composer, 0, 4);
            composer.endReplaceGroup();
        } else {
            if (i11 != 3) {
                composer.startReplaceGroup(-1811318707);
                composer.endReplaceGroup();
                throw new r();
            }
            composer.startReplaceGroup(-1811303283);
            PlayerScreenKt.PlayerScreen(navHostController, playerParams, null, composer, 0, 4);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PlayerApp$lambda$1(PlayerParams playerParams, int i10, Composer composer, int i11) {
        PlayerApp(playerParams, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
