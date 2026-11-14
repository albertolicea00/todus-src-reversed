package cu.z17.views.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.OptIn;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.i0;
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
import androidx.p001lifecycle.ViewModelKt;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.m0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\tJ\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\tJ\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\tJ\r\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020#0&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010%R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020+0&8\u0006¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcu/z17/views/camera/Z17CameraViewModel;", "Landroidx/lifecycle/ViewModel;", "", "imagePathToSave", "videoPathToSave", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lua/k0;", "setStateRead", "()V", "", "on", "handleFlashMode", "(Z)V", "Landroidx/camera/view/PreviewView;", "previewView", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "showCamera", "(Landroidx/camera/view/PreviewView;Landroidx/lifecycle/LifecycleOwner;)V", "showVideoCamera", "Landroid/content/Context;", "context", "captureAndSaveImage", "(Landroid/content/Context;)V", "startVideoRecord", "resumeRecord", "pauseRecord", "stopRecord", "cancelRecord", "Ljava/lang/String;", "Lcu/z17/views/camera/Z17CameraModule;", "z17CameraModule", "Lcu/z17/views/camera/Z17CameraModule;", "Lte/b0;", "Lcu/z17/views/camera/CaptureState;", "_captureResult", "Lte/b0;", "Lte/p0;", "captureResult", "Lte/p0;", "getCaptureResult", "()Lte/p0;", "Lcu/z17/views/camera/RecordingState;", "_recordingResult", "recordingResult", "getRecordingResult", "Landroidx/camera/video/Recording;", "recording", "Landroidx/camera/video/Recording;", "getRecording", "()Landroidx/camera/video/Recording;", "setRecording", "(Landroidx/camera/video/Recording;)V", "Landroidx/camera/video/VideoCapture;", "Landroidx/camera/video/Recorder;", "videoCapture", "Landroidx/camera/video/VideoCapture;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17CameraViewModel extends ViewModel {
    public static final int $stable = 8;
    private final b0 _captureResult;
    private final b0 _recordingResult;
    private final p0 captureResult;
    private final String imagePathToSave;
    private Recording recording;
    private final p0 recordingResult;
    private VideoCapture<Recorder> videoCapture;
    private final String videoPathToSave;
    private final Z17CameraModule z17CameraModule;

    /* JADX INFO: renamed from: cu.z17.views.camera.Z17CameraViewModel$captureAndSaveImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.camera.Z17CameraViewModel$captureAndSaveImage$1", f = "Z17CameraViewModel.kt", l = {105}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.z17.views.camera.Z17CameraViewModel$captureAndSaveImage$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.camera.Z17CameraViewModel$captureAndSaveImage$1$1", f = "Z17CameraViewModel.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
        public static final class C02751 extends cb.m implements Function2 {
            int label;
            final /* synthetic */ Z17CameraViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02751(Z17CameraViewModel z17CameraViewModel, ab.e<? super C02751> eVar) {
                super(2, eVar);
                this.this$0 = z17CameraViewModel;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02751(this.this$0, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                ImageCapture.OutputFileOptions outputFileOptionsBuild = new ImageCapture.OutputFileOptions.Builder(new FileOutputStream(new File(this.this$0.imagePathToSave))).build();
                y.h(outputFileOptionsBuild, "build(...)");
                ImageCapture imageCapture = this.this$0.z17CameraModule.getImageCapture();
                Executor backgroundExecutor = Z17CameraModule.INSTANCE.getInstance().getBackgroundExecutor();
                final Z17CameraViewModel z17CameraViewModel = this.this$0;
                imageCapture.takePicture(outputFileOptionsBuild, backgroundExecutor, new ImageCapture.OnImageSavedCallback() { // from class: cu.z17.views.camera.Z17CameraViewModel.captureAndSaveImage.1.1.1
                    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                    public /* synthetic */ void onCaptureProcessProgressed(int i10) {
                        i0.a(this, i10);
                    }

                    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                    public /* synthetic */ void onCaptureStarted() {
                        i0.b(this);
                    }

                    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                    public void onError(ImageCaptureException exception) {
                        y.i(exception, "exception");
                        z17CameraViewModel._captureResult.setValue(CaptureState.ERROR);
                    }

                    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
                        y.i(outputFileResults, "outputFileResults");
                        z17CameraViewModel.z17CameraModule.getProcessCameraProvider().unbindAll();
                        z17CameraViewModel._captureResult.setValue(CaptureState.RESULT);
                    }

                    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                    public /* synthetic */ void onPostviewBitmapAvailable(Bitmap bitmap) {
                        i0.c(this, bitmap);
                    }
                });
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02751) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return Z17CameraViewModel.this.new AnonymousClass1(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                pe.k0 k0VarB = d1.b();
                C02751 c02751 = new C02751(Z17CameraViewModel.this, null);
                this.label = 1;
                if (pe.i.g(k0VarB, c02751, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public Z17CameraViewModel(String imagePathToSave, String videoPathToSave) {
        y.i(imagePathToSave, "imagePathToSave");
        y.i(videoPathToSave, "videoPathToSave");
        this.imagePathToSave = imagePathToSave;
        this.videoPathToSave = videoPathToSave;
        this.z17CameraModule = Z17CameraModule.INSTANCE.getInstance();
        b0 b0VarA = r0.a(CaptureState.NOT_REQUESTED);
        this._captureResult = b0VarA;
        this.captureResult = te.j.b(b0VarA);
        b0 b0VarA2 = r0.a(RecordingState.NOT_REQUESTED);
        this._recordingResult = b0VarA2;
        this.recordingResult = te.j.b(b0VarA2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVideoRecord$lambda$0(Z17CameraViewModel z17CameraViewModel, VideoRecordEvent videoRecordEvent) {
        if (!(videoRecordEvent instanceof VideoRecordEvent.Finalize) || z17CameraViewModel._recordingResult.getValue() == RecordingState.CANCEL) {
            return;
        }
        Uri outputUri = ((VideoRecordEvent.Finalize) videoRecordEvent).getOutputResults().getOutputUri();
        y.h(outputUri, "getOutputUri(...)");
        if (y.d(outputUri, Uri.EMPTY)) {
            return;
        }
        z17CameraViewModel._recordingResult.setValue(RecordingState.RESULT);
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

    public final void captureAndSaveImage(Context context) {
        y.i(context, "context");
        this._captureResult.setValue(CaptureState.SAVING);
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final p0 getCaptureResult() {
        return this.captureResult;
    }

    public final Recording getRecording() {
        return this.recording;
    }

    public final p0 getRecordingResult() {
        return this.recordingResult;
    }

    public final void handleFlashMode(boolean on) {
        if (on) {
            this.z17CameraModule.getImageCapture().setFlashMode(1);
        } else {
            this.z17CameraModule.getImageCapture().setFlashMode(2);
        }
    }

    public final void pauseRecord() {
        this._recordingResult.setValue(RecordingState.PAUSE);
        Recording recording = this.recording;
        if (recording != null) {
            recording.pause();
        }
    }

    public final void resumeRecord() {
        this._recordingResult.setValue(RecordingState.RECORDING);
        Recording recording = this.recording;
        if (recording != null) {
            recording.resume();
        }
    }

    public final void setRecording(Recording recording) {
        this.recording = recording;
    }

    public final void setStateRead() {
        this._captureResult.setValue(CaptureState.NOT_REQUESTED);
        this._recordingResult.setValue(RecordingState.NOT_REQUESTED);
    }

    public final void showCamera(PreviewView previewView, LifecycleOwner lifecycleOwner) {
        y.i(previewView, "previewView");
        y.i(lifecycleOwner, "lifecycleOwner");
        this.z17CameraModule.getPreview().setSurfaceProvider(previewView.getSurfaceProvider());
        try {
            this.z17CameraModule.getProcessCameraProvider().unbindAll();
            this.z17CameraModule.getProcessCameraProvider().bindToLifecycle(lifecycleOwner, this.z17CameraModule.getCameraSelector(), this.z17CameraModule.getPreview(), this.z17CameraModule.getImageAnalysis(), this.z17CameraModule.getImageCapture());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
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
        FileOutputOptions fileOutputOptionsBuild = new FileOutputOptions.Builder(new File(this.videoPathToSave)).build();
        y.h(fileOutputOptionsBuild, "build(...)");
        VideoCapture<Recorder> videoCapture = this.videoCapture;
        Recorder recorder = videoCapture != null ? (Recorder) videoCapture.getOutput() : null;
        y.f(recorder);
        this.recording = recorder.prepareRecording(context, fileOutputOptionsBuild).withAudioEnabled().start(Z17CameraModule.INSTANCE.getInstance().getBackgroundExecutor(), new Consumer() { // from class: cu.z17.views.camera.n
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Z17CameraViewModel.startVideoRecord$lambda$0(this.f29059c, (VideoRecordEvent) obj);
            }
        });
    }

    public final void stopRecord() throws Throwable {
        this._recordingResult.setValue(RecordingState.NOT_REQUESTED);
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
