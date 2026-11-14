package cu.todus.android.uiCompose.main.screen.searchUser;

import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import cb.m;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.searchUser.SearchUserScreenKt$SearchUserScreen$2$1", f = "SearchUserScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class SearchUserScreenKt$SearchUserScreen$2$1 extends m implements Function2 {
    final /* synthetic */ NavHostController $navHostController;
    final /* synthetic */ SearchUserParams $searchUserParams;
    final /* synthetic */ SearchUserViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserScreenKt$SearchUserScreen$2$1(SearchUserViewModel searchUserViewModel, SearchUserParams searchUserParams, NavHostController navHostController, ab.e<? super SearchUserScreenKt$SearchUserScreen$2$1> eVar) {
        super(2, eVar);
        this.$viewModel = searchUserViewModel;
        this.$searchUserParams = searchUserParams;
        this.$navHostController = navHostController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0(SearchUserParams searchUserParams, NavHostController navHostController, SearchUserViewModel searchUserViewModel, String str) {
        if (y.d(searchUserParams.getRedirect(), SearchUserParams.GO_SOCIAL_PROFILE)) {
            navHostController.navigate(NavLinks.INSTANCE.goSocialProfile(str), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.searchUser.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchUserScreenKt$SearchUserScreen$2$1.invokeSuspend$lambda$0$0((NavOptionsBuilder) obj);
                }
            });
        } else {
            ChatParams chatParams = new ChatParams(str, 3, null, 0, 12, null);
            NavLinks navLinks = NavLinks.INSTANCE;
            String strT = searchUserViewModel.getGson().t(chatParams);
            y.h(strT, "toJson(...)");
            navHostController.navigate(navLinks.goChat(0, strT), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.searchUser.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchUserScreenKt$SearchUserScreen$2$1.invokeSuspend$lambda$0$1((NavOptionsBuilder) obj);
                }
            });
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0$0(NavOptionsBuilder navOptionsBuilder) {
        NavOptionsBuilder.popUpTo$default(navOptionsBuilder, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0$1(NavOptionsBuilder navOptionsBuilder) {
        NavOptionsBuilder.popUpTo$default(navOptionsBuilder, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$1(NavHostController navHostController) {
        navHostController.navigate(NavLinks.HOME, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.searchUser.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchUserScreenKt$SearchUserScreen$2$1.invokeSuspend$lambda$1$0((NavOptionsBuilder) obj);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$1$0(NavOptionsBuilder navOptionsBuilder) {
        NavOptionsBuilder.popUpTo$default(navOptionsBuilder, NavLinks.HOME, (Function1) null, 2, (Object) null);
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new SearchUserScreenKt$SearchUserScreen$2$1(this.$viewModel, this.$searchUserParams, this.$navHostController, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        SearchUserViewModel searchUserViewModel = this.$viewModel;
        String toDusId = this.$searchUserParams.getToDusId();
        final SearchUserParams searchUserParams = this.$searchUserParams;
        final NavHostController navHostController = this.$navHostController;
        final SearchUserViewModel searchUserViewModel2 = this.$viewModel;
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.searchUser.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SearchUserScreenKt$SearchUserScreen$2$1.invokeSuspend$lambda$0(searchUserParams, navHostController, searchUserViewModel2, (String) obj2);
            }
        };
        final NavHostController navHostController2 = this.$navHostController;
        searchUserViewModel.searchUser(toDusId, function1, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.searchUser.d
            @Override // lb.a
            public final Object invoke() {
                return SearchUserScreenKt$SearchUserScreen$2$1.invokeSuspend$lambda$1(navHostController2);
            }
        });
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((SearchUserScreenKt$SearchUserScreen$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
