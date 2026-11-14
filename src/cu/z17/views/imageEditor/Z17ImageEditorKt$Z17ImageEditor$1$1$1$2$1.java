package cu.z17.views.imageEditor;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class Z17ImageEditorKt$Z17ImageEditor$1$1$1$2$1 extends kotlin.jvm.internal.v implements Function1 {
    final /* synthetic */ Z17ImageEditorViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17ImageEditorKt$Z17ImageEditor$1$1$1$2$1(Z17ImageEditorViewModel z17ImageEditorViewModel) {
        super(1, kotlin.jvm.internal.y.a.class, "setState", "Z17ImageEditor$lambda$95$setState(Lcu/z17/views/imageEditor/Z17ImageEditorViewModel;Lcu/z17/views/imageEditor/Z17EditorState;)V", 0);
        this.$viewModel = z17ImageEditorViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Z17EditorState) obj);
        return ua.k0.f43947a;
    }

    public final void invoke(Z17EditorState p10) {
        kotlin.jvm.internal.y.i(p10, "p0");
        this.$viewModel.requestState(p10);
    }
}
