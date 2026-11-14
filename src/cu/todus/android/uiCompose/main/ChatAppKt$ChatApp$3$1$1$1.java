package cu.todus.android.uiCompose.main;

import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import cu.todus.android.uiCompose.navigation.NavLinks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.ChatAppKt$ChatApp$3$1$1$1", f = "ChatApp.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class ChatAppKt$ChatApp$3$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ String $it;
    final /* synthetic */ NavHostController $navHostController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatAppKt$ChatApp$3$1$1$1(NavHostController navHostController, String str, ab.e<? super ChatAppKt$ChatApp$3$1$1$1> eVar) {
        super(2, eVar);
        this.$navHostController = navHostController;
        this.$it = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0(NavOptionsBuilder navOptionsBuilder) {
        NavOptionsBuilder.popUpTo$default(navOptionsBuilder, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ChatAppKt$ChatApp$3$1$1$1(this.$navHostController, this.$it, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        this.$navHostController.navigate(this.$it, new Function1() { // from class: cu.todus.android.uiCompose.main.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ChatAppKt$ChatApp$3$1$1$1.invokeSuspend$lambda$0((NavOptionsBuilder) obj2);
            }
        });
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ChatAppKt$ChatApp$3$1$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
