package cu.z17.views.label;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.extractor.WavUtil;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a=\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001aU\u0010\u0014\u001a \u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000fj\u0004\u0018\u0001`\u00100\u000ej\u0002`\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u001a\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019*\u0016\u0010\u001b\"\b\u0012\u0004\u0012\u00020\u00000\u000f2\b\u0012\u0004\u0012\u00020\u00000\u000f*2\u0010\u001c\"\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001`\u00100\u000e2\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000fj\u0004\u0018\u0001`\u00100\u000e¨\u0006\u001d"}, d2 = {"", "text", "Landroidx/compose/ui/graphics/Color;", "linkColor", "mentionColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "textSize", "Landroidx/compose/ui/text/AnnotatedString;", "messageFormatter-Jy8F4Js", "(Ljava/lang/String;JJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/text/AnnotatedString;", "messageFormatter", "Lle/i;", "matchResult", "Lkotlin/Pair;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Lcu/z17/views/label/StringAnnotation;", "Lcu/z17/views/label/SymbolAnnotation;", "getSymbolAnnotation-f1JAnFk", "(Lle/i;JJJF)Lkotlin/Pair;", "getSymbolAnnotation", "Lle/m;", "symbolPattern$delegate", "Lua/n;", "getSymbolPattern", "()Lle/m;", "symbolPattern", "StringAnnotation", "SymbolAnnotation", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MessageFormatterKt {
    private static final ua.n symbolPattern$delegate = ua.o.a(new lb.a() { // from class: cu.z17.views.label.a
        @Override // lb.a
        public final Object invoke() {
            return MessageFormatterKt.symbolPattern_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: getSymbolAnnotation-f1JAnFk, reason: not valid java name */
    private static final Pair<AnnotatedString, AnnotatedString.Range<String>> m10254getSymbolAnnotationf1JAnFk(le.i iVar, long j10, long j11, long j12, float f10) {
        if (le.f0.u1(iVar.getValue()) == '@') {
            AnnotatedString annotatedStringAnnotatedString$default = AnnotatedStringKt.AnnotatedString$default(iVar.getValue(), new SpanStyle(j10, 0L, FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (kotlin.jvm.internal.p) null), null, 4, null);
            String strSubstring = iVar.getValue().substring(1);
            kotlin.jvm.internal.y.h(strSubstring, "substring(...)");
            return new Pair<>(annotatedStringAnnotatedString$default, new AnnotatedString.Range(strSubstring, iVar.getRange().c(), iVar.getRange().d(), "MENTION"));
        }
        if (le.f0.u1(iVar.getValue()) == '*') {
            return new Pair<>(AnnotatedStringKt.AnnotatedString$default(le.d0.r1(iVar.getValue(), '*'), new SpanStyle(0L, 0L, FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (kotlin.jvm.internal.p) null), null, 4, null), null);
        }
        if (le.f0.u1(iVar.getValue()) == '_') {
            return new Pair<>(AnnotatedStringKt.AnnotatedString$default(le.d0.r1(iVar.getValue(), '_'), new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (kotlin.jvm.internal.p) null), null, 4, null), null);
        }
        if (le.f0.u1(iVar.getValue()) == '~') {
            return new Pair<>(AnnotatedStringKt.AnnotatedString$default(le.d0.r1(iVar.getValue(), '~'), new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getLineThrough(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (kotlin.jvm.internal.p) null), null, 4, null), null);
        }
        if (le.f0.u1(iVar.getValue()) == '`') {
            return new Pair<>(AnnotatedStringKt.AnnotatedString$default(le.d0.r1(iVar.getValue(), '`'), new SpanStyle(0L, TextUnitKt.getSp(f10 - 1), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getMonospace(), (String) null, 0L, BaselineShift.m8554boximpl(BaselineShift.m8555constructorimpl(0.2f)), (TextGeometricTransform) null, (LocaleList) null, j12, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63197, (kotlin.jvm.internal.p) null), null, 4, null), null);
        }
        if (le.f0.u1(iVar.getValue()) == 'h') {
            return new Pair<>(AnnotatedStringKt.AnnotatedString$default(iVar.getValue(), new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (kotlin.jvm.internal.p) null), null, 4, null), new AnnotatedString.Range(iVar.getValue(), iVar.getRange().c(), iVar.getRange().d(), "LINK"));
        }
        if (le.f0.u1(iVar.getValue()) == '#') {
            return new Pair<>(AnnotatedStringKt.AnnotatedString$default(iVar.getValue(), new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (kotlin.jvm.internal.p) null), null, 4, null), new AnnotatedString.Range(iVar.getValue(), iVar.getRange().c(), iVar.getRange().d(), "TAG"));
        }
        if (le.z.x(le.a0.O(iVar.getValue(), "-", "", false, 4, null)) != null) {
            return new Pair<>(AnnotatedStringKt.AnnotatedString$default(iVar.getValue(), new SpanStyle(0L, 0L, FontWeight.INSTANCE.getSemiBold(), FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65523, (kotlin.jvm.internal.p) null), null, 4, null), new AnnotatedString.Range(iVar.getValue(), iVar.getRange().c(), iVar.getRange().d(), "NUMBER"));
        }
        return le.f0.u1(iVar.getValue()) == '/' ? new Pair<>(AnnotatedStringKt.AnnotatedString$default(iVar.getValue(), new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (kotlin.jvm.internal.p) null), null, 4, null), new AnnotatedString.Range(iVar.getValue(), iVar.getRange().c(), iVar.getRange().d(), "COMMAND")) : new Pair<>(new AnnotatedString(iVar.getValue(), null, 2, null), null);
    }

    public static final le.m getSymbolPattern() {
        return (le.m) symbolPattern$delegate.getValue();
    }

    @Composable
    /* JADX INFO: renamed from: messageFormatter-Jy8F4Js, reason: not valid java name */
    public static final AnnotatedString m10255messageFormatterJy8F4Js(String text, long j10, long j11, long j12, float f10, Composer composer, int i10, int i11) {
        kotlin.jvm.internal.y.i(text, "text");
        long jColor = (i11 & 2) != 0 ? ColorKt.Color(4278225100L) : j10;
        long jColor2 = (i11 & 4) != 0 ? ColorKt.Color(4289867551L) : j11;
        long jColor3 = (i11 & 8) != 0 ? ColorKt.Color(4292594635L) : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2023748907, i10, -1, "cu.z17.views.label.messageFormatter (MessageFormatter.kt:52)");
        }
        int iD = 0;
        ke.h<le.i> hVarF = le.m.f(getSymbolPattern(), text, 0, 2, null);
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        for (le.i iVar : hVarF) {
            builder.append(le.f0.y1(text, rb.k.x(iD, iVar.getRange().c())));
            Pair<AnnotatedString, AnnotatedString.Range<String>> pairM10254getSymbolAnnotationf1JAnFk = m10254getSymbolAnnotationf1JAnFk(iVar, jColor2, jColor, jColor3, f10);
            AnnotatedString annotatedStringComponent1 = pairM10254getSymbolAnnotationf1JAnFk.component1();
            AnnotatedString.Range<String> rangeComponent2 = pairM10254getSymbolAnnotationf1JAnFk.component2();
            builder.append(annotatedStringComponent1);
            if (rangeComponent2 != null) {
                builder.addStringAnnotation(rangeComponent2.getTag(), rangeComponent2.component1(), rangeComponent2.getStart(), rangeComponent2.getEnd());
            }
            iD = iVar.getRange().d() + 1;
        }
        if (ke.u.T(hVarF)) {
            builder.append(text);
        } else {
            builder.append(le.f0.y1(text, new rb.f(iD, le.d0.i0(text))));
        }
        AnnotatedString annotatedString = builder.toAnnotatedString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final le.m symbolPattern_delegate$lambda$0() {
        return new le.m("(https?://[^\\s\\t\\n]+)|(`[^`]+`)|(@\\w+)|(#\\w+)|(\\*[\\w]+\\*)|(_[\\w]+_)|(~[\\w]+~)|((?!(^-|.*--|.*-$))(?=.*\\d{4})[\\d-]+)|(/[^\\s\\t\\n/]+)");
    }
}
