package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

import androidx.compose.foundation.pager.PagerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.AttachmentPreviewKt$AttachmentPreviewWithOptions$2$3$1$1$1", f = "AttachmentPreview.kt", l = {220}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class AttachmentPreviewKt$AttachmentPreviewWithOptions$2$3$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttachmentPreviewKt$AttachmentPreviewWithOptions$2$3$1$1$1(PagerState pagerState, ab.e<? super AttachmentPreviewKt$AttachmentPreviewWithOptions$2$3$1$1$1> eVar) {
        super(2, eVar);
        this.$pagerState = pagerState;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new AttachmentPreviewKt$AttachmentPreviewWithOptions$2$3$1$1$1(this.$pagerState, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            PagerState pagerState = this.$pagerState;
            int currentPage = pagerState.getCurrentPage() - 1;
            this.label = 1;
            if (PagerState.animateScrollToPage$default(pagerState, currentPage, 0.0f, null, this, 6, null) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((AttachmentPreviewKt$AttachmentPreviewWithOptions$2$3$1$1$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
