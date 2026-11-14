package cu.todus.android.uiCompose.shared.callToolbar;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import cu.z17.views.permission.PermissionsRequesterState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class CallToolbarKt$CallToolbar$1$1$1$1$1 extends kotlin.jvm.internal.v implements Function2 {
    final /* synthetic */ MutableState<PermissionsRequesterState> $callPermissionsState$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ m0 $coroutineScope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallToolbarKt$CallToolbar$1$1$1$1$1(m0 m0Var, MutableState<PermissionsRequesterState> mutableState, Context context) {
        super(2, y.a.class, "goCallNew", "CallToolbar$goCallNew(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroid/content/Context;Ljava/lang/String;Z)V", 0);
        this.$coroutineScope = m0Var;
        this.$callPermissionsState$delegate = mutableState;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, ((Boolean) obj2).booleanValue());
        return k0.f43947a;
    }

    public final void invoke(String p10, boolean z10) {
        y.i(p10, "p0");
        CallToolbarKt.CallToolbar$goCallNew(this.$coroutineScope, this.$callPermissionsState$delegate, this.$context, p10, z10);
    }
}
