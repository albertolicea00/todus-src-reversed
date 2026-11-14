package cu.todus.android.rest.certified;

import ab.e;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.rest.entity.CardEntity;
import kotlin.Metadata;
import mi.a0;
import oi.f;
import oi.s;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\b\u0010\u0007J \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\t\u0010\u0007J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\u0007¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/rest/certified/CertifiedInfoService;", "", "", "uid", "Lmi/a0;", "Lcu/todus/android/data/rest/entity/CardEntity;", "getInfo", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getInfoOrError", Room.CONFIG_SUBSCRIBED_STATE, "unSubscribe", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface CertifiedInfoService {
    @f(Service.Endpoint.GET_INFO)
    Object getInfo(@s("uid") String str, e<? super a0<CardEntity>> eVar);

    @f(Service.Endpoint.GET_INFO_OR_ERROR)
    Object getInfoOrError(@s("uid") String str, e<? super a0<Object>> eVar);

    @f(Service.Endpoint.SUBSCRIBE)
    Object subscribe(@s("uid") String str, e<? super a0<Object>> eVar);

    @f(Service.Endpoint.UN_SUBSCRIBE)
    Object unSubscribe(@s("uid") String str, e<? super a0<Object>> eVar);
}
