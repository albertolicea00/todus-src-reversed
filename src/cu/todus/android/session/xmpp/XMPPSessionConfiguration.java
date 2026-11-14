package cu.todus.android.session.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.session.store.SessionsConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u000e\u0010\u0012J\b\u0010!\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcu/todus/android/session/xmpp/XMPPSessionConfiguration;", "Lcu/todus/android/session/store/SessionsConfiguration;", "debugMode", "", "xmppDomain", "", "xmppHost", "xmppPort", "", "replyTimeOut", "", "sendPresence", "credentials", "Lcu/todus/android/session/xmpp/XMPPCredentials;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;IJZLcu/todus/android/session/xmpp/XMPPCredentials;)V", "builder", "Lcu/todus/android/session/xmpp/XMPPSessionConfiguration$Builder;", "(Lcu/todus/android/session/xmpp/XMPPSessionConfiguration$Builder;)V", "getDebugMode", "()Z", "getXmppDomain", "()Ljava/lang/String;", "getXmppHost", "getXmppPort", "()I", "getReplyTimeOut", "()J", "getSendPresence", "getCredentials", "()Lcu/todus/android/session/xmpp/XMPPCredentials;", "setCredentials", "(Lcu/todus/android/session/xmpp/XMPPCredentials;)V", "getId", "Builder", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class XMPPSessionConfiguration extends SessionsConfiguration {
    public static final int $stable = 8;
    private XMPPCredentials credentials;
    private final boolean debugMode;
    private final long replyTimeOut;
    private final boolean sendPresence;
    private final String xmppDomain;
    private final String xmppHost;
    private final int xmppPort;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\"\u001a\u00020#R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcu/todus/android/session/xmpp/XMPPSessionConfiguration$Builder;", "", "<init>", "()V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "debugMode", "getDebugMode", "()Z", "", "xmppDomain", "getXmppDomain", "()Ljava/lang/String;", "xmppHost", "getXmppHost", "", "xmppPort", "getXmppPort", "()I", "", "replyTimeOut", "getReplyTimeOut", "()J", "sendPresence", "getSendPresence", "credentials", "Lcu/todus/android/session/xmpp/XMPPCredentials;", "getCredentials", "()Lcu/todus/android/session/xmpp/XMPPCredentials;", "setCredentials", "(Lcu/todus/android/session/xmpp/XMPPCredentials;)V", "domain", "host", "port", "build", "Lcu/todus/android/session/xmpp/XMPPSessionConfiguration;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        public XMPPCredentials credentials;
        private boolean debugMode;
        private boolean sendPresence;
        private String xmppDomain;
        private String xmppHost;
        private int xmppPort = 5222;
        private long replyTimeOut = 300;

        public final XMPPSessionConfiguration build() {
            return new XMPPSessionConfiguration(this, null);
        }

        public final Builder credentials(XMPPCredentials credentials) {
            y.i(credentials, "credentials");
            setCredentials(credentials);
            return this;
        }

        public final Builder debugMode(boolean value) {
            this.debugMode = value;
            return this;
        }

        public final Builder domain(String value) {
            y.i(value, "value");
            this.xmppDomain = value;
            return this;
        }

        public final XMPPCredentials getCredentials() {
            XMPPCredentials xMPPCredentials = this.credentials;
            if (xMPPCredentials != null) {
                return xMPPCredentials;
            }
            y.w("credentials");
            return null;
        }

        public final boolean getDebugMode() {
            return this.debugMode;
        }

        public final long getReplyTimeOut() {
            return this.replyTimeOut;
        }

        public final boolean getSendPresence() {
            return this.sendPresence;
        }

        public final String getXmppDomain() {
            String str = this.xmppDomain;
            if (str != null) {
                return str;
            }
            y.w("xmppDomain");
            return null;
        }

        public final String getXmppHost() {
            String str = this.xmppHost;
            if (str != null) {
                return str;
            }
            y.w("xmppHost");
            return null;
        }

        public final int getXmppPort() {
            return this.xmppPort;
        }

        public final Builder host(String value) {
            y.i(value, "value");
            this.xmppHost = value;
            return this;
        }

        public final Builder port(int value) {
            this.xmppPort = value;
            return this;
        }

        public final Builder replyTimeOut(long value) {
            this.replyTimeOut = value;
            return this;
        }

        public final Builder sendPresence(boolean value) {
            this.sendPresence = value;
            return this;
        }

        public final void setCredentials(XMPPCredentials xMPPCredentials) {
            y.i(xMPPCredentials, "<set-?>");
            this.credentials = xMPPCredentials;
        }
    }

    public /* synthetic */ XMPPSessionConfiguration(Builder builder, p pVar) {
        this(builder);
    }

    public final XMPPCredentials getCredentials() {
        return this.credentials;
    }

    public final boolean getDebugMode() {
        return this.debugMode;
    }

    @Override // cu.todus.android.session.store.SessionsConfiguration
    public String getId() {
        return this.credentials.getUsername();
    }

    public final long getReplyTimeOut() {
        return this.replyTimeOut;
    }

    public final boolean getSendPresence() {
        return this.sendPresence;
    }

    public final String getXmppDomain() {
        return this.xmppDomain;
    }

    public final String getXmppHost() {
        return this.xmppHost;
    }

    public final int getXmppPort() {
        return this.xmppPort;
    }

    public final void setCredentials(XMPPCredentials xMPPCredentials) {
        y.i(xMPPCredentials, "<set-?>");
        this.credentials = xMPPCredentials;
    }

    public XMPPSessionConfiguration(boolean z10, String xmppDomain, String xmppHost, int i10, long j10, boolean z11, XMPPCredentials credentials) {
        y.i(xmppDomain, "xmppDomain");
        y.i(xmppHost, "xmppHost");
        y.i(credentials, "credentials");
        this.debugMode = z10;
        this.xmppDomain = xmppDomain;
        this.xmppHost = xmppHost;
        this.xmppPort = i10;
        this.replyTimeOut = j10;
        this.sendPresence = z11;
        this.credentials = credentials;
    }

    private XMPPSessionConfiguration(Builder builder) {
        this(builder.getDebugMode(), builder.getXmppDomain(), builder.getXmppHost(), builder.getXmppPort(), builder.getReplyTimeOut(), builder.getSendPresence(), builder.getCredentials());
    }
}
