package cu.todus.android.uiCompose.main.screen.manageBackup;

import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel$import$1$exporter$3", f = "ManageBackupViewModel.kt", l = {30, 31, 32, 33}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "uid", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
public final class ManageBackupViewModel$import$1$exporter$3 extends m implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ManageBackupViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageBackupViewModel$import$1$exporter$3(ManageBackupViewModel manageBackupViewModel, ab.e<? super ManageBackupViewModel$import$1$exporter$3> eVar) {
        super(2, eVar);
        this.this$0 = manageBackupViewModel;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        ManageBackupViewModel$import$1$exporter$3 manageBackupViewModel$import$1$exporter$3 = new ManageBackupViewModel$import$1$exporter$3(this.this$0, eVar);
        manageBackupViewModel$import$1$exporter$3.L$0 = obj;
        return manageBackupViewModel$import$1$exporter$3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (r8.reloadChannel(r0, r7) == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        if (r8.reloadGroup(r0, r7) == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r8.reloadCard(r0, r7) == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
    
        if (r8.reloadUser(r0, r7) == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
    
        return r1;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = bb.b.g()
            int r2 = r7.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L26
            if (r2 == r6) goto L21
            if (r2 == r5) goto L21
            if (r2 == r4) goto L21
            if (r2 != r3) goto L19
            goto L21
        L19:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L21:
            ua.v.b(r8)
            goto L97
        L26:
            ua.v.b(r8)
            cu.todus.android.xmpp.XMPPUtils r8 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
            boolean r2 = r8.isChannel(r0)
            if (r2 == 0) goto L46
            cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel r8 = r7.this$0
            cu.todus.android.repositories.MainRepository r8 = cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel.access$getMainRepository$p(r8)
            java.lang.Object r2 = cb.l.a(r0)
            r7.L$0 = r2
            r7.label = r6
            java.lang.Object r8 = r8.reloadChannel(r0, r7)
            if (r8 != r1) goto L97
            goto L96
        L46:
            boolean r2 = r8.isMUC(r0)
            if (r2 == 0) goto L61
            cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel r8 = r7.this$0
            cu.todus.android.repositories.MainRepository r8 = cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel.access$getMainRepository$p(r8)
            java.lang.Object r2 = cb.l.a(r0)
            r7.L$0 = r2
            r7.label = r5
            java.lang.Object r8 = r8.reloadGroup(r0, r7)
            if (r8 != r1) goto L97
            goto L96
        L61:
            boolean r2 = r8.isCard(r0)
            if (r2 == 0) goto L7c
            cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel r8 = r7.this$0
            cu.todus.android.repositories.MainRepository r8 = cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel.access$getMainRepository$p(r8)
            java.lang.Object r2 = cb.l.a(r0)
            r7.L$0 = r2
            r7.label = r4
            java.lang.Object r8 = r8.reloadCard(r0, r7)
            if (r8 != r1) goto L97
            goto L96
        L7c:
            boolean r8 = r8.isUser(r0)
            if (r8 == 0) goto L97
            cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel r8 = r7.this$0
            cu.todus.android.repositories.MainRepository r8 = cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel.access$getMainRepository$p(r8)
            java.lang.Object r2 = cb.l.a(r0)
            r7.L$0 = r2
            r7.label = r3
            java.lang.Object r8 = r8.reloadUser(r0, r7)
            if (r8 != r1) goto L97
        L96:
            return r1
        L97:
            ua.k0 r8 = ua.k0.f43947a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.manageBackup.ManageBackupViewModel$import$1$exporter$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, ab.e<? super k0> eVar) {
        return ((ManageBackupViewModel$import$1$exporter$3) create(str, eVar)).invokeSuspend(k0.f43947a);
    }
}
