package cu.todus.android.xmpp.iq.version;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"Lcu/todus/android/xmpp/iq/version/GetUpdateInfoIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "packageName", "", "versionCode", "", "versionName", "minRequiredVersionCode", "downloadUrl", "publishedAt", "<init>", "(Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getVersionCode", "()J", "getVersionName", "getMinRequiredVersionCode", "getDownloadUrl", "getPublishedAt", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetUpdateInfoIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:version:getupdateinfo";
    private final String downloadUrl;
    private final long minRequiredVersionCode;
    private final String packageName;
    private final String publishedAt;
    private final long versionCode;
    private final String versionName;
    public static final int $stable = 8;

    public GetUpdateInfoIQ() {
        this(null, 0L, null, 0L, null, null, 63, null);
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public final long getMinRequiredVersionCode() {
        return this.minRequiredVersionCode;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPublishedAt() {
        return this.publishedAt;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public /* synthetic */ GetUpdateInfoIQ(String str, long j10, String str2, long j11, String str3, String str4, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? -1L : j10, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? -1L : j11, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? "" : str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUpdateInfoIQ(String packageName, long j10, String versionName, long j11, String downloadUrl, String publishedAt) {
        super("query", NAMESPACE);
        y.i(packageName, "packageName");
        y.i(versionName, "versionName");
        y.i(downloadUrl, "downloadUrl");
        y.i(publishedAt, "publishedAt");
        this.packageName = packageName;
        this.versionCode = j10;
        this.versionName = versionName;
        this.minRequiredVersionCode = j11;
        this.downloadUrl = downloadUrl;
        this.publishedAt = publishedAt;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
