package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
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
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.ChannelSubscriber;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.xmpp.ChannelAdmin;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelAdminsParams;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModelFactory;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.l;
import defpackage.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.a0;
import le.d0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f²\u0006\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/chatPreview/previewChannel/PreviewChannelViewModel;", "viewModel", "Lua/k0;", "PreviewSubscribersScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chatPreview/previewChannel/PreviewChannelViewModel;Landroidx/compose/runtime/Composer;II)V", "", "Lcu/todus/android/data/xmpp/ChannelAdmin;", "adminsChannel", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PreviewSubscribersScreenKt {
    /* JADX WARN: Code duplicated, block: B:57:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:60:0x0107  */
    /* JADX WARN: Code duplicated, block: B:63:0x0113  */
    /* JADX WARN: Code duplicated, block: B:64:0x0117  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a2  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PreviewSubscribersScreen(final NavHostController navHostController, final String uid, PreviewChannelViewModel previewChannelViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final PreviewChannelViewModel previewChannelViewModel2;
        PreviewChannelViewModel previewChannelViewModel3;
        lb.a constructor;
        y.i(navHostController, "navHostController");
        y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1177525998);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(uid) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                previewChannelViewModel2 = previewChannelViewModel;
                int i13 = composerStartRestartGroup.changedInstance(previewChannelViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                previewChannelViewModel2 = previewChannelViewModel;
            }
            i12 |= i13;
        } else {
            previewChannelViewModel2 = previewChannelViewModel;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 147) != 146, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    PreviewChannelViewModelFactory previewChannelViewModelFactory = new PreviewChannelViewModelFactory(uid);
                    int i15 = i14 & 112;
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(PreviewChannelViewModel.class), current, uid, previewChannelViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, (i15 << 3) & 896, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    i14 &= -897;
                    previewChannelViewModel3 = (PreviewChannelViewModel) viewModel;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1177525998, i14, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.PreviewSubscribersScreen (PreviewSubscribersScreen.kt:38)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
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
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel3.getAdminsChannel(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                Composer composer2 = composerStartRestartGroup;
                final String strStringResource = StringResources_androidKt.stringResource(R.string.admin, composer2, 0);
                final PreviewChannelViewModel previewChannelViewModel4 = previewChannelViewModel3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-222511516, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$0$1(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-972959070, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$0$2(previewChannelViewModel4, lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle, uid, navHostController, strStringResource, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 805306806, 376);
                composerStartRestartGroup = composer2;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                previewChannelViewModel2 = previewChannelViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i14 &= -897;
                }
            }
            previewChannelViewModel3 = previewChannelViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1177525998, i14, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.PreviewSubscribersScreen (PreviewSubscribersScreen.kt:38)");
            }
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            constructor = companion4.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            final LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel3.getAdminsChannel(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            Composer composer3 = composerStartRestartGroup;
            final String strStringResource2 = StringResources_androidKt.stringResource(R.string.admin, composer3, 0);
            final PreviewChannelViewModel previewChannelViewModel5 = previewChannelViewModel3;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-222511516, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$0$1(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-972959070, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$0$2(previewChannelViewModel5, lazyListStateRememberLazyListState2, stateCollectAsStateWithLifecycle2, uid, navHostController, strStringResource2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer3, 805306806, 376);
            composerStartRestartGroup = composer3;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            previewChannelViewModel2 = previewChannelViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$1(navHostController, uid, previewChannelViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<ChannelAdmin> PreviewSubscribersScreen$lambda$0$0(State<? extends List<ChannelAdmin>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewSubscribersScreen$lambda$0$1(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-222511516, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.PreviewSubscribersScreen.<anonymous>.<anonymous> (PreviewSubscribersScreen.kt:53)");
            }
            Function2 lambda$553133687$app_productionPFast = ComposableSingletons$PreviewSubscribersScreenKt.INSTANCE.getLambda$553133687$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.c
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$0$1$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$553133687$app_productionPFast, it, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, ((i11 << 3) & 112) | 6, 0, 1948);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewSubscribersScreen$lambda$0$1$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewSubscribersScreen$lambda$0$2(final PreviewChannelViewModel previewChannelViewModel, LazyListState lazyListState, final State state, final String str, final NavHostController navHostController, final String str2, Modifier it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-972959070, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.PreviewSubscribersScreen.<anonymous>.<anonymous> (PreviewSubscribersScreen.kt:68)");
            }
            LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(previewChannelViewModel.getSubscribers(), null, composer, 0, 1);
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(it, 0.0f, 1, null);
            String nameWithDomain = previewChannelViewModel.owner().getNameWithDomain();
            boolean zChanged = composer.changed(state) | composer.changed(str) | composer.changedInstance(navHostController) | composer.changedInstance(previewChannelViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$0$2$0$0(str, navHostController, previewChannelViewModel, state, (ChannelSubscriber) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$0$2$1$0((ChannelSubscriber) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            Function2 lambda$1074747132$app_productionPFast = ComposableSingletons$PreviewSubscribersScreenKt.INSTANCE.getLambda$1074747132$app_productionPFast();
            boolean zChanged2 = composer.changed(state) | composer.changed(str2);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewSubscribersScreenKt.PreviewSubscribersScreen$lambda$0$2$2$0(str2, state, (ChannelSubscriber) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            UserCommonListKt.UserCommonList(modifierFillMaxHeight$default, lazyListState, lazyPagingItemsCollectAsLazyPagingItems, function1, function2, lambda$1074747132$app_productionPFast, nameWithDomain, (Function1) objRememberedValue3, null, composer, (LazyPagingItems.$stable << 6) | 221184, 256);
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composer.changedInstance(previewChannelViewModel) | composer.changed(str);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new PreviewSubscribersScreenKt$PreviewSubscribersScreen$1$2$4$1(previewChannelViewModel, str, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue4, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewSubscribersScreen$lambda$0$2$0$0(String str, NavHostController navHostController, PreviewChannelViewModel previewChannelViewModel, State state, ChannelSubscriber userCommon) {
        Object next;
        List listN;
        String rights;
        y.i(userCommon, "userCommon");
        Iterator<T> it = PreviewSubscribersScreen$lambda$0$0(state).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!y.d(a0.O(((ChannelAdmin) next).getId(), "@im.todus.cu", "", false, 4, null), a0.O(userCommon.getId(), "@im.todus.cu", "", false, 4, null)));
        ChannelAdmin channelAdmin = (ChannelAdmin) next;
        Partner partner = userCommon.getPartner();
        if (channelAdmin == null || (rights = channelAdmin.getRights()) == null || (listN = d0.S0(rights, new String[]{","}, false, 0, 6, null)) == null) {
            listN = w.n();
        }
        PreviewChannelAdminsParams previewChannelAdminsParams = new PreviewChannelAdminsParams(str, partner, listN);
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = previewChannelViewModel.getGson().t(previewChannelAdminsParams);
        y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goPreviewAdminChannel(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewSubscribersScreen$lambda$0$2$1$0(ChannelSubscriber it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0041 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0042 A[RETURN] */
    public static final String PreviewSubscribersScreen$lambda$0$2$2$0(String str, State state, ChannelSubscriber channelSubscriber) {
        Object objO;
        Object next;
        String strO;
        String id2;
        Iterator<T> it = PreviewSubscribersScreen$lambda$0$0(state).iterator();
        do {
            objO = null;
            if (it.hasNext()) {
                next = it.next();
                strO = a0.O(((ChannelAdmin) next).getId(), "@im.todus.cu", "", false, 4, null);
                if (channelSubscriber != null && (id2 = channelSubscriber.getId()) != null) {
                    objO = a0.O(id2, "@im.todus.cu", "", false, 4, null);
                }
            }
            if (objO != null) {
                return str;
            }
            return "";
        } while (!y.d(strO, objO));
        objO = next;
        if (objO != null) {
            return str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewSubscribersScreen$lambda$1(NavHostController navHostController, String str, PreviewChannelViewModel previewChannelViewModel, int i10, int i11, Composer composer, int i12) {
        PreviewSubscribersScreen(navHostController, str, previewChannelViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
