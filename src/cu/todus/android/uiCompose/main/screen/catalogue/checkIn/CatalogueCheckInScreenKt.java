package cu.todus.android.uiCompose.main.screen.catalogue.checkIn;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
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
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000e²\u0006\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\r\u001a\u00020\f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", User.COLUMN_TODUS_ID, "Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;", "viewModel", "Lua/k0;", "CatalogueCheckInScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/wrapper/FlowsState;", "", "checkState", "", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CatalogueCheckInScreenKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.NOT_REQUESTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CatalogueCheckInScreen(final NavHostController navHostController, final String toDusId, CatalogueViewModel catalogueViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        CatalogueViewModel catalogueViewModel2;
        final CatalogueViewModel catalogueViewModel3;
        y.i(navHostController, "navHostController");
        y.i(toDusId, "toDusId");
        Composer composerStartRestartGroup = composer.startRestartGroup(1846189682);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(toDusId) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                catalogueViewModel2 = catalogueViewModel;
                int i13 = composerStartRestartGroup.changedInstance(catalogueViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                catalogueViewModel2 = catalogueViewModel;
            }
            i12 |= i13;
        } else {
            catalogueViewModel2 = catalogueViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            } else if ((i11 & 4) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                catalogueViewModel2 = (CatalogueViewModel) ViewModelKt.viewModel(z0.b(CatalogueViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i12 &= -897;
            }
            CatalogueViewModel catalogueViewModel4 = catalogueViewModel2;
            int i14 = i12;
            catalogueViewModel3 = catalogueViewModel4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1846189682, i14, -1, "cu.todus.android.uiCompose.main.screen.catalogue.checkIn.CatalogueCheckInScreen (CatalogueCheckInScreen.kt:45)");
            }
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1448972734, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.checkIn.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CatalogueCheckInScreenKt.CatalogueCheckInScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(319390460, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.checkIn.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CatalogueCheckInScreenKt.CatalogueCheckInScreen$lambda$1(catalogueViewModel3, toDusId, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            catalogueViewModel3 = catalogueViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.checkIn.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogueCheckInScreenKt.CatalogueCheckInScreen$lambda$2(navHostController, toDusId, catalogueViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CatalogueCheckInScreen$lambda$0(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1448972734, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.checkIn.CatalogueCheckInScreen.<anonymous> (CatalogueCheckInScreen.kt:52)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$CatalogueCheckInScreenKt.INSTANCE.m9841getLambda$1439934895$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
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
    public static final k0 CatalogueCheckInScreen$lambda$1(CatalogueViewModel catalogueViewModel, String str, final NavHostController navHostController, Modifier it, Composer composer, int i10) {
        int i11;
        MutableState mutableState;
        int i12;
        final String str2;
        MutableState mutableState2;
        Composer composer2 = composer;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer2.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer2.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(319390460, i11, -1, "cu.todus.android.uiCompose.main.screen.catalogue.checkIn.CatalogueCheckInScreen.<anonymous> (CatalogueCheckInScreen.kt:63)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel.getCheckResponse(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 0, 7);
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(it, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i13 = WhenMappings.$EnumSwitchMapping$0[CatalogueCheckInScreen$lambda$1$0(stateCollectAsStateWithLifecycle).getStatus().ordinal()];
            if (i13 == 1) {
                mutableState = mutableState3;
                i12 = 6;
                composer2.startReplaceGroup(-544783617);
                Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
                Modifier.Companion companion4 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion4);
                lb.a constructor2 = companion3.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(150)), Integer.valueOf(R.drawable.shop), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                composer2 = composer;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion4, Dp.m8823constructorimpl(10)), composer2, 6);
                str2 = str;
                boolean zChangedInstance = composer2.changedInstance(navHostController) | composer2.changed(str2);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.checkIn.a
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueCheckInScreenKt.CatalogueCheckInScreen$lambda$1$4$0$0$0(navHostController, str2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue2, StringResources_androidKt.stringResource(R.string.view_catalogue, composer2, 0), null, false, false, composer2, 0, 57);
                composer2.endNode();
                composer2.endReplaceGroup();
                k0 k0Var = k0.f43947a;
            } else if (i13 != 2) {
                if (i13 == 3) {
                    mutableState2 = mutableState3;
                    composer2.startReplaceGroup(-543587606);
                    composer2.endReplaceGroup();
                    k0 k0Var2 = k0.f43947a;
                } else if (i13 != 4) {
                    composer2.startReplaceGroup(-543493769);
                    Alignment.Horizontal centerHorizontally2 = companion2.getCenterHorizontally();
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composer2, 48);
                    int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion5);
                    lb.a constructor3 = companion3.getConstructor();
                    if (!r.a(composer2.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion5, Dp.m8823constructorimpl(10)), composer2, 6);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.checkIn.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = mutableState3;
                    IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, null, ComposableSingletons$CatalogueCheckInScreenKt.INSTANCE.getLambda$1222997953$app_productionPFast(), composer, 1572870, 62);
                    composer2 = composer;
                    composer2.endNode();
                    composer2.endReplaceGroup();
                    k0 k0Var3 = k0.f43947a;
                } else {
                    mutableState2 = mutableState3;
                    composer2.startReplaceGroup(-543543958);
                    composer2.endReplaceGroup();
                    k0 k0Var4 = k0.f43947a;
                }
                str2 = str;
                mutableState = mutableState2;
                i12 = 6;
            } else {
                composer2.startReplaceGroup(-544166345);
                Alignment.Horizontal centerHorizontally3 = companion2.getCenterHorizontally();
                Modifier.Companion companion6 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally3, composer2, 48);
                int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, companion6);
                lb.a constructor4 = companion3.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy3, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                mutableState = mutableState3;
                i12 = 6;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion6, Dp.m8823constructorimpl(150)), Integer.valueOf(R.drawable.closed_shop), null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                composer2 = composer;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(10)), composer2, 6);
                boolean zChangedInstance2 = composer2.changedInstance(navHostController);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.checkIn.b
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueCheckInScreenKt.CatalogueCheckInScreen$lambda$1$4$1$0$0(navHostController);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue4, StringResources_androidKt.stringResource(R.string.go_back, composer2, 0), null, false, false, composer2, 0, 57);
                composer2.endNode();
                composer2.endReplaceGroup();
                k0 k0Var5 = k0.f43947a;
                str2 = str;
            }
            composer2.endNode();
            if (CatalogueCheckInScreen$lambda$1$2(mutableState)) {
                composer2.startReplaceGroup(1991630825);
                LoadingScreenKt.LoadingWall(composer2, 0);
            } else {
                composer2.startReplaceGroup(1611025926);
            }
            composer2.endReplaceGroup();
            k0 k0Var6 = k0.f43947a;
            boolean zChangedInstance3 = composer2.changedInstance(catalogueViewModel) | composer2.changed(str2);
            Object objRememberedValue5 = composer2.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new CatalogueCheckInScreenKt$CatalogueCheckInScreen$2$2$1(catalogueViewModel, str2, mutableState, null);
                composer2.updateRememberedValue(objRememberedValue5);
            }
            EffectsKt.LaunchedEffect(k0Var6, (Function2) objRememberedValue5, composer2, i12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final FlowsState<Integer> CatalogueCheckInScreen$lambda$1$0(State<FlowsState<Integer>> state) {
        return state.getValue();
    }

    private static final boolean CatalogueCheckInScreen$lambda$1$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CatalogueCheckInScreen$lambda$1$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CatalogueCheckInScreen$lambda$1$4$0$0$0(NavHostController navHostController, String str) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goCatalogue(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CatalogueCheckInScreen$lambda$1$4$1$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CatalogueCheckInScreen$lambda$2(NavHostController navHostController, String str, CatalogueViewModel catalogueViewModel, int i10, int i11, Composer composer, int i12) {
        CatalogueCheckInScreen(navHostController, str, catalogueViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
