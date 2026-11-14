package cu.todus.android.rest.user;

import ab.e;
import cu.todus.android.constants.Service;
import cu.todus.proto.ApiProto;
import kotlin.Metadata;
import mi.a0;
import oi.a;
import oi.o;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/rest/user/UserService;", "", "Lcu/todus/proto/ApiProto$ProtoUsersMeRequest;", "meRequest", "Lmi/a0;", "Lcu/todus/proto/ApiProto$ProtoUsersMeResponse;", "updateProfile", "(Lcu/todus/proto/ApiProto$ProtoUsersMeRequest;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface UserService {
    @o(Service.Endpoint.UPDATE_PROFILE)
    Object updateProfile(@a ApiProto.ProtoUsersMeRequest protoUsersMeRequest, e<? super a0<ApiProto.ProtoUsersMeResponse>> eVar);
}
