package cu.todus.android.notification.intent;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcu/todus/android/notification/intent/ClickPendingIntentActivity;", "Lcu/todus/android/notification/intent/PendingIntentNotification;", "context", "Landroid/content/Context;", "mActivity", "Ljava/lang/Class;", "mBundle", "Landroid/os/Bundle;", "mIdentifier", "", "<init>", "(Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;I)V", "getContext", "()Landroid/content/Context;", "onSettingPendingIntent", "Landroid/app/PendingIntent;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ClickPendingIntentActivity implements PendingIntentNotification {
    public static final String ACTION_CLICK_INTENT = "cu.todus.android.action.click.intent";
    private final Context context;
    private final Class<?> mActivity;
    private final Bundle mBundle;
    private final int mIdentifier;
    public static final int $stable = 8;

    public ClickPendingIntentActivity(Context context, Class<?> mActivity, Bundle bundle, int i10) {
        y.i(context, "context");
        y.i(mActivity, "mActivity");
        this.context = context;
        this.mActivity = mActivity;
        this.mBundle = bundle;
        this.mIdentifier = i10;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // cu.todus.android.notification.intent.PendingIntentNotification
    public PendingIntent onSettingPendingIntent() {
        Intent intent = new Intent(this.context, this.mActivity);
        intent.setAction(ACTION_CLICK_INTENT);
        intent.addFlags(C.BUFFER_FLAG_LAST_SAMPLE);
        intent.setPackage(this.context.getPackageName());
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        PendingIntent activity = PendingIntent.getActivity(this.context, this.mIdentifier, intent, Build.VERSION.SDK_INT >= 31 ? 167772160 : C.BUFFER_FLAG_FIRST_SAMPLE);
        y.h(activity, "getActivity(...)");
        return activity;
    }
}
