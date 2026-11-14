package cu.todus.android.xmpp;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lcu/todus/android/xmpp/ConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING_FOR_CONNECTION", "CONNECTING", "BEFORE_CONNECTED", "AUTHENTICATED", "CONNECTED", "DISCONNECTED", "RECONNECTING", "isConnected", "", "()Z", "isDisconnected", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum ConnectionState {
    WAITING_FOR_CONNECTION,
    CONNECTING,
    BEFORE_CONNECTED,
    AUTHENTICATED,
    CONNECTED,
    DISCONNECTED,
    RECONNECTING;

    private static final /* synthetic */ db.a $ENTRIES = db.b.a(values());

    public static db.a getEntries() {
        return $ENTRIES;
    }

    public final boolean isConnected() {
        return this == CONNECTED;
    }

    public final boolean isDisconnected() {
        return this == DISCONNECTED;
    }
}
