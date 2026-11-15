package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.Objects;

/**
 * Room entity and Gson model representing a linked web/desktop session device.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.LinkedDevice
 */
@Immutable
@Entity(tableName = LinkedDevice.TABLE_NAME)
public final class LinkedDevice {

    public static final String TABLE_NAME = "linked_device";

    public static final String COLUMN_ID = "session_id";
    public static final String COLUMN_DEVICE = "device";
    public static final String COLUMN_URL = "url";
    public static final String COLUMN_LAST_TIME = "last_time";
    public static final String COLUMN_STATE = "state";

    public static final int STATE_ACTIVE = 0;
    public static final int STATE_CLOSED = 1;

    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    @SerializedName(COLUMN_ID)
    private final String id;

    @Expose
    @ColumnInfo(name = COLUMN_DEVICE)
    @SerializedName(COLUMN_DEVICE)
    private final String device;

    @Expose
    @ColumnInfo(name = COLUMN_URL)
    @SerializedName(COLUMN_URL)
    private final String url;

    @Expose
    @ColumnInfo(name = COLUMN_LAST_TIME)
    @SerializedName(COLUMN_LAST_TIME)
    private final long date;

    @Expose
    @ColumnInfo(name = COLUMN_STATE)
    @SerializedName(COLUMN_STATE)
    private final int state;

    public LinkedDevice() {
        this("", "", "", new Date().getTime(), STATE_ACTIVE);
    }

    public LinkedDevice(String id, String device, String url, long date, int state) {
        this.id = Objects.requireNonNull(id, "id");
        this.device = Objects.requireNonNull(device, "device");
        this.url = Objects.requireNonNull(url, "url");
        this.date = date;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getDevice() {
        return device;
    }

    public String getUrl() {
        return url;
    }

    public long getDate() {
        return date;
    }

    public int getState() {
        return state;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkedDevice)) {
            return false;
        }
        LinkedDevice that = (LinkedDevice) other;
        return date == that.date
                && state == that.state
                && Objects.equals(id, that.id)
                && Objects.equals(device, that.device)
                && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, device, url, date, state);
    }

    @Override
    public String toString() {
        return "LinkedDevice(id=" + id
                + ", device=" + device
                + ", url=" + url
                + ", date=" + date
                + ", state=" + state + ")";
    }
}
