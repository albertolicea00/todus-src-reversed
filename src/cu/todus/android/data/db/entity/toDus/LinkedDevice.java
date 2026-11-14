package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import defpackage.l;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import w5.a;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(tableName = "linked_device")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcu/todus/android/data/db/entity/toDus/LinkedDevice;", "", "id", "", LinkedDevice.COLUMN_DEVICE, "url", "date", "", "state", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "getId", "()Ljava/lang/String;", "getDevice", "getUrl", "getDate", "()J", "getState", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LinkedDevice {
    public static final int $stable = 0;
    public static final String COLUMN_DEVICE = "device";
    public static final String COLUMN_ID = "session_id";
    public static final String COLUMN_LAST_TIME = "last_time";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_URL = "url";
    public static final int STATE_ACTIVE = 0;
    public static final int STATE_CLOSED = 1;
    public static final String TABLE_NAME = "linked_device";

    @a
    @ColumnInfo(name = COLUMN_LAST_TIME)
    @c(COLUMN_LAST_TIME)
    private final long date;

    @a
    @ColumnInfo(name = COLUMN_DEVICE)
    @c(COLUMN_DEVICE)
    private final String device;

    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    @c(COLUMN_ID)
    private final String id;

    @a
    @ColumnInfo(name = "state")
    @c("state")
    private final int state;

    @a
    @ColumnInfo(name = "url")
    @c("url")
    private final String url;

    public LinkedDevice() {
        this(null, null, null, 0L, 0, 31, null);
    }

    public static /* synthetic */ LinkedDevice copy$default(LinkedDevice linkedDevice, String str, String str2, String str3, long j10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = linkedDevice.id;
        }
        if ((i11 & 2) != 0) {
            str2 = linkedDevice.device;
        }
        if ((i11 & 4) != 0) {
            str3 = linkedDevice.url;
        }
        if ((i11 & 8) != 0) {
            j10 = linkedDevice.date;
        }
        if ((i11 & 16) != 0) {
            i10 = linkedDevice.state;
        }
        int i12 = i10;
        String str4 = str3;
        return linkedDevice.copy(str, str2, str4, j10, i12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public final LinkedDevice copy(String id2, String device, String url, long date, int state) {
        y.i(id2, "id");
        y.i(device, "device");
        y.i(url, "url");
        return new LinkedDevice(id2, device, url, date, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkedDevice)) {
            return false;
        }
        LinkedDevice linkedDevice = (LinkedDevice) other;
        return y.d(this.id, linkedDevice.id) && y.d(this.device, linkedDevice.device) && y.d(this.url, linkedDevice.url) && this.date == linkedDevice.date && this.state == linkedDevice.state;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getDevice() {
        return this.device;
    }

    public final String getId() {
        return this.id;
    }

    public final int getState() {
        return this.state;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.device.hashCode()) * 31) + this.url.hashCode()) * 31) + l.a(this.date)) * 31) + this.state;
    }

    public String toString() {
        return "LinkedDevice(id=" + this.id + ", device=" + this.device + ", url=" + this.url + ", date=" + this.date + ", state=" + this.state + ")";
    }

    public LinkedDevice(String id2, String device, String url, long j10, int i10) {
        y.i(id2, "id");
        y.i(device, "device");
        y.i(url, "url");
        this.id = id2;
        this.device = device;
        this.url = url;
        this.date = j10;
        this.state = i10;
    }

    public /* synthetic */ LinkedDevice(String str, String str2, String str3, long j10, int i10, int i11, p pVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? new Date().getTime() : j10, (i11 & 16) != 0 ? 0 : i10);
    }
}
