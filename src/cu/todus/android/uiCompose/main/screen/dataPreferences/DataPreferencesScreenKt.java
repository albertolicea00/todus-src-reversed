package cu.todus.android.uiCompose.main.screen.dataPreferences;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
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
import cu.todus.android.data.preferences.CallQuality;
import cu.todus.android.data.preferences.DataPreferences;
import cu.todus.android.volatileState.AppVolatileState;
import cu.z17.views.check.Z17CheckKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import cu.z17.views.topBar.Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a;\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001a²\u0006\f\u0010\u0017\u001a\u00020\u00168\nX\u008a\u0084\u0002²\u0006\f\u0010\u0019\u001a\u00020\u00188\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/dataPreferences/DataPreferencesViewModel;", "viewModel", "Lua/k0;", "DataPreferencesScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/dataPreferences/DataPreferencesViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isCheck", "", "label", "Lkotlin/Function0;", "onClick", "CheckWithLabel", "(ZLjava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "descriptionLabel", "", "startValue", "Lkotlin/Function1;", "onValueSet", "QualitySelector", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/data/preferences/DataPreferences;", "state", "Lcu/todus/android/data/preferences/CallQuality;", "callQuality", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DataPreferencesScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CheckWithLabel(boolean z10, String label, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        final boolean z11;
        final String str;
        kotlin.jvm.internal.y.i(label, "label");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-756214618);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-756214618, i12, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.CheckWithLabel (DataPreferencesScreen.kt:409)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            int i13 = i12 & 896;
            boolean z12 = i13 == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.t
                    @Override // lb.a
                    public final Object invoke() {
                        return DataPreferencesScreenKt.CheckWithLabel$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(5));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean z13 = i13 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.CheckWithLabel$lambda$1$0$0(onClick, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Z17CheckKt.Z17Check(null, z10, (Function1) objRememberedValue2, composerStartRestartGroup, (i12 << 3) & 112, 1);
            z11 = z10;
            str = label;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, i12 & 112, 57);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z11 = z10;
            str = label;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataPreferencesScreenKt.CheckWithLabel$lambda$2(z11, str, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CheckWithLabel$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CheckWithLabel$lambda$1$0$0(lb.a aVar, boolean z10) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CheckWithLabel$lambda$2(boolean z10, String str, lb.a aVar, int i10, Composer composer, int i11) {
        CheckWithLabel(z10, str, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DataPreferencesScreen(final NavHostController navHostController, DataPreferencesViewModel dataPreferencesViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        int i13;
        final DataPreferencesViewModel dataPreferencesViewModel2 = dataPreferencesViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1365795944);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i13 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(dataPreferencesViewModel2) : composerStartRestartGroup.changedInstance(dataPreferencesViewModel2)) {
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
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                dataPreferencesViewModel2 = (DataPreferencesViewModel) ViewModelKt.viewModel(z0.b(DataPreferencesViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i14 &= -113;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1365795944, i14, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.DataPreferencesScreen (DataPreferencesScreen.kt:63)");
            }
            composer2 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-435842660, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DataPreferencesScreenKt.DataPreferencesScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(2086359454, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.x
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1(dataPreferencesViewModel2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataPreferencesScreenKt.DataPreferencesScreen$lambda$2(navHostController, dataPreferencesViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 DataPreferencesScreen$lambda$0(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-435842660, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.DataPreferencesScreen.<anonymous> (DataPreferencesScreen.kt:69)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$DataPreferencesScreenKt.INSTANCE.getLambda$331152681$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 DataPreferencesScreen$lambda$1(final DataPreferencesViewModel dataPreferencesViewModel, Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2086359454, i10, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.DataPreferencesScreen.<anonymous> (DataPreferencesScreen.kt:80)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 20;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getStart(), composer, 54);
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
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(dataPreferencesViewModel.getDataPreferences(), new DataPreferences(false, false, false, false, false, false, false, false, false, false, null, 0, null, 8191, null), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            String strStringResource = StringResources_androidKt.stringResource(R.string.image_quality, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.image_quality_desc, composer, 0);
            AppVolatileState.Companion companion3 = AppVolatileState.INSTANCE;
            int uploadQuality = companion3.getInstance().getUploadQuality();
            boolean zChangedInstance = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$1$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            QualitySelector(strStringResource, strStringResource2, uploadQuality, (Function1) objRememberedValue, composer, 0);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(companion3.getInstance().getCallQuality(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.upload_call_quality, composer, 0);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.upload_call_quality_desc, composer, 0);
            int sendQuality = DataPreferencesScreen$lambda$1$0$2(stateCollectAsStateWithLifecycle2).getSendQuality();
            boolean zChangedInstance2 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$3$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle2, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            QualitySelector(strStringResource3, strStringResource4, sendQuality, (Function1) objRememberedValue2, composer, 0);
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.download_call_quality, composer, 0);
            String strStringResource6 = StringResources_androidKt.stringResource(R.string.download_call_quality_desc, composer, 0);
            int receivingQuality = DataPreferencesScreen$lambda$1$0$2(stateCollectAsStateWithLifecycle2).getReceivingQuality();
            boolean zChangedInstance3 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle2);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$4$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle2, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            QualitySelector(strStringResource5, strStringResource6, receivingQuality, (Function1) objRememberedValue3, composer, 0);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            float f11 = 30;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            String strStringResource7 = StringResources_androidKt.stringResource(R.string.automatic_download, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource7, materialTheme.getTypography(composer, i11).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
            float f12 = 10;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean autoDownloadImages = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getAutoDownloadImages();
            boolean zChangedInstance4 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$5$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposableSingletons$DataPreferencesScreenKt composableSingletons$DataPreferencesScreenKt = ComposableSingletons$DataPreferencesScreenKt.INSTANCE;
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default, autoDownloadImages, (Function1) objRememberedValue4, composableSingletons$DataPreferencesScreenKt.getLambda$1096798119$app_productionPFast(), StringResources_androidKt.stringResource(R.string.images, composer, 0), null, null, composer, 3078, 96);
            Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean autoDownloadVideos = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getAutoDownloadVideos();
            boolean zChangedInstance5 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$6$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default2, autoDownloadVideos, (Function1) objRememberedValue5, composableSingletons$DataPreferencesScreenKt.getLambda$562341982$app_productionPFast(), StringResources_androidKt.stringResource(R.string.videos, composer, 0), null, null, composer, 3078, 96);
            Modifier modifierM1727paddingVpY3zN4$default3 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean autoDownloadAudios = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getAutoDownloadAudios();
            boolean zChangedInstance6 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$7$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default3, autoDownloadAudios, (Function1) objRememberedValue6, composableSingletons$DataPreferencesScreenKt.getLambda$1659659871$app_productionPFast(), StringResources_androidKt.stringResource(R.string.audios, composer, 0), null, null, composer, 3078, 96);
            Modifier modifierM1727paddingVpY3zN4$default4 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean autoDownloadVoice = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getAutoDownloadVoice();
            boolean zChangedInstance7 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$8$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default4, autoDownloadVoice, (Function1) objRememberedValue7, composableSingletons$DataPreferencesScreenKt.m9929getLambda$1537989536$app_productionPFast(), StringResources_androidKt.stringResource(R.string.voice_msg, composer, 0), null, null, composer, 3078, 96);
            Modifier modifierM1727paddingVpY3zN4$default5 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean autoDownloadFiles = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getAutoDownloadFiles();
            boolean zChangedInstance8 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$9$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default5, autoDownloadFiles, (Function1) objRememberedValue8, composableSingletons$DataPreferencesScreenKt.m9932getLambda$440671647$app_productionPFast(), StringResources_androidKt.stringResource(R.string.files, composer, 0), null, null, composer, 3078, 96);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.save_in_public_folder, composer, 0), materialTheme.getTypography(composer, i11).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
            Modifier modifierM1727paddingVpY3zN4$default6 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean publicImages = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getPublicImages();
            boolean zChangedInstance9 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance9 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$10$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default6, publicImages, (Function1) objRememberedValue9, composableSingletons$DataPreferencesScreenKt.getLambda$656646242$app_productionPFast(), StringResources_androidKt.stringResource(R.string.images, composer, 0), null, null, composer, 3078, 96);
            Modifier modifierM1727paddingVpY3zN4$default7 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean publicVideos = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getPublicVideos();
            boolean zChangedInstance10 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$11$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default7, publicVideos, (Function1) objRememberedValue10, composableSingletons$DataPreferencesScreenKt.getLambda$1753964131$app_productionPFast(), StringResources_androidKt.stringResource(R.string.videos, composer, 0), null, null, composer, 3078, 96);
            Modifier modifierM1727paddingVpY3zN4$default8 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean publicAudios = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getPublicAudios();
            boolean zChangedInstance11 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue11 = composer.rememberedValue();
            if (zChangedInstance11 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$12$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default8, publicAudios, (Function1) objRememberedValue11, composableSingletons$DataPreferencesScreenKt.m9928getLambda$1443685276$app_productionPFast(), StringResources_androidKt.stringResource(R.string.audios, composer, 0), null, null, composer, 3078, 96);
            Modifier modifierM1727paddingVpY3zN4$default9 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean publicVoice = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getPublicVoice();
            boolean zChangedInstance12 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue12 = composer.rememberedValue();
            if (zChangedInstance12 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$13$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default9, publicVoice, (Function1) objRememberedValue12, composableSingletons$DataPreferencesScreenKt.m9931getLambda$346367387$app_productionPFast(), StringResources_androidKt.stringResource(R.string.voice_msg, composer, 0), null, null, composer, 3078, 96);
            Modifier modifierM1727paddingVpY3zN4$default10 = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f12), 1, null);
            boolean publicFiles = DataPreferencesScreen$lambda$1$0$0(stateCollectAsStateWithLifecycle).getPublicFiles();
            boolean zChangedInstance13 = composer.changedInstance(dataPreferencesViewModel) | composer.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue13 = composer.rememberedValue();
            if (zChangedInstance13 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.DataPreferencesScreen$lambda$1$0$14$0(dataPreferencesViewModel, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue13);
            }
            Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default10, publicFiles, (Function1) objRememberedValue13, composableSingletons$DataPreferencesScreenKt.getLambda$750950502$app_productionPFast(), StringResources_androidKt.stringResource(R.string.files, composer, 0), null, null, composer, 3078, 96);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            composer.startReplaceGroup(1145859694);
            composer.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f12)), composer, 6);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final DataPreferences DataPreferencesScreen$lambda$1$0$0(State<DataPreferences> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$1$0(DataPreferencesViewModel dataPreferencesViewModel, State state, int i10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, false, false, false, false, false, null, i10, null, 6143, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$10$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), z10, false, false, false, false, false, false, false, false, false, null, 0, null, 8190, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$11$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, z10, false, false, false, false, false, false, false, false, null, 0, null, 8189, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$12$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, z10, false, false, false, false, false, false, false, null, 0, null, 8187, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$13$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, z10, false, false, false, false, false, false, null, 0, null, 8183, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$14$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, z10, false, false, false, false, false, null, 0, null, 8175, null));
        return k0.f43947a;
    }

    private static final k0 DataPreferencesScreen$lambda$1$0$15$0(DataPreferencesViewModel dataPreferencesViewModel, State state) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, false, false, false, false, false, null, 0, "webp", 4095, null));
        return k0.f43947a;
    }

    private static final k0 DataPreferencesScreen$lambda$1$0$16$0(DataPreferencesViewModel dataPreferencesViewModel, State state) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, false, false, false, false, false, null, 0, "png", 4095, null));
        return k0.f43947a;
    }

    private static final k0 DataPreferencesScreen$lambda$1$0$17$0(DataPreferencesViewModel dataPreferencesViewModel, State state) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, false, false, false, false, false, null, 0, "jpeg", 4095, null));
        return k0.f43947a;
    }

    private static final CallQuality DataPreferencesScreen$lambda$1$0$2(State<CallQuality> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$3$0(DataPreferencesViewModel dataPreferencesViewModel, State state, int i10) {
        dataPreferencesViewModel.changeCallQuality(CallQuality.copy$default(DataPreferencesScreen$lambda$1$0$2(state), i10, 0, 2, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$4$0(DataPreferencesViewModel dataPreferencesViewModel, State state, int i10) {
        dataPreferencesViewModel.changeCallQuality(CallQuality.copy$default(DataPreferencesScreen$lambda$1$0$2(state), 0, i10, 1, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$5$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, z10, false, false, false, false, null, 0, null, 8159, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$6$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, false, z10, false, false, false, null, 0, null, 8127, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$7$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, false, false, z10, false, false, null, 0, null, 8063, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$8$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, false, false, false, z10, false, null, 0, null, 7935, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$1$0$9$0(DataPreferencesViewModel dataPreferencesViewModel, State state, boolean z10) {
        dataPreferencesViewModel.updateDataPreferences(DataPreferences.copy$default(DataPreferencesScreen$lambda$1$0$0(state), false, false, false, false, false, false, false, false, false, z10, null, 0, null, 7679, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DataPreferencesScreen$lambda$2(NavHostController navHostController, DataPreferencesViewModel dataPreferencesViewModel, int i10, int i11, Composer composer, int i12) {
        DataPreferencesScreen(navHostController, dataPreferencesViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void QualitySelector(final String label, final String descriptionLabel, int i10, Function1 function1, Composer composer, final int i11) {
        int i12;
        final int i13;
        final Function1 onValueSet = function1;
        kotlin.jvm.internal.y.i(label, "label");
        kotlin.jvm.internal.y.i(descriptionLabel, "descriptionLabel");
        kotlin.jvm.internal.y.i(onValueSet, "onValueSet");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1614555307);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(label) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(descriptionLabel) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onValueSet) ? 2048 : 1024;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 1171) != 1170, i14 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1614555307, i14, -1, "cu.todus.android.uiCompose.main.screen.dataPreferences.QualitySelector (DataPreferencesScreen.kt:435)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, label, materialTheme.getTypography(composerStartRestartGroup, i15).getTitleMedium(), 0L, 0, 0, composerStartRestartGroup, (i14 << 3) & 112, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(5)), composerStartRestartGroup, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), descriptionLabel, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8694getJustifye0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composerStartRestartGroup, (i14 & 112) | 6, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            i13 = i10;
            float f10 = i13;
            boolean z10 = (i14 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                onValueSet = function1;
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DataPreferencesScreenKt.QualitySelector$lambda$0$0$0(onValueSet, ((Float) obj).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                onValueSet = function1;
            }
            Function1 function2 = (Function1) objRememberedValue;
            rb.b bVarB = rb.j.b(1.0f, 3.0f);
            ComposableSingletons$DataPreferencesScreenKt composableSingletons$DataPreferencesScreenKt = ComposableSingletons$DataPreferencesScreenKt.INSTANCE;
            defpackage.b0.l(null, f10, function2, bVarB, 0, false, false, false, composableSingletons$DataPreferencesScreenKt.getLambda$1587491476$app_productionPFast(), composableSingletons$DataPreferencesScreenKt.m9930getLambda$1960766284$app_productionPFast(), null, null, composerStartRestartGroup, 905969664, 0, 3313);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(20)), composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            i13 = i10;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function3 = onValueSet;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.dataPreferences.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataPreferencesScreenKt.QualitySelector$lambda$1(label, descriptionLabel, i13, function3, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 QualitySelector$lambda$0$0$0(Function1 function1, float f10) {
        function1.invoke(Integer.valueOf((int) f10));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 QualitySelector$lambda$1(String str, String str2, int i10, Function1 function1, int i11, Composer composer, int i12) {
        QualitySelector(str, str2, i10, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return k0.f43947a;
    }
}
