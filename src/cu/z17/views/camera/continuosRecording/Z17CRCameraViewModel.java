package cu.z17.views.camera.continuosRecording;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.OptIn;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.PreviewView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.util.Consumer;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModel;
import cu.z17.views.camera.RecordingState;
import cu.z17.views.camera.Z17CameraModule;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import te.b0;
import te.j;
import te.p0;
import te.r0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcu/z17/views/camera/continuosRecording/Z17CRCameraViewModel;", "Landroidx/lifecycle/ViewModel;", "", "videoPathToSave", "<init>", "(Ljava/lang/String;)V", "Landroidx/camera/view/PreviewView;", "previewView", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lua/k0;", "showVideoCamera", "(Landroidx/camera/view/PreviewView;Landroidx/lifecycle/LifecycleOwner;)V", "Landroid/content/Context;", "context", "startVideoRecord", "(Landroid/content/Context;)V", "stopRecord", "()V", "flip", "cancelRecord", "Ljava/lang/String;", "Lcu/z17/views/camera/Z17CameraModule;", "z17CameraModule", "Lcu/z17/views/camera/Z17CameraModule;", "Lte/b0;", "Lcu/z17/views/camera/RecordingState;", "_recordingResult", "Lte/b0;", "Lte/p0;", "recordingResult", "Lte/p0;", "getRecordingResult", "()Lte/p0;", "Landroidx/camera/video/Recording;", "recording", "Landroidx/camera/video/Recording;", "Landroidx/camera/video/VideoCapture;", "Landroidx/camera/video/Recorder;", "videoCapture", "Landroidx/camera/video/VideoCapture;", "", "cut", "I", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17CRCameraViewModel extends ViewModel {
    public static final int $stable = 8;
    private final b0 _recordingResult;
    private int cut;
    private Recording recording;
    private final p0 recordingResult;
    private VideoCapture<Recorder> videoCapture;
    private final String videoPathToSave;
    private final Z17CameraModule z17CameraModule;

    public Z17CRCameraViewModel(String videoPathToSave) {
        y.i(videoPathToSave, "videoPathToSave");
        this.videoPathToSave = videoPathToSave;
        this.z17CameraModule = Z17CameraModule.INSTANCE.getInstance();
        b0 b0VarA = r0.a(RecordingState.NOT_REQUESTED);
        this._recordingResult = b0VarA;
        this.recordingResult = j.b(b0VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVideoRecord$lambda$0(Z17CRCameraViewModel z17CRCameraViewModel, VideoRecordEvent videoRecordEvent) {
        if (!(videoRecordEvent instanceof VideoRecordEvent.Finalize) || z17CRCameraViewModel._recordingResult.getValue() == RecordingState.CANCEL) {
            return;
        }
        Uri outputUri = ((VideoRecordEvent.Finalize) videoRecordEvent).getOutputResults().getOutputUri();
        y.h(outputUri, "getOutputUri(...)");
        if (y.d(outputUri, Uri.EMPTY) || z17CRCameraViewModel._recordingResult.getValue() != RecordingState.FLIPPING) {
            return;
        }
        z17CRCameraViewModel._recordingResult.setValue(RecordingState.RESULT);
    }

    public final void cancelRecord() throws Throwable {
        this._recordingResult.setValue(RecordingState.CANCEL);
        Recording recording = this.recording;
        if (recording != null) {
            recording.stop();
        }
        Recording recording2 = this.recording;
        if (recording2 != null) {
            recording2.close();
        }
    }

    public final void flip() {
        this._recordingResult.setValue(RecordingState.FLIPPING);
    }

    public final p0 getRecordingResult() {
        return this.recordingResult;
    }

    public final void showVideoCamera(PreviewView previewView, LifecycleOwner lifecycleOwner) {
        y.i(previewView, "previewView");
        y.i(lifecycleOwner, "lifecycleOwner");
        this.z17CameraModule.getPreview().setSurfaceProvider(previewView.getSurfaceProvider());
        this.videoCapture = this.z17CameraModule.provideVideoCapture();
        try {
            this.z17CameraModule.getProcessCameraProvider().unbindAll();
            this.z17CameraModule.getProcessCameraProvider().bindToLifecycle(lifecycleOwner, this.z17CameraModule.getCameraSelector(), this.z17CameraModule.getPreview(), this.videoCapture);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    @SuppressLint({"MissingPermission"})
    public final void startVideoRecord(Context context) {
        y.i(context, "context");
        this._recordingResult.setValue(RecordingState.RECORDING);
        this.cut++;
        String str = (String) g0.I0(d0.S0(this.videoPathToSave, new String[]{"."}, false, 0, 6, null));
        FileOutputOptions fileOutputOptionsBuild = new FileOutputOptions.Builder(new File(a0.O(this.videoPathToSave, "." + str, "", false, 4, null) + "_" + this.cut + "_." + str)).build();
        y.h(fileOutputOptionsBuild, "build(...)");
        VideoCapture<Recorder> videoCapture = this.videoCapture;
        Recorder recorder = videoCapture != null ? (Recorder) videoCapture.getOutput() : null;
        y.f(recorder);
        this.recording = recorder.prepareRecording(context, fileOutputOptionsBuild).withAudioEnabled().start(Z17CameraModule.INSTANCE.getInstance().getBackgroundExecutor(), new Consumer() { // from class: cu.z17.views.camera.continuosRecording.i
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Z17CRCameraViewModel.startVideoRecord$lambda$0(this.f29018c, (VideoRecordEvent) obj);
            }
        });
    }

    public final void stopRecord() throws Throwable {
        if (this._recordingResult.getValue() != RecordingState.FLIPPING) {
            this._recordingResult.setValue(RecordingState.NOT_REQUESTED);
        }
        Recording recording = this.recording;
        if (recording != null) {
            recording.stop();
        }
        Recording recording2 = this.recording;
        if (recording2 != null) {
            recording2.close();
        }
    }
}
