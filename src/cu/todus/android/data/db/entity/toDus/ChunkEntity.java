package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Entity(primaryKeys = {"originalMsgId", "chunkIndex"}, tableName = "message_chunks")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/ChunkEntity;", "", "originalMsgId", "", "chunkIndex", "", "textContent", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOriginalMsgId", "()Ljava/lang/String;", "getChunkIndex", "()I", "getTextContent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ChunkEntity {
    public static final int $stable = 0;
    private final int chunkIndex;
    private final String originalMsgId;
    private final String textContent;

    public ChunkEntity(String originalMsgId, int i10, String textContent) {
        y.i(originalMsgId, "originalMsgId");
        y.i(textContent, "textContent");
        this.originalMsgId = originalMsgId;
        this.chunkIndex = i10;
        this.textContent = textContent;
    }

    public static /* synthetic */ ChunkEntity copy$default(ChunkEntity chunkEntity, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = chunkEntity.originalMsgId;
        }
        if ((i11 & 2) != 0) {
            i10 = chunkEntity.chunkIndex;
        }
        if ((i11 & 4) != 0) {
            str2 = chunkEntity.textContent;
        }
        return chunkEntity.copy(str, i10, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOriginalMsgId() {
        return this.originalMsgId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getChunkIndex() {
        return this.chunkIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }

    public final ChunkEntity copy(String originalMsgId, int chunkIndex, String textContent) {
        y.i(originalMsgId, "originalMsgId");
        y.i(textContent, "textContent");
        return new ChunkEntity(originalMsgId, chunkIndex, textContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChunkEntity)) {
            return false;
        }
        ChunkEntity chunkEntity = (ChunkEntity) other;
        return y.d(this.originalMsgId, chunkEntity.originalMsgId) && this.chunkIndex == chunkEntity.chunkIndex && y.d(this.textContent, chunkEntity.textContent);
    }

    public final int getChunkIndex() {
        return this.chunkIndex;
    }

    public final String getOriginalMsgId() {
        return this.originalMsgId;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public int hashCode() {
        return (((this.originalMsgId.hashCode() * 31) + this.chunkIndex) * 31) + this.textContent.hashCode();
    }

    public String toString() {
        return "ChunkEntity(originalMsgId=" + this.originalMsgId + ", chunkIndex=" + this.chunkIndex + ", textContent=" + this.textContent + ")";
    }
}
