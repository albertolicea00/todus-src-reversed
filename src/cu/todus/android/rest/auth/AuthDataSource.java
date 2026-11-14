package cu.todus.android.rest.auth;

import ab.e;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import bb.b;
import cb.f;
import cb.l;
import cb.m;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.rest.request.LinkInfoRequest;
import cu.todus.android.data.rest.response.TokenResponse;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.rest.BaseDataSource;
import cu.todus.android.xmpp.extension.link.ExtensionLinkInfo;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086@¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0015\u0010\u0011J'\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\u0006\u0010\u001d\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\"¨\u0006#"}, d2 = {"Lcu/todus/android/rest/auth/AuthDataSource;", "", "Lcu/todus/android/rest/auth/AuthService;", NotificationCompat.CATEGORY_SERVICE, "Lcu/todus/android/rest/BaseDataSource;", "baseDataSource", "<init>", "(Lcu/todus/android/rest/auth/AuthService;Lcu/todus/android/rest/BaseDataSource;)V", "", "username", "clientToken", "Lcu/todus/android/data/wrapper/DataWrapper;", "reserve", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "code", "Lcu/todus/proto/ApiProto$ProtoUserRegisterResponse;", "register", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", HintConstants.AUTOFILL_HINT_PASSWORD, "clientVersion", "Lcu/todus/proto/ApiProto$ProtoUserAuthTokenResponse;", "newToken", "Lcu/todus/android/data/rest/response/TokenResponse;", "newTokenNotLive", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcu/todus/android/data/rest/response/TokenResponse;", "Lcu/todus/proto/ApiProto$ProtoAuthCheckRequest;", "request", "passCheck", "(Lcu/todus/proto/ApiProto$ProtoAuthCheckRequest;Lab/e;)Ljava/lang/Object;", "url", "Lcu/todus/android/data/db/pojo/content/LinkEntity;", ExtensionLinkInfo.ELEMENT, "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/rest/auth/AuthService;", "Lcu/todus/android/rest/BaseDataSource;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AuthDataSource {
    public static final int $stable = 8;
    private final BaseDataSource baseDataSource;
    private final AuthService service;

    /* JADX INFO: renamed from: cu.todus.android.rest.auth.AuthDataSource$linkInfo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.auth.AuthDataSource$linkInfo$2", f = "AuthDataSource.kt", l = {75}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function1 {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, e<? super AnonymousClass2> eVar) {
            super(1, eVar);
            this.$url = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return AuthDataSource.this.new AnonymousClass2(this.$url, eVar);
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
            AuthService authService = AuthDataSource.this.service;
            LinkInfoRequest linkInfoRequest = new LinkInfoRequest(this.$url);
            this.label = 1;
            Object objLinkInfo = authService.linkInfo(linkInfoRequest, this);
            return objLinkInfo == objG ? objG : objLinkInfo;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.auth.AuthDataSource$newToken$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.auth.AuthDataSource$newToken$2", f = "AuthDataSource.kt", l = {48}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11522 extends m implements Function1 {
        final /* synthetic */ String $clientVersion;
        final /* synthetic */ String $password;
        final /* synthetic */ String $username;
        Object L$0;
        int label;
        final /* synthetic */ AuthDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11522(String str, String str2, String str3, AuthDataSource authDataSource, e<? super C11522> eVar) {
            super(1, eVar);
            this.$username = str;
            this.$password = str2;
            this.$clientVersion = str3;
            this.this$0 = authDataSource;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return new C11522(this.$username, this.$password, this.$clientVersion, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11522) create(eVar)).invokeSuspend(k0.f43947a);
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
            ApiProto.ProtoUserAuthTokenRequest protoUserAuthTokenRequestBuild = ApiProto.ProtoUserAuthTokenRequest.newBuilder().setUsername(this.$username).setPassword(this.$password).setVersion(this.$clientVersion).build();
            AuthService authService = this.this$0.service;
            y.f(protoUserAuthTokenRequestBuild);
            this.L$0 = l.a(protoUserAuthTokenRequestBuild);
            this.label = 1;
            Object obj2 = authService.token(protoUserAuthTokenRequestBuild, this);
            return obj2 == objG ? objG : obj2;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.auth.AuthDataSource$passCheck$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.auth.AuthDataSource$passCheck$2", f = "AuthDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11532 extends m implements Function1 {
        final /* synthetic */ ApiProto.ProtoAuthCheckRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11532(ApiProto.ProtoAuthCheckRequest protoAuthCheckRequest, e<? super C11532> eVar) {
            super(1, eVar);
            this.$request = protoAuthCheckRequest;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return AuthDataSource.this.new C11532(this.$request, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11532) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            return AuthDataSource.this.service.passCheck(this.$request);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.auth.AuthDataSource$register$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.auth.AuthDataSource$register$2", f = "AuthDataSource.kt", l = {29}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11542 extends m implements Function1 {
        final /* synthetic */ String $clientToken;
        final /* synthetic */ String $code;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11542(String str, String str2, String str3, e<? super C11542> eVar) {
            super(1, eVar);
            this.$username = str;
            this.$clientToken = str2;
            this.$code = str3;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return AuthDataSource.this.new C11542(this.$username, this.$clientToken, this.$code, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11542) create(eVar)).invokeSuspend(k0.f43947a);
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
            AuthService authService = AuthDataSource.this.service;
            ApiProto.ProtoUserRegisterRequest protoUserRegisterRequestBuild = ApiProto.ProtoUserRegisterRequest.newBuilder().setUsername(this.$username).setClientToken(this.$clientToken).setCode(this.$code).build();
            y.h(protoUserRegisterRequestBuild, "build(...)");
            this.label = 1;
            Object objRegister = authService.register(protoUserRegisterRequestBuild, this);
            return objRegister == objG ? objG : objRegister;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.auth.AuthDataSource$reserve$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.auth.AuthDataSource$reserve$2", f = "AuthDataSource.kt", l = {16}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11552 extends m implements Function1 {
        final /* synthetic */ String $clientToken;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11552(String str, String str2, e<? super C11552> eVar) {
            super(1, eVar);
            this.$username = str;
            this.$clientToken = str2;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return AuthDataSource.this.new C11552(this.$username, this.$clientToken, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11552) create(eVar)).invokeSuspend(k0.f43947a);
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
            AuthService authService = AuthDataSource.this.service;
            ApiProto.ProtoUserReserveRequest protoUserReserveRequestBuild = ApiProto.ProtoUserReserveRequest.newBuilder().setUsername(this.$username).setClientToken(this.$clientToken).build();
            y.h(protoUserReserveRequestBuild, "build(...)");
            this.label = 1;
            Object objReserve = authService.reserve(protoUserReserveRequestBuild, this);
            return objReserve == objG ? objG : objReserve;
        }
    }

    public AuthDataSource(AuthService service, BaseDataSource baseDataSource) {
        y.i(service, "service");
        y.i(baseDataSource, "baseDataSource");
        this.service = service;
        this.baseDataSource = baseDataSource;
    }

    public final Object linkInfo(String str, e<? super DataWrapper<LinkEntity>> eVar) {
        return this.baseDataSource.handleFlowRequest(new AnonymousClass2(str, null), eVar);
    }

    public final Object newToken(String str, String str2, String str3, e<? super DataWrapper<ApiProto.ProtoUserAuthTokenResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11522(str, str2, str3, this, null), eVar);
    }

    public final TokenResponse newTokenNotLive(String username, String password, String clientVersion) {
        y.i(username, "username");
        y.i(password, "password");
        y.i(clientVersion, "clientVersion");
        try {
            ApiProto.ProtoUserAuthTokenRequest protoUserAuthTokenRequestBuild = ApiProto.ProtoUserAuthTokenRequest.newBuilder().setUsername(username).setPassword(password).setVersion(clientVersion).build();
            AuthService authService = this.service;
            y.f(protoUserAuthTokenRequestBuild);
            ApiProto.ProtoUserAuthTokenResponse protoUserAuthTokenResponse = (ApiProto.ProtoUserAuthTokenResponse) authService.tokenNotLive(protoUserAuthTokenRequestBuild).execute().a();
            if (protoUserAuthTokenResponse == null) {
                return null;
            }
            String tokenString = protoUserAuthTokenResponse.getTokenString();
            y.h(tokenString, "getTokenString(...)");
            return new TokenResponse(tokenString, protoUserAuthTokenResponse.getExpireTime());
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final Object passCheck(ApiProto.ProtoAuthCheckRequest protoAuthCheckRequest, e<? super DataWrapper<Object>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11532(protoAuthCheckRequest, null), eVar);
    }

    public final Object register(String str, String str2, String str3, e<? super DataWrapper<ApiProto.ProtoUserRegisterResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11542(str, str2, str3, null), eVar);
    }

    public final Object reserve(String str, String str2, e<? super DataWrapper<Object>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11552(str, str2, null), eVar);
    }
}
