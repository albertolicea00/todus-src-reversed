package cu.todus.android.uiCompose.main.screen.chat.functionalities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.AudioContent;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.data.db.pojo.content.VoiceContent;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.media.player.MediaPlayerData;
import cu.todus.android.notification.SystemNotificationExecutor;
import cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewState;
import cu.todus.android.uiCompose.main.screen.chat.functionalities.ChatButtonsFunctionality;
import cu.todus.android.uiCompose.main.screen.chat.functionalities.ChatComplexFunctionalities;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt;
import cu.todus.android.uiCompose.main.screen.map.MapMotive;
import cu.todus.android.uiCompose.main.screen.map.MapParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.utils.IntentUtil;
import cu.todus.android.volatileState.PathsVolatileState;
import cu.z17.singledi.SinglediException;
import cu.z17.views.map.Z17MapMarker;
import defpackage.r;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import lb.o;
import le.d0;
import v5.f;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0083\u0002\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2,\u0010\u0013\u001a(\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000e0\u00102,\u0010\u0014\u001a(\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000e0\u00102,\u0010\u0015\u001a(\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000e0\u00102,\u0010\u0016\u001a(\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0004\b\u0017\u0010\u0018Jý\u0001\u00102\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0#2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u001e\u0010*\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0)2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0#2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0#2\u001e\u0010.\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000e0)2\u0006\u0010/\u001a\u00020\u001d2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u000e0#¢\u0006\u0004\b2\u00103J'\u00106\u001a\u0004\u0018\u00010\u001f2\u0006\u00104\u001a\u00020\u00042\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0011¢\u0006\u0004\b6\u00107J#\u0010:\u001a\u00020\u001d2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00112\u0006\u00109\u001a\u00020\u0004¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/functionalities/ChatComplexFunctionalities;", "", "<init>", "()V", "", "messageContent", "uid", "replyMsgId", "Landroid/content/Context;", "context", "", "Landroid/net/Uri;", "attachedItemsToSend", "Lkotlin/Function0;", "Lua/k0;", "clearAttachedFilesToSend", "Lkotlin/Function4;", "", "Ljava/io/File;", "sendImages", "sendFiles", "sendAudios", "sendVideos", "selectMethodAndSend", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Ljava/util/List;Llb/a;Llb/o;Llb/o;Llb/o;Llb/o;)V", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", SystemNotificationExecutor.ACTION, "", "index", "", "fromOwner", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "messageWithPartnerWithReactions", "Lv5/f;", "gson", "Lkotlin/Function1;", "navigateTo", "Lkotlin/Function2;", "Lcu/todus/android/media/player/MediaPlayerData;", "startPlaying", "stopPlaying", "Lkotlin/Function3;", "requestUserByContact", "sendMessage", "setOnTyping", "Lcu/todus/android/data/db/pojo/content/ButtonTemplate;", "setPlaceholderData", "isSecret", "Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "showAttachmentPreview", "attachmentClicked", "(Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;IZLcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Landroid/content/Context;Lv5/f;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Llb/a;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function1;)V", Room.COLUMN_LAST_MSG, "flowMsgs", "findMsg", "(Ljava/lang/String;Ljava/util/List;)Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "selectedList", "ownerId", "listIsEditable", "(Ljava/util/List;Ljava/lang/String;)Z", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChatComplexFunctionalities {
    public static final int $stable = 0;
    public static final ChatComplexFunctionalities INSTANCE = new ChatComplexFunctionalities();

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageAction.values().length];
            try {
                iArr[MessageAction.OPEN_ATTACHMENT_PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageAction.PLAY_AUDIO_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageAction.STOP_AUDIO_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageAction.CHECK_CONTACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessageAction.CHECK_EVENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessageAction.OPEN_FILE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MessageAction.SEE_LOCATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MessageAction.CLICK_ON_BUTTON.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ChatComplexFunctionalities() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri attachmentClicked$lambda$12(FileContent fileContent, boolean z10) {
        try {
            if (new File(fileContent.getPath()).exists()) {
                return Uri.parse(fileContent.getPath());
            }
            return fileContent.getToDus2Uri(PathsVolatileState.INSTANCE.getInstance().publicFiles() && !z10);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri attachmentClicked$lambda$4(Content content, boolean z10) {
        AudioContent audioContent = (AudioContent) content;
        if (new File(audioContent.getPath()).exists()) {
            return Uri.parse(audioContent.getPath());
        }
        return audioContent.getToDus2Uri(PathsVolatileState.INSTANCE.getInstance().publicAudios() && !z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri attachmentClicked$lambda$7(Content content, boolean z10) {
        VoiceContent voiceContent = (VoiceContent) content;
        if (new File(voiceContent.getPath()).exists()) {
            return Uri.parse(voiceContent.getPath());
        }
        return voiceContent.getToDus2Uri(PathsVolatileState.INSTANCE.getInstance().publicVoice() && !z10);
    }

    public final void attachmentClicked(MessageAction action, int index, boolean fromOwner, MessageWithPartnerWithReactions messageWithPartnerWithReactions, Context context, f gson, Function1 navigateTo, Function2 startPlaying, a stopPlaying, Function3 requestUserByContact, Function1 sendMessage, Function1 setOnTyping, Function3 setPlaceholderData, final boolean isSecret, Function1 showAttachmentPreview) throws IllegalAccessException, SinglediException, IOException, InvocationTargetException {
        Uri uri;
        Uri uri2;
        String userSender;
        y.i(action, "action");
        y.i(messageWithPartnerWithReactions, "messageWithPartnerWithReactions");
        y.i(context, "context");
        y.i(gson, "gson");
        y.i(navigateTo, "navigateTo");
        y.i(startPlaying, "startPlaying");
        y.i(stopPlaying, "stopPlaying");
        y.i(requestUserByContact, "requestUserByContact");
        y.i(sendMessage, "sendMessage");
        y.i(setOnTyping, "setOnTyping");
        y.i(setPlaceholderData, "setPlaceholderData");
        y.i(showAttachmentPreview, "showAttachmentPreview");
        switch (WhenMappings.$EnumSwitchMapping$0[action.ordinal()]) {
            case 1:
                List<Attachment> attachments = messageWithPartnerWithReactions.getAttachments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : attachments) {
                    Attachment attachment = (Attachment) obj;
                    if (attachment.getType() == 1 || attachment.getType() == 7 || attachment.getType() == 2) {
                        arrayList.add(obj);
                    } else if (attachment.getType() == 5 || attachment.getType() == 13) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(x.y(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Attachment) it.next()).getId());
                }
                showAttachmentPreview.invoke(new AttachmentPreviewState(arrayList2, fromOwner, messageWithPartnerWithReactions.getMessage().getId(), isSecret));
                break;
            case 2:
                List<Attachment> attachments2 = messageWithPartnerWithReactions.getAttachments();
                if (!r.a(attachments2) || !attachments2.isEmpty()) {
                    Iterator<T> it2 = attachments2.iterator();
                    while (it2.hasNext()) {
                        if (((Attachment) it2.next()).getType() == 4) {
                            List<Attachment> attachments3 = messageWithPartnerWithReactions.getAttachments();
                            ArrayList arrayList3 = new ArrayList();
                            for (Object obj2 : attachments3) {
                                if (((Attachment) obj2).getType() == 4) {
                                    arrayList3.add(obj2);
                                }
                            }
                            final Content content = ((Attachment) arrayList3.get(index)).getContent();
                            if ((content instanceof VoiceContent) && (uri = (Uri) new a() { // from class: q7.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ChatComplexFunctionalities.attachmentClicked$lambda$7(content, isSecret);
                                }
                            }.invoke()) != null) {
                                String string = context.getString(R.string.voice_msg);
                                y.h(string, "getString(...)");
                                startPlaying.invoke(new MediaPlayerData(uri, string, ((VoiceContent) content).getUrl()), context);
                                break;
                            }
                        }
                    }
                }
                List<Attachment> attachments4 = messageWithPartnerWithReactions.getAttachments();
                ArrayList arrayList4 = new ArrayList();
                for (Object obj3 : attachments4) {
                    if (((Attachment) obj3).getType() == 3) {
                        arrayList4.add(obj3);
                    }
                }
                final Content content2 = ((Attachment) arrayList4.get(index)).getContent();
                if ((content2 instanceof AudioContent) && (uri2 = (Uri) new a() { // from class: q7.b
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatComplexFunctionalities.attachmentClicked$lambda$4(content2, isSecret);
                    }
                }.invoke()) != null) {
                    AudioContent audioContent = (AudioContent) content2;
                    startPlaying.invoke(new MediaPlayerData(uri2, audioContent.getName(), audioContent.getUrl()), context);
                    break;
                }
                break;
            case 3:
                stopPlaying.invoke();
                break;
            case 4:
                List<Attachment> attachments5 = messageWithPartnerWithReactions.getAttachments();
                ArrayList arrayList5 = new ArrayList();
                for (Object obj4 : attachments5) {
                    if (((Attachment) obj4).getType() == 6) {
                        arrayList5.add(obj4);
                    }
                }
                Content content3 = ((Attachment) arrayList5.get(index)).getContent();
                y.g(content3, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ContactContent");
                ContactContent contactContent = (ContactContent) content3;
                requestUserByContact.invoke(contactContent.getPhone(), contactContent.getFName(), contactContent.getFName());
                break;
            case 5:
                List<Attachment> attachments6 = messageWithPartnerWithReactions.getAttachments();
                ArrayList arrayList6 = new ArrayList();
                for (Object obj5 : attachments6) {
                    if (((Attachment) obj5).getType() == 8) {
                        arrayList6.add(obj5);
                    }
                }
                Content content4 = ((Attachment) arrayList6.get(index)).getContent();
                IntentUtil intentUtil = IntentUtil.INSTANCE;
                y.g(content4, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.EventContent");
                intentUtil.addEvent(context, (EventContent) content4);
                break;
            case 6:
                List<Attachment> attachments7 = messageWithPartnerWithReactions.getAttachments();
                ArrayList arrayList7 = new ArrayList();
                for (Object obj6 : attachments7) {
                    if (((Attachment) obj6).getType() == 5) {
                        arrayList7.add(obj6);
                    }
                }
                Content content5 = ((Attachment) arrayList7.get(index)).getContent();
                y.g(content5, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent");
                final FileContent fileContent = (FileContent) content5;
                Uri uri3 = (Uri) new a() { // from class: q7.d
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatComplexFunctionalities.attachmentClicked$lambda$12(fileContent, isSecret);
                    }
                }.invoke();
                if (uri3 != null) {
                    IntentUtil.INSTANCE.openUri(context, uri3);
                }
                break;
            case 7:
                List<Attachment> attachments8 = messageWithPartnerWithReactions.getAttachments();
                ArrayList arrayList8 = new ArrayList();
                for (Object obj7 : attachments8) {
                    if (((Attachment) obj7).getType() == 10) {
                        arrayList8.add(obj7);
                    }
                }
                Content content6 = ((Attachment) arrayList8.get(index)).getContent();
                y.g(content6, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.LocationContent");
                LocationContent locationContent = (LocationContent) content6;
                NavLinks navLinks = NavLinks.INSTANCE;
                MapMotive mapMotive = MapMotive.SHOW;
                User senderUser = messageWithPartnerWithReactions.getSenderUser();
                if (senderUser == null || (userSender = senderUser.getUsername()) == null) {
                    userSender = messageWithPartnerWithReactions.getMessage().getUserSender();
                }
                String strT = gson.t(new MapParams(mapMotive, null, null, w.g(new Z17MapMarker(userSender, locationContent.getLat(), locationContent.getLon(), locationContent.getZoom(), null, null, 0, 112, null)), 6, null));
                y.h(strT, "toJson(...)");
                navigateTo.invoke(navLinks.goMap(strT));
                break;
            case 8:
                List<Attachment> attachments9 = messageWithPartnerWithReactions.getAttachments();
                ArrayList arrayList9 = new ArrayList();
                for (Object obj8 : attachments9) {
                    if (((Attachment) obj8).getType() == 21) {
                        arrayList9.add(obj8);
                    }
                }
                Content content7 = ((Attachment) arrayList9.get(index)).getContent();
                ChatButtonsFunctionality chatButtonsFunctionality = ChatButtonsFunctionality.INSTANCE;
                y.g(content7, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ButtonContent");
                chatButtonsFunctionality.handleClick((ButtonContent) content7, context, sendMessage, navigateTo, setOnTyping, setPlaceholderData, (64 & 64) != 0 ? new Function1() { // from class: q7.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj9) {
                        return ChatButtonsFunctionality.handleClick$lambda$0((BotShortcut) obj9);
                    }
                } : null);
                break;
        }
    }

    public final MessageWithPartnerWithReactions findMsg(String msgId, List<MessageWithPartnerWithReactions> flowMsgs) {
        Object obj;
        y.i(msgId, "msgId");
        y.i(flowMsgs, "flowMsgs");
        Iterator<T> it = flowMsgs.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) next;
            if ((messageWithPartnerWithReactions != null ? messageWithPartnerWithReactions.getMessage() : null) != null && (y.d(messageWithPartnerWithReactions.getMessage().getId(), msgId) || y.d(messageWithPartnerWithReactions.getMessage().getPublId(), msgId))) {
                obj = next;
                break;
            }
        }
        return (MessageWithPartnerWithReactions) obj;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x009b  */
    public final boolean listIsEditable(List<MessageWithPartnerWithReactions> selectedList, String ownerId) {
        boolean z10;
        boolean z11;
        y.i(selectedList, "selectedList");
        y.i(ownerId, "ownerId");
        boolean z12 = selectedList.size() == 1;
        for (MessageWithPartnerWithReactions messageWithPartnerWithReactions : selectedList) {
            if (messageWithPartnerWithReactions.getMessage().getContent().length() == 0 || d0.q0(messageWithPartnerWithReactions.getMessage().getContent())) {
                z12 = false;
            }
            if (!messageWithPartnerWithReactions.editable(ownerId)) {
                z12 = false;
            }
            if (z12) {
                if (selectedList.isEmpty()) {
                    z11 = true;
                    break;
                }
                Iterator<T> it = selectedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z11 = true;
                        break;
                    }
                    List<Attachment> attachments = ((MessageWithPartnerWithReactions) it.next()).getAttachments();
                    if (!r.a(attachments) || !attachments.isEmpty()) {
                        Iterator<T> it2 = attachments.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z10 = false;
                                break;
                            }
                            if (((Attachment) it2.next()).getType() == 14) {
                                z10 = true;
                                break;
                            }
                        }
                    } else {
                        z10 = false;
                        break;
                        break;
                    }
                    if (z10) {
                        z11 = false;
                        break;
                    }
                }
                if (z11) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                z12 = false;
            }
            if (z12) {
                break;
            }
        }
        return z12;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x008c  */
    public final void selectMethodAndSend(String messageContent, String uid, String replyMsgId, Context context, List<Uri> attachedItemsToSend, a clearAttachedFilesToSend, o sendImages, o sendFiles, o sendAudios, o sendVideos) {
        File file;
        y.i(messageContent, "messageContent");
        y.i(uid, "uid");
        y.i(context, "context");
        y.i(attachedItemsToSend, "attachedItemsToSend");
        y.i(clearAttachedFilesToSend, "clearAttachedFilesToSend");
        y.i(sendImages, "sendImages");
        y.i(sendFiles, "sendFiles");
        y.i(sendAudios, "sendAudios");
        y.i(sendVideos, "sendVideos");
        if (attachedItemsToSend.isEmpty()) {
            return;
        }
        Bundle attachedFilesAndType = PresentListKt.getAttachedFilesAndType(attachedItemsToSend, context);
        int i10 = attachedFilesAndType.getInt("type", -1);
        boolean z10 = attachedFilesAndType.getBoolean("sameType", false);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = attachedItemsToSend.iterator();
        while (it.hasNext()) {
            try {
                String path = MediaUtil.INSTANCE.getPath(context, (Uri) it.next());
                if (path != null) {
                    file = new File(path);
                    if (!file.exists() || !file.isFile()) {
                        file = null;
                    }
                } else {
                    file = null;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (file != null) {
                arrayList.add(file);
            }
        }
        if (!arrayList.isEmpty() && i10 != -1) {
            if (i10 == 5 || !z10) {
                sendFiles.invoke(uid, arrayList, messageContent, replyMsgId);
            } else if (i10 == 1) {
                sendImages.invoke(uid, arrayList, messageContent, replyMsgId);
            } else if (i10 == 2) {
                sendVideos.invoke(uid, arrayList, messageContent, replyMsgId);
            } else if (i10 == 3) {
                sendAudios.invoke(uid, arrayList, messageContent, replyMsgId);
            }
        }
        clearAttachedFilesToSend.invoke();
    }
}
