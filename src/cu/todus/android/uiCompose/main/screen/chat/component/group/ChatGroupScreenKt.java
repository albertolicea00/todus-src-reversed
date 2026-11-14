package cu.todus.android.uiCompose.main.screen.chat.component.group;

import android.content.Context;
import android.net.Uri;
import androidx.camera.video.VideoSpec;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p000activity.compose.ManagedActivityResultLauncher;
import androidx.paging.compose.LazyPagingItems;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.BotShortcut;
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
import cu.todus.android.domain.handlers.Send;
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
import cu.todus.android.uiCompose.main.screen.chat.mentionList.MentionItemModel;
import cu.todus.android.uiCompose.main.screen.chat.mentionList.MentionListKt;
import cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialogData;
import cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt;
import cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt;
import cu.todus.android.uiCompose.main.screen.chat.preview.PinnedMsg;
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
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.XMPPUtils;
import cu.z17.singledi.SinglediException;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
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

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006*²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\nX\u008a\u0084\u0002²\u0006\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0015\u001a\u00020\u00148\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00188\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001c\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001e\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001f\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010 \u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010!\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\"\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\f\u0010#\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010$\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\nX\u008a\u0084\u0002²\u0006\u000e\u0010(\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010)\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;", "viewModel", "Lua/k0;", "ChatGroupScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "chatScreenState", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/data/db/pojo/Friend;", "requestedFriendByContact", "Lkotlin/Function1;", "scrollBottom", "", "scrollToPosition", "", "actualRecorderTime", "Lcu/z17/views/permission/PermissionsRequesterState;", "mediaPermissionsState", "Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogData;", "createPlaceholderMsg", "Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "attachmentPreview", "showAttachmentSelector", "isPickingFiles", "showDeleteForEveryone", "showDeleteDialog", "openCamera", "showStickers", "msgDetailId", "showUnknown", "showPinnedMsg", "", "Lcu/todus/android/uiCompose/main/screen/chat/mentionList/MentionItemModel;", "mentionList", "openMention", "firstItemVisible", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatGroupScreenKt {

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

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v7 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @android.annotation.SuppressLint({"CoroutineCreationDuringComposition"})
    public static final void ChatGroupScreen(androidx.navigation.NavHostController r60, java.lang.String r61, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r62, androidx.compose.runtime.Composer r63, int r64, int r65) {
        /*
            Method dump skipped, instruction units count: 1483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreenKt.ChatGroupScreen(androidx.navigation.NavHostController, java.lang.String, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void ChatGroupScreen$addAttachedFileToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, Uri uri) {
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
        ChatGroupScreen$lambda$35(mutableState, true);
    }

    private static final void ChatGroupScreen$addItemToSelected(MutableState<MessageWithPartnerWithReactions> mutableState, MutableState<MessageWithPartnerWithReactions> mutableState2, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, MessageWithPartnerWithReactions messageWithPartnerWithReactions) {
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

    private static final void ChatGroupScreen$attachmentClicked(SoftwareKeyboardController softwareKeyboardController, Context context, final ChatViewModel chatViewModel, final NavHostController navHostController, final ChatParams chatParams, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, State<ChatScreenState> state, final MutableState<AttachmentPreviewState> mutableState2, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions messageWithPartnerWithReactions, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.m3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatGroupScreenKt.ChatGroupScreen$attachmentClicked$lambda$40(navHostController, (String) obj);
            }
        };
        ChatGroupScreenKt$ChatGroupScreen$attachmentClicked$2 chatGroupScreenKt$ChatGroupScreen$attachmentClicked$2 = new ChatGroupScreenKt$ChatGroupScreen$attachmentClicked$2(chatViewModel);
        ChatGroupScreenKt$ChatGroupScreen$attachmentClicked$3 chatGroupScreenKt$ChatGroupScreen$attachmentClicked$3 = new ChatGroupScreenKt$ChatGroupScreen$attachmentClicked$3(chatViewModel);
        ChatGroupScreenKt$ChatGroupScreen$attachmentClicked$4 chatGroupScreenKt$ChatGroupScreen$attachmentClicked$4 = new ChatGroupScreenKt$ChatGroupScreen$attachmentClicked$4(chatViewModel);
        Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.n3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatGroupScreenKt.ChatGroupScreen$attachmentClicked$lambda$41(chatViewModel, chatParams, (String) obj);
            }
        };
        Function1 function3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.o3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatGroupScreenKt.ChatGroupScreen$attachmentClicked$lambda$42(textFieldState, (String) obj);
            }
        };
        ChatGroupScreenKt$ChatGroupScreen$attachmentClicked$7 chatGroupScreenKt$ChatGroupScreen$attachmentClicked$7 = new ChatGroupScreenKt$ChatGroupScreen$attachmentClicked$7(mutableState);
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
        chatComplexFunctionalities.attachmentClicked(messageAction, i10, z10, messageWithPartnerWithReactions, context, gson, function1, chatGroupScreenKt$ChatGroupScreen$attachmentClicked$2, chatGroupScreenKt$ChatGroupScreen$attachmentClicked$3, chatGroupScreenKt$ChatGroupScreen$attachmentClicked$4, function2, function3, chatGroupScreenKt$ChatGroupScreen$attachmentClicked$7, chatScreenStateChatGroupScreen$lambda$6 != null ? chatScreenStateChatGroupScreen$lambda$6.isSecret() : false, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.p3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatGroupScreenKt.ChatGroupScreen$attachmentClicked$lambda$43(mutableState2, (AttachmentPreviewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$attachmentClicked$lambda$40(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$attachmentClicked$lambda$41(ChatViewModel chatViewModel, ChatParams chatParams, String msgContent) {
        kotlin.jvm.internal.y.i(msgContent, "msgContent");
        ChatViewModel.sendMessage$default(chatViewModel, msgContent, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$attachmentClicked$lambda$42(TextFieldState textFieldState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$attachmentClicked$lambda$43(MutableState mutableState, AttachmentPreviewState it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    private static final void ChatGroupScreen$clearAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        snapshotStateList.clear();
        ChatGroupScreen$lambda$35(mutableState, false);
        ChatGroupScreen$lambda$32(mutableState2, false);
    }

    private static final List<String> ChatGroupScreen$clearSelection(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        List<MessageWithPartnerWithReactions> list = snapshotStateList.toList();
        snapshotStateList.clear();
        ArrayList arrayList = new ArrayList(va.x.y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MessageWithPartnerWithReactions) it.next()).getMessage().getId());
        }
        return arrayList;
    }

    private static final void ChatGroupScreen$createAndSendDate(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState) {
        Message message;
        NavLinks navLinks = NavLinks.INSTANCE;
        v5.f gson = chatViewModel.getGson();
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        String strT = gson.t(new DateEditorParams(uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId()));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goDateEditor(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatGroupScreen$handleAutoOpenMentionList(State<String> state, State<? extends List<MentionItemModel>> state2, MutableState<Boolean> mutableState) {
        String value = state.getValue();
        if (value == null || !le.a0.U(value, "@", false, 2, null) || ChatGroupScreen$lambda$75(state2).isEmpty()) {
            ChatGroupScreen$lambda$78(mutableState, false);
        } else {
            if (ChatGroupScreen$lambda$77(mutableState)) {
                return;
            }
            ChatGroupScreen$lambda$78(mutableState, true);
        }
    }

    private static final void ChatGroupScreen$handleClickOnMention(ChatViewModel chatViewModel, final MutableState<Boolean> mutableState, final NavHostController navHostController, MessageEntity messageEntity) {
        ChatGroupScreen$lambda$2(mutableState, true);
        if (messageEntity instanceof MentionName) {
            chatViewModel.goChatByMention((MentionName) messageEntity, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.j5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ChatGroupScreenKt.ChatGroupScreen$handleClickOnMention$lambda$79(navHostController, mutableState, (String) obj);
                }
            }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.u5
                @Override // lb.a
                public final Object invoke() {
                    return ChatGroupScreenKt.ChatGroupScreen$handleClickOnMention$lambda$80(mutableState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$handleClickOnMention$lambda$79(NavHostController navHostController, MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatGroupScreen$lambda$2(mutableState, false);
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$handleClickOnMention$lambda$80(MutableState mutableState) {
        ChatGroupScreen$lambda$2(mutableState, false);
        return ua.k0.f43947a;
    }

    private static final boolean ChatGroupScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatGroupScreen$lambda$10(MutableState<Function1> mutableState, Function1 function1) {
        mutableState.setValue(function1);
    }

    private static final Function1 ChatGroupScreen$lambda$12(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final void ChatGroupScreen$lambda$13(MutableState<Function1> mutableState, Function1 function1) {
        mutableState.setValue(function1);
    }

    private static final long ChatGroupScreen$lambda$14(State<Long> state) {
        return state.getValue().longValue();
    }

    private static final PermissionsRequesterState ChatGroupScreen$lambda$16(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    private static final void ChatGroupScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final PagerDialogData ChatGroupScreen$lambda$22(MutableState<PagerDialogData> mutableState) {
        return mutableState.getValue();
    }

    private static final AttachmentPreviewState ChatGroupScreen$lambda$28(MutableState<AttachmentPreviewState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ChatGroupScreen$lambda$31(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatGroupScreen$lambda$32(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatGroupScreen$lambda$34(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatGroupScreen$lambda$35(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$39$0(Context context, MutableState mutableState, SnapshotStateList snapshotStateList, Uri uri) {
        if (uri != null) {
            ChatGroupScreen$lambda$35(mutableState, true);
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatGroupScreen$addAttachedFileToSend(snapshotStateList, mutableState, Uri.fromFile(new File(path)));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$4(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        ChatGroupScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$44$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, Uri uri) {
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

    private static final boolean ChatGroupScreen$lambda$45(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean ChatGroupScreen$lambda$56(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatGroupScreen$lambda$57(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatGroupScreen$lambda$59(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatScreenState ChatGroupScreen$lambda$6(State<ChatScreenState> state) {
        return state.getValue();
    }

    private static final void ChatGroupScreen$lambda$60(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean ChatGroupScreen$lambda$62(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatGroupScreen$lambda$63(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$64$0(ChatViewModel chatViewModel, Context context, State state, Uri uri) {
        if (uri != null) {
            String path = MediaUtil.INSTANCE.getPath(context, uri);
            if (path == null) {
                path = "";
            }
            ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
            kotlin.jvm.internal.y.f(chatScreenStateChatGroupScreen$lambda$6);
            chatViewModel.setChatBackground(path, chatScreenStateChatGroupScreen$lambda$6.getId());
        }
        return ua.k0.f43947a;
    }

    private static final String ChatGroupScreen$lambda$66(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatGroupScreen$lambda$68$0(State state) {
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
        if (!kotlin.jvm.internal.y.d(chatScreenStateChatGroupScreen$lambda$6 != null ? chatScreenStateChatGroupScreen$lambda$6.getUnknownUserState() : null, "new")) {
            return false;
        }
        ChatScreenState chatScreenStateChatGroupScreen$lambda$7 = ChatGroupScreen$lambda$6(state);
        if (kotlin.jvm.internal.y.d(chatScreenStateChatGroupScreen$lambda$7 != null ? chatScreenStateChatGroupScreen$lambda$7.getAffiliation() : null, "none")) {
            return false;
        }
        ChatScreenState chatScreenStateChatGroupScreen$lambda$8 = ChatGroupScreen$lambda$6(state);
        return !kotlin.jvm.internal.y.d(chatScreenStateChatGroupScreen$lambda$8 != null ? chatScreenStateChatGroupScreen$lambda$8.getAffiliation() : null, UserRoomJoin.AFFILIATION_OWNER);
    }

    private static final boolean ChatGroupScreen$lambda$69(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final FlowsState<Friend> ChatGroupScreen$lambda$7(State<FlowsState<Friend>> state) {
        return state.getValue();
    }

    private static final boolean ChatGroupScreen$lambda$71(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatGroupScreen$lambda$72(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ChatGroupScreen$lambda$74$0(TextFieldState textFieldState) {
        return (String) va.g0.K0(le.d0.S0(textFieldState.getText().toString(), new String[]{" ", "\n"}, false, 0, 6, null));
    }

    private static final List<MentionItemModel> ChatGroupScreen$lambda$75(State<? extends List<MentionItemModel>> state) {
        return state.getValue();
    }

    private static final boolean ChatGroupScreen$lambda$77(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatGroupScreen$lambda$78(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$82(MutableState mutableState, final MutableState mutableState2, MutableState mutableState3, final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final TextFieldState textFieldState, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState4, final ChatParams chatParams, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        boolean z10 = false;
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1416411315, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous> (ChatGroupScreen.kt:575)");
            }
            if (ChatGroupScreen$lambda$28(mutableState) == null && le.d0.q0(ChatGroupScreen$lambda$66(mutableState2)) && !ChatGroupScreen$lambda$59(mutableState3)) {
                z10 = true;
            }
            AttachContainerKt.AnimateContainer(null, z10, ComposableLambdaKt.rememberComposableLambda(-479355908, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.d4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0(navHostController, snapshotStateList, chatViewModel, textFieldState, softwareKeyboardController, context, managedActivityResultLauncher, state, mutableState4, chatParams, mutableState5, mutableState6, mutableState2, mutableState7, (Composer) obj, ((Integer) obj2).intValue());
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
    /* JADX WARN: Code duplicated, block: B:25:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b8  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$82$0(final NavHostController navHostController, final SnapshotStateList snapshotStateList, final ChatViewModel chatViewModel, final TextFieldState textFieldState, final SoftwareKeyboardController softwareKeyboardController, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final State state, final MutableState mutableState, final ChatParams chatParams, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, Composer composer, int i10) throws SinglediException {
        boolean z10;
        boolean z11;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-479355908, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous> (ChatGroupScreen.kt:578)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
            int size = snapshotStateList.toList().size();
            if (ChatComplexFunctionalities.INSTANCE.listIsEditable(snapshotStateList, chatViewModel.getOwner().getNameWithDomain())) {
                ChatScreenState chatScreenStateChatGroupScreen$lambda$7 = ChatGroupScreen$lambda$6(state);
                if ((chatScreenStateChatGroupScreen$lambda$7 != null ? chatScreenStateChatGroupScreen$lambda$7.getAffiliation() : null) == null) {
                    z10 = false;
                } else {
                    ChatScreenState chatScreenStateChatGroupScreen$lambda$8 = ChatGroupScreen$lambda$6(state);
                    if (kotlin.jvm.internal.y.d(chatScreenStateChatGroupScreen$lambda$8 != null ? chatScreenStateChatGroupScreen$lambda$8.getAffiliation() : null, "none")) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                }
            } else {
                z10 = false;
            }
            boolean zChangedInstance = composer.changedInstance(chatViewModel) | composer.changed(textFieldState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.b7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$0$0(mutableState, chatViewModel, snapshotStateList, textFieldState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            if (snapshotStateList.size() != 1) {
                z11 = false;
            } else {
                ChatScreenState chatScreenStateChatGroupScreen$lambda$9 = ChatGroupScreen$lambda$6(state);
                if (kotlin.jvm.internal.y.d(chatScreenStateChatGroupScreen$lambda$9 != null ? chatScreenStateChatGroupScreen$lambda$9.getAffiliation() : null, UserRoomJoin.AFFILIATION_OWNER)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.s3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$1$0(chatViewModel, chatParams, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar2 = (lb.a) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue3 == companion2.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.t3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$2$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar3 = (lb.a) objRememberedValue3;
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) va.g0.y0(snapshotStateList);
            boolean zAvailable = messageWithPartnerWithReactions != null ? messageWithPartnerWithReactions.available() : false;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            boolean z12 = zAvailable;
            if (zChangedInstance3 || objRememberedValue4 == companion2.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.u3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$3$0(mutableState3, chatViewModel, mutableState, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar4 = (lb.a) objRememberedValue4;
            boolean zChatGroupScreen$listIsForwardable = ChatGroupScreen$listIsForwardable(snapshotStateList);
            boolean zChangedInstance4 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue5 == companion2.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.v3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$4$0(navHostController, chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar5 = (lb.a) objRememberedValue5;
            boolean zChanged = composer.changed(softwareKeyboardController);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged || objRememberedValue6 == companion2.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.w3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$5$0(softwareKeyboardController, snapshotStateList, mutableState4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar6 = (lb.a) objRememberedValue6;
            boolean zChangedInstance5 = composer.changedInstance(chatViewModel);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue7 == companion2.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.x3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$6$0(chatViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            lb.a aVar7 = (lb.a) objRememberedValue7;
            boolean zChangedInstance6 = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue8 == companion2.getEmpty()) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.y3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$7$0(chatViewModel, context, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            lb.a aVar8 = (lb.a) objRememberedValue8;
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == companion2.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.z3
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$8$0(snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            lb.a aVar9 = (lb.a) objRememberedValue9;
            boolean zChangedInstance7 = composer.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue10 == companion2.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.a4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$9$0(managedActivityResultLauncher, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            lb.a aVar10 = (lb.a) objRememberedValue10;
            boolean zChangedInstance8 = composer.changedInstance(chatViewModel) | composer.changed(state);
            Object objRememberedValue11 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue11 == companion2.getEmpty()) {
                objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.m7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$82$0$10$0(chatViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            ChatActionBarKt.ChatActionBar(companion, navHostController, chatScreenStateChatGroupScreen$lambda$6, size, z10, aVar, z11, aVar2, true, aVar3, z12, aVar4, zChatGroupScreen$listIsForwardable, aVar5, true, aVar6, false, null, true, aVar7, aVar8, aVar9, aVar10, (lb.a) objRememberedValue11, null, null, null, composer, 905969670, 100687872, 48, 117637120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$0$0(MutableState mutableState, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, TextFieldState textFieldState) {
        List<String> listChatGroupScreen$clearSelection = ChatGroupScreen$clearSelection(snapshotStateList);
        if (!listChatGroupScreen$clearSelection.isEmpty()) {
            mutableState.setValue(ChatComplexFunctionalities.INSTANCE.findMsg(listChatGroupScreen$clearSelection.get(0), chatViewModel.getMsgList()));
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions != null) {
                TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, messageWithPartnerWithReactions.getMessage().getContent());
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$1$0(ChatViewModel chatViewModel, ChatParams chatParams, SnapshotStateList snapshotStateList) {
        chatViewModel.pinMsgInGroup(ChatGroupScreen$clearSelection(snapshotStateList).get(0), chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$10$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
        kotlin.jvm.internal.y.f(chatScreenStateChatGroupScreen$lambda$6);
        chatViewModel.removeChatBackground(chatScreenStateChatGroupScreen$lambda$6.getId());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$2$0(MutableState mutableState) {
        ChatGroupScreen$lambda$57(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$3$0(MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, SnapshotStateList snapshotStateList) {
        List<String> listChatGroupScreen$clearSelection = ChatGroupScreen$clearSelection(snapshotStateList);
        if (!listChatGroupScreen$clearSelection.isEmpty()) {
            mutableState.setValue(ChatComplexFunctionalities.INSTANCE.findMsg(listChatGroupScreen$clearSelection.get(0), chatViewModel.getMsgList()));
            mutableState2.setValue(null);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$4$0(NavHostController navHostController, ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        List<String> listChatGroupScreen$clearSelection = ChatGroupScreen$clearSelection(snapshotStateList);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listChatGroupScreen$clearSelection.iterator();
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
    public static final ua.k0 ChatGroupScreen$lambda$82$0$5$0(SoftwareKeyboardController softwareKeyboardController, SnapshotStateList snapshotStateList, MutableState mutableState) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        mutableState.setValue((String) va.g0.w0(ChatGroupScreen$clearSelection(snapshotStateList)));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$6$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList) {
        chatViewModel.share(ChatGroupScreen$clearSelection(snapshotStateList));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$7$0(ChatViewModel chatViewModel, Context context, SnapshotStateList snapshotStateList) {
        chatViewModel.pastToClipboard(ChatGroupScreen$clearSelection(snapshotStateList), context);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$8$0(SnapshotStateList snapshotStateList) {
        ChatGroupScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$82$0$9$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        Integer state = ChatGroupScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            managedActivityResultLauncher.launch("image/*");
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatGroupScreen$lambda$16(mutableState), null, true, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 33561. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final ua.k0 ChatGroupScreen$lambda$83(androidx.compose.runtime.snapshots.SnapshotStateList r53, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r54, androidx.compose.runtime.State r55, androidx.compose.foundation.text.input.TextFieldState r56, cu.todus.android.uiCompose.main.screen.chat.component.ChatParams r57, pe.m0 r58, androidx.compose.runtime.MutableState r14, androidx.compose.runtime.MutableState r60, androidx.compose.runtime.snapshots.SnapshotStateList r61, androidx.compose.runtime.MutableState r62, androidx.compose.runtime.MutableState r63, androidx.paging.compose.LazyPagingItems r64, androidx.navigation.NavHostController r65, androidx.compose.ui.platform.SoftwareKeyboardController r66, android.content.Context r67, androidx.compose.ui.focus.FocusRequester r68, androidx.compose.runtime.MutableState r69, androidx.compose.runtime.MutableState r70, androidx.compose.runtime.MutableState r71, androidx.compose.runtime.MutableState r72, androidx.compose.runtime.State r73, androidx.compose.runtime.State r74, androidx.compose.runtime.MutableState r75, androidx.compose.runtime.MutableState r76, androidx.compose.runtime.State r77, androidx.compose.runtime.MutableState r78, androidx.compose.runtime.MutableState r79, androidx.p000activity.compose.ManagedActivityResultLauncher r80, androidx.compose.runtime.MutableState r81, androidx.p000activity.compose.ManagedActivityResultLauncher r82, androidx.compose.runtime.MutableState r83, androidx.paging.compose.LazyPagingItems r84, androidx.paging.compose.LazyPagingItems r85, androidx.paging.compose.LazyPagingItems r86, androidx.compose.runtime.State r87, androidx.compose.runtime.MutableState r88, androidx.compose.runtime.State r89, androidx.compose.runtime.MutableState r90, androidx.compose.runtime.State r91, androidx.compose.runtime.MutableState r92, cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreenKt$ChatGroupScreen$notificationFilter$1$1 r93, androidx.compose.ui.Modifier r94, androidx.compose.runtime.Composer r95, int r96) {
        /*
            Method dump skipped, instruction units count: 3356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreenKt.ChatGroupScreen$lambda$83(androidx.compose.runtime.snapshots.SnapshotStateList, cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel, androidx.compose.runtime.State, androidx.compose.foundation.text.input.TextFieldState, cu.todus.android.uiCompose.main.screen.chat.component.ChatParams, pe.m0, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.snapshots.SnapshotStateList, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.paging.compose.LazyPagingItems, androidx.navigation.NavHostController, androidx.compose.ui.platform.SoftwareKeyboardController, android.content.Context, androidx.compose.ui.focus.FocusRequester, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.paging.compose.LazyPagingItems, androidx.paging.compose.LazyPagingItems, androidx.paging.compose.LazyPagingItems, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreenKt$ChatGroupScreen$notificationFilter$1$1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):ua.k0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatGroupScreen$lambda$83$0$0$0(LazyListState lazyListState) {
        return lazyListState.getFirstVisibleItemIndex() == 0;
    }

    private static final boolean ChatGroupScreen$lambda$83$0$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$10(final MutableState mutableState, ChatViewModel chatViewModel, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(860309015, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1004)");
            }
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions == null) {
                composer.startReplaceGroup(1396061381);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1396061382);
                String nameWithDomain = chatViewModel.getOwner().getNameWithDomain();
                String alias = chatViewModel.getOwner().getAlias();
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.h3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$10$0$0$0(mutableState);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$0$10$0$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$11$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$12(final MutableState mutableState, ChatViewModel chatViewModel, final TextFieldState textFieldState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(545832576, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1021)");
            }
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            if (messageWithPartnerWithReactions == null) {
                composer.startReplaceGroup(152140669);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(152140670);
                String nameWithDomain = chatViewModel.getOwner().getNameWithDomain();
                String alias = chatViewModel.getOwner().getAlias();
                boolean zChanged = composer.changed(textFieldState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.y4
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$12$0$0$0(mutableState, textFieldState);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$0$12$0$0$0(MutableState mutableState, TextFieldState textFieldState) {
        mutableState.setValue(null);
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, "");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$13$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatGroupScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$14(final SnapshotStateList snapshotStateList, final ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(202948767, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1041)");
            }
            Integer state = ChatGroupScreen$lambda$16(mutableState).getPermissionsResult().getState();
            if (state != null && state.intValue() == 2) {
                composer.startReplaceGroup(-1267145014);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.q3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$14$0$0(snapshotStateList, mutableState2, mutableState3, (Uri) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.r3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$14$1$0(managedActivityResultLauncher);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                PresentListKt.PresentList(snapshotStateList, function1, (lb.a) objRememberedValue2, composer, 54);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1266751965);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$0$14$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, Uri it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatGroupScreen$removeAttachedFilesToSend(snapshotStateList, mutableState, mutableState2, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$14$1$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("*/*");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$15$0(MutableState mutableState) {
        ChatGroupScreen$lambda$32(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$16(final ChatViewModel chatViewModel, final ManagedActivityResultLauncher managedActivityResultLauncher, NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher2, final Context context, final TextFieldState textFieldState, final MutableState mutableState, final MutableState mutableState2, final SnapshotStateList snapshotStateList, final MutableState mutableState3, final ChatParams chatParams, final MutableState mutableState4, final MutableState mutableState5, Composer composer, int i10) {
        ManagedActivityResultLauncher managedActivityResultLauncher3;
        final NavHostController navHostController2;
        final MutableState mutableState6;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-139935042, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1059)");
            }
            v5.f gson = chatViewModel.getGson();
            List<BotShortcut> attachmentShortcuts = chatViewModel.getAttachmentShortcuts();
            boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.g7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$16$0$0(managedActivityResultLauncher, mutableState, mutableState2, snapshotStateList, mutableState3);
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
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.h7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$16$1$0(navHostController2, chatViewModel, chatParams, mutableState4, mutableState3);
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
                lb.a aVar5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.i7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$16$2$0(navHostController2, chatViewModel, chatParams, mutableState4, mutableState6);
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
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.j7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$16$3$0(managedActivityResultLauncher2, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar7 = (lb.a) objRememberedValue4;
            boolean zChangedInstance5 = composer.changedInstance(navHostController2);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.k7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$16$4$0(navHostController2, chatParams, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar8 = (lb.a) objRememberedValue5;
            boolean zChangedInstance6 = composer.changedInstance(managedActivityResultLauncher3);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                final ManagedActivityResultLauncher managedActivityResultLauncher4 = managedActivityResultLauncher3;
                lb.a aVar9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.l7
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$16$5$0(managedActivityResultLauncher4, mutableState, mutableState2, snapshotStateList, mutableState6);
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
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.i3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$16$6$0(context, chatViewModel, chatParams, navHostController3, textFieldState, mutableState5, mutableState3, (ButtonContent) obj);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$0$16$0$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = ChatGroupScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatGroupScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (ChatGroupScreen$lambda$34(mutableState2)) {
            ChatGroupScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch("*/*");
        }
        ChatGroupScreen$lambda$32(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$16$1$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2) {
        ChatGroupScreen$createAndSendDate(navHostController, chatViewModel, chatParams, mutableState);
        ChatGroupScreen$lambda$32(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$16$2$0(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2) {
        ChatGroupScreen$selectMapLocation(navHostController, chatViewModel, chatParams, mutableState);
        ChatGroupScreen$lambda$32(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$16$3$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        managedActivityResultLauncher.launch(null);
        ChatGroupScreen$lambda$32(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$16$4$0(NavHostController navHostController, ChatParams chatParams, MutableState mutableState) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goPubEditor(chatParams.getUid()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        ChatGroupScreen$lambda$32(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$16$5$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, SnapshotStateList snapshotStateList, MutableState mutableState3) {
        Integer state = ChatGroupScreen$lambda$16(mutableState).getPermissionsResult().getState();
        if (state == null || state.intValue() != 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatGroupScreen$lambda$16(mutableState), null, true, null, 5, null));
        } else if (ChatGroupScreen$lambda$34(mutableState2)) {
            ChatGroupScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        } else {
            managedActivityResultLauncher.launch(VideoSpec.MIME_TYPE_UNSPECIFIED);
        }
        ChatGroupScreen$lambda$32(mutableState3, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$16$6$0(Context context, ChatViewModel chatViewModel, ChatParams chatParams, NavHostController navHostController, TextFieldState textFieldState, MutableState mutableState, MutableState mutableState2, ButtonContent it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatGroupScreen$onClickInShortcut(context, chatViewModel, chatParams, navHostController, textFieldState, mutableState, it);
        ChatGroupScreen$lambda$32(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$17$0(MutableState mutableState) {
        ChatGroupScreen$lambda$63(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$18(LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, final NavHostController navHostController, final ChatViewModel chatViewModel, final MutableState mutableState, final ChatParams chatParams, final MutableState mutableState2, final FocusRequester focusRequester, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-482818851, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1118)");
            }
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.o4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$18$0$0(navHostController, chatViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.p4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$18$1$0(chatViewModel, chatParams, mutableState2, focusRequester, mutableState, (Sticker) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            }
            Function1 function2 = (Function1) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new ChatGroupScreenKt$ChatGroupScreen$4$1$17$3$1(chatViewModel);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$0$18$0$0(NavHostController navHostController, ChatViewModel chatViewModel, MutableState mutableState) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(null, 1, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        ChatGroupScreen$lambda$63(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$18$1$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, FocusRequester focusRequester, MutableState mutableState2, Sticker it) {
        Message message;
        kotlin.jvm.internal.y.i(it, "it");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendSticker(uid, it, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatGroupScreen$lambda$63(mutableState2, false);
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$19(ChatParams chatParams, Composer composer, int i10) {
        String strStringResource;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-825702660, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1157)");
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl(10));
            int type = chatParams.getType();
            if (type == 1) {
                composer.startReplaceGroup(1068702337);
                strStringResource = StringResources_androidKt.stringResource(R.string.cant_send_msgs_to_this_group_not_a_member, composer, 0);
                composer.endReplaceGroup();
            } else if (type != 2) {
                composer.startReplaceGroup(-1229695198);
                composer.endReplaceGroup();
                strStringResource = "";
            } else {
                composer.startReplaceGroup(1068708148);
                strStringResource = StringResources_androidKt.stringResource(R.string.cant_write_on_this_channel, composer, 0);
                composer.endReplaceGroup();
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1725padding3ABfNKs, strStringResource, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 6, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$2$0(pe.m0 m0Var, LazyListState lazyListState, boolean z10) {
        pe.k.d(m0Var, null, null, new ChatGroupScreenKt$ChatGroupScreen$4$1$1$1$1(z10, lazyListState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$20(TextFieldState textFieldState, final ChatViewModel chatViewModel, final Context context, FocusRequester focusRequester, State state, final MutableState mutableState, final MutableState mutableState2, final SnapshotStateList snapshotStateList, ChatParams chatParams, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, Composer composer, int i10) {
        Object obj;
        final ChatParams chatParams2;
        final MutableState mutableState8;
        final MutableState mutableState9;
        final MutableState mutableState10;
        final SnapshotStateList snapshotStateList2;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-807400076, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1182)");
            }
            long jChatGroupScreen$lambda$14 = ChatGroupScreen$lambda$14(state);
            boolean zChatGroupScreen$lambda$34 = ChatGroupScreen$lambda$34(mutableState);
            boolean zChatGroupScreen$lambda$62 = ChatGroupScreen$lambda$62(mutableState2);
            boolean zChangedInstance = composer.changedInstance(chatViewModel) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                chatParams2 = chatParams;
                obj = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.q4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$20$0$0(snapshotStateList, chatViewModel, chatParams2, mutableState3, mutableState4, mutableState5, context, mutableState, mutableState6, (String) obj2);
                    }
                };
                mutableState8 = mutableState5;
                composer.updateRememberedValue(obj);
            } else {
                chatParams2 = chatParams;
                obj = objRememberedValue;
                mutableState8 = mutableState5;
            }
            Function1 function1 = (Function1) obj;
            boolean zChangedInstance2 = composer.changedInstance(chatViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.r4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$20$1$0(chatViewModel, chatParams2, mutableState8);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(chatViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.s4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$20$2$0(chatViewModel, chatParams2, mutableState8);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar2 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(chatViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.t4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$20$3$0(chatViewModel, mutableState8);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar3 = (lb.a) objRememberedValue4;
            Object objRememberedValue5 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue5 == companion.getEmpty()) {
                mutableState9 = mutableState;
                mutableState10 = mutableState6;
                snapshotStateList2 = snapshotStateList;
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.u4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$20$4$0(mutableState8, snapshotStateList2, mutableState9, mutableState10);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            } else {
                mutableState9 = mutableState;
                mutableState10 = mutableState6;
                snapshotStateList2 = snapshotStateList;
            }
            lb.a aVar4 = (lb.a) objRememberedValue5;
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.v4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$20$5$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar5 = (lb.a) objRememberedValue6;
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.w4
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$20$6$0(mutableState5, snapshotStateList2, mutableState9, mutableState10, mutableState7);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ChatInputKt.ChatInput(textFieldState, null, function1, aVar, aVar2, aVar3, aVar4, aVar5, (lb.a) objRememberedValue7, zChatGroupScreen$lambda$34, jChatGroupScreen$lambda$14, focusRequester, zChatGroupScreen$lambda$62, composer, 114819072, 48, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$20$0$0(SnapshotStateList snapshotStateList, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Context context, MutableState mutableState4, MutableState mutableState5, String messageContent) {
        Message message;
        Message message2;
        kotlin.jvm.internal.y.i(messageContent, "messageContent");
        ChatGroupScreen$lambda$78(mutableState3, false);
        if (snapshotStateList.isEmpty()) {
            String uid = chatParams.getUid();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
            String id2 = (messageWithPartnerWithReactions == null || (message2 = messageWithPartnerWithReactions.getMessage()) == null) ? null : message2.getId();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions2 = (MessageWithPartnerWithReactions) mutableState2.getValue();
            ChatViewModel.sendMessage$default(chatViewModel, messageContent, uid, false, null, id2, (messageWithPartnerWithReactions2 == null || (message = messageWithPartnerWithReactions2.getMessage()) == null) ? null : message.getId(), null, 76, null);
        } else {
            ChatGroupScreen$selectMethodAndSend(chatParams, mutableState, chatViewModel, context, snapshotStateList, mutableState4, mutableState5, messageContent);
        }
        mutableState.setValue(null);
        mutableState2.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$20$1$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState) {
        ChatGroupScreen$lambda$78(mutableState, false);
        chatViewModel.startRecorder(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$20$2$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState) {
        ChatGroupScreen$lambda$78(mutableState, false);
        chatViewModel.stopRecorderAndSend(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$20$3$0(ChatViewModel chatViewModel, MutableState mutableState) {
        ChatGroupScreen$lambda$78(mutableState, false);
        chatViewModel.stopRecorder();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$20$4$0(MutableState mutableState, SnapshotStateList snapshotStateList, MutableState mutableState2, MutableState mutableState3) {
        ChatGroupScreen$lambda$78(mutableState, false);
        ChatGroupScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        ChatGroupScreen$lambda$32(mutableState3, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$20$5$0(MutableState mutableState) {
        ChatGroupScreen$lambda$63(mutableState, !ChatGroupScreen$lambda$62(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$20$6$0(MutableState mutableState, SnapshotStateList snapshotStateList, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4) {
        ChatGroupScreen$lambda$78(mutableState, false);
        ChatGroupScreen$clearAttachedFilesToSend(snapshotStateList, mutableState2, mutableState3);
        ChatGroupScreen$lambda$60(mutableState4, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$3$0(pe.m0 m0Var, LazyListState lazyListState, int i10) {
        pe.k.d(m0Var, null, null, new ChatGroupScreenKt$ChatGroupScreen$4$1$2$1$1(lazyListState, i10, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$10$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, SoftwareKeyboardController softwareKeyboardController, Context context, NavHostController navHostController, ChatParams chatParams, TextFieldState textFieldState, MutableState mutableState, State state, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, boolean z10, MessageAction messageAction, MessageWithPartnerWithReactions msg, int i10) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        kotlin.jvm.internal.y.i(messageAction, "messageAction");
        kotlin.jvm.internal.y.i(msg, "msg");
        if (msg.getMessage().getState() == 4) {
            chatViewModel.tryResend(msg.getMessage().getId());
        } else if (ChatGroupScreen$selectedListIsEmpty(snapshotStateList)) {
            ChatGroupScreen$attachmentClicked(softwareKeyboardController, context, chatViewModel, navHostController, chatParams, textFieldState, mutableState, state, mutableState2, z10, messageAction, msg, i10);
        } else if (ChatGroupScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            ChatGroupScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            ChatGroupScreen$addItemToSelected(mutableState3, mutableState4, snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$11$0(SnapshotStateList snapshotStateList, ChatViewModel chatViewModel, MutableState mutableState, MutableState mutableState2, MessageWithPartnerWithReactions msg, int i10) {
        kotlin.jvm.internal.y.i(msg, "msg");
        if (ChatGroupScreen$selectedContains(snapshotStateList, msg.getMessage().getId())) {
            ChatGroupScreen$removeItemFromSelected(snapshotStateList, chatViewModel, msg.getMessage().getId());
        } else {
            ChatGroupScreen$addItemToSelected(mutableState, mutableState2, snapshotStateList, chatViewModel, msg);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$12$0(ChatViewModel chatViewModel, Context context, TextFieldState textFieldState, MutableState mutableState, NavHostController navHostController, MessageWithPartnerWithReactions msg, MessageAction messageAction, String value) {
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
            ChatGroupScreen$handleClickOnMention(chatViewModel, mutableState, navHostController, mentionName);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$13$0(ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState) {
        chatViewModel.displayAllMsg(chatParams.getUid());
        Function1 function1ChatGroupScreen$lambda$9 = ChatGroupScreen$lambda$9(mutableState);
        if (function1ChatGroupScreen$lambda$9 != null) {
            function1ChatGroupScreen$lambda$9.invoke(Boolean.FALSE);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$15(final TextFieldState textFieldState, final ChatViewModel chatViewModel, State state, final State state2, final MutableState mutableState, Composer composer, int i10) {
        String strO;
        String strO2;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1431706920, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:914)");
            }
            List<MentionItemModel> listChatGroupScreen$lambda$75 = ChatGroupScreen$lambda$75(state);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listChatGroupScreen$lambda$75) {
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
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.b4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$4$15$1$0(textFieldState, state2, chatViewModel, mutableState, (MentionItemModel) obj2);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$15$1$0(TextFieldState textFieldState, State state, ChatViewModel chatViewModel, MutableState mutableState, MentionItemModel it) {
        kotlin.jvm.internal.y.i(it, "it");
        String string = textFieldState.getText().toString();
        String str = (String) state.getValue();
        if (str == null) {
            str = "";
        }
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, le.a0.O(string, str, "", false, 4, null) + " @" + it.getToDusId() + " ");
        chatViewModel.getActualMentionsToSend().add(it);
        ChatGroupScreen$lambda$78(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$16(final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1853420283, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:952)");
            }
            ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
            final PinnedMsg pinnedMessage = chatScreenStateChatGroupScreen$lambda$6 != null ? chatScreenStateChatGroupScreen$lambda$6.getPinnedMessage() : null;
            if (pinnedMessage == null) {
                composer.startReplaceGroup(855986876);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(855986877);
                String shortMsg = pinnedMessage.getShortMsg();
                boolean zChanged = composer.changed(pinnedMessage);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.e7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$4$16$0$0$0(pinnedMessage, mutableState3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                boolean zChanged2 = composer.changed(state);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.f7
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$4$16$0$1$0(mutableState, state, mutableState2);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$16$0$0$0(PinnedMsg pinnedMsg, MutableState mutableState) {
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.showReply(pinnedMsg.getMsgId());
        }
        ChatGroupScreen$lambda$83$0$goReply(mutableState, pinnedMsg.getPosition());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$16$0$1$0(MutableState mutableState, State state, MutableState mutableState2) {
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
        if (kotlin.jvm.internal.y.d(chatScreenStateChatGroupScreen$lambda$6 != null ? chatScreenStateChatGroupScreen$lambda$6.getAffiliation() : null, UserRoomJoin.AFFILIATION_OWNER)) {
            mutableState.setValue(Boolean.TRUE);
        }
        ChatGroupScreen$lambda$72(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$4$0(FocusRequester focusRequester, MutableState mutableState, SnapshotStateList snapshotStateList, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        FocusRequester.m5530requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        ChatGroupScreen$clearSelection(snapshotStateList);
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$5$0(ChatViewModel chatViewModel, SnapshotStateList snapshotStateList, String roomId, String msgId, String value) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(value, "value");
        ChatGroupScreen$clearSelection(snapshotStateList);
        chatViewModel.onReacted(roomId, msgId, value);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$6$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.REACT_SELECTION, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$7$0(NavHostController navHostController, ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatParams chatParams = new ChatParams(it, XMPPUtils.INSTANCE.getChatType(it), null, 0, 12, null);
        NavLinks navLinks = NavLinks.INSTANCE;
        int type = chatParams.getType();
        String strT = chatViewModel.getGson().t(chatParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goChat(type, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$9$0(final ChatViewModel chatViewModel, final NavHostController navHostController, final String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.getStatusPosition(it, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.f6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$4$9$0$0(navHostController, chatViewModel, it, (Pair) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$4$9$0$0(NavHostController navHostController, ChatViewModel chatViewModel, String str, Pair result) {
        kotlin.jvm.internal.y.i(result, "result");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new StatusPreviewParams(((Boolean) result.getFirst()).booleanValue(), ((Number) result.getSecond()).intValue(), str));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$5$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
        String id2 = chatScreenStateChatGroupScreen$lambda$6 != null ? chatScreenStateChatGroupScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsAccepted(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$6$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
        String id2 = chatScreenStateChatGroupScreen$lambda$6 != null ? chatScreenStateChatGroupScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownRoomAsAccepted(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$7$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
        String id2 = chatScreenStateChatGroupScreen$lambda$6 != null ? chatScreenStateChatGroupScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownUserAsShared(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$8$0(ChatViewModel chatViewModel, State state) {
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreen$lambda$6(state);
        String id2 = chatScreenStateChatGroupScreen$lambda$6 != null ? chatScreenStateChatGroupScreen$lambda$6.getId() : null;
        kotlin.jvm.internal.y.f(id2);
        chatViewModel.setUnknownUserAsBlocked(id2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$0$9$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatGroupScreen$lambda$83$0$goReply(MutableState<Function1> mutableState, int i10) {
        Function1 function1ChatGroupScreen$lambda$12 = ChatGroupScreen$lambda$12(mutableState);
        if (function1ChatGroupScreen$lambda$12 != null) {
            function1ChatGroupScreen$lambda$12.invoke(Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$0$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$1$0(ChatViewModel chatViewModel, ChatParams chatParams) {
        chatViewModel.unPinMsgInGroup(chatParams.getUid());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$10$0(ChatParams chatParams, MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, List files, String content) {
        Message message;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendImages(uid, files, content, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatGroupScreen$lambda$60(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$11$0(MutableState mutableState) {
        ChatGroupScreen$lambda$60(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$12$0(MutableState mutableState) {
        ChatGroupScreen$lambda$60(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$1$13(final MutableState mutableState, final ChatViewModel chatViewModel, final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1471394250, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1340)");
            }
            AttachmentPreviewState attachmentPreviewStateChatGroupScreen$lambda$28 = ChatGroupScreen$lambda$28(mutableState);
            if (attachmentPreviewStateChatGroupScreen$lambda$28 == null) {
                composer.startReplaceGroup(130180840);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(130180841);
                boolean zChangedInstance = composer.changedInstance(chatViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.j3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$1$13$0$0$0(chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.k3
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$1$13$0$1$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar = (lb.a) objRememberedValue2;
                boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(chatViewModel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.l3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChatGroupScreenKt.ChatGroupScreen$lambda$83$1$13$0$2$0(navHostController, chatViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                AttachmentPreviewKt.AttachmentPreviewWithOptions(attachmentPreviewStateChatGroupScreen$lambda$28, function1, aVar, (Function1) objRememberedValue3, null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 16);
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
    public static final ua.k0 ChatGroupScreen$lambda$83$1$13$0$0$0(ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        chatViewModel.share(va.v.e(it));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$13$0$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$13$0$2$0(NavHostController navHostController, ChatViewModel chatViewModel, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = chatViewModel.getGson().t(new ManageStickersParams(it));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goManageStickers(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$14$0(MutableState mutableState) {
        mutableState.setValue("");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ChatGroupScreen$lambda$83$1$15(NavHostController navHostController, MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(979663257, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreen.<anonymous>.<anonymous>.<anonymous> (ChatGroupScreen.kt:1365)");
            }
            MsgDetailsDialogKt.MsgDetailsDialog(ChatGroupScreen$lambda$66(mutableState), navHostController, null, composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$16$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatGroupScreen$lambda$16(mutableState), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$17$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatGroupScreen$lambda$16(mutableState), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$18$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatGroupScreen$lambda$16(mutableState), null, false, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$19$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(ChatGroupScreen$lambda$16(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(ChatGroupScreen$lambda$16(mutableState), null, false, null, 5, null));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$2$0(ChatViewModel chatViewModel) {
        chatViewModel.readRequestingFriend();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$3$0(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$4$0(MutableState mutableState) {
        ChatGroupScreen$lambda$57(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$7$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$1$8$0(TextFieldState textFieldState, ChatViewModel chatViewModel, ChatParams chatParams, MutableState mutableState, String value, boolean z10) {
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
    public static final ua.k0 ChatGroupScreen$lambda$83$1$9$0(ChatParams chatParams, MutableState mutableState, ChatViewModel chatViewModel, MutableState mutableState2, List files, String content) {
        Message message;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) mutableState.getValue();
        chatViewModel.sendVideos(uid, files, content, (messageWithPartnerWithReactions == null || (message = messageWithPartnerWithReactions.getMessage()) == null) ? null : message.getId());
        mutableState.setValue(null);
        ChatGroupScreen$lambda$60(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$83$2$0(SnapshotStateList snapshotStateList) {
        ChatGroupScreen$clearSelection(snapshotStateList);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ChatGroupScreen$lambda$83$5$0(final ChatViewModel chatViewModel, final TextFieldState textFieldState, final ChatParams chatParams, final ChatGroupScreenKt$ChatGroupScreen$notificationFilter$1$1 chatGroupScreenKt$ChatGroupScreen$notificationFilter$1$1, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreenKt$ChatGroupScreen$lambda$83$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                chatViewModel.setRoomDraft(textFieldState.getText().toString(), chatParams.getUid());
                chatViewModel.stopRecorder();
                chatViewModel.getNotificationManager().unRegister(chatGroupScreenKt$ChatGroupScreen$notificationFilter$1$1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$lambda$84(NavHostController navHostController, String str, ChatViewModel chatViewModel, int i10, int i11, Composer composer, int i12) {
        ChatGroupScreen(navHostController, str, chatViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 ChatGroupScreen$lambda$9(MutableState<Function1> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ChatGroupScreen$listIsForwardable(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
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

    private static final void ChatGroupScreen$onClickInShortcut(Context context, final ChatViewModel chatViewModel, final ChatParams chatParams, final NavHostController navHostController, final TextFieldState textFieldState, MutableState<PagerDialogData> mutableState, ButtonContent buttonContent) {
        ChatButtonsFunctionality.INSTANCE.handleClick(buttonContent, context, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.x4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatGroupScreenKt.ChatGroupScreen$onClickInShortcut$lambda$24(chatViewModel, chatParams, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.z4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatGroupScreenKt.ChatGroupScreen$onClickInShortcut$lambda$25(navHostController, (String) obj);
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.a5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatGroupScreenKt.ChatGroupScreen$onClickInShortcut$lambda$26(textFieldState, (String) obj);
            }
        }, new ChatGroupScreenKt$ChatGroupScreen$onClickInShortcut$4(mutableState), (64 & 64) != 0 ? new Function1() { // from class: q7.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChatButtonsFunctionality.handleClick$lambda$0((BotShortcut) obj);
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$onClickInShortcut$lambda$24(ChatViewModel chatViewModel, ChatParams chatParams, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        ChatViewModel.sendMessage$default(chatViewModel, it, chatParams.getUid(), false, null, null, null, null, 124, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$onClickInShortcut$lambda$25(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, it, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$onClickInShortcut$lambda$26(TextFieldState textFieldState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatGroupScreen$onDelete(ChatViewModel chatViewModel, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteMessages(ChatGroupScreen$clearSelection(snapshotStateList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatGroupScreen$onDeleteToAll(ChatViewModel chatViewModel, ChatParams chatParams, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        chatViewModel.deleteForAll(chatParams.getUid(), ChatGroupScreen$clearSelection(snapshotStateList));
    }

    private static final void ChatGroupScreen$removeAttachedFilesToSend(SnapshotStateList<Uri> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Uri uri) {
        if (snapshotStateList.size() == 1) {
            ChatGroupScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        } else {
            snapshotStateList.remove(uri);
        }
    }

    private static final void ChatGroupScreen$removeItemFromSelected(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, ChatViewModel chatViewModel, final String str) {
        final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.c4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ChatGroupScreenKt.ChatGroupScreen$removeItemFromSelected$lambda$49(str, (MessageWithPartnerWithReactions) obj));
            }
        };
        Collection.EL.removeIf(snapshotStateList, new Predicate() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.n4
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
                return ChatGroupScreenKt.ChatGroupScreen$removeItemFromSelected$lambda$50(function1, obj);
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
    public static final boolean ChatGroupScreen$removeItemFromSelected$lambda$49(String str, MessageWithPartnerWithReactions it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getMessage().getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatGroupScreen$removeItemFromSelected$lambda$50(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private static final void ChatGroupScreen$selectMapLocation(NavHostController navHostController, ChatViewModel chatViewModel, ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState) {
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

    private static final void ChatGroupScreen$selectMethodAndSend(ChatParams chatParams, MutableState<MessageWithPartnerWithReactions> mutableState, ChatViewModel chatViewModel, Context context, final SnapshotStateList<Uri> snapshotStateList, final MutableState<Boolean> mutableState2, final MutableState<Boolean> mutableState3, String str) {
        Message message;
        ChatComplexFunctionalities chatComplexFunctionalities = ChatComplexFunctionalities.INSTANCE;
        String uid = chatParams.getUid();
        MessageWithPartnerWithReactions value = mutableState.getValue();
        chatComplexFunctionalities.selectMethodAndSend(str, uid, (value == null || (message = value.getMessage()) == null) ? null : message.getId(), context, snapshotStateList, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.q6
            @Override // lb.a
            public final Object invoke() {
                return ChatGroupScreenKt.ChatGroupScreen$selectMethodAndSend$lambda$38(snapshotStateList, mutableState2, mutableState3);
            }
        }, new ChatGroupScreenKt$ChatGroupScreen$selectMethodAndSend$1(chatViewModel), new ChatGroupScreenKt$ChatGroupScreen$selectMethodAndSend$2(chatViewModel), new ChatGroupScreenKt$ChatGroupScreen$selectMethodAndSend$3(chatViewModel), new ChatGroupScreenKt$ChatGroupScreen$selectMethodAndSend$4(chatViewModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatGroupScreen$selectMethodAndSend$lambda$38(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2) {
        ChatGroupScreen$clearAttachedFilesToSend(snapshotStateList, mutableState, mutableState2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x002a A[RETURN] */
    public static final boolean ChatGroupScreen$selectedContains(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList, String str) {
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

    private static final boolean ChatGroupScreen$selectedListIsEmpty(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        return snapshotStateList.toList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatGroupScreen$setPlaceholderData(MutableState<PagerDialogData> mutableState, String str, ButtonTemplate buttonTemplate, boolean z10) {
        mutableState.setValue(new PagerDialogData(str, buttonTemplate, z10, null, 8, null));
    }
}
