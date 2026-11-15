package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import java.util.Objects;

/**
 * Room entity storing a single chunk of a split long text message.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.ChunkEntity
 */
@StabilityInferred(parameters = 1)
@Entity(
        tableName = "message_chunks",
        primaryKeys = {"originalMsgId", "chunkIndex"}
)
public final class ChunkEntity {

    private final String originalMsgId;
    private final int chunkIndex;
    private final String textContent;

    public ChunkEntity(String originalMsgId, int chunkIndex, String textContent) {
        this.originalMsgId = Objects.requireNonNull(originalMsgId, "originalMsgId");
        this.chunkIndex = chunkIndex;
        this.textContent = Objects.requireNonNull(textContent, "textContent");
    }

    public String getOriginalMsgId() {
        return originalMsgId;
    }

    public int getChunkIndex() {
        return chunkIndex;
    }

    public String getTextContent() {
        return textContent;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChunkEntity)) {
            return false;
        }
        ChunkEntity that = (ChunkEntity) other;
        return chunkIndex == that.chunkIndex
                && Objects.equals(originalMsgId, that.originalMsgId)
                && Objects.equals(textContent, that.textContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalMsgId, chunkIndex, textContent);
    }

    @Override
    public String toString() {
        return "ChunkEntity(originalMsgId=" + originalMsgId
                + ", chunkIndex=" + chunkIndex
                + ", textContent=" + textContent + ")";
    }
}
