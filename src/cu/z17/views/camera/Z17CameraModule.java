package cu.z17.views.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import cu.z17.compress.UtilKt;
import cu.z17.singledi.SingletonInitializer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 T2\u00020\u0001:\u0001TB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010)\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\"\u0010*\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010'\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0017\u00106\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010:\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\rR\u0017\u0010=\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0010R\u0017\u0010@\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u0013R\u0017\u0010D\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010$\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lcu/z17/views/camera/Z17CameraModule;", "", "Landroid/content/Context;", "context", "", "initialDefaultFormat", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "provideCameraProvider", "(Landroid/content/Context;)Landroidx/camera/lifecycle/ProcessCameraProvider;", "Landroidx/camera/core/Preview;", "provideCameraPreview", "()Landroidx/camera/core/Preview;", "Landroidx/camera/core/ImageCapture;", "provideImageCapture", "()Landroidx/camera/core/ImageCapture;", "Landroidx/camera/core/ImageAnalysis;", "provideImageAnalysis", "()Landroidx/camera/core/ImageAnalysis;", "Landroidx/camera/video/VideoCapture;", "Landroidx/camera/video/Recorder;", "provideVideoCapture", "()Landroidx/camera/video/VideoCapture;", "Lua/k0;", "changeToFrontCamera", "()V", "changeToBackCamera", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/lang/String;", "getInitialDefaultFormat", "()Ljava/lang/String;", "", "lensFacing", "I", "", "hasFrontCamera", "Z", "hasBackCamera", "canChange", "canUseCamera", "getCanUseCamera", "()Z", "setCanUseCamera", "(Z)V", "Landroidx/camera/core/CameraSelector;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "getCameraSelector", "()Landroidx/camera/core/CameraSelector;", "setCameraSelector", "(Landroidx/camera/core/CameraSelector;)V", "processCameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "getProcessCameraProvider", "()Landroidx/camera/lifecycle/ProcessCameraProvider;", "preview", "Landroidx/camera/core/Preview;", "getPreview", "imageCapture", "Landroidx/camera/core/ImageCapture;", "getImageCapture", "imageAnalysis", "Landroidx/camera/core/ImageAnalysis;", "getImageAnalysis", "Ljava/util/concurrent/Executor;", "backgroundExecutor", "Ljava/util/concurrent/Executor;", "getBackgroundExecutor", "()Ljava/util/concurrent/Executor;", "Landroid/graphics/Bitmap$CompressFormat;", "defaultFormat", "Landroid/graphics/Bitmap$CompressFormat;", "getDefaultFormat", "()Landroid/graphics/Bitmap$CompressFormat;", "setDefaultFormat", "(Landroid/graphics/Bitmap$CompressFormat;)V", "defaultVideoBitrate", "getDefaultVideoBitrate", "()I", "setDefaultVideoBitrate", "(I)V", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17CameraModule {
    private final Executor backgroundExecutor;
    private CameraSelector cameraSelector;
    private boolean canChange;
    private boolean canUseCamera;
    private final Context context;
    private Bitmap.CompressFormat defaultFormat;
    private int defaultVideoBitrate;
    private boolean hasBackCamera;
    private boolean hasFrontCamera;
    private final ImageAnalysis imageAnalysis;
    private final ImageCapture imageCapture;
    private final String initialDefaultFormat;
    private int lensFacing;
    private final Preview preview;
    private final ProcessCameraProvider processCameraProvider;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/z17/views/camera/Z17CameraModule$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/z17/views/camera/Z17CameraModule;", "<init>", "()V", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<Z17CameraModule> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public Z17CameraModule(Context context, String initialDefaultFormat) throws ExecutionException, InterruptedException {
        y.i(context, "context");
        y.i(initialDefaultFormat, "initialDefaultFormat");
        this.context = context;
        this.initialDefaultFormat = initialDefaultFormat;
        this.hasFrontCamera = true;
        this.hasBackCamera = true;
        this.canChange = true;
        this.canUseCamera = true;
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(this.lensFacing).build();
        y.h(cameraSelectorBuild, "build(...)");
        this.cameraSelector = cameraSelectorBuild;
        Executor mainExecutor = ContextCompat.getMainExecutor(context);
        y.h(mainExecutor, "getMainExecutor(...)");
        this.backgroundExecutor = mainExecutor;
        this.defaultVideoBitrate = 1000000;
        ProcessCameraProvider processCameraProviderProvideCameraProvider = provideCameraProvider(context);
        this.processCameraProvider = processCameraProviderProvideCameraProvider;
        if (!processCameraProviderProvideCameraProvider.hasCamera(this.cameraSelector)) {
            this.canChange = false;
            this.hasFrontCamera = false;
        }
        changeToBackCamera();
        if (!processCameraProviderProvideCameraProvider.hasCamera(this.cameraSelector)) {
            this.canChange = false;
            this.hasBackCamera = false;
            if (this.hasFrontCamera) {
                changeToFrontCamera();
            }
        }
        if (!this.hasFrontCamera && !this.hasBackCamera) {
            this.canUseCamera = false;
        }
        this.preview = provideCameraPreview();
        this.imageCapture = provideImageCapture();
        this.imageAnalysis = provideImageAnalysis();
        this.defaultFormat = UtilKt.compressFormat(initialDefaultFormat);
    }

    private final Preview provideCameraPreview() {
        ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setResolutionStrategy(new ResolutionStrategy(new Size(1080, 1920), 3)).build();
        y.h(resolutionSelectorBuild, "build(...)");
        Preview previewBuild = new Preview.Builder().setResolutionSelector(resolutionSelectorBuild).build();
        y.h(previewBuild, "build(...)");
        return previewBuild;
    }

    private final ProcessCameraProvider provideCameraProvider(Context context) throws ExecutionException, InterruptedException {
        Object obj = ProcessCameraProvider.INSTANCE.getInstance(context).get();
        y.h(obj, "get(...)");
        return (ProcessCameraProvider) obj;
    }

    private final ImageAnalysis provideImageAnalysis() {
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setOutputImageFormat(2).setBackpressureStrategy(0).build();
        y.h(imageAnalysisBuild, "build(...)");
        return imageAnalysisBuild;
    }

    private final ImageCapture provideImageCapture() {
        ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setResolutionStrategy(new ResolutionStrategy(new Size(1080, 1920), 3)).build();
        y.h(resolutionSelectorBuild, "build(...)");
        ImageCapture imageCaptureBuild = new ImageCapture.Builder().setResolutionSelector(resolutionSelectorBuild).setJpegQuality(70).setCaptureMode(1).setFlashMode(1).build();
        y.h(imageCaptureBuild, "build(...)");
        return imageCaptureBuild;
    }

    public final void changeToBackCamera() {
        if (this.canChange) {
            this.lensFacing = 1;
        }
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(this.lensFacing).build();
        y.h(cameraSelectorBuild, "build(...)");
        this.cameraSelector = cameraSelectorBuild;
    }

    public final void changeToFrontCamera() {
        if (this.canChange) {
            this.lensFacing = 0;
        }
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(this.lensFacing).build();
        y.h(cameraSelectorBuild, "build(...)");
        this.cameraSelector = cameraSelectorBuild;
    }

    public final Executor getBackgroundExecutor() {
        return this.backgroundExecutor;
    }

    public final CameraSelector getCameraSelector() {
        return this.cameraSelector;
    }

    public final boolean getCanUseCamera() {
        return this.canUseCamera;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Bitmap.CompressFormat getDefaultFormat() {
        return this.defaultFormat;
    }

    public final int getDefaultVideoBitrate() {
        return this.defaultVideoBitrate;
    }

    public final ImageAnalysis getImageAnalysis() {
        return this.imageAnalysis;
    }

    public final ImageCapture getImageCapture() {
        return this.imageCapture;
    }

    public final String getInitialDefaultFormat() {
        return this.initialDefaultFormat;
    }

    public final Preview getPreview() {
        return this.preview;
    }

    public final ProcessCameraProvider getProcessCameraProvider() {
        return this.processCameraProvider;
    }

    public final VideoCapture<Recorder> provideVideoCapture() {
        Recorder recorderBuild = new Recorder.Builder().setTargetVideoEncodingBitRate(this.defaultVideoBitrate).setExecutor(Executors.newSingleThreadExecutor()).setQualitySelector(QualitySelector.from(Quality.HD)).build();
        y.h(recorderBuild, "build(...)");
        VideoCapture<Recorder> videoCaptureWithOutput = VideoCapture.withOutput(recorderBuild);
        y.h(videoCaptureWithOutput, "withOutput(...)");
        return videoCaptureWithOutput;
    }

    public final void setCameraSelector(CameraSelector cameraSelector) {
        y.i(cameraSelector, "<set-?>");
        this.cameraSelector = cameraSelector;
    }

    public final void setCanUseCamera(boolean z10) {
        this.canUseCamera = z10;
    }

    public final void setDefaultFormat(Bitmap.CompressFormat compressFormat) {
        this.defaultFormat = compressFormat;
    }

    public final void setDefaultVideoBitrate(int i10) {
        this.defaultVideoBitrate = i10;
    }

    public /* synthetic */ Z17CameraModule(Context context, String str, int i10, p pVar) {
        this(context, (i10 & 2) != 0 ? "webp" : str);
    }
}
