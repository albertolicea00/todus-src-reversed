package cu.todus.android.repositories;

import cu.todus.android.data.db.entity.toDus.Attachment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class MainRepository$downloadDataSource$2 extends kotlin.jvm.internal.v implements Function2 {
    public MainRepository$downloadDataSource$2(Object obj) {
        super(2, obj, MainRepository.class, "updateAttachment", "updateAttachment(Lcu/todus/android/data/db/entity/toDus/Attachment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Attachment attachment, ab.e<? super ua.k0> eVar) {
        return ((MainRepository) this.receiver).updateAttachment(attachment, eVar);
    }
}
