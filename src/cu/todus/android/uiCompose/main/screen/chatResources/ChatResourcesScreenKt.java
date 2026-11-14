package cu.todus.android.uiCompose.main.screen.chatResources;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TabRowKt;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewKt;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewState;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.content.ImageContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.LinksContentKt;
import cu.todus.android.uiCompose.main.screen.chat.item.content.VideoContentKt;
import cu.todus.android.uiCompose.shared.animations.attach.AttachContainerKt;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.tab.Z17TabKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r²\u0006\u0010\u0010\n\u001a\u0004\u0018\u00010\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/chatResources/ChatResourcesViewModel;", "viewModel", "Lua/k0;", "ChatResourcesScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chatResources/ChatResourcesViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "attachmentPreview", "", "tabIndex", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatResourcesScreenKt {
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:61:0x0115  */
    /* JADX WARN: Code duplicated, block: B:64:0x0159  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ChatResourcesScreen(final NavHostController navHostController, final String uid, ChatResourcesViewModel chatResourcesViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final ChatResourcesViewModel chatResourcesViewModel2;
        int i13;
        Object objRememberedValue;
        int i14;
        ChatResourcesViewModel chatResourcesViewModel3 = chatResourcesViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(1554675937);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(uid) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) != 0) {
                i14 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(chatResourcesViewModel3) : composerStartRestartGroup.changedInstance(chatResourcesViewModel3)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
            }
            i12 |= i14;
        }
        int i15 = i12;
        if (composerStartRestartGroup.shouldExecute((i15 & 147) != 146, i15 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i15 &= -897;
                    i13 = 0;
                    chatResourcesViewModel3 = (ChatResourcesViewModel) ViewModelKt.viewModel(z0.b(ChatResourcesViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1554675937, i15, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen (ChatResourcesScreen.kt:64)");
                }
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, i13, 3);
                final LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(i13, i13, composerStartRestartGroup, i13, 3);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(chatResourcesViewModel3.images(uid), null, composerStartRestartGroup, i13, 1);
                final LazyGridState lazyGridStateRememberLazyGridState2 = LazyGridStateKt.rememberLazyGridState(i13, i13, composerStartRestartGroup, i13, 3);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(chatResourcesViewModel3.videos(uid), null, composerStartRestartGroup, i13, 1);
                final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(i13, i13, composerStartRestartGroup, i13, 3);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems3 = LazyPagingItemsKt.collectAsLazyPagingItems(chatResourcesViewModel3.links(uid), null, composerStartRestartGroup, i13, 1);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                final ChatResourcesViewModel chatResourcesViewModel4 = chatResourcesViewModel3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-304556755, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.w
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatResourcesScreenKt.ChatResourcesScreen$lambda$3(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-777384725, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.x
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4(lazyGridStateRememberLazyGridState, lazyPagingItemsCollectAsLazyPagingItems, lazyGridStateRememberLazyGridState2, lazyPagingItemsCollectAsLazyPagingItems2, lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems3, context, mutableState, chatResourcesViewModel4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chatResourcesViewModel2 = chatResourcesViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i15 &= -897;
                }
            }
            i13 = 0;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1554675937, i15, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen (ChatResourcesScreen.kt:64)");
            }
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, i13, 3);
            final LazyGridState lazyGridStateRememberLazyGridState3 = LazyGridStateKt.rememberLazyGridState(i13, i13, composerStartRestartGroup, i13, 3);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems4 = LazyPagingItemsKt.collectAsLazyPagingItems(chatResourcesViewModel3.images(uid), null, composerStartRestartGroup, i13, 1);
            final LazyGridState lazyGridStateRememberLazyGridState4 = LazyGridStateKt.rememberLazyGridState(i13, i13, composerStartRestartGroup, i13, 3);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems5 = LazyPagingItemsKt.collectAsLazyPagingItems(chatResourcesViewModel3.videos(uid), null, composerStartRestartGroup, i13, 1);
            final LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(i13, i13, composerStartRestartGroup, i13, 3);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems6 = LazyPagingItemsKt.collectAsLazyPagingItems(chatResourcesViewModel3.links(uid), null, composerStartRestartGroup, i13, 1);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            final ChatResourcesViewModel chatResourcesViewModel5 = chatResourcesViewModel3;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-304556755, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChatResourcesScreenKt.ChatResourcesScreen$lambda$3(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-777384725, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.x
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4(lazyGridStateRememberLazyGridState3, lazyPagingItemsCollectAsLazyPagingItems4, lazyGridStateRememberLazyGridState4, lazyPagingItemsCollectAsLazyPagingItems5, lazyListStateRememberLazyListState2, lazyPagingItemsCollectAsLazyPagingItems6, context2, mutableState2, chatResourcesViewModel5, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            chatResourcesViewModel2 = chatResourcesViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            chatResourcesViewModel2 = chatResourcesViewModel3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatResourcesScreenKt.ChatResourcesScreen$lambda$5(navHostController, uid, chatResourcesViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final AttachmentPreviewState ChatResourcesScreen$lambda$1(MutableState<AttachmentPreviewState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatResourcesScreen$lambda$3(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-304556755, i11, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous> (ChatResourcesScreen.kt:95)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$ChatResourcesScreenKt.INSTANCE.getLambda$1659847680$app_productionPFast(), it, false, null, false, navHostController, null, null, 0L, 0L, Dp.m8823constructorimpl(0), composer, ((i11 << 3) & 112) | 6, 6, 988);
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
    public static final k0 ChatResourcesScreen$lambda$4(LazyGridState lazyGridState, final LazyPagingItems lazyPagingItems, LazyGridState lazyGridState2, final LazyPagingItems lazyPagingItems2, LazyListState lazyListState, final LazyPagingItems lazyPagingItems3, final Context context, final MutableState mutableState, final ChatResourcesViewModel chatResourcesViewModel, Modifier it, Composer composer, int i10) {
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(it, "it");
        if (composer2.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777384725, i10, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous> (ChatResourcesScreen.kt:108)");
            }
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composer2.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            final List listQ = va.w.q(StringResources_androidKt.stringResource(R.string.images, composer2, 0), StringResources_androidKt.stringResource(R.string.videos, composer2, 0), StringResources_androidKt.stringResource(R.string.links, composer2, 0));
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TabRowKt.m3761TabRowpAZo6Ak(mutableIntState.getIntValue(), BackgroundKt.m1205backgroundbw27NRU$default(PaddingKt.m1729paddingqDBjuR0$default(companion2, 0.0f, Dp.m8823constructorimpl(5), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null), 0L, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-332187747, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$0(listQ, mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, 1572864, 60);
            int intValue = mutableIntState.getIntValue();
            if (intValue == 0) {
                composer2.startReplaceGroup(329421034);
                GridCells.Adaptive adaptive = new GridCells.Adaptive(Dp.m8823constructorimpl(100), null);
                boolean zChangedInstance = composer2.changedInstance(lazyPagingItems);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$1$0(lazyPagingItems, mutableState, (LazyGridScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                LazyGridDslKt.LazyVerticalGrid(adaptive, null, lazyGridState, null, false, null, null, null, false, null, (Function1) objRememberedValue2, composer, 0, 0, 1018);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else if (intValue == 1) {
                composer2.startReplaceGroup(331740330);
                GridCells.Adaptive adaptive2 = new GridCells.Adaptive(Dp.m8823constructorimpl(100), null);
                boolean zChangedInstance2 = composer2.changedInstance(lazyPagingItems2);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$2$0(lazyPagingItems2, mutableState, (LazyGridScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                LazyGridDslKt.LazyVerticalGrid(adaptive2, null, lazyGridState2, null, false, null, null, null, false, null, (Function1) objRememberedValue3, composer, 0, 0, 1018);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else if (intValue != 2) {
                composer2.startReplaceGroup(337124813);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(334065516);
                boolean zChangedInstance3 = composer2.changedInstance(lazyPagingItems3) | composer2.changedInstance(context);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$3$0(lazyPagingItems3, context, (LazyListScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                LazyDslKt.LazyColumn(null, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue4, composer, 0, 509);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            AttachContainerKt.AnimateContainer(null, ChatResourcesScreen$lambda$1(mutableState) != null, ComposableLambdaKt.rememberComposableLambda(2045462236, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$4(mutableState, chatResourcesViewModel, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
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
    public static final k0 ChatResourcesScreen$lambda$4$3$0(List list, final MutableIntState mutableIntState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-332187747, i10, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous>.<anonymous>.<anonymous> (ChatResourcesScreen.kt:124)");
            }
            final int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    va.w.x();
                }
                String str = (String) list.get(i11);
                boolean z10 = mutableIntState.getIntValue() == i11;
                boolean zChanged = composer.changed(i11);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.d
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$0$0$0$0(i11, mutableIntState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Z17TabKt.Z17Tab((lb.a) objRememberedValue, z10, str, composer, 0);
                i11 = i12;
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
    public static final k0 ChatResourcesScreen$lambda$4$3$0$0$0$0(int i10, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatResourcesScreen$lambda$4$3$1$0(final LazyPagingItems lazyPagingItems, final MutableState mutableState, LazyGridScope LazyVerticalGrid) {
        kotlin.jvm.internal.y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.CC.b(LazyVerticalGrid, lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$1$0$0((Attachment) obj);
            }
        }), null, LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$1$0$1((Attachment) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(1013115608, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.g
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$1$0$2(lazyPagingItems, mutableState, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        LazyGridScope.CC.a(LazyVerticalGrid, null, null, null, ComposableLambdaKt.composableLambdaInstance(1976998257, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.h
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$1$0$3(lazyPagingItems, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 7, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ChatResourcesScreen$lambda$4$3$1$0$0(Attachment a10) {
        kotlin.jvm.internal.y.i(a10, "a");
        return a10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ChatResourcesScreen$lambda$4$3$1$0$1(Attachment i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return "images";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatResourcesScreen$lambda$4$3$1$0$2(LazyPagingItems lazyPagingItems, final MutableState mutableState, LazyGridItemScope items, int i10, Composer composer, int i11) {
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
                ComposerKt.traceEventStart(1013115608, i12, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatResourcesScreen.kt:146)");
            }
            final Attachment attachment = (Attachment) lazyPagingItems.get(i10);
            if (attachment != null) {
                composer.startReplaceGroup(992038234);
                if ((attachment.getContent() instanceof ImageContent) && new File(((ImageContent) attachment.getContent()).getPath()).exists()) {
                    composer.startReplaceGroup(-1353467778);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    boolean zChanged = composer.changed(attachment);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.i
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$1$0$2$0$0(attachment, mutableState);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxSize$default(PaddingKt.m1725padding3ABfNKs(androidx.compose.foundation.lazy.grid.s.a(items, ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), null, null, null, 2, null), Dp.m8823constructorimpl(2)), 0.0f, 1, null), 1.0f, false, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAspectRatio$default);
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
                    ImageContentKt.ImageShowIn(true, Uri.parse(((ImageContent) attachment.getContent()).getPath()), (ImageContent) attachment.getContent(), composer, 6);
                    composer.endNode();
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(993223178);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1353432481);
                Z17ShimmerLoaderKt.Z17Shimmer(androidx.compose.foundation.lazy.grid.s.a(items, SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(100)), null, null, null, 2, null), composer, 0);
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
    public static final k0 ChatResourcesScreen$lambda$4$3$1$0$2$0$0(Attachment attachment, MutableState mutableState) {
        ChatResourcesScreen$openAttachmentPreview(mutableState, attachment.getId(), attachment.getMsg());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 ChatResourcesScreen$lambda$4$3$1$0$3(LazyPagingItems lazyPagingItems, LazyGridItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1976998257, i10, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatResourcesScreen.kt:177)");
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
    public static final k0 ChatResourcesScreen$lambda$4$3$2$0(final LazyPagingItems lazyPagingItems, final MutableState mutableState, LazyGridScope LazyVerticalGrid) {
        kotlin.jvm.internal.y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.CC.b(LazyVerticalGrid, lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$2$0$0((Attachment) obj);
            }
        }), null, LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$2$0$1((Attachment) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(204985679, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.q
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$2$0$2(lazyPagingItems, mutableState, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        LazyGridScope.CC.a(LazyVerticalGrid, null, null, null, ComposableLambdaKt.composableLambdaInstance(-1216724568, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.r
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$2$0$3(lazyPagingItems, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 7, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ChatResourcesScreen$lambda$4$3$2$0$0(Attachment a10) {
        kotlin.jvm.internal.y.i(a10, "a");
        return a10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ChatResourcesScreen$lambda$4$3$2$0$1(Attachment i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return "videos";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatResourcesScreen$lambda$4$3$2$0$2(LazyPagingItems lazyPagingItems, final MutableState mutableState, LazyGridItemScope items, int i10, Composer composer, int i11) {
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
                ComposerKt.traceEventStart(204985679, i12, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatResourcesScreen.kt:194)");
            }
            final Attachment attachment = (Attachment) lazyPagingItems.get(i10);
            if (attachment != null) {
                composer.startReplaceGroup(-714982525);
                if ((attachment.getContent() instanceof VideoContent) && new File(((VideoContent) attachment.getContent()).getPath()).exists()) {
                    composer.startReplaceGroup(-577248971);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    boolean zChanged = composer.changed(attachment);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.c
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$2$0$2$0$0(attachment, mutableState);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxSize$default(PaddingKt.m1725padding3ABfNKs(androidx.compose.foundation.lazy.grid.s.a(items, ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), null, null, null, 2, null), Dp.m8823constructorimpl(2)), 0.0f, 1, null), 1.0f, false, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAspectRatio$default);
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
                    VideoContentKt.VideoShowIn(true, Uri.parse(((VideoContent) attachment.getContent()).getPath()), (VideoContent) attachment.getContent(), composer, 6);
                    composer.endNode();
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-713797581);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-577213674);
                Z17ShimmerLoaderKt.Z17Shimmer(androidx.compose.foundation.lazy.grid.s.a(items, SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(100)), null, null, null, 2, null), composer, 0);
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
    public static final k0 ChatResourcesScreen$lambda$4$3$2$0$2$0$0(Attachment attachment, MutableState mutableState) {
        ChatResourcesScreen$openAttachmentPreview(mutableState, attachment.getId(), attachment.getMsg());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 ChatResourcesScreen$lambda$4$3$2$0$3(LazyPagingItems lazyPagingItems, LazyGridItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1216724568, i10, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatResourcesScreen.kt:225)");
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
    public static final k0 ChatResourcesScreen$lambda$4$3$3$0(final LazyPagingItems lazyPagingItems, final Context context, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$3$0$0((Attachment) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$3$0$1((Attachment) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-540380521, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.m
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$3$0$2(lazyPagingItems, context, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-366604032, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.n
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$3$0$3(lazyPagingItems, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ChatResourcesScreen$lambda$4$3$3$0$0(Attachment a10) {
        kotlin.jvm.internal.y.i(a10, "a");
        return a10.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ChatResourcesScreen$lambda$4$3$3$0$1(Attachment i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return "links";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatResourcesScreen$lambda$4$3$3$0$2(LazyPagingItems lazyPagingItems, final Context context, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        LinkEntity linkEntity;
        String title;
        String description;
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
                ComposerKt.traceEventStart(-540380521, i12, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatResourcesScreen.kt:241)");
            }
            Attachment attachment = (Attachment) lazyPagingItems.get(i10);
            if (attachment != null) {
                composer.startReplaceGroup(-938536170);
                if ((attachment.getContent() instanceof LinkInfoContent) && ((LinkInfoContent) attachment.getContent()).getDownloadedInfo() && (linkEntity = ((LinkInfoContent) attachment.getContent()).getLinkEntity()) != null && (title = linkEntity.getTitle()) != null && (!le.d0.q0(title)) && (description = ((LinkInfoContent) attachment.getContent()).getLinkEntity().getDescription()) != null && (!le.d0.q0(description))) {
                    composer.startReplaceGroup(385374511);
                    Modifier modifierC = androidx.compose.foundation.lazy.g.c(items, PaddingKt.m1726paddingVpY3zN4(Modifier.INSTANCE, Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(2)), null, null, null, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierC);
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    LinkInfoContent linkInfoContent = (LinkInfoContent) attachment.getContent();
                    boolean zChangedInstance = composer.changedInstance(context);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.s
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$3$3$0$2$0$0$0(context, (MessageAction) obj, (String) obj2);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    LinksContentKt.LinkShowIn(linkInfoContent, (Function2) objRememberedValue, composer, 0);
                    composer.endNode();
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-937623189);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-937542775);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifierC2 = androidx.compose.foundation.lazy.g.c(items, SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), null, null, null, 2, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composer, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierC2);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
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
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), composer, 0);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion2);
                lb.a constructor3 = companion4.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(70)), composer, 6);
                Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(10)), 0.0f, 1, null), composer, 6);
                composer.endNode();
                float f10 = 5;
                float f11 = 2;
                Z17ShimmerLoaderKt.Z17Shimmer(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), 0.0f, 1, null), Dp.m8823constructorimpl(f11)), composer, 6);
                Z17ShimmerLoaderKt.Z17Shimmer(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), 0.0f, 1, null), Dp.m8823constructorimpl(f11)), composer, 6);
                composer.endNode();
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
    public static final k0 ChatResourcesScreen$lambda$4$3$3$0$2$0$0$0(Context context, MessageAction messageAction, String value) {
        kotlin.jvm.internal.y.i(messageAction, "<unused var>");
        kotlin.jvm.internal.y.i(value, "value");
        IntentUtil.INSTANCE.showWeb(context, value);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 ChatResourcesScreen$lambda$4$3$3$0$3(LazyPagingItems lazyPagingItems, LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-366604032, i10, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatResourcesScreen.kt:290)");
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
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatResourcesScreen$lambda$4$4(final MutableState mutableState, final ChatResourcesViewModel chatResourcesViewModel, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2045462236, i10, -1, "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesScreen.<anonymous>.<anonymous> (ChatResourcesScreen.kt:303)");
            }
            AttachmentPreviewState attachmentPreviewStateChatResourcesScreen$lambda$1 = ChatResourcesScreen$lambda$1(mutableState);
            if (attachmentPreviewStateChatResourcesScreen$lambda$1 == null) {
                composer.startReplaceGroup(-630479354);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-630479353);
                boolean zChangedInstance = composer.changedInstance(chatResourcesViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.z
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$4$0$0$0(chatResourcesViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.a0
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$4$0$1$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar = (lb.a) objRememberedValue2;
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatResourcesScreenKt.ChatResourcesScreen$lambda$4$4$0$2$0((String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                AttachmentPreviewKt.AttachmentPreviewWithOptions(attachmentPreviewStateChatResourcesScreen$lambda$1, function1, aVar, (Function1) objRememberedValue3, null, composer, 3456, 16);
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
    public static final k0 ChatResourcesScreen$lambda$4$4$0$0$0(ChatResourcesViewModel chatResourcesViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatResourcesViewModel.share(va.v.e(it));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatResourcesScreen$lambda$4$4$0$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatResourcesScreen$lambda$4$4$0$2$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatResourcesScreen$lambda$5(NavHostController navHostController, String str, ChatResourcesViewModel chatResourcesViewModel, int i10, int i11, Composer composer, int i12) {
        ChatResourcesScreen(navHostController, str, chatResourcesViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final void ChatResourcesScreen$openAttachmentPreview(MutableState<AttachmentPreviewState> mutableState, String str, String str2) {
        mutableState.setValue(new AttachmentPreviewState(va.v.e(str), true, str2, false));
    }
}
