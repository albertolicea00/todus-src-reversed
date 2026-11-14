package cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
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
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueAction;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel;
import cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormParams;
import cu.todus.android.uiCompose.main.screen.catalogue.list.ProductItemKt;
import cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewParams;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0013²\u0006\f\u0010\b\u001a\u00020\u00078\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\f\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\r\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u000f\u001a\u00020\u000e8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0010\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0011\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;", "viewModel", "Lua/k0;", "MyCatalogueScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;Landroidx/compose/runtime/Composer;II)V", "", "publicCant", "", "", "tags", "selectedTag", "filter", "", "showFloatingActionBtn", "refreshTags", "url", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MyCatalogueScreenKt {

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

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MyCatalogueScreen(final NavHostController navHostController, CatalogueViewModel catalogueViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final CatalogueViewModel catalogueViewModel2;
        final CatalogueViewModel catalogueViewModel3;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1522556903);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                catalogueViewModel2 = catalogueViewModel;
                int i13 = composerStartRestartGroup.changedInstance(catalogueViewModel2) ? 32 : 16;
                i12 |= i13;
            } else {
                catalogueViewModel2 = catalogueViewModel;
            }
            i12 |= i13;
        } else {
            catalogueViewModel2 = catalogueViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
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
                ViewModel viewModel = ViewModelKt.viewModel(z0.b(CatalogueViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                catalogueViewModel2 = (CatalogueViewModel) viewModel;
                i12 &= -113;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1522556903, i12, -1, "cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreen (MyCatalogueScreen.kt:73)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                Object systemService = context.getSystemService("clipboard");
                kotlin.jvm.internal.y.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                objRememberedValue = (ClipboardManager) systemService;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ClipboardManager clipboardManager = (ClipboardManager) objRememberedValue;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel2.getPublicCant(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            Composer composer2 = composerStartRestartGroup;
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel2.getAllTags().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composer2.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(catalogueViewModel2.myFilteredCatalogue(MyCatalogueScreen$lambda$4(mutableState), MyCatalogueScreen$lambda$7((MutableState) objRememberedValue3)), null, composer2, 0, 1);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.o
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(MyCatalogueScreenKt.MyCatalogueScreen$lambda$9$0(lazyPagingItemsCollectAsLazyPagingItems));
                    }
                });
                composer2.updateRememberedValue(objRememberedValue4);
            }
            State state = (State) objRememberedValue4;
            Object objRememberedValue5 = composer2.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(1);
                composer2.updateRememberedValue(objRememberedValue5);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue5;
            boolean zMyCatalogueScreen$lambda$10 = MyCatalogueScreen$lambda$10(state);
            catalogueViewModel3 = catalogueViewModel2;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-383303347, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MyCatalogueScreenKt.MyCatalogueScreen$lambda$14(navHostController, catalogueViewModel2, stateCollectAsStateWithLifecycle, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), false, false, zMyCatalogueScreen$lambda$10, ComposableLambdaKt.rememberComposableLambda(147604385, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MyCatalogueScreenKt.MyCatalogueScreen$lambda$15(catalogueViewModel2, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-1695145137, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16(lazyPagingItemsCollectAsLazyPagingItems, catalogueViewModel3, navHostController, stateCollectAsStateWithLifecycle, stateCollectAsStateWithLifecycle2, mutableState, mutableIntState, clipboardManager, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 805331382, 352);
            composerStartRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            catalogueViewModel3 = catalogueViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MyCatalogueScreenKt.MyCatalogueScreen$lambda$17(navHostController, catalogueViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int MyCatalogueScreen$lambda$1(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final boolean MyCatalogueScreen$lambda$10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MyCatalogueScreen$lambda$14(final NavHostController navHostController, final CatalogueViewModel catalogueViewModel, final State state, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-383303347, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreen.<anonymous> (MyCatalogueScreen.kt:111)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$MyCatalogueScreenKt.INSTANCE.m9849getLambda$604665382$app_productionPFast(), null, false, ComposableLambdaKt.rememberComposableLambda(318201029, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.u
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MyCatalogueScreenKt.MyCatalogueScreen$lambda$14$0(catalogueViewModel, navHostController, state, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), false, navHostController, null, null, 0L, 0L, 0.0f, composer, 3078, 0, 2006);
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
    public static final k0 MyCatalogueScreen$lambda$14$0(final CatalogueViewModel catalogueViewModel, final NavHostController navHostController, State state, RowScope Z17TopBar, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(318201029, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreen.<anonymous>.<anonymous> (MyCatalogueScreen.kt:120)");
            }
            if (MyCatalogueScreen$lambda$1(state) != 0) {
                composer.startReplaceGroup(848514062);
                boolean zChangedInstance = composer.changedInstance(catalogueViewModel) | composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.d0
                        @Override // lb.a
                        public final Object invoke() {
                            return MyCatalogueScreenKt.MyCatalogueScreen$lambda$14$0$0$0(catalogueViewModel, navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, ComposableSingletons$MyCatalogueScreenKt.INSTANCE.getLambda$1085965804$app_productionPFast(), composer, 1572864, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(535155613);
                composer.endReplaceGroup();
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
    public static final k0 MyCatalogueScreen$lambda$14$0$0$0(CatalogueViewModel catalogueViewModel, NavHostController navHostController) {
        SendToParams sendToParams = new SendToParams(va.w.g(new Send(9, "https://todus.cu/catalogos/" + catalogueViewModel.owner().getToDusId())));
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = catalogueViewModel.getGson().t(sendToParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goForwardTo(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MyCatalogueScreen$lambda$15(final CatalogueViewModel catalogueViewModel, final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(147604385, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreen.<anonymous> (MyCatalogueScreen.kt:149)");
            }
            ComposableSingletons$MyCatalogueScreenKt composableSingletons$MyCatalogueScreenKt = ComposableSingletons$MyCatalogueScreenKt.INSTANCE;
            Function2 lambda$576592437$app_productionPFast = composableSingletons$MyCatalogueScreenKt.getLambda$576592437$app_productionPFast();
            Function2 lambda$752920694$app_productionPFast = composableSingletons$MyCatalogueScreenKt.getLambda$752920694$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(catalogueViewModel) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.j
                    @Override // lb.a
                    public final Object invoke() {
                        return MyCatalogueScreenKt.MyCatalogueScreen$lambda$15$0$0(catalogueViewModel, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            FloatingActionButtonKt.m3249ExtendedFloatingActionButtonElI57k(lambda$576592437$app_productionPFast, lambda$752920694$app_productionPFast, (lb.a) objRememberedValue, null, true, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, composer, 24630, 936);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$15$0$0(CatalogueViewModel catalogueViewModel, NavHostController navHostController) {
        String strT = catalogueViewModel.getGson().t(new CatalogueFormParams(null, 1, null));
        NavLinks navLinks = NavLinks.INSTANCE;
        kotlin.jvm.internal.y.f(strT);
        NavController.navigate$default((NavController) navHostController, navLinks.goCatalogueForm(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v0 java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final ua.k0 MyCatalogueScreen$lambda$16(androidx.paging.compose.LazyPagingItems r18, cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r19, final androidx.navigation.NavHostController r20, final androidx.compose.runtime.State r21, final androidx.compose.runtime.State r22, final androidx.compose.runtime.MutableState r23, androidx.compose.runtime.MutableIntState r24, final android.content.ClipboardManager r25, androidx.compose.ui.Modifier r26, androidx.compose.runtime.Composer r27, int r28) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreenKt.MyCatalogueScreen$lambda$16(androidx.paging.compose.LazyPagingItems, cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel, androidx.navigation.NavHostController, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableIntState, android.content.ClipboardManager, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):ua.k0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$10$0(MutableState mutableState) {
        mutableState.setValue(null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$11$0(CatalogueViewModel catalogueViewModel, MutableState mutableState, final MutableState mutableState2, final MutableIntState mutableIntState) {
        MyCatalogueScreen$lambda$16$6(mutableState2, true);
        Product product = (Product) mutableState.getValue();
        catalogueViewModel.deleteProduct(product != null ? product.getId() : -1, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.h
            @Override // lb.a
            public final Object invoke() {
                return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16$11$0$0(mutableIntState);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.i
            @Override // lb.a
            public final Object invoke() {
                return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16$11$0$1(mutableState2);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$11$0$0(MutableIntState mutableIntState) {
        int intValue = mutableIntState.getIntValue();
        mutableIntState.setIntValue(intValue + 1);
        mutableIntState.setIntValue(intValue);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$11$0$1(MutableState mutableState) {
        MyCatalogueScreen$lambda$16$6(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$12$0(MutableState mutableState) {
        mutableState.setValue("");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MyCatalogueScreen$lambda$16$13(MutableState mutableState, final ClipboardManager clipboardManager, final NavHostController navHostController, final CatalogueViewModel catalogueViewModel, final lb.a it, Composer composer, int i10) {
        int i11;
        final MutableState mutableState2;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-95036643, i11, -1, "cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreen.<anonymous>.<anonymous> (MyCatalogueScreen.kt:285)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(companion, null, false, 3, null);
            RoundedCornerShape roundedCornerShapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierWrapContentSize$default, materialTheme.getColorScheme(composer, i12).getBackground(), roundedCornerShapeM2015RoundedCornerShape0680j_4), Dp.m8823constructorimpl(10)), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            int i13 = i11;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, MyCatalogueScreen$lambda$16$2(mutableState), materialTheme.getTypography(composer, i12).getLabelLarge(), 0L, 0, 0, composer, 0, 57);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceAround(), companion2.getTop(), composer, 6);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean zChangedInstance = composer.changedInstance(clipboardManager) | ((i13 & 14) == 4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState;
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.m
                    @Override // lb.a
                    public final Object invoke() {
                        return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16$13$0$0$0$0(clipboardManager, it, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                mutableState2 = mutableState;
            }
            lb.a aVar = (lb.a) objRememberedValue;
            float f10 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10));
            ComposableSingletons$MyCatalogueScreenKt composableSingletons$MyCatalogueScreenKt = ComposableSingletons$MyCatalogueScreenKt.INSTANCE;
            IconButtonKt.IconButton(aVar, modifierM1725padding3ABfNKs, false, null, null, null, composableSingletons$MyCatalogueScreenKt.m9848getLambda$1166954603$app_productionPFast(), composer, 1572912, 60);
            boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(catalogueViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.n
                    @Override // lb.a
                    public final Object invoke() {
                        return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16$13$0$0$1$0(navHostController, catalogueViewModel, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), false, null, null, null, composableSingletons$MyCatalogueScreenKt.m9847getLambda$1033962100$app_productionPFast(), composer, 1572912, 60);
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
    public static final k0 MyCatalogueScreen$lambda$16$13$0$0$0$0(ClipboardManager clipboardManager, lb.a aVar, MutableState mutableState) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText("url", MyCatalogueScreen$lambda$16$2(mutableState)));
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$13$0$0$1$0(NavHostController navHostController, CatalogueViewModel catalogueViewModel, MutableState mutableState) {
        SendToParams sendToParams = new SendToParams(va.w.g(new Send(9, MyCatalogueScreen$lambda$16$2(mutableState))));
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = catalogueViewModel.getGson().t(sendToParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goForwardTo(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult MyCatalogueScreen$lambda$16$16$0(final CatalogueViewModel catalogueViewModel, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreenKt$MyCatalogueScreen$lambda$16$16$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                catalogueViewModel.clearTags();
            }
        };
    }

    private static final String MyCatalogueScreen$lambda$16$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean MyCatalogueScreen$lambda$16$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MyCatalogueScreen$lambda$16$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$7$0(CatalogueViewModel catalogueViewModel, MutableState mutableState, NavHostController navHostController, final MutableState mutableState2, final MutableState mutableState3, Product product, CatalogueAction catalogueAction) {
        kotlin.jvm.internal.y.i(product, "product");
        kotlin.jvm.internal.y.i(catalogueAction, "catalogueAction");
        int i10 = WhenMappings.$EnumSwitchMapping$0[catalogueAction.ordinal()];
        if (i10 == 1) {
            MyCatalogueScreen$lambda$16$6(mutableState2, true);
            catalogueViewModel.loadProductUrl(product.getId(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16$7$0$0(mutableState3, (String) obj);
                }
            }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.l
                @Override // lb.a
                public final Object invoke() {
                    return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16$7$0$1(mutableState2);
                }
            });
        } else if (i10 == 2) {
            mutableState.setValue(product);
        } else if (i10 == 3) {
            String strT = catalogueViewModel.getGson().t(new CatalogueFormParams(product));
            NavLinks navLinks = NavLinks.INSTANCE;
            kotlin.jvm.internal.y.f(strT);
            NavController.navigate$default((NavController) navHostController, navLinks.goCatalogueForm(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        } else {
            if (i10 != 4) {
                throw new ua.r();
            }
            String strT2 = catalogueViewModel.getGson().t(new ProductPreviewParams(catalogueViewModel.owner().getToDusId(), product.getId()));
            NavLinks navLinks2 = NavLinks.INSTANCE;
            kotlin.jvm.internal.y.f(strT2);
            NavController.navigate$default((NavController) navHostController, navLinks2.goProductPreview(strT2), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$7$0$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$7$0$1(MutableState mutableState) {
        MyCatalogueScreen$lambda$16$6(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$16$8$0(Product it) {
        kotlin.jvm.internal.y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MyCatalogueScreen$lambda$16$9(State state, final State state2, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1380894475, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreen.<anonymous>.<anonymous> (MyCatalogueScreen.kt:236)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f10 = 5;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), StringResources_androidKt.stringResource(R.string.public_products, composer, 0) + " (" + MyCatalogueScreen$lambda$1(state) + ")", MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0, 0, composer, 6, 56);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl((float) 10)), composer, 6);
            FlowLayoutKt.FlowRow(null, null, null, null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1322464208, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16$9$0$0(state2, mutableState, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572864, 63);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
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
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MyCatalogueScreen$lambda$16$9$0$0(State state, final MutableState mutableState, FlowRowScope FlowRow, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(FlowRow, "$this$FlowRow");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1322464208, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.MyCatalogueScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MyCatalogueScreen.kt:248)");
            }
            for (final String str : MyCatalogueScreen$lambda$2(state)) {
                boolean zD = kotlin.jvm.internal.y.d(MyCatalogueScreen$lambda$4(mutableState), str);
                boolean zChanged = composer.changed(str);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.myCatalogue.c0
                        @Override // lb.a
                        public final Object invoke() {
                            return MyCatalogueScreenKt.MyCatalogueScreen$lambda$16$9$0$0$0$0$0(str, mutableState);
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
    public static final k0 MyCatalogueScreen$lambda$16$9$0$0$0$0$0(String str, MutableState mutableState) {
        if (kotlin.jvm.internal.y.d(MyCatalogueScreen$lambda$4(mutableState), str)) {
            str = "";
        }
        mutableState.setValue(str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MyCatalogueScreen$lambda$17(NavHostController navHostController, CatalogueViewModel catalogueViewModel, int i10, int i11, Composer composer, int i12) {
        MyCatalogueScreen(navHostController, catalogueViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final List<String> MyCatalogueScreen$lambda$2(State<? extends List<String>> state) {
        return state.getValue();
    }

    private static final String MyCatalogueScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String MyCatalogueScreen$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MyCatalogueScreen$lambda$9$0(LazyPagingItems lazyPagingItems) {
        return lazyPagingItems.getItemCount() < 10;
    }
}
