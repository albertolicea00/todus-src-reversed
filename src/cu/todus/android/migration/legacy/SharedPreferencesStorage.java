package cu.todus.android.migration.legacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\f\u0010\u000fJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\f\u0010\u0011J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0012J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\f\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcu/todus/android/migration/legacy/SharedPreferencesStorage;", "Lcu/todus/android/migration/legacy/Storage;", "Landroid/content/Context;", "context", "", "sharedPreferencesName", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "name", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "store", "(Ljava/lang/String;Ljava/lang/Long;)V", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "default", "retrieveLong", "(Ljava/lang/String;J)J", "retrieveFloat", "(Ljava/lang/String;F)F", "retrieveString", "(Ljava/lang/String;)Ljava/lang/String;", "retrieveInteger", "(Ljava/lang/String;)Ljava/lang/Integer;", "retrieveBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", DiscoverItems.Item.REMOVE_ACTION, "(Ljava/lang/String;)V", "clean", "()V", "Landroid/content/SharedPreferences;", "sp", "Landroid/content/SharedPreferences;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SharedPreferencesStorage implements Storage {
    public static final int $stable = 8;
    private final SharedPreferences sp;

    public SharedPreferencesStorage(Context context, String sharedPreferencesName) {
        y.i(context, "context");
        y.i(sharedPreferencesName, "sharedPreferencesName");
        if (TextUtils.isEmpty(sharedPreferencesName)) {
            throw new IllegalArgumentException("The SharedPreferences name is invalid.");
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferencesName, 0);
        y.h(sharedPreferences, "getSharedPreferences(...)");
        this.sp = sharedPreferences;
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public void clean() {
        this.sp.edit().clear().apply();
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public void remove(String name) {
        y.i(name, "name");
        this.sp.edit().remove(name).apply();
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public Boolean retrieveBoolean(String name) {
        y.i(name, "name");
        if (this.sp.contains(name)) {
            return Boolean.valueOf(this.sp.getBoolean(name, false));
        }
        return null;
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public float retrieveFloat(String name, float f10) {
        y.i(name, "name");
        return !this.sp.contains(name) ? f10 : this.sp.getFloat(name, f10);
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public Integer retrieveInteger(String name) {
        y.i(name, "name");
        if (this.sp.contains(name)) {
            return Integer.valueOf(this.sp.getInt(name, 0));
        }
        return null;
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public long retrieveLong(String name, long j10) {
        y.i(name, "name");
        return !this.sp.contains(name) ? j10 : this.sp.getLong(name, 0L);
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public String retrieveString(String name) {
        String string;
        y.i(name, "name");
        return (this.sp.contains(name) && (string = this.sp.getString(name, "")) != null) ? string : "";
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public void store(String name, Long value) {
        y.i(name, "name");
        if (value == null) {
            this.sp.edit().remove(name).apply();
        } else {
            this.sp.edit().putLong(name, value.longValue()).apply();
        }
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public void store(String name, Float value) {
        y.i(name, "name");
        if (value == null) {
            this.sp.edit().remove(name).apply();
        } else {
            this.sp.edit().putFloat(name, value.floatValue()).apply();
        }
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public void store(String name, Integer value) {
        y.i(name, "name");
        if (value == null) {
            this.sp.edit().remove(name).apply();
        } else {
            this.sp.edit().putInt(name, value.intValue()).apply();
        }
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public void store(String name, String value) {
        y.i(name, "name");
        if (value == null) {
            this.sp.edit().remove(name).apply();
        } else {
            this.sp.edit().putString(name, value).apply();
        }
    }

    @Override // cu.todus.android.migration.legacy.Storage
    public void store(String name, Boolean value) {
        y.i(name, "name");
        if (value == null) {
            this.sp.edit().remove(name).apply();
        } else {
            this.sp.edit().putBoolean(name, value.booleanValue()).apply();
        }
    }
}
