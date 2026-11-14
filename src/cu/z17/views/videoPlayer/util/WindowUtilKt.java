package cu.z17.views.videoPlayer.util;

import android.app.Activity;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/app/Activity;", "", "fullscreen", "Lua/k0;", "setFullScreen", "(Landroid/app/Activity;Z)V", "Landroid/view/Window;", "(Landroid/view/Window;Z)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WindowUtilKt {
    public static final void setFullScreen(Activity activity, boolean z10) {
        y.i(activity, "<this>");
        Window window = activity.getWindow();
        y.h(window, "getWindow(...)");
        setFullScreen(window, z10);
    }

    public static final void setFullScreen(Window window, boolean z10) {
        y.i(window, "<this>");
        if (z10) {
            window.getDecorView().setSystemUiVisibility(5894);
        } else {
            window.getDecorView().setSystemUiVisibility(0);
        }
    }
}
