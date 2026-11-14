package cu.todus.android.uiCompose.call.screen.call.components.videoRender;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.GlRectDrawer;
import org.webrtc.RendererCommon;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ7\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010 \u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J'\u0010&\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b(\u0010)J'\u0010*\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0016¢\u0006\u0004\b*\u0010'J\u0017\u0010+\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\fH\u0014¢\u0006\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010=\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;¨\u0006>"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/components/videoRender/VideoTextureViewRenderer;", "Landroid/view/TextureView;", "Lorg/webrtc/VideoSink;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lorg/webrtc/VideoFrame;", "videoFrame", "Lua/k0;", "updateFrameData", "(Lorg/webrtc/VideoFrame;)V", "", "getResourceName", "()Ljava/lang/String;", "onFrame", "", "changed", "", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "onLayout", "(ZIIII)V", "Lorg/webrtc/EglBase$Context;", "sharedContext", "Lorg/webrtc/RendererCommon$RendererEvents;", "rendererEvents", "init", "(Lorg/webrtc/EglBase$Context;Lorg/webrtc/RendererCommon$RendererEvents;)V", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "width", "height", "onSurfaceTextureAvailable", "(Landroid/graphics/SurfaceTexture;II)V", "onSurfaceTextureDestroyed", "(Landroid/graphics/SurfaceTexture;)Z", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "(Landroid/graphics/SurfaceTexture;)V", "onDetachedFromWindow", "()V", "resourceName", "Ljava/lang/String;", "Lorg/webrtc/EglRenderer;", "eglRenderer", "Lorg/webrtc/EglRenderer;", "Lorg/webrtc/RendererCommon$RendererEvents;", "Landroid/os/Handler;", "uiThreadHandler", "Landroid/os/Handler;", "isFirstFrameRendered", "Z", "rotatedFrameWidth", "I", "rotatedFrameHeight", "frameRotation", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class VideoTextureViewRenderer extends TextureView implements VideoSink, TextureView.SurfaceTextureListener {
    public static final int $stable = 8;
    private final EglRenderer eglRenderer;
    private int frameRotation;
    private boolean isFirstFrameRendered;
    private RendererCommon.RendererEvents rendererEvents;
    private final String resourceName;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private final Handler uiThreadHandler;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoTextureViewRenderer(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        y.i(context, "context");
    }

    private final String getResourceName() {
        try {
            return getResources().getResourceEntryName(getId()) + ": ";
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    private final void updateFrameData(VideoFrame videoFrame) {
        if (this.isFirstFrameRendered) {
            RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
            if (rendererEvents != null) {
                rendererEvents.onFirstFrameRendered();
            }
            this.isFirstFrameRendered = true;
        }
        if (videoFrame.getRotatedWidth() == this.rotatedFrameWidth && videoFrame.getRotatedHeight() == this.rotatedFrameHeight && videoFrame.getRotation() == this.frameRotation) {
            return;
        }
        this.rotatedFrameWidth = videoFrame.getRotatedWidth();
        this.rotatedFrameHeight = videoFrame.getRotatedHeight();
        this.frameRotation = videoFrame.getRotation();
        this.uiThreadHandler.post(new Runnable() { // from class: cu.todus.android.uiCompose.call.screen.call.components.videoRender.f
            @Override // java.lang.Runnable
            public final void run() {
                VideoTextureViewRenderer.updateFrameData$lambda$0(this.f21222c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateFrameData$lambda$0(VideoTextureViewRenderer videoTextureViewRenderer) {
        RendererCommon.RendererEvents rendererEvents = videoTextureViewRenderer.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFrameResolutionChanged(videoTextureViewRenderer.rotatedFrameWidth, videoTextureViewRenderer.rotatedFrameHeight, videoTextureViewRenderer.frameRotation);
        }
    }

    public final void init(EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents) {
        y.i(sharedContext, "sharedContext");
        y.i(rendererEvents, "rendererEvents");
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.eglRenderer.init(sharedContext, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.eglRenderer.release();
        super.onDetachedFromWindow();
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        y.i(videoFrame, "videoFrame");
        this.eglRenderer.onFrame(videoFrame);
        updateFrameData(videoFrame);
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.eglRenderer.setLayoutAspectRatio((right - left) / (bottom - top));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        y.i(surfaceTexture, "surfaceTexture");
        this.eglRenderer.createEglSurface(surfaceTexture);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        y.i(surfaceTexture, "surfaceTexture");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.eglRenderer.releaseEglSurface(new Runnable() { // from class: cu.todus.android.uiCompose.call.screen.call.components.videoRender.e
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
        y.i(surfaceTexture, "surfaceTexture");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        y.i(surfaceTexture, "surfaceTexture");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTextureViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y.i(context, "context");
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new EglRenderer(resourceName);
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        setSurfaceTextureListener(this);
    }

    public /* synthetic */ VideoTextureViewRenderer(Context context, AttributeSet attributeSet, int i10, p pVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
