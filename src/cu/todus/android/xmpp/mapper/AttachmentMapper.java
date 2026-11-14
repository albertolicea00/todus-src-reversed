package cu.todus.android.xmpp.mapper;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.content.AudioContent;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.DeleteOwnerMessageContent;
import cu.todus.android.data.db.pojo.content.DeletedContent;
import cu.todus.android.data.db.pojo.content.EditedContent;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.ForwardedContent;
import cu.todus.android.data.db.pojo.content.GifContent;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.data.db.pojo.content.PubDeletedContent;
import cu.todus.android.data.db.pojo.content.PubEditedContent;
import cu.todus.android.data.db.pojo.content.ReactionContent;
import cu.todus.android.data.db.pojo.content.RefreshToDusIdContent;
import cu.todus.android.data.db.pojo.content.ReplyMsgContent;
import cu.todus.android.data.db.pojo.content.StatusExistenceContent;
import cu.todus.android.data.db.pojo.content.StickerContent;
import cu.todus.android.data.db.pojo.content.StreamVideoContent;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.data.db.pojo.content.VoiceContent;
import cu.todus.android.utils.Base64Util;
import cu.todus.android.xmpp.extension.audio.ExtensionAudio;
import cu.todus.android.xmpp.extension.button.ExtensionButton;
import cu.todus.android.xmpp.extension.call.ExtensionCall;
import cu.todus.android.xmpp.extension.contact.ExtensionContact;
import cu.todus.android.xmpp.extension.deleteOwnerMessage.ExtensionDeleteOwnerMessage;
import cu.todus.android.xmpp.extension.deleted.ExtensionDeleted;
import cu.todus.android.xmpp.extension.edited.ExtensionEdited;
import cu.todus.android.xmpp.extension.event.ExtensionEvent;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import cu.todus.android.xmpp.extension.forward.ExtensionForwarded;
import cu.todus.android.xmpp.extension.gif.ExtensionGif;
import cu.todus.android.xmpp.extension.image.ExtensionImage;
import cu.todus.android.xmpp.extension.link.ExtensionLinkInfo;
import cu.todus.android.xmpp.extension.location.ExtensionLocation;
import cu.todus.android.xmpp.extension.pubDeleted.ExtensionPubDeleted;
import cu.todus.android.xmpp.extension.pubEdited.ExtensionPubEdited;
import cu.todus.android.xmpp.extension.reaction.ExtensionReaction;
import cu.todus.android.xmpp.extension.refreshToDusId.ExtensionRefreshToDusId;
import cu.todus.android.xmpp.extension.statusExistence.ExtensionStatusExistence;
import cu.todus.android.xmpp.extension.sticker.ExtensionSticker;
import cu.todus.android.xmpp.extension.streamVideo.ExtensionStreamVideo;
import cu.todus.android.xmpp.extension.video.ExtensionVideo;
import cu.todus.android.xmpp.extension.voice.ExtensionVoice;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.forward.packet.Forwarded;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u00100\u001a\u00020\t2\u0006\u0010\u0006\u001a\u000201J\u000e\u00102\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u00103\u001a\u00020\t2\u0006\u0010\u0006\u001a\u000204J\u000e\u00105\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u00106\u001a\u00020\t2\u0006\u0010\u0006\u001a\u000207J\u000e\u00108\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u00109\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020:J\u000e\u0010;\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020=J\u000e\u0010>\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020@J\u000e\u0010A\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010B\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020CJ\u000e\u0010D\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010E\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020FJ\u000e\u0010G\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020IJ\u000e\u0010J\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010K\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020LJ\u000e\u0010M\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010N\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020OJ\u000e\u0010P\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010Q\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020R2\u0006\u0010S\u001a\u00020T¨\u0006U"}, d2 = {"Lcu/todus/android/xmpp/mapper/AttachmentMapper;", "", "<init>", "()V", "identifyAttachmentContact", "", "element", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "createAttachmentContact", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "Lcu/todus/android/xmpp/extension/contact/ExtensionContact;", "identifyAttachmentEvent", "createAttachmentEvent", "Lcu/todus/android/xmpp/extension/event/ExtensionEvent;", "identifyAttachmentLocation", "createAttachmentLocation", "Lcu/todus/android/xmpp/extension/location/ExtensionLocation;", "identifyAttachmentForwarded", "createAttachmentForwarded", "Lcu/todus/android/xmpp/extension/forward/ExtensionForwarded;", "identifyAttachmentEdited", "createAttachmentEdited", "Lcu/todus/android/xmpp/extension/edited/ExtensionEdited;", "identifyAttachmentDeleted", "createAttachmentDeleted", "Lcu/todus/android/xmpp/extension/deleted/ExtensionDeleted;", "identifyAttachmentReply", "createAttachmentReply", "Lorg/jivesoftware/smackx/forward/packet/Forwarded;", "stanza", "Lorg/jivesoftware/smack/packet/Message;", "isMe", "identifyAttachmentVoice", "createAttachmentVoice", "Lcu/todus/android/xmpp/extension/voice/ExtensionVoice;", "identifyAttachmentImage", "createAttachmentImage", "Lcu/todus/android/xmpp/extension/image/ExtensionImage;", "identifyAttachmentGif", "createAttachmentGif", "Lcu/todus/android/xmpp/extension/gif/ExtensionGif;", "identifyAttachmentAudio", "createAttachmentAudio", "Lcu/todus/android/xmpp/extension/audio/ExtensionAudio;", "identifyAttachmentVideo", "createAttachmentVideo", "Lcu/todus/android/xmpp/extension/video/ExtensionVideo;", "identifyAttachmentFile", "createAttachmentFile", "Lcu/todus/android/xmpp/extension/file/ExtensionFile;", "identifyAttachmentSticker", "createAttachmentSticker", "Lcu/todus/android/xmpp/extension/sticker/ExtensionSticker;", "identifyAttachmentLinkInfo", "createAttachmentLinkInfo", "Lcu/todus/android/xmpp/extension/link/ExtensionLinkInfo;", "identifyAttachmentButton", "createAttachmentButton", "Lcu/todus/android/xmpp/extension/button/ExtensionButton;", "identifyAttachmentReaction", "createAttachmentReaction", "Lcu/todus/android/xmpp/extension/reaction/ExtensionReaction;", "identifyAttachmentStatusExistence", "createAttachmentStatusExistence", "Lcu/todus/android/xmpp/extension/statusExistence/ExtensionStatusExistence;", "identifyAttachmentPubEdited", "createAttachmentPubEdited", "Lcu/todus/android/xmpp/extension/pubEdited/ExtensionPubEdited;", "identifyAttachmentPubDeleted", "createAttachmentPubDeleted", "Lcu/todus/android/xmpp/extension/pubDeleted/ExtensionPubDeleted;", "identifyAttachmentRefreshToDusId", "createAttachmentToDusId", "Lcu/todus/android/xmpp/extension/refreshToDusId/ExtensionRefreshToDusId;", "identifyAttachmentDeleteOwnerMessage", "createAttachmentDeleteOwnerMessage", "Lcu/todus/android/xmpp/extension/deleteOwnerMessage/ExtensionDeleteOwnerMessage;", "identifyAttachmentStreamVideo", "createAttachmentStreamVideo", "Lcu/todus/android/xmpp/extension/streamVideo/ExtensionStreamVideo;", "identifyAttachmentCall", "createAttachmentCall", "Lcu/todus/android/xmpp/extension/call/ExtensionCall;", TypedValues.TransitionType.S_FROM, "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AttachmentMapper {
    public static final int $stable = 0;
    public static final AttachmentMapper INSTANCE = new AttachmentMapper();

    private AttachmentMapper() {
    }

    public final Attachment createAttachmentAudio(ExtensionAudio element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new AudioContent(element.getName(), element.getDuration(), null, element.getUrl(), element.getSize(), element.getHash(), 4, null), 4, 3, false, 32, null);
    }

    public final Attachment createAttachmentButton(ExtensionButton element) {
        y.i(element, "element");
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        String messageId = element.getMessageId();
        String btnTitle = element.getBtnTitle();
        String btnDesc = element.getBtnDesc();
        String msgCmd = element.getMsgCmd();
        String strDecodedMessage$default = Base64Util.decodedMessage$default(Base64Util.INSTANCE, element.getMsgContent(), 0, 2, null);
        if (strDecodedMessage$default == null) {
            strDecodedMessage$default = element.getMsgContent();
        }
        return new Attachment(string, messageId, new ButtonContent(btnTitle, btnDesc, msgCmd, strDecodedMessage$default, element.getBtnSize()), 6, 21, false, 32, null);
    }

    public final Attachment createAttachmentCall(ExtensionCall element, String from) {
        y.i(element, "element");
        y.i(from, "from");
        String id2 = element.getId();
        String messageId = element.getMessageId();
        String callId = element.getCallId();
        String strDecodedMessage$default = Base64Util.decodedMessage$default(Base64Util.INSTANCE, element.getState(), 0, 2, null);
        if (strDecodedMessage$default == null) {
            strDecodedMessage$default = "";
        }
        return new Attachment(id2, messageId, new CallContent(from, callId, strDecodedMessage$default, element.getMessageId(), 0L, 0L, 48, null), 6, 32, false, 32, null);
    }

    public final Attachment createAttachmentContact(ExtensionContact element) {
        String number;
        String name;
        y.i(element, "element");
        String id2 = element.getId();
        String messageId = element.getMessageId();
        if (element.getNumber().length() > 32) {
            number = element.getNumber().substring(0, 32);
            y.h(number, "substring(...)");
        } else {
            number = element.getNumber();
        }
        if (element.getName().length() > 128) {
            name = element.getName().substring(0, 128);
            y.h(name, "substring(...)");
        } else {
            name = element.getName();
        }
        return new Attachment(id2, messageId, new ContactContent(number, name, null, null, 12, null), 6, 6, false, 32, null);
    }

    public final Attachment createAttachmentDeleteOwnerMessage(ExtensionDeleteOwnerMessage element) {
        y.i(element, "element");
        return new Attachment("", "", new DeleteOwnerMessageContent(element.getMessageId()), 6, 29, false, 32, null);
    }

    public final Attachment createAttachmentDeleted(ExtensionDeleted element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new DeletedContent(), 6, 16, false, 32, null);
    }

    public final Attachment createAttachmentEdited(ExtensionEdited element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new EditedContent(), 6, 15, false, 32, null);
    }

    public final Attachment createAttachmentEvent(ExtensionEvent element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new EventContent(element.getTitle(), element.getIcs(), element.getStart(), element.getEnd(), element.getAllDay()), 6, 8, false, 32, null);
    }

    public final Attachment createAttachmentFile(ExtensionFile element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new FileContent(element.getName(), null, element.getUrl(), element.getSize(), element.getHash(), 5, 2, null), 4, 5, false, 32, null);
    }

    public final Attachment createAttachmentForwarded(ExtensionForwarded element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new ForwardedContent(element.getOwnerUser()), 6, 14, false, 32, null);
    }

    public final Attachment createAttachmentGif(ExtensionGif element) {
        y.i(element, "element");
        String id2 = element.getId();
        String messageId = element.getMessageId();
        String thumbnail = element.getThumbnail();
        String url = element.getUrl();
        return new Attachment(id2, messageId, new GifContent(thumbnail, element.getWidth(), element.getHeight(), element.getName(), null, url, element.getSize(), element.getHash(), 16, null), 4, 7, false, 32, null);
    }

    public final Attachment createAttachmentImage(ExtensionImage element) {
        y.i(element, "element");
        String id2 = element.getId();
        String messageId = element.getMessageId();
        String thumbnail = element.getThumbnail();
        String url = element.getUrl();
        return new Attachment(id2, messageId, new ImageContent(thumbnail, element.getWidth(), element.getHeight(), element.getName(), null, url, element.getSize(), element.getHash(), 16, null), 4, 1, false, 32, null);
    }

    public final Attachment createAttachmentLinkInfo(ExtensionLinkInfo element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new LinkInfoContent(element.getDownloadedInfo(), element.getLinkEntity()), 6, 20, false, 32, null);
    }

    public final Attachment createAttachmentLocation(ExtensionLocation element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new LocationContent(element.getLat(), element.getLon(), element.getZoom(), element.getThumbnails()), 6, 10, false, 32, null);
    }

    public final Attachment createAttachmentPubDeleted(ExtensionPubDeleted element) {
        y.i(element, "element");
        return new Attachment("", "", new PubDeletedContent(element.getChId() + "@ch", element.getPubsId()), 6, 25, false, 32, null);
    }

    public final Attachment createAttachmentPubEdited(ExtensionPubEdited element) {
        y.i(element, "element");
        return new Attachment("", "", new PubEditedContent(element.getPubId(), element.getChId() + "@ch"), 6, 24, false, 32, null);
    }

    public final Attachment createAttachmentReaction(ExtensionReaction element) {
        y.i(element, "element");
        return new Attachment(element.getId(), element.getMessageId(), new ReactionContent(element.getEntity(), element.getReactionContent(), element.getCreatedAt()), 6, 23, false, 32, null);
    }

    public final Attachment createAttachmentReply(Forwarded element, Message stanza, boolean isMe) {
        y.i(element, "element");
        y.i(stanza, "stanza");
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        String stanzaId = stanza.getStanzaId();
        y.h(stanzaId, "getStanzaId(...)");
        String stanzaId2 = element.getForwardedStanza().getStanzaId();
        y.h(stanzaId2, "getStanzaId(...)");
        return new Attachment(string, stanzaId, new ReplyMsgContent(stanzaId2, isMe, null, null, null, 0, 0L, false, false, null, null, 2044, null), 6, 9, false, 32, null);
    }

    public final Attachment createAttachmentStatusExistence(ExtensionStatusExistence element) {
        y.i(element, "element");
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        return new Attachment(string, "", new StatusExistenceContent(element.getStatusId(), element.getCreateAt(), element.getIsDelete()), 6, 22, false, 32, null);
    }

    public final Attachment createAttachmentSticker(ExtensionSticker element) {
        y.i(element, "element");
        String id2 = element.getId();
        String messageId = element.getMessageId();
        String name = element.getName();
        return new Attachment(id2, messageId, new StickerContent(element.getFolder(), element.getJson(), name, null, element.getUrl(), element.getSize(), element.getHash(), 8, null), 6, 13, false, 32, null);
    }

    public final Attachment createAttachmentStreamVideo(ExtensionStreamVideo element) {
        y.i(element, "element");
        return new Attachment("", "", new StreamVideoContent(element.getGetUrl(), element.getStreamUrl(), element.getDownloadUrl()), 6, 31, false, 32, null);
    }

    public final Attachment createAttachmentToDusId(ExtensionRefreshToDusId element) {
        y.i(element, "element");
        return new Attachment("", "", new RefreshToDusIdContent(element.getUserId(), element.getToDusId()), 6, 28, false, 32, null);
    }

    public final Attachment createAttachmentVideo(ExtensionVideo element) {
        y.i(element, "element");
        String id2 = element.getId();
        String messageId = element.getMessageId();
        String name = element.getName();
        return new Attachment(id2, messageId, new VideoContent(element.getThumbnail(), element.getDuration(), element.getWidth(), element.getHeight(), name, null, element.getUrl(), element.getSize(), element.getHash(), 32, null), 4, 2, false, 32, null);
    }

    public final Attachment createAttachmentVoice(ExtensionVoice element) {
        y.i(element, "element");
        String id2 = element.getId();
        String messageId = element.getMessageId();
        long duration = element.getDuration();
        long size = element.getSize();
        return new Attachment(id2, messageId, new VoiceContent(duration, element.getWaveSample(), null, element.getUrl(), size, element.getHash(), 4, null), 4, 4, false, 32, null);
    }

    public final boolean identifyAttachmentAudio(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), "audio") && (element instanceof ExtensionAudio);
    }

    public final boolean identifyAttachmentButton(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionButton.ELEMENT) && (element instanceof ExtensionButton);
    }

    public final boolean identifyAttachmentCall(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionCall.ELEMENT) && (element instanceof ExtensionCall);
    }

    public final boolean identifyAttachmentContact(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), "contact") && (element instanceof ExtensionContact);
    }

    public final boolean identifyAttachmentDeleteOwnerMessage(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionDeleteOwnerMessage.ELEMENT) && (element instanceof ExtensionDeleteOwnerMessage);
    }

    public final boolean identifyAttachmentDeleted(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionDeleted.ELEMENT) && (element instanceof ExtensionDeleted);
    }

    public final boolean identifyAttachmentEdited(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionEdited.ELEMENT) && (element instanceof ExtensionEdited);
    }

    public final boolean identifyAttachmentEvent(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), "event") && (element instanceof ExtensionEvent);
    }

    public final boolean identifyAttachmentFile(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionFile.ELEMENT) && (element instanceof ExtensionFile);
    }

    public final boolean identifyAttachmentForwarded(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionForwarded.ELEMENT) && (element instanceof ExtensionForwarded);
    }

    public final boolean identifyAttachmentGif(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionGif.ELEMENT) && (element instanceof ExtensionGif);
    }

    public final boolean identifyAttachmentImage(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), "image") && (element instanceof ExtensionImage);
    }

    public final boolean identifyAttachmentLinkInfo(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionLinkInfo.ELEMENT) && (element instanceof ExtensionLinkInfo);
    }

    public final boolean identifyAttachmentLocation(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), "location") && (element instanceof ExtensionLocation);
    }

    public final boolean identifyAttachmentPubDeleted(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionPubDeleted.ELEMENT) && (element instanceof ExtensionPubDeleted);
    }

    public final boolean identifyAttachmentPubEdited(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionPubEdited.ELEMENT) && (element instanceof ExtensionPubEdited);
    }

    public final boolean identifyAttachmentReaction(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), "reaction") && (element instanceof ExtensionReaction);
    }

    public final boolean identifyAttachmentRefreshToDusId(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionRefreshToDusId.ELEMENT) && (element instanceof ExtensionRefreshToDusId);
    }

    public final boolean identifyAttachmentReply(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), Forwarded.ELEMENT) && (element instanceof Forwarded);
    }

    public final boolean identifyAttachmentStatusExistence(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionStatusExistence.ELEMENT) && (element instanceof ExtensionStatusExistence);
    }

    public final boolean identifyAttachmentSticker(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), "sticker") && (element instanceof ExtensionSticker);
    }

    public final boolean identifyAttachmentStreamVideo(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionStreamVideo.ELEMENT) && (element instanceof ExtensionStreamVideo);
    }

    public final boolean identifyAttachmentVideo(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), "video") && (element instanceof ExtensionVideo);
    }

    public final boolean identifyAttachmentVoice(ExtensionElement element) {
        y.i(element, "element");
        return y.d(element.getElementName(), ExtensionVoice.ELEMENT) && (element instanceof ExtensionVoice);
    }
}
