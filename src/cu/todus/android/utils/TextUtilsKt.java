package cu.todus.android.utils;

import android.util.Log;
import androidx.core.text.HtmlCompat;
import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;
import ke.u;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import le.d0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0007*\u00020\u0001¢\u0006\u0004\b\n\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\u0007*\u00020\u0001¢\u0006\u0004\b\u000b\u0010\t\u001a\u0011\u0010\r\u001a\u00020\u0001*\u00020\f¢\u0006\u0004\b\r\u0010\u000e\"\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u00018\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "", "unaccent", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "getFirstLink", "(Ljava/lang/String;)Ljava/lang/String;", "removeHtmlTags", "", "hasMarkdown", "(Ljava/lang/String;)Z", "hasLatex", "hasHtml", "", "get256Hash", "(Ljava/lang/Object;)Ljava/lang/String;", "Lle/m;", "REGEX_UNACCENT", "Lle/m;", "getREGEX_UNACCENT", "()Lle/m;", "ITEM_LINK_TAG", "Ljava/lang/String;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TextUtilsKt {
    public static final String ITEM_LINK_TAG = "link_tag";
    private static final le.m REGEX_UNACCENT = new le.m("\\p{InCombiningDiacriticalMarks}+");

    public static final String get256Hash(Object obj) {
        y.i(obj, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = obj.toString().getBytes(le.c.f37236b);
        y.h(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Base64Util base64Util = Base64Util.INSTANCE;
        y.f(bArrDigest);
        return d0.q1(Base64Util.encodedMessage$default(base64Util, bArrDigest, 0, 2, (Object) null)).toString();
    }

    public static final String getFirstLink(String str) {
        y.i(str, "<this>");
        List listA0 = u.a0(u.Q(le.m.f(new le.m("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"), str, 0, 2, null), new Function1() { // from class: cu.todus.android.utils.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextUtilsKt.getFirstLink$lambda$0((le.i) obj);
            }
        }));
        if (!listA0.isEmpty()) {
            Log.i(ITEM_LINK_TAG, "Links founded: " + listA0.size() + " " + g0.y0(listA0));
        }
        if (listA0.isEmpty()) {
            return null;
        }
        return (String) listA0.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getFirstLink$lambda$0(le.i it) {
        y.i(it, "it");
        return it.getValue();
    }

    public static final le.m getREGEX_UNACCENT() {
        return REGEX_UNACCENT;
    }

    public static final boolean hasHtml(String str) {
        y.i(str, "<this>");
        return Pattern.compile("\\<(.*?)\\>").matcher(str).find();
    }

    public static final boolean hasLatex(String str) {
        y.i(str, "<this>");
        return Pattern.compile("(?s)\\\\\\[.*?\\\\]|\\$\\$.*?\\$\\$|\\\\\\(.*?\\\\\\)").matcher(str).find();
    }

    public static final boolean hasMarkdown(String str) {
        y.i(str, "<this>");
        if (!d0.a0(str, "# ", false, 2, null)) {
            return false;
        }
        while (true) {
            boolean z10 = false;
            for (String str2 : w.q("/(#+)(.*)/", "/\\[([^\\[]+)\\]\\(([^\\)]+)\\)/", "/(\\*\\*|__)(.*?)\\1/", "/<\\/blockquote><blockquote>/", "/(\\*|_)(.*?)\\1/", "/\\~\\~(.*?)\\~\\~/", "/\\:\"(.*?)\"\\:/", "/`(.*?)`/", "/\n\\*(.*)/", "/\n[0-9]+\\.(.*)/", "/\n(&gt;|\\>)(.*)/", "/\n-{5,}/", "/\n([^\n]+)\n/", "/<\\/ul>\\s?<ul>/", "/<\\/ol>\\s?<ol>/")) {
                if (z10 || Pattern.compile("").matcher(str).find()) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public static final String removeHtmlTags(String str) {
        y.i(str, "<this>");
        return hasHtml(str) ? HtmlCompat.fromHtml(str, 0).toString() : str;
    }

    public static final String unaccent(CharSequence charSequence) {
        y.i(charSequence, "<this>");
        String strNormalize = Normalizer.normalize(charSequence, Normalizer.Form.NFD);
        le.m mVar = REGEX_UNACCENT;
        y.f(strNormalize);
        return mVar.l(strNormalize, "");
    }
}
