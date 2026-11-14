package cu.todus.android.xmpp.extension.button;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcu/todus/android/xmpp/extension/button/ExtensionButton;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "messageId", "getMessageId", "setMessageId", "btnTitle", "getBtnTitle", "setBtnTitle", "btnDesc", "getBtnDesc", "setBtnDesc", "msgCmd", "getMsgCmd", "setMsgCmd", "msgContent", "getMsgContent", "setMsgContent", "btnSize", "", "getBtnSize", "()F", "setBtnSize", "(F)V", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionButton implements ExtensionElement {
    public static final String CMD_ADD_SHORTCUT = "cmd_add_shortcut";
    public static final String CMD_COPY_TO_CLIPBOARD = "cmd_copy_to_clipboard";
    public static final String CMD_OPEN_APP_SCREEN = "cmd_open_app_screen";
    public static final String CMD_OPEN_WEB = "cmd_open_web";
    public static final String CMD_PLACEHOLDER = "cmd_placeholder";
    public static final String CMD_PLACEHOLDER_CONTACT_SEND = "cmd_placeholder_contact_send";
    public static final String CMD_PLACEHOLDER_SEND = "cmd_placeholder_send";
    public static final String CMD_TYPE_SEND = "cmd_type_send";
    public static final String ELEMENT = "button";
    public static final float FULL_SIZE = 0.82f;
    public static final float MID_SIZE = 0.4f;
    public static final String NAMESPACE = "button:n";
    public static final String TAG_BTN_SIZE = "btn_size";
    public static final String TAG_DESC = "btn_d";
    public static final String TAG_MESSAGE_ID = "mi";
    public static final String TAG_MSG_CMD = "btn_cmd";
    public static final String TAG_MSG_CONT = "btn_msg_c";
    public static final String TAG_TITLE = "btn_t";
    public static final int $stable = 8;
    private String id = "";
    private String messageId = "";
    private String btnTitle = "";
    private String btnDesc = "";
    private String msgCmd = "";
    private String msgContent = "";
    private float btnSize = 0.82f;

    public final String getBtnDesc() {
        return this.btnDesc;
    }

    public final float getBtnSize() {
        return this.btnSize;
    }

    public final String getBtnTitle() {
        return this.btnTitle;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getMsgCmd() {
        return this.msgCmd;
    }

    public final String getMsgContent() {
        return this.msgContent;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final void setBtnDesc(String str) {
        y.i(str, "<set-?>");
        this.btnDesc = str;
    }

    public final void setBtnSize(float f10) {
        this.btnSize = f10;
    }

    public final void setBtnTitle(String str) {
        y.i(str, "<set-?>");
        this.btnTitle = str;
    }

    public final void setId(String str) {
        y.i(str, "<set-?>");
        this.id = str;
    }

    public final void setMessageId(String str) {
        y.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void setMsgCmd(String str) {
        y.i(str, "<set-?>");
        this.msgCmd = str;
    }

    public final void setMsgContent(String str) {
        y.i(str, "<set-?>");
        this.msgContent = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("i", this.id);
        xmlStringBuilder.attribute("mi", this.messageId);
        xmlStringBuilder.attribute(TAG_TITLE, this.btnTitle);
        xmlStringBuilder.attribute(TAG_DESC, this.btnDesc);
        xmlStringBuilder.attribute(TAG_MSG_CMD, this.msgCmd);
        xmlStringBuilder.attribute(TAG_MSG_CONT, this.msgContent);
        xmlStringBuilder.attribute(TAG_BTN_SIZE, String.valueOf(this.btnSize));
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
