package cu.z17.views.videoEditor.sections.filter;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.OptIn;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.BaseGlShaderProgram;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@OptIn(markerClass = {UnstableApi.class})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 !2\u00020\u0001:\u0001!BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001f¨\u0006\""}, d2 = {"Lcu/z17/views/videoEditor/sections/filter/PeriodicVignetteShaderProgram;", "Landroidx/media3/effect/BaseGlShaderProgram;", "Landroid/content/Context;", "context", "", "useHdr", "", "centerX", "centerY", "minInnerRadius", "maxInnerRadius", "outerRadius", "<init>", "(Landroid/content/Context;ZFFFFF)V", "", "inputWidth", "inputHeight", "Landroidx/media3/common/util/Size;", "configure", "(II)Landroidx/media3/common/util/Size;", "inputTexId", "", "presentationTimeUs", "Lua/k0;", "drawFrame", "(IJ)V", "release", "()V", "Landroidx/media3/common/util/GlProgram;", "glProgram", "Landroidx/media3/common/util/GlProgram;", "F", "deltaInnerRadius", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PeriodicVignetteShaderProgram extends BaseGlShaderProgram {
    private static final float DIMMING_PERIOD_US = 5600000.0f;
    private static final String FRAGMENT_SHADER_PATH = "fragment_shader_vignette_es2.glsl";
    private static final String VERTEX_SHADER_PATH = "vertex_shader_copy_es2.glsl";
    private final float deltaInnerRadius;
    private GlProgram glProgram;
    private final float minInnerRadius;
    public static final int $stable = 8;

    public PeriodicVignetteShaderProgram(Context context, boolean z10, float f10, float f11, float f12, float f13, float f14) throws VideoFrameProcessingException {
        super(z10, 1);
        Assertions.checkArgument(f12 <= f13);
        Assertions.checkArgument(f13 <= f14);
        this.minInnerRadius = f12;
        this.deltaInnerRadius = f13 - f12;
        try {
            y.f(context);
            GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
            this.glProgram = glProgram;
            glProgram.setFloatsUniform("uCenter", new float[]{f10, f11});
            GlProgram glProgram2 = this.glProgram;
            if (glProgram2 != null) {
                glProgram2.setFloatsUniform("uOuterRadius", new float[]{f14});
            }
            GlProgram glProgram3 = this.glProgram;
            if (glProgram3 != null) {
                glProgram3.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            }
        } catch (GlUtil.GlException e10) {
            throw new VideoFrameProcessingException(e10);
        } catch (IOException e11) {
            throw new VideoFrameProcessingException(e11);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size configure(int inputWidth, int inputHeight) {
        return new Size(inputWidth, inputHeight);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void drawFrame(int inputTexId, long presentationTimeUs) throws VideoFrameProcessingException {
        try {
            GlProgram glProgram = this.glProgram;
            y.f(glProgram);
            glProgram.use();
            GlProgram glProgram2 = this.glProgram;
            y.f(glProgram2);
            glProgram2.setSamplerTexIdUniform("uTexSampler", inputTexId, 0);
            float fCos = this.minInnerRadius + (this.deltaInnerRadius * (0.5f - (((float) Math.cos(((((long) 2) * presentationTimeUs) * 3.141592653589793d) / ((double) DIMMING_PERIOD_US))) * 0.5f)));
            GlProgram glProgram3 = this.glProgram;
            y.f(glProgram3);
            glProgram3.setFloatsUniform("uInnerRadius", new float[]{fCos});
            GlProgram glProgram4 = this.glProgram;
            y.f(glProgram4);
            glProgram4.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e10) {
            throw new VideoFrameProcessingException(e10, presentationTimeUs);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            GlProgram glProgram = this.glProgram;
            y.f(glProgram);
            glProgram.delete();
        } catch (GlUtil.GlException e10) {
            throw new VideoFrameProcessingException(e10);
        }
    }
}
