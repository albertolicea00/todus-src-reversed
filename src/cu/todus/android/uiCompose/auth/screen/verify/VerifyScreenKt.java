package cu.todus.android.uiCompose.auth.screen.verify;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.ts.TsExtractor;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aQ\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u001b²\u0006\u000e\u0010\u0014\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0016\u001a\u00020\f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0018\u001a\u00020\u00178\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0019\u001a\u00020\u00178\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/auth/screen/AuthViewModel;", "viewModel", "Lua/k0;", "VerifyScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/auth/screen/AuthViewModel;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "", "show", "", "Lcu/todus/android/data/geo/CountryNumber;", "countryNumbers", "Lkotlin/Function1;", "onSelected", "Lkotlin/Function0;", "onClose", "CountrySelectionList", "(Landroidx/compose/ui/Modifier;ZLjava/util/List;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;II)V", "isLoading", "showCountrySelection", "selectedCountry", "", "dialCode", TemplateContent.NUMBER_TYPE, "permissionsGranted", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class VerifyScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CountrySelectionList(Modifier modifier, final boolean z10, final List<CountryNumber> countryNumbers, final Function1 onSelected, final lb.a onClose, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Composer composer2;
        final Modifier modifier3;
        Modifier modifier4;
        kotlin.jvm.internal.y.i(countryNumbers, "countryNumbers");
        kotlin.jvm.internal.y.i(onSelected, "onSelected");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1232953834);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(countryNumbers) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onSelected) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClose) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            Modifier modifier5 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1232953834, i12, -1, "cu.todus.android.uiCompose.auth.screen.verify.CountrySelectionList (VerifyScreen.kt:328)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-367073587);
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifier5, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                modifier4 = modifier5;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(modifier4);
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                boolean zChangedInstance = ((57344 & i12) == 16384) | composerStartRestartGroup.changedInstance(countryNumbers) | ((i12 & 7168) == 2048);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.verify.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return VerifyScreenKt.CountrySelectionList$lambda$0$0$0(countryNumbers, onClose, onSelected, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                LazyDslKt.LazyColumn(modifierSafeContentPadding, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
                composer2 = composerStartRestartGroup;
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                modifier4 = modifier5;
                composer2.startReplaceGroup(-364675892);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.verify.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VerifyScreenKt.CountrySelectionList$lambda$1(modifier3, z10, countryNumbers, onSelected, onClose, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CountrySelectionList$lambda$0$0$0(final List list, final lb.a aVar, final Function1 function1, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        LazyListScope.CC.s(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1548457836, true, new lb.o() { // from class: cu.todus.android.uiCompose.auth.screen.verify.d0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return VerifyScreenKt.CountrySelectionList$lambda$0$0$0$0(aVar, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 3, null);
        LazyListScope.CC.o(LazyColumn, list.size(), new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.verify.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VerifyScreenKt.CountrySelectionList$lambda$0$0$0$1(list, ((Integer) obj).intValue());
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(1494255607, true, new lb.o() { // from class: cu.todus.android.uiCompose.auth.screen.verify.f0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return VerifyScreenKt.CountrySelectionList$lambda$0$0$0$2(list, function1, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CountrySelectionList$lambda$0$0$0$0(final lb.a aVar, LazyItemScope stickyHeader, int i10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(stickyHeader, "$this$stickyHeader");
        if (composer.shouldExecute((i11 & TsExtractor.TS_STREAM_TYPE_AC3) != 128, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1548457836, i11, -1, "cu.todus.android.uiCompose.auth.screen.verify.CountrySelectionList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VerifyScreen.kt:340)");
            }
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getEnd(), Alignment.INSTANCE.getTop(), composer, 6);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1205backgroundbw27NRU$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.b0
                    @Override // lb.a
                    public final Object invoke() {
                        return VerifyScreenKt.CountrySelectionList$lambda$0$0$0$0$0$0$0(aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, ComposableSingletons$VerifyScreenKt.INSTANCE.m9803getLambda$169387242$app_productionPFast(), composer, 1572864, 62);
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
    public static final k0 CountrySelectionList$lambda$0$0$0$0$0$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object CountrySelectionList$lambda$0$0$0$1(List list, int i10) {
        return ((CountryNumber) list.get(i10)).getCountryName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CountrySelectionList$lambda$0$0$0$2(List list, final Function1 function1, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1494255607, i12, -1, "cu.todus.android.uiCompose.auth.screen.verify.CountrySelectionList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VerifyScreen.kt:365)");
            }
            final CountryNumber countryNumber = (CountryNumber) list.get(i10);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            boolean zChanged = composer.changed(function1) | composer.changed(countryNumber);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.p
                    @Override // lb.a
                    public final Object invoke() {
                        return VerifyScreenKt.CountrySelectionList$lambda$0$0$0$2$0$0(function1, countryNumber);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(15));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1726paddingVpY3zN4);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String str = countryNumber.getFlag() + countryNumber.getCode();
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, materialTheme.getTypography(composer, i13).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), countryNumber.getCountryName(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i13).getBodyLarge(), 0L, 0L, FontWeight.INSTANCE.getBlack(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 0, composer, 0, 56);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(3)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, countryNumber.getDialCode(), materialTheme.getTypography(composer, i13).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 CountrySelectionList$lambda$0$0$0$2$0$0(Function1 function1, CountryNumber countryNumber) {
        function1.invoke(countryNumber);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CountrySelectionList$lambda$1(Modifier modifier, boolean z10, List list, Function1 function1, lb.a aVar, int i10, int i11, Composer composer, int i12) {
        CountrySelectionList(modifier, z10, list, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VerifyScreen(final NavHostController navHostController, AuthViewModel authViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        int i13;
        final AuthViewModel authViewModel2 = authViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1324130386);
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
                ComposerKt.traceEventStart(-1324130386, i12, -1, "cu.todus.android.uiCompose.auth.screen.verify.VerifyScreen (VerifyScreen.kt:80)");
            }
            SurfaceKt.m3707SurfaceT9BRK9s(WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(210364595, true, new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.verify.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VerifyScreenKt.VerifyScreen$lambda$0(authViewModel2, (Composer) obj, ((Integer) obj2).intValue());
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.verify.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VerifyScreenKt.VerifyScreen$lambda$1(navHostController, authViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 VerifyScreen$lambda$0(final AuthViewModel authViewModel, Composer composer, int i10) {
        List list;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(210364595, i10, -1, "cu.todus.android.uiCompose.auth.screen.verify.VerifyScreen.<anonymous> (VerifyScreen.kt:86)");
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
            List list2 = (List) objRememberedValue3;
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
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(companion2, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
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
            CardKt.Card(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(i11 - (i11 / 3))), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 12, null), cardDefaults.m2922cardColorsro_MJ88(background, 0L, 0L, 0L, composer, i12 << 12, 14), cardDefaults.m2923cardElevationaqJV_2Y(Dp.m8823constructorimpl(4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer, (i12 << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(-794594149, true, new Function3() { // from class: cu.todus.android.uiCompose.auth.screen.verify.g0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return VerifyScreenKt.VerifyScreen$lambda$0$21$1(strStringResource, mutableState6, mutableState4, focusManager, mutableState2, mutableState3, mutableState5, mutableState7, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            composer.endNode();
            if (VerifyScreen$lambda$0$1(mutableState)) {
                composer.startReplaceGroup(297111008);
                LoadingScreenKt.LoadingWall(composer, 0);
            } else {
                composer.startReplaceGroup(620519151);
            }
            composer.endReplaceGroup();
            boolean zVerifyScreen$lambda$0$4 = VerifyScreen$lambda$0$4(mutableState2);
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.verify.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VerifyScreenKt.VerifyScreen$lambda$0$22$0(mutableState3, mutableState4, mutableState2, (CountryNumber) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            Function1 function1 = (Function1) objRememberedValue10;
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.i0
                    @Override // lb.a
                    public final Object invoke() {
                        return VerifyScreenKt.VerifyScreen$lambda$0$23$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            CountrySelectionList(null, zVerifyScreen$lambda$0$4, list2, function1, (lb.a) objRememberedValue11, composer, 27648, 1);
            Composer composer2 = composer;
            if (Build.VERSION.SDK_INT <= 30) {
                composer2.startReplaceGroup(297126465);
                List listE = va.v.e(PermissionNeedIt.READ_SMS);
                Object objRememberedValue12 = composer2.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.j0
                        @Override // lb.a
                        public final Object invoke() {
                            return VerifyScreenKt.VerifyScreen$lambda$0$24$0(mutableState8);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                String packageName = context.getPackageName();
                kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
                list = list2;
                Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listE, (lb.a) objRememberedValue12, null, packageName, null, composer, 1576320, 19);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                list = list2;
                composer2.startReplaceGroup(621276047);
                composer2.endReplaceGroup();
            }
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.please_confirm, composer2, 0);
            String str = StringResources_androidKt.stringResource(R.string.the_number_to_verify_is, composer2, 0) + " +" + VerifyScreen$lambda$0$11(mutableState4) + VerifyScreen$lambda$0$14(mutableState5);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.edit, composer2, 0);
            boolean zBooleanValue = ((Boolean) mutableState7.getValue()).booleanValue();
            Object objRememberedValue13 = composer2.rememberedValue();
            if (objRememberedValue13 == companion.getEmpty()) {
                objRememberedValue13 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.q
                    @Override // lb.a
                    public final Object invoke() {
                        return VerifyScreenKt.VerifyScreen$lambda$0$25$0(mutableState7);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue13);
            }
            lb.a aVar = (lb.a) objRememberedValue13;
            boolean zChangedInstance = composer2.changedInstance(authViewModel);
            Object objRememberedValue14 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue14 == companion.getEmpty()) {
                objRememberedValue14 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.r
                    @Override // lb.a
                    public final Object invoke() {
                        return VerifyScreenKt.VerifyScreen$lambda$0$26$0(authViewModel, mutableState, mutableState4, mutableState5);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue14);
            }
            Z17DialogsKt.Z17DialogWithActions(zBooleanValue, aVar, (lb.a) objRememberedValue14, null, strStringResource2, str, null, strStringResource3, composer, 48, 72);
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance2 = composer.changedInstance(context) | composer.changedInstance(list) | composer.changedInstance(authViewModel);
            Object objRememberedValue15 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue15 == companion.getEmpty()) {
                objRememberedValue15 = new VerifyScreenKt$VerifyScreen$1$7$1(context, list, authViewModel, null);
                composer.updateRememberedValue(objRememberedValue15);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue15, composer, 6);
            String strVerifyScreen$lambda$0$11 = VerifyScreen$lambda$0$11(mutableState4);
            boolean zChangedInstance3 = composer.changedInstance(list);
            Object objRememberedValue16 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue16 == companion.getEmpty()) {
                objRememberedValue16 = new VerifyScreenKt$VerifyScreen$1$8$1(list, mutableState4, mutableState3, null);
                composer.updateRememberedValue(objRememberedValue16);
            }
            EffectsKt.LaunchedEffect(strVerifyScreen$lambda$0$11, (Function2) objRememberedValue16, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final boolean VerifyScreen$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String VerifyScreen$lambda$0$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String VerifyScreen$lambda$0$14(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final void VerifyScreen$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final void VerifyScreen$lambda$0$20(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 VerifyScreen$lambda$0$21$1(final String str, final MutableState mutableState, final MutableState mutableState2, final FocusManager focusManager, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, ColumnScope Card, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Card, "$this$Card");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-794594149, i10, -1, "cu.todus.android.uiCompose.auth.screen.verify.VerifyScreen.<anonymous>.<anonymous>.<anonymous> (VerifyScreen.kt:162)");
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
            String strVerifyScreen$lambda$0$11 = VerifyScreen$lambda$0$11(mutableState2);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue == companion5.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.verify.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VerifyScreenKt.VerifyScreen$lambda$0$21$1$0$0$0$0$0(mutableState2, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierM1727paddingVpY3zN4$default, strVerifyScreen$lambda$0$11, 0, 0, null, null, (Function1) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-1977636906, true, new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.verify.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VerifyScreenKt.VerifyScreen$lambda$0$21$1$0$0$0$1(focusManager, mutableState3, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 3, iM8504getPhonePjHm6EE, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 819462150, 6, 1046844);
            Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
            int iM8504getPhonePjHm6EE2 = companion4.m8504getPhonePjHm6EE();
            String str2 = (String) mutableState.getValue();
            String strVerifyScreen$lambda$0$14 = VerifyScreen$lambda$0$14(mutableState5);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion5.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.auth.screen.verify.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VerifyScreenKt.VerifyScreen$lambda$0$21$1$0$0$0$2$0(mutableState5, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierA, strVerifyScreen$lambda$0$14, 0, 0, null, str2, (Function1) objRememberedValue2, null, null, 11, iM8504getPhonePjHm6EE2, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806879232, 6, 1046940);
            composer.endNode();
            composer.endNode();
            boolean zChanged = composer.changed(str);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion5.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.v
                    @Override // lb.a
                    public final Object invoke() {
                        return VerifyScreenKt.VerifyScreen$lambda$0$21$1$0$1$0(mutableState6, mutableState, str, mutableState2, mutableState5, mutableState4);
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
    public static final k0 VerifyScreen$lambda$0$21$1$0$0$0$0$0(MutableState mutableState, String it) {
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
    public static final k0 VerifyScreen$lambda$0$21$1$0$0$0$1(final FocusManager focusManager, final MutableState mutableState, MutableState mutableState2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1977636906, i10, -1, "cu.todus.android.uiCompose.auth.screen.verify.VerifyScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VerifyScreen.kt:202)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean zChangedInstance = composer.changedInstance(focusManager);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.c0
                    @Override // lb.a
                    public final Object invoke() {
                        return VerifyScreenKt.VerifyScreen$lambda$0$21$1$0$0$0$1$0$0(focusManager, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), VerifyScreen$lambda$0$8(mutableState2).getFlag() + " +", null, 0L, 0, 0, composer, 0, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$21$1$0$0$0$1$0$0(FocusManager focusManager, MutableState mutableState) {
        VerifyScreen$lambda$0$5(mutableState, true);
        androidx.compose.ui.focus.c.a(focusManager, false, 1, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$21$1$0$0$0$2$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        if (TextUtils.isDigitsOnly(it)) {
            mutableState.setValue(it);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$21$1$0$1$0(MutableState mutableState, MutableState mutableState2, String str, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        if (VerifyScreen$lambda$0$checkPhone(mutableState5, "+" + VerifyScreen$lambda$0$11(mutableState3) + VerifyScreen$lambda$0$14(mutableState4))) {
            mutableState.setValue(Boolean.TRUE);
            mutableState2.setValue("");
        } else {
            mutableState2.setValue(str);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$22$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, CountryNumber it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        mutableState2.setValue(le.a0.O(it.getDialCode(), "+", "", false, 4, null));
        VerifyScreen$lambda$0$5(mutableState3, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$23$0(MutableState mutableState) {
        VerifyScreen$lambda$0$5(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$24$0(MutableState mutableState) {
        VerifyScreen$lambda$0$20(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$25$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$26$0(AuthViewModel authViewModel, final MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        VerifyScreen$lambda$0$2(mutableState, true);
        authViewModel.verityPhone(le.a0.O(le.a0.O(VerifyScreen$lambda$0$11(mutableState2) + VerifyScreen$lambda$0$14(mutableState3), " ", "", false, 4, null), "+", "", false, 4, null), Integer.parseInt(le.a0.O(le.a0.O(VerifyScreen$lambda$0$11(mutableState2), " ", "", false, 4, null), "+", "", false, 4, null)), new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.verify.a0
            @Override // lb.a
            public final Object invoke() {
                return VerifyScreenKt.VerifyScreen$lambda$0$26$0$0(mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$0$26$0$0(MutableState mutableState) {
        VerifyScreen$lambda$0$2(mutableState, false);
        return k0.f43947a;
    }

    private static final boolean VerifyScreen$lambda$0$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VerifyScreen$lambda$0$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final CountryNumber VerifyScreen$lambda$0$8(MutableState<CountryNumber> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean VerifyScreen$lambda$0$checkPhone(MutableState<CountryNumber> mutableState, String str) {
        if (VerifyScreen$lambda$0$8(mutableState).getPattern().length() > 0) {
            return new le.m(VerifyScreen$lambda$0$8(mutableState).getPattern()).k(le.d0.q1(str).toString());
        }
        return str.length() > 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VerifyScreen$lambda$1(NavHostController navHostController, AuthViewModel authViewModel, int i10, int i11, Composer composer, int i12) {
        VerifyScreen(navHostController, authViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
