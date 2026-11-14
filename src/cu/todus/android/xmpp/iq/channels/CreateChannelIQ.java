package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.tracing.Trace;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Room;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.a0;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/CreateChannelIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "name", "", "link", EditPubChannelIQ.PUB, "", CreateChannelIQ.SUBS, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "desc", "chId", Room.CONFIG_PICTURE, "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getLink", "getPub", "()I", "getSubs", "()Ljava/util/ArrayList;", "getDesc", "getChId", "getPicture", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CreateChannelIQ extends IQ {
    public static final String DESC = "desc";
    public static final String DESCRIPTION = "desc";
    public static final String ELEMENT = "query";
    public static final String ID = "id";
    public static final String LAST_ID = "last_id";
    public static final String LIMIT = "limit";
    public static final String LINK = "link";
    public static final String NAME = "name";
    public static final String NAMESPACE = "todus:ch:create";
    public static final String OFFSET = "offset";
    public static final String PROFILE_PHOTO = "profile_photo";
    public static final String PROFILE_PHOTO_THUMB = "profile_photo_thumb";
    public static final String PUBL = "publ";
    public static final String PUBLIC = "public";
    public static final String PUBL_ID = "publ_id";
    public static final String RIGHTS = "rights";
    public static final String SUB = "sub";
    public static final String SUBS = "subs";
    private final String chId;
    private final String desc;
    private final String link;
    private final String name;
    private final String picture;
    private final int pub;
    private final ArrayList<String> subs;
    public static final int $stable = 8;

    public CreateChannelIQ() {
        this(null, null, 0, null, null, null, null, Trace.MAX_TRACE_LABEL_LENGTH, null);
    }

    public final String getChId() {
        return this.chId;
    }

    public final String getDesc() {
        return this.desc;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("name", this.name);
        xml.attribute("profile_photo", this.picture);
        xml.attribute("link", a0.O(this.link, "-", "", false, 4, null));
        xml.attribute("public", this.pub);
        xml.attribute(SUBS, g0.G0(this.subs, ",", null, null, 0, null, null, 62, null));
        xml.attribute("desc", this.desc);
        xml.rightAngleBracket();
        return xml;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final int getPub() {
        return this.pub;
    }

    public final ArrayList<String> getSubs() {
        return this.subs;
    }

    public /* synthetic */ CreateChannelIQ(String str, String str2, int i10, ArrayList arrayList, String str3, String str4, String str5, int i11, p pVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? 1 : i10, (i11 & 8) != 0 ? new ArrayList() : arrayList, (i11 & 16) != 0 ? "" : str3, (i11 & 32) != 0 ? "" : str4, (i11 & 64) != 0 ? "" : str5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateChannelIQ(String name, String link, int i10, ArrayList<String> subs, String desc, String chId, String picture) {
        super("query", NAMESPACE);
        y.i(name, "name");
        y.i(link, "link");
        y.i(subs, "subs");
        y.i(desc, "desc");
        y.i(chId, "chId");
        y.i(picture, "picture");
        this.name = name;
        this.link = link;
        this.pub = i10;
        this.subs = subs;
        this.desc = desc;
        this.chId = chId;
        this.picture = picture;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_NAME_CHANNELS));
    }
}
