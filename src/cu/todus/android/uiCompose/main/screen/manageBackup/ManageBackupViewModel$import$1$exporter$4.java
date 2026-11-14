package cu.todus.android.uiCompose.main.screen.manageBackup;

import cb.m;
import cu.todus.android.data.db.pojo.MessageWithAttachments;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel$import$1$exporter$4", f = "ManageBackupViewModel.kt", l = {38, 39, 40}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "it", "Lua/k0;", "<anonymous>", "(Lcu/todus/android/data/db/pojo/MessageWithAttachments;)V"}, k = 3, mv = {2, 3, 0})
public final class ManageBackupViewModel$import$1$exporter$4 extends m implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ManageBackupViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageBackupViewModel$import$1$exporter$4(ManageBackupViewModel manageBackupViewModel, ab.e<? super ManageBackupViewModel$import$1$exporter$4> eVar) {
        super(2, eVar);
        this.this$0 = manageBackupViewModel;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        ManageBackupViewModel$import$1$exporter$4 manageBackupViewModel$import$1$exporter$4 = new ManageBackupViewModel$import$1$exporter$4(this.this$0, eVar);
        manageBackupViewModel$import$1$exporter$4.L$0 = obj;
        return manageBackupViewModel$import$1$exporter$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MessageWithAttachments messageWithAttachments, ab.e<? super k0> eVar) {
        return ((ManageBackupViewModel$import$1$exporter$4) create(messageWithAttachments, eVar)).invokeSuspend(k0.f43947a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        if (r7.upsertAttachments(r2, r6) == r1) goto L25;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            cu.todus.android.data.db.pojo.MessageWithAttachments r0 = (cu.todus.android.data.db.pojo.MessageWithAttachments) r0
            java.lang.Object r1 = bb.b.g()
            int r2 = r6.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L2b
            if (r2 == r5) goto L27
            if (r2 == r4) goto L23
            if (r2 != r3) goto L1b
            ua.v.b(r7)     // Catch: java.lang.Exception -> L19
            goto L78
        L19:
            r7 = move-exception
            goto L75
        L1b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L23:
            ua.v.b(r7)     // Catch: java.lang.Exception -> L19
            goto L5c
        L27:
            ua.v.b(r7)     // Catch: java.lang.Exception -> L19
            goto L47
        L2b:
            ua.v.b(r7)
            cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel r7 = r6.this$0     // Catch: java.lang.Exception -> L19
            cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel.access$getMainRepository$p(r7)     // Catch: java.lang.Exception -> L19
            cu.todus.android.data.db.entity.toDus.Message r2 = r0.getMessage()     // Catch: java.lang.Exception -> L19
            java.lang.String r2 = r2.getRoomId()     // Catch: java.lang.Exception -> L19
            r6.L$0 = r0     // Catch: java.lang.Exception -> L19
            r6.label = r5     // Catch: java.lang.Exception -> L19
            java.lang.Object r7 = r7.createRoomIfNeed(r2, r6)     // Catch: java.lang.Exception -> L19
            if (r7 != r1) goto L47
            goto L74
        L47:
            cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel r7 = r6.this$0     // Catch: java.lang.Exception -> L19
            cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel.access$getMainRepository$p(r7)     // Catch: java.lang.Exception -> L19
            cu.todus.android.data.db.entity.toDus.Message r2 = r0.getMessage()     // Catch: java.lang.Exception -> L19
            r6.L$0 = r0     // Catch: java.lang.Exception -> L19
            r6.label = r4     // Catch: java.lang.Exception -> L19
            java.lang.Object r7 = r7.saveMsg(r2, r6)     // Catch: java.lang.Exception -> L19
            if (r7 != r1) goto L5c
            goto L74
        L5c:
            cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel r7 = r6.this$0     // Catch: java.lang.Exception -> L19
            cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel.access$getMainRepository$p(r7)     // Catch: java.lang.Exception -> L19
            java.util.List r2 = r0.getAttachments()     // Catch: java.lang.Exception -> L19
            java.lang.Object r0 = cb.l.a(r0)     // Catch: java.lang.Exception -> L19
            r6.L$0 = r0     // Catch: java.lang.Exception -> L19
            r6.label = r3     // Catch: java.lang.Exception -> L19
            java.lang.Object r7 = r7.upsertAttachments(r2, r6)     // Catch: java.lang.Exception -> L19
            if (r7 != r1) goto L78
        L74:
            return r1
        L75:
            r7.printStackTrace()
        L78:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel$import$1$exporter$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
