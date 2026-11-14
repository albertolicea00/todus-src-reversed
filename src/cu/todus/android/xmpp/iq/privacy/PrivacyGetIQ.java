package cu.todus.android.xmpp.iq.privacy;

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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/privacy/PrivacyGetIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "info", "", PrivacyGetIQ.PRIVACY_PROFILE_LAST, "profilePhoto", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "getLast", "getProfilePhoto", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PrivacyGetIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:privacy";
    public static final String PRIVACY_ALL = "all";
    public static final String PRIVACY_CONTACTS = "contacts";
    public static final String PRIVACY_EXCEPTIONS = "exceptions";
    public static final String PRIVACY_NONE = "none";
    public static final String PRIVACY_PROFILE_INFO = "info";
    public static final String PRIVACY_PROFILE_LAST = "last";
    public static final String PRIVACY_PROFILE_PHOTO = "profile_photo";
    public static final String PRIVACY_WHO_CAN = "who_can";
    private final String info;
    private final String last;
    private final String profilePhoto;
    public static final int $stable = 8;

    public PrivacyGetIQ() {
        this(null, null, null, 7, null);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getLast() {
        return this.last;
    }

    public final String getProfilePhoto() {
        return this.profilePhoto;
    }

    public /* synthetic */ PrivacyGetIQ(String str, String str2, String str3, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyGetIQ(String info, String last, String profilePhoto) {
        super("query", "todus:privacy");
        y.i(info, "info");
        y.i(last, "last");
        y.i(profilePhoto, "profilePhoto");
        this.info = info;
        this.last = last;
        this.profilePhoto = profilePhoto;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
