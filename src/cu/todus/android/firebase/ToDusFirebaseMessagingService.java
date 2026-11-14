package cu.todus.android.firebase;

import ab.e;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import cb.f;
import cb.m;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.o0;
import cu.todus.android.ToDusApp;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcu/todus/android/firebase/ToDusFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "", "token", "Lua/k0;", "sendRegistrationToServer", "(Ljava/lang/String;)V", "sendNotification", "Lcom/google/firebase/messaging/o0;", "remoteMessage", "onMessageReceived", "(Lcom/google/firebase/messaging/o0;)V", "onNewToken", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "getCoroutineScope", "()Lpe/m0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ToDusFirebaseMessagingService extends FirebaseMessagingService {
    public static final int $stable = 8;
    private final m0 coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));

    /* JADX INFO: renamed from: cu.todus.android.firebase.ToDusFirebaseMessagingService$sendRegistrationToServer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.firebase.ToDusFirebaseMessagingService$sendRegistrationToServer$1", f = "ToDusFirebaseMessagingService.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$token = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return new AnonymousClass1(this.$token, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                instanceOrNull.savePushToken(this.$token);
            }
            return k0.f43947a;
        }
    }

    private final void sendNotification() {
        Context appContext;
        try {
            MainModule instanceOrNull = MainModule.INSTANCE.getInstanceOrNull();
            if (instanceOrNull == null || (appContext = instanceOrNull.getAppContext()) == null) {
                return;
            }
            ToDusApp.manageAlive$default((ToDusApp) appContext, null, false, 3, null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void sendRegistrationToServer(String token) {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new AnonymousClass1(token, null), 3, null);
    }

    public final m0 getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(o0 remoteMessage) {
        y.i(remoteMessage, "remoteMessage");
        Map data = remoteMessage.getData();
        y.f(data);
        data.isEmpty();
        remoteMessage.b();
        sendNotification();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        y.i(token, "token");
        sendRegistrationToServer(token);
    }
}
