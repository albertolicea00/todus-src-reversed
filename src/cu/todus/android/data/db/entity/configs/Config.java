package cu.todus.android.data.db.entity.configs;

import android.media.RingtoneManager;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Entity(tableName = Config.TABLE_NAME)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/db/entity/configs/Config;", "", "tag", "", Config.COLUMN_VALUES, "Lcu/todus/android/data/db/entity/configs/Values;", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/db/entity/configs/Values;)V", "getTag", "()Ljava/lang/String;", "getValues", "()Lcu/todus/android/data/db/entity/configs/Values;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Config {
    public static final int $stable = 0;
    public static final String COLUMN_PARENT = "parent";
    public static final String COLUMN_TAG = "tag";
    public static final String COLUMN_VALUES = "values";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_MEDIUM = 1;
    public static final int PRIORITY_URGENT = 3;
    private static final String SOUND_DEFAULT;
    public static final String TABLE_NAME = "heritage";

    @PrimaryKey
    private final String tag;

    @Embedded
    private final Values values;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcu/todus/android/data/db/entity/configs/Config$Companion;", "", "<init>", "()V", "TABLE_NAME", "", "COLUMN_TAG", "COLUMN_VALUES", "COLUMN_PARENT", "PRIORITY_LOW", "", "PRIORITY_MEDIUM", "PRIORITY_HIGH", "PRIORITY_URGENT", "SOUND_DEFAULT", "getSOUND_DEFAULT", "()Ljava/lang/String;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final String getSOUND_DEFAULT() {
            return Config.SOUND_DEFAULT;
        }

        private Companion() {
        }
    }

    static {
        String string = RingtoneManager.getDefaultUri(2).toString();
        y.h(string, "toString(...)");
        SOUND_DEFAULT = string;
    }

    public Config(String tag, Values values) {
        y.i(tag, "tag");
        y.i(values, "values");
        this.tag = tag;
        this.values = values;
    }

    public static /* synthetic */ Config copy$default(Config config, String str, Values values, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = config.tag;
        }
        if ((i10 & 2) != 0) {
            values = config.values;
        }
        return config.copy(str, values);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Values getValues() {
        return this.values;
    }

    public final Config copy(String tag, Values values) {
        y.i(tag, "tag");
        y.i(values, "values");
        return new Config(tag, values);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Config)) {
            return false;
        }
        Config config = (Config) other;
        return y.d(this.tag, config.tag) && y.d(this.values, config.values);
    }

    public final String getTag() {
        return this.tag;
    }

    public final Values getValues() {
        return this.values;
    }

    public int hashCode() {
        return (this.tag.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        return "Config(tag=" + this.tag + ", values=" + this.values + ")";
    }
}
