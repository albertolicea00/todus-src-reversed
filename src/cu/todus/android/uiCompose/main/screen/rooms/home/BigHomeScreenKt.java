package cu.todus.android.uiCompose.main.screen.rooms.home;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.BatterySaverKt;
import androidx.compose.material.icons.outlined.LockKt;
import androidx.compose.material.icons.outlined.NewspaperKt;
import androidx.compose.material.icons.outlined.PeopleOutlineKt;
import androidx.compose.material.icons.outlined.SaveKt;
import androidx.compose.material.icons.outlined.SearchKt;
import androidx.compose.material.pullrefresh.PullRefreshIndicatorKt;
import androidx.compose.material.pullrefresh.PullRefreshKt;
import androidx.compose.material.pullrefresh.PullRefreshState;
import androidx.compose.material.pullrefresh.PullRefreshStateKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p000activity.compose.BackHandlerKt;
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
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.data.mucks.DefaultNews;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupParams;
import cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel;
import cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItemKt;
import cu.todus.android.uiCompose.main.screen.rooms.roomItem.RoomItemState;
import cu.todus.android.uiCompose.main.screen.rooms.selectType.SelectTypeKt;
import cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsActionsTopBarKt;
import cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsTopBarKt;
import cu.todus.android.uiCompose.main.screen.rooms.tooltip.RoomTooltipKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.drawer.DrawerNavItem;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.XMPPUtils;
import cu.z17.singledi.SinglediException;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import j$.util.Collection;
import j$.util.function.Predicate$CC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0019²\u0006\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\nX\u008a\u0084\u0002²\u0006\f\u0010\u000b\u001a\u00020\n8\nX\u008a\u0084\u0002²\u0006\f\u0010\f\u001a\u00020\n8\nX\u008a\u0084\u0002²\u0006\f\u0010\r\u001a\u00020\n8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u000e\u001a\u0004\u0018\u00010\n8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0010\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u0018\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00118\nX\u008a\u0084\u0002²\u0006\f\u0010\u0013\u001a\u00020\u000f8\nX\u008a\u0084\u0002²\u0006\f\u0010\u0014\u001a\u00020\u000f8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0016\u001a\u00020\n8\nX\u008a\u0084\u0002²\u0006\f\u0010\u0018\u001a\u00020\u00178\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/rooms/RoomViewModel;", "viewModel", "Lua/k0;", "BigHomeScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/rooms/RoomViewModel;Landroidx/compose/runtime/Composer;II)V", "", "", "unseenStatusList", "", "unseenStatus", "isConnected", "firstItemVisible", "requestMode", "", "selectedRoomType", "", "typingState", "requestRoomCount", "searchNumberForTooltip", "refreshing", "isSelected", "Lcu/todus/android/uiCompose/main/screen/rooms/roomItem/RoomItemState;", "state", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BigHomeScreenKt {
    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:60:0x0152  */
    /* JADX WARN: Code duplicated, block: B:63:0x018b  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:69:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:72:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:78:0x042b  */
    /* JADX WARN: Code duplicated, block: B:81:0x043c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0441  */
    /* JADX WARN: Code duplicated, block: B:85:0x0449  */
    /* JADX WARN: Code duplicated, block: B:86:0x0466  */
    /* JADX WARN: Code duplicated, block: B:89:0x0515  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"InlinedApi"})
    public static final void BigHomeScreen(NavHostController navHostController, RoomViewModel roomViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        final RoomViewModel roomViewModel2;
        int i13;
        RoomViewModel roomViewModel3;
        int i14;
        int i15;
        final State stateCollectAsStateWithLifecycle;
        Object objRememberedValue;
        Composer.Companion companion;
        final Context context;
        boolean zChangedInstance;
        Object objRememberedValue2;
        Boolean bool;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Object objRememberedValue6;
        final LazyListState lazyListStateRememberLazyListState;
        Object objRememberedValue7;
        Object objRememberedValue8;
        final MutableIntState mutableIntState;
        Boolean boolBigHomeScreen$lambda$10;
        boolean zBooleanValue;
        List<Integer> listE;
        int i16;
        final NavHostController navHostController2 = navHostController;
        RoomViewModel roomViewModel4 = roomViewModel;
        kotlin.jvm.internal.y.i(navHostController2, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1532986086);
        if ((i10 & 6) == 0) {
            i12 = i10 | (composerStartRestartGroup.changedInstance(navHostController2) ? 4 : 2);
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i16 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(roomViewModel4) : composerStartRestartGroup.changedInstance(roomViewModel4)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
            }
            i12 |= i16;
        }
        int i17 = i12;
        if (composerStartRestartGroup.shouldExecute((i17 & 19) != 18, i17 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 2) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i13 = 1;
                    i17 &= -113;
                    roomViewModel3 = (RoomViewModel) ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(RoomViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                }
                i14 = i17;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1532986086, i14, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen (BigHomeScreen.kt:127)");
                }
                i15 = i13;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(roomViewModel3.getRoomsWithStatusUnseen(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(BigHomeScreenKt.BigHomeScreen$lambda$1$0(stateCollectAsStateWithLifecycle));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final State state = (State) objRememberedValue;
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(roomViewModel3.mXMPPDataSourceDataState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final c1.a aVarC = c1.d.c(va.w.g("android.permission.POST_NOTIFICATIONS", "android.permission.BLUETOOTH_CONNECT"), null, composerStartRestartGroup, 0, 2);
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                AppVolatileState.Companion companion2 = AppVolatileState.INSTANCE;
                Boolean boolValueOf = Boolean.valueOf(companion2.getInstance().getAliasSelected());
                Boolean boolValueOf2 = Boolean.valueOf(companion2.getInstance().getBatterySettingsShowed());
                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new BigHomeScreenKt$BigHomeScreen$1$1(navHostController2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(boolValueOf, boolValueOf2, (Function2) objRememberedValue2, composerStartRestartGroup, 0);
                te.h hVarIsConnected = roomViewModel3.isConnected();
                bool = Boolean.FALSE;
                final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(hVarIsConnected, bool, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState = (MutableState) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.mutableStateListOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    String string = context.getString(R.string.search);
                    kotlin.jvm.internal.y.h(string, "getString(...)");
                    Icons.Outlined outlined = Icons.Outlined.INSTANCE;
                    DrawerNavItem drawerNavItem = new DrawerNavItem(string, NavLinks.SEARCH, SearchKt.getSearch(outlined), false, 8, null);
                    String string2 = context.getString(R.string.news);
                    kotlin.jvm.internal.y.h(string2, "getString(...)");
                    DrawerNavItem drawerNavItem2 = new DrawerNavItem(string2, NavLinks.NEWS, NewspaperKt.getNewspaper(outlined), false, 8, null);
                    DrawerNavItem drawerNavItem3 = new DrawerNavItem("", "", null, true, 4, null);
                    String string3 = context.getString(R.string.new_group);
                    kotlin.jvm.internal.y.h(string3, "getString(...)");
                    NavLinks navLinks = NavLinks.INSTANCE;
                    String strT = roomViewModel3.getGson().t(new CreateGroupParams(null, null, 3, null));
                    kotlin.jvm.internal.y.h(strT, "toJson(...)");
                    DrawerNavItem drawerNavItem4 = new DrawerNavItem(string3, navLinks.goCreateGroupStep1(strT), Integer.valueOf(R.drawable.newgroup), false, 8, null);
                    String string4 = context.getString(R.string.new_channel);
                    kotlin.jvm.internal.y.h(string4, "getString(...)");
                    DrawerNavItem drawerNavItem5 = new DrawerNavItem(string4, NavLinks.CREATE_CHANNEL, Integer.valueOf(R.drawable.channel_image_type), false, 8, null);
                    DrawerNavItem drawerNavItem6 = new DrawerNavItem("", "", null, true, 4, null);
                    String string5 = context.getString(R.string.secret_folder);
                    kotlin.jvm.internal.y.h(string5, "getString(...)");
                    DrawerNavItem drawerNavItem7 = new DrawerNavItem(string5, NavLinks.SECRET_ROOM_ACCESS, LockKt.getLock(outlined), false, 8, null);
                    String string6 = context.getString(R.string.people_near);
                    kotlin.jvm.internal.y.h(string6, "getString(...)");
                    DrawerNavItem drawerNavItem8 = new DrawerNavItem(string6, NavLinks.NEAR, Integer.valueOf(R.drawable.nearpeople), false, 8, null);
                    String string7 = context.getString(R.string.catalog);
                    kotlin.jvm.internal.y.h(string7, "getString(...)");
                    DrawerNavItem drawerNavItem9 = new DrawerNavItem(string7, NavLinks.MY_CATALOGUE, Integer.valueOf(R.drawable.business), false, 8, null);
                    DrawerNavItem drawerNavItem10 = new DrawerNavItem("", "", null, true, 4, null);
                    String string8 = context.getString(R.string.devices);
                    kotlin.jvm.internal.y.h(string8, "getString(...)");
                    DrawerNavItem drawerNavItem11 = new DrawerNavItem(string8, "linked_device", Integer.valueOf(R.drawable.devices), false, 8, null);
                    DrawerNavItem drawerNavItem12 = new DrawerNavItem("", "", null, true, 4, null);
                    String string9 = context.getString(R.string.settings);
                    kotlin.jvm.internal.y.h(string9, "getString(...)");
                    DrawerNavItem drawerNavItem13 = new DrawerNavItem(string9, NavLinks.SETTING, Integer.valueOf(R.drawable.settings), false, 8, null);
                    String string10 = context.getString(R.string.battery_preference);
                    kotlin.jvm.internal.y.h(string10, "getString(...)");
                    DrawerNavItem drawerNavItem14 = new DrawerNavItem(string10, NavLinks.BATTERY_PREFERENCE, BatterySaverKt.getBatterySaver(Icons.INSTANCE.getDefault()), false, 8, null);
                    String string11 = context.getString(R.string.manage_backups);
                    kotlin.jvm.internal.y.h(string11, "getString(...)");
                    DrawerNavItem drawerNavItem15 = new DrawerNavItem(string11, NavLinks.MANAGE_BACKUP, SaveKt.getSave(outlined), false, 8, null);
                    DrawerNavItem drawerNavItem16 = new DrawerNavItem("", "", null, true, 4, null);
                    String string12 = context.getString(R.string.about_todus);
                    kotlin.jvm.internal.y.h(string12, "getString(...)");
                    DrawerNavItem drawerNavItem17 = new DrawerNavItem(string12, NavLinks.ABOUT, PeopleOutlineKt.getPeopleOutline(outlined), false, 8, null);
                    DrawerNavItem[] drawerNavItemArr = new DrawerNavItem[17];
                    drawerNavItemArr[0] = drawerNavItem;
                    drawerNavItemArr[i15] = drawerNavItem2;
                    drawerNavItemArr[2] = drawerNavItem3;
                    drawerNavItemArr[3] = drawerNavItem4;
                    drawerNavItemArr[4] = drawerNavItem5;
                    drawerNavItemArr[5] = drawerNavItem6;
                    drawerNavItemArr[6] = drawerNavItem7;
                    drawerNavItemArr[7] = drawerNavItem8;
                    drawerNavItemArr[8] = drawerNavItem9;
                    drawerNavItemArr[9] = drawerNavItem10;
                    drawerNavItemArr[10] = drawerNavItem11;
                    drawerNavItemArr[11] = drawerNavItem12;
                    drawerNavItemArr[12] = drawerNavItem13;
                    drawerNavItemArr[13] = drawerNavItem14;
                    drawerNavItemArr[14] = drawerNavItem15;
                    drawerNavItemArr[15] = drawerNavItem16;
                    drawerNavItemArr[16] = drawerNavItem17;
                    objRememberedValue5 = va.w.q(drawerNavItemArr);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final List list = (List) objRememberedValue5;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final pe.m0 m0Var = (pe.m0) objRememberedValue6;
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.g
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(BigHomeScreenKt.BigHomeScreen$lambda$8$0(lazyListStateRememberLazyListState));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final State state2 = (State) objRememberedValue7;
                final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(roomViewModel3.getRequestMode(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = SnapshotIntStateKt.mutableIntStateOf(-1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                mutableIntState = (MutableIntState) objRememberedValue8;
                boolBigHomeScreen$lambda$10 = BigHomeScreen$lambda$10(stateCollectAsStateWithLifecycle4);
                if (boolBigHomeScreen$lambda$10 != null) {
                    zBooleanValue = boolBigHomeScreen$lambda$10.booleanValue();
                } else {
                    zBooleanValue = i15;
                }
                if (mutableIntState.getIntValue() == -1) {
                    Integer numValueOf = Integer.valueOf(i15);
                    Integer[] numArr = new Integer[4];
                    numArr[0] = 0;
                    numArr[i15] = numValueOf;
                    numArr[2] = 2;
                    numArr[3] = 3;
                    listE = va.w.q(numArr);
                } else {
                    listE = va.v.e(Integer.valueOf(mutableIntState.getIntValue()));
                }
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(roomViewModel3.rooms(zBooleanValue, listE), null, composerStartRestartGroup, 0, i15);
                final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(companion2.getInstance().getUsersTyping(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(roomViewModel3.getRequestRoomCount(), 0, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
                final RoomViewModel roomViewModel5 = roomViewModel3;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1554087910, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BigHomeScreenKt.BigHomeScreen$lambda$16(snapshotStateList, navHostController2, roomViewModel5, stateCollectAsStateWithLifecycle2, mutableState, stateCollectAsStateWithLifecycle3, state, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-385597842, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BigHomeScreenKt.BigHomeScreen$lambda$17(navHostController2, state2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BigHomeScreenKt.BigHomeScreen$lambda$18(mutableState, roomViewModel5, snapshotStateList, aVarC, context, list, m0Var, navHostController2, lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle4, stateCollectAsStateWithLifecycle6, lazyPagingItemsCollectAsLazyPagingItems, stateCollectAsStateWithLifecycle5, stateCollectAsStateWithLifecycle, mutableIntState, stateCollectAsStateWithLifecycle3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                navHostController2 = navHostController2;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, false, composableLambdaRememberComposableLambda2, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(690276380, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805331382, 360);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                roomViewModel2 = roomViewModel5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i17 &= -113;
                }
            }
            i13 = 1;
            roomViewModel3 = roomViewModel4;
            i14 = i17;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1532986086, i14, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen (BigHomeScreen.kt:127)");
            }
            i15 = i13;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(roomViewModel3.getRoomsWithStatusUnseen(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.f
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(BigHomeScreenKt.BigHomeScreen$lambda$1$0(stateCollectAsStateWithLifecycle));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final State state3 = (State) objRememberedValue;
            final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(roomViewModel3.mXMPPDataSourceDataState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final c1.a aVarC2 = c1.d.c(va.w.g("android.permission.POST_NOTIFICATIONS", "android.permission.BLUETOOTH_CONNECT"), null, composerStartRestartGroup, 0, 2);
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            AppVolatileState.Companion companion3 = AppVolatileState.INSTANCE;
            Boolean boolValueOf3 = Boolean.valueOf(companion3.getInstance().getAliasSelected());
            Boolean boolValueOf4 = Boolean.valueOf(companion3.getInstance().getBatterySettingsShowed());
            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue2 = new BigHomeScreenKt$BigHomeScreen$1$1(navHostController2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new BigHomeScreenKt$BigHomeScreen$1$1(navHostController2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(boolValueOf3, boolValueOf4, (Function2) objRememberedValue2, composerStartRestartGroup, 0);
            te.h hVarIsConnected2 = roomViewModel3.isConnected();
            bool = Boolean.FALSE;
            final State stateCollectAsStateWithLifecycle8 = FlowExtKt.collectAsStateWithLifecycle(hVarIsConnected2, bool, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final SnapshotStateList snapshotStateList2 = (SnapshotStateList) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                String string13 = context.getString(R.string.search);
                kotlin.jvm.internal.y.h(string13, "getString(...)");
                Icons.Outlined outlined2 = Icons.Outlined.INSTANCE;
                DrawerNavItem drawerNavItem18 = new DrawerNavItem(string13, NavLinks.SEARCH, SearchKt.getSearch(outlined2), false, 8, null);
                String string14 = context.getString(R.string.news);
                kotlin.jvm.internal.y.h(string14, "getString(...)");
                DrawerNavItem drawerNavItem19 = new DrawerNavItem(string14, NavLinks.NEWS, NewspaperKt.getNewspaper(outlined2), false, 8, null);
                DrawerNavItem drawerNavItem20 = new DrawerNavItem("", "", null, true, 4, null);
                String string15 = context.getString(R.string.new_group);
                kotlin.jvm.internal.y.h(string15, "getString(...)");
                NavLinks navLinks2 = NavLinks.INSTANCE;
                String strT2 = roomViewModel3.getGson().t(new CreateGroupParams(null, null, 3, null));
                kotlin.jvm.internal.y.h(strT2, "toJson(...)");
                DrawerNavItem drawerNavItem21 = new DrawerNavItem(string15, navLinks2.goCreateGroupStep1(strT2), Integer.valueOf(R.drawable.newgroup), false, 8, null);
                String string16 = context.getString(R.string.new_channel);
                kotlin.jvm.internal.y.h(string16, "getString(...)");
                DrawerNavItem drawerNavItem22 = new DrawerNavItem(string16, NavLinks.CREATE_CHANNEL, Integer.valueOf(R.drawable.channel_image_type), false, 8, null);
                DrawerNavItem drawerNavItem23 = new DrawerNavItem("", "", null, true, 4, null);
                String string17 = context.getString(R.string.secret_folder);
                kotlin.jvm.internal.y.h(string17, "getString(...)");
                DrawerNavItem drawerNavItem24 = new DrawerNavItem(string17, NavLinks.SECRET_ROOM_ACCESS, LockKt.getLock(outlined2), false, 8, null);
                String string18 = context.getString(R.string.people_near);
                kotlin.jvm.internal.y.h(string18, "getString(...)");
                DrawerNavItem drawerNavItem25 = new DrawerNavItem(string18, NavLinks.NEAR, Integer.valueOf(R.drawable.nearpeople), false, 8, null);
                String string19 = context.getString(R.string.catalog);
                kotlin.jvm.internal.y.h(string19, "getString(...)");
                DrawerNavItem drawerNavItem26 = new DrawerNavItem(string19, NavLinks.MY_CATALOGUE, Integer.valueOf(R.drawable.business), false, 8, null);
                DrawerNavItem drawerNavItem110 = new DrawerNavItem("", "", null, true, 4, null);
                String string20 = context.getString(R.string.devices);
                kotlin.jvm.internal.y.h(string20, "getString(...)");
                DrawerNavItem drawerNavItem111 = new DrawerNavItem(string20, "linked_device", Integer.valueOf(R.drawable.devices), false, 8, null);
                DrawerNavItem drawerNavItem112 = new DrawerNavItem("", "", null, true, 4, null);
                String string21 = context.getString(R.string.settings);
                kotlin.jvm.internal.y.h(string21, "getString(...)");
                DrawerNavItem drawerNavItem113 = new DrawerNavItem(string21, NavLinks.SETTING, Integer.valueOf(R.drawable.settings), false, 8, null);
                String string110 = context.getString(R.string.battery_preference);
                kotlin.jvm.internal.y.h(string110, "getString(...)");
                DrawerNavItem drawerNavItem114 = new DrawerNavItem(string110, NavLinks.BATTERY_PREFERENCE, BatterySaverKt.getBatterySaver(Icons.INSTANCE.getDefault()), false, 8, null);
                String string111 = context.getString(R.string.manage_backups);
                kotlin.jvm.internal.y.h(string111, "getString(...)");
                DrawerNavItem drawerNavItem115 = new DrawerNavItem(string111, NavLinks.MANAGE_BACKUP, SaveKt.getSave(outlined2), false, 8, null);
                DrawerNavItem drawerNavItem116 = new DrawerNavItem("", "", null, true, 4, null);
                String string112 = context.getString(R.string.about_todus);
                kotlin.jvm.internal.y.h(string112, "getString(...)");
                DrawerNavItem drawerNavItem117 = new DrawerNavItem(string112, NavLinks.ABOUT, PeopleOutlineKt.getPeopleOutline(outlined2), false, 8, null);
                DrawerNavItem[] drawerNavItemArr2 = new DrawerNavItem[17];
                drawerNavItemArr2[0] = drawerNavItem18;
                drawerNavItemArr2[i15] = drawerNavItem19;
                drawerNavItemArr2[2] = drawerNavItem20;
                drawerNavItemArr2[3] = drawerNavItem21;
                drawerNavItemArr2[4] = drawerNavItem22;
                drawerNavItemArr2[5] = drawerNavItem23;
                drawerNavItemArr2[6] = drawerNavItem24;
                drawerNavItemArr2[7] = drawerNavItem25;
                drawerNavItemArr2[8] = drawerNavItem26;
                drawerNavItemArr2[9] = drawerNavItem110;
                drawerNavItemArr2[10] = drawerNavItem111;
                drawerNavItemArr2[11] = drawerNavItem112;
                drawerNavItemArr2[12] = drawerNavItem113;
                drawerNavItemArr2[13] = drawerNavItem114;
                drawerNavItemArr2[14] = drawerNavItem115;
                drawerNavItemArr2[15] = drawerNavItem116;
                drawerNavItemArr2[16] = drawerNavItem117;
                objRememberedValue5 = va.w.q(drawerNavItemArr2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final List list2 = (List) objRememberedValue5;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final pe.m0 m0Var2 = (pe.m0) objRememberedValue6;
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.g
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(BigHomeScreenKt.BigHomeScreen$lambda$8$0(lazyListStateRememberLazyListState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final State state4 = (State) objRememberedValue7;
            final State stateCollectAsStateWithLifecycle9 = FlowExtKt.collectAsStateWithLifecycle(roomViewModel3.getRequestMode(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = SnapshotIntStateKt.mutableIntStateOf(-1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            mutableIntState = (MutableIntState) objRememberedValue8;
            boolBigHomeScreen$lambda$10 = BigHomeScreen$lambda$10(stateCollectAsStateWithLifecycle9);
            if (boolBigHomeScreen$lambda$10 != null) {
                zBooleanValue = boolBigHomeScreen$lambda$10.booleanValue();
            } else {
                zBooleanValue = i15;
            }
            if (mutableIntState.getIntValue() == -1) {
                Integer numValueOf2 = Integer.valueOf(i15);
                Integer[] numArr2 = new Integer[4];
                numArr2[0] = 0;
                numArr2[i15] = numValueOf2;
                numArr2[2] = 2;
                numArr2[3] = 3;
                listE = va.w.q(numArr2);
            } else {
                listE = va.v.e(Integer.valueOf(mutableIntState.getIntValue()));
            }
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(roomViewModel3.rooms(zBooleanValue, listE), null, composerStartRestartGroup, 0, i15);
            final State stateCollectAsStateWithLifecycle10 = FlowExtKt.collectAsStateWithLifecycle(companion3.getInstance().getUsersTyping(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle11 = FlowExtKt.collectAsStateWithLifecycle(roomViewModel3.getRequestRoomCount(), 0, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            final RoomViewModel roomViewModel6 = roomViewModel3;
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1554087910, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigHomeScreenKt.BigHomeScreen$lambda$16(snapshotStateList2, navHostController2, roomViewModel6, stateCollectAsStateWithLifecycle7, mutableState2, stateCollectAsStateWithLifecycle8, state3, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-385597842, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigHomeScreenKt.BigHomeScreen$lambda$17(navHostController2, state4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function3 function4 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigHomeScreenKt.BigHomeScreen$lambda$18(mutableState2, roomViewModel6, snapshotStateList2, aVarC2, context, list2, m0Var2, navHostController2, lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle9, stateCollectAsStateWithLifecycle11, lazyPagingItemsCollectAsLazyPagingItems2, stateCollectAsStateWithLifecycle10, stateCollectAsStateWithLifecycle, mutableIntState, stateCollectAsStateWithLifecycle8, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            navHostController2 = navHostController2;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda3, false, false, false, composableLambdaRememberComposableLambda4, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(690276380, true, function4, composerStartRestartGroup, 54), composerStartRestartGroup, 805331382, 360);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            roomViewModel2 = roomViewModel6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            roomViewModel2 = roomViewModel4;
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigHomeScreenKt.BigHomeScreen$lambda$19(navHostController2, roomViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<String> BigHomeScreen$lambda$0(State<? extends List<String>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigHomeScreen$lambda$1$0(State state) {
        return !BigHomeScreen$lambda$0(state).isEmpty();
    }

    private static final Boolean BigHomeScreen$lambda$10(State<Boolean> state) {
        return state.getValue();
    }

    private static final Map<String, Boolean> BigHomeScreen$lambda$14(State<? extends Map<String, Boolean>> state) {
        return state.getValue();
    }

    private static final int BigHomeScreen$lambda$15(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$16(final SnapshotStateList snapshotStateList, NavHostController navHostController, final RoomViewModel roomViewModel, State state, final MutableState mutableState, State state2, State state3, TopAppBarScrollBehavior it, Composer composer, int i10) throws XmlPullParserException, SinglediException, IOException {
        kotlin.jvm.internal.y.i(it, "it");
        boolean z10 = false;
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1554087910, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous> (BigHomeScreen.kt:311)");
            }
            if (snapshotStateList.isEmpty()) {
                composer.startReplaceGroup(1915356794);
                String photoUrl = roomViewModel.getOwner().getPhotoUrl();
                String alias = roomViewModel.getOwner().getAlias();
                boolean zBigHomeScreen$lambda$4 = BigHomeScreen$lambda$4(state2);
                boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
                boolean zBigHomeScreen$lambda$2 = BigHomeScreen$lambda$2(state3);
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.y
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                RoomsTopBarKt.RoomsTopBar(zBigHomeScreen$lambda$4, photoUrl, alias, null, navHostController, zBooleanValue, (lb.a) objRememberedValue, zBigHomeScreen$lambda$2, true, composer, 102236160, 8);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1914591838);
                int size = snapshotStateList.size();
                RoomItemView roomItemView = (RoomItemView) va.g0.y0(snapshotStateList);
                if (!snapshotStateList.isEmpty()) {
                    Iterator<T> it2 = snapshotStateList.iterator();
                    while (it2.hasNext()) {
                        if (XMPPUtils.INSTANCE.isChannel(((RoomItemView) it2.next()).getRoom().getId())) {
                            z10 = true;
                            break;
                        }
                    }
                }
                boolean z11 = true ^ z10;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.t
                        @Override // lb.a
                        public final Object invoke() {
                            return BigHomeScreenKt.BigHomeScreen$lambda$16$1$0(snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar = (lb.a) objRememberedValue2;
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.u
                        @Override // lb.a
                        public final Object invoke() {
                            return BigHomeScreenKt.BigHomeScreen$lambda$16$2$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                lb.a aVar2 = (lb.a) objRememberedValue3;
                boolean zChangedInstance = composer.changedInstance(roomViewModel);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.v
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigHomeScreenKt.BigHomeScreen$lambda$16$3$0(roomViewModel, snapshotStateList, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                Function1 function1 = (Function1) objRememberedValue4;
                boolean zChangedInstance2 = composer.changedInstance(roomViewModel);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.x
                        @Override // lb.a
                        public final Object invoke() {
                            return BigHomeScreenKt.BigHomeScreen$lambda$16$4$0(roomViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                RoomsActionsTopBarKt.RoomsActionsTopBar(navHostController, size, roomItemView, aVar, z11, aVar2, function1, (lb.a) objRememberedValue5, composer, 199680, 0);
                composer.endReplaceGroup();
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
    public static final ua.k0 BigHomeScreen$lambda$16$1$0(SnapshotStateList snapshotStateList) {
        snapshotStateList.clear();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$16$2$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$16$3$0(RoomViewModel roomViewModel, SnapshotStateList snapshotStateList, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        roomViewModel.toggleMute(it);
        snapshotStateList.clear();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$16$4$0(RoomViewModel roomViewModel, SnapshotStateList snapshotStateList) {
        roomViewModel.togglePin(((RoomItemView) snapshotStateList.get(0)).getRoom().getId());
        snapshotStateList.clear();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$17(final NavHostController navHostController, State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-385597842, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous> (BigHomeScreen.kt:345)");
            }
            ComposableSingletons$BigHomeScreenKt composableSingletons$BigHomeScreenKt = ComposableSingletons$BigHomeScreenKt.INSTANCE;
            Function2 function2M9966getLambda$1627418366$app_productionPFast = composableSingletons$BigHomeScreenKt.m9966getLambda$1627418366$app_productionPFast();
            Function2 lambda$519148099$app_productionPFast = composableSingletons$BigHomeScreenKt.getLambda$519148099$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.s
                    @Override // lb.a
                    public final Object invoke() {
                        return BigHomeScreenKt.BigHomeScreen$lambda$17$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            FloatingActionButtonKt.m3249ExtendedFloatingActionButtonElI57k(function2M9966getLambda$1627418366$app_productionPFast, lambda$519148099$app_productionPFast, (lb.a) objRememberedValue, null, BigHomeScreen$lambda$9(state), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, composer, 54, 936);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$17$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.OPEN_WITH, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$18(final MutableState mutableState, final RoomViewModel roomViewModel, final SnapshotStateList snapshotStateList, c1.a aVar, final Context context, List list, final pe.m0 m0Var, final NavHostController navHostController, LazyListState lazyListState, final State state, final State state2, final LazyPagingItems lazyPagingItems, final State state3, final State state4, final MutableIntState mutableIntState, State state5, Modifier it, Composer composer, int i10) {
        int i11;
        ab.e eVar;
        final SnapshotStateList snapshotStateList2;
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer2.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer2.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(690276380, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous> (BigHomeScreen.kt:368)");
            }
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = va.g0.Y0(new DefaultNews().getNews());
                composer2.updateRememberedValue(objRememberedValue);
            }
            final List list2 = (List) objRememberedValue;
            Object objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(NumberInlineFunctionsKt.nextInt(pb.d.f40576c, new rb.f(0, list2.size() * 5)));
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue2;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(it, 0.0f, 1, null), Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnBackground(), 0.05f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), composer2, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.3f), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierVerticalScroll$default);
            lb.a constructor2 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2.startReplaceGroup(-1111246130);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                final DrawerNavItem drawerNavItem = (DrawerNavItem) it2.next();
                if (drawerNavItem.isDivider()) {
                    composer2.startReplaceGroup(-409917863);
                    DividerKt.m3177HorizontalDivider9IZ8Weo(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(10)), 0.0f, 0L, composer2, 6, 6);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-409971472);
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl(4));
                    boolean zChangedInstance = composer2.changedInstance(m0Var) | composer2.changedInstance(navHostController) | composer2.changed(drawerNavItem);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.z
                            @Override // lb.a
                            public final Object invoke() {
                                return BigHomeScreenKt.BigHomeScreen$lambda$18$3$0$0$0$0(m0Var, navHostController, drawerNavItem);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    Composer composer3 = composer2;
                    CardKt.Card(ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs, false, null, null, null, (lb.a) objRememberedValue3, 15, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)), CardDefaults.INSTANCE.m2922cardColorsro_MJ88(Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnBackground(), 0.005f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1717729391, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.a0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BigHomeScreenKt.BigHomeScreen$lambda$18$3$0$0$1(drawerNavItem, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer3, 54), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
                    composer2 = composer3;
                    composer2.endReplaceGroup();
                }
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierA = e3.a(rowScopeInstance, companion4, 1.0f, false, 2, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(modifierA, materialTheme.getColorScheme(composer2, i12).getBackground(), null, 2, null);
            Alignment.Companion companion5 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getTopStart(), false);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default2);
            ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
            lb.a constructor3 = companion6.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, companion6.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion6.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion6.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion6.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue4 = composer2.rememberedValue();
            Composer.Companion companion7 = Composer.INSTANCE;
            if (objRememberedValue4 == companion7.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue4;
            boolean zBigHomeScreen$lambda$18$3$1$1 = BigHomeScreen$lambda$18$3$1$1(mutableState2);
            Object objRememberedValue5 = composer2.rememberedValue();
            if (objRememberedValue5 == companion7.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.b0
                    @Override // lb.a
                    public final Object invoke() {
                        return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$3$0(mutableState2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            }
            Composer composer4 = composer2;
            PullRefreshState pullRefreshStateM2815rememberPullRefreshStateUuyPYSY = PullRefreshStateKt.m2815rememberPullRefreshStateUuyPYSY(zBigHomeScreen$lambda$18$3$1$1, (lb.a) objRememberedValue5, 0.0f, 0.0f, composer4, 48, 12);
            Modifier modifierPullRefresh$default = PullRefreshKt.pullRefresh$default(SizeKt.fillMaxHeight$default(companion4, 0.0f, 1, null), pullRefreshStateM2815rememberPullRefreshStateUuyPYSY, false, 2, null);
            boolean zChangedInstance2 = composer4.changedInstance(list2) | composer4.changedInstance(navHostController) | composer4.changed(state) | composer4.changed(state2) | composer4.changedInstance(lazyPagingItems) | composer4.changed(state3) | composer4.changedInstance(roomViewModel) | composer4.changedInstance(context) | composer4.changed(state4);
            Object objRememberedValue6 = composer4.rememberedValue();
            if (zChangedInstance2 || objRememberedValue6 == companion7.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0(list2, lazyPagingItems, mutableIntState2, navHostController, state, state2, mutableIntState, roomViewModel, context, snapshotStateList, state3, state4, (LazyListScope) obj);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue6);
            }
            LazyDslKt.LazyColumn(modifierPullRefresh$default, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue6, composer4, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
            PullRefreshIndicatorKt.m2813PullRefreshIndicatorjB83MbM(BigHomeScreen$lambda$18$3$1$1(mutableState2) && !BigHomeScreen$lambda$4(state5), pullRefreshStateM2815rememberPullRefreshStateUuyPYSY, boxScopeInstance.align(companion4, companion5.getTopCenter()), materialTheme.getColorScheme(composer4, i12).getBackground(), materialTheme.getColorScheme(composer4, i12).getPrimary(), false, composer4, PullRefreshState.$stable << 3, 32);
            Boolean boolValueOf = Boolean.valueOf(BigHomeScreen$lambda$18$3$1$1(mutableState2));
            boolean zChangedInstance3 = composer4.changedInstance(roomViewModel);
            Object objRememberedValue7 = composer4.rememberedValue();
            if (zChangedInstance3 || objRememberedValue7 == companion7.getEmpty()) {
                eVar = null;
                objRememberedValue7 = new BigHomeScreenKt$BigHomeScreen$4$1$2$2$1(roomViewModel, mutableState2, null);
                composer4.updateRememberedValue(objRememberedValue7);
            } else {
                eVar = null;
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue7, composer4, 0);
            composer4.endNode();
            composer4.endNode();
            String strStringResource = StringResources_androidKt.stringResource(R.string.clear_all_histories_question, composer4, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.this_action_cant_be_undone, composer4, 0);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.ok, composer4, 0);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.no, composer4, 0);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Object objRememberedValue8 = composer4.rememberedValue();
            if (objRememberedValue8 == companion7.getEmpty()) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.d0
                    @Override // lb.a
                    public final Object invoke() {
                        return BigHomeScreenKt.BigHomeScreen$lambda$18$4$0(mutableState);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue8);
            }
            lb.a aVar2 = (lb.a) objRememberedValue8;
            boolean zChangedInstance4 = composer4.changedInstance(roomViewModel);
            Object objRememberedValue9 = composer4.rememberedValue();
            if (zChangedInstance4 || objRememberedValue9 == companion7.getEmpty()) {
                snapshotStateList2 = snapshotStateList;
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.e0
                    @Override // lb.a
                    public final Object invoke() {
                        return BigHomeScreenKt.BigHomeScreen$lambda$18$5$0(snapshotStateList2, roomViewModel);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue9);
            } else {
                snapshotStateList2 = snapshotStateList;
            }
            Z17DialogsKt.Z17DialogWithActions(zBooleanValue, aVar2, (lb.a) objRememberedValue9, null, strStringResource, strStringResource2, strStringResource3, strStringResource4, composer4, 48, 8);
            if (snapshotStateList2.isEmpty()) {
                composer4.startReplaceGroup(-263582266);
                composer4.endReplaceGroup();
            } else {
                composer4.startReplaceGroup(-263662029);
                Object objRememberedValue10 = composer4.rememberedValue();
                if (objRememberedValue10 == companion7.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.f0
                        @Override // lb.a
                        public final Object invoke() {
                            return BigHomeScreenKt.BigHomeScreen$lambda$18$6$0(snapshotStateList2);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue10);
                }
                BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue10, composer4, 48, 1);
                composer4.endReplaceGroup();
            }
            ua.k0 k0Var = ua.k0.f43947a;
            boolean zChanged = composer4.changed(aVar) | composer4.changedInstance(context);
            Object objRememberedValue11 = composer4.rememberedValue();
            if (zChanged || objRememberedValue11 == companion7.getEmpty()) {
                objRememberedValue11 = new BigHomeScreenKt$BigHomeScreen$4$5$1(aVar, context, eVar);
                composer4.updateRememberedValue(objRememberedValue11);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue11, composer4, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$0$0$0$0(pe.m0 m0Var, NavHostController navHostController, DrawerNavItem drawerNavItem) {
        pe.k.d(m0Var, null, null, new BigHomeScreenKt$BigHomeScreen$4$1$1$1$1$1$1(navHostController, drawerNavItem, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$18$3$0$0$1(DrawerNavItem drawerNavItem, ColumnScope Card, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Card, "$this$Card");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1717729391, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigHomeScreen.kt:403)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(companion, Dp.m8823constructorimpl(16), Dp.m8823constructorimpl(8));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composer, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1726paddingVpY3zN4);
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
            float f10 = 24;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f10));
            Object icon = drawerNavItem.getIcon();
            kotlin.jvm.internal.y.f(icon);
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, icon, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null), drawerNavItem.getName(), null, 0L, 0, 0, composer, 6, 60);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigHomeScreen$lambda$18$3$1$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigHomeScreen$lambda$18$3$1$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$3$0(MutableState mutableState) {
        BigHomeScreen$lambda$18$3$1$2(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0(final List list, final LazyPagingItems lazyPagingItems, final MutableIntState mutableIntState, final NavHostController navHostController, State state, final State state2, final MutableIntState mutableIntState2, final RoomViewModel roomViewModel, final Context context, final SnapshotStateList snapshotStateList, final State state3, final State state4, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        if (mutableIntState.getIntValue() < list.size()) {
            LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1731739062, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.g0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$0(list, navHostController, mutableIntState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        if (kotlin.jvm.internal.y.d(BigHomeScreen$lambda$10(state), Boolean.TRUE)) {
            LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1329707411, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.h0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$1(navHostController, state2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        LazyListScope.CC.s(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1896063527, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.i0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$2(mutableIntState2, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$3((RoomItemView) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$4((RoomItemView) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(161312036, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.l0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5(lazyPagingItems, roomViewModel, navHostController, context, snapshotStateList, state3, state4, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-783240933, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.m0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$6(lazyPagingItems, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.CC.m(LazyColumn, null, null, ComposableSingletons$BigHomeScreenKt.INSTANCE.m9965getLambda$158894958$app_productionPFast(), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$0(List list, final NavHostController navHostController, MutableIntState mutableIntState, LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if ((i10 & 6) == 0) {
            i10 |= composer.changed(item) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1731739062, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigHomeScreen.kt:452)");
            }
            Modifier modifierC = androidx.compose.foundation.lazy.g.c(item, Modifier.INSTANCE, null, null, null, 2, null);
            int intValue = mutableIntState.getIntValue();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.c
                    @Override // lb.a
                    public final Object invoke() {
                        return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$0$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            RoomTooltipKt.RoomTooltip(modifierC, intValue, list, (lb.a) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$0$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.NEWS, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$1(final NavHostController navHostController, State state, LazyItemScope item, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1329707411, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigHomeScreen.kt:464)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(15), Dp.m8823constructorimpl(8));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical spaceBetween = arrangement.getSpaceBetween();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, companion2.getTop(), composer, 6);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1726paddingVpY3zN4);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String strStringResource = StringResources_androidKt.stringResource(R.string.messages, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            TextStyle bodyMedium = materialTheme.getTypography(composer, i12).getBodyMedium();
            FontWeight.Companion companion4 = FontWeight.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, TextStyle.m8271copyp1EtxEg$default(bodyMedium, 0L, 0L, companion4.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 0, composer, 0, 57);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.e
                    @Override // lb.a
                    public final Object invoke() {
                        return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$1$0$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            if (BigHomeScreen$lambda$15(state) > 0) {
                composer.startReplaceGroup(443913979);
                i11 = i12;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, "(" + BigHomeScreen$lambda$15(state) + ") ", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i12).getBodyMedium(), 0L, 0L, companion4.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), materialTheme.getColorScheme(composer, i12).getPrimary(), 0, 0, composer, 0, 49);
                composer.endReplaceGroup();
            } else {
                i11 = i12;
                composer.startReplaceGroup(444368749);
                composer.endReplaceGroup();
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.requests, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0L, companion4.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), materialTheme.getColorScheme(composer, i11).getPrimary(), 0, 0, composer, 0, 49);
            composer.endNode();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$1$0$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.REQUEST_ROOMS, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$2(final MutableIntState mutableIntState, LazyItemScope stickyHeader, int i10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(stickyHeader, "$this$stickyHeader");
        if (composer.shouldExecute((i11 & TsExtractor.TS_STREAM_TYPE_AC3) != 128, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1896063527, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigHomeScreen.kt:501)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            int intValue = mutableIntState.getIntValue();
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$2$0$0(mutableIntState, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            SelectTypeKt.SelectType(companion, intValue, (Function1) objRememberedValue, composer, 390, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$2$0$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object BigHomeScreen$lambda$18$3$1$4$0$3(RoomItemView r10) {
        kotlin.jvm.internal.y.i(r10, "r");
        return r10.getIdOnList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object BigHomeScreen$lambda$18$3$1$4$0$4(RoomItemView it) {
        kotlin.jvm.internal.y.i(it, "it");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$5(LazyPagingItems lazyPagingItems, final RoomViewModel roomViewModel, final NavHostController navHostController, Context context, final SnapshotStateList snapshotStateList, final State state, State state2, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        long jM5865copywmQWz5c$default;
        final State state3;
        Message message;
        User senderUser;
        Message message2;
        kotlin.jvm.internal.y.i(items, "$this$items");
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
                ComposerKt.traceEventStart(161312036, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigHomeScreen.kt:515)");
            }
            final RoomItemView roomItemView = (RoomItemView) lazyPagingItems.get(i10);
            if (roomItemView != null) {
                composer.startReplaceGroup(-421199335);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.m
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$0$0(snapshotStateList, roomItemView));
                        }
                    });
                    composer.updateRememberedValue(objRememberedValue);
                }
                State state4 = (State) objRememberedValue;
                boolean zChanged = composer.changed(roomItemView.getRoom().getDraft());
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.n
                        @Override // lb.a
                        public final Object invoke() {
                            return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$2$0(roomItemView, state);
                        }
                    });
                    composer.updateRememberedValue(objRememberedValue2);
                }
                State state5 = (State) objRememberedValue2;
                float f10 = 3;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(androidx.compose.foundation.lazy.g.c(items, Modifier.INSTANCE, null, null, null, 2, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(f10), 0.0f, Dp.m8823constructorimpl(f10), 4, null);
                if (BigHomeScreen$lambda$18$3$1$4$0$5$0$1(state4)) {
                    composer.startReplaceGroup(-842836142);
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    composer.startReplaceGroup(-842837876);
                    jM5865copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground();
                }
                composer.endReplaceGroup();
                float f11 = 15;
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1729paddingqDBjuR0$default, jM5865copywmQWz5c$default, RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f11), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 6, null));
                boolean zChanged2 = composer.changed(roomItemView);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                    state3 = state4;
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.o
                        @Override // lb.a
                        public final Object invoke() {
                            return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$4$0(snapshotStateList, roomItemView, state3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                } else {
                    state3 = state4;
                }
                lb.a aVar = (lb.a) objRememberedValue3;
                boolean zChanged3 = composer.changed(roomItemView) | composer.changedInstance(roomViewModel) | composer.changedInstance(navHostController);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                    final State state6 = state3;
                    Object obj = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.p
                        @Override // lb.a
                        public final Object invoke() {
                            return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$5$0(snapshotStateList, roomItemView, roomViewModel, state6, navHostController);
                        }
                    };
                    composer.updateRememberedValue(obj);
                    objRememberedValue4 = obj;
                }
                Modifier modifierM1250combinedClickablehoGz1lA$default = ClickableKt.m1250combinedClickablehoGz1lA$default(modifierM1204backgroundbw27NRU, false, null, null, null, aVar, null, false, null, (lb.a) objRememberedValue4, 239, null);
                composer.startReplaceGroup(402203130);
                String name = roomItemView.getName();
                if (le.d0.q0(name)) {
                    name = StringResources_androidKt.stringResource(R.string.loading_hint, composer, 0);
                }
                composer.endReplaceGroup();
                String thumbnail = roomItemView.getThumbnail();
                String shortMsg = ExtensionFunsKt.toShortMsg(roomItemView, context, roomViewModel.getOwner().getNameWithDomain(), roomViewModel.getOwner().getAlias());
                String string = roomItemView.getLastUpdate().toString();
                MessageWithPartnerWithReactions lastMessage = roomItemView.getLastMessage();
                if (lastMessage != null && (message2 = lastMessage.getMessage()) != null && message2.getState() == 2) {
                    User senderUser2 = roomItemView.getLastMessage().getSenderUser();
                    if (!kotlin.jvm.internal.y.d(senderUser2 != null ? senderUser2.getUid() : null, roomViewModel.getOwner().getNameWithDomain()) && roomItemView.getLastMessage().getMessage().getPayload() == null) {
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
                boolean zD = kotlin.jvm.internal.y.d((lastMessage2 == null || (senderUser = lastMessage2.getSenderUser()) == null) ? null : senderUser.getUid(), roomViewModel.getOwner().getNameWithDomain());
                MessageWithPartnerWithReactions lastMessage3 = roomItemView.getLastMessage();
                Integer numValueOf = (lastMessage3 == null || (message = lastMessage3.getMessage()) == null) ? null : Integer.valueOf(message.getState());
                String str2 = name;
                boolean zContains = BigHomeScreen$lambda$0(state2).contains(roomItemView.getRoom().getId());
                RoomItemState roomItemStateBigHomeScreen$lambda$18$3$1$4$0$5$0$3 = BigHomeScreen$lambda$18$3$1$4$0$5$0$3(state5);
                MessageWithPartnerWithReactions lastMessage4 = roomItemView.getLastMessage();
                List<Reaction> reactions = lastMessage4 != null ? lastMessage4.getReactions() : null;
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$7$0(navHostController, (String) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                Function1 function1 = (Function1) objRememberedValue5;
                boolean zChangedInstance2 = composer.changedInstance(roomViewModel) | composer.changed(roomItemView) | composer.changedInstance(navHostController);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.r
                        @Override // lb.a
                        public final Object invoke() {
                            return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$8$0(roomViewModel, roomItemView, navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                RoomItemKt.RoomItem(modifierM1250combinedClickablehoGz1lA$default, str2, thumbnail, shortMsg, string, z10, str, type, pined, id2, numValueOf, zD, roomItemStateBigHomeScreen$lambda$18$3$1$4$0$5$0$3, zContains, reactions, function1, (lb.a) objRememberedValue6, composer, 0, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(402294516);
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
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigHomeScreen$lambda$18$3$1$4$0$5$0$0$0(SnapshotStateList snapshotStateList, RoomItemView roomItemView) {
        ArrayList arrayList = new ArrayList(va.x.y(snapshotStateList, 10));
        Iterator<T> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(((RoomItemView) it.next()).getRoom().getId());
        }
        return arrayList.contains(roomItemView.getRoom().getId());
    }

    private static final boolean BigHomeScreen$lambda$18$3$1$4$0$5$0$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomItemState BigHomeScreen$lambda$18$3$1$4$0$5$0$2$0(RoomItemView roomItemView, State state) {
        if (BigHomeScreen$lambda$14(state).containsKey(roomItemView.getRoom().getId())) {
            return RoomItemState.TYPING;
        }
        return !le.d0.q0(roomItemView.getRoom().getDraft()) ? RoomItemState.DRAFT : RoomItemState.REGULAR;
    }

    private static final RoomItemState BigHomeScreen$lambda$18$3$1$4$0$5$0$3(State<? extends RoomItemState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$5$0$4$0(SnapshotStateList snapshotStateList, RoomItemView roomItemView, State state) {
        if (!BigHomeScreen$lambda$18$3$1$4$0$5$0$1(state)) {
            snapshotStateList.add(roomItemView);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$5$0$5$0(SnapshotStateList snapshotStateList, final RoomItemView roomItemView, final RoomViewModel roomViewModel, State state, final NavHostController navHostController) {
        if (BigHomeScreen$lambda$18$3$1$4$0$5$0$1(state)) {
            final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$5$0$0(roomItemView, (RoomItemView) obj));
                }
            };
            Collection.EL.removeIf(snapshotStateList, new Predicate() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.l
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate$CC.$default$and(this, predicate);
                }

                public /* synthetic */ Predicate negate() {
                    return Predicate$CC.$default$negate(this);
                }

                @Override // java.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate$CC.$default$or(this, predicate);
                }

                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$5$0$1(function1, obj);
                }
            });
        } else if (snapshotStateList.isEmpty()) {
            roomViewModel.goOnUnreadPosition(roomItemView.getRoom().getId(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.w
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$5$0$2(navHostController, roomItemView, roomViewModel, ((Integer) obj).intValue());
                }
            });
        } else {
            snapshotStateList.add(roomItemView);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigHomeScreen$lambda$18$3$1$4$0$5$0$5$0$0(RoomItemView roomItemView, RoomItemView it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getRoom().getId(), roomItemView.getRoom().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigHomeScreen$lambda$18$3$1$4$0$5$0$5$0$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$5$0$5$0$2(NavHostController navHostController, RoomItemView roomItemView, RoomViewModel roomViewModel, int i10) {
        NavLinks navLinks = NavLinks.INSTANCE;
        XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
        int chatType = xMPPUtils.getChatType(roomItemView.getRoom().getId());
        String strT = roomViewModel.getGson().t(new ChatParams(roomItemView.getRoom().getId(), xMPPUtils.getChatType(roomItemView.getRoom().getId()), va.w.n(), i10));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goChat(chatType, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$5$0$7$0(NavHostController navHostController, String prev) {
        kotlin.jvm.internal.y.i(prev, "prev");
        NavController.navigate$default((NavController) navHostController, prev, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$5$0$8$0(final RoomViewModel roomViewModel, RoomItemView roomItemView, final NavHostController navHostController) {
        roomViewModel.searchForStatus(roomItemView.getRoom().getId(), new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.home.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BigHomeScreenKt.BigHomeScreen$lambda$18$3$1$4$0$5$0$8$0$0(navHostController, roomViewModel, ((Integer) obj).intValue(), (String) obj2);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$5$0$8$0$0(NavHostController navHostController, RoomViewModel roomViewModel, int i10, String id2) {
        kotlin.jvm.internal.y.i(id2, "id");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = roomViewModel.getGson().t(new StatusPreviewParams(false, i10, id2));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 BigHomeScreen$lambda$18$3$1$4$0$6(LazyPagingItems lazyPagingItems, LazyItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-783240933, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigHomeScreen.kt:639)");
            }
            PagerStateIndicatorKt.PagerStateIndicator(null, null, null, null, lazyPagingItems, composer, LazyPagingItems.$stable << 12, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$4$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$5$0(SnapshotStateList snapshotStateList, RoomViewModel roomViewModel) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(((RoomItemView) it.next()).getRoom().getId());
        }
        roomViewModel.clearHistoryFromRooms(arrayList);
        snapshotStateList.clear();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$18$6$0(SnapshotStateList snapshotStateList) {
        snapshotStateList.clear();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigHomeScreen$lambda$19(NavHostController navHostController, RoomViewModel roomViewModel, int i10, int i11, Composer composer, int i12) {
        BigHomeScreen(navHostController, roomViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    private static final boolean BigHomeScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean BigHomeScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigHomeScreen$lambda$8$0(LazyListState lazyListState) {
        return lazyListState.getFirstVisibleItemIndex() == 0;
    }

    private static final boolean BigHomeScreen$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
