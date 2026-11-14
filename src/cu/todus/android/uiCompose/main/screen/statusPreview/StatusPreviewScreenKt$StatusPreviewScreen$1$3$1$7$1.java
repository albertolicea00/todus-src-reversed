package cu.todus.android.uiCompose.main.screen.statusPreview;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$7$1 extends kotlin.jvm.internal.v implements Function2 {
    public StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$7$1(Object obj) {
        super(2, obj, StatusPreviewViewModel.class, "getFollowState", "getFollowState(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Function1) obj2);
        return ua.k0.f43947a;
    }

    public final void invoke(String p10, Function1 p11) {
        kotlin.jvm.internal.y.i(p10, "p0");
        kotlin.jvm.internal.y.i(p11, "p1");
        ((StatusPreviewViewModel) this.receiver).getFollowState(p10, p11);
    }
}
