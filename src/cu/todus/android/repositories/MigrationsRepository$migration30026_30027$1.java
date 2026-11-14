package cu.todus.android.repositories;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MigrationsRepository$migration30026_30027$1", f = "MigrationsRepository.kt", l = {63, 64, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/Function0;", "Lua/k0;", "it", "<anonymous>", "(Llb/a;)V"}, k = 3, mv = {2, 3, 0})
public final class MigrationsRepository$migration30026_30027$1 extends cb.m implements Function2 {
    int label;
    final /* synthetic */ MigrationsRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationsRepository$migration30026_30027$1(MigrationsRepository migrationsRepository, ab.e<? super MigrationsRepository$migration30026_30027$1> eVar) {
        super(2, eVar);
        this.this$0 = migrationsRepository;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new MigrationsRepository$migration30026_30027$1(this.this$0, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        if (r11.setCatalogueVersion(0, r10) == r0) goto L20;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r10.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            ua.v.b(r11)
            goto L5c
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1d:
            ua.v.b(r11)
            goto L4c
        L21:
            ua.v.b(r11)
            goto L33
        L25:
            ua.v.b(r11)
            cu.todus.android.repositories.MigrationsRepository r11 = r10.this$0
            r10.label = r4
            java.lang.Object r11 = cu.todus.android.repositories.MigrationsRepository.access$deleteAllReactions(r11, r10)
            if (r11 != r0) goto L33
            goto L5b
        L33:
            cu.todus.android.repositories.MigrationsRepository r11 = r10.this$0
            cu.todus.android.di.PreferencesModule r11 = cu.todus.android.repositories.MigrationsRepository.access$getPreferencesModule$p(r11)
            cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences r4 = new cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences
            r8 = 7
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r10.label = r3
            java.lang.Object r11 = r11.saveAliveWelcomeMessageDataPreferences(r4, r10)
            if (r11 != r0) goto L4c
            goto L5b
        L4c:
            cu.todus.android.repositories.MigrationsRepository r11 = r10.this$0
            cu.todus.android.di.PreferencesModule r11 = cu.todus.android.repositories.MigrationsRepository.access$getPreferencesModule$p(r11)
            r10.label = r2
            r1 = 0
            java.lang.Object r11 = r11.setCatalogueVersion(r1, r10)
            if (r11 != r0) goto L5c
        L5b:
            return r0
        L5c:
            ua.k0 r11 = ua.k0.f43947a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MigrationsRepository$migration30026_30027$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(lb.a aVar, ab.e<? super ua.k0> eVar) {
        return ((MigrationsRepository$migration30026_30027$1) create(aVar, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
