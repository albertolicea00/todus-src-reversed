package cu.todus.android.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.debugger.AbstractDebugger;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\t\u0010\r¨\u0006\u000f"}, d2 = {"Lcu/todus/android/xmpp/ToDusXmppDebugger;", "Lorg/jivesoftware/smack/debugger/AbstractDebugger;", "Lorg/jivesoftware/smack/XMPPConnection;", "connection", "<init>", "(Lorg/jivesoftware/smack/XMPPConnection;)V", "", "logMessage", "Lua/k0;", "log", "(Ljava/lang/String;)V", "", "throwable", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ToDusXmppDebugger extends AbstractDebugger {
    public static final String LOG = "SMACK";
    public static final int $stable = 8;

    public ToDusXmppDebugger(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    public void log(String logMessage) {
        kotlin.jvm.internal.y.i(logMessage, "logMessage");
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    public void log(String logMessage, Throwable throwable) {
        kotlin.jvm.internal.y.i(logMessage, "logMessage");
        kotlin.jvm.internal.y.i(throwable, "throwable");
    }
}
