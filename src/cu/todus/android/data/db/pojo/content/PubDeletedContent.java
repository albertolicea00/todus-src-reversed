package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/data/db/pojo/content/PubDeletedContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "chId", "", "pubsId", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getChId", "()Ljava/lang/String;", "getPubsId", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class PubDeletedContent extends Content {
    public static final int $stable = 0;
    private final String chId;
    private final List<String> pubsId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PubDeletedContent(String chId, List<String> pubsId) {
        super(25);
        y.i(chId, "chId");
        y.i(pubsId, "pubsId");
        this.chId = chId;
        this.pubsId = pubsId;
    }

    public final String getChId() {
        return this.chId;
    }

    public final List<String> getPubsId() {
        return this.pubsId;
    }
}
