package cu.z17.preferences;

import ab.e;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import te.i;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.preferences.PreferencesRepositoryImpl$retrieve$value$7", f = "PreferencesRepositoryImpl.kt", l = {267, 270}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Landroidx/datastore/preferences/core/Preferences;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
public final class PreferencesRepositoryImpl$retrieve$value$7 extends m implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ PreferencesRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferencesRepositoryImpl$retrieve$value$7(PreferencesRepositoryImpl preferencesRepositoryImpl, e<? super PreferencesRepositoryImpl$retrieve$value$7> eVar) {
        super(3, eVar);
        this.this$0 = preferencesRepositoryImpl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        if (r0.emit(r7, r6) == r2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
    
        if (r0.emit(r7, r6) == r2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0068, code lost:
    
        return r2;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            te.i r0 = (te.i) r0
            java.lang.Object r1 = r6.L$1
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = bb.b.g()
            int r3 = r6.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L23
            if (r3 == r5) goto L1f
            if (r3 != r4) goto L17
            goto L1f
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1f:
            ua.v.b(r7)
            goto L69
        L23:
            ua.v.b(r7)
            boolean r7 = r1 instanceof java.io.IOException
            if (r7 == 0) goto L43
            androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
            java.lang.Object r3 = cb.l.a(r0)
            r6.L$0 = r3
            java.lang.Object r1 = cb.l.a(r1)
            r6.L$1 = r1
            r6.label = r5
            java.lang.Object r7 = r0.emit(r7, r6)
            if (r7 != r2) goto L69
            goto L68
        L43:
            cu.z17.preferences.PreferencesRepositoryImpl r7 = r6.this$0
            java.lang.String r7 = cu.z17.preferences.PreferencesRepositoryImpl.access$getTAG$p(r7)
            java.lang.String r3 = r1.toString()
            android.util.Log.e(r7, r3)
            androidx.datastore.preferences.core.Preferences r7 = androidx.datastore.preferences.core.PreferencesFactory.createEmpty()
            java.lang.Object r3 = cb.l.a(r0)
            r6.L$0 = r3
            java.lang.Object r1 = cb.l.a(r1)
            r6.L$1 = r1
            r6.label = r4
            java.lang.Object r7 = r0.emit(r7, r6)
            if (r7 != r2) goto L69
        L68:
            return r2
        L69:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.preferences.PreferencesRepositoryImpl$retrieve$value$7.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
        PreferencesRepositoryImpl$retrieve$value$7 preferencesRepositoryImpl$retrieve$value$7 = new PreferencesRepositoryImpl$retrieve$value$7(this.this$0, eVar);
        preferencesRepositoryImpl$retrieve$value$7.L$0 = iVar;
        preferencesRepositoryImpl$retrieve$value$7.L$1 = th2;
        return preferencesRepositoryImpl$retrieve$value$7.invokeSuspend(k0.f43947a);
    }
}
