package cu.todus.android.rest;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import cb.d;
import cb.f;
import cb.l;
import cb.m;
import java.io.IOException;
import java.net.InetAddress;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import le.a0;
import pe.d1;
import pe.i;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcu/todus/android/rest/IPChecker;", "", "<init>", "()V", "", "ip", "", "timeout", "", "checkIp", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IPChecker {
    public static final int $stable = 0;
    public static final IPChecker INSTANCE = new IPChecker();

    /* JADX INFO: renamed from: cu.todus.android.rest.IPChecker$checkIp$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.IPChecker", f = "IPChecker.kt", l = {13}, m = "checkIp", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IPChecker.this.checkIp(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.IPChecker$checkIp$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.IPChecker$checkIp$2", f = "IPChecker.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ String $ip;
        final /* synthetic */ u0 $result;
        final /* synthetic */ int $timeout;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, int i10, u0 u0Var, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$ip = str;
            this.$timeout = i10;
            this.$result = u0Var;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass2(this.$ip, this.$timeout, this.$result, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws IOException {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            InetAddress.getByName(a0.O(a0.O(a0.O(this.$ip, "http://", "", false, 4, null), "https://", "", false, 4, null), "/", "", false, 4, null)).isReachable(this.$timeout);
            this.$result.f36629c = true;
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    private IPChecker() {
    }

    public static /* synthetic */ Object checkIp$default(IPChecker iPChecker, String str, int i10, e eVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 3000;
        }
        return iPChecker.checkIp(str, i10, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object checkIp(String str, int i10, e<? super Boolean> eVar) {
        AnonymousClass1 anonymousClass1;
        u0 u0Var;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i11 = anonymousClass1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i11 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object obj = anonymousClass1.result;
        Object objG = bb.b.g();
        int i12 = anonymousClass1.label;
        if (i12 == 0) {
            v.b(obj);
            u0 u0Var2 = new u0();
            try {
                pe.k0 k0VarB = d1.b();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, i10, u0Var2, null);
                anonymousClass1.L$0 = l.a(str);
                anonymousClass1.L$1 = u0Var2;
                anonymousClass1.I$0 = i10;
                anonymousClass1.label = 1;
                if (i.g(k0VarB, anonymousClass2, anonymousClass1) == objG) {
                    return objG;
                }
                u0Var = u0Var2;
            } catch (Exception e10) {
                e = e10;
                u0Var = u0Var2;
                e.printStackTrace();
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0Var = (u0) anonymousClass1.L$1;
            try {
                v.b(obj);
            } catch (Exception e11) {
                e = e11;
                e.printStackTrace();
            }
        }
        return cb.b.a(u0Var.f36629c);
    }
}
