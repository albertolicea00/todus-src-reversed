package cu.todus.android.xmpp.iq.s3;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcu/todus/android/xmpp/iq/s3/PutUrlIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "server", "", MarkerAction.COLUMN_ROOM, "fileType", "", Attachment.COLUMN_PERSISTENT, "", "size", "put", "get", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZILjava/lang/String;Ljava/lang/String;I)V", "getRoom", "()Ljava/lang/String;", "getFileType", "()I", "getPersistent", "()Z", "getSize", "getPut", "getGet", "getStatus", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PutUrlIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:purl";
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_FILE = 0;
    public static final int TYPE_PICTURE = 4;
    public static final int TYPE_PROFILE = 5;
    public static final int TYPE_VIDEO = 3;
    public static final int TYPE_VOICE = 1;
    private final int fileType;
    private final String get;
    private final boolean persistent;
    private final String put;
    private final String room;
    private final int size;
    private final int status;
    public static final int $stable = 8;

    public PutUrlIQ() {
        this(null, null, 0, false, 0, null, null, 0, 255, null);
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final String getGet() {
        return this.get;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("type", this.fileType);
        xml.attribute(Attachment.COLUMN_PERSISTENT, this.persistent);
        xml.attribute("size", this.size);
        xml.attribute(MarkerAction.COLUMN_ROOM, this.room);
        xml.rightAngleBracket();
        return xml;
    }

    public final boolean getPersistent() {
        return this.persistent;
    }

    public final String getPut() {
        return this.put;
    }

    public final String getRoom() {
        return this.room;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getStatus() {
        return this.status;
    }

    public /* synthetic */ PutUrlIQ(String str, String str2, int i10, boolean z10, int i11, String str3, String str4, int i12, int i13, p pVar) {
        this((i13 & 1) != 0 ? "" : str, (i13 & 2) != 0 ? "" : str2, (i13 & 4) != 0 ? 0 : i10, (i13 & 8) != 0 ? false : z10, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? "" : str3, (i13 & 64) != 0 ? "" : str4, (i13 & 128) != 0 ? 200 : i12);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PutUrlIQ(String server, String room, int i10, boolean z10, int i11, String put, String get, int i12) {
        super("query", NAMESPACE);
        y.i(server, "server");
        y.i(room, "room");
        y.i(put, "put");
        y.i(get, "get");
        this.room = room;
        this.fileType = i10;
        this.persistent = z10;
        this.size = i11;
        this.put = put;
        this.get = get;
        this.status = i12;
        setType(IQ.Type.get);
    }
}
