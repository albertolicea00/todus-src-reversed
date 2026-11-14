package cu.z17.views.utils.blurhash;

import androidx.camera.video.AudioStats;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.db.entity.configs.Config;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import rb.k;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J+\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcu/z17/views/utils/blurhash/Utils;", "", "<init>", "()V", "sRGBToLinear", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "linearTosRGB", "signPow", "val", "exp", "max", Config.COLUMN_VALUES, "", "", TypedValues.TransitionType.S_FROM, "", "endExclusive", "([[DII)D", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Utils {
    public static final int $stable = 0;
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public static final long linearTosRGB(double value) {
        double dC = k.c(AudioStats.AUDIO_AMPLITUDE_NONE, k.h(1.0d, value));
        return (long) (((dC <= 0.0031308d ? dC * 12.92d : (Math.pow(dC, 0.4166666666666667d) * 1.055d) - 0.055d) * ((double) 255)) + 0.5d);
    }

    public static final double max(double[][] values, int from, int endExclusive) {
        y.i(values, "values");
        double d10 = Double.NEGATIVE_INFINITY;
        while (from < endExclusive) {
            int length = values[from].length;
            for (int i10 = 0; i10 < length; i10++) {
                double d11 = values[from][i10];
                if (d11 > d10) {
                    d10 = d11;
                }
            }
            from++;
        }
        return d10;
    }

    public static final double sRGBToLinear(long value) {
        double d10 = value / 255.0d;
        return d10 <= 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
    }

    public static final double signPow(double val, double exp) {
        return Math.copySign(Math.pow(Math.abs(val), exp), val);
    }
}
