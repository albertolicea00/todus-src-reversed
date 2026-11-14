package cu.todus.android.uiCompose.main.screen.rooms.home;

import android.content.Context;
import android.os.Build;
import cu.z17.views.utils.Z17InlineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.home.BigHomeScreenKt$BigHomeScreen$4$5$1", f = "BigHomeScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class BigHomeScreenKt$BigHomeScreen$4$5$1 extends cb.m implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ c1.a $permissionsState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigHomeScreenKt$BigHomeScreen$4$5$1(c1.a aVar, Context context, ab.e<? super BigHomeScreenKt$BigHomeScreen$4$5$1> eVar) {
        super(2, eVar);
        this.$permissionsState = aVar;
        this.$context = context;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new BigHomeScreenKt$BigHomeScreen$4$5$1(this.$permissionsState, this.$context, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (Build.VERSION.SDK_INT >= 33 && !this.$permissionsState.a()) {
            this.$permissionsState.b();
        }
        try {
            Z17InlineUtilsKt.findActivity(this.$context).getWindow().clearFlags(8192);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((BigHomeScreenKt$BigHomeScreen$4$5$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
