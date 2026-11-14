package cu.todus.android.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import ua.z;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"getScaleFromSize", "Lcu/todus/android/utils/Scale;", "width", "", "height", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ImageScalerKt {
    public static final Scale getScaleFromSize(long j10, long j11) {
        List<Pair> listQ = w.q(z.a(Scale.SCALE1x1, Double.valueOf(1.0d)), z.a(Scale.SCALE4x3, Double.valueOf(1.3333333333333333d)), z.a(Scale.SCALE16x9, Double.valueOf(1.7777777777777777d)), z.a(Scale.SCALE9x16, Double.valueOf(0.5625d)));
        double d10 = j10 / j11;
        Pair pair = (Pair) listQ.get(0);
        double d11 = Double.MAX_VALUE;
        for (Pair pair2 : listQ) {
            double dAbs = Math.abs(((Number) pair2.getSecond()).doubleValue() - d10);
            if (dAbs < d11) {
                pair = pair2;
                d11 = dAbs;
            }
        }
        return (Scale) pair.getFirst();
    }
}
