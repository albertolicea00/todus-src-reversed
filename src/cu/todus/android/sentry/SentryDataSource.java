package cu.todus.android.sentry;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import bb.b;
import cb.d;
import cb.f;
import cb.l;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.xmpp.extension.event.ExtensionEvent;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import lb.a;
import pe.d1;
import pe.m0;
import pe.n0;
import ua.k0;
import ua.v;
import ua.z;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0010J3\u0010\u0019\u001a\u00020\u000e2\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR \u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcu/todus/android/sentry/SentryDataSource;", "", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lkotlin/Function0;", "Lte/h;", "", "sentryState", "", "ownerId", "<init>", "(Lcu/todus/android/db/dao/toDus/RoomDao;Lcu/todus/android/db/dao/toDus/MessageDao;Llb/a;Ljava/lang/String;)V", "Lua/k0;", "createSentryRoomIfNeedIt", "(Lab/e;)Ljava/lang/Object;", "removeSentryChat", "Ljava/lang/Exception;", "Lkotlin/Exception;", ExtensionEvent.TAG_END, "className", "", "lineNumber", "state", "saveNewEntry", "(Ljava/lang/Exception;Ljava/lang/String;II)V", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Llb/a;", "Ljava/lang/String;", "Lpe/m0;", "coroutineContext", "Lpe/m0;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SentryDataSource {
    public static final String SENTRY_CH_ID = "sentrytodus@ch";
    private final m0 coroutineContext;
    private final MessageDao messageDao;
    private final String ownerId;
    private final RoomDao roomDao;
    private final a sentryState;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J3\u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcu/todus/android/sentry/SentryDataSource$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/sentry/SentryDataSource;", "<init>", "()V", "Ljava/lang/Exception;", "Lkotlin/Exception;", ExtensionEvent.TAG_END, "", "className", "", "lineNumber", "state", "Lua/k0;", "onError", "(Ljava/lang/Exception;Ljava/lang/String;II)V", "SENTRY_CH_ID", "Ljava/lang/String;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<SentryDataSource> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public static /* synthetic */ void onError$default(Companion companion, Exception exc, String str, int i10, int i11, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                i11 = 5;
            }
            companion.onError(exc, str, i10, i11);
        }

        public final void onError(Exception e10, String className, int lineNumber, int state) {
            y.i(e10, "e");
            y.i(className, "className");
            SentryDataSource instanceOrNull = SentryDataSource.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                instanceOrNull.saveNewEntry(e10, className, lineNumber, state);
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.sentry.SentryDataSource$createSentryRoomIfNeedIt$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.sentry.SentryDataSource", f = "SentryDataSource.kt", l = {42}, m = "createSentryRoomIfNeedIt", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SentryDataSource.this.createSentryRoomIfNeedIt(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.sentry.SentryDataSource$saveNewEntry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.sentry.SentryDataSource$saveNewEntry$1", f = "SentryDataSource.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, MdtaMetadataEntry.TYPE_INDICATOR_INT32, 83, 84}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11871 extends m implements Function1 {
        final /* synthetic */ String $className;
        final /* synthetic */ Exception $e;
        final /* synthetic */ int $lineNumber;
        final /* synthetic */ int $state;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11871(String str, int i10, Exception exc, int i11, e<? super C11871> eVar) {
            super(1, eVar);
            this.$className = str;
            this.$lineNumber = i10;
            this.$e = exc;
            this.$state = i11;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return SentryDataSource.this.new C11871(this.$className, this.$lineNumber, this.$e, this.$state, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((C11871) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0126, code lost:
        
            if (r7.insert(r6, r18) == r1) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0133, code lost:
        
            if (r10.removeSentryChat(r18) == r1) goto L29;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 313
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.sentry.SentryDataSource.C11871.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SentryDataSource(RoomDao roomDao, MessageDao messageDao, a sentryState, String ownerId) {
        y.i(roomDao, "roomDao");
        y.i(messageDao, "messageDao");
        y.i(sentryState, "sentryState");
        y.i(ownerId, "ownerId");
        this.roomDao = roomDao;
        this.messageDao = messageDao;
        this.sentryState = sentryState;
        this.ownerId = ownerId;
        this.coroutineContext = n0.a(d1.b());
    }

    public static /* synthetic */ void saveNewEntry$default(SentryDataSource sentryDataSource, Exception exc, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i11 = 5;
        }
        sentryDataSource.saveNewEntry(exc, str, i10, i11);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object createSentryRoomIfNeedIt(e<? super k0> eVar) {
        AnonymousClass1 anonymousClass1;
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
        Object objInsertIfNeed = anonymousClass1.result;
        Object objG = b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            v.b(objInsertIfNeed);
            Room room = new Room(SENTRY_CH_ID, "Registro de Errores", 2, "", "Este servicio es para ayudar al equipo de desarrollo a resolver problemas que ocurren fuera del ámbito de desarrollo.", w0.l(z.a(Room.CONFIG_ROOM_NAME, "Registro de Errores"), z.a("subject", "Este servicio es para ayudar al equipo de desarrollo a resolver problemas que ocurren fuera del ámbito de desarrollo.")), 0L, 0, "", false, false, true);
            RoomDao roomDao = this.roomDao;
            anonymousClass1.L$0 = l.a(room);
            anonymousClass1.label = 1;
            objInsertIfNeed = roomDao.insertIfNeed(room, anonymousClass1);
            if (objInsertIfNeed == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objInsertIfNeed);
        }
        if (((Number) objInsertIfNeed).longValue() != -1) {
            saveNewEntry(new Exception("Usted se ha subscrito al servicio de reporte de errores en producción. Este es un error de prueba.  Todo el equipo agradece su ayuda"), "Inicio", 0, 6);
        }
        return k0.f43947a;
    }

    public final Object removeSentryChat(e<? super k0> eVar) {
        Object objDelete = this.roomDao.delete(SENTRY_CH_ID, eVar);
        return objDelete == b.g() ? objDelete : k0.f43947a;
    }

    public final void saveNewEntry(Exception e10, String className, int lineNumber, int state) {
        y.i(e10, "e");
        y.i(className, "className");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineContext, null, null, new C11871(className, lineNumber, e10, state, null), 3, null);
    }
}
