package cu.todus.android.utils;

import android.content.Context;
import android.util.TypedValue;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t¨\u0006\u0012"}, d2 = {"Lcu/todus/android/utils/ScreenUtil;", "", "<init>", "()V", "dip2px", "", "context", "Landroid/content/Context;", "dpValue", "", "dp", AppMeasurementSdk.ConditionalUserProperty.VALUE, "dip2fpx", "px2dip", "pxValue", "px2sp", "sp2px", "spValue", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScreenUtil {
    public static final int $stable = 0;
    public static final ScreenUtil INSTANCE = new ScreenUtil();

    private ScreenUtil() {
    }

    public final float dip2fpx(Context context, float dpValue) {
        y.i(context, "context");
        return (dpValue * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public final int dip2px(Context context, float dpValue) {
        y.i(context, "context");
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int dp(Context context, float value) {
        y.i(context, "context");
        return (int) TypedValue.applyDimension(1, value, context.getResources().getDisplayMetrics());
    }

    public final int px2dip(Context context, float pxValue) {
        y.i(context, "context");
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int px2sp(Context context, float pxValue) {
        y.i(context, "context");
        return (int) ((pxValue / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final int sp2px(Context context, float spValue) {
        y.i(context, "context");
        return (int) ((spValue * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final int dp(Context context, int value) {
        y.i(context, "context");
        return (int) TypedValue.applyDimension(1, value, context.getResources().getDisplayMetrics());
    }
}
