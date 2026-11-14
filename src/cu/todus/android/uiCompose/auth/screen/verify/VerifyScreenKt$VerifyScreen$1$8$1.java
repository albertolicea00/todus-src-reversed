package cu.todus.android.uiCompose.auth.screen.verify;

import androidx.compose.runtime.MutableState;
import cu.todus.android.data.geo.CountryNumber;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.auth.screen.verify.VerifyScreenKt$VerifyScreen$1$8$1", f = "VerifyScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class VerifyScreenKt$VerifyScreen$1$8$1 extends cb.m implements Function2 {
    final /* synthetic */ List<CountryNumber> $countryList;
    final /* synthetic */ MutableState<String> $dialCode$delegate;
    final /* synthetic */ MutableState<CountryNumber> $selectedCountry$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyScreenKt$VerifyScreen$1$8$1(List<CountryNumber> list, MutableState<String> mutableState, MutableState<CountryNumber> mutableState2, ab.e<? super VerifyScreenKt$VerifyScreen$1$8$1> eVar) {
        super(2, eVar);
        this.$countryList = list;
        this.$dialCode$delegate = mutableState;
        this.$selectedCountry$delegate = mutableState2;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new VerifyScreenKt$VerifyScreen$1$8$1(this.$countryList, this.$dialCode$delegate, this.$selectedCountry$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object next;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        List<CountryNumber> list = this.$countryList;
        MutableState<String> mutableState = this.$dialCode$delegate;
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kotlin.jvm.internal.y.d(le.a0.O(((CountryNumber) next).getDialCode(), "+", "", false, 4, null), VerifyScreenKt.VerifyScreen$lambda$0$11(mutableState)));
        CountryNumber countryNumber = (CountryNumber) next;
        if (countryNumber != null) {
            this.$selectedCountry$delegate.setValue(countryNumber);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((VerifyScreenKt$VerifyScreen$1$8$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
