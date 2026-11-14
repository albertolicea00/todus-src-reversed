package cu.todus.android.uiCompose.main.screen.usersDisplay.openWith;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel;
import cu.todus.android.uiCompose.main.screen.usersDisplay.RefreshContactsState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreenKt$OpenWithScreen$1$1$1", f = "OpenWithScreen.kt", l = {132, 134, 141, 143}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class OpenWithScreenKt$OpenWithScreen$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Boolean> $isSuccess$delegate;
    final /* synthetic */ State<RefreshContactsState> $refreshState$delegate;
    final /* synthetic */ MutableState<Boolean> $showStatusCard$delegate;
    final /* synthetic */ MutableState<String> $statusCardMessage$delegate;
    final /* synthetic */ ContactsViewModel $viewModel;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OpenWithScreenKt$OpenWithScreen$1$1$1(ContactsViewModel contactsViewModel, State<? extends RefreshContactsState> state, MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, ab.e<? super OpenWithScreenKt$OpenWithScreen$1$1$1> eVar) {
        super(2, eVar);
        this.$viewModel = contactsViewModel;
        this.$refreshState$delegate = state;
        this.$statusCardMessage$delegate = mutableState;
        this.$isSuccess$delegate = mutableState2;
        this.$showStatusCard$delegate = mutableState3;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new OpenWithScreenKt$OpenWithScreen$1$1$1(this.$viewModel, this.$refreshState$delegate, this.$statusCardMessage$delegate, this.$isSuccess$delegate, this.$showStatusCard$delegate, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0086, code lost:
    
        if (pe.w0.b(300, r9) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00cb, code lost:
    
        if (pe.w0.b(300, r9) == r0) goto L30;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.OpenWithScreenKt$OpenWithScreen$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((OpenWithScreenKt$OpenWithScreen$1$1$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
