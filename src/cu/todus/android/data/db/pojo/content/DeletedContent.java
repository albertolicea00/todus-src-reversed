package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0082\u0004J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004¨\u0006\n"}, d2 = {"Lcu/todus/android/data/db/pojo/content/DeletedContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class DeletedContent extends Content {
    public static final int $stable = 0;

    public DeletedContent() {
        super(16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return y.d(getClass(), other != null ? other.getClass() : null);
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
