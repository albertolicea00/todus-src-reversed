package cu.todus.android.uiCompose.main.screen.chat.component.card;

import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatCardScreenKt$ChatCardScreen$4$2$10$3$1 extends kotlin.jvm.internal.v implements Function2 {
    public ChatCardScreenKt$ChatCardScreen$4$2$10$3$1(Object obj) {
        super(2, obj, ChatViewModel.class, "onChangeStickerFavoriteStatus", "onChangeStickerFavoriteStatus(Ljava/lang/String;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, ((Boolean) obj2).booleanValue());
        return ua.k0.f43947a;
    }

    public final void invoke(String p10, boolean z10) {
        kotlin.jvm.internal.y.i(p10, "p0");
        ((ChatViewModel) this.receiver).onChangeStickerFavoriteStatus(p10, z10);
    }
}
