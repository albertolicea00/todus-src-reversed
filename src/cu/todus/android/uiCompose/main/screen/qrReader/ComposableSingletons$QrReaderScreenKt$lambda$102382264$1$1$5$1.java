package cu.todus.android.uiCompose.main.screen.qrReader;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.qrReader.ComposableSingletons$QrReaderScreenKt$lambda$102382264$1$1$5$1", f = "QrReaderScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class ComposableSingletons$QrReaderScreenKt$lambda$102382264$1$1$5$1 extends cb.m implements Function2 {
    final /* synthetic */ c1.a $permissionsState;
    final /* synthetic */ MutableState<Boolean> $qrReaderOpen$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposableSingletons$QrReaderScreenKt$lambda$102382264$1$1$5$1(c1.a aVar, MutableState<Boolean> mutableState, ab.e<? super ComposableSingletons$QrReaderScreenKt$lambda$102382264$1$1$5$1> eVar) {
        super(2, eVar);
        this.$permissionsState = aVar;
        this.$qrReaderOpen$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ComposableSingletons$QrReaderScreenKt$lambda$102382264$1$1$5$1(this.$permissionsState, this.$qrReaderOpen$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        if (this.$permissionsState.a()) {
            ComposableSingletons$QrReaderScreenKt.lambda_102382264$lambda$0$2(this.$qrReaderOpen$delegate, true);
        } else {
            this.$permissionsState.b();
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ComposableSingletons$QrReaderScreenKt$lambda$102382264$1$1$5$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
