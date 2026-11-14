package cu.todus.android.uiCompose.main.screen.batteryPreference;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.Battery4BarKt;
import androidx.compose.material.icons.outlined.BatteryAlertKt;
import androidx.compose.material.icons.outlined.BatteryFullKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.ToDusApp;
import cu.todus.android.alive.AliveUtility;
import cu.todus.android.data.preferences.DataPreferences;
import cu.todus.android.di.MainModule;
import cu.todus.android.uiCompose.shared.animations.attach.AttachContainerKt;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.volatileState.AppVolatileState;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.z0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r²\u0006\f\u0010\b\u001a\u00020\u00078\nX\u008a\u0084\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\n\u001a\u00020\u00078\nX\u008a\u0084\u0002²\u0006\f\u0010\f\u001a\u00020\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/batteryPreference/BatteryPreferenceViewModel;", "viewModel", "Lua/k0;", "BigBatteryPreferenceScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/batteryPreference/BatteryPreferenceViewModel;Landroidx/compose/runtime/Composer;II)V", "", "batteryOptimizations", "showBatteryDialog", "isFirstTimeOnSettings", "Lcu/todus/android/data/preferences/DataPreferences;", "selected", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BigBatteryPreferenceScreenKt {
    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:57:0x0116  */
    /* JADX WARN: Code duplicated, block: B:60:0x016b  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BigBatteryPreferenceScreen(final NavHostController navHostController, BatteryPreferenceViewModel batteryPreferenceViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z10;
        Boolean bool;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        int i13;
        final BatteryPreferenceViewModel batteryPreferenceViewModel2 = batteryPreferenceViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2049889586);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i13 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(batteryPreferenceViewModel2) : composerStartRestartGroup.changedInstance(batteryPreferenceViewModel2)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
            }
            i12 |= i13;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 2) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i14 &= -113;
                    z10 = true;
                    batteryPreferenceViewModel2 = (BatteryPreferenceViewModel) ViewModelKt.viewModel(z0.b(BatteryPreferenceViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2049889586, i14, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.BigBatteryPreferenceScreen (BigBatteryPreferenceScreen.kt:50)");
                }
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                te.h hVarIsBatteryPermissionAvailable = batteryPreferenceViewModel2.isBatteryPermissionAvailable(context);
                bool = Boolean.FALSE;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(hVarIsBatteryPermissionAvailable, bool, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(batteryPreferenceViewModel2.getIsFirstTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final u0 u0Var = new u0();
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = Boolean.TRUE;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                u0Var.f36629c = ((Boolean) objRememberedValue2).booleanValue();
                final BatteryPreferenceViewModel batteryPreferenceViewModel3 = batteryPreferenceViewModel2;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(367865090, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.v
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$6(navHostController, stateCollectAsStateWithLifecycle, mutableState, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(-1226194556, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.w
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7(batteryPreferenceViewModel3, u0Var, context, stateCollectAsStateWithLifecycle, mutableState, stateCollectAsStateWithLifecycle2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            }
            z10 = true;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049889586, i14, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.BigBatteryPreferenceScreen (BigBatteryPreferenceScreen.kt:50)");
            }
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            te.h hVarIsBatteryPermissionAvailable2 = batteryPreferenceViewModel2.isBatteryPermissionAvailable(context2);
            bool = Boolean.FALSE;
            final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(hVarIsBatteryPermissionAvailable2, bool, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(batteryPreferenceViewModel2.getIsFirstTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final u0 u0Var2 = new u0();
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = Boolean.TRUE;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            u0Var2.f36629c = ((Boolean) objRememberedValue2).booleanValue();
            final BatteryPreferenceViewModel batteryPreferenceViewModel4 = batteryPreferenceViewModel2;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(367865090, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$6(navHostController, stateCollectAsStateWithLifecycle3, mutableState2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(-1226194556, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7(batteryPreferenceViewModel4, u0Var2, context2, stateCollectAsStateWithLifecycle3, mutableState2, stateCollectAsStateWithLifecycle4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$8(navHostController, batteryPreferenceViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean BigBatteryPreferenceScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean BigBatteryPreferenceScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigBatteryPreferenceScreen$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean BigBatteryPreferenceScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$6(final NavHostController navHostController, final State state, final MutableState mutableState, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(367865090, i10, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.BigBatteryPreferenceScreen.<anonymous> (BigBatteryPreferenceScreen.kt:69)");
            }
            Function2 function2M9838getLambda$1431904817$app_productionPFast = ComposableSingletons$BigBatteryPreferenceScreenKt.INSTANCE.m9838getLambda$1431904817$app_productionPFast();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(103210618, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.y
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$6$0(state, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.z
                    @Override // lb.a
                    public final Object invoke() {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$6$1$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9838getLambda$1431904817$app_productionPFast, null, false, composableLambdaRememberComposableLambda, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 3078, 0, 1942);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$6$0(State state, final MutableState mutableState, RowScope Z17TopBar, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(103210618, i10, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.BigBatteryPreferenceScreen.<anonymous>.<anonymous> (BigBatteryPreferenceScreen.kt:80)");
            }
            if (BigBatteryPreferenceScreen$lambda$0(state)) {
                composer.startReplaceGroup(-448506584);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-448998616);
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.a0
                        @Override // lb.a
                        public final Object invoke() {
                            return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$6$0$0$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue, PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, ComposableSingletons$BigBatteryPreferenceScreenKt.INSTANCE.getLambda$1858314337$app_productionPFast(), composer, 1572918, 60);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$6$0$0$0(MutableState mutableState) {
        BigBatteryPreferenceScreen$lambda$3(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$6$1$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7(final BatteryPreferenceViewModel batteryPreferenceViewModel, final u0 u0Var, final Context context, final State state, final MutableState mutableState, State state2, Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1226194556, i10, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.BigBatteryPreferenceScreen.<anonymous> (BigBatteryPreferenceScreen.kt:97)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(batteryPreferenceViewModel.getActualPreference(), new DataPreferences(false, false, false, false, false, false, false, false, false, false, null, 0, null, 8191, null), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ScrollKt.verticalScroll$default(companion, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String strStringResource = StringResources_androidKt.stringResource(R.string.eco_mode, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.eco_mode_description, composer, 0);
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            ImageVector batteryFull = BatteryFullKt.getBatteryFull(outlined);
            Other other = Other.INSTANCE;
            long jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(other.m10111getGreen0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null);
            boolean zD = kotlin.jvm.internal.y.d(BigBatteryPreferenceScreen$lambda$7$0(stateCollectAsStateWithLifecycle).getBatteryPreference(), DataPreferences.CON_ECO);
            boolean zChangedInstance = composer.changedInstance(batteryPreferenceViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$1$0$0(batteryPreferenceViewModel, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            BatteryPreferenceScreenKt.m9836BatteryModeItem3f6hBDE(companion, strStringResource, strStringResource2, batteryFull, jM5865copywmQWz5c$default, zD, (Function1) objRememberedValue, composer, 6, 0);
            BatteryPreferenceScreenKt.m9836BatteryModeItem3f6hBDE(companion, StringResources_androidKt.stringResource(R.string.balance_mode, composer, 0), StringResources_androidKt.stringResource(R.string.balance_mode_description, composer, 0), Battery4BarKt.getBattery4Bar(outlined), Color.m5865copywmQWz5c$default(other.m10114getOrange10d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), kotlin.jvm.internal.y.d(BigBatteryPreferenceScreen$lambda$7$0(stateCollectAsStateWithLifecycle).getBatteryPreference(), DataPreferences.CON_BALANCED), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.d0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$1$1(u0Var, context, batteryPreferenceViewModel, state, mutableState, ((Boolean) obj).booleanValue());
                }
            }, composer, 6, 0);
            BatteryPreferenceScreenKt.m9836BatteryModeItem3f6hBDE(companion, StringResources_androidKt.stringResource(R.string.full_time_mode, composer, 0), StringResources_androidKt.stringResource(R.string.full_time_mode_description, composer, 0), BatteryAlertKt.getBatteryAlert(outlined), Color.m5865copywmQWz5c$default(other.m10118getRed0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), kotlin.jvm.internal.y.d(BigBatteryPreferenceScreen$lambda$7$0(stateCollectAsStateWithLifecycle).getBatteryPreference(), DataPreferences.CON_FULL_TIME), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.e0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$1$2(u0Var, batteryPreferenceViewModel, state, mutableState, ((Boolean) obj).booleanValue());
                }
            }, composer, 6, 0);
            composer.endNode();
            boolean zBigBatteryPreferenceScreen$lambda$2 = BigBatteryPreferenceScreen$lambda$2(mutableState);
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.f0
                    @Override // lb.a
                    public final Object invoke() {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$2$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17DialogsKt.Z17CustomDialog(zBigBatteryPreferenceScreen$lambda$2, (lb.a) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-578843950, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.g0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$3(batteryPreferenceViewModel, context, mutableState, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 432);
            boolean zBigBatteryPreferenceScreen$lambda$4 = BigBatteryPreferenceScreen$lambda$4(state2);
            boolean zChangedInstance2 = composer.changedInstance(batteryPreferenceViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$4$0(batteryPreferenceViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Z17DialogsKt.Z17CustomDialog(zBigBatteryPreferenceScreen$lambda$4, (lb.a) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(1323450889, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.i0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$5(batteryPreferenceViewModel, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    private static final DataPreferences BigBatteryPreferenceScreen$lambda$7$0(State<DataPreferences> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$1$0$0(BatteryPreferenceViewModel batteryPreferenceViewModel, boolean z10) {
        batteryPreferenceViewModel.changeBatteryPreference(DataPreferences.CON_ECO);
        Context appContext = MainModule.INSTANCE.getInstance().getAppContext();
        kotlin.jvm.internal.y.g(appContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
        ToDusApp.manageAlive$default((ToDusApp) appContext, DataPreferences.CON_ECO, false, 2, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$1$1(u0 u0Var, Context context, BatteryPreferenceViewModel batteryPreferenceViewModel, State state, MutableState mutableState, boolean z10) {
        if (BigBatteryPreferenceScreen$lambda$0(state) || !u0Var.f36629c) {
            AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null && instanceOrNull.getIsServiceRunning()) {
                AliveUtility.INSTANCE.stopService(context);
            }
            batteryPreferenceViewModel.changeBatteryPreference(DataPreferences.CON_BALANCED);
            Context appContext = MainModule.INSTANCE.getInstance().getAppContext();
            kotlin.jvm.internal.y.g(appContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
            ToDusApp.manageAlive$default((ToDusApp) appContext, DataPreferences.CON_BALANCED, false, 2, null);
        } else {
            BigBatteryPreferenceScreen$lambda$3(mutableState, true);
            u0Var.f36629c = false;
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$1$2(u0 u0Var, BatteryPreferenceViewModel batteryPreferenceViewModel, State state, MutableState mutableState, boolean z10) {
        if (BigBatteryPreferenceScreen$lambda$0(state) || !u0Var.f36629c) {
            batteryPreferenceViewModel.changeBatteryPreference(DataPreferences.CON_FULL_TIME);
            Context appContext = MainModule.INSTANCE.getInstance().getAppContext();
            kotlin.jvm.internal.y.g(appContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
            ToDusApp.manageAlive$default((ToDusApp) appContext, DataPreferences.CON_FULL_TIME, false, 2, null);
        } else {
            BigBatteryPreferenceScreen$lambda$3(mutableState, true);
            u0Var.f36629c = false;
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$2$0(MutableState mutableState) {
        BigBatteryPreferenceScreen$lambda$3(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$3(final BatteryPreferenceViewModel batteryPreferenceViewModel, final Context context, final MutableState mutableState, final lb.a it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-578843950, i11, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.BigBatteryPreferenceScreen.<anonymous>.<anonymous> (BigBatteryPreferenceScreen.kt:164)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 20;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            boolean z10 = (i11 & 14) == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.t
                    @Override // lb.a
                    public final Object invoke() {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$3$0$0$0(it);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            AttachContainerKt.DialogToDusTopBar((lb.a) objRememberedValue, composer, 0);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(5)), composer, 6);
            String strStringResource = StringResources_androidKt.stringResource(R.string.battery_permissions, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, materialTheme.getTypography(composer, i12).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.for_battery_permissions, composer, 0), materialTheme.getTypography(composer, i12).getLabelLarge(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.ok, composer, 0);
            boolean zChangedInstance = composer.changedInstance(batteryPreferenceViewModel) | composer.changedInstance(context);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.b0
                    @Override // lb.a
                    public final Object invoke() {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$3$0$1$0(batteryPreferenceViewModel, context, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue2, strStringResource2, null, true, false, false, composer, 24576, 105);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$3$0$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$3$0$1$0(BatteryPreferenceViewModel batteryPreferenceViewModel, Context context, MutableState mutableState) {
        batteryPreferenceViewModel.batteryRequest(context);
        BigBatteryPreferenceScreen$lambda$3(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$4$0(BatteryPreferenceViewModel batteryPreferenceViewModel) {
        batteryPreferenceViewModel.getIsFirstTime().setValue(Boolean.FALSE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$5(final BatteryPreferenceViewModel batteryPreferenceViewModel, final lb.a it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1323450889, i11, -1, "cu.todus.android.uiCompose.main.screen.batteryPreference.BigBatteryPreferenceScreen.<anonymous>.<anonymous> (BigBatteryPreferenceScreen.kt:197)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 20;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            boolean z10 = (i11 & 14) == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.j0
                    @Override // lb.a
                    public final Object invoke() {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$5$0$0$0(it);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            AttachContainerKt.DialogToDusTopBar((lb.a) objRememberedValue, composer, 0);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(5)), composer, 6);
            String strStringResource = StringResources_androidKt.stringResource(R.string.app_suggestion, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, materialTheme.getTypography(composer, i12).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.select_current_use, composer, 0), materialTheme.getTypography(composer, i12).getLabelLarge(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.ok, composer, 0);
            boolean zChangedInstance = composer.changedInstance(batteryPreferenceViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.batteryPreference.u
                    @Override // lb.a
                    public final Object invoke() {
                        return BigBatteryPreferenceScreenKt.BigBatteryPreferenceScreen$lambda$7$5$0$1$0(batteryPreferenceViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue2, strStringResource2, null, true, false, false, composer, 24576, 105);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$5$0$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$7$5$0$1$0(BatteryPreferenceViewModel batteryPreferenceViewModel) {
        batteryPreferenceViewModel.getIsFirstTime().setValue(Boolean.FALSE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigBatteryPreferenceScreen$lambda$8(NavHostController navHostController, BatteryPreferenceViewModel batteryPreferenceViewModel, int i10, int i11, Composer composer, int i12) {
        BigBatteryPreferenceScreen(navHostController, batteryPreferenceViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
