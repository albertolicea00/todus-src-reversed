package cu.todus.android.repositories;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class MainRepository$uploadDataSource$4 extends kotlin.jvm.internal.v implements Function3 {
    public MainRepository$uploadDataSource$4(Object obj) {
        super(3, obj, MainRepository.class, "updateMsgStatus", "updateMsgStatus(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((String) obj, ((Number) obj2).intValue(), (ab.e<? super ua.k0>) obj3);
    }

    public final Object invoke(String str, int i10, ab.e<? super ua.k0> eVar) {
        return ((MainRepository) this.receiver).updateMsgStatus(str, i10, eVar);
    }
}
