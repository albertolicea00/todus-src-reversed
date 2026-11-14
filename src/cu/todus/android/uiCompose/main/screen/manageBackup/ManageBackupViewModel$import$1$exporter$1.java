package cu.todus.android.uiCompose.main.screen.manageBackup;

import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.repositories.RoomsRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ManageBackupViewModel$import$1$exporter$1 extends v implements Function1 {
    public ManageBackupViewModel$import$1$exporter$1(Object obj) {
        super(1, obj, RoomsRepository.class, "getAllForSaves", "getAllForSaves(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super List<RoomItemView>> eVar) {
        return ((RoomsRepository) this.receiver).getAllForSaves(eVar);
    }
}
