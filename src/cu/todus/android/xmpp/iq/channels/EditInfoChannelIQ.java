package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.tracing.Trace;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/EditInfoChannelIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "name", "", "link", "public", "profilePhoto", "profilePhotoThumb", "subject", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getLink", "getPublic", "getProfilePhoto", "getProfilePhotoThumb", "getSubject", "getId", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EditInfoChannelIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:ch:edit";
    private final String id;
    private final String link;
    private final String name;
    private final String profilePhoto;
    private final String profilePhotoThumb;
    private final String public;
    private final String subject;
    public static final int $stable = 8;

    public EditInfoChannelIQ() {
        this(null, null, null, null, null, null, null, Trace.MAX_TRACE_LABEL_LENGTH, null);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("name", this.name);
        xml.attribute("link", this.link);
        xml.attribute("public", this.public);
        xml.attribute("profile_photo", this.profilePhoto);
        xml.attribute(CreateChannelIQ.PROFILE_PHOTO_THUMB, this.profilePhotoThumb);
        xml.attribute("desc", this.subject);
        xml.rightAngleBracket();
        return xml;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProfilePhoto() {
        return this.profilePhoto;
    }

    public final String getProfilePhotoThumb() {
        return this.profilePhotoThumb;
    }

    public final String getPublic() {
        return this.public;
    }

    public final String getSubject() {
        return this.subject;
    }

    public /* synthetic */ EditInfoChannelIQ(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "1" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? "" : str5, (i10 & 32) != 0 ? "" : str6, (i10 & 64) != 0 ? "" : str7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditInfoChannelIQ(String name, String link, String str, String profilePhoto, String profilePhotoThumb, String subject, String id2) {
        super("query", NAMESPACE);
        y.i(name, "name");
        y.i(link, "link");
        y.i(str, "public");
        y.i(profilePhoto, "profilePhoto");
        y.i(profilePhotoThumb, "profilePhotoThumb");
        y.i(subject, "subject");
        y.i(id2, "id");
        this.name = name;
        this.link = link;
        this.public = str;
        this.profilePhoto = profilePhoto;
        this.profilePhotoThumb = profilePhotoThumb;
        this.subject = subject;
        this.id = id2;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(id2));
    }
}
