package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Objects;

/**
 * Room entity logging a pending or synced local contact roster mutation.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.RosterChange
 */
@StabilityInferred(parameters = 1)
@Entity(tableName = "roster_change")
public final class RosterChange {

    public static final String TYPE_ADD = "ADD";
    public static final String TYPE_DELETE = "DELETE";
    public static final String TYPE_UPDATE = "UPDATE";

    @PrimaryKey(autoGenerate = true)
    private final long id;
    private final String phone;
    private final String changeType;
    private final long timestamp;
    private final String previousName;
    private final String currentName;
    private final boolean synced;
    private final Integer targetVersion;

    public RosterChange(
            String phone,
            String changeType,
            String previousName,
            String currentName
    ) {
        this(0L, phone, changeType, System.currentTimeMillis(), previousName, currentName, false, null);
    }

    public RosterChange(
            long id,
            String phone,
            String changeType,
            long timestamp,
            String previousName,
            String currentName,
            boolean synced,
            Integer targetVersion
    ) {
        this.id = id;
        this.phone = Objects.requireNonNull(phone, "phone");
        this.changeType = Objects.requireNonNull(changeType, "changeType");
        this.timestamp = timestamp;
        this.previousName = previousName;
        this.currentName = currentName;
        this.synced = synced;
        this.targetVersion = targetVersion;
    }

    public long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getChangeType() {
        return changeType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPreviousName() {
        return previousName;
    }

    public String getCurrentName() {
        return currentName;
    }

    public boolean getSynced() {
        return synced;
    }

    public Integer getTargetVersion() {
        return targetVersion;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RosterChange)) {
            return false;
        }
        RosterChange that = (RosterChange) other;
        return id == that.id
                && timestamp == that.timestamp
                && synced == that.synced
                && Objects.equals(phone, that.phone)
                && Objects.equals(changeType, that.changeType)
                && Objects.equals(previousName, that.previousName)
                && Objects.equals(currentName, that.currentName)
                && Objects.equals(targetVersion, that.targetVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, changeType, timestamp, previousName, currentName, synced, targetVersion);
    }

    @Override
    public String toString() {
        return "RosterChange(id=" + id
                + ", phone=" + phone
                + ", changeType=" + changeType
                + ", timestamp=" + timestamp
                + ", previousName=" + previousName
                + ", currentName=" + currentName
                + ", synced=" + synced
                + ", targetVersion=" + targetVersion + ")";
    }
}
