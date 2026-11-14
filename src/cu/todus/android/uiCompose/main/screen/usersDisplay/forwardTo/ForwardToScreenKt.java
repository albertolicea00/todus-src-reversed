package cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.data.db.pojo.UserCommon;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel;
import cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBarKt;
import cu.todus.android.uiCompose.shared.multipleList.MultipleListKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;
import va.g0;
import va.y0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u000b\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/usersDisplay/ContactsViewModel;", "viewModel", "Lua/k0;", "ForwardToScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/usersDisplay/ContactsViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "showFloatingActionBtn", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ForwardToScreenKt {
    /* JADX WARN: Code duplicated, block: B:58:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:64:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x0114  */
    /* JADX WARN: Code duplicated, block: B:70:0x0153  */
    /* JADX WARN: Code duplicated, block: B:73:0x0168  */
    /* JADX WARN: Code duplicated, block: B:76:0x017f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0192  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:85:0x0206  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r6v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ForwardToScreen(final NavHostController navHostController, final String params, ContactsViewModel contactsViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        ContactsViewModel contactsViewModel2;
        final ContactsViewModel contactsViewModel3;
        int i13;
        int i14;
        final ContactsViewModel contactsViewModel4;
        Object objRememberedValue;
        Composer.Companion companion;
        final SendToParams sendToParams;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        final SnapshotStateMap snapshotStateMap;
        Object objRememberedValue6;
        final MutableState mutableState;
        Object objRememberedValue7;
        y.i(navHostController, "navHostController");
        y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(-971313424);
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
                contactsViewModel2 = contactsViewModel;
                int i15 = composerStartRestartGroup.changedInstance(contactsViewModel2) ? 256 : 128;
                i12 |= i15;
            } else {
                contactsViewModel2 = contactsViewModel;
            }
            i12 |= i15;
        } else {
            contactsViewModel2 = contactsViewModel;
        }
        ?? r10 = 1;
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i13 = 0;
                    contactsViewModel2 = (ContactsViewModel) ViewModelKt.viewModel(z0.b(ContactsViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i12 &= -897;
                }
                ContactsViewModel contactsViewModel5 = contactsViewModel2;
                i14 = i12;
                contactsViewModel4 = contactsViewModel5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-971313424, i14, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen (ForwardToScreen.kt:56)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (SendToParams) contactsViewModel4.getGson().j(params, SendToParams.class);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                sendToParams = (SendToParams) objRememberedValue;
                if (sendToParams.getToSend().isEmpty()) {
                    navHostController.navigateUp();
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, i13, 3);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.recent((String) mutableState2.getValue()), null, composerStartRestartGroup, i13, r10);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.groupsAndChannels((String) mutableState2.getValue()), null, composerStartRestartGroup, i13, r10);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems3 = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.friendsOnDbNoHeaders((String) mutableState2.getValue()), null, composerStartRestartGroup, i13, r10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt.mutableStateMapOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                snapshotStateMap = (SnapshotStateMap) objRememberedValue5;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                mutableState = (MutableState) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.j
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(ForwardToScreenKt.ForwardToScreen$lambda$8$0(snapshotStateMap, mutableState));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final State state = (State) objRememberedValue7;
                boolean z10 = r10;
                final ContactsViewModel contactsViewModel6 = contactsViewModel4;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-300199620, r10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ForwardToScreenKt.ForwardToScreen$lambda$10(mutableState3, navHostController, mutableState2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, ForwardToScreen$lambda$9(state), ComposableLambdaKt.rememberComposableLambda(1902460520, z10, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.l
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ForwardToScreenKt.ForwardToScreen$lambda$11(navHostController, contactsViewModel4, mutableState, snapshotStateMap, sendToParams, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-1471539206, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.m
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ForwardToScreenKt.ForwardToScreen$lambda$12(contactsViewModel6, mutableState4, lazyPagingItemsCollectAsLazyPagingItems, lazyPagingItemsCollectAsLazyPagingItems2, lazyPagingItemsCollectAsLazyPagingItems3, snapshotStateMap, state, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805331382, 352);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contactsViewModel3 = contactsViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    ContactsViewModel contactsViewModel7 = contactsViewModel2;
                    i14 = i12 & (-897);
                    contactsViewModel4 = contactsViewModel7;
                    i13 = 0;
                    r10 = 1;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-971313424, i14, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen (ForwardToScreen.kt:56)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (SendToParams) contactsViewModel4.getGson().j(params, SendToParams.class);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                sendToParams = (SendToParams) objRememberedValue;
                if (sendToParams.getToSend().isEmpty()) {
                    navHostController.navigateUp();
                }
                ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, i13, 3);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue2;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems4 = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.recent((String) mutableState5.getValue()), null, composerStartRestartGroup, i13, r10);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems5 = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.groupsAndChannels((String) mutableState5.getValue()), null, composerStartRestartGroup, i13, r10);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems6 = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.friendsOnDbNoHeaders((String) mutableState5.getValue()), null, composerStartRestartGroup, i13, r10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState6 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState7 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt.mutableStateMapOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                snapshotStateMap = (SnapshotStateMap) objRememberedValue5;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                mutableState = (MutableState) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.j
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(ForwardToScreenKt.ForwardToScreen$lambda$8$0(snapshotStateMap, mutableState));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final State state2 = (State) objRememberedValue7;
                boolean z11 = r10;
                final ContactsViewModel contactsViewModel8 = contactsViewModel4;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-300199620, r10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ForwardToScreenKt.ForwardToScreen$lambda$10(mutableState6, navHostController, mutableState5, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, ForwardToScreen$lambda$9(state2), ComposableLambdaKt.rememberComposableLambda(1902460520, z11, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.l
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ForwardToScreenKt.ForwardToScreen$lambda$11(navHostController, contactsViewModel4, mutableState, snapshotStateMap, sendToParams, mutableState7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-1471539206, z11, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.m
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ForwardToScreenKt.ForwardToScreen$lambda$12(contactsViewModel8, mutableState7, lazyPagingItemsCollectAsLazyPagingItems4, lazyPagingItemsCollectAsLazyPagingItems5, lazyPagingItemsCollectAsLazyPagingItems6, snapshotStateMap, state2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805331382, 352);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contactsViewModel3 = contactsViewModel4;
            }
            i13 = 0;
            ContactsViewModel contactsViewModel9 = contactsViewModel2;
            i14 = i12;
            contactsViewModel4 = contactsViewModel9;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-971313424, i14, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen (ForwardToScreen.kt:56)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (SendToParams) contactsViewModel4.getGson().j(params, SendToParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            sendToParams = (SendToParams) objRememberedValue;
            if (sendToParams.getToSend().isEmpty()) {
                navHostController.navigateUp();
            }
            ScaffoldState scaffoldStateRememberScaffoldState3 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, i13, 3);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue2;
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems7 = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.recent((String) mutableState8.getValue()), null, composerStartRestartGroup, i13, r10);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems8 = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.groupsAndChannels((String) mutableState8.getValue()), null, composerStartRestartGroup, i13, r10);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems9 = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.friendsOnDbNoHeaders((String) mutableState8.getValue()), null, composerStartRestartGroup, i13, r10);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState9 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState10 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt.mutableStateMapOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            snapshotStateMap = (SnapshotStateMap) objRememberedValue5;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            mutableState = (MutableState) objRememberedValue6;
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.j
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(ForwardToScreenKt.ForwardToScreen$lambda$8$0(snapshotStateMap, mutableState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final State state3 = (State) objRememberedValue7;
            boolean z12 = r10;
            final ContactsViewModel contactsViewModel10 = contactsViewModel4;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-300199620, r10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ForwardToScreenKt.ForwardToScreen$lambda$10(mutableState9, navHostController, mutableState8, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, ForwardToScreen$lambda$9(state3), ComposableLambdaKt.rememberComposableLambda(1902460520, z12, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForwardToScreenKt.ForwardToScreen$lambda$11(navHostController, contactsViewModel4, mutableState, snapshotStateMap, sendToParams, mutableState10, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0L, scaffoldStateRememberScaffoldState3, null, ComposableLambdaKt.rememberComposableLambda(-1471539206, z12, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ForwardToScreenKt.ForwardToScreen$lambda$12(contactsViewModel10, mutableState10, lazyPagingItemsCollectAsLazyPagingItems7, lazyPagingItemsCollectAsLazyPagingItems8, lazyPagingItemsCollectAsLazyPagingItems9, snapshotStateMap, state3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805331382, 352);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contactsViewModel3 = contactsViewModel4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            contactsViewModel3 = contactsViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForwardToScreenKt.ForwardToScreen$lambda$13(navHostController, params, contactsViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ForwardToScreen$lambda$10(final MutableState mutableState, final NavHostController navHostController, final MutableState mutableState2, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-300199620, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen.<anonymous> (ForwardToScreen.kt:100)");
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer.startReplaceGroup(-1124920755);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.v
                        @Override // lb.a
                        public final Object invoke() {
                            return ForwardToScreenKt.ForwardToScreen$lambda$10$0$0(mutableState2, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.w
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ForwardToScreenKt.ForwardToScreen$lambda$10$1$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                SearchContactTopBarKt.SearchContactTopBar(navHostController, aVar, (Function1) objRememberedValue2, composer, 432);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1124516174);
                Function2 lambda$1341889331$app_productionPFast = ComposableSingletons$ForwardToScreenKt.INSTANCE.getLambda$1341889331$app_productionPFast();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(672487272, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ForwardToScreenKt.ForwardToScreen$lambda$10$2(mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.i
                        @Override // lb.a
                        public final Object invoke() {
                            return ForwardToScreenKt.ForwardToScreen$lambda$10$3$0(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$1341889331$app_productionPFast, null, false, composableLambdaRememberComposableLambda, false, navHostController, (lb.a) objRememberedValue3, null, 0L, 0L, Dp.m8823constructorimpl(0), composer, 3078, 6, 918);
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
    public static final k0 ForwardToScreen$lambda$10$0$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue("");
        mutableState2.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardToScreen$lambda$10$1$0(MutableState mutableState, String f10) {
        y.i(f10, "f");
        mutableState.setValue(f10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ForwardToScreen$lambda$10$2(final MutableState mutableState, RowScope Z17TopBar, Composer composer, int i10) {
        y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(672487272, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen.<anonymous>.<anonymous> (ForwardToScreen.kt:120)");
            }
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.s
                    @Override // lb.a
                    public final Object invoke() {
                        return ForwardToScreenKt.ForwardToScreen$lambda$10$2$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, ComposableSingletons$ForwardToScreenKt.INSTANCE.getLambda$13318534$app_productionPFast(), composer, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardToScreen$lambda$10$2$0$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardToScreen$lambda$10$3$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ForwardToScreen$lambda$11(final NavHostController navHostController, final ContactsViewModel contactsViewModel, final MutableState mutableState, final SnapshotStateMap snapshotStateMap, final SendToParams sendToParams, final MutableState mutableState2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1902460520, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen.<anonymous> (ForwardToScreen.kt:144)");
            }
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(contactsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.t
                    @Override // lb.a
                    public final Object invoke() {
                        return ForwardToScreenKt.ForwardToScreen$lambda$11$0$0(mutableState, snapshotStateMap, sendToParams, contactsViewModel, mutableState2, navHostController);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((lb.a) objRememberedValue, null, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, ComposableSingletons$ForwardToScreenKt.INSTANCE.getLambda$542428966$app_productionPFast(), composer, 12582912, 118);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardToScreen$lambda$11$0$0(MutableState mutableState, SnapshotStateMap snapshotStateMap, SendToParams sendToParams, ContactsViewModel contactsViewModel, MutableState mutableState2, NavHostController navHostController) {
        List<String> listO1;
        Object obj;
        Object next;
        String toSend;
        ForwardToScreen$lambda$5(mutableState2, true);
        if (mutableState.getValue() != null) {
            Object value = mutableState.getValue();
            y.f(value);
            listO1 = va.v.e(((RoomItemView) value).getRoom().getId());
        } else {
            ArrayList arrayList = new ArrayList(snapshotStateMap.size());
            Iterator it = snapshotStateMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Map.Entry) it.next()).getKey());
            }
            listO1 = g0.o1(arrayList);
        }
        Iterator<T> it2 = sendToParams.getToSend().iterator();
        do {
            obj = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (((Send) next).getType() != 9);
        if (next != null) {
            for (Object obj2 : sendToParams.getToSend()) {
                if (((Send) obj2).getType() == 9) {
                    obj = obj2;
                    break;
                }
            }
            Send send = (Send) obj;
            if (send == null || (toSend = send.getToSend()) == null) {
                toSend = "";
            }
            contactsViewModel.sendNewMessage(toSend, listO1, new ForwardToScreenKt$ForwardToScreen$2$1$1$3(snapshotStateMap, mutableState, navHostController, mutableState2));
        } else {
            contactsViewModel.sendForwards(listO1, sendToParams.getToSend(), new ForwardToScreenKt$ForwardToScreen$2$1$1$4(snapshotStateMap, mutableState, navHostController, mutableState2));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ForwardToScreen$lambda$11$0$0$onCompleted(SnapshotStateMap<String, String> snapshotStateMap, MutableState<RoomItemView> mutableState, NavHostController navHostController, MutableState<Boolean> mutableState2) {
        ForwardToScreen$lambda$5(mutableState2, false);
        snapshotStateMap.clear();
        mutableState.setValue(null);
        navHostController.navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ForwardToScreen$lambda$12(ContactsViewModel contactsViewModel, MutableState mutableState, LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, final SnapshotStateMap snapshotStateMap, State state, Modifier it, Composer composer, int i10) {
        int i11;
        Composer composer2 = composer;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer2.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer2.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1471539206, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen.<anonymous> (ForwardToScreen.kt:186)");
            }
            if (ForwardToScreen$lambda$4(mutableState)) {
                composer2.startReplaceGroup(-1104835641);
                LoadingScreenKt.LoadingWall(composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1104932636);
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getBottomEnd(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, it);
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
                Modifier.Companion companion3 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion.getStart(), composer2, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion3);
                lb.a constructor2 = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                AnimatedVisibilityKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, ForwardToScreen$lambda$9(state), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-906927701, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ForwardToScreenKt.ForwardToScreen$lambda$12$0$0$0(snapshotStateMap, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 1572870, 30);
                Object objRememberedValue = composer2.rememberedValue();
                Composer.Companion companion4 = Composer.INSTANCE;
                if (objRememberedValue == companion4.getEmpty()) {
                    objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ForwardToScreenKt.ForwardToScreen$lambda$12$0$0$1$0(snapshotStateMap, (UserCommon) obj, (RoomItemView) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function2 function2 = (Function2) objRememberedValue;
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == companion4.getEmpty()) {
                    objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.p
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ForwardToScreenKt.ForwardToScreen$lambda$12$0$0$2$0(snapshotStateMap, (UserCommon) obj, (RoomItemView) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function2 function3 = (Function2) objRememberedValue2;
                boolean z10 = !snapshotStateMap.isEmpty();
                Object objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == companion4.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(ForwardToScreenKt.ForwardToScreen$lambda$12$0$0$3$0(snapshotStateMap, (String) obj));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Function1 function1 = (Function1) objRememberedValue3;
                String nameWithDomain = contactsViewModel.owner().getNameWithDomain();
                int i12 = LazyPagingItems.$stable;
                MultipleListKt.MultipleList(companion3, lazyPagingItems, lazyPagingItems2, lazyPagingItems3, function2, function3, z10, function1, nameWithDomain, composer2, (i12 << 3) | 12804102 | (i12 << 6) | (i12 << 9));
                composer2 = composer2;
                composer2.endNode();
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composer2.changedInstance(contactsViewModel);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new ForwardToScreenKt$ForwardToScreen$3$2$1(contactsViewModel, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue4, composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ForwardToScreen$lambda$12$0$0$0(final SnapshotStateMap snapshotStateMap, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-906927701, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ForwardToScreen.kt:194)");
        }
        FlowLayoutKt.FlowRow(PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(20), 0.0f, 2, null), null, null, null, 0, 0, ComposableLambdaKt.rememberComposableLambda(760980710, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.u
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ForwardToScreenKt.ForwardToScreen$lambda$12$0$0$0$0(snapshotStateMap, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 1572870, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ForwardToScreen$lambda$12$0$0$0$0(final SnapshotStateMap snapshotStateMap, FlowRowScope FlowRow, Composer composer, int i10) {
        y.i(FlowRow, "$this$FlowRow");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(760980710, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardToScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ForwardToScreen.kt:198)");
            }
            Iterator it = snapshotStateMap.entrySet().iterator();
            while (it.hasNext()) {
                final Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getValue();
                boolean zChangedInstance = composer.changedInstance(entry);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.r
                        @Override // lb.a
                        public final Object invoke() {
                            return ForwardToScreenKt.ForwardToScreen$lambda$12$0$0$0$0$0$0$0(snapshotStateMap, entry);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ForwardChipKt.ForwardChip(str, (lb.a) objRememberedValue, composer, 0);
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
    public static final k0 ForwardToScreen$lambda$12$0$0$0$0$0$0$0(SnapshotStateMap snapshotStateMap, Map.Entry entry) {
        snapshotStateMap.remove(entry.getKey());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardToScreen$lambda$12$0$0$1$0(SnapshotStateMap snapshotStateMap, UserCommon userCommon, RoomItemView roomItemView) {
        if (userCommon != null) {
            if (snapshotStateMap.containsKey(userCommon.getId())) {
                snapshotStateMap.remove(userCommon.getId());
            } else if (snapshotStateMap.size() < 5) {
                snapshotStateMap.put(userCommon.getId(), userCommon.getName());
            }
        }
        if (roomItemView != null) {
            if (snapshotStateMap.containsKey(roomItemView.getId())) {
                snapshotStateMap.remove(roomItemView.getId());
            } else if (snapshotStateMap.size() < 5) {
                snapshotStateMap.put(roomItemView.getId(), roomItemView.getName());
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardToScreen$lambda$12$0$0$2$0(SnapshotStateMap snapshotStateMap, UserCommon userCommon, RoomItemView roomItemView) {
        if (userCommon != null) {
            if (snapshotStateMap.containsKey(userCommon.getId())) {
                snapshotStateMap.remove(userCommon.getId());
            } else if (snapshotStateMap.size() < 5) {
                snapshotStateMap.put(userCommon.getId(), userCommon.getName());
            }
        }
        if (roomItemView != null) {
            if (snapshotStateMap.containsKey(roomItemView.getId())) {
                snapshotStateMap.remove(roomItemView.getId());
            } else if (snapshotStateMap.size() < 5) {
                snapshotStateMap.put(roomItemView.getId(), roomItemView.getName());
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ForwardToScreen$lambda$12$0$0$3$0(SnapshotStateMap snapshotStateMap, String it) {
        y.i(it, "it");
        return snapshotStateMap.containsKey(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ForwardToScreen$lambda$13(NavHostController navHostController, String str, ContactsViewModel contactsViewModel, int i10, int i11, Composer composer, int i12) {
        ForwardToScreen(navHostController, str, contactsViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final boolean ForwardToScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ForwardToScreen$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ForwardToScreen$lambda$8$0(SnapshotStateMap snapshotStateMap, MutableState mutableState) {
        return (y0.C(snapshotStateMap).isEmpty() && mutableState.getValue() == null) ? false : true;
    }

    private static final boolean ForwardToScreen$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
