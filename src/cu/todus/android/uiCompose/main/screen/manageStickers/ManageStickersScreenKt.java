package cu.todus.android.uiCompose.main.screen.manageStickers;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
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
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.rest.entity.StickerPack;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r²\u0006\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\nX\u008a\u0084\u0002²\u0006\f\u0010\u000b\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\u000e\u0010\f\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/manageStickers/ManageStickersViewModel;", "viewModel", "Lua/k0;", "ManageStickersScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/manageStickers/ManageStickersViewModel;Landroidx/compose/runtime/Composer;II)V", "", "actualDownloaded", "filterValue", "msgFilterWithDelay", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ManageStickersScreenKt {
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00df  */
    /* JADX WARN: Code duplicated, block: B:64:0x0128  */
    /* JADX WARN: Code duplicated, block: B:67:0x0179  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ManageStickersScreen(final NavHostController navHostController, final String params, ManageStickersViewModel manageStickersViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z10;
        Object objRememberedValue;
        Composer.Companion companion;
        ManageStickersParams manageStickersParams;
        Object objRememberedValue2;
        int i13;
        final ManageStickersViewModel manageStickersViewModel2 = manageStickersViewModel;
        y.i(navHostController, "navHostController");
        y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2056795843);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(params) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) != 0) {
                i13 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(manageStickersViewModel2) : composerStartRestartGroup.changedInstance(manageStickersViewModel2)) {
                    i13 = 256;
                } else {
                    i13 = 128;
                }
            }
            i12 |= i13;
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
                    i14 &= -897;
                    z10 = true;
                    manageStickersViewModel2 = (ManageStickersViewModel) ViewModelKt.viewModel(z0.b(ManageStickersViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2056795843, i14, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreen (ManageStickersScreen.kt:51)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (ManageStickersParams) manageStickersViewModel2.getGson().j(params, ManageStickersParams.class);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                manageStickersParams = (ManageStickersParams) objRememberedValue;
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(manageStickersViewModel2.getActualDownloaded(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(manageStickersViewModel2.getFilterValue(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(manageStickersParams.getPack(), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState = (MutableState) objRememberedValue2;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(manageStickersViewModel2.stickers(ManageStickersScreen$lambda$4(mutableState)), null, composerStartRestartGroup, 0, 1);
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-466149495, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ManageStickersScreenKt.ManageStickersScreen$lambda$6(navHostController, manageStickersViewModel2, stateCollectAsStateWithLifecycle2, mutableState, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-1995814841, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ManageStickersScreenKt.ManageStickersScreen$lambda$7(lazyPagingItemsCollectAsLazyPagingItems, stateCollectAsStateWithLifecycle, manageStickersViewModel2, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i14 &= -897;
                }
            }
            z10 = true;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2056795843, i14, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreen (ManageStickersScreen.kt:51)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (ManageStickersParams) manageStickersViewModel2.getGson().j(params, ManageStickersParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            manageStickersParams = (ManageStickersParams) objRememberedValue;
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(manageStickersViewModel2.getActualDownloaded(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(manageStickersViewModel2.getFilterValue(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(manageStickersParams.getPack(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(manageStickersViewModel2.stickers(ManageStickersScreen$lambda$4(mutableState2)), null, composerStartRestartGroup, 0, 1);
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-466149495, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ManageStickersScreenKt.ManageStickersScreen$lambda$6(navHostController, manageStickersViewModel2, stateCollectAsStateWithLifecycle4, mutableState2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-1995814841, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ManageStickersScreenKt.ManageStickersScreen$lambda$7(lazyPagingItemsCollectAsLazyPagingItems2, stateCollectAsStateWithLifecycle3, manageStickersViewModel2, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final ManageStickersViewModel manageStickersViewModel3 = manageStickersViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ManageStickersScreenKt.ManageStickersScreen$lambda$8(navHostController, params, manageStickersViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<String> ManageStickersScreen$lambda$1(State<? extends List<String>> state) {
        return state.getValue();
    }

    private static final String ManageStickersScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    private static final String ManageStickersScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ManageStickersScreen$lambda$6(NavHostController navHostController, final ManageStickersViewModel manageStickersViewModel, final State state, final MutableState mutableState, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-466149495, i10, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreen.<anonymous> (ManageStickersScreen.kt:73)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(-133960484, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ManageStickersScreenKt.ManageStickersScreen$lambda$6$0(manageStickersViewModel, state, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
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
    public static final k0 ManageStickersScreen$lambda$6$0(final ManageStickersViewModel manageStickersViewModel, State state, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-133960484, i10, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreen.<anonymous>.<anonymous> (ManageStickersScreen.kt:76)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String strManageStickersScreen$lambda$2 = ManageStickersScreen$lambda$2(state);
            String strStringResource = StringResources_androidKt.stringResource(R.string.search_hint, composer, 0);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m8823constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            boolean zChangedInstance = composer.changedInstance(manageStickersViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ManageStickersScreenKt.ManageStickersScreen$lambda$6$0$0$0$0(manageStickersViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposableSingletons$ManageStickersScreenKt composableSingletons$ManageStickersScreenKt = ComposableSingletons$ManageStickersScreenKt.INSTANCE;
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, strManageStickersScreen$lambda$2, 1, 0, strStringResource, null, (Function1) objRememberedValue, composableSingletons$ManageStickersScreenKt.m9945getLambda$69619731$app_productionPFast(), null, 0, 0, 0L, 0L, 0L, 0L, 0L, null, false, circleShape, false, composer, 12583296, 0, 786216);
            boolean zChangedInstance2 = composer.changedInstance(manageStickersViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.e
                    @Override // lb.a
                    public final Object invoke() {
                        return ManageStickersScreenKt.ManageStickersScreen$lambda$6$0$0$1$0(manageStickersViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, composableSingletons$ManageStickersScreenKt.m9944getLambda$1677827942$app_productionPFast(), composer, 1572912, 60);
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
    public static final k0 ManageStickersScreen$lambda$6$0$0$0$0(ManageStickersViewModel manageStickersViewModel, String it) {
        y.i(it, "it");
        manageStickersViewModel.setNewFilterValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageStickersScreen$lambda$6$0$0$1$0(ManageStickersViewModel manageStickersViewModel, MutableState mutableState) {
        manageStickersViewModel.setNewFilterValue("");
        mutableState.setValue("");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ManageStickersScreen$lambda$7(final LazyPagingItems lazyPagingItems, final State state, final ManageStickersViewModel manageStickersViewModel, MutableState mutableState, Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1995814841, i10, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreen.<anonymous> (ManageStickersScreen.kt:117)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            float f10 = 8;
            float f11 = 20;
            PaddingValues paddingValuesM1721PaddingValuesa9UjIt4 = PaddingKt.m1721PaddingValuesa9UjIt4(Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10));
            boolean zChangedInstance = composer.changedInstance(lazyPagingItems) | composer.changed(state) | composer.changedInstance(manageStickersViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ManageStickersScreenKt.ManageStickersScreen$lambda$7$0$0(lazyPagingItems, manageStickersViewModel, state, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyColumn(modifierFillMaxSize$default, lazyListStateRememberLazyListState, paddingValuesM1721PaddingValuesa9UjIt4, false, null, null, null, false, null, (Function1) objRememberedValue, composer, 6, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance2 = composer.changedInstance(manageStickersViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new ManageStickersScreenKt$ManageStickersScreen$2$2$1(manageStickersViewModel, mutableState, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageStickersScreen$lambda$7$0$0(final LazyPagingItems lazyPagingItems, final ManageStickersViewModel manageStickersViewModel, final State state, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ManageStickersScreenKt.ManageStickersScreen$lambda$7$0$0$0((StickerPack) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ManageStickersScreenKt.ManageStickersScreen$lambda$7$0$0$1((StickerPack) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-2125724183, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.h
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ManageStickersScreenKt.ManageStickersScreen$lambda$7$0$0$2(lazyPagingItems, manageStickersViewModel, state, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1022396910, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.i
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ManageStickersScreenKt.ManageStickersScreen$lambda$7$0$0$3(lazyPagingItems, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ManageStickersScreen$lambda$7$0$0$0(StickerPack s10) {
        y.i(s10, "s");
        return s10.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ManageStickersScreen$lambda$7$0$0$1(StickerPack it) {
        y.i(it, "it");
        return "sticker";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ManageStickersScreen$lambda$7$0$0$2(LazyPagingItems lazyPagingItems, final ManageStickersViewModel manageStickersViewModel, State state, LazyItemScope items, int i10, Composer composer, int i11) {
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i11 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i11 & 145) != 144, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2125724183, i11, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ManageStickersScreen.kt:134)");
            }
            final StickerPack stickerPack = (StickerPack) lazyPagingItems.get(i10);
            if (stickerPack != null) {
                composer.startReplaceGroup(1583496992);
                String title = stickerPack.getTitle();
                boolean zContains = ManageStickersScreen$lambda$1(state).contains(stickerPack.getName());
                String strPreviewFileUrl = stickerPack.previewFileUrl();
                boolean zChangedInstance = composer.changedInstance(manageStickersViewModel) | composer.changed(stickerPack);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ManageStickersScreenKt.ManageStickersScreen$lambda$7$0$0$2$0$0(manageStickersViewModel, stickerPack, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                StickerPackItemKt.StickerPackItem(title, zContains, strPreviewFileUrl, (Function1) objRememberedValue, composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1583512325);
                StickerPackItemKt.StickerPackItemPlaceholder(composer, 0);
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
    public static final k0 ManageStickersScreen$lambda$7$0$0$2$0$0(ManageStickersViewModel manageStickersViewModel, StickerPack stickerPack, boolean z10) {
        if (z10) {
            manageStickersViewModel.saveStickerPack(stickerPack);
        } else {
            manageStickersViewModel.deleteStickerPack(stickerPack);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 ManageStickersScreen$lambda$7$0$0$3(LazyPagingItems lazyPagingItems, LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1022396910, i10, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ManageStickersScreen.kt:152)");
            }
            PagerStateIndicatorKt.PagerStateIndicator(null, null, null, null, lazyPagingItems, composer, LazyPagingItems.$stable << 12, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ManageStickersScreen$lambda$8(NavHostController navHostController, String str, ManageStickersViewModel manageStickersViewModel, int i10, int i11, Composer composer, int i12) {
        ManageStickersScreen(navHostController, str, manageStickersViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
