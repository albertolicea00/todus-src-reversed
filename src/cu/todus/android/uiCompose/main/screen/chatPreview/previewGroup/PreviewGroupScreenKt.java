package cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ExitToAppKt;
import androidx.compose.material.icons.outlined.DeleteOutlineKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material.icons.outlined.GroupAddKt;
import androidx.compose.material.icons.outlined.InfoKt;
import androidx.compose.material.icons.outlined.LinkKt;
import androidx.compose.material.icons.outlined.LockKt;
import androidx.compose.material.icons.outlined.LockOpenKt;
import androidx.compose.material.icons.outlined.RefreshKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TabRowKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.p000activity.compose.BackHandlerKt;
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
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.RoomMember;
import cu.todus.android.data.db.pojo.UserCommon;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBarKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.RichTitleDescBtnKt;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.form.FormItemRequest;
import cu.z17.views.form.FormItemType;
import cu.z17.views.form.UtilRegex;
import cu.z17.views.form.Z17FormKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.tab.Z17TabKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\u0011\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006%²\u0006\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\nX\u008a\u0084\u0002²\u0006\f\u0010\u0015\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\f\u0010\u0017\u001a\u00020\u00168\nX\u008a\u0084\u0002²\u0006\f\u0010\u0018\u001a\u00020\u00068\nX\u008a\u0084\u0002²\u0006\f\u0010\u0019\u001a\u00020\u00068\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001c\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001f\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010 \u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\f\u0010!\u001a\u00020\u00068\nX\u008a\u0084\u0002²\u0006\u000e\u0010\"\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u0012\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\nX\u008a\u0084\u0002²\u0006\u000e\u0010$\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/chatPreview/previewGroup/PreviewGroupViewModel;", "viewModel", "", "showTopBar", "Lua/k0;", "PreviewGroupScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chatPreview/previewGroup/PreviewGroupViewModel;ZLandroidx/compose/runtime/Composer;II)V", "Lkotlin/Function1;", "onClick", "Lkotlin/Function0;", "onClose", "", "selectedList", "AddMemberSelection", "(Lkotlin/jvm/functions/Function1;Llb/a;Ljava/util/List;Lcu/todus/android/uiCompose/main/screen/chatPreview/previewGroup/PreviewGroupViewModel;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/data/db/entity/toDus/Room;", "preview", UserRoomJoin.COLUMN_AFFILIATION, "", "memberCount", "isSecret", Room.COLUMN_MUTED, "isLoading", "showClearAndDeleteActionDialog", "showLeaveActionDialog", "showClearActionDialog", "showShareLinkDialog", "showChangeSecretState", "showAddMember", "areSelected", "editorModeActive", "alreadyIn", "tabIndex", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PreviewGroupScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AddMemberSelection(final Function1 onClick, final lb.a onClose, final List<String> selectedList, final PreviewGroupViewModel viewModel, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        kotlin.jvm.internal.y.i(selectedList, "selectedList");
        kotlin.jvm.internal.y.i(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-564104016);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(selectedList) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(viewModel) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-564104016, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.AddMemberSelection (PreviewGroupScreen.kt:929)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            int i12 = i11;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(viewModel.getMembersInGroup().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(viewModel.friendsOnDb((String) mutableState.getValue()), null, composerStartRestartGroup, 0, 1);
            LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(viewModel.usersOnDb((String) mutableState.getValue()), null, composerStartRestartGroup, 0, 1);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            float f10 = 5;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewGroupScreenKt.AddMemberSelection$lambda$2$0$0(mutableState, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            boolean z10 = (i12 & 112) == 32;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.AddMemberSelection$lambda$2$1$0(onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            SearchContactTopBarKt.SearchInput(function1, (lb.a) objRememberedValue3, (String) mutableState.getValue(), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            final List listQ = va.w.q(StringResources_androidKt.stringResource(R.string.contacts, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.other_users, composerStartRestartGroup, 0));
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue4;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion2, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
            int intValue = mutableIntState.getIntValue();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1978253246, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewGroupScreenKt.AddMemberSelection$lambda$2$5(listQ, mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup = composerStartRestartGroup;
            TabRowKt.m3761TabRowpAZo6Ak(intValue, modifierM1205backgroundbw27NRU$default, 0L, 0L, null, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 1572864, 60);
            int intValue2 = mutableIntState.getIntValue();
            if (intValue2 == 0) {
                composerStartRestartGroup.startReplaceGroup(1810255125);
                Modifier modifierA = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null);
                String nameWithDomain = viewModel.owner().getNameWithDomain();
                boolean z11 = (i12 & 14) == 4;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z11 || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.j0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.AddMemberSelection$lambda$2$6$0(onClick, (Friend) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function1 function2 = (Function1) objRememberedValue5;
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.k0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.AddMemberSelection$lambda$2$7$0((Friend) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                Function1 function3 = (Function1) objRememberedValue6;
                Function2 function2M9917getLambda$1878924412$app_productionPFast = ComposableSingletons$PreviewGroupScreenKt.INSTANCE.m9917getLambda$1878924412$app_productionPFast();
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(selectedList);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.l0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.AddMemberSelection$lambda$2$8$0(selectedList, (Friend) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Function1 function4 = (Function1) objRememberedValue7;
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.m0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(PreviewGroupScreenKt.AddMemberSelection$lambda$2$9$0(stateCollectAsStateWithLifecycle, (UserCommon) obj));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                UserCommonListKt.UserCommonList(modifierA, lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems, function2, function3, function2M9917getLambda$1878924412$app_productionPFast, nameWithDomain, function4, (Function1) objRememberedValue8, composerStartRestartGroup, (LazyPagingItems.$stable << 6) | 221184, 0);
                composerStartRestartGroup.endReplaceGroup();
                ua.k0 k0Var = ua.k0.f43947a;
            } else if (intValue2 != 1) {
                composerStartRestartGroup.startReplaceGroup(1811898652);
                composerStartRestartGroup.endReplaceGroup();
                ua.k0 k0Var2 = ua.k0.f43947a;
            } else {
                composerStartRestartGroup.startReplaceGroup(1811076253);
                Modifier modifierA2 = androidx.compose.foundation.layout.x.a(columnScopeInstance, companion2, 1.0f, false, 2, null);
                String nameWithDomain2 = viewModel.owner().getNameWithDomain();
                boolean z12 = (i12 & 14) == 4;
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.n0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.AddMemberSelection$lambda$2$10$0(onClick, (Partner) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                Function1 function5 = (Function1) objRememberedValue9;
                Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.p0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.AddMemberSelection$lambda$2$11$0((Partner) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                Function1 function6 = (Function1) objRememberedValue10;
                Function2 function2M9916getLambda$1686499347$app_productionPFast = ComposableSingletons$PreviewGroupScreenKt.INSTANCE.m9916getLambda$1686499347$app_productionPFast();
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(selectedList);
                Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.c0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.AddMemberSelection$lambda$2$12$0(selectedList, (Partner) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                Function1 function7 = (Function1) objRememberedValue11;
                boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.e0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(PreviewGroupScreenKt.AddMemberSelection$lambda$2$13$0(stateCollectAsStateWithLifecycle, (UserCommon) obj));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                }
                UserCommonListKt.UserCommonList(modifierA2, lazyListStateRememberLazyListState2, lazyPagingItemsCollectAsLazyPagingItems2, function5, function6, function2M9916getLambda$1686499347$app_productionPFast, nameWithDomain2, function7, (Function1) objRememberedValue12, composerStartRestartGroup, (LazyPagingItems.$stable << 6) | 221184, 0);
                composerStartRestartGroup.endReplaceGroup();
                ua.k0 k0Var3 = ua.k0.f43947a;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewGroupScreenKt.AddMemberSelection$lambda$3(onClick, onClose, selectedList, viewModel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<String> AddMemberSelection$lambda$1(State<? extends List<String>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddMemberSelection$lambda$2$0$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddMemberSelection$lambda$2$1$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddMemberSelection$lambda$2$10$0(Function1 function1, Partner userCommon) {
        kotlin.jvm.internal.y.i(userCommon, "userCommon");
        function1.invoke(userCommon.getId());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddMemberSelection$lambda$2$11$0(Partner it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddMemberSelection$lambda$2$12$0(List list, Partner partner) {
        if (defpackage.r.a(list) && list.isEmpty()) {
            return "";
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.y.d((String) it.next(), partner != null ? partner.getId() : null)) {
                return "✅";
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddMemberSelection$lambda$2$13$0(State state, UserCommon it) {
        kotlin.jvm.internal.y.i(it, "it");
        Partner partner = (Partner) it;
        return (partner.hasContact() || AddMemberSelection$lambda$1(state).contains(partner.getId())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 AddMemberSelection$lambda$2$5(List list, final MutableIntState mutableIntState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1978253246, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.AddMemberSelection.<anonymous>.<anonymous> (PreviewGroupScreen.kt:970)");
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
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.f1
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewGroupScreenKt.AddMemberSelection$lambda$2$5$0$0$0(i11, mutableIntState);
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
    public static final ua.k0 AddMemberSelection$lambda$2$5$0$0$0(int i10, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddMemberSelection$lambda$2$6$0(Function1 function1, Friend userCommon) {
        kotlin.jvm.internal.y.i(userCommon, "userCommon");
        function1.invoke(userCommon.getId());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddMemberSelection$lambda$2$7$0(Friend it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddMemberSelection$lambda$2$8$0(List list, Friend friend) {
        if (defpackage.r.a(list) && list.isEmpty()) {
            return "";
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.y.d((String) it.next(), friend != null ? friend.getId() : null)) {
                return "✅";
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddMemberSelection$lambda$2$9$0(State state, UserCommon it) {
        kotlin.jvm.internal.y.i(it, "it");
        return !AddMemberSelection$lambda$1(state).contains(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AddMemberSelection$lambda$3(Function1 function1, lb.a aVar, List list, PreviewGroupViewModel previewGroupViewModel, int i10, Composer composer, int i11) {
        AddMemberSelection(function1, aVar, list, previewGroupViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0255  */
    /* JADX WARN: Code duplicated, block: B:104:0x026a  */
    /* JADX WARN: Code duplicated, block: B:107:0x027f  */
    /* JADX WARN: Code duplicated, block: B:110:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:113:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:120:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:123:0x0378  */
    /* JADX WARN: Code duplicated, block: B:125:0x037f  */
    /* JADX WARN: Code duplicated, block: B:128:0x038b  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:74:0x0145  */
    /* JADX WARN: Code duplicated, block: B:77:0x017b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0192  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:89:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:92:0x0214  */
    /* JADX WARN: Code duplicated, block: B:95:0x022a  */
    /* JADX WARN: Code duplicated, block: B:98:0x023d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PreviewGroupScreen(final NavHostController navHostController, final String uid, PreviewGroupViewModel previewGroupViewModel, boolean z10, Composer composer, final int i10, final int i11) {
        int i12;
        PreviewGroupViewModel previewGroupViewModel2;
        boolean z11;
        boolean z12;
        final PreviewGroupViewModel previewGroupViewModel3;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z14;
        int i13;
        PreviewGroupViewModel previewGroupViewModel4;
        int i14;
        boolean z15;
        PreviewGroupViewModel previewGroupViewModel5;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Composer composer2;
        Object objRememberedValue7;
        Object objRememberedValue8;
        final SnapshotStateList snapshotStateList;
        Object objRememberedValue9;
        Object objRememberedValue10;
        Object objRememberedValue11;
        Object objRememberedValue12;
        Object objRememberedValue13;
        Object objRememberedValue14;
        boolean z16;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(-703571573);
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
                previewGroupViewModel2 = previewGroupViewModel;
                int i15 = composerStartRestartGroup.changedInstance(previewGroupViewModel2) ? 256 : 128;
                i12 |= i15;
            } else {
                previewGroupViewModel2 = previewGroupViewModel;
            }
            i12 |= i15;
        } else {
            previewGroupViewModel2 = previewGroupViewModel;
        }
        int i16 = i11 & 8;
        if (i16 == 0) {
            if ((i10 & 3072) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
            }
            if ((i12 & 1171) != 1170) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i11 & 4) != 0) {
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        CreationExtras creationExtras = defaultViewModelCreationExtras;
                        i13 = 0;
                        ViewModel viewModel = ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(PreviewGroupViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, creationExtras, composerStartRestartGroup, 0, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        previewGroupViewModel4 = (PreviewGroupViewModel) viewModel;
                        i12 &= -897;
                        z14 = true;
                    } else {
                        z14 = true;
                        i13 = 0;
                        previewGroupViewModel4 = previewGroupViewModel;
                    }
                    if (i16 != 0) {
                        i14 = i12;
                        previewGroupViewModel5 = previewGroupViewModel4;
                        z15 = z14;
                    } else {
                        i14 = i12;
                        z15 = z11;
                        previewGroupViewModel5 = previewGroupViewModel4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                    }
                    i14 = i12;
                    previewGroupViewModel5 = previewGroupViewModel2;
                    z15 = z11;
                    z14 = true;
                    i13 = 0;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-703571573, i14, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreen (PreviewGroupScreen.kt:119)");
                }
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                boolean z17 = z14;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getPreviewGroup(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getAffiliationGroup(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getMemberCount(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getIsSecret(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getIsMuted(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(previewGroupViewModel5.members(uid), null, composerStartRestartGroup, i13, z17 ? 1 : 0);
                final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(i13, i13, composerStartRestartGroup, i13, 3);
                final String strStringResource = StringResources_androidKt.stringResource(R.string.owner, composerStartRestartGroup, i13);
                final String strStringResource2 = StringResources_androidKt.stringResource(R.string.admin, composerStartRestartGroup, i13);
                final String strStringResource3 = StringResources_androidKt.stringResource(R.string.member, composerStartRestartGroup, i13);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
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
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState6 = (MutableState) objRememberedValue6;
                final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getLink(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                composer2 = composerStartRestartGroup;
                final ClipboardManager clipboardManager = (ClipboardManager) composer2.consume(CompositionLocalsKt.getLocalClipboardManager());
                final String strStringResource4 = StringResources_androidKt.stringResource(R.string.invitation_link, composer2, i13);
                objRememberedValue7 = composer2.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                final MutableState mutableState7 = (MutableState) objRememberedValue7;
                objRememberedValue8 = composer2.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = SnapshotStateKt.mutableStateListOf();
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                snapshotStateList = (SnapshotStateList) objRememberedValue8;
                objRememberedValue9 = composer2.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.m1
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(PreviewGroupScreenKt.PreviewGroupScreen$lambda$27$0(snapshotStateList));
                        }
                    });
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                State state = (State) objRememberedValue9;
                objRememberedValue10 = composer2.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer2);
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                final pe.m0 m0Var = (pe.m0) objRememberedValue10;
                objRememberedValue11 = composer2.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue11);
                }
                final MutableState mutableState8 = (MutableState) objRememberedValue11;
                objRememberedValue12 = composer2.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new ArrayList();
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                final List list = (List) objRememberedValue12;
                final String strStringResource5 = StringResources_androidKt.stringResource(R.string.image, composer2, i13);
                final String strStringResource6 = StringResources_androidKt.stringResource(R.string.delete_image, composer2, i13);
                final String strStringResource7 = StringResources_androidKt.stringResource(R.string.name, composer2, i13);
                final String strStringResource8 = StringResources_androidKt.stringResource(R.string.information, composer2, i13);
                final kotlin.jvm.internal.y0 y0Var = new kotlin.jvm.internal.y0();
                objRememberedValue13 = composer2.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = "";
                    composer2.updateRememberedValue("");
                }
                y0Var.f36634c = (String) objRememberedValue13;
                final kotlin.jvm.internal.u0 u0Var = new kotlin.jvm.internal.u0();
                objRememberedValue14 = composer2.rememberedValue();
                if (objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = Boolean.FALSE;
                    composer2.updateRememberedValue(objRememberedValue14);
                }
                u0Var.f36629c = ((Boolean) objRememberedValue14).booleanValue();
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, 3);
                if (z15 || PreviewGroupScreen$lambda$30(mutableState8)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                final PreviewGroupViewModel previewGroupViewModel6 = previewGroupViewModel5;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1232379351, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.n1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$37(navHostController, list, stateCollectAsStateWithLifecycle, snapshotStateList, mutableState8, mutableState7, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), z16, false, PreviewGroupScreen$lambda$28(state), ComposableLambdaKt.rememberComposableLambda(332414211, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.o1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$38(previewGroupViewModel6, uid, snapshotStateList, mutableState, mutableState7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-938829419, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.p1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39(snapshotStateList, previewGroupViewModel6, lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems, navHostController, stateCollectAsStateWithLifecycle2, uid, strStringResource, strStringResource2, strStringResource3, list, stateCollectAsStateWithLifecycle, mutableState, mutableState7, mutableState8, context, m0Var, y0Var, u0Var, strStringResource5, strStringResource6, strStringResource7, strStringResource8, stateCollectAsStateWithLifecycle6, stateCollectAsStateWithLifecycle4, mutableState6, mutableState3, mutableState4, mutableState5, mutableState2, stateCollectAsStateWithLifecycle5, stateCollectAsStateWithLifecycle3, strStringResource4, clipboardManager, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 805331334, 352);
                composerStartRestartGroup = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                previewGroupViewModel3 = previewGroupViewModel6;
                z13 = z15;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                previewGroupViewModel3 = previewGroupViewModel;
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.q1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$40(navHostController, uid, previewGroupViewModel3, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        z11 = z10;
        if ((i12 & 1171) != 1170) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if ((i11 & 4) != 0) {
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    CreationExtras creationExtras2 = defaultViewModelCreationExtras;
                    i13 = 0;
                    ViewModel viewModel2 = ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(PreviewGroupViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, creationExtras2, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    previewGroupViewModel4 = (PreviewGroupViewModel) viewModel2;
                    i12 &= -897;
                    z14 = true;
                } else {
                    z14 = true;
                    i13 = 0;
                    previewGroupViewModel4 = previewGroupViewModel;
                }
                if (i16 != 0) {
                    i14 = i12;
                    previewGroupViewModel5 = previewGroupViewModel4;
                    z15 = z14;
                } else {
                    i14 = i12;
                    z15 = z11;
                    previewGroupViewModel5 = previewGroupViewModel4;
                }
            } else {
                if ((i11 & 4) != 0) {
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    CreationExtras creationExtras3 = defaultViewModelCreationExtras;
                    i13 = 0;
                    ViewModel viewModel3 = ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(PreviewGroupViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, creationExtras3, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    previewGroupViewModel4 = (PreviewGroupViewModel) viewModel3;
                    i12 &= -897;
                    z14 = true;
                } else {
                    z14 = true;
                    i13 = 0;
                    previewGroupViewModel4 = previewGroupViewModel;
                }
                if (i16 != 0) {
                    i14 = i12;
                    previewGroupViewModel5 = previewGroupViewModel4;
                    z15 = z14;
                } else {
                    i14 = i12;
                    z15 = z11;
                    previewGroupViewModel5 = previewGroupViewModel4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-703571573, i14, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreen (PreviewGroupScreen.kt:119)");
            }
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            boolean z18 = z14;
            final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getPreviewGroup(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle8 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getAffiliationGroup(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle9 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getMemberCount(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle10 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getIsSecret(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle11 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getIsMuted(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState9 = (MutableState) objRememberedValue;
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(previewGroupViewModel5.members(uid), null, composerStartRestartGroup, i13, z18 ? 1 : 0);
            final LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(i13, i13, composerStartRestartGroup, i13, 3);
            final String strStringResource9 = StringResources_androidKt.stringResource(R.string.owner, composerStartRestartGroup, i13);
            final String strStringResource10 = StringResources_androidKt.stringResource(R.string.admin, composerStartRestartGroup, i13);
            final String strStringResource11 = StringResources_androidKt.stringResource(R.string.member, composerStartRestartGroup, i13);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState10 = (MutableState) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState11 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState12 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState13 = (MutableState) objRememberedValue5;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState14 = (MutableState) objRememberedValue6;
            final State stateCollectAsStateWithLifecycle12 = FlowExtKt.collectAsStateWithLifecycle(previewGroupViewModel5.getLink(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            composer2 = composerStartRestartGroup;
            final ClipboardManager clipboardManager2 = (ClipboardManager) composer2.consume(CompositionLocalsKt.getLocalClipboardManager());
            final String strStringResource12 = StringResources_androidKt.stringResource(R.string.invitation_link, composer2, i13);
            objRememberedValue7 = composer2.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState15 = (MutableState) objRememberedValue7;
            objRememberedValue8 = composer2.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = SnapshotStateKt.mutableStateListOf();
                composer2.updateRememberedValue(objRememberedValue8);
            }
            snapshotStateList = (SnapshotStateList) objRememberedValue8;
            objRememberedValue9 = composer2.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.m1
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(PreviewGroupScreenKt.PreviewGroupScreen$lambda$27$0(snapshotStateList));
                    }
                });
                composer2.updateRememberedValue(objRememberedValue9);
            }
            State state2 = (State) objRememberedValue9;
            objRememberedValue10 = composer2.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer2);
                composer2.updateRememberedValue(objRememberedValue10);
            }
            final pe.m0 m0Var2 = (pe.m0) objRememberedValue10;
            objRememberedValue11 = composer2.rememberedValue();
            if (objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue11);
            }
            final MutableState mutableState16 = (MutableState) objRememberedValue11;
            objRememberedValue12 = composer2.rememberedValue();
            if (objRememberedValue12 == companion.getEmpty()) {
                objRememberedValue12 = new ArrayList();
                composer2.updateRememberedValue(objRememberedValue12);
            }
            final List list2 = (List) objRememberedValue12;
            final String strStringResource13 = StringResources_androidKt.stringResource(R.string.image, composer2, i13);
            final String strStringResource14 = StringResources_androidKt.stringResource(R.string.delete_image, composer2, i13);
            final String strStringResource15 = StringResources_androidKt.stringResource(R.string.name, composer2, i13);
            final String strStringResource16 = StringResources_androidKt.stringResource(R.string.information, composer2, i13);
            final kotlin.jvm.internal.y0 y0Var2 = new kotlin.jvm.internal.y0();
            objRememberedValue13 = composer2.rememberedValue();
            if (objRememberedValue13 == companion.getEmpty()) {
                objRememberedValue13 = "";
                composer2.updateRememberedValue("");
            }
            y0Var2.f36634c = (String) objRememberedValue13;
            final kotlin.jvm.internal.u0 u0Var2 = new kotlin.jvm.internal.u0();
            objRememberedValue14 = composer2.rememberedValue();
            if (objRememberedValue14 == companion.getEmpty()) {
                objRememberedValue14 = Boolean.FALSE;
                composer2.updateRememberedValue(objRememberedValue14);
            }
            u0Var2.f36629c = ((Boolean) objRememberedValue14).booleanValue();
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, 3);
            if (z15) {
                z16 = true;
            } else {
                z16 = true;
            }
            final PreviewGroupViewModel previewGroupViewModel7 = previewGroupViewModel5;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1232379351, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.n1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewGroupScreenKt.PreviewGroupScreen$lambda$37(navHostController, list2, stateCollectAsStateWithLifecycle7, snapshotStateList, mutableState16, mutableState15, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), z16, false, PreviewGroupScreen$lambda$28(state2), ComposableLambdaKt.rememberComposableLambda(332414211, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.o1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewGroupScreenKt.PreviewGroupScreen$lambda$38(previewGroupViewModel7, uid, snapshotStateList, mutableState9, mutableState15, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-938829419, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.p1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39(snapshotStateList, previewGroupViewModel7, lazyListStateRememberLazyListState2, lazyPagingItemsCollectAsLazyPagingItems2, navHostController, stateCollectAsStateWithLifecycle8, uid, strStringResource9, strStringResource10, strStringResource11, list2, stateCollectAsStateWithLifecycle7, mutableState9, mutableState15, mutableState16, context2, m0Var2, y0Var2, u0Var2, strStringResource13, strStringResource14, strStringResource15, strStringResource16, stateCollectAsStateWithLifecycle12, stateCollectAsStateWithLifecycle10, mutableState14, mutableState11, mutableState12, mutableState13, mutableState10, stateCollectAsStateWithLifecycle11, stateCollectAsStateWithLifecycle9, strStringResource12, clipboardManager2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 805331334, 352);
            composerStartRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            previewGroupViewModel3 = previewGroupViewModel7;
            z13 = z15;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            previewGroupViewModel3 = previewGroupViewModel;
            z13 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.q1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewGroupScreenKt.PreviewGroupScreen$lambda$40(navHostController, uid, previewGroupViewModel3, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PreviewGroupScreen$activateEditorMode(pe.m0 m0Var, kotlin.jvm.internal.y0 y0Var, List<FormItemRequest> list, String str, String str2, String str3, String str4, State<Room> state, MutableState<Boolean> mutableState) {
        pe.k.d(m0Var, null, null, new PreviewGroupScreenKt$PreviewGroupScreen$activateEditorMode$1(y0Var, list, str, str2, str3, str4, state, mutableState, null), 3, null);
    }

    private static final void PreviewGroupScreen$desactivateEditorMode(List<FormItemRequest> list, MutableState<Boolean> mutableState) {
        PreviewGroupScreen$lambda$31(mutableState, false);
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Room PreviewGroupScreen$lambda$0(State<Room> state) {
        return state.getValue();
    }

    private static final String PreviewGroupScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final void PreviewGroupScreen$lambda$10(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewGroupScreen$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupScreen$lambda$13(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewGroupScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupScreen$lambda$16(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewGroupScreen$lambda$18(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupScreen$lambda$19(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final int PreviewGroupScreen$lambda$2(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final boolean PreviewGroupScreen$lambda$21(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupScreen$lambda$22(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewGroupScreen$lambda$24(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupScreen$lambda$25(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PreviewGroupScreen$lambda$27$0(SnapshotStateList snapshotStateList) {
        return !snapshotStateList.isEmpty();
    }

    private static final boolean PreviewGroupScreen$lambda$28(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean PreviewGroupScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean PreviewGroupScreen$lambda$30(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewGroupScreen$lambda$31(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PreviewGroupScreen$lambda$37(final NavHostController navHostController, final List list, final State state, final SnapshotStateList snapshotStateList, final MutableState mutableState, final MutableState mutableState2, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1232379351, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreen.<anonymous> (PreviewGroupScreen.kt:358)");
            }
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1274087082, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.r1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewGroupScreenKt.PreviewGroupScreen$lambda$37$0(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            boolean zChangedInstance = composer.changedInstance(list) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.s1
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$37$1$0(snapshotStateList, navHostController, mutableState, mutableState2, list);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(composableLambdaRememberComposableLambda, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
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
    public static final ua.k0 PreviewGroupScreen$lambda$37$0(State state, Composer composer, int i10) {
        String onlyName;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1274087082, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreen.<anonymous>.<anonymous> (PreviewGroupScreen.kt:360)");
            }
            Room roomPreviewGroupScreen$lambda$0 = PreviewGroupScreen$lambda$0(state);
            if (roomPreviewGroupScreen$lambda$0 == null || (onlyName = roomPreviewGroupScreen$lambda$0.getOnlyName()) == null) {
                onlyName = "";
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, onlyName, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$37$1$0(SnapshotStateList snapshotStateList, NavHostController navHostController, MutableState mutableState, MutableState mutableState2, List list) {
        if (PreviewGroupScreen$lambda$30(mutableState) || PreviewGroupScreen$lambda$24(mutableState2)) {
            PreviewGroupScreen$desactivateEditorMode(list, mutableState);
            PreviewGroupScreen$lambda$25(mutableState2, false);
            snapshotStateList.clear();
        } else {
            navHostController.navigateUp();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PreviewGroupScreen$lambda$38(final PreviewGroupViewModel previewGroupViewModel, final String str, final SnapshotStateList snapshotStateList, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(332414211, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreen.<anonymous> (PreviewGroupScreen.kt:379)");
            }
            boolean zChangedInstance = composer.changedInstance(previewGroupViewModel) | composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.d0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$38$0$0(previewGroupViewModel, str, snapshotStateList, mutableState, mutableState2);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((lb.a) objRememberedValue, null, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, ComposableSingletons$PreviewGroupScreenKt.INSTANCE.getLambda$1490944705$app_productionPFast(), composer, 12582912, 118);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$38$0$0(PreviewGroupViewModel previewGroupViewModel, String str, final SnapshotStateList snapshotStateList, final MutableState mutableState, final MutableState mutableState2) {
        PreviewGroupScreen$lambda$7(mutableState, true);
        previewGroupViewModel.addMembers(str, snapshotStateList, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.i1
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$38$0$0$0(snapshotStateList, mutableState2, mutableState);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$38$0$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        snapshotStateList.clear();
        PreviewGroupScreen$lambda$25(mutableState, false);
        PreviewGroupScreen$lambda$7(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v9 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PreviewGroupScreen$lambda$39(final SnapshotStateList snapshotStateList, final PreviewGroupViewModel previewGroupViewModel, LazyListState lazyListState, LazyPagingItems lazyPagingItems, final NavHostController navHostController, final State state, final String str, final String str2, final String str3, final String str4, final List list, final State state2, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final Context context, final pe.m0 m0Var, final kotlin.jvm.internal.y0 y0Var, final kotlin.jvm.internal.u0 u0Var, final String str5, final String str6, final String str7, final String str8, final State state3, final State state4, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final State state5, final State state6, final String str9, final ClipboardManager clipboardManager, Modifier m10, Composer composer, int i10) {
        int i11;
        final PreviewGroupViewModel previewGroupViewModel2;
        final String str10;
        final NavHostController navHostController2;
        ?? r11;
        final MutableState mutableState9;
        final MutableState mutableState10;
        char c10;
        final SnapshotStateList snapshotStateList2;
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(m10, "m");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer2.changed(m10) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer2.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-938829419, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreen.<anonymous> (PreviewGroupScreen.kt:403)");
            }
            if (PreviewGroupScreen$lambda$0(state2) == null || PreviewGroupScreen$lambda$6(mutableState)) {
                previewGroupViewModel2 = previewGroupViewModel;
                str10 = str;
                navHostController2 = navHostController;
                composer2.startReplaceGroup(159859880);
                r11 = 0;
                LoadingScreenKt.LoadingWall(composer2, 0);
                composer2.endReplaceGroup();
            } else if (PreviewGroupScreen$lambda$24(mutableState2)) {
                composer2.startReplaceGroup(159962614);
                Object objRememberedValue = composer2.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    snapshotStateList2 = snapshotStateList;
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.v1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$0$0(snapshotStateList2, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    snapshotStateList2 = snapshotStateList;
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.r
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$1$0(mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                AddMemberSelection(function1, (lb.a) objRememberedValue2, snapshotStateList2, previewGroupViewModel, composer2, 438);
                composer2.endReplaceGroup();
                previewGroupViewModel2 = previewGroupViewModel;
                str10 = str;
                navHostController2 = navHostController;
                r11 = 0;
            } else if (PreviewGroupScreen$lambda$30(mutableState3)) {
                composer2.startReplaceGroup(160510942);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(m10, 0.0f, 1, null);
                Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
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
                Object objRememberedValue3 = composer2.rememberedValue();
                Composer.Companion companion4 = Composer.INSTANCE;
                if (objRememberedValue3 == companion4.getEmpty()) {
                    mutableState10 = mutableState3;
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.v
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$2$0$0(mutableState10);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    mutableState10 = mutableState3;
                }
                lb.a aVar = (lb.a) objRememberedValue3;
                Modifier modifierAlign = columnScopeInstance.align(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), companion2.getEnd());
                ComposableSingletons$PreviewGroupScreenKt composableSingletons$PreviewGroupScreenKt = ComposableSingletons$PreviewGroupScreenKt.INSTANCE;
                IconButtonKt.IconButton(aVar, modifierAlign, false, null, null, null, composableSingletons$PreviewGroupScreenKt.getLambda$670657214$app_productionPFast(), composer2, 1572870, 60);
                Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1727paddingVpY3zN4$default(m10, Dp.m8823constructorimpl(20), 0.0f, 2, null));
                Function3 lambda$1914186243$app_productionPFast = composableSingletons$PreviewGroupScreenKt.getLambda$1914186243$app_productionPFast();
                boolean zChanged = composer2.changed(state2) | composer2.changedInstance(previewGroupViewModel) | composer2.changed(str) | composer2.changedInstance(list);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChanged || objRememberedValue4 == companion4.getEmpty()) {
                    final MutableState mutableState11 = mutableState10;
                    c10 = 6;
                    Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.w
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$2$1$0(previewGroupViewModel, str, mutableState, state2, list, mutableState11, (HashMap) obj);
                        }
                    };
                    composer2.updateRememberedValue(function2);
                    objRememberedValue4 = function2;
                } else {
                    c10 = 6;
                }
                Function1 function3 = (Function1) objRememberedValue4;
                Function1 function4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$2$2(m0Var, y0Var, u0Var, list, str5, str6, str7, str8, mutableState, state2, (HashMap) obj);
                    }
                };
                boolean zChangedInstance = composer2.changedInstance(context);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == companion4.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$2$3$0(context, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                Z17FormKt.Z17Form(modifierImePadding, list, lambda$1914186243$app_productionPFast, function3, function4, (Function1) objRememberedValue5, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 64);
                composer2 = composer2;
                composer2.endNode();
                composer2.endReplaceGroup();
                previewGroupViewModel2 = previewGroupViewModel;
                str10 = str;
                navHostController2 = navHostController;
                r11 = 0;
            } else {
                composer2.startReplaceGroup(164028140);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(m10, 0.0f, 1, null);
                String nameWithDomain = previewGroupViewModel.owner().getNameWithDomain();
                boolean zChangedInstance2 = composer2.changedInstance(navHostController) | composer2.changedInstance(previewGroupViewModel);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.z
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$3$0(navHostController, previewGroupViewModel, (RoomMember) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                Function1 function5 = (Function1) objRememberedValue6;
                boolean zChanged2 = composer2.changed(state) | composer2.changedInstance(navHostController) | composer2.changedInstance(previewGroupViewModel) | composer2.changed(str);
                Object objRememberedValue7 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.a0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$4$0(navHostController, previewGroupViewModel, str, state, (RoomMember) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                Function1 function6 = (Function1) objRememberedValue7;
                previewGroupViewModel2 = previewGroupViewModel;
                str10 = str;
                navHostController2 = navHostController;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1566667701, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.b0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5(state2, previewGroupViewModel, state3, str, navHostController, state, state4, mutableState4, mutableState5, mutableState6, mutableState2, m0Var, y0Var, list, str5, str6, str7, str8, mutableState3, mutableState7, mutableState, mutableState8, state5, state6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54);
                boolean zChanged3 = composer.changed(str2) | composer.changed(str3) | composer.changed(str4);
                Object objRememberedValue8 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.w1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$6$0(str2, str3, str4, (RoomMember) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                UserCommonListKt.UserCommonList(modifierFillMaxSize$default, lazyListState, lazyPagingItems, function5, function6, composableLambdaRememberComposableLambda, nameWithDomain, (Function1) objRememberedValue8, null, composer, (LazyPagingItems.$stable << 6) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 256);
                composer2 = composer;
                composer2.endReplaceGroup();
                r11 = 0;
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.leave_group_question, composer2, r11);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.this_action_will_eliminate_all, composer2, r11);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.ok, composer2, r11);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.no, composer2, r11);
            boolean zPreviewGroupScreen$lambda$9 = PreviewGroupScreen$lambda$9(mutableState8);
            Object objRememberedValue9 = composer2.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue9 == companion5.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.i
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$7$0(mutableState8);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            }
            lb.a aVar2 = (lb.a) objRememberedValue9;
            boolean zChangedInstance3 = composer2.changedInstance(previewGroupViewModel2) | composer2.changed(str10) | composer2.changedInstance(navHostController2);
            Object objRememberedValue10 = composer2.rememberedValue();
            if (zChangedInstance3 || objRememberedValue10 == companion5.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.j
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$8$0(previewGroupViewModel2, str10, navHostController2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue10);
            }
            Z17DialogsKt.Z17DialogWithActions(zPreviewGroupScreen$lambda$9, aVar2, (lb.a) objRememberedValue10, null, strStringResource, strStringResource2, strStringResource3, strStringResource4, composer2, 48, 8);
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.leave_group_question, composer2, r11);
            String strStringResource6 = StringResources_androidKt.stringResource(R.string.this_action_will_eliminate_all, composer2, r11);
            String strStringResource7 = StringResources_androidKt.stringResource(R.string.leave_group, composer2, r11);
            String strStringResource8 = StringResources_androidKt.stringResource(R.string.no, composer2, r11);
            boolean zPreviewGroupScreen$lambda$12 = PreviewGroupScreen$lambda$12(mutableState5);
            Object objRememberedValue11 = composer2.rememberedValue();
            if (objRememberedValue11 == companion5.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.k
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$9$0(mutableState5);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue11);
            }
            lb.a aVar3 = (lb.a) objRememberedValue11;
            boolean zChangedInstance4 = composer2.changedInstance(previewGroupViewModel2) | composer2.changed(str10) | composer2.changedInstance(navHostController2);
            Object objRememberedValue12 = composer2.rememberedValue();
            if (zChangedInstance4 || objRememberedValue12 == companion5.getEmpty()) {
                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.l
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$10$0(previewGroupViewModel2, str10, mutableState, navHostController2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue12);
            }
            Z17DialogsKt.Z17DialogWithActions(zPreviewGroupScreen$lambda$12, aVar3, (lb.a) objRememberedValue12, null, strStringResource5, strStringResource6, strStringResource7, strStringResource8, composer2, 48, 8);
            String strStringResource9 = StringResources_androidKt.stringResource(R.string.clear_history_question, composer2, r11);
            String strStringResource10 = StringResources_androidKt.stringResource(R.string.this_action_cant_be_undone, composer2, r11);
            String strStringResource11 = StringResources_androidKt.stringResource(R.string.ok, composer2, r11);
            String strStringResource12 = StringResources_androidKt.stringResource(R.string.no, composer2, r11);
            boolean zPreviewGroupScreen$lambda$15 = PreviewGroupScreen$lambda$15(mutableState6);
            Object objRememberedValue13 = composer2.rememberedValue();
            if (objRememberedValue13 == companion5.getEmpty()) {
                objRememberedValue13 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.m
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$11$0(mutableState6);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue13);
            }
            lb.a aVar4 = (lb.a) objRememberedValue13;
            boolean zChangedInstance5 = composer2.changedInstance(previewGroupViewModel2) | composer2.changed(str10);
            Object objRememberedValue14 = composer2.rememberedValue();
            if (zChangedInstance5 || objRememberedValue14 == companion5.getEmpty()) {
                objRememberedValue14 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.n
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$12$0(previewGroupViewModel2, str10);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue14);
            }
            Z17DialogsKt.Z17DialogWithActions(zPreviewGroupScreen$lambda$15, aVar4, (lb.a) objRememberedValue14, null, strStringResource9, strStringResource10, strStringResource11, strStringResource12, composer2, 48, 8);
            boolean zPreviewGroupScreen$lambda$18 = PreviewGroupScreen$lambda$18(mutableState7);
            Object objRememberedValue15 = composer2.rememberedValue();
            if (objRememberedValue15 == companion5.getEmpty()) {
                objRememberedValue15 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.o
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$13$0(mutableState7);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue15);
            }
            final PreviewGroupViewModel previewGroupViewModel3 = previewGroupViewModel2;
            final NavHostController navHostController3 = navHostController2;
            Z17DialogsKt.Z17CustomDialog(zPreviewGroupScreen$lambda$18, (lb.a) objRememberedValue15, ComposableLambdaKt.rememberComposableLambda(1949170183, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$14(state3, navHostController3, previewGroupViewModel3, context, str9, clipboardManager, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 432);
            String strStringResource13 = StringResources_androidKt.stringResource(PreviewGroupScreen$lambda$3(state4) ? R.string.pull_out_secret : R.string.make_it_secret, composer2, r11);
            String strStringResource14 = StringResources_androidKt.stringResource(PreviewGroupScreen$lambda$3(state4) ? R.string.pull_out_secret_text : R.string.make_it_secret_text, composer2, r11);
            String strStringResource15 = StringResources_androidKt.stringResource(R.string.ok, composer2, r11);
            String strStringResource16 = StringResources_androidKt.stringResource(R.string.no, composer2, r11);
            boolean zPreviewGroupScreen$lambda$21 = PreviewGroupScreen$lambda$21(mutableState4);
            Object objRememberedValue16 = composer2.rememberedValue();
            if (objRememberedValue16 == companion5.getEmpty()) {
                mutableState9 = mutableState4;
                objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.q
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$15$0(mutableState9);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue16);
            } else {
                mutableState9 = mutableState4;
            }
            lb.a aVar5 = (lb.a) objRememberedValue16;
            boolean zChangedInstance6 = composer2.changedInstance(previewGroupViewModel2) | composer2.changed(str10);
            Object objRememberedValue17 = composer2.rememberedValue();
            if (zChangedInstance6 || objRememberedValue17 == companion5.getEmpty()) {
                objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.t
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$16$0(previewGroupViewModel2, str10, mutableState9);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue17);
            }
            Z17DialogsKt.Z17DialogWithActions(zPreviewGroupScreen$lambda$21, aVar5, (lb.a) objRememberedValue17, null, strStringResource13, strStringResource14, strStringResource15, strStringResource16, composer2, 48, 8);
            boolean zChangedInstance7 = composer2.changedInstance(list) | composer2.changedInstance(navHostController2);
            Object objRememberedValue18 = composer2.rememberedValue();
            if (zChangedInstance7 || objRememberedValue18 == companion5.getEmpty()) {
                final NavHostController navHostController4 = navHostController2;
                objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.u
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$17$0(snapshotStateList, navHostController4, mutableState3, mutableState2, list);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue18);
            }
            BackHandlerKt.BackHandler(r11, (lb.a) objRememberedValue18, composer2, r11, 1);
            ua.k0 k0Var = ua.k0.f43947a;
            boolean zChangedInstance8 = composer2.changedInstance(previewGroupViewModel2) | composer2.changed(str10);
            Object objRememberedValue19 = composer2.rememberedValue();
            if (zChangedInstance8 || objRememberedValue19 == companion5.getEmpty()) {
                objRememberedValue19 = new PreviewGroupScreenKt$PreviewGroupScreen$3$19$1(previewGroupViewModel2, str10, mutableState, null);
                composer2.updateRememberedValue(objRememberedValue19);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue19, composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$0$0(SnapshotStateList snapshotStateList, String id2) {
        kotlin.jvm.internal.y.i(id2, "id");
        if (defpackage.r.a(snapshotStateList) && snapshotStateList.isEmpty()) {
            snapshotStateList.add(id2);
        } else {
            Iterator<T> it = snapshotStateList.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.y.d((String) it.next(), id2)) {
                    snapshotStateList.remove(id2);
                }
            }
            snapshotStateList.add(id2);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$1$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$25(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$10$0(PreviewGroupViewModel previewGroupViewModel, String str, final MutableState mutableState, final NavHostController navHostController) {
        PreviewGroupScreen$lambda$7(mutableState, true);
        previewGroupViewModel.leaveAndDeleteGroup(str, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.j1
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$10$0$0(navHostController);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.l1
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$10$0$1(mutableState);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$10$0$0(NavHostController navHostController) {
        navHostController.navigate(NavLinks.HOME, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.u1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$10$0$0$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$10$0$0$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$10$0$1(MutableState mutableState) {
        PreviewGroupScreen$lambda$7(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$11$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$16(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$12$0(PreviewGroupViewModel previewGroupViewModel, String str) {
        previewGroupViewModel.clearHistory(str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$13$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$19(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PreviewGroupScreen$lambda$39$14(final State state, final NavHostController navHostController, final PreviewGroupViewModel previewGroupViewModel, final Context context, final String str, final ClipboardManager clipboardManager, final lb.a close, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(close, "close");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(close) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1949170183, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreen.<anonymous>.<anonymous> (PreviewGroupScreen.kt:808)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(15));
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
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
            String strStringResource = StringResources_androidKt.stringResource(R.string.group_invitation_link, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, materialTheme.getTypography(composer, i12).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
            float f10 = 50;
            Modifier modifierM1754defaultMinSizeVpY3zN4$default = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            int i13 = i11 & 14;
            boolean zChanged = composer.changed(state) | composer.changedInstance(navHostController) | composer.changedInstance(previewGroupViewModel) | (i13 == 4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.o0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$14$0$0$0(close, state, navHostController, previewGroupViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierM1754defaultMinSizeVpY3zN4$default, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.share_link_todus, composer, 0), materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            composer.endNode();
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            Modifier modifierM1754defaultMinSizeVpY3zN4$default2 = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            boolean zChangedInstance = composer.changedInstance(context) | composer.changed(str) | composer.changed(state) | (i13 == 4);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.z0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$14$0$2$0(close, context, str, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1754defaultMinSizeVpY3zN4$default2, false, null, null, null, (lb.a) objRememberedValue2, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default2);
            lb.a constructor3 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.share_link_other_apps, composer, 0), materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            composer.endNode();
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            Modifier modifierM1754defaultMinSizeVpY3zN4$default3 = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            boolean zChanged2 = composer.changed(state) | composer.changedInstance(clipboardManager) | (i13 == 4);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.k1
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$14$0$4$0(state, clipboardManager, close);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierM1240clickableoSLSa3U$default3 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1754defaultMinSizeVpY3zN4$default3, false, null, null, null, (lb.a) objRememberedValue3, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default3);
            lb.a constructor4 = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.copy_link, composer, 0), materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            composer.endNode();
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            Modifier modifierM1754defaultMinSizeVpY3zN4$default4 = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changed(state);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.t1
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$14$0$6$0(navHostController, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierM1240clickableoSLSa3U$default4 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1754defaultMinSizeVpY3zN4$default4, false, null, null, null, (lb.a) objRememberedValue4, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
            int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default4);
            lb.a constructor5 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.show_qr, composer, 0), materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
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
    public static final ua.k0 PreviewGroupScreen$lambda$39$14$0$0$0(lb.a aVar, State state, NavHostController navHostController, PreviewGroupViewModel previewGroupViewModel) {
        PreviewGroupScreen$shareThroughToDus(state, navHostController, previewGroupViewModel);
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$14$0$2$0(lb.a aVar, Context context, String str, State state) {
        PreviewGroupScreen$shareThroughOtherApps(context, str, state);
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$14$0$4$0(State state, ClipboardManager clipboardManager, lb.a aVar) {
        ClipData clipDataNewPlainText = ClipData.newPlainText("link", (CharSequence) ((FlowsState) state.getValue()).getData());
        kotlin.jvm.internal.y.f(clipDataNewPlainText);
        clipboardManager.setClip(AndroidClipboardManager_androidKt.toClipEntry(clipDataNewPlainText));
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$14$0$6$0(NavHostController navHostController, State state) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String str = (String) ((FlowsState) state.getValue()).getData();
        if (str == null) {
            str = "";
        }
        NavController.navigate$default((NavController) navHostController, navLinks.goQrViewer(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$15$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$22(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$16$0(PreviewGroupViewModel previewGroupViewModel, String str, MutableState mutableState) {
        previewGroupViewModel.changeSecretState(str);
        PreviewGroupScreen$lambda$22(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$17$0(SnapshotStateList snapshotStateList, NavHostController navHostController, MutableState mutableState, MutableState mutableState2, List list) {
        if (PreviewGroupScreen$lambda$30(mutableState) || PreviewGroupScreen$lambda$24(mutableState2)) {
            PreviewGroupScreen$desactivateEditorMode(list, mutableState);
            PreviewGroupScreen$lambda$25(mutableState2, false);
            snapshotStateList.clear();
        } else {
            navHostController.navigateUp();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$2$0$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$31(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x005f  */
    public static final ua.k0 PreviewGroupScreen$lambda$39$2$1$0(PreviewGroupViewModel previewGroupViewModel, String str, final MutableState mutableState, State state, final List list, final MutableState mutableState2, HashMap result) {
        kotlin.jvm.internal.y.i(result, "result");
        PreviewGroupScreen$lambda$7(mutableState, true);
        String str2 = (String) result.get("delete_image");
        if (str2 == null) {
            str2 = "";
        }
        boolean zD = kotlin.jvm.internal.y.d(str2, "0");
        Object obj = result.get("image");
        Room roomPreviewGroupScreen$lambda$0 = PreviewGroupScreen$lambda$0(state);
        kotlin.jvm.internal.y.f(roomPreviewGroupScreen$lambda$0);
        boolean z10 = (kotlin.jvm.internal.y.d(obj, roomPreviewGroupScreen$lambda$0.getPicture()) || result.get("image") == null) ? false : true;
        String name = (String) result.get("name");
        if (name == null) {
            Room roomPreviewGroupScreen$lambda$1 = PreviewGroupScreen$lambda$0(state);
            kotlin.jvm.internal.y.f(roomPreviewGroupScreen$lambda$1);
            name = roomPreviewGroupScreen$lambda$1.getName();
        } else {
            if (le.d0.q0(name)) {
                Room roomPreviewGroupScreen$lambda$2 = PreviewGroupScreen$lambda$0(state);
                kotlin.jvm.internal.y.f(roomPreviewGroupScreen$lambda$2);
                name = roomPreviewGroupScreen$lambda$2.getName();
            }
            if (name == null) {
                Room roomPreviewGroupScreen$lambda$3 = PreviewGroupScreen$lambda$0(state);
                kotlin.jvm.internal.y.f(roomPreviewGroupScreen$lambda$3);
                name = roomPreviewGroupScreen$lambda$3.getName();
            }
        }
        String str3 = name;
        String subject = (String) result.get(TtmlNode.TAG_INFORMATION);
        if (subject == null) {
            subject = null;
        } else if (le.d0.q0(subject)) {
            Room roomPreviewGroupScreen$lambda$4 = PreviewGroupScreen$lambda$0(state);
            kotlin.jvm.internal.y.f(roomPreviewGroupScreen$lambda$4);
            subject = roomPreviewGroupScreen$lambda$4.getSubject();
        }
        previewGroupViewModel.updateGroup(str, str3, subject, z10 ? (String) result.get("image") : "", zD, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.h
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$2$1$0$2(list, mutableState2, mutableState);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.s
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$2$1$0$3(mutableState);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$2$1$0$2(List list, MutableState mutableState, MutableState mutableState2) {
        PreviewGroupScreen$desactivateEditorMode(list, mutableState);
        PreviewGroupScreen$lambda$7(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$2$1$0$3(MutableState mutableState) {
        PreviewGroupScreen$lambda$7(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$2$2(pe.m0 m0Var, kotlin.jvm.internal.y0 y0Var, kotlin.jvm.internal.u0 u0Var, List list, String str, String str2, String str3, String str4, MutableState mutableState, State state, HashMap updatedResult) {
        kotlin.jvm.internal.y.i(updatedResult, "updatedResult");
        CoroutineUtilsKt.launchWithContext$default(m0Var, null, null, new PreviewGroupScreenKt$PreviewGroupScreen$3$3$3$1(updatedResult, y0Var, u0Var, list, str, str2, str3, str4, mutableState, state, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PreviewGroupScreen$lambda$39$2$3$0(Context context, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        String path = MediaUtil.INSTANCE.getPath(context, Uri.fromFile(new File(it)));
        return path == null ? "" : path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$3$0(NavHostController navHostController, PreviewGroupViewModel previewGroupViewModel, RoomMember userCommon) {
        kotlin.jvm.internal.y.i(userCommon, "userCommon");
        ChatParams chatParams = new ChatParams(userCommon.getId(), 0, null, 0, 12, null);
        NavLinks navLinks = NavLinks.INSTANCE;
        int type = chatParams.getType();
        String strT = previewGroupViewModel.getGson().t(chatParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goChat(type, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$4$0(NavHostController navHostController, PreviewGroupViewModel previewGroupViewModel, String str, State state, RoomMember it) {
        kotlin.jvm.internal.y.i(it, "it");
        if (kotlin.jvm.internal.y.d(PreviewGroupScreen$lambda$1(state), "admin") || (kotlin.jvm.internal.y.d(PreviewGroupScreen$lambda$1(state), UserRoomJoin.AFFILIATION_OWNER) && !kotlin.jvm.internal.y.d(it.getUserRoomJoin().getAffiliation(), UserRoomJoin.AFFILIATION_OWNER))) {
            NavLinks navLinks = NavLinks.INSTANCE;
            String strT = previewGroupViewModel.getGson().t(new PreviewGroupAdminsParams(str, it));
            kotlin.jvm.internal.y.h(strT, "toJson(...)");
            NavController.navigate$default((NavController) navHostController, navLinks.goPreviewAdminGroup(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PreviewGroupScreen$lambda$39$5(final State state, PreviewGroupViewModel previewGroupViewModel, final State state2, String str, final NavHostController navHostController, State state3, State state4, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final pe.m0 m0Var, final kotlin.jvm.internal.y0 y0Var, final List list, final String str2, final String str3, final String str4, final String str5, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, State state5, State state6, Composer composer, int i10) {
        final String str6;
        String str7;
        String str8;
        final PreviewGroupViewModel previewGroupViewModel2;
        String onlyName;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1566667701, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupScreen.<anonymous>.<anonymous> (PreviewGroupScreen.kt:533)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(250));
            Room roomPreviewGroupScreen$lambda$0 = PreviewGroupScreen$lambda$0(state);
            String picture = roomPreviewGroupScreen$lambda$0 != null ? roomPreviewGroupScreen$lambda$0.getPicture() : null;
            ContentScale crop = ContentScale.INSTANCE.getCrop();
            ColorGenerator material = ColorGenerator.INSTANCE.getMATERIAL();
            Room roomPreviewGroupScreen$lambda$1 = PreviewGroupScreen$lambda$0(state);
            String strStringResource = "";
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1755height3ABfNKs, picture, Color.m5856boximpl(ColorKt.Color(material.getColor((roomPreviewGroupScreen$lambda$1 == null || (onlyName = roomPreviewGroupScreen$lambda$1.getOnlyName()) == null) ? "" : onlyName))), null, crop, null, 0, null, null, composer, 24582, 488);
            float f10 = 0;
            float f11 = 20;
            Modifier modifierClip = ClipKt.clip(OffsetKt.m1684offsetVpY3zN4(IntrinsicKt.height(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), IntrinsicSize.Max), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(-Dp.m8823constructorimpl(f11))), RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifierClip, materialTheme.getColorScheme(composer, i11).getBackground(), null, 2, null), Dp.m8823constructorimpl(f11));
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Room roomPreviewGroupScreen$lambda$2 = PreviewGroupScreen$lambda$0(state);
            if (roomPreviewGroupScreen$lambda$2 == null) {
                composer.startReplaceGroup(1594954058);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1594954059);
                SelfMembershipKt.GroupMembershipCard(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f11)), PreviewGroupScreen$lambda$1(state3), previewGroupViewModel.owner().getAlias(), previewGroupViewModel.owner().getPhotoUrl(), composer, 6);
                Icons.Outlined outlined = Icons.Outlined.INSTANCE;
                ImageVector info = InfoKt.getInfo(outlined);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.information, composer, 0);
                String onlySubject = roomPreviewGroupScreen$lambda$2.getOnlySubject();
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion4 = Composer.INSTANCE;
                if (objRememberedValue == companion4.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.w0
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                RichTitleDescBtnKt.RichTitleDescBtn(info, strStringResource2, onlySubject, (lb.a) objRememberedValue, composer, 3072);
                ImageVector lockOpen = PreviewGroupScreen$lambda$3(state4) ? LockOpenKt.getLockOpen(outlined) : LockKt.getLock(outlined);
                String strStringResource3 = StringResources_androidKt.stringResource(PreviewGroupScreen$lambda$3(state4) ? R.string.pull_out_secret : R.string.make_it_secret, composer, 0);
                String strStringResource4 = StringResources_androidKt.stringResource(PreviewGroupScreen$lambda$3(state4) ? R.string.pull_out_secret_text : R.string.make_it_secret_text, composer, 0);
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion4.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.x0
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$1$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(lockOpen, strStringResource3, strStringResource4, 0L, (lb.a) objRememberedValue2, composer, 24576, 8);
                Composer composer2 = composer;
                String strPreviewGroupScreen$lambda$1 = PreviewGroupScreen$lambda$1(state3);
                if (kotlin.jvm.internal.y.d(strPreviewGroupScreen$lambda$1, UserRoomJoin.AFFILIATION_MEMBER)) {
                    composer2.startReplaceGroup(-1719652527);
                    ImageVector exitToApp = ExitToAppKt.getExitToApp(Icons.AutoMirrored.Outlined.INSTANCE);
                    String strStringResource5 = StringResources_androidKt.stringResource(R.string.exit_group, composer2, 0);
                    String strStringResource6 = StringResources_androidKt.stringResource(R.string.stop_interact_group, composer2, 0);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (objRememberedValue3 == companion4.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.y0
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$2$0(mutableState2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(exitToApp, strStringResource5, strStringResource6, 0L, (lb.a) objRememberedValue3, composer2, 24576, 8);
                    ImageVector deleteOutline = DeleteOutlineKt.getDeleteOutline(outlined);
                    String strStringResource7 = StringResources_androidKt.stringResource(R.string.clear_history, composer2, 0);
                    String strStringResource8 = StringResources_androidKt.stringResource(R.string.clear_history_of_msgs, composer2, 0);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == companion4.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.a1
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$3$0(mutableState3);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(deleteOutline, strStringResource7, strStringResource8, 0L, (lb.a) objRememberedValue4, composer2, 24576, 8);
                    composer2.endReplaceGroup();
                    str6 = str;
                    str7 = UserRoomJoin.AFFILIATION_OWNER;
                    str8 = "admin";
                    previewGroupViewModel2 = previewGroupViewModel;
                } else if (va.w.q("admin", UserRoomJoin.AFFILIATION_OWNER).contains(strPreviewGroupScreen$lambda$1)) {
                    composer2.startReplaceGroup(-1718292712);
                    ImageVector groupAdd = GroupAddKt.getGroupAdd(outlined);
                    String strStringResource9 = StringResources_androidKt.stringResource(R.string.add_member, composer2, 0);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == companion4.getEmpty()) {
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.b1
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$4$0(mutableState4);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    str7 = UserRoomJoin.AFFILIATION_OWNER;
                    str8 = "admin";
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(groupAdd, strStringResource9, null, 0L, (lb.a) objRememberedValue5, composer, 24576, 12);
                    composer2 = composer;
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(EditKt.getEdit(outlined), StringResources_androidKt.stringResource(R.string.edit, composer2, 0), StringResources_androidKt.stringResource(R.string.edit_group_properties, composer2, 0), 0L, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.c1
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$5(m0Var, y0Var, list, str2, str3, str4, str5, state, mutableState5);
                        }
                    }, composer2, 0, 8);
                    String str9 = (String) ((FlowsState) state2.getValue()).getData();
                    if (str9 == null || !(!le.d0.q0(str9))) {
                        composer2.startReplaceGroup(-1716801457);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-886684525);
                        ImageVector link = LinkKt.getLink(outlined);
                        String strStringResource10 = StringResources_androidKt.stringResource(R.string.group_invitation_link, composer2, 0);
                        String str10 = (String) ((FlowsState) state2.getValue()).getData();
                        if (str10 == null) {
                            str10 = "";
                        }
                        boolean zChanged = composer2.changed(state2);
                        Object objRememberedValue6 = composer2.rememberedValue();
                        if (zChanged || objRememberedValue6 == companion4.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.d1
                                @Override // lb.a
                                public final Object invoke() {
                                    return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$6$0(state2, mutableState6);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue6);
                        }
                        RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(link, strStringResource10, str10, 0L, (lb.a) objRememberedValue6, composer2, 0, 8);
                        composer2.endReplaceGroup();
                    }
                    ImageVector refresh = RefreshKt.getRefresh(outlined);
                    String strStringResource11 = StringResources_androidKt.stringResource(R.string.group_invitation_link, composer2, 0);
                    String strStringResource12 = StringResources_androidKt.stringResource(R.string.change_link_for_add_members_to_group, composer2, 0);
                    previewGroupViewModel2 = previewGroupViewModel;
                    str6 = str;
                    boolean zChangedInstance = composer2.changedInstance(previewGroupViewModel2) | composer2.changed(str6);
                    Object objRememberedValue7 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue7 == companion4.getEmpty()) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.e1
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$7$0(previewGroupViewModel2, str6, mutableState7);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(refresh, strStringResource11, strStringResource12, 0L, (lb.a) objRememberedValue7, composer2, 0, 8);
                    ImageVector exitToApp2 = ExitToAppKt.getExitToApp(Icons.AutoMirrored.Outlined.INSTANCE);
                    String strStringResource13 = StringResources_androidKt.stringResource(R.string.exit_group, composer2, 0);
                    String strStringResource14 = StringResources_androidKt.stringResource(R.string.stop_interact_group, composer2, 0);
                    Object objRememberedValue8 = composer2.rememberedValue();
                    if (objRememberedValue8 == companion4.getEmpty()) {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.q0
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$8$0(mutableState2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(exitToApp2, strStringResource13, strStringResource14, 0L, (lb.a) objRememberedValue8, composer2, 24576, 8);
                    ImageVector deleteOutline2 = DeleteOutlineKt.getDeleteOutline(outlined);
                    String strStringResource15 = StringResources_androidKt.stringResource(R.string.clear_history, composer2, 0);
                    String strStringResource16 = StringResources_androidKt.stringResource(R.string.clear_history_of_msgs, composer2, 0);
                    Object objRememberedValue9 = composer2.rememberedValue();
                    if (objRememberedValue9 == companion4.getEmpty()) {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.r0
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$9$0(mutableState3);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(deleteOutline2, strStringResource15, strStringResource16, 0L, (lb.a) objRememberedValue9, composer2, 24576, 8);
                    composer2.endReplaceGroup();
                } else {
                    str6 = str;
                    str7 = UserRoomJoin.AFFILIATION_OWNER;
                    str8 = "admin";
                    previewGroupViewModel2 = previewGroupViewModel;
                    composer2.startReplaceGroup(-1714948556);
                    ImageVector deleteOutline3 = DeleteOutlineKt.getDeleteOutline(outlined);
                    String strStringResource17 = StringResources_androidKt.stringResource(R.string.eliminate_group, composer2, 0);
                    String strStringResource18 = StringResources_androidKt.stringResource(R.string.clear_history_of_msgs, composer2, 0);
                    Object objRememberedValue10 = composer2.rememberedValue();
                    if (objRememberedValue10 == companion4.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.s0
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$10$0(mutableState8);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(deleteOutline3, strStringResource17, strStringResource18, 0L, (lb.a) objRememberedValue10, composer2, 24576, 8);
                    composer2.endReplaceGroup();
                }
                DividerKt.m3177HorizontalDivider9IZ8Weo(PaddingKt.m1726paddingVpY3zN4(companion, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(5)), 0.0f, materialTheme.getColorScheme(composer2, i11).getTertiary(), composer2, 6, 2);
                ImageVector folder = FolderKt.getFolder(outlined);
                String strStringResource19 = StringResources_androidKt.stringResource(R.string.folder, composer2, 0);
                String strStringResource20 = StringResources_androidKt.stringResource(R.string.find_the_chat_attachments, composer2, 0);
                boolean zChangedInstance2 = composer2.changedInstance(navHostController) | composer2.changed(str6);
                Object objRememberedValue11 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue11 == companion4.getEmpty()) {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.t0
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$11$0(navHostController, str6);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue11);
                }
                RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(folder, strStringResource19, strStringResource20, 0L, (lb.a) objRememberedValue11, composer2, 0, 8);
                boolean z10 = !PreviewGroupScreen$lambda$4(state5);
                boolean zChangedInstance3 = composer2.changedInstance(previewGroupViewModel2) | composer2.changed(str6);
                Object objRememberedValue12 = composer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue12 == companion4.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.u0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$12$0(previewGroupViewModel2, str6, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                Z17TextToggleKt.Z17TextToggle(companion, z10, (Function1) objRememberedValue12, ComposableSingletons$PreviewGroupScreenKt.INSTANCE.getLambda$735879078$app_productionPFast(), StringResources_androidKt.stringResource(R.string.notifications, composer2, 0), null, null, composer2, 3078, 96);
                ImageVector info2 = InfoKt.getInfo(outlined);
                String str11 = StringResources_androidKt.stringResource(R.string.members, composer2, 0) + " (" + PreviewGroupScreen$lambda$2(state6) + ")";
                if (va.w.q(str8, str7).contains(PreviewGroupScreen$lambda$1(state3))) {
                    composer2.startReplaceGroup(-1712001944);
                    strStringResource = StringResources_androidKt.stringResource(R.string.keep_pressing_to_manage_member, composer2, 0);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1711866197);
                    composer2.endReplaceGroup();
                }
                Object objRememberedValue13 = composer2.rememberedValue();
                if (objRememberedValue13 == companion4.getEmpty()) {
                    objRememberedValue13 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.v0
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                }
                RichTitleDescBtnKt.RichTitleDescBtn(info2, str11, strStringResource, (lb.a) objRememberedValue13, composer2, 3072);
                ua.k0 k0Var = ua.k0.f43947a;
                composer.endReplaceGroup();
            }
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
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$1$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$22(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$10$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$10(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$11$0(NavHostController navHostController, String str) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goChatResources(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$12$0(PreviewGroupViewModel previewGroupViewModel, String str, boolean z10) {
        previewGroupViewModel.changeMuteValue(str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$2$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$13(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$3$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$16(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$4$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$25(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$5(pe.m0 m0Var, kotlin.jvm.internal.y0 y0Var, List list, String str, String str2, String str3, String str4, State state, MutableState mutableState) {
        PreviewGroupScreen$activateEditorMode(m0Var, y0Var, list, str, str2, str3, str4, state, mutableState);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$6$0(State state, MutableState mutableState) {
        CharSequence charSequence;
        if (((FlowsState) state.getValue()).getStatus() == Status.SUCCESS && (charSequence = (CharSequence) ((FlowsState) state.getValue()).getData()) != null && charSequence.length() != 0) {
            PreviewGroupScreen$lambda$19(mutableState, true);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$7$0(PreviewGroupViewModel previewGroupViewModel, String str, final MutableState mutableState) {
        PreviewGroupScreen$lambda$7(mutableState, true);
        previewGroupViewModel.createGroupLink(str, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.h1
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$5$0$0$0$7$0$0(mutableState);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$7$0$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$7(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$8$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$13(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$5$0$0$0$9$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$16(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PreviewGroupScreen$lambda$39$6$0(String str, String str2, String str3, RoomMember roomMember) {
        UserRoomJoin userRoomJoin;
        String affiliation = (roomMember == null || (userRoomJoin = roomMember.getUserRoomJoin()) == null) ? null : userRoomJoin.getAffiliation();
        if (affiliation == null) {
            return "";
        }
        int iHashCode = affiliation.hashCode();
        if (iHashCode == -1077769574) {
            return !affiliation.equals(UserRoomJoin.AFFILIATION_MEMBER) ? "" : str3;
        }
        if (iHashCode != 92668751) {
            return (iHashCode == 106164915 && affiliation.equals(UserRoomJoin.AFFILIATION_OWNER)) ? str : "";
        }
        return !affiliation.equals("admin") ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$7$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$10(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$8$0(PreviewGroupViewModel previewGroupViewModel, String str, NavHostController navHostController) {
        previewGroupViewModel.clearDeleteGroup(str);
        navHostController.navigate(NavLinks.HOME, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewGroupScreenKt.PreviewGroupScreen$lambda$39$8$0$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$8$0$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$39$9$0(MutableState mutableState) {
        PreviewGroupScreen$lambda$13(mutableState, false);
        return ua.k0.f43947a;
    }

    private static final boolean PreviewGroupScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewGroupScreen$lambda$40(NavHostController navHostController, String str, PreviewGroupViewModel previewGroupViewModel, boolean z10, int i10, int i11, Composer composer, int i12) {
        PreviewGroupScreen(navHostController, str, previewGroupViewModel, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    private static final boolean PreviewGroupScreen$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewGroupScreen$lambda$7(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewGroupScreen$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupScreen$shareThroughOtherApps(Context context, String str, State<FlowsState<String>> state) {
        IntentUtil intentUtil = IntentUtil.INSTANCE;
        String data = state.getValue().getData();
        if (data == null) {
            data = "";
        }
        intentUtil.shareText(context, str, data);
    }

    private static final void PreviewGroupScreen$shareThroughToDus(State<FlowsState<String>> state, NavHostController navHostController, PreviewGroupViewModel previewGroupViewModel) {
        String data = state.getValue().getData();
        if (data == null) {
            data = "";
        }
        SendToParams sendToParams = new SendToParams(va.w.g(new Send(9, data)));
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = previewGroupViewModel.getGson().t(sendToParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goForwardTo(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0136  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public static final Object PreviewGroupScreen$updateStateForDeleteImage(List<FormItemRequest> list, String str, kotlin.jvm.internal.y0 y0Var, String str2, String str3, String str4, MutableState<Boolean> mutableState, State<Room> state, HashMap<String, String> map, ab.e<? super ua.k0> eVar) {
        PreviewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1 previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1;
        boolean zD;
        kotlin.jvm.internal.y0 y0Var2;
        String str5;
        String str6;
        State<Room> state2;
        List<FormItemRequest> list2;
        String str7;
        String str8;
        String str9;
        MutableState<Boolean> mutableState2 = mutableState;
        HashMap<String, String> map2 = map;
        if (eVar instanceof PreviewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1) {
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1 = (PreviewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1) eVar;
            int i10 = previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.label = i10 - Integer.MIN_VALUE;
            } else {
                previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1 = new PreviewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1(eVar);
            }
        } else {
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1 = new PreviewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1(eVar);
        }
        Object obj = previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.result;
        Object objG = bb.b.g();
        int i11 = previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.label;
        if (i11 == 0) {
            ua.v.b(obj);
            String str10 = map2.get("delete_image");
            if (str10 == null) {
                str10 = "";
            }
            zD = kotlin.jvm.internal.y.d(str10, "0");
            list.clear();
            PreviewGroupScreen$lambda$7(mutableState2, true);
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$0 = list;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$1 = str;
            y0Var2 = y0Var;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$2 = y0Var2;
            str5 = str2;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$3 = str5;
            str6 = str3;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$4 = str6;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$5 = str4;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$6 = mutableState2;
            state2 = state;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$7 = state2;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$8 = map2;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.Z$0 = zD;
            previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.label = 1;
            if (pe.w0.b(10L, previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1) == objG) {
                return objG;
            }
            list2 = list;
            str7 = str;
            str8 = str4;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z10 = previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.Z$0;
            map2 = (HashMap) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$8;
            State<Room> state3 = (State) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$7;
            MutableState<Boolean> mutableState3 = (MutableState) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$6;
            str8 = (String) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$5;
            String str11 = (String) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$4;
            str5 = (String) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$3;
            kotlin.jvm.internal.y0 y0Var3 = (kotlin.jvm.internal.y0) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$2;
            String str12 = (String) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$1;
            list2 = (List) previewGroupScreenKt$PreviewGroupScreen$updateStateForDeleteImage$1.L$0;
            ua.v.b(obj);
            str6 = str11;
            y0Var2 = y0Var3;
            zD = z10;
            state2 = state3;
            mutableState2 = mutableState3;
            str7 = str12;
        }
        FormItemRequest formItemRequest = new FormItemRequest("image", FormItemType.LARGE_IMAGE, str7, "", zD ? "" : (String) y0Var2.f36634c, "", "", 0, 0.0f, null, null, 1920, null);
        FormItemType formItemType = FormItemType.MULTIPLE_SELECTION;
        String str13 = map2.get("delete_image");
        if (str13 != null) {
            if (le.d0.q0(str13)) {
                str13 = r8;
            }
            str9 = str13;
        } else {
            str9 = r8;
        }
        FormItemRequest formItemRequest2 = new FormItemRequest("delete_image", formItemType, "", "", str9, "", "", 0, 0.0f, va.v.e(str5), null, 1408, null);
        FormItemType formItemType2 = FormItemType.TEXT;
        String name = map2.get("name");
        if (name == null) {
            Room roomPreviewGroupScreen$lambda$0 = PreviewGroupScreen$lambda$0(state2);
            kotlin.jvm.internal.y.f(roomPreviewGroupScreen$lambda$0);
            name = roomPreviewGroupScreen$lambda$0.getName();
        } else {
            if (le.d0.q0(name)) {
                Room roomPreviewGroupScreen$lambda$1 = PreviewGroupScreen$lambda$0(state2);
                kotlin.jvm.internal.y.f(roomPreviewGroupScreen$lambda$1);
                name = roomPreviewGroupScreen$lambda$1.getName();
            }
            if (name == null) {
                Room roomPreviewGroupScreen$lambda$2 = PreviewGroupScreen$lambda$0(state2);
                kotlin.jvm.internal.y.f(roomPreviewGroupScreen$lambda$2);
                name = roomPreviewGroupScreen$lambda$2.getName();
            }
        }
        FormItemRequest formItemRequest3 = new FormItemRequest("name", formItemType2, str6, "", name, UtilRegex.CANNOT_BE_EMPTY, "", 150, 0.0f, null, null, 1792, null);
        FormItemType formItemType3 = FormItemType.LARGE_TEXT;
        String str14 = map2.get(TtmlNode.TAG_INFORMATION);
        list2.addAll(va.w.q(formItemRequest, formItemRequest2, formItemRequest3, new FormItemRequest(TtmlNode.TAG_INFORMATION, formItemType3, str8, "", str14 == null ? r8 : str14, "", "", PsExtractor.VIDEO_STREAM_MASK, 0.0f, null, null, 1792, null)));
        PreviewGroupScreen$lambda$7(mutableState2, false);
        return ua.k0.f43947a;
    }
}
