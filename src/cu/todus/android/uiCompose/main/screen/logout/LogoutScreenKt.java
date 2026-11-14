package cu.todus.android.uiCompose.main.screen.logout;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.LogoutKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.ImportExportKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import cu.todus.android.R;
import cu.todus.android.ToDusApp;
import cu.todus.android.uiCompose.main.screen.logout.LogoutScreenKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.RichTitleDescBtnKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import l0.j;
import lb.a;
import p0.e;
import p0.n;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t²\u0006\u000e\u0010\u0006\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\b\u001a\u0004\u0018\u00010\u00078\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lua/k0;", "LogoutScreen", "(Landroidx/navigation/NavHostController;Landroidx/compose/runtime/Composer;I)V", "", "showConfirmationDialogForLogout", "Ll0/j;", "animation", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LogoutScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LogoutScreen(final NavHostController navHostController, Composer composer, final int i10) {
        int i11;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(218647996);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(218647996, i11, -1, "cu.todus.android.uiCompose.main.screen.logout.LogoutScreen (LogoutScreen.kt:44)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-226824976, true, new Function3() { // from class: z7.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LogoutScreenKt.LogoutScreen$lambda$3(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(220187122, true, new Function3() { // from class: z7.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LogoutScreenKt.LogoutScreen$lambda$4(context, navHostController, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: z7.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LogoutScreenKt.LogoutScreen$lambda$5(navHostController, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean LogoutScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LogoutScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 LogoutScreen$lambda$3(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-226824976, i10, -1, "cu.todus.android.uiCompose.main.screen.logout.LogoutScreen.<anonymous> (LogoutScreen.kt:57)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$LogoutScreenKt.INSTANCE.m9941getLambda$1407494915$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
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
    public static final k0 LogoutScreen$lambda$4(final Context context, final NavHostController navHostController, final MutableState mutableState, Modifier it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(220187122, i11, -1, "cu.todus.android.uiCompose.main.screen.logout.LogoutScreen.<anonymous> (LogoutScreen.kt:68)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(it, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), composer, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            p0.l lVarQ = p0.r.q(n.a.a(n.a.b(R.raw.log_out_lottie)), null, null, null, null, null, composer, 0, 62);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            e.a(LogoutScreen$lambda$4$0$0(lVarQ), SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(100)), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572912, 0, 0, 4194236);
            ImageVector logout = LogoutKt.getLogout(Icons.AutoMirrored.Outlined.INSTANCE);
            String strStringResource = StringResources_androidKt.stringResource(R.string.logout_desc, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.logout, composer, 0);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = new a() { // from class: z7.b
                    @Override // lb.a
                    public final Object invoke() {
                        return LogoutScreenKt.LogoutScreen$lambda$4$0$1$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(logout, strStringResource2, strStringResource, 0L, (a) objRememberedValue, composer, 24576, 8);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(30)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.maybe_you_want, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            ImageVector importExport = ImportExportKt.getImportExport(outlined);
            String str = StringResources_androidKt.stringResource(R.string.import_chats, composer, 0) + "\n" + StringResources_androidKt.stringResource(R.string.export_chats, composer, 0);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.manage_backups, composer, 0);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new a() { // from class: z7.c
                    @Override // lb.a
                    public final Object invoke() {
                        return LogoutScreenKt.LogoutScreen$lambda$4$0$2$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(importExport, strStringResource3, str, 0L, (a) objRememberedValue2, composer, 0, 8);
            ImageVector edit = EditKt.getEdit(outlined);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.edit_profile_desc, composer, 0);
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.edit_profile, composer, 0);
            boolean zChangedInstance2 = composer.changedInstance(navHostController);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = new a() { // from class: z7.d
                    @Override // lb.a
                    public final Object invoke() {
                        return LogoutScreenKt.LogoutScreen$lambda$4$0$3$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(edit, strStringResource5, strStringResource4, 0L, (a) objRememberedValue3, composer, 0, 8);
            composer.endNode();
            String strStringResource6 = StringResources_androidKt.stringResource(R.string.please_confirm, composer, 0);
            String strStringResource7 = StringResources_androidKt.stringResource(R.string.sure_to_delete_all_personal_data_in_this_device, composer, 0);
            boolean zLogoutScreen$lambda$1 = LogoutScreen$lambda$1(mutableState);
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = new a() { // from class: z7.e
                    @Override // lb.a
                    public final Object invoke() {
                        return LogoutScreenKt.LogoutScreen$lambda$4$1$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            a aVar = (a) objRememberedValue4;
            boolean zChangedInstance3 = composer.changedInstance(context);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == companion3.getEmpty()) {
                objRememberedValue5 = new a() { // from class: z7.f
                    @Override // lb.a
                    public final Object invoke() {
                        return LogoutScreenKt.LogoutScreen$lambda$4$2$0(context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Z17DialogsKt.Z17DialogWithActions(zLogoutScreen$lambda$1, aVar, (a) objRememberedValue5, null, strStringResource6, strStringResource7, null, null, composer, 48, 200);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final j LogoutScreen$lambda$4$0$0(p0.l lVar) {
        return (j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LogoutScreen$lambda$4$0$1$0(MutableState mutableState) {
        LogoutScreen$lambda$2(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LogoutScreen$lambda$4$0$2$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.MANAGE_BACKUP, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LogoutScreen$lambda$4$0$3$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.EDIT_PROFILE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LogoutScreen$lambda$4$1$0(MutableState mutableState) {
        LogoutScreen$lambda$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LogoutScreen$lambda$4$2$0(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            y.g(applicationContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
            ((ToDusApp) applicationContext).logout();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LogoutScreen$lambda$5(NavHostController navHostController, int i10, Composer composer, int i11) {
        LogoutScreen(navHostController, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
