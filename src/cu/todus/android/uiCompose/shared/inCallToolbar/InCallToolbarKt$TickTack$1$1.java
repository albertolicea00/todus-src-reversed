package cu.todus.android.uiCompose.shared.inCallToolbar;

import ab.e;
import androidx.compose.runtime.MutableState;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.uiCompose.shared.inCallToolbar.InCallToolbarKt$TickTack$1$1", f = "InCallToolbar.kt", l = {83}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class InCallToolbarKt$TickTack$1$1 extends m implements Function2 {
    final /* synthetic */ MutableState<String> $currentPassedTime$delegate;
    final /* synthetic */ long $startTime;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InCallToolbarKt$TickTack$1$1(long j10, MutableState<String> mutableState, e<? super InCallToolbarKt$TickTack$1$1> eVar) {
        super(2, eVar);
        this.$startTime = j10;
        this.$currentPassedTime$delegate = mutableState;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new InCallToolbarKt$TickTack$1$1(this.$startTime, this.$currentPassedTime$delegate, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:12:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // cb.a
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            ua.v.b(r8)
            goto L25
        Lf:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L17:
            ua.v.b(r8)
        L1a:
            r7.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = pe.w0.b(r3, r7)
            if (r8 != r0) goto L25
            return r0
        L25:
            long r3 = r7.$startTime
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L1a
            java.util.Date r8 = new java.util.Date
            r8.<init>()
            long r3 = r8.getTime()
            long r5 = r7.$startTime
            long r3 = r3 - r5
            androidx.compose.runtime.MutableState<java.lang.String> r8 = r7.$currentPassedTime$delegate
            java.lang.String r1 = cu.todus.android.utils.NumberInlineFunctionsKt.humanDuration(r3)
            cu.todus.android.uiCompose.shared.inCallToolbar.InCallToolbarKt.access$TickTack$lambda$2(r8, r1)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.shared.inCallToolbar.InCallToolbarKt$TickTack$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((InCallToolbarKt$TickTack$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
