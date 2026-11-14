package cu.z17.views.imageEditor.sections.cropper.components.util;

import android.graphics.Canvas;
import androidx.compose.material.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatio;
import cu.z17.views.imageEditor.sections.cropper.components.util.DrawScopeUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a)\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u000f\u001a\u00020\u0007*\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u000f\u001a\u00020\u0011*\u00020\u00112\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u000f\u0010\u0012\u001aE\u0010\u001e\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u001f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Rect;", "rect", "", "strokeWidth", "Landroidx/compose/ui/graphics/Color;", "color", "Lua/k0;", "drawGrid-g2O1Hgs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/geometry/Rect;FJ)V", "drawGrid", "drawChecker", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "Lkotlin/Function1;", BlockContactsIQ.ELEMENT, "drawWithLayer", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "aspectRatio", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/graphics/ImageBitmap;", "dstBitmap", "coefficient", "drawOutlineWithBlendModeAndChecker-PE3pjmc", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/ImageBitmap;FJ)Landroidx/compose/ui/Modifier;", "drawOutlineWithBlendModeAndChecker", "drawBlockWithCheckerAndLayer", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/ImageBitmap;Lkotlin/jvm/functions/Function1;)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DrawScopeUtilsKt {
    public static final void drawBlockWithCheckerAndLayer(DrawScope drawScope, final ImageBitmap dstBitmap, final Function1 block) {
        y.i(drawScope, "<this>");
        y.i(dstBitmap, "dstBitmap");
        y.i(block, "block");
        drawChecker(drawScope);
        drawWithLayer(drawScope, new Function1() { // from class: j9.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DrawScopeUtilsKt.drawBlockWithCheckerAndLayer$lambda$7(block, dstBitmap, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 drawBlockWithCheckerAndLayer$lambda$7(Function1 function1, ImageBitmap imageBitmap, DrawScope drawWithLayer) {
        y.i(drawWithLayer, "$this$drawWithLayer");
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (drawWithLayer.mo6334getSizeNHjbRc() >> 32));
        int iIntBitsToFloat2 = (int) Float.intBitsToFloat((int) (drawWithLayer.mo6334getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        function1.invoke(drawWithLayer);
        DrawScope.CC.B(drawWithLayer, imageBitmap, 0L, 0L, 0L, IntSize.m8985constructorimpl((((long) iIntBitsToFloat2) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) iIntBitsToFloat) << 32)), 0.0f, null, null, BlendMode.INSTANCE.m5810getSrcIn0nO6VwU(), 0, 750, null);
        return k0.f43947a;
    }

    public static final void drawChecker(DrawScope drawScope) {
        int i10;
        int i11;
        int i12;
        int i13;
        DrawScope drawScope2 = drawScope;
        y.i(drawScope2, "<this>");
        char c10 = ' ';
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope2.mo6334getSizeNHjbRc() >> 32));
        long jMo6334getSizeNHjbRc = drawScope2.mo6334getSizeNHjbRc();
        long j10 = MuxerUtil.UNSIGNED_INT_MAX_VALUE;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo6334getSizeNHjbRc & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float f10 = 10;
        float fMo1345toPx0680j_4 = drawScope2.mo1345toPx0680j_4(Dp.m8823constructorimpl(f10));
        float fMo1345toPx0680j_5 = drawScope2.mo1345toPx0680j_4(Dp.m8823constructorimpl(f10));
        int i14 = (int) (fIntBitsToFloat / fMo1345toPx0680j_4);
        int i15 = (int) (fIntBitsToFloat2 / fMo1345toPx0680j_5);
        if (i15 < 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            if (i14 >= 0) {
                int i17 = 0;
                while (true) {
                    long jM5898getLightGray0d7_KjU = (i17 + i16) % 2 == 1 ? Color.INSTANCE.m5898getLightGray0d7_KjU() : Color.INSTANCE.m5903getWhite0d7_KjU();
                    long jM5618constructorimpl = Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(i16 * fMo1345toPx0680j_5)) & j10) | (((long) Float.floatToRawIntBits(i17 * fMo1345toPx0680j_4)) << c10));
                    long jM5686constructorimpl = Size.m5686constructorimpl((((long) Float.floatToRawIntBits(fMo1345toPx0680j_4)) << c10) | (((long) Float.floatToRawIntBits(fMo1345toPx0680j_5)) & j10));
                    int i18 = i17;
                    i13 = i15;
                    i11 = i16;
                    i10 = i14;
                    DrawScope.CC.M(drawScope2, jM5898getLightGray0d7_KjU, jM5618constructorimpl, jM5686constructorimpl, 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
                    if (i18 == i10) {
                        break;
                    }
                    i17 = i18 + 1;
                    drawScope2 = drawScope;
                    i14 = i10;
                    i16 = i11;
                    i15 = i13;
                    c10 = ' ';
                    j10 = MuxerUtil.UNSIGNED_INT_MAX_VALUE;
                }
                i12 = i13;
            } else {
                i10 = i14;
                i11 = i16;
                i12 = i15;
            }
            if (i11 == i12) {
                return;
            }
            i16 = i11 + 1;
            i15 = i12;
            i14 = i10;
            c10 = ' ';
            j10 = MuxerUtil.UNSIGNED_INT_MAX_VALUE;
            drawScope2 = drawScope;
        }
    }

    /* JADX INFO: renamed from: drawGrid-g2O1Hgs, reason: not valid java name */
    public static final void m10231drawGridg2O1Hgs(DrawScope drawScope, Rect rect, float f10, long j10) {
        DrawScope drawGrid = drawScope;
        y.i(drawGrid, "$this$drawGrid");
        Rect rect2 = rect;
        y.i(rect2, "rect");
        int i10 = 3;
        float f11 = 3;
        float right = (rect2.getRight() - rect2.getLeft()) / f11;
        float bottom = (rect2.getBottom() - rect2.getTop()) / f11;
        int i11 = 1;
        while (i11 < i10) {
            float left = rect2.getLeft();
            float f12 = i11 * bottom;
            DrawScope.CC.E(drawGrid, j10, Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(rect2.getTop() + f12)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(left) << 32)), Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(rect2.getRight())) << 32) | (((long) Float.floatToRawIntBits(rect2.getTop() + f12)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), f10, 0, null, 0.0f, null, 0, 496, null);
            i11++;
            drawGrid = drawScope;
            rect2 = rect;
            i10 = i10;
            right = right;
        }
        float f13 = right;
        int i12 = i10;
        for (int i13 = 1; i13 < i12; i13++) {
            float f14 = i13 * f13;
            long jM5618constructorimpl = Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(rect.getLeft() + f14)) << 32) | (((long) Float.floatToRawIntBits(rect.getTop())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            float left2 = rect.getLeft() + f14;
            DrawScope.CC.E(drawScope, j10, jM5618constructorimpl, Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(rect.getBottom())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(left2) << 32)), f10, 0, null, 0.0f, null, 0, 496, null);
        }
    }

    /* JADX INFO: renamed from: drawOutlineWithBlendModeAndChecker-PE3pjmc, reason: not valid java name */
    public static final Modifier m10232drawOutlineWithBlendModeAndCheckerPE3pjmc(Modifier drawOutlineWithBlendModeAndChecker, final AspectRatio aspectRatio, final Shape shape, final Density density, final ImageBitmap dstBitmap, final float f10, final long j10) {
        y.i(drawOutlineWithBlendModeAndChecker, "$this$drawOutlineWithBlendModeAndChecker");
        y.i(aspectRatio, "aspectRatio");
        y.i(shape, "shape");
        y.i(density, "density");
        y.i(dstBitmap, "dstBitmap");
        return drawOutlineWithBlendModeAndChecker.then(DrawModifierKt.drawWithCache(Modifier.INSTANCE, new Function1() { // from class: j9.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DrawScopeUtilsKt.drawOutlineWithBlendModeAndChecker_PE3pjmc$lambda$6(aspectRatio, f10, shape, density, dstBitmap, j10, (CacheDrawScope) obj);
            }
        }));
    }

    /* JADX INFO: renamed from: drawOutlineWithBlendModeAndChecker-PE3pjmc$default, reason: not valid java name */
    public static /* synthetic */ Modifier m10233drawOutlineWithBlendModeAndCheckerPE3pjmc$default(Modifier modifier, AspectRatio aspectRatio, Shape shape, Density density, ImageBitmap imageBitmap, float f10, long j10, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            f10 = 0.9f;
        }
        return m10232drawOutlineWithBlendModeAndCheckerPE3pjmc(modifier, aspectRatio, shape, density, imageBitmap, f10, (i10 & 32) != 0 ? Color.INSTANCE.m5900getRed0d7_KjU() : j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawOutlineWithBlendModeAndChecker_PE3pjmc$lambda$6(AspectRatio aspectRatio, float f10, Shape shape, Density density, final ImageBitmap imageBitmap, final long j10, CacheDrawScope drawWithCache) {
        y.i(drawWithCache, "$this$drawWithCache");
        Pair<Offset, Outline> pairM10235buildOutlinewzdHmys = ShapeUtilsKt.m10235buildOutlinewzdHmys(aspectRatio, f10, shape, drawWithCache.m5441getSizeNHjbRc(), drawWithCache.getLayoutDirection(), density);
        final long jM5636unboximpl = pairM10235buildOutlinewzdHmys.component1().m5636unboximpl();
        final Outline outlineComponent2 = pairM10235buildOutlinewzdHmys.component2();
        return drawWithCache.onDrawWithContent(new Function1() { // from class: j9.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DrawScopeUtilsKt.drawOutlineWithBlendModeAndChecker_PE3pjmc$lambda$6$lambda$5(imageBitmap, jM5636unboximpl, outlineComponent2, j10, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 drawOutlineWithBlendModeAndChecker_PE3pjmc$lambda$6$lambda$5(ImageBitmap imageBitmap, final long j10, final Outline outline, final long j11, ContentDrawScope onDrawWithContent) {
        y.i(onDrawWithContent, "$this$onDrawWithContent");
        drawBlockWithCheckerAndLayer(onDrawWithContent, imageBitmap, new Function1() { // from class: j9.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DrawScopeUtilsKt.drawOutlineWithBlendModeAndChecker_PE3pjmc$lambda$6$lambda$5$lambda$4(j10, outline, j11, (DrawScope) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 drawOutlineWithBlendModeAndChecker_PE3pjmc$lambda$6$lambda$5$lambda$4(long j10, Outline outline, long j11, DrawScope drawBlockWithCheckerAndLayer) {
        y.i(drawBlockWithCheckerAndLayer, "$this$drawBlockWithCheckerAndLayer");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        drawBlockWithCheckerAndLayer.getDrawContext().getTransform().translate(fIntBitsToFloat, fIntBitsToFloat2);
        try {
            OutlineKt.m6118drawOutlinewDX37Ww$default(drawBlockWithCheckerAndLayer, outline, j11, 0.0f, null, null, 0, 60, null);
            return k0.f43947a;
        } finally {
            drawBlockWithCheckerAndLayer.getDrawContext().getTransform().translate(-fIntBitsToFloat, -fIntBitsToFloat2);
        }
    }

    public static final void drawWithLayer(DrawScope drawScope, Function1 block) {
        y.i(drawScope, "<this>");
        y.i(block, "block");
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas());
        int iSaveLayer = nativeCanvas.saveLayer(null, null);
        block.invoke(drawScope);
        nativeCanvas.restoreToCount(iSaveLayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 drawWithLayer$lambda$2(final Function1 function1, ContentDrawScope drawWithContent) {
        y.i(drawWithContent, "$this$drawWithContent");
        drawWithLayer(drawWithContent, new Function1() { // from class: j9.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DrawScopeUtilsKt.drawWithLayer$lambda$2$lambda$1(function1, (DrawScope) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 drawWithLayer$lambda$2$lambda$1(Function1 function1, DrawScope drawWithLayer) {
        y.i(drawWithLayer, "$this$drawWithLayer");
        function1.invoke(drawWithLayer);
        return k0.f43947a;
    }

    public static final Modifier drawWithLayer(Modifier modifier, final Function1 block) {
        y.i(modifier, "<this>");
        y.i(block, "block");
        return modifier.then(DrawModifierKt.drawWithContent(Modifier.INSTANCE, new Function1() { // from class: j9.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DrawScopeUtilsKt.drawWithLayer$lambda$2(block, (ContentDrawScope) obj);
            }
        }));
    }
}
