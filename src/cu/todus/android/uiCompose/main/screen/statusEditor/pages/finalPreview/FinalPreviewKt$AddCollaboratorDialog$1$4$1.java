package cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview;

import androidx.compose.runtime.MutableState;
import cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import le.d0;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.pages.finalPreview.FinalPreviewKt$AddCollaboratorDialog$1$4$1", f = "FinalPreview.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class FinalPreviewKt$AddCollaboratorDialog$1$4$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<String> $filter$delegate;
    final /* synthetic */ StatusEditorViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinalPreviewKt$AddCollaboratorDialog$1$4$1(StatusEditorViewModel statusEditorViewModel, MutableState<String> mutableState, ab.e<? super FinalPreviewKt$AddCollaboratorDialog$1$4$1> eVar) {
        super(2, eVar);
        this.$viewModel = statusEditorViewModel;
        this.$filter$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new FinalPreviewKt$AddCollaboratorDialog$1$4$1(this.$viewModel, this.$filter$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (le.a0.U(FinalPreviewKt.AddCollaboratorDialog$lambda$0$1(this.$filter$delegate), "@", false, 2, null)) {
            this.$viewModel.searchForPartner(le.a0.O(d0.q1(FinalPreviewKt.AddCollaboratorDialog$lambda$0$1(this.$filter$delegate)).toString(), "@", "", false, 4, null));
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((FinalPreviewKt$AddCollaboratorDialog$1$4$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
