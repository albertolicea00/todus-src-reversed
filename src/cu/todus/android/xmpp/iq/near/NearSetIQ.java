package cu.todus.android.xmpp.iq.near;

import androidx.camera.video.AudioStats;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.xmpp.extension.location.ExtensionLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcu/todus/android/xmpp/iq/near/NearSetIQ;", "Lorg/jivesoftware/smack/packet/IQ;", ExtensionLocation.TAG_LAT, "", ExtensionLocation.TAG_LON, "code", "", "<init>", "(DDLjava/lang/Integer;)V", "getLat", "()D", "getLon", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NearSetIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "tnearp:loc:set";
    private final Integer code;
    private final double lat;
    private final double lon;
    public static final int $stable = 8;

    public NearSetIQ() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, 7, null);
    }

    public final Integer getCode() {
        return this.code;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute(ExtensionLocation.TAG_LAT, String.valueOf(this.lat));
        xml.attribute(ExtensionLocation.TAG_LON, String.valueOf(this.lon));
        xml.rightAngleBracket();
        return xml;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public /* synthetic */ NearSetIQ(double d10, double d11, Integer num, int i10, p pVar) {
        this((i10 & 1) != 0 ? 0.0d : d10, (i10 & 2) != 0 ? 0.0d : d11, (i10 & 4) != 0 ? null : num);
    }

    public NearSetIQ(double d10, double d11, Integer num) {
        super("query", NAMESPACE);
        this.lat = d10;
        this.lon = d11;
        this.code = num;
        setType(IQ.Type.set);
    }
}
