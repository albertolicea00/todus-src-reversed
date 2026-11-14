package cu.todus.android.s3.download;

import ab.e;
import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.notification.NotificationManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y0;
import pe.m0;
import re.u;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.s3.download.DownloadDataSource$download$2$2$onResponse$3", f = "DownloadDataSource.kt", l = {535, 514, 567}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class DownloadDataSource$download$2$2$onResponse$3 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ Attachment $attObj;
    final /* synthetic */ Attachment $attachment;
    final /* synthetic */ y0 $call;
    final /* synthetic */ String $contentName;
    final /* synthetic */ m0 $downloadScope;
    final /* synthetic */ long $expectedTotalSize;
    final /* synthetic */ String $filePath;
    final /* synthetic */ u0 $isSuccess;
    final /* synthetic */ NotificationManager $sysNotifier;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDataSource$download$2$2$onResponse$3(u0 u0Var, NotificationManager notificationManager, Attachment attachment, String str, long j10, DownloadDataSource downloadDataSource, Attachment attachment2, String str2, u uVar, m0 m0Var, y0 y0Var, e<? super DownloadDataSource$download$2$2$onResponse$3> eVar) {
        super(2, eVar);
        this.$isSuccess = u0Var;
        this.$sysNotifier = notificationManager;
        this.$attachment = attachment;
        this.$contentName = str;
        this.$expectedTotalSize = j10;
        this.this$0 = downloadDataSource;
        this.$attObj = attachment2;
        this.$filePath = str2;
        this.$$this$callbackFlow = uVar;
        this.$downloadScope = m0Var;
        this.$call = y0Var;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new DownloadDataSource$download$2$2$onResponse$3(this.$isSuccess, this.$sysNotifier, this.$attachment, this.$contentName, this.$expectedTotalSize, this.this$0, this.$attObj, this.$filePath, this.$$this$callbackFlow, this.$downloadScope, this.$call, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x01fe  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0147, code lost:
    
        if (r7 == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x020a, code lost:
    
        if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r2, r4, r24) == r1) goto L42;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instruction units count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.download.DownloadDataSource$download$2$2$onResponse$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((DownloadDataSource$download$2$2$onResponse$3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
