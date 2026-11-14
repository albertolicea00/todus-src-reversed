package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.compose.Measurer2;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lua/k0;", "invoke", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$7$1", "<anonymous>"}, k = 3, mv = {2, 3, 0})
public final class LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$7 extends kotlin.jvm.internal.e0 implements Function1 {
    final /* synthetic */ Measurer2 $measurer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$7(Measurer2 measurer2) {
        super(1);
        this.$measurer = measurer2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return ua.k0.f43947a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, this.$measurer);
    }
}
