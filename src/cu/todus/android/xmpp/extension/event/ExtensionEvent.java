package cu.todus.android.xmpp.extension.event;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006("}, d2 = {"Lcu/todus/android/xmpp/extension/event/ExtensionEvent;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "messageId", "getMessageId", "setMessageId", "title", "getTitle", "setTitle", ExtensionEvent.TAG_ICS, "getIcs", "setIcs", TtmlNode.START, "", "getStart", "()J", "setStart", "(J)V", TtmlNode.END, "getEnd", "setEnd", "allDay", "", "getAllDay", "()Z", "setAllDay", "(Z)V", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionEvent implements ExtensionElement {
    public static final String ELEMENT = "event";
    public static final String NAMESPACE = "event:n";
    public static final String TAG_ALL_DAY = "ad";
    public static final String TAG_END = "e";
    public static final String TAG_ICS = "ics";
    public static final String TAG_ID = "i";
    public static final String TAG_MESSAGE_ID = "mi";
    public static final String TAG_START = "s";
    public static final String TAG_TITLE = "ti";
    private boolean allDay;
    private long end;
    private long start;
    public static final int $stable = 8;
    private String id = "";
    private String messageId = "";
    private String title = "";
    private String ics = "";

    public final boolean getAllDay() {
        return this.allDay;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "event";
    }

    public final long getEnd() {
        return this.end;
    }

    public final String getIcs() {
        return this.ics;
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

    public final long getStart() {
        return this.start;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAllDay(boolean z10) {
        this.allDay = z10;
    }

    public final void setEnd(long j10) {
        this.end = j10;
    }

    public final void setIcs(String str) {
        y.i(str, "<set-?>");
        this.ics = str;
    }

    public final void setId(String str) {
        y.i(str, "<set-?>");
        this.id = str;
    }

    public final void setMessageId(String str) {
        y.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void setStart(long j10) {
        this.start = j10;
    }

    public final void setTitle(String str) {
        y.i(str, "<set-?>");
        this.title = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("i", this.id);
        xmlStringBuilder.attribute("mi", this.messageId);
        xmlStringBuilder.attribute(TAG_TITLE, this.title);
        xmlStringBuilder.attribute("s", String.valueOf(this.start));
        xmlStringBuilder.attribute(TAG_END, String.valueOf(this.end));
        xmlStringBuilder.attribute(TAG_ALL_DAY, this.allDay);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((CharSequence) ("<ics>" + this.ics + "</ics>"));
        xmlStringBuilder.closeElement(this);
        String string = xmlStringBuilder.toString();
        y.h(string, "toString(...)");
        return string;
    }
}
