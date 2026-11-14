package cu.todus.android.data.db.pojo.messageentity;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0013\u001a\u00020\u0003H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0007H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", "", "type", "", "offset", "length", "url", "", "<init>", "(IIILjava/lang/String;)V", "getType", "()I", "getOffset", "getLength", "getUrl", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MessageEntity {
    public static final int $stable = 0;
    public static final int TYPE_LINK = 2;
    public static final int TYPE_MENTION_NAME = 1;
    private final int length;
    private final int offset;
    private final int type;
    private final String url;

    public MessageEntity(int i10, int i11, int i12, String str) {
        this.type = i10;
        this.offset = i11;
        this.length = i12;
        this.url = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEntity)) {
            return false;
        }
        MessageEntity messageEntity = (MessageEntity) other;
        if (this.type == messageEntity.type && this.offset == messageEntity.offset && this.length == messageEntity.length) {
            return y.d(this.url, messageEntity.url);
        }
        return false;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i10 = ((((this.type * 31) + this.offset) * 31) + this.length) * 31;
        String str = this.url;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "MessageEntity(type=" + this.type + ", offset=" + this.offset + ", length=" + this.length + ", url=" + this.url + ")";
    }

    public /* synthetic */ MessageEntity(int i10, int i11, int i12, String str, int i13, p pVar) {
        this(i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12, (i13 & 8) != 0 ? null : str);
    }
}
