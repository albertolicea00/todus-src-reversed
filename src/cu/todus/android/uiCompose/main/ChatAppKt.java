package cu.todus.android.uiCompose.main;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import androidx.p000activity.compose.ActivityResultRegistryKt;
import androidx.p000activity.compose.ManagedActivityResultLauncher;
import androidx.p000activity.result.contract.ActivityResultContracts;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.ToDusApp;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.uiCompose.main.screen.updateRequired.UpdateDialogKt;
import cu.todus.android.uiCompose.main.screen.updateRequired.UpdateViewModel;
import cu.todus.android.uiCompose.navigation.NavDestinations;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.navigation.ToDusNavigationComposableKt;
import cu.todus.android.uiCompose.theme.WindowSize;
import cu.todus.android.uiCompose.theme.WindowsSizeUtilKt;
import cu.todus.android.utils.UpdateInfo;
import defpackage.r;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import pe.m0;
import ua.k0;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t²\u0006\u000e\u0010\b\u001a\u0004\u0018\u00010\u00078\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/data/preferences/AppState;", "state", "Lcu/todus/android/uiCompose/main/MainActivityViewModel;", "viewModel", "Lua/k0;", "ChatApp", "(Lcu/todus/android/data/preferences/AppState;Lcu/todus/android/uiCompose/main/MainActivityViewModel;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/utils/UpdateInfo;", "updateInfo", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatAppKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AppStateStep.values().length];
            try {
                iArr[AppStateStep.WAITING_COMPLETE_PROFILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[WindowSize.values().length];
            try {
                iArr2[WindowSize.Compact.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[WindowSize.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[WindowSize.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ChatApp(final AppState state, final MainActivityViewModel viewModel, Composer composer, final int i10) {
        int i11;
        final UpdateViewModel updateViewModel;
        y.i(state, "state");
        y.i(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1977503189);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= (i10 & 64) == 0 ? composerStartRestartGroup.changed(viewModel) : composerStartRestartGroup.changedInstance(viewModel) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1977503189, i11, -1, "cu.todus.android.uiCompose.main.ChatApp (ChatApp.kt:41)");
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
            Context applicationContext = ((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getApplicationContext();
            y.g(applicationContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
            final ToDusApp toDusApp = (ToDusApp) applicationContext;
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getUpdateInfo(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            UpdateViewModel updateViewModel2 = (UpdateViewModel) ViewModelKt.viewModel(z0.b(UpdateViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
            List listC = v.c();
            listC.add("android.permission.READ_CONTACTS");
            if (Build.VERSION.SDK_INT >= 33) {
                listC.add("android.permission.POST_NOTIFICATIONS");
            }
            String[] strArr = (String[]) v.a(listC).toArray(new String[0]);
            ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatAppKt.ChatApp$lambda$2$0((Map) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) objRememberedValue2, composerStartRestartGroup, 48);
            AppStateStep appStep = state.getAppStep();
            boolean zChangedInstance = ((i11 & 14) == 4) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(strArr);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new ChatAppKt$ChatApp$1$1(state, managedActivityResultLauncherRememberLauncherForActivityResult, strArr, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(appStep, (Function2) objRememberedValue3, composerStartRestartGroup, 0);
            final NavDestinations.AppDestination[] appDestinationArr = {NavDestinations.InitInfoProfileDest.INSTANCE, NavDestinations.HomeDest.INSTANCE, NavDestinations.LinkedDeviceDest.INSTANCE, NavDestinations.OpenWithDest.INSTANCE, NavDestinations.CreateChannelDest.INSTANCE, NavDestinations.QrReaderDest.INSTANCE, NavDestinations.SettingScreenDest.INSTANCE, NavDestinations.SecretRoomsDest.INSTANCE, NavDestinations.SecretRoomAccessDest.INSTANCE, NavDestinations.MutedRoomsDest.INSTANCE, NavDestinations.BlockedDest.INSTANCE, NavDestinations.EditProfileDest.INSTANCE, NavDestinations.SearchDest.INSTANCE, NavDestinations.DataPreferencesDest.INSTANCE, NavDestinations.NearPeopleDest.INSTANCE, NavDestinations.AboutDest.INSTANCE, NavDestinations.NewsDest.INSTANCE, NavDestinations.MyCatalogueDest.INSTANCE, NavDestinations.EditToDusIdDest.INSTANCE, NavDestinations.ThemeSelectorDest.INSTANCE, NavDestinations.StatusListDest.INSTANCE, NavDestinations.PrivacyDest.INSTANCE, NavDestinations.BatteryPreferenceDest.INSTANCE, NavDestinations.ReactSelectionDest.INSTANCE, NavDestinations.ManageBackupDest.INSTANCE, NavDestinations.LogoutDest.INSTANCE, NavDestinations.RequestRoomsDest.INSTANCE, NavDestinations.ContactsPermissionDest.INSTANCE, NavDestinations.CallDest.INSTANCE};
            final NavDestinations.AppDestination[] appDestinationArr2 = {NavDestinations.CatalogueWebDest.INSTANCE, NavDestinations.ChatP2PDest.INSTANCE, NavDestinations.ChatGroupDest.INSTANCE, NavDestinations.ChatChannelDest.INSTANCE, NavDestinations.ChatCardDest.INSTANCE, NavDestinations.PreviewP2PDest.INSTANCE, NavDestinations.MapDest.INSTANCE, NavDestinations.ForwardToDest.INSTANCE, NavDestinations.PreviewGroupDest.INSTANCE, NavDestinations.PreviewChannelDest.INSTANCE, NavDestinations.PreviewChannelAdminsDest.INSTANCE, NavDestinations.PreviewCardDest.INSTANCE, NavDestinations.DateEditorDest.INSTANCE, NavDestinations.CreateGroupStep1SelectionDest.INSTANCE, NavDestinations.CreateGroupStep2ConfigurationDest.INSTANCE, NavDestinations.JoinRoomDest.INSTANCE, NavDestinations.QrViewerDest.INSTANCE, NavDestinations.PreviewSubscribersDest.INSTANCE, NavDestinations.PubEditorDest.INSTANCE, NavDestinations.CatalogueCheckInDest.INSTANCE, NavDestinations.CatalogueFormDest.INSTANCE, NavDestinations.CatalogueDest.INSTANCE, NavDestinations.ProductPreviewDest.INSTANCE, NavDestinations.StatusPreviewDest.INSTANCE, NavDestinations.ManageStickersDest.INSTANCE, NavDestinations.PreviewGroupAdminsDest.INSTANCE, NavDestinations.ChatResourcesDest.INSTANCE, NavDestinations.SocialProfileDest.INSTANCE, NavDestinations.StatusEditorDest.INSTANCE, NavDestinations.SearchUserDest.INSTANCE};
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            int i12 = i11;
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierSystemBarsPadding = WindowInsetsPadding_androidKt.systemBarsPadding(BackgroundKt.m1205backgroundbw27NRU$default(companion2, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null));
            String route = WhenMappings.$EnumSwitchMapping$0[state.getAppStep().ordinal()] == 1 ? appDestinationArr[0].getRoute() : appDestinationArr[1].getRoute();
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(appDestinationArr) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | composerStartRestartGroup.changed(windowSizeRememberWindowSizeClass.ordinal()) | composerStartRestartGroup.changedInstance(appDestinationArr2);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatAppKt.ChatApp$lambda$4$0$0(appDestinationArr, appDestinationArr2, navHostControllerRememberNavController, windowSizeRememberWindowSizeClass, (NavGraphBuilder) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            NavHostKt.NavHost(navHostControllerRememberNavController, route, modifierSystemBarsPadding, null, null, null, null, null, null, null, (Function1) objRememberedValue4, composerStartRestartGroup, 0, 0, 1016);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            Status status = ((FlowsState) stateCollectAsStateWithLifecycle.getValue()).getStatus();
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(m0Var) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | ((i12 & 112) == 32 || ((i12 & 64) != 0 && composerStartRestartGroup.changedInstance(viewModel)));
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue5 == companion.getEmpty()) {
                updateViewModel = updateViewModel2;
                ChatAppKt$ChatApp$3$1 chatAppKt$ChatApp$3$1 = new ChatAppKt$ChatApp$3$1(stateCollectAsStateWithLifecycle, viewModel, m0Var, navHostControllerRememberNavController, null);
                composerStartRestartGroup.updateRememberedValue(chatAppKt$ChatApp$3$1);
                objRememberedValue5 = chatAppKt$ChatApp$3$1;
            } else {
                updateViewModel = updateViewModel2;
            }
            EffectsKt.LaunchedEffect(status, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
            UpdateInfo updateInfoChatApp$lambda$0 = ChatApp$lambda$0(stateCollectAsStateWithLifecycle2);
            if (updateInfoChatApp$lambda$0 == null) {
                composerStartRestartGroup.startReplaceGroup(-2019709897);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2019709896);
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(toDusApp) | composerStartRestartGroup.changedInstance(updateViewModel);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new Function2() { // from class: cu.todus.android.uiCompose.main.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatAppKt.ChatApp$lambda$6$0$0(toDusApp, updateViewModel, (String) obj, ((Long) obj2).longValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                Function2 function2 = (Function2) objRememberedValue6;
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(toDusApp);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance4 || objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatAppKt.ChatApp$lambda$6$1$0(toDusApp);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                UpdateDialogKt.UpdateDialog(updateViewModel, updateInfoChatApp$lambda$0, function2, (lb.a) objRememberedValue7, composerStartRestartGroup, 0);
                k0 k0Var = k0.f43947a;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatAppKt.ChatApp$lambda$7(state, viewModel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final UpdateInfo ChatApp$lambda$0(State<UpdateInfo> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatApp$lambda$2$0(Map it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatApp$lambda$4$0$0(NavDestinations.AppDestination[] appDestinationArr, NavDestinations.AppDestination[] appDestinationArr2, final NavHostController navHostController, final WindowSize windowSize, NavGraphBuilder navGraphBuilder) {
        boolean z10;
        NavGraphBuilder NavHost = navGraphBuilder;
        y.i(NavHost, "$this$NavHost");
        int length = appDestinationArr.length;
        int i10 = 0;
        while (true) {
            z10 = true;
            if (i10 >= length) {
                break;
            }
            final NavDestinations.AppDestination appDestination = appDestinationArr[i10];
            ToDusNavigationComposableKt.toDusNavigationComposable$default(NavHost, appDestination.getRoute(), null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-911009864, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.a
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ChatAppKt.ChatApp$lambda$4$0$0$0$0(appDestination, navHostController, windowSize, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 126, null);
            i10++;
            NavHost = navGraphBuilder;
        }
        int length2 = appDestinationArr2.length;
        int i11 = 0;
        while (i11 < length2) {
            final NavDestinations.AppDestination appDestination2 = appDestinationArr2[i11];
            ToDusNavigationComposableKt.toDusNavigationComposable$default(navGraphBuilder, appDestination2.getRoute(), v.e(NamedNavArgumentKt.navArgument("params", new Function1() { // from class: cu.todus.android.uiCompose.main.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ChatAppKt.ChatApp$lambda$4$0$0$1$0((NavArgumentBuilder) obj);
                }
            })), null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-1396956049, z10, new lb.o() { // from class: cu.todus.android.uiCompose.main.c
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ChatAppKt.ChatApp$lambda$4$0$0$1$1(appDestination2, navHostController, windowSize, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 124, null);
            i11++;
            z10 = z10;
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatApp$lambda$4$0$0$0$0(NavDestinations.AppDestination appDestination, NavHostController navHostController, WindowSize windowSize, AnimatedContentScope toDusNavigationComposable, NavBackStackEntry it, Composer composer, int i10) {
        k0 k0Var;
        y.i(toDusNavigationComposable, "$this$toDusNavigationComposable");
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-911009864, i10, -1, "cu.todus.android.uiCompose.main.ChatApp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatApp.kt:156)");
        }
        appDestination.setArgs(new Object[]{navHostController});
        int i11 = WhenMappings.$EnumSwitchMapping$1[windowSize.ordinal()];
        if (i11 == 1) {
            composer.startReplaceGroup(692853920);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else if (i11 == 2) {
            composer.startReplaceGroup(692855776);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else {
            if (i11 != 3) {
                composer.startReplaceGroup(692851917);
                composer.endReplaceGroup();
                throw new ua.r();
            }
            composer.startReplaceGroup(3749091);
            Function2 bigScreen = appDestination.getBigScreen();
            if (bigScreen == null) {
                composer.startReplaceGroup(3763009);
                composer.endReplaceGroup();
                k0Var = null;
            } else {
                composer.startReplaceGroup(692858048);
                bigScreen.invoke(composer, 0);
                composer.endReplaceGroup();
                k0Var = k0.f43947a;
            }
            if (k0Var == null) {
                composer.startReplaceGroup(692858560);
                appDestination.getScreen().invoke(composer, 0);
            } else {
                composer.startReplaceGroup(692857599);
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
    public static final k0 ChatApp$lambda$4$0$0$1$0(NavArgumentBuilder navArgument) {
        y.i(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        navArgument.setDefaultValue("");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatApp$lambda$4$0$0$1$1(NavDestinations.AppDestination appDestination, NavHostController navHostController, WindowSize windowSize, AnimatedContentScope toDusNavigationComposable, NavBackStackEntry bse, Composer composer, int i10) {
        String string;
        k0 k0Var;
        y.i(toDusNavigationComposable, "$this$toDusNavigationComposable");
        y.i(bse, "bse");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396956049, i10, -1, "cu.todus.android.uiCompose.main.ChatApp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatApp.kt:177)");
        }
        NavLinks navLinks = NavLinks.INSTANCE;
        Bundle arguments = bse.getArguments();
        if (arguments == null || (string = arguments.getString("params")) == null) {
            string = "";
        }
        appDestination.setArgs(new Object[]{navHostController, navLinks.decode(string)});
        int i11 = WhenMappings.$EnumSwitchMapping$1[windowSize.ordinal()];
        if (i11 == 1) {
            composer.startReplaceGroup(1850012439);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else if (i11 == 2) {
            composer.startReplaceGroup(1850014455);
            appDestination.getScreen().invoke(composer, 0);
            composer.endReplaceGroup();
        } else {
            if (i11 != 3) {
                composer.startReplaceGroup(1850010296);
                composer.endReplaceGroup();
                throw new ua.r();
            }
            composer.startReplaceGroup(1515933802);
            Function2 bigScreen = appDestination.getBigScreen();
            if (bigScreen == null) {
                composer.startReplaceGroup(1515948650);
                composer.endReplaceGroup();
                k0Var = null;
            } else {
                composer.startReplaceGroup(1850016887);
                bigScreen.invoke(composer, 0);
                composer.endReplaceGroup();
                k0Var = k0.f43947a;
            }
            if (k0Var == null) {
                composer.startReplaceGroup(1850017431);
                appDestination.getScreen().invoke(composer, 0);
            } else {
                composer.startReplaceGroup(1850016408);
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
    public static final k0 ChatApp$lambda$6$0$0(ToDusApp toDusApp, UpdateViewModel updateViewModel, String url, long j10) {
        y.i(url, "url");
        toDusApp.dismissUpdate();
        updateViewModel.startDownloadIfNeeded(url, j10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatApp$lambda$6$1$0(ToDusApp toDusApp) {
        toDusApp.dismissUpdate();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatApp$lambda$7(AppState appState, MainActivityViewModel mainActivityViewModel, int i10, Composer composer, int i11) {
        ChatApp(appState, mainActivityViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
