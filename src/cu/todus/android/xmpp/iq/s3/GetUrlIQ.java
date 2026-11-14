package cu.todus.android.xmpp.iq.s3;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.xmpp.extension.streamVideo.ExtensionStreamVideo;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcu/todus/android/xmpp/iq/s3/GetUrlIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "url", "", ExtensionStreamVideo.TAG_DOWNLOAD_URL, "status", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getDu", "getStatus", "()I", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetUrlIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:gurl";
    private final String du;
    private final int status;
    private final String url;
    public static final int $stable = 8;

    public GetUrlIQ() {
        this(null, null, 0, 7, null);
    }

    public final String getDu() {
        return this.du;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("url", this.url);
        xml.rightAngleBracket();
        return xml;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ GetUrlIQ(String str, String str2, int i10, int i11, p pVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? 200 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUrlIQ(String url, String du, int i10) {
        super("query", NAMESPACE);
        y.i(url, "url");
        y.i(du, "du");
        this.url = url;
        this.du = du;
        this.status = i10;
        setType(IQ.Type.get);
    }
}
