package cu.todus.android.uiCompose.main.screen.createGroup;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import cu.todus.android.data.db.pojo.Friend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreenKt$CreateGroupStep2ConfigurationScreen$3$6$1", f = "CreateGroupStep2ConfigurationScreen.kt", l = {289, 294}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class CreateGroupStep2ConfigurationScreenKt$CreateGroupStep2ConfigurationScreen$3$6$1 extends cb.m implements Function2 {
    final /* synthetic */ CreateGroupParams $createGroupParams;
    final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
    final /* synthetic */ SnapshotStateList<Friend> $selectedList;
    final /* synthetic */ CreateGroupViewModel $viewModel;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGroupStep2ConfigurationScreenKt$CreateGroupStep2ConfigurationScreen$3$6$1(SnapshotStateList<Friend> snapshotStateList, CreateGroupParams createGroupParams, CreateGroupViewModel createGroupViewModel, MutableState<Boolean> mutableState, ab.e<? super CreateGroupStep2ConfigurationScreenKt$CreateGroupStep2ConfigurationScreen$3$6$1> eVar) {
        super(2, eVar);
        this.$selectedList = snapshotStateList;
        this.$createGroupParams = createGroupParams;
        this.$viewModel = createGroupViewModel;
        this.$isLoading$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new CreateGroupStep2ConfigurationScreenKt$CreateGroupStep2ConfigurationScreen$3$6$1(this.$selectedList, this.$createGroupParams, this.$viewModel, this.$isLoading$delegate, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0058  */
    /* JADX WARN: Code duplicated, block: B:19:0x008c  */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0081, code lost:
    
        if (r12 == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a1, code lost:
    
        if (pe.w0.b(200, r11) == r0) goto L21;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0081 -> B:16:0x0084). Please report as a decompilation issue!!! */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L36
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            ua.v.b(r12)
            goto La4
        L14:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1c:
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$5
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r11.L$3
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r11.L$2
            androidx.compose.runtime.snapshots.SnapshotStateList r6 = (androidx.compose.runtime.snapshots.SnapshotStateList) r6
            java.lang.Object r7 = r11.L$1
            cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupViewModel r7 = (cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupViewModel) r7
            java.lang.Object r8 = r11.L$0
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            ua.v.b(r12)
            goto L84
        L36:
            ua.v.b(r12)
            androidx.compose.runtime.snapshots.SnapshotStateList<cu.todus.android.data.db.pojo.Friend> r12 = r11.$selectedList
            r12.clear()
            cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupParams r12 = r11.$createGroupParams
            java.util.List r12 = r12.getMembers()
            cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupViewModel r1 = r11.$viewModel
            androidx.compose.runtime.snapshots.SnapshotStateList<cu.todus.android.data.db.pojo.Friend> r5 = r11.$selectedList
            java.util.Iterator r6 = r12.iterator()
            r7 = r6
            r6 = r5
            r5 = r7
            r8 = r12
            r7 = r1
            r1 = r4
        L52:
            boolean r12 = r5.hasNext()
            if (r12 == 0) goto L8c
            java.lang.Object r12 = r5.next()
            r9 = r12
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = cb.l.a(r8)
            r11.L$0 = r10
            r11.L$1 = r7
            r11.L$2 = r6
            r11.L$3 = r5
            java.lang.Object r12 = cb.l.a(r12)
            r11.L$4 = r12
            java.lang.Object r12 = cb.l.a(r9)
            r11.L$5 = r12
            r11.I$0 = r1
            r11.I$1 = r4
            r11.label = r3
            java.lang.Object r12 = r7.getFriendById(r9, r11)
            if (r12 != r0) goto L84
            goto La3
        L84:
            cu.todus.android.data.db.pojo.Friend r12 = (cu.todus.android.data.db.pojo.Friend) r12
            if (r12 == 0) goto L52
            r6.add(r12)
            goto L52
        L8c:
            r12 = 0
            r11.L$0 = r12
            r11.L$1 = r12
            r11.L$2 = r12
            r11.L$3 = r12
            r11.L$4 = r12
            r11.L$5 = r12
            r11.label = r2
            r1 = 200(0xc8, double:9.9E-322)
            java.lang.Object r12 = pe.w0.b(r1, r11)
            if (r12 != r0) goto La4
        La3:
            return r0
        La4:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r12 = r11.$isLoading$delegate
            cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreenKt.access$CreateGroupStep2ConfigurationScreen$lambda$4(r12, r4)
            ua.k0 r12 = ua.k0.f43947a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreenKt$CreateGroupStep2ConfigurationScreen$3$6$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((CreateGroupStep2ConfigurationScreenKt$CreateGroupStep2ConfigurationScreen$3$6$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
