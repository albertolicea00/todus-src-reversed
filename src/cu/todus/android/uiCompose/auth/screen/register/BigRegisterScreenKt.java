package cu.todus.android.uiCompose.auth.screen.register;

import android.os.CountDownTimer;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.uiCompose.auth.screen.AuthViewModel;
import cu.todus.android.uiCompose.shared.optTextField.OptTextFieldKt;
import cu.todus.android.utils.DateFormatter;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.z0;
import le.f0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000e²\u0006\u0014\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\r\u001a\u00020\n8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/auth/screen/AuthViewModel;", "viewModel", "Lua/k0;", "BigRegisterScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/auth/screen/AuthViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/preferences/AppState;", "kotlin.jvm.PlatformType", "appState", "", "isLoading", "wasRequested", "permissionsGranted", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BigRegisterScreenKt {
    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BigRegisterScreen(final NavHostController navHostController, AuthViewModel authViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        int i13;
        final AuthViewModel authViewModel2 = authViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1809797288);
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i13 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(authViewModel2) : composerStartRestartGroup.changedInstance(authViewModel2)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
            }
            i12 = i13 | i10;
        } else {
            i12 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 17) != 16, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                authViewModel2 = (AuthViewModel) ViewModelKt.viewModel(z0.b(AuthViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i12 &= -113;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1809797288, i12, -1, "cu.todus.android.uiCompose.auth.screen.register.BigRegisterScreen (BigRegisterScreen.kt:72)");
            }
            SurfaceKt.m3707SurfaceT9BRK9s(WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(224361005, true, new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.register.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigRegisterScreenKt.BigRegisterScreen$lambda$0(authViewModel2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.register.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigRegisterScreenKt.BigRegisterScreen$lambda$1(navHostController, authViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v19 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final ua.k0 BigRegisterScreen$lambda$0(cu.todus.android.uiCompose.auth.screen.AuthViewModel r34, androidx.compose.runtime.Composer r35, int r36) {
        /*
            Method dump skipped, instruction units count: 1158
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.auth.screen.register.BigRegisterScreenKt.BigRegisterScreen$lambda$0(cu.todus.android.uiCompose.auth.screen.AuthViewModel, androidx.compose.runtime.Composer, int):ua.k0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppState BigRegisterScreen$lambda$0$0(State<AppState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigRegisterScreen$lambda$0$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigRegisterScreen$lambda$0$14(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$17$0(MutableState mutableState) {
        BigRegisterScreen$lambda$0$14(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 BigRegisterScreen$lambda$0$19$1(final MutableState mutableState, final AuthViewModel authViewModel, MutableState mutableState2, final MutableState mutableState3, MutableState mutableState4, final MutableState mutableState5, ColumnScope Card, Composer composer, int i10) {
        final MutableState mutableState6;
        long onSurface;
        long onSurface2;
        long onSurface3;
        kotlin.jvm.internal.y.i(Card, "$this$Card");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1086428651, i10, -1, "cu.todus.android.uiCompose.auth.screen.register.BigRegisterScreen.<anonymous>.<anonymous>.<anonymous> (BigRegisterScreen.kt:214)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 20;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getSpaceBetween(), centerHorizontally, composer, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
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
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composer, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
            lb.a constructor2 = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
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
            Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(companion);
            String strStringResource = StringResources_androidKt.stringResource(R.string.insert_code_number, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierSafeContentPadding, strStringResource, materialTheme.getTypography(composer, i11).getTitleLarge(), 0L, 0, 0, composer, 0, 56);
            float f11 = 10;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.insert_code_number_information_text, composer, 0);
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            float f12 = 0;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1728paddingqDBjuR0(companion, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f12)), strStringResource2, textStyleM8271copyp1EtxEg$default, 0L, 0, 0, composer, 6, 56);
            composer.endNode();
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composer, 48);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion);
            lb.a constructor3 = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            String str = (String) mutableState.getValue();
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.register.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigRegisterScreenKt.BigRegisterScreen$lambda$0$19$1$0$1$0$0(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            OptTextFieldKt.OtpTextField(null, str, false, (Function1) objRememberedValue, composer, 3072, 5);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            boolean zBigRegisterScreen$lambda$0$checkSmsCode = BigRegisterScreen$lambda$0$checkSmsCode((String) mutableState.getValue());
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.next, composer, 0);
            boolean zChangedInstance = composer.changedInstance(authViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion4.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.register.j
                    @Override // lb.a
                    public final Object invoke() {
                        return BigRegisterScreenKt.BigRegisterScreen$lambda$0$19$1$0$1$1$0(mutableState, authViewModel, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue2, strStringResource3, null, true, zBigRegisterScreen$lambda$0$checkSmsCode, composer, 24576, 9);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion4.getEmpty()) {
                mutableState6 = mutableState2;
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.register.k
                    @Override // lb.a
                    public final Object invoke() {
                        return BigRegisterScreenKt.BigRegisterScreen$lambda$0$19$1$0$1$2$0(mutableState6, mutableState3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                mutableState6 = mutableState2;
            }
            float f13 = 15;
            Modifier modifierM1728paddingqDBjuR0 = PaddingKt.m1728paddingqDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue3, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getTop(), composer, 6);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierM1728paddingqDBjuR0);
            lb.a constructor4 = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.send_sms_again, composer, 0);
            TextStyle bodySmall = materialTheme.getTypography(composer, i11).getBodySmall();
            if (((Boolean) mutableState6.getValue()).booleanValue()) {
                composer.startReplaceGroup(-163155101);
                onSurface = materialTheme.getColorScheme(composer, i11).getPrimary();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-163152699);
                onSurface = materialTheme.getColorScheme(composer, i11).getOnSurface();
                composer.endReplaceGroup();
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource4, TextStyle.m8271copyp1EtxEg$default(bodySmall, onSurface, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), 0L, 0, 0, composer, 0, 57);
            String str2 = (String) mutableState4.getValue();
            TextStyle bodySmall2 = materialTheme.getTypography(composer, i11).getBodySmall();
            if (((Boolean) mutableState6.getValue()).booleanValue()) {
                composer.startReplaceGroup(-163141725);
                onSurface2 = materialTheme.getColorScheme(composer, i11).getPrimary();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-163139323);
                onSurface2 = materialTheme.getColorScheme(composer, i11).getOnSurface();
                composer.endReplaceGroup();
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str2, TextStyle.m8271copyp1EtxEg$default(bodySmall2, onSurface2, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), 0L, 0, 0, composer, 0, 57);
            int i12 = R.drawable.sms;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24));
            ColorFilter.Companion companion5 = ColorFilter.INSTANCE;
            if (((Boolean) mutableState6.getValue()).booleanValue()) {
                composer.startReplaceGroup(-163126557);
                onSurface3 = materialTheme.getColorScheme(composer, i11).getPrimary();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-163124155);
                onSurface3 = materialTheme.getColorScheme(composer, i11).getOnSurface();
                composer.endReplaceGroup();
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, Integer.valueOf(i12), null, ColorFilter.Companion.m5907tintxETnrds$default(companion5, onSurface3, 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composer.endNode();
            composer.endNode();
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
    public static final k0 BigRegisterScreen$lambda$0$19$1$0$1$0$0(MutableState mutableState, String value) throws IOException {
        kotlin.jvm.internal.y.i(value, "value");
        StringBuilder sb2 = new StringBuilder();
        int length = value.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = value.charAt(i10);
            if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        mutableState.setValue(f0.z1(sb2.toString(), 6));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$19$1$0$1$1$0(MutableState mutableState, AuthViewModel authViewModel, MutableState mutableState2) {
        if (BigRegisterScreen$lambda$0$checkSmsCode((String) mutableState.getValue())) {
            BigRegisterScreen$lambda$0$register(authViewModel, mutableState, mutableState2);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$19$1$0$1$2$0(MutableState mutableState, MutableState mutableState2) {
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            mutableState2.setValue(Boolean.TRUE);
        }
        return k0.f43947a;
    }

    private static final boolean BigRegisterScreen$lambda$0$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$20$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$21(AuthViewModel authViewModel, final MutableState mutableState, State state, u0 u0Var, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4) {
        BigRegisterScreen$lambda$0$3(mutableState, true);
        authViewModel.verityPhone(BigRegisterScreen$lambda$0$0(state).getSavedNumber(), BigRegisterScreen$lambda$0$0(state).getCountryCode(), new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.register.h
            @Override // lb.a
            public final Object invoke() {
                return BigRegisterScreenKt.BigRegisterScreen$lambda$0$21$0(mutableState);
            }
        });
        BigRegisterScreen$lambda$0$chronometerStart(u0Var, mutableState2, mutableState3, mutableState4, new Date());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$21$0(MutableState mutableState) {
        BigRegisterScreen$lambda$0$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$22$0(AuthViewModel authViewModel) {
        authViewModel.backToVerify();
        return k0.f43947a;
    }

    private static final void BigRegisterScreen$lambda$0$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigRegisterScreen$lambda$0$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigRegisterScreen$lambda$0$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean BigRegisterScreen$lambda$0$checkSmsCode(String str) {
        Pattern patternCompile = Pattern.compile("\\d{6}");
        kotlin.jvm.internal.y.f(patternCompile);
        return new le.m(patternCompile).k(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigRegisterScreen$lambda$0$chronometerStart(final u0 u0Var, final MutableState<Boolean> mutableState, final MutableState<String> mutableState2, final MutableState<String> mutableState3, Date date) {
        u0Var.f36629c = true;
        mutableState.setValue(Boolean.FALSE);
        final long time = ((long) 300000) - (new Date().getTime() - date.getTime());
        if (time > 0) {
            new CountDownTimer(time) { // from class: cu.todus.android.uiCompose.auth.screen.register.BigRegisterScreenKt$BigRegisterScreen$1$chronometerStart$countDownTimer$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    cancel();
                    BigRegisterScreenKt.BigRegisterScreen$lambda$0$makeResendAvailable(mutableState3, mutableState2, u0Var, mutableState);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    mutableState2.setValue(DateFormatter.INSTANCE.format(new Date(millisUntilFinished), "m:ss"));
                }
            }.start();
        } else {
            BigRegisterScreen$lambda$0$makeResendAvailable(mutableState3, mutableState2, u0Var, mutableState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigRegisterScreen$lambda$0$makeResendAvailable(MutableState<String> mutableState, MutableState<String> mutableState2, u0 u0Var, MutableState<Boolean> mutableState3) {
        mutableState.setValue("");
        mutableState2.setValue("0:00");
        u0Var.f36629c = false;
        mutableState3.setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigRegisterScreen$lambda$0$register(AuthViewModel authViewModel, MutableState<String> mutableState, final MutableState<Boolean> mutableState2) {
        BigRegisterScreen$lambda$0$3(mutableState2, true);
        authViewModel.register(mutableState.getValue(), new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.register.f
            @Override // lb.a
            public final Object invoke() {
                return BigRegisterScreenKt.BigRegisterScreen$lambda$0$register$15(mutableState2);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.register.g
            @Override // lb.a
            public final Object invoke() {
                return BigRegisterScreenKt.BigRegisterScreen$lambda$0$register$16(mutableState2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$register$15(MutableState mutableState) {
        BigRegisterScreen$lambda$0$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$0$register$16(MutableState mutableState) {
        BigRegisterScreen$lambda$0$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigRegisterScreen$lambda$1(NavHostController navHostController, AuthViewModel authViewModel, int i10, int i11, Composer composer, int i12) {
        BigRegisterScreen(navHostController, authViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
