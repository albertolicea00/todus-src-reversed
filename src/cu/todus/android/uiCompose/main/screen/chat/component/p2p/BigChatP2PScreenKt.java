package cu.todus.android.uiCompose.main.screen.chat.component.p2p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.camera.video.VideoSpec;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p000activity.compose.ActivityResultRegistryKt;
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
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.ButtonTemplate;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.messageentity.MentionName;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.notification.ConfigProcessor;
import cu.todus.android.notification.INotificationFilter;
import cu.todus.android.uiCompose.call.CallActivity;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewKt;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewState;
import cu.todus.android.uiCompose.main.screen.chat.attachmentSelector.AttachmentSelectorKt;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatScreenState;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialogKt;
import cu.todus.android.uiCompose.main.screen.chat.functionalities.ChatButtonsFunctionality;
import cu.todus.android.uiCompose.main.screen.chat.functionalities.ChatComplexFunctionalities;
import cu.todus.android.uiCompose.main.screen.chat.input.ChatInputKt;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialogData;
import cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt;
import cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt;
import cu.todus.android.uiCompose.main.screen.chat.stickers.GroupsContainerKt;
import cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBarKt;
import cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorParams;
import cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersParams;
import cu.todus.android.uiCompose.main.screen.map.MapMotive;
import cu.todus.android.uiCompose.main.screen.map.MapParams;
import cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.animations.attach.AttachContainerKt;
import cu.todus.android.utils.ContactUtil;
import cu.todus.android.utils.IntentUtil;
import cu.z17.singledi.SinglediException;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006&²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\nX\u008a\u0084\u0002²\u0006\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0015\u001a\u00020\u00148\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0018\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00198\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001f\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010 \u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010!\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\"\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010#\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\f\u0010$\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\f\u0010%\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;", "viewModel", "Lua/k0;", "BigChatP2PScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "chatScreenState", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/data/db/pojo/Friend;", "requestedFriendByContact", "Lkotlin/Function1;", "scrollBottom", "", "scrollToPosition", "", "actualRecorderTime", "Lcu/z17/views/permission/PermissionsRequesterState;", "mediaPermissionsState", "callPermissionsState", "Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogData;", "createPlaceholderMsg", "Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "attachmentPreview", "showAttachmentSelector", "isPickingFiles", "showDeleteForEveryone", "showDeleteDialog", "openCamera", "showStickers", "msgDetailId", "showUnknown", "firstItemVisible", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BigChatP2PScreenKt {

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

    /* JADX WARN: Code duplicated, block: B:102:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:105:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:108:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:111:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:114:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:117:0x030f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0326  */
    /* JADX WARN: Code duplicated, block: B:123:0x033b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0359  */
    /* JADX WARN: Code duplicated, block: B:133:0x0381  */
    /* JADX WARN: Code duplicated, block: B:136:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:139:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:140:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:143:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:146:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:151:0x0436  */
    /* JADX WARN: Code duplicated, block: B:154:0x044e  */
    /* JADX WARN: Code duplicated, block: B:157:0x0464  */
    /* JADX WARN: Code duplicated, block: B:160:0x0505  */
    /* JADX WARN: Code duplicated, block: B:166:0x0523 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:63:0x0116  */
    /* JADX WARN: Code duplicated, block: B:66:0x012d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0165  */
    /* JADX WARN: Code duplicated, block: B:77:0x016e  */
    /* JADX WARN: Code duplicated, block: B:82:0x0187  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:91:0x020d  */
    /* JADX WARN: Code duplicated, block: B:94:0x023f  */
    /* JADX WARN: Code duplicated, block: B:97:0x027a  */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39, types: [ab.i, androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v46 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"CoroutineCreationDuringComposition"})
    public static final void BigChatP2PScreen(final NavHostController navHostController, final String params, ChatViewModel chatViewModel, Composer composer, final int i10, final int i11) {
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
        Object objRememberedValue4;
        final ChatViewModel chatViewModel5;
        Composer composer3;
        final State stateCollectAsStateWithLifecycle;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Object objRememberedValue8;
        Object objRememberedValue9;
        final TextFieldState textFieldStateM2202rememberTextFieldStateLepunE;
        boolean zChanged;
        Object objRememberedValue10;
        Object objRememberedValue11;
        Object objRememberedValue12;
        final MutableState mutableState2;
        Object objRememberedValue13;
        Object objRememberedValue14;
        Object objRememberedValue15;
        Object objRememberedValue16;
        final MutableState mutableState3;
        Object objRememberedValue17;
        final SnapshotStateList snapshotStateList;
        boolean zChangedInstance;
        Object objRememberedValue18;
        boolean zChangedInstance2;
        Object objRememberedValue19;
        Object objRememberedValue20;
        Object objRememberedValue21;
        ?? r10;
        Object objRememberedValue22;
        Object objRememberedValue23;
        boolean zChangedInstance3;
        Object objRememberedValue24;
        Object objRememberedValue25;
        Object objRememberedValue26;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(2082903454);
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
                    ComposerKt.traceEventStart(2082903454, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen (BigChatP2PScreen.kt:131)");
                }
                scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, r6);
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
                    function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$4(navHostController, str2, chatViewModel6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                } else {
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new INotificationFilter() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1
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
                    final BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1 bigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1 = (BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1) objRememberedValue4;
                    chatViewModel5 = chatViewModel4;
                    composer3 = composer2;
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(chatViewModel4.getChatScreenState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
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
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO, PermissionNeedIt.CALLS), 1, null), null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableState mutableState7 = (MutableState) objRememberedValue8;
                    objRememberedValue9 = composer3.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new FocusRequester();
                        composer3.updateRememberedValue(objRememberedValue9);
                    }
                    final FocusRequester focusRequester = (FocusRequester) objRememberedValue9;
                    textFieldStateM2202rememberTextFieldStateLepunE = TextFieldStateKt.m2202rememberTextFieldStateLepunE(null, 0L, composer3, 0, 3);
                    zChanged = composer3.changed(textFieldStateM2202rememberTextFieldStateLepunE) | composer3.changedInstance(chatViewModel5);
                    objRememberedValue10 = composer3.rememberedValue();
                    if (zChanged || objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new BigChatP2PScreenKt$BigChatP2PScreen$2$1(textFieldStateM2202rememberTextFieldStateLepunE, chatViewModel5, null);
                        composer3.updateRememberedValue(objRememberedValue10);
                    }
                    EffectsKt.LaunchedEffect(textFieldStateM2202rememberTextFieldStateLepunE, (Function2) objRememberedValue10, composer3, 0);
                    objRememberedValue11 = composer3.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue11);
                    }
                    final MutableState mutableState8 = (MutableState) objRememberedValue11;
                    objRememberedValue12 = composer3.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue12);
                    }
                    mutableState2 = (MutableState) objRememberedValue12;
                    objRememberedValue13 = composer3.rememberedValue();
                    if (objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue13);
                    }
                    final MutableState mutableState9 = (MutableState) objRememberedValue13;
                    objRememberedValue14 = composer3.rememberedValue();
                    if (objRememberedValue14 == companion.getEmpty()) {
                        objRememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue14);
                    }
                    final MutableState mutableState10 = (MutableState) objRememberedValue14;
                    objRememberedValue15 = composer3.rememberedValue();
                    if (objRememberedValue15 == companion.getEmpty()) {
                        objRememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue15);
                    }
                    final MutableState mutableState11 = (MutableState) objRememberedValue15;
                    objRememberedValue16 = composer3.rememberedValue();
                    if (objRememberedValue16 == companion.getEmpty()) {
                        objRememberedValue16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue16);
                    }
                    mutableState3 = (MutableState) objRememberedValue16;
                    objRememberedValue17 = composer3.rememberedValue();
                    if (objRememberedValue17 == companion.getEmpty()) {
                        objRememberedValue17 = SnapshotStateKt.mutableStateListOf();
                        composer3.updateRememberedValue(objRememberedValue17);
                    }
                    snapshotStateList = (SnapshotStateList) objRememberedValue17;
                    ActivityResultContracts.GetContent getContent = new ActivityResultContracts.GetContent();
                    zChangedInstance = composer3.changedInstance(context);
                    objRememberedValue18 = composer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue18 == companion.getEmpty()) {
                        objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BigChatP2PScreenKt.BigChatP2PScreen$lambda$43$0(context, mutableState3, snapshotStateList, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue18);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent, (Function1) objRememberedValue18, composer3, 0);
                    ActivityResultContracts.PickContact pickContact = new ActivityResultContracts.PickContact();
                    zChangedInstance2 = composer3.changedInstance(context) | composer3.changedInstance(chatViewModel5);
                    objRememberedValue19 = composer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue19 == companion.getEmpty()) {
                        objRememberedValue19 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.d1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BigChatP2PScreenKt.BigChatP2PScreen$lambda$48$0(context, chatViewModel5, chatParams, mutableState2, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue19);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(pickContact, (Function1) objRememberedValue19, composer3, 0);
                    final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getAllMsgsAreMine(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                    objRememberedValue20 = composer3.rememberedValue();
                    if (objRememberedValue20 == companion.getEmpty()) {
                        objRememberedValue20 = SnapshotStateKt.mutableStateListOf();
                        composer3.updateRememberedValue(objRememberedValue20);
                    }
                    final SnapshotStateList snapshotStateList2 = (SnapshotStateList) objRememberedValue20;
                    objRememberedValue21 = composer3.rememberedValue();
                    if (objRememberedValue21 == companion.getEmpty()) {
                        r10 = 0;
                        objRememberedValue21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue21);
                    } else {
                        r10 = 0;
                    }
                    final MutableState mutableState12 = (MutableState) objRememberedValue21;
                    objRememberedValue22 = composer3.rememberedValue();
                    if (objRememberedValue22 == companion.getEmpty()) {
                        objRememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, r10, 2, r10);
                        composer3.updateRememberedValue(objRememberedValue22);
                    }
                    final MutableState mutableState13 = (MutableState) objRememberedValue22;
                    objRememberedValue23 = composer3.rememberedValue();
                    if (objRememberedValue23 == companion.getEmpty()) {
                        objRememberedValue23 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, r10, 2, r10);
                        composer3.updateRememberedValue(objRememberedValue23);
                    }
                    final MutableState mutableState14 = (MutableState) objRememberedValue23;
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getRecentStickers(), r10, composer3, 0, 1);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems3 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getFavoriteStickers(), r10, composer3, 0, 1);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems4 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getAllStickers(), r10, composer3, 0, 1);
                    ActivityResultContracts.GetContent getContent2 = new ActivityResultContracts.GetContent();
                    zChangedInstance3 = composer3.changedInstance(chatViewModel5) | composer3.changedInstance(context) | composer3.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue24 = composer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue24 == companion.getEmpty()) {
                        objRememberedValue24 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.e1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BigChatP2PScreenKt.BigChatP2PScreen$lambda$70$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue24);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult3 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent2, (Function1) objRememberedValue24, composer3, 0);
                    objRememberedValue25 = composer3.rememberedValue();
                    if (objRememberedValue25 == companion.getEmpty()) {
                        objRememberedValue25 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue25);
                    }
                    final MutableState mutableState15 = (MutableState) objRememberedValue25;
                    objRememberedValue26 = composer3.rememberedValue();
                    if (objRememberedValue26 == companion.getEmpty()) {
                        objRememberedValue26 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.f1
                            @Override // lb.a
                            public final Object invoke() {
                                return Boolean.valueOf(BigChatP2PScreenKt.BigChatP2PScreen$lambda$74$0(stateCollectAsStateWithLifecycle));
                            }
                        });
                        composer3.updateRememberedValue(objRememberedValue26);
                    }
                    final State state = (State) objRememberedValue26;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(998351082, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76(mutableState10, mutableState15, mutableState13, navHostController, snapshotStateList2, chatViewModel5, textFieldStateM2202rememberTextFieldStateLepunE, softwareKeyboardController, context, managedActivityResultLauncherRememberLauncherForActivityResult3, stateCollectAsStateWithLifecycle, mutableState8, mutableState12, mutableState2, mutableState6, chatParams, mutableState7, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer3, 54);
                    Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.h1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77(snapshotStateList2, chatViewModel5, stateCollectAsStateWithLifecycle, textFieldStateM2202rememberTextFieldStateLepunE, chatParams, m0Var, mutableState2, mutableState8, snapshotStateList, mutableState4, mutableState5, lazyPagingItemsCollectAsLazyPagingItems, navHostController, softwareKeyboardController, context, focusRequester, mutableState9, mutableState10, mutableState, state, mutableState3, mutableState11, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState6, managedActivityResultLauncherRememberLauncherForActivityResult2, mutableState14, lazyPagingItemsCollectAsLazyPagingItems2, lazyPagingItemsCollectAsLazyPagingItems3, lazyPagingItemsCollectAsLazyPagingItems4, stateCollectAsStateWithLifecycle3, mutableState13, stateCollectAsStateWithLifecycle2, mutableState12, stateCollectAsStateWithLifecycle4, mutableState15, mutableState7, bigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    composerStartRestartGroup = composer3;
                    Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-687616472, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
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
                ComposerKt.traceEventStart(2082903454, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen (BigChatP2PScreen.kt:131)");
            }
            scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, r6);
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
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new INotificationFilter() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1
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
                final BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1 bigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$2 = (BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1) objRememberedValue4;
                chatViewModel5 = chatViewModel4;
                composer3 = composer2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(chatViewModel4.getChatScreenState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getRequestingFriend(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems5 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.chatMsgs(chatParams.getUid()), null, composer3, 0, 1);
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState16 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState17 = (MutableState) objRememberedValue6;
                final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getRecordingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                objRememberedValue7 = composer3.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA), 1, null), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                final MutableState mutableState18 = (MutableState) objRememberedValue7;
                objRememberedValue8 = composer3.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO, PermissionNeedIt.CALLS), 1, null), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                final MutableState mutableState19 = (MutableState) objRememberedValue8;
                objRememberedValue9 = composer3.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new FocusRequester();
                    composer3.updateRememberedValue(objRememberedValue9);
                }
                final FocusRequester focusRequester2 = (FocusRequester) objRememberedValue9;
                textFieldStateM2202rememberTextFieldStateLepunE = TextFieldStateKt.m2202rememberTextFieldStateLepunE(null, 0L, composer3, 0, 3);
                zChanged = composer3.changed(textFieldStateM2202rememberTextFieldStateLepunE) | composer3.changedInstance(chatViewModel5);
                objRememberedValue10 = composer3.rememberedValue();
                if (zChanged) {
                    objRememberedValue10 = new BigChatP2PScreenKt$BigChatP2PScreen$2$1(textFieldStateM2202rememberTextFieldStateLepunE, chatViewModel5, null);
                    composer3.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new BigChatP2PScreenKt$BigChatP2PScreen$2$1(textFieldStateM2202rememberTextFieldStateLepunE, chatViewModel5, null);
                    composer3.updateRememberedValue(objRememberedValue10);
                }
                EffectsKt.LaunchedEffect(textFieldStateM2202rememberTextFieldStateLepunE, (Function2) objRememberedValue10, composer3, 0);
                objRememberedValue11 = composer3.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                final MutableState mutableState20 = (MutableState) objRememberedValue11;
                objRememberedValue12 = composer3.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue12);
                }
                mutableState2 = (MutableState) objRememberedValue12;
                objRememberedValue13 = composer3.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue13);
                }
                final MutableState mutableState21 = (MutableState) objRememberedValue13;
                objRememberedValue14 = composer3.rememberedValue();
                if (objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue14);
                }
                final MutableState mutableState110 = (MutableState) objRememberedValue14;
                objRememberedValue15 = composer3.rememberedValue();
                if (objRememberedValue15 == companion.getEmpty()) {
                    objRememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue15);
                }
                final MutableState mutableState111 = (MutableState) objRememberedValue15;
                objRememberedValue16 = composer3.rememberedValue();
                if (objRememberedValue16 == companion.getEmpty()) {
                    objRememberedValue16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue16);
                }
                mutableState3 = (MutableState) objRememberedValue16;
                objRememberedValue17 = composer3.rememberedValue();
                if (objRememberedValue17 == companion.getEmpty()) {
                    objRememberedValue17 = SnapshotStateKt.mutableStateListOf();
                    composer3.updateRememberedValue(objRememberedValue17);
                }
                snapshotStateList = (SnapshotStateList) objRememberedValue17;
                ActivityResultContracts.GetContent getContent3 = new ActivityResultContracts.GetContent();
                zChangedInstance = composer3.changedInstance(context);
                objRememberedValue18 = composer3.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$43$0(context, mutableState3, snapshotStateList, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue18);
                } else {
                    objRememberedValue18 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$43$0(context, mutableState3, snapshotStateList, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue18);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult4 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent3, (Function1) objRememberedValue18, composer3, 0);
                ActivityResultContracts.PickContact pickContact2 = new ActivityResultContracts.PickContact();
                zChangedInstance2 = composer3.changedInstance(context) | composer3.changedInstance(chatViewModel5);
                objRememberedValue19 = composer3.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue19 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.d1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$48$0(context, chatViewModel5, chatParams, mutableState2, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue19);
                } else {
                    objRememberedValue19 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.d1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$48$0(context, chatViewModel5, chatParams, mutableState2, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue19);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult5 = ActivityResultRegistryKt.rememberLauncherForActivityResult(pickContact2, (Function1) objRememberedValue19, composer3, 0);
                final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getAllMsgsAreMine(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                objRememberedValue20 = composer3.rememberedValue();
                if (objRememberedValue20 == companion.getEmpty()) {
                    objRememberedValue20 = SnapshotStateKt.mutableStateListOf();
                    composer3.updateRememberedValue(objRememberedValue20);
                }
                final SnapshotStateList snapshotStateList3 = (SnapshotStateList) objRememberedValue20;
                objRememberedValue21 = composer3.rememberedValue();
                if (objRememberedValue21 == companion.getEmpty()) {
                    r10 = 0;
                    objRememberedValue21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue21);
                } else {
                    r10 = 0;
                }
                final MutableState mutableState112 = (MutableState) objRememberedValue21;
                objRememberedValue22 = composer3.rememberedValue();
                if (objRememberedValue22 == companion.getEmpty()) {
                    objRememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, r10, 2, r10);
                    composer3.updateRememberedValue(objRememberedValue22);
                }
                final MutableState mutableState113 = (MutableState) objRememberedValue22;
                objRememberedValue23 = composer3.rememberedValue();
                if (objRememberedValue23 == companion.getEmpty()) {
                    objRememberedValue23 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, r10, 2, r10);
                    composer3.updateRememberedValue(objRememberedValue23);
                }
                final MutableState mutableState114 = (MutableState) objRememberedValue23;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems6 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getRecentStickers(), r10, composer3, 0, 1);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems7 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getFavoriteStickers(), r10, composer3, 0, 1);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems8 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getAllStickers(), r10, composer3, 0, 1);
                ActivityResultContracts.GetContent getContent4 = new ActivityResultContracts.GetContent();
                zChangedInstance3 = composer3.changedInstance(chatViewModel5) | composer3.changedInstance(context) | composer3.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue24 = composer3.rememberedValue();
                if (zChangedInstance3) {
                    objRememberedValue24 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.e1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$70$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue24);
                } else {
                    objRememberedValue24 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.e1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$70$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue24);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult6 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent4, (Function1) objRememberedValue24, composer3, 0);
                objRememberedValue25 = composer3.rememberedValue();
                if (objRememberedValue25 == companion.getEmpty()) {
                    objRememberedValue25 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue25);
                }
                final MutableState mutableState115 = (MutableState) objRememberedValue25;
                objRememberedValue26 = composer3.rememberedValue();
                if (objRememberedValue26 == companion.getEmpty()) {
                    objRememberedValue26 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.f1
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(BigChatP2PScreenKt.BigChatP2PScreen$lambda$74$0(stateCollectAsStateWithLifecycle));
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue26);
                }
                final State state2 = (State) objRememberedValue26;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(998351082, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76(mutableState110, mutableState115, mutableState113, navHostController, snapshotStateList3, chatViewModel5, textFieldStateM2202rememberTextFieldStateLepunE, softwareKeyboardController, context, managedActivityResultLauncherRememberLauncherForActivityResult6, stateCollectAsStateWithLifecycle, mutableState20, mutableState112, mutableState2, mutableState18, chatParams, mutableState19, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54);
                Function3 function4 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.h1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77(snapshotStateList3, chatViewModel5, stateCollectAsStateWithLifecycle, textFieldStateM2202rememberTextFieldStateLepunE, chatParams, m0Var, mutableState2, mutableState20, snapshotStateList, mutableState16, mutableState17, lazyPagingItemsCollectAsLazyPagingItems5, navHostController, softwareKeyboardController, context, focusRequester2, mutableState21, mutableState110, mutableState, state2, mutableState3, mutableState111, managedActivityResultLauncherRememberLauncherForActivityResult4, mutableState18, managedActivityResultLauncherRememberLauncherForActivityResult5, mutableState114, lazyPagingItemsCollectAsLazyPagingItems6, lazyPagingItemsCollectAsLazyPagingItems7, lazyPagingItemsCollectAsLazyPagingItems8, stateCollectAsStateWithLifecycle6, mutableState113, stateCollectAsStateWithLifecycle5, mutableState112, stateCollectAsStateWithLifecycle7, mutableState115, mutableState19, bigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                composerStartRestartGroup = composer3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda2, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-687616472, true, function4, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
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
                function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$4(navHostController, str3, chatViewModel7, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
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
            function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigChatP2PScreenKt.BigChatP2PScreen$lambda$78(navHostController, params, chatViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final void BigChatP2PScreen$addAttachedFileToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, Uri uri) {
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
        BigChatP2PScreen$lambda$39(mutableState, true);
    }

    private static final void BigChatP2PScreen$addItemToSelected(MutableState<MessageWithPartnerWithReactions> mutableState, MutableState<MessageWithPartnerWithReactions> mutableState2, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
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

    private static final void BigChatP2PScreen$attachmentClicked(SoftwareKeyboardController softwareKeyboardController, Context context, final ChatViewModel chatViewModel, final NavHostController navHostController, final ChatParams chatParams, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, State<ChatScreenState> state, final MutableState<AttachmentPreviewState> mutableState2, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions messageWithPartnerWithReactions, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.q2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigChatP2PScreenKt.BigChatP2PScreen$attachmentClicked$lambda$44(navHostController, (String) obj);
            }
        };
        BigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$2 bigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$2 = new BigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$2(chatViewModel);
        BigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$3 bigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$3 = new BigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$3(chatViewModel);
        BigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$4 bigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$4 = new BigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$4(chatViewModel);
        Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.r2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigChatP2PScreenKt.BigChatP2PScreen$attachmentClicked$lambda$45(chatViewModel, chatParams, (String) obj);
            }
        };
        Function1 function3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.t2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigChatP2PScreenKt.BigChatP2PScreen$attachmentClicked$lambda$46(textFieldState, (String) obj);
            }
        };
        BigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$7 bigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$7 = new BigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$7(mutableState);
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
        chatComplexFunctionalities.attachmentClicked(messageAction, i10, z10, messageWithPartnerWithReactions, context, gson, function1, bigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$2, bigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$3, bigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$4, function2, function3, bigChatP2PScreenKt$BigChatP2PScreen$attachmentClicked$7, chatScreenStateBigChatP2PScreen$lambda$6 != null ? chatScreenStateBigChatP2PScreen$lambda$6.isSecret() : false, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.u2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigChatP2PScreenKt.BigChatP2PScreen$attachmentClicked$lambda$47(mutableState2, (AttachmentPreviewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$attachmentClicked$lambda$44(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$attachmentClicked$lambda$45(ChatViewModel chatViewModel, ChatParams chatParams, String msgContent) {
        kotlin.jvm.internal.y.i(msgContent, "msgContent");
        ChatViewModel.sendMessage$default(chatViewModel, msgContent, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$attachmentClicked$lambda$46(TextFieldState textFieldState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$attachmentClicked$lambda$47(MutableState mutableState, AttachmentPreviewState it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    private static final void BigChatP2PScreen$clearAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        snapshotStateList.clear();
        BigChatP2PScreen$lambda$39(mutableState, false);
        BigChatP2PScreen$lambda$36(mutableState2, false);
    }

    private static final List<String> BigChatP2PScreen$clearSelection(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        List<MessageWithPartnerWithReactions> list = snapshotStateList.toList();
        snapshotStateList.clear();
        ArrayList arrayList = new ArrayList(va.x.y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MessageWithPartnerWithReactions) it.next()).getMessage().getId());
        }
        return arrayList;
    }

    private static final void BigChatP2PScreen$createAndSendDate(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState) {
        Message message;
        NavLinks navLinks = NavLinks.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        String strT = gson.t(new DateEditorParams(uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId()));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goDateEditor(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    private static final void BigChatP2PScreen$handleClickOnMention(ChatViewModel chatViewModel, final MutableState<Boolean> mutableState, final NavHostController navHostController, MessageEntity messageEntity) {
        BigChatP2PScreen$lambda$2(mutableState, true);
        if (messageEntity instanceof MentionName) {
            chatViewModel.goChatByMention((MentionName) messageEntity, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BigChatP2PScreenKt.BigChatP2PScreen$handleClickOnMention$lambda$68(navHostController, mutableState, (String) obj);
                }
            }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.f
                @Override // lb.a
                public final Object invoke() {
                    return BigChatP2PScreenKt.BigChatP2PScreen$handleClickOnMention$lambda$69(mutableState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$handleClickOnMention$lambda$68(NavHostController navHostController, MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        BigChatP2PScreen$lambda$2(mutableState, false);
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$handleClickOnMention$lambda$69(MutableState mutableState) {
        BigChatP2PScreen$lambda$2(mutableState, false);
        return ua.k0.f43947a;
    }

    private static final boolean BigChatP2PScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final Function1 BigChatP2PScreen$lambda$12(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final long BigChatP2PScreen$lambda$14(State<Long> state) {
        return state.getValue().longValue();
    }

    private static final PermissionsRequesterState BigChatP2PScreen$lambda$16(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    private static final PermissionsRequesterState BigChatP2PScreen$lambda$19(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    private static final void BigChatP2PScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final PagerDialogData BigChatP2PScreen$lambda$26(MutableState<PagerDialogData> mutableState) {
        return mutableState.getValue();
    }

    private static final AttachmentPreviewState BigChatP2PScreen$lambda$32(MutableState<AttachmentPreviewState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean BigChatP2PScreen$lambda$35(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigChatP2PScreen$lambda$36(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean BigChatP2PScreen$lambda$38(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigChatP2PScreen$lambda$39(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$4(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        BigChatP2PScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$43$0(Context context, MutableState mutableState, SnapshotStateList snapshotStateList, Uri uri) {
        if (uri != null) {
            BigChatP2PScreen$lambda$39(mutableState, true);
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            BigChatP2PScreen$addAttachedFileToSend(snapshotStateList, mutableState, Uri.fromFile(new File(path)));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$48$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, Uri uri) {
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

    private static final boolean BigChatP2PScreen$lambda$49(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatScreenState BigChatP2PScreen$lambda$6(State<ChatScreenState> state) {
        return state.getValue();
    }

    private static final boolean BigChatP2PScreen$lambda$60(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigChatP2PScreen$lambda$61(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean BigChatP2PScreen$lambda$63(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigChatP2PScreen$lambda$64(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean BigChatP2PScreen$lambda$66(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigChatP2PScreen$lambda$67(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final FlowsState<Friend> BigChatP2PScreen$lambda$7(State<FlowsState<Friend>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$70$0(ChatViewModel chatViewModel, Context context, State state, Uri uri) {
        if (uri != null) {
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
            kotlin.jvm.internal.y.f(chatScreenStateBigChatP2PScreen$lambda$6);
            chatViewModel.setChatBackground(path, chatScreenStateBigChatP2PScreen$lambda$6.getId());
        }
        return ua.k0.f43947a;
    }

    private static final String BigChatP2PScreen$lambda$72(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigChatP2PScreen$lambda$74$0(State state) {
        String number;
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
        if (chatScreenStateBigChatP2PScreen$lambda$6 == null || (number = chatScreenStateBigChatP2PScreen$lambda$6.getNumber()) == null || number.length() != 0) {
            return false;
        }
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$7 = BigChatP2PScreen$lambda$6(state);
        return kotlin.jvm.internal.y.d(chatScreenStateBigChatP2PScreen$lambda$7 != null ? chatScreenStateBigChatP2PScreen$lambda$7.getUnknownUserState() : null, "new");
    }

    private static final boolean BigChatP2PScreen$lambda$75(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$76(MutableState mutableState, final MutableState mutableState2, MutableState mutableState3, final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final TextFieldState textFieldState, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final ChatParams chatParams, final MutableState mutableState8, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        boolean z10 = false;
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(998351082, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous> (BigChatP2PScreen.kt:559)");
            }
            if (BigChatP2PScreen$lambda$32(mutableState) == null && le.d0.q0(BigChatP2PScreen$lambda$72(mutableState2)) && !BigChatP2PScreen$lambda$63(mutableState3)) {
                z10 = true;
            }
            AttachContainerKt.AnimateContainer(null, z10, ComposableLambdaKt.rememberComposableLambda(1935406489, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0(navHostController, snapshotStateList, chatViewModel, textFieldState, softwareKeyboardController, context, managedActivityResultLauncher, state, mutableState4, mutableState5, mutableState6, mutableState2, mutableState7, chatParams, mutableState8, (Composer) obj, ((Integer) obj2).intValue());
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
    /* JADX WARN: Code duplicated, block: B:37:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:42:0x0110  */
    /* JADX WARN: Code duplicated, block: B:47:0x012c  */
    /* JADX WARN: Code duplicated, block: B:52:0x014d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0163  */
    /* JADX WARN: Code duplicated, block: B:60:0x017f  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x0206  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$76$0(final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final TextFieldState textFieldState, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final ChatParams chatParams, final MutableState mutableState6, Composer composer, int i10) throws SinglediException {
        lb.a aVar;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChanged;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        boolean zChangedInstance3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        boolean zChangedInstance4;
        Object objRememberedValue6;
        boolean zChangedInstance5;
        Object objRememberedValue7;
        boolean zChangedInstance6;
        Object objRememberedValue8;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1935406489, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous> (BigChatP2PScreen.kt:562)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
            int size = snapshotStateList.toList().size();
            boolean zListIsEditable = ChatComplexFunctionalities.INSTANCE.listIsEditable(snapshotStateList, chatViewModel.getOwner().getNameWithDomain());
            boolean zChangedInstance7 = composer.changedInstance(chatViewModel) | composer.changed(textFieldState);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.k1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$0$0(mutableState, chatViewModel, snapshotStateList, textFieldState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            lb.a aVar2 = (lb.a) objRememberedValue9;
            Object objRememberedValue10 = composer.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue10 == companion2.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.o1
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            lb.a aVar3 = (lb.a) objRememberedValue10;
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == companion2.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.p1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$2$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            lb.a aVar4 = (lb.a) objRememberedValue11;
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
            boolean zAvailable = messageWithPartnerWithReactions != null ? messageWithPartnerWithReactions.available() : false;
            boolean zChangedInstance8 = composer.changedInstance(chatViewModel);
            Object objRememberedValue12 = composer.rememberedValue();
            if (zChangedInstance8) {
                aVar = aVar4;
            } else {
                aVar = aVar4;
                if (objRememberedValue12 == companion2.getEmpty()) {
                }
                lb.a aVar5 = (lb.a) objRememberedValue12;
                boolean zBigChatP2PScreen$listIsForwardable = BigChatP2PScreen$listIsForwardable(snapshotStateList);
                zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.r1
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$4$0(navHostController, chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar6 = (lb.a) objRememberedValue;
                zChanged = composer.changed(softwareKeyboardController);
                objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.s1
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar7 = (lb.a) objRememberedValue2;
                zChangedInstance2 = composer.changedInstance(chatViewModel);
                objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.t1
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$6$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                lb.a aVar8 = (lb.a) objRememberedValue3;
                zChangedInstance3 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == companion2.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.u1
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$7$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar9 = (lb.a) objRememberedValue4;
                objRememberedValue5 = composer.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.v1
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$8$0(snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                lb.a aVar10 = (lb.a) objRememberedValue5;
                zChangedInstance4 = composer.changedInstance(managedActivityResultLauncher);
                objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue6 == companion2.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.x1
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$9$0(managedActivityResultLauncher, mutableState5);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar11 = (lb.a) objRememberedValue6;
                zChangedInstance5 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue7 == companion2.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.m1
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$10$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar12 = (lb.a) objRememberedValue7;
                zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue8 = composer.rememberedValue();
                if (zChangedInstance6 || objRememberedValue8 == companion2.getEmpty()) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.n1
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$11$0(chatViewModel, chatParams, mutableState6, context);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                ChatActionBarKt.ChatActionBar(companion, navHostController, chatScreenStateBigChatP2PScreen$lambda$6, size, zListIsEditable, aVar2, false, aVar3, true, aVar, zAvailable, aVar5, zBigChatP2PScreen$listIsForwardable, aVar6, true, aVar7, false, null, true, aVar8, aVar9, aVar10, aVar11, aVar12, (lb.a) objRememberedValue8, null, null, composer, 920125446, 100687872, 48, 100859904);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.q1
                @Override // lb.a
                public final Object invoke() {
                    return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                }
            };
            composer.updateRememberedValue(objRememberedValue12);
            lb.a aVar13 = (lb.a) objRememberedValue12;
            boolean zBigChatP2PScreen$listIsForwardable2 = BigChatP2PScreen$listIsForwardable(snapshotStateList);
            zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            objRememberedValue = composer.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.r1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$4$0(navHostController, chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.r1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$4$0(navHostController, chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar14 = (lb.a) objRememberedValue;
            zChanged = composer.changed(softwareKeyboardController);
            objRememberedValue2 = composer.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.s1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.s1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar15 = (lb.a) objRememberedValue2;
            zChangedInstance2 = composer.changedInstance(chatViewModel);
            objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.t1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$6$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.t1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$6$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar16 = (lb.a) objRememberedValue3;
            zChangedInstance3 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance3) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.u1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$7$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.u1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$7$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar17 = (lb.a) objRememberedValue4;
            objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion2.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.v1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$8$0(snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar18 = (lb.a) objRememberedValue5;
            zChangedInstance4 = composer.changedInstance(managedActivityResultLauncher);
            objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance4) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.x1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$9$0(managedActivityResultLauncher, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.x1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$9$0(managedActivityResultLauncher, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar19 = (lb.a) objRememberedValue6;
            zChangedInstance5 = composer.changedInstance(chatViewModel) | composer.changed(state);
            objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance5) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.m1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$10$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.m1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$10$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            lb.a aVar110 = (lb.a) objRememberedValue7;
            zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance6) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.n1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$11$0(chatViewModel, chatParams, mutableState6, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.n1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$11$0(chatViewModel, chatParams, mutableState6, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            ChatActionBarKt.ChatActionBar(companion, navHostController, chatScreenStateBigChatP2PScreen$lambda$6, size, zListIsEditable, aVar2, false, aVar3, true, aVar, zAvailable, aVar13, zBigChatP2PScreen$listIsForwardable2, aVar14, true, aVar15, false, null, true, aVar16, aVar17, aVar18, aVar19, aVar110, (lb.a) objRememberedValue8, null, null, composer, 920125446, 100687872, 48, 100859904);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$0$0(MutableState mutableState, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, TextFieldState textFieldState) {
        List<String> listBigChatP2PScreen$clearSelection = BigChatP2PScreen$clearSelection(snapshotStateList);
        if (!listBigChatP2PScreen$clearSelection.isEmpty()) {
            mutableState.setValue(ChatComplexFunctionalities.INSTANCE.findMsg(listBigChatP2PScreen$clearSelection.get(0), chatViewModel.getMsgList()));
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions != null) {
                TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, messageWithPartnerWithReactions.getMessage().getContent());
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$10$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
        kotlin.jvm.internal.y.f(chatScreenStateBigChatP2PScreen$lambda$6);
        chatViewModel.removeChatBackground(chatScreenStateBigChatP2PScreen$lambda$6.getId());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$11$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, final Context context) {
        if (kotlin.jvm.internal.y.d(BigChatP2PScreen$lambda$19(mutableState).getPermissionsResult(), PermissionsResult.INSTANCE.granted())) {
            chatViewModel.startCall(chatParams.getUid(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.z2
                @Override // lb.a
                public final Object invoke() {
                    return BigChatP2PScreenKt.BigChatP2PScreen$lambda$76$0$11$0$0(context);
                }
            });
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$19(mutableState), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$11$0$0(Context context) {
        CallActivity.Companion.openCallActivity$default(CallActivity.INSTANCE, context, null, 2, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$2$0(MutableState mutableState) {
        BigChatP2PScreen$lambda$61(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$3$0(MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, SnapshotStateList snapshotStateList) {
        List<String> listBigChatP2PScreen$clearSelection = BigChatP2PScreen$clearSelection(snapshotStateList);
        if (!listBigChatP2PScreen$clearSelection.isEmpty()) {
            mutableState.setValue(ChatComplexFunctionalities.INSTANCE.findMsg(listBigChatP2PScreen$clearSelection.get(0), chatViewModel.getMsgList()));
            mutableState2.setValue(null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$4$0(NavHostController navHostController, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        List<String> listBigChatP2PScreen$clearSelection = BigChatP2PScreen$clearSelection(snapshotStateList);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listBigChatP2PScreen$clearSelection.iterator();
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
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$5$0(SoftwareKeyboardController softwareKeyboardController, SnapshotStateList snapshotStateList, MutableState mutableState) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        mutableState.setValue((String) va.g0.w0(BigChatP2PScreen$clearSelection(snapshotStateList)));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$6$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        chatViewModel.share(BigChatP2PScreen$clearSelection(snapshotStateList));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$7$0(ChatViewModel chatViewModel, Context context, SnapshotStateList snapshotStateList) {
        chatViewModel.pastToClipboard(BigChatP2PScreen$clearSelection(snapshotStateList), context);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$8$0(SnapshotStateList snapshotStateList) {
        BigChatP2PScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$76$0$9$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        Integer state = BigChatP2PScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            managedActivityResultLauncher.launch("image/*");
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$16(mutableState), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v0 java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77(final androidx.compose.runtime.snapshots.SnapshotStateList r49, final cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r50, final androidx.compose.runtime.State r51, final androidx.compose.foundation.text.input.TextFieldState r52, final cu.todus.android.uiCompose.main.screen.chat.component.ChatParams r53, pe.m0 r54, final androidx.compose.runtime.MutableState r55, final androidx.compose.runtime.MutableState r56, final androidx.compose.runtime.snapshots.SnapshotStateList r57, final androidx.compose.runtime.MutableState r58, androidx.compose.runtime.MutableState r59, androidx.paging.compose.LazyPagingItems r60, final androidx.navigation.NavHostController r61, androidx.compose.ui.platform.SoftwareKeyboardController r62, final android.content.Context r63, final androidx.compose.ui.focus.FocusRequester r64, final androidx.compose.runtime.MutableState r65, final androidx.compose.runtime.MutableState r66, androidx.compose.runtime.MutableState r67, androidx.compose.runtime.State r68, final androidx.compose.runtime.MutableState r69, final androidx.compose.runtime.MutableState r70, final androidx.p000activity.compose.ManagedActivityResultLauncher r71, final androidx.compose.runtime.MutableState r72, final androidx.p000activity.compose.ManagedActivityResultLauncher r73, final androidx.compose.runtime.MutableState r74, final androidx.paging.compose.LazyPagingItems r75, final androidx.paging.compose.LazyPagingItems r76, final androidx.paging.compose.LazyPagingItems r77, final androidx.compose.runtime.State r78, final androidx.compose.runtime.MutableState r79, androidx.compose.runtime.State r80, final androidx.compose.runtime.MutableState r81, androidx.compose.runtime.State r82, androidx.compose.runtime.MutableState r83, androidx.compose.runtime.MutableState r84, cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1 r85, androidx.compose.ui.Modifier r86, androidx.compose.runtime.Composer r87, int r88) {
        /*
            Method dump skipped, instruction units count: 3296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreenKt.BigChatP2PScreen$lambda$77(androidx.compose.runtime.snapshots.SnapshotStateList, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel, androidx.compose.runtime.State, androidx.compose.foundation.text.input.TextFieldState, cu.todus.android.uiCompose.main.screen.chat.component.ChatParams, pe.m0, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.snapshots.SnapshotStateList, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.paging.compose.LazyPagingItems, androidx.navigation.NavHostController, androidx.compose.ui.platform.SoftwareKeyboardController, android.content.Context, androidx.compose.ui.focus.FocusRequester, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.paging.compose.LazyPagingItems, androidx.paging.compose.LazyPagingItems, androidx.paging.compose.LazyPagingItems, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):ua.k0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigChatP2PScreen$lambda$77$0$0$0$0(LazyListState lazyListState) {
        return lazyListState.getFirstVisibleItemIndex() == 0;
    }

    private static final boolean BigChatP2PScreen$lambda$77$0$0$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$10(final MutableState mutableState, ChatViewModel chatViewModel, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1735082448, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigChatP2PScreen.kt:942)");
            }
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions == null) {
                composer.startReplaceGroup(-90143284);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-90143283);
                String nameWithDomain = chatViewModel.getOwner().getNameWithDomain();
                String alias = chatViewModel.getOwner().getAlias();
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$10$0$0$0(mutableState);
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
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$10$0$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$11$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$12(final MutableState mutableState, ChatViewModel chatViewModel, final TextFieldState textFieldState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1141609863, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigChatP2PScreen.kt:959)");
            }
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions == null) {
                composer.startReplaceGroup(2146645184);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2146645185);
                String nameWithDomain = chatViewModel.getOwner().getNameWithDomain();
                String alias = chatViewModel.getOwner().getAlias();
                boolean zChanged = composer.changed(textFieldState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.v2
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$12$0$0$0(mutableState, textFieldState);
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
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$12$0$0$0(MutableState mutableState, TextFieldState textFieldState) {
        mutableState.setValue(null);
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, "");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$13$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        BigChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$14(final SnapshotStateList snapshotStateList, final ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429624920, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigChatP2PScreen.kt:979)");
            }
            Integer state = BigChatP2PScreen$lambda$16(mutableState).getPermissionsResult().getState();
            if (state != null && state.intValue() == 2) {
                composer.startReplaceGroup(-46455095);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$14$0$0(snapshotStateList, mutableState2, mutableState3, (Uri) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$14$1$0(managedActivityResultLauncher);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                PresentListKt.PresentList(snapshotStateList, function1, (lb.a) objRememberedValue2, composer, 54);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-46023606);
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
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$14$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, Uri it) {
        kotlin.jvm.internal.y.i(it, "it");
        BigChatP2PScreen$removeAttachedFilesToSend(snapshotStateList, mutableState, mutableState2, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$14$1$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("*/*");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$15$0(MutableState mutableState) {
        BigChatP2PScreen$lambda$36(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$16(final ChatViewModel chatViewModel, final ManagedActivityResultLauncher managedActivityResultLauncher, NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher2, final Context context, final TextFieldState textFieldState, final MutableState mutableState, final MutableState mutableState2, final SnapshotStateList snapshotStateList, final MutableState mutableState3, final ChatParams chatParams, final MutableState mutableState4, final MutableState mutableState5, Composer composer, int i10) {
        ManagedActivityResultLauncher managedActivityResultLauncher3;
        final NavHostController navHostController2;
        final MutableState mutableState6;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2000859703, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigChatP2PScreen.kt:997)");
            }
            v5.f gson = chatViewModel.getGson();
            List<BotShortcut> attachmentShortcuts = chatViewModel.getAttachmentShortcuts();
            boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.j2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$16$0$0(managedActivityResultLauncher, mutableState, mutableState2, snapshotStateList, mutableState3);
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
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.k2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$16$1$0(navHostController2, chatViewModel, chatParams, mutableState4, mutableState3);
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
                lb.a aVar5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.l2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$16$2$0(navHostController2, chatViewModel, chatParams, mutableState4, mutableState6);
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
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.m2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$16$3$0(managedActivityResultLauncher2, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar7 = (lb.a) objRememberedValue4;
            boolean zChangedInstance5 = composer.changedInstance(navHostController2);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.n2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$16$4$0(navHostController2, chatParams, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar8 = (lb.a) objRememberedValue5;
            boolean zChangedInstance6 = composer.changedInstance(managedActivityResultLauncher3);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                final ManagedActivityResultLauncher managedActivityResultLauncher4 = managedActivityResultLauncher3;
                lb.a aVar9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.o2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$16$5$0(managedActivityResultLauncher4, mutableState, mutableState2, snapshotStateList, mutableState6);
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
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.p2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$16$6$0(context, chatViewModel, chatParams, navHostController3, textFieldState, mutableState5, mutableState3, (ButtonContent) obj);
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
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$16$0$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = BigChatP2PScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (BigChatP2PScreen$lambda$38(mutableState2)) {
            BigChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch("*/*");
        }
        BigChatP2PScreen$lambda$36(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$16$1$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2) {
        BigChatP2PScreen$createAndSendDate(navHostController, chatViewModel, chatParams, mutableState);
        BigChatP2PScreen$lambda$36(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$16$2$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2) {
        BigChatP2PScreen$selectMapLocation(navHostController, chatViewModel, chatParams, mutableState);
        BigChatP2PScreen$lambda$36(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$16$3$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        managedActivityResultLauncher.launch(null);
        BigChatP2PScreen$lambda$36(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$16$4$0(NavHostController navHostController, ChatParams chatParams, MutableState mutableState) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goPubEditor(chatParams.getUid()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        BigChatP2PScreen$lambda$36(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$16$5$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = BigChatP2PScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (BigChatP2PScreen$lambda$38(mutableState2)) {
            BigChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch(VideoSpec.MIME_TYPE_UNSPECIFIED);
        }
        BigChatP2PScreen$lambda$36(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$16$6$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, NavHostController navHostController, TextFieldState textFieldState, MutableState mutableState, MutableState mutableState2, ButtonContent it) {
        kotlin.jvm.internal.y.i(it, "it");
        BigChatP2PScreen$onClickInShortcut(context, chatViewModel, chatParams, navHostController, textFieldState, mutableState, it);
        BigChatP2PScreen$lambda$36(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$17$0(MutableState mutableState) {
        BigChatP2PScreen$lambda$67(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$18(LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, final NavHostController navHostController, final ChatViewModel chatViewModel, final MutableState mutableState, final ChatParams chatParams, final MutableState mutableState2, final FocusRequester focusRequester, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-722872810, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigChatP2PScreen.kt:1056)");
            }
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$18$0$0(navHostController, chatViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$18$1$0(chatViewModel, chatParams, mutableState2, focusRequester, mutableState, (Sticker) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            }
            Function1 function2 = (Function1) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new BigChatP2PScreenKt$BigChatP2PScreen$4$1$1$17$3$1(chatViewModel);
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
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$18$0$0(NavHostController navHostController, ChatViewModel chatViewModel, MutableState mutableState) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(null, 1, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        BigChatP2PScreen$lambda$67(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$18$1$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, FocusRequester focusRequester, MutableState mutableState2, Sticker it) {
        Message message;
        kotlin.jvm.internal.y.i(it, "it");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendSticker(uid, it, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        BigChatP2PScreen$lambda$67(mutableState2, false);
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$19(TextFieldState textFieldState, final ChatViewModel chatViewModel, final Context context, FocusRequester focusRequester, State state, MutableState mutableState, final MutableState mutableState2, SnapshotStateList snapshotStateList, ChatParams chatParams, final MutableState mutableState3, final MutableState mutableState4, MutableState mutableState5, final MutableState mutableState6, Composer composer, int i10) {
        Object obj;
        final MutableState mutableState7;
        final SnapshotStateList snapshotStateList2;
        final ChatParams chatParams2;
        final MutableState mutableState8;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1528802925, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BigChatP2PScreen.kt:1094)");
            }
            long jBigChatP2PScreen$lambda$14 = BigChatP2PScreen$lambda$14(state);
            boolean zBigChatP2PScreen$lambda$38 = BigChatP2PScreen$lambda$38(mutableState);
            boolean zBigChatP2PScreen$lambda$66 = BigChatP2PScreen$lambda$66(mutableState2);
            boolean zChangedInstance = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState7 = mutableState;
                snapshotStateList2 = snapshotStateList;
                chatParams2 = chatParams;
                mutableState8 = mutableState5;
                obj = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.y1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$19$0$0(chatViewModel, snapshotStateList2, chatParams2, mutableState3, mutableState4, context, mutableState7, mutableState8, (String) obj2);
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
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.z1
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$19$1$0(chatViewModel, chatParams2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.a2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$19$2$0(chatViewModel, chatParams2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar2 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(chatViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$19$3$0(chatViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar3 = (lb.a) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.c2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$19$4$0(snapshotStateList2, mutableState7, mutableState8);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar4 = (lb.a) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.d2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$19$5$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar5 = (lb.a) objRememberedValue6;
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.e2
                    @Override // lb.a
                    public final Object invoke() {
                        return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$19$6$0(snapshotStateList2, mutableState7, mutableState8, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ChatInputKt.ChatInput(textFieldState, null, function1, aVar, aVar2, aVar3, aVar4, aVar5, (lb.a) objRememberedValue7, zBigChatP2PScreen$lambda$38, jBigChatP2PScreen$lambda$14, focusRequester, zBigChatP2PScreen$lambda$66, composer, 114819072, 48, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$19$0$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, ChatParams chatParams, MutableState mutableState, MutableState mutableState2, Context context, MutableState mutableState3, MutableState mutableState4, String messageContent) {
        Message message;
        Message message2;
        kotlin.jvm.internal.y.i(messageContent, "messageContent");
        chatViewModel.sendTyping(false);
        if (snapshotStateList.isEmpty()) {
            String uid = chatParams.getUid();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            String id2 = (messageWithPartnerWithReactions == null || (message2 = messageWithPartnerWithReactions.getMessage()) == null) ? null : message2.getId();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions2 = (MessageWithPartnerWithReactions) mutableState2.getValue();
            ChatViewModel.sendMessage$default(chatViewModel, messageContent, uid, false, null, id2, (messageWithPartnerWithReactions2 == null || (message = messageWithPartnerWithReactions2.getMessage()) == null) ? null : message.getId(), null, 76, null);
        } else {
            BigChatP2PScreen$selectMethodAndSend(chatParams, mutableState, chatViewModel, context, snapshotStateList, mutableState3, mutableState4, messageContent);
        }
        mutableState.setValue(null);
        mutableState2.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$19$1$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.startRecorder(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$19$2$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.stopRecorderAndSend(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$19$3$0(ChatViewModel chatViewModel) {
        chatViewModel.stopRecorder();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$19$4$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        BigChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        BigChatP2PScreen$lambda$36(mutableState2, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$19$5$0(MutableState mutableState) {
        BigChatP2PScreen$lambda$67(mutableState, !BigChatP2PScreen$lambda$66(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$19$6$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        BigChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        BigChatP2PScreen$lambda$64(mutableState3, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$2$0(pe.m0 m0Var, LazyListState lazyListState, boolean z10) {
        pe.k.d(m0Var, null, null, new BigChatP2PScreenKt$BigChatP2PScreen$4$1$1$1$1$1(z10, lazyListState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$3$0(pe.m0 m0Var, LazyListState lazyListState, int i10) {
        pe.k.d(m0Var, null, null, new BigChatP2PScreenKt$BigChatP2PScreen$4$1$1$2$1$1(lazyListState, i10, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$10$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, SoftwareKeyboardController softwareKeyboardController, Context context, NavHostController navHostController, ChatParams chatParams, TextFieldState textFieldState, MutableState mutableState, State state, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions msg, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        kotlin.jvm.internal.y.i(msg, "msg");
        if (msg.getMessage().getState() == 4) {
            chatViewModel.tryResend(msg.getMessage().getId());
        } else if (BigChatP2PScreen$selectedListIsEmpty(snapshotStateList)) {
            BigChatP2PScreen$attachmentClicked(softwareKeyboardController, context, chatViewModel, navHostController, chatParams, textFieldState, mutableState, state, mutableState2, z10, messageAction, msg, i10);
        } else if (BigChatP2PScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            BigChatP2PScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            BigChatP2PScreen$addItemToSelected(mutableState3, mutableState4, snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$11$0(SnapshotStateList snapshotStateList, ChatViewModel chatViewModel, MutableState mutableState, MutableState mutableState2, MessageWithPartnerWithReactions msg, int i10) {
        kotlin.jvm.internal.y.i(msg, "msg");
        if (BigChatP2PScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            BigChatP2PScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            BigChatP2PScreen$addItemToSelected(mutableState, mutableState2, snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$12$0(ChatViewModel chatViewModel, Context context, TextFieldState textFieldState, MutableState mutableState, NavHostController navHostController, MessageWithPartnerWithReactions msg, MessageAction messageAction, String value) {
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
            BigChatP2PScreen$handleClickOnMention(chatViewModel, mutableState, navHostController, mentionName);
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
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$13$0(State state, NavHostController navHostController) {
        String toDusId;
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
        if (chatScreenStateBigChatP2PScreen$lambda$6 != null && (toDusId = chatScreenStateBigChatP2PScreen$lambda$6.getToDusId()) != null) {
            NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goCatalogueCheckIn(toDusId), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$14$0(NavHostController navHostController, ChatParams chatParams) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goSocialProfile(chatParams.getUid()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$15$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState) {
        chatViewModel.displayAllMsg(chatParams.getUid());
        Function1 function1BigChatP2PScreen$lambda$9 = BigChatP2PScreen$lambda$9(mutableState);
        if (function1BigChatP2PScreen$lambda$9 != null) {
            function1BigChatP2PScreen$lambda$9.invoke(Boolean.FALSE);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$4$0(FocusRequester focusRequester, MutableState mutableState, SnapshotStateList snapshotStateList, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        BigChatP2PScreen$clearSelection(snapshotStateList);
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$5$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, String roomId, String msgId, String value) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(value, "value");
        BigChatP2PScreen$clearSelection(snapshotStateList);
        chatViewModel.onReacted(roomId, msgId, value);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$6$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.REACT_SELECTION, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$7$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$9$0(final ChatViewModel chatViewModel, final NavHostController navHostController, final String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.getStatusPosition(it, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$0$0$4$9$0$0(navHostController, chatViewModel, it, (Pair) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$4$9$0$0(NavHostController navHostController, ChatViewModel chatViewModel, String str, Pair result) {
        kotlin.jvm.internal.y.i(result, "result");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new StatusPreviewParams(((Boolean) result.getFirst()).booleanValue(), ((Number) result.getSecond()).intValue(), str));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$5$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
        String id2 = chatScreenStateBigChatP2PScreen$lambda$6 != null ? chatScreenStateBigChatP2PScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsAccepted(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$6$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
        String id2 = chatScreenStateBigChatP2PScreen$lambda$6 != null ? chatScreenStateBigChatP2PScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsAccepted(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$7$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
        String id2 = chatScreenStateBigChatP2PScreen$lambda$6 != null ? chatScreenStateBigChatP2PScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownUserAsShared(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$8$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateBigChatP2PScreen$lambda$6 = BigChatP2PScreen$lambda$6(state);
        String id2 = chatScreenStateBigChatP2PScreen$lambda$6 != null ? chatScreenStateBigChatP2PScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownUserAsBlocked(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$0$0$9$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigChatP2PScreen$lambda$77$0$0$goReply(MutableState<Function1> mutableState, int i10) {
        Function1 function1BigChatP2PScreen$lambda$12 = BigChatP2PScreen$lambda$12(mutableState);
        if (function1BigChatP2PScreen$lambda$12 != null) {
            function1BigChatP2PScreen$lambda$12.invoke(Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$0$0(ChatViewModel chatViewModel) {
        chatViewModel.readRequestingFriend();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$1$0(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$10$0(MutableState mutableState) {
        BigChatP2PScreen$lambda$64(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$11(final MutableState mutableState, final ChatViewModel chatViewModel, final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943368147, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (BigChatP2PScreen.kt:1244)");
            }
            AttachmentPreviewState attachmentPreviewStateBigChatP2PScreen$lambda$32 = BigChatP2PScreen$lambda$32(mutableState);
            if (attachmentPreviewStateBigChatP2PScreen$lambda$32 == null) {
                composer.startReplaceGroup(1909509163);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1909509164);
                boolean zChangedInstance = composer.changedInstance(chatViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.w2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$1$11$0$0$0(chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.x2
                        @Override // lb.a
                        public final Object invoke() {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$1$11$0$1$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar = (lb.a) objRememberedValue2;
                boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.y2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigChatP2PScreenKt.BigChatP2PScreen$lambda$77$1$11$0$2$0(navHostController, chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                AttachmentPreviewKt.AttachmentPreviewWithOptions(attachmentPreviewStateBigChatP2PScreen$lambda$32, function1, aVar, (Function1) objRememberedValue3, null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 16);
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
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$11$0$0$0(ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.share(va.v.e(it));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$11$0$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$11$0$2$0(NavHostController navHostController, ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(it));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$12$0(MutableState mutableState) {
        mutableState.setValue("");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$13(NavHostController navHostController, MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-900541642, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreen.<anonymous>.<anonymous>.<anonymous> (BigChatP2PScreen.kt:1269)");
            }
            MsgDetailsDialogKt.MsgDetailsDialog(BigChatP2PScreen$lambda$72(mutableState), navHostController, null, composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$14$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$16(mutableState), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$15$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$16(mutableState), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$16$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$16(mutableState), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$17$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$16(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$16(mutableState), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$18$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$19(mutableState), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$19$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$19(mutableState), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$2$0(MutableState mutableState) {
        BigChatP2PScreen$lambda$61(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$20$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$19(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(BigChatP2PScreen$lambda$19(mutableState), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$5$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$6$0(TextFieldState textFieldState, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, String value, boolean z10) {
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
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$7$0(ChatParams chatParams, MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, List files, String content) {
        Message message;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendVideos(uid, files, content, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        BigChatP2PScreen$lambda$64(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$8$0(ChatParams chatParams, MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, List files, String content) {
        Message message;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendImages(uid, files, content, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        BigChatP2PScreen$lambda$64(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$1$9$0(MutableState mutableState) {
        BigChatP2PScreen$lambda$64(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$77$2$0(SnapshotStateList snapshotStateList) {
        BigChatP2PScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BigChatP2PScreen$lambda$77$5$0(final ChatViewModel chatViewModel, final TextFieldState textFieldState, final ChatParams chatParams, final BigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1 bigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.BigChatP2PScreenKt$BigChatP2PScreen$lambda$77$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                chatViewModel.setRoomDraft(textFieldState.getText().toString(), chatParams.getUid());
                chatViewModel.stopRecorder();
                chatViewModel.getNotificationManager().unRegister(bigChatP2PScreenKt$BigChatP2PScreen$notificationFilter$1$1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$lambda$78(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        BigChatP2PScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 BigChatP2PScreen$lambda$9(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean BigChatP2PScreen$listIsForwardable(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
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

    private static final void BigChatP2PScreen$onClickInShortcut(Context context, final ChatViewModel chatViewModel, final ChatParams chatParams, final NavHostController navHostController, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, ButtonContent buttonContent) {
        ChatButtonsFunctionality.INSTANCE.handleClick(buttonContent, context, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.f2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigChatP2PScreenKt.BigChatP2PScreen$onClickInShortcut$lambda$28(chatViewModel, chatParams, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.g2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigChatP2PScreenKt.BigChatP2PScreen$onClickInShortcut$lambda$29(navHostController, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.i2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BigChatP2PScreenKt.BigChatP2PScreen$onClickInShortcut$lambda$30(textFieldState, (String) obj);
            }
        }, new BigChatP2PScreenKt$BigChatP2PScreen$onClickInShortcut$4(mutableState), (64 & 64) != 0 ? new Function1() { // from class: q7.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatButtonsFunctionality.handleClick$lambda$0((BotShortcut) obj);
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$onClickInShortcut$lambda$28(ChatViewModel chatViewModel, ChatParams chatParams, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatViewModel.sendMessage$default(chatViewModel, it, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$onClickInShortcut$lambda$29(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$onClickInShortcut$lambda$30(TextFieldState textFieldState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigChatP2PScreen$onDelete(ChatViewModel chatViewModel, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteMessages(BigChatP2PScreen$clearSelection(snapshotStateList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigChatP2PScreen$onDeleteToAll(ChatViewModel chatViewModel, ChatParams chatParams, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteForAll(chatParams.getUid(), BigChatP2PScreen$clearSelection(snapshotStateList));
    }

    private static final void BigChatP2PScreen$removeAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Uri uri) {
        if (snapshotStateList.size() == 1) {
            BigChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        } else {
            snapshotStateList.remove(uri);
        }
    }

    private static final void BigChatP2PScreen$removeItemFromSelected(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, final String str) {
        final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.a3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(BigChatP2PScreenKt.BigChatP2PScreen$removeItemFromSelected$lambda$53(str, (MessageWithPartnerWithReactions) obj));
            }
        };
        Collection.EL.removeIf(snapshotStateList, new Predicate() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.b3
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
                return BigChatP2PScreenKt.BigChatP2PScreen$removeItemFromSelected$lambda$54(function1, obj);
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
    public static final boolean BigChatP2PScreen$removeItemFromSelected$lambda$53(String str, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getMessage().getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BigChatP2PScreen$removeItemFromSelected$lambda$54(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private static final void BigChatP2PScreen$selectMapLocation(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState) {
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

    private static final void BigChatP2PScreen$selectMethodAndSend(ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState, ChatViewModel chatViewModel, Context context, final SnapshotStateList<Uri> snapshotStateList, final MutableState<Boolean> mutableState2, final MutableState<Boolean> mutableState3, String str) {
        Message message;
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        chatComplexFunctionalities.selectMethodAndSend(str, uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId(), context, snapshotStateList, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.j1
            @Override // lb.a
            public final Object invoke() {
                return BigChatP2PScreenKt.BigChatP2PScreen$selectMethodAndSend$lambda$42(snapshotStateList, mutableState2, mutableState3);
            }
        }, new BigChatP2PScreenKt$BigChatP2PScreen$selectMethodAndSend$1(chatViewModel), new BigChatP2PScreenKt$BigChatP2PScreen$selectMethodAndSend$2(chatViewModel), new BigChatP2PScreenKt$BigChatP2PScreen$selectMethodAndSend$3(chatViewModel), new BigChatP2PScreenKt$BigChatP2PScreen$selectMethodAndSend$4(chatViewModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BigChatP2PScreen$selectMethodAndSend$lambda$42(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        BigChatP2PScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x002a A[RETURN] */
    public static final boolean BigChatP2PScreen$selectedContains(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, String str) {
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

    private static final boolean BigChatP2PScreen$selectedListIsEmpty(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        return snapshotStateList.toList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigChatP2PScreen$setPlaceholderData(MutableState<PagerDialogData> mutableState, String str, ButtonTemplate buttonTemplate, boolean z10) {
        mutableState.setValue(new PagerDialogData(str, buttonTemplate, z10, null, 8, null));
    }
}
