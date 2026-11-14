package cu.todus.android.xmpp;

import android.util.Log;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.xmpp.extension.event.ExtensionEvent;
import j$.util.Objects;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"cu/todus/android/xmpp/XMPPDataSource$connectionListener$1", "Lorg/jivesoftware/smack/ConnectionListener;", "Lorg/jivesoftware/smack/XMPPConnection;", "connection", "Lua/k0;", "connected", "(Lorg/jivesoftware/smack/XMPPConnection;)V", "connectionClosed", "()V", "Ljava/lang/Exception;", "Lkotlin/Exception;", ExtensionEvent.TAG_END, "connectionClosedOnError", "(Ljava/lang/Exception;)V", "", "resumed", "authenticated", "(Lorg/jivesoftware/smack/XMPPConnection;Z)V", "", "TAG", "Ljava/lang/String;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class XMPPDataSource$connectionListener$1 implements ConnectionListener {
    private final String TAG = "XMPPConnectionListener";
    final /* synthetic */ XMPPDataSource this$0;

    public XMPPDataSource$connectionListener$1(XMPPDataSource xMPPDataSource) {
        this.this$0 = xMPPDataSource;
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void authenticated(XMPPConnection connection, boolean resumed) {
        if (connection != null) {
            connection.isSecureConnection();
        }
        Objects.toString(connection != null ? connection.getUser() : null);
        this.this$0.hasTryingFirst = true;
        this.this$0.setConnectionState(ConnectionState.AUTHENTICATED);
        CoroutineUtilsKt.launchWithContext$default(this.this$0.coroutineScope, null, null, new XMPPDataSource$connectionListener$1$authenticated$1(this.this$0, this, null), 3, null);
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connected(XMPPConnection connection) {
        if (connection != null) {
            connection.getHost();
        }
        if (connection != null) {
            connection.isAuthenticated();
        }
        this.this$0.hasTryingFirst = true;
        this.this$0.setConnectionState(ConnectionState.BEFORE_CONNECTED);
        CoroutineUtilsKt.launchWithContext$default(this.this$0.coroutineScope, null, null, new XMPPDataSource$connectionListener$1$connected$1(connection, this, this.this$0, null), 3, null);
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connectionClosed() {
        this.this$0.hasTryingFirst = true;
        this.this$0.setConnectionState(ConnectionState.DISCONNECTED);
        this.this$0.appVolatileState.clearTyping();
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connectionClosedOnError(Exception e10) {
        Log.e(this.TAG, "🔥 ERROR DE CONEXIÓN: " + (e10 != null ? e10.getMessage() : null), e10);
        if (e10 instanceof SmackException.NotConnectedException) {
            Log.w(this.TAG, "📡 Problema de conectividad de red");
        } else if (e10 instanceof SmackException.NoResponseException) {
            Log.w(this.TAG, "⏰ Timeout - sin respuesta del servidor");
        } else if (e10 instanceof XMPPException) {
            Log.w(this.TAG, "🚫 Error de protocolo XMPP");
        } else if (e10 instanceof SSLException) {
            Log.w(this.TAG, "🔒 Error SSL/TLS");
        } else {
            Log.w(this.TAG, "❓ Error desconocido: " + (e10 != null ? e10.getClass().getSimpleName() : null));
        }
        this.this$0.hasTryingFirst = true;
        this.this$0.setConnectionState(ConnectionState.DISCONNECTED);
        this.this$0.appVolatileState.clearTyping();
    }
}
