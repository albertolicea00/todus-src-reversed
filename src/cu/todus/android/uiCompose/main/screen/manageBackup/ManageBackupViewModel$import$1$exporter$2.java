package cu.todus.android.uiCompose.main.screen.manageBackup;

import cu.todus.android.data.db.pojo.MessageWithAttachments;
import cu.todus.android.repositories.RoomsRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ManageBackupViewModel$import$1$exporter$2 extends v implements Function2 {
    public ManageBackupViewModel$import$1$exporter$2(Object obj) {
        super(2, obj, RoomsRepository.class, "getAllByRoomForSave", "getAllByRoomForSave(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, ab.e<? super List<MessageWithAttachments>> eVar) {
        return ((RoomsRepository) this.receiver).getAllByRoomForSave(str, eVar);
    }
}
