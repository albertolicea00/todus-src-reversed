package cu.todus.android.utils;

import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcu/todus/android/utils/UniqueId;", "", "<init>", "()V", "getUniquePsuedoID", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UniqueId {
    public static final int $stable = 0;
    public static final UniqueId INSTANCE = new UniqueId();

    private UniqueId() {
    }

    public final String getUniquePsuedoID() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        try {
            Object obj = Build.class.getField("SERIAL").get(null);
            String string = obj != null ? obj.toString() : null;
            String string2 = new UUID(str.hashCode(), string != null ? string.hashCode() : 0).toString();
            y.h(string2, "toString(...)");
            return string2;
        } catch (Exception unused) {
            String string3 = new UUID(str.hashCode(), -905839116).toString();
            y.h(string3, "toString(...)");
            return string3;
        }
    }
}
