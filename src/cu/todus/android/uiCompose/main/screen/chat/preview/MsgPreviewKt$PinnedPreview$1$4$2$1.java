package cu.todus.android.uiCompose.main.screen.chat.preview;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt$PinnedPreview$1$4$2$1", f = "MsgPreview.kt", l = {298, 300}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class MsgPreviewKt$PinnedPreview$1$4$2$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableIntState $actualMsg$delegate;
    final /* synthetic */ MutableState<Boolean> $showActual$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPreviewKt$PinnedPreview$1$4$2$1(MutableState<Boolean> mutableState, MutableIntState mutableIntState, ab.e<? super MsgPreviewKt$PinnedPreview$1$4$2$1> eVar) {
        super(2, eVar);
        this.$showActual$delegate = mutableState;
        this.$actualMsg$delegate = mutableIntState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new MsgPreviewKt$PinnedPreview$1$4$2$1(this.$showActual$delegate, this.$actualMsg$delegate, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (pe.w0.b(1000, r7) == r0) goto L15;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r7.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1f
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            ua.v.b(r8)
            goto L3d
        L13:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1b:
            ua.v.b(r8)
            goto L2d
        L1f:
            ua.v.b(r8)
            r7.label = r4
            r5 = 4000(0xfa0, double:1.9763E-320)
            java.lang.Object r8 = pe.w0.b(r5, r7)
            if (r8 != r0) goto L2d
            goto L3c
        L2d:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r7.$showActual$delegate
            cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt.access$PinnedPreview$lambda$0$16$2(r8, r2)
            r7.label = r3
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = pe.w0.b(r5, r7)
            if (r8 != r0) goto L3d
        L3c:
            return r0
        L3d:
            androidx.compose.runtime.MutableIntState r8 = r7.$actualMsg$delegate
            int r8 = cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt.access$PinnedPreview$lambda$0$10(r8)
            r0 = 3
            if (r8 >= r0) goto L57
            androidx.compose.runtime.MutableIntState r8 = r7.$actualMsg$delegate
            int r8 = cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt.access$PinnedPreview$lambda$0$10(r8)
            androidx.compose.runtime.MutableIntState r0 = r7.$actualMsg$delegate
            int r1 = r8 + 1
            cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt.access$PinnedPreview$lambda$0$11(r0, r1)
            cb.b.d(r8)
            goto L5c
        L57:
            androidx.compose.runtime.MutableIntState r8 = r7.$actualMsg$delegate
            cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt.access$PinnedPreview$lambda$0$11(r8, r2)
        L5c:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r7.$showActual$delegate
            cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt.access$PinnedPreview$lambda$0$16$2(r8, r4)
            ua.k0 r8 = ua.k0.f43947a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt$PinnedPreview$1$4$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((MsgPreviewKt$PinnedPreview$1$4$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
