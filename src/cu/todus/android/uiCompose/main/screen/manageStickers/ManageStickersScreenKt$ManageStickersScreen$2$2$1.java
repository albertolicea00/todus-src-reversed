package cu.todus.android.uiCompose.main.screen.manageStickers;

import androidx.compose.runtime.MutableState;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import le.d0;
import pe.m0;
import pe.w0;
import te.p0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreenKt$ManageStickersScreen$2$2$1", f = "ManageStickersScreen.kt", l = {158}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class ManageStickersScreenKt$ManageStickersScreen$2$2$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<String> $msgFilterWithDelay$delegate;
    final /* synthetic */ ManageStickersViewModel $viewModel;
    int label;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreenKt$ManageStickersScreen$2$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersScreenKt$ManageStickersScreen$2$2$1$1", f = "ManageStickersScreen.kt", l = {WebmConstants.MkvEbmlElement.CHANNELS}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ MutableState<String> $msgFilterWithDelay$delegate;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MutableState<String> mutableState, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$msgFilterWithDelay$delegate = mutableState;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$msgFilterWithDelay$delegate, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                this.L$0 = str;
                this.label = 1;
                if (w0.b(1000L, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            if (!d0.q0(str)) {
                this.$msgFilterWithDelay$delegate.setValue(str);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageStickersScreenKt$ManageStickersScreen$2$2$1(ManageStickersViewModel manageStickersViewModel, MutableState<String> mutableState, ab.e<? super ManageStickersScreenKt$ManageStickersScreen$2$2$1> eVar) {
        super(2, eVar);
        this.$viewModel = manageStickersViewModel;
        this.$msgFilterWithDelay$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ManageStickersScreenKt$ManageStickersScreen$2$2$1(this.$viewModel, this.$msgFilterWithDelay$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            p0 filterValue = this.$viewModel.getFilterValue();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$msgFilterWithDelay$delegate, null);
            this.label = 1;
            if (te.j.k(filterValue, anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ManageStickersScreenKt$ManageStickersScreen$2$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
