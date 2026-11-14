package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0082\u0004J\n\u0010\u0011\u001a\u00020\u0005H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0012"}, d2 = {"Lcu/todus/android/data/db/pojo/content/EmojiContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "onlyTodus", "", "cant", "", "size", "<init>", "(ZII)V", "getOnlyTodus", "()Z", "getCant", "()I", "getSize", "equals", "other", "", "hashCode", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class EmojiContent extends Content {
    public static final int $stable = 0;
    private final int cant;
    private final boolean onlyTodus;
    private final int size;

    public EmojiContent() {
        this(false, 0, 0, 7, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return y.d(getClass(), other != null ? other.getClass() : null);
    }

    public final int getCant() {
        return this.cant;
    }

    public final boolean getOnlyTodus() {
        return this.onlyTodus;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public EmojiContent(boolean z10, int i10, int i11) {
        super(11);
        this.onlyTodus = z10;
        this.cant = i10;
        this.size = i11;
    }

    public /* synthetic */ EmojiContent(boolean z10, int i10, int i11, int i12, p pVar) {
        this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }
}
