package cu.todus.android.uiCompose.main.screen.chat.component.card;

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
import androidx.navigation.NavOptionsBuilder;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006$²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\nX\u008a\u0084\u0002²\u0006\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0015\u001a\u00020\u00148\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00188\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001c\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001e\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001f\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010 \u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010!\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\"\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\f\u0010#\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;", "viewModel", "Lua/k0;", "ChatCardScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "chatScreenState", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/data/db/pojo/Friend;", "requestedFriendByContact", "Lkotlin/Function1;", "scrollBottom", "", "scrollToPosition", "", "actualRecorderTime", "Lcu/z17/views/permission/PermissionsRequesterState;", "mediaPermissionsState", "Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "attachmentPreview", "Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogData;", "createPlaceholderMsg", "showAttachmentSelector", "isPickingFiles", "showDeleteForEveryone", "showDeleteDialog", "openCamera", "showStickers", "msgDetailId", "firstItemVisible", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatCardScreenKt {

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

    /* JADX WARN: Code duplicated, block: B:102:0x027f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0294  */
    /* JADX WARN: Code duplicated, block: B:108:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:111:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:116:0x02de  */
    /* JADX WARN: Code duplicated, block: B:121:0x0306  */
    /* JADX WARN: Code duplicated, block: B:124:0x0333  */
    /* JADX WARN: Code duplicated, block: B:127:0x0346  */
    /* JADX WARN: Code duplicated, block: B:130:0x035b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0370  */
    /* JADX WARN: Code duplicated, block: B:138:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:141:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:144:0x0462  */
    /* JADX WARN: Code duplicated, block: B:150:0x0480 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:63:0x0113  */
    /* JADX WARN: Code duplicated, block: B:66:0x012a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0146  */
    /* JADX WARN: Code duplicated, block: B:71:0x014f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0158  */
    /* JADX WARN: Code duplicated, block: B:77:0x0167  */
    /* JADX WARN: Code duplicated, block: B:79:0x0171  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:85:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x0227  */
    /* JADX WARN: Code duplicated, block: B:96:0x0253  */
    /* JADX WARN: Code duplicated, block: B:99:0x026a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"CoroutineCreationDuringComposition"})
    public static final void ChatCardScreen(final NavHostController navHostController, final String params, ChatViewModel chatViewModel, Composer composer, final int i10, final int i11) {
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
        final TextFieldState textFieldStateM2202rememberTextFieldStateLepunE;
        boolean zChanged;
        Object objRememberedValue9;
        Object objRememberedValue10;
        Object objRememberedValue11;
        Object objRememberedValue12;
        Object objRememberedValue13;
        final MutableState mutableState2;
        Object objRememberedValue14;
        final SnapshotStateList snapshotStateList;
        boolean zChangedInstance;
        Object objRememberedValue15;
        boolean zChangedInstance2;
        Object objRememberedValue16;
        Object objRememberedValue17;
        Object objRememberedValue18;
        Object objRememberedValue19;
        Object objRememberedValue20;
        boolean zChangedInstance3;
        Object objRememberedValue21;
        Object objRememberedValue22;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(-652868118);
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
                    ComposerKt.traceEventStart(-652868118, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen (ChatCardScreen.kt:137)");
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
                    navHostController.navigateUp();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final ChatViewModel chatViewModel6 = chatViewModel4;
                    final String str2 = str;
                    function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.b4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$4(navHostController, str2, chatViewModel6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                } else {
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new INotificationFilter() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1
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
                    final ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1 chatCardScreenKt$ChatCardScreen$notificationFilter$1$1 = (ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1) objRememberedValue4;
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
                    final MutableState mutableState3 = (MutableState) objRememberedValue5;
                    objRememberedValue6 = composer3.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState4 = (MutableState) objRememberedValue6;
                    final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getRecordingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                    objRememberedValue7 = composer3.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA), 1, null), null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue7);
                    }
                    final MutableState mutableState5 = (MutableState) objRememberedValue7;
                    objRememberedValue8 = composer3.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new FocusRequester();
                        composer3.updateRememberedValue(objRememberedValue8);
                    }
                    final FocusRequester focusRequester = (FocusRequester) objRememberedValue8;
                    textFieldStateM2202rememberTextFieldStateLepunE = TextFieldStateKt.m2202rememberTextFieldStateLepunE(null, 0L, composer3, 0, 3);
                    zChanged = composer3.changed(textFieldStateM2202rememberTextFieldStateLepunE) | composer3.changedInstance(chatViewModel5);
                    objRememberedValue9 = composer3.rememberedValue();
                    if (zChanged || objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new ChatCardScreenKt$ChatCardScreen$2$1(textFieldStateM2202rememberTextFieldStateLepunE, chatViewModel5, null);
                        composer3.updateRememberedValue(objRememberedValue9);
                    }
                    EffectsKt.LaunchedEffect(textFieldStateM2202rememberTextFieldStateLepunE, (Function2) objRememberedValue9, composer3, 0);
                    objRememberedValue10 = composer3.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue10);
                    }
                    final MutableState mutableState6 = (MutableState) objRememberedValue10;
                    objRememberedValue11 = composer3.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue11);
                    }
                    final MutableState mutableState7 = (MutableState) objRememberedValue11;
                    objRememberedValue12 = composer3.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue12);
                    }
                    final MutableState mutableState8 = (MutableState) objRememberedValue12;
                    objRememberedValue13 = composer3.rememberedValue();
                    if (objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue13);
                    }
                    mutableState2 = (MutableState) objRememberedValue13;
                    objRememberedValue14 = composer3.rememberedValue();
                    if (objRememberedValue14 == companion.getEmpty()) {
                        objRememberedValue14 = SnapshotStateKt.mutableStateListOf();
                        composer3.updateRememberedValue(objRememberedValue14);
                    }
                    snapshotStateList = (SnapshotStateList) objRememberedValue14;
                    ActivityResultContracts.GetContent getContent = new ActivityResultContracts.GetContent();
                    zChangedInstance = composer3.changedInstance(context);
                    objRememberedValue15 = composer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue15 == companion.getEmpty()) {
                        objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.m4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChatCardScreenKt.ChatCardScreen$lambda$38$0(context, mutableState2, snapshotStateList, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue15);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent, (Function1) objRememberedValue15, composer3, 0);
                    ActivityResultContracts.PickContact pickContact = new ActivityResultContracts.PickContact();
                    zChangedInstance2 = composer3.changedInstance(context) | composer3.changedInstance(chatViewModel5);
                    objRememberedValue16 = composer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue16 == companion.getEmpty()) {
                        objRememberedValue16 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.x4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChatCardScreenKt.ChatCardScreen$lambda$43$0(context, chatViewModel5, chatParams, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue16);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(pickContact, (Function1) objRememberedValue16, composer3, 0);
                    final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getAllMsgsAreMine(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                    objRememberedValue17 = composer3.rememberedValue();
                    if (objRememberedValue17 == companion.getEmpty()) {
                        objRememberedValue17 = SnapshotStateKt.mutableStateListOf();
                        composer3.updateRememberedValue(objRememberedValue17);
                    }
                    final SnapshotStateList snapshotStateList2 = (SnapshotStateList) objRememberedValue17;
                    objRememberedValue18 = composer3.rememberedValue();
                    if (objRememberedValue18 == companion.getEmpty()) {
                        objRememberedValue18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue18);
                    }
                    final MutableState mutableState9 = (MutableState) objRememberedValue18;
                    objRememberedValue19 = composer3.rememberedValue();
                    if (objRememberedValue19 == companion.getEmpty()) {
                        objRememberedValue19 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue19);
                    }
                    final MutableState mutableState10 = (MutableState) objRememberedValue19;
                    objRememberedValue20 = composer3.rememberedValue();
                    if (objRememberedValue20 == companion.getEmpty()) {
                        objRememberedValue20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue20);
                    }
                    final MutableState mutableState11 = (MutableState) objRememberedValue20;
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getRecentStickers(), null, composer3, 0, 1);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems3 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getFavoriteStickers(), null, composer3, 0, 1);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems4 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getAllStickers(), null, composer3, 0, 1);
                    ActivityResultContracts.GetContent getContent2 = new ActivityResultContracts.GetContent();
                    zChangedInstance3 = composer3.changedInstance(chatViewModel5) | composer3.changedInstance(context) | composer3.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue21 = composer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue21 == companion.getEmpty()) {
                        objRememberedValue21 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.i5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChatCardScreenKt.ChatCardScreen$lambda$65$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue21);
                    }
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult3 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent2, (Function1) objRememberedValue21, composer3, 0);
                    objRememberedValue22 = composer3.rememberedValue();
                    if (objRememberedValue22 == companion.getEmpty()) {
                        objRememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue22);
                    }
                    final MutableState mutableState12 = (MutableState) objRememberedValue22;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2033476066, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.t5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$69(mutableState6, mutableState12, mutableState10, navHostController, snapshotStateList2, chatViewModel5, softwareKeyboardController, context, managedActivityResultLauncherRememberLauncherForActivityResult3, stateCollectAsStateWithLifecycle, mutableState9, mutableState5, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer3, 54);
                    Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.e6
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$70(snapshotStateList2, chatViewModel5, stateCollectAsStateWithLifecycle, textFieldStateM2202rememberTextFieldStateLepunE, navHostController, chatParams, mutableState, m0Var, snapshotStateList, mutableState3, mutableState4, lazyPagingItemsCollectAsLazyPagingItems, softwareKeyboardController, context, mutableState7, mutableState6, mutableState2, mutableState8, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState5, managedActivityResultLauncherRememberLauncherForActivityResult2, mutableState11, lazyPagingItemsCollectAsLazyPagingItems2, lazyPagingItemsCollectAsLazyPagingItems3, lazyPagingItemsCollectAsLazyPagingItems4, focusRequester, stateCollectAsStateWithLifecycle3, mutableState10, stateCollectAsStateWithLifecycle2, mutableState9, stateCollectAsStateWithLifecycle4, mutableState12, chatCardScreenKt$ChatCardScreen$notificationFilter$1$1, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    composerStartRestartGroup = composer3;
                    Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-303781472, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
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
                ComposerKt.traceEventStart(-652868118, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen (ChatCardScreen.kt:137)");
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
                navHostController.navigateUp();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                }
                final ChatViewModel chatViewModel7 = chatViewModel4;
                final String str3 = str;
                function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.b4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatCardScreenKt.ChatCardScreen$lambda$4(navHostController, str3, chatViewModel7, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
            } else {
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new INotificationFilter() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1
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
                final ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1 chatCardScreenKt$ChatCardScreen$notificationFilter$1$2 = (ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1) objRememberedValue4;
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
                final MutableState mutableState13 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState14 = (MutableState) objRememberedValue6;
                final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getRecordingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                objRememberedValue7 = composer3.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA), 1, null), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                final MutableState mutableState15 = (MutableState) objRememberedValue7;
                objRememberedValue8 = composer3.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new FocusRequester();
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                final FocusRequester focusRequester2 = (FocusRequester) objRememberedValue8;
                textFieldStateM2202rememberTextFieldStateLepunE = TextFieldStateKt.m2202rememberTextFieldStateLepunE(null, 0L, composer3, 0, 3);
                zChanged = composer3.changed(textFieldStateM2202rememberTextFieldStateLepunE) | composer3.changedInstance(chatViewModel5);
                objRememberedValue9 = composer3.rememberedValue();
                if (zChanged) {
                    objRememberedValue9 = new ChatCardScreenKt$ChatCardScreen$2$1(textFieldStateM2202rememberTextFieldStateLepunE, chatViewModel5, null);
                    composer3.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new ChatCardScreenKt$ChatCardScreen$2$1(textFieldStateM2202rememberTextFieldStateLepunE, chatViewModel5, null);
                    composer3.updateRememberedValue(objRememberedValue9);
                }
                EffectsKt.LaunchedEffect(textFieldStateM2202rememberTextFieldStateLepunE, (Function2) objRememberedValue9, composer3, 0);
                objRememberedValue10 = composer3.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue10);
                }
                final MutableState mutableState16 = (MutableState) objRememberedValue10;
                objRememberedValue11 = composer3.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                final MutableState mutableState17 = (MutableState) objRememberedValue11;
                objRememberedValue12 = composer3.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue12);
                }
                final MutableState mutableState18 = (MutableState) objRememberedValue12;
                objRememberedValue13 = composer3.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue13);
                }
                mutableState2 = (MutableState) objRememberedValue13;
                objRememberedValue14 = composer3.rememberedValue();
                if (objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = SnapshotStateKt.mutableStateListOf();
                    composer3.updateRememberedValue(objRememberedValue14);
                }
                snapshotStateList = (SnapshotStateList) objRememberedValue14;
                ActivityResultContracts.GetContent getContent3 = new ActivityResultContracts.GetContent();
                zChangedInstance = composer3.changedInstance(context);
                objRememberedValue15 = composer3.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.m4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$38$0(context, mutableState2, snapshotStateList, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                } else {
                    objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.m4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$38$0(context, mutableState2, snapshotStateList, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult4 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent3, (Function1) objRememberedValue15, composer3, 0);
                ActivityResultContracts.PickContact pickContact2 = new ActivityResultContracts.PickContact();
                zChangedInstance2 = composer3.changedInstance(context) | composer3.changedInstance(chatViewModel5);
                objRememberedValue16 = composer3.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue16 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.x4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$43$0(context, chatViewModel5, chatParams, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue16);
                } else {
                    objRememberedValue16 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.x4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$43$0(context, chatViewModel5, chatParams, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue16);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult5 = ActivityResultRegistryKt.rememberLauncherForActivityResult(pickContact2, (Function1) objRememberedValue16, composer3, 0);
                final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(chatViewModel5.getAllMsgsAreMine(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                objRememberedValue17 = composer3.rememberedValue();
                if (objRememberedValue17 == companion.getEmpty()) {
                    objRememberedValue17 = SnapshotStateKt.mutableStateListOf();
                    composer3.updateRememberedValue(objRememberedValue17);
                }
                final SnapshotStateList snapshotStateList3 = (SnapshotStateList) objRememberedValue17;
                objRememberedValue18 = composer3.rememberedValue();
                if (objRememberedValue18 == companion.getEmpty()) {
                    objRememberedValue18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue18);
                }
                final MutableState mutableState19 = (MutableState) objRememberedValue18;
                objRememberedValue19 = composer3.rememberedValue();
                if (objRememberedValue19 == companion.getEmpty()) {
                    objRememberedValue19 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue19);
                }
                final MutableState mutableState110 = (MutableState) objRememberedValue19;
                objRememberedValue20 = composer3.rememberedValue();
                if (objRememberedValue20 == companion.getEmpty()) {
                    objRememberedValue20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue20);
                }
                final MutableState mutableState111 = (MutableState) objRememberedValue20;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems6 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getRecentStickers(), null, composer3, 0, 1);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems7 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getFavoriteStickers(), null, composer3, 0, 1);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems8 = LazyPagingItemsKt.collectAsLazyPagingItems(chatViewModel5.getAllStickers(), null, composer3, 0, 1);
                ActivityResultContracts.GetContent getContent4 = new ActivityResultContracts.GetContent();
                zChangedInstance3 = composer3.changedInstance(chatViewModel5) | composer3.changedInstance(context) | composer3.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue21 = composer3.rememberedValue();
                if (zChangedInstance3) {
                    objRememberedValue21 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.i5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$65$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue21);
                } else {
                    objRememberedValue21 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.i5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$65$0(chatViewModel5, context, stateCollectAsStateWithLifecycle, (Uri) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue21);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult6 = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent4, (Function1) objRememberedValue21, composer3, 0);
                objRememberedValue22 = composer3.rememberedValue();
                if (objRememberedValue22 == companion.getEmpty()) {
                    objRememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue22);
                }
                final MutableState mutableState112 = (MutableState) objRememberedValue22;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-2033476066, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.t5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69(mutableState16, mutableState112, mutableState110, navHostController, snapshotStateList3, chatViewModel5, softwareKeyboardController, context, managedActivityResultLauncherRememberLauncherForActivityResult6, stateCollectAsStateWithLifecycle, mutableState19, mutableState15, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54);
                Function3 function4 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.e6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70(snapshotStateList3, chatViewModel5, stateCollectAsStateWithLifecycle, textFieldStateM2202rememberTextFieldStateLepunE, navHostController, chatParams, mutableState, m0Var, snapshotStateList, mutableState13, mutableState14, lazyPagingItemsCollectAsLazyPagingItems5, softwareKeyboardController, context, mutableState17, mutableState16, mutableState2, mutableState18, managedActivityResultLauncherRememberLauncherForActivityResult4, mutableState15, managedActivityResultLauncherRememberLauncherForActivityResult5, mutableState111, lazyPagingItemsCollectAsLazyPagingItems6, lazyPagingItemsCollectAsLazyPagingItems7, lazyPagingItemsCollectAsLazyPagingItems8, focusRequester2, stateCollectAsStateWithLifecycle6, mutableState110, stateCollectAsStateWithLifecycle5, mutableState19, stateCollectAsStateWithLifecycle7, mutableState112, chatCardScreenKt$ChatCardScreen$notificationFilter$1$2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                composerStartRestartGroup = composer3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda2, false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-303781472, true, function4, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chatViewModel3 = chatViewModel5;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        composerStartRestartGroup.skipToGroupEnd();
        chatViewModel3 = chatViewModel2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.m6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatCardScreenKt.ChatCardScreen$lambda$71(navHostController, params, chatViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final void ChatCardScreen$addAttachedFileToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, Uri uri) {
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
        ChatCardScreen$lambda$34(mutableState, true);
    }

    private static final void ChatCardScreen$addItemToSelected(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
        snapshotStateList.add(messageWithPartnerWithReactions);
        ArrayList arrayList = new ArrayList(va.x.y(snapshotStateList, 10));
        Iterator<MessageWithPartnerWithReactions> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMessage().getId());
        }
        chatViewModel.allMsgsAreMine(va.g0.o1(arrayList));
    }

    private static final void ChatCardScreen$attachmentClicked(SoftwareKeyboardController softwareKeyboardController, final ChatViewModel chatViewModel, Context context, State<ChatScreenState> state, final NavHostController navHostController, final ChatParams chatParams, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, final MutableState<AttachmentPreviewState> mutableState2, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions messageWithPartnerWithReactions, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        ChatCardScreenKt$ChatCardScreen$attachmentClicked$1 chatCardScreenKt$ChatCardScreen$attachmentClicked$1 = new ChatCardScreenKt$ChatCardScreen$attachmentClicked$1(chatViewModel);
        ChatCardScreenKt$ChatCardScreen$attachmentClicked$2 chatCardScreenKt$ChatCardScreen$attachmentClicked$2 = new ChatCardScreenKt$ChatCardScreen$attachmentClicked$2(chatViewModel);
        ChatCardScreenKt$ChatCardScreen$attachmentClicked$3 chatCardScreenKt$ChatCardScreen$attachmentClicked$3 = new ChatCardScreenKt$ChatCardScreen$attachmentClicked$3(chatViewModel);
        ChatScreenState chatScreenStateChatCardScreen$lambda$6 = ChatCardScreen$lambda$6(state);
        chatComplexFunctionalities.attachmentClicked(messageAction, i10, z10, messageWithPartnerWithReactions, context, gson, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.v2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$attachmentClicked$lambda$39(navHostController, (String) obj);
            }
        }, chatCardScreenKt$ChatCardScreen$attachmentClicked$1, chatCardScreenKt$ChatCardScreen$attachmentClicked$2, chatCardScreenKt$ChatCardScreen$attachmentClicked$3, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.w2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$attachmentClicked$lambda$40(chatViewModel, chatParams, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.x2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$attachmentClicked$lambda$41(textFieldState, (String) obj);
            }
        }, new ChatCardScreenKt$ChatCardScreen$attachmentClicked$7(mutableState), chatScreenStateChatCardScreen$lambda$6 != null ? chatScreenStateChatCardScreen$lambda$6.isSecret() : false, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.y2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$attachmentClicked$lambda$42(mutableState2, (AttachmentPreviewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$attachmentClicked$lambda$39(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$attachmentClicked$lambda$40(ChatViewModel chatViewModel, ChatParams chatParams, String msgContent) {
        kotlin.jvm.internal.y.i(msgContent, "msgContent");
        ChatViewModel.sendMessage$default(chatViewModel, msgContent, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$attachmentClicked$lambda$41(TextFieldState textFieldState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$attachmentClicked$lambda$42(MutableState mutableState, AttachmentPreviewState it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    private static final void ChatCardScreen$clearAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        snapshotStateList.clear();
        ChatCardScreen$lambda$34(mutableState, false);
        ChatCardScreen$lambda$31(mutableState2, false);
    }

    private static final List<String> ChatCardScreen$clearSelection(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        List<MessageWithPartnerWithReactions> list = snapshotStateList.toList();
        snapshotStateList.clear();
        ArrayList arrayList = new ArrayList(va.x.y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MessageWithPartnerWithReactions) it.next()).getMessage().getId());
        }
        return arrayList;
    }

    private static final void ChatCardScreen$createAndSendDate(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new DateEditorParams(chatParams.getUid(), null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goDateEditor(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    private static final void ChatCardScreen$handleClickOnMention(ChatViewModel chatViewModel, final MutableState<Boolean> mutableState, final NavHostController navHostController, MessageEntity messageEntity) {
        ChatCardScreen$lambda$2(mutableState, true);
        if (messageEntity instanceof MentionName) {
            chatViewModel.goChatByMention((MentionName) messageEntity, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.u2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ChatCardScreenKt.ChatCardScreen$handleClickOnMention$lambda$63(navHostController, mutableState, (String) obj);
                }
            }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.f3
                @Override // lb.a
                public final Object invoke() {
                    return ChatCardScreenKt.ChatCardScreen$handleClickOnMention$lambda$64(mutableState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$handleClickOnMention$lambda$63(NavHostController navHostController, MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatCardScreen$lambda$2(mutableState, false);
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$handleClickOnMention$lambda$64(MutableState mutableState) {
        ChatCardScreen$lambda$2(mutableState, false);
        return ua.k0.f43947a;
    }

    private static final boolean ChatCardScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatCardScreen$lambda$10(MutableState<Function1> mutableState, Function1 function1) {
        mutableState.setValue(function1);
    }

    private static final Function1 ChatCardScreen$lambda$12(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final void ChatCardScreen$lambda$13(MutableState<Function1> mutableState, Function1 function1) {
        mutableState.setValue(function1);
    }

    private static final long ChatCardScreen$lambda$14(State<Long> state) {
        return state.getValue().longValue();
    }

    private static final PermissionsRequesterState ChatCardScreen$lambda$16(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    private static final void ChatCardScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final AttachmentPreviewState ChatCardScreen$lambda$21(MutableState<AttachmentPreviewState> mutableState) {
        return mutableState.getValue();
    }

    private static final PagerDialogData ChatCardScreen$lambda$24(MutableState<PagerDialogData> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ChatCardScreen$lambda$30(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatCardScreen$lambda$31(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatCardScreen$lambda$33(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatCardScreen$lambda$34(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$38$0(Context context, MutableState mutableState, SnapshotStateList snapshotStateList, Uri uri) {
        if (uri != null) {
            ChatCardScreen$lambda$34(mutableState, true);
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatCardScreen$addAttachedFileToSend(snapshotStateList, mutableState, Uri.fromFile(new File(path)));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$4(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        ChatCardScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$43$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, Uri uri) {
        if (uri != null) {
            ContactUtil contactUtil = ContactUtil.INSTANCE;
            Uri uriNormalizeScheme = uri.normalizeScheme();
            kotlin.jvm.internal.y.h(uriNormalizeScheme, "normalizeScheme(...)");
            ContactContent contactContentLoadContact = contactUtil.loadContact(context, uriNormalizeScheme);
            if (contactContentLoadContact != null) {
                chatViewModel.sendContact(chatParams.getUid(), contactContentLoadContact, null);
            }
        }
        return ua.k0.f43947a;
    }

    private static final boolean ChatCardScreen$lambda$44(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean ChatCardScreen$lambda$55(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatCardScreen$lambda$56(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatCardScreen$lambda$58(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatCardScreen$lambda$59(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatScreenState ChatCardScreen$lambda$6(State<ChatScreenState> state) {
        return state.getValue();
    }

    private static final boolean ChatCardScreen$lambda$61(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatCardScreen$lambda$62(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$65$0(ChatViewModel chatViewModel, Context context, State state, Uri uri) {
        if (uri != null) {
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatScreenState chatScreenStateChatCardScreen$lambda$6 = ChatCardScreen$lambda$6(state);
            kotlin.jvm.internal.y.f(chatScreenStateChatCardScreen$lambda$6);
            chatViewModel.setChatBackground(path, chatScreenStateChatCardScreen$lambda$6.getId());
        }
        return ua.k0.f43947a;
    }

    private static final String ChatCardScreen$lambda$67(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$69(final MutableState mutableState, final MutableState mutableState2, MutableState mutableState3, final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState4, final MutableState mutableState5, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        boolean z10 = false;
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2033476066, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous> (ChatCardScreen.kt:530)");
            }
            if (ChatCardScreen$lambda$21(mutableState) == null && le.d0.q0(ChatCardScreen$lambda$67(mutableState2)) && !ChatCardScreen$lambda$58(mutableState3)) {
                z10 = true;
            }
            AttachContainerKt.AnimateContainer(null, z10, ComposableLambdaKt.rememberComposableLambda(598089679, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.d5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatCardScreenKt.ChatCardScreen$lambda$69$0(mutableState, navHostController, snapshotStateList, chatViewModel, softwareKeyboardController, context, managedActivityResultLauncher, state, mutableState4, mutableState2, mutableState5, (Composer) obj, ((Integer) obj2).intValue());
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
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$69$0(MutableState mutableState, final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(598089679, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous>.<anonymous> (ChatCardScreen.kt:533)");
            }
            AttachContainerKt.AnimateContainer(null, ChatCardScreen$lambda$21(mutableState) == null, ComposableLambdaKt.rememberComposableLambda(-483527872, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.z2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0(navHostController, snapshotStateList, chatViewModel, softwareKeyboardController, context, managedActivityResultLauncher, state, mutableState2, mutableState3, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
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
    /* JADX WARN: Code duplicated, block: B:34:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:44:0x010e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0124  */
    /* JADX WARN: Code duplicated, block: B:52:0x0140  */
    /* JADX WARN: Code duplicated, block: B:57:0x0163  */
    /* JADX WARN: Code duplicated, block: B:60:0x01a2  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$69$0$0(final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) throws SinglediException {
        ChatScreenState chatScreenState;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        boolean zChangedInstance3;
        Object objRememberedValue5;
        boolean zChangedInstance4;
        Object objRememberedValue6;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-483527872, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous>.<anonymous>.<anonymous> (ChatCardScreen.kt:536)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ChatScreenState chatScreenStateChatCardScreen$lambda$6 = ChatCardScreen$lambda$6(state);
            int size = snapshotStateList.toList().size();
            Object objRememberedValue7 = composer.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue7 == companion2.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.n5
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            lb.a aVar = (lb.a) objRememberedValue7;
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == companion2.getEmpty()) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.p5
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            lb.a aVar2 = (lb.a) objRememberedValue8;
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == companion2.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.q5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$2$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            lb.a aVar3 = (lb.a) objRememberedValue9;
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == companion2.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.r5
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            lb.a aVar4 = (lb.a) objRememberedValue10;
            boolean zChatCardScreen$listIsForwardable = ChatCardScreen$listIsForwardable(snapshotStateList);
            boolean zChangedInstance5 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue11 = composer.rememberedValue();
            if (zChangedInstance5) {
                chatScreenState = chatScreenStateChatCardScreen$lambda$6;
            } else {
                chatScreenState = chatScreenStateChatCardScreen$lambda$6;
                if (objRememberedValue11 == companion2.getEmpty()) {
                }
                lb.a aVar5 = (lb.a) objRememberedValue11;
                zChanged = composer.changed(softwareKeyboardController);
                objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.u5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$5$0(softwareKeyboardController, snapshotStateList, mutableState2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar6 = (lb.a) objRememberedValue;
                zChangedInstance = composer.changedInstance(chatViewModel);
                objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.v5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$6$0(chatViewModel, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar7 = (lb.a) objRememberedValue2;
                zChangedInstance2 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
                objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.w5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$7$0(chatViewModel, context, snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                lb.a aVar8 = (lb.a) objRememberedValue3;
                objRememberedValue4 = composer.rememberedValue();
                if (objRememberedValue4 == companion2.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.x5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$8$0(snapshotStateList);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar9 = (lb.a) objRememberedValue4;
                zChangedInstance3 = composer.changedInstance(managedActivityResultLauncher);
                objRememberedValue5 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue5 == companion2.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.y5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$9$0(managedActivityResultLauncher, mutableState3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                lb.a aVar10 = (lb.a) objRememberedValue5;
                zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
                objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue6 == companion2.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.o5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$10$0(chatViewModel, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                ChatActionBarKt.ChatActionBar(companion, navHostController, chatScreenState, size, false, aVar, false, aVar2, false, aVar3, false, aVar4, zChatCardScreen$listIsForwardable, aVar5, true, aVar6, false, null, true, aVar7, aVar8, aVar9, aVar10, (lb.a) objRememberedValue6, null, null, null, composer, 920346630, 100687926, 48, 117637120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.s5
                @Override // lb.a
                public final Object invoke() {
                    return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$4$0(navHostController, chatViewModel, snapshotStateList);
                }
            };
            composer.updateRememberedValue(objRememberedValue11);
            lb.a aVar11 = (lb.a) objRememberedValue11;
            zChanged = composer.changed(softwareKeyboardController);
            objRememberedValue = composer.rememberedValue();
            if (zChanged) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.u5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$5$0(softwareKeyboardController, snapshotStateList, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.u5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$5$0(softwareKeyboardController, snapshotStateList, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar12 = (lb.a) objRememberedValue;
            zChangedInstance = composer.changedInstance(chatViewModel);
            objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.v5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$6$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.v5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$6$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar13 = (lb.a) objRememberedValue2;
            zChangedInstance2 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.w5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$7$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.w5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$7$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar14 = (lb.a) objRememberedValue3;
            objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion2.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.x5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$8$0(snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar15 = (lb.a) objRememberedValue4;
            zChangedInstance3 = composer.changedInstance(managedActivityResultLauncher);
            objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance3) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.y5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$9$0(managedActivityResultLauncher, mutableState3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.y5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$9$0(managedActivityResultLauncher, mutableState3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar16 = (lb.a) objRememberedValue5;
            zChangedInstance4 = composer.changedInstance(chatViewModel) | composer.changed(state);
            objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance4) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.o5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$10$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.o5
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$69$0$0$10$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            ChatActionBarKt.ChatActionBar(companion, navHostController, chatScreenState, size, false, aVar, false, aVar2, false, aVar3, false, aVar4, zChatCardScreen$listIsForwardable, aVar11, true, aVar12, false, null, true, aVar13, aVar14, aVar15, aVar16, (lb.a) objRememberedValue6, null, null, null, composer, 920346630, 100687926, 48, 117637120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$69$0$0$10$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatCardScreen$lambda$6 = ChatCardScreen$lambda$6(state);
        kotlin.jvm.internal.y.f(chatScreenStateChatCardScreen$lambda$6);
        chatViewModel.removeChatBackground(chatScreenStateChatCardScreen$lambda$6.getId());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$69$0$0$2$0(MutableState mutableState) {
        ChatCardScreen$lambda$56(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$69$0$0$4$0(NavHostController navHostController, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        List<String> listChatCardScreen$clearSelection = ChatCardScreen$clearSelection(snapshotStateList);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listChatCardScreen$clearSelection.iterator();
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
    public static final ua.k0 ChatCardScreen$lambda$69$0$0$5$0(SoftwareKeyboardController softwareKeyboardController, SnapshotStateList snapshotStateList, MutableState mutableState) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        mutableState.setValue((String) va.g0.w0(ChatCardScreen$clearSelection(snapshotStateList)));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$69$0$0$6$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        chatViewModel.share(ChatCardScreen$clearSelection(snapshotStateList));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$69$0$0$7$0(ChatViewModel chatViewModel, Context context, SnapshotStateList snapshotStateList) {
        chatViewModel.pastToClipboard(ChatCardScreen$clearSelection(snapshotStateList), context);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$69$0$0$8$0(SnapshotStateList snapshotStateList) {
        ChatCardScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$69$0$0$9$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        Integer state = ChatCardScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            managedActivityResultLauncher.launch("image/*");
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatCardScreen$lambda$16(mutableState), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    private static final FlowsState<Friend> ChatCardScreen$lambda$7(State<FlowsState<Friend>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 34251. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final ua.k0 ChatCardScreen$lambda$70(androidx.compose.runtime.snapshots.SnapshotStateList r79, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r80, androidx.compose.runtime.State r81, androidx.compose.foundation.text.input.TextFieldState r82, androidx.navigation.NavHostController r83, cu.todus.android.uiCompose.main.screen.chat.component.ChatParams r84, androidx.compose.runtime.MutableState r85, pe.m0 r86, androidx.compose.runtime.snapshots.SnapshotStateList r87, androidx.compose.runtime.MutableState r88, androidx.compose.runtime.MutableState r89, androidx.paging.compose.LazyPagingItems r90, androidx.compose.ui.platform.SoftwareKeyboardController r91, android.content.Context r92, androidx.compose.runtime.MutableState r93, androidx.compose.runtime.MutableState r94, androidx.compose.runtime.MutableState r95, androidx.compose.runtime.MutableState r96, androidx.p000activity.compose.ManagedActivityResultLauncher r97, androidx.compose.runtime.MutableState r98, androidx.p000activity.compose.ManagedActivityResultLauncher r99, androidx.compose.runtime.MutableState r100, androidx.paging.compose.LazyPagingItems r101, androidx.paging.compose.LazyPagingItems r102, androidx.paging.compose.LazyPagingItems r103, androidx.compose.ui.focus.FocusRequester r104, androidx.compose.runtime.State r105, androidx.compose.runtime.MutableState r106, androidx.compose.runtime.State r107, androidx.compose.runtime.MutableState r108, androidx.compose.runtime.State r109, androidx.compose.runtime.MutableState r110, cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1 r111, androidx.compose.ui.Modifier r112, androidx.compose.runtime.Composer r113, int r114) {
        /*
            Method dump skipped, instruction units count: 3425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt.ChatCardScreen$lambda$70(androidx.compose.runtime.snapshots.SnapshotStateList, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel, androidx.compose.runtime.State, androidx.compose.foundation.text.input.TextFieldState, androidx.navigation.NavHostController, cu.todus.android.uiCompose.main.screen.chat.component.ChatParams, androidx.compose.runtime.MutableState, pe.m0, androidx.compose.runtime.snapshots.SnapshotStateList, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.paging.compose.LazyPagingItems, androidx.compose.ui.platform.SoftwareKeyboardController, android.content.Context, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.paging.compose.LazyPagingItems, androidx.paging.compose.LazyPagingItems, androidx.paging.compose.LazyPagingItems, androidx.compose.ui.focus.FocusRequester, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):ua.k0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$0$0$0(ChatViewModel chatViewModel, ChatParams chatParams, final MutableState mutableState, final NavHostController navHostController) {
        ChatCardScreen$lambda$2(mutableState, true);
        chatViewModel.leaveAndDeleteCard(chatParams.getUid(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.q3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$lambda$70$0$0$0$0(navHostController, mutableState, ((Boolean) obj).booleanValue());
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$0$0$0$0(NavHostController navHostController, MutableState mutableState, boolean z10) {
        ChatCardScreen$lambda$2(mutableState, false);
        if (z10) {
            navHostController.navigateUp();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatCardScreen$lambda$70$1$0$0(LazyListState lazyListState) {
        return lazyListState.getFirstVisibleItemIndex() == 0;
    }

    private static final boolean ChatCardScreen$lambda$70$1$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$10$0(MutableState mutableState) {
        ChatCardScreen$lambda$62(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$70$1$11(LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, final NavHostController navHostController, final ChatViewModel chatViewModel, final MutableState mutableState, final ChatParams chatParams, final FocusRequester focusRequester, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-431230288, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous>.<anonymous>.<anonymous> (ChatCardScreen.kt:1000)");
            }
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.i6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$11$0$0(navHostController, chatViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.j6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$11$1$0(chatViewModel, chatParams, focusRequester, mutableState, (Sticker) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new ChatCardScreenKt$ChatCardScreen$4$2$10$3$1(chatViewModel);
                composer.updateRememberedValue(objRememberedValue3);
            }
            int i11 = LazyPagingItems.$stable;
            GroupsContainerKt.GroupsContainer(lazyPagingItems, lazyPagingItems2, lazyPagingItems3, aVar, function1, (Function2) ((sb.h) objRememberedValue3), composer, (i11 << 3) | i11 | (i11 << 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$11$0$0(NavHostController navHostController, ChatViewModel chatViewModel, MutableState mutableState) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(null, 1, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        ChatCardScreen$lambda$62(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$11$1$0(ChatViewModel chatViewModel, ChatParams chatParams, FocusRequester focusRequester, MutableState mutableState, Sticker it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.sendSticker(chatParams.getUid(), it, null);
        ChatCardScreen$lambda$62(mutableState, false);
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$70$1$12(TextFieldState textFieldState, final ChatViewModel chatViewModel, final Context context, FocusRequester focusRequester, State state, MutableState mutableState, final MutableState mutableState2, SnapshotStateList snapshotStateList, ChatParams chatParams, MutableState mutableState3, final MutableState mutableState4, Composer composer, int i10) {
        Object obj;
        final MutableState mutableState5;
        final SnapshotStateList snapshotStateList2;
        final ChatParams chatParams2;
        final MutableState mutableState6;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2102631685, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous>.<anonymous>.<anonymous> (ChatCardScreen.kt:1038)");
            }
            long jChatCardScreen$lambda$14 = ChatCardScreen$lambda$14(state);
            boolean zChatCardScreen$lambda$33 = ChatCardScreen$lambda$33(mutableState);
            boolean zChatCardScreen$lambda$61 = ChatCardScreen$lambda$61(mutableState2);
            boolean zChangedInstance = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState5 = mutableState;
                snapshotStateList2 = snapshotStateList;
                chatParams2 = chatParams;
                mutableState6 = mutableState3;
                obj = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.a3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$12$0$0(chatViewModel, snapshotStateList2, chatParams2, context, mutableState5, mutableState6, (String) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                mutableState5 = mutableState;
                chatParams2 = chatParams;
                mutableState6 = mutableState3;
                obj = objRememberedValue;
                snapshotStateList2 = snapshotStateList;
            }
            Function1 function1 = (Function1) obj;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.b3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$12$1$0(chatViewModel, chatParams2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.c3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$12$2$0(chatViewModel, chatParams2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar2 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(chatViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.d3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$12$3$0(chatViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar3 = (lb.a) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.e3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$12$4$0(snapshotStateList2, mutableState5, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar4 = (lb.a) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.g3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$12$5$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar5 = (lb.a) objRememberedValue6;
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.h3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$12$6$0(snapshotStateList2, mutableState5, mutableState6, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ChatInputKt.ChatInput(textFieldState, null, function1, aVar, aVar2, aVar3, aVar4, aVar5, (lb.a) objRememberedValue7, zChatCardScreen$lambda$33, jChatCardScreen$lambda$14, focusRequester, zChatCardScreen$lambda$61, composer, 114819072, 48, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$12$0$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, ChatParams chatParams, Context context, MutableState mutableState, MutableState mutableState2, String messageContent) {
        kotlin.jvm.internal.y.i(messageContent, "messageContent");
        chatViewModel.sendTyping(false);
        if (snapshotStateList.isEmpty()) {
            ChatViewModel.sendMessage$default(chatViewModel, messageContent, chatParams.getUid(), false, null, null, null, null, 76, null);
        } else {
            ChatCardScreen$selectMethodAndSend(chatParams, chatViewModel, context, snapshotStateList, mutableState, mutableState2, messageContent);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$12$1$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.startRecorder(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$12$2$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.stopRecorderAndSend(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$12$3$0(ChatViewModel chatViewModel) {
        chatViewModel.stopRecorder();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$12$4$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatCardScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        ChatCardScreen$lambda$31(mutableState2, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$12$5$0(MutableState mutableState) {
        ChatCardScreen$lambda$62(mutableState, !ChatCardScreen$lambda$61(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$12$6$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        ChatCardScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        ChatCardScreen$lambda$59(mutableState3, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$2$0(pe.m0 m0Var, LazyListState lazyListState, boolean z10) {
        pe.k.d(m0Var, null, null, new ChatCardScreenKt$ChatCardScreen$4$2$1$1$1(z10, lazyListState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$3$0(pe.m0 m0Var, LazyListState lazyListState, int i10) {
        pe.k.d(m0Var, null, null, new ChatCardScreenKt$ChatCardScreen$4$2$2$1$1(lazyListState, i10, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$10$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, SoftwareKeyboardController softwareKeyboardController, Context context, State state, NavHostController navHostController, ChatParams chatParams, TextFieldState textFieldState, MutableState mutableState, MutableState mutableState2, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions msg, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        kotlin.jvm.internal.y.i(msg, "msg");
        if (msg.getMessage().getState() == 4) {
            chatViewModel.tryResend(msg.getMessage().getId());
        } else if (ChatCardScreen$selectedListIsEmpty(snapshotStateList)) {
            ChatCardScreen$attachmentClicked(softwareKeyboardController, chatViewModel, context, state, navHostController, chatParams, textFieldState, mutableState, mutableState2, z10, messageAction, msg, i10);
        } else if (ChatCardScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            ChatCardScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            ChatCardScreen$addItemToSelected(snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$11$0(SnapshotStateList snapshotStateList, ChatViewModel chatViewModel, MessageWithPartnerWithReactions msg, int i10) {
        kotlin.jvm.internal.y.i(msg, "msg");
        if (ChatCardScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            ChatCardScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            ChatCardScreen$addItemToSelected(snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$12$0(ChatViewModel chatViewModel, Context context, TextFieldState textFieldState, MutableState mutableState, NavHostController navHostController, MessageWithPartnerWithReactions msg, MessageAction messageAction, String value) {
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
            ChatCardScreen$handleClickOnMention(chatViewModel, mutableState, navHostController, mentionName);
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
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$13$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState) {
        chatViewModel.displayAllMsg(chatParams.getUid());
        Function1 function1ChatCardScreen$lambda$9 = ChatCardScreen$lambda$9(mutableState);
        if (function1ChatCardScreen$lambda$9 != null) {
            function1ChatCardScreen$lambda$9.invoke(Boolean.FALSE);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$4$0(MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$5$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, String roomId, String msgId, String value) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(value, "value");
        ChatCardScreen$clearSelection(snapshotStateList);
        chatViewModel.onReacted(roomId, msgId, value);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$6$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.REACT_SELECTION, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$7$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$8$0(int i10) {
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$9$0(final ChatViewModel chatViewModel, final NavHostController navHostController, final String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.getStatusPosition(it, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.i3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$lambda$70$1$4$9$0$0(navHostController, chatViewModel, it, (Pair) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$4$9$0$0(NavHostController navHostController, ChatViewModel chatViewModel, String str, Pair result) {
        kotlin.jvm.internal.y.i(result, "result");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new StatusPreviewParams(((Boolean) result.getFirst()).booleanValue(), ((Number) result.getSecond()).intValue(), str));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$5$0$0(ChatViewModel chatViewModel, ChatParams chatParams, final MutableState mutableState, final NavHostController navHostController) {
        ChatCardScreen$lambda$2(mutableState, true);
        chatViewModel.subscribe(chatParams.getUid(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.c5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$lambda$70$1$5$0$0$0(navHostController, mutableState, ((Boolean) obj).booleanValue());
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$5$0$0$0(NavHostController navHostController, MutableState mutableState, boolean z10) {
        ChatCardScreen$lambda$2(mutableState, false);
        if (z10) {
            navHostController.navigate(NavLinks.HOME, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.z5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ChatCardScreenKt.ChatCardScreen$lambda$70$1$5$0$0$0$0((NavOptionsBuilder) obj);
                }
            });
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$5$0$0$0$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$6$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatCardScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$70$1$7(final SnapshotStateList snapshotStateList, final ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-852617160, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous>.<anonymous>.<anonymous> (ChatCardScreen.kt:923)");
            }
            Integer state = ChatCardScreen$lambda$16(mutableState).getPermissionsResult().getState();
            if (state != null && state.intValue() == 2) {
                composer.startReplaceGroup(118870249);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.k6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$70$1$7$0$0(snapshotStateList, mutableState2, mutableState3, (Uri) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.l6
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatCardScreenKt.ChatCardScreen$lambda$70$1$7$1$0(managedActivityResultLauncher);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                PresentListKt.PresentList(snapshotStateList, function1, (lb.a) objRememberedValue2, composer, 54);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(119301738);
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
    public static final ua.k0 ChatCardScreen$lambda$70$1$7$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, Uri it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatCardScreen$removeAttachedFilesToSend(snapshotStateList, mutableState, mutableState2, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$7$1$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("*/*");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$8$0(MutableState mutableState) {
        ChatCardScreen$lambda$31(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$70$1$9(final ChatViewModel chatViewModel, final ManagedActivityResultLauncher managedActivityResultLauncher, final NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher2, final Context context, final TextFieldState textFieldState, final MutableState mutableState, final MutableState mutableState2, final SnapshotStateList snapshotStateList, final MutableState mutableState3, final ChatParams chatParams, final MutableState mutableState4, Composer composer, int i10) {
        final MutableState mutableState5;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2034530671, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous>.<anonymous>.<anonymous> (ChatCardScreen.kt:941)");
            }
            v5.f gson = chatViewModel.getGson();
            List<BotShortcut> attachmentShortcuts = chatViewModel.getAttachmentShortcuts();
            boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState5 = mutableState3;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.a6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$9$0$0(managedActivityResultLauncher, mutableState, mutableState2, snapshotStateList, mutableState5);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            } else {
                mutableState5 = mutableState3;
            }
            lb.a aVar2 = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.b6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$9$1$0(navHostController, chatViewModel, chatParams, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar3 = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.c6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$9$2$0(navHostController, chatViewModel, chatParams, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar4 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(managedActivityResultLauncher2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.d6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$9$3$0(managedActivityResultLauncher2, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar5 = (lb.a) objRememberedValue4;
            boolean zChangedInstance5 = composer.changedInstance(navHostController);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.f6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$9$4$0(navHostController, chatParams, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar6 = (lb.a) objRememberedValue5;
            boolean zChangedInstance6 = composer.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.g6
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$9$5$0(managedActivityResultLauncher, mutableState, mutableState2, snapshotStateList, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar7 = (lb.a) objRememberedValue6;
            boolean zChangedInstance7 = composer.changedInstance(context) | composer.changedInstance(chatViewModel) | composer.changedInstance(navHostController) | composer.changed(textFieldState);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.h6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatCardScreenKt.ChatCardScreen$lambda$70$1$9$6$0(context, chatViewModel, chatParams, navHostController, textFieldState, mutableState4, mutableState3, (ButtonContent) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue7 = function1;
            }
            AttachmentSelectorKt.AttachmentSelector(aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, (Function1) objRememberedValue7, gson, attachmentShortcuts, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$9$0$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = ChatCardScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatCardScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (ChatCardScreen$lambda$33(mutableState2)) {
            ChatCardScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch("*/*");
        }
        ChatCardScreen$lambda$31(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$9$1$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState) {
        ChatCardScreen$createAndSendDate(navHostController, chatViewModel, chatParams);
        ChatCardScreen$lambda$31(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$9$2$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState) {
        ChatCardScreen$selectMapLocation(navHostController, chatViewModel, chatParams);
        ChatCardScreen$lambda$31(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$9$3$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        managedActivityResultLauncher.launch(null);
        ChatCardScreen$lambda$31(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$9$4$0(NavHostController navHostController, ChatParams chatParams, MutableState mutableState) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goPubEditor(chatParams.getUid()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        ChatCardScreen$lambda$31(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$9$5$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = ChatCardScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatCardScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (ChatCardScreen$lambda$33(mutableState2)) {
            ChatCardScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch(VideoSpec.MIME_TYPE_UNSPECIFIED);
        }
        ChatCardScreen$lambda$31(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$1$9$6$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, NavHostController navHostController, TextFieldState textFieldState, MutableState mutableState, MutableState mutableState2, ButtonContent it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatCardScreen$onClickInShortcut(context, chatViewModel, chatParams, navHostController, textFieldState, mutableState, it);
        ChatCardScreen$lambda$31(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$0$0(ChatViewModel chatViewModel) {
        chatViewModel.readRequestingFriend();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$1$0(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$10$0(MutableState mutableState) {
        ChatCardScreen$lambda$59(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$70$2$11(final MutableState mutableState, final ChatViewModel chatViewModel, final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1794299947, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous>.<anonymous>.<anonymous> (ChatCardScreen.kt:1179)");
            }
            AttachmentPreviewState attachmentPreviewStateChatCardScreen$lambda$21 = ChatCardScreen$lambda$21(mutableState);
            if (attachmentPreviewStateChatCardScreen$lambda$21 == null) {
                composer.startReplaceGroup(1173304553);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1173304554);
                boolean zChangedInstance = composer.changedInstance(chatViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.e5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$70$2$11$0$0$0(chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.f5
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatCardScreenKt.ChatCardScreen$lambda$70$2$11$0$1$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar = (lb.a) objRememberedValue2;
                boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.g5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatCardScreenKt.ChatCardScreen$lambda$70$2$11$0$2$0(navHostController, chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                AttachmentPreviewKt.AttachmentPreviewWithOptions(attachmentPreviewStateChatCardScreen$lambda$21, function1, aVar, (Function1) objRememberedValue3, null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 16);
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
    public static final ua.k0 ChatCardScreen$lambda$70$2$11$0$0$0(ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.share(va.v.e(it));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$11$0$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$11$0$2$0(NavHostController navHostController, ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(it));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$12$0(MutableState mutableState) {
        mutableState.setValue("");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatCardScreen$lambda$70$2$13(NavHostController navHostController, MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(840200018, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreen.<anonymous>.<anonymous>.<anonymous> (ChatCardScreen.kt:1204)");
            }
            MsgDetailsDialogKt.MsgDetailsDialog(ChatCardScreen$lambda$67(mutableState), navHostController, null, composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$14$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatCardScreen$lambda$16(mutableState), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$15$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatCardScreen$lambda$16(mutableState), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$16$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatCardScreen$lambda$16(mutableState), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$17$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatCardScreen$lambda$16(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatCardScreen$lambda$16(mutableState), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$2$0(MutableState mutableState) {
        ChatCardScreen$lambda$56(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$5$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$6$0(TextFieldState textFieldState, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, String value, boolean z10) {
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
    public static final ua.k0 ChatCardScreen$lambda$70$2$7$0(ChatParams chatParams, ChatViewModel chatViewModel, MutableState mutableState, List files, String content) {
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        chatViewModel.sendVideos(chatParams.getUid(), files, content, null);
        ChatCardScreen$lambda$59(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$8$0(ChatParams chatParams, ChatViewModel chatViewModel, MutableState mutableState, List files, String content) {
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        chatViewModel.sendImages(chatParams.getUid(), files, content, null);
        ChatCardScreen$lambda$59(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$2$9$0(MutableState mutableState) {
        ChatCardScreen$lambda$59(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$70$3$0(SnapshotStateList snapshotStateList) {
        ChatCardScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ChatCardScreen$lambda$70$6$0(final ChatViewModel chatViewModel, final TextFieldState textFieldState, final ChatParams chatParams, final ChatCardScreenKt$ChatCardScreen$notificationFilter$1$1 chatCardScreenKt$ChatCardScreen$notificationFilter$1$1, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt$ChatCardScreen$lambda$70$6$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                chatViewModel.setRoomDraft(textFieldState.getText().toString(), chatParams.getUid());
                chatViewModel.stopRecorder();
                chatViewModel.getNotificationManager().unRegister(chatCardScreenKt$ChatCardScreen$notificationFilter$1$1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$lambda$71(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        ChatCardScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 ChatCardScreen$lambda$9(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ChatCardScreen$listIsForwardable(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
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

    private static final void ChatCardScreen$onClickInShortcut(Context context, final ChatViewModel chatViewModel, final ChatParams chatParams, final NavHostController navHostController, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, ButtonContent buttonContent) {
        ChatButtonsFunctionality.INSTANCE.handleClick(buttonContent, context, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.h5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$onClickInShortcut$lambda$26(chatViewModel, chatParams, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.j5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$onClickInShortcut$lambda$27(navHostController, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.k5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatCardScreenKt.ChatCardScreen$onClickInShortcut$lambda$28(textFieldState, (String) obj);
            }
        }, new ChatCardScreenKt$ChatCardScreen$onClickInShortcut$4(mutableState), (64 & 64) != 0 ? new Function1() { // from class: q7.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatButtonsFunctionality.handleClick$lambda$0((BotShortcut) obj);
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$onClickInShortcut$lambda$26(ChatViewModel chatViewModel, ChatParams chatParams, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatViewModel.sendMessage$default(chatViewModel, it, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$onClickInShortcut$lambda$27(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$onClickInShortcut$lambda$28(TextFieldState textFieldState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatCardScreen$onDelete(ChatViewModel chatViewModel, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteMessages(ChatCardScreen$clearSelection(snapshotStateList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatCardScreen$onDeleteToAll(ChatViewModel chatViewModel, ChatParams chatParams, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteForAll(chatParams.getUid(), ChatCardScreen$clearSelection(snapshotStateList));
    }

    private static final void ChatCardScreen$removeAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Uri uri) {
        if (snapshotStateList.size() == 1) {
            ChatCardScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        } else {
            snapshotStateList.remove(uri);
        }
    }

    private static final void ChatCardScreen$removeItemFromSelected(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, final String str) {
        final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.l5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ChatCardScreenKt.ChatCardScreen$removeItemFromSelected$lambda$48(str, (MessageWithPartnerWithReactions) obj));
            }
        };
        Collection.EL.removeIf(snapshotStateList, new Predicate() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.m5
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
                return ChatCardScreenKt.ChatCardScreen$removeItemFromSelected$lambda$49(function1, obj);
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
    public static final boolean ChatCardScreen$removeItemFromSelected$lambda$48(String str, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getMessage().getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatCardScreen$removeItemFromSelected$lambda$49(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private static final void ChatCardScreen$selectMapLocation(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new MapParams(MapMotive.SELECT, chatParams.getUid(), null, null, 8, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goMap(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    private static final void ChatCardScreen$selectMethodAndSend(ChatParams chatParams, ChatViewModel chatViewModel, Context context, final SnapshotStateList<Uri> snapshotStateList, final MutableState<Boolean> mutableState, final MutableState<Boolean> mutableState2, String str) {
        ChatComplexFunctionalities.INSTANCE.selectMethodAndSend(str, chatParams.getUid(), null, context, snapshotStateList, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.b5
            @Override // lb.a
            public final Object invoke() {
                return ChatCardScreenKt.ChatCardScreen$selectMethodAndSend$lambda$37(snapshotStateList, mutableState, mutableState2);
            }
        }, new ChatCardScreenKt$ChatCardScreen$selectMethodAndSend$1(chatViewModel), new ChatCardScreenKt$ChatCardScreen$selectMethodAndSend$2(chatViewModel), new ChatCardScreenKt$ChatCardScreen$selectMethodAndSend$3(chatViewModel), new ChatCardScreenKt$ChatCardScreen$selectMethodAndSend$4(chatViewModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatCardScreen$selectMethodAndSend$lambda$37(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatCardScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x002a A[RETURN] */
    public static final boolean ChatCardScreen$selectedContains(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, String str) {
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

    private static final boolean ChatCardScreen$selectedListIsEmpty(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        return snapshotStateList.toList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatCardScreen$setPlaceholderData(MutableState<PagerDialogData> mutableState, String str, ButtonTemplate buttonTemplate, boolean z10) {
        mutableState.setValue(new PagerDialogData(str, buttonTemplate, z10, null, 8, null));
    }
}
