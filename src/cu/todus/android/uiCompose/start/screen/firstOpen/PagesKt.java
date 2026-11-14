package cu.todus.android.uiCompose.start.screen.firstOpen;

import cu.todus.android.R;
import java.util.List;
import kotlin.Metadata;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"onboardPages", "", "Lcu/todus/android/uiCompose/start/screen/firstOpen/Page;", "getOnboardPages", "()Ljava/util/List;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PagesKt {
    private static final List<Page> onboardPages = w.q(new Page(R.string.welcome, R.string.you_are_about_start_text, R.drawable.welcome1), new Page(R.string.chat_with_your_friends, R.string.share_with_your_friends_text, R.drawable.welcome2), new Page(R.string.share_title, R.string.share_files_text, R.drawable.welcome3), new Page(R.string.cuban, R.string.made_in_cuba, R.drawable.welcome4));

    public static final List<Page> getOnboardPages() {
        return onboardPages;
    }
}
