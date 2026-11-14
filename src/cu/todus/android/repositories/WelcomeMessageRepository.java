package cu.todus.android.repositories;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import cu.todus.android.data.db.entity.cache.WelcomeMessage;
import cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences;
import cu.todus.android.db.dao.cache.WelcomeMessageDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.PreferencesModule;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0004\b\f\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcu/todus/android/repositories/WelcomeMessageRepository;", "", "<init>", "()V", "Lua/k0;", "insertMockUpMessages", "(Lab/e;)Ljava/lang/Object;", "", "Lcu/todus/android/data/db/entity/cache/WelcomeMessage;", "welcomeMessages", "insertMessages", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "getNextMessage", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "welcomeMessageDao", "Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WelcomeMessageRepository {
    private final PreferencesModule preferences = PreferencesModule.INSTANCE.getInstance();
    private final WelcomeMessageDao welcomeMessageDao = DatabaseModule.INSTANCE.getInstance().getWelcomeMessageDao();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/WelcomeMessageRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/WelcomeMessageRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<WelcomeMessageRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.WelcomeMessageRepository$getNextMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.WelcomeMessageRepository", f = "WelcomeMessageRepository.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, 56, 59}, m = "getNextMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WelcomeMessageRepository.this.getNextMessage(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.WelcomeMessageRepository$insertMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.WelcomeMessageRepository", f = "WelcomeMessageRepository.kt", l = {36, 38, 40, 41}, m = "insertMessages", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11491 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11491(ab.e<? super C11491> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WelcomeMessageRepository.this.insertMessages(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.WelcomeMessageRepository$insertMockUpMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.WelcomeMessageRepository", f = "WelcomeMessageRepository.kt", l = {18, 22, 24, 26}, m = "insertMockUpMessages", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11501 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11501(ab.e<? super C11501> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WelcomeMessageRepository.this.insertMockUpMessages(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0086  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getNextMessage(ab.e<? super WelcomeMessage> eVar) {
        AnonymousClass1 anonymousClass1;
        int lastShowed;
        AliveWelcomeMessageDataPreferences aliveWelcomeMessageDataPreferences;
        WelcomeMessage welcomeMessage;
        PreferencesModule preferencesModule;
        AliveWelcomeMessageDataPreferences aliveWelcomeMessageDataPreferencesCopy$default;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object aliveWelcomeMessageDataPreferences2 = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            ua.v.b(aliveWelcomeMessageDataPreferences2);
            PreferencesModule preferencesModule2 = this.preferences;
            anonymousClass1.label = 1;
            aliveWelcomeMessageDataPreferences2 = preferencesModule2.getAliveWelcomeMessageDataPreferences(anonymousClass1);
            if (aliveWelcomeMessageDataPreferences2 != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            ua.v.b(aliveWelcomeMessageDataPreferences2);
        } else {
            if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                WelcomeMessage welcomeMessage2 = (WelcomeMessage) anonymousClass1.L$1;
                ua.v.b(aliveWelcomeMessageDataPreferences2);
                return welcomeMessage2;
            }
            lastShowed = anonymousClass1.I$0;
            aliveWelcomeMessageDataPreferences = (AliveWelcomeMessageDataPreferences) anonymousClass1.L$0;
            ua.v.b(aliveWelcomeMessageDataPreferences2);
        }
        welcomeMessage = (WelcomeMessage) aliveWelcomeMessageDataPreferences2;
        preferencesModule = this.preferences;
        aliveWelcomeMessageDataPreferencesCopy$default = AliveWelcomeMessageDataPreferences.copy$default(aliveWelcomeMessageDataPreferences, false, welcomeMessage != null ? welcomeMessage.getId() : -1, 0, 5, null);
        anonymousClass1.L$0 = cb.l.a(aliveWelcomeMessageDataPreferences);
        anonymousClass1.L$1 = welcomeMessage;
        anonymousClass1.I$0 = lastShowed;
        anonymousClass1.label = 3;
        if (preferencesModule.saveAliveWelcomeMessageDataPreferences(aliveWelcomeMessageDataPreferencesCopy$default, anonymousClass1) != objG) {
            return objG;
        }
        return welcomeMessage;
        AliveWelcomeMessageDataPreferences aliveWelcomeMessageDataPreferences3 = (AliveWelcomeMessageDataPreferences) aliveWelcomeMessageDataPreferences2;
        lastShowed = aliveWelcomeMessageDataPreferences3.getLastShowed() == aliveWelcomeMessageDataPreferences3.getActualMax() ? -1 : aliveWelcomeMessageDataPreferences3.getLastShowed();
        WelcomeMessageDao welcomeMessageDao = this.welcomeMessageDao;
        anonymousClass1.L$0 = aliveWelcomeMessageDataPreferences3;
        anonymousClass1.I$0 = lastShowed;
        anonymousClass1.label = 2;
        Object nextByLastId = welcomeMessageDao.getNextByLastId(lastShowed, anonymousClass1);
        if (nextByLastId != objG) {
            aliveWelcomeMessageDataPreferences = aliveWelcomeMessageDataPreferences3;
            aliveWelcomeMessageDataPreferences2 = nextByLastId;
            welcomeMessage = (WelcomeMessage) aliveWelcomeMessageDataPreferences2;
            preferencesModule = this.preferences;
            aliveWelcomeMessageDataPreferencesCopy$default = AliveWelcomeMessageDataPreferences.copy$default(aliveWelcomeMessageDataPreferences, false, welcomeMessage != null ? welcomeMessage.getId() : -1, 0, 5, null);
            anonymousClass1.L$0 = cb.l.a(aliveWelcomeMessageDataPreferences);
            anonymousClass1.L$1 = welcomeMessage;
            anonymousClass1.I$0 = lastShowed;
            anonymousClass1.label = 3;
            if (preferencesModule.saveAliveWelcomeMessageDataPreferences(aliveWelcomeMessageDataPreferencesCopy$default, anonymousClass1) != objG) {
                return welcomeMessage;
            }
        }
        return objG;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004c A[PHI: r2 r11 r12
      0x004c: PHI (r2v4 java.util.List<cu.todus.android.data.db.entity.cache.WelcomeMessage>) = 
      (r2v3 java.util.List<cu.todus.android.data.db.entity.cache.WelcomeMessage>)
      (r2v8 java.util.List<cu.todus.android.data.db.entity.cache.WelcomeMessage>)
     binds: [B:29:0x009a, B:17:0x0043] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r11v4 int) = (r11v3 int), (r11v12 int) binds: [B:29:0x009a, B:17:0x0043] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r12v10 java.lang.Object) = (r12v9 java.lang.Object), (r12v1 java.lang.Object) binds: [B:29:0x009a, B:17:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
    
        if (r11.saveAliveWelcomeMessageDataPreferences(r12, r0) == r1) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object insertMessages(java.util.List<cu.todus.android.data.db.entity.cache.WelcomeMessage> r11, ab.e<? super ua.k0> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof cu.todus.android.repositories.WelcomeMessageRepository.C11491
            if (r0 == 0) goto L13
            r0 = r12
            cu.todus.android.repositories.WelcomeMessageRepository$insertMessages$1 r0 = (cu.todus.android.repositories.WelcomeMessageRepository.C11491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.WelcomeMessageRepository$insertMessages$1 r0 = new cu.todus.android.repositories.WelcomeMessageRepository$insertMessages$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L5f
            if (r2 == r6) goto L57
            if (r2 == r5) goto L4e
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r11 = r0.L$1
            cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences r11 = (cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences) r11
            java.lang.Object r11 = r0.L$0
            java.util.List r11 = (java.util.List) r11
            ua.v.b(r12)
            goto Lc1
        L3b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L43:
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            ua.v.b(r12)
        L4c:
            r7 = r11
            goto L9d
        L4e:
            java.lang.Object r11 = r0.L$0
            java.util.List r11 = (java.util.List) r11
            ua.v.b(r12)
        L55:
            r2 = r11
            goto L84
        L57:
            java.lang.Object r11 = r0.L$0
            java.util.List r11 = (java.util.List) r11
            ua.v.b(r12)
            goto L73
        L5f:
            ua.v.b(r12)
            cu.todus.android.db.dao.cache.WelcomeMessageDao r12 = r10.welcomeMessageDao
            java.lang.Object r2 = cb.l.a(r11)
            r0.L$0 = r2
            r0.label = r6
            java.lang.Object r12 = r12.insert(r11, r0)
            if (r12 != r1) goto L73
            goto Lc0
        L73:
            cu.todus.android.db.dao.cache.WelcomeMessageDao r12 = r10.welcomeMessageDao
            java.lang.Object r2 = cb.l.a(r11)
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r12 = r12.getMaxId(r0)
            if (r12 != r1) goto L55
            goto Lc0
        L84:
            java.lang.Number r12 = (java.lang.Number) r12
            int r11 = r12.intValue()
            cu.todus.android.di.PreferencesModule r12 = r10.preferences
            java.lang.Object r5 = cb.l.a(r2)
            r0.L$0 = r5
            r0.I$0 = r11
            r0.label = r4
            java.lang.Object r12 = r12.getAliveWelcomeMessageDataPreferences(r0)
            if (r12 != r1) goto L4c
            goto Lc0
        L9d:
            r4 = r12
            cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences r4 = (cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences) r4
            cu.todus.android.di.PreferencesModule r11 = r10.preferences
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences r12 = cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences.copy$default(r4, r5, r6, r7, r8, r9)
            java.lang.Object r2 = cb.l.a(r2)
            r0.L$0 = r2
            java.lang.Object r2 = cb.l.a(r4)
            r0.L$1 = r2
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r11 = r11.saveAliveWelcomeMessageDataPreferences(r12, r0)
            if (r11 != r1) goto Lc1
        Lc0:
            return r1
        Lc1:
            ua.k0 r11 = ua.k0.f43947a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.WelcomeMessageRepository.insertMessages(java.util.List, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c9, code lost:
    
        if (r12.saveAliveWelcomeMessageDataPreferences(r5, r0) == r1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object insertMockUpMessages(ab.e<? super ua.k0> r12) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.WelcomeMessageRepository.insertMockUpMessages(ab.e):java.lang.Object");
    }
}
