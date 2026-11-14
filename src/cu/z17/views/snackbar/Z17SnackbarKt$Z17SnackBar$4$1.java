package cu.z17.views.snackbar;

import androidx.compose.runtime.MutableState;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import pe.w0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.snackbar.Z17SnackbarKt$Z17SnackBar$4$1", f = "Z17Snackbar.kt", l = {76}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17SnackbarKt$Z17SnackBar$4$1 extends m implements Function2 {
    final /* synthetic */ lb.a $onClose;
    final /* synthetic */ MutableState<Boolean> $visible;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17SnackbarKt$Z17SnackBar$4$1(MutableState<Boolean> mutableState, lb.a aVar, ab.e<? super Z17SnackbarKt$Z17SnackBar$4$1> eVar) {
        super(2, eVar);
        this.$visible = mutableState;
        this.$onClose = aVar;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17SnackbarKt$Z17SnackBar$4$1(this.$visible, this.$onClose, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            if (this.$visible.getValue().booleanValue()) {
                this.label = 1;
                if (w0.b(3000L, this) == objG) {
                    return objG;
                }
            }
            return k0.f43947a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        this.$visible.setValue(cb.b.a(false));
        this.$onClose.invoke();
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17SnackbarKt$Z17SnackBar$4$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
