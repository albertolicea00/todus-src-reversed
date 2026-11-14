package cu.todus.android.uiCompose.main.screen.rooms.muted;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
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
import cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel;
import cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItemKt;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.utils.ExtensionFunsKt;
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
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/rooms/RoomViewModel;", "viewModel", "Lua/k0;", "MutedRoomsScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/rooms/RoomViewModel;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MutedRoomsScreenKt {
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"InlinedApi"})
    public static final void MutedRoomsScreen(final NavHostController navHostController, RoomViewModel roomViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        int i13;
        final RoomViewModel roomViewModel2 = roomViewModel;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-617847104);
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
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                roomViewModel2 = (RoomViewModel) ViewModelKt.viewModel(z0.b(RoomViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i14 &= -113;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617847104, i14, -1, "cu.todus.android.uiCompose.main.screen.rooms.muted.MutedRoomsScreen (MutedRoomsScreen.kt:54)");
            }
            composer2 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-595335412, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MutedRoomsScreenKt.MutedRoomsScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, true, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(-1872824118, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MutedRoomsScreenKt.MutedRoomsScreen$lambda$1(roomViewModel2, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MutedRoomsScreenKt.MutedRoomsScreen$lambda$2(navHostController, roomViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MutedRoomsScreen$lambda$0(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-595335412, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.muted.MutedRoomsScreen.<anonymous> (MutedRoomsScreen.kt:58)");
            }
            Function2 lambda$1149230815$app_productionPFast = ComposableSingletons$MutedRoomsScreenKt.INSTANCE.getLambda$1149230815$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.i
                    @Override // lb.a
                    public final Object invoke() {
                        return MutedRoomsScreenKt.MutedRoomsScreen$lambda$0$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$1149230815$app_productionPFast, it, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, ((i11 << 3) & 112) | 6, 0, 1948);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MutedRoomsScreen$lambda$0$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MutedRoomsScreen$lambda$1(final RoomViewModel roomViewModel, final NavHostController navHostController, Modifier it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1872824118, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.muted.MutedRoomsScreen.<anonymous> (MutedRoomsScreen.kt:74)");
            }
            c1.a aVarC = c1.d.c(w.g("android.permission.POST_NOTIFICATIONS"), null, composer, 0, 2);
            final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(roomViewModel.getMutedRooms(), null, composer, 0, 1);
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(it, 0.0f, 1, null);
            boolean zChangedInstance = composer.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | composer.changedInstance(roomViewModel) | composer.changedInstance(context) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MutedRoomsScreenKt.MutedRoomsScreen$lambda$1$0$0(lazyPagingItemsCollectAsLazyPagingItems, roomViewModel, context, navHostController, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyColumn(modifierFillMaxHeight$default, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
            k0 k0Var = k0.f43947a;
            boolean zChanged = composer.changed(aVarC);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new MutedRoomsScreenKt$MutedRoomsScreen$2$2$1(aVarC, null);
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
    public static final k0 MutedRoomsScreen$lambda$1$0$0(final LazyPagingItems lazyPagingItems, final RoomViewModel roomViewModel, final Context context, final NavHostController navHostController, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$MutedRoomsScreenKt composableSingletons$MutedRoomsScreenKt = ComposableSingletons$MutedRoomsScreenKt.INSTANCE;
        LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$MutedRoomsScreenKt.getLambda$1391342869$app_productionPFast(), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MutedRoomsScreenKt.MutedRoomsScreen$lambda$1$0$0$0((RoomItemView) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MutedRoomsScreenKt.MutedRoomsScreen$lambda$1$0$0$1((RoomItemView) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(2070945132, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.e
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MutedRoomsScreenKt.MutedRoomsScreen$lambda$1$0$0$2(lazyPagingItems, roomViewModel, context, navHostController, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1158421822, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.f
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MutedRoomsScreenKt.MutedRoomsScreen$lambda$1$0$0$3(lazyPagingItems, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.CC.m(LazyColumn, null, null, composableSingletons$MutedRoomsScreenKt.m9969getLambda$714791715$app_productionPFast(), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MutedRoomsScreen$lambda$1$0$0$0(RoomItemView r10) {
        y.i(r10, "r");
        return r10.getIdOnList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MutedRoomsScreen$lambda$1$0$0$1(RoomItemView i10) {
        y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 MutedRoomsScreen$lambda$1$0$0$2(LazyPagingItems lazyPagingItems, final RoomViewModel roomViewModel, Context context, final NavHostController navHostController, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        Message message;
        User senderUser;
        Message message2;
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
                ComposerKt.traceEventStart(2070945132, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.muted.MutedRoomsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MutedRoomsScreen.kt:112)");
            }
            final RoomItemView roomItemView = (RoomItemView) lazyPagingItems.get(i10);
            if (roomItemView != null) {
                composer.startReplaceGroup(-1678613528);
                float f10 = 3;
                float f11 = 15;
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1729paddingqDBjuR0$default(androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 2, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f10), 0.0f, Dp.m8823constructorimpl(f10), 4, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f11), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 6, null));
                boolean zChangedInstance = composer.changedInstance(roomViewModel) | composer.changed(roomItemView);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.k
                        @Override // lb.a
                        public final Object invoke() {
                            return MutedRoomsScreenKt.MutedRoomsScreen$lambda$1$0$0$2$0$0$0(roomViewModel, roomItemView);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.l
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1250combinedClickablehoGz1lA$default = ClickableKt.m1250combinedClickablehoGz1lA$default(modifierM1204backgroundbw27NRU, false, null, null, null, aVar, null, false, null, (lb.a) objRememberedValue2, 239, null);
                composer.startReplaceGroup(1608450690);
                String name = roomItemView.getName();
                if (d0.q0(name)) {
                    name = StringResources_androidKt.stringResource(R.string.loading_hint, composer, 0);
                }
                composer.endReplaceGroup();
                String thumbnail = roomItemView.getThumbnail();
                String shortMsg = ExtensionFunsKt.toShortMsg(roomItemView, context, roomViewModel.getOwner().getNameWithDomain(), roomViewModel.getOwner().getAlias());
                String string = roomItemView.getLastUpdate().toString();
                MessageWithPartnerWithReactions lastMessage = roomItemView.getLastMessage();
                if (lastMessage != null && (message2 = lastMessage.getMessage()) != null && message2.getState() == 2) {
                    User senderUser2 = roomItemView.getLastMessage().getSenderUser();
                    if (!y.d(senderUser2 != null ? senderUser2.getUid() : null, roomViewModel.getOwner().getNameWithDomain()) && roomItemView.getLastMessage().getMessage().getPayload() == null) {
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
                MessageWithPartnerWithReactions lastMessage3 = roomItemView.getLastMessage();
                boolean zD = y.d((lastMessage3 == null || (senderUser = lastMessage3.getSenderUser()) == null) ? null : senderUser.getUid(), roomViewModel.getOwner().getNameWithDomain());
                MessageWithPartnerWithReactions lastMessage4 = roomItemView.getLastMessage();
                Integer numValueOf = (lastMessage4 == null || (message = lastMessage4.getMessage()) == null) ? null : Integer.valueOf(message.getState());
                boolean zChangedInstance2 = composer.changedInstance(navHostController);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.muted.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MutedRoomsScreenKt.MutedRoomsScreen$lambda$1$0$0$2$0$3$0(navHostController, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                RoomItemKt.RoomItem(modifierM1250combinedClickablehoGz1lA$default, name, thumbnail, shortMsg, string, z10, str, type, pined, id2, numValueOf, zD, null, false, reactions, (Function1) objRememberedValue3, null, composer, 0, 0, 77824);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1608500292);
                float f12 = 3;
                RoomItemKt.RoomItemPlaceholder(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f12), 0.0f, Dp.m8823constructorimpl(f12), 4, null), composer, 6);
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
    public static final k0 MutedRoomsScreen$lambda$1$0$0$2$0$0$0(RoomViewModel roomViewModel, RoomItemView roomItemView) {
        roomViewModel.changeMuteValue(roomItemView.getRoom().getId());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MutedRoomsScreen$lambda$1$0$0$2$0$3$0(NavHostController navHostController, String prev) {
        y.i(prev, "prev");
        NavController.navigate$default((NavController) navHostController, prev, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 MutedRoomsScreen$lambda$1$0$0$3(LazyPagingItems lazyPagingItems, LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1158421822, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.muted.MutedRoomsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MutedRoomsScreen.kt:166)");
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
    public static final k0 MutedRoomsScreen$lambda$2(NavHostController navHostController, RoomViewModel roomViewModel, int i10, int i11, Composer composer, int i12) {
        MutedRoomsScreen(navHostController, roomViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
