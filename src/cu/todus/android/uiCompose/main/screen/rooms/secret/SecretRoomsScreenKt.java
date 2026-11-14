package cu.todus.android.uiCompose.main.screen.rooms.secret;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
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
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel;
import cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItemKt;
import cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsActionsTopBarKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.xmpp.XMPPUtils;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.d0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/rooms/RoomViewModel;", "viewModel", "Lua/k0;", "SecretRoomsScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/rooms/RoomViewModel;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SecretRoomsScreenKt {
    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:61:0x015a  */
    /* JADX WARN: Code duplicated, block: B:64:0x0170  */
    /* JADX WARN: Code duplicated, block: B:69:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e5  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"InlinedApi"})
    public static final void SecretRoomsScreen(final NavHostController navHostController, RoomViewModel roomViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        lb.a constructor;
        c1.a aVarC;
        final Context context;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        boolean zChanged;
        Object objRememberedValue3;
        int i13;
        final RoomViewModel roomViewModel2 = roomViewModel;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1905393243);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i13 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(roomViewModel2) : composerStartRestartGroup.changedInstance(roomViewModel2)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
            }
            i12 |= i13;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 2) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    roomViewModel2 = (RoomViewModel) ViewModelKt.viewModel(z0.b(RoomViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i12 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1905393243, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.SecretRoomsScreen (SecretRoomsScreen.kt:59)");
                }
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r10);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, r10));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                aVarC = c1.d.c(w.g("android.permission.POST_NOTIFICATIONS"), null, composerStartRestartGroup, r10, 2);
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(r10, r10, composerStartRestartGroup, r10, 3);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(roomViewModel2.getSecretRooms(), null, composerStartRestartGroup, r10, 1);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue2;
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(649712659, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.i
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$2(snapshotStateList, navHostController, roomViewModel2, mutableState, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                final RoomViewModel roomViewModel3 = roomViewModel2;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-1875890667, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3(lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems, roomViewModel3, navHostController, context, mutableState, snapshotStateList, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                composerStartRestartGroup = composerStartRestartGroup;
                k0 k0Var = k0.f43947a;
                zChanged = composerStartRestartGroup.changed(aVarC) | composerStartRestartGroup.changedInstance(context);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new SecretRoomsScreenKt$SecretRoomsScreen$1$3$1(aVarC, context, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue3, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                roomViewModel2 = roomViewModel3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1905393243, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.SecretRoomsScreen (SecretRoomsScreen.kt:59)");
            }
            Modifier.Companion companion4 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r10);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, r10));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            constructor = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            aVarC = c1.d.c(w.g("android.permission.POST_NOTIFICATIONS"), null, composerStartRestartGroup, r10, 2);
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(r10, r10, composerStartRestartGroup, r10, 3);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(roomViewModel2.getSecretRooms(), null, composerStartRestartGroup, r10, 1);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final SnapshotStateList snapshotStateList2 = (SnapshotStateList) objRememberedValue2;
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(649712659, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$2(snapshotStateList2, navHostController, roomViewModel2, mutableState2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            final RoomViewModel roomViewModel4 = roomViewModel2;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda2, false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-1875890667, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3(lazyListStateRememberLazyListState2, lazyPagingItemsCollectAsLazyPagingItems2, roomViewModel4, navHostController, context, mutableState2, snapshotStateList2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            composerStartRestartGroup = composerStartRestartGroup;
            k0 k0Var2 = k0.f43947a;
            zChanged = composerStartRestartGroup.changed(aVarC) | composerStartRestartGroup.changedInstance(context);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new SecretRoomsScreenKt$SecretRoomsScreen$1$3$1(aVarC, context, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new SecretRoomsScreenKt$SecretRoomsScreen$1$3$1(aVarC, context, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue3, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            roomViewModel2 = roomViewModel4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SecretRoomsScreenKt.SecretRoomsScreen$lambda$1(navHostController, roomViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SecretRoomsScreen$lambda$0$2(final SnapshotStateList snapshotStateList, final NavHostController navHostController, final RoomViewModel roomViewModel, final MutableState mutableState, TopAppBarScrollBehavior it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        boolean z10 = false;
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(649712659, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.SecretRoomsScreen.<anonymous>.<anonymous> (SecretRoomsScreen.kt:88)");
            }
            if (snapshotStateList.isEmpty()) {
                composer.startReplaceGroup(1603630921);
                Function2 lambda$1952694652$app_productionPFast = ComposableSingletons$SecretRoomsScreenKt.INSTANCE.getLambda$1952694652$app_productionPFast();
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.e
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$2$4$0(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$1952694652$app_productionPFast, it, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, ((i11 << 3) & 112) | 6, 0, 1948);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1827710725);
                int size = snapshotStateList.size();
                if (!snapshotStateList.isEmpty()) {
                    Iterator<T> it2 = snapshotStateList.iterator();
                    while (it2.hasNext()) {
                        if (XMPPUtils.INSTANCE.isChannel((String) it2.next())) {
                            z10 = true;
                            break;
                        }
                    }
                }
                boolean z11 = !z10;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.s
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$2$1$0(snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar = (lb.a) objRememberedValue2;
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.t
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$2$2$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                lb.a aVar2 = (lb.a) objRememberedValue3;
                boolean zChangedInstance2 = composer.changedInstance(roomViewModel);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.u
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$2$3$0(roomViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                RoomsActionsTopBarKt.RoomsActionsTopBar(navHostController, size, null, aVar, z11, aVar2, null, (lb.a) objRememberedValue4, composer, 200064, 64);
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
    public static final k0 SecretRoomsScreen$lambda$0$2$1$0(SnapshotStateList snapshotStateList) {
        snapshotStateList.clear();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$0$2$2$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$0$2$3$0(RoomViewModel roomViewModel, SnapshotStateList snapshotStateList) {
        roomViewModel.togglePin((String) snapshotStateList.get(0));
        snapshotStateList.clear();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$0$2$4$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SecretRoomsScreen$lambda$0$3(LazyListState lazyListState, final LazyPagingItems lazyPagingItems, final RoomViewModel roomViewModel, final NavHostController navHostController, final Context context, final MutableState mutableState, final SnapshotStateList snapshotStateList, Modifier it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1875890667, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.SecretRoomsScreen.<anonymous>.<anonymous> (SecretRoomsScreen.kt:122)");
            }
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(it, 0.0f, 1, null);
            boolean zChangedInstance = composer.changedInstance(lazyPagingItems) | composer.changedInstance(roomViewModel) | composer.changedInstance(navHostController) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0(lazyPagingItems, snapshotStateList, roomViewModel, navHostController, context, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue = function1;
            }
            LazyDslKt.LazyColumn(modifierFillMaxHeight$default, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
            String strStringResource = StringResources_androidKt.stringResource(R.string.clear_all_histories_question, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.this_action_cant_be_undone, composer, 0);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.ok, composer, 0);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.no, composer, 0);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.q
                    @Override // lb.a
                    public final Object invoke() {
                        return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$1$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            boolean zChangedInstance2 = composer.changedInstance(r3);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.r
                    @Override // lb.a
                    public final Object invoke() {
                        return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$2$0(snapshotStateList, roomViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Z17DialogsKt.Z17DialogWithActions(zBooleanValue, aVar, (lb.a) objRememberedValue3, null, strStringResource, strStringResource2, strStringResource3, strStringResource4, composer, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$0$3$0$0(final LazyPagingItems lazyPagingItems, final SnapshotStateList snapshotStateList, final RoomViewModel roomViewModel, final NavHostController navHostController, final Context context, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$SecretRoomsScreenKt composableSingletons$SecretRoomsScreenKt = ComposableSingletons$SecretRoomsScreenKt.INSTANCE;
        LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$SecretRoomsScreenKt.getLambda$1763974442$app_productionPFast(), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0$0((RoomItemView) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0$1((RoomItemView) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-705254989, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.n
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0$2(lazyPagingItems, snapshotStateList, roomViewModel, navHostController, context, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-77672415, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.o
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0$3(lazyPagingItems, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$SecretRoomsScreenKt.m9971getLambda$401680798$app_productionPFast(), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SecretRoomsScreen$lambda$0$3$0$0$0(RoomItemView r10) {
        y.i(r10, "r");
        return r10.getIdOnList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SecretRoomsScreen$lambda$0$3$0$0$1(RoomItemView i10) {
        y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SecretRoomsScreen$lambda$0$3$0$0$2(LazyPagingItems lazyPagingItems, final SnapshotStateList snapshotStateList, final RoomViewModel roomViewModel, final NavHostController navHostController, Context context, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        long tertiary;
        Message message;
        y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        boolean z10 = false;
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-705254989, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.SecretRoomsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecretRoomsScreen.kt:135)");
            }
            final RoomItemView roomItemView = (RoomItemView) lazyPagingItems.get(i10);
            if (roomItemView == null) {
                composer.startReplaceGroup(728854431);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(728854432);
                float f10 = 3;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 2, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f10), 0.0f, Dp.m8823constructorimpl(f10), 4, null);
                if (snapshotStateList.contains(roomItemView.getRoom().getId())) {
                    composer.startReplaceGroup(1364272607);
                    tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary();
                } else {
                    composer.startReplaceGroup(1364271265);
                    tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground();
                }
                composer.endReplaceGroup();
                float f11 = 15;
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1729paddingqDBjuR0$default, tertiary, RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f11), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 6, null));
                boolean zChanged = composer.changed(roomItemView);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.f
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0$2$0$0$0(snapshotStateList, roomItemView);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                boolean zChanged2 = composer.changed(roomItemView) | composer.changedInstance(roomViewModel) | composer.changedInstance(navHostController);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.g
                        @Override // lb.a
                        public final Object invoke() {
                            return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0$2$0$1$0(snapshotStateList, roomItemView, roomViewModel, navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1250combinedClickablehoGz1lA$default = ClickableKt.m1250combinedClickablehoGz1lA$default(modifierM1204backgroundbw27NRU, false, null, null, null, aVar, null, false, null, (lb.a) objRememberedValue2, 239, null);
                composer.startReplaceGroup(854894313);
                String name = roomItemView.getName();
                if (d0.q0(name)) {
                    name = StringResources_androidKt.stringResource(R.string.loading_hint, composer, 0);
                }
                composer.endReplaceGroup();
                String thumbnail = roomItemView.getThumbnail();
                String shortMsg = ExtensionFunsKt.toShortMsg(roomItemView, context, roomViewModel.getOwner().getNameWithDomain(), roomViewModel.getOwner().getAlias());
                String string = roomItemView.getLastUpdate().toString();
                MessageWithPartnerWithReactions lastMessage = roomItemView.getLastMessage();
                if (lastMessage != null && (message = lastMessage.getMessage()) != null && message.getState() == 2) {
                    User senderUser = roomItemView.getLastMessage().getSenderUser();
                    if (!y.d(senderUser != null ? senderUser.getUid() : null, roomViewModel.getOwner().getNameWithDomain()) && roomItemView.getLastMessage().getMessage().getPayload() == null) {
                        z10 = true;
                    }
                }
                String str = roomItemView.getRoom().getConfig().get(Room.CONFIG_UNREAD_COUNT);
                if (str == null) {
                    str = "";
                }
                int type = roomItemView.getRoom().getType();
                boolean pined = roomItemView.getRoom().getPined();
                String id2 = roomItemView.getRoom().getId();
                MessageWithPartnerWithReactions lastMessage2 = roomItemView.getLastMessage();
                List<Reaction> reactions = lastMessage2 != null ? lastMessage2.getReactions() : null;
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0$2$0$3$0(navHostController, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                RoomItemKt.RoomItem(modifierM1250combinedClickablehoGz1lA$default, name, thumbnail, shortMsg, string, z10, str, type, pined, id2, null, false, null, false, reactions, (Function1) objRememberedValue3, null, composer, 0, 0, 80896);
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
    public static final k0 SecretRoomsScreen$lambda$0$3$0$0$2$0$0$0(SnapshotStateList snapshotStateList, RoomItemView roomItemView) {
        if (!snapshotStateList.contains(roomItemView.getRoom().getId())) {
            snapshotStateList.add(roomItemView.getRoom().getId());
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$0$3$0$0$2$0$1$0(SnapshotStateList snapshotStateList, final RoomItemView roomItemView, final RoomViewModel roomViewModel, final NavHostController navHostController) {
        if (snapshotStateList.contains(roomItemView.getRoom().getId())) {
            snapshotStateList.remove(roomItemView.getRoom().getId());
        } else if (snapshotStateList.isEmpty()) {
            roomViewModel.goOnUnreadPosition(roomItemView.getRoom().getId(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.secret.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SecretRoomsScreenKt.SecretRoomsScreen$lambda$0$3$0$0$2$0$1$0$0(navHostController, roomItemView, roomViewModel, ((Integer) obj).intValue());
                }
            });
        } else {
            snapshotStateList.add(roomItemView.getRoom().getId());
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$0$3$0$0$2$0$1$0$0(NavHostController navHostController, RoomItemView roomItemView, RoomViewModel roomViewModel, int i10) {
        NavLinks navLinks = NavLinks.INSTANCE;
        int type = roomItemView.getRoom().getType();
        String strT = roomViewModel.getGson().t(new ChatParams(roomItemView.getRoom().getId(), roomItemView.getRoom().getType(), w.n(), i10));
        y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goChat(type, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$0$3$0$0$2$0$3$0(NavHostController navHostController, String prev) {
        y.i(prev, "prev");
        NavController.navigate$default((NavController) navHostController, prev, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 SecretRoomsScreen$lambda$0$3$0$0$3(LazyPagingItems lazyPagingItems, LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-77672415, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.secret.SecretRoomsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecretRoomsScreen.kt:209)");
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
    public static final k0 SecretRoomsScreen$lambda$0$3$1$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$0$3$2$0(SnapshotStateList snapshotStateList, RoomViewModel roomViewModel) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        roomViewModel.clearHistoryFromRooms(arrayList);
        snapshotStateList.clear();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SecretRoomsScreen$lambda$1(NavHostController navHostController, RoomViewModel roomViewModel, int i10, int i11, Composer composer, int i12) {
        SecretRoomsScreen(navHostController, roomViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
