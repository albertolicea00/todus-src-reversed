package cu.todus.android.uiCompose.main.screen.chat.component.channel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.camera.video.VideoSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.pullrefresh.PullRefreshIndicatorKt;
import androidx.compose.material.pullrefresh.PullRefreshKt;
import androidx.compose.material.pullrefresh.PullRefreshState;
import androidx.compose.material.pullrefresh.PullRefreshStateKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p000activity.compose.ActivityResultRegistryKt;
import androidx.p000activity.compose.BackHandlerKt;
import androidx.p000activity.compose.ManagedActivityResultLauncher;
import androidx.p000activity.result.contract.ActivityResultContracts;
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
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.ButtonTemplate;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.messageentity.MentionName;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.notification.ConfigProcessor;
import cu.todus.android.notification.INotificationFilter;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewKt;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewState;
import cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorKt;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatScreenState;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.main.screen.chat.deletingDialog.DeletingDialogKt;
import cu.todus.android.uiCompose.main.screen.chat.details.DetailsDialogForContactCardKt;
import cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialogKt;
import cu.todus.android.uiCompose.main.screen.chat.functionalities.ChatButtonsFunctionality;
import cu.todus.android.uiCompose.main.screen.chat.functionalities.ChatComplexFunctionalities;
import cu.todus.android.uiCompose.main.screen.chat.input.ChatInputKt;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.list.MsgListKt;
import cu.todus.android.uiCompose.main.screen.chat.mentionList.MentionItemModel;
import cu.todus.android.uiCompose.main.screen.chat.mentionList.MentionListKt;
import cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialogData;
import cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialogKt;
import cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt;
import cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt;
import cu.todus.android.uiCompose.main.screen.chat.preview.PinnedMsg;
import cu.todus.android.uiCompose.main.screen.chat.stickers.GroupsContainerKt;
import cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBarKt;
import cu.todus.android.uiCompose.main.screen.chat.unknownConfirmation.UnknownConfirmationKt;
import cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorParams;
import cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersParams;
import cu.todus.android.uiCompose.main.screen.map.MapMotive;
import cu.todus.android.uiCompose.main.screen.map.MapParams;
import cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.animations.attach.AttachContainerKt;
import cu.todus.android.uiCompose.shared.camera.CameraKt;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.utils.ContactUtil;
import cu.todus.android.utils.IntentUtil;
import cu.todus.android.volatileState.AppVolatileState;
import cu.z17.singledi.SinglediException;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import j$.util.Collection;
import j$.util.function.Predicate$CC;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006*²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\nX\u008a\u0084\u0002²\u0006\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0015\u001a\u00020\u00148\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0018\u001a\u00020\u00128\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00198\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001f\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010 \u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010!\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\"\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010#\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\f\u0010$\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010%\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\nX\u008a\u0084\u0002²\u0006\u000e\u0010)\u001a\u00020\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;", "viewModel", "Lua/k0;", "ChatChannelScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "chatScreenState", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/data/db/pojo/Friend;", "requestedFriendByContact", "Lkotlin/Function1;", "scrollBottom", "", "scrollToPosition", "", "actualRecorderTime", "Lcu/z17/views/permission/PermissionsRequesterState;", "mediaPermissionsState", "newCount", "Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogData;", "createPlaceholderMsg", "Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "attachmentPreview", "showAttachmentSelector", "isPickingFiles", "showDeleteForEveryone", "showDeleteDialog", "openCamera", "showStickers", "msgDetailId", "showUnknown", "showPinnedMsg", "", "Lcu/todus/android/uiCompose/main/screen/chat/mentionList/MentionItemModel;", "mentionList", "openMention", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatChannelScreenKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageAction.values().length];
            try {
                iArr[MessageAction.MENTION_CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageAction.TAG_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageAction.NUMBER_CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageAction.LINK_CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessageAction.COMMAND_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0261  */
    /* JADX WARN: Code duplicated, block: B:103:0x0276  */
    /* JADX WARN: Code duplicated, block: B:106:0x0289  */
    /* JADX WARN: Code duplicated, block: B:109:0x029e  */
    /* JADX WARN: Code duplicated, block: B:112:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:115:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:118:0x02df  */
    /* JADX WARN: Code duplicated, block: B:123:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:128:0x0325  */
    /* JADX WARN: Code duplicated, block: B:131:0x035c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0371  */
    /* JADX WARN: Code duplicated, block: B:137:0x0388  */
    /* JADX WARN: Code duplicated, block: B:140:0x039f  */
    /* JADX WARN: Code duplicated, block: B:145:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:148:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:151:0x0415  */
    /* JADX WARN: Code duplicated, block: B:154:0x042f  */
    /* JADX WARN: Code duplicated, block: B:157:0x0446  */
    /* JADX WARN: Code duplicated, block: B:160:0x045d  */
    /* JADX WARN: Code duplicated, block: B:163:0x048a  */
    /* JADX WARN: Code duplicated, block: B:166:0x052e  */
    /* JADX WARN: Code duplicated, block: B:172:0x054c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:63:0x0114  */
    /* JADX WARN: Code duplicated, block: B:66:0x012b  */
    /* JADX WARN: Code duplicated, block: B:74:0x0163  */
    /* JADX WARN: Code duplicated, block: B:77:0x016c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0186  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:88:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:91:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:94:0x022c  */
    /* JADX WARN: Code duplicated, block: B:97:0x024c  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"CoroutineCreationDuringComposition"})
    public static final void ChatChannelScreen(final NavHostController navHostController, final String params, ChatViewModel chatViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        ChatViewModel chatViewModel2;
        final ChatViewModel chatViewModel3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2 function2;
        String str;
        Composer composer2;
        ChatViewModel chatViewModel4;
        ScaffoldState scaffoldStateRememberScaffoldState;
        Object objRememberedValue;
        Composer.Companion companion;
        final pe.m0 m0Var;
        final Context context;
        final SoftwareKeyboardController softwareKeyboardController;
        Object objRememberedValue2;
        final MutableState mutableState;
        Object objRememberedValue3;
        final ChatParams chatParams;
        final ChatViewModel chatViewModel5;
        Object objRememberedValue4;
        Composer composer3;
        final State stateCollectAsStateWithLifecycle;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Object objRememberedValue8;
        final TextFieldState textFieldStateM2202rememberTextFieldStateLepunE;
        Object objRememberedValue9;
        Object objRememberedValue10;
        Object objRememberedValue11;
        final MutableState mutableState2;
        Object objRememberedValue12;
        Object objRememberedValue13;
        Object objRememberedValue14;
        Object objRememberedValue15;
        final MutableState mutableState3;
        Object objRememberedValue16;
        final SnapshotStateList snapshotStateList;
        boolean zChangedInstance;
        Object objRememberedValue17;
        boolean zChangedInstance2;
        Object objRememberedValue18;
        Object objRememberedValue19;
        Object objRememberedValue20;
        Object objRememberedValue21;
        Object objRememberedValue22;
        boolean zChangedInstance3;
        Object objRememberedValue23;
        Object objRememberedValue24;
        Object objRememberedValue25;
        Object objRememberedValue26;
        Object objRememberedValue27;
        Object objRememberedValue28;
        Object objRememberedValue29;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(80075845);
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
                chatViewModel2 = chatViewModel;
                int i13 = composerStartRestartGroup.changedInstance(chatViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                chatViewModel2 = chatViewModel;
            }
            i12 |= i13;
        } else {
            chatViewModel2 = chatViewModel;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 147) != 146, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    int i15 = i14 & 112;
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    str = params;
                    ViewModel viewModel = ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(ChatViewModel.class), current, str, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, (i15 << 3) & 896, 0);
                    composer2 = composerStartRestartGroup;
                    chatViewModel4 = (ChatViewModel) viewModel;
                    i14 &= -897;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(80075845, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen (ChatChannelScreen.kt:136)");
                }
                scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, 3);
                objRememberedValue = composer2.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer2);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                m0Var = (pe.m0) objRememberedValue;
                context = (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                softwareKeyboardController = (SoftwareKeyboardController) composer2.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = (ChatParams) chatViewModel4.getGson().j(str, ChatParams.class);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                chatParams = (ChatParams) objRememberedValue3;
                if (chatParams.getUid().length() == 0 || kotlin.jvm.internal.y.d(chatParams.getUid(), chatViewModel4.getOwner().getNameWithDomain())) {
                    navHostController.navigateUp();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    final ChatViewModel chatViewModel6 = chatViewModel4;
                    final String str2 = str;
                    function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.w6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$4(navHostController, str2, chatViewModel6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                } else {
                    chatViewModel5 = chatViewModel4;
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new INotificationFilter() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1
                            @Override // cu.todus.android.notification.INotificationFilter
                            public boolean apply(Heritage heritage) {
                                kotlin.jvm.internal.y.i(heritage, "heritage");
                                return Heritage.INSTANCE.contains(chatParams.getUid(), heritage);
                            }

                            @Override // cu.todus.android.notification.INotificationFilter
                            public Heritage heritage() {
                                return ConfigProcessor.INSTANCE.buildHeritagePrivateChat(chatParams.getUid());
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    final ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1 chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1 = (ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1) objRememberedValue4;
                    composer3 = composer2;
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getChatScreenState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                    final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getRequestingFriend(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.chatMsgs(chatParams.getUid()), null, composer3, 0, 1);
                    objRememberedValue5 = composer3.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    final MutableState mutableState4 = (MutableState) objRememberedValue5;
                    objRememberedValue6 = composer3.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState5 = (MutableState) objRememberedValue6;
                    final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getRecordingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                    objRememberedValue7 = composer3.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA), 1, null), null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue7);
                    }
                    final MutableState mutableState6 = (MutableState) objRememberedValue7;
                    objRememberedValue8 = composer3.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new FocusRequester();
                        composer3.updateRememberedValue(objRememberedValue8);
                    }
                    final FocusRequester focusRequester = (FocusRequester) objRememberedValue8;
                    textFieldStateM2202rememberTextFieldStateLepunE = TextFieldStateKt.m2202rememberTextFieldStateLepunE(null, 0L, composer3, 0, 3);
                    objRememberedValue9 = composer3.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composer3.updateRememberedValue(objRememberedValue9);
                    }
                    final MutableIntState mutableIntState = (MutableIntState) objRememberedValue9;
                    objRememberedValue10 = composer3.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue10);
                    }
                    final MutableState mutableState7 = (MutableState) objRememberedValue10;
                    objRememberedValue11 = composer3.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue11);
                    }
                    mutableState2 = (MutableState) objRememberedValue11;
                    objRememberedValue12 = composer3.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue12);
                    }
                    final MutableState mutableState8 = (MutableState) objRememberedValue12;
                    objRememberedValue13 = composer3.rememberedValue();
                    if (objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue13);
                    }
                    final MutableState mutableState9 = (MutableState) objRememberedValue13;
                    objRememberedValue14 = composer3.rememberedValue();
                    if (objRememberedValue14 == companion.getEmpty()) {
                        objRememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue14);
                    }
                    final MutableState mutableState10 = (MutableState) objRememberedValue14;
                    objRememberedValue15 = composer3.rememberedValue();
                    if (objRememberedValue15 == companion.getEmpty()) {
                        objRememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue15);
                    }
                    mutableState3 = (MutableState) objRememberedValue15;
                    objRememberedValue16 = composer3.rememberedValue();
                    if (objRememberedValue16 == companion.getEmpty()) {
                        objRememberedValue16 = SnapshotStateKt.mutableStateListOf();
                        composer3.updateRememberedValue(objRememberedValue16);
                    }
                    snapshotStateList = (SnapshotStateList) objRememberedValue16;
                    ActivityResultContracts.GetContent getContent = new ActivityResultContracts.GetContent();
                    zChangedInstance = composer3.changedInstance(context);
                    objRememberedValue17 = composer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue17 == companion.getEmpty()) {
                        objRememberedValue17 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.x6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$42$0(context, mutableState3, snapshotStateList, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue17);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent, (Function1) objRememberedValue17, composer3, 0);
                    ActivityResultContracts.PickContact pickContact = new ActivityResultContracts.PickContact();
                    zChangedInstance2 = composer3.changedInstance(context) | composer3.changedInstance(chatViewModel5);
                    objRememberedValue18 = composer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue18 == companion.getEmpty()) {
                        objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.y6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$47$0(context, chatViewModel5, chatParams, mutableState2, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue18);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(pickContact, (Function1) objRememberedValue18, composer3, 0);
                    final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getAllMsgsAreMine(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                    objRememberedValue19 = composer3.rememberedValue();
                    if (objRememberedValue19 == companion.getEmpty()) {
                        objRememberedValue19 = SnapshotStateKt.mutableStateListOf();
                        composer3.updateRememberedValue(objRememberedValue19);
                    }
                    final SnapshotStateList snapshotStateList2 = (SnapshotStateList) objRememberedValue19;
                    objRememberedValue20 = composer3.rememberedValue();
                    if (objRememberedValue20 == companion.getEmpty()) {
                        objRememberedValue20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue20);
                    }
                    final MutableState mutableState11 = (MutableState) objRememberedValue20;
                    objRememberedValue21 = composer3.rememberedValue();
                    if (objRememberedValue21 == companion.getEmpty()) {
                        objRememberedValue21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue21);
                    }
                    final MutableState mutableState12 = (MutableState) objRememberedValue21;
                    objRememberedValue22 = composer3.rememberedValue();
                    if (objRememberedValue22 == companion.getEmpty()) {
                        objRememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue22);
                    }
                    final MutableState mutableState13 = (MutableState) objRememberedValue22;
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getRecentStickers(), null, composer3, 0, 1);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems3 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getFavoriteStickers(), null, composer3, 0, 1);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems4 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getAllStickers(), null, composer3, 0, 1);
                    ActivityResultContracts.GetContent getContent2 = new ActivityResultContracts.GetContent();
                    zChangedInstance3 = composer3.changedInstance(chatViewModel5) | composer3.changedInstance(context) | composer3.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue23 = composer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue23 == companion.getEmpty()) {
                        objRememberedValue23 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.z6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$71$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue23);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult3 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent2, (Function1) objRememberedValue23, composer3, 0);
                    objRememberedValue24 = composer3.rememberedValue();
                    if (objRememberedValue24 == companion.getEmpty()) {
                        objRememberedValue24 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue24);
                    }
                    final MutableState mutableState14 = (MutableState) objRememberedValue24;
                    objRememberedValue25 = composer3.rememberedValue();
                    if (objRememberedValue25 == companion.getEmpty()) {
                        objRememberedValue25 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.b7
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(ChatChannelScreenKt.ChatChannelScreen$lambda$75$0(stateCollectAsStateWithLifecycle));
                            }
                        });
                        composer3.updateRememberedValue(objRememberedValue25);
                    }
                    final State state = (State) objRememberedValue25;
                    objRememberedValue26 = composer3.rememberedValue();
                    if (objRememberedValue26 == companion.getEmpty()) {
                        objRememberedValue26 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue26);
                    }
                    final MutableState mutableState15 = (MutableState) objRememberedValue26;
                    objRememberedValue27 = composer3.rememberedValue();
                    if (objRememberedValue27 == companion.getEmpty()) {
                        objRememberedValue27 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue27);
                    }
                    final MutableState mutableState16 = (MutableState) objRememberedValue27;
                    objRememberedValue28 = composer3.rememberedValue();
                    if (objRememberedValue28 == companion.getEmpty()) {
                        objRememberedValue28 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.c7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$81$0(textFieldStateM2202rememberTextFieldStateLepunE);
                            }
                        });
                        composer3.updateRememberedValue(objRememberedValue28);
                    }
                    final State state2 = (State) objRememberedValue28;
                    final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getMentionList(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                    objRememberedValue29 = composer3.rememberedValue();
                    if (objRememberedValue29 == companion.getEmpty()) {
                        objRememberedValue29 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue29);
                    }
                    final MutableState mutableState17 = (MutableState) objRememberedValue29;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(751189649, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.d7
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88(mutableState9, mutableState14, mutableState12, navHostController, snapshotStateList2, chatViewModel5, textFieldStateM2202rememberTextFieldStateLepunE, softwareKeyboardController, stateCollectAsStateWithLifecycle, context, managedActivityResultLauncherRememberLauncherForActivityResult3, mutableState7, mutableState11, mutableState2, mutableState6, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer3, 54);
                    Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.e7
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89(snapshotStateList2, chatViewModel5, stateCollectAsStateWithLifecycle, textFieldStateM2202rememberTextFieldStateLepunE, chatParams, m0Var, navHostController, mutableState2, mutableState7, snapshotStateList, mutableState4, mutableState5, lazyPagingItemsCollectAsLazyPagingItems, softwareKeyboardController, context, focusRequester, mutableState8, mutableState9, mutableState, mutableState17, stateCollectAsStateWithLifecycle5, state2, mutableState15, mutableState16, mutableIntState, state, mutableState3, mutableState10, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState6, managedActivityResultLauncherRememberLauncherForActivityResult2, mutableState13, lazyPagingItemsCollectAsLazyPagingItems2, lazyPagingItemsCollectAsLazyPagingItems3, lazyPagingItemsCollectAsLazyPagingItems4, stateCollectAsStateWithLifecycle3, mutableState12, stateCollectAsStateWithLifecycle2, mutableState11, stateCollectAsStateWithLifecycle4, mutableState14, chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    composerStartRestartGroup = composer3;
                    Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-420149937, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chatViewModel3 = chatViewModel5;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            composerStartRestartGroup.skipToGroupEnd();
            if ((i11 & 4) != 0) {
                i14 &= -897;
            }
            composer2 = composerStartRestartGroup;
            str = params;
            chatViewModel4 = chatViewModel2;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(80075845, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen (ChatChannelScreen.kt:136)");
            }
            scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, 3);
            objRememberedValue = composer2.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer2);
                composer2.updateRememberedValue(objRememberedValue);
            }
            m0Var = (pe.m0) objRememberedValue;
            context = (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            softwareKeyboardController = (SoftwareKeyboardController) composer2.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
            objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            objRememberedValue3 = composer2.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = (ChatParams) chatViewModel4.getGson().j(str, ChatParams.class);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            chatParams = (ChatParams) objRememberedValue3;
            if (chatParams.getUid().length() == 0) {
                chatViewModel5 = chatViewModel4;
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new INotificationFilter() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1
                        @Override // cu.todus.android.notification.INotificationFilter
                        public boolean apply(Heritage heritage) {
                            kotlin.jvm.internal.y.i(heritage, "heritage");
                            return Heritage.INSTANCE.contains(chatParams.getUid(), heritage);
                        }

                        @Override // cu.todus.android.notification.INotificationFilter
                        public Heritage heritage() {
                            return ConfigProcessor.INSTANCE.buildHeritagePrivateChat(chatParams.getUid());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                final ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1 chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$2 = (ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1) objRememberedValue4;
                composer3 = composer2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getChatScreenState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getRequestingFriend(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems5 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.chatMsgs(chatParams.getUid()), null, composer3, 0, 1);
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState18 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState19 = (MutableState) objRememberedValue6;
                final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getRecordingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                objRememberedValue7 = composer3.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA), 1, null), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                final MutableState mutableState20 = (MutableState) objRememberedValue7;
                objRememberedValue8 = composer3.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new FocusRequester();
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                final FocusRequester focusRequester2 = (FocusRequester) objRememberedValue8;
                textFieldStateM2202rememberTextFieldStateLepunE = TextFieldStateKt.m2202rememberTextFieldStateLepunE(null, 0L, composer3, 0, 3);
                objRememberedValue9 = composer3.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composer3.updateRememberedValue(objRememberedValue9);
                }
                final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue9;
                objRememberedValue10 = composer3.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue10);
                }
                final MutableState mutableState21 = (MutableState) objRememberedValue10;
                objRememberedValue11 = composer3.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                mutableState2 = (MutableState) objRememberedValue11;
                objRememberedValue12 = composer3.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue12);
                }
                final MutableState mutableState22 = (MutableState) objRememberedValue12;
                objRememberedValue13 = composer3.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue13);
                }
                final MutableState mutableState23 = (MutableState) objRememberedValue13;
                objRememberedValue14 = composer3.rememberedValue();
                if (objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue14);
                }
                final MutableState mutableState110 = (MutableState) objRememberedValue14;
                objRememberedValue15 = composer3.rememberedValue();
                if (objRememberedValue15 == companion.getEmpty()) {
                    objRememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue15);
                }
                mutableState3 = (MutableState) objRememberedValue15;
                objRememberedValue16 = composer3.rememberedValue();
                if (objRememberedValue16 == companion.getEmpty()) {
                    objRememberedValue16 = SnapshotStateKt.mutableStateListOf();
                    composer3.updateRememberedValue(objRememberedValue16);
                }
                snapshotStateList = (SnapshotStateList) objRememberedValue16;
                ActivityResultContracts.GetContent getContent3 = new ActivityResultContracts.GetContent();
                zChangedInstance = composer3.changedInstance(context);
                objRememberedValue17 = composer3.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue17 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.x6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$42$0(context, mutableState3, snapshotStateList, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue17);
                } else {
                    objRememberedValue17 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.x6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$42$0(context, mutableState3, snapshotStateList, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue17);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult4 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent3, (Function1) objRememberedValue17, composer3, 0);
                ActivityResultContracts.PickContact pickContact2 = new ActivityResultContracts.PickContact();
                zChangedInstance2 = composer3.changedInstance(context) | composer3.changedInstance(chatViewModel5);
                objRememberedValue18 = composer3.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.y6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$47$0(context, chatViewModel5, chatParams, mutableState2, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue18);
                } else {
                    objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.y6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$47$0(context, chatViewModel5, chatParams, mutableState2, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue18);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult5 = ActivityResultRegistryKt.rememberLauncherForActivityResult(pickContact2, (Function1) objRememberedValue18, composer3, 0);
                final State stateCollectAsStateWithLifecycle8 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getAllMsgsAreMine(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                objRememberedValue19 = composer3.rememberedValue();
                if (objRememberedValue19 == companion.getEmpty()) {
                    objRememberedValue19 = SnapshotStateKt.mutableStateListOf();
                    composer3.updateRememberedValue(objRememberedValue19);
                }
                final SnapshotStateList snapshotStateList3 = (SnapshotStateList) objRememberedValue19;
                objRememberedValue20 = composer3.rememberedValue();
                if (objRememberedValue20 == companion.getEmpty()) {
                    objRememberedValue20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue20);
                }
                final MutableState mutableState111 = (MutableState) objRememberedValue20;
                objRememberedValue21 = composer3.rememberedValue();
                if (objRememberedValue21 == companion.getEmpty()) {
                    objRememberedValue21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue21);
                }
                final MutableState mutableState112 = (MutableState) objRememberedValue21;
                objRememberedValue22 = composer3.rememberedValue();
                if (objRememberedValue22 == companion.getEmpty()) {
                    objRememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue22);
                }
                final MutableState mutableState113 = (MutableState) objRememberedValue22;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems6 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getRecentStickers(), null, composer3, 0, 1);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems7 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getFavoriteStickers(), null, composer3, 0, 1);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems8 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getAllStickers(), null, composer3, 0, 1);
                ActivityResultContracts.GetContent getContent4 = new ActivityResultContracts.GetContent();
                zChangedInstance3 = composer3.changedInstance(chatViewModel5) | composer3.changedInstance(context) | composer3.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue23 = composer3.rememberedValue();
                if (zChangedInstance3) {
                    objRememberedValue23 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.z6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$71$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue23);
                } else {
                    objRememberedValue23 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.z6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$71$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue23);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult6 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent4, (Function1) objRememberedValue23, composer3, 0);
                objRememberedValue24 = composer3.rememberedValue();
                if (objRememberedValue24 == companion.getEmpty()) {
                    objRememberedValue24 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue24);
                }
                final MutableState mutableState114 = (MutableState) objRememberedValue24;
                objRememberedValue25 = composer3.rememberedValue();
                if (objRememberedValue25 == companion.getEmpty()) {
                    objRememberedValue25 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.b7
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(ChatChannelScreenKt.ChatChannelScreen$lambda$75$0(stateCollectAsStateWithLifecycle));
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue25);
                }
                final State state3 = (State) objRememberedValue25;
                objRememberedValue26 = composer3.rememberedValue();
                if (objRememberedValue26 == companion.getEmpty()) {
                    objRememberedValue26 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue26);
                }
                final MutableState mutableState115 = (MutableState) objRememberedValue26;
                objRememberedValue27 = composer3.rememberedValue();
                if (objRememberedValue27 == companion.getEmpty()) {
                    objRememberedValue27 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue27);
                }
                final MutableState mutableState116 = (MutableState) objRememberedValue27;
                objRememberedValue28 = composer3.rememberedValue();
                if (objRememberedValue28 == companion.getEmpty()) {
                    objRememberedValue28 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.c7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$81$0(textFieldStateM2202rememberTextFieldStateLepunE);
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue28);
                }
                final State state4 = (State) objRememberedValue28;
                final State stateCollectAsStateWithLifecycle9 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getMentionList(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                objRememberedValue29 = composer3.rememberedValue();
                if (objRememberedValue29 == companion.getEmpty()) {
                    objRememberedValue29 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue29);
                }
                final MutableState mutableState117 = (MutableState) objRememberedValue29;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(751189649, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.d7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88(mutableState23, mutableState114, mutableState112, navHostController, snapshotStateList3, chatViewModel5, textFieldStateM2202rememberTextFieldStateLepunE, softwareKeyboardController, stateCollectAsStateWithLifecycle, context, managedActivityResultLauncherRememberLauncherForActivityResult6, mutableState21, mutableState111, mutableState2, mutableState20, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54);
                Function3 function4 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.e7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89(snapshotStateList3, chatViewModel5, stateCollectAsStateWithLifecycle, textFieldStateM2202rememberTextFieldStateLepunE, chatParams, m0Var, navHostController, mutableState2, mutableState21, snapshotStateList, mutableState18, mutableState19, lazyPagingItemsCollectAsLazyPagingItems5, softwareKeyboardController, context, focusRequester2, mutableState22, mutableState23, mutableState, mutableState117, stateCollectAsStateWithLifecycle9, state4, mutableState115, mutableState116, mutableIntState2, state3, mutableState3, mutableState110, managedActivityResultLauncherRememberLauncherForActivityResult4, mutableState20, managedActivityResultLauncherRememberLauncherForActivityResult5, mutableState113, lazyPagingItemsCollectAsLazyPagingItems6, lazyPagingItemsCollectAsLazyPagingItems7, lazyPagingItemsCollectAsLazyPagingItems8, stateCollectAsStateWithLifecycle7, mutableState112, stateCollectAsStateWithLifecycle6, mutableState111, stateCollectAsStateWithLifecycle8, mutableState114, chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                composerStartRestartGroup = composer3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda2, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-420149937, true, function4, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chatViewModel3 = chatViewModel5;
            }
            navHostController.navigateUp();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final ChatViewModel chatViewModel7 = chatViewModel4;
                final String str3 = str;
                function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.w6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$4(navHostController, str3, chatViewModel7, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            return;
        }
        composerStartRestartGroup.skipToGroupEnd();
        chatViewModel3 = chatViewModel2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.f7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatChannelScreenKt.ChatChannelScreen$lambda$90(navHostController, params, chatViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final void ChatChannelScreen$addAttachedFileToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, Uri uri) {
        Uri next;
        Iterator<Uri> it = snapshotStateList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kotlin.jvm.internal.y.d(next.getPath(), uri.getPath()));
        if (next == null) {
            snapshotStateList.add(uri);
        }
        ChatChannelScreen$lambda$38(mutableState, true);
    }

    private static final void ChatChannelScreen$addItemToSelected(MutableState<MessageWithPartnerWithReactions> mutableState, MutableState<MessageWithPartnerWithReactions> mutableState2, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        mutableState.setValue(null);
        mutableState2.setValue(null);
        snapshotStateList.add(messageWithPartnerWithReactions);
        ArrayList arrayList = new ArrayList(va.x.y(snapshotStateList, 10));
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMessage().getId());
        }
        chatViewModel.allMsgsAreMine(va.g0.o1(arrayList));
    }

    private static final void ChatChannelScreen$attachmentClicked(SoftwareKeyboardController softwareKeyboardController, Context context, final ChatViewModel chatViewModel, final NavHostController navHostController, final ChatParams chatParams, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, State<ChatScreenState> state, final MutableState<AttachmentPreviewState> mutableState2, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions messageWithPartnerWithReactions, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.g3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatChannelScreenKt.ChatChannelScreen$attachmentClicked$lambda$43(navHostController, (String) obj);
            }
        };
        ChatChannelScreenKt$ChatChannelScreen$attachmentClicked$2 chatChannelScreenKt$ChatChannelScreen$attachmentClicked$2 = new ChatChannelScreenKt$ChatChannelScreen$attachmentClicked$2(chatViewModel);
        ChatChannelScreenKt$ChatChannelScreen$attachmentClicked$3 chatChannelScreenKt$ChatChannelScreen$attachmentClicked$3 = new ChatChannelScreenKt$ChatChannelScreen$attachmentClicked$3(chatViewModel);
        ChatChannelScreenKt$ChatChannelScreen$attachmentClicked$4 chatChannelScreenKt$ChatChannelScreen$attachmentClicked$4 = new ChatChannelScreenKt$ChatChannelScreen$attachmentClicked$4(chatViewModel);
        Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.b4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatChannelScreenKt.ChatChannelScreen$attachmentClicked$lambda$44(chatViewModel, chatParams, (String) obj);
            }
        };
        Function1 function3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatChannelScreenKt.ChatChannelScreen$attachmentClicked$lambda$45(textFieldState, (String) obj);
            }
        };
        ChatChannelScreenKt$ChatChannelScreen$attachmentClicked$7 chatChannelScreenKt$ChatChannelScreen$attachmentClicked$7 = new ChatChannelScreenKt$ChatChannelScreen$attachmentClicked$7(mutableState);
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
        chatComplexFunctionalities.attachmentClicked(messageAction, i10, z10, messageWithPartnerWithReactions, context, gson, function1, chatChannelScreenKt$ChatChannelScreen$attachmentClicked$2, chatChannelScreenKt$ChatChannelScreen$attachmentClicked$3, chatChannelScreenKt$ChatChannelScreen$attachmentClicked$4, function2, function3, chatChannelScreenKt$ChatChannelScreen$attachmentClicked$7, chatScreenStateChatChannelScreen$lambda$6 != null ? chatScreenStateChatChannelScreen$lambda$6.isSecret() : false, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.x4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatChannelScreenKt.ChatChannelScreen$attachmentClicked$lambda$46(mutableState2, (AttachmentPreviewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$attachmentClicked$lambda$43(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$attachmentClicked$lambda$44(ChatViewModel chatViewModel, ChatParams chatParams, String msgContent) {
        kotlin.jvm.internal.y.i(msgContent, "msgContent");
        ChatViewModel.sendMessage$default(chatViewModel, msgContent, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$attachmentClicked$lambda$45(TextFieldState textFieldState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$attachmentClicked$lambda$46(MutableState mutableState, AttachmentPreviewState it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    private static final void ChatChannelScreen$clearAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        snapshotStateList.clear();
        ChatChannelScreen$lambda$38(mutableState, false);
        ChatChannelScreen$lambda$35(mutableState2, false);
    }

    private static final List<String> ChatChannelScreen$clearSelection(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        List<MessageWithPartnerWithReactions> list = snapshotStateList.toList();
        snapshotStateList.clear();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String publId = ((MessageWithPartnerWithReactions) it.next()).getMessage().getPublId();
            if (publId != null) {
                arrayList.add(publId);
            }
        }
        return arrayList;
    }

    private static final List<String> ChatChannelScreen$clearSelectionPublications(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        List<MessageWithPartnerWithReactions> list = snapshotStateList.toList();
        snapshotStateList.clear();
        ArrayList arrayList = new ArrayList(va.x.y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String publId = ((MessageWithPartnerWithReactions) it.next()).getMessage().getPublId();
            if (publId == null) {
                publId = "";
            }
            arrayList.add(publId);
        }
        return arrayList;
    }

    private static final void ChatChannelScreen$createAndSendDate(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState) {
        Message message;
        NavLinks navLinks = NavLinks.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        String strT = gson.t(new DateEditorParams(uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId()));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goDateEditor(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    private static final void ChatChannelScreen$handleAutoOpenMentionList(State<String> state, State<? extends List<MentionItemModel>> state2, MutableState<Boolean> mutableState) {
        String value = state.getValue();
        if (value == null || !le.a0.U(value, "@", false, 2, null) || ChatChannelScreen$lambda$82(state2).isEmpty()) {
            ChatChannelScreen$lambda$85(mutableState, false);
        } else {
            if (ChatChannelScreen$lambda$84(mutableState)) {
                return;
            }
            ChatChannelScreen$lambda$85(mutableState, true);
        }
    }

    private static final void ChatChannelScreen$handleClickOnMention(ChatViewModel chatViewModel, final MutableState<Boolean> mutableState, final NavHostController navHostController, MessageEntity messageEntity) {
        ChatChannelScreen$lambda$2(mutableState, true);
        if (messageEntity instanceof MentionName) {
            chatViewModel.goChatByMention((MentionName) messageEntity, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.u6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ChatChannelScreenKt.ChatChannelScreen$handleClickOnMention$lambda$86(navHostController, mutableState, (String) obj);
                }
            }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.v6
                @Override // lb.a
                public final Object invoke() {
                    return ChatChannelScreenKt.ChatChannelScreen$handleClickOnMention$lambda$87(mutableState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$handleClickOnMention$lambda$86(NavHostController navHostController, MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatChannelScreen$lambda$2(mutableState, false);
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$handleClickOnMention$lambda$87(MutableState mutableState) {
        ChatChannelScreen$lambda$2(mutableState, false);
        return ua.k0.f43947a;
    }

    private static final boolean ChatChannelScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final Function1 ChatChannelScreen$lambda$12(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final long ChatChannelScreen$lambda$14(State<Long> state) {
        return state.getValue().longValue();
    }

    private static final PermissionsRequesterState ChatChannelScreen$lambda$16(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    private static final void ChatChannelScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final PagerDialogData ChatChannelScreen$lambda$25(MutableState<PagerDialogData> mutableState) {
        return mutableState.getValue();
    }

    private static final AttachmentPreviewState ChatChannelScreen$lambda$31(MutableState<AttachmentPreviewState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ChatChannelScreen$lambda$34(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatChannelScreen$lambda$35(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatChannelScreen$lambda$37(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatChannelScreen$lambda$38(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$4(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        ChatChannelScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$42$0(Context context, MutableState mutableState, SnapshotStateList snapshotStateList, Uri uri) {
        if (uri != null) {
            ChatChannelScreen$lambda$38(mutableState, true);
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatChannelScreen$addAttachedFileToSend(snapshotStateList, mutableState, Uri.fromFile(new File(path)));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$47$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, Uri uri) {
        Message message;
        if (uri != null) {
            ContactUtil contactUtil = ContactUtil.INSTANCE;
            Uri uriNormalizeScheme = uri.normalizeScheme();
            kotlin.jvm.internal.y.h(uriNormalizeScheme, "normalizeScheme(...)");
            ContactContent contactContentLoadContact = contactUtil.loadContact(context, uriNormalizeScheme);
            if (contactContentLoadContact != null) {
                String uid = chatParams.getUid();
                MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
                chatViewModel.sendContact(uid, contactContentLoadContact, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
            }
        }
        return ua.k0.f43947a;
    }

    private static final boolean ChatChannelScreen$lambda$48(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatScreenState ChatChannelScreen$lambda$6(State<ChatScreenState> state) {
        return state.getValue();
    }

    private static final boolean ChatChannelScreen$lambda$63(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatChannelScreen$lambda$64(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatChannelScreen$lambda$66(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatChannelScreen$lambda$67(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatChannelScreen$lambda$69(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final FlowsState<Friend> ChatChannelScreen$lambda$7(State<FlowsState<Friend>> state) {
        return state.getValue();
    }

    private static final void ChatChannelScreen$lambda$70(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$71$0(ChatViewModel chatViewModel, Context context, State state, Uri uri) {
        if (uri != null) {
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
            kotlin.jvm.internal.y.f(chatScreenStateChatChannelScreen$lambda$6);
            chatViewModel.setChatBackground(path, chatScreenStateChatChannelScreen$lambda$6.getId());
        }
        return ua.k0.f43947a;
    }

    private static final String ChatChannelScreen$lambda$73(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatChannelScreen$lambda$75$0(State state) {
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
        if (!kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$6 != null ? chatScreenStateChatChannelScreen$lambda$6.getUnknownUserState() : null, "new")) {
            return false;
        }
        ChatScreenState chatScreenStateChatChannelScreen$lambda$7 = ChatChannelScreen$lambda$6(state);
        if (kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$7 != null ? chatScreenStateChatChannelScreen$lambda$7.getAffiliation() : null, "none")) {
            return false;
        }
        ChatScreenState chatScreenStateChatChannelScreen$lambda$8 = ChatChannelScreen$lambda$6(state);
        return !kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$8 != null ? chatScreenStateChatChannelScreen$lambda$8.getAffiliation() : null, UserRoomJoin.AFFILIATION_OWNER);
    }

    private static final boolean ChatChannelScreen$lambda$76(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean ChatChannelScreen$lambda$78(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatChannelScreen$lambda$79(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ChatChannelScreen$lambda$81$0(TextFieldState textFieldState) {
        return (String) va.g0.K0(le.d0.S0(textFieldState.getText().toString(), new String[]{" ", "\n"}, false, 0, 6, null));
    }

    private static final List<MentionItemModel> ChatChannelScreen$lambda$82(State<? extends List<MentionItemModel>> state) {
        return state.getValue();
    }

    private static final boolean ChatChannelScreen$lambda$84(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatChannelScreen$lambda$85(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$88(MutableState mutableState, final MutableState mutableState2, MutableState mutableState3, final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final TextFieldState textFieldState, final SoftwareKeyboardController softwareKeyboardController, final State state, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        boolean z10 = false;
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(751189649, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous> (ChatChannelScreen.kt:622)");
            }
            if (ChatChannelScreen$lambda$31(mutableState) == null && le.d0.q0(ChatChannelScreen$lambda$73(mutableState2)) && !ChatChannelScreen$lambda$66(mutableState3)) {
                z10 = true;
            }
            AttachContainerKt.AnimateContainer(null, z10, ComposableLambdaKt.rememberComposableLambda(1307841536, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.r5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0(navHostController, snapshotStateList, chatViewModel, textFieldState, softwareKeyboardController, state, context, managedActivityResultLauncher, mutableState4, mutableState5, mutableState6, mutableState2, mutableState7, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0195  */
    /* JADX WARN: Code duplicated, block: B:103:0x019b  */
    /* JADX WARN: Code duplicated, block: B:104:0x019e  */
    /* JADX WARN: Code duplicated, block: B:109:0x01af  */
    /* JADX WARN: Code duplicated, block: B:111:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:114:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:116:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:119:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:120:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:123:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:125:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:128:0x0206  */
    /* JADX WARN: Code duplicated, block: B:130:0x020c  */
    /* JADX WARN: Code duplicated, block: B:136:0x021d  */
    /* JADX WARN: Code duplicated, block: B:140:0x0224  */
    /* JADX WARN: Code duplicated, block: B:144:0x0230  */
    /* JADX WARN: Code duplicated, block: B:146:0x0236  */
    /* JADX WARN: Code duplicated, block: B:149:0x0251  */
    /* JADX WARN: Code duplicated, block: B:151:0x0257  */
    /* JADX WARN: Code duplicated, block: B:154:0x026d  */
    /* JADX WARN: Code duplicated, block: B:156:0x0273  */
    /* JADX WARN: Code duplicated, block: B:159:0x028c  */
    /* JADX WARN: Code duplicated, block: B:161:0x0292  */
    /* JADX WARN: Code duplicated, block: B:164:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:167:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:169:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:172:0x02db  */
    /* JADX WARN: Code duplicated, block: B:174:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:177:0x032b  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00db  */
    /* JADX WARN: Code duplicated, block: B:49:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:57:0x0104  */
    /* JADX WARN: Code duplicated, block: B:58:0x0109  */
    /* JADX WARN: Code duplicated, block: B:61:0x0111  */
    /* JADX WARN: Code duplicated, block: B:68:0x0127  */
    /* JADX WARN: Code duplicated, block: B:70:0x012b  */
    /* JADX WARN: Code duplicated, block: B:74:0x013a  */
    /* JADX WARN: Code duplicated, block: B:77:0x014e  */
    /* JADX WARN: Code duplicated, block: B:78:0x0153  */
    /* JADX WARN: Code duplicated, block: B:80:0x0156  */
    /* JADX WARN: Code duplicated, block: B:82:0x015c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0161  */
    /* JADX WARN: Code duplicated, block: B:86:0x0169  */
    /* JADX WARN: Code duplicated, block: B:88:0x016f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0174  */
    /* JADX WARN: Code duplicated, block: B:92:0x017c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0182  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$88$0(final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final TextFieldState textFieldState, final SoftwareKeyboardController softwareKeyboardController, final State state, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, Composer composer, int i10) throws SinglediException {
        ChatScreenState chatScreenState;
        boolean z10;
        boolean zChangedInstance;
        Object objRememberedValue;
        int i11;
        Object objRememberedValue2;
        Composer.Companion companion;
        lb.a aVar;
        lb.a aVar2;
        boolean z11;
        Object objRememberedValue3;
        lb.a aVar3;
        MessageWithPartnerWithReactions messageWithPartnerWithReactions;
        boolean zAvailable;
        lb.a aVar4;
        boolean z12;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        boolean zChangedInstance3;
        Object objRememberedValue5;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6;
        String affiliation;
        boolean z13;
        boolean z14;
        boolean zChanged;
        Object objRememberedValue6;
        boolean zChangedInstance4;
        Object objRememberedValue7;
        boolean zChangedInstance5;
        Object objRememberedValue8;
        boolean zChangedInstance6;
        Object objRememberedValue9;
        Object objRememberedValue10;
        boolean zChangedInstance7;
        Object objRememberedValue11;
        boolean zChangedInstance8;
        Object objRememberedValue12;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$7;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$8;
        boolean z15;
        List<String> rights;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$9;
        String affiliation2;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$10;
        String affiliation3;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$11;
        boolean z16;
        List<String> rights2;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$12;
        String affiliation4;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$13;
        String affiliation5;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$14;
        List<String> rights3;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$15;
        List<String> rights4;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1307841536, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous> (ChatChannelScreen.kt:625)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ChatScreenState chatScreenStateChatChannelScreen$lambda$16 = ChatChannelScreen$lambda$6(state);
            int size = snapshotStateList.toList().size();
            if (ChatChannelScreen$listIsEditableInChannel(snapshotStateList, state)) {
                chatScreenState = chatScreenStateChatChannelScreen$lambda$16;
            } else {
                chatScreenState = chatScreenStateChatChannelScreen$lambda$16;
                if (ChatComplexFunctionalities.INSTANCE.listIsEditable(snapshotStateList, chatViewModel.getOwner().getNameWithDomain())) {
                    ChatScreenState chatScreenStateChatChannelScreen$lambda$17 = ChatChannelScreen$lambda$6(state);
                    if (!kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$17 != null ? chatScreenStateChatChannelScreen$lambda$17.getAffiliation() : null, UserRoomJoin.AFFILIATION_OWNER)) {
                        ChatScreenState chatScreenStateChatChannelScreen$lambda$18 = ChatChannelScreen$lambda$6(state);
                        if (kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$18 != null ? chatScreenStateChatChannelScreen$lambda$18.getAffiliation() : null, "none") || (chatScreenStateChatChannelScreen$lambda$15 = ChatChannelScreen$lambda$6(state)) == null || (rights4 = chatScreenStateChatChannelScreen$lambda$15.getRights()) == null || !rights4.contains("pm")) {
                        }
                        zChangedInstance = composer.changedInstance(chatViewModel) | composer.changed(textFieldState);
                        objRememberedValue = composer.rememberedValue();
                        if (zChangedInstance) {
                            i11 = size;
                        } else {
                            i11 = size;
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            lb.a aVar5 = (lb.a) objRememberedValue;
                            objRememberedValue2 = composer.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue2);
                            }
                            aVar = (lb.a) objRememberedValue2;
                            if (ChatChannelScreen$listIsDeletableInChannel(snapshotStateList, state)) {
                                aVar2 = aVar;
                                z11 = true;
                            } else {
                                chatScreenStateChatChannelScreen$lambda$12 = ChatChannelScreen$lambda$6(state);
                                if (chatScreenStateChatChannelScreen$lambda$12 != null) {
                                    affiliation4 = chatScreenStateChatChannelScreen$lambda$12.getAffiliation();
                                } else {
                                    affiliation4 = null;
                                }
                                if (kotlin.jvm.internal.y.d(affiliation4, UserRoomJoin.AFFILIATION_OWNER)) {
                                    aVar2 = aVar;
                                } else {
                                    chatScreenStateChatChannelScreen$lambda$13 = ChatChannelScreen$lambda$6(state);
                                    if (chatScreenStateChatChannelScreen$lambda$13 != null) {
                                        affiliation5 = chatScreenStateChatChannelScreen$lambda$13.getAffiliation();
                                    } else {
                                        affiliation5 = null;
                                    }
                                    if (!kotlin.jvm.internal.y.d(affiliation5, "none") || (chatScreenStateChatChannelScreen$lambda$14 = ChatChannelScreen$lambda$6(state)) == null || (rights3 = chatScreenStateChatChannelScreen$lambda$14.getRights()) == null) {
                                        aVar2 = aVar;
                                    } else {
                                        aVar2 = aVar;
                                        if (rights3.contains("pm")) {
                                        }
                                    }
                                    z11 = false;
                                }
                                z11 = true;
                            }
                            objRememberedValue3 = composer.rememberedValue();
                            boolean z17 = z11;
                            if (objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$2$0(mutableState2);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue3);
                            }
                            aVar3 = (lb.a) objRememberedValue3;
                            messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
                            if (messageWithPartnerWithReactions != null) {
                                zAvailable = messageWithPartnerWithReactions.available();
                            } else {
                                zAvailable = false;
                            }
                            if (zAvailable) {
                                chatScreenStateChatChannelScreen$lambda$9 = ChatChannelScreen$lambda$6(state);
                                if (chatScreenStateChatChannelScreen$lambda$9 != null) {
                                    affiliation2 = chatScreenStateChatChannelScreen$lambda$9.getAffiliation();
                                } else {
                                    affiliation2 = null;
                                }
                                if (kotlin.jvm.internal.y.d(affiliation2, UserRoomJoin.AFFILIATION_OWNER)) {
                                    aVar4 = aVar3;
                                } else {
                                    chatScreenStateChatChannelScreen$lambda$10 = ChatChannelScreen$lambda$6(state);
                                    if (chatScreenStateChatChannelScreen$lambda$10 != null) {
                                        affiliation3 = chatScreenStateChatChannelScreen$lambda$10.getAffiliation();
                                    } else {
                                        affiliation3 = null;
                                    }
                                    if (kotlin.jvm.internal.y.d(affiliation3, "none")) {
                                        aVar4 = aVar3;
                                    } else {
                                        chatScreenStateChatChannelScreen$lambda$11 = ChatChannelScreen$lambda$6(state);
                                        if (chatScreenStateChatChannelScreen$lambda$11 != null || (rights2 = chatScreenStateChatChannelScreen$lambda$11.getRights()) == null) {
                                            aVar4 = aVar3;
                                        } else {
                                            aVar4 = aVar3;
                                            z16 = rights2.contains("pm");
                                            if (z16) {
                                            }
                                        }
                                        if (z16) {
                                        }
                                    }
                                    z12 = false;
                                }
                                z12 = true;
                            } else {
                                aVar4 = aVar3;
                                z12 = false;
                            }
                            zChangedInstance2 = composer.changedInstance(chatViewModel);
                            boolean z18 = z12;
                            objRememberedValue4 = composer.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue4);
                            }
                            lb.a aVar6 = (lb.a) objRememberedValue4;
                            zChangedInstance3 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                            objRememberedValue5 = composer.rememberedValue();
                            if (zChangedInstance3 || objRememberedValue5 == companion.getEmpty()) {
                                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue5);
                            }
                            lb.a aVar7 = (lb.a) objRememberedValue5;
                            chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
                            if (chatScreenStateChatChannelScreen$lambda$6 != null) {
                                affiliation = chatScreenStateChatChannelScreen$lambda$6.getAffiliation();
                            } else {
                                affiliation = null;
                            }
                            if (kotlin.jvm.internal.y.d(affiliation, UserRoomJoin.AFFILIATION_OWNER)) {
                                z13 = true;
                            } else {
                                chatScreenStateChatChannelScreen$lambda$7 = ChatChannelScreen$lambda$6(state);
                                if (!kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$7 != null ? chatScreenStateChatChannelScreen$lambda$7.getAffiliation() : null, "none")) {
                                    chatScreenStateChatChannelScreen$lambda$8 = ChatChannelScreen$lambda$6(state);
                                    if (chatScreenStateChatChannelScreen$lambda$8 != null || (rights = chatScreenStateChatChannelScreen$lambda$8.getRights()) == null) {
                                        z13 = true;
                                    } else {
                                        z13 = true;
                                        z15 = rights.contains("pm");
                                        if (z15) {
                                        }
                                        zChanged = composer.changed(softwareKeyboardController);
                                        objRememberedValue6 = composer.rememberedValue();
                                        if (zChanged || objRememberedValue6 == companion.getEmpty()) {
                                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                                @Override // lb.a
                                                public final Object invoke() {
                                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                                }
                                            };
                                            composer.updateRememberedValue(objRememberedValue6);
                                        }
                                        lb.a aVar8 = (lb.a) objRememberedValue6;
                                        zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                                        objRememberedValue7 = composer.rememberedValue();
                                        if (zChangedInstance4 || objRememberedValue7 == companion.getEmpty()) {
                                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                                @Override // lb.a
                                                public final Object invoke() {
                                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                                }
                                            };
                                            composer.updateRememberedValue(objRememberedValue7);
                                        }
                                        lb.a aVar9 = (lb.a) objRememberedValue7;
                                        zChangedInstance5 = composer.changedInstance(chatViewModel);
                                        objRememberedValue8 = composer.rememberedValue();
                                        if (zChangedInstance5 || objRememberedValue8 == companion.getEmpty()) {
                                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                                @Override // lb.a
                                                public final Object invoke() {
                                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                                }
                                            };
                                            composer.updateRememberedValue(objRememberedValue8);
                                        }
                                        lb.a aVar10 = (lb.a) objRememberedValue8;
                                        zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                                        objRememberedValue9 = composer.rememberedValue();
                                        if (zChangedInstance6 || objRememberedValue9 == companion.getEmpty()) {
                                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                                @Override // lb.a
                                                public final Object invoke() {
                                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                                }
                                            };
                                            composer.updateRememberedValue(objRememberedValue9);
                                        }
                                        lb.a aVar11 = (lb.a) objRememberedValue9;
                                        objRememberedValue10 = composer.rememberedValue();
                                        if (objRememberedValue10 == companion.getEmpty()) {
                                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                                @Override // lb.a
                                                public final Object invoke() {
                                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                                }
                                            };
                                            composer.updateRememberedValue(objRememberedValue10);
                                        }
                                        lb.a aVar12 = (lb.a) objRememberedValue10;
                                        zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                                        objRememberedValue11 = composer.rememberedValue();
                                        if (zChangedInstance7 || objRememberedValue11 == companion.getEmpty()) {
                                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                                @Override // lb.a
                                                public final Object invoke() {
                                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                                }
                                            };
                                            composer.updateRememberedValue(objRememberedValue11);
                                        }
                                        lb.a aVar13 = (lb.a) objRememberedValue11;
                                        zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                                        objRememberedValue12 = composer.rememberedValue();
                                        if (zChangedInstance8 || objRememberedValue12 == companion.getEmpty()) {
                                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                                @Override // lb.a
                                                public final Object invoke() {
                                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                                }
                                            };
                                            composer.updateRememberedValue(objRememberedValue12);
                                        }
                                        ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar5, false, aVar2, z17, aVar4, z18, aVar6, false, aVar7, z14, aVar8, true, aVar9, true, aVar10, aVar11, aVar12, aVar13, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    if (z15) {
                                    }
                                    zChanged = composer.changed(softwareKeyboardController);
                                    objRememberedValue6 = composer.rememberedValue();
                                    if (zChanged) {
                                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue6);
                                    } else {
                                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue6);
                                    }
                                    lb.a aVar14 = (lb.a) objRememberedValue6;
                                    zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                                    objRememberedValue7 = composer.rememberedValue();
                                    if (zChangedInstance4) {
                                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue7);
                                    } else {
                                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue7);
                                    }
                                    lb.a aVar15 = (lb.a) objRememberedValue7;
                                    zChangedInstance5 = composer.changedInstance(chatViewModel);
                                    objRememberedValue8 = composer.rememberedValue();
                                    if (zChangedInstance5) {
                                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue8);
                                    } else {
                                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue8);
                                    }
                                    lb.a aVar16 = (lb.a) objRememberedValue8;
                                    zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                                    objRememberedValue9 = composer.rememberedValue();
                                    if (zChangedInstance6) {
                                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue9);
                                    } else {
                                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue9);
                                    }
                                    lb.a aVar17 = (lb.a) objRememberedValue9;
                                    objRememberedValue10 = composer.rememberedValue();
                                    if (objRememberedValue10 == companion.getEmpty()) {
                                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue10);
                                    }
                                    lb.a aVar18 = (lb.a) objRememberedValue10;
                                    zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                                    objRememberedValue11 = composer.rememberedValue();
                                    if (zChangedInstance7) {
                                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue11);
                                    } else {
                                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue11);
                                    }
                                    lb.a aVar19 = (lb.a) objRememberedValue11;
                                    zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                                    objRememberedValue12 = composer.rememberedValue();
                                    if (zChangedInstance8) {
                                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue12);
                                    } else {
                                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                            }
                                        };
                                        composer.updateRememberedValue(objRememberedValue12);
                                    }
                                    ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar5, false, aVar2, z17, aVar4, z18, aVar6, false, aVar7, z14, aVar14, true, aVar15, true, aVar16, aVar17, aVar18, aVar19, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                z14 = false;
                                zChanged = composer.changed(softwareKeyboardController);
                                objRememberedValue6 = composer.rememberedValue();
                                if (zChanged) {
                                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue6);
                                } else {
                                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue6);
                                }
                                lb.a aVar110 = (lb.a) objRememberedValue6;
                                zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                                objRememberedValue7 = composer.rememberedValue();
                                if (zChangedInstance4) {
                                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue7);
                                } else {
                                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue7);
                                }
                                lb.a aVar111 = (lb.a) objRememberedValue7;
                                zChangedInstance5 = composer.changedInstance(chatViewModel);
                                objRememberedValue8 = composer.rememberedValue();
                                if (zChangedInstance5) {
                                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue8);
                                } else {
                                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue8);
                                }
                                lb.a aVar112 = (lb.a) objRememberedValue8;
                                zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                                objRememberedValue9 = composer.rememberedValue();
                                if (zChangedInstance6) {
                                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue9);
                                } else {
                                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue9);
                                }
                                lb.a aVar113 = (lb.a) objRememberedValue9;
                                objRememberedValue10 = composer.rememberedValue();
                                if (objRememberedValue10 == companion.getEmpty()) {
                                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue10);
                                }
                                lb.a aVar114 = (lb.a) objRememberedValue10;
                                zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                                objRememberedValue11 = composer.rememberedValue();
                                if (zChangedInstance7) {
                                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue11);
                                } else {
                                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue11);
                                }
                                lb.a aVar115 = (lb.a) objRememberedValue11;
                                zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                                objRememberedValue12 = composer.rememberedValue();
                                if (zChangedInstance8) {
                                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue12);
                                } else {
                                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue12);
                                }
                                ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar5, false, aVar2, z17, aVar4, z18, aVar6, false, aVar7, z14, aVar110, true, aVar111, true, aVar112, aVar113, aVar114, aVar115, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            z14 = z13;
                            zChanged = composer.changed(softwareKeyboardController);
                            objRememberedValue6 = composer.rememberedValue();
                            if (zChanged) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue6);
                            }
                            lb.a aVar116 = (lb.a) objRememberedValue6;
                            zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                            objRememberedValue7 = composer.rememberedValue();
                            if (zChangedInstance4) {
                                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue7);
                            } else {
                                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue7);
                            }
                            lb.a aVar117 = (lb.a) objRememberedValue7;
                            zChangedInstance5 = composer.changedInstance(chatViewModel);
                            objRememberedValue8 = composer.rememberedValue();
                            if (zChangedInstance5) {
                                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue8);
                            } else {
                                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue8);
                            }
                            lb.a aVar118 = (lb.a) objRememberedValue8;
                            zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                            objRememberedValue9 = composer.rememberedValue();
                            if (zChangedInstance6) {
                                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue9);
                            }
                            lb.a aVar119 = (lb.a) objRememberedValue9;
                            objRememberedValue10 = composer.rememberedValue();
                            if (objRememberedValue10 == companion.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue10);
                            }
                            lb.a aVar1110 = (lb.a) objRememberedValue10;
                            zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                            objRememberedValue11 = composer.rememberedValue();
                            if (zChangedInstance7) {
                                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue11);
                            } else {
                                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue11);
                            }
                            lb.a aVar1111 = (lb.a) objRememberedValue11;
                            zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                            objRememberedValue12 = composer.rememberedValue();
                            if (zChangedInstance8) {
                                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue12);
                            } else {
                                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue12);
                            }
                            ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar5, false, aVar2, z17, aVar4, z18, aVar6, false, aVar7, z14, aVar116, true, aVar117, true, aVar118, aVar119, aVar1110, aVar1111, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$0$0(mutableState, chatViewModel, snapshotStateList, textFieldState);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                        lb.a aVar20 = (lb.a) objRememberedValue;
                        objRememberedValue2 = composer.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue2);
                        }
                        aVar = (lb.a) objRememberedValue2;
                        if (ChatChannelScreen$listIsDeletableInChannel(snapshotStateList, state)) {
                            aVar2 = aVar;
                            z11 = true;
                        } else {
                            chatScreenStateChatChannelScreen$lambda$12 = ChatChannelScreen$lambda$6(state);
                            if (chatScreenStateChatChannelScreen$lambda$12 != null) {
                                affiliation4 = chatScreenStateChatChannelScreen$lambda$12.getAffiliation();
                            } else {
                                affiliation4 = null;
                            }
                            if (kotlin.jvm.internal.y.d(affiliation4, UserRoomJoin.AFFILIATION_OWNER)) {
                                chatScreenStateChatChannelScreen$lambda$13 = ChatChannelScreen$lambda$6(state);
                                if (chatScreenStateChatChannelScreen$lambda$13 != null) {
                                    affiliation5 = chatScreenStateChatChannelScreen$lambda$13.getAffiliation();
                                } else {
                                    affiliation5 = null;
                                }
                                if (kotlin.jvm.internal.y.d(affiliation5, "none")) {
                                    aVar2 = aVar;
                                } else {
                                    aVar2 = aVar;
                                }
                                z11 = false;
                            } else {
                                aVar2 = aVar;
                            }
                            z11 = true;
                        }
                        objRememberedValue3 = composer.rememberedValue();
                        boolean z19 = z11;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$2$0(mutableState2);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue3);
                        }
                        aVar3 = (lb.a) objRememberedValue3;
                        messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
                        if (messageWithPartnerWithReactions != null) {
                            zAvailable = messageWithPartnerWithReactions.available();
                        } else {
                            zAvailable = false;
                        }
                        if (zAvailable) {
                            aVar4 = aVar3;
                            z12 = false;
                        } else {
                            chatScreenStateChatChannelScreen$lambda$9 = ChatChannelScreen$lambda$6(state);
                            if (chatScreenStateChatChannelScreen$lambda$9 != null) {
                                affiliation2 = chatScreenStateChatChannelScreen$lambda$9.getAffiliation();
                            } else {
                                affiliation2 = null;
                            }
                            if (kotlin.jvm.internal.y.d(affiliation2, UserRoomJoin.AFFILIATION_OWNER)) {
                                chatScreenStateChatChannelScreen$lambda$10 = ChatChannelScreen$lambda$6(state);
                                if (chatScreenStateChatChannelScreen$lambda$10 != null) {
                                    affiliation3 = chatScreenStateChatChannelScreen$lambda$10.getAffiliation();
                                } else {
                                    affiliation3 = null;
                                }
                                if (kotlin.jvm.internal.y.d(affiliation3, "none")) {
                                    chatScreenStateChatChannelScreen$lambda$11 = ChatChannelScreen$lambda$6(state);
                                    if (chatScreenStateChatChannelScreen$lambda$11 != null) {
                                        aVar4 = aVar3;
                                    } else {
                                        aVar4 = aVar3;
                                    }
                                    if (z16) {
                                    }
                                } else {
                                    aVar4 = aVar3;
                                }
                                z12 = false;
                            } else {
                                aVar4 = aVar3;
                            }
                            z12 = true;
                        }
                        zChangedInstance2 = composer.changedInstance(chatViewModel);
                        boolean z110 = z12;
                        objRememberedValue4 = composer.rememberedValue();
                        if (zChangedInstance2) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue4);
                        }
                        lb.a aVar21 = (lb.a) objRememberedValue4;
                        zChangedInstance3 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                        objRememberedValue5 = composer.rememberedValue();
                        if (zChangedInstance3) {
                            objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue5);
                        }
                        lb.a aVar22 = (lb.a) objRememberedValue5;
                        chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$6 != null) {
                            affiliation = chatScreenStateChatChannelScreen$lambda$6.getAffiliation();
                        } else {
                            affiliation = null;
                        }
                        if (kotlin.jvm.internal.y.d(affiliation, UserRoomJoin.AFFILIATION_OWNER)) {
                            chatScreenStateChatChannelScreen$lambda$7 = ChatChannelScreen$lambda$6(state);
                            if (!kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$7 != null ? chatScreenStateChatChannelScreen$lambda$7.getAffiliation() : null, "none")) {
                                chatScreenStateChatChannelScreen$lambda$8 = ChatChannelScreen$lambda$6(state);
                                if (chatScreenStateChatChannelScreen$lambda$8 != null) {
                                    z13 = true;
                                } else {
                                    z13 = true;
                                }
                                if (z15) {
                                }
                                zChanged = composer.changed(softwareKeyboardController);
                                objRememberedValue6 = composer.rememberedValue();
                                if (zChanged) {
                                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue6);
                                } else {
                                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue6);
                                }
                                lb.a aVar1112 = (lb.a) objRememberedValue6;
                                zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                                objRememberedValue7 = composer.rememberedValue();
                                if (zChangedInstance4) {
                                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue7);
                                } else {
                                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue7);
                                }
                                lb.a aVar1113 = (lb.a) objRememberedValue7;
                                zChangedInstance5 = composer.changedInstance(chatViewModel);
                                objRememberedValue8 = composer.rememberedValue();
                                if (zChangedInstance5) {
                                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue8);
                                } else {
                                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue8);
                                }
                                lb.a aVar1114 = (lb.a) objRememberedValue8;
                                zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                                objRememberedValue9 = composer.rememberedValue();
                                if (zChangedInstance6) {
                                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue9);
                                } else {
                                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue9);
                                }
                                lb.a aVar1115 = (lb.a) objRememberedValue9;
                                objRememberedValue10 = composer.rememberedValue();
                                if (objRememberedValue10 == companion.getEmpty()) {
                                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue10);
                                }
                                lb.a aVar1116 = (lb.a) objRememberedValue10;
                                zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                                objRememberedValue11 = composer.rememberedValue();
                                if (zChangedInstance7) {
                                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue11);
                                } else {
                                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue11);
                                }
                                lb.a aVar1117 = (lb.a) objRememberedValue11;
                                zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                                objRememberedValue12 = composer.rememberedValue();
                                if (zChangedInstance8) {
                                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue12);
                                } else {
                                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue12);
                                }
                                ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar20, false, aVar2, z19, aVar4, z110, aVar21, false, aVar22, z14, aVar1112, true, aVar1113, true, aVar1114, aVar1115, aVar1116, aVar1117, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            z14 = false;
                            zChanged = composer.changed(softwareKeyboardController);
                            objRememberedValue6 = composer.rememberedValue();
                            if (zChanged) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue6);
                            }
                            lb.a aVar1118 = (lb.a) objRememberedValue6;
                            zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                            objRememberedValue7 = composer.rememberedValue();
                            if (zChangedInstance4) {
                                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue7);
                            } else {
                                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue7);
                            }
                            lb.a aVar1119 = (lb.a) objRememberedValue7;
                            zChangedInstance5 = composer.changedInstance(chatViewModel);
                            objRememberedValue8 = composer.rememberedValue();
                            if (zChangedInstance5) {
                                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue8);
                            } else {
                                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue8);
                            }
                            lb.a aVar11110 = (lb.a) objRememberedValue8;
                            zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                            objRememberedValue9 = composer.rememberedValue();
                            if (zChangedInstance6) {
                                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue9);
                            }
                            lb.a aVar11111 = (lb.a) objRememberedValue9;
                            objRememberedValue10 = composer.rememberedValue();
                            if (objRememberedValue10 == companion.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue10);
                            }
                            lb.a aVar11112 = (lb.a) objRememberedValue10;
                            zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                            objRememberedValue11 = composer.rememberedValue();
                            if (zChangedInstance7) {
                                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue11);
                            } else {
                                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue11);
                            }
                            lb.a aVar11113 = (lb.a) objRememberedValue11;
                            zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                            objRememberedValue12 = composer.rememberedValue();
                            if (zChangedInstance8) {
                                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue12);
                            } else {
                                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue12);
                            }
                            ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar20, false, aVar2, z19, aVar4, z110, aVar21, false, aVar22, z14, aVar1118, true, aVar1119, true, aVar11110, aVar11111, aVar11112, aVar11113, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            z13 = true;
                        }
                        z14 = z13;
                        zChanged = composer.changed(softwareKeyboardController);
                        objRememberedValue6 = composer.rememberedValue();
                        if (zChanged) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar11114 = (lb.a) objRememberedValue6;
                        zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                        objRememberedValue7 = composer.rememberedValue();
                        if (zChangedInstance4) {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        } else {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        }
                        lb.a aVar11115 = (lb.a) objRememberedValue7;
                        zChangedInstance5 = composer.changedInstance(chatViewModel);
                        objRememberedValue8 = composer.rememberedValue();
                        if (zChangedInstance5) {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        }
                        lb.a aVar11116 = (lb.a) objRememberedValue8;
                        zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                        objRememberedValue9 = composer.rememberedValue();
                        if (zChangedInstance6) {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        }
                        lb.a aVar11117 = (lb.a) objRememberedValue9;
                        objRememberedValue10 = composer.rememberedValue();
                        if (objRememberedValue10 == companion.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue10);
                        }
                        lb.a aVar11118 = (lb.a) objRememberedValue10;
                        zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                        objRememberedValue11 = composer.rememberedValue();
                        if (zChangedInstance7) {
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue11);
                        }
                        lb.a aVar11119 = (lb.a) objRememberedValue11;
                        zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                        objRememberedValue12 = composer.rememberedValue();
                        if (zChangedInstance8) {
                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue12);
                        } else {
                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue12);
                        }
                        ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar20, false, aVar2, z19, aVar4, z110, aVar21, false, aVar22, z14, aVar11114, true, aVar11115, true, aVar11116, aVar11117, aVar11118, aVar11119, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }
                z10 = false;
                zChangedInstance = composer.changedInstance(chatViewModel) | composer.changed(textFieldState);
                objRememberedValue = composer.rememberedValue();
                if (zChangedInstance) {
                    i11 = size;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    lb.a aVar23 = (lb.a) objRememberedValue;
                    objRememberedValue2 = composer.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h3
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    aVar = (lb.a) objRememberedValue2;
                    if (ChatChannelScreen$listIsDeletableInChannel(snapshotStateList, state)) {
                        aVar2 = aVar;
                        z11 = true;
                    } else {
                        chatScreenStateChatChannelScreen$lambda$12 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$12 != null) {
                            affiliation4 = chatScreenStateChatChannelScreen$lambda$12.getAffiliation();
                        } else {
                            affiliation4 = null;
                        }
                        if (kotlin.jvm.internal.y.d(affiliation4, UserRoomJoin.AFFILIATION_OWNER)) {
                            chatScreenStateChatChannelScreen$lambda$13 = ChatChannelScreen$lambda$6(state);
                            if (chatScreenStateChatChannelScreen$lambda$13 != null) {
                                affiliation5 = chatScreenStateChatChannelScreen$lambda$13.getAffiliation();
                            } else {
                                affiliation5 = null;
                            }
                            if (kotlin.jvm.internal.y.d(affiliation5, "none")) {
                                aVar2 = aVar;
                            } else {
                                aVar2 = aVar;
                            }
                            z11 = false;
                        } else {
                            aVar2 = aVar;
                        }
                        z11 = true;
                    }
                    objRememberedValue3 = composer.rememberedValue();
                    boolean z111 = z11;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$2$0(mutableState2);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    aVar3 = (lb.a) objRememberedValue3;
                    messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
                    if (messageWithPartnerWithReactions != null) {
                        zAvailable = messageWithPartnerWithReactions.available();
                    } else {
                        zAvailable = false;
                    }
                    if (zAvailable) {
                        aVar4 = aVar3;
                        z12 = false;
                    } else {
                        chatScreenStateChatChannelScreen$lambda$9 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$9 != null) {
                            affiliation2 = chatScreenStateChatChannelScreen$lambda$9.getAffiliation();
                        } else {
                            affiliation2 = null;
                        }
                        if (kotlin.jvm.internal.y.d(affiliation2, UserRoomJoin.AFFILIATION_OWNER)) {
                            chatScreenStateChatChannelScreen$lambda$10 = ChatChannelScreen$lambda$6(state);
                            if (chatScreenStateChatChannelScreen$lambda$10 != null) {
                                affiliation3 = chatScreenStateChatChannelScreen$lambda$10.getAffiliation();
                            } else {
                                affiliation3 = null;
                            }
                            if (kotlin.jvm.internal.y.d(affiliation3, "none")) {
                                chatScreenStateChatChannelScreen$lambda$11 = ChatChannelScreen$lambda$6(state);
                                if (chatScreenStateChatChannelScreen$lambda$11 != null) {
                                    aVar4 = aVar3;
                                } else {
                                    aVar4 = aVar3;
                                }
                                if (z16) {
                                }
                            } else {
                                aVar4 = aVar3;
                            }
                            z12 = false;
                        } else {
                            aVar4 = aVar3;
                        }
                        z12 = true;
                    }
                    zChangedInstance2 = composer.changedInstance(chatViewModel);
                    boolean z112 = z12;
                    objRememberedValue4 = composer.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar24 = (lb.a) objRememberedValue4;
                    zChangedInstance3 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                    objRememberedValue5 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue5);
                    }
                    lb.a aVar25 = (lb.a) objRememberedValue5;
                    chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
                    if (chatScreenStateChatChannelScreen$lambda$6 != null) {
                        affiliation = chatScreenStateChatChannelScreen$lambda$6.getAffiliation();
                    } else {
                        affiliation = null;
                    }
                    if (kotlin.jvm.internal.y.d(affiliation, UserRoomJoin.AFFILIATION_OWNER)) {
                        chatScreenStateChatChannelScreen$lambda$7 = ChatChannelScreen$lambda$6(state);
                        if (!kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$7 != null ? chatScreenStateChatChannelScreen$lambda$7.getAffiliation() : null, "none")) {
                            chatScreenStateChatChannelScreen$lambda$8 = ChatChannelScreen$lambda$6(state);
                            if (chatScreenStateChatChannelScreen$lambda$8 != null) {
                                z13 = true;
                            } else {
                                z13 = true;
                            }
                            if (z15) {
                            }
                            zChanged = composer.changed(softwareKeyboardController);
                            objRememberedValue6 = composer.rememberedValue();
                            if (zChanged) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue6);
                            }
                            lb.a aVar111110 = (lb.a) objRememberedValue6;
                            zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                            objRememberedValue7 = composer.rememberedValue();
                            if (zChangedInstance4) {
                                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue7);
                            } else {
                                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue7);
                            }
                            lb.a aVar111111 = (lb.a) objRememberedValue7;
                            zChangedInstance5 = composer.changedInstance(chatViewModel);
                            objRememberedValue8 = composer.rememberedValue();
                            if (zChangedInstance5) {
                                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue8);
                            } else {
                                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue8);
                            }
                            lb.a aVar111112 = (lb.a) objRememberedValue8;
                            zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                            objRememberedValue9 = composer.rememberedValue();
                            if (zChangedInstance6) {
                                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue9);
                            }
                            lb.a aVar111113 = (lb.a) objRememberedValue9;
                            objRememberedValue10 = composer.rememberedValue();
                            if (objRememberedValue10 == companion.getEmpty()) {
                                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue10);
                            }
                            lb.a aVar111114 = (lb.a) objRememberedValue10;
                            zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                            objRememberedValue11 = composer.rememberedValue();
                            if (zChangedInstance7) {
                                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue11);
                            } else {
                                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue11);
                            }
                            lb.a aVar111115 = (lb.a) objRememberedValue11;
                            zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                            objRememberedValue12 = composer.rememberedValue();
                            if (zChangedInstance8) {
                                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue12);
                            } else {
                                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue12);
                            }
                            ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar23, false, aVar2, z111, aVar4, z112, aVar24, false, aVar25, z14, aVar111110, true, aVar111111, true, aVar111112, aVar111113, aVar111114, aVar111115, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        z14 = false;
                        zChanged = composer.changed(softwareKeyboardController);
                        objRememberedValue6 = composer.rememberedValue();
                        if (zChanged) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar111116 = (lb.a) objRememberedValue6;
                        zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                        objRememberedValue7 = composer.rememberedValue();
                        if (zChangedInstance4) {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        } else {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        }
                        lb.a aVar111117 = (lb.a) objRememberedValue7;
                        zChangedInstance5 = composer.changedInstance(chatViewModel);
                        objRememberedValue8 = composer.rememberedValue();
                        if (zChangedInstance5) {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        }
                        lb.a aVar111118 = (lb.a) objRememberedValue8;
                        zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                        objRememberedValue9 = composer.rememberedValue();
                        if (zChangedInstance6) {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        }
                        lb.a aVar111119 = (lb.a) objRememberedValue9;
                        objRememberedValue10 = composer.rememberedValue();
                        if (objRememberedValue10 == companion.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue10);
                        }
                        lb.a aVar1111110 = (lb.a) objRememberedValue10;
                        zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                        objRememberedValue11 = composer.rememberedValue();
                        if (zChangedInstance7) {
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue11);
                        }
                        lb.a aVar1111111 = (lb.a) objRememberedValue11;
                        zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                        objRememberedValue12 = composer.rememberedValue();
                        if (zChangedInstance8) {
                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue12);
                        } else {
                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue12);
                        }
                        ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar23, false, aVar2, z111, aVar4, z112, aVar24, false, aVar25, z14, aVar111116, true, aVar111117, true, aVar111118, aVar111119, aVar1111110, aVar1111111, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        z13 = true;
                    }
                    z14 = z13;
                    zChanged = composer.changed(softwareKeyboardController);
                    objRememberedValue6 = composer.rememberedValue();
                    if (zChanged) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar1111112 = (lb.a) objRememberedValue6;
                    zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                    objRememberedValue7 = composer.rememberedValue();
                    if (zChangedInstance4) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    }
                    lb.a aVar1111113 = (lb.a) objRememberedValue7;
                    zChangedInstance5 = composer.changedInstance(chatViewModel);
                    objRememberedValue8 = composer.rememberedValue();
                    if (zChangedInstance5) {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    }
                    lb.a aVar1111114 = (lb.a) objRememberedValue8;
                    zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                    objRememberedValue9 = composer.rememberedValue();
                    if (zChangedInstance6) {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    }
                    lb.a aVar1111115 = (lb.a) objRememberedValue9;
                    objRememberedValue10 = composer.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue10);
                    }
                    lb.a aVar1111116 = (lb.a) objRememberedValue10;
                    zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                    objRememberedValue11 = composer.rememberedValue();
                    if (zChangedInstance7) {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    }
                    lb.a aVar1111117 = (lb.a) objRememberedValue11;
                    zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                    objRememberedValue12 = composer.rememberedValue();
                    if (zChangedInstance8) {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue12);
                    }
                    ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar23, false, aVar2, z111, aVar4, z112, aVar24, false, aVar25, z14, aVar1111112, true, aVar1111113, true, aVar1111114, aVar1111115, aVar1111116, aVar1111117, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    i11 = size;
                }
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$0$0(mutableState, chatViewModel, snapshotStateList, textFieldState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
                lb.a aVar26 = (lb.a) objRememberedValue;
                objRememberedValue2 = composer.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h3
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                aVar = (lb.a) objRememberedValue2;
                if (ChatChannelScreen$listIsDeletableInChannel(snapshotStateList, state)) {
                    aVar2 = aVar;
                    z11 = true;
                } else {
                    chatScreenStateChatChannelScreen$lambda$12 = ChatChannelScreen$lambda$6(state);
                    if (chatScreenStateChatChannelScreen$lambda$12 != null) {
                        affiliation4 = chatScreenStateChatChannelScreen$lambda$12.getAffiliation();
                    } else {
                        affiliation4 = null;
                    }
                    if (kotlin.jvm.internal.y.d(affiliation4, UserRoomJoin.AFFILIATION_OWNER)) {
                        chatScreenStateChatChannelScreen$lambda$13 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$13 != null) {
                            affiliation5 = chatScreenStateChatChannelScreen$lambda$13.getAffiliation();
                        } else {
                            affiliation5 = null;
                        }
                        if (kotlin.jvm.internal.y.d(affiliation5, "none")) {
                            aVar2 = aVar;
                        } else {
                            aVar2 = aVar;
                        }
                        z11 = false;
                    } else {
                        aVar2 = aVar;
                    }
                    z11 = true;
                }
                objRememberedValue3 = composer.rememberedValue();
                boolean z113 = z11;
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$2$0(mutableState2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                aVar3 = (lb.a) objRememberedValue3;
                messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
                if (messageWithPartnerWithReactions != null) {
                    zAvailable = messageWithPartnerWithReactions.available();
                } else {
                    zAvailable = false;
                }
                if (zAvailable) {
                    aVar4 = aVar3;
                    z12 = false;
                } else {
                    chatScreenStateChatChannelScreen$lambda$9 = ChatChannelScreen$lambda$6(state);
                    if (chatScreenStateChatChannelScreen$lambda$9 != null) {
                        affiliation2 = chatScreenStateChatChannelScreen$lambda$9.getAffiliation();
                    } else {
                        affiliation2 = null;
                    }
                    if (kotlin.jvm.internal.y.d(affiliation2, UserRoomJoin.AFFILIATION_OWNER)) {
                        chatScreenStateChatChannelScreen$lambda$10 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$10 != null) {
                            affiliation3 = chatScreenStateChatChannelScreen$lambda$10.getAffiliation();
                        } else {
                            affiliation3 = null;
                        }
                        if (kotlin.jvm.internal.y.d(affiliation3, "none")) {
                            chatScreenStateChatChannelScreen$lambda$11 = ChatChannelScreen$lambda$6(state);
                            if (chatScreenStateChatChannelScreen$lambda$11 != null) {
                                aVar4 = aVar3;
                            } else {
                                aVar4 = aVar3;
                            }
                            if (z16) {
                            }
                        } else {
                            aVar4 = aVar3;
                        }
                        z12 = false;
                    } else {
                        aVar4 = aVar3;
                    }
                    z12 = true;
                }
                zChangedInstance2 = composer.changedInstance(chatViewModel);
                boolean z114 = z12;
                objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar27 = (lb.a) objRememberedValue4;
                zChangedInstance3 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                objRememberedValue5 = composer.rememberedValue();
                if (zChangedInstance3) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                lb.a aVar28 = (lb.a) objRememberedValue5;
                chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
                if (chatScreenStateChatChannelScreen$lambda$6 != null) {
                    affiliation = chatScreenStateChatChannelScreen$lambda$6.getAffiliation();
                } else {
                    affiliation = null;
                }
                if (kotlin.jvm.internal.y.d(affiliation, UserRoomJoin.AFFILIATION_OWNER)) {
                    chatScreenStateChatChannelScreen$lambda$7 = ChatChannelScreen$lambda$6(state);
                    if (!kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$7 != null ? chatScreenStateChatChannelScreen$lambda$7.getAffiliation() : null, "none")) {
                        chatScreenStateChatChannelScreen$lambda$8 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$8 != null) {
                            z13 = true;
                        } else {
                            z13 = true;
                        }
                        if (z15) {
                        }
                        zChanged = composer.changed(softwareKeyboardController);
                        objRememberedValue6 = composer.rememberedValue();
                        if (zChanged) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar1111118 = (lb.a) objRememberedValue6;
                        zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                        objRememberedValue7 = composer.rememberedValue();
                        if (zChangedInstance4) {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        } else {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        }
                        lb.a aVar1111119 = (lb.a) objRememberedValue7;
                        zChangedInstance5 = composer.changedInstance(chatViewModel);
                        objRememberedValue8 = composer.rememberedValue();
                        if (zChangedInstance5) {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        }
                        lb.a aVar11111110 = (lb.a) objRememberedValue8;
                        zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                        objRememberedValue9 = composer.rememberedValue();
                        if (zChangedInstance6) {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        }
                        lb.a aVar11111111 = (lb.a) objRememberedValue9;
                        objRememberedValue10 = composer.rememberedValue();
                        if (objRememberedValue10 == companion.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue10);
                        }
                        lb.a aVar11111112 = (lb.a) objRememberedValue10;
                        zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                        objRememberedValue11 = composer.rememberedValue();
                        if (zChangedInstance7) {
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue11);
                        }
                        lb.a aVar11111113 = (lb.a) objRememberedValue11;
                        zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                        objRememberedValue12 = composer.rememberedValue();
                        if (zChangedInstance8) {
                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue12);
                        } else {
                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue12);
                        }
                        ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar26, false, aVar2, z113, aVar4, z114, aVar27, false, aVar28, z14, aVar1111118, true, aVar1111119, true, aVar11111110, aVar11111111, aVar11111112, aVar11111113, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    z14 = false;
                    zChanged = composer.changed(softwareKeyboardController);
                    objRememberedValue6 = composer.rememberedValue();
                    if (zChanged) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar11111114 = (lb.a) objRememberedValue6;
                    zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                    objRememberedValue7 = composer.rememberedValue();
                    if (zChangedInstance4) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    }
                    lb.a aVar11111115 = (lb.a) objRememberedValue7;
                    zChangedInstance5 = composer.changedInstance(chatViewModel);
                    objRememberedValue8 = composer.rememberedValue();
                    if (zChangedInstance5) {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    }
                    lb.a aVar11111116 = (lb.a) objRememberedValue8;
                    zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                    objRememberedValue9 = composer.rememberedValue();
                    if (zChangedInstance6) {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    }
                    lb.a aVar11111117 = (lb.a) objRememberedValue9;
                    objRememberedValue10 = composer.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue10);
                    }
                    lb.a aVar11111118 = (lb.a) objRememberedValue10;
                    zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                    objRememberedValue11 = composer.rememberedValue();
                    if (zChangedInstance7) {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    }
                    lb.a aVar11111119 = (lb.a) objRememberedValue11;
                    zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                    objRememberedValue12 = composer.rememberedValue();
                    if (zChangedInstance8) {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue12);
                    }
                    ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar26, false, aVar2, z113, aVar4, z114, aVar27, false, aVar28, z14, aVar11111114, true, aVar11111115, true, aVar11111116, aVar11111117, aVar11111118, aVar11111119, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    z13 = true;
                }
                z14 = z13;
                zChanged = composer.changed(softwareKeyboardController);
                objRememberedValue6 = composer.rememberedValue();
                if (zChanged) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar111111110 = (lb.a) objRememberedValue6;
                zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance4) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar111111111 = (lb.a) objRememberedValue7;
                zChangedInstance5 = composer.changedInstance(chatViewModel);
                objRememberedValue8 = composer.rememberedValue();
                if (zChangedInstance5) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                lb.a aVar111111112 = (lb.a) objRememberedValue8;
                zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue9 = composer.rememberedValue();
                if (zChangedInstance6) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                lb.a aVar111111113 = (lb.a) objRememberedValue9;
                objRememberedValue10 = composer.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue10);
                }
                lb.a aVar111111114 = (lb.a) objRememberedValue10;
                zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                objRememberedValue11 = composer.rememberedValue();
                if (zChangedInstance7) {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                lb.a aVar111111115 = (lb.a) objRememberedValue11;
                zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue12 = composer.rememberedValue();
                if (zChangedInstance8) {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue12);
                }
                ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar26, false, aVar2, z113, aVar4, z114, aVar27, false, aVar28, z14, aVar111111110, true, aVar111111111, true, aVar111111112, aVar111111113, aVar111111114, aVar111111115, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            z10 = true;
            zChangedInstance = composer.changedInstance(chatViewModel) | composer.changed(textFieldState);
            objRememberedValue = composer.rememberedValue();
            if (zChangedInstance) {
                i11 = size;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                lb.a aVar29 = (lb.a) objRememberedValue;
                objRememberedValue2 = composer.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h3
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                aVar = (lb.a) objRememberedValue2;
                if (ChatChannelScreen$listIsDeletableInChannel(snapshotStateList, state)) {
                    aVar2 = aVar;
                    z11 = true;
                } else {
                    chatScreenStateChatChannelScreen$lambda$12 = ChatChannelScreen$lambda$6(state);
                    if (chatScreenStateChatChannelScreen$lambda$12 != null) {
                        affiliation4 = chatScreenStateChatChannelScreen$lambda$12.getAffiliation();
                    } else {
                        affiliation4 = null;
                    }
                    if (kotlin.jvm.internal.y.d(affiliation4, UserRoomJoin.AFFILIATION_OWNER)) {
                        chatScreenStateChatChannelScreen$lambda$13 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$13 != null) {
                            affiliation5 = chatScreenStateChatChannelScreen$lambda$13.getAffiliation();
                        } else {
                            affiliation5 = null;
                        }
                        if (kotlin.jvm.internal.y.d(affiliation5, "none")) {
                            aVar2 = aVar;
                        } else {
                            aVar2 = aVar;
                        }
                        z11 = false;
                    } else {
                        aVar2 = aVar;
                    }
                    z11 = true;
                }
                objRememberedValue3 = composer.rememberedValue();
                boolean z115 = z11;
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$2$0(mutableState2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                aVar3 = (lb.a) objRememberedValue3;
                messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
                if (messageWithPartnerWithReactions != null) {
                    zAvailable = messageWithPartnerWithReactions.available();
                } else {
                    zAvailable = false;
                }
                if (zAvailable) {
                    aVar4 = aVar3;
                    z12 = false;
                } else {
                    chatScreenStateChatChannelScreen$lambda$9 = ChatChannelScreen$lambda$6(state);
                    if (chatScreenStateChatChannelScreen$lambda$9 != null) {
                        affiliation2 = chatScreenStateChatChannelScreen$lambda$9.getAffiliation();
                    } else {
                        affiliation2 = null;
                    }
                    if (kotlin.jvm.internal.y.d(affiliation2, UserRoomJoin.AFFILIATION_OWNER)) {
                        chatScreenStateChatChannelScreen$lambda$10 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$10 != null) {
                            affiliation3 = chatScreenStateChatChannelScreen$lambda$10.getAffiliation();
                        } else {
                            affiliation3 = null;
                        }
                        if (kotlin.jvm.internal.y.d(affiliation3, "none")) {
                            chatScreenStateChatChannelScreen$lambda$11 = ChatChannelScreen$lambda$6(state);
                            if (chatScreenStateChatChannelScreen$lambda$11 != null) {
                                aVar4 = aVar3;
                            } else {
                                aVar4 = aVar3;
                            }
                            if (z16) {
                            }
                        } else {
                            aVar4 = aVar3;
                        }
                        z12 = false;
                    } else {
                        aVar4 = aVar3;
                    }
                    z12 = true;
                }
                zChangedInstance2 = composer.changedInstance(chatViewModel);
                boolean z116 = z12;
                objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar210 = (lb.a) objRememberedValue4;
                zChangedInstance3 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                objRememberedValue5 = composer.rememberedValue();
                if (zChangedInstance3) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                lb.a aVar211 = (lb.a) objRememberedValue5;
                chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
                if (chatScreenStateChatChannelScreen$lambda$6 != null) {
                    affiliation = chatScreenStateChatChannelScreen$lambda$6.getAffiliation();
                } else {
                    affiliation = null;
                }
                if (kotlin.jvm.internal.y.d(affiliation, UserRoomJoin.AFFILIATION_OWNER)) {
                    chatScreenStateChatChannelScreen$lambda$7 = ChatChannelScreen$lambda$6(state);
                    if (!kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$7 != null ? chatScreenStateChatChannelScreen$lambda$7.getAffiliation() : null, "none")) {
                        chatScreenStateChatChannelScreen$lambda$8 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$8 != null) {
                            z13 = true;
                        } else {
                            z13 = true;
                        }
                        if (z15) {
                        }
                        zChanged = composer.changed(softwareKeyboardController);
                        objRememberedValue6 = composer.rememberedValue();
                        if (zChanged) {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue6);
                        }
                        lb.a aVar111111116 = (lb.a) objRememberedValue6;
                        zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                        objRememberedValue7 = composer.rememberedValue();
                        if (zChangedInstance4) {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        } else {
                            objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue7);
                        }
                        lb.a aVar111111117 = (lb.a) objRememberedValue7;
                        zChangedInstance5 = composer.changedInstance(chatViewModel);
                        objRememberedValue8 = composer.rememberedValue();
                        if (zChangedInstance5) {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue8);
                        }
                        lb.a aVar111111118 = (lb.a) objRememberedValue8;
                        zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                        objRememberedValue9 = composer.rememberedValue();
                        if (zChangedInstance6) {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue9);
                        }
                        lb.a aVar111111119 = (lb.a) objRememberedValue9;
                        objRememberedValue10 = composer.rememberedValue();
                        if (objRememberedValue10 == companion.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue10);
                        }
                        lb.a aVar1111111110 = (lb.a) objRememberedValue10;
                        zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                        objRememberedValue11 = composer.rememberedValue();
                        if (zChangedInstance7) {
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue11);
                        }
                        lb.a aVar1111111111 = (lb.a) objRememberedValue11;
                        zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                        objRememberedValue12 = composer.rememberedValue();
                        if (zChangedInstance8) {
                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue12);
                        } else {
                            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue12);
                        }
                        ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar29, false, aVar2, z115, aVar4, z116, aVar210, false, aVar211, z14, aVar111111116, true, aVar111111117, true, aVar111111118, aVar111111119, aVar1111111110, aVar1111111111, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    z14 = false;
                    zChanged = composer.changed(softwareKeyboardController);
                    objRememberedValue6 = composer.rememberedValue();
                    if (zChanged) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar1111111112 = (lb.a) objRememberedValue6;
                    zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                    objRememberedValue7 = composer.rememberedValue();
                    if (zChangedInstance4) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    }
                    lb.a aVar1111111113 = (lb.a) objRememberedValue7;
                    zChangedInstance5 = composer.changedInstance(chatViewModel);
                    objRememberedValue8 = composer.rememberedValue();
                    if (zChangedInstance5) {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    }
                    lb.a aVar1111111114 = (lb.a) objRememberedValue8;
                    zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                    objRememberedValue9 = composer.rememberedValue();
                    if (zChangedInstance6) {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    }
                    lb.a aVar1111111115 = (lb.a) objRememberedValue9;
                    objRememberedValue10 = composer.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue10);
                    }
                    lb.a aVar1111111116 = (lb.a) objRememberedValue10;
                    zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                    objRememberedValue11 = composer.rememberedValue();
                    if (zChangedInstance7) {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    }
                    lb.a aVar1111111117 = (lb.a) objRememberedValue11;
                    zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                    objRememberedValue12 = composer.rememberedValue();
                    if (zChangedInstance8) {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue12);
                    }
                    ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar29, false, aVar2, z115, aVar4, z116, aVar210, false, aVar211, z14, aVar1111111112, true, aVar1111111113, true, aVar1111111114, aVar1111111115, aVar1111111116, aVar1111111117, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    z13 = true;
                }
                z14 = z13;
                zChanged = composer.changed(softwareKeyboardController);
                objRememberedValue6 = composer.rememberedValue();
                if (zChanged) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar1111111118 = (lb.a) objRememberedValue6;
                zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance4) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar1111111119 = (lb.a) objRememberedValue7;
                zChangedInstance5 = composer.changedInstance(chatViewModel);
                objRememberedValue8 = composer.rememberedValue();
                if (zChangedInstance5) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                lb.a aVar11111111110 = (lb.a) objRememberedValue8;
                zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue9 = composer.rememberedValue();
                if (zChangedInstance6) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                lb.a aVar11111111111 = (lb.a) objRememberedValue9;
                objRememberedValue10 = composer.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue10);
                }
                lb.a aVar11111111112 = (lb.a) objRememberedValue10;
                zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                objRememberedValue11 = composer.rememberedValue();
                if (zChangedInstance7) {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                lb.a aVar11111111113 = (lb.a) objRememberedValue11;
                zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue12 = composer.rememberedValue();
                if (zChangedInstance8) {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue12);
                }
                ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar29, false, aVar2, z115, aVar4, z116, aVar210, false, aVar211, z14, aVar1111111118, true, aVar1111111119, true, aVar11111111110, aVar11111111111, aVar11111111112, aVar11111111113, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                i11 = size;
            }
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i7
                @Override // lb.a
                public final Object invoke() {
                    return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$0$0(mutableState, chatViewModel, snapshotStateList, textFieldState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
            lb.a aVar212 = (lb.a) objRememberedValue;
            objRememberedValue2 = composer.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h3
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            aVar = (lb.a) objRememberedValue2;
            if (ChatChannelScreen$listIsDeletableInChannel(snapshotStateList, state)) {
                aVar2 = aVar;
                z11 = true;
            } else {
                chatScreenStateChatChannelScreen$lambda$12 = ChatChannelScreen$lambda$6(state);
                if (chatScreenStateChatChannelScreen$lambda$12 != null) {
                    affiliation4 = chatScreenStateChatChannelScreen$lambda$12.getAffiliation();
                } else {
                    affiliation4 = null;
                }
                if (kotlin.jvm.internal.y.d(affiliation4, UserRoomJoin.AFFILIATION_OWNER)) {
                    chatScreenStateChatChannelScreen$lambda$13 = ChatChannelScreen$lambda$6(state);
                    if (chatScreenStateChatChannelScreen$lambda$13 != null) {
                        affiliation5 = chatScreenStateChatChannelScreen$lambda$13.getAffiliation();
                    } else {
                        affiliation5 = null;
                    }
                    if (kotlin.jvm.internal.y.d(affiliation5, "none")) {
                        aVar2 = aVar;
                    } else {
                        aVar2 = aVar;
                    }
                    z11 = false;
                } else {
                    aVar2 = aVar;
                }
                z11 = true;
            }
            objRememberedValue3 = composer.rememberedValue();
            boolean z117 = z11;
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$2$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            aVar3 = (lb.a) objRememberedValue3;
            messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
            if (messageWithPartnerWithReactions != null) {
                zAvailable = messageWithPartnerWithReactions.available();
            } else {
                zAvailable = false;
            }
            if (zAvailable) {
                aVar4 = aVar3;
                z12 = false;
            } else {
                chatScreenStateChatChannelScreen$lambda$9 = ChatChannelScreen$lambda$6(state);
                if (chatScreenStateChatChannelScreen$lambda$9 != null) {
                    affiliation2 = chatScreenStateChatChannelScreen$lambda$9.getAffiliation();
                } else {
                    affiliation2 = null;
                }
                if (kotlin.jvm.internal.y.d(affiliation2, UserRoomJoin.AFFILIATION_OWNER)) {
                    chatScreenStateChatChannelScreen$lambda$10 = ChatChannelScreen$lambda$6(state);
                    if (chatScreenStateChatChannelScreen$lambda$10 != null) {
                        affiliation3 = chatScreenStateChatChannelScreen$lambda$10.getAffiliation();
                    } else {
                        affiliation3 = null;
                    }
                    if (kotlin.jvm.internal.y.d(affiliation3, "none")) {
                        chatScreenStateChatChannelScreen$lambda$11 = ChatChannelScreen$lambda$6(state);
                        if (chatScreenStateChatChannelScreen$lambda$11 != null) {
                            aVar4 = aVar3;
                        } else {
                            aVar4 = aVar3;
                        }
                        if (z16) {
                        }
                    } else {
                        aVar4 = aVar3;
                    }
                    z12 = false;
                } else {
                    aVar4 = aVar3;
                }
                z12 = true;
            }
            zChangedInstance2 = composer.changedInstance(chatViewModel);
            boolean z118 = z12;
            objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar213 = (lb.a) objRememberedValue4;
            zChangedInstance3 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance3) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$4$0(navHostController, chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar214 = (lb.a) objRememberedValue5;
            chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
            if (chatScreenStateChatChannelScreen$lambda$6 != null) {
                affiliation = chatScreenStateChatChannelScreen$lambda$6.getAffiliation();
            } else {
                affiliation = null;
            }
            if (kotlin.jvm.internal.y.d(affiliation, UserRoomJoin.AFFILIATION_OWNER)) {
                chatScreenStateChatChannelScreen$lambda$7 = ChatChannelScreen$lambda$6(state);
                if (!kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$7 != null ? chatScreenStateChatChannelScreen$lambda$7.getAffiliation() : null, "none")) {
                    chatScreenStateChatChannelScreen$lambda$8 = ChatChannelScreen$lambda$6(state);
                    if (chatScreenStateChatChannelScreen$lambda$8 != null) {
                        z13 = true;
                    } else {
                        z13 = true;
                    }
                    if (z15) {
                    }
                    zChanged = composer.changed(softwareKeyboardController);
                    objRememberedValue6 = composer.rememberedValue();
                    if (zChanged) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar11111111114 = (lb.a) objRememberedValue6;
                    zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                    objRememberedValue7 = composer.rememberedValue();
                    if (zChangedInstance4) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    }
                    lb.a aVar11111111115 = (lb.a) objRememberedValue7;
                    zChangedInstance5 = composer.changedInstance(chatViewModel);
                    objRememberedValue8 = composer.rememberedValue();
                    if (zChangedInstance5) {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue8);
                    }
                    lb.a aVar11111111116 = (lb.a) objRememberedValue8;
                    zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                    objRememberedValue9 = composer.rememberedValue();
                    if (zChangedInstance6) {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue9);
                    }
                    lb.a aVar11111111117 = (lb.a) objRememberedValue9;
                    objRememberedValue10 = composer.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue10);
                    }
                    lb.a aVar11111111118 = (lb.a) objRememberedValue10;
                    zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                    objRememberedValue11 = composer.rememberedValue();
                    if (zChangedInstance7) {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    }
                    lb.a aVar11111111119 = (lb.a) objRememberedValue11;
                    zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                    objRememberedValue12 = composer.rememberedValue();
                    if (zChangedInstance8) {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue12);
                    }
                    ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar212, false, aVar2, z117, aVar4, z118, aVar213, false, aVar214, z14, aVar11111111114, true, aVar11111111115, true, aVar11111111116, aVar11111111117, aVar11111111118, aVar11111111119, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                z14 = false;
                zChanged = composer.changed(softwareKeyboardController);
                objRememberedValue6 = composer.rememberedValue();
                if (zChanged) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar111111111110 = (lb.a) objRememberedValue6;
                zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance4) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar111111111111 = (lb.a) objRememberedValue7;
                zChangedInstance5 = composer.changedInstance(chatViewModel);
                objRememberedValue8 = composer.rememberedValue();
                if (zChangedInstance5) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                lb.a aVar111111111112 = (lb.a) objRememberedValue8;
                zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue9 = composer.rememberedValue();
                if (zChangedInstance6) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                lb.a aVar111111111113 = (lb.a) objRememberedValue9;
                objRememberedValue10 = composer.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue10);
                }
                lb.a aVar111111111114 = (lb.a) objRememberedValue10;
                zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
                objRememberedValue11 = composer.rememberedValue();
                if (zChangedInstance7) {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                lb.a aVar111111111115 = (lb.a) objRememberedValue11;
                zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue12 = composer.rememberedValue();
                if (zChangedInstance8) {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue12);
                }
                ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar212, false, aVar2, z117, aVar4, z118, aVar213, false, aVar214, z14, aVar111111111110, true, aVar111111111111, true, aVar111111111112, aVar111111111113, aVar111111111114, aVar111111111115, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                z13 = true;
            }
            z14 = z13;
            zChanged = composer.changed(softwareKeyboardController);
            objRememberedValue6 = composer.rememberedValue();
            if (zChanged) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar111111111116 = (lb.a) objRememberedValue6;
            zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
            objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance4) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$6$0(chatViewModel, snapshotStateList, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            lb.a aVar111111111117 = (lb.a) objRememberedValue7;
            zChangedInstance5 = composer.changedInstance(chatViewModel);
            objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance5) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$7$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            lb.a aVar111111111118 = (lb.a) objRememberedValue8;
            zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance6) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$8$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            lb.a aVar111111111119 = (lb.a) objRememberedValue9;
            objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$9$0(snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            lb.a aVar1111111111110 = (lb.a) objRememberedValue10;
            zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
            objRememberedValue11 = composer.rememberedValue();
            if (zChangedInstance7) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            } else {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$10$0(managedActivityResultLauncher, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            lb.a aVar1111111111111 = (lb.a) objRememberedValue11;
            zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
            objRememberedValue12 = composer.rememberedValue();
            if (zChangedInstance8) {
                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            } else {
                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$88$0$11$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            ChatActionBarKt.ChatActionBar(companion2, navHostController, chatScreenState, i11, z10, aVar212, false, aVar2, z117, aVar4, z118, aVar213, false, aVar214, z14, aVar111111111116, true, aVar111111111117, true, aVar111111111118, aVar111111111119, aVar1111111111110, aVar1111111111111, (lb.a) objRememberedValue12, null, null, null, composer, 819462150, 102236544, 48, 117440512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$0$0(MutableState mutableState, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, TextFieldState textFieldState) {
        List<String> listChatChannelScreen$clearSelection = ChatChannelScreen$clearSelection(snapshotStateList);
        if (!listChatChannelScreen$clearSelection.isEmpty()) {
            mutableState.setValue(ChatComplexFunctionalities.INSTANCE.findMsg(listChatChannelScreen$clearSelection.get(0), chatViewModel.getMsgList()));
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions != null) {
                TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, messageWithPartnerWithReactions.getMessage().getContent());
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$10$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        Integer state = ChatChannelScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            managedActivityResultLauncher.launch("image/*");
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatChannelScreen$lambda$16(mutableState), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$11$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
        kotlin.jvm.internal.y.f(chatScreenStateChatChannelScreen$lambda$6);
        chatViewModel.removeChatBackground(chatScreenStateChatChannelScreen$lambda$6.getId());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$2$0(MutableState mutableState) {
        ChatChannelScreen$lambda$64(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$3$0(MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, SnapshotStateList snapshotStateList) {
        List<String> listChatChannelScreen$clearSelection = ChatChannelScreen$clearSelection(snapshotStateList);
        if (!listChatChannelScreen$clearSelection.isEmpty()) {
            mutableState.setValue(ChatComplexFunctionalities.INSTANCE.findMsg(listChatChannelScreen$clearSelection.get(0), chatViewModel.getMsgList()));
            mutableState2.setValue(null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$4$0(NavHostController navHostController, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        List<String> listChatChannelScreen$clearSelection = ChatChannelScreen$clearSelection(snapshotStateList);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listChatChannelScreen$clearSelection.iterator();
        while (it.hasNext()) {
            arrayList.add(new Send(3, (String) it.next()));
        }
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new SendToParams(arrayList));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goForwardTo(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$5$0(SoftwareKeyboardController softwareKeyboardController, SnapshotStateList snapshotStateList, MutableState mutableState) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        mutableState.setValue((String) va.g0.w0(ChatChannelScreen$clearSelection(snapshotStateList)));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$6$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, State state) {
        String id2;
        List<String> listChatChannelScreen$clearSelectionPublications = ChatChannelScreen$clearSelectionPublications(snapshotStateList);
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
        if (chatScreenStateChatChannelScreen$lambda$6 == null || (id2 = chatScreenStateChatChannelScreen$lambda$6.getId()) == null) {
            id2 = "";
        }
        chatViewModel.reloadSelectedMsgsOnChannel(listChatChannelScreen$clearSelectionPublications, id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$7$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        chatViewModel.share(ChatChannelScreen$clearSelectionPublications(snapshotStateList));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$8$0(ChatViewModel chatViewModel, Context context, SnapshotStateList snapshotStateList) {
        chatViewModel.pastToClipboard(ChatChannelScreen$clearSelection(snapshotStateList), context);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$88$0$9$0(SnapshotStateList snapshotStateList) {
        ChatChannelScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:275:0x09a2  */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v27 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89(final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final State state, final TextFieldState textFieldState, final ChatParams chatParams, final pe.m0 m0Var, final NavHostController navHostController, final MutableState mutableState, final MutableState mutableState2, final SnapshotStateList snapshotStateList2, MutableState mutableState3, final MutableState mutableState4, LazyPagingItems lazyPagingItems, final SoftwareKeyboardController softwareKeyboardController, final Context context, final FocusRequester focusRequester, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final State state2, final State state3, final MutableState mutableState9, final MutableState mutableState10, MutableIntState mutableIntState, State state4, final MutableState mutableState11, final MutableState mutableState12, final ManagedActivityResultLauncher managedActivityResultLauncher, final MutableState mutableState13, final ManagedActivityResultLauncher managedActivityResultLauncher2, final MutableState mutableState14, final LazyPagingItems lazyPagingItems2, final LazyPagingItems lazyPagingItems3, final LazyPagingItems lazyPagingItems4, final State state5, final MutableState mutableState15, State state6, final MutableState mutableState16, State state7, MutableState mutableState17, ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1 chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1, Modifier m10, Composer composer, int i10) {
        int i11;
        final MutableState mutableState18;
        Composer composer2;
        final State state8;
        final ChatViewModel chatViewModel2;
        final TextFieldState textFieldState2;
        final ChatParams chatParams2;
        final NavHostController navHostController2;
        String str;
        String str2;
        char c10;
        boolean z10;
        final MutableState mutableState19;
        final MutableState mutableState20;
        final MutableState mutableState21;
        ?? r10;
        final ChatParams chatParams3;
        final ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1 chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$2;
        ab.e eVar;
        final MutableState mutableState22;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6;
        List<String> rights;
        final SnapshotStateList snapshotStateList3;
        final MutableState mutableState23;
        final MutableState mutableState24;
        final MutableState mutableState25;
        String str3;
        String str4;
        boolean z11;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$7;
        List<String> rights2;
        Composer composer3;
        final MutableState mutableState26;
        final MutableState mutableState27;
        ChatScreenState chatScreenStateChatChannelScreen$lambda$8;
        List<String> rights3;
        String backgroundPath;
        final TextFieldState textFieldState3 = textFieldState;
        kotlin.jvm.internal.y.i(m10, "m");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(m10) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-420149937, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous> (ChatChannelScreen.kt:740)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(m10, 0.0f, 1, null));
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierImePadding);
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
            String str5 = "pm";
            String str6 = "none";
            if (ChatChannelScreen$lambda$6(state) != null) {
                composer.startReplaceGroup(1522304467);
                final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(chatParams.getInitialPosition(), 0, composer, 0, 2);
                State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(chatViewModel.getRefreshing().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
                boolean zContains = ((List) stateCollectAsStateWithLifecycle.getValue()).contains(chatParams.getUid());
                boolean zChangedInstance = composer.changedInstance(chatViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.v3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$0$0(chatViewModel, chatParams);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                PullRefreshState pullRefreshStateM2815rememberPullRefreshStateUuyPYSY = PullRefreshStateKt.m2815rememberPullRefreshStateUuyPYSY(zContains, (lb.a) objRememberedValue, 0.0f, 0.0f, composer, 0, 12);
                if (ChatChannelScreen$lambda$9(mutableState3) == null) {
                    composer.startReplaceGroup(1522668283);
                    boolean zChangedInstance2 = composer.changedInstance(m0Var) | composer.changed(lazyListStateRememberLazyListState);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.g4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$1$0(m0Var, lazyListStateRememberLazyListState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState3.setValue((Function1) objRememberedValue2);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1523973321);
                    composer.endReplaceGroup();
                }
                if (ChatChannelScreen$lambda$12(mutableState4) == null) {
                    composer.startReplaceGroup(1524095306);
                    boolean zChangedInstance3 = composer.changedInstance(m0Var) | composer.changed(lazyListStateRememberLazyListState);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.s4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$2$0(m0Var, lazyListStateRememberLazyListState, ((Integer) obj).intValue());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState4.setValue((Function1) objRememberedValue3);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1526400745);
                    composer.endReplaceGroup();
                }
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierA = androidx.compose.foundation.layout.x.a(columnScopeInstance, PullRefreshKt.pullRefresh$default(companion3, pullRefreshStateM2815rememberPullRefreshStateUuyPYSY, false, 2, null), 1.0f, false, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getBottomEnd(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierA);
                lb.a constructor2 = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
                boolean zChangedInstance4 = composer.changedInstance(chatViewModel);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new ChatChannelScreenKt$ChatChannelScreen$3$1$3$1$1(chatViewModel);
                    composer.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar = (lb.a) ((sb.h) objRememberedValue4);
                Object objRememberedValue5 = composer.rememberedValue();
                Composer.Companion companion4 = Composer.INSTANCE;
                if (objRememberedValue5 == companion4.getEmpty()) {
                    objRememberedValue5 = new ChatChannelScreenKt$ChatChannelScreen$3$1$3$2$1(snapshotStateList);
                    composer.updateRememberedValue(objRememberedValue5);
                }
                Function1 function1 = (Function1) ((sb.h) objRememberedValue5);
                ChatScreenState chatScreenStateChatChannelScreen$lambda$9 = ChatChannelScreen$lambda$6(state);
                boolean zIsSecret = chatScreenStateChatChannelScreen$lambda$9 != null ? chatScreenStateChatChannelScreen$lambda$9.isSecret() : false;
                String uid = chatParams.getUid();
                ChatScreenState chatScreenStateChatChannelScreen$lambda$10 = ChatChannelScreen$lambda$6(state);
                String str7 = (chatScreenStateChatChannelScreen$lambda$10 == null || (backgroundPath = chatScreenStateChatChannelScreen$lambda$10.getBackgroundPath()) == null) ? "" : backgroundPath;
                boolean zChangedInstance5 = composer.changedInstance(chatViewModel);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue6 == companion4.getEmpty()) {
                    objRememberedValue6 = new ChatChannelScreenKt$ChatChannelScreen$3$1$3$3$1(chatViewModel);
                    composer.updateRememberedValue(objRememberedValue6);
                }
                Function1 function2 = (Function1) ((sb.h) objRememberedValue6);
                boolean zChangedInstance6 = composer.changedInstance(chatViewModel);
                Object objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance6 || objRememberedValue7 == companion4.getEmpty()) {
                    objRememberedValue7 = new ChatChannelScreenKt$ChatChannelScreen$3$1$3$4$1(chatViewModel);
                    composer.updateRememberedValue(objRememberedValue7);
                }
                Function1 function3 = (Function1) ((sb.h) objRememberedValue7);
                ChatScreenState chatScreenStateChatChannelScreen$lambda$11 = ChatChannelScreen$lambda$6(state);
                boolean z12 = (kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$11 != null ? chatScreenStateChatChannelScreen$lambda$11.getAffiliation() : null, "none") || (chatScreenStateChatChannelScreen$lambda$8 = ChatChannelScreen$lambda$6(state)) == null || (rights3 = chatScreenStateChatChannelScreen$lambda$8.getRights()) == null || !rights3.contains("pm")) ? false : true;
                Object objRememberedValue8 = composer.rememberedValue();
                if (objRememberedValue8 == companion4.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.f5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$4$0(focusRequester, mutableState, snapshotStateList, (MessageWithPartnerWithReactions) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                Function1 function4 = (Function1) objRememberedValue8;
                boolean zChangedInstance7 = composer.changedInstance(chatViewModel);
                Object objRememberedValue9 = composer.rememberedValue();
                if (zChangedInstance7 || objRememberedValue9 == companion4.getEmpty()) {
                    objRememberedValue9 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.g5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$5$0(chatViewModel, snapshotStateList, (String) obj, (String) obj2, (String) obj3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                Function3 function5 = (Function3) objRememberedValue9;
                boolean zChangedInstance8 = composer.changedInstance(navHostController);
                Object objRememberedValue10 = composer.rememberedValue();
                if (zChangedInstance8 || objRememberedValue10 == companion4.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$6$0(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue10);
                }
                lb.a aVar2 = (lb.a) objRememberedValue10;
                Object objRememberedValue11 = composer.rememberedValue();
                if (objRememberedValue11 == companion4.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$7$0((String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                Function1 function6 = (Function1) objRememberedValue11;
                Object objRememberedValue12 = composer.rememberedValue();
                if (objRememberedValue12 == companion4.getEmpty()) {
                    objRememberedValue12 = new ChatChannelScreenKt$ChatChannelScreen$3$1$3$9$1(mutableState4);
                    composer.updateRememberedValue(objRememberedValue12);
                }
                Function1 function7 = (Function1) ((sb.h) objRememberedValue12);
                boolean zChangedInstance9 = composer.changedInstance(chatViewModel) | composer.changedInstance(navHostController);
                Object objRememberedValue13 = composer.rememberedValue();
                if (zChangedInstance9 || objRememberedValue13 == companion4.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$9$0(chatViewModel, navHostController, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue13);
                }
                Function1 function8 = (Function1) objRememberedValue13;
                boolean zChangedInstance10 = composer.changedInstance(chatViewModel) | composer.changed(softwareKeyboardController) | composer.changedInstance(context) | composer.changedInstance(navHostController) | composer.changed(textFieldState3) | composer.changed(state);
                Object objRememberedValue14 = composer.rememberedValue();
                if (zChangedInstance10 || objRememberedValue14 == companion4.getEmpty()) {
                    composer3 = composer;
                    objRememberedValue14 = new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i5
                        @Override // lb.o
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$10$0(chatViewModel, snapshotStateList, softwareKeyboardController, context, navHostController, chatParams, textFieldState3, mutableState5, state, mutableState6, mutableState, mutableState2, ((Boolean) obj).booleanValue(), (MessageAction) obj2, (MessageWithPartnerWithReactions) obj3, ((Integer) obj4).intValue());
                        }
                    };
                    textFieldState3 = textFieldState3;
                    mutableState26 = mutableState2;
                    state8 = state;
                    mutableState27 = mutableState;
                    composer3.updateRememberedValue(objRememberedValue14);
                } else {
                    mutableState26 = mutableState2;
                    mutableState27 = mutableState;
                    composer3 = composer;
                    state8 = state;
                }
                lb.o oVar = (lb.o) objRememberedValue14;
                boolean zChangedInstance11 = composer3.changedInstance(chatViewModel);
                Object objRememberedValue15 = composer3.rememberedValue();
                if (zChangedInstance11 || objRememberedValue15 == companion4.getEmpty()) {
                    objRememberedValue15 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.t5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$11$0(snapshotStateList, chatViewModel, mutableState27, mutableState26, (MessageWithPartnerWithReactions) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                }
                Function2 function9 = (Function2) objRememberedValue15;
                boolean zChangedInstance12 = composer3.changedInstance(chatViewModel) | composer3.changedInstance(navHostController) | composer3.changedInstance(context) | composer3.changed(textFieldState3);
                Object objRememberedValue16 = composer3.rememberedValue();
                if (zChangedInstance12 || objRememberedValue16 == companion4.getEmpty()) {
                    Function3 function10 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.e6
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$12$0(chatViewModel, context, textFieldState3, mutableState7, navHostController, (MessageWithPartnerWithReactions) obj, (MessageAction) obj2, (String) obj3);
                        }
                    };
                    composer3.updateRememberedValue(function10);
                    objRememberedValue16 = function10;
                }
                Composer composer4 = composer3;
                MsgListKt.MsgList(modifierFillMaxSize$default, lazyListStateRememberLazyListState, lazyPagingItems, aVar, function1, zIsSecret, uid, str7, function2, function3, z12, function4, false, function5, aVar2, function6, function7, function8, oVar, function9, (Function3) objRememberedValue16, null, null, composer4, (LazyPagingItems.$stable << 6) | 24582, 1769904, 0, 6291456);
                AttachContainerKt.AttachContainer(boxScopeInstance.align(r62, companion.getBottomCenter()), ChatChannelScreen$lambda$84(mutableState8), null, false, false, ComposableLambdaKt.rememberComposableLambda(-850787284, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$13(textFieldState, chatViewModel, state2, state3, mutableState8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer4, 54), composer4, 199680, 20);
                Modifier modifierAlign = boxScopeInstance.align(r62, companion.getTopCenter());
                ChatScreenState chatScreenStateChatChannelScreen$lambda$12 = ChatChannelScreen$lambda$6(state8);
                AttachContainerKt.AnimateContainer(modifierAlign, (chatScreenStateChatChannelScreen$lambda$12 != null ? chatScreenStateChatChannelScreen$lambda$12.getPinnedMessage() : null) != null && ChatChannelScreen$lambda$78(mutableState9), ComposableLambdaKt.rememberComposableLambda(-1047733687, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.a7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$14(state8, mutableState10, mutableState9, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer4, 54), composer4, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                boolean zContains2 = ((List) stateCollectAsStateWithLifecycle.getValue()).contains(chatParams.getUid());
                Modifier modifierAlign2 = boxScopeInstance.align(companion3, companion.getTopCenter());
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i12 = MaterialTheme.$stable;
                mutableState18 = mutableState27;
                PullRefreshIndicatorKt.m2813PullRefreshIndicatorjB83MbM(zContains2, pullRefreshStateM2815rememberPullRefreshStateUuyPYSY, modifierAlign2, materialTheme.getColorScheme(composer4, i12).getBackground(), materialTheme.getColorScheme(composer4, i12).getPrimary(), false, composer4, PullRefreshState.$stable << 3, 32);
                composer2 = composer4;
                ua.k0 k0Var = ua.k0.f43947a;
                boolean zChanged = composer2.changed(lazyListStateRememberLazyListState);
                Object objRememberedValue17 = composer2.rememberedValue();
                if (zChanged || objRememberedValue17 == companion4.getEmpty()) {
                    ChatChannelScreenKt$ChatChannelScreen$3$1$3$16$1 chatChannelScreenKt$ChatChannelScreen$3$1$3$16$1 = new ChatChannelScreenKt$ChatChannelScreen$3$1$3$16$1(chatParams, lazyListStateRememberLazyListState, mutableState3, mutableIntState, null);
                    composer2.updateRememberedValue(chatChannelScreenKt$ChatChannelScreen$3$1$3$16$1);
                    objRememberedValue17 = chatChannelScreenKt$ChatChannelScreen$3$1$3$16$1;
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue17, composer2, 6);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                mutableState18 = mutableState;
                composer2 = composer;
                str6 = "none";
                str5 = "pm";
                state8 = state;
                composer2.startReplaceGroup(-643202506);
                PagerStateIndicatorKt.PageLoaderDefault(SizeKt.fillMaxWidth$default(androidx.compose.foundation.layout.x.a(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 1, null), composer2, 0, 0);
                composer2.endReplaceGroup();
            }
            if (ChatChannelScreen$lambda$6(state8) != null) {
                composer2.startReplaceGroup(1536067475);
                Modifier.Companion companion5 = Modifier.INSTANCE;
                boolean zChatChannelScreen$lambda$76 = ChatChannelScreen$lambda$76(state4);
                boolean zChangedInstance13 = composer2.changedInstance(chatViewModel) | composer2.changed(state8);
                Object objRememberedValue18 = composer2.rememberedValue();
                if (zChangedInstance13 || objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$4$0(chatViewModel, state8);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue18);
                }
                lb.a aVar3 = (lb.a) objRememberedValue18;
                boolean zChangedInstance14 = composer2.changedInstance(chatViewModel) | composer2.changed(state8);
                Object objRememberedValue19 = composer2.rememberedValue();
                if (zChangedInstance14 || objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.r3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$5$0(chatViewModel, state8);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue19);
                }
                lb.a aVar4 = (lb.a) objRememberedValue19;
                boolean zChangedInstance15 = composer2.changedInstance(chatViewModel) | composer2.changed(state8) | composer2.changedInstance(navHostController);
                Object objRememberedValue20 = composer2.rememberedValue();
                if (zChangedInstance15 || objRememberedValue20 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue20 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.s3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$6$0(chatViewModel, state8, navHostController);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue20);
                }
                UnknownConfirmationKt.UnknownConfirmation(companion5, zChatChannelScreen$lambda$76, 2, aVar3, aVar4, null, (lb.a) objRememberedValue20, composer, 390, 32);
                boolean z13 = mutableState18.getValue() != null;
                Object objRememberedValue21 = composer.rememberedValue();
                Composer.Companion companion6 = Composer.INSTANCE;
                if (objRememberedValue21 == companion6.getEmpty()) {
                    objRememberedValue21 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.t3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$7$0(mutableState18);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue21);
                }
                AttachContainerKt.AttachContainer(companion5, z13, (lb.a) objRememberedValue21, false, false, ComposableLambdaKt.rememberComposableLambda(246316507, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.u3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$8(mutableState18, chatViewModel, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 200070, 16);
                boolean z14 = mutableState2.getValue() != null;
                Object objRememberedValue22 = composer.rememberedValue();
                if (objRememberedValue22 == companion6.getEmpty()) {
                    objRememberedValue22 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.w3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$9$0(mutableState2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue22);
                }
                AttachContainerKt.AttachContainer(companion5, z14, (lb.a) objRememberedValue22, false, false, ComposableLambdaKt.rememberComposableLambda(-446413948, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.x3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$10(mutableState2, chatViewModel, textFieldState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 200070, 16);
                boolean z15 = !snapshotStateList2.isEmpty();
                Object objRememberedValue23 = composer.rememberedValue();
                if (objRememberedValue23 == companion6.getEmpty()) {
                    snapshotStateList3 = snapshotStateList2;
                    mutableState23 = mutableState11;
                    mutableState24 = mutableState12;
                    objRememberedValue23 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.y3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$11$0(snapshotStateList3, mutableState23, mutableState24);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue23);
                } else {
                    snapshotStateList3 = snapshotStateList2;
                    mutableState23 = mutableState11;
                    mutableState24 = mutableState12;
                }
                final MutableState mutableState28 = mutableState24;
                AttachContainerKt.AttachContainer(companion5, z15, (lb.a) objRememberedValue23, false, false, ComposableLambdaKt.rememberComposableLambda(424407651, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.z3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$12(snapshotStateList3, managedActivityResultLauncher, mutableState13, mutableState23, mutableState24, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 196998, 24);
                boolean zChatChannelScreen$lambda$34 = ChatChannelScreen$lambda$34(mutableState28);
                Object objRememberedValue24 = composer.rememberedValue();
                if (objRememberedValue24 == companion6.getEmpty()) {
                    objRememberedValue24 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.a4
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$13$0(mutableState28);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue24);
                }
                final MutableState mutableState29 = mutableState18;
                AttachContainerKt.AttachContainer(companion5, zChatChannelScreen$lambda$34, (lb.a) objRememberedValue24, false, false, ComposableLambdaKt.rememberComposableLambda(1295229250, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.c4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$14(chatViewModel, managedActivityResultLauncher, navHostController, managedActivityResultLauncher2, context, textFieldState, mutableState13, mutableState11, snapshotStateList2, mutableState28, chatParams, mutableState29, mutableState5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 196998, 24);
                boolean zChatChannelScreen$lambda$69 = ChatChannelScreen$lambda$69(mutableState14);
                Object objRememberedValue25 = composer.rememberedValue();
                if (objRememberedValue25 == companion6.getEmpty()) {
                    mutableState25 = mutableState14;
                    objRememberedValue25 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.d4
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$15$0(mutableState25);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue25);
                } else {
                    mutableState25 = mutableState14;
                }
                navHostController2 = navHostController;
                AttachContainerKt.AttachContainer(companion5, zChatChannelScreen$lambda$69, (lb.a) objRememberedValue25, true, false, ComposableLambdaKt.rememberComposableLambda(-2128916447, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.e4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$16(lazyPagingItems2, lazyPagingItems3, lazyPagingItems4, navHostController, chatViewModel, mutableState25, chatParams, mutableState, focusRequester, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 200070, 16);
                ChatScreenState chatScreenStateChatChannelScreen$lambda$13 = ChatChannelScreen$lambda$6(state);
                if (kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$13 != null ? chatScreenStateChatChannelScreen$lambda$13.getAffiliation() : null, UserRoomJoin.AFFILIATION_OWNER)) {
                    str3 = str5;
                    str4 = str6;
                } else {
                    ChatScreenState chatScreenStateChatChannelScreen$lambda$14 = ChatChannelScreen$lambda$6(state);
                    str4 = str6;
                    if (kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$14 != null ? chatScreenStateChatChannelScreen$lambda$14.getAffiliation() : null, str4) || (chatScreenStateChatChannelScreen$lambda$7 = ChatChannelScreen$lambda$6(state)) == null || (rights2 = chatScreenStateChatChannelScreen$lambda$7.getRights()) == null) {
                        str3 = str5;
                    } else {
                        str3 = str5;
                        if (rights2.contains(str3)) {
                        }
                        str2 = str4;
                        str = str3;
                        textFieldState2 = textFieldState;
                        chatViewModel2 = chatViewModel;
                        chatParams2 = chatParams;
                        c10 = '6';
                        AttachContainerKt.AnimateContainer(companion5, z11, ComposableLambdaKt.rememberComposableLambda(150571896, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.f4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17(textFieldState, chatViewModel, context, focusRequester, state5, mutableState11, mutableState14, snapshotStateList2, chatParams, mutableState, mutableState2, mutableState12, mutableState15, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer, 54), composer, 390, 0);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                    }
                    z11 = false;
                    str2 = str4;
                    str = str3;
                    textFieldState2 = textFieldState;
                    chatViewModel2 = chatViewModel;
                    chatParams2 = chatParams;
                    c10 = '6';
                    AttachContainerKt.AnimateContainer(companion5, z11, ComposableLambdaKt.rememberComposableLambda(150571896, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.f4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17(textFieldState, chatViewModel, context, focusRequester, state5, mutableState11, mutableState14, snapshotStateList2, chatParams, mutableState, mutableState2, mutableState12, mutableState15, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer, 54), composer, 390, 0);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                }
                z11 = true;
                str2 = str4;
                str = str3;
                textFieldState2 = textFieldState;
                chatViewModel2 = chatViewModel;
                chatParams2 = chatParams;
                c10 = '6';
                AttachContainerKt.AnimateContainer(companion5, z11, ComposableLambdaKt.rememberComposableLambda(150571896, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.f4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17(textFieldState, chatViewModel, context, focusRequester, state5, mutableState11, mutableState14, snapshotStateList2, chatParams, mutableState, mutableState2, mutableState12, mutableState15, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 390, 0);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                chatViewModel2 = chatViewModel;
                textFieldState2 = textFieldState;
                chatParams2 = chatParams;
                navHostController2 = navHostController;
                str = str5;
                str2 = str6;
                c10 = '6';
                composer2.startReplaceGroup(1546113769);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            Modifier modifierImePadding2 = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierImePadding2);
            lb.a constructor3 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            boolean zBooleanValue = ((Boolean) mutableState10.getValue()).booleanValue();
            Object objRememberedValue26 = composer2.rememberedValue();
            Composer.Companion companion7 = Composer.INSTANCE;
            if (objRememberedValue26 == companion7.getEmpty()) {
                objRememberedValue26 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$0$0(mutableState10);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue26);
            }
            lb.a aVar5 = (lb.a) objRememberedValue26;
            boolean zChangedInstance16 = composer2.changedInstance(chatViewModel2);
            Object objRememberedValue27 = composer2.rememberedValue();
            if (zChangedInstance16 || objRememberedValue27 == companion7.getEmpty()) {
                objRememberedValue27 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$1$0(chatViewModel2, chatParams2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue27);
            }
            Z17DialogsKt.Z17DialogWithActions(zBooleanValue, aVar5, (lb.a) objRememberedValue27, null, StringResources_androidKt.stringResource(R.string.pinned_message, composer2, 0), StringResources_androidKt.stringResource(R.string.u_wish_to_unpin_msg, composer2, 0), null, null, composer, 48, 200);
            Composer composer5 = composer;
            if (ChatChannelScreen$lambda$7(state6).getStatus() == Status.SUCCESS) {
                composer5.startReplaceGroup(1835424657);
                Friend data = ChatChannelScreen$lambda$7(state6).getData();
                kotlin.jvm.internal.y.f(data);
                Friend friend = data;
                boolean zChangedInstance17 = composer5.changedInstance(chatViewModel2);
                Object objRememberedValue28 = composer5.rememberedValue();
                if (zChangedInstance17 || objRememberedValue28 == companion7.getEmpty()) {
                    objRememberedValue28 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j4
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$2$0(chatViewModel2);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue28);
                }
                lb.a aVar6 = (lb.a) objRememberedValue28;
                boolean zChangedInstance18 = composer5.changedInstance(navHostController2);
                Object objRememberedValue29 = composer5.rememberedValue();
                if (zChangedInstance18 || objRememberedValue29 == companion7.getEmpty()) {
                    objRememberedValue29 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$3$0(navHostController2, (String) obj);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue29);
                }
                DetailsDialogForContactCardKt.DetailsDialogForContactCard(friend, aVar6, (Function1) objRememberedValue29, composer5, 0);
                composer5.endReplaceGroup();
            } else {
                composer5.startReplaceGroup(1063812473);
                composer5.endReplaceGroup();
            }
            int size = snapshotStateList.size();
            if (ChatChannelScreen$lambda$63(mutableState16) && ChatChannelScreen$lambda$48(state7)) {
                ChatScreenState chatScreenStateChatChannelScreen$lambda$15 = ChatChannelScreen$lambda$6(state);
                if (kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$15 != null ? chatScreenStateChatChannelScreen$lambda$15.getAffiliation() : null, str2) || (chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state)) == null || (rights = chatScreenStateChatChannelScreen$lambda$6.getRights()) == null || !rights.contains(str)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            } else {
                z10 = false;
            }
            boolean zChatChannelScreen$lambda$48 = ChatChannelScreen$lambda$48(state7);
            Object objRememberedValue30 = composer5.rememberedValue();
            if (objRememberedValue30 == companion7.getEmpty()) {
                objRememberedValue30 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$4$0(mutableState16);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue30);
            }
            lb.a aVar7 = (lb.a) objRememberedValue30;
            Object objRememberedValue31 = composer5.rememberedValue();
            if (objRememberedValue31 == companion7.getEmpty()) {
                objRememberedValue31 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n4
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer5.updateRememberedValue(objRememberedValue31);
            }
            lb.a aVar8 = (lb.a) objRememberedValue31;
            boolean zChangedInstance19 = composer5.changedInstance(chatViewModel2);
            Object objRememberedValue32 = composer5.rememberedValue();
            if (zChangedInstance19 || objRememberedValue32 == companion7.getEmpty()) {
                objRememberedValue32 = new ChatChannelScreenKt$ChatChannelScreen$3$2$7$1(chatViewModel2, chatParams2, snapshotStateList);
                composer5.updateRememberedValue(objRememberedValue32);
            }
            DeletingDialogKt.DeletingDialog(size, z10, false, zChatChannelScreen$lambda$48, aVar7, aVar8, (lb.a) ((sb.h) objRememberedValue32), composer5, 221568, 0);
            Object objRememberedValue33 = composer5.rememberedValue();
            if (objRememberedValue33 == companion7.getEmpty()) {
                mutableState19 = mutableState5;
                objRememberedValue33 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$7$0(mutableState19);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue33);
            } else {
                mutableState19 = mutableState5;
            }
            lb.a aVar9 = (lb.a) objRememberedValue33;
            PagerDialogData pagerDialogDataChatChannelScreen$lambda$25 = ChatChannelScreen$lambda$25(mutableState19);
            LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel2.friendsOnDbNoHeaders(""), null, composer5, 0, 1);
            String nameWithDomain = chatViewModel2.getOwner().getNameWithDomain();
            boolean zChanged2 = composer5.changed(textFieldState2) | composer5.changedInstance(chatViewModel2);
            Object objRememberedValue34 = composer5.rememberedValue();
            if (zChanged2 || objRememberedValue34 == companion7.getEmpty()) {
                objRememberedValue34 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$8$0(textFieldState2, chatViewModel2, chatParams2, mutableState19, (String) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer5.updateRememberedValue(objRememberedValue34);
            }
            PagerDialogKt.PagerDialog(aVar9, pagerDialogDataChatChannelScreen$lambda$25, lazyPagingItemsCollectAsLazyPagingItems, nameWithDomain, (Function2) objRememberedValue34, null, null, composer5, (LazyPagingItems.$stable << 6) | 6, 96);
            if (ChatChannelScreen$lambda$66(mutableState15)) {
                composer5.startReplaceGroup(1065373943);
                boolean zChangedInstance20 = composer5.changedInstance(chatViewModel2);
                Object objRememberedValue35 = composer5.rememberedValue();
                if (zChangedInstance20 || objRememberedValue35 == companion7.getEmpty()) {
                    mutableState22 = mutableState15;
                    objRememberedValue35 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.q4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$9$0(chatParams2, mutableState, chatViewModel2, mutableState22, (List) obj, (String) obj2);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue35);
                } else {
                    mutableState22 = mutableState15;
                }
                Function2 function11 = (Function2) objRememberedValue35;
                boolean zChangedInstance21 = composer5.changedInstance(chatViewModel2);
                Object objRememberedValue36 = composer5.rememberedValue();
                if (zChangedInstance21 || objRememberedValue36 == companion7.getEmpty()) {
                    objRememberedValue36 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.r4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$10$0(chatParams2, mutableState, chatViewModel2, mutableState22, (List) obj, (String) obj2);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue36);
                }
                Function2 function12 = (Function2) objRememberedValue36;
                Object objRememberedValue37 = composer5.rememberedValue();
                if (objRememberedValue37 == companion7.getEmpty()) {
                    objRememberedValue37 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.t4
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$11$0(mutableState22);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue37);
                }
                lb.a aVar10 = (lb.a) objRememberedValue37;
                Object objRememberedValue38 = composer5.rememberedValue();
                if (objRememberedValue38 == companion7.getEmpty()) {
                    objRememberedValue38 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.u4
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$12$0(mutableState22);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue38);
                }
                CameraKt.Camera(null, null, false, false, false, false, 0L, function11, function12, null, aVar10, (lb.a) objRememberedValue38, composer, 0, 54, 639);
                composer5 = composer;
                composer5.endReplaceGroup();
            } else {
                composer5.startReplaceGroup(1066482937);
                composer5.endReplaceGroup();
            }
            AttachContainerKt.AnimateContainer(null, ChatChannelScreen$lambda$31(mutableState6) != null, ComposableLambdaKt.rememberComposableLambda(-2052148550, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.v4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$13(mutableState6, chatViewModel, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer5, 54), composer5, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            boolean z16 = ChatChannelScreen$lambda$73(mutableState17).length() > 0;
            Object objRememberedValue39 = composer5.rememberedValue();
            if (objRememberedValue39 == companion7.getEmpty()) {
                mutableState20 = mutableState17;
                objRememberedValue39 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.w4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$14$0(mutableState20);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue39);
            } else {
                mutableState20 = mutableState17;
            }
            AttachContainerKt.AttachContainer(null, z16, (lb.a) objRememberedValue39, false, false, ComposableLambdaKt.rememberComposableLambda(1187219421, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.y4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$15(navHostController, mutableState20, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer5, 54), composer5, 196992, 25);
            PermissionsRequesterState permissionsRequesterStateChatChannelScreen$lambda$16 = ChatChannelScreen$lambda$16(mutableState13);
            Object objRememberedValue40 = composer5.rememberedValue();
            if (objRememberedValue40 == companion7.getEmpty()) {
                mutableState21 = mutableState13;
                objRememberedValue40 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.z4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$16$0(mutableState21);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue40);
            } else {
                mutableState21 = mutableState13;
            }
            lb.a aVar11 = (lb.a) objRememberedValue40;
            Object objRememberedValue41 = composer5.rememberedValue();
            if (objRememberedValue41 == companion7.getEmpty()) {
                objRememberedValue41 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.a5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$17$0(mutableState21, (PermissionsResult) obj);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue41);
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar11, permissionsRequesterStateChatChannelScreen$lambda$16, (Function1) objRememberedValue41, ComposableSingletons$ChatChannelScreenKt.INSTANCE.m9868getLambda$543497111$app_productionPFast(), composer5, 27696, 1);
            PermissionsRequesterState permissionsRequesterStateChatChannelScreen$lambda$17 = ChatChannelScreen$lambda$16(mutableState21);
            String packageName = context.getPackageName();
            kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
            Object objRememberedValue42 = composer5.rememberedValue();
            if (objRememberedValue42 == companion7.getEmpty()) {
                objRememberedValue42 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.b5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$18$0(mutableState21);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue42);
            }
            lb.a aVar12 = (lb.a) objRememberedValue42;
            Object objRememberedValue43 = composer5.rememberedValue();
            if (objRememberedValue43 == companion7.getEmpty()) {
                objRememberedValue43 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.c5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$19$0(mutableState21, (PermissionsResult) obj);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue43);
            }
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterStateChatChannelScreen$lambda$17, aVar12, (Function1) objRememberedValue43, packageName, composer5, 432);
            composer5.endNode();
            if (ChatChannelScreen$lambda$1(mutableState7)) {
                composer5.startReplaceGroup(-36175556);
                r10 = 0;
                LoadingScreenKt.LoadingWall(composer5, 0);
            } else {
                r10 = 0;
                composer5.startReplaceGroup(-1121429741);
            }
            composer5.endReplaceGroup();
            if (snapshotStateList.isEmpty()) {
                composer5.startReplaceGroup(-1121282925);
                composer5.endReplaceGroup();
            } else {
                composer5.startReplaceGroup(-36172277);
                Object objRememberedValue44 = composer5.rememberedValue();
                if (objRememberedValue44 == companion7.getEmpty()) {
                    objRememberedValue44 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.d5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$2$0(snapshotStateList);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue44);
                }
                BackHandlerKt.BackHandler(r10, (lb.a) objRememberedValue44, composer5, 48, 1);
                composer5.endReplaceGroup();
            }
            ua.k0 k0Var2 = ua.k0.f43947a;
            boolean zChangedInstance22 = composer5.changedInstance(chatViewModel);
            Object objRememberedValue45 = composer5.rememberedValue();
            if (zChangedInstance22 || objRememberedValue45 == companion7.getEmpty()) {
                chatParams3 = chatParams;
                chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$2 = chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1;
                eVar = null;
                objRememberedValue45 = new ChatChannelScreenKt$ChatChannelScreen$3$4$1(chatViewModel, chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$2, chatParams3, null);
                composer5.updateRememberedValue(objRememberedValue45);
            } else {
                chatParams3 = chatParams;
                chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$2 = chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1;
                eVar = null;
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue45, composer5, 6);
            ChatScreenState chatScreenStateChatChannelScreen$lambda$16 = ChatChannelScreen$lambda$6(state);
            boolean zChanged3 = composer5.changed(state) | composer5.changed(textFieldState) | composer5.changedInstance(chatViewModel);
            Object objRememberedValue46 = composer5.rememberedValue();
            if (zChanged3 || objRememberedValue46 == companion7.getEmpty()) {
                objRememberedValue46 = new ChatChannelScreenKt$ChatChannelScreen$3$5$1(textFieldState, chatViewModel, state, eVar);
                composer5.updateRememberedValue(objRememberedValue46);
            }
            EffectsKt.LaunchedEffect(chatScreenStateChatChannelScreen$lambda$16, (Function2) objRememberedValue46, composer5, (int) r10);
            boolean zChangedInstance23 = composer5.changedInstance(chatViewModel) | composer5.changed(textFieldState);
            Object objRememberedValue47 = composer5.rememberedValue();
            if (zChangedInstance23 || objRememberedValue47 == companion7.getEmpty()) {
                objRememberedValue47 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.e5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$5$0(chatViewModel, textFieldState, chatParams3, chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$2, (DisposableEffectScope) obj);
                    }
                };
                composer5.updateRememberedValue(objRememberedValue47);
            }
            EffectsKt.DisposableEffect(k0Var2, (Function1) objRememberedValue47, composer5, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$0$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.loadChannelOldMsgs(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$1$0(pe.m0 m0Var, LazyListState lazyListState, boolean z10) {
        pe.k.d(m0Var, null, null, new ChatChannelScreenKt$ChatChannelScreen$3$1$1$1$1(z10, lazyListState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$0$10(final MutableState mutableState, ChatViewModel chatViewModel, final TextFieldState textFieldState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446413948, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:1083)");
            }
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions == null) {
                composer.startReplaceGroup(-1899124743);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1899124742);
                String nameWithDomain = chatViewModel.getOwner().getNameWithDomain();
                String alias = chatViewModel.getOwner().getAlias();
                boolean zChanged = composer.changed(textFieldState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$10$0$0$0(mutableState, textFieldState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                MsgPreviewKt.EditPreview(messageWithPartnerWithReactions, nameWithDomain, alias, (lb.a) objRememberedValue, composer, 0);
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
    public static final ua.k0 ChatChannelScreen$lambda$89$0$10$0$0$0(MutableState mutableState, TextFieldState textFieldState) {
        mutableState.setValue(null);
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, "");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$11$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatChannelScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$0$12(final SnapshotStateList snapshotStateList, final ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424407651, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:1103)");
            }
            Integer state = ChatChannelScreen$lambda$16(mutableState).getPermissionsResult().getState();
            if (state != null && state.intValue() == 2) {
                composer.startReplaceGroup(-855298426);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.p5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$12$0$0(snapshotStateList, mutableState2, mutableState3, (Uri) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.q5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$12$1$0(managedActivityResultLauncher);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                PresentListKt.PresentList(snapshotStateList, function1, (lb.a) objRememberedValue2, composer, 54);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-854905377);
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
    public static final ua.k0 ChatChannelScreen$lambda$89$0$12$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, Uri it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatChannelScreen$removeAttachedFilesToSend(snapshotStateList, mutableState, mutableState2, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$12$1$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("*/*");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$13$0(MutableState mutableState) {
        ChatChannelScreen$lambda$35(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$0$14(final ChatViewModel chatViewModel, final ManagedActivityResultLauncher managedActivityResultLauncher, NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher2, final Context context, final TextFieldState textFieldState, final MutableState mutableState, final MutableState mutableState2, final SnapshotStateList snapshotStateList, final MutableState mutableState3, final ChatParams chatParams, final MutableState mutableState4, final MutableState mutableState5, Composer composer, int i10) {
        ManagedActivityResultLauncher managedActivityResultLauncher3;
        final NavHostController navHostController2;
        final MutableState mutableState6;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1295229250, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:1121)");
            }
            v5.f gson = chatViewModel.getGson();
            List<BotShortcut> attachmentShortcuts = chatViewModel.getAttachmentShortcuts();
            boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.w5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$14$0$0(managedActivityResultLauncher, mutableState, mutableState2, snapshotStateList, mutableState3);
                    }
                };
                managedActivityResultLauncher3 = managedActivityResultLauncher;
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            } else {
                managedActivityResultLauncher3 = managedActivityResultLauncher;
            }
            lb.a aVar2 = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                navHostController2 = navHostController;
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.x5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$14$1$0(navHostController2, chatViewModel, chatParams, mutableState4, mutableState3);
                    }
                };
                composer.updateRememberedValue(aVar3);
                objRememberedValue2 = aVar3;
            } else {
                navHostController2 = navHostController;
            }
            lb.a aVar4 = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(navHostController2) | composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableState6 = mutableState3;
                lb.a aVar5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.y5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$14$2$0(navHostController2, chatViewModel, chatParams, mutableState4, mutableState6);
                    }
                };
                composer.updateRememberedValue(aVar5);
                objRememberedValue3 = aVar5;
            } else {
                mutableState6 = mutableState3;
            }
            lb.a aVar6 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(managedActivityResultLauncher2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.z5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$14$3$0(managedActivityResultLauncher2, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar7 = (lb.a) objRememberedValue4;
            boolean zChangedInstance5 = composer.changedInstance(navHostController2);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.a6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$14$4$0(navHostController2, chatParams, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar8 = (lb.a) objRememberedValue5;
            boolean zChangedInstance6 = composer.changedInstance(managedActivityResultLauncher3);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                final ManagedActivityResultLauncher managedActivityResultLauncher4 = managedActivityResultLauncher3;
                lb.a aVar9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.b6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$14$5$0(managedActivityResultLauncher4, mutableState, mutableState2, snapshotStateList, mutableState6);
                    }
                };
                composer.updateRememberedValue(aVar9);
                objRememberedValue6 = aVar9;
            }
            lb.a aVar10 = (lb.a) objRememberedValue6;
            boolean zChangedInstance7 = composer.changedInstance(context) | composer.changedInstance(r2) | composer.changedInstance(navHostController2) | composer.changed(textFieldState);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                final NavHostController navHostController3 = navHostController2;
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.c6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$14$6$0(context, chatViewModel, chatParams, navHostController3, textFieldState, mutableState5, mutableState3, (ButtonContent) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue7 = function1;
            }
            AttachmentSelectorKt.AttachmentSelector(aVar2, aVar4, aVar6, aVar7, aVar8, aVar10, (Function1) objRememberedValue7, gson, attachmentShortcuts, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$14$0$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = ChatChannelScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatChannelScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (ChatChannelScreen$lambda$37(mutableState2)) {
            ChatChannelScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch("*/*");
        }
        ChatChannelScreen$lambda$35(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$14$1$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2) {
        ChatChannelScreen$createAndSendDate(navHostController, chatViewModel, chatParams, mutableState);
        ChatChannelScreen$lambda$35(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$14$2$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2) {
        ChatChannelScreen$selectMapLocation(navHostController, chatViewModel, chatParams, mutableState);
        ChatChannelScreen$lambda$35(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$14$3$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        managedActivityResultLauncher.launch(null);
        ChatChannelScreen$lambda$35(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$14$4$0(NavHostController navHostController, ChatParams chatParams, MutableState mutableState) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goPubEditor(chatParams.getUid()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        ChatChannelScreen$lambda$35(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$14$5$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = ChatChannelScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatChannelScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (ChatChannelScreen$lambda$37(mutableState2)) {
            ChatChannelScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch(VideoSpec.MIME_TYPE_UNSPECIFIED);
        }
        ChatChannelScreen$lambda$35(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$14$6$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, NavHostController navHostController, TextFieldState textFieldState, MutableState mutableState, MutableState mutableState2, ButtonContent it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatChannelScreen$onClickInShortcut(context, chatViewModel, chatParams, navHostController, textFieldState, mutableState, it);
        ChatChannelScreen$lambda$35(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$15$0(MutableState mutableState) {
        ChatChannelScreen$lambda$70(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$0$16(LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, final NavHostController navHostController, final ChatViewModel chatViewModel, final MutableState mutableState, final ChatParams chatParams, final MutableState mutableState2, final FocusRequester focusRequester, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2128916447, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:1180)");
            }
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$16$0$0(navHostController, chatViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$16$1$0(chatViewModel, chatParams, mutableState2, focusRequester, mutableState, (Sticker) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            }
            Function1 function2 = (Function1) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new ChatChannelScreenKt$ChatChannelScreen$3$1$16$3$1(chatViewModel);
                composer.updateRememberedValue(objRememberedValue3);
            }
            int i11 = LazyPagingItems.$stable;
            GroupsContainerKt.GroupsContainer(lazyPagingItems, lazyPagingItems2, lazyPagingItems3, aVar, function2, (Function2) ((sb.h) objRememberedValue3), composer, (i11 << 6) | (i11 << 3) | i11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$16$0$0(NavHostController navHostController, ChatViewModel chatViewModel, MutableState mutableState) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(null, 1, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        ChatChannelScreen$lambda$70(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$16$1$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, FocusRequester focusRequester, MutableState mutableState2, Sticker it) {
        Message message;
        kotlin.jvm.internal.y.i(it, "it");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendSticker(uid, it, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatChannelScreen$lambda$70(mutableState2, false);
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$0$17(TextFieldState textFieldState, final ChatViewModel chatViewModel, final Context context, FocusRequester focusRequester, State state, MutableState mutableState, final MutableState mutableState2, SnapshotStateList snapshotStateList, ChatParams chatParams, final MutableState mutableState3, final MutableState mutableState4, MutableState mutableState5, final MutableState mutableState6, Composer composer, int i10) {
        Object obj;
        final MutableState mutableState7;
        final SnapshotStateList snapshotStateList2;
        final ChatParams chatParams2;
        final MutableState mutableState8;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(150571896, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:1220)");
            }
            long jChatChannelScreen$lambda$14 = ChatChannelScreen$lambda$14(state);
            boolean zChatChannelScreen$lambda$37 = ChatChannelScreen$lambda$37(mutableState);
            boolean zChatChannelScreen$lambda$69 = ChatChannelScreen$lambda$69(mutableState2);
            boolean zChangedInstance = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState7 = mutableState;
                snapshotStateList2 = snapshotStateList;
                chatParams2 = chatParams;
                mutableState8 = mutableState5;
                obj = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.j6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17$0$0(snapshotStateList2, chatViewModel, chatParams2, mutableState3, mutableState4, context, mutableState7, mutableState8, (String) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                mutableState7 = mutableState;
                chatParams2 = chatParams;
                mutableState8 = mutableState5;
                obj = objRememberedValue;
                snapshotStateList2 = snapshotStateList;
            }
            Function1 function1 = (Function1) obj;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.k6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17$1$0(chatViewModel, chatParams2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.l6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17$2$0(chatViewModel, chatParams2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar2 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(chatViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17$3$0(chatViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar3 = (lb.a) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17$4$0(snapshotStateList2, mutableState7, mutableState8);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar4 = (lb.a) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.o6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17$5$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar5 = (lb.a) objRememberedValue6;
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.q6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$17$6$0(snapshotStateList2, mutableState7, mutableState8, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ChatInputKt.ChatInput(textFieldState, null, function1, aVar, aVar2, aVar3, aVar4, aVar5, (lb.a) objRememberedValue7, zChatChannelScreen$lambda$37, jChatChannelScreen$lambda$14, focusRequester, zChatChannelScreen$lambda$69, composer, 114819072, 48, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$17$0$0(SnapshotStateList snapshotStateList, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2, Context context, MutableState mutableState3, MutableState mutableState4, String messageContent) {
        Message message;
        Message message2;
        Message message3;
        kotlin.jvm.internal.y.i(messageContent, "messageContent");
        if (snapshotStateList.isEmpty()) {
            String uid = chatParams.getUid();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            String id2 = (messageWithPartnerWithReactions == null || (message3 = messageWithPartnerWithReactions.getMessage()) == null) ? null : message3.getId();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions2 = (MessageWithPartnerWithReactions) mutableState2.getValue();
            String id3 = (messageWithPartnerWithReactions2 == null || (message2 = messageWithPartnerWithReactions2.getMessage()) == null) ? null : message2.getId();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions3 = (MessageWithPartnerWithReactions) mutableState2.getValue();
            ChatViewModel.sendMessage$default(chatViewModel, messageContent, uid, false, null, id2, id3, (messageWithPartnerWithReactions3 == null || (message = messageWithPartnerWithReactions3.getMessage()) == null) ? null : message.getPublId(), 12, null);
        } else {
            ChatChannelScreen$selectMethodAndSend(chatParams, mutableState, chatViewModel, context, snapshotStateList, mutableState3, mutableState4, messageContent);
        }
        mutableState.setValue(null);
        mutableState2.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$17$1$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.startRecorder(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$17$2$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.stopRecorderAndSend(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$17$3$0(ChatViewModel chatViewModel) {
        chatViewModel.stopRecorder();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$17$4$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatChannelScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        ChatChannelScreen$lambda$35(mutableState2, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$17$5$0(MutableState mutableState) {
        ChatChannelScreen$lambda$70(mutableState, !ChatChannelScreen$lambda$69(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$17$6$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        ChatChannelScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        ChatChannelScreen$lambda$67(mutableState3, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$2$0(pe.m0 m0Var, LazyListState lazyListState, int i10) {
        pe.k.d(m0Var, null, null, new ChatChannelScreenKt$ChatChannelScreen$3$1$2$1$1(lazyListState, i10, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$10$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, SoftwareKeyboardController softwareKeyboardController, Context context, NavHostController navHostController, ChatParams chatParams, TextFieldState textFieldState, MutableState mutableState, State state, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions msg, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        kotlin.jvm.internal.y.i(msg, "msg");
        if (msg.getMessage().getState() == 4) {
            chatViewModel.tryResend(msg.getMessage().getId());
        } else if (ChatChannelScreen$selectedListIsEmpty(snapshotStateList)) {
            ChatChannelScreen$attachmentClicked(softwareKeyboardController, context, chatViewModel, navHostController, chatParams, textFieldState, mutableState, state, mutableState2, z10, messageAction, msg, i10);
        } else if (ChatChannelScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            ChatChannelScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            ChatChannelScreen$addItemToSelected(mutableState3, mutableState4, snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$11$0(SnapshotStateList snapshotStateList, ChatViewModel chatViewModel, MutableState mutableState, MutableState mutableState2, MessageWithPartnerWithReactions msg, int i10) {
        kotlin.jvm.internal.y.i(msg, "msg");
        if (ChatChannelScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            ChatChannelScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            ChatChannelScreen$addItemToSelected(mutableState, mutableState2, snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$12$0(ChatViewModel chatViewModel, Context context, TextFieldState textFieldState, MutableState mutableState, NavHostController navHostController, MessageWithPartnerWithReactions msg, MessageAction messageAction, String value) {
        Object next;
        String username;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        kotlin.jvm.internal.y.i(value, "value");
        int i10 = WhenMappings.$EnumSwitchMapping$0[messageAction.ordinal()];
        if (i10 == 1) {
            Iterator<T> it = msg.getMessage().getMessageEntities().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!kotlin.jvm.internal.y.d(((MessageEntity) next).getUrl(), value));
            MessageEntity mentionName = (MessageEntity) next;
            if (mentionName == null) {
                mentionName = new MentionName("", value, 0, 0, null);
            }
            ChatChannelScreen$handleClickOnMention(chatViewModel, mutableState, navHostController, mentionName);
        } else if (i10 == 3) {
            User senderUser = msg.getSenderUser();
            if (senderUser == null || (username = senderUser.getUsername()) == null) {
                username = "";
            }
            chatViewModel.requestUserByContact(value, value, username);
        } else if (i10 == 4) {
            IntentUtil.INSTANCE.showWeb(context, value);
        } else if (i10 == 5) {
            TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, value);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$13(final TextFieldState textFieldState, final ChatViewModel chatViewModel, State state, final State state2, final MutableState mutableState, Composer composer, int i10) {
        String strO;
        String strO2;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850787284, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:960)");
            }
            List<MentionItemModel> listChatChannelScreen$lambda$82 = ChatChannelScreen$lambda$82(state);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listChatChannelScreen$lambda$82) {
                MentionItemModel mentionItemModel = (MentionItemModel) obj;
                String toDusId = mentionItemModel.getToDusId();
                String str = (String) state2.getValue();
                String str2 = "";
                if (str == null || (strO = le.a0.O(str, "@", "", false, 4, null)) == null) {
                    strO = "";
                }
                if (!le.a0.S(toDusId, strO, true)) {
                    String displayName = mentionItemModel.getDisplayName();
                    String str3 = (String) state2.getValue();
                    if (str3 != null && (strO2 = le.a0.O(str3, "@", "", false, 4, null)) != null) {
                        str2 = strO2;
                    }
                    if (le.a0.S(displayName, str2, true)) {
                    }
                }
                arrayList.add(obj);
            }
            boolean zChanged = composer.changed(textFieldState) | composer.changedInstance(chatViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.n5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$13$1$0(textFieldState, state2, chatViewModel, mutableState, (MentionItemModel) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            MentionListKt.MentionList(null, arrayList, (Function1) objRememberedValue, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$13$1$0(TextFieldState textFieldState, State state, ChatViewModel chatViewModel, MutableState mutableState, MentionItemModel it) {
        kotlin.jvm.internal.y.i(it, "it");
        String string = textFieldState.getText().toString();
        String str = (String) state.getValue();
        if (str == null) {
            str = "";
        }
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, le.a0.O(string, str, "", false, 4, null) + " @" + it.getToDusId() + " ");
        chatViewModel.getActualMentionsToSend().add(it);
        ChatChannelScreen$lambda$85(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$14(final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1047733687, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:993)");
            }
            ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
            final PinnedMsg pinnedMessage = chatScreenStateChatChannelScreen$lambda$6 != null ? chatScreenStateChatChannelScreen$lambda$6.getPinnedMessage() : null;
            if (pinnedMessage == null) {
                composer.startReplaceGroup(-1506849032);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1506849031);
                String shortMsg = pinnedMessage.getShortMsg();
                boolean zChanged = composer.changed(pinnedMessage);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.d6
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$14$0$0$0(pinnedMessage, mutableState3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                boolean zChanged2 = composer.changed(state);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.f6
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$14$0$1$0(mutableState, state, mutableState2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                MsgPreviewKt.PinnedPreview(shortMsg, aVar, (lb.a) objRememberedValue2, composer, 0);
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
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$14$0$0$0(PinnedMsg pinnedMsg, MutableState mutableState) {
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.showReply(pinnedMsg.getMsgId());
        }
        ChatChannelScreen$lambda$89$0$goReply(mutableState, pinnedMsg.getPosition());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$14$0$1$0(MutableState mutableState, State state, MutableState mutableState2) {
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
        if (kotlin.jvm.internal.y.d(chatScreenStateChatChannelScreen$lambda$6 != null ? chatScreenStateChatChannelScreen$lambda$6.getAffiliation() : null, UserRoomJoin.AFFILIATION_OWNER)) {
            mutableState.setValue(Boolean.TRUE);
        }
        ChatChannelScreen$lambda$79(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$4$0(FocusRequester focusRequester, MutableState mutableState, SnapshotStateList snapshotStateList, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        ChatChannelScreen$clearSelection(snapshotStateList);
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$5$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, String roomId, String msgId, String value) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(value, "value");
        ChatChannelScreen$clearSelection(snapshotStateList);
        chatViewModel.onReacted(roomId, msgId, value);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$6$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.REACT_SELECTION, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$7$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$9$0(final ChatViewModel chatViewModel, final NavHostController navHostController, final String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.getStatusPosition(it, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.g7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$3$9$0$0(navHostController, chatViewModel, it, (Pair) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$3$9$0$0(NavHostController navHostController, ChatViewModel chatViewModel, String str, Pair result) {
        kotlin.jvm.internal.y.i(result, "result");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new StatusPreviewParams(((Boolean) result.getFirst()).booleanValue(), ((Number) result.getSecond()).intValue(), str));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$4$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
        String id2 = chatScreenStateChatChannelScreen$lambda$6 != null ? chatScreenStateChatChannelScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsAccepted(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$5$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
        String id2 = chatScreenStateChatChannelScreen$lambda$6 != null ? chatScreenStateChatChannelScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsAccepted(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$6$0(ChatViewModel chatViewModel, State state, final NavHostController navHostController) {
        ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
        String id2 = chatScreenStateChatChannelScreen$lambda$6 != null ? chatScreenStateChatChannelScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsRejected(id2, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.i6
            @Override // lb.a
            public final Object invoke() {
                return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$6$0$0(navHostController);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$6$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$7$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$0$8(final MutableState mutableState, ChatViewModel chatViewModel, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(246316507, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:1066)");
            }
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions == null) {
                composer.startReplaceGroup(-2083998079);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-2083998078);
                String nameWithDomain = chatViewModel.getOwner().getNameWithDomain();
                String alias = chatViewModel.getOwner().getAlias();
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$0$8$0$0$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                MsgPreviewKt.ReplyPreview(nameWithDomain, alias, messageWithPartnerWithReactions, (lb.a) objRememberedValue, composer, 3072);
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
    public static final ua.k0 ChatChannelScreen$lambda$89$0$8$0$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$0$9$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatChannelScreen$lambda$89$0$goReply(MutableState<Function1> mutableState, int i10) {
        Function1 function1ChatChannelScreen$lambda$12 = ChatChannelScreen$lambda$12(mutableState);
        if (function1ChatChannelScreen$lambda$12 != null) {
            function1ChatChannelScreen$lambda$12.invoke(Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$0$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$1$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.unPinMsgInGroup(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$10$0(ChatParams chatParams, MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, List files, String content) {
        Message message;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendImages(uid, files, content, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatChannelScreen$lambda$67(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$11$0(MutableState mutableState) {
        ChatChannelScreen$lambda$67(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$12$0(MutableState mutableState) {
        ChatChannelScreen$lambda$67(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$1$13(final MutableState mutableState, final ChatViewModel chatViewModel, final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2052148550, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:1372)");
            }
            AttachmentPreviewState attachmentPreviewStateChatChannelScreen$lambda$31 = ChatChannelScreen$lambda$31(mutableState);
            if (attachmentPreviewStateChatChannelScreen$lambda$31 == null) {
                composer.startReplaceGroup(-992902172);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-992902171);
                boolean zChangedInstance = composer.changedInstance(chatViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.r6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$13$0$0$0(chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.s6
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$13$0$1$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar = (lb.a) objRememberedValue2;
                boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.t6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatChannelScreenKt.ChatChannelScreen$lambda$89$1$13$0$2$0(navHostController, chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                AttachmentPreviewKt.AttachmentPreviewWithOptions(attachmentPreviewStateChatChannelScreen$lambda$31, function1, aVar, (Function1) objRememberedValue3, null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 16);
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
    public static final ua.k0 ChatChannelScreen$lambda$89$1$13$0$0$0(ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.share(va.v.e(it));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$13$0$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$13$0$2$0(NavHostController navHostController, ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(it));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$14$0(MutableState mutableState) {
        mutableState.setValue("");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatChannelScreen$lambda$89$1$15(NavHostController navHostController, MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1187219421, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreen.<anonymous>.<anonymous>.<anonymous> (ChatChannelScreen.kt:1397)");
            }
            MsgDetailsDialogKt.MsgDetailsDialog(ChatChannelScreen$lambda$73(mutableState), navHostController, null, composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$16$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatChannelScreen$lambda$16(mutableState), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$17$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatChannelScreen$lambda$16(mutableState), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$18$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatChannelScreen$lambda$16(mutableState), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$19$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatChannelScreen$lambda$16(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatChannelScreen$lambda$16(mutableState), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$2$0(ChatViewModel chatViewModel) {
        chatViewModel.readRequestingFriend();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$3$0(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$4$0(MutableState mutableState) {
        ChatChannelScreen$lambda$64(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$7$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$8$0(TextFieldState textFieldState, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, String value, boolean z10) {
        kotlin.jvm.internal.y.i(value, "value");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, value);
        mutableState.setValue(null);
        if (z10) {
            ChatViewModel.sendMessage$default(chatViewModel, textFieldState.getText().toString(), chatParams.getUid(), false, null, null, null, null, 124, null);
            TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, "");
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$1$9$0(ChatParams chatParams, MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, List files, String content) {
        Message message;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendVideos(uid, files, content, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatChannelScreen$lambda$67(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$89$2$0(SnapshotStateList snapshotStateList) {
        ChatChannelScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ChatChannelScreen$lambda$89$5$0(final ChatViewModel chatViewModel, final TextFieldState textFieldState, final ChatParams chatParams, final ChatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1 chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.ChatChannelScreenKt$ChatChannelScreen$lambda$89$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                chatViewModel.setRoomDraft(textFieldState.getText().toString(), chatParams.getUid());
                chatViewModel.stopRecorder();
                chatViewModel.getNotificationManager().unRegister(chatChannelScreenKt$ChatChannelScreen$notificationFilter$1$1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 ChatChannelScreen$lambda$9(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$lambda$90(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        ChatChannelScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    private static final boolean ChatChannelScreen$listIsDeletableInChannel(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, State<ChatScreenState> state) {
        List<String> rights;
        boolean z10 = true;
        for (MessageWithPartnerWithReactions messageWithPartnerWithReactions : snapshotStateList) {
            if (messageWithPartnerWithReactions.getMessage().getContent().length() == 0 || le.d0.q0(messageWithPartnerWithReactions.getMessage().getContent()) || !messageWithPartnerWithReactions.available()) {
                z10 = false;
            }
        }
        if (z10) {
            ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
            if ((chatScreenStateChatChannelScreen$lambda$6 == null || (rights = chatScreenStateChatChannelScreen$lambda$6.getRights()) == null) ? false : rights.contains("dom")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    private static final boolean ChatChannelScreen$listIsEditableInChannel(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, State<ChatScreenState> state) {
        boolean z10;
        List<String> rights;
        boolean z11;
        boolean z12;
        boolean z13 = snapshotStateList.size() == 1;
        for (MessageWithPartnerWithReactions messageWithPartnerWithReactions : snapshotStateList) {
            if (messageWithPartnerWithReactions.getMessage().getContent().length() == 0 || le.d0.q0(messageWithPartnerWithReactions.getMessage().getContent())) {
                z13 = false;
            }
            if (!messageWithPartnerWithReactions.available()) {
                z13 = false;
            }
            if (z13) {
                break;
            }
        }
        if (z13) {
            if (snapshotStateList.isEmpty()) {
                z12 = true;
                break;
            }
            Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z12 = true;
                    break;
                }
                List<Attachment> attachments = it.next().getAttachments();
                if (!defpackage.r.a(attachments) || !attachments.isEmpty()) {
                    Iterator<T> it2 = attachments.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z11 = false;
                            break;
                        }
                        if (((Attachment) it2.next()).getType() == 14) {
                            z11 = true;
                            break;
                        }
                    }
                } else {
                    z11 = false;
                    break;
                    break;
                }
                if (z11) {
                    z12 = false;
                    break;
                }
            }
            if (z12) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        if (z10) {
            ChatScreenState chatScreenStateChatChannelScreen$lambda$6 = ChatChannelScreen$lambda$6(state);
            if ((chatScreenStateChatChannelScreen$lambda$6 == null || (rights = chatScreenStateChatChannelScreen$lambda$6.getRights()) == null || !rights.contains("eom")) ? false : true) {
                return true;
            }
        }
        return false;
    }

    private static final boolean ChatChannelScreen$listIsForwardable(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        boolean z10;
        boolean z11;
        if (defpackage.r.a(snapshotStateList) && snapshotStateList.isEmpty()) {
            z10 = false;
            break;
        }
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        loop2: while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            List<Attachment> attachments = it.next().getAttachments();
            if (!defpackage.r.a(attachments) || !attachments.isEmpty()) {
                Iterator<T> it2 = attachments.iterator();
                while (it2.hasNext()) {
                    if (((Attachment) it2.next()).getType() == 16) {
                        z10 = true;
                        break loop2;
                    }
                }
            }
        }
        if (defpackage.r.a(snapshotStateList) && snapshotStateList.isEmpty()) {
            z11 = false;
            break;
        }
        Iterator<MessageWithPartnerWithReactions> it3 = snapshotStateList.iterator();
        loop0: while (true) {
            if (!it3.hasNext()) {
                z11 = false;
                break;
            }
            List<Attachment> attachments2 = it3.next().getAttachments();
            if (!defpackage.r.a(attachments2) || !attachments2.isEmpty()) {
                for (Attachment attachment : attachments2) {
                    if (attachment.getState() != 2 && attachment.getState() != 6) {
                        z11 = true;
                        break loop0;
                    }
                }
            }
        }
        return (z10 || z11) ? false : true;
    }

    private static final void ChatChannelScreen$onClickInShortcut(Context context, final ChatViewModel chatViewModel, final ChatParams chatParams, final NavHostController navHostController, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, ButtonContent buttonContent) {
        ChatButtonsFunctionality.INSTANCE.handleClick(buttonContent, context, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.s5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatChannelScreenKt.ChatChannelScreen$onClickInShortcut$lambda$27(chatViewModel, chatParams, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.u5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatChannelScreenKt.ChatChannelScreen$onClickInShortcut$lambda$28(navHostController, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.v5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatChannelScreenKt.ChatChannelScreen$onClickInShortcut$lambda$29(textFieldState, (String) obj);
            }
        }, new ChatChannelScreenKt$ChatChannelScreen$onClickInShortcut$4(mutableState), (64 & 64) != 0 ? new Function1() { // from class: q7.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatButtonsFunctionality.handleClick$lambda$0((BotShortcut) obj);
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$onClickInShortcut$lambda$27(ChatViewModel chatViewModel, ChatParams chatParams, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatViewModel.sendMessage$default(chatViewModel, it, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$onClickInShortcut$lambda$28(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$onClickInShortcut$lambda$29(TextFieldState textFieldState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatChannelScreen$onDeleteToAll(ChatViewModel chatViewModel, ChatParams chatParams, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteForAll(chatParams.getUid(), ChatChannelScreen$clearSelection(snapshotStateList));
    }

    private static final void ChatChannelScreen$removeAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Uri uri) {
        if (snapshotStateList.size() == 1) {
            ChatChannelScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        } else {
            snapshotStateList.remove(uri);
        }
    }

    private static final void ChatChannelScreen$removeItemFromSelected(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, final String str) {
        final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.g6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ChatChannelScreenKt.ChatChannelScreen$removeItemFromSelected$lambda$52(str, (MessageWithPartnerWithReactions) obj));
            }
        };
        Collection.EL.removeIf(snapshotStateList, new Predicate() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.h6
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
                return ChatChannelScreenKt.ChatChannelScreen$removeItemFromSelected$lambda$53(function1, obj);
            }
        });
        ArrayList arrayList = new ArrayList(va.x.y(snapshotStateList, 10));
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMessage().getId());
        }
        chatViewModel.allMsgsAreMine(va.g0.o1(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatChannelScreen$removeItemFromSelected$lambda$52(String str, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getMessage().getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatChannelScreen$removeItemFromSelected$lambda$53(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private static final void ChatChannelScreen$selectMapLocation(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState) {
        Message message;
        NavLinks navLinks = NavLinks.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        MapMotive mapMotive = MapMotive.SELECT;
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        String strT = gson.t(new MapParams(mapMotive, uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId(), null, 8, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goMap(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    private static final void ChatChannelScreen$selectMethodAndSend(ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState, ChatViewModel chatViewModel, Context context, final SnapshotStateList<Uri> snapshotStateList, final MutableState<Boolean> mutableState2, final MutableState<Boolean> mutableState3, String str) {
        Message message;
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        chatComplexFunctionalities.selectMethodAndSend(str, uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId(), context, snapshotStateList, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.q3
            @Override // lb.a
            public final Object invoke() {
                return ChatChannelScreenKt.ChatChannelScreen$selectMethodAndSend$lambda$41(snapshotStateList, mutableState2, mutableState3);
            }
        }, new ChatChannelScreenKt$ChatChannelScreen$selectMethodAndSend$1(chatViewModel), new ChatChannelScreenKt$ChatChannelScreen$selectMethodAndSend$2(chatViewModel), new ChatChannelScreenKt$ChatChannelScreen$selectMethodAndSend$3(chatViewModel), new ChatChannelScreenKt$ChatChannelScreen$selectMethodAndSend$4(chatViewModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatChannelScreen$selectMethodAndSend$lambda$41(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatChannelScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x002a A[RETURN] */
    public static final boolean ChatChannelScreen$selectedContains(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, String str) {
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.y.d(it.next().getMessage().getId(), str)) {
                if (i10 != -1) {
                    return true;
                }
                return false;
            }
            i10++;
        }
        i10 = -1;
        if (i10 != -1) {
            return true;
        }
        return false;
    }

    private static final boolean ChatChannelScreen$selectedListIsEmpty(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        return snapshotStateList.toList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatChannelScreen$setPlaceholderData(MutableState<PagerDialogData> mutableState, String str, ButtonTemplate buttonTemplate, boolean z10) {
        mutableState.setValue(new PagerDialogData(str, buttonTemplate, z10, null, 8, null));
    }
}
