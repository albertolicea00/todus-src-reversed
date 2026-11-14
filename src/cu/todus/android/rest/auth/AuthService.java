package cu.todus.android.rest.auth;

import ab.e;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.rest.request.LinkInfoRequest;
import cu.todus.android.xmpp.extension.link.ExtensionLinkInfo;
import cu.todus.proto.ApiProto;
import kotlin.Metadata;
import mi.a0;
import mi.d;
import oi.a;
import oi.o;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\b\b\u0001\u0010\r\u001a\u00020\fH§@¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0018H§@¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/rest/auth/AuthService;", "", "Lcu/todus/proto/ApiProto$ProtoUserReserveRequest;", "verifyPhoneNumberRequest", "Lmi/a0;", "reserve", "(Lcu/todus/proto/ApiProto$ProtoUserReserveRequest;Lab/e;)Ljava/lang/Object;", "Lcu/todus/proto/ApiProto$ProtoUserRegisterRequest;", "registerRequest", "Lcu/todus/proto/ApiProto$ProtoUserRegisterResponse;", "register", "(Lcu/todus/proto/ApiProto$ProtoUserRegisterRequest;Lab/e;)Ljava/lang/Object;", "Lcu/todus/proto/ApiProto$ProtoUserAuthTokenRequest;", "tokenRequest", "Lcu/todus/proto/ApiProto$ProtoUserAuthTokenResponse;", "token", "(Lcu/todus/proto/ApiProto$ProtoUserAuthTokenRequest;Lab/e;)Ljava/lang/Object;", "Lmi/d;", "tokenNotLive", "(Lcu/todus/proto/ApiProto$ProtoUserAuthTokenRequest;)Lmi/d;", "Lcu/todus/proto/ApiProto$ProtoAuthCheckRequest;", "request", "passCheck", "(Lcu/todus/proto/ApiProto$ProtoAuthCheckRequest;)Lmi/a0;", "Lcu/todus/android/data/rest/request/LinkInfoRequest;", "Lcu/todus/android/data/db/pojo/content/LinkEntity;", ExtensionLinkInfo.ELEMENT, "(Lcu/todus/android/data/rest/request/LinkInfoRequest;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AuthService {
    @o(Service.Endpoint.LINK_INFO)
    Object linkInfo(@a LinkInfoRequest linkInfoRequest, e<? super a0<LinkEntity>> eVar);

    @o(Service.Endpoint.CHECK)
    a0<?> passCheck(@a ApiProto.ProtoAuthCheckRequest request);

    @o(Service.Endpoint.USERS_REGISTER)
    Object register(@a ApiProto.ProtoUserRegisterRequest protoUserRegisterRequest, e<? super a0<ApiProto.ProtoUserRegisterResponse>> eVar);

    @o(Service.Endpoint.USERS_RESERVE)
    Object reserve(@a ApiProto.ProtoUserReserveRequest protoUserReserveRequest, e<? super a0<Object>> eVar);

    @o(Service.Endpoint.TOKEN)
    Object token(@a ApiProto.ProtoUserAuthTokenRequest protoUserAuthTokenRequest, e<? super a0<ApiProto.ProtoUserAuthTokenResponse>> eVar);

    @o(Service.Endpoint.TOKEN)
    d<ApiProto.ProtoUserAuthTokenResponse> tokenNotLive(@a ApiProto.ProtoUserAuthTokenRequest tokenRequest);
}
