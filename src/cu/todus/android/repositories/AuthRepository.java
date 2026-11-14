package cu.todus.android.repositories;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.ts.TsExtractor;
import cu.todus.android.R;
import cu.todus.android.accountManager.AccountUtils;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.rest.BaseResponse;
import cu.todus.android.data.rest.response.TokenResponse;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.di.MainModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.exceptions.PhoneAuthException;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.rest.auth.AuthDataSource;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.proto.ApiProto;
import cu.z17.singledi.SingletonInitializer;
import java.net.ConnectException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import pe.d1;
import pe.e2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00160#¢\u0006\u0004\b$\u0010%J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160#H\u0086@¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\bH\u0086@¢\u0006\u0004\b(\u0010'J\u0010\u0010)\u001a\u00020\bH\u0086@¢\u0006\u0004\b)\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010+\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0015R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcu/todus/android/repositories/AuthRepository;", "", "Landroid/content/Context;", "context", "Lcu/todus/android/data/preferences/Owner;", "firsOpenCredential", "Lkotlin/Function1;", "Lcu/todus/android/exceptions/ToDusException;", "Lua/k0;", "setError", "<init>", "(Landroid/content/Context;Lcu/todus/android/data/preferences/Owner;Lkotlin/jvm/functions/Function1;)V", "Lte/h;", "Lcu/todus/android/data/preferences/AppState;", "kotlin.jvm.PlatformType", "getActualAppState", "()Lte/h;", "getActualOwner", "()Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "updateOwner", "(Lcu/todus/android/data/preferences/Owner;)V", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "", "countryCode", "uid", "", "verifyPhoneNumber", "(Ljava/lang/String;ILjava/lang/String;Lab/e;)Ljava/lang/Object;", "code", "register", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getVersion", "()Ljava/lang/String;", "Lkotlin/Pair;", "newToken", "()Lkotlin/Pair;", "newTokenLive", "(Lab/e;)Ljava/lang/Object;", "retryVerify", "backToVerifyEdit", "Landroid/content/Context;", "Lcu/todus/android/data/preferences/Owner;", "Lkotlin/jvm/functions/Function1;", "getSetError", "()Lkotlin/jvm/functions/Function1;", "Lcu/todus/android/rest/auth/AuthDataSource;", "authDataSource", "Lcu/todus/android/rest/auth/AuthDataSource;", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "getOwner", "setOwner", "Landroid/accounts/AccountManager;", "mAccountManager", "Landroid/accounts/AccountManager;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AuthRepository {
    private final AuthDataSource authDataSource;
    private final Context context;
    private final pe.m0 coroutineScope;
    private final Owner firsOpenCredential;
    private final AccountManager mAccountManager;
    private Owner owner;
    private final PreferencesModule preferences;
    private final Function1 setError;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/AuthRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/AuthRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<AuthRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.AuthRepository$newTokenLive$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.AuthRepository", f = "AuthRepository.kt", l = {217}, m = "newTokenLive", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthRepository.this.newTokenLive(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.AuthRepository$register$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.AuthRepository", f = "AuthRepository.kt", l = {124, 126, 157}, m = "register", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10161 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C10161(ab.e<? super C10161> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthRepository.this.register(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.AuthRepository$retryVerify$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.AuthRepository", f = "AuthRepository.kt", l = {250, 253, 260, 270}, m = "retryVerify", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10171 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10171(ab.e<? super C10171> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthRepository.this.retryVerify(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.AuthRepository$updateOwner$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.AuthRepository$updateOwner$1", f = "AuthRepository.kt", l = {57}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10181 extends cb.m implements Function1 {
        final /* synthetic */ Owner $owner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10181(Owner owner, ab.e<? super C10181> eVar) {
            super(1, eVar);
            this.$owner = owner;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return AuthRepository.this.new C10181(this.$owner, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10181) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                PreferencesModule preferencesModule = AuthRepository.this.preferences;
                Owner owner = this.$owner;
                this.label = 1;
                if (preferencesModule.saveOwner(owner, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.AuthRepository$verifyPhoneNumber$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.AuthRepository", f = "AuthRepository.kt", l = {RectListKt.BitOffsetForGesturable, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, MdtaMetadataEntry.TYPE_INDICATOR_INT32, TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m = "verifyPhoneNumber", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10191 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10191(ab.e<? super C10191> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthRepository.this.verifyPhoneNumber(null, 0, null, this);
        }
    }

    public AuthRepository(Context context, Owner owner, Function1 setError) {
        kotlin.jvm.internal.y.i(context, "context");
        kotlin.jvm.internal.y.i(setError, "setError");
        this.context = context;
        this.firsOpenCredential = owner;
        this.setError = setError;
        this.authDataSource = RetrofitModule.INSTANCE.getInstance().getAuthDataSource();
        this.preferences = PreferencesModule.INSTANCE.getInstance();
        this.coroutineScope = pe.n0.a(d1.b());
        this.owner = owner;
        AccountManager accountManager = AccountManager.get(context);
        kotlin.jvm.internal.y.h(accountManager, "get(...)");
        this.mAccountManager = accountManager;
    }

    public final Object backToVerifyEdit(ab.e<? super ua.k0> eVar) {
        Object appState = this.preferences.setAppState(new AppState(AppStateStep.WAITING_VERIFY, null, null, 0, 0L, 30, null), eVar);
        return appState == bb.b.g() ? appState : ua.k0.f43947a;
    }

    public final te.h getActualAppState() {
        return this.preferences.getAppStateFlow();
    }

    public final Owner getActualOwner() {
        Owner owner = this.owner;
        kotlin.jvm.internal.y.f(owner);
        return owner;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final Function1 getSetError() {
        return this.setError;
    }

    public final String getVersion() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            packageInfo = null;
        }
        return String.valueOf(packageInfo != null ? packageInfo.versionCode : 0);
    }

    public final Pair<Boolean, String> newToken() {
        TokenResponse tokenResponseNewTokenNotLive;
        Owner owner = this.owner;
        if (owner == null || (tokenResponseNewTokenNotLive = this.authDataSource.newTokenNotLive(owner.getUsername(), owner.getPassword(), getVersion())) == null) {
            return ua.z.a(Boolean.FALSE, "");
        }
        updateOwner(Owner.copy$default(getActualOwner(), null, null, null, 0, null, null, null, null, tokenResponseNewTokenNotLive.getToken(), 0L, null, 0, 3839, null));
        this.mAccountManager.setAuthToken(new Account(owner.getUsername(), "cu.todus.android"), AccountUtils.AUTH_TOKEN_TYPE, tokenResponseNewTokenNotLive.getToken());
        return ua.z.a(Boolean.TRUE, tokenResponseNewTokenNotLive.getToken());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object newTokenLive(ab.e<? super Pair<Integer, String>> eVar) {
        AnonymousClass1 anonymousClass1;
        TokenResponse tokenResponse;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object objNewToken = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            ua.v.b(objNewToken);
            Owner actualOwner = getActualOwner();
            AuthDataSource authDataSource = this.authDataSource;
            String username = actualOwner.getUsername();
            String password = actualOwner.getPassword();
            String version = INSTANCE.getInstance().getVersion();
            anonymousClass1.L$0 = cb.l.a(actualOwner);
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            objNewToken = authDataSource.newToken(username, password, version, anonymousClass1);
            if (objNewToken == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objNewToken);
        }
        DataWrapper dataWrapper = (DataWrapper) objNewToken;
        if (dataWrapper.getResponseBody() != null && dataWrapper.getThrowable() == null) {
            String tokenString = ((ApiProto.ProtoUserAuthTokenResponse) dataWrapper.getResponseBody()).getTokenString();
            kotlin.jvm.internal.y.h(tokenString, "getTokenString(...)");
            tokenResponse = new TokenResponse(tokenString, ((ApiProto.ProtoUserAuthTokenResponse) dataWrapper.getResponseBody()).getExpireTime());
        } else {
            if (dataWrapper.getCode() == 403) {
                return ua.z.a(cb.b.d(2), "");
            }
            tokenResponse = null;
        }
        if (tokenResponse == null) {
            return ua.z.a(cb.b.d(0), "");
        }
        updateOwner(Owner.copy$default(getActualOwner(), null, null, null, 0, null, null, null, null, tokenResponse.getToken(), tokenResponse.getExpire(), null, 0, 3327, null));
        Owner owner = this.owner;
        kotlin.jvm.internal.y.f(owner);
        this.mAccountManager.setAuthToken(new Account(owner.getUsername(), "cu.todus.android"), AccountUtils.AUTH_TOKEN_TYPE, tokenResponse.getToken());
        return ua.z.a(cb.b.d(1), tokenResponse.getToken());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:29:0x0164  */
    /* JADX WARN: Code duplicated, block: B:32:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:37:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:39:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:42:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:46:0x0223  */
    /* JADX WARN: Code duplicated, block: B:47:0x0225  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object register(String str, ab.e<? super Boolean> eVar) {
        C10161 c10161;
        String str2;
        AppState appState;
        String str3;
        DataWrapper dataWrapper;
        ApiProto.ProtoUserRegisterResponse protoUserRegisterResponse;
        boolean z10;
        AppState appState2;
        Account account;
        Owner owner;
        Object appState3;
        DataWrapper dataWrapper2;
        Throwable throwable;
        boolean z11;
        if (eVar instanceof C10161) {
            c10161 = (C10161) eVar;
            int i10 = c10161.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10161.label = i10 - Integer.MIN_VALUE;
            } else {
                c10161 = new C10161(eVar);
            }
        } else {
            c10161 = new C10161(eVar);
        }
        Object appState4 = c10161.result;
        Object objG = bb.b.g();
        int i11 = c10161.label;
        if (i11 == 0) {
            ua.v.b(appState4);
            PreferencesModule preferencesModule = this.preferences;
            str2 = str;
            c10161.L$0 = str2;
            c10161.label = 1;
            appState4 = preferencesModule.getAppState(c10161);
            if (appState4 != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            str2 = (String) c10161.L$0;
            ua.v.b(appState4);
        } else {
            if (i11 == 2) {
                AppState appState5 = (AppState) c10161.L$1;
                str3 = (String) c10161.L$0;
                ua.v.b(appState4);
                appState = appState5;
                dataWrapper = (DataWrapper) appState4;
                protoUserRegisterResponse = (ApiProto.ProtoUserRegisterResponse) dataWrapper.getResponseBody();
                if (protoUserRegisterResponse != null) {
                    String clientUid = appState.getClientUid();
                    String alias = protoUserRegisterResponse.getProtoUserReserve().getAlias();
                    kotlin.jvm.internal.y.h(alias, "getAlias(...)");
                    String pictureUrl = protoUserRegisterResponse.getProtoUserReserve().getPictureUrl();
                    kotlin.jvm.internal.y.h(pictureUrl, "getPictureUrl(...)");
                    appState2 = appState;
                    int version = (int) protoUserRegisterResponse.getProtoUserReserve().getVersion();
                    String description = protoUserRegisterResponse.getProtoUserReserve().getDescription();
                    kotlin.jvm.internal.y.h(description, "getDescription(...)");
                    String pictureUrl2 = protoUserRegisterResponse.getProtoUserReserve().getPictureUrl();
                    kotlin.jvm.internal.y.h(pictureUrl2, "getPictureUrl(...)");
                    String username = protoUserRegisterResponse.getProtoUserReserve().getUsername();
                    kotlin.jvm.internal.y.h(username, "getUsername(...)");
                    String passwd = protoUserRegisterResponse.getPasswd();
                    kotlin.jvm.internal.y.h(passwd, "getPasswd(...)");
                    String toDusId = protoUserRegisterResponse.getProtoUserReserve().getToDusId();
                    kotlin.jvm.internal.y.h(toDusId, "getToDusId(...)");
                    this.owner = new Owner(clientUid, alias, pictureUrl, version, description, pictureUrl2, username, passwd, null, 0L, toDusId, appState2.getCountryCode(), 768, null);
                    Owner owner2 = this.owner;
                    kotlin.jvm.internal.y.f(owner2);
                    account = new Account(owner2.getUsername(), "cu.todus.android");
                    AccountManager accountManager = this.mAccountManager;
                    Owner owner3 = this.owner;
                    kotlin.jvm.internal.y.f(owner3);
                    accountManager.addAccountExplicitly(account, owner3.getPassword(), null);
                    AccountManager accountManager2 = this.mAccountManager;
                    Owner owner4 = this.owner;
                    kotlin.jvm.internal.y.f(owner4);
                    accountManager2.setAuthToken(account, AccountUtils.AUTH_TOKEN_TYPE, owner4.getToken());
                    newToken();
                    owner = this.owner;
                    if (owner != null) {
                        AppState appStateCopy$default = AppState.copy$default(appState2, AppStateStep.WAITING_COMPLETE_PROFILE, null, null, 0, 0L, 30, null);
                        PreferencesModule preferencesModule2 = this.preferences;
                        c10161.L$0 = cb.l.a(str3);
                        c10161.L$1 = cb.l.a(appState2);
                        c10161.L$2 = dataWrapper;
                        c10161.L$3 = cb.l.a(protoUserRegisterResponse);
                        c10161.L$4 = cb.l.a(account);
                        c10161.L$5 = cb.l.a(owner);
                        c10161.L$6 = cb.l.a(appStateCopy$default);
                        z10 = false;
                        c10161.I$0 = 0;
                        c10161.I$1 = 0;
                        c10161.label = 3;
                        appState3 = preferencesModule2.setAppState(appStateCopy$default, c10161);
                        if (appState3 != objG) {
                            dataWrapper2 = dataWrapper;
                            appState4 = appState3;
                        }
                        return objG;
                    }
                    throwable = dataWrapper.getThrowable();
                    if (throwable != null) {
                        if ((throwable instanceof mi.p) || ((mi.p) throwable).a() != 404) {
                            Function1 function1 = this.setError;
                            String string = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                            kotlin.jvm.internal.y.h(string, "getString(...)");
                            function1.invoke(new ToDusException(string, null, false, 6, null));
                        } else {
                            Function1 function2 = this.setError;
                            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.wrong_code);
                            kotlin.jvm.internal.y.h(string2, "getString(...)");
                            function2.invoke(new ToDusException(string2, null, false, 6, null));
                        }
                        throwable.printStackTrace();
                    }
                    if (dataWrapper.getCode() == 200) {
                        z11 = true;
                    } else {
                        z11 = z10;
                    }
                    return cb.b.a(z11);
                }
                z10 = false;
                throwable = dataWrapper.getThrowable();
                if (throwable != null) {
                    if (throwable instanceof mi.p) {
                        Function1 function3 = this.setError;
                        String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                        kotlin.jvm.internal.y.h(string3, "getString(...)");
                        function3.invoke(new ToDusException(string3, null, false, 6, null));
                    } else {
                        Function1 function4 = this.setError;
                        String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                        kotlin.jvm.internal.y.h(string4, "getString(...)");
                        function4.invoke(new ToDusException(string4, null, false, 6, null));
                    }
                    throwable.printStackTrace();
                }
                if (dataWrapper.getCode() == 200) {
                    z11 = true;
                } else {
                    z11 = z10;
                }
                return cb.b.a(z11);
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dataWrapper2 = (DataWrapper) c10161.L$2;
            ua.v.b(appState4);
            z10 = false;
        }
        cb.b.a(((Boolean) appState4).booleanValue());
        dataWrapper = dataWrapper2;
        throwable = dataWrapper.getThrowable();
        if (throwable != null) {
            if (throwable instanceof mi.p) {
                Function1 function5 = this.setError;
                String string5 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                kotlin.jvm.internal.y.h(string5, "getString(...)");
                function5.invoke(new ToDusException(string5, null, false, 6, null));
            } else {
                Function1 function6 = this.setError;
                String string6 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                kotlin.jvm.internal.y.h(string6, "getString(...)");
                function6.invoke(new ToDusException(string6, null, false, 6, null));
            }
            throwable.printStackTrace();
        }
        if (dataWrapper.getCode() == 200) {
            z11 = true;
        } else {
            z11 = z10;
        }
        return cb.b.a(z11);
        AppState appState6 = (AppState) appState4;
        AuthDataSource authDataSource = this.authDataSource;
        String savedNumber = appState6.getSavedNumber();
        String clientUid2 = appState6.getClientUid();
        c10161.L$0 = cb.l.a(str2);
        c10161.L$1 = appState6;
        c10161.label = 2;
        Object objRegister = authDataSource.register(savedNumber, clientUid2, str2, c10161);
        if (objRegister != objG) {
            appState = appState6;
            appState4 = objRegister;
            str3 = str2;
            dataWrapper = (DataWrapper) appState4;
            protoUserRegisterResponse = (ApiProto.ProtoUserRegisterResponse) dataWrapper.getResponseBody();
            if (protoUserRegisterResponse != null) {
                String clientUid3 = appState.getClientUid();
                String alias2 = protoUserRegisterResponse.getProtoUserReserve().getAlias();
                kotlin.jvm.internal.y.h(alias2, "getAlias(...)");
                String pictureUrl3 = protoUserRegisterResponse.getProtoUserReserve().getPictureUrl();
                kotlin.jvm.internal.y.h(pictureUrl3, "getPictureUrl(...)");
                appState2 = appState;
                int version2 = (int) protoUserRegisterResponse.getProtoUserReserve().getVersion();
                String description2 = protoUserRegisterResponse.getProtoUserReserve().getDescription();
                kotlin.jvm.internal.y.h(description2, "getDescription(...)");
                String pictureUrl4 = protoUserRegisterResponse.getProtoUserReserve().getPictureUrl();
                kotlin.jvm.internal.y.h(pictureUrl4, "getPictureUrl(...)");
                String username2 = protoUserRegisterResponse.getProtoUserReserve().getUsername();
                kotlin.jvm.internal.y.h(username2, "getUsername(...)");
                String passwd2 = protoUserRegisterResponse.getPasswd();
                kotlin.jvm.internal.y.h(passwd2, "getPasswd(...)");
                String toDusId2 = protoUserRegisterResponse.getProtoUserReserve().getToDusId();
                kotlin.jvm.internal.y.h(toDusId2, "getToDusId(...)");
                this.owner = new Owner(clientUid3, alias2, pictureUrl3, version2, description2, pictureUrl4, username2, passwd2, null, 0L, toDusId2, appState2.getCountryCode(), 768, null);
                Owner owner5 = this.owner;
                kotlin.jvm.internal.y.f(owner5);
                account = new Account(owner5.getUsername(), "cu.todus.android");
                AccountManager accountManager3 = this.mAccountManager;
                Owner owner6 = this.owner;
                kotlin.jvm.internal.y.f(owner6);
                accountManager3.addAccountExplicitly(account, owner6.getPassword(), null);
                AccountManager accountManager4 = this.mAccountManager;
                Owner owner7 = this.owner;
                kotlin.jvm.internal.y.f(owner7);
                accountManager4.setAuthToken(account, AccountUtils.AUTH_TOKEN_TYPE, owner7.getToken());
                newToken();
                owner = this.owner;
                if (owner != null) {
                    AppState appStateCopy$default2 = AppState.copy$default(appState2, AppStateStep.WAITING_COMPLETE_PROFILE, null, null, 0, 0L, 30, null);
                    PreferencesModule preferencesModule3 = this.preferences;
                    c10161.L$0 = cb.l.a(str3);
                    c10161.L$1 = cb.l.a(appState2);
                    c10161.L$2 = dataWrapper;
                    c10161.L$3 = cb.l.a(protoUserRegisterResponse);
                    c10161.L$4 = cb.l.a(account);
                    c10161.L$5 = cb.l.a(owner);
                    c10161.L$6 = cb.l.a(appStateCopy$default2);
                    z10 = false;
                    c10161.I$0 = 0;
                    c10161.I$1 = 0;
                    c10161.label = 3;
                    appState3 = preferencesModule3.setAppState(appStateCopy$default2, c10161);
                    if (appState3 != objG) {
                        dataWrapper2 = dataWrapper;
                        appState4 = appState3;
                        cb.b.a(((Boolean) appState4).booleanValue());
                        dataWrapper = dataWrapper2;
                    }
                }
                throwable = dataWrapper.getThrowable();
                if (throwable != null) {
                    if (throwable instanceof mi.p) {
                        Function1 function7 = this.setError;
                        String string7 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                        kotlin.jvm.internal.y.h(string7, "getString(...)");
                        function7.invoke(new ToDusException(string7, null, false, 6, null));
                    } else {
                        Function1 function8 = this.setError;
                        String string8 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                        kotlin.jvm.internal.y.h(string8, "getString(...)");
                        function8.invoke(new ToDusException(string8, null, false, 6, null));
                    }
                    throwable.printStackTrace();
                }
                if (dataWrapper.getCode() == 200) {
                    z11 = true;
                } else {
                    z11 = z10;
                }
                return cb.b.a(z11);
            }
            z10 = false;
            throwable = dataWrapper.getThrowable();
            if (throwable != null) {
                if (throwable instanceof mi.p) {
                    Function1 function9 = this.setError;
                    String string9 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                    kotlin.jvm.internal.y.h(string9, "getString(...)");
                    function9.invoke(new ToDusException(string9, null, false, 6, null));
                } else {
                    Function1 function10 = this.setError;
                    String string10 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                    kotlin.jvm.internal.y.h(string10, "getString(...)");
                    function10.invoke(new ToDusException(string10, null, false, 6, null));
                }
                throwable.printStackTrace();
            }
            if (dataWrapper.getCode() == 200) {
                z11 = true;
            } else {
                z11 = z10;
            }
            return cb.b.a(z11);
        }
        return objG;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008b  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b9, code lost:
    
        if (r2.setAppState(r3, r0) == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ec, code lost:
    
        if (r2.setAppState(r4, r0) == r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object retryVerify(ab.e<? super ua.k0> r15) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.AuthRepository.retryVerify(ab.e):java.lang.Object");
    }

    public final void setOwner(Owner owner) {
        this.owner = owner;
    }

    public final void updateOwner(Owner owner) {
        kotlin.jvm.internal.y.i(owner, "owner");
        this.owner = owner;
        CoroutineUtilsKt.launchWithContext$default(pe.n0.a(d1.b().plus(e2.b(null, 1, null))), null, null, new C10181(owner, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:37:0x0110  */
    /* JADX WARN: Code duplicated, block: B:39:0x0117  */
    /* JADX WARN: Code duplicated, block: B:42:0x0147  */
    /* JADX WARN: Code duplicated, block: B:44:0x014b  */
    /* JADX WARN: Code duplicated, block: B:52:0x017b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0184  */
    /* JADX WARN: Code duplicated, block: B:55:0x0189  */
    /* JADX WARN: Code duplicated, block: B:57:0x018c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0192  */
    /* JADX WARN: Code duplicated, block: B:63:0x019e  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object verifyPhoneNumber(String str, int i10, String str2, ab.e<? super Boolean> eVar) {
        C10191 c10191;
        int i11;
        String str3;
        DataWrapper dataWrapper;
        int i12;
        String str4;
        String str5;
        int i13;
        PreferencesModule preferencesModule;
        AppState appStateCopy;
        String str6;
        int i14;
        Throwable throwable;
        boolean z10;
        mi.p pVar;
        mi.a0 a0VarC;
        nf.h0 h0VarE;
        mi.a0 a0VarC2;
        String string;
        nf.h0 h0VarE2;
        Throwable th2;
        String str7 = str;
        String str8 = str2;
        if (eVar instanceof C10191) {
            c10191 = (C10191) eVar;
            int i15 = c10191.label;
            if ((i15 & Integer.MIN_VALUE) != 0) {
                c10191.label = i15 - Integer.MIN_VALUE;
            } else {
                c10191 = new C10191(eVar);
            }
        } else {
            c10191 = new C10191(eVar);
        }
        Object objReserve = c10191.result;
        Object objG = bb.b.g();
        int i16 = c10191.label;
        if (i16 == 0) {
            ua.v.b(objReserve);
            AuthDataSource authDataSource = this.authDataSource;
            c10191.L$0 = str7;
            c10191.L$1 = str8;
            i11 = i10;
            c10191.I$0 = i11;
            c10191.label = 1;
            objReserve = authDataSource.reserve(str7, str8, c10191);
            if (objReserve != objG) {
            }
            return objG;
        }
        if (i16 == 1) {
            int i17 = c10191.I$0;
            str8 = (String) c10191.L$1;
            String str9 = (String) c10191.L$0;
            ua.v.b(objReserve);
            i11 = i17;
            str7 = str9;
        } else {
            if (i16 == 2) {
                int i18 = c10191.I$0;
                dataWrapper = (DataWrapper) c10191.L$2;
                String str10 = (String) c10191.L$1;
                String str11 = (String) c10191.L$0;
                ua.v.b(objReserve);
                i13 = i18;
                str5 = str10;
                str4 = str11;
                AppState appState = (AppState) objReserve;
                preferencesModule = this.preferences;
                appStateCopy = appState.copy(AppStateStep.WAITING_REGISTER, str4, str5, i13, new Date().getTime());
                c10191.L$0 = cb.l.a(str4);
                c10191.L$1 = cb.l.a(str5);
                c10191.L$2 = dataWrapper;
                c10191.L$3 = cb.l.a(appState);
                c10191.I$0 = i13;
                c10191.label = 3;
                if (preferencesModule.setAppState(appStateCopy, c10191) != objG) {
                    str6 = str4;
                    str3 = str5;
                    i14 = i13;
                    i12 = i14;
                    str7 = str6;
                    throwable = dataWrapper.getThrowable();
                    if (throwable != null) {
                        if (throwable instanceof ConnectException) {
                            z10 = throwable instanceof mi.p;
                            if (!z10) {
                            }
                            if (z10) {
                                pVar = (mi.p) throwable;
                                a0VarC = pVar.c();
                                if (a0VarC != null) {
                                    h0VarE = a0VarC.e();
                                } else {
                                    h0VarE = null;
                                }
                                if (h0VarE != null) {
                                    a0VarC2 = pVar.c();
                                    if (a0VarC2 != null) {
                                        string = "";
                                    } else {
                                        string = "";
                                    }
                                    BaseResponse baseResponse = (BaseResponse) new v5.f().j(string, BaseResponse.class);
                                    Function1 function1 = this.setError;
                                    String error = baseResponse.getError();
                                    kotlin.jvm.internal.y.f(error);
                                    function1.invoke(new PhoneAuthException(error));
                                    ua.k0 k0Var = ua.k0.f43947a;
                                } else {
                                    Function1 function2 = this.setError;
                                    String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                                    kotlin.jvm.internal.y.h(string2, "getString(...)");
                                    function2.invoke(new ToDusException(string2, new lb.a() { // from class: cu.todus.android.repositories.c
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    }, false));
                                    ua.k0 k0Var2 = ua.k0.f43947a;
                                }
                            } else {
                                Function1 function3 = this.setError;
                                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                                kotlin.jvm.internal.y.h(string3, "getString(...)");
                                function3.invoke(new ToDusException(string3, new lb.a() { // from class: cu.todus.android.repositories.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                }, false));
                                ua.k0 k0Var3 = ua.k0.f43947a;
                            }
                        } else {
                            z10 = throwable instanceof mi.p;
                            if (!z10) {
                            }
                            if (z10) {
                                Function1 function4 = this.setError;
                                String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                                kotlin.jvm.internal.y.h(string4, "getString(...)");
                                function4.invoke(new ToDusException(string4, new lb.a() { // from class: cu.todus.android.repositories.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                }, false));
                                ua.k0 k0Var4 = ua.k0.f43947a;
                            } else {
                                pVar = (mi.p) throwable;
                                a0VarC = pVar.c();
                                if (a0VarC != null) {
                                    h0VarE = a0VarC.e();
                                } else {
                                    h0VarE = null;
                                }
                                if (h0VarE != null) {
                                    a0VarC2 = pVar.c();
                                    if (a0VarC2 != null) {
                                        string = "";
                                    } else {
                                        string = "";
                                    }
                                    BaseResponse baseResponse2 = (BaseResponse) new v5.f().j(string, BaseResponse.class);
                                    Function1 function5 = this.setError;
                                    String error2 = baseResponse2.getError();
                                    kotlin.jvm.internal.y.f(error2);
                                    function5.invoke(new PhoneAuthException(error2));
                                    ua.k0 k0Var5 = ua.k0.f43947a;
                                } else {
                                    Function1 function6 = this.setError;
                                    String string5 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                                    kotlin.jvm.internal.y.h(string5, "getString(...)");
                                    function6.invoke(new ToDusException(string5, new lb.a() { // from class: cu.todus.android.repositories.c
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    }, false));
                                    ua.k0 k0Var6 = ua.k0.f43947a;
                                }
                            }
                        }
                        throwable.printStackTrace();
                    }
                    return cb.b.a(dataWrapper.getResponseOkButNull());
                }
                return objG;
            }
            if (i16 == 3) {
                i14 = c10191.I$0;
                dataWrapper = (DataWrapper) c10191.L$2;
                str3 = (String) c10191.L$1;
                str6 = (String) c10191.L$0;
                ua.v.b(objReserve);
                i12 = i14;
                str7 = str6;
                throwable = dataWrapper.getThrowable();
                if (throwable != null) {
                    if ((throwable instanceof ConnectException) || dataWrapper.getCode() != 508) {
                        z10 = throwable instanceof mi.p;
                        if (!z10 && ((mi.p) throwable).a() == 418) {
                            PreferencesModule preferencesModule2 = this.preferences;
                            c10191.L$0 = cb.l.a(str7);
                            c10191.L$1 = cb.l.a(str3);
                            c10191.L$2 = dataWrapper;
                            c10191.L$3 = throwable;
                            c10191.I$0 = i12;
                            c10191.I$1 = 0;
                            c10191.label = 4;
                            if (preferencesModule2.setBannedUser(c10191) != objG) {
                                th2 = throwable;
                            }
                            return objG;
                        }
                        if (z10) {
                            Function1 function7 = this.setError;
                            String string6 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                            kotlin.jvm.internal.y.h(string6, "getString(...)");
                            function7.invoke(new ToDusException(string6, new lb.a() { // from class: cu.todus.android.repositories.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            }, false));
                            ua.k0 k0Var7 = ua.k0.f43947a;
                        } else {
                            pVar = (mi.p) throwable;
                            a0VarC = pVar.c();
                            if (a0VarC != null) {
                                h0VarE = a0VarC.e();
                            } else {
                                h0VarE = null;
                            }
                            if (h0VarE != null) {
                                a0VarC2 = pVar.c();
                                if (a0VarC2 != null || (h0VarE2 = a0VarC2.e()) == null || (string = h0VarE2.toString()) == null) {
                                    string = "";
                                }
                                try {
                                    BaseResponse baseResponse3 = (BaseResponse) new v5.f().j(string, BaseResponse.class);
                                    Function1 function8 = this.setError;
                                    String error3 = baseResponse3.getError();
                                    kotlin.jvm.internal.y.f(error3);
                                    function8.invoke(new PhoneAuthException(error3));
                                } catch (Exception unused) {
                                    Function1 function9 = this.setError;
                                    String string7 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                                    kotlin.jvm.internal.y.h(string7, "getString(...)");
                                    function9.invoke(new ToDusException(string7, new lb.a() { // from class: cu.todus.android.repositories.b
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    }, false));
                                }
                                ua.k0 k0Var8 = ua.k0.f43947a;
                            } else {
                                Function1 function10 = this.setError;
                                String string8 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                                kotlin.jvm.internal.y.h(string8, "getString(...)");
                                function10.invoke(new ToDusException(string8, new lb.a() { // from class: cu.todus.android.repositories.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                }, false));
                                ua.k0 k0Var9 = ua.k0.f43947a;
                            }
                        }
                    } else {
                        Function1 function11 = this.setError;
                        String string9 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.certificate_error);
                        kotlin.jvm.internal.y.h(string9, "getString(...)");
                        function11.invoke(new ToDusException(string9, new lb.a() { // from class: cu.todus.android.repositories.a
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        }, false));
                        ua.k0 k0Var10 = ua.k0.f43947a;
                    }
                    throwable.printStackTrace();
                }
                return cb.b.a(dataWrapper.getResponseOkButNull());
            }
            if (i16 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            th2 = (Throwable) c10191.L$3;
            dataWrapper = (DataWrapper) c10191.L$2;
            ua.v.b(objReserve);
        }
        throwable = th2;
        throwable.printStackTrace();
        return cb.b.a(dataWrapper.getResponseOkButNull());
        DataWrapper dataWrapper2 = (DataWrapper) objReserve;
        if (!dataWrapper2.getResponseOkButNull()) {
            int i19 = i11;
            str3 = str8;
            dataWrapper = dataWrapper2;
            i12 = i19;
            throwable = dataWrapper.getThrowable();
            if (throwable != null) {
                if (throwable instanceof ConnectException) {
                    z10 = throwable instanceof mi.p;
                    if (!z10) {
                    }
                    if (z10) {
                        Function1 function12 = this.setError;
                        String string10 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                        kotlin.jvm.internal.y.h(string10, "getString(...)");
                        function12.invoke(new ToDusException(string10, new lb.a() { // from class: cu.todus.android.repositories.c
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        }, false));
                        ua.k0 k0Var11 = ua.k0.f43947a;
                    } else {
                        pVar = (mi.p) throwable;
                        a0VarC = pVar.c();
                        if (a0VarC != null) {
                            h0VarE = a0VarC.e();
                        } else {
                            h0VarE = null;
                        }
                        if (h0VarE != null) {
                            a0VarC2 = pVar.c();
                            if (a0VarC2 != null) {
                                string = "";
                            } else {
                                string = "";
                            }
                            BaseResponse baseResponse4 = (BaseResponse) new v5.f().j(string, BaseResponse.class);
                            Function1 function13 = this.setError;
                            String error4 = baseResponse4.getError();
                            kotlin.jvm.internal.y.f(error4);
                            function13.invoke(new PhoneAuthException(error4));
                            ua.k0 k0Var12 = ua.k0.f43947a;
                        } else {
                            Function1 function14 = this.setError;
                            String string11 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                            kotlin.jvm.internal.y.h(string11, "getString(...)");
                            function14.invoke(new ToDusException(string11, new lb.a() { // from class: cu.todus.android.repositories.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            }, false));
                            ua.k0 k0Var13 = ua.k0.f43947a;
                        }
                    }
                } else {
                    z10 = throwable instanceof mi.p;
                    if (!z10) {
                    }
                    if (z10) {
                        Function1 function15 = this.setError;
                        String string12 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                        kotlin.jvm.internal.y.h(string12, "getString(...)");
                        function15.invoke(new ToDusException(string12, new lb.a() { // from class: cu.todus.android.repositories.c
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        }, false));
                        ua.k0 k0Var14 = ua.k0.f43947a;
                    } else {
                        pVar = (mi.p) throwable;
                        a0VarC = pVar.c();
                        if (a0VarC != null) {
                            h0VarE = a0VarC.e();
                        } else {
                            h0VarE = null;
                        }
                        if (h0VarE != null) {
                            a0VarC2 = pVar.c();
                            if (a0VarC2 != null) {
                                string = "";
                            } else {
                                string = "";
                            }
                            BaseResponse baseResponse5 = (BaseResponse) new v5.f().j(string, BaseResponse.class);
                            Function1 function16 = this.setError;
                            String error5 = baseResponse5.getError();
                            kotlin.jvm.internal.y.f(error5);
                            function16.invoke(new PhoneAuthException(error5));
                            ua.k0 k0Var15 = ua.k0.f43947a;
                        } else {
                            Function1 function17 = this.setError;
                            String string13 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                            kotlin.jvm.internal.y.h(string13, "getString(...)");
                            function17.invoke(new ToDusException(string13, new lb.a() { // from class: cu.todus.android.repositories.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            }, false));
                            ua.k0 k0Var16 = ua.k0.f43947a;
                        }
                    }
                }
                throwable.printStackTrace();
            }
            return cb.b.a(dataWrapper.getResponseOkButNull());
        }
        PreferencesModule preferencesModule3 = this.preferences;
        c10191.L$0 = str7;
        c10191.L$1 = str8;
        c10191.L$2 = dataWrapper2;
        c10191.I$0 = i11;
        c10191.label = 2;
        Object appState2 = preferencesModule3.getAppState(c10191);
        if (appState2 != objG) {
            str4 = str7;
            str5 = str8;
            dataWrapper = dataWrapper2;
            i13 = i11;
            objReserve = appState2;
            AppState appState3 = (AppState) objReserve;
            preferencesModule = this.preferences;
            appStateCopy = appState3.copy(AppStateStep.WAITING_REGISTER, str4, str5, i13, new Date().getTime());
            c10191.L$0 = cb.l.a(str4);
            c10191.L$1 = cb.l.a(str5);
            c10191.L$2 = dataWrapper;
            c10191.L$3 = cb.l.a(appState3);
            c10191.I$0 = i13;
            c10191.label = 3;
            if (preferencesModule.setAppState(appStateCopy, c10191) != objG) {
                str6 = str4;
                str3 = str5;
                i14 = i13;
                i12 = i14;
                str7 = str6;
                throwable = dataWrapper.getThrowable();
                if (throwable != null) {
                    if (throwable instanceof ConnectException) {
                        z10 = throwable instanceof mi.p;
                        if (!z10) {
                        }
                        if (z10) {
                            Function1 function18 = this.setError;
                            String string14 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                            kotlin.jvm.internal.y.h(string14, "getString(...)");
                            function18.invoke(new ToDusException(string14, new lb.a() { // from class: cu.todus.android.repositories.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            }, false));
                            ua.k0 k0Var17 = ua.k0.f43947a;
                        } else {
                            pVar = (mi.p) throwable;
                            a0VarC = pVar.c();
                            if (a0VarC != null) {
                                h0VarE = a0VarC.e();
                            } else {
                                h0VarE = null;
                            }
                            if (h0VarE != null) {
                                a0VarC2 = pVar.c();
                                if (a0VarC2 != null) {
                                    string = "";
                                } else {
                                    string = "";
                                }
                                BaseResponse baseResponse6 = (BaseResponse) new v5.f().j(string, BaseResponse.class);
                                Function1 function19 = this.setError;
                                String error6 = baseResponse6.getError();
                                kotlin.jvm.internal.y.f(error6);
                                function19.invoke(new PhoneAuthException(error6));
                                ua.k0 k0Var18 = ua.k0.f43947a;
                            } else {
                                Function1 function110 = this.setError;
                                String string15 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                                kotlin.jvm.internal.y.h(string15, "getString(...)");
                                function110.invoke(new ToDusException(string15, new lb.a() { // from class: cu.todus.android.repositories.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                }, false));
                                ua.k0 k0Var19 = ua.k0.f43947a;
                            }
                        }
                    } else {
                        z10 = throwable instanceof mi.p;
                        if (!z10) {
                        }
                        if (z10) {
                            Function1 function111 = this.setError;
                            String string16 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                            kotlin.jvm.internal.y.h(string16, "getString(...)");
                            function111.invoke(new ToDusException(string16, new lb.a() { // from class: cu.todus.android.repositories.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            }, false));
                            ua.k0 k0Var110 = ua.k0.f43947a;
                        } else {
                            pVar = (mi.p) throwable;
                            a0VarC = pVar.c();
                            if (a0VarC != null) {
                                h0VarE = a0VarC.e();
                            } else {
                                h0VarE = null;
                            }
                            if (h0VarE != null) {
                                a0VarC2 = pVar.c();
                                if (a0VarC2 != null) {
                                    string = "";
                                } else {
                                    string = "";
                                }
                                BaseResponse baseResponse7 = (BaseResponse) new v5.f().j(string, BaseResponse.class);
                                Function1 function112 = this.setError;
                                String error7 = baseResponse7.getError();
                                kotlin.jvm.internal.y.f(error7);
                                function112.invoke(new PhoneAuthException(error7));
                                ua.k0 k0Var111 = ua.k0.f43947a;
                            } else {
                                Function1 function113 = this.setError;
                                String string17 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
                                kotlin.jvm.internal.y.h(string17, "getString(...)");
                                function113.invoke(new ToDusException(string17, new lb.a() { // from class: cu.todus.android.repositories.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                }, false));
                                ua.k0 k0Var112 = ua.k0.f43947a;
                            }
                        }
                    }
                    throwable.printStackTrace();
                }
                return cb.b.a(dataWrapper.getResponseOkButNull());
            }
        }
        return objG;
    }
}
