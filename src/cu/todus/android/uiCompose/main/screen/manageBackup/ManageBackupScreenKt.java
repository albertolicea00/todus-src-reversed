package cu.todus.android.uiCompose.main.screen.manageBackup;

import android.content.Context;
import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.x;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavHostController;
import androidx.p000activity.compose.ActivityResultRegistryKt;
import androidx.p000activity.compose.ManagedActivityResultLauncher;
import androidx.p000activity.result.contract.ActivityResultContracts;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.l;
import defpackage.r;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.a0;
import p0.n;
import ua.k0;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\f²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u0004\u0018\u00010\n8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/manageBackup/ManageBackupViewModel;", "viewModel", "Lua/k0;", "ManageBackupScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/manageBackup/ManageBackupViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "permissionsGranted", "Ll0/j;", "topAnimation", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ManageBackupScreenKt {
    /* JADX WARN: Code duplicated, block: B:36:0x0070  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ManageBackupScreen(final NavHostController navHostController, ManageBackupViewModel manageBackupViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        ManageBackupViewModel manageBackupViewModel2;
        final ManageBackupViewModel manageBackupViewModel3;
        boolean z10;
        Composer composer2;
        final ManageBackupViewModel manageBackupViewModel4;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-543729616);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                manageBackupViewModel2 = manageBackupViewModel;
                int i13 = composerStartRestartGroup.changedInstance(manageBackupViewModel2) ? 32 : 16;
                i12 |= i13;
            } else {
                manageBackupViewModel2 = manageBackupViewModel;
            }
            i12 |= i13;
        } else {
            manageBackupViewModel2 = manageBackupViewModel;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                    manageBackupViewModel4 = manageBackupViewModel2;
                    composer2 = composerStartRestartGroup;
                    z10 = true;
                } else {
                    composer2 = composerStartRestartGroup;
                    z10 = true;
                    manageBackupViewModel4 = manageBackupViewModel2;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                z10 = true;
                composer2 = composerStartRestartGroup;
                manageBackupViewModel4 = (ManageBackupViewModel) ViewModelKt.viewModel(z0.b(ManageBackupViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer2, 0, 0);
                i14 &= -113;
            } else {
                composer2 = composerStartRestartGroup;
                z10 = true;
                manageBackupViewModel4 = manageBackupViewModel2;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-543729616, i14, -1, "cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupScreen (ManageBackupScreen.kt:45)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, 3);
            final Context context = (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ActivityResultContracts.GetContent getContent = new ActivityResultContracts.GetContent();
            boolean zChangedInstance = composer2.changedInstance(context) | composer2.changedInstance(manageBackupViewModel4);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ManageBackupScreenKt.ManageBackupScreen$lambda$6$0(context, manageBackupViewModel4, mutableState, (Uri) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent, (Function1) objRememberedValue3, composer2, 0);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-163073180, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ManageBackupScreenKt.ManageBackupScreen$lambda$7(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ManageBackupScreenKt.ManageBackupScreen$lambda$8(manageBackupViewModel4, context, mutableState, mutableState2, managedActivityResultLauncherRememberLauncherForActivityResult, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            manageBackupViewModel3 = manageBackupViewModel4;
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-78911898, z10, function3, composer2, 54);
            composerStartRestartGroup = composer2;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            manageBackupViewModel3 = manageBackupViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ManageBackupScreenKt.ManageBackupScreen$lambda$9(navHostController, manageBackupViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ManageBackupScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ManageBackupScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ManageBackupScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ManageBackupScreen$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageBackupScreen$lambda$6$0(Context context, ManageBackupViewModel manageBackupViewModel, final MutableState mutableState, Uri uri) {
        if (uri != null) {
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            File file = new File(path);
            String path2 = file.getPath();
            y.h(path2, "getPath(...)");
            if (a0.F(path2, ".tdb", false, 2, null)) {
                ManageBackupScreen$lambda$2(mutableState, true);
                manageBackupViewModel.m9943import(file, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.j
                    @Override // lb.a
                    public final Object invoke() {
                        return ManageBackupScreenKt.ManageBackupScreen$lambda$6$0$0$0(mutableState);
                    }
                });
            } else {
                manageBackupViewModel.notABackupFile();
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageBackupScreen$lambda$6$0$0$0(MutableState mutableState) {
        ManageBackupScreen$lambda$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ManageBackupScreen$lambda$7(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-163073180, i10, -1, "cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupScreen.<anonymous> (ManageBackupScreen.kt:79)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$ManageBackupScreenKt.INSTANCE.m9942getLambda$981317007$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
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
    public static final k0 ManageBackupScreen$lambda$8(final ManageBackupViewModel manageBackupViewModel, Context context, MutableState mutableState, MutableState mutableState2, final ManagedActivityResultLauncher managedActivityResultLauncher, Modifier it, Composer composer, int i10) {
        int i11;
        final MutableState mutableState3;
        final MutableState mutableState4;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-78911898, i11, -1, "cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupScreen.<anonymous> (ManageBackupScreen.kt:90)");
            }
            float f10 = 20;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxSize$default(it, 0.0f, 1, null), Dp.m8823constructorimpl(f10), 0.0f, 2, null);
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion.getCenterHorizontally(), composer, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            p0.l lVarQ = p0.r.q(n.a.a(n.a.b(R.raw.importing)), null, null, null, null, null, composer, 0, 62);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            float f11 = 5;
            p0.e.a(ManageBackupScreen$lambda$8$0$0(lVarQ), columnScopeInstance.align(PaddingKt.m1725padding3ABfNKs(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(100)), Dp.m8823constructorimpl(f11)), companion.getCenterHorizontally()), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572864, 0, 0, 4194236);
            String strStringResource = StringResources_androidKt.stringResource(R.string.recover_your_chats, composer, 0);
            Modifier modifierAlign = columnScopeInstance.align(PaddingKt.m1725padding3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), companion.getCenterHorizontally());
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierAlign, strStringResource, materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 56);
            Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(PaddingKt.m1725padding3ABfNKs(companion3, Dp.m8823constructorimpl(15)), companion.getCenterHorizontally()), StringResources_androidKt.stringResource(R.string.use_a_save_file, composer, 0), materialTheme.getTypography(composer, i12).getLabelSmall(), 0L, 0, 0, composer, 0, 56);
            Modifier modifierAlign2 = columnScopeInstance.align(companion3, companion.getCenterHorizontally());
            boolean zChangedInstance = composer.changedInstance(manageBackupViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState3 = mutableState;
                mutableState4 = mutableState2;
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.c
                    @Override // lb.a
                    public final Object invoke() {
                        return ManageBackupScreenKt.ManageBackupScreen$lambda$8$0$1$0(manageBackupViewModel, mutableState3, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                mutableState3 = mutableState;
                mutableState4 = mutableState2;
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(modifierAlign2, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.export_chats, composer, 0), null, false, true, false, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 88);
            SpacerKt.Spacer(x.a(columnScopeInstance, companion3, 1.0f, false, 2, null), composer, 0);
            List listE = v.e(PermissionNeedIt.STORAGE);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.d
                    @Override // lb.a
                    public final Object invoke() {
                        return ManageBackupScreenKt.ManageBackupScreen$lambda$8$0$2$0(mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            String packageName = context.getPackageName();
            y.h(packageName, "getPackageName(...)");
            Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listE, (lb.a) objRememberedValue2, null, packageName, null, composer, 3456, 83);
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, ManageBackupScreen$lambda$4(mutableState4), PaddingKt.m1729paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 7, null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1336468940, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ManageBackupScreenKt.ManageBackupScreen$lambda$8$0$3(managedActivityResultLauncher, mutableState4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573254, 28);
            composer.endNode();
            if (ManageBackupScreen$lambda$1(mutableState3)) {
                composer.startReplaceGroup(1475160371);
                LoadingScreenKt.LoadingWall(composer, 0);
            } else {
                composer.startReplaceGroup(-1514656260);
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

    private static final l0.j ManageBackupScreen$lambda$8$0$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageBackupScreen$lambda$8$0$1$0(ManageBackupViewModel manageBackupViewModel, final MutableState mutableState, MutableState mutableState2) {
        ManageBackupScreen$lambda$2(mutableState, true);
        if (ManageBackupScreen$lambda$4(mutableState2)) {
            manageBackupViewModel.export(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.b
                @Override // lb.a
                public final Object invoke() {
                    return ManageBackupScreenKt.ManageBackupScreen$lambda$8$0$1$0$0(mutableState);
                }
            });
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageBackupScreen$lambda$8$0$1$0$0(MutableState mutableState) {
        ManageBackupScreen$lambda$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageBackupScreen$lambda$8$0$2$0(MutableState mutableState) {
        ManageBackupScreen$lambda$5(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ManageBackupScreen$lambda$8$0$3(final ManagedActivityResultLauncher managedActivityResultLauncher, final MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1336468940, i10, -1, "cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupScreen.<anonymous>.<anonymous>.<anonymous> (ManageBackupScreen.kt:152)");
        }
        boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageBackup.k
                @Override // lb.a
                public final Object invoke() {
                    return ManageBackupScreenKt.ManageBackupScreen$lambda$8$0$3$0$0(managedActivityResultLauncher, mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.search, composer, 0), null, true, false, composer, 24576, 41);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageBackupScreen$lambda$8$0$3$0$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        if (ManageBackupScreen$lambda$4(mutableState)) {
            managedActivityResultLauncher.launch("*/*");
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageBackupScreen$lambda$9(NavHostController navHostController, ManageBackupViewModel manageBackupViewModel, int i10, int i11, Composer composer, int i12) {
        ManageBackupScreen(navHostController, manageBackupViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
