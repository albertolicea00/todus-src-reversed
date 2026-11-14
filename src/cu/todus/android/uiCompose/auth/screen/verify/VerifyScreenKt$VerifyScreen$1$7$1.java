package cu.todus.android.uiCompose.auth.screen.verify;

import android.content.Context;
import cu.todus.android.R;
import cu.todus.android.data.geo.CountryDataJson;
import cu.todus.android.data.geo.CountryNumber;
import cu.todus.android.uiCompose.auth.screen.AuthViewModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.util.StringUtils;
import pe.d1;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.auth.screen.verify.VerifyScreenKt$VerifyScreen$1$7$1", f = "VerifyScreen.kt", l = {290}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class VerifyScreenKt$VerifyScreen$1$7$1 extends cb.m implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<CountryNumber> $countryList;
    final /* synthetic */ AuthViewModel $viewModel;
    int label;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.auth.screen.verify.VerifyScreenKt$VerifyScreen$1$7$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.auth.screen.verify.VerifyScreenKt$VerifyScreen$1$7$1$1", f = "VerifyScreen.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<CountryNumber> $countryList;
        final /* synthetic */ AuthViewModel $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, List<CountryNumber> list, AuthViewModel authViewModel, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$context = context;
            this.$countryList = list;
            this.$viewModel = authViewModel;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.$context, this.$countryList, this.$viewModel, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            InputStream inputStreamOpenRawResource = this.$context.getResources().openRawResource(R.raw.number_pattern);
            kotlin.jvm.internal.y.h(inputStreamOpenRawResource, "openRawResource(...)");
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, StringUtils.UTF8));
                while (true) {
                    int i10 = bufferedReader.read(cArr);
                    if (i10 == -1) {
                        k0 k0Var = k0.f43947a;
                        hb.c.a(inputStreamOpenRawResource, null);
                        this.$countryList.addAll(((CountryDataJson) this.$viewModel.getGson().j(stringWriter.toString(), CountryDataJson.class)).getData());
                        return k0.f43947a;
                    }
                    stringWriter.write(cArr, 0, i10);
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    hb.c.a(inputStreamOpenRawResource, th2);
                    throw th3;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyScreenKt$VerifyScreen$1$7$1(Context context, List<CountryNumber> list, AuthViewModel authViewModel, ab.e<? super VerifyScreenKt$VerifyScreen$1$7$1> eVar) {
        super(2, eVar);
        this.$context = context;
        this.$countryList = list;
        this.$viewModel = authViewModel;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new VerifyScreenKt$VerifyScreen$1$7$1(this.$context, this.$countryList, this.$viewModel, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            pe.k0 k0VarB = d1.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$countryList, this.$viewModel, null);
            this.label = 1;
            if (pe.i.g(k0VarB, anonymousClass1, this) == objG) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((VerifyScreenKt$VerifyScreen$1$7$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
