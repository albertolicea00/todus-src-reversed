package cu.todus.android.s3.upload;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.notification.NotificationManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y0;
import nf.g0;
import pe.a2;
import pe.m0;
import re.u;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$upload$2$1$onResponse$1", f = "UploadDataSource.kt", l = {409, TypedValues.CycleType.TYPE_WAVE_PERIOD, TypedValues.CycleType.TYPE_WAVE_OFFSET}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class UploadDataSource$upload$2$1$onResponse$1 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ Attachment $attObj;
    final /* synthetic */ Attachment $attachment;
    final /* synthetic */ y0 $call;
    final /* synthetic */ a2 $cancelWatcherJob;
    final /* synthetic */ String $contentName;
    final /* synthetic */ m0 $downloadScope;
    final /* synthetic */ u0 $isSuccess;
    final /* synthetic */ NotificationManager $notifManager;
    final /* synthetic */ g0 $response;
    final /* synthetic */ long $totalSize;
    int label;
    final /* synthetic */ UploadDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadDataSource$upload$2$1$onResponse$1(a2 a2Var, g0 g0Var, u uVar, u0 u0Var, NotificationManager notificationManager, Attachment attachment, String str, long j10, UploadDataSource uploadDataSource, Attachment attachment2, m0 m0Var, y0 y0Var, ab.e<? super UploadDataSource$upload$2$1$onResponse$1> eVar) {
        super(2, eVar);
        this.$cancelWatcherJob = a2Var;
        this.$response = g0Var;
        this.$$this$callbackFlow = uVar;
        this.$isSuccess = u0Var;
        this.$notifManager = notificationManager;
        this.$attachment = attachment;
        this.$contentName = str;
        this.$totalSize = j10;
        this.this$0 = uploadDataSource;
        this.$attObj = attachment2;
        this.$downloadScope = m0Var;
        this.$call = y0Var;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new UploadDataSource$upload$2$1$onResponse$1(this.$cancelWatcherJob, this.$response, this.$$this$callbackFlow, this.$isSuccess, this.$notifManager, this.$attachment, this.$contentName, this.$totalSize, this.this$0, this.$attObj, this.$downloadScope, this.$call, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
    
        if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r15, r1, r14) == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
    
        if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r15, r1, r14) == r0) goto L26;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r14.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L27
            if (r1 == r4) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            ua.v.b(r15)
            goto L8b
        L16:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L1e:
            ua.v.b(r15)
            goto L7c
        L22:
            ua.v.b(r15)
            goto Lab
        L27:
            ua.v.b(r15)
            pe.a2 r15 = r14.$cancelWatcherJob
            r1 = 0
            pe.a2.a.a(r15, r1, r4, r1)
            nf.g0 r15 = r14.$response
            boolean r15 = r15.E()
            if (r15 == 0) goto L9b
            nf.g0 r15 = r14.$response
            int r15 = r15.j()
            r1 = 200(0xc8, float:2.8E-43)
            if (r15 == r1) goto L43
            goto L9b
        L43:
            kotlin.jvm.internal.u0 r15 = r14.$isSuccess
            r15.f36629c = r4
            cu.todus.android.notification.NotificationManager r5 = r14.$notifManager
            cu.todus.android.data.db.entity.toDus.Attachment r15 = r14.$attachment
            java.lang.String r6 = r15.getMsg()
            cu.todus.android.data.db.entity.toDus.Attachment r15 = r14.$attachment
            java.lang.String r7 = r15.getId()
            java.lang.String r8 = r14.$contentName
            long r9 = r14.$totalSize
            r13 = 1
            r11 = r9
            r5.showUploadProgress(r6, r7, r8, r9, r11, r13)
            cu.todus.android.s3.upload.UploadDataSource r15 = r14.this$0
            kotlin.jvm.functions.Function2 r15 = cu.todus.android.s3.upload.UploadDataSource.access$getUpdateAttachment$p(r15)
            cu.todus.android.data.db.entity.toDus.Attachment r5 = r14.$attObj
            r12 = 55
            r13 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 2
            r10 = 0
            r11 = 0
            cu.todus.android.data.db.entity.toDus.Attachment r1 = cu.todus.android.data.db.entity.toDus.Attachment.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r14.label = r3
            java.lang.Object r15 = r15.invoke(r1, r14)
            if (r15 != r0) goto L7c
            goto Laa
        L7c:
            re.u r15 = r14.$$this$callbackFlow
            java.lang.Boolean r1 = cb.b.a(r4)
            r14.label = r2
            java.lang.Object r15 = cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r15, r1, r14)
            if (r15 != r0) goto L8b
            goto Laa
        L8b:
            pe.m0 r1 = r14.$downloadScope
            re.u r2 = r14.$$this$callbackFlow
            kotlin.jvm.internal.y0 r3 = r14.$call
            kotlin.jvm.internal.u0 r4 = r14.$isSuccess
            cu.todus.android.notification.NotificationManager r5 = r14.$notifManager
            cu.todus.android.data.db.entity.toDus.Attachment r6 = r14.$attachment
            cu.todus.android.s3.upload.UploadDataSource.AnonymousClass2.access$invokeSuspend$close(r1, r2, r3, r4, r5, r6)
            goto Lba
        L9b:
            re.u r15 = r14.$$this$callbackFlow
            r1 = 0
            java.lang.Boolean r1 = cb.b.a(r1)
            r14.label = r4
            java.lang.Object r15 = cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r15, r1, r14)
            if (r15 != r0) goto Lab
        Laa:
            return r0
        Lab:
            pe.m0 r1 = r14.$downloadScope
            re.u r2 = r14.$$this$callbackFlow
            kotlin.jvm.internal.y0 r3 = r14.$call
            kotlin.jvm.internal.u0 r4 = r14.$isSuccess
            cu.todus.android.notification.NotificationManager r5 = r14.$notifManager
            cu.todus.android.data.db.entity.toDus.Attachment r6 = r14.$attachment
            cu.todus.android.s3.upload.UploadDataSource.AnonymousClass2.access$invokeSuspend$close(r1, r2, r3, r4, r5, r6)
        Lba:
            ua.k0 r15 = ua.k0.f43947a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadDataSource$upload$2$1$onResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((UploadDataSource$upload$2$1$onResponse$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
