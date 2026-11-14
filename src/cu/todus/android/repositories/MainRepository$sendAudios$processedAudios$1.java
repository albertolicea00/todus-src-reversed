package cu.todus.android.repositories;

import cu.todus.android.data.util.MediaUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MainRepository$sendAudios$processedAudios$1", f = "MainRepository.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lpe/m0;", "", "Lkotlin/Pair;", "Ljava/io/File;", "", "<anonymous>", "(Lpe/m0;)Ljava/util/List;"}, k = 3, mv = {2, 3, 0})
public final class MainRepository$sendAudios$processedAudios$1 extends cb.m implements Function2 {
    final /* synthetic */ List<File> $files;
    int label;
    final /* synthetic */ MainRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MainRepository$sendAudios$processedAudios$1(List<? extends File> list, MainRepository mainRepository, ab.e<? super MainRepository$sendAudios$processedAudios$1> eVar) {
        super(2, eVar);
        this.$files = list;
        this.this$0 = mainRepository;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new MainRepository$sendAudios$processedAudios$1(this.$files, this.this$0, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        List<File> list = this.$files;
        ArrayList<File> arrayList = new ArrayList();
        for (Object obj2 : list) {
            File file = (File) obj2;
            if (file.exists() && file.isFile()) {
                arrayList.add(obj2);
            }
        }
        MainRepository mainRepository = this.this$0;
        ArrayList arrayList2 = new ArrayList(va.x.y(arrayList, 10));
        for (File file2 : arrayList) {
            arrayList2.add(ua.z.a(file2, cb.b.e(MediaUtil.INSTANCE.getDurationFromFile(mainRepository.context, file2))));
        }
        return arrayList2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super List<? extends Pair<? extends File, Long>>> eVar) {
        return ((MainRepository$sendAudios$processedAudios$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
