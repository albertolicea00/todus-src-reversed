package cu.z17.views.videoEditor.sections.filter;

import android.content.Context;
import android.opengl.Matrix;
import androidx.annotation.OptIn;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.effect.BaseGlShaderProgram;
import androidx.media3.effect.GlMatrixTransformation;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.MatrixTransformation;
import androidx.media3.effect.q3;
import androidx.media3.effect.s2;
import androidx.media3.effect.t2;
import cu.z17.views.videoEditor.sections.filter.MatrixTransformationFactory;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@OptIn(markerClass = {UnstableApi.class})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcu/z17/views/videoEditor/sections/filter/MatrixTransformationFactory;", "", "<init>", "()V", "createZoomInTransition", "Landroidx/media3/effect/MatrixTransformation;", "createDizzyCropEffect", "createSpin3dEffect", "Landroidx/media3/effect/GlMatrixTransformation;", "ZOOM_DURATION_SECONDS", "", "DIZZY_CROP_ROTATION_PERIOD_US", "calculateZoomInTransitionMatrix", "Landroid/graphics/Matrix;", "presentationTimeUs", "", "calculateDizzyCropMatrix", "calculate3dSpinMatrix", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MatrixTransformationFactory {
    public static final int $stable = 0;
    private static final float DIZZY_CROP_ROTATION_PERIOD_US = 1500000.0f;
    public static final MatrixTransformationFactory INSTANCE = new MatrixTransformationFactory();
    private static final float ZOOM_DURATION_SECONDS = 2.0f;

    private MatrixTransformationFactory() {
    }

    private final float[] calculate3dSpinMatrix(long presentationTimeUs) {
        float[] fArr = new float[16];
        Matrix.frustumM(fArr, 0, -1.0f, 1.0f, -1.0f, 1.0f, 3.0f, 5.0f);
        Matrix.translateM(fArr, 0, 0.0f, 0.0f, -4.0f);
        Matrix.rotateM(fArr, 0, Util.usToMs(presentationTimeUs) / 10.0f, 0.0f, 1.0f, 0.0f);
        return fArr;
    }

    private final android.graphics.Matrix calculateDizzyCropMatrix(long presentationTimeUs) {
        double d10 = ((presentationTimeUs * ((long) 2)) * 3.141592653589793d) / ((double) DIZZY_CROP_ROTATION_PERIOD_US);
        float fCos = ((float) Math.cos(d10)) * 0.5f;
        float fSin = ((float) Math.sin(d10)) * 0.5f;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postTranslate(fCos, fSin);
        matrix.postScale(2.0f, 2.0f);
        return matrix;
    }

    private final android.graphics.Matrix calculateZoomInTransitionMatrix(long presentationTimeUs) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float fMin = Math.min(1.0f, presentationTimeUs / 2000000.0f);
        matrix.postScale(fMin, fMin);
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Matrix createDizzyCropEffect$lambda$1(long j10) {
        return INSTANCE.calculateDizzyCropMatrix(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] createSpin3dEffect$lambda$2(long j10) {
        return INSTANCE.calculate3dSpinMatrix(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Matrix createZoomInTransition$lambda$0(long j10) {
        return INSTANCE.calculateZoomInTransitionMatrix(j10);
    }

    public final MatrixTransformation createDizzyCropEffect() {
        return new MatrixTransformation() { // from class: u9.b
            @Override // androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ Size configure(int i10, int i11) {
                return t2.a(this, i10, i11);
            }

            @Override // androidx.media3.common.Effect
            public /* synthetic */ long getDurationAfterEffectApplied(long j10) {
                return androidx.media3.common.f.a(this, j10);
            }

            @Override // androidx.media3.effect.MatrixTransformation, androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ float[] getGlMatrixArray(long j10) {
                return q3.a(this, j10);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ int getGlTextureMinFilter() {
                return t2.b(this);
            }

            @Override // androidx.media3.effect.MatrixTransformation
            public final android.graphics.Matrix getMatrix(long j10) {
                return MatrixTransformationFactory.createDizzyCropEffect$lambda$1(j10);
            }

            @Override // androidx.media3.effect.GlEffect
            public /* synthetic */ boolean isNoOp(int i10, int i11) {
                return s2.a(this, i10, i11);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
            public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z10) {
                return t2.c(this, context, z10);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
            public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z10) {
                return toGlShaderProgram(context, z10);
            }
        };
    }

    public final GlMatrixTransformation createSpin3dEffect() {
        return new GlMatrixTransformation() { // from class: u9.c
            @Override // androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ Size configure(int i10, int i11) {
                return t2.a(this, i10, i11);
            }

            @Override // androidx.media3.common.Effect
            public /* synthetic */ long getDurationAfterEffectApplied(long j10) {
                return androidx.media3.common.f.a(this, j10);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation
            public final float[] getGlMatrixArray(long j10) {
                return MatrixTransformationFactory.createSpin3dEffect$lambda$2(j10);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ int getGlTextureMinFilter() {
                return t2.b(this);
            }

            @Override // androidx.media3.effect.GlEffect
            public /* synthetic */ boolean isNoOp(int i10, int i11) {
                return s2.a(this, i10, i11);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
            public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z10) {
                return t2.c(this, context, z10);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
            public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z10) {
                return toGlShaderProgram(context, z10);
            }
        };
    }

    public final MatrixTransformation createZoomInTransition() {
        return new MatrixTransformation() { // from class: u9.d
            @Override // androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ Size configure(int i10, int i11) {
                return t2.a(this, i10, i11);
            }

            @Override // androidx.media3.common.Effect
            public /* synthetic */ long getDurationAfterEffectApplied(long j10) {
                return androidx.media3.common.f.a(this, j10);
            }

            @Override // androidx.media3.effect.MatrixTransformation, androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ float[] getGlMatrixArray(long j10) {
                return q3.a(this, j10);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ int getGlTextureMinFilter() {
                return t2.b(this);
            }

            @Override // androidx.media3.effect.MatrixTransformation
            public final android.graphics.Matrix getMatrix(long j10) {
                return MatrixTransformationFactory.createZoomInTransition$lambda$0(j10);
            }

            @Override // androidx.media3.effect.GlEffect
            public /* synthetic */ boolean isNoOp(int i10, int i11) {
                return s2.a(this, i10, i11);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
            public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z10) {
                return t2.c(this, context, z10);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
            public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z10) {
                return toGlShaderProgram(context, z10);
            }
        };
    }
}
