package cu.todus.android.xmpp.extension.reaction;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Reaction;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcu/todus/android/xmpp/extension/reaction/ExtensionReaction;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "messageId", "getMessageId", "setMessageId", Reaction.COLUMN_ENTITY, "getEntity", "setEntity", "reactionContent", "getReactionContent", "setReactionContent", "createdAt", "", "getCreatedAt", "()J", "setCreatedAt", "(J)V", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionReaction implements ExtensionElement {
    public static final String ELEMENT = "reaction";
    public static final String NAMESPACE = "reaction:n";
    public static final String TAG_CREATED_AT = "ca";
    public static final String TAG_ENTITY_ID = "mi";
    public static final String TAG_ID = "i";
    public static final String TAG_MSG_ID_REACTED = "mir";
    public static final String TAG_REACTION_CONTENT = "rc";
    public static final int $stable = 8;
    private String id = "";
    private String messageId = "";
    private String entity = "";
    private String reactionContent = "";
    private long createdAt = new Date().getTime();

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "reaction";
    }

    public final String getEntity() {
        return this.entity;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final String getReactionContent() {
        return this.reactionContent;
    }

    public final void setCreatedAt(long j10) {
        this.createdAt = j10;
    }

    public final void setEntity(String str) {
        y.i(str, "<set-?>");
        this.entity = str;
    }

    public final void setId(String str) {
        y.i(str, "<set-?>");
        this.id = str;
    }

    public final void setMessageId(String str) {
        y.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void setReactionContent(String str) {
        y.i(str, "<set-?>");
        this.reactionContent = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("i", this.id);
        xmlStringBuilder.attribute("mi", this.messageId);
        xmlStringBuilder.attribute(TAG_MSG_ID_REACTED, this.entity);
        xmlStringBuilder.attribute(TAG_REACTION_CONTENT, this.reactionContent);
        xmlStringBuilder.attribute("ca", String.valueOf(this.createdAt));
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
