package cu.todus.android.uiCompose.intentReceiver;

import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.uiCompose.navigation.NavDestinations;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.navigation.ToDusNavigationComposableKt;
import cu.todus.android.uiCompose.theme.WindowSize;
import cu.todus.android.uiCompose.theme.WindowsSizeUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.o;
import pe.m0;
import ua.k0;
import ua.r;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcu/todus/android/uiCompose/intentReceiver/IntentReceiverActivityViewModel;", "viewModel", "Lkotlin/Function0;", "Lua/k0;", "closeActivity", "IntentReceiverApp", "(Lcu/todus/android/uiCompose/intentReceiver/IntentReceiverActivityViewModel;Llb/a;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class IntentReceiverAppKt {

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
    public static final void IntentReceiverApp(final IntentReceiverActivityViewModel viewModel, final lb.a closeActivity, Composer composer, final int i10) {
        int i11;
        int i12;
        y.i(viewModel, "viewModel");
        y.i(closeActivity, "closeActivity");
        Composer composerStartRestartGroup = composer.startRestartGroup(507440839);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(closeActivity) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(507440839, i11, -1, "cu.todus.android.uiCompose.intentReceiver.IntentReceiverApp (IntentReceiverApp.kt:24)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(viewModel.getNewIntent(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composerStartRestartGroup, 0);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            m0 m0Var = (m0) objRememberedValue;
            final WindowSize windowSizeRememberWindowSizeClass = WindowsSizeUtilKt.rememberWindowSizeClass(composerStartRestartGroup, 0);
            final NavDestinations.LoadingDest[] loadingDestArr = {NavDestinations.LoadingDest.INSTANCE};
            final NavDestinations.AppDestination[] appDestinationArr = {NavDestinations.SendToDest.INSTANCE, NavDestinations.PresentDest.INSTANCE, NavDestinations.StatusEditorDest.INSTANCE};
            Modifier modifierSystemBarsPadding = WindowInsetsPadding_androidKt.systemBarsPadding(BackgroundKt.m1205backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null));
            String route = loadingDestArr[0].getRoute();
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(loadingDestArr) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | composerStartRestartGroup.changedInstance(appDestinationArr) | composerStartRestartGroup.changed(windowSizeRememberWindowSizeClass.ordinal());
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.intentReceiver.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IntentReceiverAppKt.IntentReceiverApp$lambda$0$0(loadingDestArr, appDestinationArr, navHostControllerRememberNavController, windowSizeRememberWindowSizeClass, (NavGraphBuilder) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            NavHostKt.NavHost(navHostControllerRememberNavController, route, modifierSystemBarsPadding, null, null, null, null, null, null, null, (Function1) objRememberedValue2, composerStartRestartGroup, 0, 0, 1016);
            composerStartRestartGroup = composerStartRestartGroup;
            Status status = ((FlowsState) stateCollectAsStateWithLifecycle.getValue()).getStatus();
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(m0Var) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | ((i11 & 112) == 32) | composerStartRestartGroup.changedInstance(viewModel);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                i12 = 0;
                IntentReceiverAppKt$IntentReceiverApp$2$1 intentReceiverAppKt$IntentReceiverApp$2$1 = new IntentReceiverAppKt$IntentReceiverApp$2$1(stateCollectAsStateWithLifecycle, viewModel, m0Var, navHostControllerRememberNavController, closeActivity, null);
                composerStartRestartGroup.updateRememberedValue(intentReceiverAppKt$IntentReceiverApp$2$1);
                objRememberedValue3 = intentReceiverAppKt$IntentReceiverApp$2$1;
            } else {
                i12 = 0;
            }
            EffectsKt.LaunchedEffect(status, (Function2) objRememberedValue3, composerStartRestartGroup, i12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntentReceiverAppKt.IntentReceiverApp$lambda$2(viewModel, closeActivity, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 IntentReceiverApp$lambda$0$0(NavDestinations.LoadingDest[] loadingDestArr, NavDestinations.AppDestination[] appDestinationArr, final NavHostController navHostController, final WindowSize windowSize, NavGraphBuilder navGraphBuilder) {
        boolean z10;
        NavGraphBuilder NavHost = navGraphBuilder;
        y.i(NavHost, "$this$NavHost");
        int length = loadingDestArr.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            z10 = true;
            if (i11 >= length) {
                break;
            }
            final NavDestinations.LoadingDest loadingDest = loadingDestArr[i11];
            ToDusNavigationComposableKt.toDusNavigationComposable$default(NavHost, loadingDest.getRoute(), null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-1068802315, true, new o() { // from class: cu.todus.android.uiCompose.intentReceiver.e
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return IntentReceiverAppKt.IntentReceiverApp$lambda$0$0$0$0(loadingDest, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 126, null);
            i11++;
            NavHost = navGraphBuilder;
        }
        int length2 = appDestinationArr.length;
        while (i10 < length2) {
            final NavDestinations.AppDestination appDestination = appDestinationArr[i10];
            ToDusNavigationComposableKt.toDusNavigationComposable$default(navGraphBuilder, appDestination.getRoute(), v.e(NamedNavArgumentKt.navArgument("params", new Function1() { // from class: cu.todus.android.uiCompose.intentReceiver.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IntentReceiverAppKt.IntentReceiverApp$lambda$0$0$1$0((NavArgumentBuilder) obj);
                }
            })), null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-636170439, z10, new o() { // from class: cu.todus.android.uiCompose.intentReceiver.g
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return IntentReceiverAppKt.IntentReceiverApp$lambda$0$0$1$1(appDestination, navHostController, windowSize, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 124, null);
            i10++;
            z10 = z10;
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 IntentReceiverApp$lambda$0$0$0$0(NavDestinations.LoadingDest loadingDest, NavHostController navHostController, AnimatedContentScope toDusNavigationComposable, NavBackStackEntry it, Composer composer, int i10) {
        y.i(toDusNavigationComposable, "$this$toDusNavigationComposable");
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1068802315, i10, -1, "cu.todus.android.uiCompose.intentReceiver.IntentReceiverApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IntentReceiverApp.kt:53)");
        }
        loadingDest.setArgs(new Object[]{navHostController});
        loadingDest.getScreen().invoke(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 IntentReceiverApp$lambda$0$0$1$0(NavArgumentBuilder navArgument) {
        y.i(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        navArgument.setDefaultValue("");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 IntentReceiverApp$lambda$0$0$1$1(NavDestinations.AppDestination appDestination, NavHostController navHostController, WindowSize windowSize, AnimatedContentScope toDusNavigationComposable, NavBackStackEntry bse, Composer composer, int i10) {
        String string;
        k0 k0Var;
        y.i(toDusNavigationComposable, "$this$toDusNavigationComposable");
        y.i(bse, "bse");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-636170439, i10, -1, "cu.todus.android.uiCompose.intentReceiver.IntentReceiverApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IntentReceiverApp.kt:69)");
        }
        NavLinks navLinks = NavLinks.INSTANCE;
        Bundle arguments = bse.getArguments();
        if (arguments == null || (string = arguments.getString("params")) == null) {
            string = "";
        }
        appDestination.setArgs(new Object[]{navHostController, navLinks.decode(string)});
        int i11 = WhenMappings.$EnumSwitchMapping$0[windowSize.ordinal()];
        if (i11 == 1) {
            composer.startReplaceGroup(-1474421471);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else if (i11 == 2) {
            composer.startReplaceGroup(-1474419583);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else {
            if (i11 != 3) {
                composer.startReplaceGroup(-1474423502);
                composer.endReplaceGroup();
                throw new r();
            }
            composer.startReplaceGroup(1537689760);
            Function2 bigScreen = appDestination.getBigScreen();
            if (bigScreen == null) {
                composer.startReplaceGroup(1537704608);
                composer.endReplaceGroup();
                k0Var = null;
            } else {
                composer.startReplaceGroup(-1474417279);
                bigScreen.invoke(composer, 0);
                composer.endReplaceGroup();
                k0Var = k0.f43947a;
            }
            if (k0Var == null) {
                composer.startReplaceGroup(-1474416735);
                appDestination.getScreen().invoke(composer, 0);
            } else {
                composer.startReplaceGroup(-1474417758);
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
    public static final k0 IntentReceiverApp$lambda$2(IntentReceiverActivityViewModel intentReceiverActivityViewModel, lb.a aVar, int i10, Composer composer, int i11) {
        IntentReceiverApp(intentReceiverActivityViewModel, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
