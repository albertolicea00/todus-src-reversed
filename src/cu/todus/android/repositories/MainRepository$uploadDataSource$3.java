package cu.todus.android.repositories;

import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.db.dao.toDus.AttachmentDao;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MainRepository$uploadDataSource$3", f = "MainRepository.kt", l = {190}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class MainRepository$uploadDataSource$3 extends cb.m implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRepository$uploadDataSource$3(MainRepository mainRepository, ab.e<? super MainRepository$uploadDataSource$3> eVar) {
        super(2, eVar);
        this.this$0 = mainRepository;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        MainRepository$uploadDataSource$3 mainRepository$uploadDataSource$3 = new MainRepository$uploadDataSource$3(this.this$0, eVar);
        mainRepository$uploadDataSource$3.L$0 = obj;
        return mainRepository$uploadDataSource$3;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            AttachmentDao attachmentDao = this.this$0.attachmentDao;
            this.L$0 = cb.l.a(str);
            this.label = 1;
            obj = attachmentDao.getByMessageId(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            if (((Attachment) obj2).getContent() instanceof FileContent) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, ab.e<? super List<Attachment>> eVar) {
        return ((MainRepository$uploadDataSource$3) create(str, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
