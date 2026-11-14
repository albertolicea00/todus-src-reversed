package cu.todus.android.notification;

import ab.e;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.muxer.WebmConstants;
import cb.d;
import cb.f;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.notification.NotificationManager$1$1", f = "NotificationManager.kt", l = {WebmConstants.MAX_META_SEEK_SIZE, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m = "emit", v = 2)
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class NotificationManager$1$1$emit$1 extends d {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationManager.AnonymousClass1.C02031<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NotificationManager$1$1$emit$1(NotificationManager.AnonymousClass1.C02031<? super T> c02031, e<? super NotificationManager$1$1$emit$1> eVar) {
        super(eVar);
        this.this$0 = c02031;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type ab.e to cu.todus.android.notification.NotificationManager$1$1$emit$1 for r1v1 'this'  ab.e
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
            cu.todus.android.notification.NotificationManager$1$1<T> r2 = r1.this$0
            r0 = 0
            java.lang.Object r2 = r2.emit(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.notification.NotificationManager$1$1$emit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
