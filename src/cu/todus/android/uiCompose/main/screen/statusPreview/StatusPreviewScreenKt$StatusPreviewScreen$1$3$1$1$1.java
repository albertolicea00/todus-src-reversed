package cu.todus.android.uiCompose.main.screen.statusPreview;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.paging.compose.LazyPagingItems;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator.ActionIndicatorData;
import cu.z17.views.videoPlayer.Z17VideoModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1", f = "StatusPreviewScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<ActionIndicatorData> $actionIndicator$delegate;
    final /* synthetic */ pe.m0 $coroutineScope;
    final /* synthetic */ int $index;
    final /* synthetic */ State<Boolean> $isCurrentPage$delegate;
    final /* synthetic */ StatusWithPartnersOrRooms $item;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ MutableState<Boolean> $showAllDescription$delegate;
    final /* synthetic */ LazyPagingItems<StatusWithPartnersOrRooms> $status;
    final /* synthetic */ StatusPreviewViewModel $viewModel;
    int label;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1$1", f = "StatusPreviewScreen.kt", l = {213}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ int $index;
        final /* synthetic */ LazyListState $lazyListState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LazyListState lazyListState, int i10, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$lazyListState = lazyListState;
            this.$index = i10;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.$lazyListState, this.$index, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                LazyListState lazyListState = this.$lazyListState;
                int i11 = this.$index;
                this.label = 1;
                if (LazyListState.animateScrollToItem$default(lazyListState, i11, 0, this, 2, null) == objG) {
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
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1(PagerState pagerState, StatusWithPartnersOrRooms statusWithPartnersOrRooms, StatusPreviewViewModel statusPreviewViewModel, pe.m0 m0Var, LazyPagingItems<StatusWithPartnersOrRooms> lazyPagingItems, State<Boolean> state, LazyListState lazyListState, int i10, MutableState<Boolean> mutableState, MutableState<ActionIndicatorData> mutableState2, ab.e<? super StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1> eVar) {
        super(2, eVar);
        this.$pagerState = pagerState;
        this.$item = statusWithPartnersOrRooms;
        this.$viewModel = statusPreviewViewModel;
        this.$coroutineScope = m0Var;
        this.$status = lazyPagingItems;
        this.$isCurrentPage$delegate = state;
        this.$lazyListState = lazyListState;
        this.$index = i10;
        this.$showAllDescription$delegate = mutableState;
        this.$actionIndicator$delegate = mutableState2;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1(this.$pagerState, this.$item, this.$viewModel, this.$coroutineScope, this.$status, this.$isCurrentPage$delegate, this.$lazyListState, this.$index, this.$showAllDescription$delegate, this.$actionIndicator$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        StatusWithPartnersOrRooms statusWithPartnersOrRooms;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$2(this.$isCurrentPage$delegate) && !this.$pagerState.isScrollInProgress()) {
            if (!this.$item.getStatus().getSeen()) {
                this.$viewModel.seenStatus(this.$item.getStatus().getId());
            }
            pe.k.d(this.$coroutineScope, null, null, new AnonymousClass1(this.$lazyListState, this.$index, null), 3, null);
        }
        Status status = (this.$pagerState.getCurrentPage() + 3 >= this.$pagerState.getPageCount() || (statusWithPartnersOrRooms = this.$status.getItemSnapshotList().get(this.$pagerState.getCurrentPage() + 3)) == null) ? null : statusWithPartnersOrRooms.getStatus();
        if ((status != null ? status.getContent() : null) instanceof StatusVideoContent) {
            Z17VideoModule.INSTANCE.getInstance().clearFromRAMCache(status.getId());
        }
        StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$5(this.$showAllDescription$delegate, false);
        this.$actionIndicator$delegate.setValue(new ActionIndicatorData(0, null, 2, null));
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
