package cu.todus.android.uiCompose.main.screen.statusList;

import androidx.compose.material.ModalBottomSheetState;
import androidx.media3.muxer.WebmConstants;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import cu.todus.android.data.db.pojo.FollowPartner;
import cu.todus.android.uiCompose.navigation.NavLinks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.d1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreenKt$StatusListScreen$1$2$1$1$1$1", f = "StatusListScreen.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_ADD_ID}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class StatusListScreenKt$StatusListScreen$1$2$1$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ pe.m0 $coroutineScope;
    final /* synthetic */ ModalBottomSheetState $followersModal;
    final /* synthetic */ FollowPartner $it;
    final /* synthetic */ NavHostController $navHostController;
    int label;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusList.StatusListScreenKt$StatusListScreen$1$2$1$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreenKt$StatusListScreen$1$2$1$1$1$1$1", f = "StatusListScreen.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ FollowPartner $it;
        final /* synthetic */ NavHostController $navHostController;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NavHostController navHostController, FollowPartner followPartner, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$navHostController = navHostController;
            this.$it = followPartner;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.$navHostController, this.$it, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            NavController.navigate$default((NavController) this.$navHostController, NavLinks.INSTANCE.goSocialProfile(this.$it.getId()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusListScreenKt$StatusListScreen$1$2$1$1$1$1(ModalBottomSheetState modalBottomSheetState, pe.m0 m0Var, NavHostController navHostController, FollowPartner followPartner, ab.e<? super StatusListScreenKt$StatusListScreen$1$2$1$1$1$1> eVar) {
        super(2, eVar);
        this.$followersModal = modalBottomSheetState;
        this.$coroutineScope = m0Var;
        this.$navHostController = navHostController;
        this.$it = followPartner;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new StatusListScreenKt$StatusListScreen$1$2$1$1$1$1(this.$followersModal, this.$coroutineScope, this.$navHostController, this.$it, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            ModalBottomSheetState modalBottomSheetState = this.$followersModal;
            this.label = 1;
            if (modalBottomSheetState.hide(this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        pe.k.d(this.$coroutineScope, d1.c(), null, new AnonymousClass1(this.$navHostController, this.$it, null), 2, null);
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((StatusListScreenKt$StatusListScreen$1$2$1$1$1$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
