package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/data/db/pojo/content/Content;", "", "type", "", "<init>", "(I)V", "getType", "()I", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Content {
    public static final int $stable = 0;
    private final int type;

    public Content(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
