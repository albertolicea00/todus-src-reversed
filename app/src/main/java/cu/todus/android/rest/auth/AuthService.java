package cu.todus.android.rest.auth;

import cu.todus.android.constants.Service;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.rest.request.LinkInfoRequest;
import cu.todus.proto.ApiProto;

/**
 * Retrofit service interface for {@code auth.todus.cu} Protobuf and JSON endpoints.
 *
 * @obfuscated_class cu.todus.android.rest.auth.AuthService
 */
public interface AuthService {

    Object reserve(ApiProto.ProtoUserReserveRequest request, Object continuation);

    Object register(ApiProto.ProtoUserRegisterRequest request, Object continuation);

    Object token(ApiProto.ProtoUserAuthTokenRequest request, Object continuation);

    Object passCheck(ApiProto.ProtoAuthCheckRequest request);

    Object linkInfo(LinkInfoRequest request, Object continuation);
}
