package cu.todus.android.uiCompose.auth;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.uiCompose.auth.AuthAppKt;
import cu.todus.android.uiCompose.navigation.NavDestinations;
import cu.todus.android.uiCompose.navigation.ToDusNavigationComposableKt;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/data/preferences/AppState;", "state", "Lua/k0;", "AuthApp", "(Lcu/todus/android/data/preferences/AppState;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AuthAppKt {

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
    public static final void AuthApp(final AppState state, Composer composer, final int i10) {
        int i11;
        y.i(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-501488630);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-501488630, i11, -1, "cu.todus.android.uiCompose.auth.AuthApp (AuthApp.kt:17)");
            }
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composerStartRestartGroup, 0);
            final WindowSize windowSizeRememberWindowSizeClass = WindowsSizeUtilKt.rememberWindowSizeClass(composerStartRestartGroup, 0);
            final NavDestinations.AppDestination[] appDestinationArr = {NavDestinations.VerifyDest.INSTANCE, NavDestinations.RegisterDest.INSTANCE};
            Modifier modifierSystemBarsPadding = WindowInsetsPadding_androidKt.systemBarsPadding(BackgroundKt.m1205backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null));
            String route = (state.getAppStep() == AppStateStep.WAITING_VERIFY ? appDestinationArr[0] : appDestinationArr[1]).getRoute();
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(appDestinationArr) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | composerStartRestartGroup.changed(windowSizeRememberWindowSizeClass.ordinal());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: g7.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthAppKt.AuthApp$lambda$0$0(appDestinationArr, navHostControllerRememberNavController, windowSizeRememberWindowSizeClass, (NavGraphBuilder) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            NavHostKt.NavHost(navHostControllerRememberNavController, route, modifierSystemBarsPadding, null, null, null, null, null, null, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 0, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: g7.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthAppKt.AuthApp$lambda$1(state, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AuthApp$lambda$0$0(NavDestinations.AppDestination[] appDestinationArr, final NavHostController navHostController, final WindowSize windowSize, NavGraphBuilder navGraphBuilder) {
        NavGraphBuilder NavHost = navGraphBuilder;
        y.i(NavHost, "$this$NavHost");
        int length = appDestinationArr.length;
        int i10 = 0;
        while (i10 < length) {
            final NavDestinations.AppDestination appDestination = appDestinationArr[i10];
            ToDusNavigationComposableKt.toDusNavigationComposable$default(NavHost, appDestination.getRoute(), null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(347608161, true, new o() { // from class: g7.h
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return AuthAppKt.AuthApp$lambda$0$0$0$0(appDestination, navHostController, windowSize, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 126, null);
            i10++;
            NavHost = navGraphBuilder;
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AuthApp$lambda$0$0$0$0(NavDestinations.AppDestination appDestination, NavHostController navHostController, WindowSize windowSize, AnimatedContentScope toDusNavigationComposable, NavBackStackEntry it, Composer composer, int i10) {
        k0 k0Var;
        y.i(toDusNavigationComposable, "$this$toDusNavigationComposable");
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(347608161, i10, -1, "cu.todus.android.uiCompose.auth.AuthApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AuthApp.kt:35)");
        }
        appDestination.setArgs(new Object[]{navHostController});
        int i11 = WhenMappings.$EnumSwitchMapping$0[windowSize.ordinal()];
        if (i11 == 1) {
            composer.startReplaceGroup(-956001911);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else if (i11 == 2) {
            composer.startReplaceGroup(-956000183);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else {
            if (i11 != 3) {
                composer.startReplaceGroup(-956003802);
                composer.endReplaceGroup();
                throw new r();
            }
            composer.startReplaceGroup(428817946);
            Function2 bigScreen = appDestination.getBigScreen();
            if (bigScreen == null) {
                composer.startReplaceGroup(428831864);
                composer.endReplaceGroup();
                k0Var = null;
            } else {
                composer.startReplaceGroup(-955998039);
                bigScreen.invoke(composer, 0);
                composer.endReplaceGroup();
                k0Var = k0.f43947a;
            }
            if (k0Var == null) {
                composer.startReplaceGroup(-955997527);
                appDestination.getScreen().invoke(composer, 0);
            } else {
                composer.startReplaceGroup(-955998488);
            }
            composer.endReplaceGroup();
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AuthApp$lambda$1(AppState appState, int i10, Composer composer, int i11) {
        AuthApp(appState, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
