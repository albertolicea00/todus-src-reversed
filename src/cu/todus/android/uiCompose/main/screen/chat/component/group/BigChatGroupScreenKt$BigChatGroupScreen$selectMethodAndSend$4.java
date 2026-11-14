package cu.todus.android.uiCompose.main.screen.chat.component.group;

import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import java.io.File;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class BigChatGroupScreenKt$BigChatGroupScreen$selectMethodAndSend$4 extends kotlin.jvm.internal.v implements lb.o {
    public BigChatGroupScreenKt$BigChatGroupScreen$selectMethodAndSend$4(Object obj) {
        super(4, obj, ChatViewModel.class, "sendVideos", "sendVideos(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // lb.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((String) obj, (List<? extends File>) obj2, (String) obj3, (String) obj4);
        return ua.k0.f43947a;
    }

    public final void invoke(String p10, List<? extends File> p11, String p12, String str) {
        kotlin.jvm.internal.y.i(p10, "p0");
        kotlin.jvm.internal.y.i(p11, "p1");
        kotlin.jvm.internal.y.i(p12, "p2");
        ((ChatViewModel) this.receiver).sendVideos(p10, p11, p12, str);
    }
}
