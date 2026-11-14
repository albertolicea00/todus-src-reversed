package cu.todus.android.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.utils.HashUtils;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Pair;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcu/todus/android/xmpp/ToDusXMPPFactoryConfiguration;", "", "<init>", "()V", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ToDusXMPPFactoryConfiguration {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcu/todus/android/xmpp/ToDusXMPPFactoryConfiguration$Companion;", "", "<init>", "()V", "create", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnectionConfiguration;", "username", "", "host", "port", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private static final SmackDebugger create$lambda$0$0(XMPPConnection xMPPConnection) {
            return new ToDusXmppDebugger(xMPPConnection);
        }

        public final XMPPTCPConnectionConfiguration create(String username, String host, int port) throws XmppStringprepException {
            SSLSocketFactory first;
            X509TrustManager second;
            kotlin.jvm.internal.y.i(username, "username");
            kotlin.jvm.internal.y.i(host, "host");
            XMPPTCPConnectionConfiguration.Builder builder = XMPPTCPConnectionConfiguration.builder();
            Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = RetrofitModule.INSTANCE.allowAllCertificated();
            builder.setResource(HashUtils.INSTANCE.md5(username) + "_Android");
            builder.setXmppDomain(JidCreate.from(Service.Config.SERVER_DOMAIN).asDomainBareJid());
            builder.setHost(host);
            builder.setCompressionEnabled(true);
            builder.setPort(port);
            builder.setSendPresence(true);
            builder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
            if (pairAllowAllCertificated == null || (first = pairAllowAllCertificated.getFirst()) == null) {
                first = SSLSocketFactory.getDefault();
            }
            builder.setSocketFactory(first);
            if (pairAllowAllCertificated != null && (second = pairAllowAllCertificated.getSecond()) != null) {
                builder.setCustomX509TrustManager(second);
            }
            XMPPTCPConnectionConfiguration xMPPTCPConnectionConfigurationBuild = builder.build();
            kotlin.jvm.internal.y.h(xMPPTCPConnectionConfigurationBuild, "build(...)");
            return xMPPTCPConnectionConfigurationBuild;
        }

        private Companion() {
        }
    }
}
