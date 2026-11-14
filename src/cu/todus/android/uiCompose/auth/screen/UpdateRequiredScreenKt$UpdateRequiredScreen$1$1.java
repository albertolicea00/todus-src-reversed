package cu.todus.android.uiCompose.auth.screen;

import androidx.compose.runtime.State;
import cb.m;
import cu.todus.android.uiCompose.main.screen.updateRequired.UpdateViewModel;
import cu.todus.android.utils.UpdateInfo;
import cu.todus.android.utils.versionupdate.DownloadState;
import j$.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.auth.screen.UpdateRequiredScreenKt$UpdateRequiredScreen$1$1", f = "UpdateRequiredScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class UpdateRequiredScreenKt$UpdateRequiredScreen$1$1 extends m implements Function2 {
    final /* synthetic */ State<DownloadState> $downloadState$delegate;
    final /* synthetic */ long $targetVersionCode;
    final /* synthetic */ UpdateInfo $updateInfo;
    final /* synthetic */ UpdateViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UpdateRequiredScreenKt$UpdateRequiredScreen$1$1(UpdateInfo updateInfo, UpdateViewModel updateViewModel, long j10, State<? extends DownloadState> state, ab.e<? super UpdateRequiredScreenKt$UpdateRequiredScreen$1$1> eVar) {
        super(2, eVar);
        this.$updateInfo = updateInfo;
        this.$viewModel = updateViewModel;
        this.$targetVersionCode = j10;
        this.$downloadState$delegate = state;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new UpdateRequiredScreenKt$UpdateRequiredScreen$1$1(this.$updateInfo, this.$viewModel, this.$targetVersionCode, this.$downloadState$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        UpdateInfo updateInfo = this.$updateInfo;
        DownloadState downloadStateUpdateRequiredScreen$lambda$0 = UpdateRequiredScreenKt.UpdateRequiredScreen$lambda$0(this.$downloadState$delegate);
        Objects.toString(updateInfo);
        Objects.toString(downloadStateUpdateRequiredScreen$lambda$0);
        if (this.$updateInfo != null && (UpdateRequiredScreenKt.UpdateRequiredScreen$lambda$0(this.$downloadState$delegate) instanceof DownloadState.Idle)) {
            this.$viewModel.checkExistingUpdate(this.$targetVersionCode);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((UpdateRequiredScreenKt$UpdateRequiredScreen$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
