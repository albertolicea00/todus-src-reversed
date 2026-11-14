package cu.todus.android.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0000J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\u0000J\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u0000J \u0010\u0011\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\tJ\u0010\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\tJ \u0010\u0013\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tJ\u001e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcu/todus/android/utils/StringMakeup;", "", "input", "", "<init>", "(Ljava/lang/String;)V", "sb", "Landroid/text/Spannable;", "length", "", "getLength", "()I", "strikethrough", TtmlNode.START, TtmlNode.UNDERLINE, "boldify", "italize", "colorize", "color", "mark", "proportionate", "proportion", "", "apply", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StringMakeup {
    public static final int $stable = 8;
    private final Spannable sb;

    public StringMakeup(String input) {
        y.i(input, "input");
        this.sb = new SpannableString(input);
    }

    private final int getLength() {
        return this.sb.length();
    }

    /* JADX INFO: renamed from: apply, reason: from getter */
    public final Spannable getSb() {
        return this.sb;
    }

    public final StringMakeup boldify(int start, int length) {
        this.sb.setSpan(new StyleSpan(1), start, length + start, 33);
        return this;
    }

    public final StringMakeup colorize(int start, int length, @ColorInt int color) {
        this.sb.setSpan(new ForegroundColorSpan(color), start, length + start, 33);
        return this;
    }

    public final StringMakeup italize(int start, int length) {
        this.sb.setSpan(new StyleSpan(2), start, length + start, 33);
        return this;
    }

    public final StringMakeup mark(int start, int length, @ColorInt int color) {
        this.sb.setSpan(new BackgroundColorSpan(color), start, length + start, 33);
        return this;
    }

    public final StringMakeup proportionate(int start, int length, float proportion) {
        this.sb.setSpan(new RelativeSizeSpan(proportion), start, length + start, 33);
        return this;
    }

    public final StringMakeup strikethrough(int start, int length) {
        this.sb.setSpan(new StrikethroughSpan(), start, length + start, 33);
        return this;
    }

    public final StringMakeup underline(int start, int length) {
        this.sb.setSpan(new UnderlineSpan(), start, length + start, 33);
        return this;
    }

    public final StringMakeup boldify() {
        this.sb.setSpan(new StyleSpan(1), 0, getLength(), 33);
        return this;
    }

    public final StringMakeup colorize(@ColorInt int color) {
        this.sb.setSpan(new ForegroundColorSpan(color), 0, getLength(), 33);
        return this;
    }

    public final StringMakeup italize() {
        this.sb.setSpan(new StyleSpan(2), 0, getLength(), 33);
        return this;
    }

    public final StringMakeup mark(int color) {
        this.sb.setSpan(new BackgroundColorSpan(color), 0, getLength(), 33);
        return this;
    }

    public final StringMakeup proportionate(float proportion) {
        this.sb.setSpan(new RelativeSizeSpan(proportion), 0, getLength(), 33);
        return this;
    }

    public final StringMakeup strikethrough() {
        this.sb.setSpan(new StrikethroughSpan(), 0, getLength(), 33);
        return this;
    }

    public final StringMakeup underline() {
        this.sb.setSpan(new UnderlineSpan(), 0, getLength(), 33);
        return this;
    }
}
