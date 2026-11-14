package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import cu.todus.android.data.xmpp.ChannelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/ChannelInfoIQByLink;", "Lorg/jivesoftware/smack/packet/IQ;", "link", "", "channelInfo", "Lcu/todus/android/data/xmpp/ChannelInfo;", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/xmpp/ChannelInfo;)V", "getLink", "()Ljava/lang/String;", "getChannelInfo", "()Lcu/todus/android/data/xmpp/ChannelInfo;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChannelInfoIQByLink extends IQ {
    public static final String ELEMENT = "query";
    public static final String LINK = "link";
    public static final String NAMESPACE = "todus:ch:info:link:v2";
    private final ChannelInfo channelInfo;
    private final String link;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelInfoIQByLink() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final ChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("link", this.link);
        xml.rightAngleBracket();
        return xml;
    }

    public final String getLink() {
        return this.link;
    }

    public /* synthetic */ ChannelInfoIQByLink(String str, ChannelInfo channelInfo, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : channelInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelInfoIQByLink(String link, ChannelInfo channelInfo) {
        super("query", NAMESPACE);
        y.i(link, "link");
        this.link = link;
        this.channelInfo = channelInfo;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_NAME_CHANNELS));
    }
}
