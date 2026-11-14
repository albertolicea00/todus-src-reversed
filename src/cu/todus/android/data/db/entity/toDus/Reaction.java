package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import defpackage.l;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.a0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(tableName = "reaction")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\tHÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Reaction;", "", "id", "", Reaction.COLUMN_ENTITY, "userId", "roomId", "reactionContent", Reaction.COLUMN_REACTION_STATE, "", "createdAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V", "getId", "()Ljava/lang/String;", "getEntity", "getUserId", "getRoomId", "getReactionContent", "getReactionState", "()I", "getCreatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Reaction {
    public static final int $stable = 0;
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_ENTITY = "entity";
    public static final String COLUMN_REACTION_ID = "id";
    public static final String COLUMN_REACTION_STATE = "reactionState";
    public static final String COLUMN_REACTION_USER_ID = "userId";
    public static final String COLUMN_ROOM_ID = "roomId";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int REACTION_RECEIVED = 2;
    public static final int REACTION_SENT = 0;
    public static final int REACTION_UNSENT = 1;
    public static final String TABLE_NAME = "reaction";
    private final long createdAt;
    private final String entity;

    @PrimaryKey
    private final String id;
    private final String reactionContent;
    private final int reactionState;
    private final String roomId;
    private final String userId;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Reaction$Companion;", "", "<init>", "()V", "TABLE_NAME", "", "COLUMN_REACTION_USER_ID", "COLUMN_REACTION_ID", "COLUMN_ENTITY", "COLUMN_REACTION_STATE", "COLUMN_ROOM_ID", "COLUMN_CREATED_AT", "REACTION_SENT", "", "REACTION_UNSENT", "REACTION_RECEIVED", "buildId", Reaction.COLUMN_ENTITY, "ownerId", "checkIfIsForStatus", "", "reactionId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final String buildId(String entity, String ownerId) {
            y.i(entity, "entity");
            y.i(ownerId, "ownerId");
            return "reaction_" + entity + "_" + ownerId;
        }

        public final boolean checkIfIsForStatus(String reactionId) {
            y.i(reactionId, "reactionId");
            return a0.U(reactionId, "reaction_status", false, 2, null);
        }

        private Companion() {
        }
    }

    public Reaction(String id2, String entity, String userId, String roomId, String reactionContent, int i10, long j10) {
        y.i(id2, "id");
        y.i(entity, "entity");
        y.i(userId, "userId");
        y.i(roomId, "roomId");
        y.i(reactionContent, "reactionContent");
        this.id = id2;
        this.entity = entity;
        this.userId = userId;
        this.roomId = roomId;
        this.reactionContent = reactionContent;
        this.reactionState = i10;
        this.createdAt = j10;
    }

    public static /* synthetic */ Reaction copy$default(Reaction reaction, String str, String str2, String str3, String str4, String str5, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = reaction.id;
        }
        if ((i11 & 2) != 0) {
            str2 = reaction.entity;
        }
        if ((i11 & 4) != 0) {
            str3 = reaction.userId;
        }
        if ((i11 & 8) != 0) {
            str4 = reaction.roomId;
        }
        if ((i11 & 16) != 0) {
            str5 = reaction.reactionContent;
        }
        if ((i11 & 32) != 0) {
            i10 = reaction.reactionState;
        }
        if ((i11 & 64) != 0) {
            j10 = reaction.createdAt;
        }
        long j11 = j10;
        String str6 = str5;
        int i12 = i10;
        return reaction.copy(str, str2, str3, str4, str6, i12, j11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEntity() {
        return this.entity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReactionContent() {
        return this.reactionContent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getReactionState() {
        return this.reactionState;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final Reaction copy(String id2, String entity, String userId, String roomId, String reactionContent, int reactionState, long createdAt) {
        y.i(id2, "id");
        y.i(entity, "entity");
        y.i(userId, "userId");
        y.i(roomId, "roomId");
        y.i(reactionContent, "reactionContent");
        return new Reaction(id2, entity, userId, roomId, reactionContent, reactionState, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Reaction)) {
            return false;
        }
        Reaction reaction = (Reaction) other;
        return y.d(this.id, reaction.id) && y.d(this.entity, reaction.entity) && y.d(this.userId, reaction.userId) && y.d(this.roomId, reaction.roomId) && y.d(this.reactionContent, reaction.reactionContent) && this.reactionState == reaction.reactionState && this.createdAt == reaction.createdAt;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getEntity() {
        return this.entity;
    }

    public final String getId() {
        return this.id;
    }

    public final String getReactionContent() {
        return this.reactionContent;
    }

    public final int getReactionState() {
        return this.reactionState;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.entity.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.roomId.hashCode()) * 31) + this.reactionContent.hashCode()) * 31) + this.reactionState) * 31) + l.a(this.createdAt);
    }

    public String toString() {
        return "Reaction(id=" + this.id + ", entity=" + this.entity + ", userId=" + this.userId + ", roomId=" + this.roomId + ", reactionContent=" + this.reactionContent + ", reactionState=" + this.reactionState + ", createdAt=" + this.createdAt + ")";
    }

    public /* synthetic */ Reaction(String str, String str2, String str3, String str4, String str5, int i10, long j10, int i11, p pVar) {
        this(str, str2, str3, str4, str5, (i11 & 32) != 0 ? 1 : i10, (i11 & 64) != 0 ? new Date().getTime() : j10);
    }
}
