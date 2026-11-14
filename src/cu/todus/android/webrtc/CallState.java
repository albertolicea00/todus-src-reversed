package cu.todus.android.webrtc;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.xmpp.TurnCredentials;
import cu.todus.android.uiCompose.call.screen.call.CallMediaState;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pb.d;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0011HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003Jw\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0006HÆ\u0001J\u0014\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u0011HÖ\u0081\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0019¨\u00065"}, d2 = {"Lcu/todus/android/webrtc/CallState;", "", "callId", "", "with", "ownerIsCalling", "", "callIsStarted", "peersConnected", "withCallMediaState", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "turnCredentials", "Lcu/todus/android/data/xmpp/TurnCredentials;", "partner", "Lcu/todus/android/data/db/pojo/Partner;", Room.COLUMN_LAST_MSG, "maxToSend", "", "isVideoCall", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZLcu/todus/android/uiCompose/call/screen/call/CallMediaState;Lcu/todus/android/data/xmpp/TurnCredentials;Lcu/todus/android/data/db/pojo/Partner;Ljava/lang/String;IZ)V", "getCallId", "()Ljava/lang/String;", "getWith", "getOwnerIsCalling", "()Z", "getCallIsStarted", "getPeersConnected", "getWithCallMediaState", "()Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "getTurnCredentials", "()Lcu/todus/android/data/xmpp/TurnCredentials;", "getPartner", "()Lcu/todus/android/data/db/pojo/Partner;", "getMsgId", "getMaxToSend", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CallState {
    public static final int $stable = 8;
    private final String callId;
    private final boolean callIsStarted;
    private final boolean isVideoCall;
    private final int maxToSend;
    private final String msgId;
    private final boolean ownerIsCalling;
    private final Partner partner;
    private final boolean peersConnected;
    private final TurnCredentials turnCredentials;
    private final String with;
    private final CallMediaState withCallMediaState;

    public CallState(String callId, String with, boolean z10, boolean z11, boolean z12, CallMediaState withCallMediaState, TurnCredentials turnCredentials, Partner partner, String msgId, int i10, boolean z13) {
        y.i(callId, "callId");
        y.i(with, "with");
        y.i(withCallMediaState, "withCallMediaState");
        y.i(turnCredentials, "turnCredentials");
        y.i(partner, "partner");
        y.i(msgId, "msgId");
        this.callId = callId;
        this.with = with;
        this.ownerIsCalling = z10;
        this.callIsStarted = z11;
        this.peersConnected = z12;
        this.withCallMediaState = withCallMediaState;
        this.turnCredentials = turnCredentials;
        this.partner = partner;
        this.msgId = msgId;
        this.maxToSend = i10;
        this.isVideoCall = z13;
    }

    public static /* synthetic */ CallState copy$default(CallState callState, String str, String str2, boolean z10, boolean z11, boolean z12, CallMediaState callMediaState, TurnCredentials turnCredentials, Partner partner, String str3, int i10, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = callState.callId;
        }
        if ((i11 & 2) != 0) {
            str2 = callState.with;
        }
        if ((i11 & 4) != 0) {
            z10 = callState.ownerIsCalling;
        }
        if ((i11 & 8) != 0) {
            z11 = callState.callIsStarted;
        }
        if ((i11 & 16) != 0) {
            z12 = callState.peersConnected;
        }
        if ((i11 & 32) != 0) {
            callMediaState = callState.withCallMediaState;
        }
        if ((i11 & 64) != 0) {
            turnCredentials = callState.turnCredentials;
        }
        if ((i11 & 128) != 0) {
            partner = callState.partner;
        }
        if ((i11 & 256) != 0) {
            str3 = callState.msgId;
        }
        if ((i11 & 512) != 0) {
            i10 = callState.maxToSend;
        }
        if ((i11 & 1024) != 0) {
            z13 = callState.isVideoCall;
        }
        int i12 = i10;
        boolean z14 = z13;
        Partner partner2 = partner;
        String str4 = str3;
        CallMediaState callMediaState2 = callMediaState;
        TurnCredentials turnCredentials2 = turnCredentials;
        boolean z15 = z12;
        boolean z16 = z10;
        return callState.copy(str, str2, z16, z11, z15, callMediaState2, turnCredentials2, partner2, str4, i12, z14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCallId() {
        return this.callId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getMaxToSend() {
        return this.maxToSend;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getWith() {
        return this.with;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getOwnerIsCalling() {
        return this.ownerIsCalling;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCallIsStarted() {
        return this.callIsStarted;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getPeersConnected() {
        return this.peersConnected;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CallMediaState getWithCallMediaState() {
        return this.withCallMediaState;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final TurnCredentials getTurnCredentials() {
        return this.turnCredentials;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Partner getPartner() {
        return this.partner;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    public final CallState copy(String callId, String with, boolean ownerIsCalling, boolean callIsStarted, boolean peersConnected, CallMediaState withCallMediaState, TurnCredentials turnCredentials, Partner partner, String msgId, int maxToSend, boolean isVideoCall) {
        y.i(callId, "callId");
        y.i(with, "with");
        y.i(withCallMediaState, "withCallMediaState");
        y.i(turnCredentials, "turnCredentials");
        y.i(partner, "partner");
        y.i(msgId, "msgId");
        return new CallState(callId, with, ownerIsCalling, callIsStarted, peersConnected, withCallMediaState, turnCredentials, partner, msgId, maxToSend, isVideoCall);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallState)) {
            return false;
        }
        CallState callState = (CallState) other;
        return y.d(this.callId, callState.callId) && y.d(this.with, callState.with) && this.ownerIsCalling == callState.ownerIsCalling && this.callIsStarted == callState.callIsStarted && this.peersConnected == callState.peersConnected && y.d(this.withCallMediaState, callState.withCallMediaState) && y.d(this.turnCredentials, callState.turnCredentials) && y.d(this.partner, callState.partner) && y.d(this.msgId, callState.msgId) && this.maxToSend == callState.maxToSend && this.isVideoCall == callState.isVideoCall;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final boolean getCallIsStarted() {
        return this.callIsStarted;
    }

    public final int getMaxToSend() {
        return this.maxToSend;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final boolean getOwnerIsCalling() {
        return this.ownerIsCalling;
    }

    public final Partner getPartner() {
        return this.partner;
    }

    public final boolean getPeersConnected() {
        return this.peersConnected;
    }

    public final TurnCredentials getTurnCredentials() {
        return this.turnCredentials;
    }

    public final String getWith() {
        return this.with;
    }

    public final CallMediaState getWithCallMediaState() {
        return this.withCallMediaState;
    }

    public int hashCode() {
        return (((((((((((((((((((this.callId.hashCode() * 31) + this.with.hashCode()) * 31) + r.a(this.ownerIsCalling)) * 31) + r.a(this.callIsStarted)) * 31) + r.a(this.peersConnected)) * 31) + this.withCallMediaState.hashCode()) * 31) + this.turnCredentials.hashCode()) * 31) + this.partner.hashCode()) * 31) + this.msgId.hashCode()) * 31) + this.maxToSend) * 31) + r.a(this.isVideoCall);
    }

    public final boolean isVideoCall() {
        return this.isVideoCall;
    }

    public String toString() {
        return "CallState(callId=" + this.callId + ", with=" + this.with + ", ownerIsCalling=" + this.ownerIsCalling + ", callIsStarted=" + this.callIsStarted + ", peersConnected=" + this.peersConnected + ", withCallMediaState=" + this.withCallMediaState + ", turnCredentials=" + this.turnCredentials + ", partner=" + this.partner + ", msgId=" + this.msgId + ", maxToSend=" + this.maxToSend + ", isVideoCall=" + this.isVideoCall + ")";
    }

    public /* synthetic */ CallState(String str, String str2, boolean z10, boolean z11, boolean z12, CallMediaState callMediaState, TurnCredentials turnCredentials, Partner partner, String str3, int i10, boolean z13, int i11, p pVar) {
        String string;
        if ((i11 & 1) != 0) {
            d.a aVar = d.f40576c;
            int iH = aVar.h(0, 10);
            int iH2 = aVar.h(0, 10);
            int iH3 = aVar.h(0, 10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(iH);
            sb2.append(iH2);
            sb2.append(iH3);
            string = sb2.toString();
        } else {
            string = str;
        }
        this(string, str2, z10, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12, callMediaState, turnCredentials, partner, str3, i10, (i11 & 1024) != 0 ? false : z13);
    }
}
