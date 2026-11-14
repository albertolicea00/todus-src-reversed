package cu.todus.android.connection;

import ab.e;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.exoplayer.Renderer;
import bb.b;
import cb.f;
import cb.m;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.z17.singledi.SingletonInitializer;
import j$.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import te.b0;
import te.j;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@RequiresApi(23)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u000bJ\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/¨\u00064"}, d2 = {"Lcu/todus/android/connection/ConnectionManager;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lua/k0;", "autoUpdateStatus", "()V", "Lcu/todus/android/connection/ConnectionStatus;", "getConnectionStatus", "()Lcu/todus/android/connection/ConnectionStatus;", "", "kbs", "Lcu/todus/android/connection/SpeedResult;", "mapperKBToSpeedResult", "(I)Lcu/todus/android/connection/SpeedResult;", "getStatus", "updateStatus", "Landroid/content/Context;", "Landroid/net/ConnectivityManager;", "cm", "Landroid/net/ConnectivityManager;", "Landroid/net/NetworkCapabilities;", "nc", "Landroid/net/NetworkCapabilities;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "getCoroutineScope", "()Lpe/m0;", "_status", "Lcu/todus/android/connection/ConnectionStatus;", "Lte/b0;", "_mutableStatus", "Lte/b0;", "Lte/p0;", "mutableStatus", "Lte/p0;", "getMutableStatus", "()Lte/p0;", "", "autoUpdate", "Z", "getAutoUpdate", "()Z", "setAutoUpdate", "(Z)V", "logActive", "getLogActive", "setLogActive", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConnectionManager {
    private final b0 _mutableStatus;
    private ConnectionStatus _status;
    private boolean autoUpdate;
    private final ConnectivityManager cm;
    private final Context context;
    private final m0 coroutineScope;
    private boolean logActive;
    private final p0 mutableStatus;
    private final NetworkCapabilities nc;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/connection/ConnectionManager$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/connection/ConnectionManager;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<ConnectionManager> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.connection.ConnectionManager$autoUpdateStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.connection.ConnectionManager$autoUpdateStatus$1", f = "ConnectionManager.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        int label;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return ConnectionManager.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            if (ConnectionManager.this.getAutoUpdate()) {
                ConnectionManager.this.updateStatus();
            }
            return k0.f43947a;
        }
    }

    public ConnectionManager(Context context) {
        y.i(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("connectivity");
        y.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        this.cm = connectivityManager;
        this.nc = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        b0 b0VarA = r0.a(null);
        this._mutableStatus = b0VarA;
        this.mutableStatus = j.b(b0VarA);
        autoUpdateStatus();
    }

    private final void autoUpdateStatus() {
        CoroutineUtilsKt.launchPeriodic$default(this.coroutineScope, null, Renderer.DEFAULT_DURATION_TO_PROGRESS_US, new AnonymousClass1(null), 1, null);
    }

    private final ConnectionStatus getConnectionStatus() {
        NetworkCapabilities networkCapabilities = this.nc;
        Integer numValueOf = networkCapabilities != null ? Integer.valueOf(networkCapabilities.getLinkDownstreamBandwidthKbps()) : null;
        NetworkCapabilities networkCapabilities2 = this.nc;
        Integer numValueOf2 = networkCapabilities2 != null ? Integer.valueOf(networkCapabilities2.getLinkUpstreamBandwidthKbps()) : null;
        if (numValueOf == null || numValueOf2 == null) {
            return null;
        }
        return new ConnectionStatus(mapperKBToSpeedResult(numValueOf.intValue()), mapperKBToSpeedResult(numValueOf2.intValue()));
    }

    private final SpeedResult mapperKBToSpeedResult(int kbs) {
        if (kbs >= 0 && kbs < 16) {
            return SpeedResult.S_2G_GSM;
        }
        if (16 <= kbs && kbs < 28) {
            return SpeedResult.S_G_GPRS;
        }
        if (28 <= kbs && kbs < 110) {
            return SpeedResult.S_E_EDGE;
        }
        if (110 <= kbs && kbs < 129) {
            return SpeedResult.S_3G_UMTS;
        }
        if (129 <= kbs && kbs < 3687) {
            return SpeedResult.S_H_HSPA;
        }
        if (3788 <= kbs && kbs < 23553) {
            return SpeedResult.S_HPLUS_HSPAPLUS;
        }
        if (24576 > kbs || kbs >= 51201) {
            return (52224 > kbs || kbs >= 512001) ? SpeedResult.S_5G : SpeedResult.S_4G_LTEA;
        }
        return SpeedResult.S_4G_LTE;
    }

    public final boolean getAutoUpdate() {
        return this.autoUpdate;
    }

    public final m0 getCoroutineScope() {
        return this.coroutineScope;
    }

    public final boolean getLogActive() {
        return this.logActive;
    }

    public final p0 getMutableStatus() {
        return this.mutableStatus;
    }

    /* JADX INFO: renamed from: getStatus, reason: from getter */
    public final ConnectionStatus get_status() {
        return this._status;
    }

    public final void setAutoUpdate(boolean z10) {
        this.autoUpdate = z10;
    }

    public final void setLogActive(boolean z10) {
        this.logActive = z10;
    }

    public final void updateStatus() {
        this._status = getConnectionStatus();
        this._mutableStatus.setValue(get_status());
        if (this.logActive) {
            ConnectionStatus connectionStatus = get_status();
            SpeedResult download = connectionStatus != null ? connectionStatus.getDownload() : null;
            ConnectionStatus connectionStatus2 = get_status();
            SpeedResult download2 = connectionStatus2 != null ? connectionStatus2.getDownload() : null;
            Objects.toString(download);
            Objects.toString(download2);
        }
    }
}
