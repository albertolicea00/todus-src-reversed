package cu.todus.android.utils.betterypermissionhelper.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"applicationName", "", "Landroid/content/Context;", "getApplicationName", "(Landroid/content/Context;)Ljava/lang/String;", "getIntentActivities", "", "Landroid/content/pm/ResolveInfo;", "intent", "Landroid/content/Intent;", "flag", "", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ApplicationUtilsKt {
    public static final String getApplicationName(Context context) {
        y.i(context, "<this>");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i10 = applicationInfo.labelRes;
        if (i10 == 0) {
            return applicationInfo.nonLocalizedLabel.toString();
        }
        String string = context.getString(i10);
        y.h(string, "getString(...)");
        return string;
    }

    public static final List<ResolveInfo> getIntentActivities(Context context, Intent intent, int i10) {
        y.i(context, "<this>");
        y.i(intent, "intent");
        if (Build.VERSION.SDK_INT >= 33) {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(i10));
            y.f(listQueryIntentActivities);
            return listQueryIntentActivities;
        }
        List<ResolveInfo> listQueryIntentActivities2 = context.getPackageManager().queryIntentActivities(intent, i10);
        y.f(listQueryIntentActivities2);
        return listQueryIntentActivities2;
    }

    public static /* synthetic */ List getIntentActivities$default(Context context, Intent intent, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 65536;
        }
        return getIntentActivities(context, intent, i10);
    }
}
