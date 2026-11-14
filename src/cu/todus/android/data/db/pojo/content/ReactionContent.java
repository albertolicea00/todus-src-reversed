package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Reaction;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcu/todus/android/data/db/pojo/content/ReactionContent;", "Lcu/todus/android/data/db/pojo/content/Content;", Reaction.COLUMN_ENTITY, "", "reactionContent", "createdAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getEntity", "()Ljava/lang/String;", "getReactionContent", "getCreatedAt", "()J", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ReactionContent extends Content {
    public static final int $stable = 0;
    private final long createdAt;
    private final String entity;
    private final String reactionContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionContent(String entity, String reactionContent, long j10) {
        super(23);
        y.i(entity, "entity");
        y.i(reactionContent, "reactionContent");
        this.entity = entity;
        this.reactionContent = reactionContent;
        this.createdAt = j10;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getEntity() {
        return this.entity;
    }

    public final String getReactionContent() {
        return this.reactionContent;
    }

    public /* synthetic */ ReactionContent(String str, String str2, long j10, int i10, p pVar) {
        this(str, str2, (i10 & 4) != 0 ? new Date().getTime() : j10);
    }
}
