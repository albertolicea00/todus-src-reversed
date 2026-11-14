package cu.todus.android.xmpp.extension.statusExistence;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Status;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcu/todus/android/xmpp/extension/statusExistence/ExtensionStatusExistence;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "statusId", "", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "createAt", "", "getCreateAt", "()J", "setCreateAt", "(J)V", Status.COLUMN_IS_DELETED, "", "()I", "setDelete", "(I)V", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionStatusExistence implements ExtensionElement {
    public static final String ELEMENT = "statusexistence";
    public static final String NAMESPACE = "statusexistence:n";
    public static final String TAG_CREATE_AT = "ca";
    public static final String TAG_IS_DELETE = "isdel";
    public static final String TAG_STATUS_ID = "si";
    private long createAt;
    private int isDelete;
    private String statusId = "";
    public static final int $stable = 8;

    public final long getCreateAt() {
        return this.createAt;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    /* JADX INFO: renamed from: isDelete, reason: from getter */
    public final int getIsDelete() {
        return this.isDelete;
    }

    public final void setCreateAt(long j10) {
        this.createAt = j10;
    }

    public final void setDelete(int i10) {
        this.isDelete = i10;
    }

    public final void setStatusId(String str) {
        y.i(str, "<set-?>");
        this.statusId = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(TAG_STATUS_ID, this.statusId);
        xmlStringBuilder.attribute("ca", String.valueOf(this.createAt));
        xmlStringBuilder.attribute(TAG_IS_DELETE, String.valueOf(this.isDelete));
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
