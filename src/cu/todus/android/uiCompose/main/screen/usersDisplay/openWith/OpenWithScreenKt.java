package cu.todus.android.uiCompose.main.screen.usersDisplay.openWith;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.ErrorKt;
import androidx.compose.material.icons.outlined.RefreshKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TabRowKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
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
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.UserCommon;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupParams;
import cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel;
import cu.todus.android.uiCompose.main.screen.usersDisplay.RefreshContactsState;
import cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBarKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.userCommonList.ContactItemKt;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.floatingMutilple.Z17MultipleFabObj;
import cu.z17.views.floatingMutilple.Z17MultipleFabViewKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.tab.Z17TabKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a5\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001f²\u0006\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00168\nX\u008a\u0084\u0002²\u0006\f\u0010\u0019\u001a\u00020\u00188\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001c\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\u001d8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/usersDisplay/ContactsViewModel;", "viewModel", "Lua/k0;", "OpenWithScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/usersDisplay/ContactsViewModel;Landroidx/compose/runtime/Composer;II)V", "", "message", "", "isSuccess", "Landroidx/compose/ui/Modifier;", "modifier", "StatusCard", "(Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "isSearching", "Lcu/todus/android/data/db/pojo/Partner;", "partner", "Lkotlin/Function1;", "openChat", "UserByToDusId", "(ZLcu/todus/android/data/db/pojo/Partner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/data/wrapper/FlowsState;", "partnerRequest", "Lcu/todus/android/uiCompose/main/screen/usersDisplay/RefreshContactsState;", "refreshState", "contactsPermissionWasGranted", "showStatusCard", "statusCardMessage", "", "tabIndex", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OpenWithScreenKt {
    /* JADX WARN: Code duplicated, block: B:100:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:103:0x035c  */
    /* JADX WARN: Code duplicated, block: B:106:0x037d  */
    /* JADX WARN: Code duplicated, block: B:109:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:111:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:114:0x0405  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:56:0x0104  */
    /* JADX WARN: Code duplicated, block: B:57:0x0108  */
    /* JADX WARN: Code duplicated, block: B:60:0x0155  */
    /* JADX WARN: Code duplicated, block: B:63:0x016a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0187  */
    /* JADX WARN: Code duplicated, block: B:68:0x018d  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:73:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:76:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:79:0x0212  */
    /* JADX WARN: Code duplicated, block: B:82:0x0245  */
    /* JADX WARN: Code duplicated, block: B:85:0x025b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0271  */
    /* JADX WARN: Code duplicated, block: B:91:0x0290  */
    /* JADX WARN: Code duplicated, block: B:93:0x0296  */
    /* JADX WARN: Code duplicated, block: B:98:0x02c4  */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v4, types: [boolean, int] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void OpenWithScreen(final NavHostController navHostController, ContactsViewModel contactsViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final ContactsViewModel contactsViewModel2;
        final NavHostController navHostController2;
        boolean z10;
        int i13;
        ContactsViewModel contactsViewModel3;
        ?? r14;
        lb.a constructor;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        boolean zChanged;
        Object objRememberedValue3;
        boolean zChanged2;
        Object objRememberedValue4;
        final State stateCollectAsStateWithLifecycle;
        Composer composer2;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        MutableState mutableState2;
        Object objRememberedValue8;
        final MutableState mutableState3;
        Object objRememberedValue9;
        final MutableState mutableState4;
        boolean zChanged3;
        Object objRememberedValue10;
        final ContactsViewModel contactsViewModel4;
        Composer composer3;
        boolean zChangedInstance;
        Object objRememberedValue11;
        Composer composer4;
        final ContactsViewModel contactsViewModel5;
        Object objRememberedValue12;
        Object objRememberedValue13;
        boolean zChangedInstance2;
        Object objRememberedValue14;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(442080067);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                contactsViewModel2 = contactsViewModel;
                int i14 = composerStartRestartGroup.changedInstance(contactsViewModel2) ? 32 : 16;
                i12 |= i14;
            } else {
                contactsViewModel2 = contactsViewModel;
            }
            i12 |= i14;
        } else {
            contactsViewModel2 = contactsViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 2) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    z10 = false;
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(ContactsViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    contactsViewModel2 = (ContactsViewModel) viewModel;
                    i12 &= -113;
                }
                ContactsViewModel contactsViewModel6 = contactsViewModel2;
                i13 = i12;
                contactsViewModel3 = contactsViewModel6;
                r14 = z10;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(442080067, i13, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen (OpenWithScreen.kt:88)");
                }
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                Alignment.Companion companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), r14);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, r14));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                constructor = companion4.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, r14, 3);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue2;
                zChanged = composerStartRestartGroup.changed((String) mutableState.getValue());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = contactsViewModel3.friendsOnDb((String) mutableState.getValue());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                te.h hVar = (te.h) objRememberedValue3;
                zChanged2 = composerStartRestartGroup.changed((String) mutableState.getValue());
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = contactsViewModel3.usersOnDb((String) mutableState.getValue());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(hVar, null, composerStartRestartGroup, r14, 1);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems((te.h) objRememberedValue4, null, composerStartRestartGroup, r14, 1);
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(contactsViewModel3.getRequestingPartner(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(contactsViewModel3.getRefreshState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                composer2 = composerStartRestartGroup;
                objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState6 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.v.e(PermissionNeedIt.CONTACT), 1, null), null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState7 = (MutableState) objRememberedValue6;
                final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer2, 0, 3);
                final LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composer2, 0, 3);
                objRememberedValue7 = composer2.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                mutableState2 = (MutableState) objRememberedValue7;
                objRememberedValue8 = composer2.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                mutableState3 = (MutableState) objRememberedValue8;
                objRememberedValue9 = composer2.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                mutableState4 = (MutableState) objRememberedValue9;
                RefreshContactsState refreshContactsStateOpenWithScreen$lambda$0$5 = OpenWithScreen$lambda$0$5(stateCollectAsStateWithLifecycle);
                zChanged3 = composer2.changed(stateCollectAsStateWithLifecycle) | composer2.changedInstance(contactsViewModel3);
                objRememberedValue10 = composer2.rememberedValue();
                if (!zChanged3 || objRememberedValue10 == companion.getEmpty()) {
                    contactsViewModel4 = contactsViewModel3;
                    composer3 = composer2;
                    OpenWithScreenKt$OpenWithScreen$1$1$1 openWithScreenKt$OpenWithScreen$1$1$1 = new OpenWithScreenKt$OpenWithScreen$1$1$1(contactsViewModel4, stateCollectAsStateWithLifecycle, mutableState3, mutableState4, mutableState2, null);
                    composer3.updateRememberedValue(openWithScreenKt$OpenWithScreen$1$1$1);
                    objRememberedValue10 = openWithScreenKt$OpenWithScreen$1$1$1;
                } else {
                    contactsViewModel4 = contactsViewModel3;
                    composer3 = composer2;
                }
                EffectsKt.LaunchedEffect(refreshContactsStateOpenWithScreen$lambda$0$5, (Function2) objRememberedValue10, composer3, 0);
                ua.k0 k0Var = ua.k0.f43947a;
                zChangedInstance = composer3.changedInstance(contactsViewModel4);
                objRememberedValue11 = composer3.rememberedValue();
                if (zChangedInstance || objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = new OpenWithScreenKt$OpenWithScreen$1$2$1(contactsViewModel4, null);
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue11, composer3, 6);
                composer4 = composer3;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(20893973, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.f
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$21(mutableState5, navHostController, mutableState, contactsViewModel4, mutableState6, stateCollectAsStateWithLifecycle, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(330209345, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$22(navHostController, context, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer4, 54);
                contactsViewModel5 = contactsViewModel4;
                navHostController2 = navHostController;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, true, false, composableLambdaRememberComposableLambda2, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(546410707, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$23(contactsViewModel5, lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems, navHostController, lazyListStateRememberLazyListState2, lazyPagingItemsCollectAsLazyPagingItems2, mutableState7, mutableState6, mutableState, stateCollectAsStateWithLifecycle2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54), composer4, 805331382, 360);
                boolean zOpenWithScreen$lambda$0$11 = OpenWithScreen$lambda$0$11(mutableState2);
                objRememberedValue12 = composer4.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(OpenWithScreenKt.OpenWithScreen$lambda$0$24$0(((Integer) obj).intValue()));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue12);
                }
                EnterTransition enterTransitionPlus = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue12, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                objRememberedValue13 = composer4.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(OpenWithScreenKt.OpenWithScreen$lambda$0$25$0(((Integer) obj).intValue()));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue13);
                }
                ExitTransition exitTransitionPlus = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue13, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                float f10 = 16;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getTopCenter()), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(80), Dp.m8823constructorimpl(f10), 0.0f, 8, null);
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1352726111, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$26(mutableState3, mutableState4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                composerStartRestartGroup = composer4;
                AnimatedVisibilityKt.AnimatedVisibility(zOpenWithScreen$lambda$0$11, modifierM1729paddingqDBjuR0$default, enterTransitionPlus, exitTransitionPlus, (String) null, composableLambdaRememberComposableLambda3, composerStartRestartGroup, 200064, 16);
                Object value = mutableState.getValue();
                zChangedInstance2 = composerStartRestartGroup.changedInstance(contactsViewModel5);
                objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = new OpenWithScreenKt$OpenWithScreen$1$9$1(mutableState, contactsViewModel5, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                }
                EffectsKt.LaunchedEffect(value, (Function2) objRememberedValue14, composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contactsViewModel2 = contactsViewModel5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    ContactsViewModel contactsViewModel7 = contactsViewModel2;
                    i13 = i12 & (-113);
                    contactsViewModel3 = contactsViewModel7;
                    r14 = 0;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(442080067, i13, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen (OpenWithScreen.kt:88)");
                }
                Modifier.Companion companion5 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion5, 0.0f, 1, null);
                Alignment.Companion companion6 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion6.getTopStart(), r14);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, r14));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
                ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                constructor = companion7.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion7.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion7.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion7.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion7.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, r14, 3);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState8 = (MutableState) objRememberedValue2;
                zChanged = composerStartRestartGroup.changed((String) mutableState.getValue());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = contactsViewModel3.friendsOnDb((String) mutableState.getValue());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = contactsViewModel3.friendsOnDb((String) mutableState.getValue());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                te.h hVar2 = (te.h) objRememberedValue3;
                zChanged2 = composerStartRestartGroup.changed((String) mutableState.getValue());
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = contactsViewModel3.usersOnDb((String) mutableState.getValue());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = contactsViewModel3.usersOnDb((String) mutableState.getValue());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems3 = LazyPagingItemsKt.collectAsLazyPagingItems(hVar2, null, composerStartRestartGroup, r14, 1);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems4 = LazyPagingItemsKt.collectAsLazyPagingItems((te.h) objRememberedValue4, null, composerStartRestartGroup, r14, 1);
                final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(contactsViewModel3.getRequestingPartner(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(contactsViewModel3.getRefreshState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                composer2 = composerStartRestartGroup;
                objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState9 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.v.e(PermissionNeedIt.CONTACT), 1, null), null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState10 = (MutableState) objRememberedValue6;
                final LazyListState lazyListStateRememberLazyListState3 = LazyListStateKt.rememberLazyListState(0, 0, composer2, 0, 3);
                final LazyListState lazyListStateRememberLazyListState4 = LazyListStateKt.rememberLazyListState(0, 0, composer2, 0, 3);
                objRememberedValue7 = composer2.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                mutableState2 = (MutableState) objRememberedValue7;
                objRememberedValue8 = composer2.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                mutableState3 = (MutableState) objRememberedValue8;
                objRememberedValue9 = composer2.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                mutableState4 = (MutableState) objRememberedValue9;
                RefreshContactsState refreshContactsStateOpenWithScreen$lambda$0$6 = OpenWithScreen$lambda$0$5(stateCollectAsStateWithLifecycle);
                zChanged3 = composer2.changed(stateCollectAsStateWithLifecycle) | composer2.changedInstance(contactsViewModel3);
                objRememberedValue10 = composer2.rememberedValue();
                if (zChanged3) {
                    contactsViewModel4 = contactsViewModel3;
                    composer3 = composer2;
                    OpenWithScreenKt$OpenWithScreen$1$1$1 openWithScreenKt$OpenWithScreen$1$1$2 = new OpenWithScreenKt$OpenWithScreen$1$1$1(contactsViewModel4, stateCollectAsStateWithLifecycle, mutableState3, mutableState4, mutableState2, null);
                    composer3.updateRememberedValue(openWithScreenKt$OpenWithScreen$1$1$2);
                    objRememberedValue10 = openWithScreenKt$OpenWithScreen$1$1$2;
                } else {
                    contactsViewModel4 = contactsViewModel3;
                    composer3 = composer2;
                    OpenWithScreenKt$OpenWithScreen$1$1$1 openWithScreenKt$OpenWithScreen$1$1$3 = new OpenWithScreenKt$OpenWithScreen$1$1$1(contactsViewModel4, stateCollectAsStateWithLifecycle, mutableState3, mutableState4, mutableState2, null);
                    composer3.updateRememberedValue(openWithScreenKt$OpenWithScreen$1$1$3);
                    objRememberedValue10 = openWithScreenKt$OpenWithScreen$1$1$3;
                }
                EffectsKt.LaunchedEffect(refreshContactsStateOpenWithScreen$lambda$0$6, (Function2) objRememberedValue10, composer3, 0);
                ua.k0 k0Var2 = ua.k0.f43947a;
                zChangedInstance = composer3.changedInstance(contactsViewModel4);
                objRememberedValue11 = composer3.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue11 = new OpenWithScreenKt$OpenWithScreen$1$2$1(contactsViewModel4, null);
                    composer3.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new OpenWithScreenKt$OpenWithScreen$1$2$1(contactsViewModel4, null);
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue11, composer3, 6);
                composer4 = composer3;
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(20893973, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.f
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$21(mutableState8, navHostController, mutableState, contactsViewModel4, mutableState9, stateCollectAsStateWithLifecycle, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(330209345, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$22(navHostController, context2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer4, 54);
                contactsViewModel5 = contactsViewModel4;
                navHostController2 = navHostController;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda4, false, true, false, composableLambdaRememberComposableLambda5, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(546410707, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$23(contactsViewModel5, lazyListStateRememberLazyListState3, lazyPagingItemsCollectAsLazyPagingItems3, navHostController, lazyListStateRememberLazyListState4, lazyPagingItemsCollectAsLazyPagingItems4, mutableState10, mutableState9, mutableState, stateCollectAsStateWithLifecycle3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54), composer4, 805331382, 360);
                boolean zOpenWithScreen$lambda$0$12 = OpenWithScreen$lambda$0$11(mutableState2);
                objRememberedValue12 = composer4.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(OpenWithScreenKt.OpenWithScreen$lambda$0$24$0(((Integer) obj).intValue()));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue12);
                }
                EnterTransition enterTransitionPlus2 = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue12, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                objRememberedValue13 = composer4.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(OpenWithScreenKt.OpenWithScreen$lambda$0$25$0(((Integer) obj).intValue()));
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue13);
                }
                ExitTransition exitTransitionPlus2 = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue13, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                float f11 = 16;
                Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance2.align(companion5, companion6.getTopCenter()), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(80), Dp.m8823constructorimpl(f11), 0.0f, 8, null);
                ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-1352726111, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$26(mutableState3, mutableState4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                composerStartRestartGroup = composer4;
                AnimatedVisibilityKt.AnimatedVisibility(zOpenWithScreen$lambda$0$12, modifierM1729paddingqDBjuR0$default2, enterTransitionPlus2, exitTransitionPlus2, (String) null, composableLambdaRememberComposableLambda6, composerStartRestartGroup, 200064, 16);
                Object value2 = mutableState.getValue();
                zChangedInstance2 = composerStartRestartGroup.changedInstance(contactsViewModel5);
                objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue14 = new OpenWithScreenKt$OpenWithScreen$1$9$1(mutableState, contactsViewModel5, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                } else {
                    objRememberedValue14 = new OpenWithScreenKt$OpenWithScreen$1$9$1(mutableState, contactsViewModel5, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                }
                EffectsKt.LaunchedEffect(value2, (Function2) objRememberedValue14, composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contactsViewModel2 = contactsViewModel5;
            }
            z10 = false;
            ContactsViewModel contactsViewModel8 = contactsViewModel2;
            i13 = i12;
            contactsViewModel3 = contactsViewModel8;
            r14 = z10;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442080067, i13, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen (OpenWithScreen.kt:88)");
            }
            Modifier.Companion companion8 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion8, 0.0f, 1, null);
            Alignment.Companion companion9 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion9.getTopStart(), r14);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, r14));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default3);
            ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
            constructor = companion10.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion10.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion10.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion10.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion10.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion10.getSetModifier());
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            final Context context3 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ScaffoldState scaffoldStateRememberScaffoldState3 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, r14, 3);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState11 = (MutableState) objRememberedValue2;
            zChanged = composerStartRestartGroup.changed((String) mutableState.getValue());
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = contactsViewModel3.friendsOnDb((String) mutableState.getValue());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = contactsViewModel3.friendsOnDb((String) mutableState.getValue());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            te.h hVar3 = (te.h) objRememberedValue3;
            zChanged2 = composerStartRestartGroup.changed((String) mutableState.getValue());
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue4 = contactsViewModel3.usersOnDb((String) mutableState.getValue());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = contactsViewModel3.usersOnDb((String) mutableState.getValue());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems5 = LazyPagingItemsKt.collectAsLazyPagingItems(hVar3, null, composerStartRestartGroup, r14, 1);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems6 = LazyPagingItemsKt.collectAsLazyPagingItems((te.h) objRememberedValue4, null, composerStartRestartGroup, r14, 1);
            final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(contactsViewModel3.getRequestingPartner(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(contactsViewModel3.getRefreshState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            composer2 = composerStartRestartGroup;
            objRememberedValue5 = composer2.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState12 = (MutableState) objRememberedValue5;
            objRememberedValue6 = composer2.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.v.e(PermissionNeedIt.CONTACT), 1, null), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState13 = (MutableState) objRememberedValue6;
            final LazyListState lazyListStateRememberLazyListState5 = LazyListStateKt.rememberLazyListState(0, 0, composer2, 0, 3);
            final LazyListState lazyListStateRememberLazyListState6 = LazyListStateKt.rememberLazyListState(0, 0, composer2, 0, 3);
            objRememberedValue7 = composer2.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue7);
            }
            mutableState2 = (MutableState) objRememberedValue7;
            objRememberedValue8 = composer2.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer2.updateRememberedValue(objRememberedValue8);
            }
            mutableState3 = (MutableState) objRememberedValue8;
            objRememberedValue9 = composer2.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue9);
            }
            mutableState4 = (MutableState) objRememberedValue9;
            RefreshContactsState refreshContactsStateOpenWithScreen$lambda$0$7 = OpenWithScreen$lambda$0$5(stateCollectAsStateWithLifecycle);
            zChanged3 = composer2.changed(stateCollectAsStateWithLifecycle) | composer2.changedInstance(contactsViewModel3);
            objRememberedValue10 = composer2.rememberedValue();
            if (zChanged3) {
                contactsViewModel4 = contactsViewModel3;
                composer3 = composer2;
                OpenWithScreenKt$OpenWithScreen$1$1$1 openWithScreenKt$OpenWithScreen$1$1$4 = new OpenWithScreenKt$OpenWithScreen$1$1$1(contactsViewModel4, stateCollectAsStateWithLifecycle, mutableState3, mutableState4, mutableState2, null);
                composer3.updateRememberedValue(openWithScreenKt$OpenWithScreen$1$1$4);
                objRememberedValue10 = openWithScreenKt$OpenWithScreen$1$1$4;
            } else {
                contactsViewModel4 = contactsViewModel3;
                composer3 = composer2;
                OpenWithScreenKt$OpenWithScreen$1$1$1 openWithScreenKt$OpenWithScreen$1$1$5 = new OpenWithScreenKt$OpenWithScreen$1$1$1(contactsViewModel4, stateCollectAsStateWithLifecycle, mutableState3, mutableState4, mutableState2, null);
                composer3.updateRememberedValue(openWithScreenKt$OpenWithScreen$1$1$5);
                objRememberedValue10 = openWithScreenKt$OpenWithScreen$1$1$5;
            }
            EffectsKt.LaunchedEffect(refreshContactsStateOpenWithScreen$lambda$0$7, (Function2) objRememberedValue10, composer3, 0);
            ua.k0 k0Var3 = ua.k0.f43947a;
            zChangedInstance = composer3.changedInstance(contactsViewModel4);
            objRememberedValue11 = composer3.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue11 = new OpenWithScreenKt$OpenWithScreen$1$2$1(contactsViewModel4, null);
                composer3.updateRememberedValue(objRememberedValue11);
            } else {
                objRememberedValue11 = new OpenWithScreenKt$OpenWithScreen$1$2$1(contactsViewModel4, null);
                composer3.updateRememberedValue(objRememberedValue11);
            }
            EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue11, composer3, 6);
            composer4 = composer3;
            ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(20893973, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OpenWithScreenKt.OpenWithScreen$lambda$0$21(mutableState11, navHostController, mutableState, contactsViewModel4, mutableState12, stateCollectAsStateWithLifecycle, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(330209345, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OpenWithScreenKt.OpenWithScreen$lambda$0$22(navHostController, context3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer4, 54);
            contactsViewModel5 = contactsViewModel4;
            navHostController2 = navHostController;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda7, false, true, false, composableLambdaRememberComposableLambda8, null, 0L, scaffoldStateRememberScaffoldState3, null, ComposableLambdaKt.rememberComposableLambda(546410707, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OpenWithScreenKt.OpenWithScreen$lambda$0$23(contactsViewModel5, lazyListStateRememberLazyListState5, lazyPagingItemsCollectAsLazyPagingItems5, navHostController, lazyListStateRememberLazyListState6, lazyPagingItemsCollectAsLazyPagingItems6, mutableState13, mutableState12, mutableState, stateCollectAsStateWithLifecycle4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), composer4, 805331382, 360);
            boolean zOpenWithScreen$lambda$0$13 = OpenWithScreen$lambda$0$11(mutableState2);
            objRememberedValue12 = composer4.rememberedValue();
            if (objRememberedValue12 == companion.getEmpty()) {
                objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(OpenWithScreenKt.OpenWithScreen$lambda$0$24$0(((Integer) obj).intValue()));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue12);
            }
            EnterTransition enterTransitionPlus3 = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue12, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
            objRememberedValue13 = composer4.rememberedValue();
            if (objRememberedValue13 == companion.getEmpty()) {
                objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(OpenWithScreenKt.OpenWithScreen$lambda$0$25$0(((Integer) obj).intValue()));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue13);
            }
            ExitTransition exitTransitionPlus3 = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue13, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            float f12 = 16;
            Modifier modifierM1729paddingqDBjuR0$default3 = PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance3.align(companion8, companion9.getTopCenter()), Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(80), Dp.m8823constructorimpl(f12), 0.0f, 8, null);
            ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(-1352726111, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OpenWithScreenKt.OpenWithScreen$lambda$0$26(mutableState3, mutableState4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            composerStartRestartGroup = composer4;
            AnimatedVisibilityKt.AnimatedVisibility(zOpenWithScreen$lambda$0$13, modifierM1729paddingqDBjuR0$default3, enterTransitionPlus3, exitTransitionPlus3, (String) null, composableLambdaRememberComposableLambda9, composerStartRestartGroup, 200064, 16);
            Object value3 = mutableState.getValue();
            zChangedInstance2 = composerStartRestartGroup.changedInstance(contactsViewModel5);
            objRememberedValue14 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue14 = new OpenWithScreenKt$OpenWithScreen$1$9$1(mutableState, contactsViewModel5, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
            } else {
                objRememberedValue14 = new OpenWithScreenKt$OpenWithScreen$1$9$1(mutableState, contactsViewModel5, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
            }
            EffectsKt.LaunchedEffect(value3, (Function2) objRememberedValue14, composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contactsViewModel2 = contactsViewModel5;
        } else {
            navHostController2 = navHostController;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OpenWithScreenKt.OpenWithScreen$lambda$1(navHostController2, contactsViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean OpenWithScreen$lambda$0$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OpenWithScreen$lambda$0$12(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final String OpenWithScreen$lambda$0$14(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean OpenWithScreen$lambda$0$17(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OpenWithScreen$lambda$0$18(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$21(final MutableState mutableState, final NavHostController navHostController, final MutableState mutableState2, final ContactsViewModel contactsViewModel, final MutableState mutableState3, final State state, TopAppBarScrollBehavior it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(20893973, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous> (OpenWithScreen.kt:164)");
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer.startReplaceGroup(-317854552);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.m0
                        @Override // lb.a
                        public final Object invoke() {
                            return OpenWithScreenKt.OpenWithScreen$lambda$0$21$0$0(mutableState2, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.n0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OpenWithScreenKt.OpenWithScreen$lambda$0$21$1$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                SearchContactTopBarKt.SearchContactTopBar(navHostController, aVar, (Function1) objRememberedValue2, composer, 432);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-317341812);
                Function2 function2M9999getLambda$983848052$app_productionPFast = ComposableSingletons$OpenWithScreenKt.INSTANCE.m9999getLambda$983848052$app_productionPFast();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1777979071, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.d
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$21$2(contactsViewModel, mutableState, mutableState3, state, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.e
                        @Override // lb.a
                        public final Object invoke() {
                            return OpenWithScreenKt.OpenWithScreen$lambda$0$21$3$0(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9999getLambda$983848052$app_productionPFast, it, false, composableLambdaRememberComposableLambda, false, navHostController, (lb.a) objRememberedValue3, null, 0L, 0L, Dp.m8823constructorimpl(0), composer, ((i11 << 3) & 112) | 3078, 6, 916);
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
    public static final ua.k0 OpenWithScreen$lambda$0$21$0$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue("");
        mutableState2.setValue(Boolean.FALSE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$21$1$0(MutableState mutableState, String f10) {
        kotlin.jvm.internal.y.i(f10, "f");
        mutableState.setValue(f10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$21$2(final ContactsViewModel contactsViewModel, final MutableState mutableState, final MutableState mutableState2, final State state, RowScope Z17TopBar, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1777979071, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous>.<anonymous> (OpenWithScreen.kt:185)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_4 = Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(0));
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(12), 0.0f, 11, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_4, centerVertically, composer, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1729paddingqDBjuR0$default);
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
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.w
                    @Override // lb.a
                    public final Object invoke() {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$21$2$0$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, ComposableSingletons$OpenWithScreenKt.INSTANCE.getLambda$2074458691$app_productionPFast(), composer, 1572918, 60);
            boolean zChangedInstance = composer.changedInstance(contactsViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.x
                    @Override // lb.a
                    public final Object invoke() {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$21$2$0$1$0(contactsViewModel, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, null, !(OpenWithScreen$lambda$0$5(state) instanceof RefreshContactsState.Loading), null, null, null, ComposableLambdaKt.rememberComposableLambda(264058042, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OpenWithScreenKt.OpenWithScreen$lambda$0$21$2$0$2(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 58);
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
    public static final ua.k0 OpenWithScreen$lambda$0$21$2$0$0$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$21$2$0$1$0(ContactsViewModel contactsViewModel, MutableState mutableState) {
        contactsViewModel.updateContactList(OpenWithScreen$lambda$0$7(mutableState), true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$21$2$0$2(State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(264058042, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenWithScreen.kt:209)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1769size3ABfNKs);
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
            if (OpenWithScreen$lambda$0$5(state) instanceof RefreshContactsState.Loading) {
                composer.startReplaceGroup(-1076475516);
                ProgressIndicatorKt.m2699CircularProgressIndicatorLxG7B9w(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), Dp.m8823constructorimpl(2), 0L, 0, composer, 390, 24);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1076109840);
                IconKt.m3298Iconww6aTOc(RefreshKt.getRefresh(Icons.Outlined.INSTANCE), "Actualizar", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
                composer.endReplaceGroup();
            }
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
    public static final ua.k0 OpenWithScreen$lambda$0$21$3$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$22(final NavHostController navHostController, final Context context, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(330209345, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous> (OpenWithScreen.kt:237)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.qr_reader, composer, 0);
            Integer numValueOf = Integer.valueOf(R.drawable.qr_reader);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.m
                    @Override // lb.a
                    public final Object invoke() {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$22$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17MultipleFabObj z17MultipleFabObj = new Z17MultipleFabObj("1", strStringResource, numValueOf, null, null, (lb.a) objRememberedValue, 24, null);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.new_contact, composer, 0);
            Integer numValueOf2 = Integer.valueOf(R.drawable.useradd);
            boolean zChangedInstance2 = composer.changedInstance(context);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.o
                    @Override // lb.a
                    public final Object invoke() {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$22$1$0(context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17MultipleFabObj z17MultipleFabObj2 = new Z17MultipleFabObj(ExifInterface.GPS_MEASUREMENT_2D, strStringResource2, numValueOf2, null, null, (lb.a) objRememberedValue2, 24, null);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.new_group, composer, 0);
            Integer numValueOf3 = Integer.valueOf(R.drawable.newgroup);
            boolean zChangedInstance3 = composer.changedInstance(navHostController);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.p
                    @Override // lb.a
                    public final Object invoke() {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$22$2$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Z17MultipleFabObj z17MultipleFabObj3 = new Z17MultipleFabObj(ExifInterface.GPS_MEASUREMENT_3D, strStringResource3, numValueOf3, null, null, (lb.a) objRememberedValue3, 24, null);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.new_channel, composer, 0);
            Integer numValueOf4 = Integer.valueOf(R.drawable.channel_image_type);
            boolean zChangedInstance4 = composer.changedInstance(navHostController);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.q
                    @Override // lb.a
                    public final Object invoke() {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$22$3$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Z17MultipleFabViewKt.m10142Z17MultipleViewjA1GFJw(va.w.q(z17MultipleFabObj, z17MultipleFabObj2, z17MultipleFabObj3, new Z17MultipleFabObj("4", strStringResource4, numValueOf4, null, null, (lb.a) objRememberedValue4, 24, null)), null, null, 0L, 0L, composer, Z17MultipleFabObj.$stable, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$22$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.QR_READER, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$22$1$0(Context context) {
        IntentUtil.addContact$default(IntentUtil.INSTANCE, context, null, null, null, 14, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$22$2$0(NavHostController navHostController) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = new v5.f().t(new CreateGroupParams(null, null, 3, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goCreateGroupStep1(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$22$3$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.CREATE_CHANNEL, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$23(final ContactsViewModel contactsViewModel, LazyListState lazyListState, LazyPagingItems lazyPagingItems, final NavHostController navHostController, LazyListState lazyListState2, LazyPagingItems lazyPagingItems2, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final State state, Modifier it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(546410707, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous> (OpenWithScreen.kt:273)");
            }
            final List listQ = va.w.q(StringResources_androidKt.stringResource(R.string.contacts, composer, 0), StringResources_androidKt.stringResource(R.string.other_users, composer, 0));
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion2);
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
            TabRowKt.m3761TabRowpAZo6Ak(mutableIntState.getIntValue(), BackgroundKt.m1205backgroundbw27NRU$default(companion2, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null), 0L, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-1141673083, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$0(listQ, mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 60);
            int intValue = mutableIntState.getIntValue();
            if (intValue == 0) {
                composer.startReplaceGroup(1799958601);
                Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(it, 0.0f, 1, null);
                String nameWithDomain = contactsViewModel.owner().getNameWithDomain();
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$1$0(navHostController, (Friend) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function1 function1 = (Function1) objRememberedValue2;
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$2$0((Friend) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                UserCommonListKt.UserCommonList(modifierFillMaxHeight$default, lazyListState, lazyPagingItems, function1, (Function1) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(865453183, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.h0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$3(mutableState, navHostController, contactsViewModel, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), nameWithDomain, null, null, composer, (LazyPagingItems.$stable << 6) | 221184, RendererCapabilities.DECODER_SUPPORT_MASK);
                composer.endReplaceGroup();
            } else if (intValue != 1) {
                composer.startReplaceGroup(1803595397);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1802016195);
                Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(it, 0.0f, 1, null);
                String nameWithDomain2 = contactsViewModel.owner().getNameWithDomain();
                boolean zChangedInstance2 = composer.changedInstance(navHostController);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.i0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$4$0(navHostController, (Partner) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                Function1 function2 = (Function1) objRememberedValue4;
                Object objRememberedValue5 = composer.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.j0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$5$0((Partner) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                Function1 function3 = (Function1) objRememberedValue5;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-333471946, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.k0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$6(mutableState3, navHostController, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54);
                Object objRememberedValue6 = composer.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.l0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$7$0((UserCommon) obj));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                UserCommonListKt.UserCommonList(modifierFillMaxHeight$default2, lazyListState2, lazyPagingItems2, function2, function3, composableLambdaRememberComposableLambda, nameWithDomain2, null, (Function1) objRememberedValue6, composer, (LazyPagingItems.$stable << 6) | 100884480, 128);
                composer.endReplaceGroup();
            }
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
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$0(List list, final MutableIntState mutableIntState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1141673083, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenWithScreen.kt:285)");
            }
            final int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    va.w.x();
                }
                String str = (String) obj;
                boolean z10 = mutableIntState.getIntValue() == i11;
                boolean zChanged = composer.changed(i11);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.c0
                        @Override // lb.a
                        public final Object invoke() {
                            return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$0$0$0$0(i11, mutableIntState);
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
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$0$0$0$0(int i10, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$1$0(NavHostController navHostController, Friend userCommon) {
        kotlin.jvm.internal.y.i(userCommon, "userCommon");
        ChatParams chatParams = new ChatParams(userCommon.getId(), 0, null, 0, 12, null);
        NavLinks navLinks = NavLinks.INSTANCE;
        int type = chatParams.getType();
        String strT = new v5.f().t(chatParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        navHostController.navigate(navLinks.goChat(type, strT), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$1$0$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$1$0$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$2$0(Friend it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$3(final MutableState mutableState, final NavHostController navHostController, final ContactsViewModel contactsViewModel, final MutableState mutableState2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(865453183, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenWithScreen.kt:311)");
            }
            PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState.getValue();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.s
                    @Override // lb.a
                    public final Object invoke() {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$3$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(contactsViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$3$1$0(contactsViewModel, mutableState, mutableState2, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar, permissionsRequesterState, (Function1) objRememberedValue2, null, composer, 0, 17);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$3$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.CONTACTS_PERMISSION, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$3$1$0(ContactsViewModel contactsViewModel, MutableState mutableState, MutableState mutableState2, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        Integer state = result.getState();
        boolean z10 = state != null && state.intValue() == 2;
        if (z10 && !OpenWithScreen$lambda$0$7(mutableState2)) {
            ContactsViewModel.updateContactList$default(contactsViewModel, true, false, 2, null);
        }
        OpenWithScreen$lambda$0$8(mutableState2, z10);
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$4$0(NavHostController navHostController, Partner userCommon) {
        kotlin.jvm.internal.y.i(userCommon, "userCommon");
        ChatParams chatParams = new ChatParams(userCommon.getId(), 0, null, 0, 12, null);
        NavLinks navLinks = NavLinks.INSTANCE;
        int type = chatParams.getType();
        String strT = new v5.f().t(chatParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        navHostController.navigate(navLinks.goChat(type, strT), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$4$0$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$4$0$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$5$0(Partner it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$6(MutableState mutableState, final NavHostController navHostController, State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-333471946, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenWithScreen.kt:351)");
            }
            boolean zU = le.a0.U((String) mutableState.getValue(), "@", false, 2, null);
            Partner data = OpenWithScreen$lambda$0$4(state).getData();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$6$0$0(navHostController, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            UserByToDusId(zU, data, (Function1) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$6$0$0(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatParams chatParams = new ChatParams(it, 0, null, 0, 12, null);
        NavLinks navLinks = NavLinks.INSTANCE;
        int type = chatParams.getType();
        String strT = new v5.f().t(chatParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        navHostController.navigate(navLinks.goChat(type, strT), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OpenWithScreenKt.OpenWithScreen$lambda$0$23$3$6$0$0$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$0$23$3$6$0$0$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OpenWithScreen$lambda$0$23$3$7$0(UserCommon it) {
        kotlin.jvm.internal.y.i(it, "it");
        return !((Partner) it).hasContact();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OpenWithScreen$lambda$0$24$0(int i10) {
        return (-i10) / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OpenWithScreen$lambda$0$25$0(int i10) {
        return (-i10) / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 OpenWithScreen$lambda$0$26(MutableState mutableState, MutableState mutableState2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1352726111, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreen.<anonymous>.<anonymous> (OpenWithScreen.kt:379)");
        }
        StatusCard(OpenWithScreen$lambda$0$14(mutableState), OpenWithScreen$lambda$0$17(mutableState2), null, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    private static final FlowsState<Partner> OpenWithScreen$lambda$0$4(State<FlowsState<Partner>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RefreshContactsState OpenWithScreen$lambda$0$5(State<? extends RefreshContactsState> state) {
        return state.getValue();
    }

    private static final boolean OpenWithScreen$lambda$0$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void OpenWithScreen$lambda$0$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OpenWithScreen$lambda$1(NavHostController navHostController, ContactsViewModel contactsViewModel, int i10, int i11, Composer composer, int i12) {
        OpenWithScreen(navHostController, contactsViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x008c  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:49:0x0156  */
    /* JADX WARN: Code duplicated, block: B:51:0x015c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0167  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusCard(final String message, final boolean z10, Modifier modifier, Composer composer, final int i10, final int i11) {
        int i12;
        Modifier modifier2;
        boolean z11;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long errorContainer;
        long onErrorContainer;
        kotlin.jvm.internal.y.i(message, "message");
        Composer composerStartRestartGroup = composer.startRestartGroup(1641644755);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(message) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        int i13 = i11 & 4;
        if (i13 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i12 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i12 & 147) != 146) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1641644755, i12, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.StatusCard (OpenWithScreen.kt:397)");
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-553563659);
                    errorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-553500233);
                    errorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getErrorContainer();
                    composerStartRestartGroup.endReplaceGroup();
                }
                long j10 = errorContainer;
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-553404877);
                    onErrorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryFixed();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-553339467);
                    onErrorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnErrorContainer();
                    composerStartRestartGroup.endReplaceGroup();
                }
                float f10 = 12;
                Modifier modifierM5480shadows4CzXII$default = ShadowKt.m5480shadows4CzXII$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), Dp.m8823constructorimpl(8), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)), false, 0L, Color.m5865copywmQWz5c$default(j10, 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 12, null);
                RoundedCornerShape roundedCornerShapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10));
                Modifier modifier5 = modifier4;
                composer2 = composerStartRestartGroup;
                final long j11 = onErrorContainer;
                CardKt.Card(modifierM5480shadows4CzXII$default, roundedCornerShapeM2015RoundedCornerShape0680j_4, CardDefaults.INSTANCE.m2922cardColorsro_MJ88(j10, 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1411815483, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.u
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OpenWithScreenKt.StatusCard$lambda$0(z10, j11, message, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.v
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OpenWithScreenKt.StatusCard$lambda$1(message, z10, modifier3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        modifier2 = modifier;
        if ((i12 & 147) != 146) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            if (i13 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1641644755, i12, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.StatusCard (OpenWithScreen.kt:397)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-553563659);
                errorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-553500233);
                errorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getErrorContainer();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j12 = errorContainer;
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-553404877);
                onErrorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryFixed();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-553339467);
                onErrorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnErrorContainer();
                composerStartRestartGroup.endReplaceGroup();
            }
            float f11 = 12;
            Modifier modifierM5480shadows4CzXII$default2 = ShadowKt.m5480shadows4CzXII$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), Dp.m8823constructorimpl(8), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)), false, 0L, Color.m5865copywmQWz5c$default(j12, 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 12, null);
            RoundedCornerShape roundedCornerShapeM2015RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11));
            Modifier modifier6 = modifier4;
            composer2 = composerStartRestartGroup;
            final long j13 = onErrorContainer;
            CardKt.Card(modifierM5480shadows4CzXII$default2, roundedCornerShapeM2015RoundedCornerShape0680j_5, CardDefaults.INSTANCE.m2922cardColorsro_MJ88(j12, 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1411815483, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.u
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OpenWithScreenKt.StatusCard$lambda$0(z10, j13, message, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OpenWithScreenKt.StatusCard$lambda$1(message, z10, modifier3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusCard$lambda$0(boolean z10, long j10, String str, ColumnScope Card, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Card, "$this$Card");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411815483, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.StatusCard.<anonymous> (OpenWithScreen.kt:423)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(16));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composer, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
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
            Icons.Filled filled = Icons.INSTANCE.getDefault();
            IconKt.m3298Iconww6aTOc(z10 ? CheckCircleKt.getCheckCircle(filled) : ErrorKt.getError(filled), (String) null, SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(28)), j10, composer, 432, 0);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(12)), composer, 6);
            TextKt.m3850TextNvy7gAk(str, e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), j10, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131064);
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
    public static final ua.k0 StatusCard$lambda$1(String str, boolean z10, Modifier modifier, int i10, int i11, Composer composer, int i12) {
        StatusCard(str, z10, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void UserByToDusId(final boolean z10, final Partner partner, final Function1 openChat, Composer composer, final int i10) {
        int i11;
        long background;
        kotlin.jvm.internal.y.i(openChat, "openChat");
        Composer composerStartRestartGroup = composer.startRestartGroup(732213302);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(partner) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(openChat) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(732213302, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.UserByToDusId (OpenWithScreen.kt:454)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            if (partner != null) {
                composerStartRestartGroup.startReplaceGroup(-717645440);
                composerStartRestartGroup.endReplaceGroup();
                background = Color.m5865copywmQWz5c$default(Other.INSTANCE.m10111getGreen0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
            } else if (z10) {
                composerStartRestartGroup.startReplaceGroup(-717642656);
                background = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-717640672);
                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(companion, background, null, 2, null), Dp.m8823constructorimpl(8));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(1208331097);
                if (partner != null) {
                    composerStartRestartGroup.startReplaceGroup(-1196415708);
                    String thumbnailPicture = partner.getThumbnailPicture();
                    String name = partner.getName();
                    String str = "@" + partner.getUser().getToDusId();
                    boolean z11 = ((i11 & 896) == 256) | ((i11 & 112) == 32);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.e0
                            @Override // lb.a
                            public final Object invoke() {
                                return OpenWithScreenKt.UserByToDusId$lambda$0$0$0(openChat, partner);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    lb.a aVar = (lb.a) objRememberedValue;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.f0
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ContactItemKt.ContactItem(thumbnailPicture, name, str, aVar, (lb.a) objRememberedValue2, composerStartRestartGroup, 24576, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1196098578);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.todusid_not_found, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composerStartRestartGroup, 6, 56);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1195799397);
                Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.to_search_by_todusid, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composerStartRestartGroup, 6, 56);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OpenWithScreenKt.UserByToDusId$lambda$1(z10, partner, openChat, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 UserByToDusId$lambda$0$0$0(Function1 function1, Partner partner) {
        function1.invoke(partner.getUser().getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 UserByToDusId$lambda$1(boolean z10, Partner partner, Function1 function1, int i10, Composer composer, int i11) {
        UserByToDusId(z10, partner, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
