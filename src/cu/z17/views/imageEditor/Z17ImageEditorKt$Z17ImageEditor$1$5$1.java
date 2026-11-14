package cu.z17.views.imageEditor;

import android.graphics.Bitmap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorKt$Z17ImageEditor$1$5$1", f = "Z17ImageEditor.kt", l = {346}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17ImageEditorKt$Z17ImageEditor$1$5$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Bitmap> $actualBitmap$delegate;
    final /* synthetic */ State<List<Bitmap>> $history$delegate;
    final /* synthetic */ Function1 $onEdited;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Z17ImageEditorKt$Z17ImageEditor$1$5$1(Function1 function1, MutableState<Bitmap> mutableState, State<? extends List<Bitmap>> state, ab.e<? super Z17ImageEditorKt$Z17ImageEditor$1$5$1> eVar) {
        super(2, eVar);
        this.$onEdited = function1;
        this.$actualBitmap$delegate = mutableState;
        this.$history$delegate = state;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new Z17ImageEditorKt$Z17ImageEditor$1$5$1(this.$onEdited, this.$actualBitmap$delegate, this.$history$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            this.$actualBitmap$delegate.setValue(null);
            this.label = 1;
            if (w0.b(100L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        this.$actualBitmap$delegate.setValue((Bitmap) va.g0.K0(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$1(this.$history$delegate)));
        if (Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$1(this.$history$delegate).isEmpty()) {
            this.$onEdited.invoke(cb.b.a(false));
        } else {
            this.$onEdited.invoke(cb.b.a(true));
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((Z17ImageEditorKt$Z17ImageEditor$1$5$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
