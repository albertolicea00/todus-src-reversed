package cu.todus.android.uiCompose.main.screen.search;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.data.db.pojo.info.RoomBannerPayload;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageItemKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.InfoContentKt;
import cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItemKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.xmpp.XMPPUtils;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\f²\u0006\f\u0010\b\u001a\u00020\u00078\nX\u008a\u0084\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\n8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/search/SearchViewModel;", "viewModel", "Lua/k0;", "SearchScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/search/SearchViewModel;Landroidx/compose/runtime/Composer;II)V", "", "filterValue", "msgFilterWithDelay", "", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SearchScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SearchScreen(final NavHostController navHostController, SearchViewModel searchViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final SearchViewModel searchViewModel2;
        final SearchViewModel searchViewModel3;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(767200782);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                searchViewModel2 = searchViewModel;
                int i13 = composerStartRestartGroup.changedInstance(searchViewModel2) ? 32 : 16;
                i12 |= i13;
            } else {
                searchViewModel2 = searchViewModel;
            }
            i12 |= i13;
        } else {
            searchViewModel2 = searchViewModel;
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
                ViewModel viewModel = ViewModelKt.viewModel(z0.b(SearchViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                searchViewModel2 = (SearchViewModel) viewModel;
                i12 &= -113;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(767200782, i12, -1, "cu.todus.android.uiCompose.main.screen.search.SearchScreen (SearchScreen.kt:67)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final m0 m0Var = (m0) objRememberedValue;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(searchViewModel2.getFilterValue(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(searchViewModel2.chatMsgs(SearchScreen$lambda$0$2(mutableState)), null, composerStartRestartGroup, 0, 1);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(searchViewModel2.getOpenRooms(SearchScreen$lambda$0$2(mutableState)), null, composerStartRestartGroup, 0, 1);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            searchViewModel3 = searchViewModel2;
            Composer composer2 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1656953084, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.search.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchScreenKt.SearchScreen$lambda$0$7(navHostController, searchViewModel2, stateCollectAsStateWithLifecycle, mutableState, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-2102247810, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.search.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchScreenKt.SearchScreen$lambda$0$8(lazyPagingItemsCollectAsLazyPagingItems2, navHostController, searchViewModel3, lazyPagingItemsCollectAsLazyPagingItems, context, m0Var, mutableState, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306806, 376);
            composerStartRestartGroup = composer2;
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(searchViewModel3);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = new SearchScreenKt$SearchScreen$1$3$1(searchViewModel3, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue4, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            searchViewModel3 = searchViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.search.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreen$lambda$1(navHostController, searchViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String SearchScreen$lambda$0$0(State<String> state) {
        return state.getValue();
    }

    private static final String SearchScreen$lambda$0$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SearchScreen$lambda$0$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SearchScreen$lambda$0$7(NavHostController navHostController, final SearchViewModel searchViewModel, final State state, final MutableState mutableState, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1656953084, i10, -1, "cu.todus.android.uiCompose.main.screen.search.SearchScreen.<anonymous>.<anonymous> (SearchScreen.kt:139)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(-1335412663, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.search.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreen$lambda$0$7$0(searchViewModel, state, mutableState, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final k0 SearchScreen$lambda$0$7$0(final SearchViewModel searchViewModel, State state, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1335412663, i10, -1, "cu.todus.android.uiCompose.main.screen.search.SearchScreen.<anonymous>.<anonymous>.<anonymous> (SearchScreen.kt:142)");
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
            String strSearchScreen$lambda$0$0 = SearchScreen$lambda$0$0(state);
            String strStringResource = StringResources_androidKt.stringResource(R.string.search_hint, composer, 0);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1729paddingqDBjuR0$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m8823constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            boolean zChangedInstance = composer.changedInstance(searchViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$0$7$0$0$0$0(searchViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposableSingletons$SearchScreenKt composableSingletons$SearchScreenKt = ComposableSingletons$SearchScreenKt.INSTANCE;
            Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, strSearchScreen$lambda$0$0, 1, 0, strStringResource, null, (Function1) objRememberedValue, composableSingletons$SearchScreenKt.getLambda$236195864$app_productionPFast(), null, 0, 0, 0L, 0L, 0L, 0L, 0L, null, false, circleShape, false, composer, 12583296, 0, 786216);
            boolean zChangedInstance2 = composer.changedInstance(searchViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.search.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$0$7$0$0$1$0(searchViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, composableSingletons$SearchScreenKt.m9975getLambda$1082871093$app_productionPFast(), composer, 1572912, 60);
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
    public static final k0 SearchScreen$lambda$0$7$0$0$0$0(SearchViewModel searchViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        searchViewModel.setNewFilterValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$7$0$0$1$0(SearchViewModel searchViewModel, MutableState mutableState) {
        searchViewModel.setNewFilterValue("");
        mutableState.setValue("");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SearchScreen$lambda$0$8(final LazyPagingItems lazyPagingItems, final NavHostController navHostController, final SearchViewModel searchViewModel, final LazyPagingItems lazyPagingItems2, final Context context, final m0 m0Var, final MutableState mutableState, final MutableState mutableState2, Modifier it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2102247810, i11, -1, "cu.todus.android.uiCompose.main.screen.search.SearchScreen.<anonymous>.<anonymous> (SearchScreen.kt:183)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
            boolean zChangedInstance = composer.changedInstance(lazyPagingItems) | composer.changedInstance(navHostController) | composer.changedInstance(searchViewModel) | composer.changedInstance(lazyPagingItems2) | composer.changedInstance(context) | composer.changedInstance(m0Var);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0(lazyPagingItems, lazyPagingItems2, navHostController, searchViewModel, mutableState, context, m0Var, mutableState2, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue = function1;
            }
            LazyDslKt.LazyColumn(it, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer, i11 & 14, TypedValues.PositionType.TYPE_CURVE_FIT);
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
    public static final k0 SearchScreen$lambda$0$8$0$0$0(final LazyPagingItems lazyPagingItems, final LazyPagingItems lazyPagingItems2, final NavHostController navHostController, final SearchViewModel searchViewModel, MutableState mutableState, final Context context, final m0 m0Var, final MutableState mutableState2, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$SearchScreenKt composableSingletons$SearchScreenKt = ComposableSingletons$SearchScreenKt.INSTANCE;
        LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$SearchScreenKt.m9978getLambda$316744119$app_productionPFast(), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$0((RoomItemView) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$1((RoomItemView) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(1160559634, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.search.v
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$2(lazyPagingItems, navHostController, searchViewModel, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$SearchScreenKt.m9977getLambda$1615683584$app_productionPFast(), 3, null);
        if (lazyPagingItems.getItemCount() == 0 && lazyPagingItems2.getItemCount() == 0 && !le.d0.q0(SearchScreen$lambda$0$2(mutableState))) {
            LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$SearchScreenKt.m9976getLambda$1487556572$app_productionPFast(), 3, null);
            lazyListScope = LazyColumn;
        } else {
            lazyListScope = LazyColumn;
        }
        lazyListScope.items(lazyPagingItems2.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems2, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$3((MessageWithPartnerWithRoomWithReactions) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems2, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$4((MessageWithPartnerWithRoomWithReactions) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(734015369, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.search.y
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5(lazyPagingItems2, navHostController, searchViewModel, context, m0Var, mutableState2, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SearchScreen$lambda$0$8$0$0$0$0(RoomItemView r10) {
        kotlin.jvm.internal.y.i(r10, "r");
        return r10.getIdOnList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SearchScreen$lambda$0$8$0$0$0$1(RoomItemView i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SearchScreen$lambda$0$8$0$0$0$2(LazyPagingItems lazyPagingItems, final NavHostController navHostController, final SearchViewModel searchViewModel, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1160559634, i12, -1, "cu.todus.android.uiCompose.main.screen.search.SearchScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SearchScreen.kt:204)");
            }
            final RoomItemView roomItemView = (RoomItemView) lazyPagingItems.get(i10);
            if (roomItemView != null) {
                composer.startReplaceGroup(-254498891);
                float f10 = 3;
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(PaddingKt.m1729paddingqDBjuR0$default(androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 2, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f10), 0.0f, Dp.m8823constructorimpl(f10), 4, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null);
                boolean zChanged = composer.changed(roomItemView) | composer.changedInstance(navHostController) | composer.changedInstance(searchViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.search.o
                        @Override // lb.a
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$2$0$0$0(roomItemView, navHostController, searchViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierM1205backgroundbw27NRU$default, false, null, null, null, (lb.a) objRememberedValue, 15, null);
                composer.startReplaceGroup(-1393637752);
                String name = roomItemView.getName();
                if (le.d0.q0(name)) {
                    name = StringResources_androidKt.stringResource(R.string.loading_hint, composer, 0);
                }
                composer.endReplaceGroup();
                String thumbnail = roomItemView.getThumbnail();
                String subject = roomItemView.getRoom().getSubject();
                int type = roomItemView.getRoom().getType();
                boolean pined = roomItemView.getRoom().getPined();
                MessageWithPartnerWithReactions lastMessage = roomItemView.getLastMessage();
                RoomItemKt.RoomItem(modifierM1240clickableoSLSa3U$default, name, thumbnail, subject, "", false, null, type, pined, null, null, false, null, false, lastMessage != null ? lastMessage.getReactions() : null, null, null, composer, 221184, 0, 114240);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1393618270);
                float f11 = 3;
                RoomItemKt.RoomItemPlaceholder(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f11), 0.0f, Dp.m8823constructorimpl(f11), 4, null), composer, 6);
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
    public static final k0 SearchScreen$lambda$0$8$0$0$0$2$0$0$0(RoomItemView roomItemView, NavHostController navHostController, SearchViewModel searchViewModel) {
        int chatType = XMPPUtils.INSTANCE.getChatType(roomItemView.getRoom().getId());
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = searchViewModel.getGson().t(new ChatParams(roomItemView.getRoom().getId(), chatType, null, 0, 12, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goChat(chatType, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SearchScreen$lambda$0$8$0$0$0$3(MessageWithPartnerWithRoomWithReactions m10) {
        kotlin.jvm.internal.y.i(m10, "m");
        return m10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SearchScreen$lambda$0$8$0$0$0$4(MessageWithPartnerWithRoomWithReactions m10) {
        kotlin.jvm.internal.y.i(m10, "m");
        return ExtensionFunsKt.getItemMsgType(m10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5(LazyPagingItems lazyPagingItems, final NavHostController navHostController, final SearchViewModel searchViewModel, Context context, final m0 m0Var, final MutableState mutableState, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        Composer composer2;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(734015369, i12, -1, "cu.todus.android.uiCompose.main.screen.search.SearchScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SearchScreen.kt:291)");
            }
            final MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions = (MessageWithPartnerWithRoomWithReactions) lazyPagingItems.get(i10);
            if (messageWithPartnerWithRoomWithReactions == null) {
                composer.startReplaceGroup(1373561365);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1373561366);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    User senderUser = messageWithPartnerWithRoomWithReactions.getSenderUser();
                    if (senderUser == null || (objRememberedValue = senderUser.getUsername()) == null) {
                        objRememberedValue = messageWithPartnerWithRoomWithReactions.getMessage().getUserSender();
                    }
                    composer.updateRememberedValue(objRememberedValue);
                }
                if (messageWithPartnerWithRoomWithReactions.getMessage().getPayload() != null) {
                    composer.startReplaceGroup(1301072942);
                    if (messageWithPartnerWithRoomWithReactions.getMessage().getPayload() instanceof RoomBannerPayload) {
                        composer.startReplaceGroup(1301172297);
                        String roomName = ((RoomBannerPayload) messageWithPartnerWithRoomWithReactions.getMessage().getPayload()).getRoomName();
                        float f10 = 20;
                        Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        int i13 = MaterialTheme.$stable;
                        Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1205backgroundbw27NRU$default(modifierM1727paddingVpY3zN4$default, materialTheme.getColorScheme(composer, i13).getOnBackground(), null, 2, null), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(5));
                        boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(searchViewModel) | composer.changed(messageWithPartnerWithRoomWithReactions);
                        Object objRememberedValue2 = composer.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.search.b0
                                @Override // lb.a
                                public final Object invoke() {
                                    return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$1$0(messageWithPartnerWithRoomWithReactions, navHostController, searchViewModel);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue2);
                        }
                        Z17LabelKt.m10262Z17LabelfWhpE4E(ClickableKt.m1240clickableoSLSa3U$default(modifierM1726paddingVpY3zN4, false, null, null, null, (lb.a) objRememberedValue2, 15, null), roomName, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i13).getTitleSmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), materialTheme.getColorScheme(composer, i13).getBackground(), 0, 0, composer, 0, 48);
                        composer.endReplaceGroup();
                        composer2 = composer;
                    } else {
                        composer.startReplaceGroup(1288930247);
                        InfoContentKt.InfoContent(context, messageWithPartnerWithRoomWithReactions.getMessage().getPayload(), searchViewModel.getOwner().getNameWithDomain(), messageWithPartnerWithRoomWithReactions.getSenderAlias(), composer, 0);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                    }
                    composer2.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1302638039);
                    Modifier modifierZIndex = ZIndexModifierKt.zIndex(androidx.compose.foundation.lazy.g.c(items, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, 2, null), Float.MIN_VALUE);
                    MessageWithPartnerWithReactions messageWithPartner = ExtensionFunsKt.toMessageWithPartner(messageWithPartnerWithRoomWithReactions);
                    String nameWithDomain = searchViewModel.getOwner().getNameWithDomain();
                    String password = searchViewModel.getOwner().getPassword();
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.search.c0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$2$0((MessageAction) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    Function2 function2 = (Function2) objRememberedValue3;
                    boolean zChangedInstance2 = composer.changedInstance(m0Var) | composer.changedInstance(searchViewModel) | composer.changedInstance(navHostController) | composer.changed(messageWithPartnerWithRoomWithReactions);
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                        Function2 function3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.search.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$3$0(messageWithPartnerWithRoomWithReactions, m0Var, searchViewModel, navHostController, mutableState, (MessageWithPartnerWithReactions) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer.updateRememberedValue(function3);
                        objRememberedValue4 = function3;
                    }
                    Function2 function4 = (Function2) objRememberedValue4;
                    Object objRememberedValue5 = composer.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$4$0((String) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue5);
                    }
                    Function1 function1 = (Function1) objRememberedValue5;
                    Object objRememberedValue6 = composer.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$5$0(((Integer) obj).intValue());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function5 = (Function1) objRememberedValue6;
                    Object objRememberedValue7 = composer.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$6$0((Message) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function6 = (Function1) objRememberedValue7;
                    Object objRememberedValue8 = composer.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$7$0((String) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function7 = (Function1) objRememberedValue8;
                    Object objRememberedValue9 = composer.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.l
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$8$0((String) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    }
                    Function1 function8 = (Function1) objRememberedValue9;
                    Object objRememberedValue10 = composer.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.search.m
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue10);
                    }
                    lb.a aVar = (lb.a) objRememberedValue10;
                    Object objRememberedValue11 = composer.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.search.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$0$8$0$0$0$5$0$10$0((MessageWithPartnerWithReactions) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    }
                    MessageItemKt.MessageItem(modifierZIndex, messageWithPartner, nameWithDomain, password, false, false, false, function2, function4, function1, function5, function6, function7, false, function8, aVar, false, (Function1) objRememberedValue11, null, composer, 819683328, 14380470, 262144);
                    composer.endReplaceGroup();
                }
                k0 k0Var = k0.f43947a;
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
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$1$0(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, NavHostController navHostController, SearchViewModel searchViewModel) {
        SearchScreen$lambda$0$goChatByRoomId(navHostController, searchViewModel, ((RoomBannerPayload) messageWithPartnerWithRoomWithReactions.getMessage().getPayload()).getRoomId());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$10$0(MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$2$0(MessageAction messageAction, int i10) {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$3$0(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, m0 m0Var, SearchViewModel searchViewModel, NavHostController navHostController, MutableState mutableState, MessageWithPartnerWithReactions messageWithPartner, int i10) {
        kotlin.jvm.internal.y.i(messageWithPartner, "messageWithPartner");
        SearchScreen$lambda$0$goOnSpecificPosition(m0Var, searchViewModel, navHostController, mutableState, messageWithPartner.getMessage().getRoomId(), messageWithPartnerWithRoomWithReactions.getMessage().getId());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$4$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$5$0(int i10) {
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$6$0(Message it) {
        kotlin.jvm.internal.y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$7$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$0$8$0$0$0$5$0$8$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return k0.f43947a;
    }

    private static final void SearchScreen$lambda$0$goChatByRoomId(NavHostController navHostController, SearchViewModel searchViewModel, String str) {
        if (le.d0.q0(str)) {
            return;
        }
        int chatType = XMPPUtils.INSTANCE.getChatType(str);
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = searchViewModel.getGson().t(new ChatParams(str, chatType, null, 0, 12, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goChat(chatType, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    private static final void SearchScreen$lambda$0$goOnSpecificPosition(m0 m0Var, SearchViewModel searchViewModel, NavHostController navHostController, MutableState<Boolean> mutableState, String str, String str2) {
        if (le.d0.q0(str) || le.d0.q0(str2)) {
            return;
        }
        pe.k.d(m0Var, null, null, new SearchScreenKt$SearchScreen$1$goOnSpecificPosition$1(str, searchViewModel, str2, navHostController, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchScreen$lambda$1(NavHostController navHostController, SearchViewModel searchViewModel, int i10, int i11, Composer composer, int i12) {
        SearchScreen(navHostController, searchViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
