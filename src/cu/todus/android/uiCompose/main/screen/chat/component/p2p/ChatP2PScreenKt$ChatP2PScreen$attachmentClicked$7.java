package cu.todus.android.uiCompose.main.screen.chat.component.p2p;

import androidx.compose.runtime.MutableState;
import cu.todus.android.data.db.pojo.content.ButtonTemplate;
import cu.todus.android.uiCompose.main.screen.chat.pagerDialog.PagerDialogData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$7 extends kotlin.jvm.internal.v implements Function3 {
    final /* synthetic */ MutableState<PagerDialogData> $createPlaceholderMsg$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$7(MutableState<PagerDialogData> mutableState) {
        super(3, kotlin.jvm.internal.y.a.class, "setPlaceholderData", "ChatP2PScreen$setPlaceholderData(Landroidx/compose/runtime/MutableState;Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/ButtonTemplate;Z)V", 0);
        this.$createPlaceholderMsg$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (ButtonTemplate) obj2, ((Boolean) obj3).booleanValue());
        return ua.k0.f43947a;
    }

    public final void invoke(String p10, ButtonTemplate p11, boolean z10) {
        kotlin.jvm.internal.y.i(p10, "p0");
        kotlin.jvm.internal.y.i(p11, "p1");
        ChatP2PScreenKt.ChatP2PScreen$setPlaceholderData(this.$createPlaceholderMsg$delegate, p10, p11, z10);
    }
}
