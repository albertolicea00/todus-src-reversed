package cu.todus.android.uiCompose.main.screen.chat.component.p2p;

import android.content.Context;
import cu.todus.android.media.player.MediaPlayerData;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$2 extends kotlin.jvm.internal.v implements Function2 {
    public ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$2(Object obj) {
        super(2, obj, ChatViewModel.class, "startPlaying", "startPlaying(Lcu/todus/android/media/player/MediaPlayerData;Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IOException {
        invoke((MediaPlayerData) obj, (Context) obj2);
        return ua.k0.f43947a;
    }

    public final void invoke(MediaPlayerData p10, Context p11) throws IOException {
        kotlin.jvm.internal.y.i(p10, "p0");
        kotlin.jvm.internal.y.i(p11, "p1");
        ((ChatViewModel) this.receiver).startPlaying(p10, p11);
    }
}
