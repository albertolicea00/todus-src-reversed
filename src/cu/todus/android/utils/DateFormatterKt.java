package cu.todus.android.utils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.e1;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"formatHourMinSec", "", "", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DateFormatterKt {
    public static final String formatHourMinSec(long j10) {
        if (j10 == 0) {
            return "...";
        }
        e1 e1Var = e1.f36604a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toHours(j10)), Long.valueOf(timeUnit.toMinutes(j10) - TimeUnit.HOURS.toMinutes(timeUnit.toHours(j10))), Long.valueOf(timeUnit.toSeconds(j10) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j10)))}, 3));
        y.h(str, "format(...)");
        return str;
    }
}
