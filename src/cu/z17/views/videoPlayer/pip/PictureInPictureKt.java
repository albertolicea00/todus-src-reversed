package cu.z17.views.videoPlayer.pip;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.content.Context;
import android.os.Build;
import android.util.Rational;
import androidx.media3.ui.PlayerView;
import cu.z17.views.utils.Z17InlineUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aC\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "context", "Landroidx/media3/ui/PlayerView;", "defaultPlayerView", "Lkotlin/Pair;", "", "scale", "Lkotlin/Function0;", "Lua/k0;", "onEnterPIP", "enterPIPMode", "(Landroid/content/Context;Landroidx/media3/ui/PlayerView;Lkotlin/Pair;Llb/a;)V", "", "isActivityStatePipMode", "(Landroid/content/Context;)Z", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PictureInPictureKt {
    public static final void enterPIPMode(Context context, PlayerView defaultPlayerView, Pair<Integer, Integer> scale, a onEnterPIP) {
        y.i(context, "context");
        y.i(defaultPlayerView, "defaultPlayerView");
        y.i(scale, "scale");
        y.i(onEnterPIP, "onEnterPIP");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24 || !context.getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
            return;
        }
        defaultPlayerView.setUseController(false);
        if (i10 >= 26) {
            PictureInPictureParams.Builder builderA = v9.a.a();
            if (i10 >= 33) {
                builderA.setTitle("Video Player").setAspectRatio(new Rational(scale.getFirst().intValue(), scale.getSecond().intValue())).setSeamlessResizeEnabled(true);
            }
            Z17InlineUtilsKt.findActivity(context).enterPictureInPictureMode(builderA.build());
        } else {
            Z17InlineUtilsKt.findActivity(context).enterPictureInPictureMode();
        }
        onEnterPIP.invoke();
    }

    public static /* synthetic */ void enterPIPMode$default(Context context, PlayerView playerView, Pair pair, a aVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            aVar = new a() { // from class: v9.b
                @Override // lb.a
                public final Object invoke() {
                    return k0.f43947a;
                }
            };
        }
        enterPIPMode(context, playerView, pair, aVar);
    }

    public static final boolean isActivityStatePipMode(Context context) {
        y.i(context, "<this>");
        Activity activityFindActivity = Z17InlineUtilsKt.findActivity(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return activityFindActivity.isInPictureInPictureMode();
        }
        return false;
    }
}
