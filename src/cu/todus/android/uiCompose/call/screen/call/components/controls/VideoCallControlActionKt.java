package cu.todus.android.uiCompose.call.screen.call.components.controls;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import cu.todus.android.R;
import cu.todus.android.uiCompose.call.screen.call.CallMediaState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"buildDefaultCallControlActions", "", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/VideoCallControlAction;", "callMediaState", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "(Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "buildWithCallControlActions", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class VideoCallControlActionKt {
    @Composable
    public static final List<VideoCallControlAction> buildDefaultCallControlActions(CallMediaState callMediaState, Composer composer, int i10) {
        y.i(callMediaState, "callMediaState");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-375467370, i10, -1, "cu.todus.android.uiCompose.call.screen.call.components.controls.buildDefaultCallControlActions (VideoCallControlAction.kt:34)");
        }
        Painter painterPainterResource = PainterResources_androidKt.painterResource(callMediaState.isMicrophoneEnabled() ? R.drawable.mic_on : R.drawable.mic_off, composer, 0);
        Painter painterPainterResource2 = PainterResources_androidKt.painterResource(callMediaState.isCameraEnabled() ? R.drawable.videocam_on : R.drawable.videocam_off, composer, 0);
        Color.Companion companion = Color.INSTANCE;
        long jM5903getWhite0d7_KjU = companion.m5903getWhite0d7_KjU();
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        List<VideoCallControlAction> listQ = w.q(new VideoCallControlAction(painterPainterResource, jM5903getWhite0d7_KjU, materialTheme.getColorScheme(composer, i11).getPrimary(), new CallAction.ToggleMicroPhone(callMediaState.isMicrophoneEnabled()), null), new VideoCallControlAction(painterPainterResource2, companion.m5903getWhite0d7_KjU(), materialTheme.getColorScheme(composer, i11).getPrimary(), new CallAction.ToggleCamera(callMediaState.isCameraEnabled()), null), new VideoCallControlAction(PainterResources_androidKt.painterResource(R.drawable.camera_flip, composer, 0), companion.m5903getWhite0d7_KjU(), materialTheme.getColorScheme(composer, i11).getPrimary(), CallAction.FlipCamera.INSTANCE, null), new VideoCallControlAction(PainterResources_androidKt.painterResource(R.drawable.call_end, composer, 0), companion.m5903getWhite0d7_KjU(), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i11).getOnBackground(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), CallAction.LeaveCall.INSTANCE, null));
        ArrayList arrayList = new ArrayList();
        for (VideoCallControlAction videoCallControlAction : listQ) {
            if (!callMediaState.isCameraEnabled() && y.d(videoCallControlAction.getCallAction(), CallAction.FlipCamera.INSTANCE)) {
                videoCallControlAction = null;
            }
            if (videoCallControlAction != null) {
                arrayList.add(videoCallControlAction);
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return arrayList;
    }

    @Composable
    public static final List<VideoCallControlAction> buildWithCallControlActions(CallMediaState callMediaState, Composer composer, int i10) {
        y.i(callMediaState, "callMediaState");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-522525647, i10, -1, "cu.todus.android.uiCompose.call.screen.call.components.controls.buildWithCallControlActions (VideoCallControlAction.kt:87)");
        }
        Painter painterPainterResource = PainterResources_androidKt.painterResource(callMediaState.isMicrophoneEnabled() ? R.drawable.mic_on : R.drawable.mic_off, composer, 0);
        Painter painterPainterResource2 = PainterResources_androidKt.painterResource(callMediaState.isCameraEnabled() ? R.drawable.videocam_on : R.drawable.videocam_off, composer, 0);
        Color.Companion companion = Color.INSTANCE;
        long jM5903getWhite0d7_KjU = companion.m5903getWhite0d7_KjU();
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        List<VideoCallControlAction> listQ = w.q(new VideoCallControlAction(painterPainterResource, jM5903getWhite0d7_KjU, materialTheme.getColorScheme(composer, i11).getPrimary(), new CallAction.ToggleMicroPhone(callMediaState.isMicrophoneEnabled()), null), new VideoCallControlAction(painterPainterResource2, companion.m5903getWhite0d7_KjU(), materialTheme.getColorScheme(composer, i11).getPrimary(), new CallAction.ToggleCamera(callMediaState.isCameraEnabled()), null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return listQ;
    }
}
