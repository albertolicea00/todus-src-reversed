package cu.todus.android.uiCompose.main.screen.secretRoomsAccess;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.uiCompose.shared.optTextField.OptTextFieldKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.r;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.a0;
import le.f0;
import te.b0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/secretRoomsAccess/SecretRoomAccessViewModel;", "viewModel", "Lua/k0;", "SecretRoomAccess", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/secretRoomsAccess/SecretRoomAccessViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SecretRoomAccessKt {
    /* JADX WARN: Code duplicated, block: B:107:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:109:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:111:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:112:0x0546  */
    /* JADX WARN: Code duplicated, block: B:115:0x0561  */
    /* JADX WARN: Code duplicated, block: B:117:0x0587  */
    /* JADX WARN: Code duplicated, block: B:130:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:132:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:145:0x05fd  */
    /* JADX WARN: Code duplicated, block: B:148:0x0614  */
    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:56:0x0107  */
    /* JADX WARN: Code duplicated, block: B:57:0x010b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0181  */
    /* JADX WARN: Code duplicated, block: B:63:0x0194  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:78:0x0273  */
    /* JADX WARN: Code duplicated, block: B:81:0x027f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0283  */
    /* JADX WARN: Code duplicated, block: B:85:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:88:0x0443  */
    /* JADX WARN: Code duplicated, block: B:94:0x0482  */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v53 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SecretRoomAccess(final NavHostController navHostController, SecretRoomAccessViewModel secretRoomAccessViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        ?? r11;
        Modifier.Companion companion;
        Alignment.Companion companion2;
        ComposeUiNode.Companion companion3;
        lb.a constructor;
        Boolean bool;
        State stateCollectAsStateWithLifecycle;
        final State stateCollectAsStateWithLifecycle2;
        final State stateCollectAsStateWithLifecycle3;
        Object objRememberedValue;
        Composer.Companion companion4;
        final MutableState mutableState;
        Object objRememberedValue2;
        final MutableState mutableState2;
        final String strStringResource;
        final String strStringResource2;
        Object objRememberedValue3;
        int i13;
        final MutableState mutableState3;
        Object objRememberedValue4;
        int i14;
        MutableState mutableState4;
        Object objRememberedValue5;
        final MutableState mutableState5;
        int i15;
        int i16;
        final SecretRoomAccessViewModel secretRoomAccessViewModel2;
        final MutableState mutableState6;
        int i17;
        int i18;
        int i19;
        Object objRememberedValue6;
        Object objRememberedValue7;
        int i20;
        Object objRememberedValue8;
        lb.a constructor2;
        Object objRememberedValue9;
        Object objRememberedValue10;
        boolean z10;
        boolean zChanged;
        Object objRememberedValue11;
        int i21;
        final SecretRoomAccessViewModel secretRoomAccessViewModel3 = secretRoomAccessViewModel;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1308299793);
        if ((i10 & 6) == 0) {
            i12 = i10 | (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2);
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i21 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(secretRoomAccessViewModel3) : composerStartRestartGroup.changedInstance(secretRoomAccessViewModel3)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
            }
            i12 |= i21;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 2) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(SecretRoomAccessViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    SecretRoomAccessViewModel secretRoomAccessViewModel4 = (SecretRoomAccessViewModel) viewModel;
                    i12 &= -113;
                    r11 = 0;
                    secretRoomAccessViewModel3 = secretRoomAccessViewModel4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1308299793, i12, -1, "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccess (SecretRoomAccess.kt:54)");
                }
                companion = Modifier.INSTANCE;
                companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), r11);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, r11));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                b0 isReady = secretRoomAccessViewModel3.getIsReady();
                bool = Boolean.FALSE;
                Composer composer2 = composerStartRestartGroup;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(isReady, bool, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
                composerStartRestartGroup = composer2;
                stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(secretRoomAccessViewModel3.getActualCode(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(secretRoomAccessViewModel3.getActualCleanCode(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion4 = Composer.INSTANCE;
                if (objRememberedValue == companion4.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion4.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                strStringResource = StringResources_androidKt.stringResource(R.string.codes_cant_be_equals, composerStartRestartGroup, 0);
                strStringResource2 = StringResources_androidKt.stringResource(R.string.wrong_code, composerStartRestartGroup, 0);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion4.getEmpty()) {
                    i13 = 2;
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    i13 = 2;
                }
                mutableState3 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                i14 = i12;
                if (objRememberedValue4 == companion4.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, i13, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState4 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion4.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, i13, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                mutableState5 = (MutableState) objRememberedValue5;
                if (y.d(stateCollectAsStateWithLifecycle.getValue(), bool)) {
                    composerStartRestartGroup.startReplaceGroup(-2126830482);
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i22 = MaterialTheme.$stable;
                    float f10 = 20;
                    Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme.getColorScheme(composerStartRestartGroup, i22).getBackground(), null, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(f10))), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), composerStartRestartGroup, 48);
                    int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
                    constructor2 = companion3.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.secret_folder, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i22).getTitleLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(200)), Integer.valueOf(R.drawable.secret), null, null, null, null, 0, null, null, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                    float f11 = 10;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i22).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f10)), StringResources_androidKt.stringResource(R.string.requiring_secret_config_text, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i22).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composerStartRestartGroup, 0, 56);
                    float f12 = 30;
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f12)), composerStartRestartGroup, 6);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.secret_access_code, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i22).getTitleMedium(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
                    String str = (String) mutableState.getValue();
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue9 == companion4.getEmpty()) {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SecretRoomAccessKt.SecretRoomAccess$lambda$0$7$0$0(mutableState, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    OptTextFieldKt.OtpTextField(null, str, false, (Function1) objRememberedValue9, composerStartRestartGroup, 3072, 5);
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f12)), composerStartRestartGroup, 6);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.secret_clean_code, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i22).getTitleMedium(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
                    String str2 = (String) mutableState2.getValue();
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == companion4.getEmpty()) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SecretRoomAccessKt.SecretRoomAccess$lambda$0$7$1$0(mutableState2, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    OptTextFieldKt.OtpTextField(null, str2, false, (Function1) objRememberedValue10, composerStartRestartGroup, 3072, 5);
                    i15 = 6;
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(40)), composerStartRestartGroup, 6);
                    if (((String) mutableState.getValue()).length() == 4 || ((String) mutableState2.getValue()).length() != 4) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    String strStringResource3 = StringResources_androidKt.stringResource(R.string.continue_label, composerStartRestartGroup, 0);
                    i16 = 32;
                    zChanged = composerStartRestartGroup.changed(strStringResource) | ((((i14 & 112) ^ 48) <= 32 && composerStartRestartGroup.changedInstance(secretRoomAccessViewModel3)) || (i14 & 48) == 32);
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue11 == companion4.getEmpty()) {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.l
                            @Override // lb.a
                            public final Object invoke() {
                                return SecretRoomAccessKt.SecretRoomAccess$lambda$0$7$2$0(mutableState, mutableState2, secretRoomAccessViewModel3, strStringResource);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue11, strStringResource3, null, true, z10, composerStartRestartGroup, 24576, 9);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                    secretRoomAccessViewModel2 = secretRoomAccessViewModel3;
                    mutableState6 = mutableState4;
                    i17 = 0;
                    i18 = 1;
                } else {
                    i15 = 6;
                    i16 = 32;
                    if (y.d(stateCollectAsStateWithLifecycle.getValue(), Boolean.TRUE)) {
                        composerStartRestartGroup.startReplaceGroup(-2123366635);
                        i18 = 1;
                        secretRoomAccessViewModel2 = secretRoomAccessViewModel3;
                        mutableState6 = mutableState4;
                        i15 = 6;
                        i17 = 0;
                        Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(486159207, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.m
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return SecretRoomAccessKt.SecretRoomAccess$lambda$0$8(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(-671242203, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.n
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return SecretRoomAccessKt.SecretRoomAccess$lambda$0$9(mutableState3, stateCollectAsStateWithLifecycle2, stateCollectAsStateWithLifecycle3, secretRoomAccessViewModel2, navHostController, strStringResource2, mutableState6, mutableState5, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        secretRoomAccessViewModel2 = secretRoomAccessViewModel3;
                        mutableState6 = mutableState4;
                        i17 = 0;
                        i18 = 1;
                        composerStartRestartGroup.startReplaceGroup(-2119686005);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                if (((Boolean) mutableState6.getValue()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(-2119623354);
                    String strStringResource4 = StringResources_androidKt.stringResource(R.string.please_confirm, composerStartRestartGroup, i17);
                    String strStringResource5 = StringResources_androidKt.stringResource(R.string.you_are_about_to_reset_secret, composerStartRestartGroup, i17);
                    boolean zBooleanValue = ((Boolean) mutableState6.getValue()).booleanValue();
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion4.getEmpty()) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.o
                            @Override // lb.a
                            public final Object invoke() {
                                return SecretRoomAccessKt.SecretRoomAccess$lambda$0$10$0(mutableState6);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    lb.a aVar = (lb.a) objRememberedValue7;
                    i20 = ((((i14 & 112) ^ 48) > i16 || !composerStartRestartGroup.changedInstance(secretRoomAccessViewModel2)) && (i14 & 48) != i16) ? i17 : i18;
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (i20 == 0 || objRememberedValue8 == companion4.getEmpty()) {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.c
                            @Override // lb.a
                            public final Object invoke() {
                                return SecretRoomAccessKt.SecretRoomAccess$lambda$0$11$0(secretRoomAccessViewModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Composer composer3 = composerStartRestartGroup;
                    Z17DialogsKt.Z17DialogWithActions(zBooleanValue, aVar, (lb.a) objRememberedValue8, null, strStringResource4, strStringResource5, null, null, composer3, 48, 200);
                    composerStartRestartGroup = composer3;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2119239605);
                    composerStartRestartGroup.endReplaceGroup();
                }
                k0 k0Var = k0.f43947a;
                i19 = ((((i14 & 112) ^ 48) > i16 || !composerStartRestartGroup.changedInstance(secretRoomAccessViewModel2)) && (i14 & 48) != i16) ? i17 : i18;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (i19 == 0 || objRememberedValue6 == companion4.getEmpty()) {
                    objRememberedValue6 = new SecretRoomAccessKt$SecretRoomAccess$1$6$1(secretRoomAccessViewModel2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue6, composerStartRestartGroup, i15);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                secretRoomAccessViewModel3 = secretRoomAccessViewModel2;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                }
            }
            r11 = 0;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1308299793, i12, -1, "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccess (SecretRoomAccess.kt:54)");
            }
            companion = Modifier.INSTANCE;
            companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), r11);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, r11));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            companion3 = ComposeUiNode.INSTANCE;
            constructor = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            b0 isReady2 = secretRoomAccessViewModel3.getIsReady();
            bool = Boolean.FALSE;
            Composer composer4 = composerStartRestartGroup;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(isReady2, bool, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 48, 14);
            composerStartRestartGroup = composer4;
            stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(secretRoomAccessViewModel3.getActualCode(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(secretRoomAccessViewModel3.getActualCleanCode(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion4.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            strStringResource = StringResources_androidKt.stringResource(R.string.codes_cant_be_equals, composerStartRestartGroup, 0);
            strStringResource2 = StringResources_androidKt.stringResource(R.string.wrong_code, composerStartRestartGroup, 0);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion4.getEmpty()) {
                i13 = 2;
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                i13 = 2;
            }
            mutableState3 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            i14 = i12;
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, i13, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            mutableState4 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, i13, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            mutableState5 = (MutableState) objRememberedValue5;
            if (y.d(stateCollectAsStateWithLifecycle.getValue(), bool)) {
                composerStartRestartGroup.startReplaceGroup(-2126830482);
                MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                int i23 = MaterialTheme.$stable;
                float f13 = 20;
                Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme2.getColorScheme(composerStartRestartGroup, i23).getBackground(), null, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(f13))), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), composerStartRestartGroup, 48);
                int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default2);
                constructor2 = companion3.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.secret_folder, composerStartRestartGroup, 0), materialTheme2.getTypography(composerStartRestartGroup, i23).getTitleLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(200)), Integer.valueOf(R.drawable.secret), null, null, null, null, 0, null, null, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                float f14 = 10;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composerStartRestartGroup, i23).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f14))), Dp.m8823constructorimpl(f13)), StringResources_androidKt.stringResource(R.string.requiring_secret_config_text, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme2.getTypography(composerStartRestartGroup, i23).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composerStartRestartGroup, 0, 56);
                float f15 = 30;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f15)), composerStartRestartGroup, 6);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.secret_access_code, composerStartRestartGroup, 0), materialTheme2.getTypography(composerStartRestartGroup, i23).getTitleMedium(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f14)), composerStartRestartGroup, 6);
                String str3 = (String) mutableState.getValue();
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue9 == companion4.getEmpty()) {
                    objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$7$0$0(mutableState, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                OptTextFieldKt.OtpTextField(null, str3, false, (Function1) objRememberedValue9, composerStartRestartGroup, 3072, 5);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f15)), composerStartRestartGroup, 6);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.secret_clean_code, composerStartRestartGroup, 0), materialTheme2.getTypography(composerStartRestartGroup, i23).getTitleMedium(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f14)), composerStartRestartGroup, 6);
                String str4 = (String) mutableState2.getValue();
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue10 == companion4.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$7$1$0(mutableState2, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                OptTextFieldKt.OtpTextField(null, str4, false, (Function1) objRememberedValue10, composerStartRestartGroup, 3072, 5);
                i15 = 6;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(40)), composerStartRestartGroup, 6);
                if (((String) mutableState.getValue()).length() == 4) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                String strStringResource6 = StringResources_androidKt.stringResource(R.string.continue_label, composerStartRestartGroup, 0);
                i16 = 32;
                zChanged = composerStartRestartGroup.changed(strStringResource) | ((((i14 & 112) ^ 48) <= 32 && composerStartRestartGroup.changedInstance(secretRoomAccessViewModel3)) || (i14 & 48) == 32);
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.l
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$7$2$0(mutableState, mutableState2, secretRoomAccessViewModel3, strStringResource);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.l
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$7$2$0(mutableState, mutableState2, secretRoomAccessViewModel3, strStringResource);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue11, strStringResource6, null, true, z10, composerStartRestartGroup, 24576, 9);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
                secretRoomAccessViewModel2 = secretRoomAccessViewModel3;
                mutableState6 = mutableState4;
                i17 = 0;
                i18 = 1;
            } else {
                i15 = 6;
                i16 = 32;
                if (y.d(stateCollectAsStateWithLifecycle.getValue(), Boolean.TRUE)) {
                    composerStartRestartGroup.startReplaceGroup(-2123366635);
                    i18 = 1;
                    secretRoomAccessViewModel2 = secretRoomAccessViewModel3;
                    mutableState6 = mutableState4;
                    i15 = 6;
                    i17 = 0;
                    Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(486159207, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.m
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$8(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(-671242203, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.n
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$9(mutableState3, stateCollectAsStateWithLifecycle2, stateCollectAsStateWithLifecycle3, secretRoomAccessViewModel2, navHostController, strStringResource2, mutableState6, mutableState5, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    secretRoomAccessViewModel2 = secretRoomAccessViewModel3;
                    mutableState6 = mutableState4;
                    i17 = 0;
                    i18 = 1;
                    composerStartRestartGroup.startReplaceGroup(-2119686005);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (((Boolean) mutableState6.getValue()).booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(-2119623354);
                String strStringResource7 = StringResources_androidKt.stringResource(R.string.please_confirm, composerStartRestartGroup, i17);
                String strStringResource8 = StringResources_androidKt.stringResource(R.string.you_are_about_to_reset_secret, composerStartRestartGroup, i17);
                boolean zBooleanValue2 = ((Boolean) mutableState6.getValue()).booleanValue();
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion4.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.o
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$10$0(mutableState6);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar2 = (lb.a) objRememberedValue7;
                if (((i14 & 112) ^ 48) > i16) {
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (i20 == 0) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.c
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$11$0(secretRoomAccessViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.c
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomAccessKt.SecretRoomAccess$lambda$0$11$0(secretRoomAccessViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                Composer composer5 = composerStartRestartGroup;
                Z17DialogsKt.Z17DialogWithActions(zBooleanValue2, aVar2, (lb.a) objRememberedValue8, null, strStringResource7, strStringResource8, null, null, composer5, 48, 200);
                composerStartRestartGroup = composer5;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2119239605);
                composerStartRestartGroup.endReplaceGroup();
            }
            k0 k0Var2 = k0.f43947a;
            if (((i14 & 112) ^ 48) > i16) {
            }
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (i19 == 0) {
                objRememberedValue6 = new SecretRoomAccessKt$SecretRoomAccess$1$6$1(secretRoomAccessViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new SecretRoomAccessKt$SecretRoomAccess$1$6$1(secretRoomAccessViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue6, composerStartRestartGroup, i15);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            secretRoomAccessViewModel3 = secretRoomAccessViewModel2;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SecretRoomAccessKt.SecretRoomAccess$lambda$1(navHostController, secretRoomAccessViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$10$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$11$0(SecretRoomAccessViewModel secretRoomAccessViewModel) {
        secretRoomAccessViewModel.resetConfigs();
        return k0.f43947a;
    }

    private static final void SecretRoomAccess$lambda$0$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$7$0$0(MutableState mutableState, String value) throws IOException {
        y.i(value, "value");
        StringBuilder sb2 = new StringBuilder();
        int length = value.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = value.charAt(i10);
            if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        mutableState.setValue(f0.z1(sb2.toString(), 4));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$7$1$0(MutableState mutableState, String value) throws IOException {
        y.i(value, "value");
        StringBuilder sb2 = new StringBuilder();
        int length = value.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = value.charAt(i10);
            if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        mutableState.setValue(f0.z1(sb2.toString(), 4));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$7$2$0(MutableState mutableState, MutableState mutableState2, SecretRoomAccessViewModel secretRoomAccessViewModel, String str) {
        if (y.d(mutableState.getValue(), mutableState2.getValue())) {
            MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                instanceOrNull.addNewNotification(new InsideNotificationState(a0.O(string, "-", "", false, 4, null), Cause.ERROR, str));
            }
        } else {
            secretRoomAccessViewModel.setReady((String) mutableState.getValue(), (String) mutableState2.getValue());
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SecretRoomAccess$lambda$0$8(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(486159207, i10, -1, "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccess.<anonymous>.<anonymous> (SecretRoomAccess.kt:173)");
            }
            Function2 function2M9979getLambda$222957894$app_productionPFast = ComposableSingletons$SecretRoomAccessKt.INSTANCE.m9979getLambda$222957894$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.e
                    @Override // lb.a
                    public final Object invoke() {
                        return SecretRoomAccessKt.SecretRoomAccess$lambda$0$8$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9979getLambda$222957894$app_productionPFast, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$8$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SecretRoomAccess$lambda$0$9(final MutableState mutableState, final State state, final State state2, final SecretRoomAccessViewModel secretRoomAccessViewModel, final NavHostController navHostController, final String str, final MutableState mutableState2, final MutableState mutableState3, Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-671242203, i10, -1, "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccess.<anonymous>.<anonymous> (SecretRoomAccess.kt:186)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(20))), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), composer, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(200)), Integer.valueOf(R.drawable.secret), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            float f10 = 40;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            String str2 = (String) mutableState.getValue();
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SecretRoomAccessKt.SecretRoomAccess$lambda$0$9$0$0$0(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            OptTextFieldKt.OtpTextField(null, str2, true, (Function1) objRememberedValue, composer, 3456, 1);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.h
                    @Override // lb.a
                    public final Object invoke() {
                        return SecretRoomAccessKt.SecretRoomAccess$lambda$0$9$0$1$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (lb.a) objRememberedValue2, 15, null);
            String strStringResource = StringResources_androidKt.stringResource(R.string.reset_configs, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1240clickableoSLSa3U$default, strStringResource, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16740351, null), materialTheme.getColorScheme(composer, i11).getPrimary(), 0, 0, composer, 0, 48);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            boolean z10 = ((String) mutableState.getValue()).length() == 4;
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.continue_label, composer, 0);
            boolean zChanged = composer.changed(state) | composer.changed(state2) | composer.changedInstance(secretRoomAccessViewModel) | composer.changedInstance(navHostController) | composer.changed(str);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.i
                    @Override // lb.a
                    public final Object invoke() {
                        return SecretRoomAccessKt.SecretRoomAccess$lambda$0$9$0$2$0(mutableState, state, state2, secretRoomAccessViewModel, str, mutableState3, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue3, strStringResource2, null, true, z10, composer, 24576, 9);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$9$0$0$0(MutableState mutableState, String value) throws IOException {
        y.i(value, "value");
        StringBuilder sb2 = new StringBuilder();
        int length = value.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = value.charAt(i10);
            if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        mutableState.setValue(f0.z1(sb2.toString(), 4));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$9$0$1$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$9$0$2$0(MutableState mutableState, State state, State state2, SecretRoomAccessViewModel secretRoomAccessViewModel, String str, final MutableState mutableState2, final NavHostController navHostController) {
        SecretRoomAccess$lambda$0$6(mutableState2, true);
        if (y.d(mutableState.getValue(), state.getValue()) || y.d(mutableState.getValue(), state2.getValue())) {
            secretRoomAccessViewModel.navigateSecret(y.d(mutableState.getValue(), state2.getValue()), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.b
                @Override // lb.a
                public final Object invoke() {
                    return SecretRoomAccessKt.SecretRoomAccess$lambda$0$9$0$2$0$0(navHostController, mutableState2);
                }
            });
        } else {
            MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                instanceOrNull.addNewNotification(new InsideNotificationState(a0.O(string, "-", "", false, 4, null), Cause.ERROR, str));
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$9$0$2$0$0(NavHostController navHostController, MutableState mutableState) {
        SecretRoomAccess$lambda$0$6(mutableState, false);
        navHostController.navigate(NavLinks.SECRET_ROOMS, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SecretRoomAccessKt.SecretRoomAccess$lambda$0$9$0$2$0$0$0((NavOptionsBuilder) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$0$9$0$2$0$0$0(NavOptionsBuilder navigate) {
        y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomAccess$lambda$1(NavHostController navHostController, SecretRoomAccessViewModel secretRoomAccessViewModel, int i10, int i11, Composer composer, int i12) {
        SecretRoomAccess(navHostController, secretRoomAccessViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
