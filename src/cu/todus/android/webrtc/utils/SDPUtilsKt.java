package cu.todus.android.webrtc.utils;

import ab.e;
import ab.k;
import androidx.media3.muxer.WebmConstants;
import bb.b;
import cb.d;
import cb.f;
import cb.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.w;
import ua.k0;
import ua.u;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086H¢\u0006\u0004\b\u0006\u0010\u0007\u001a,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086H¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlin/Function1;", "Lorg/webrtc/SdpObserver;", "Lua/k0;", "call", "Lua/u;", "Lorg/webrtc/SessionDescription;", "createValue", "(Lkotlin/jvm/functions/Function1;Lab/e;)Ljava/lang/Object;", "setValue", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SDPUtilsKt {

    /* JADX INFO: renamed from: cu.todus.android.webrtc.utils.SDPUtilsKt$createValue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.webrtc.utils.SDPUtilsKt", f = "SDPUtils.kt", l = {10}, m = "createValue", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass1 extends d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objCreateValue = SDPUtilsKt.createValue(null, this);
            return objCreateValue == b.g() ? objCreateValue : u.a(objCreateValue);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.utils.SDPUtilsKt$setValue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.webrtc.utils.SDPUtilsKt", f = "SDPUtils.kt", l = {39}, m = "setValue", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C13521 extends d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13521(e<? super C13521> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object value = SDPUtilsKt.setValue(null, this);
            return value == b.g() ? value : u.a(value);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object createValue(Function1 function1, e<? super u> eVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
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
        Object objA = anonymousClass1.result;
        Object objG = b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            v.b(objA);
            anonymousClass1.L$0 = function1;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            k kVar = new k(b.d(anonymousClass1));
            function1.invoke(new SDPUtilsKt$createValue$2$observer$1(kVar));
            objA = kVar.a();
            if (objA == b.g()) {
                h.c(anonymousClass1);
            }
            if (objA == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objA);
        }
        return ((u) objA).j();
    }

    private static final Object createValue$$forInline(Function1 function1, e<? super u> eVar) throws Throwable {
        w.c(0);
        k kVar = new k(b.d(eVar));
        function1.invoke(new SDPUtilsKt$createValue$2$observer$1(kVar));
        k0 k0Var = k0.f43947a;
        Object objA = kVar.a();
        if (objA == b.g()) {
            h.c(eVar);
        }
        w.c(1);
        return ((u) objA).j();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object setValue(Function1 function1, e<? super u> eVar) throws Throwable {
        C13521 c13521;
        if (eVar instanceof C13521) {
            c13521 = (C13521) eVar;
            int i10 = c13521.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13521.label = i10 - Integer.MIN_VALUE;
            } else {
                c13521 = new C13521(eVar);
            }
        } else {
            c13521 = new C13521(eVar);
        }
        Object objA = c13521.result;
        Object objG = b.g();
        int i11 = c13521.label;
        if (i11 == 0) {
            v.b(objA);
            c13521.L$0 = function1;
            c13521.I$0 = 0;
            c13521.label = 1;
            k kVar = new k(b.d(c13521));
            function1.invoke(new SDPUtilsKt$setValue$2$observer$1(kVar));
            objA = kVar.a();
            if (objA == b.g()) {
                h.c(c13521);
            }
            if (objA == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objA);
        }
        return ((u) objA).j();
    }

    private static final Object setValue$$forInline(Function1 function1, e<? super u> eVar) throws Throwable {
        w.c(0);
        k kVar = new k(b.d(eVar));
        function1.invoke(new SDPUtilsKt$setValue$2$observer$1(kVar));
        k0 k0Var = k0.f43947a;
        Object objA = kVar.a();
        if (objA == b.g()) {
            h.c(eVar);
        }
        w.c(1);
        return ((u) objA).j();
    }
}
