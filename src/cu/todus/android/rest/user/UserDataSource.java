package cu.todus.android.rest.user;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import bb.b;
import cb.f;
import cb.m;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.rest.BaseDataSource;
import cu.todus.proto.ApiProto;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import mi.a0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/rest/user/UserDataSource;", "", "Lcu/todus/android/rest/user/UserService;", NotificationCompat.CATEGORY_SERVICE, "Lcu/todus/android/rest/BaseDataSource;", "baseDataSource", "<init>", "(Lcu/todus/android/rest/user/UserService;Lcu/todus/android/rest/BaseDataSource;)V", "Lcu/todus/proto/ApiProto$ProtoUsersMeRequest;", "meRequest", "Lcu/todus/android/data/wrapper/DataWrapper;", "Lcu/todus/proto/ApiProto$ProtoUsersMeResponse;", "updateProfile", "(Lcu/todus/proto/ApiProto$ProtoUsersMeRequest;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/rest/user/UserService;", "Lcu/todus/android/rest/BaseDataSource;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UserDataSource {
    public static final int $stable = 8;
    private final BaseDataSource baseDataSource;
    private final UserService service;

    /* JADX INFO: renamed from: cu.todus.android.rest.user.UserDataSource$updateProfile$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.user.UserDataSource$updateProfile$2", f = "UserDataSource.kt", l = {12}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function1 {
        final /* synthetic */ ApiProto.ProtoUsersMeRequest $meRequest;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApiProto.ProtoUsersMeRequest protoUsersMeRequest, e<? super AnonymousClass2> eVar) {
            super(1, eVar);
            this.$meRequest = protoUsersMeRequest;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return UserDataSource.this.new AnonymousClass2(this.$meRequest, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            UserService userService = UserDataSource.this.service;
            ApiProto.ProtoUsersMeRequest protoUsersMeRequest = this.$meRequest;
            this.label = 1;
            Object objUpdateProfile = userService.updateProfile(protoUsersMeRequest, this);
            return objUpdateProfile == objG ? objG : objUpdateProfile;
        }
    }

    public UserDataSource(UserService service, BaseDataSource baseDataSource) {
        y.i(service, "service");
        y.i(baseDataSource, "baseDataSource");
        this.service = service;
        this.baseDataSource = baseDataSource;
    }

    public final Object updateProfile(ApiProto.ProtoUsersMeRequest protoUsersMeRequest, e<? super DataWrapper<ApiProto.ProtoUsersMeResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new AnonymousClass2(protoUsersMeRequest, null), eVar);
    }
}
