package cu.todus.android.uiCompose.auth.screen.verify;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.data.geo.CountryNumber;
import cu.todus.android.uiCompose.auth.screen.AuthViewModel;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0010²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\r\u001a\u00020\f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000e\u001a\u00020\f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000f\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/auth/screen/AuthViewModel;", "viewModel", "Lua/k0;", "BigVerifyScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/auth/screen/AuthViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "showCountrySelection", "Lcu/todus/android/data/geo/CountryNumber;", "selectedCountry", "", "dialCode", TemplateContent.NUMBER_TYPE, "permissionsGranted", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BigVerifyScreenKt {
    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BigVerifyScreen(final NavHostController navHostController, AuthViewModel authViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        int i13;
        final AuthViewModel authViewModel2 = authViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2041115246);
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
                ComposerKt.traceEventStart(-2041115246, i12, -1, "cu.todus.android.uiCompose.auth.screen.verify.BigVerifyScreen (BigVerifyScreen.kt:80)");
            }
            SurfaceKt.m3707SurfaceT9BRK9s(WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(797048535, true, new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.verify.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigVerifyScreenKt.BigVerifyScreen$lambda$0(authViewModel2, (Composer) obj, ((Integer) obj2).intValue());
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.verify.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigVerifyScreenKt.BigVerifyScreen$lambda$1(navHostController, authViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 BigVerifyScreen$lambda$0(final AuthViewModel authViewModel, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(797048535, i10, -1, "cu.todus.android.uiCompose.auth.screen.verify.BigVerifyScreen.<anonymous> (BigVerifyScreen.kt:86)");
            }
            Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final FocusManager focusManager = (FocusManager) composer.consume(CompositionLocalsKt.getLocalFocusManager());
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            int i11 = ((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new ArrayList();
                composer.updateRememberedValue(objRememberedValue3);
            }
            List list = (List) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CountryNumber("🇨🇺", "+53", "CU", "Cuba", "^(\\+53|0053)?[56]\\d{7}$"), null, 2, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("53", null, 2, null);
                composer.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue6;
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue7;
            final String strStringResource = StringResources_androidKt.stringResource(R.string.invalid_number, composer, 0);
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue8);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue8;
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue9);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue9;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Integer.valueOf(R.drawable.trama_bg), null, null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composer, 24582, 492);
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceAround(), companion3.getCenterHorizontally(), composer, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            Modifier modifierA = androidx.compose.foundation.layout.x.a(ColumnScopeInstance.INSTANCE, companion2, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierA);
            lb.a constructor2 = companion4.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(200)), Integer.valueOf(R.drawable.icon), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            composer.endNode();
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            long background = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground();
            int i12 = CardDefaults.$stable;
            float f10 = 40;
            CardKt.Card(SizeKt.m1755height3ABfNKs(SizeKt.m1775widthInVpY3zN4(companion2, Dp.m8823constructorimpl(0), Dp.m8823constructorimpl(600)), Dp.m8823constructorimpl(i11 - (i11 / 3))), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 12, null), cardDefaults.m2922cardColorsro_MJ88(background, 0L, 0L, 0L, composer, i12 << 12, 14), cardDefaults.m2923cardElevationaqJV_2Y(Dp.m8823constructorimpl(4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer, (i12 << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(-1347617601, true, new Function3() { // from class: cu.todus.android.uiCompose.auth.screen.verify.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigVerifyScreenKt.BigVerifyScreen$lambda$0$21$1(strStringResource, mutableState6, mutableState4, focusManager, mutableState2, mutableState3, mutableState5, mutableState7, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            composer.endNode();
            if (BigVerifyScreen$lambda$0$1(mutableState)) {
                composer.startReplaceGroup(1459662276);
                LoadingScreenKt.LoadingWall(composer, 0);
            } else {
                composer.startReplaceGroup(-1995097205);
            }
            composer.endReplaceGroup();
            boolean zBigVerifyScreen$lambda$0$4 = BigVerifyScreen$lambda$0$4(mutableState2);
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.verify.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigVerifyScreenKt.BigVerifyScreen$lambda$0$22$0(mutableState3, mutableState4, mutableState2, (CountryNumber) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            Function1 function1 = (Function1) objRememberedValue10;
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.m
                    @Override // lb.a
                    public final Object invoke() {
                        return BigVerifyScreenKt.BigVerifyScreen$lambda$0$23$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            VerifyScreenKt.CountrySelectionList(null, zBigVerifyScreen$lambda$0$4, list, function1, (lb.a) objRememberedValue11, composer, 27648, 1);
            Composer composer2 = composer;
            if (Build.VERSION.SDK_INT <= 30) {
                composer2.startReplaceGroup(1459677733);
                List listE = va.v.e(PermissionNeedIt.READ_SMS);
                Object objRememberedValue12 = composer2.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.n
                        @Override // lb.a
                        public final Object invoke() {
                            return BigVerifyScreenKt.BigVerifyScreen$lambda$0$24$0(mutableState8);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                String packageName = context.getPackageName();
                kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
                Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listE, (lb.a) objRememberedValue12, null, packageName, null, composer, 1576320, 19);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1994340309);
                composer2.endReplaceGroup();
            }
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.please_confirm, composer2, 0);
            String str = StringResources_androidKt.stringResource(R.string.the_number_to_verify_is, composer2, 0) + " +" + BigVerifyScreen$lambda$0$11(mutableState4) + BigVerifyScreen$lambda$0$14(mutableState5);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.edit, composer2, 0);
            boolean zBooleanValue = ((Boolean) mutableState7.getValue()).booleanValue();
            Object objRememberedValue13 = composer2.rememberedValue();
            if (objRememberedValue13 == companion.getEmpty()) {
                objRememberedValue13 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.b
                    @Override // lb.a
                    public final Object invoke() {
                        return BigVerifyScreenKt.BigVerifyScreen$lambda$0$25$0(mutableState7);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue13);
            }
            lb.a aVar = (lb.a) objRememberedValue13;
            boolean zChangedInstance = composer2.changedInstance(authViewModel);
            Object objRememberedValue14 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue14 == companion.getEmpty()) {
                objRememberedValue14 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.c
                    @Override // lb.a
                    public final Object invoke() {
                        return BigVerifyScreenKt.BigVerifyScreen$lambda$0$26$0(authViewModel, mutableState, mutableState4, mutableState5);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue14);
            }
            Z17DialogsKt.Z17DialogWithActions(zBooleanValue, aVar, (lb.a) objRememberedValue14, null, strStringResource2, str, null, strStringResource3, composer, 48, 72);
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance2 = composer.changedInstance(context) | composer.changedInstance(list) | composer.changedInstance(authViewModel);
            Object objRememberedValue15 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue15 == companion.getEmpty()) {
                objRememberedValue15 = new BigVerifyScreenKt$BigVerifyScreen$1$7$1(context, list, authViewModel, null);
                composer.updateRememberedValue(objRememberedValue15);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue15, composer, 6);
            String strBigVerifyScreen$lambda$0$11 = BigVerifyScreen$lambda$0$11(mutableState4);
            boolean zChangedInstance3 = composer.changedInstance(list);
            Object objRememberedValue16 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue16 == companion.getEmpty()) {
                objRememberedValue16 = new BigVerifyScreenKt$BigVerifyScreen$1$8$1(list, mutableState4, mutableState3, null);
                composer.updateRememberedValue(objRememberedValue16);
            }
            EffectsKt.LaunchedEffect(strBigVerifyScreen$lambda$0$11, (Function2) objRememberedValue16, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final boolean BigVerifyScreen$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BigVerifyScreen$lambda$0$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String BigVerifyScreen$lambda$0$14(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final void BigVerifyScreen$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final void BigVerifyScreen$lambda$0$20(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 BigVerifyScreen$lambda$0$21$1(final String str, final MutableState mutableState, final MutableState mutableState2, final FocusManager focusManager, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, ColumnScope Card, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Card, "$this$Card");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1347617601, i10, -1, "cu.todus.android.uiCompose.auth.screen.verify.BigVerifyScreen.<anonymous>.<anonymous>.<anonymous> (BigVerifyScreen.kt:162)");
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
            String strStringResource = StringResources_androidKt.stringResource(R.string.insert_phone_number, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierSafeContentPadding, strStringResource, materialTheme.getTypography(composer, i11).getTitleLarge(), 0L, 0, 0, composer, 0, 56);
            float f11 = 10;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            float f12 = 0;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1728paddingqDBjuR0(companion, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f12)), StringResources_androidKt.stringResource(R.string.verify_phone_number_information_text, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 6, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.m1775widthInVpY3zN4(companion, Dp.m8823constructorimpl(100), Dp.m8823constructorimpl(MenuKt.InTransitionDuration)), Dp.m8823constructorimpl(5), 0.0f, 2, null);
            KeyboardType.Companion companion4 = KeyboardType.INSTANCE;
            int iM8504getPhonePjHm6EE = companion4.m8504getPhonePjHm6EE();
            String strBigVerifyScreen$lambda$0$11 = BigVerifyScreen$lambda$0$11(mutableState2);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue == companion5.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.verify.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigVerifyScreenKt.BigVerifyScreen$lambda$0$21$1$0$0$0$0$0(mutableState2, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierM1727paddingVpY3zN4$default, strBigVerifyScreen$lambda$0$11, 0, 0, null, null, (Function1) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1795594170, true, new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.verify.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigVerifyScreenKt.BigVerifyScreen$lambda$0$21$1$0$0$0$1(focusManager, mutableState3, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 3, iM8504getPhonePjHm6EE, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 819462150, 6, 1046844);
            Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
            int iM8504getPhonePjHm6EE2 = companion4.m8504getPhonePjHm6EE();
            String str2 = (String) mutableState.getValue();
            String strBigVerifyScreen$lambda$0$14 = BigVerifyScreen$lambda$0$14(mutableState5);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion5.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.verify.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigVerifyScreenKt.BigVerifyScreen$lambda$0$21$1$0$0$0$2$0(mutableState5, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierA, strBigVerifyScreen$lambda$0$14, 0, 0, null, str2, (Function1) objRememberedValue2, null, null, 11, iM8504getPhonePjHm6EE2, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806879232, 6, 1046940);
            composer.endNode();
            composer.endNode();
            boolean zChanged = composer.changed(str);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion5.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.h
                    @Override // lb.a
                    public final Object invoke() {
                        return BigVerifyScreenKt.BigVerifyScreen$lambda$0$21$1$0$1$0(mutableState6, mutableState, str, mutableState2, mutableState5, mutableState4);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue3 = aVar;
            }
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue3, StringResources_androidKt.stringResource(R.string.accept_and_continue, composer, 0), null, true, false, composer, 24576, 41);
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
    public static final k0 BigVerifyScreen$lambda$0$21$1$0$0$0$0$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        String strL = new le.m("[^0-9]").l(it, "");
        if (TextUtils.isDigitsOnly(strL)) {
            mutableState.setValue(strL);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 BigVerifyScreen$lambda$0$21$1$0$0$0$1(final FocusManager focusManager, final MutableState mutableState, MutableState mutableState2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1795594170, i10, -1, "cu.todus.android.uiCompose.auth.screen.verify.BigVerifyScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigVerifyScreen.kt:202)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean zChangedInstance = composer.changedInstance(focusManager);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.j
                    @Override // lb.a
                    public final Object invoke() {
                        return BigVerifyScreenKt.BigVerifyScreen$lambda$0$21$1$0$0$0$1$0$0(focusManager, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), BigVerifyScreen$lambda$0$8(mutableState2).getFlag() + " +", null, 0L, 0, 0, composer, 0, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$21$1$0$0$0$1$0$0(FocusManager focusManager, MutableState mutableState) {
        BigVerifyScreen$lambda$0$5(mutableState, true);
        androidx.compose.ui.focus.c.a(focusManager, false, 1, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$21$1$0$0$0$2$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        if (TextUtils.isDigitsOnly(it)) {
            mutableState.setValue(it);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$21$1$0$1$0(MutableState mutableState, MutableState mutableState2, String str, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        if (BigVerifyScreen$lambda$0$checkPhone(mutableState5, "+" + BigVerifyScreen$lambda$0$11(mutableState3) + BigVerifyScreen$lambda$0$14(mutableState4))) {
            mutableState.setValue(Boolean.TRUE);
            mutableState2.setValue("");
        } else {
            mutableState2.setValue(str);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$22$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, CountryNumber it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        mutableState2.setValue(le.a0.O(it.getDialCode(), "+", "", false, 4, null));
        BigVerifyScreen$lambda$0$5(mutableState3, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$23$0(MutableState mutableState) {
        BigVerifyScreen$lambda$0$5(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$24$0(MutableState mutableState) {
        BigVerifyScreen$lambda$0$20(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$25$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$26$0(AuthViewModel authViewModel, final MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        BigVerifyScreen$lambda$0$2(mutableState, true);
        authViewModel.verityPhone(le.a0.O(le.a0.O(BigVerifyScreen$lambda$0$11(mutableState2) + BigVerifyScreen$lambda$0$14(mutableState3), " ", "", false, 4, null), "+", "", false, 4, null), Integer.parseInt(le.a0.O(le.a0.O(BigVerifyScreen$lambda$0$11(mutableState2), " ", "", false, 4, null), "+", "", false, 4, null)), new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.i
            @Override // lb.a
            public final Object invoke() {
                return BigVerifyScreenKt.BigVerifyScreen$lambda$0$26$0$0(mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$0$26$0$0(MutableState mutableState) {
        BigVerifyScreen$lambda$0$2(mutableState, false);
        return k0.f43947a;
    }

    private static final boolean BigVerifyScreen$lambda$0$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigVerifyScreen$lambda$0$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final CountryNumber BigVerifyScreen$lambda$0$8(MutableState<CountryNumber> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean BigVerifyScreen$lambda$0$checkPhone(MutableState<CountryNumber> mutableState, String str) {
        if (BigVerifyScreen$lambda$0$8(mutableState).getPattern().length() > 0) {
            return new le.m(BigVerifyScreen$lambda$0$8(mutableState).getPattern()).k(le.d0.q1(str).toString());
        }
        return str.length() > 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigVerifyScreen$lambda$1(NavHostController navHostController, AuthViewModel authViewModel, int i10, int i11, Composer composer, int i12) {
        BigVerifyScreen(navHostController, authViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
