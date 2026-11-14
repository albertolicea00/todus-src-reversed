package cu.todus.android.uiCompose.main.screen.editToDusId;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17MarkdownLabelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.a0;
import le.d0;
import le.f0;
import le.m;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\f²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\n8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/editToDusId/EditToDusIdViewModel;", "viewModel", "Lua/k0;", "EditToDusIdScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/editToDusId/EditToDusIdViewModel;Landroidx/compose/runtime/Composer;II)V", "", User.COLUMN_TODUS_ID, "toDusIdError", "", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EditToDusIdScreenKt {
    /* JADX WARN: Code duplicated, block: B:51:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f7  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void EditToDusIdScreen(final NavHostController navHostController, EditToDusIdViewModel editToDusIdViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        EditToDusIdViewModel editToDusIdViewModel2;
        final EditToDusIdViewModel editToDusIdViewModel3;
        final EditToDusIdViewModel editToDusIdViewModel4;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-66454828);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                editToDusIdViewModel2 = editToDusIdViewModel;
                int i13 = composerStartRestartGroup.changedInstance(editToDusIdViewModel2) ? 32 : 16;
                i12 |= i13;
            } else {
                editToDusIdViewModel2 = editToDusIdViewModel;
            }
            i12 |= i13;
        } else {
            editToDusIdViewModel2 = editToDusIdViewModel;
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
                    editToDusIdViewModel4 = (EditToDusIdViewModel) ViewModelKt.viewModel(z0.b(EditToDusIdViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i14 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-66454828, i14, -1, "cu.todus.android.uiCompose.main.screen.editToDusId.EditToDusIdScreen (EditToDusIdScreen.kt:47)");
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-890236920, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return EditToDusIdScreenKt.EditToDusIdScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1819939850, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.f
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return EditToDusIdScreenKt.EditToDusIdScreen$lambda$1(editToDusIdViewModel4, navHostController, context, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                editToDusIdViewModel3 = editToDusIdViewModel4;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 805306806, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            }
            editToDusIdViewModel4 = editToDusIdViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-66454828, i14, -1, "cu.todus.android.uiCompose.main.screen.editToDusId.EditToDusIdScreen (EditToDusIdScreen.kt:47)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-890236920, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditToDusIdScreenKt.EditToDusIdScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1819939850, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditToDusIdScreenKt.EditToDusIdScreen$lambda$1(editToDusIdViewModel4, navHostController, context2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            editToDusIdViewModel3 = editToDusIdViewModel4;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda3, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, composableLambdaRememberComposableLambda4, composerStartRestartGroup, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            editToDusIdViewModel3 = editToDusIdViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditToDusIdScreenKt.EditToDusIdScreen$lambda$2(navHostController, editToDusIdViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 EditToDusIdScreen$lambda$0(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-890236920, i10, -1, "cu.todus.android.uiCompose.main.screen.editToDusId.EditToDusIdScreen.<anonymous> (EditToDusIdScreen.kt:57)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$EditToDusIdScreenKt.INSTANCE.getLambda$1644311957$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:60:0x0319  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 EditToDusIdScreen$lambda$1(final EditToDusIdViewModel editToDusIdViewModel, final NavHostController navHostController, final Context context, Modifier it, Composer composer, int i10) {
        int i11;
        boolean z10;
        int i12;
        MutableState mutableState;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1819939850, i11, -1, "cu.todus.android.uiCompose.main.screen.editToDusId.EditToDusIdScreen.<anonymous> (EditToDusIdScreen.kt:68)");
            }
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue3;
            float f10 = 20;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(WindowInsetsPadding_androidKt.imePadding(it), 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical spaceBetween = arrangement.getSpaceBetween();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, companion2.getStart(), composer, 6);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion4);
            lb.a constructor2 = companion3.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
            int iM8500getEmailPjHm6EE = KeyboardType.INSTANCE.m8500getEmailPjHm6EE();
            String strEditToDusIdScreen$lambda$1$4 = EditToDusIdScreen$lambda$1$4(mutableState3);
            String strEditToDusIdScreen$lambda$1$1 = EditToDusIdScreen$lambda$1$1(mutableState2);
            String toDusId = editToDusIdViewModel.owner().getToDusId();
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditToDusIdScreenKt.EditToDusIdScreen$lambda$1$9$0$0$0(mutableState2, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, strEditToDusIdScreen$lambda$1$1, 0, 0, toDusId, strEditToDusIdScreen$lambda$1$4, (Function1) objRememberedValue4, ComposableSingletons$EditToDusIdScreenKt.INSTANCE.m9937getLambda$444891359$app_productionPFast(), null, 36, iM8500getEmailPjHm6EE, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 819462150, 6, 1046796);
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs2, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i13).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10));
            String strStringResource = StringResources_androidKt.stringResource(R.string.choose_a_todus_id_description, composer, 0);
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i13).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.i
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Z17MarkdownLabelKt.Z17MarkdownLabel(modifierM1725padding3ABfNKs3, strStringResource, textStyleM8271copyp1EtxEg$default, (lb.a) objRememberedValue5, null, composer, 3072, 16);
            Modifier modifierAlign = columnScopeInstance.align(companion4, companion2.getCenterHorizontally());
            boolean zChangedInstance = composer.changedInstance(editToDusIdViewModel) | composer.changedInstance(navHostController);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.j
                    @Override // lb.a
                    public final Object invoke() {
                        return EditToDusIdScreenKt.EditToDusIdScreen$lambda$1$9$0$2$0(editToDusIdViewModel, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(modifierAlign, (lb.a) objRememberedValue6, StringResources_androidKt.stringResource(R.string.keep_actual, composer, 0), null, false, true, false, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 88);
            composer.endNode();
            if (d0.q0(EditToDusIdScreen$lambda$1$1(mutableState2)) || EditToDusIdScreen$lambda$1$1(mutableState2).length() <= 3) {
                z10 = false;
            } else {
                if (new m("\\d").b(EditToDusIdScreen$lambda$1$1(mutableState2))) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.change, composer, 0);
            boolean zChangedInstance2 = composer.changedInstance(editToDusIdViewModel) | composer.changedInstance(navHostController) | composer.changedInstance(context);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue7 == companion.getEmpty()) {
                i12 = 0;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.k
                    @Override // lb.a
                    public final Object invoke() {
                        return EditToDusIdScreenKt.EditToDusIdScreen$lambda$1$9$1$0(editToDusIdViewModel, mutableState4, mutableState2, navHostController, mutableState3, context);
                    }
                };
                mutableState = mutableState4;
                composer.updateRememberedValue(aVar);
                objRememberedValue7 = aVar;
            } else {
                mutableState = mutableState4;
                i12 = 0;
            }
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue7, strStringResource2, null, true, z10, composer, 24576, 9);
            composer.endNode();
            if (EditToDusIdScreen$lambda$1$7(mutableState)) {
                composer.startReplaceGroup(910626103);
                LoadingScreenKt.LoadingWall(composer, i12);
            } else {
                composer.startReplaceGroup(-1835349384);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final String EditToDusIdScreen$lambda$1$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String EditToDusIdScreen$lambda$1$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean EditToDusIdScreen$lambda$1$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void EditToDusIdScreen$lambda$1$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditToDusIdScreen$lambda$1$9$0$0$0(MutableState mutableState, String nV) {
        y.i(nV, "nV");
        mutableState.setValue(a0.O(nV, " ", "_", false, 4, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditToDusIdScreen$lambda$1$9$0$2$0(EditToDusIdViewModel editToDusIdViewModel, NavHostController navHostController) {
        editToDusIdViewModel.keepToDusId();
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditToDusIdScreen$lambda$1$9$1$0(EditToDusIdViewModel editToDusIdViewModel, final MutableState mutableState, final MutableState mutableState2, final NavHostController navHostController, final MutableState mutableState3, final Context context) {
        EditToDusIdScreen$lambda$1$8(mutableState, true);
        editToDusIdViewModel.editToDusId(EditToDusIdScreen$lambda$1$1(mutableState2), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.c
            @Override // lb.a
            public final Object invoke() {
                return EditToDusIdScreenKt.EditToDusIdScreen$lambda$1$9$1$0$0(navHostController, mutableState, mutableState3);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.editToDusId.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EditToDusIdScreenKt.EditToDusIdScreen$lambda$1$9$1$0$1(context, mutableState, mutableState2, mutableState3, ((Boolean) obj).booleanValue());
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditToDusIdScreen$lambda$1$9$1$0$0(NavHostController navHostController, MutableState mutableState, MutableState mutableState2) {
        EditToDusIdScreen$lambda$1$8(mutableState, false);
        navHostController.navigateUp();
        mutableState2.setValue("");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditToDusIdScreen$lambda$1$9$1$0$1(Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, boolean z10) {
        String string;
        EditToDusIdScreen$lambda$1$8(mutableState, false);
        if (z10) {
            Character chV1 = f0.v1(EditToDusIdScreen$lambda$1$1(mutableState2));
            if (chV1 != null && Character.isDigit(chV1.charValue())) {
                string = context.getString(R.string.cannot_start_with_number);
                y.h(string, "getString(...)");
            } else if (a0.F(EditToDusIdScreen$lambda$1$1(mutableState2), "_", false, 2, null)) {
                string = context.getString(R.string.cannot_ends_in_);
                y.h(string, "getString(...)");
            } else {
                string = context.getString(R.string.cannot_have_accent_or_other);
                y.h(string, "getString(...)");
            }
            mutableState3.setValue(string);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditToDusIdScreen$lambda$2(NavHostController navHostController, EditToDusIdViewModel editToDusIdViewModel, int i10, int i11, Composer composer, int i12) {
        EditToDusIdScreen(navHostController, editToDusIdViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
