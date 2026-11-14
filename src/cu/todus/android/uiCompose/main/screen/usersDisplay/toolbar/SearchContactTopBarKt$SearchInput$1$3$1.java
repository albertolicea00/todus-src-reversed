package cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar;

import androidx.compose.ui.focus.FocusRequester;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBarKt$SearchInput$1$3$1", f = "SearchContactTopBar.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class SearchContactTopBarKt$SearchInput$1$3$1 extends m implements Function2 {
    final /* synthetic */ FocusRequester $focusRequester;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchContactTopBarKt$SearchInput$1$3$1(FocusRequester focusRequester, ab.e<? super SearchContactTopBarKt$SearchInput$1$3$1> eVar) {
        super(2, eVar);
        this.$focusRequester = focusRequester;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new SearchContactTopBarKt$SearchInput$1$3$1(this.$focusRequester, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        FocusRequester.m5530requestFocus3ESFkO8$default(this.$focusRequester, 0, 1, null);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((SearchContactTopBarKt$SearchInput$1$3$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
