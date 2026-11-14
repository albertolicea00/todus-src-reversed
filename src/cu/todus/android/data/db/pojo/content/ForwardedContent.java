package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0082\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcu/todus/android/data/db/pojo/content/ForwardedContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "ownerUser", "", "<init>", "(Ljava/lang/String;)V", "getOwnerUser", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ForwardedContent extends Content {
    public static final int $stable = 0;
    private final String ownerUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardedContent(String ownerUser) {
        super(14);
        y.i(ownerUser, "ownerUser");
        this.ownerUser = ownerUser;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return y.d(getClass(), other != null ? other.getClass() : null);
    }

    public final String getOwnerUser() {
        return this.ownerUser;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
