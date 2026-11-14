package cu.todus.android.utils;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.text.HtmlCompat;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001dR\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcu/todus/android/utils/HTMLHelper;", "", "<init>", "()V", "Landroid/text/SpannableStringBuilder;", "strBuilder", "Landroid/text/style/URLSpan;", "span", "Landroid/content/Context;", "context", "Lua/k0;", "makeLinkClickable", "(Landroid/text/SpannableStringBuilder;Landroid/text/style/URLSpan;Landroid/content/Context;)V", "", "htmlString", "", "isHtml", "(Ljava/lang/String;)Z", "Landroid/widget/TextView;", "text", XHTMLExtension.ELEMENT, "setTextViewHTML", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Lcu/todus/android/utils/HtmlForTextObj;", "getTextViewHTML", "(Ljava/lang/String;Landroid/content/Context;)Lcu/todus/android/utils/HtmlForTextObj;", "getTextFromHTML", "(Ljava/lang/String;)Ljava/lang/String;", "TAG_START", "Ljava/lang/String;", "TAG_END", "TAG_SELF_CLOSING", "HTML_ENTITY", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "htmlPattern", "Ljava/util/regex/Pattern;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HTMLHelper {
    private static final String HTML_ENTITY = "&[a-zA-Z][a-zA-Z0-9]+;";
    private static final String TAG_END = "</\\w+>";
    private static final String TAG_SELF_CLOSING = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>";
    private static final String TAG_START = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>";
    public static final HTMLHelper INSTANCE = new HTMLHelper();
    private static final Pattern htmlPattern = Pattern.compile("(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>.*</\\w+>)|(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>)|(&[a-zA-Z][a-zA-Z0-9]+;)", 32);
    public static final int $stable = 8;

    private HTMLHelper() {
    }

    private final void makeLinkClickable(SpannableStringBuilder strBuilder, final URLSpan span, final Context context) {
        strBuilder.setSpan(new ClickableSpan() { // from class: cu.todus.android.utils.HTMLHelper$makeLinkClickable$clickable$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                y.i(view, "view");
                IntentUtil intentUtil = IntentUtil.INSTANCE;
                Context context2 = context;
                String url = span.getURL();
                y.h(url, "getURL(...)");
                intentUtil.showWeb(context2, url);
            }
        }, strBuilder.getSpanStart(span), strBuilder.getSpanEnd(span), strBuilder.getSpanFlags(span));
        strBuilder.removeSpan(span);
    }

    public final String getTextFromHTML(String html) {
        y.i(html, "html");
        return Html.fromHtml(Html.fromHtml(html).toString()).toString();
    }

    public final HtmlForTextObj getTextViewHTML(String html, Context context) {
        y.i(html, "html");
        y.i(context, "context");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(html, 0);
        y.h(spannedFromHtml, "fromHtml(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class);
        y.f(uRLSpanArr);
        for (URLSpan uRLSpan : uRLSpanArr) {
            y.f(uRLSpan);
            makeLinkClickable(spannableStringBuilder, uRLSpan, context);
        }
        MovementMethod linkMovementMethod = LinkMovementMethod.getInstance();
        y.h(linkMovementMethod, "getInstance(...)");
        return new HtmlForTextObj(spannableStringBuilder, linkMovementMethod);
    }

    public final boolean isHtml(String htmlString) {
        if (htmlString != null) {
            return htmlPattern.matcher(htmlString).find();
        }
        return false;
    }

    public final void setTextViewHTML(TextView text, String html) {
        y.i(text, "text");
        y.i(html, "html");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(html, 0);
        y.h(spannedFromHtml, "fromHtml(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class);
        y.f(uRLSpanArr);
        for (URLSpan uRLSpan : uRLSpanArr) {
            y.f(uRLSpan);
            Context context = text.getContext();
            y.h(context, "getContext(...)");
            makeLinkClickable(spannableStringBuilder, uRLSpan, context);
        }
        text.setText(spannableStringBuilder);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
