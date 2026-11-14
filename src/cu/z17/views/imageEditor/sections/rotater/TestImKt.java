package cu.z17.views.imageEditor.sections.rotater;

import android.content.Context;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MenuKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.muxer.MuxerUtil;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import coil.request.ImageRequest;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a5\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a5\u0010\u0010\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0012²\u0006\f\u0010\u0011\u001a\u00020\n8\nX\u008a\u0084\u0002"}, d2 = {"Lua/k0;", "TutorialContent", "(Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "", "text", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/text/TextStyle;", "style", "", "labelTextRatio", "drawDiagonalLabel-XO-JAsU", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;F)Landroidx/compose/ui/Modifier;", "drawDiagonalLabel", "drawDiagonalShimmerLabel-XO-JAsU", "drawDiagonalShimmerLabel", "progress", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TestImKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TutorialContent(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-64555722);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-64555722, i10, -1, "cu.z17.views.imageEditor.sections.rotater.TutorialContent (TestIm.kt:46)");
            }
            Modifier modifierM10246drawDiagonalShimmerLabelXOJAsU$default = Modifier.INSTANCE;
            Color.Companion companion = Color.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(BackgroundKt.m1205backgroundbw27NRU$default(modifierM10246drawDiagonalShimmerLabelXOJAsU$default, companion.m5892getBlack0d7_KjU(), null, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(20));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ImageRequest.Builder builderData = new ImageRequest.Builder((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).data("https://www.techtoyreviews.com/wp-content/uploads/2020/09/5152094_Cover_PS5.jpg");
            Size size = Size.ORIGINAL;
            AsyncImagePainter asyncImagePainterM9777rememberAsyncImagePainterEHKIwbg = SingletonAsyncImagePainterKt.m9777rememberAsyncImagePainterEHKIwbg(builderData.size(size).build(), null, null, null, 0, null, composerStartRestartGroup, 0, 62);
            Modifier modifierThen = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(modifierM10246drawDiagonalShimmerLabelXOJAsU$default, 0.0f, 1, null), 1.3333334f, false, 2, null).then(asyncImagePainterM9777rememberAsyncImagePainterEHKIwbg.getState() instanceof AsyncImagePainter.State.Success ? m10244drawDiagonalLabelXOJAsU$default(modifierM10246drawDiagonalShimmerLabelXOJAsU$default, "50%", companion.m5900getRed0d7_KjU(), null, 0.0f, 12, null) : modifierM10246drawDiagonalShimmerLabelXOJAsU$default);
            ContentScale.Companion companion3 = ContentScale.INSTANCE;
            ImageKt.Image(asyncImagePainterM9777rememberAsyncImagePainterEHKIwbg, (String) null, modifierThen, (Alignment) null, companion3.getFillBounds(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, LocationRequestCompat.QUALITY_LOW_POWER);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(modifierM10246drawDiagonalShimmerLabelXOJAsU$default, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            AsyncImagePainter asyncImagePainterM9777rememberAsyncImagePainterEHKIwbg2 = SingletonAsyncImagePainterKt.m9777rememberAsyncImagePainterEHKIwbg(new ImageRequest.Builder((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).data("https://i02.appmifile.com/images/2019/06/03/03ab1861-42fe-4137-b7df-2840d9d3a7f5.png").size(size).build(), null, null, null, 0, null, composerStartRestartGroup, 0, 62);
            Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(modifierM10246drawDiagonalShimmerLabelXOJAsU$default, 0.0f, 1, r15), 1.3333334f, false, 2, 0);
            if (asyncImagePainterM9777rememberAsyncImagePainterEHKIwbg2.getState() instanceof AsyncImagePainter.State.Success) {
                modifierM10246drawDiagonalShimmerLabelXOJAsU$default = m10246drawDiagonalShimmerLabelXOJAsU$default(modifierM10246drawDiagonalShimmerLabelXOJAsU$default, "40% OFF", ColorKt.Color(4283215696L), null, 5.0f, 4, null);
            }
            ImageKt.Image(asyncImagePainterM9777rememberAsyncImagePainterEHKIwbg2, (String) null, modifierAspectRatio$default.then(modifierM10246drawDiagonalShimmerLabelXOJAsU$default), (Alignment) null, companion3.getFillBounds(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, LocationRequestCompat.QUALITY_LOW_POWER);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.rotater.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TestImKt.TutorialContent$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TutorialContent$lambda$1(int i10, Composer composer, int i11) {
        TutorialContent(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: drawDiagonalLabel-XO-JAsU, reason: not valid java name */
    public static final Modifier m10243drawDiagonalLabelXOJAsU(Modifier drawDiagonalLabel, final String text, final long j10, final TextStyle style, final float f10) {
        y.i(drawDiagonalLabel, "$this$drawDiagonalLabel");
        y.i(text, "text");
        y.i(style, "style");
        return ComposedModifierKt.composed$default(drawDiagonalLabel, null, new Function3() { // from class: cu.z17.views.imageEditor.sections.rotater.q
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TestImKt.drawDiagonalLabel_XO_JAsU$lambda$7(f10, j10, text, style, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: renamed from: drawDiagonalLabel-XO-JAsU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m10244drawDiagonalLabelXOJAsU$default(Modifier modifier, String str, long j10, TextStyle textStyle, float f10, int i10, Object obj) {
        TextStyle textStyle2;
        if ((i10 & 4) != 0) {
            textStyle2 = new TextStyle(Color.INSTANCE.m5903getWhite0d7_KjU(), TextUnitKt.getSp(18), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (kotlin.jvm.internal.p) null);
        } else {
            textStyle2 = textStyle;
        }
        return m10243drawDiagonalLabelXOJAsU(modifier, str, j10, textStyle2, (i10 & 8) != 0 ? 7.0f : f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier drawDiagonalLabel_XO_JAsU$lambda$7(final float f10, final long j10, final String str, final TextStyle textStyle, Modifier composed, Composer composer, int i10) {
        y.i(composed, "$this$composed");
        composer.startReplaceGroup(1115955654);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1115955654, i10, -1, "cu.z17.views.imageEditor.sections.rotater.drawDiagonalLabel.<anonymous> (TestIm.kt:119)");
        }
        final TextMeasurer textMeasurerRememberTextMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, composer, 0, 1);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = TextMeasurer.m8232measurexDpz5zY$default(textMeasurerRememberTextMeasurer, new AnnotatedString(str, null, 2, null), textStyle, 0, false, 0, null, 0L, null, null, null, false, 2044, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final TextLayoutResult textLayoutResult = (TextLayoutResult) objRememberedValue;
        Modifier modifierClipToBounds = ClipKt.clipToBounds(Modifier.INSTANCE);
        boolean zChangedInstance = composer.changedInstance(textLayoutResult) | composer.changed(f10) | composer.changed(j10) | composer.changed(textMeasurerRememberTextMeasurer) | composer.changed(str) | composer.changed(textStyle);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            Object obj = new Function1() { // from class: cu.z17.views.imageEditor.sections.rotater.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TestImKt.drawDiagonalLabel_XO_JAsU$lambda$7$lambda$6$lambda$5(textLayoutResult, f10, j10, textMeasurerRememberTextMeasurer, str, textStyle, (ContentDrawScope) obj2);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue2 = obj;
        }
        Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(modifierClipToBounds, (Function1) objRememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierDrawWithContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 drawDiagonalLabel_XO_JAsU$lambda$7$lambda$6$lambda$5(TextLayoutResult textLayoutResult, float f10, long j10, TextMeasurer textMeasurer, String str, TextStyle textStyle, ContentDrawScope drawWithContent) throws Throwable {
        long j11;
        DrawContext drawContext;
        y.i(drawWithContent, "$this$drawWithContent");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.mo6334getSizeNHjbRc() >> 32));
        Float.intBitsToFloat((int) (drawWithContent.mo6334getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        long size = textLayoutResult.getSize();
        float f11 = (int) (size >> 32);
        float f12 = f11 * f10;
        float f13 = (int) (size & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        Rect rectM5666Recttz77jQw = RectKt.m5666Recttz77jQw(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - f12)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), androidx.compose.ui.geometry.Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f12)) << 32) | (((long) Float.floatToRawIntBits(1.1f * f13)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        float fSqrt = (float) Math.sqrt(f12 / 2.0f);
        float f14 = fSqrt * fSqrt;
        drawWithContent.drawContent();
        DrawContext drawContext2 = drawWithContent.getDrawContext();
        long jMo6341getSizeNHjbRc = drawContext2.mo6341getSizeNHjbRc();
        drawContext2.getCanvas().save();
        try {
            drawContext2.getTransform().mo6347rotateUv8p0NA(45.0f, Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - (f12 / 2))) << 32) | (((long) Float.floatToRawIntBits(f14)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
            j11 = jMo6341getSizeNHjbRc;
            drawContext = drawContext2;
            try {
                try {
                    DrawScope.CC.M(drawWithContent, j10, rectM5666Recttz77jQw.m5661getTopLeftF1C5BW0(), rectM5666Recttz77jQw.m5659getSizeNHjbRc(), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
                    float left = rectM5666Recttz77jQw.getLeft() + ((f12 - f11) / 2.0f);
                    TextPainterKt.m8241drawTextTPWCCtM(drawWithContent, textMeasurer, str, (496 & 4) != 0 ? Offset.INSTANCE.m5642getZeroF1C5BW0() : Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(rectM5666Recttz77jQw.getTop() + ((rectM5666Recttz77jQw.getBottom() - f13) / 2.0f))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(left) << 32)), (496 & 8) != 0 ? TextStyle.INSTANCE.getDefault() : textStyle, (496 & 16) != 0 ? TextOverflow.INSTANCE.m8749getClipgIe3tQ8() : 0, (496 & 32) != 0, (496 & 64) != 0 ? Integer.MAX_VALUE : 0, (496 & 128) != 0 ? androidx.compose.ui.geometry.Size.INSTANCE.m5703getUnspecifiedNHjbRc() : 0L, (496 & 256) != 0 ? DrawScope.INSTANCE.m6366getDefaultBlendMode0nO6VwU() : 0);
                    drawContext.getCanvas().restore();
                    drawContext.mo6342setSizeuvyYCjk(j11);
                    return k0.f43947a;
                } catch (Throwable th2) {
                    th = th2;
                    drawContext = drawContext;
                    j11 = j11;
                    drawContext.getCanvas().restore();
                    drawContext.mo6342setSizeuvyYCjk(j11);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            j11 = jMo6341getSizeNHjbRc;
            drawContext = drawContext2;
        }
    }

    /* JADX INFO: renamed from: drawDiagonalShimmerLabel-XO-JAsU, reason: not valid java name */
    public static final Modifier m10245drawDiagonalShimmerLabelXOJAsU(Modifier drawDiagonalShimmerLabel, final String text, final long j10, final TextStyle style, final float f10) {
        y.i(drawDiagonalShimmerLabel, "$this$drawDiagonalShimmerLabel");
        y.i(text, "text");
        y.i(style, "style");
        return ComposedModifierKt.composed$default(drawDiagonalShimmerLabel, null, new Function3() { // from class: cu.z17.views.imageEditor.sections.rotater.p
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TestImKt.drawDiagonalShimmerLabel_XO_JAsU$lambda$14(f10, j10, style, text, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: renamed from: drawDiagonalShimmerLabel-XO-JAsU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m10246drawDiagonalShimmerLabelXOJAsU$default(Modifier modifier, String str, long j10, TextStyle textStyle, float f10, int i10, Object obj) {
        TextStyle textStyle2;
        if ((i10 & 4) != 0) {
            textStyle2 = new TextStyle(Color.INSTANCE.m5903getWhite0d7_KjU(), TextUnitKt.getSp(18), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (kotlin.jvm.internal.p) null);
        } else {
            textStyle2 = textStyle;
        }
        return m10245drawDiagonalShimmerLabelXOJAsU(modifier, str, j10, textStyle2, (i10 & 8) != 0 ? 7.0f : f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier drawDiagonalShimmerLabel_XO_JAsU$lambda$14(final float f10, final long j10, final TextStyle textStyle, final String str, Modifier composed, Composer composer, int i10) {
        y.i(composed, "$this$composed");
        composer.startReplaceGroup(1124170547);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1124170547, i10, -1, "cu.z17.views.imageEditor.sections.rotater.drawDiagonalShimmerLabel.<anonymous> (TestIm.kt:190)");
        }
        final TextMeasurer textMeasurerRememberTextMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, composer, 0, 1);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = TextMeasurer.m8232measurexDpz5zY$default(textMeasurerRememberTextMeasurer, new AnnotatedString(str, null, 2, null), textStyle, 0, false, 0, null, 0L, null, null, null, false, 2044, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final TextLayoutResult textLayoutResult = (TextLayoutResult) objRememberedValue;
        final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, composer, 0, 1), 0.0f, 1.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(3000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "amfsl", composer, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
        Modifier modifierClipToBounds = ClipKt.clipToBounds(Modifier.INSTANCE);
        boolean zChangedInstance = composer.changedInstance(textLayoutResult) | composer.changed(f10) | composer.changed(j10) | composer.changed(textStyle) | composer.changed(stateAnimateFloat) | composer.changed(textMeasurerRememberTextMeasurer) | composer.changed(str);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            Object obj = new Function1() { // from class: cu.z17.views.imageEditor.sections.rotater.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TestImKt.drawDiagonalShimmerLabel_XO_JAsU$lambda$14$lambda$13$lambda$12(textLayoutResult, f10, j10, textStyle, stateAnimateFloat, textMeasurerRememberTextMeasurer, str, (ContentDrawScope) obj2);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue2 = obj;
        }
        Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(modifierClipToBounds, (Function1) objRememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierDrawWithContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 drawDiagonalShimmerLabel_XO_JAsU$lambda$14$lambda$13$lambda$12(TextLayoutResult textLayoutResult, float f10, long j10, TextStyle textStyle, State state, TextMeasurer textMeasurer, String str, ContentDrawScope drawWithContent) throws Throwable {
        DrawContext drawContext;
        long j11;
        y.i(drawWithContent, "$this$drawWithContent");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.mo6334getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawWithContent.mo6334getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        long size = textLayoutResult.getSize();
        float f11 = (int) (size >> 32);
        float f12 = f11 * f10;
        float f13 = (int) (size & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        float f14 = 1.1f * f13;
        Rect rectM5666Recttz77jQw = RectKt.m5666Recttz77jQw(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - f12)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), androidx.compose.ui.geometry.Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f12)) << 32) | (((long) Float.floatToRawIntBits(f14)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        float fSqrt = (float) Math.sqrt(f12 / 2.0f);
        float f15 = fSqrt * fSqrt;
        Brush brushM5821linearGradientmHitzGk$default = Brush.Companion.m5821linearGradientmHitzGk$default(Brush.INSTANCE, w.q(Color.m5856boximpl(j10), Color.m5856boximpl(textStyle.m8288getColor0d7_KjU()), Color.m5856boximpl(j10)), Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(drawDiagonalShimmerLabel_XO_JAsU$lambda$14$lambda$9(state) * fIntBitsToFloat2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(drawDiagonalShimmerLabel_XO_JAsU$lambda$14$lambda$9(state) * fIntBitsToFloat)) << 32)), Offset.m5618constructorimpl((((long) Float.floatToRawIntBits((drawDiagonalShimmerLabel_XO_JAsU$lambda$14$lambda$9(state) * fIntBitsToFloat2) + f14)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits((drawDiagonalShimmerLabel_XO_JAsU$lambda$14$lambda$9(state) * fIntBitsToFloat) + f14)) << 32)), 0, 8, (Object) null);
        drawWithContent.drawContent();
        DrawContext drawContext2 = drawWithContent.getDrawContext();
        long jMo6341getSizeNHjbRc = drawContext2.mo6341getSizeNHjbRc();
        drawContext2.getCanvas().save();
        try {
            drawContext2.getTransform().mo6347rotateUv8p0NA(45.0f, Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(f15)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(fIntBitsToFloat - (f12 / 2))) << 32)));
            drawContext = drawContext2;
            try {
                try {
                    DrawScope.CC.L(drawWithContent, brushM5821linearGradientmHitzGk$default, rectM5666Recttz77jQw.m5661getTopLeftF1C5BW0(), rectM5666Recttz77jQw.m5659getSizeNHjbRc(), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
                    TextPainterKt.m8241drawTextTPWCCtM(drawWithContent, textMeasurer, str, (496 & 4) != 0 ? Offset.INSTANCE.m5642getZeroF1C5BW0() : Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(rectM5666Recttz77jQw.getTop() + ((rectM5666Recttz77jQw.getBottom() - f13) / 2.0f))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(rectM5666Recttz77jQw.getLeft() + ((f12 - f11) / 2.0f))) << 32)), (496 & 8) != 0 ? TextStyle.INSTANCE.getDefault() : textStyle, (496 & 16) != 0 ? TextOverflow.INSTANCE.m8749getClipgIe3tQ8() : 0, (496 & 32) != 0, (496 & 64) != 0 ? Integer.MAX_VALUE : 0, (496 & 128) != 0 ? androidx.compose.ui.geometry.Size.INSTANCE.m5703getUnspecifiedNHjbRc() : 0L, (496 & 256) != 0 ? DrawScope.INSTANCE.m6366getDefaultBlendMode0nO6VwU() : 0);
                    drawContext.getCanvas().restore();
                    drawContext.mo6342setSizeuvyYCjk(jMo6341getSizeNHjbRc);
                    return k0.f43947a;
                } catch (Throwable th2) {
                    th = th2;
                    drawContext = drawContext;
                    j11 = jMo6341getSizeNHjbRc;
                    drawContext.getCanvas().restore();
                    drawContext.mo6342setSizeuvyYCjk(j11);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j11 = jMo6341getSizeNHjbRc;
                drawContext.getCanvas().restore();
                drawContext.mo6342setSizeuvyYCjk(j11);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            drawContext = drawContext2;
        }
    }

    private static final float drawDiagonalShimmerLabel_XO_JAsU$lambda$14$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }
}
