package cu.todus.android.uiCompose.main.screen.editProfile;

import android.net.Uri;
import android.os.Build;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
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
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.camera.CameraKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.d0;
import ua.k0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/editProfile/EditProfileViewModel;", "viewModel", "Lua/k0;", "EditInfoProfileScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/editProfile/EditProfileViewModel;Landroidx/compose/runtime/Composer;II)V", "", "openCamera", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EditProfileScreenKt {
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void EditInfoProfileScreen(final NavHostController navHostController, EditProfileViewModel editProfileViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        EditProfileViewModel editProfileViewModel2;
        Composer composer2;
        final EditProfileViewModel editProfileViewModel3;
        Composer composer3;
        EditProfileViewModel editProfileViewModel4;
        int i13;
        String info;
        String alias;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(267578292);
        if ((i10 & 6) == 0) {
            i12 = i10 | (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2);
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                editProfileViewModel2 = editProfileViewModel;
                int i14 = composerStartRestartGroup.changedInstance(editProfileViewModel2) ? 32 : 16;
                i12 |= i14;
            } else {
                editProfileViewModel2 = editProfileViewModel;
            }
            i12 |= i14;
        } else {
            editProfileViewModel2 = editProfileViewModel;
        }
        int i15 = i12;
        if (composerStartRestartGroup.shouldExecute((i15 & 19) != 18, i15 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i15 &= -113;
                    editProfileViewModel4 = editProfileViewModel2;
                    composer3 = composerStartRestartGroup;
                } else {
                    composer3 = composerStartRestartGroup;
                    editProfileViewModel4 = editProfileViewModel2;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                composer3 = composerStartRestartGroup;
                i15 &= -113;
                editProfileViewModel4 = (EditProfileViewModel) ViewModelKt.viewModel(z0.b(EditProfileViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer3, 0, 0);
            } else {
                composer3 = composerStartRestartGroup;
                editProfileViewModel4 = editProfileViewModel2;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(267578292, i15, -1, "cu.todus.android.uiCompose.main.screen.editProfile.EditInfoProfileScreen (EditProfileScreen.kt:60)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer3, 0, 3);
            final c1.a aVarC = c1.d.c(Build.VERSION.SDK_INT >= 33 ? w.q("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES") : w.q("android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE"), null, composer3, 0, 2);
            final FocusManager focusManager = (FocusManager) composer3.consume(CompositionLocalsKt.getLocalFocusManager());
            Composer composer4 = composer3;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(editProfileViewModel4.getOwnerData(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 0, 7);
            Object objRememberedValue = composer4.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                if (((Owner) stateCollectAsStateWithLifecycle.getValue()).getAlias().length() > 200) {
                    String strSubstring = ((Owner) stateCollectAsStateWithLifecycle.getValue()).getAlias().substring(0, 200);
                    y.h(strSubstring, "substring(...)");
                    alias = strSubstring.substring(0, 200);
                    y.h(alias, "substring(...)");
                } else {
                    alias = ((Owner) stateCollectAsStateWithLifecycle.getValue()).getAlias();
                }
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(alias, null, 2, null);
                composer4.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer4.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer4.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composer4.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                if (((Owner) stateCollectAsStateWithLifecycle.getValue()).getInfo().length() > 200) {
                    String strSubstring2 = ((Owner) stateCollectAsStateWithLifecycle.getValue()).getInfo().substring(0, 200);
                    y.h(strSubstring2, "substring(...)");
                    info = strSubstring2.substring(0, 200);
                    y.h(info, "substring(...)");
                } else {
                    info = ((Owner) stateCollectAsStateWithLifecycle.getValue()).getInfo();
                }
                i13 = 2;
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(info, null, 2, null);
                composer4.updateRememberedValue(objRememberedValue3);
            } else {
                i13 = 2;
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composer4.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(((Owner) stateCollectAsStateWithLifecycle.getValue()).getPhotoUrl(), null, i13, null);
                composer4.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = composer4.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i13, null);
                composer4.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue5;
            Object objRememberedValue6 = composer4.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer4.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue6 = mutableStateMutableStateOf$default;
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue6;
            Object objRememberedValue7 = composer4.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer4.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue7;
            editProfileViewModel3 = editProfileViewModel4;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(648234728, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditProfileScreenKt.EditInfoProfileScreen$lambda$11(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(732396010, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditProfileScreenKt.EditInfoProfileScreen$lambda$12(editProfileViewModel3, mutableState5, mutableState4, focusManager, aVarC, mutableState2, mutableState, mutableState3, stateCollectAsStateWithLifecycle, navHostController, mutableState6, mutableState7, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), composer4, 805306806, 376);
            composer2 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            editProfileViewModel3 = editProfileViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditProfileScreenKt.EditInfoProfileScreen$lambda$13(navHostController, editProfileViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void EditInfoProfileScreen$lambda$10(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 EditInfoProfileScreen$lambda$11(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(648234728, i10, -1, "cu.todus.android.uiCompose.main.screen.editProfile.EditInfoProfileScreen.<anonymous> (EditProfileScreen.kt:120)");
            }
            Function2 function2M9936getLambda$170009099$app_productionPFast = ComposableSingletons$EditProfileScreenKt.INSTANCE.m9936getLambda$170009099$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.k
                    @Override // lb.a
                    public final Object invoke() {
                        return EditProfileScreenKt.EditInfoProfileScreen$lambda$11$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9936getLambda$170009099$app_productionPFast, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$11$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 EditInfoProfileScreen$lambda$12(final EditProfileViewModel editProfileViewModel, final MutableState mutableState, final MutableState mutableState2, final FocusManager focusManager, final c1.a aVar, MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final State state, final NavHostController navHostController, final MutableState mutableState6, final MutableState mutableState7, Modifier it, Composer composer, int i10) {
        int i11;
        int i12;
        char c10;
        final MutableState mutableState8;
        final EditProfileViewModel editProfileViewModel2;
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(732396010, i10, -1, "cu.todus.android.uiCompose.main.screen.editProfile.EditInfoProfileScreen.<anonymous> (EditProfileScreen.kt:133)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1725padding3ABfNKs(WindowInsetsPadding_androidKt.imePadding(companion), Dp.m8823constructorimpl(20)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), companion2.getCenterHorizontally(), composer, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Object objValueOf = ((Boolean) mutableState.getValue()).booleanValue() ? Integer.valueOf(R.drawable.profile) : mutableState2.getValue();
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(columnScopeInstance.align(companion, companion2.getCenterHorizontally()), Dp.m8823constructorimpl(150));
            float f10 = 5;
            float fM8823constructorimpl = Dp.m8823constructorimpl(f10);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(modifierM1769size3ABfNKs, fM8823constructorimpl, materialTheme.getColorScheme(composer, i13).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10));
            boolean zChangedInstance = composer.changedInstance(focusManager) | composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.t
                    @Override // lb.a
                    public final Object invoke() {
                        return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$0$0$0(focusManager, aVar, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs, false, null, null, null, (lb.a) objRememberedValue, 15, null), objValueOf, Integer.valueOf(R.drawable.profile), null, null, 0, null, true, null, null, false, 0, composer, 12582912, 0, 3960);
            float f11 = 30;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            KeyboardType.Companion companion4 = KeyboardType.INSTANCE;
            int iM8505getTextPjHm6EE = companion4.m8505getTextPjHm6EE();
            String str = (String) mutableState3.getValue();
            String str2 = (String) mutableState4.getValue();
            String strStringResource = StringResources_androidKt.stringResource(R.string.put_name_here, composer, 0);
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue2 == companion5.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$0$1$0(mutableState4, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, str2, 0, 0, strStringResource, str, (Function1) objRememberedValue2, null, null, 50, iM8505getTextPjHm6EE, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806879238, 6, 1046924);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            SurfaceKt.m2749SurfaceFjzlyU(null, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)), materialTheme.getColorScheme(composer, i13).getBackground(), 0L, BorderStrokeKt.m1231BorderStrokecXLIe8U(Dp.m8823constructorimpl(2), materialTheme.getColorScheme(composer, i13).getPrimary()), 0.0f, ComposableLambdaKt.rememberComposableLambda(-1279040484, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$0$2(navHostController, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 41);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            int iM8505getTextPjHm6EE2 = companion4.m8505getTextPjHm6EE();
            String str3 = (String) mutableState5.getValue();
            if (d0.q0(((Owner) state.getValue()).getInfo())) {
                composer.startReplaceGroup(-269092599);
                i12 = R.string.i_use_todus;
                i11 = 0;
            } else {
                i11 = 0;
                composer.startReplaceGroup(-269091057);
                i12 = R.string.description;
            }
            String strStringResource2 = StringResources_androidKt.stringResource(i12, composer, i11);
            composer.endReplaceGroup();
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion5.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$0$3$0(mutableState5, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default2, str3, 3, 3, strStringResource2, null, (Function1) objRememberedValue3, null, null, 200, iM8505getTextPjHm6EE2, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806882694, 6, 1046944);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(60)), composer, 6);
            boolean z10 = d0.q1((String) mutableState4.getValue()).toString().length() > 0;
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.save, composer, 0);
            boolean zChangedInstance2 = composer.changedInstance(editProfileViewModel) | composer.changedInstance(navHostController);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == companion5.getEmpty()) {
                c10 = 6;
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.f
                    @Override // lb.a
                    public final Object invoke() {
                        return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$0$4$0(editProfileViewModel, mutableState4, mutableState5, mutableState7, navHostController);
                    }
                };
                composer.updateRememberedValue(aVar2);
                objRememberedValue4 = aVar2;
            } else {
                c10 = 6;
            }
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue4, strStringResource3, null, true, z10, composer, 24576, 9);
            composer.endNode();
            if (EditInfoProfileScreen$lambda$6(mutableState6)) {
                composer.startReplaceGroup(379420364);
                Object objRememberedValue5 = composer.rememberedValue();
                if (objRememberedValue5 == companion5.getEmpty()) {
                    mutableState8 = mutableState6;
                    objRememberedValue5 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$1$0(mutableState8, (List) obj, (String) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                } else {
                    mutableState8 = mutableState6;
                }
                Function2 function2 = (Function2) objRememberedValue5;
                boolean zChangedInstance3 = composer.changedInstance(editProfileViewModel);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue6 == companion5.getEmpty()) {
                    final MutableState mutableState9 = mutableState8;
                    objRememberedValue6 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$2$0(mutableState, mutableState2, mutableState9, editProfileViewModel, mutableState7, (List) obj, (String) obj2);
                        }
                    };
                    editProfileViewModel2 = editProfileViewModel;
                    composer.updateRememberedValue(objRememberedValue6);
                } else {
                    editProfileViewModel2 = editProfileViewModel;
                }
                Function2 function3 = (Function2) objRememberedValue6;
                boolean zChangedInstance4 = composer.changedInstance(editProfileViewModel2);
                Object objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue7 == companion5.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.i
                        @Override // lb.a
                        public final Object invoke() {
                            return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$3$0(editProfileViewModel2, mutableState, mutableState8, mutableState7);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar3 = (lb.a) objRememberedValue7;
                Object objRememberedValue8 = composer.rememberedValue();
                if (objRememberedValue8 == companion5.getEmpty()) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.j
                        @Override // lb.a
                        public final Object invoke() {
                            return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$4$0(mutableState8);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                lb.a aVar4 = (lb.a) objRememberedValue8;
                Object objRememberedValue9 = composer.rememberedValue();
                if (objRememberedValue9 == companion5.getEmpty()) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.s
                        @Override // lb.a
                        public final Object invoke() {
                            return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$5$0(mutableState8);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                CameraKt.Camera(null, null, false, false, true, false, 0L, function2, function3, aVar3, aVar4, (lb.a) objRememberedValue9, composer, 12610944, 54, 99);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(380631224);
                composer.endReplaceGroup();
            }
            if (EditInfoProfileScreen$lambda$9(mutableState7)) {
                composer.startReplaceGroup(-541909705);
                LoadingScreenKt.LoadingWall(composer, 0);
            } else {
                composer.startReplaceGroup(380680824);
            }
            composer.endReplaceGroup();
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance5 = composer.changedInstance(editProfileViewModel);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue10 == companion5.getEmpty()) {
                objRememberedValue10 = new EditProfileScreenKt$EditInfoProfileScreen$2$7$1(editProfileViewModel, null);
                composer.updateRememberedValue(objRememberedValue10);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue10, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$0$0$0(FocusManager focusManager, c1.a aVar, MutableState mutableState) {
        androidx.compose.ui.focus.c.a(focusManager, false, 1, null);
        if (aVar.a()) {
            EditInfoProfileScreen$lambda$7(mutableState, true);
        } else {
            aVar.b();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$0$1$0(MutableState mutableState, String it) {
        y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 EditInfoProfileScreen$lambda$12$0$2(final NavHostController navHostController, State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1279040484, i10, -1, "cu.todus.android.uiCompose.main.screen.editProfile.EditInfoProfileScreen.<anonymous>.<anonymous>.<anonymous> (EditProfileScreen.kt:185)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(5)), 0.0f, 1, null);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.l
                    @Override // lb.a
                    public final Object invoke() {
                        return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$0$2$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            String str = "@" + ((Owner) state.getValue()).getToDusId();
            String strStringResource = StringResources_androidKt.stringResource(R.string.todus_id, composer, 0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$0$2$1$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierM1240clickableoSLSa3U$default, str, 0, 0, strStringResource, null, (Function1) objRememberedValue2, null, null, 0, 0, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 1572864, 805306368, 524204);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$0$2$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.EDIT_TODUS_ID, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$0$2$1$0(String it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$0$3$0(MutableState mutableState, String it) {
        y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$0$4$0(EditProfileViewModel editProfileViewModel, MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, final NavHostController navHostController) {
        EditInfoProfileScreen$lambda$10(mutableState3, true);
        editProfileViewModel.updateDisplayNameAndBio((String) mutableState.getValue(), (String) mutableState2.getValue(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.q
            @Override // lb.a
            public final Object invoke() {
                return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$0$4$0$0(navHostController, mutableState3);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$0$4$0$0(NavHostController navHostController, MutableState mutableState) {
        EditInfoProfileScreen$lambda$10(mutableState, false);
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$1$0(MutableState mutableState, List files, String content) {
        y.i(files, "files");
        y.i(content, "content");
        EditInfoProfileScreen$lambda$7(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$2$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, EditProfileViewModel editProfileViewModel, final MutableState mutableState4, List files, String content) {
        Uri uriFromFile;
        y.i(files, "files");
        y.i(content, "content");
        EditInfoProfileScreen$lambda$7(mutableState3, false);
        mutableState.setValue(Boolean.FALSE);
        File file = (File) g0.y0(files);
        mutableState2.setValue(file != null ? Uri.fromFile(file) : null);
        File file2 = (File) g0.y0(files);
        System.out.println((Object) ("MEDIA " + (file2 != null ? Uri.fromFile(file2) : null)));
        File file3 = (File) g0.y0(files);
        if (file3 != null && (uriFromFile = Uri.fromFile(file3)) != null) {
            EditInfoProfileScreen$lambda$10(mutableState4, true);
            editProfileViewModel.updateProfileImage(uriFromFile, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.b
                @Override // lb.a
                public final Object invoke() {
                    return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$2$0$0$0(mutableState4);
                }
            });
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$2$0$0$0(MutableState mutableState) {
        EditInfoProfileScreen$lambda$10(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$3$0(EditProfileViewModel editProfileViewModel, MutableState mutableState, MutableState mutableState2, final MutableState mutableState3) {
        EditInfoProfileScreen$lambda$7(mutableState2, false);
        EditInfoProfileScreen$lambda$10(mutableState3, true);
        editProfileViewModel.deleteProfileImage(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.editProfile.r
            @Override // lb.a
            public final Object invoke() {
                return EditProfileScreenKt.EditInfoProfileScreen$lambda$12$3$0$0(mutableState3);
            }
        });
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$3$0$0(MutableState mutableState) {
        EditInfoProfileScreen$lambda$10(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$4$0(MutableState mutableState) {
        EditInfoProfileScreen$lambda$7(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$12$5$0(MutableState mutableState) {
        EditInfoProfileScreen$lambda$7(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditInfoProfileScreen$lambda$13(NavHostController navHostController, EditProfileViewModel editProfileViewModel, int i10, int i11, Composer composer, int i12) {
        EditInfoProfileScreen(navHostController, editProfileViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final boolean EditInfoProfileScreen$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void EditInfoProfileScreen$lambda$7(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean EditInfoProfileScreen$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }
}
