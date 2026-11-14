package cu.todus.android.uiCompose.main.screen.statusPreview;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreenKt$StatusPreviewScreen$1$3$2$1", f = "StatusPreviewScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class StatusPreviewScreenKt$StatusPreviewScreen$1$3$2$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Boolean> $canScroll$delegate;
    final /* synthetic */ int $index;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ ModalBottomSheetState $showMore;
    final /* synthetic */ ModalBottomSheetState $showViews;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusPreviewScreenKt$StatusPreviewScreen$1$3$2$1(PagerState pagerState, int i10, ModalBottomSheetState modalBottomSheetState, ModalBottomSheetState modalBottomSheetState2, MutableState<Boolean> mutableState, ab.e<? super StatusPreviewScreenKt$StatusPreviewScreen$1$3$2$1> eVar) {
        super(2, eVar);
        this.$pagerState = pagerState;
        this.$index = i10;
        this.$showViews = modalBottomSheetState;
        this.$showMore = modalBottomSheetState2;
        this.$canScroll$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new StatusPreviewScreenKt$StatusPreviewScreen$1$3$2$1(this.$pagerState, this.$index, this.$showViews, this.$showMore, this.$canScroll$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (this.$pagerState.getCurrentPage() == this.$index) {
            MutableState<Boolean> mutableState = this.$canScroll$delegate;
            ModalBottomSheetValue currentValue = this.$showViews.getCurrentValue();
            ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Hidden;
            StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$4(mutableState, currentValue == modalBottomSheetValue && this.$showMore.getCurrentValue() == modalBottomSheetValue);
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((StatusPreviewScreenKt$StatusPreviewScreen$1$3$2$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
