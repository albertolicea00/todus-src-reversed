package cu.todus.android.utils;

import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/utils/HtmlForTextObj;", "", "strBuilder", "Landroid/text/SpannableStringBuilder;", "movementMethod", "Landroid/text/method/MovementMethod;", "<init>", "(Landroid/text/SpannableStringBuilder;Landroid/text/method/MovementMethod;)V", "getStrBuilder", "()Landroid/text/SpannableStringBuilder;", "getMovementMethod", "()Landroid/text/method/MovementMethod;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HtmlForTextObj {
    public static final int $stable = 8;
    private final MovementMethod movementMethod;
    private final SpannableStringBuilder strBuilder;

    public HtmlForTextObj(SpannableStringBuilder strBuilder, MovementMethod movementMethod) {
        y.i(strBuilder, "strBuilder");
        y.i(movementMethod, "movementMethod");
        this.strBuilder = strBuilder;
        this.movementMethod = movementMethod;
    }

    public final MovementMethod getMovementMethod() {
        return this.movementMethod;
    }

    public final SpannableStringBuilder getStrBuilder() {
        return this.strBuilder;
    }
}
