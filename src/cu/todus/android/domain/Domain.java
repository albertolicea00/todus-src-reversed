package cu.todus.android.domain;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.R;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.content.AudioContent;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.DeletedContent;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.ForwardedContent;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.data.db.pojo.content.ReplyMsgContent;
import cu.todus.android.data.db.pojo.content.StickerContent;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.data.db.pojo.content.VoiceContent;
import cu.todus.android.data.db.pojo.info.ConfigChangeInChannel;
import cu.todus.android.data.db.pojo.info.ConfigChangeInGroup;
import cu.todus.android.data.db.pojo.info.DatePayload;
import cu.todus.android.data.db.pojo.info.DestroyGroup;
import cu.todus.android.data.db.pojo.info.MessagePayload;
import cu.todus.android.data.db.pojo.info.PrivilegesChangeInChannel;
import cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup;
import cu.todus.android.data.db.pojo.messageentity.MentionLink;
import cu.todus.android.data.db.pojo.messageentity.MentionName;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.utils.Base64Util;
import cu.todus.android.utils.DateFormatter;
import cu.todus.android.utils.TextUtilsKt;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import ua.r;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u001b"}, d2 = {"Lcu/todus/android/domain/Domain;", "", "<init>", "()V", "createShorMsg", "", "msg", "Lcu/todus/android/data/db/entity/toDus/Message;", Attachment.TABLE_NAME, "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", Message.COLUMN_PAYLOAD, "Lcu/todus/android/data/db/pojo/info/MessagePayload;", "context", "Landroid/content/Context;", "ownerId", "senderAlias", "resumeAttachments", "messagePayloadToString", "", "parseMessageEntities", "Landroid/text/Spannable;", "text", Service.Endpoint.LINKED_DEVICES_LIST, "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", "trimText", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Domain {
    public static final int $stable = 0;
    public static final Domain INSTANCE = new Domain();

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PrivilegesChangeInGroup.PRIVILEGES.values().length];
            try {
                iArr[PrivilegesChangeInGroup.PRIVILEGES.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrivilegesChangeInGroup.PRIVILEGES.MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrivilegesChangeInGroup.PRIVILEGES.OWNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrivilegesChangeInGroup.PRIVILEGES.ADMIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PrivilegesChangeInChannel.PRIVILEGES.values().length];
            try {
                iArr2[PrivilegesChangeInChannel.PRIVILEGES.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PrivilegesChangeInChannel.PRIVILEGES.MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PrivilegesChangeInChannel.PRIVILEGES.OWNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PrivilegesChangeInChannel.PRIVILEGES.ADMIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private Domain() {
    }

    public static /* synthetic */ Spannable parseMessageEntities$default(Domain domain, CharSequence charSequence, List list, boolean z10, Context context, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return domain.parseMessageEntities(charSequence, list, z10, context);
    }

    private final String resumeAttachments(Context context, List<Attachment> attachments) {
        if (!attachments.isEmpty()) {
            Content content = ((Attachment) g0.w0(attachments)).getContent();
            if (content instanceof ButtonContent) {
                return "🆒" + context.getString(R.string.button_group);
            }
            if (content instanceof VoiceContent) {
                return "🎙️" + context.getString(R.string.voice_msg);
            }
            if (content instanceof ContactContent) {
                String string = context.getString(R.string.contact);
                Content content2 = ((Attachment) g0.w0(attachments)).getContent();
                y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ContactContent");
                return "📓" + string + ": " + ((ContactContent) content2).getFName();
            }
            if (content instanceof AudioContent) {
                return "💿" + context.getString(R.string.audio);
            }
            if (content instanceof ImageContent) {
                return "📷" + context.getString(R.string.image);
            }
            if (content instanceof StickerContent) {
                return "🙂" + context.getString(R.string.sticker);
            }
            if (content instanceof VideoContent) {
                return "🎥" + context.getString(R.string.video);
            }
            if (content instanceof FileContent) {
                String string2 = context.getString(R.string.file);
                Content content3 = ((Attachment) g0.w0(attachments)).getContent();
                y.g(content3, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent");
                return "📁" + string2 + ": " + ((FileContent) content3).getName();
            }
            if (content instanceof EventContent) {
                return "📅" + context.getString(R.string.date);
            }
            if (content instanceof LocationContent) {
                return "📍" + context.getString(R.string.location);
            }
            if (content instanceof ReplyMsgContent) {
                String string3 = context.getString(R.string.replied);
                y.f(string3);
                return string3;
            }
            if (content instanceof ForwardedContent) {
                String string4 = context.getString(R.string.forwarded);
                y.f(string4);
                return string4;
            }
            if (content instanceof DeletedContent) {
                String string5 = context.getString(R.string.eliminated_message);
                y.f(string5);
                return string5;
            }
            if (content instanceof CallContent) {
                return "📞" + context.getString(R.string.call);
            }
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:119:0x037a  */
    public final String createShorMsg(Message msg, List<Attachment> attachments, MessagePayload payload, Context context, String ownerId, String senderAlias) {
        String string;
        String content;
        String content2;
        String content3;
        String content4;
        y.i(attachments, "attachments");
        y.i(context, "context");
        y.i(ownerId, "ownerId");
        y.i(senderAlias, "senderAlias");
        if (payload == null) {
            string = "";
            boolean zD = false;
            if (attachments.isEmpty()) {
                String str = (msg == null || (content = msg.getContent()) == null) ? "" : content;
                if (d0.q0(str) || d0.a0(str, "CALL", false, 2, null)) {
                    try {
                        if (a0.U(str, "CALL", false, 2, null)) {
                            List listS0 = d0.S0(str, new String[]{" "}, false, 0, 6, null);
                            string = listS0.size() > 2 ? y.d(listS0.get(2), "1") : false ? "📞" + context.getString(R.string.video_call) : "📞" + context.getString(R.string.call);
                        } else {
                            string = str;
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    string = str;
                }
            } else {
                Content content5 = ((Attachment) g0.w0(attachments)).getContent();
                if (content5 instanceof DeletedContent) {
                    string = context.getString(R.string.eliminated_message);
                    y.f(string);
                } else if (content5 instanceof ReplyMsgContent) {
                    String string2 = context.getString(R.string.replied);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : attachments) {
                        if (((Attachment) obj).getType() != 9) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : arrayList) {
                        if (((Attachment) obj2).getType() != 14) {
                            arrayList2.add(obj2);
                        }
                    }
                    String strResumeAttachments = resumeAttachments(context, arrayList2);
                    if (msg != null && (content4 = msg.getContent()) != null) {
                        string = content4;
                    }
                    string = string2 + " " + strResumeAttachments + " " + string;
                } else if (content5 instanceof ForwardedContent) {
                    String string3 = context.getString(R.string.forwarded);
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj3 : attachments) {
                        if (((Attachment) obj3).getType() != 9) {
                            arrayList3.add(obj3);
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj4 : arrayList3) {
                        if (((Attachment) obj4).getType() != 14) {
                            arrayList4.add(obj4);
                        }
                    }
                    String strResumeAttachments2 = resumeAttachments(context, arrayList4);
                    if (msg != null && (content3 = msg.getContent()) != null) {
                        string = content3;
                    }
                    string = string3 + " " + strResumeAttachments2 + " " + string;
                } else if (content5 instanceof ButtonContent) {
                    string = "🆒" + context.getString(R.string.button_group);
                } else if (content5 instanceof VoiceContent) {
                    string = "🎙️" + context.getString(R.string.voice_msg);
                } else if (content5 instanceof ContactContent) {
                    String string4 = context.getString(R.string.contact);
                    Content content6 = ((Attachment) g0.w0(attachments)).getContent();
                    y.g(content6, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ContactContent");
                    string = "📓" + string4 + ": " + ((ContactContent) content6).getFName();
                } else if (content5 instanceof AudioContent) {
                    string = "💿" + context.getString(R.string.audio);
                } else if (content5 instanceof ImageContent) {
                    string = "📷" + context.getString(R.string.image);
                } else if (content5 instanceof StickerContent) {
                    string = "🙂" + context.getString(R.string.sticker);
                } else if (content5 instanceof VideoContent) {
                    string = "🎥" + context.getString(R.string.video);
                } else if (content5 instanceof FileContent) {
                    String string5 = context.getString(R.string.file);
                    Content content7 = ((Attachment) g0.w0(attachments)).getContent();
                    y.g(content7, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent");
                    string = "📁" + string5 + ": " + ((FileContent) content7).getName();
                } else if (content5 instanceof EventContent) {
                    string = "📅" + context.getString(R.string.date);
                } else if (content5 instanceof LocationContent) {
                    string = "📍" + context.getString(R.string.location);
                } else {
                    if (content5 instanceof CallContent) {
                        try {
                            Base64Util base64Util = Base64Util.INSTANCE;
                            Content content8 = ((Attachment) g0.w0(attachments)).getContent();
                            y.g(content8, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.CallContent");
                            String strDecodedMessage$default = Base64Util.decodedMessage$default(base64Util, ((CallContent) content8).getState(), 0, 2, null);
                            if (strDecodedMessage$default != null) {
                                string = strDecodedMessage$default;
                            }
                            List listS1 = d0.S0(d0.b1(string, ' ', null, 2, null), new String[]{" "}, false, 0, 6, null);
                            if (listS1.size() > 1) {
                                zD = y.d(listS1.get(1), "1");
                            }
                        } catch (Exception unused2) {
                        }
                        content2 = zD ? "📞" + context.getString(R.string.video_call) : "📞" + context.getString(R.string.call);
                    } else if (msg != null && (content2 = msg.getContent()) != null) {
                    }
                    string = content2;
                }
                Objects.toString(attachments);
            }
        } else {
            string = messagePayloadToString(context, payload, ownerId, senderAlias).toString();
        }
        return TextUtilsKt.removeHtmlTags(string);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b2  */
    public final CharSequence messagePayloadToString(Context context, MessagePayload payload, String ownerId, String senderAlias) {
        String string;
        String string2;
        String string3;
        y.i(context, "context");
        y.i(ownerId, "ownerId");
        y.i(senderAlias, "senderAlias");
        if (payload instanceof PrivilegesChangeInGroup) {
            PrivilegesChangeInGroup privilegesChangeInGroup = (PrivilegesChangeInGroup) payload;
            int i10 = WhenMappings.$EnumSwitchMapping$0[privilegesChangeInGroup.getPrivileges().ordinal()];
            if (i10 == 1) {
                string3 = !y.d(privilegesChangeInGroup.getUserId(), ownerId) ? context.getString(R.string.placeholder_has_left_the_group, senderAlias) : context.getString(R.string.you_leave_group);
            } else if (i10 == 2) {
                boolean z10 = privilegesChangeInGroup.getBeforePrivileges() == PrivilegesChangeInGroup.PRIVILEGES.OWNER;
                if (y.d(privilegesChangeInGroup.getUserId(), ownerId)) {
                    string3 = context.getString(z10 ? R.string.you_are_not_group_admin : R.string.welcome_to_group);
                } else {
                    string3 = context.getString(z10 ? R.string.placeholder_is_not_group_admin : R.string.placeholder_is_group_member, senderAlias);
                }
            } else {
                if (i10 != 3 && i10 != 4) {
                    throw new r();
                }
                string3 = !y.d(privilegesChangeInGroup.getUserId(), ownerId) ? context.getString(R.string.placeholder_is_group_admin, senderAlias) : context.getString(R.string.you_are_group_admin);
            }
            y.f(string3);
            return string3;
        }
        if (payload instanceof PrivilegesChangeInChannel) {
            PrivilegesChangeInChannel privilegesChangeInChannel = (PrivilegesChangeInChannel) payload;
            int i11 = WhenMappings.$EnumSwitchMapping$1[privilegesChangeInChannel.getPrivileges().ordinal()];
            if (i11 == 1) {
                string2 = !y.d(privilegesChangeInChannel.getUserId(), ownerId) ? context.getString(R.string.placeholder_has_left_the_channel, senderAlias) : context.getString(R.string.you_leave_channel);
            } else if (i11 == 2) {
                boolean z11 = privilegesChangeInChannel.getBeforePrivileges() == PrivilegesChangeInChannel.PRIVILEGES.OWNER;
                if (y.d(privilegesChangeInChannel.getUserId(), ownerId)) {
                    string2 = context.getString(z11 ? R.string.you_are_not_channel_admin : R.string.welcome_to_channel);
                } else {
                    string2 = context.getString(z11 ? R.string.placeholder_is_not_channel_admin : R.string.placeholder_is_channel_member, senderAlias);
                }
            } else {
                if (i11 != 3 && i11 != 4) {
                    throw new r();
                }
                string2 = !y.d(privilegesChangeInChannel.getUserId(), ownerId) ? context.getString(R.string.placeholder_is_channel_admin, senderAlias) : context.getString(R.string.you_are_channel_admin);
            }
            y.f(string2);
            return string2;
        }
        String string4 = "";
        if (!(payload instanceof ConfigChangeInGroup)) {
            if (payload instanceof ConfigChangeInChannel) {
                return "";
            }
            if (!(payload instanceof DestroyGroup)) {
                return payload instanceof DatePayload ? DateFormatter.INSTANCE.format(new Date(((DatePayload) payload).getDate()), DateFormatter.Template.STRING_DAY_MONTH_YEAR) : "";
            }
            String string5 = context.getString(R.string.eliminate_group);
            y.f(string5);
            return string5;
        }
        ConfigChangeInGroup configChangeInGroup = (ConfigChangeInGroup) payload;
        String roomName = configChangeInGroup.getRoomName();
        String string6 = (roomName == null || d0.q0(roomName)) ? "" : context.getString(R.string.the_group_name_now_is, configChangeInGroup.getRoomName());
        String subject = configChangeInGroup.getSubject();
        String string7 = (subject == null || d0.q0(subject)) ? "" : context.getString(R.string.description_group_has_changed_to, configChangeInGroup.getSubject());
        HashMap<String, String> customConfigs = configChangeInGroup.getCustomConfigs();
        if (customConfigs == null || !customConfigs.containsKey(Room.CONFIG_PICTURE)) {
            string = "";
        } else {
            String str = configChangeInGroup.getCustomConfigs().get(Room.CONFIG_PICTURE);
            if (str == null || !str.equals(Room.CONFIG_NO_PICTURE)) {
                String str2 = configChangeInGroup.getCustomConfigs().get(Room.CONFIG_PICTURE);
                if (str2 == null || str2.length() <= 0) {
                    string = "";
                } else {
                    string = context.getString(R.string.image_group_has_changed);
                }
            } else {
                string = context.getString(R.string.image_group_has_been_removed);
            }
        }
        HashMap<String, String> customConfigs2 = configChangeInGroup.getCustomConfigs();
        if (customConfigs2 != null && customConfigs2.containsKey(Room.CONFIG_PINED_MESSAGE)) {
            String str3 = configChangeInGroup.getCustomConfigs().get(Room.CONFIG_PINED_MESSAGE);
            if (str3 == null || !str3.equals("")) {
                String str4 = configChangeInGroup.getCustomConfigs().get(Room.CONFIG_PINED_MESSAGE);
                if (str4 != null && str4.length() > 0) {
                    String str5 = configChangeInGroup.getCustomConfigs().get(Room.CONFIG_PINED_MESSAGE);
                    String string8 = context.getString(R.string.pinned_msg_on_group_now_is);
                    y.h(string8, "getString(...)");
                    return string8 + " ' " + str5 + "'.";
                }
            } else {
                string4 = context.getString(R.string.pinned_message_on_group_was_deleted);
            }
        }
        return string6 + string7 + string + string4;
    }

    public final Spannable parseMessageEntities(CharSequence text, List<? extends MessageEntity> list, boolean trimText, Context context) {
        y.i(text, "text");
        y.i(list, "list");
        y.i(context, "context");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        SpannableStringBuilder spannableStringBuilderAppend = (!trimText || text.length() <= 400) ? null : new SpannableStringBuilder(spannableStringBuilder, 0, TypedValues.CycleType.TYPE_CURVE_FIT).append((CharSequence) context.getString(R.string.show_more));
        for (MessageEntity messageEntity : list) {
            if (!(messageEntity instanceof MentionName) && (messageEntity instanceof MentionLink)) {
                String url = messageEntity.getUrl();
                if (url == null || a0.U(url, "http://", false, 2, null) || a0.U(messageEntity.getUrl(), "https://", false, 2, null)) {
                    messageEntity.getUrl();
                } else {
                    messageEntity.getUrl();
                }
            }
        }
        return spannableStringBuilderAppend != null ? spannableStringBuilderAppend : spannableStringBuilder;
    }
}
