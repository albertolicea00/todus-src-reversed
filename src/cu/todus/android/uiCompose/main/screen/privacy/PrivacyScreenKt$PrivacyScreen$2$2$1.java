package cu.todus.android.uiCompose.main.screen.privacy;

import androidx.compose.runtime.MutableState;
import cu.todus.android.data.db.pojo.Partner;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreenKt$PrivacyScreen$2$2$1", f = "PrivacyScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class PrivacyScreenKt$PrivacyScreen$2$2$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<String> $privacyOfAdd$delegate;
    final /* synthetic */ MutableState<List<String>> $privacyOfAddExcluded$delegate;
    final /* synthetic */ MutableState<List<Partner>> $privacyOfAddExcludedPartner$delegate;
    final /* synthetic */ MutableState<String> $privacyOfProfileInfo$delegate;
    final /* synthetic */ MutableState<String> $privacyOfProfileLast$delegate;
    final /* synthetic */ MutableState<String> $privacyOfProfilePhoto$delegate;
    final /* synthetic */ PrivacyViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyScreenKt$PrivacyScreen$2$2$1(PrivacyViewModel privacyViewModel, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<List<String>> mutableState5, MutableState<List<Partner>> mutableState6, ab.e<? super PrivacyScreenKt$PrivacyScreen$2$2$1> eVar) {
        super(2, eVar);
        this.$viewModel = privacyViewModel;
        this.$privacyOfProfileInfo$delegate = mutableState;
        this.$privacyOfProfileLast$delegate = mutableState2;
        this.$privacyOfProfilePhoto$delegate = mutableState3;
        this.$privacyOfAdd$delegate = mutableState4;
        this.$privacyOfAddExcluded$delegate = mutableState5;
        this.$privacyOfAddExcludedPartner$delegate = mutableState6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invokeSuspend$lambda$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, ua.y yVar) {
        mutableState.setValue((String) yVar.f());
        mutableState2.setValue((String) yVar.g());
        mutableState3.setValue((String) yVar.h());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invokeSuspend$lambda$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, String str, List list, List list2) {
        mutableState.setValue(str);
        mutableState2.setValue(list);
        mutableState3.setValue(list2);
        return ua.k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new PrivacyScreenKt$PrivacyScreen$2$2$1(this.$viewModel, this.$privacyOfProfileInfo$delegate, this.$privacyOfProfileLast$delegate, this.$privacyOfProfilePhoto$delegate, this.$privacyOfAdd$delegate, this.$privacyOfAddExcluded$delegate, this.$privacyOfAddExcludedPartner$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        PrivacyViewModel privacyViewModel = this.$viewModel;
        final MutableState<String> mutableState = this.$privacyOfProfileInfo$delegate;
        final MutableState<String> mutableState2 = this.$privacyOfProfileLast$delegate;
        final MutableState<String> mutableState3 = this.$privacyOfProfilePhoto$delegate;
        privacyViewModel.getProfilePrivacy(new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PrivacyScreenKt$PrivacyScreen$2$2$1.invokeSuspend$lambda$0(mutableState, mutableState2, mutableState3, (ua.y) obj2);
            }
        });
        PrivacyViewModel privacyViewModel2 = this.$viewModel;
        final MutableState<String> mutableState4 = this.$privacyOfAdd$delegate;
        final MutableState<List<String>> mutableState5 = this.$privacyOfAddExcluded$delegate;
        final MutableState<List<Partner>> mutableState6 = this.$privacyOfAddExcludedPartner$delegate;
        privacyViewModel2.getPrivacyOfAdd(new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.v0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return PrivacyScreenKt$PrivacyScreen$2$2$1.invokeSuspend$lambda$1(mutableState4, mutableState5, mutableState6, (String) obj2, (List) obj3, (List) obj4);
            }
        });
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((PrivacyScreenKt$PrivacyScreen$2$2$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
