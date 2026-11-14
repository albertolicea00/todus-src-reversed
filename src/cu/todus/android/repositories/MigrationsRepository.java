package cu.todus.android.repositories;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.migration.ToDusMigration;
import cu.todus.android.db.dao.toDus.AttachmentDao;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.ReactionDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.exceptions.ToDusException;
import cu.z17.singledi.SingletonInitializer;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u000f\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0010\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0011\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0012\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010'R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020%0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcu/todus/android/repositories/MigrationsRepository;", "", "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Llb/a;)V", "Lua/k0;", "addOldDatesToChat", "(Lab/e;)Ljava/lang/Object;", "", "roomId", "migratedDatesToMsgs", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "fixRoomTypes", "fixMsgsResentToChannels", "fixLastMsgsInChannels", "deleteAllReactions", "executeMigrations", "Llb/a;", "getOwner", "()Llb/a;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Lcu/todus/android/di/PreferencesModule;", "preferencesModule", "Lcu/todus/android/di/PreferencesModule;", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "attachmentDao", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "reactionDao", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "Lcu/todus/android/data/migration/ToDusMigration;", "migration30021_30022", "Lcu/todus/android/data/migration/ToDusMigration;", "migration30023_30024", "migration30024_30025", "migration30025_30026", "migration30026_30027", "migration30055_30056", "", "migrations", "Ljava/util/List;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MigrationsRepository {
    private final AttachmentDao attachmentDao;
    private final MessageDao messageDao;
    private final ToDusMigration migration30021_30022;
    private final ToDusMigration migration30023_30024;
    private final ToDusMigration migration30024_30025;
    private final ToDusMigration migration30025_30026;
    private final ToDusMigration migration30026_30027;
    private final ToDusMigration migration30055_30056;
    private final List<ToDusMigration> migrations;
    private final lb.a owner;
    private final PreferencesModule preferencesModule;
    private final ReactionDao reactionDao;
    private final RoomDao roomDao;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/MigrationsRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/MigrationsRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<MigrationsRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MigrationsRepository$addOldDatesToChat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MigrationsRepository", f = "MigrationsRepository.kt", l = {77, 80, 83}, m = "addOldDatesToChat", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MigrationsRepository.this.addOldDatesToChat(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MigrationsRepository$executeMigrations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MigrationsRepository", f = "MigrationsRepository.kt", l = {180, 185, PsExtractor.AUDIO_STREAM}, m = "executeMigrations", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11231 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11231(ab.e<? super C11231> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MigrationsRepository.this.executeMigrations(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MigrationsRepository$fixLastMsgsInChannels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MigrationsRepository", f = "MigrationsRepository.kt", l = {152, 153, WebmConstants.MkvEbmlElement.FLAG_LACING}, m = "fixLastMsgsInChannels", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11241 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C11241(ab.e<? super C11241> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MigrationsRepository.this.fixLastMsgsInChannels(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MigrationsRepository$fixMsgsResentToChannels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MigrationsRepository", f = "MigrationsRepository.kt", l = {146, 148}, m = "fixMsgsResentToChannels", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11251 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C11251(ab.e<? super C11251> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MigrationsRepository.this.fixMsgsResentToChannels(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MigrationsRepository$fixRoomTypes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MigrationsRepository", f = "MigrationsRepository.kt", l = {140, 141}, m = "fixRoomTypes", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11261 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11261(ab.e<? super C11261> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MigrationsRepository.this.fixRoomTypes(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MigrationsRepository$migratedDatesToMsgs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MigrationsRepository", f = "MigrationsRepository.kt", l = {87, 111, 132}, m = "migratedDatesToMsgs", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11271 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C11271(ab.e<? super C11271> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MigrationsRepository.this.migratedDatesToMsgs(null, this);
        }
    }

    public MigrationsRepository(lb.a owner) {
        kotlin.jvm.internal.y.i(owner, "owner");
        this.owner = owner;
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.messageDao = companion.getInstance().getMessageDao();
        this.roomDao = companion.getInstance().getRoomDao();
        this.preferencesModule = PreferencesModule.INSTANCE.getInstance();
        this.attachmentDao = companion.getInstance().getAttachmentDao();
        this.reactionDao = companion.getInstance().getReactionDao();
        ToDusMigration toDusMigration = new ToDusMigration(30021, 30022, new MigrationsRepository$migration30021_30022$1(this, null));
        this.migration30021_30022 = toDusMigration;
        ToDusMigration toDusMigration2 = new ToDusMigration(30023, 30024, new MigrationsRepository$migration30023_30024$1(this, null));
        this.migration30023_30024 = toDusMigration2;
        ToDusMigration toDusMigration3 = new ToDusMigration(30024, 30025, new MigrationsRepository$migration30024_30025$1(this, null));
        this.migration30024_30025 = toDusMigration3;
        ToDusMigration toDusMigration4 = new ToDusMigration(30025, 30026, new MigrationsRepository$migration30025_30026$1(this, null));
        this.migration30025_30026 = toDusMigration4;
        ToDusMigration toDusMigration5 = new ToDusMigration(30026, 30027, new MigrationsRepository$migration30026_30027$1(this, null));
        this.migration30026_30027 = toDusMigration5;
        ToDusMigration toDusMigration6 = new ToDusMigration(30054, 30055, new MigrationsRepository$migration30055_30056$1(this, null));
        this.migration30055_30056 = toDusMigration6;
        this.migrations = va.w.q(toDusMigration, toDusMigration2, toDusMigration3, toDusMigration4, toDusMigration5, toDusMigration6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x0075  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:? A[LOOP:0: B:22:0x006f->B:35:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        if (r14 == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c2, code lost:
    
        if (r14.setIsValidCertificate(true, r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object addOldDatesToChat(ab.e<? super ua.k0> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof cu.todus.android.repositories.MigrationsRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            cu.todus.android.repositories.MigrationsRepository$addOldDatesToChat$1 r0 = (cu.todus.android.repositories.MigrationsRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MigrationsRepository$addOldDatesToChat$1 r0 = new cu.todus.android.repositories.MigrationsRepository$addOldDatesToChat$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L57
            if (r2 == r6) goto L53
            if (r2 == r5) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            ua.v.b(r14)
            goto Lc5
        L35:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L3d:
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$4
            cu.todus.android.data.db.pojo.RoomItemView r7 = (cu.todus.android.data.db.pojo.RoomItemView) r7
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r0.L$1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.Object r9 = r0.L$0
            java.util.List r9 = (java.util.List) r9
            ua.v.b(r14)
            goto L6f
        L53:
            ua.v.b(r14)
            goto L65
        L57:
            ua.v.b(r14)
            cu.todus.android.db.dao.toDus.RoomDao r14 = r13.roomDao
            r0.label = r6
            java.lang.Object r14 = r14.getAllForSaves(r0)
            if (r14 != r1) goto L65
            goto Lc4
        L65:
            java.util.List r14 = (java.util.List) r14
            java.util.Iterator r2 = r14.iterator()
            r8 = r14
            r9 = r8
            r7 = r2
            r2 = r3
        L6f:
            boolean r14 = r7.hasNext()
            if (r14 == 0) goto Lab
            java.lang.Object r14 = r7.next()
            r10 = r14
            cu.todus.android.data.db.pojo.RoomItemView r10 = (cu.todus.android.data.db.pojo.RoomItemView) r10
            cu.todus.android.data.db.entity.toDus.Room r11 = r10.getRoom()
            java.lang.String r11 = r11.getId()
            java.lang.Object r12 = cb.l.a(r9)
            r0.L$0 = r12
            java.lang.Object r12 = cb.l.a(r8)
            r0.L$1 = r12
            r0.L$2 = r7
            java.lang.Object r14 = cb.l.a(r14)
            r0.L$3 = r14
            java.lang.Object r14 = cb.l.a(r10)
            r0.L$4 = r14
            r0.I$0 = r2
            r0.I$1 = r3
            r0.label = r5
            java.lang.Object r14 = r13.migratedDatesToMsgs(r11, r0)
            if (r14 != r1) goto L6f
            goto Lc4
        Lab:
            cu.todus.android.di.PreferencesModule r14 = r13.preferencesModule
            java.lang.Object r2 = cb.l.a(r9)
            r0.L$0 = r2
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.L$3 = r2
            r0.L$4 = r2
            r0.label = r4
            java.lang.Object r14 = r14.setIsValidCertificate(r6, r0)
            if (r14 != r1) goto Lc5
        Lc4:
            return r1
        Lc5:
            ua.k0 r14 = ua.k0.f43947a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MigrationsRepository.addOldDatesToChat(ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object deleteAllReactions(ab.e<? super ua.k0> eVar) {
        Object objDeleteAll = this.reactionDao.deleteAll(eVar);
        return objDeleteAll == bb.b.g() ? objDeleteAll : ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 executeMigrations$lambda$0$0(ToDusMigration toDusMigration) throws ToDusException {
        throw new ToDusException("Error running toDus migration from " + toDusMigration.getStartVersion() + " to " + toDusMigration.getEndVersion(), null, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:36:0x0104  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00fc -> B:35:0x00ff). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0104 -> B:37:0x0108). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fixLastMsgsInChannels(ab.e<? super ua.k0> r19) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MigrationsRepository.fixLastMsgsInChannels(ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (cu.todus.android.db.dao.toDus.a.a(r6, null, r0, 1, null) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fixMsgsResentToChannels(ab.e<? super ua.k0> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cu.todus.android.repositories.MigrationsRepository.C11251
            if (r0 == 0) goto L13
            r0 = r6
            cu.todus.android.repositories.MigrationsRepository$fixMsgsResentToChannels$1 r0 = (cu.todus.android.repositories.MigrationsRepository.C11251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MigrationsRepository$fixMsgsResentToChannels$1 r0 = new cu.todus.android.repositories.MigrationsRepository$fixMsgsResentToChannels$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ua.v.b(r6)
            goto L52
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            ua.v.b(r6)
            goto L46
        L38:
            ua.v.b(r6)
            cu.todus.android.db.dao.toDus.MessageDao r6 = r5.messageDao
            r0.label = r4
            java.lang.Object r6 = r6.deleteBadResentMsgs(r0)
            if (r6 != r1) goto L46
            goto L51
        L46:
            cu.todus.android.db.dao.toDus.AttachmentDao r6 = r5.attachmentDao
            r0.label = r3
            r2 = 0
            java.lang.Object r6 = cu.todus.android.db.dao.toDus.a.a(r6, r2, r0, r4, r2)
            if (r6 != r1) goto L52
        L51:
            return r1
        L52:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MigrationsRepository.fixMsgsResentToChannels(ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:28:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:? A[LOOP:0: B:20:0x0062->B:30:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if (r1 == r3) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fixRoomTypes(ab.e<? super ua.k0> r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            boolean r2 = r1 instanceof cu.todus.android.repositories.MigrationsRepository.C11261
            if (r2 == 0) goto L17
            r2 = r1
            cu.todus.android.repositories.MigrationsRepository$fixRoomTypes$1 r2 = (cu.todus.android.repositories.MigrationsRepository.C11261) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            cu.todus.android.repositories.MigrationsRepository$fixRoomTypes$1 r2 = new cu.todus.android.repositories.MigrationsRepository$fixRoomTypes$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = bb.b.g()
            int r4 = r2.label
            r5 = 0
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L4b
            if (r4 == r7) goto L47
            if (r4 != r6) goto L3f
            int r4 = r2.I$0
            java.lang.Object r7 = r2.L$3
            cu.todus.android.data.db.pojo.RoomItemView r7 = (cu.todus.android.data.db.pojo.RoomItemView) r7
            java.lang.Object r7 = r2.L$1
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r2.L$0
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            ua.v.b(r1)
            goto L62
        L3f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L47:
            ua.v.b(r1)
            goto L59
        L4b:
            ua.v.b(r1)
            cu.todus.android.db.dao.toDus.RoomDao r1 = r0.roomDao
            r2.label = r7
            java.lang.Object r1 = r1.getAllForSaves(r2)
            if (r1 != r3) goto L59
            goto Lbe
        L59:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r4 = r1.iterator()
            r8 = r1
            r7 = r4
            r4 = r5
        L62:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Lbf
            java.lang.Object r1 = r7.next()
            r9 = r1
            cu.todus.android.data.db.pojo.RoomItemView r9 = (cu.todus.android.data.db.pojo.RoomItemView) r9
            cu.todus.android.db.dao.toDus.RoomDao r10 = r0.roomDao
            cu.todus.android.data.db.entity.toDus.Room r11 = r9.getRoom()
            cu.todus.android.xmpp.XMPPUtils r12 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
            cu.todus.android.data.db.entity.toDus.Room r13 = r9.getRoom()
            java.lang.String r13 = r13.getId()
            int r14 = r12.getChatType(r13)
            r25 = 4091(0xffb, float:5.733E-42)
            r26 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            cu.todus.android.data.db.entity.toDus.Room r11 = cu.todus.android.data.db.entity.toDus.Room.copy$default(r11, r12, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26)
            java.lang.Object r12 = cb.l.a(r8)
            r2.L$0 = r12
            r2.L$1 = r7
            java.lang.Object r1 = cb.l.a(r1)
            r2.L$2 = r1
            java.lang.Object r1 = cb.l.a(r9)
            r2.L$3 = r1
            r2.I$0 = r4
            r2.I$1 = r5
            r2.label = r6
            java.lang.Object r1 = r10.update(r11, r2)
            if (r1 != r3) goto L62
        Lbe:
            return r3
        Lbf:
            ua.k0 r1 = ua.k0.f43947a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MigrationsRepository.fixRoomTypes(ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:36:0x0113  */
    /* JADX WARN: Code duplicated, block: B:38:0x011b  */
    /* JADX WARN: Code duplicated, block: B:48:0x019a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x019a -> B:49:0x019f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x01bc -> B:58:0x01bd). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object migratedDatesToMsgs(java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MigrationsRepository.migratedDatesToMsgs(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0075  */
    /* JADX WARN: Code duplicated, block: B:35:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x006f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x006f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        if (r14 == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c9, code lost:
    
        if (r14.setLastVersion(cu.todus.android.BuildConfig.VERSION_CODE, r0) == r1) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeMigrations(ab.e<? super ua.k0> r14) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MigrationsRepository.executeMigrations(ab.e):java.lang.Object");
    }

    public final lb.a getOwner() {
        return this.owner;
    }
}
