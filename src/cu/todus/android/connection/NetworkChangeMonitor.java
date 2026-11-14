package cu.todus.android.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.util.Log;
import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import db.a;
import db.b;
import defpackage.l;
import j$.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.k;
import pe.m0;
import pe.n0;
import pe.w2;
import te.a0;
import te.f0;
import te.h0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 )2\u00020\u0001:\u0005*+,-)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcu/todus/android/connection/NetworkChangeMonitor;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/net/Network;", "network", "Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;", "getNetworkType", "(Landroid/net/Network;)Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;", "Lua/k0;", "startMonitoring", "()V", "stopMonitoring", "getCurrentNetworkType", "()Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;", "Landroid/content/Context;", "Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/net/ConnectivityManager;", "Lpe/m0;", "monitorScope", "Lpe/m0;", "Lte/a0;", "Lcu/todus/android/connection/NetworkChangeMonitor$NetworkChangeEvent;", "_networkChangeFlow", "Lte/a0;", "Lte/f0;", "networkChangeFlow", "Lte/f0;", "getNetworkChangeFlow", "()Lte/f0;", "currentNetwork", "Landroid/net/Network;", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "", "isMonitoring", "Z", "Companion", "NetworkChangeEvent", "NetworkType", "ConnectionType", "NetworkCallbackImpl", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NetworkChangeMonitor {
    private static final String TAG = "NetworkChangeMonitor";
    private final a0 _networkChangeFlow;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private Network currentNetwork;
    private boolean isMonitoring;
    private final m0 monitorScope;
    private ConnectivityManager.NetworkCallback networkCallback;
    private final f0 networkChangeFlow;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/connection/NetworkChangeMonitor$ConnectionType;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTED", "CHANGED", "DISCONNECTED", "RECONNECTED", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum ConnectionType {
        CONNECTED,
        CHANGED,
        DISCONNECTED,
        RECONNECTED;

        private static final /* synthetic */ a $ENTRIES = b.a(values());

        public static a getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcu/todus/android/connection/NetworkChangeMonitor$NetworkCallbackImpl;", "Landroid/net/ConnectivityManager$NetworkCallback;", "<init>", "(Lcu/todus/android/connection/NetworkChangeMonitor;)V", "Landroid/net/Network;", "network", "Lua/k0;", "onAvailable", "(Landroid/net/Network;)V", "onLost", "Landroid/net/NetworkCapabilities;", "caps", "onCapabilitiesChanged", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        public NetworkCallbackImpl() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            ConnectionType connectionType;
            y.i(network, "network");
            Objects.toString(network);
            NetworkType networkType = NetworkChangeMonitor.this.getNetworkType(network);
            Network network2 = NetworkChangeMonitor.this.currentNetwork;
            NetworkType networkType2 = network2 != null ? NetworkChangeMonitor.this.getNetworkType(network2) : null;
            if (NetworkChangeMonitor.this.currentNetwork == null) {
                connectionType = ConnectionType.CONNECTED;
            } else {
                connectionType = networkType2 != networkType ? ConnectionType.CHANGED : ConnectionType.RECONNECTED;
            }
            NetworkChangeMonitor.this.currentNetwork = network;
            k.d(NetworkChangeMonitor.this.monitorScope, null, null, new NetworkChangeMonitor$NetworkCallbackImpl$onAvailable$1(networkType, connectionType, NetworkChangeMonitor.this, null), 3, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities caps) {
            y.i(network, "network");
            y.i(caps, "caps");
            Objects.toString(network);
            super.onCapabilitiesChanged(network, caps);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            y.i(network, "network");
            Objects.toString(network);
            if (y.d(NetworkChangeMonitor.this.currentNetwork, network)) {
                NetworkChangeMonitor.this.currentNetwork = null;
            }
            k.d(NetworkChangeMonitor.this.monitorScope, null, null, new NetworkChangeMonitor$NetworkCallbackImpl$onLost$1(NetworkChangeMonitor.this, null), 3, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;", "", "<init>", "(Ljava/lang/String;I)V", "WiFi", "MOBILE", "UNKNOWN", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum NetworkType {
        WiFi,
        MOBILE,
        UNKNOWN;

        private static final /* synthetic */ a $ENTRIES = b.a(values());

        public static a getEntries() {
            return $ENTRIES;
        }
    }

    public NetworkChangeMonitor(Context context) {
        y.i(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("connectivity");
        y.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
        this.monitorScope = n0.a(w2.b(null, 1, null).plus(d1.b()));
        a0 a0VarB = h0.b(0, 0, null, 7, null);
        this._networkChangeFlow = a0VarB;
        this.networkChangeFlow = a0VarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NetworkType getNetworkType(Network network) {
        try {
            NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return NetworkType.UNKNOWN;
            }
            if (networkCapabilities.hasTransport(1)) {
                return NetworkType.WiFi;
            }
            return networkCapabilities.hasTransport(0) ? NetworkType.MOBILE : NetworkType.UNKNOWN;
        } catch (Exception e10) {
            Log.e(TAG, "[getNetworkType] Error: " + e10.getMessage());
            return NetworkType.UNKNOWN;
        }
    }

    public final NetworkType getCurrentNetworkType() {
        NetworkType networkType;
        Network network = this.currentNetwork;
        return (network == null || (networkType = getNetworkType(network)) == null) ? NetworkType.UNKNOWN : networkType;
    }

    public final f0 getNetworkChangeFlow() {
        return this.networkChangeFlow;
    }

    public final void startMonitoring() {
        if (this.isMonitoring) {
            Log.w(TAG, "[startMonitoring] Ya está siendo monitoreado");
            return;
        }
        this.networkCallback = new NetworkCallbackImpl();
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
        ConnectivityManager connectivityManager = this.connectivityManager;
        ConnectivityManager.NetworkCallback networkCallback = this.networkCallback;
        y.f(networkCallback);
        connectivityManager.registerNetworkCallback(networkRequestBuild, networkCallback);
        this.isMonitoring = true;
    }

    public final void stopMonitoring() {
        ConnectivityManager.NetworkCallback networkCallback;
        if (!this.isMonitoring || (networkCallback = this.networkCallback) == null) {
            Log.w(TAG, "[stopMonitoring] No hay callback para desregistrar");
            return;
        }
        try {
            ConnectivityManager connectivityManager = this.connectivityManager;
            y.f(networkCallback);
            connectivityManager.unregisterNetworkCallback(networkCallback);
            this.isMonitoring = false;
            this.networkCallback = null;
        } catch (Exception e10) {
            Log.e(TAG, "[stopMonitoring] Error: " + e10.getMessage());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcu/todus/android/connection/NetworkChangeMonitor$NetworkChangeEvent;", "", "type", "Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;", "isAvailable", "", "connectionType", "Lcu/todus/android/connection/NetworkChangeMonitor$ConnectionType;", "timestamp", "", "<init>", "(Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;ZLcu/todus/android/connection/NetworkChangeMonitor$ConnectionType;J)V", "getType", "()Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;", "()Z", "getConnectionType", "()Lcu/todus/android/connection/NetworkChangeMonitor$ConnectionType;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class NetworkChangeEvent {
        public static final int $stable = 0;
        private final ConnectionType connectionType;
        private final boolean isAvailable;
        private final long timestamp;
        private final NetworkType type;

        public NetworkChangeEvent(NetworkType type, boolean z10, ConnectionType connectionType, long j10) {
            y.i(type, "type");
            y.i(connectionType, "connectionType");
            this.type = type;
            this.isAvailable = z10;
            this.connectionType = connectionType;
            this.timestamp = j10;
        }

        public static /* synthetic */ NetworkChangeEvent copy$default(NetworkChangeEvent networkChangeEvent, NetworkType networkType, boolean z10, ConnectionType connectionType, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                networkType = networkChangeEvent.type;
            }
            if ((i10 & 2) != 0) {
                z10 = networkChangeEvent.isAvailable;
            }
            if ((i10 & 4) != 0) {
                connectionType = networkChangeEvent.connectionType;
            }
            if ((i10 & 8) != 0) {
                j10 = networkChangeEvent.timestamp;
            }
            ConnectionType connectionType2 = connectionType;
            return networkChangeEvent.copy(networkType, z10, connectionType2, j10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final NetworkType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsAvailable() {
            return this.isAvailable;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ConnectionType getConnectionType() {
            return this.connectionType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final NetworkChangeEvent copy(NetworkType type, boolean isAvailable, ConnectionType connectionType, long timestamp) {
            y.i(type, "type");
            y.i(connectionType, "connectionType");
            return new NetworkChangeEvent(type, isAvailable, connectionType, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkChangeEvent)) {
                return false;
            }
            NetworkChangeEvent networkChangeEvent = (NetworkChangeEvent) other;
            return this.type == networkChangeEvent.type && this.isAvailable == networkChangeEvent.isAvailable && this.connectionType == networkChangeEvent.connectionType && this.timestamp == networkChangeEvent.timestamp;
        }

        public final ConnectionType getConnectionType() {
            return this.connectionType;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final NetworkType getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((this.type.hashCode() * 31) + r.a(this.isAvailable)) * 31) + this.connectionType.hashCode()) * 31) + l.a(this.timestamp);
        }

        public final boolean isAvailable() {
            return this.isAvailable;
        }

        public String toString() {
            return "NetworkChangeEvent(type=" + this.type + ", isAvailable=" + this.isAvailable + ", connectionType=" + this.connectionType + ", timestamp=" + this.timestamp + ")";
        }

        public /* synthetic */ NetworkChangeEvent(NetworkType networkType, boolean z10, ConnectionType connectionType, long j10, int i10, p pVar) {
            this(networkType, z10, connectionType, (i10 & 8) != 0 ? System.currentTimeMillis() : j10);
        }
    }
}
