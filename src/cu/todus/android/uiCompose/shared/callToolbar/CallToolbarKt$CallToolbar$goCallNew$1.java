package cu.todus.android.uiCompose.shared.callToolbar;

import android.content.Context;
import androidx.compose.runtime.ComposerImplKt;
import cu.todus.android.R;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.z17.singledi.SinglediException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import le.a0;
import pe.d1;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.shared.callToolbar.CallToolbarKt$CallToolbar$goCallNew$1", f = "CallToolbar.kt", l = {ComposerImplKt.nodeKey}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
public final class CallToolbarKt$CallToolbar$goCallNew$1 extends cb.m implements Function1 {
    final /* synthetic */ Context $context;
    final /* synthetic */ m0 $coroutineScope;
    final /* synthetic */ boolean $isVideoCall;
    final /* synthetic */ String $uid;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallToolbarKt$CallToolbar$goCallNew$1(String str, m0 m0Var, boolean z10, Context context, ab.e<? super CallToolbarKt$CallToolbar$goCallNew$1> eVar) {
        super(1, eVar);
        this.$uid = str;
        this.$coroutineScope = m0Var;
        this.$isVideoCall = z10;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0(m0 m0Var, boolean z10, Context context, String str) {
        pe.k.d(m0Var, d1.c(), null, new CallToolbarKt$CallToolbar$goCallNew$1$1$1(z10, context, str, null), 2, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$1() throws SinglediException {
        MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        String strO = a0.O(string, "-", "", false, 4, null);
        Cause cause = Cause.ERROR;
        String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.cannot_answer_now);
        y.h(string2, "getString(...)");
        singletonInitializer.addNewNotification(new InsideNotificationState(strO, cause, string2));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$2() throws SinglediException {
        MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        String strO = a0.O(string, "-", "", false, 4, null);
        Cause cause = Cause.ERROR;
        String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
        y.h(string2, "getString(...)");
        singletonInitializer.addNewNotification(new InsideNotificationState(strO, cause, string2));
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(ab.e<?> eVar) {
        return new CallToolbarKt$CallToolbar$goCallNew$1(this.$uid, this.$coroutineScope, this.$isVideoCall, this.$context, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super k0> eVar) {
        return ((CallToolbarKt$CallToolbar$goCallNew$1) create(eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) throws SinglediException {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
            final String str = this.$uid;
            final m0 m0Var = this.$coroutineScope;
            final boolean z10 = this.$isVideoCall;
            final Context context = this.$context;
            lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.p
                @Override // lb.a
                public final Object invoke() {
                    return CallToolbarKt$CallToolbar$goCallNew$1.invokeSuspend$lambda$0(m0Var, z10, context, str);
                }
            };
            lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.q
                @Override // lb.a
                public final Object invoke() {
                    return CallToolbarKt$CallToolbar$goCallNew$1.invokeSuspend$lambda$1();
                }
            };
            lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.r
                @Override // lb.a
                public final Object invoke() {
                    return CallToolbarKt$CallToolbar$goCallNew$1.invokeSuspend$lambda$2();
                }
            };
            this.label = 1;
            if (singletonInitializer.acceptCallProcess(str, aVar, aVar2, aVar3, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return k0.f43947a;
    }
}
