package cu.todus.android.xmpp.iq.roster;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import cu.todus.android.utils.Base64Util;
import g0.a;
import h0.b;
import j0.g;
import j0.o;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.impl.JidCreate;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcu/todus/android/xmpp/iq/roster/RosterUpdateIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "code", "", "contacts", "", "Lkotlin/Pair;", "", "<init>", "(ILjava/util/List;)V", "getCode", "()I", "getContacts", "()Ljava/util/List;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterUpdateIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:roster:update";
    private final int code;
    private final List<Pair<String, String>> contacts;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public RosterUpdateIQ() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<Pair<String, String>> getContacts() {
        return this.contacts;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        b bVarC = new a().c();
        List<Pair<String, String>> list = this.contacts;
        ArrayList arrayList = new ArrayList(x.y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            g gVar = new g();
            o oVar = new o("a");
            o oVar2 = new o((String) pair.getSecond());
            o oVar3 = new o(StreamManagement.Resume.ELEMENT);
            o oVar4 = new o((String) pair.getFirst());
            gVar.g(oVar, oVar2);
            gVar.g(oVar3, oVar4);
            arrayList.add(bVarC.b(gVar));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new g0.b(byteArrayOutputStream).c(((a) bVarC.c()).d());
        Base64Util base64Util = Base64Util.INSTANCE;
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        y.h(byteArray, "toByteArray(...)");
        String strEncodedMessage$default = Base64Util.encodedMessage$default(base64Util, byteArray, 0, 2, (Object) null);
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.append((CharSequence) strEncodedMessage$default);
        xml.element(xmlStringBuilder);
        return xml;
    }

    public /* synthetic */ RosterUpdateIQ(int i10, List list, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? w.n() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RosterUpdateIQ(int i10, List<Pair<String, String>> contacts) {
        super("query", NAMESPACE);
        y.i(contacts, "contacts");
        this.code = i10;
        this.contacts = contacts;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
