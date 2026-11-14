package cu.todus.android.utils;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.utils.MaxLengthObserverToastKt$MaxLengthObserver$1$1", f = "MaxLengthObserverToast.kt", l = {19}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class MaxLengthObserverToastKt$MaxLengthObserver$1$1 extends cb.m implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ TextFieldState $input;
    final /* synthetic */ int $maxLength;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxLengthObserverToastKt$MaxLengthObserver$1$1(TextFieldState textFieldState, int i10, Context context, ab.e<? super MaxLengthObserverToastKt$MaxLengthObserver$1$1> eVar) {
        super(2, eVar);
        this.$input = textFieldState;
        this.$maxLength = i10;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(TextFieldState textFieldState, int i10) {
        return textFieldState.getText().length() >= i10;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new MaxLengthObserverToastKt$MaxLengthObserver$1$1(this.$input, this.$maxLength, this.$context, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            final TextFieldState textFieldState = this.$input;
            final int i11 = this.$maxLength;
            te.h hVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new lb.a() { // from class: cu.todus.android.utils.j
                @Override // lb.a
                public final Object invoke() {
                    return Boolean.valueOf(MaxLengthObserverToastKt$MaxLengthObserver$1$1.invokeSuspend$lambda$0(textFieldState, i11));
                }
            });
            final Context context = this.$context;
            final int i12 = this.$maxLength;
            te.i iVar = new te.i() { // from class: cu.todus.android.utils.MaxLengthObserverToastKt$MaxLengthObserver$1$1.2
                @Override // te.i
                public /* bridge */ /* synthetic */ Object emit(Object obj2, ab.e eVar) {
                    return emit(((Boolean) obj2).booleanValue(), (ab.e<? super k0>) eVar);
                }

                public final Object emit(boolean z10, ab.e<? super k0> eVar) {
                    if (z10) {
                        Toast.makeText(context, "Límite de " + i12 + " caracteres alcanzado", 0).show();
                    }
                    return k0.f43947a;
                }
            };
            this.label = 1;
            if (hVarSnapshotFlow.collect(iVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((MaxLengthObserverToastKt$MaxLengthObserver$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
