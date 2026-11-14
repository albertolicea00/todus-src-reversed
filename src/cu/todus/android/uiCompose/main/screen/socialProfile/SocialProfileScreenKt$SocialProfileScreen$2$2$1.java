package cu.todus.android.uiCompose.main.screen.socialProfile;

import androidx.compose.runtime.MutableState;
import androidx.navigation.NavHostController;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.xmpp.FollowState;
import cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorsDetailData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreenKt$SocialProfileScreen$2$2$1", f = "SocialProfileScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class SocialProfileScreenKt$SocialProfileScreen$2$2$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
    final /* synthetic */ NavHostController $navHostController;
    final /* synthetic */ MutableState<AuthorsDetailData> $profileDetail$delegate;
    final /* synthetic */ MutableState<FollowState> $profileState$delegate;
    final /* synthetic */ String $uid;
    final /* synthetic */ SocialProfileViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialProfileScreenKt$SocialProfileScreen$2$2$1(SocialProfileViewModel socialProfileViewModel, String str, MutableState<AuthorsDetailData> mutableState, MutableState<Boolean> mutableState2, NavHostController navHostController, MutableState<FollowState> mutableState3, ab.e<? super SocialProfileScreenKt$SocialProfileScreen$2$2$1> eVar) {
        super(2, eVar);
        this.$viewModel = socialProfileViewModel;
        this.$uid = str;
        this.$profileDetail$delegate = mutableState;
        this.$isLoading$delegate = mutableState2;
        this.$navHostController = navHostController;
        this.$profileState$delegate = mutableState3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0(MutableState mutableState, MutableState mutableState2, Partner partner) {
        mutableState.setValue(AuthorsDetailData.INSTANCE.convert(partner));
        SocialProfileScreenKt.SocialProfileScreen$lambda$2(mutableState2, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$1(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$2(MutableState mutableState, FollowState followState) {
        mutableState.setValue(followState);
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new SocialProfileScreenKt$SocialProfileScreen$2$2$1(this.$viewModel, this.$uid, this.$profileDetail$delegate, this.$isLoading$delegate, this.$navHostController, this.$profileState$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        SocialProfileViewModel socialProfileViewModel = this.$viewModel;
        String str = this.$uid;
        final MutableState<AuthorsDetailData> mutableState = this.$profileDetail$delegate;
        final MutableState<Boolean> mutableState2 = this.$isLoading$delegate;
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SocialProfileScreenKt$SocialProfileScreen$2$2$1.invokeSuspend$lambda$0(mutableState, mutableState2, (Partner) obj2);
            }
        };
        final NavHostController navHostController = this.$navHostController;
        socialProfileViewModel.loadProfileData(str, function1, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.u
            @Override // lb.a
            public final Object invoke() {
                return SocialProfileScreenKt$SocialProfileScreen$2$2$1.invokeSuspend$lambda$1(navHostController);
            }
        });
        SocialProfileViewModel socialProfileViewModel2 = this.$viewModel;
        String str2 = this.$uid;
        final MutableState<FollowState> mutableState3 = this.$profileState$delegate;
        socialProfileViewModel2.getFollowState(str2, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SocialProfileScreenKt$SocialProfileScreen$2$2$1.invokeSuspend$lambda$2(mutableState3, (FollowState) obj2);
            }
        });
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((SocialProfileScreenKt$SocialProfileScreen$2$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
