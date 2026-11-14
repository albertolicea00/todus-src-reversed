package cu.todus.android.uiCompose.theme;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.Typography;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import cu.todus.android.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"appTypography", "Landroidx/compose/material3/Typography;", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "appTypographyBig", "statusFonts", "", "", "getStatusFonts", "()Ljava/util/List;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TypeKt {
    private static final List<Integer> statusFonts = w.q(Integer.valueOf(R.font.roboto_medium), Integer.valueOf(R.font.dosis_semibold), Integer.valueOf(R.font.barlow_condensed_medium), Integer.valueOf(R.font.chivo_mono_medium), Integer.valueOf(R.font.montserrat_alternates_medium));

    public static final Typography appTypography(ColorScheme colorScheme) {
        y.i(colorScheme, "colorScheme");
        FontFamily.Companion companion = FontFamily.INSTANCE;
        SystemFontFamily systemFontFamily = companion.getDefault();
        FontWeight.Companion companion2 = FontWeight.INSTANCE;
        FontWeight normal = companion2.getNormal();
        TextStyle textStyle = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(12), normal, (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily2 = companion.getDefault();
        FontWeight normal2 = companion2.getNormal();
        TextStyle textStyle2 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(14), normal2, (FontStyle) null, (FontSynthesis) null, systemFontFamily2, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily3 = companion.getDefault();
        FontWeight normal3 = companion2.getNormal();
        TextStyle textStyle3 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(17), normal3, (FontStyle) null, (FontSynthesis) null, systemFontFamily3, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily4 = companion.getDefault();
        FontWeight bold = companion2.getBold();
        TextStyle textStyle4 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(20), bold, (FontStyle) null, (FontSynthesis) null, systemFontFamily4, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily5 = companion.getDefault();
        FontWeight bold2 = companion2.getBold();
        TextStyle textStyle5 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(22), bold2, (FontStyle) null, (FontSynthesis) null, systemFontFamily5, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily6 = companion.getDefault();
        FontWeight bold3 = companion2.getBold();
        TextStyle textStyle6 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(24), bold3, (FontStyle) null, (FontSynthesis) null, systemFontFamily6, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily7 = companion.getDefault();
        FontWeight extraLight = companion2.getExtraLight();
        TextStyle textStyle7 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(14), extraLight, (FontStyle) null, (FontSynthesis) null, systemFontFamily7, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily8 = companion.getDefault();
        FontWeight extraLight2 = companion2.getExtraLight();
        TextStyle textStyle8 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(16), extraLight2, (FontStyle) null, (FontSynthesis) null, systemFontFamily8, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily9 = companion.getDefault();
        FontWeight extraLight3 = companion2.getExtraLight();
        return new Typography(null, null, null, null, null, null, textStyle6, textStyle5, textStyle4, textStyle3, textStyle2, textStyle, new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(18), extraLight3, (FontStyle) null, (FontSynthesis) null, systemFontFamily9, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null), textStyle8, textStyle7, 63, null);
    }

    public static final Typography appTypographyBig(ColorScheme colorScheme) {
        y.i(colorScheme, "colorScheme");
        FontFamily.Companion companion = FontFamily.INSTANCE;
        SystemFontFamily systemFontFamily = companion.getDefault();
        FontWeight.Companion companion2 = FontWeight.INSTANCE;
        FontWeight normal = companion2.getNormal();
        TextStyle textStyle = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(16), normal, (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily2 = companion.getDefault();
        FontWeight normal2 = companion2.getNormal();
        TextStyle textStyle2 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(18), normal2, (FontStyle) null, (FontSynthesis) null, systemFontFamily2, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily3 = companion.getDefault();
        FontWeight normal3 = companion2.getNormal();
        TextStyle textStyle3 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(21), normal3, (FontStyle) null, (FontSynthesis) null, systemFontFamily3, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily4 = companion.getDefault();
        FontWeight bold = companion2.getBold();
        TextStyle textStyle4 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(24), bold, (FontStyle) null, (FontSynthesis) null, systemFontFamily4, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily5 = companion.getDefault();
        FontWeight bold2 = companion2.getBold();
        TextStyle textStyle5 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(26), bold2, (FontStyle) null, (FontSynthesis) null, systemFontFamily5, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily6 = companion.getDefault();
        FontWeight bold3 = companion2.getBold();
        TextStyle textStyle6 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(28), bold3, (FontStyle) null, (FontSynthesis) null, systemFontFamily6, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily7 = companion.getDefault();
        FontWeight extraLight = companion2.getExtraLight();
        TextStyle textStyle7 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(18), extraLight, (FontStyle) null, (FontSynthesis) null, systemFontFamily7, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily8 = companion.getDefault();
        FontWeight extraLight2 = companion2.getExtraLight();
        TextStyle textStyle8 = new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(20), extraLight2, (FontStyle) null, (FontSynthesis) null, systemFontFamily8, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null);
        SystemFontFamily systemFontFamily9 = companion.getDefault();
        FontWeight extraLight3 = companion2.getExtraLight();
        return new Typography(null, null, null, null, null, null, textStyle6, textStyle5, textStyle4, textStyle3, textStyle2, textStyle, new TextStyle(colorScheme.getOnBackground(), TextUnitKt.getSp(22), extraLight3, (FontStyle) null, (FontSynthesis) null, systemFontFamily9, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777048, (p) null), textStyle8, textStyle7, 63, null);
    }

    public static final List<Integer> getStatusFonts() {
        return statusFonts;
    }
}
