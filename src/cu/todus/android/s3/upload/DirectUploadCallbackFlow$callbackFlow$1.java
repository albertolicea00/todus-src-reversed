package cu.todus.android.s3.upload;

import androidx.media3.muxer.WebmConstants;
import cb.l;
import cb.m;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.rest.TokenAuthenticator;
import cu.todus.android.utils.CoroutineUtilsKt;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import nf.a0;
import nf.c0;
import nf.e0;
import nf.f0;
import nf.g0;
import pe.k;
import pe.m0;
import re.s;
import re.u;
import re.w;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.s3.upload.DirectUploadCallbackFlow$callbackFlow$1", f = "DirectUploadCallbackFlow.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_DURATION}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "Lcu/todus/android/s3/upload/DirectUploadState;", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
public final class DirectUploadCallbackFlow$callbackFlow$1 extends m implements Function2 {
    final /* synthetic */ DirectUploadState $directUploadState;
    final /* synthetic */ File $file;
    final /* synthetic */ String $header;
    final /* synthetic */ m0 $scope;
    final /* synthetic */ URL $url;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DirectUploadCallbackFlow this$0;

    /* JADX INFO: renamed from: cu.todus.android.s3.upload.DirectUploadCallbackFlow$callbackFlow$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.s3.upload.DirectUploadCallbackFlow$callbackFlow$1$2", f = "DirectUploadCallbackFlow.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function1 {
        final /* synthetic */ u $$this$callbackFlow;
        int label;
        final /* synthetic */ DirectUploadCallbackFlow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DirectUploadCallbackFlow directUploadCallbackFlow, u uVar, ab.e<? super AnonymousClass2> eVar) {
            super(1, eVar);
            this.this$0 = directUploadCallbackFlow;
            this.$$this$callbackFlow = uVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new AnonymousClass2(this.this$0, this.$$this$callbackFlow, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            while (true) {
                if (this.this$0.hasToClose) {
                    DirectUploadCallbackFlow$callbackFlow$1.invokeSuspend$close(this.$$this$callbackFlow);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectUploadCallbackFlow$callbackFlow$1(File file, URL url, m0 m0Var, String str, DirectUploadState directUploadState, DirectUploadCallbackFlow directUploadCallbackFlow, ab.e<? super DirectUploadCallbackFlow$callbackFlow$1> eVar) {
        super(2, eVar);
        this.$file = file;
        this.$url = url;
        this.$scope = m0Var;
        this.$header = str;
        this.$directUploadState = directUploadState;
        this.this$0 = directUploadCallbackFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$close(u uVar) {
        w.a.a(uVar.getChannel(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$1(nf.e eVar) {
        if (!eVar.c()) {
            eVar.cancel();
        }
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        DirectUploadCallbackFlow$callbackFlow$1 directUploadCallbackFlow$callbackFlow$1 = new DirectUploadCallbackFlow$callbackFlow$1(this.$file, this.$url, this.$scope, this.$header, this.$directUploadState, this.this$0, eVar);
        directUploadCallbackFlow$callbackFlow$1.L$0 = obj;
        return directUploadCallbackFlow$callbackFlow$1;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        final u uVar = (u) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            c0.a aVarA = new c0().A();
            String str = this.$header;
            Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = RetrofitModule.INSTANCE.allowAllCertificated();
            if (pairAllowAllCertificated != null) {
                aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
                aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.s3.upload.a
                    @Override // javax.net.ssl.HostnameVerifier
                    public final boolean verify(String str2, SSLSession sSLSession) {
                        return DirectUploadCallbackFlow$callbackFlow$1.invokeSuspend$lambda$0$0$0(str2, sSLSession);
                    }
                });
            }
            aVarA.O(false);
            aVarA.a(TokenAuthenticator.INSTANCE.headerWithAuth(str, true));
            c0 c0VarD = aVarA.d();
            f0 f0VarB = f0.f38560a.b(this.$file, a0.f38429e.b("application/octet-stream"));
            final DirectUploadState directUploadState = this.$directUploadState;
            final m0 m0Var = this.$scope;
            f0 f0VarA = io.github.lizhangqu.coreprogress.b.a(f0VarB, new io.github.lizhangqu.coreprogress.d() { // from class: cu.todus.android.s3.upload.DirectUploadCallbackFlow$callbackFlow$1$requestBody$1
                @Override // io.github.lizhangqu.coreprogress.d
                public void onProgressChanged(long numBytes, long totalBytes, float percent, float speed) {
                    directUploadState.setStatus(1);
                    directUploadState.setTotalBytes(totalBytes);
                    directUploadState.setPercent(100 * percent);
                    directUploadState.setNumBytes(numBytes);
                    directUploadState.setSpeed(speed);
                    k.d(m0Var, null, null, new DirectUploadCallbackFlow$callbackFlow$1$requestBody$1$onProgressChanged$1(uVar, directUploadState, null), 3, null);
                }

                @Override // io.github.lizhangqu.coreprogress.d
                public void onProgressFinish() {
                    super.onProgressFinish();
                }

                @Override // io.github.lizhangqu.coreprogress.d
                public void onProgressStart(long totalBytes) {
                    super.onProgressStart(totalBytes);
                    directUploadState.setStatus(0);
                    directUploadState.setTotalBytes(totalBytes);
                    k.d(m0Var, null, null, new DirectUploadCallbackFlow$callbackFlow$1$requestBody$1$onProgressStart$1(uVar, directUploadState, null), 3, null);
                }
            });
            e0.a aVarT = new e0.a().t(this.$url);
            y.f(f0VarA);
            aVarT.o(f0VarA);
            final nf.e eVarA = c0VarD.a(aVarT.b());
            final DirectUploadState directUploadState2 = this.$directUploadState;
            final m0 m0Var2 = this.$scope;
            eVarA.j(new nf.f() { // from class: cu.todus.android.s3.upload.DirectUploadCallbackFlow$callbackFlow$1.1
                @Override // nf.f
                public void onFailure(nf.e call, IOException e10) {
                    y.i(call, "call");
                    y.i(e10, "e");
                    directUploadState2.setStatus(3);
                    k.d(m0Var2, null, null, new DirectUploadCallbackFlow$callbackFlow$1$1$onFailure$1(uVar, directUploadState2, null), 3, null);
                }

                @Override // nf.f
                public void onResponse(nf.e call, g0 response) throws IOException {
                    y.i(call, "call");
                    y.i(response, "response");
                    response.j();
                    if (response.E() && response.j() == 200) {
                        directUploadState2.setStatus(2);
                        k.d(m0Var2, null, null, new DirectUploadCallbackFlow$callbackFlow$1$1$onResponse$2(uVar, directUploadState2, null), 3, null);
                    } else {
                        directUploadState2.setStatus(3);
                        k.d(m0Var2, null, null, new DirectUploadCallbackFlow$callbackFlow$1$1$onResponse$1(uVar, directUploadState2, null), 3, null);
                    }
                }
            });
            CoroutineUtilsKt.launchWithContext$default(this.$scope, null, null, new AnonymousClass2(this.this$0, uVar, null), 3, null);
            lb.a aVar = new lb.a() { // from class: cu.todus.android.s3.upload.b
                @Override // lb.a
                public final Object invoke() {
                    return DirectUploadCallbackFlow$callbackFlow$1.invokeSuspend$lambda$1(eVarA);
                }
            };
            this.L$0 = l.a(uVar);
            this.L$1 = l.a(c0VarD);
            this.L$2 = l.a(f0VarA);
            this.L$3 = l.a(aVarT);
            this.L$4 = l.a(eVarA);
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
    public final Object invoke(u uVar, ab.e<? super k0> eVar) {
        return ((DirectUploadCallbackFlow$callbackFlow$1) create(uVar, eVar)).invokeSuspend(k0.f43947a);
    }
}
