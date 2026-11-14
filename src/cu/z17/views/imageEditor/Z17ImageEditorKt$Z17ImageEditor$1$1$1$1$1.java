package cu.z17.views.imageEditor;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class Z17ImageEditorKt$Z17ImageEditor$1$1$1$1$1 extends kotlin.jvm.internal.v implements Function1 {
    public Z17ImageEditorKt$Z17ImageEditor$1$1$1$1$1(Object obj) {
        super(1, obj, Z17ImageEditorViewModel.class, "requestStepBack", "requestStepBack(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return ua.k0.f43947a;
    }

    public final void invoke(String p10) {
        kotlin.jvm.internal.y.i(p10, "p0");
        ((Z17ImageEditorViewModel) this.receiver).requestStepBack(p10);
    }
}
