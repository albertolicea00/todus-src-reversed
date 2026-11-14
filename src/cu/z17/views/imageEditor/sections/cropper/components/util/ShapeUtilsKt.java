package cu.z17.views.imageEditor.sections.cropper.components.util;

import android.graphics.Matrix;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatio;
import cu.z17.views.imageEditor.sections.cropper.components.util.ShapeUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import rb.k;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\u0014\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aI\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\"\u0010#\u001a1\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b%\u0010&¨\u0006("}, d2 = {"", "cx", "cy", "", "sides", "radius", "Landroidx/compose/ui/graphics/Path;", "createPolygonPath", "(FFIF)Landroidx/compose/ui/graphics/Path;", "degrees", "Landroidx/compose/foundation/shape/GenericShape;", "createPolygonShape", "(IF)Landroidx/compose/foundation/shape/GenericShape;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "aspectRatio", "createRectShape", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;)Landroidx/compose/foundation/shape/GenericShape;", "width", "height", "Lua/k0;", "scaleAndTranslatePath", "(Landroidx/compose/ui/graphics/Path;FF)V", "coefficient", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/Density;", "density", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/graphics/Outline;", "buildOutline-wzdHmys", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;FLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Lkotlin/Pair;", "buildOutline", "calculateSizeAndOffsetFromAspectRatio-cSwnlzA", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;FJ)Lkotlin/Pair;", "calculateSizeAndOffsetFromAspectRatio", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ShapeUtilsKt {
    /* JADX INFO: renamed from: buildOutline-wzdHmys, reason: not valid java name */
    public static final Pair<Offset, Outline> m10235buildOutlinewzdHmys(AspectRatio aspectRatio, float f10, Shape shape, long j10, LayoutDirection layoutDirection, Density density) {
        y.i(aspectRatio, "aspectRatio");
        y.i(shape, "shape");
        y.i(layoutDirection, "layoutDirection");
        y.i(density, "density");
        Pair<Size, Offset> pairM10236calculateSizeAndOffsetFromAspectRatiocSwnlzA = m10236calculateSizeAndOffsetFromAspectRatiocSwnlzA(aspectRatio, f10, j10);
        long jM5700unboximpl = pairM10236calculateSizeAndOffsetFromAspectRatiocSwnlzA.component1().m5700unboximpl();
        long jM5636unboximpl = pairM10236calculateSizeAndOffsetFromAspectRatiocSwnlzA.component2().m5636unboximpl();
        return new Pair<>(Offset.m5615boximpl(jM5636unboximpl), shape.mo1261createOutlinePq9zytI(jM5700unboximpl, layoutDirection, density));
    }

    /* JADX INFO: renamed from: calculateSizeAndOffsetFromAspectRatio-cSwnlzA, reason: not valid java name */
    public static final Pair<Size, Offset> m10236calculateSizeAndOffsetFromAspectRatiocSwnlzA(AspectRatio aspectRatio, float f10, long j10) {
        long jM5686constructorimpl;
        y.i(aspectRatio, "aspectRatio");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float value = aspectRatio.getValue();
        if (y.d(aspectRatio, AspectRatio.INSTANCE.getOriginal())) {
            jM5686constructorimpl = Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f10 * fIntBitsToFloat2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat * f10) << 32));
        } else if (value > 1.0f) {
            float f11 = f10 * fIntBitsToFloat;
            jM5686constructorimpl = Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f11 / value)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f11) << 32));
        } else {
            float f12 = f10 * fIntBitsToFloat2;
            jM5686constructorimpl = Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f12)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(value * f12) << 32));
        }
        float fIntBitsToFloat3 = fIntBitsToFloat - Float.intBitsToFloat((int) (jM5686constructorimpl >> 32));
        float f13 = 2;
        float fIntBitsToFloat4 = (fIntBitsToFloat2 - Float.intBitsToFloat((int) (jM5686constructorimpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) / f13;
        return new Pair<>(Size.m5683boximpl(jM5686constructorimpl), Offset.m5615boximpl(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat3 / f13) << 32))));
    }

    public static final Path createPolygonPath(float f10, float f11, int i10, float f12) {
        double d10 = 6.283185307179586d / ((double) i10);
        Path Path = AndroidPath_androidKt.Path();
        double d11 = f12;
        Path.moveTo(((float) (Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE) * d11)) + f10, ((float) (Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE) * d11)) + f11);
        for (int i11 = 1; i11 < i10; i11++) {
            double d12 = ((double) i11) * d10;
            Path.lineTo(((float) (Math.cos(d12) * d11)) + f10, ((float) (Math.sin(d12) * d11)) + f11);
        }
        Path.close();
        return Path;
    }

    public static final GenericShape createPolygonShape(final int i10, final float f10) {
        return new GenericShape(new Function3() { // from class: j9.g
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ShapeUtilsKt.createPolygonShape$lambda$1(i10, f10, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
            }
        });
    }

    public static /* synthetic */ GenericShape createPolygonShape$default(int i10, float f10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f10 = 0.0f;
        }
        return createPolygonShape(i10, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 createPolygonShape$lambda$1(int i10, float f10, Path GenericShape, Size size, LayoutDirection layoutDirection) {
        y.i(GenericShape, "$this$GenericShape");
        y.i(layoutDirection, "<unused var>");
        float f11 = 2;
        j1.z(GenericShape, createPolygonPath(Float.intBitsToFloat((int) (size.m5700unboximpl() >> 32)) / f11, Float.intBitsToFloat((int) (size.m5700unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / f11, i10, k.i(Float.intBitsToFloat((int) (size.m5700unboximpl() >> 32)), Float.intBitsToFloat((int) (size.m5700unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) / f11), 0L, 2, null);
        Matrix matrix = new Matrix();
        matrix.postRotate(f10, Float.intBitsToFloat((int) (size.m5700unboximpl() >> 32)) / f11, Float.intBitsToFloat((int) (size.m5700unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / f11);
        if (!(GenericShape instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        ((AndroidPath) GenericShape).getInternalPath().transform(matrix);
        return k0.f43947a;
    }

    public static final GenericShape createRectShape(final AspectRatio aspectRatio) {
        y.i(aspectRatio, "aspectRatio");
        return new GenericShape(new Function3() { // from class: j9.h
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ShapeUtilsKt.createRectShape$lambda$2(aspectRatio, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 createRectShape$lambda$2(AspectRatio aspectRatio, Path GenericShape, Size size, LayoutDirection layoutDirection) {
        long jM5686constructorimpl;
        y.i(GenericShape, "$this$GenericShape");
        y.i(layoutDirection, "<unused var>");
        float value = aspectRatio.getValue();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size.m5700unboximpl() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size.m5700unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (y.d(aspectRatio, AspectRatio.INSTANCE.getOriginal())) {
            jM5686constructorimpl = Size.m5686constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
        } else if (value > 1.0f) {
            jM5686constructorimpl = Size.m5686constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat / value)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        } else {
            jM5686constructorimpl = Size.m5686constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(value * fIntBitsToFloat2) << 32));
        }
        j1.A(GenericShape, RectKt.m5666Recttz77jQw(Offset.INSTANCE.m5642getZeroF1C5BW0(), jM5686constructorimpl), null, 2, null);
        return k0.f43947a;
    }

    public static final void scaleAndTranslatePath(Path path, float f10, float f11) {
        y.i(path, "<this>");
        long jM5659getSizeNHjbRc = path.getBounds().m5659getSizeNHjbRc();
        Matrix matrix = new Matrix();
        matrix.postScale(f10 / Float.intBitsToFloat((int) (jM5659getSizeNHjbRc >> 32)), f11 / Float.intBitsToFloat((int) (jM5659getSizeNHjbRc & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        ((AndroidPath) path).getInternalPath().transform(matrix);
        float left = path.getBounds().getLeft();
        path.mo5764translatek4lQ0M(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(-path.getBounds().getTop())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(-left) << 32)));
    }
}
