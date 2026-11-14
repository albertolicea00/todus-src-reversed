package cu.z17.preferences;

import ab.e;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import cb.f;
import cb.m;
import cu.z17.preferences.encription.Encryption;
import ef.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.preferences.PreferencesRepositoryImpl$store$$inlined$secureEdit$4", f = "PreferencesRepositoryImpl.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "it", "Lua/k0;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V", "cu/z17/preferences/PreferencesRepositoryImpl$secureEdit$2"}, k = 3, mv = {2, 2, 0})
public final class PreferencesRepositoryImpl$store$$inlined$secureEdit$4 extends m implements Function2 {
    final /* synthetic */ Preferences.Key $key$inlined;
    final /* synthetic */ Object $value;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PreferencesRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferencesRepositoryImpl$store$$inlined$secureEdit$4(PreferencesRepositoryImpl preferencesRepositoryImpl, Object obj, e eVar, Preferences.Key key) {
        super(2, eVar);
        this.this$0 = preferencesRepositoryImpl;
        this.$value = obj;
        this.$key$inlined = key;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        PreferencesRepositoryImpl$store$$inlined$secureEdit$4 preferencesRepositoryImpl$store$$inlined$secureEdit$4 = new PreferencesRepositoryImpl$store$$inlined$secureEdit$4(this.this$0, this.$value, eVar, this.$key$inlined);
        preferencesRepositoryImpl$store$$inlined$secureEdit$4.L$0 = obj;
        return preferencesRepositoryImpl$store$$inlined$secureEdit$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MutablePreferences mutablePreferences, e<? super k0> eVar) {
        return ((PreferencesRepositoryImpl$store$$inlined$secureEdit$4) create(mutablePreferences, eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        Encryption encryption = this.this$0.encryption;
        kf.b.a aVar = kf.b.f36355d;
        ef.b bVarD = t.d(z0.m(Long.TYPE));
        y.g(bVarD, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        String strEncryptOrNull = encryption.encryptOrNull(aVar.b(bVarD, this.$value));
        y.f(strEncryptOrNull);
        mutablePreferences.set(this.$key$inlined, strEncryptOrNull);
        return k0.f43947a;
    }
}
