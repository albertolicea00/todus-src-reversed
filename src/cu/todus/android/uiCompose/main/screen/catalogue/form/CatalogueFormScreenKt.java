package cu.todus.android.uiCompose.main.screen.catalogue.form;

import android.location.Location;
import android.net.Uri;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CameraAltKt;
import androidx.compose.material.icons.outlined.CheckCircleKt;
import androidx.compose.material.icons.outlined.RadioButtonUncheckedKt;
import androidx.compose.material.icons.outlined.VisibilityKt;
import androidx.compose.material.icons.outlined.VisibilityOffKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
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
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.geo.CubaGeoDataSource;
import cu.todus.android.data.geo.Province;
import cu.todus.android.location.LocationDataSource;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel;
import cu.todus.android.uiCompose.main.screen.catalogue.list.ProductItemKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.camera.CameraKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.spinner.Z17SpinnerKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u001c²\u0006\u000e\u0010\u000f\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0010\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0011\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0013\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0014\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0016\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u0012\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;", "viewModel", "Lua/k0;", "CatalogueFormScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;Landroidx/compose/runtime/Composer;II)V", "selected", "Lkotlin/Function1;", "onSelected", "StateSelector", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "", "openCamera", "name", "price", "description", "isPublic", "isLoading", "stateSelected", "coinTypeSelected", "", "productTags", "Ll0/j;", "emptyAnimation", "newTagTitle", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CatalogueFormScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CatalogueFormScreen(final NavHostController navHostController, final String params, CatalogueViewModel catalogueViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        CatalogueViewModel catalogueViewModel2;
        final CatalogueViewModel catalogueViewModel3;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1920226959);
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
                ComposerKt.traceEventStart(-1920226959, i14, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormScreen (CatalogueFormScreen.kt:86)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (CatalogueFormParams) catalogueViewModel3.getGson().j(params, CatalogueFormParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CatalogueFormParams catalogueFormParams = (CatalogueFormParams) objRememberedValue;
            final c1.a aVarC = c1.d.c(va.w.g("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), null, composerStartRestartGroup, 0, 2);
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1704431781, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$1(navHostController, catalogueFormParams, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-247357017, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.u
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2(catalogueViewModel3, navHostController, catalogueFormParams, aVarC, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$3(navHostController, params, catalogueViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CatalogueFormScreen$lambda$1(NavHostController navHostController, final CatalogueFormParams catalogueFormParams, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1704431781, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormScreen.<anonymous> (CatalogueFormScreen.kt:104)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(1069861554, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$1$0(catalogueFormParams, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CatalogueFormScreen$lambda$1$0(CatalogueFormParams catalogueFormParams, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1069861554, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormScreen.<anonymous>.<anonymous> (CatalogueFormScreen.kt:107)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(catalogueFormParams.getProduct() == null ? R.string.add_product : R.string.edit_product, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:140:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:142:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:146:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:149:0x043d  */
    /* JADX WARN: Code duplicated, block: B:154:0x049d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CatalogueFormScreen$lambda$2(final CatalogueViewModel catalogueViewModel, final NavHostController navHostController, final CatalogueFormParams catalogueFormParams, final c1.a aVar, Modifier it, Composer composer, int i10) {
        int i11;
        Modifier.Companion companion;
        ColumnScopeInstance columnScopeInstance;
        Object objRememberedValue;
        MutableState mutableState;
        Composer composer2;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final MutableState mutableState4;
        final MutableState mutableState5;
        final MutableState mutableState6;
        MaterialTheme materialTheme;
        int i12;
        final CatalogueViewModel catalogueViewModel2;
        Modifier.Companion companion2;
        final MutableIntState mutableIntState;
        final MutableIntState mutableIntState2;
        final MutableIntState mutableIntState3;
        final MutableState mutableState7;
        Composer composer3;
        final MutableState mutableState8;
        MutableState mutableState9;
        final MutableState mutableState10;
        Composer composer4;
        Object obj;
        Object value;
        Object objRememberedValue2;
        Object value2;
        String str;
        Product product;
        Map<String, String> info;
        String str2;
        Product product2;
        Map<String, String> info2;
        String str3;
        String str4;
        Map<String, String> info3;
        Map<String, String> info4;
        String str5;
        Map<String, String> info5;
        String description;
        String strValueOf;
        String name;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-247357017, i11, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormScreen.<anonymous> (CatalogueFormScreen.kt:115)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(it, 0.0f, 1, null));
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierImePadding);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue3 = composer.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue3 == companion5.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState11 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion5.getEmpty()) {
                Product product3 = catalogueFormParams.getProduct();
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(product3 != null ? product3.getPictureUrl() : null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState12 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion5.getEmpty()) {
                Product product4 = catalogueFormParams.getProduct();
                if (product4 == null || (name = product4.getName()) == null) {
                    name = "";
                }
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(name, null, 2, null);
                composer.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState13 = (MutableState) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion5.getEmpty()) {
                Product product5 = catalogueFormParams.getProduct();
                if (product5 == null || (strValueOf = String.valueOf(product5.getPrice())) == null) {
                    strValueOf = "";
                }
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(strValueOf, null, 2, null);
                composer.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState14 = (MutableState) objRememberedValue6;
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion5.getEmpty()) {
                Product product6 = catalogueFormParams.getProduct();
                if (product6 == null || (description = product6.getDescription()) == null) {
                    description = "";
                }
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(description, null, 2, null);
                composer.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState15 = (MutableState) objRememberedValue7;
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == companion5.getEmpty()) {
                CubaGeoDataSource cubaGeoDataSource = catalogueViewModel.getCubaGeoDataSource();
                Product product7 = catalogueFormParams.getProduct();
                if (product7 == null || (info5 = product7.getInfo()) == null || (str5 = info5.get(Product.EXTRA_PROVINCE)) == null) {
                    str5 = "1";
                }
                objRememberedValue8 = SnapshotIntStateKt.mutableIntStateOf(cubaGeoDataSource.getPositionById(str5));
                composer.updateRememberedValue(objRememberedValue8);
            }
            MutableIntState mutableIntState4 = (MutableIntState) objRememberedValue8;
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == companion5.getEmpty()) {
                CubaGeoDataSource cubaGeoDataSource2 = catalogueViewModel.getCubaGeoDataSource();
                Product product8 = catalogueFormParams.getProduct();
                if (product8 == null || (info4 = product8.getInfo()) == null || (str3 = info4.get(Product.EXTRA_PROVINCE)) == null) {
                    str3 = "1";
                }
                Product product9 = catalogueFormParams.getProduct();
                if (product9 == null || (info3 = product9.getInfo()) == null || (str4 = info3.get(Product.EXTRA_MUNICIPALITY)) == null) {
                    str4 = "";
                }
                objRememberedValue9 = SnapshotIntStateKt.mutableIntStateOf(cubaGeoDataSource2.getPositionOfMunicipalityById(str3, str4));
                composer.updateRememberedValue(objRememberedValue9);
            }
            MutableIntState mutableIntState5 = (MutableIntState) objRememberedValue9;
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == companion5.getEmpty()) {
                objRememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue10);
            }
            MutableState mutableState16 = (MutableState) objRememberedValue10;
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == companion5.getEmpty()) {
                Product product10 = catalogueFormParams.getProduct();
                objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(product10 != null ? product10.isPublic() : false), null, 2, null);
                composer.updateRememberedValue(objRememberedValue11);
            }
            MutableState mutableState17 = (MutableState) objRememberedValue11;
            Object objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == companion5.getEmpty()) {
                objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue12);
            }
            final MutableState mutableState18 = (MutableState) objRememberedValue12;
            Object objRememberedValue13 = composer.rememberedValue();
            if (objRememberedValue13 == companion5.getEmpty()) {
                if (catalogueFormParams == null || (product2 = catalogueFormParams.getProduct()) == null || (info2 = product2.getInfo()) == null || (str2 = info2.get("state")) == null) {
                    str2 = "new";
                }
                objRememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str2, null, 2, null);
                composer.updateRememberedValue(objRememberedValue13);
            }
            MutableState mutableState19 = (MutableState) objRememberedValue13;
            Object objRememberedValue14 = composer.rememberedValue();
            if (objRememberedValue14 == companion5.getEmpty()) {
                if (catalogueFormParams == null || (product = catalogueFormParams.getProduct()) == null || (info = product.getInfo()) == null || (str = info.get(Product.EXTRA_COIN_TYPE)) == null) {
                    str = Product.COIN_CUP;
                }
                objRememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                composer.updateRememberedValue(objRememberedValue14);
            }
            final MutableState mutableState20 = (MutableState) objRememberedValue14;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(catalogueViewModel.getProductTags().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            Modifier.Companion companion6 = Modifier.INSTANCE;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(PaddingKt.m1727paddingVpY3zN4$default(companion6, Dp.m8823constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            p0.l lVarQ = p0.r.q(p0.n.a.a(p0.n.a.b(R.raw.catalogue_image_placeholder)), null, null, null, null, null, composer, 0, 62);
            if (mutableState12.getValue() == null) {
                companion = companion6;
                columnScopeInstance = columnScopeInstance2;
                composer.startReplaceGroup(-1919139642);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(100));
                objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == companion5.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.g
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$2$0(mutableState11);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                float f10 = 5;
                mutableState = mutableState11;
                p0.e.a(CatalogueFormScreen$lambda$2$0$29$0(lVarQ), columnScopeInstance.align(PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierM1769size3ABfNKs, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(10)), Dp.m8823constructorimpl(f10), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f10)), companion3.getCenterHorizontally()), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572864, 0, 0, 4194236);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else if (mutableState12.getValue() instanceof String) {
                Object value3 = mutableState12.getValue();
                kotlin.jvm.internal.y.g(value3, "null cannot be cast to non-null type kotlin.String");
                if (le.d0.q0((String) value3)) {
                    if (mutableState12.getValue() instanceof Uri) {
                        value = mutableState12.getValue();
                        kotlin.jvm.internal.y.g(value, "null cannot be cast to non-null type android.net.Uri");
                        if (((Uri) value).getPath() != null) {
                        }
                    }
                    companion = companion6;
                    columnScopeInstance = columnScopeInstance2;
                    composer.startReplaceGroup(-1919139642);
                    Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(100));
                    objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == companion5.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.g
                            @Override // lb.a
                            public final Object invoke() {
                                return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$2$0(mutableState11);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    float f11 = 5;
                    mutableState = mutableState11;
                    p0.e.a(CatalogueFormScreen$lambda$2$0$29$0(lVarQ), columnScopeInstance.align(PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierM1769size3ABfNKs2, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(10)), Dp.m8823constructorimpl(f11), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f11)), companion3.getCenterHorizontally()), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572864, 0, 0, 4194236);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                }
                composer.startReplaceGroup(-1724502187);
                Modifier modifierM1769size3ABfNKs3 = SizeKt.m1769size3ABfNKs(companion6, Dp.m8823constructorimpl(100));
                objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion5.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.f
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$1$0(mutableState11);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                float f12 = 5;
                Modifier modifierAlign = columnScopeInstance2.align(PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierM1769size3ABfNKs3, false, null, null, null, (lb.a) objRememberedValue2, 15, null), Dp.m8823constructorimpl(10)), Dp.m8823constructorimpl(f12), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f12)), companion3.getCenterHorizontally());
                value2 = mutableState12.getValue();
                if (value2 == null) {
                    value2 = CameraAltKt.getCameraAlt(Icons.Outlined.INSTANCE);
                }
                columnScopeInstance = columnScopeInstance2;
                companion = companion6;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierAlign, value2, null, null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composer, 24576, 492);
                composer2 = composer;
                composer2.endReplaceGroup();
                mutableState = mutableState11;
            } else {
                if (mutableState12.getValue() instanceof Uri) {
                    value = mutableState12.getValue();
                    kotlin.jvm.internal.y.g(value, "null cannot be cast to non-null type android.net.Uri");
                    if (((Uri) value).getPath() != null) {
                        composer.startReplaceGroup(-1724502187);
                        Modifier modifierM1769size3ABfNKs4 = SizeKt.m1769size3ABfNKs(companion6, Dp.m8823constructorimpl(100));
                        objRememberedValue2 = composer.rememberedValue();
                        if (objRememberedValue2 == companion5.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$1$0(mutableState11);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue2);
                        }
                        float f13 = 5;
                        Modifier modifierAlign2 = columnScopeInstance2.align(PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierM1769size3ABfNKs4, false, null, null, null, (lb.a) objRememberedValue2, 15, null), Dp.m8823constructorimpl(10)), Dp.m8823constructorimpl(f13), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f13)), companion3.getCenterHorizontally());
                        value2 = mutableState12.getValue();
                        if (value2 == null) {
                            value2 = CameraAltKt.getCameraAlt(Icons.Outlined.INSTANCE);
                        }
                        columnScopeInstance = columnScopeInstance2;
                        companion = companion6;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierAlign2, value2, null, null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composer, 24576, 492);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                        mutableState = mutableState11;
                    }
                }
                companion = companion6;
                columnScopeInstance = columnScopeInstance2;
                composer.startReplaceGroup(-1919139642);
                Modifier modifierM1769size3ABfNKs5 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(100));
                objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == companion5.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.g
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$2$0(mutableState11);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                float f14 = 5;
                mutableState = mutableState11;
                p0.e.a(CatalogueFormScreen$lambda$2$0$29$0(lVarQ), columnScopeInstance.align(PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierM1769size3ABfNKs5, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(10)), Dp.m8823constructorimpl(f14), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f14)), companion3.getCenterHorizontally()), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572864, 0, 0, 4194236);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            float f15 = 10;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f15)), composer2, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            String strCatalogueFormScreen$lambda$2$0$5 = CatalogueFormScreen$lambda$2$0$5(mutableState13);
            String strStringResource = StringResources_androidKt.stringResource(R.string.name, composer2, 0);
            Object objRememberedValue15 = composer2.rememberedValue();
            if (objRememberedValue15 == companion5.getEmpty()) {
                mutableState2 = mutableState13;
                objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$3$0(mutableState2, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue15);
            } else {
                mutableState2 = mutableState13;
            }
            final MutableState mutableState21 = mutableState2;
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, strCatalogueFormScreen$lambda$2$0$5, 1, 0, strStringResource, null, (Function1) objRememberedValue15, null, null, 50, 0, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806879622, 0, 1047976);
            float f16 = 30;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f16)), composer, 6);
            Modifier modifierAlign3 = columnScopeInstance.align(companion, companion3.getCenterHorizontally());
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.price, composer, 0);
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierAlign3, strStringResource2, materialTheme2.getTypography(composer, i13).getLabelLarge(), 0L, 0, 0, composer, 0, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f15)), composer, 6);
            Object objRememberedValue16 = composer.rememberedValue();
            if (objRememberedValue16 == companion5.getEmpty()) {
                objRememberedValue16 = va.w.q(Product.COIN_CUP, Product.COIN_MLC, Product.COIN_YUK);
                composer.updateRememberedValue(objRememberedValue16);
            }
            final List list = (List) objRememberedValue16;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            String strCatalogueFormScreen$lambda$2$0$8 = CatalogueFormScreen$lambda$2$0$8(mutableState14);
            KeyboardType.Companion companion7 = KeyboardType.INSTANCE;
            int iM8499getDecimalPjHm6EE = companion7.m8499getDecimalPjHm6EE();
            Object objRememberedValue17 = composer.rememberedValue();
            if (objRememberedValue17 == companion5.getEmpty()) {
                mutableState3 = mutableState14;
                objRememberedValue17 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$5$0(mutableState3, (String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue17);
            } else {
                mutableState3 = mutableState14;
            }
            final MutableState mutableState22 = mutableState3;
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default2, strCatalogueFormScreen$lambda$2$0$8, 1, 0, null, null, (Function1) objRememberedValue17, null, ComposableLambdaKt.rememberComposableLambda(277677766, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$6(list, mutableState20, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), 6, iM8499getDecimalPjHm6EE, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 907542918, 6, 1046712);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f16)), composer, 6);
            boolean zCatalogueFormScreen$lambda$2$0$17 = CatalogueFormScreen$lambda$2$0$17(r16);
            Object objRememberedValue18 = composer.rememberedValue();
            if (objRememberedValue18 == companion5.getEmpty()) {
                mutableState4 = mutableState17;
                objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$7$0(mutableState4, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue18);
            } else {
                mutableState4 = r16;
            }
            Z17TextToggleKt.Z17TextToggle(null, zCatalogueFormScreen$lambda$2$0$17, (Function1) objRememberedValue18, ComposableLambdaKt.rememberComposableLambda(1886202614, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$8(mutableState4, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), StringResources_androidKt.stringResource(R.string.make_public, composer, 0), null, null, composer, 3456, 97);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f16)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.optionals, composer, 0), null, 0L, 0, 0, composer, 0, 61);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f15)), composer, 6);
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            String strCatalogueFormScreen$lambda$2$0$11 = CatalogueFormScreen$lambda$2$0$11(mutableState15);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.optional_description, composer, 0);
            Object objRememberedValue19 = composer.rememberedValue();
            if (objRememberedValue19 == companion5.getEmpty()) {
                mutableState5 = mutableState15;
                objRememberedValue19 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$9$0(mutableState5, (String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue19);
            } else {
                mutableState5 = mutableState15;
            }
            final MutableState mutableState23 = mutableState5;
            final MutableState mutableState24 = mutableState4;
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default3, strCatalogueFormScreen$lambda$2$0$11, 4, 3, strStringResource3, null, (Function1) objRememberedValue19, null, null, 250, 0, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806882694, 0, 1047968);
            Composer composer5 = composer;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f16)), composer5, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(companion, companion3.getCenterHorizontally()), StringResources_androidKt.stringResource(R.string.state, composer5, 0), materialTheme2.getTypography(composer5, i13).getLabelLarge(), 0L, 0, 0, composer5, 0, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f15)), composer5, 6);
            String strCatalogueFormScreen$lambda$2$0$23 = CatalogueFormScreen$lambda$2$0$23(mutableState19);
            Object objRememberedValue20 = composer5.rememberedValue();
            if (objRememberedValue20 == companion5.getEmpty()) {
                mutableState6 = mutableState19;
                objRememberedValue20 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$10$0(mutableState6, (String) obj2);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue20);
            } else {
                mutableState6 = mutableState19;
            }
            StateSelector(strCatalogueFormScreen$lambda$2$0$23, (Function1) objRememberedValue20, composer5, 48);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f16)), composer5, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(companion, companion3.getCenterHorizontally()), StringResources_androidKt.stringResource(R.string.tags, composer5, 0), materialTheme2.getTypography(composer5, i13).getLabelLarge(), 0L, 0, 0, composer5, 0, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f15)), composer5, 6);
            FlowLayoutKt.FlowRow(null, null, null, null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1104998776, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$11(stateCollectAsStateWithLifecycle, catalogueViewModel, (FlowRowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer5, 54), composer5, 1572864, 63);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(5)), composer5, 6);
            if (CatalogueFormScreen$lambda$2$0$28(stateCollectAsStateWithLifecycle).size() < 2) {
                composer5.startReplaceGroup(-1913536299);
                Object objRememberedValue21 = composer5.rememberedValue();
                if (objRememberedValue21 == companion5.getEmpty()) {
                    obj = null;
                    objRememberedValue21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer5.updateRememberedValue(objRememberedValue21);
                } else {
                    obj = null;
                }
                final MutableState mutableState25 = (MutableState) objRememberedValue21;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion3.getCenterVertically(), composer5, 54);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer5, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer5, companion);
                lb.a constructor3 = companion4.getConstructor();
                if (!defpackage.r.a(composer5.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer5.startReusableNode();
                if (composer5.getInserting()) {
                    composer5.createNode(constructor3);
                } else {
                    composer5.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer5);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(e3.a(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(f15), 0.0f, 11, null);
                int iM8507getUriPjHm6EE = companion7.m8507getUriPjHm6EE();
                String strCatalogueFormScreen$lambda$2$0$29$13 = CatalogueFormScreen$lambda$2$0$29$13(mutableState25);
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.add_a_new_tag, composer5, 0);
                Object objRememberedValue22 = composer5.rememberedValue();
                if (objRememberedValue22 == companion5.getEmpty()) {
                    objRememberedValue22 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.w
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$15$0$0(mutableState25, (String) obj2);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue22);
                }
                Modifier.Companion companion8 = companion;
                i12 = i13;
                materialTheme = materialTheme2;
                Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierM1729paddingqDBjuR0$default, strCatalogueFormScreen$lambda$2$0$29$13, 1, 0, strStringResource4, null, (Function1) objRememberedValue22, null, null, 10, iM8507getUriPjHm6EE, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806879616, 6, 1046952);
                Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(companion8, 0.0f, Dp.m8823constructorimpl(3), 0.0f, 0.0f, 13, null);
                catalogueViewModel2 = catalogueViewModel;
                companion2 = companion8;
                boolean zChangedInstance = composer.changedInstance(catalogueViewModel2);
                Object objRememberedValue23 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue23 == companion5.getEmpty()) {
                    objRememberedValue23 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.h0
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$15$1$0(catalogueViewModel2, mutableState25);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue23);
                }
                Z17ButtonsKt.Z17PrimaryButton(modifierM1729paddingqDBjuR0$default2, (lb.a) objRememberedValue23, StringResources_androidKt.stringResource(R.string.add, composer, 0), null, false, false, composer, 6, 56);
                composer5 = composer;
                composer5.endNode();
                composer5.endReplaceGroup();
            } else {
                materialTheme = materialTheme2;
                i12 = i13;
                catalogueViewModel2 = catalogueViewModel;
                companion2 = companion;
                composer5.startReplaceGroup(-1912019841);
                composer5.endReplaceGroup();
            }
            int i14 = i12;
            Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(companion2, companion3.getCenterHorizontally()), StringResources_androidKt.stringResource(R.string.location, composer5, 0), materialTheme.getTypography(composer5, i14).getLabelLarge(), 0L, 0, 0, composer5, 0, 56);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f15)), composer5, 6);
            float f17 = 1;
            float f18 = 15;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(companion2, Dp.m8823constructorimpl(f17), materialTheme.getColorScheme(composer5, i14).getOnBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f18))), Dp.m8823constructorimpl(f15));
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), composer5, 48);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer5, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer5, modifierM1725padding3ABfNKs);
            lb.a constructor4 = companion4.getConstructor();
            if (!defpackage.r.a(composer5.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer5.startReusableNode();
            if (composer5.getInserting()) {
                composer5.createNode(constructor4);
            } else {
                composer5.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer5);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.province, composer5, 0), materialTheme.getTypography(composer5, i14).getLabelSmall(), 0L, 0, 0, composer5, 0, 57);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f15)), composer5, 6);
            TextStyle bodyMedium = materialTheme.getTypography(composer5, i14).getBodyMedium();
            List<Province> fullData = catalogueViewModel2.getCubaGeoDataSource().getFullData();
            Province province = catalogueViewModel2.getCubaGeoDataSource().getFullData().get(mutableIntState4.getIntValue());
            boolean zChangedInstance2 = composer5.changedInstance(catalogueViewModel2);
            Object objRememberedValue24 = composer5.rememberedValue();
            if (zChangedInstance2 || objRememberedValue24 == companion5.getEmpty()) {
                mutableIntState = mutableIntState4;
                mutableIntState2 = mutableIntState5;
                objRememberedValue24 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$16$0$0(mutableIntState2, mutableIntState, catalogueViewModel2, (Province) obj2);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue24);
            } else {
                mutableIntState = mutableIntState4;
                mutableIntState2 = mutableIntState5;
            }
            Function1 function1 = (Function1) objRememberedValue24;
            Object objRememberedValue25 = composer5.rememberedValue();
            if (objRememberedValue25 == companion5.getEmpty()) {
                objRememberedValue25 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$16$1$0((Province) obj2);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue25);
            }
            MutableIntState mutableIntState6 = mutableIntState2;
            Z17SpinnerKt.Z17Spinner2(null, fullData, function1, province, (Function1) objRememberedValue25, bodyMedium, composer, 24576, 1);
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f15)), composer, 6);
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(companion2, Dp.m8823constructorimpl(f17), materialTheme.getColorScheme(composer, i14).getOnBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f18))), Dp.m8823constructorimpl(f15));
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), composer, 48);
            int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs2);
            lb.a constructor5 = companion4.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy3, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion4.getSetModifier());
            final MutableIntState mutableIntState7 = mutableIntState;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.municipality, composer, 0), materialTheme.getTypography(composer, i14).getLabelSmall(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f15)), composer, 6);
            TextStyle bodyMedium2 = materialTheme.getTypography(composer, i14).getBodyMedium();
            List<String> municipalities = catalogueViewModel2.getCubaGeoDataSource().getFullData().get(mutableIntState7.getIntValue()).getMunicipalities();
            String str6 = catalogueViewModel2.getCubaGeoDataSource().getFullData().get(mutableIntState7.getIntValue()).getMunicipalities().get(mutableIntState6.getIntValue());
            boolean zChangedInstance3 = composer.changedInstance(catalogueViewModel2);
            Object objRememberedValue26 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue26 == companion5.getEmpty()) {
                mutableIntState3 = mutableIntState6;
                objRememberedValue26 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.m0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$17$0$0(mutableIntState3, catalogueViewModel2, mutableIntState7, (String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue26);
            } else {
                mutableIntState3 = mutableIntState6;
            }
            Function1 function2 = (Function1) objRememberedValue26;
            Object objRememberedValue27 = composer.rememberedValue();
            if (objRememberedValue27 == companion5.getEmpty()) {
                objRememberedValue27 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.n0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$17$1$0((String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue27);
            }
            Z17SpinnerKt.Z17Spinner2(null, municipalities, function2, str6, (Function1) objRememberedValue27, bodyMedium2, composer, 24576, 1);
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f15)), composer, 6);
            boolean z10 = mutableState16.getValue() != null;
            boolean zChanged = composer.changed(aVar) | composer.changedInstance(catalogueViewModel2);
            Object objRememberedValue28 = composer.rememberedValue();
            if (zChanged || objRememberedValue28 == companion5.getEmpty()) {
                mutableState7 = mutableState16;
                objRememberedValue28 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.o0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$18$0(aVar, mutableState7, catalogueViewModel2, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue28);
            } else {
                mutableState7 = mutableState16;
            }
            ComposableSingletons$CatalogueFormScreenKt composableSingletons$CatalogueFormScreenKt = ComposableSingletons$CatalogueFormScreenKt.INSTANCE;
            final MutableState mutableState26 = mutableState7;
            Z17TextToggleKt.Z17TextToggle(null, z10, (Function1) objRememberedValue28, composableSingletons$CatalogueFormScreenKt.m9843getLambda$87413011$app_productionPFast(), StringResources_androidKt.stringResource(R.string.send_current_location, composer, 0), null, null, composer, 3072, 97);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(100)), composer, 6);
            composer.endNode();
            if (le.d0.q0(CatalogueFormScreen$lambda$2$0$5(mutableState21)) || le.d0.q0(CatalogueFormScreen$lambda$2$0$8(mutableState22))) {
                composer3 = composer;
                mutableState8 = mutableState12;
                mutableState9 = mutableState18;
                composer3.startReplaceGroup(1119853685);
                composer3.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1116344113);
                Modifier modifierAlign4 = boxScopeInstance.align(PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(16)), companion3.getBottomEnd());
                long primary = materialTheme.getColorScheme(composer, i14).getPrimary();
                boolean zChangedInstance4 = composer.changedInstance(catalogueViewModel2) | composer.changedInstance(navHostController);
                Object objRememberedValue29 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue29 == companion5.getEmpty()) {
                    final CatalogueViewModel catalogueViewModel3 = catalogueViewModel2;
                    final MutableIntState mutableIntState8 = mutableIntState3;
                    final MutableState mutableState27 = mutableState6;
                    composer4 = composer;
                    lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.p0
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$30$0(catalogueFormParams, catalogueViewModel3, mutableState12, mutableIntState7, mutableIntState8, mutableState26, mutableState18, mutableState21, mutableState23, mutableState22, mutableState24, mutableState27, mutableState20, navHostController);
                        }
                    };
                    mutableState8 = mutableState12;
                    mutableState9 = mutableState18;
                    composer4.updateRememberedValue(aVar2);
                    objRememberedValue29 = aVar2;
                } else {
                    composer4 = composer;
                    mutableState8 = mutableState12;
                    mutableState9 = mutableState18;
                }
                composer3 = composer4;
                FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((lb.a) objRememberedValue29, modifierAlign4, null, primary, 0L, null, null, composableSingletons$CatalogueFormScreenKt.m9842getLambda$1681876598$app_productionPFast(), composer3, 12582912, AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID);
                composer3.endReplaceGroup();
            }
            if (CatalogueFormScreen$lambda$2$0$20(mutableState9)) {
                composer3.startReplaceGroup(728862426);
                LoadingScreenKt.LoadingWall(composer3, 0);
            } else {
                composer3.startReplaceGroup(1119911221);
            }
            composer3.endReplaceGroup();
            if (CatalogueFormScreen$lambda$2$0$1(mutableState)) {
                composer3.startReplaceGroup(1119987636);
                Object objRememberedValue30 = composer3.rememberedValue();
                if (objRememberedValue30 == companion5.getEmpty()) {
                    mutableState10 = mutableState;
                    objRememberedValue30 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$31$0(mutableState10, (List) obj2, (String) obj3);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue30);
                } else {
                    mutableState10 = mutableState;
                }
                Function2 function3 = (Function2) objRememberedValue30;
                Object objRememberedValue31 = composer3.rememberedValue();
                if (objRememberedValue31 == companion5.getEmpty()) {
                    objRememberedValue31 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$32$0(mutableState8, mutableState10, (List) obj2, (String) obj3);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue31);
                }
                Function2 function4 = (Function2) objRememberedValue31;
                Object objRememberedValue32 = composer3.rememberedValue();
                if (objRememberedValue32 == companion5.getEmpty()) {
                    objRememberedValue32 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.d
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$33$0(mutableState10);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue32);
                }
                lb.a aVar3 = (lb.a) objRememberedValue32;
                Object objRememberedValue33 = composer3.rememberedValue();
                if (objRememberedValue33 == companion5.getEmpty()) {
                    objRememberedValue33 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.e
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$34$0(mutableState10);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue33);
                }
                CameraKt.Camera(null, null, false, false, false, false, 0L, function3, function4, null, aVar3, (lb.a) objRememberedValue33, composer, 113249664, 54, 627);
                composer3 = composer;
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(1120603637);
                composer3.endReplaceGroup();
            }
            ua.k0 k0Var = ua.k0.f43947a;
            boolean zChangedInstance5 = composer3.changedInstance(catalogueViewModel);
            Object objRememberedValue34 = composer3.rememberedValue();
            if (zChangedInstance5 || objRememberedValue34 == companion5.getEmpty()) {
                objRememberedValue34 = new CatalogueFormScreenKt$CatalogueFormScreen$2$1$7$1(catalogueFormParams, catalogueViewModel, null);
                composer3.updateRememberedValue(objRememberedValue34);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue34, composer3, 6);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    private static final boolean CatalogueFormScreen$lambda$2$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final String CatalogueFormScreen$lambda$2$0$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CatalogueFormScreen$lambda$2$0$17(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CatalogueFormScreen$lambda$2$0$18(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final void CatalogueFormScreen$lambda$2$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean CatalogueFormScreen$lambda$2$0$20(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CatalogueFormScreen$lambda$2$0$21(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final String CatalogueFormScreen$lambda$2$0$23(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String CatalogueFormScreen$lambda$2$0$26(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<String> CatalogueFormScreen$lambda$2$0$28(State<? extends List<String>> state) {
        return state.getValue();
    }

    private static final l0.j CatalogueFormScreen$lambda$2$0$29$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$1$0(MutableState mutableState) {
        CatalogueFormScreen$lambda$2$0$2(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$10$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$11(State state, final CatalogueViewModel catalogueViewModel, FlowRowScope FlowRow, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(FlowRow, "$this$FlowRow");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1104998776, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CatalogueFormScreen.kt:354)");
            }
            for (final String str : CatalogueFormScreen$lambda$2$0$28(state)) {
                boolean zChangedInstance = composer.changedInstance(catalogueViewModel) | composer.changed(str);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.y
                        @Override // lb.a
                        public final Object invoke() {
                            return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$11$0$0$0(catalogueViewModel, str);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ProductItemKt.ProductTagItem(null, str, false, (lb.a) objRememberedValue, composer, 0, 5);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$11$0$0$0(CatalogueViewModel catalogueViewModel, final String str) {
        catalogueViewModel.getProductTags().removeAll(new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$11$0$0$0$0(str, (String) obj));
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CatalogueFormScreen$lambda$2$0$29$11$0$0$0$0(String str, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it, str);
    }

    private static final String CatalogueFormScreen$lambda$2$0$29$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$15$0$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        String lowerCase = le.a0.O(le.a0.O(le.d0.q1(it).toString(), "%", "", false, 4, null), "_", "", false, 4, null).toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.y.h(lowerCase, "toLowerCase(...)");
        mutableState.setValue(lowerCase);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$15$1$0(CatalogueViewModel catalogueViewModel, final MutableState mutableState) {
        if (!le.d0.q0(CatalogueFormScreen$lambda$2$0$29$13(mutableState))) {
            catalogueViewModel.getProductTags().removeAll(new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$15$1$0$0(mutableState, (String) obj));
                }
            });
            catalogueViewModel.getProductTags().add(CatalogueFormScreen$lambda$2$0$29$13(mutableState));
        }
        mutableState.setValue("");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CatalogueFormScreen$lambda$2$0$29$15$1$0$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it, CatalogueFormScreen$lambda$2$0$29$13(mutableState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$16$0$0(MutableIntState mutableIntState, MutableIntState mutableIntState2, CatalogueViewModel catalogueViewModel, Province sP) {
        kotlin.jvm.internal.y.i(sP, "sP");
        int i10 = 0;
        mutableIntState.setIntValue(0);
        Iterator<Province> it = catalogueViewModel.getCubaGeoDataSource().getFullData().iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.y.d(it.next().getName(), sP.getName())) {
                mutableIntState2.setIntValue(i10);
                return ua.k0.f43947a;
            }
            i10++;
        }
        i10 = -1;
        mutableIntState2.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CatalogueFormScreen$lambda$2$0$29$16$1$0(Province it) {
        kotlin.jvm.internal.y.i(it, "it");
        return it.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$17$0$0(MutableIntState mutableIntState, CatalogueViewModel catalogueViewModel, MutableIntState mutableIntState2, String sM) {
        kotlin.jvm.internal.y.i(sM, "sM");
        Iterator<String> it = catalogueViewModel.getCubaGeoDataSource().getFullData().get(mutableIntState2.getIntValue()).getMunicipalities().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.y.d(it.next(), sM)) {
                mutableIntState.setIntValue(i10);
                return ua.k0.f43947a;
            }
            i10++;
        }
        i10 = -1;
        mutableIntState.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CatalogueFormScreen$lambda$2$0$29$17$1$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$18$0(c1.a aVar, MutableState mutableState, CatalogueViewModel catalogueViewModel, boolean z10) {
        if (!z10) {
            mutableState.setValue(null);
        } else if (aVar.a()) {
            LocationDataSource.Companion companion = LocationDataSource.INSTANCE;
            if (companion.getInstance().currentLocation() != null) {
                Location locationCurrentLocation = companion.getInstance().currentLocation();
                kotlin.jvm.internal.y.f(locationCurrentLocation);
                Double dValueOf = Double.valueOf(locationCurrentLocation.getLatitude());
                Location locationCurrentLocation2 = companion.getInstance().currentLocation();
                kotlin.jvm.internal.y.f(locationCurrentLocation2);
                mutableState.setValue(ua.z.a(dValueOf, Double.valueOf(locationCurrentLocation2.getLongitude())));
            } else {
                catalogueViewModel.errorObtainingLocation();
            }
        } else {
            aVar.b();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$2$0(MutableState mutableState) {
        CatalogueFormScreen$lambda$2$0$2(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$3$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$5$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$6(List list, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(277677766, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CatalogueFormScreen.kt:269)");
            }
            Modifier modifierM1774width3ABfNKs = SizeKt.m1774width3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(70));
            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium();
            String strCatalogueFormScreen$lambda$2$0$26 = CatalogueFormScreen$lambda$2$0$26(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$6$0$0(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$29$6$1$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17SpinnerKt.Z17Spinner2(modifierM1774width3ABfNKs, list, function1, strCatalogueFormScreen$lambda$2$0$26, (Function1) objRememberedValue2, bodyMedium, composer, 24966, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$6$0$0(MutableState mutableState, String sC) {
        kotlin.jvm.internal.y.i(sC, "sC");
        mutableState.setValue(sC);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CatalogueFormScreen$lambda$2$0$29$6$1$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$7$0(MutableState mutableState, boolean z10) {
        CatalogueFormScreen$lambda$2$0$18(mutableState, !CatalogueFormScreen$lambda$2$0$17(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$8(MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1886202614, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.CatalogueFormScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CatalogueFormScreen.kt:293)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), CatalogueFormScreen$lambda$2$0$17(mutableState) ? VisibilityKt.getVisibility(Icons.Outlined.INSTANCE) : VisibilityOffKt.getVisibilityOff(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$29$9$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$30$0(CatalogueFormParams catalogueFormParams, CatalogueViewModel catalogueViewModel, MutableState mutableState, MutableIntState mutableIntState, MutableIntState mutableIntState2, MutableState mutableState2, final MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, final NavHostController navHostController) {
        Object obj = 0;
        CatalogueFormScreen$lambda$2$0$21(mutableState3, true);
        Product product = catalogueFormParams.getProduct();
        Uri uri = null;
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (product != null) {
            int id2 = catalogueFormParams.getProduct().getId();
            String createdAt = catalogueFormParams.getProduct().getCreatedAt();
            String strCatalogueFormScreen$lambda$2$0$5 = CatalogueFormScreen$lambda$2$0$5(mutableState4);
            String strCatalogueFormScreen$lambda$2$0$11 = CatalogueFormScreen$lambda$2$0$11(mutableState5);
            Double dS = le.y.s(CatalogueFormScreen$lambda$2$0$8(mutableState6));
            if (dS != null) {
                dDoubleValue = dS.doubleValue();
            }
            double d10 = dDoubleValue;
            if (mutableState.getValue() instanceof Uri) {
                Object value = mutableState.getValue();
                kotlin.jvm.internal.y.g(value, "null cannot be cast to non-null type android.net.Uri");
                uri = (Uri) value;
            }
            Uri uri2 = uri;
            String pictureUrl = catalogueFormParams.getProduct().getPictureUrl();
            boolean zCatalogueFormScreen$lambda$2$0$17 = CatalogueFormScreen$lambda$2$0$17(mutableState7);
            String id3 = catalogueViewModel.getCubaGeoDataSource().getFullData().get(mutableIntState.getIntValue()).getId();
            String str = catalogueViewModel.getCubaGeoDataSource().getFullData().get(mutableIntState.getIntValue()).getMunicipalities().get(mutableIntState2.getIntValue());
            Pair pair = (Pair) mutableState2.getValue();
            Object objValueOf = pair != null ? Double.valueOf(((Number) pair.getFirst()).doubleValue()) : obj;
            Pair pair2 = (Pair) mutableState2.getValue();
            catalogueViewModel.updateProduct(id2, createdAt, strCatalogueFormScreen$lambda$2$0$5, strCatalogueFormScreen$lambda$2$0$11, d10, uri2, pictureUrl, zCatalogueFormScreen$lambda$2$0$17, id3, str, objValueOf + "," + (pair2 != null ? Double.valueOf(((Number) pair2.getSecond()).doubleValue()) : 0), CatalogueFormScreen$lambda$2$0$23(mutableState8), CatalogueFormScreen$lambda$2$0$26(mutableState9), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.b0
                @Override // lb.a
                public final Object invoke() {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$30$0$0(navHostController);
                }
            }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.c0
                @Override // lb.a
                public final Object invoke() {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$30$0$1(mutableState3);
                }
            });
        } else {
            String strCatalogueFormScreen$lambda$2$0$6 = CatalogueFormScreen$lambda$2$0$5(mutableState4);
            String strCatalogueFormScreen$lambda$2$0$12 = CatalogueFormScreen$lambda$2$0$11(mutableState5);
            Double dS2 = le.y.s(CatalogueFormScreen$lambda$2$0$8(mutableState6));
            if (dS2 != null) {
                dDoubleValue = dS2.doubleValue();
            }
            double d11 = dDoubleValue;
            if (mutableState.getValue() instanceof Uri) {
                Object value2 = mutableState.getValue();
                kotlin.jvm.internal.y.g(value2, "null cannot be cast to non-null type android.net.Uri");
                uri = (Uri) value2;
            }
            Uri uri3 = uri;
            boolean zCatalogueFormScreen$lambda$2$0$18 = CatalogueFormScreen$lambda$2$0$17(mutableState7);
            String id4 = catalogueViewModel.getCubaGeoDataSource().getFullData().get(mutableIntState.getIntValue()).getId();
            String str2 = catalogueViewModel.getCubaGeoDataSource().getFullData().get(mutableIntState.getIntValue()).getMunicipalities().get(mutableIntState2.getIntValue());
            Pair pair3 = (Pair) mutableState2.getValue();
            Object objValueOf2 = pair3 != null ? Double.valueOf(((Number) pair3.getFirst()).doubleValue()) : obj;
            Pair pair4 = (Pair) mutableState2.getValue();
            catalogueViewModel.addProduct(strCatalogueFormScreen$lambda$2$0$6, strCatalogueFormScreen$lambda$2$0$12, d11, uri3, zCatalogueFormScreen$lambda$2$0$18, id4, str2, objValueOf2 + "," + (pair4 != null ? Double.valueOf(((Number) pair4.getSecond()).doubleValue()) : 0), CatalogueFormScreen$lambda$2$0$23(mutableState8), CatalogueFormScreen$lambda$2$0$26(mutableState9), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.d0
                @Override // lb.a
                public final Object invoke() {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$30$0$2(navHostController);
                }
            }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.e0
                @Override // lb.a
                public final Object invoke() {
                    return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$30$0$3(mutableState3);
                }
            });
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$30$0$0(NavHostController navHostController) {
        navHostController.navigate(NavLinks.MY_CATALOGUE, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$30$0$0$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$30$0$0$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$30$0$1(MutableState mutableState) {
        CatalogueFormScreen$lambda$2$0$21(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$30$0$2(NavHostController navHostController) {
        navHostController.navigate(NavLinks.MY_CATALOGUE, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CatalogueFormScreenKt.CatalogueFormScreen$lambda$2$0$30$0$2$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$30$0$2$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$30$0$3(MutableState mutableState) {
        CatalogueFormScreen$lambda$2$0$21(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$31$0(MutableState mutableState, List files, String content) {
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        CatalogueFormScreen$lambda$2$0$2(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$32$0(MutableState mutableState, MutableState mutableState2, List files, String str) {
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(str, "<unused var>");
        CatalogueFormScreen$lambda$2$0$2(mutableState2, false);
        File file = (File) va.g0.y0(files);
        mutableState.setValue(file != null ? Uri.fromFile(file) : null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$33$0(MutableState mutableState) {
        CatalogueFormScreen$lambda$2$0$2(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$2$0$34$0(MutableState mutableState) {
        CatalogueFormScreen$lambda$2$0$2(mutableState, false);
        return ua.k0.f43947a;
    }

    private static final String CatalogueFormScreen$lambda$2$0$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String CatalogueFormScreen$lambda$2$0$8(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CatalogueFormScreen$lambda$3(NavHostController navHostController, String str, CatalogueViewModel catalogueViewModel, int i10, int i11, Composer composer, int i12) {
        CatalogueFormScreen(navHostController, str, catalogueViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StateSelector(final String selected, final Function1 onSelected, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(selected, "selected");
        kotlin.jvm.internal.y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(1654820897);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(selected) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelected) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1654820897, i11, -1, "cu.todus.android.uiCompose.main.screen.catalogue.form.StateSelector (CatalogueFormScreen.kt:611)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i12 = i11 & 14;
            int i13 = i11 & 112;
            boolean z10 = (i12 == 4) | (i13 == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.o
                    @Override // lb.a
                    public final Object invoke() {
                        return CatalogueFormScreenKt.StateSelector$lambda$0$0$0(selected, onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
            lb.a constructor2 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            float f10 = 30;
            float f11 = 3;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f10)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null);
            ImageVector checkCircle = kotlin.jvm.internal.y.d(selected, "new") ? CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE) : RadioButtonUncheckedKt.getRadioButtonUnchecked(Icons.Outlined.INSTANCE);
            ColorFilter.Companion companion4 = ColorFilter.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1729paddingqDBjuR0$default, checkCircle, null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.new_state, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup.endNode();
            boolean z11 = (i13 == 32) | (i12 == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.p
                    @Override // lb.a
                    public final Object invoke() {
                        return CatalogueFormScreenKt.StateSelector$lambda$0$2$0(selected, onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue2, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default2);
            lb.a constructor3 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f10)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null), kotlin.jvm.internal.y.d(selected, Product.STATE_GOOD) ? CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE) : RadioButtonUncheckedKt.getRadioButtonUnchecked(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.good_state, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup.endNode();
            boolean z12 = (i13 == 32) | (i12 == 4);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.q
                    @Override // lb.a
                    public final Object invoke() {
                        return CatalogueFormScreenKt.StateSelector$lambda$0$4$0(selected, onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierM1240clickableoSLSa3U$default3 = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue3, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default3);
            lb.a constructor4 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f10)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null), kotlin.jvm.internal.y.d(selected, Product.STATE_REFURBISHED) ? CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE) : RadioButtonUncheckedKt.getRadioButtonUnchecked(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.fixed, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup.endNode();
            boolean z13 = (i12 == 4) | (i13 == 32);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.r
                    @Override // lb.a
                    public final Object invoke() {
                        return CatalogueFormScreenKt.StateSelector$lambda$0$6$0(selected, onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierM1240clickableoSLSa3U$default4 = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue4, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default4);
            lb.a constructor5 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy4, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f10)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null), kotlin.jvm.internal.y.d(selected, Product.STATE_BAD) ? CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE) : RadioButtonUncheckedKt.getRadioButtonUnchecked(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.bad_state, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.form.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogueFormScreenKt.StateSelector$lambda$1(selected, onSelected, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StateSelector$lambda$0$0$0(String str, Function1 function1) {
        if (!kotlin.jvm.internal.y.d(str, "new")) {
            function1.invoke("new");
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StateSelector$lambda$0$2$0(String str, Function1 function1) {
        if (!kotlin.jvm.internal.y.d(str, Product.STATE_GOOD)) {
            function1.invoke(Product.STATE_GOOD);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StateSelector$lambda$0$4$0(String str, Function1 function1) {
        if (!kotlin.jvm.internal.y.d(str, Product.STATE_REFURBISHED)) {
            function1.invoke(Product.STATE_REFURBISHED);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StateSelector$lambda$0$6$0(String str, Function1 function1) {
        if (!kotlin.jvm.internal.y.d(str, Product.STATE_BAD)) {
            function1.invoke(Product.STATE_BAD);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StateSelector$lambda$1(String str, Function1 function1, int i10, Composer composer, int i11) {
        StateSelector(str, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
