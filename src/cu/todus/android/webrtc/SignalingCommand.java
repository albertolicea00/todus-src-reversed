package cu.todus.android.webrtc;

import db.a;
import db.b;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcu/todus/android/webrtc/SignalingCommand;", "", "<init>", "(Ljava/lang/String;I)V", "CALL", "PICKED", "OFFER", "ANSWER", "ICE", "CONFIG", "REJECT", "END", "CHECKING_REQUEST", "CHECKING_RESPONSE", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum SignalingCommand {
    CALL,
    PICKED,
    OFFER,
    ANSWER,
    ICE,
    CONFIG,
    REJECT,
    END,
    CHECKING_REQUEST,
    CHECKING_RESPONSE;

    private static final /* synthetic */ a $ENTRIES = b.a(values());

    public static a getEntries() {
        return $ENTRIES;
    }
}
