package cu.todus.android.uiCompose.main.screen.catalogue.preview;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.location.Location;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.outlined.LocationOnKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
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
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.geo.CubaGeoDataSource;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel;
import cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormParams;
import cu.todus.android.uiCompose.main.screen.catalogue.list.ProductItemKt;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.map.MapViewKt;
import cu.todus.android.uiCompose.shared.modal.ModalKt;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.map.Z17MapMarker;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import cu.z17.views.zoomables.ZoomModifierKt;
import cu.z17.views.zoomables.ZoomStateKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import le.d0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0011²\u0006\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\nX\u008a\u0084\u0002²\u0006\u0014\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u000f\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0010\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;", "viewModel", "Lua/k0;", "ProductPreviewScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/data/db/entity/cache/Product;", "product", "", "interested", "", "isLoading", "url", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ProductPreviewScreenKt {

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
                iArr[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00df  */
    /* JADX WARN: Code duplicated, block: B:63:0x0120  */
    /* JADX WARN: Code duplicated, block: B:66:0x0136  */
    /* JADX WARN: Code duplicated, block: B:69:0x017f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ProductPreviewScreen(final NavHostController navHostController, final String params, CatalogueViewModel catalogueViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final CatalogueViewModel catalogueViewModel2;
        CatalogueViewModel catalogueViewModel3;
        Object objRememberedValue;
        Composer.Companion companion;
        Composer composer2;
        Object objRememberedValue2;
        Object objRememberedValue3;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(-843660307);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(params) ? 32 : 16;
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
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(CatalogueViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    i14 &= -897;
                    catalogueViewModel3 = (CatalogueViewModel) viewModel;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-843660307, i14, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewScreen (ProductPreviewScreen.kt:101)");
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (ProductPreviewParams) catalogueViewModel3.getGson().j(params, ProductPreviewParams.class);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ProductPreviewParams productPreviewParams = (ProductPreviewParams) objRememberedValue;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel3.getProduct(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel3.getInterested(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                composer2 = composerStartRestartGroup;
                final int i15 = ((Configuration) composer2.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
                final ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer2, 0, 1);
                objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer2);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                final m0 m0Var = (m0) objRememberedValue2;
                objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState = (MutableState) objRememberedValue3;
                final CatalogueViewModel catalogueViewModel4 = catalogueViewModel3;
                composerStartRestartGroup = composer2;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-859882183, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ProductPreviewScreenKt.ProductPreviewScreen$lambda$6(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(18972023, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.r
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7(catalogueViewModel4, stateCollectAsStateWithLifecycle, scrollStateRememberScrollState, i15, productPreviewParams, navHostController, m0Var, stateCollectAsStateWithLifecycle2, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composerStartRestartGroup, 805306806, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                catalogueViewModel2 = catalogueViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i14 &= -897;
                }
            }
            catalogueViewModel3 = catalogueViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843660307, i14, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewScreen (ProductPreviewScreen.kt:101)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (ProductPreviewParams) catalogueViewModel3.getGson().j(params, ProductPreviewParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ProductPreviewParams productPreviewParams2 = (ProductPreviewParams) objRememberedValue;
            final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel3.getProduct(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel3.getInterested(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            composer2 = composerStartRestartGroup;
            final int i16 = ((Configuration) composer2.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            final ScrollState scrollStateRememberScrollState2 = ScrollKt.rememberScrollState(0, composer2, 0, 1);
            objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer2);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final m0 m0Var2 = (m0) objRememberedValue2;
            objRememberedValue3 = composer2.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            final CatalogueViewModel catalogueViewModel5 = catalogueViewModel3;
            composerStartRestartGroup = composer2;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-859882183, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$6(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(18972023, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7(catalogueViewModel5, stateCollectAsStateWithLifecycle3, scrollStateRememberScrollState2, i16, productPreviewParams2, navHostController, m0Var2, stateCollectAsStateWithLifecycle4, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composerStartRestartGroup, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            catalogueViewModel2 = catalogueViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$8(navHostController, params, catalogueViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final FlowsState<Product> ProductPreviewScreen$lambda$1(State<FlowsState<Product>> state) {
        return state.getValue();
    }

    private static final FlowsState<Object> ProductPreviewScreen$lambda$2(State<? extends FlowsState<? extends Object>> state) {
        return state.getValue();
    }

    private static final boolean ProductPreviewScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ProductPreviewScreen$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ProductPreviewScreen$lambda$6(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-859882183, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewScreen.<anonymous> (ProductPreviewScreen.kt:126)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$ProductPreviewScreenKt.INSTANCE.getLambda$1442136908$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:87:0x057f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ProductPreviewScreen$lambda$7(CatalogueViewModel catalogueViewModel, final State state, ScrollState scrollState, final int i10, final ProductPreviewParams productPreviewParams, final NavHostController navHostController, final m0 m0Var, State state2, MutableState mutableState, Modifier it, Composer composer, int i11) {
        int i12;
        final CatalogueViewModel catalogueViewModel2;
        final MutableState mutableState2;
        String str;
        String str2;
        String strStringResource;
        String str3;
        String str4;
        String str5;
        ColorFilter.Companion companion;
        String str6;
        int i13;
        SnapshotMutationPolicy snapshotMutationPolicy;
        final MutableState mutableState3;
        int i14;
        boolean z10;
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer2.changed(it) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (composer2.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(18972023, i12, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewScreen.<anonymous> (ProductPreviewScreen.kt:137)");
            }
            Status status = ProductPreviewScreen$lambda$1(state).getStatus();
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i15 = iArr[status.ordinal()];
            if (i15 != 1) {
                if (i15 == 2) {
                    composer2.startReplaceGroup(-1740080994);
                    LoadingScreenKt.LoadingWall(composer2, 0);
                    composer2.endReplaceGroup();
                    k0 k0Var = k0.f43947a;
                } else if (i15 != 3) {
                    composer2.startReplaceGroup(-1715525925);
                    composer2.endReplaceGroup();
                    k0 k0Var2 = k0.f43947a;
                } else {
                    composer2.startReplaceGroup(-1739992396);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(it, 0.0f, 1, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    lb.a constructor = companion2.getConstructor();
                    if (!defpackage.r.a(composer2.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.cannot_load_product_online_info, composer2, 0), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer2, 6, 56);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                    k0 k0Var3 = k0.f43947a;
                }
                catalogueViewModel2 = catalogueViewModel;
                mutableState2 = mutableState;
            } else {
                composer2.startReplaceGroup(-1738729487);
                if (ProductPreviewScreen$lambda$1(state).getData() != null) {
                    composer2.startReplaceGroup(-1738687637);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    Alignment.Companion companion4 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                    int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion3);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                    lb.a constructor2 = companion5.getConstructor();
                    if (!defpackage.r.a(composer2.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, composer2, 6, 14);
                    Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), scrollState, false, null, false, 14, null);
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i16 = MaterialTheme.$stable;
                    Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierVerticalScroll$default, materialTheme.getColorScheme(composer2, i16).getBackground(), null, 2, null);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composer2, 0);
                    int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default);
                    lb.a constructor3 = companion5.getConstructor();
                    if (!defpackage.r.a(composer2.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Modifier modifierZoom$default = ZoomModifierKt.zoom$default(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(i10 / 2)), (Object) null, ZoomStateKt.rememberZoomState(0.0f, 0.0f, 0.0f, 0.0f, false, false, false, true, (Object) null, composer, 14155776, 319), true, 1, (Object) null);
                    Product data = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data);
                    String pictureUrl = data.getPictureUrl();
                    ContentScale crop = ContentScale.INSTANCE.getCrop();
                    ColorGenerator material = ColorGenerator.INSTANCE.getMATERIAL();
                    Product data2 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data2);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierZoom$default, pictureUrl, Color.m5856boximpl(ColorKt.Color(material.getColor(data2.getName()))), null, crop, null, 0, null, null, composer, 24576, 488);
                    float f10 = 0;
                    float f11 = 20;
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(ClipKt.clip(OffsetKt.m1684offsetVpY3zN4(IntrinsicKt.height(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), IntrinsicSize.Max), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(-Dp.m8823constructorimpl(f11))), RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10))), materialTheme.getColorScheme(composer, i16).getBackground(), null, 2, null), Dp.m8823constructorimpl(f11));
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composer, 0);
                    int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
                    lb.a constructor4 = companion5.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
                    Product data3 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data3);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, data3.getName(), materialTheme.getTypography(composer, i16).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), composer, 6);
                    Modifier modifierHorizontalScroll$default = ScrollKt.horizontalScroll$default(companion3, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getCenterVertically(), composer, 48);
                    int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierHorizontalScroll$default);
                    lb.a constructor5 = companion5.getConstructor();
                    if (!defpackage.r.a(composer.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor5);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composer);
                    Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion5.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    float f12 = 24;
                    float f13 = 3;
                    Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(f12)), 0.0f, 0.0f, Dp.m8823constructorimpl(f13), 0.0f, 11, null);
                    Integer numValueOf = Integer.valueOf(R.drawable.state_icon);
                    ColorFilter.Companion companion6 = ColorFilter.INSTANCE;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1729paddingqDBjuR0$default, numValueOf, null, ColorFilter.Companion.m5907tintxETnrds$default(companion6, materialTheme.getColorScheme(composer, i16).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    Composer composer3 = composer;
                    Product data4 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data4);
                    Map<String, String> info = data4.getInfo();
                    if (info == null || (str = info.get("state")) == null) {
                        str = "new";
                    }
                    switch (str) {
                        case "bad":
                            composer3.startReplaceGroup(-1261166315);
                            strStringResource = StringResources_androidKt.stringResource(R.string.bad_state, composer3, 0);
                            composer3.endReplaceGroup();
                            str2 = strStringResource;
                            break;
                        case "new":
                            composer3.startReplaceGroup(-1261366699);
                            strStringResource = StringResources_androidKt.stringResource(R.string.new_state, composer3, 0);
                            composer3.endReplaceGroup();
                            str2 = strStringResource;
                            break;
                        case "ref":
                            composer3.startReplaceGroup(-1260958119);
                            strStringResource = StringResources_androidKt.stringResource(R.string.fixed, composer3, 0);
                            composer3.endReplaceGroup();
                            str2 = strStringResource;
                            break;
                        case "good":
                            composer3.startReplaceGroup(-1260760556);
                            strStringResource = StringResources_androidKt.stringResource(R.string.good_state, composer3, 0);
                            composer3.endReplaceGroup();
                            str2 = strStringResource;
                            break;
                        default:
                            composer3.startReplaceGroup(-1260573254);
                            composer3.endReplaceGroup();
                            str2 = "";
                            break;
                    }
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, str2, materialTheme.getTypography(composer3, i16).getBodyMedium(), 0L, 0, 0, composer3, 0, 57);
                    float f14 = 10;
                    SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(f14)), composer3, 6);
                    float f15 = 1;
                    DividerKt.m3177HorizontalDivider9IZ8Weo(SizeKt.m1774width3ABfNKs(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), Dp.m8823constructorimpl(f15)), 0.0f, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer3, i16).getOnBackground(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), composer3, 6, 2);
                    SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(f14)), composer3, 6);
                    CubaGeoDataSource cubaGeoDataSource = catalogueViewModel.getCubaGeoDataSource();
                    Product data5 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data5);
                    Map<String, String> info2 = data5.getInfo();
                    if (info2 == null || (str3 = info2.get(Product.EXTRA_PROVINCE)) == null) {
                        str3 = "";
                    }
                    Product data6 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data6);
                    Map<String, String> info3 = data6.getInfo();
                    if (info3 == null || (str4 = info3.get(Product.EXTRA_MUNICIPALITY)) == null) {
                        str4 = "";
                    }
                    String municipalityNameById = cubaGeoDataSource.getMunicipalityNameById(str3, str4);
                    CubaGeoDataSource cubaGeoDataSource2 = catalogueViewModel.getCubaGeoDataSource();
                    Product data7 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data7);
                    Map<String, String> info4 = data7.getInfo();
                    if (info4 == null || (str5 = info4.get(Product.EXTRA_PROVINCE)) == null) {
                        str5 = "";
                    }
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, municipalityNameById + ", " + cubaGeoDataSource2.getProvinceNameById(str5), materialTheme.getTypography(composer3, i16).getBodyMedium(), 0L, 0, 0, composer3, 0, 57);
                    Product data8 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data8);
                    Map<String, String> info5 = data8.getInfo();
                    String str7 = info5 != null ? info5.get("location") : null;
                    if (str7 == null) {
                        composer3.startReplaceGroup(-1258588046);
                        composer3.endReplaceGroup();
                        companion = companion6;
                    } else {
                        composer3.startReplaceGroup(-1258588045);
                        if (d0.q0((CharSequence) d0.S0(str7, new String[]{","}, false, 0, 6, null).get(0)) || kotlin.jvm.internal.y.d(d0.S0(str7, new String[]{","}, false, 0, 6, null).get(0), "0")) {
                            companion = companion6;
                            composer3.startReplaceGroup(1514380862);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(1512518444);
                            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(f14)), composer3, 6);
                            DividerKt.m3177HorizontalDivider9IZ8Weo(SizeKt.m1774width3ABfNKs(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), Dp.m8823constructorimpl(f15)), 0.0f, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer3, i16).getOnBackground(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), composer3, 6, 2);
                            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(f14)), composer3, 6);
                            Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(f12)), 0.0f, 0.0f, Dp.m8823constructorimpl(f13), 0.0f, 11, null);
                            boolean zChangedInstance = composer3.changedInstance(m0Var) | composer3.changedInstance(modalBottomSheetStateRememberModalBottomSheetState);
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.n
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$0$0$0$0(m0Var, modalBottomSheetStateRememberModalBottomSheetState);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            companion = companion6;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(ClickableKt.m1240clickableoSLSa3U$default(modifierM1729paddingqDBjuR0$default2, false, null, null, null, (lb.a) objRememberedValue, 15, null), LocationOnKt.getLocationOn(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(companion6, materialTheme.getColorScheme(composer3, i16).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                            composer3 = composer;
                            boolean zChangedInstance2 = composer3.changedInstance(m0Var) | composer3.changedInstance(modalBottomSheetStateRememberModalBottomSheetState);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.o
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$0$0$1$0(m0Var, modalBottomSheetStateRememberModalBottomSheetState);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            Z17LabelKt.m10262Z17LabelfWhpE4E(ClickableKt.m1240clickableoSLSa3U$default(companion3, false, null, null, null, (lb.a) objRememberedValue2, 15, null), StringResources_androidKt.stringResource(R.string.map, composer3, 0), materialTheme.getTypography(composer3, i16).getBodyMedium(), 0L, 0, 0, composer3, 0, 56);
                            composer3.endReplaceGroup();
                        }
                        k0 k0Var4 = k0.f43947a;
                        composer3.endReplaceGroup();
                    }
                    composer3.endNode();
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f14)), composer3, 6);
                    Product data9 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data9);
                    double price = data9.getPrice();
                    Product data10 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data10);
                    Map<String, String> info6 = data10.getInfo();
                    if (info6 == null || (str6 = info6.get(Product.EXTRA_COIN_TYPE)) == null) {
                        str6 = Product.COIN_CUP;
                    }
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, price + " " + str6, materialTheme.getTypography(composer3, i16).getTitleSmall(), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer3, i16).getOnBackground(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), 0, 0, composer3, 0, 49);
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), composer3, 6);
                    Product data11 = ProductPreviewScreen$lambda$1(state).getData();
                    kotlin.jvm.internal.y.f(data11);
                    if (d0.q0(data11.getDescription())) {
                        composer3.startReplaceGroup(-1527576712);
                    } else {
                        composer3.startReplaceGroup(-1988940651);
                        Product data12 = ProductPreviewScreen$lambda$1(state).getData();
                        kotlin.jvm.internal.y.f(data12);
                        Z17LabelKt.m10262Z17LabelfWhpE4E(null, data12.getDescription(), null, 0L, 0, 0, composer3, 0, 61);
                    }
                    composer3.endReplaceGroup();
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), composer3, 6);
                    FlowLayoutKt.FlowRow(null, null, null, null, 0, 0, ComposableLambdaKt.rememberComposableLambda(577923013, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.p
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$1(state, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer3, 54), composer3, 1572864, 63);
                    if (kotlin.jvm.internal.y.d(productPreviewParams.getToDusId(), catalogueViewModel.owner().getToDusId())) {
                        catalogueViewModel2 = catalogueViewModel;
                        composer3.startReplaceGroup(-1524838079);
                        Object objRememberedValue3 = composer3.rememberedValue();
                        Composer.Companion companion7 = Composer.INSTANCE;
                        if (objRememberedValue3 == companion7.getEmpty()) {
                            i13 = 2;
                            snapshotMutationPolicy = null;
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                            composer3.updateRememberedValue(objRememberedValue3);
                        } else {
                            i13 = 2;
                            snapshotMutationPolicy = null;
                        }
                        final MutableState mutableState4 = (MutableState) objRememberedValue3;
                        Object objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == companion7.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(snapshotMutationPolicy, snapshotMutationPolicy, i13, snapshotMutationPolicy);
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        final MutableState mutableState5 = (MutableState) objRememberedValue4;
                        Context context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        Object objRememberedValue5 = composer3.rememberedValue();
                        if (objRememberedValue5 == companion7.getEmpty()) {
                            Object systemService = context.getSystemService("clipboard");
                            kotlin.jvm.internal.y.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                            objRememberedValue5 = (ClipboardManager) systemService;
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        final ClipboardManager clipboardManager = (ClipboardManager) objRememberedValue5;
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getSpaceAround(), companion4.getCenterVertically(), composer3, 54);
                        int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                        lb.a constructor6 = companion5.getConstructor();
                        if (!defpackage.r.a(composer3.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor6);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composer3);
                        Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyRowMeasurePolicy2, companion5.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion5.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion5.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion5.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion5.getSetModifier());
                        boolean zChangedInstance3 = composer3.changedInstance(catalogueViewModel2);
                        Object objRememberedValue6 = composer3.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue6 == companion7.getEmpty()) {
                            mutableState2 = mutableState;
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.z
                                @Override // lb.a
                                public final Object invoke() {
                                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$10$0$0(catalogueViewModel2, productPreviewParams, mutableState2, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue6);
                        } else {
                            mutableState2 = mutableState;
                        }
                        ComposableSingletons$ProductPreviewScreenKt composableSingletons$ProductPreviewScreenKt = ComposableSingletons$ProductPreviewScreenKt.INSTANCE;
                        IconButtonKt.IconButton((lb.a) objRememberedValue6, null, false, null, null, null, composableSingletons$ProductPreviewScreenKt.m9850getLambda$1850927923$app_productionPFast(), composer3, 1572864, 62);
                        boolean zChangedInstance4 = composer3.changedInstance(catalogueViewModel2) | composer3.changed(state) | composer3.changedInstance(navHostController);
                        Object objRememberedValue7 = composer3.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue7 == companion7.getEmpty()) {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.a0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$10$1$0(catalogueViewModel2, navHostController, state);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue7);
                        }
                        IconButtonKt.IconButton((lb.a) objRememberedValue7, null, false, null, null, null, composableSingletons$ProductPreviewScreenKt.m9851getLambda$815352458$app_productionPFast(), composer3, 1572864, 62);
                        boolean zChanged = composer3.changed(state);
                        Object objRememberedValue8 = composer3.rememberedValue();
                        if (zChanged || objRememberedValue8 == companion7.getEmpty()) {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$10$2$0(mutableState5, state);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue8);
                        }
                        IconButtonKt.IconButton((lb.a) objRememberedValue8, null, false, null, null, null, composableSingletons$ProductPreviewScreenKt.getLambda$556130773$app_productionPFast(), composer3, 1572864, 62);
                        composer3.endNode();
                        boolean z11 = mutableState5.getValue() != null;
                        Object objRememberedValue9 = composer3.rememberedValue();
                        if (objRememberedValue9 == companion7.getEmpty()) {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.i
                                @Override // lb.a
                                public final Object invoke() {
                                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$11$0(mutableState5);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue9);
                        }
                        lb.a aVar = (lb.a) objRememberedValue9;
                        boolean zChangedInstance5 = composer3.changedInstance(catalogueViewModel2) | composer3.changedInstance(navHostController);
                        Object objRememberedValue10 = composer3.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue10 == companion7.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.j
                                @Override // lb.a
                                public final Object invoke() {
                                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$12$0(catalogueViewModel2, mutableState5, mutableState2, navHostController);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue10);
                        }
                        Z17DialogsKt.Z17DialogWithActions(z11, aVar, (lb.a) objRememberedValue10, null, StringResources_androidKt.stringResource(R.string.delete_product, composer3, 0), StringResources_androidKt.stringResource(R.string.u_wish_to_delete_product, composer3, 0), null, null, composer, 48, 200);
                        composer2 = composer;
                        boolean z12 = !d0.q0(ProductPreviewScreen$lambda$7$1$0$0$6(mutableState4));
                        Object objRememberedValue11 = composer2.rememberedValue();
                        if (objRememberedValue11 == companion7.getEmpty()) {
                            mutableState3 = mutableState4;
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$13$0(mutableState3);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        } else {
                            mutableState3 = mutableState4;
                        }
                        Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.l
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$14(mutableState3, clipboardManager, navHostController, catalogueViewModel2, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        };
                        i14 = 54;
                        z10 = true;
                        Z17DialogsKt.Z17CustomDialog(z12, (lb.a) objRememberedValue11, ComposableLambdaKt.rememberComposableLambda(-1287748607, true, function3, composer2, 54), composer2, 432);
                        composer2.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-1527065739);
                        int i17 = iArr[ProductPreviewScreen$lambda$2(state2).getStatus().ordinal()];
                        if (i17 == 1) {
                            Composer composer4 = composer3;
                            composer4.startReplaceGroup(-1527018278);
                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
                            int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                            CompositionLocalMap currentCompositionLocalMap7 = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default2);
                            lb.a constructor7 = companion5.getConstructor();
                            if (!defpackage.r.a(composer4.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor7);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composer4);
                            Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy3, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion5.getSetModifier());
                            catalogueViewModel2 = catalogueViewModel;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(40)), CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(companion, materialTheme.getColorScheme(composer4, i16).getPrimary(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                            composer2 = composer;
                            composer2.endNode();
                            composer2.endReplaceGroup();
                            k0 k0Var5 = k0.f43947a;
                        } else if (i17 != 2) {
                            composer3.startReplaceGroup(-1525691106);
                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.im_interested, composer3, 0);
                            catalogueViewModel2 = catalogueViewModel;
                            boolean zChangedInstance6 = composer3.changedInstance(catalogueViewModel2);
                            Object objRememberedValue12 = composer3.rememberedValue();
                            if (zChangedInstance6 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.y
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$4$0(catalogueViewModel2, productPreviewParams);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue12);
                            }
                            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue12, strStringResource2, null, true, false, composer, 24576, 41);
                            composer2 = composer;
                            composer2.endReplaceGroup();
                            k0 k0Var6 = k0.f43947a;
                        } else {
                            catalogueViewModel2 = catalogueViewModel;
                            composer3.startReplaceGroup(-1526209426);
                            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
                            int iA8 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap8 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default3);
                            lb.a constructor8 = companion5.getConstructor();
                            if (!defpackage.r.a(composer3.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor8);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composer3);
                            Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion5.getSetModifier());
                            Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composer, 0, 15);
                            composer.endNode();
                            composer.endReplaceGroup();
                            k0 k0Var7 = k0.f43947a;
                            composer2 = composer;
                        }
                        composer2.endReplaceGroup();
                        mutableState2 = mutableState;
                        i14 = 54;
                        z10 = true;
                    }
                    composer2.endNode();
                    composer2.endNode();
                    ModalKt.Modal(modalBottomSheetStateRememberModalBottomSheetState, ComposableLambdaKt.rememberComposableLambda(1934954485, z10, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$1(i10, state, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, i14), composer2, ModalBottomSheetState.$stable | 48);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                } else {
                    catalogueViewModel2 = catalogueViewModel;
                    mutableState2 = mutableState;
                    composer2.startReplaceGroup(-1715562133);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
                k0 k0Var8 = k0.f43947a;
            }
            if (ProductPreviewScreen$lambda$4(mutableState2)) {
                composer2.startReplaceGroup(1053041124);
                LoadingScreenKt.LoadingWall(composer2, 0);
            } else {
                composer2.startReplaceGroup(-1715451029);
            }
            composer2.endReplaceGroup();
            k0 k0Var9 = k0.f43947a;
            boolean zChangedInstance7 = composer2.changedInstance(catalogueViewModel2);
            Object objRememberedValue13 = composer2.rememberedValue();
            if (zChangedInstance7 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue13 = new ProductPreviewScreenKt$ProductPreviewScreen$2$3$1(catalogueViewModel2, productPreviewParams, null);
                composer2.updateRememberedValue(objRememberedValue13);
            }
            EffectsKt.LaunchedEffect(k0Var9, (Function2) objRememberedValue13, composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$0$0$0$0(m0 m0Var, ModalBottomSheetState modalBottomSheetState) {
        pe.k.d(m0Var, null, null, new ProductPreviewScreenKt$ProductPreviewScreen$2$2$1$1$1$1$1$1$1(modalBottomSheetState, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$0$0$1$0(m0 m0Var, ModalBottomSheetState modalBottomSheetState) {
        pe.k.d(m0Var, null, null, new ProductPreviewScreenKt$ProductPreviewScreen$2$2$1$1$1$1$2$1$1(modalBottomSheetState, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$1(State state, FlowRowScope FlowRow, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(FlowRow, "$this$FlowRow");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(577923013, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductPreviewScreen.kt:329)");
            }
            Product data = ProductPreviewScreen$lambda$1(state).getData();
            kotlin.jvm.internal.y.f(data);
            Iterator<T> it = data.getTags().iterator();
            while (it.hasNext()) {
                ProductItemKt.ProductTagItem(null, (String) it.next(), false, null, composer, 0, 13);
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
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$10$0$0(CatalogueViewModel catalogueViewModel, ProductPreviewParams productPreviewParams, final MutableState mutableState, final MutableState mutableState2) {
        ProductPreviewScreen$lambda$5(mutableState, true);
        catalogueViewModel.loadProductUrl(productPreviewParams.getProductId(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$10$0$0$0(mutableState2, (String) obj);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.s
            @Override // lb.a
            public final Object invoke() {
                return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$10$0$0$1(mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$10$0$0$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$10$0$0$1(MutableState mutableState) {
        ProductPreviewScreen$lambda$5(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$10$1$0(CatalogueViewModel catalogueViewModel, NavHostController navHostController, State state) {
        v5.f gson = catalogueViewModel.getGson();
        Product data = ProductPreviewScreen$lambda$1(state).getData();
        kotlin.jvm.internal.y.f(data);
        String strT = gson.t(new CatalogueFormParams(data));
        NavLinks navLinks = NavLinks.INSTANCE;
        kotlin.jvm.internal.y.f(strT);
        NavController.navigate$default((NavController) navHostController, navLinks.goCatalogueForm(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$10$2$0(MutableState mutableState, State state) {
        Product data = ProductPreviewScreen$lambda$1(state).getData();
        kotlin.jvm.internal.y.f(data);
        mutableState.setValue(data);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$11$0(MutableState mutableState) {
        mutableState.setValue(null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$12$0(CatalogueViewModel catalogueViewModel, MutableState mutableState, final MutableState mutableState2, final NavHostController navHostController) {
        ProductPreviewScreen$lambda$5(mutableState2, true);
        Product product = (Product) mutableState.getValue();
        catalogueViewModel.deleteProduct(product != null ? product.getId() : -1, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.w
            @Override // lb.a
            public final Object invoke() {
                return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$12$0$0(navHostController);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.x
            @Override // lb.a
            public final Object invoke() {
                return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$12$0$1(mutableState2);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$12$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$12$0$1(MutableState mutableState) {
        ProductPreviewScreen$lambda$5(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$13$0(MutableState mutableState) {
        mutableState.setValue("");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$14(MutableState mutableState, final ClipboardManager clipboardManager, final NavHostController navHostController, final CatalogueViewModel catalogueViewModel, final lb.a it, Composer composer, int i10) {
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
                ComposerKt.traceEventStart(-1287748607, i11, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductPreviewScreen.kt:466)");
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
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, ProductPreviewScreen$lambda$7$1$0$0$6(mutableState), materialTheme.getTypography(composer, i12).getLabelLarge(), 0L, 0, 0, composer, 0, 57);
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
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.u
                    @Override // lb.a
                    public final Object invoke() {
                        return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$14$0$0$0$0(clipboardManager, it, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                mutableState2 = mutableState;
            }
            lb.a aVar = (lb.a) objRememberedValue;
            float f10 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10));
            ComposableSingletons$ProductPreviewScreenKt composableSingletons$ProductPreviewScreenKt = ComposableSingletons$ProductPreviewScreenKt.INSTANCE;
            IconButtonKt.IconButton(aVar, modifierM1725padding3ABfNKs, false, null, null, null, composableSingletons$ProductPreviewScreenKt.getLambda$223641225$app_productionPFast(), composer, 1572912, 60);
            boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(catalogueViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.preview.v
                    @Override // lb.a
                    public final Object invoke() {
                        return ProductPreviewScreenKt.ProductPreviewScreen$lambda$7$1$0$0$14$0$0$1$0(navHostController, catalogueViewModel, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), false, null, null, null, composableSingletons$ProductPreviewScreenKt.getLambda$1092458354$app_productionPFast(), composer, 1572912, 60);
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
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$14$0$0$0$0(ClipboardManager clipboardManager, lb.a aVar, MutableState mutableState) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText("url", ProductPreviewScreen$lambda$7$1$0$0$6(mutableState)));
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$14$0$0$1$0(NavHostController navHostController, CatalogueViewModel catalogueViewModel, MutableState mutableState) {
        SendToParams sendToParams = new SendToParams(va.w.g(new Send(9, ProductPreviewScreen$lambda$7$1$0$0$6(mutableState))));
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = catalogueViewModel.getGson().t(sendToParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goForwardTo(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPreviewScreen$lambda$7$1$0$0$4$0(CatalogueViewModel catalogueViewModel, ProductPreviewParams productPreviewParams) {
        catalogueViewModel.imInterestedIn(productPreviewParams.getProductId());
        return k0.f43947a;
    }

    private static final String ProductPreviewScreen$lambda$7$1$0$0$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ProductPreviewScreen$lambda$7$1$1(int i10, State state, Composer composer, int i11) {
        String str;
        List listS0;
        String str2;
        Double dS;
        String str3;
        List listS1;
        String str4;
        Double dS2;
        String str5;
        List listS2;
        String str6;
        Double dS3;
        String str7;
        List listS3;
        String str8;
        Double dS4;
        if (composer.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1934954485, i11, -1, "cu.todus.android.uiCompose.main.screen.catalogue.preview.ProductPreviewScreen.<anonymous>.<anonymous>.<anonymous> (ProductPreviewScreen.kt:534)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(i10 / 2));
            Product data = ProductPreviewScreen$lambda$1(state).getData();
            kotlin.jvm.internal.y.f(data);
            String strValueOf = String.valueOf(data.getId());
            Product data2 = ProductPreviewScreen$lambda$1(state).getData();
            kotlin.jvm.internal.y.f(data2);
            Map<String, String> info = data2.getInfo();
            double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
            double dDoubleValue2 = (info == null || (str7 = info.get("location")) == null || (listS3 = d0.S0(str7, new String[]{","}, false, 0, 6, null)) == null || (str8 = (String) listS3.get(0)) == null || (dS4 = le.y.s(str8)) == null) ? 0.0d : dS4.doubleValue();
            Product data3 = ProductPreviewScreen$lambda$1(state).getData();
            kotlin.jvm.internal.y.f(data3);
            Map<String, String> info2 = data3.getInfo();
            double dDoubleValue3 = (info2 == null || (str5 = info2.get("location")) == null || (listS2 = d0.S0(str5, new String[]{","}, false, 0, 6, null)) == null || (str6 = (String) listS2.get(1)) == null || (dS3 = le.y.s(str6)) == null) ? 0.0d : dS3.doubleValue();
            Location location = new Location("");
            Product data4 = ProductPreviewScreen$lambda$1(state).getData();
            kotlin.jvm.internal.y.f(data4);
            Map<String, String> info3 = data4.getInfo();
            location.setLatitude((info3 == null || (str3 = info3.get("location")) == null || (listS1 = d0.S0(str3, new String[]{","}, false, 0, 6, null)) == null || (str4 = (String) listS1.get(0)) == null || (dS2 = le.y.s(str4)) == null) ? 0.0d : dS2.doubleValue());
            Product data5 = ProductPreviewScreen$lambda$1(state).getData();
            kotlin.jvm.internal.y.f(data5);
            Map<String, String> info4 = data5.getInfo();
            if (info4 != null && (str = info4.get("location")) != null && (listS0 = d0.S0(str, new String[]{","}, false, 0, 6, null)) != null && (str2 = (String) listS0.get(1)) != null && (dS = le.y.s(str2)) != null) {
                dDoubleValue = dS.doubleValue();
            }
            location.setLongitude(dDoubleValue);
            k0 k0Var = k0.f43947a;
            MapViewKt.MapView(modifierM1755height3ABfNKs, va.w.g(new Z17MapMarker(strValueOf, dDoubleValue2, dDoubleValue3, 11.0d, location, null, cu.z17.views.R.drawable.shop_location_pointer, 32, null)), composer, 0, 0);
            ModalKt.ModalIndicator(composer, 0);
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
    public static final k0 ProductPreviewScreen$lambda$8(NavHostController navHostController, String str, CatalogueViewModel catalogueViewModel, int i10, int i11, Composer composer, int i12) {
        ProductPreviewScreen(navHostController, str, catalogueViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
