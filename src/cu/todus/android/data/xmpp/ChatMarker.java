package cu.todus.android.data.xmpp;

import androidx.compose.runtime.Immutable;
import db.a;
import db.b;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcu/todus/android/data/xmpp/ChatMarker;", "", "msg", "", "sender", "type", "Lcu/todus/android/data/xmpp/ChatMarker$TYPE;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/xmpp/ChatMarker$TYPE;)V", "getMsg", "()Ljava/lang/String;", "getSender", "getType", "()Lcu/todus/android/data/xmpp/ChatMarker$TYPE;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "TYPE", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ChatMarker {
    public static final int $stable = 0;
    private final String msg;
    private final String sender;
    private final TYPE type;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/data/xmpp/ChatMarker$TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "RECEIVED", "DISPLAYED", "MARKABLE", "ACKNOWLEDGED", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum TYPE {
        RECEIVED,
        DISPLAYED,
        MARKABLE,
        ACKNOWLEDGED;

        private static final /* synthetic */ a $ENTRIES = b.a(values());

        public static a getEntries() {
            return $ENTRIES;
        }
    }

    public ChatMarker(String msg, String sender, TYPE type) {
        y.i(msg, "msg");
        y.i(sender, "sender");
        y.i(type, "type");
        this.msg = msg;
        this.sender = sender;
        this.type = type;
    }

    public static /* synthetic */ ChatMarker copy$default(ChatMarker chatMarker, String str, String str2, TYPE type, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = chatMarker.msg;
        }
        if ((i10 & 2) != 0) {
            str2 = chatMarker.sender;
        }
        if ((i10 & 4) != 0) {
            type = chatMarker.type;
        }
        return chatMarker.copy(str, str2, type);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TYPE getType() {
        return this.type;
    }

    public final ChatMarker copy(String msg, String sender, TYPE type) {
        y.i(msg, "msg");
        y.i(sender, "sender");
        y.i(type, "type");
        return new ChatMarker(msg, sender, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatMarker)) {
            return false;
        }
        ChatMarker chatMarker = (ChatMarker) other;
        return y.d(this.msg, chatMarker.msg) && y.d(this.sender, chatMarker.sender) && this.type == chatMarker.type;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getSender() {
        return this.sender;
    }

    public final TYPE getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.msg.hashCode() * 31) + this.sender.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ChatMarker(msg=" + this.msg + ", sender=" + this.sender + ", type=" + this.type + ")";
    }
}
