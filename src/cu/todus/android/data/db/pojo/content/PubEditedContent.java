package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcu/todus/android/data/db/pojo/content/PubEditedContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "pubId", "", "chId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPubId", "()Ljava/lang/String;", "getChId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class PubEditedContent extends Content {
    public static final int $stable = 0;
    private final String chId;
    private final String pubId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PubEditedContent(String pubId, String chId) {
        super(24);
        y.i(pubId, "pubId");
        y.i(chId, "chId");
        this.pubId = pubId;
        this.chId = chId;
    }

    public final String getChId() {
        return this.chId;
    }

    public final String getPubId() {
        return this.pubId;
    }
}
