package cu.todus.android.uiCompose.main.screen.statusPreview;

import cu.todus.android.data.db.pojo.StatusForPagination;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$otherStatus2$2$1", f = "StatusPreviewViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "item", "Lcu/todus/android/data/db/pojo/StatusForPagination;"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class StatusPreviewViewModel$otherStatus2$2$1 extends cb.m implements Function2 {
    /* synthetic */ Object L$0;
    int label;

    public StatusPreviewViewModel$otherStatus2$2$1(ab.e<? super StatusPreviewViewModel$otherStatus2$2$1> eVar) {
        super(2, eVar);
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        StatusPreviewViewModel$otherStatus2$2$1 statusPreviewViewModel$otherStatus2$2$1 = new StatusPreviewViewModel$otherStatus2$2$1(eVar);
        statusPreviewViewModel$otherStatus2$2$1.L$0 = obj;
        return statusPreviewViewModel$otherStatus2$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(StatusForPagination statusForPagination, ab.e<? super StatusWithPartnersOrRooms> eVar) {
        return ((StatusPreviewViewModel$otherStatus2$2$1) create(statusForPagination, eVar)).invokeSuspend(ua.k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        StatusForPagination statusForPagination = (StatusForPagination) this.L$0;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        return statusForPagination.getStatus();
    }
}
