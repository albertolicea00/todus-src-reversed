package cu.todus.android.repositories;

import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.MessageWithAttachments;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MainRepository$sendForward$2$1$1$2", f = "MainRepository.kt", l = {1325, 1336}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
public final class MainRepository$sendForward$2$1$1$2 extends cb.m implements Function1 {
    final /* synthetic */ ArrayList<Attachment> $attachmentsToForward;
    final /* synthetic */ String $currentRoomId;
    final /* synthetic */ String $id;
    final /* synthetic */ MessageWithAttachments $msg;
    final /* synthetic */ long $time;
    int label;
    final /* synthetic */ MainRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRepository$sendForward$2$1$1$2(MainRepository mainRepository, MessageWithAttachments messageWithAttachments, String str, String str2, long j10, ArrayList<Attachment> arrayList, ab.e<? super MainRepository$sendForward$2$1$1$2> eVar) {
        super(1, eVar);
        this.this$0 = mainRepository;
        this.$msg = messageWithAttachments;
        this.$id = str;
        this.$currentRoomId = str2;
        this.$time = j10;
        this.$attachmentsToForward = arrayList;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(ab.e<?> eVar) {
        return new MainRepository$sendForward$2$1$1$2(this.this$0, this.$msg, this.$id, this.$currentRoomId, this.$time, this.$attachmentsToForward, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super ua.k0> eVar) {
        return ((MainRepository$sendForward$2$1$1$2) create(eVar)).invokeSuspend(ua.k0.f43947a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a9, code lost:
    
        if (r2.insert(r14, r19) == r1) goto L19;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L21
            if (r2 == r4) goto L1d
            if (r2 != r3) goto L15
            ua.v.b(r20)
            goto Lac
        L15:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L1d:
            ua.v.b(r20)
            goto L59
        L21:
            ua.v.b(r20)
            cu.todus.android.repositories.MainRepository r2 = r0.this$0
            cu.todus.android.data.db.pojo.MessageWithAttachments r5 = r0.$msg
            cu.todus.android.data.db.entity.toDus.Message r6 = r5.getMessage()
            cu.todus.android.repositories.MainRepository r5 = r0.this$0
            lb.a r5 = r5.getOwner()
            java.lang.Object r5 = r5.invoke()
            cu.todus.android.data.preferences.Owner r5 = (cu.todus.android.data.preferences.Owner) r5
            java.lang.String r9 = r5.getNameWithDomain()
            java.lang.String r7 = r0.$id
            java.lang.String r8 = r0.$currentRoomId
            long r11 = r0.$time
            r17 = 456(0x1c8, float:6.39E-43)
            r18 = 0
            r10 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            cu.todus.android.data.db.entity.toDus.Message r5 = cu.todus.android.data.db.entity.toDus.Message.copy$default(r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18)
            r0.label = r4
            java.lang.Object r2 = r2.saveMsg(r5, r0)
            if (r2 != r1) goto L59
            goto Lab
        L59:
            cu.todus.android.repositories.MainRepository r2 = r0.this$0
            cu.todus.android.db.dao.toDus.AttachmentDao r2 = cu.todus.android.repositories.MainRepository.access$getAttachmentDao$p(r2)
            java.util.ArrayList<cu.todus.android.data.db.entity.toDus.Attachment> r4 = r0.$attachmentsToForward
            java.lang.String r7 = r0.$id
            java.util.ArrayList r14 = new java.util.ArrayList
            r5 = 10
            int r5 = va.x.y(r4, r5)
            r14.<init>(r5)
            java.util.Iterator r4 = r4.iterator()
        L72:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto La3
            java.lang.Object r5 = r4.next()
            cu.todus.android.data.db.entity.toDus.Attachment r5 = (cu.todus.android.data.db.entity.toDus.Attachment) r5
            java.util.UUID r6 = java.util.UUID.randomUUID()
            java.lang.String r8 = r6.toString()
            java.lang.String r6 = "toString(...)"
            kotlin.jvm.internal.y.h(r8, r6)
            r12 = 4
            r13 = 0
            java.lang.String r9 = "-"
            java.lang.String r10 = ""
            r11 = 0
            java.lang.String r6 = le.a0.O(r8, r9, r10, r11, r12, r13)
            r12 = 60
            r8 = 0
            r9 = 0
            r10 = 0
            cu.todus.android.data.db.entity.toDus.Attachment r5 = cu.todus.android.data.db.entity.toDus.Attachment.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r14.add(r5)
            goto L72
        La3:
            r0.label = r3
            java.lang.Object r2 = r2.insert(r14, r0)
            if (r2 != r1) goto Lac
        Lab:
            return r1
        Lac:
            ua.k0 r1 = ua.k0.f43947a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository$sendForward$2$1$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
