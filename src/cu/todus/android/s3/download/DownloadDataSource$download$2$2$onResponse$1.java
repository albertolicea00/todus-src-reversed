package cu.todus.android.s3.download;

import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.notification.NotificationManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y0;
import nf.e;
import pe.m0;
import re.u;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.s3.download.DownloadDataSource$download$2$2$onResponse$1", f = "DownloadDataSource.kt", l = {405, 406}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class DownloadDataSource$download$2$2$onResponse$1 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ Attachment $attObj;
    final /* synthetic */ Attachment $attachment;
    final /* synthetic */ e $call;
    final /* synthetic */ y0 $call$1;
    final /* synthetic */ m0 $downloadScope;
    final /* synthetic */ u0 $isSuccess;
    final /* synthetic */ NotificationManager $sysNotifier;
    int label;
    final /* synthetic */ DownloadDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDataSource$download$2$2$onResponse$1(e eVar, DownloadDataSource downloadDataSource, Attachment attachment, u uVar, m0 m0Var, y0 y0Var, u0 u0Var, NotificationManager notificationManager, Attachment attachment2, ab.e<? super DownloadDataSource$download$2$2$onResponse$1> eVar2) {
        super(2, eVar2);
        this.$call = eVar;
        this.this$0 = downloadDataSource;
        this.$attObj = attachment;
        this.$$this$callbackFlow = uVar;
        this.$downloadScope = m0Var;
        this.$call$1 = y0Var;
        this.$isSuccess = u0Var;
        this.$sysNotifier = notificationManager;
        this.$attachment = attachment2;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new DownloadDataSource$download$2$2$onResponse$1(this.$call, this.this$0, this.$attObj, this.$$this$callbackFlow, this.$downloadScope, this.$call$1, this.$isSuccess, this.$sysNotifier, this.$attachment, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r14, r1, r13) == r0) goto L17;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            ua.v.b(r14)
            goto L56
        L12:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L1a:
            ua.v.b(r14)
            goto L47
        L1e:
            ua.v.b(r14)
            nf.e r14 = r13.$call
            boolean r14 = r14.c()
            if (r14 != 0) goto L67
            cu.todus.android.s3.download.DownloadDataSource r14 = r13.this$0
            kotlin.jvm.functions.Function2 r14 = cu.todus.android.s3.download.DownloadDataSource.access$getUpdateAttachment$p(r14)
            cu.todus.android.data.db.entity.toDus.Attachment r4 = r13.$attObj
            r11 = 55
            r12 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 4
            r9 = 0
            r10 = 0
            cu.todus.android.data.db.entity.toDus.Attachment r1 = cu.todus.android.data.db.entity.toDus.Attachment.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.label = r3
            java.lang.Object r14 = r14.invoke(r1, r13)
            if (r14 != r0) goto L47
            goto L55
        L47:
            re.u r14 = r13.$$this$callbackFlow
            java.lang.Boolean r1 = cb.b.a(r3)
            r13.label = r2
            java.lang.Object r14 = cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r14, r1, r13)
            if (r14 != r0) goto L56
        L55:
            return r0
        L56:
            pe.m0 r1 = r13.$downloadScope
            kotlin.jvm.internal.y0 r2 = r13.$call$1
            cu.todus.android.s3.download.DownloadDataSource r3 = r13.this$0
            kotlin.jvm.internal.u0 r4 = r13.$isSuccess
            cu.todus.android.notification.NotificationManager r5 = r13.$sysNotifier
            cu.todus.android.data.db.entity.toDus.Attachment r6 = r13.$attachment
            re.u r7 = r13.$$this$callbackFlow
            cu.todus.android.s3.download.DownloadDataSource.AnonymousClass2.access$invokeSuspend$close(r1, r2, r3, r4, r5, r6, r7)
        L67:
            ua.k0 r14 = ua.k0.f43947a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource$download$2$2$onResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((DownloadDataSource$download$2$2$onResponse$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
