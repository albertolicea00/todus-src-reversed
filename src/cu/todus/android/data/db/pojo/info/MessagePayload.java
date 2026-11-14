package cu.todus.android.data.db.pojo.info;

import androidx.compose.runtime.Immutable;
import db.a;
import db.b;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcu/todus/android/data/db/pojo/info/MessagePayload;", "", "type", "Lcu/todus/android/data/db/pojo/info/MessagePayload$TYPE;", "<init>", "(Lcu/todus/android/data/db/pojo/info/MessagePayload$TYPE;)V", "getType", "()Lcu/todus/android/data/db/pojo/info/MessagePayload$TYPE;", "equals", "", "other", "hashCode", "", "TYPE", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MessagePayload {
    public static final int $stable = 0;
    private final TYPE type;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcu/todus/android/data/db/pojo/info/MessagePayload$TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVILEGES_CHANGE_IN_GROUP", "PRIVILEGES_CHANGE_IN_CHANNEL", "CONFIG_CHANGE_IN_GROUP", "CONFIG_CHANGE_IN_CHANNEL", "DESTROY_GROUP", "DATE_PAYLOAD", "ROOM_BANNER_PAYLOAD", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum TYPE {
        PRIVILEGES_CHANGE_IN_GROUP,
        PRIVILEGES_CHANGE_IN_CHANNEL,
        CONFIG_CHANGE_IN_GROUP,
        CONFIG_CHANGE_IN_CHANNEL,
        DESTROY_GROUP,
        DATE_PAYLOAD,
        ROOM_BANNER_PAYLOAD;

        private static final /* synthetic */ a $ENTRIES = b.a(values());

        public static a getEntries() {
            return $ENTRIES;
        }
    }

    public MessagePayload(TYPE type) {
        y.i(type, "type");
        this.type = type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MessagePayload) && this.type == ((MessagePayload) other).type;
    }

    public final TYPE getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }
}
