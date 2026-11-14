package cu.todus.android;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.ToDusApp$startApp$1$11", f = "ToDusApp.kt", l = {223, WebmConstants.MkvEbmlElement.TIMESTAMP}, m = "emit", v = 2)
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ToDusApp$startApp$1$11$emit$1 extends cb.d {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ToDusApp.C09551.AnonymousClass11<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ToDusApp$startApp$1$11$emit$1(ToDusApp.C09551.AnonymousClass11<? super T> anonymousClass11, ab.e<? super ToDusApp$startApp$1$11$emit$1> eVar) {
        super(eVar);
        this.this$0 = anonymousClass11;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type ab.e to cu.todus.android.ToDusApp$startApp$1$11$emit$1 for r1v1 'this'  ab.e
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // cb.a
    public final java.lang.Object invokeSuspend(java.lang.Object r2) {
        /*
            r1 = this;
            r1.result = r2
            int r2 = r1.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 | r0
            r1.label = r2
            cu.todus.android.ToDusApp$startApp$1$11<T> r2 = r1.this$0
            r0 = 0
            java.lang.Object r2 = r2.emit(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.ToDusApp$startApp$1$11$emit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
