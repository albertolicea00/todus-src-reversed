package cu.todus.android.uiCompose.main.screen.catalogue.catalogue;

import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueAction;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModelFactory;
import cu.todus.android.uiCompose.main.screen.catalogue.list.ProductItemKt;
import cu.todus.android.uiCompose.main.screen.catalogue.list.ProductListKt;
import cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.d0;
import ua.k0;
import ua.r;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000e²\u0006\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\r\u001a\u00020\f8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", User.COLUMN_TODUS_ID, "Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;", "viewModel", "Lua/k0;", "CatalogueScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;Landroidx/compose/runtime/Composer;II)V", "", "tags", "selectedTag", "", "showFiltered", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CatalogueScreenKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CatalogueAction.values().length];
            try {
                iArr[CatalogueAction.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CatalogueAction.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CatalogueAction.EDIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CatalogueAction.DETAILS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:60:0x0111  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CatalogueScreen(final NavHostController navHostController, String toDusId, CatalogueViewModel catalogueViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final CatalogueViewModel catalogueViewModel2;
        final String str;
        y.i(navHostController, "navHostController");
        y.i(toDusId, "toDusId");
        Composer composerStartRestartGroup = composer.startRestartGroup(-360536932);
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
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 147) != 146, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    CatalogueViewModelFactory catalogueViewModelFactory = new CatalogueViewModelFactory(toDusId);
                    int i15 = i14 & 112;
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(CatalogueViewModel.class), current, toDusId, catalogueViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, (i15 << 3) & 896, 0);
                    str = toDusId;
                    i14 &= -897;
                    catalogueViewModel2 = (CatalogueViewModel) viewModel;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-360536932, i14, -1, "cu.todus.android.uiCompose.main.screen.catalogue.catalogue.CatalogueScreen (CatalogueScreen.kt:50)");
                }
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(596584936, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.a
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CatalogueScreenKt.CatalogueScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(-1415804890, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.b
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CatalogueScreenKt.CatalogueScreen$lambda$1(catalogueViewModel2, str, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i14 &= -897;
                }
            }
            str = toDusId;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-360536932, i14, -1, "cu.todus.android.uiCompose.main.screen.catalogue.catalogue.CatalogueScreen (CatalogueScreen.kt:50)");
            }
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(596584936, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CatalogueScreenKt.CatalogueScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(-1415804890, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CatalogueScreenKt.CatalogueScreen$lambda$1(catalogueViewModel2, str, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            str = toDusId;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str2 = str;
            final CatalogueViewModel catalogueViewModel3 = catalogueViewModel2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogueScreenKt.CatalogueScreen$lambda$2(navHostController, str2, catalogueViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CatalogueScreen$lambda$0(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(596584936, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.catalogue.CatalogueScreen.<anonymous> (CatalogueScreen.kt:57)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$CatalogueScreenKt.INSTANCE.m9840getLambda$1970670853$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
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
    public static final k0 CatalogueScreen$lambda$1(final CatalogueViewModel catalogueViewModel, final String str, final NavHostController navHostController, Modifier it, Composer composer, int i10) {
        int i11;
        te.h hVarCatalogue;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415804890, i11, -1, "cu.todus.android.uiCompose.main.screen.catalogue.catalogue.CatalogueScreen.<anonymous> (CatalogueScreen.kt:68)");
            }
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composer, 0, 3);
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel.getAllTags().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.f
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(CatalogueScreenKt.CatalogueScreen$lambda$1$4$0(mutableState));
                    }
                });
                composer.updateRememberedValue(objRememberedValue2);
            }
            if (CatalogueScreen$lambda$1$5((State) objRememberedValue2)) {
                composer.startReplaceGroup(916148736);
                hVarCatalogue = CatalogueViewModel.catalogueFiltered$default(catalogueViewModel, CatalogueScreen$lambda$1$2(mutableState), null, 2, null);
            } else {
                composer.startReplaceGroup(916150464);
                hVarCatalogue = catalogueViewModel.catalogue();
            }
            LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(hVarCatalogue, null, composer, 0, 1);
            composer.endReplaceGroup();
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(it, Dp.m8823constructorimpl(20), 0.0f, 2, null);
            boolean zChangedInstance = composer.changedInstance(catalogueViewModel) | composer.changed(str) | composer.changedInstance(navHostController);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CatalogueScreenKt.CatalogueScreen$lambda$1$6$0(catalogueViewModel, str, navHostController, (Product) obj, (CatalogueAction) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function2 function2 = (Function2) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CatalogueScreenKt.CatalogueScreen$lambda$1$7$0((Product) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ProductListKt.ProductList(modifierM1727paddingVpY3zN4$default, lazyGridStateRememberLazyGridState, lazyPagingItemsCollectAsLazyPagingItems, false, function2, (Function1) objRememberedValue4, ComposableLambdaKt.rememberComposableLambda(-547857430, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogueScreenKt.CatalogueScreen$lambda$1$8(stateCollectAsStateWithLifecycle, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (LazyPagingItems.$stable << 6) | 1772544, 0);
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance2 = composer.changedInstance(catalogueViewModel) | composer.changed(str);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new CatalogueScreenKt$CatalogueScreen$2$4$1(catalogueViewModel, str, null);
                composer.updateRememberedValue(objRememberedValue5);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue5, composer, 6);
            boolean zChangedInstance3 = composer.changedInstance(catalogueViewModel);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CatalogueScreenKt.CatalogueScreen$lambda$1$10$0(catalogueViewModel, (DisposableEffectScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue6, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final List<String> CatalogueScreen$lambda$1$0(State<? extends List<String>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CatalogueScreen$lambda$1$10$0(final CatalogueViewModel catalogueViewModel, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.CatalogueScreenKt$CatalogueScreen$lambda$1$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                catalogueViewModel.clearTags();
            }
        };
    }

    private static final String CatalogueScreen$lambda$1$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CatalogueScreen$lambda$1$4$0(MutableState mutableState) {
        return !d0.q0(CatalogueScreen$lambda$1$2(mutableState));
    }

    private static final boolean CatalogueScreen$lambda$1$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CatalogueScreen$lambda$1$6$0(CatalogueViewModel catalogueViewModel, String str, NavHostController navHostController, Product product, CatalogueAction catalogueAction) {
        y.i(product, "product");
        y.i(catalogueAction, "catalogueAction");
        int i10 = WhenMappings.$EnumSwitchMapping$0[catalogueAction.ordinal()];
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            if (i10 != 4) {
                throw new r();
            }
            String strT = catalogueViewModel.getGson().t(new ProductPreviewParams(str, product.getId()));
            NavLinks navLinks = NavLinks.INSTANCE;
            y.f(strT);
            NavController.navigate$default((NavController) navHostController, navLinks.goProductPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CatalogueScreen$lambda$1$7$0(Product it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CatalogueScreen$lambda$1$8(final State state, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-547857430, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.catalogue.CatalogueScreen.<anonymous>.<anonymous> (CatalogueScreen.kt:116)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            FlowLayoutKt.FlowRow(null, null, null, null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1580057807, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CatalogueScreenKt.CatalogueScreen$lambda$1$8$0(state, mutableState, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572864, 63);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(5)), composer, 6);
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
    public static final k0 CatalogueScreen$lambda$1$8$0(State state, final MutableState mutableState, FlowRowScope FlowRow, Composer composer, int i10) {
        y.i(FlowRow, "$this$FlowRow");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1580057807, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.catalogue.CatalogueScreen.<anonymous>.<anonymous>.<anonymous> (CatalogueScreen.kt:119)");
            }
            for (final String str : CatalogueScreen$lambda$1$0(state)) {
                boolean zD = y.d(CatalogueScreen$lambda$1$2(mutableState), str);
                boolean zChanged = composer.changed(str);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.catalogue.d
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueScreenKt.CatalogueScreen$lambda$1$8$0$0$0$0(str, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ProductItemKt.ProductTagItem(null, str, zD, (lb.a) objRememberedValue, composer, 0, 1);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CatalogueScreen$lambda$1$8$0$0$0$0(String str, MutableState mutableState) {
        if (y.d(CatalogueScreen$lambda$1$2(mutableState), str)) {
            str = "";
        }
        mutableState.setValue(str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CatalogueScreen$lambda$2(NavHostController navHostController, String str, CatalogueViewModel catalogueViewModel, int i10, int i11, Composer composer, int i12) {
        CatalogueScreen(navHostController, str, catalogueViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
