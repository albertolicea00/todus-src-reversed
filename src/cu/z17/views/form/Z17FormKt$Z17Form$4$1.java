package cu.z17.views.form;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.form.Z17FormKt$Z17Form$4$1", f = "Z17Form.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17FormKt$Z17Form$4$1 extends cb.m implements Function2 {
    final /* synthetic */ List<FormItemRequest> $initialRequest;
    final /* synthetic */ SnapshotStateList<FormItemRequest> $request;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17FormKt$Z17Form$4$1(SnapshotStateList<FormItemRequest> snapshotStateList, List<FormItemRequest> list, ab.e<? super Z17FormKt$Z17Form$4$1> eVar) {
        super(2, eVar);
        this.$request = snapshotStateList;
        this.$initialRequest = list;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new Z17FormKt$Z17Form$4$1(this.$request, this.$initialRequest, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (this.$request.isEmpty() && !this.$initialRequest.isEmpty()) {
            this.$request.addAll(this.$initialRequest);
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((Z17FormKt$Z17Form$4$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
