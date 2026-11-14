package cu.todus.android.uiCompose.main.screen.search;

import androidx.compose.runtime.MutableState;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.xmpp.XMPPUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.search.SearchScreenKt$SearchScreen$1$goOnSpecificPosition$1", f = "SearchScreen.kt", l = {117}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class SearchScreenKt$SearchScreen$1$goOnSpecificPosition$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
    final /* synthetic */ String $msgId;
    final /* synthetic */ NavHostController $navHostController;
    final /* synthetic */ String $roomId;
    final /* synthetic */ SearchViewModel $viewModel;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchScreenKt$SearchScreen$1$goOnSpecificPosition$1(String str, SearchViewModel searchViewModel, String str2, NavHostController navHostController, MutableState<Boolean> mutableState, ab.e<? super SearchScreenKt$SearchScreen$1$goOnSpecificPosition$1> eVar) {
        super(2, eVar);
        this.$roomId = str;
        this.$viewModel = searchViewModel;
        this.$msgId = str2;
        this.$navHostController = navHostController;
        this.$isLoading$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new SearchScreenKt$SearchScreen$1$goOnSpecificPosition$1(this.$roomId, this.$viewModel, this.$msgId, this.$navHostController, this.$isLoading$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        int i10;
        Object objG = bb.b.g();
        int i11 = this.label;
        if (i11 == 0) {
            ua.v.b(obj);
            SearchScreenKt.SearchScreen$lambda$0$6(this.$isLoading$delegate, true);
            int chatType = XMPPUtils.INSTANCE.getChatType(this.$roomId);
            SearchViewModel searchViewModel = this.$viewModel;
            String str = this.$roomId;
            String str2 = this.$msgId;
            this.I$0 = chatType;
            this.label = 1;
            Object msgPosition = searchViewModel.getMsgPosition(str, str2, this);
            if (msgPosition == objG) {
                return objG;
            }
            i10 = chatType;
            obj = msgPosition;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i12 = this.I$0;
            ua.v.b(obj);
            i10 = i12;
        }
        int iIntValue = ((Number) obj).intValue();
        NavHostController navHostController = this.$navHostController;
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = this.$viewModel.getGson().t(new ChatParams(this.$roomId, i10, null, iIntValue, 4, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goChat(i10, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((SearchScreenKt$SearchScreen$1$goOnSpecificPosition$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
