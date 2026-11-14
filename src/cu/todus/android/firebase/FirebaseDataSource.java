package cu.todus.android.firebase;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import cb.f;
import cb.l;
import cb.m;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import i4.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.e2;
import pe.k;
import pe.m0;
import pe.n0;
import re.s;
import re.u;
import re.w;
import te.j;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/firebase/FirebaseDataSource;", "", "", "username", "<init>", "(Ljava/lang/String;)V", "Lte/h;", "syncFBToken", "()Lte/h;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FirebaseDataSource {
    public static final int $stable = 8;
    private final m0 coroutineScope;

    /* JADX INFO: renamed from: cu.todus.android.firebase.FirebaseDataSource$syncFBToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.firebase.FirebaseDataSource$syncFBToken$1", f = "FirebaseDataSource.kt", l = {41}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(u uVar) {
            w.a.a(uVar.getChannel(), null, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(FirebaseDataSource firebaseDataSource, u uVar, Task task) {
            if (task.isSuccessful()) {
                k.d(firebaseDataSource.coroutineScope, null, null, new FirebaseDataSource$syncFBToken$1$1$2(uVar, task, null), 3, null);
            } else {
                k.d(firebaseDataSource.coroutineScope, null, null, new FirebaseDataSource$syncFBToken$1$1$1(uVar, null), 3, null);
            }
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            AnonymousClass1 anonymousClass1 = FirebaseDataSource.this.new AnonymousClass1(eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            final u uVar = (u) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                Task taskQ = FirebaseMessaging.n().q();
                final FirebaseDataSource firebaseDataSource = FirebaseDataSource.this;
                taskQ.addOnCompleteListener(new OnCompleteListener() { // from class: cu.todus.android.firebase.a
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        FirebaseDataSource.AnonymousClass1.invokeSuspend$lambda$0(firebaseDataSource, uVar, task);
                    }
                });
                lb.a aVar = new lb.a() { // from class: cu.todus.android.firebase.b
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                this.L$0 = l.a(uVar);
                this.label = 1;
                if (s.a(uVar, aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u uVar, e<? super k0> eVar) {
            return ((AnonymousClass1) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public FirebaseDataSource(String username) {
        y.i(username, "username");
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        h.b().e(username);
    }

    public final te.h syncFBToken() {
        return j.e(new AnonymousClass1(null));
    }
}
