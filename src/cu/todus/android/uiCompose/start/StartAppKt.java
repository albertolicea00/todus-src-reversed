package cu.todus.android.uiCompose.start;

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
import cu.todus.android.uiCompose.navigation.NavDestinations;
import cu.todus.android.uiCompose.navigation.ToDusNavigationComposableKt;
import cu.todus.android.uiCompose.start.StartAppKt;
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
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lua/k0;", "StartApp", "(Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StartAppKt {

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
    public static final void StartApp(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1036117400);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1036117400, i10, -1, "cu.todus.android.uiCompose.start.StartApp (StartApp.kt:15)");
            }
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composerStartRestartGroup, 0);
            final WindowSize windowSizeRememberWindowSizeClass = WindowsSizeUtilKt.rememberWindowSizeClass(composerStartRestartGroup, 0);
            final NavDestinations.AppDestination[] appDestinationArr = {NavDestinations.FirstOpenDest.INSTANCE, NavDestinations.WelcomeDest.INSTANCE};
            Modifier modifierSystemBarsPadding = WindowInsetsPadding_androidKt.systemBarsPadding(BackgroundKt.m1205backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null));
            String route = appDestinationArr[0].getRoute();
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(appDestinationArr) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | composerStartRestartGroup.changed(windowSizeRememberWindowSizeClass.ordinal());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: y8.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StartAppKt.StartApp$lambda$0$0(appDestinationArr, navHostControllerRememberNavController, windowSizeRememberWindowSizeClass, (NavGraphBuilder) obj);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: y8.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StartAppKt.StartApp$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StartApp$lambda$0$0(NavDestinations.AppDestination[] appDestinationArr, final NavHostController navHostController, final WindowSize windowSize, NavGraphBuilder navGraphBuilder) {
        NavGraphBuilder NavHost = navGraphBuilder;
        y.i(NavHost, "$this$NavHost");
        int length = appDestinationArr.length;
        int i10 = 0;
        while (i10 < length) {
            final NavDestinations.AppDestination appDestination = appDestinationArr[i10];
            ToDusNavigationComposableKt.toDusNavigationComposable$default(NavHost, appDestination.getRoute(), null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(1679609777, true, new o() { // from class: y8.f
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StartAppKt.StartApp$lambda$0$0$0$0(appDestination, navHostController, windowSize, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
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
    public static final k0 StartApp$lambda$0$0$0$0(NavDestinations.AppDestination appDestination, NavHostController navHostController, WindowSize windowSize, AnimatedContentScope toDusNavigationComposable, NavBackStackEntry it, Composer composer, int i10) {
        k0 k0Var;
        y.i(toDusNavigationComposable, "$this$toDusNavigationComposable");
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1679609777, i10, -1, "cu.todus.android.uiCompose.start.StartApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StartApp.kt:33)");
        }
        appDestination.setArgs(new Object[]{navHostController});
        int i11 = WhenMappings.$EnumSwitchMapping$0[windowSize.ordinal()];
        if (i11 == 1) {
            composer.startReplaceGroup(-802703143);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else if (i11 == 2) {
            composer.startReplaceGroup(-802701415);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else {
            if (i11 != 3) {
                composer.startReplaceGroup(-802705034);
                composer.endReplaceGroup();
                throw new r();
            }
            composer.startReplaceGroup(886112458);
            Function2 bigScreen = appDestination.getBigScreen();
            if (bigScreen == null) {
                composer.startReplaceGroup(886126376);
                composer.endReplaceGroup();
                k0Var = null;
            } else {
                composer.startReplaceGroup(-802699271);
                bigScreen.invoke(composer, 0);
                composer.endReplaceGroup();
                k0Var = k0.f43947a;
            }
            if (k0Var == null) {
                composer.startReplaceGroup(-802698759);
                appDestination.getScreen().invoke(composer, 0);
            } else {
                composer.startReplaceGroup(-802699720);
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
    public static final k0 StartApp$lambda$1(int i10, Composer composer, int i11) {
        StartApp(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
