package cu.todus.android.xmpp.managers;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.ComposerImplKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.RosterChange;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.data.preferences.RosterVersionManager;
import cu.todus.android.data.xmpp.EditToDusIdResponse;
import cu.todus.android.db.dao.toDus.ContactDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.db.dao.toDus.RosterChangeDao;
import cu.todus.android.db.dao.toDus.UserDao;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.roster.RosterEditToDusIdIQ;
import cu.todus.android.xmpp.iq.roster.RosterGetListPaginatedIQ;
import cu.todus.android.xmpp.iq.roster.RosterGetToDusIdIQ;
import cu.todus.android.xmpp.iq.roster.RosterGetUsersInfoIQ;
import cu.z17.views.utils.Z17CoilDecoders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import org.jxmpp.jid.EntityFullJid;
import pe.d1;
import pe.m0;
import pe.n0;
import pe.t0;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ&\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0015\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0015\u0010\u0012J6\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0082@¢\u0006\u0004\b\u001e\u0010\u001dJ\u001e\u0010 \u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0082@¢\u0006\u0004\b \u0010!J\u001e\u0010#\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0082@¢\u0006\u0004\b#\u0010!J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b&\u0010\u001dJ\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b)\u0010\u001dJ\u001e\u0010*\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0082@¢\u0006\u0004\b*\u0010!J\"\u0010,\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b,\u0010-J\u001a\u0010.\u001a\u00020\u00102\b\b\u0002\u0010+\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u0004\u0018\u0001012\u0006\u00100\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b2\u0010%J\u0018\u00105\u001a\u0002042\u0006\u00103\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b5\u0010%J(\u00108\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0016\u0018\u0001072\u0006\u00106\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b8\u0010%J\u001a\u0010:\u001a\u0004\u0018\u0001012\u0006\u00109\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b:\u0010%J&\u0010<\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u000b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0086@¢\u0006\u0004\b<\u0010!R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010=\u001a\u0004\b>\u0010?R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010=\u001a\u0004\b@\u0010?R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Lcu/todus/android/xmpp/managers/RosterManager;", "", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lcu/todus/android/data/preferences/RosterVersionManager;", "versionManager", "<init>", "(Llb/a;Llb/a;Lcu/todus/android/data/preferences/RosterVersionManager;)V", "", "Lcu/todus/android/data/db/entity/toDus/Contact;", "contactsToUpload", "", "userId", "Lua/k0;", "handleEmptyRosterCase", "(Ljava/util/List;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/entity/toDus/RosterChange;", "pendingChanges", "handleNoConflictSync", "", "localVersion", "serverVersion", "localChanges", "handleVersionConflict", "(IILjava/util/List;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "fillDbFromPhone", "(Lab/e;)Ljava/lang/Object;", "detectLocalChangesFromPhone", "changes", "uploadIncrementalChanges", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "contacts", "uploadContactsBatch", "downloadFullRoster", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "fetchCurrentServerVersion", "toContacts", "(Ljava/util/List;)Ljava/util/List;", "loadUsersInfoParallel", "deleteContactsFromRosterOnline", "hasContactsPermission", "syncRosterWithVersioning", "(Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "loadRosterAndUsersInfo", "(ZLab/e;)Ljava/lang/Object;", "uid", "Lcu/todus/android/data/db/entity/toDus/User;", "reloadUser", User.COLUMN_TODUS_ID, "Lcu/todus/android/data/xmpp/EditToDusIdResponse;", "editToDusId", "username", "Lkotlin/Pair;", "getToDusId", TemplateContent.NUMBER_TYPE, "getUserInfo", "numbers", "getUsersInfo", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "Lcu/todus/android/data/preferences/RosterVersionManager;", "Lcu/todus/android/db/dao/toDus/ContactDao;", "contactDao", "Lcu/todus/android/db/dao/toDus/ContactDao;", "Lcu/todus/android/db/dao/toDus/UserDao;", "userDao", "Lcu/todus/android/db/dao/toDus/UserDao;", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "userRoomJoinDao", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "rosterChangeDao", "Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "isSyncing", "Z", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final ContactDao contactDao;
    private boolean isSyncing;
    private final lb.a mXMPPConnection;
    private final RoomDao roomDao;
    private final RosterChangeDao rosterChangeDao;
    private final UserDao userDao;
    private final UserRoomJoinDao userRoomJoinDao;
    private final RosterVersionManager versionManager;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$deleteContactsFromRosterOnline$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {618, 613}, m = "deleteContactsFromRosterOnline", v = 2)
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
            return RosterManager.this.deleteContactsFromRosterOnline(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$detectLocalChangesFromPhone$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {306, 307, 325, 328, 348, 352, 369, 371, 375, 379}, m = "detectLocalChangesFromPhone", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14911 extends cb.d {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C14911(ab.e<? super C14911> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.detectLocalChangesFromPhone(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$downloadFullRoster$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {448, 476, 477, 479}, m = "downloadFullRoster", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14921 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14921(ab.e<? super C14921> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.downloadFullRoster(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$downloadFullRoster$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$downloadFullRoster$2", f = "RosterManager.kt", l = {618}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", DataLayout.ELEMENT, "", "pageSize"}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass2 extends cb.m implements Function3 {
        /* synthetic */ int I$0;
        /* synthetic */ int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(3, eVar);
        }

        public final Object invoke(int i10, int i11, ab.e<? super List<Pair<String, String>>> eVar) {
            AnonymousClass2 anonymousClass2 = RosterManager.this.new AnonymousClass2(eVar);
            anonymousClass2.I$0 = i10;
            anonymousClass2.I$1 = i11;
            return anonymousClass2.invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0085 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:6:0x001f, B:18:0x0078, B:20:0x007e, B:24:0x0089, B:23:0x0085, B:13:0x0033, B:15:0x0042), top: B:32:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:30:0x009f  */
        /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objB;
            List<Pair<String, String>> listN;
            int i10 = this.I$0;
            int i11 = this.I$1;
            Object objG = bb.b.g();
            int i12 = this.label;
            try {
                if (i12 == 0) {
                    ua.v.b(obj);
                    RosterManager rosterManager = RosterManager.this;
                    ua.u.a aVar = ua.u.f43963f;
                    XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) rosterManager.getMXMPPConnection().invoke();
                    if (xMPPTCPConnection != null) {
                        RosterGetListPaginatedIQ rosterGetListPaginatedIQ = new RosterGetListPaginatedIQ(null, i11, i10, 1, null);
                        te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, rosterGetListPaginatedIQ);
                        this.L$0 = cb.l.a(rosterManager);
                        this.L$1 = cb.l.a(xMPPTCPConnection);
                        this.L$2 = cb.l.a(rosterGetListPaginatedIQ);
                        this.L$3 = cb.l.a(this);
                        this.I$0 = i10;
                        this.I$1 = i11;
                        this.I$2 = 0;
                        this.I$3 = 0;
                        this.label = 1;
                        obj = te.j.x(hVarSendIQFlow, this);
                        if (obj == objG) {
                            return objG;
                        }
                    } else {
                        listN = va.w.n();
                    }
                    objB = ua.u.b(listN);
                    if (ua.u.e(objB) == null) {
                        return objB;
                    }
                    return va.w.n();
                }
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                RosterGetListPaginatedIQ rosterGetListPaginatedIQ2 = (RosterGetListPaginatedIQ) ((IQ) obj);
                if (rosterGetListPaginatedIQ2 == null || (listN = rosterGetListPaginatedIQ2.getContacts()) == null) {
                    listN = va.w.n();
                }
                objB = ua.u.b(listN);
            } catch (Throwable th2) {
                ua.u.a aVar2 = ua.u.f43963f;
                objB = ua.u.b(ua.v.a(th2));
            }
            if (ua.u.e(objB) == null) {
                return objB;
            }
            return va.w.n();
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (ab.e<? super List<Pair<String, String>>>) obj3);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$downloadFullRoster$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$downloadFullRoster$3", f = "RosterManager.kt", l = {470}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lkotlin/Pair;", "", "contacts", "Lua/k0;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public AnonymousClass3(ab.e<? super AnonymousClass3> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass3 anonymousClass3 = RosterManager.this.new AnonymousClass3(eVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            List<Pair> list = (List) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                if (list.isEmpty()) {
                    return k0.f43947a;
                }
                ArrayList arrayList = new ArrayList(va.x.y(list, 10));
                for (Pair pair : list) {
                    String str = (String) pair.component1();
                    arrayList.add(new Contact(str, str + "@im.todus.cu", (String) pair.component2(), "Cloud", null, Contact.UPLOADED, 16, null));
                }
                ContactDao contactDao = RosterManager.this.contactDao;
                this.L$0 = cb.l.a(list);
                this.L$1 = cb.l.a(arrayList);
                this.label = 1;
                if (contactDao.insert(arrayList, this) == objG) {
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
        public final Object invoke(List<Pair<String, String>> list, ab.e<? super k0> eVar) {
            return ((AnonymousClass3) create(list, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$editToDusId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$editToDusId$2", f = "RosterManager.kt", l = {618}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lcu/todus/android/data/xmpp/EditToDusIdResponse;", "<anonymous>", "(Lpe/m0;)Lcu/todus/android/data/xmpp/EditToDusIdResponse;"}, k = 3, mv = {2, 3, 0})
    public static final class C14932 extends cb.m implements Function2 {
        final /* synthetic */ String $toDusId;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14932(String str, ab.e<? super C14932> eVar) {
            super(2, eVar);
            this.$toDusId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C14932 c14932 = RosterManager.this.new C14932(this.$toDusId, eVar);
            c14932.L$0 = obj;
            return c14932;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x009a A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0022, B:22:0x0092, B:25:0x009a, B:27:0x00a0, B:34:0x00b3, B:37:0x00bc, B:47:0x00e6, B:38:0x00c2, B:41:0x00cb, B:42:0x00d1, B:45:0x00da, B:46:0x00e1, B:17:0x0050, B:19:0x005e), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:27:0x00a0 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0022, B:22:0x0092, B:25:0x009a, B:27:0x00a0, B:34:0x00b3, B:37:0x00bc, B:47:0x00e6, B:38:0x00c2, B:41:0x00cb, B:42:0x00d1, B:45:0x00da, B:46:0x00e1, B:17:0x0050, B:19:0x005e), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:31:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:38:0x00c2 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0022, B:22:0x0092, B:25:0x009a, B:27:0x00a0, B:34:0x00b3, B:37:0x00bc, B:47:0x00e6, B:38:0x00c2, B:41:0x00cb, B:42:0x00d1, B:45:0x00da, B:46:0x00e1, B:17:0x0050, B:19:0x005e), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:41:0x00cb A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0022, B:22:0x0092, B:25:0x009a, B:27:0x00a0, B:34:0x00b3, B:37:0x00bc, B:47:0x00e6, B:38:0x00c2, B:41:0x00cb, B:42:0x00d1, B:45:0x00da, B:46:0x00e1, B:17:0x0050, B:19:0x005e), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:42:0x00d1 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0022, B:22:0x0092, B:25:0x009a, B:27:0x00a0, B:34:0x00b3, B:37:0x00bc, B:47:0x00e6, B:38:0x00c2, B:41:0x00cb, B:42:0x00d1, B:45:0x00da, B:46:0x00e1, B:17:0x0050, B:19:0x005e), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:44:0x00d9  */
        /* JADX WARN: Code duplicated, block: B:45:0x00da A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0022, B:22:0x0092, B:25:0x009a, B:27:0x00a0, B:34:0x00b3, B:37:0x00bc, B:47:0x00e6, B:38:0x00c2, B:41:0x00cb, B:42:0x00d1, B:45:0x00da, B:46:0x00e1, B:17:0x0050, B:19:0x005e), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:46:0x00e1 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0022, B:22:0x0092, B:25:0x009a, B:27:0x00a0, B:34:0x00b3, B:37:0x00bc, B:47:0x00e6, B:38:0x00c2, B:41:0x00cb, B:42:0x00d1, B:45:0x00da, B:46:0x00e1, B:17:0x0050, B:19:0x005e), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:53:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objB;
            RosterEditToDusIdIQ rosterEditToDusIdIQ;
            String code;
            EditToDusIdResponse editToDusIdResponse;
            int iHashCode;
            m0 m0Var = (m0) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    ua.v.b(obj);
                    if (!((Boolean) RosterManager.this.getCanSend().invoke()).booleanValue()) {
                        return new EditToDusIdResponse(0);
                    }
                    RosterManager rosterManager = RosterManager.this;
                    String str = this.$toDusId;
                    ua.u.a aVar = ua.u.f43963f;
                    XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) rosterManager.getMXMPPConnection().invoke();
                    if (xMPPTCPConnection != null) {
                        RosterEditToDusIdIQ rosterEditToDusIdIQ2 = new RosterEditToDusIdIQ(str, null, 2, null);
                        te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, rosterEditToDusIdIQ2);
                        this.L$0 = cb.l.a(m0Var);
                        this.L$1 = cb.l.a(m0Var);
                        this.L$2 = cb.l.a(xMPPTCPConnection);
                        this.L$3 = cb.l.a(rosterEditToDusIdIQ2);
                        this.L$4 = cb.l.a(this);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        obj = te.j.x(hVarSendIQFlow, this);
                        if (obj == objG) {
                            return objG;
                        }
                    } else {
                        rosterEditToDusIdIQ = null;
                    }
                    code = rosterEditToDusIdIQ != null ? rosterEditToDusIdIQ.getCode() : null;
                    if (code == null) {
                        editToDusIdResponse = new EditToDusIdResponse(0);
                    } else {
                        iHashCode = code.hashCode();
                        if (iHashCode != -1295746435) {
                            if (iHashCode != 2524) {
                                if (iHashCode == 469021828 && code.equals("ERR_USER_UNAVAILABLE_ID")) {
                                    editToDusIdResponse = new EditToDusIdResponse(1);
                                } else {
                                    editToDusIdResponse = new EditToDusIdResponse(0);
                                }
                            } else if (code.equals("OK")) {
                                editToDusIdResponse = new EditToDusIdResponse(2);
                            } else {
                                editToDusIdResponse = new EditToDusIdResponse(0);
                            }
                        } else if (code.equals("ERR_USER_INVALID_ID")) {
                            editToDusIdResponse = new EditToDusIdResponse(3);
                        } else {
                            editToDusIdResponse = new EditToDusIdResponse(0);
                        }
                    }
                    objB = ua.u.b(editToDusIdResponse);
                    if (ua.u.e(objB) == null) {
                        return objB;
                    }
                    return new EditToDusIdResponse(0);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                rosterEditToDusIdIQ = (RosterEditToDusIdIQ) ((IQ) obj);
                if (rosterEditToDusIdIQ != null) {
                }
                if (code == null) {
                    editToDusIdResponse = new EditToDusIdResponse(0);
                } else {
                    iHashCode = code.hashCode();
                    if (iHashCode != -1295746435) {
                        if (iHashCode != 2524) {
                            if (iHashCode == 469021828) {
                                editToDusIdResponse = new EditToDusIdResponse(1);
                            }
                            editToDusIdResponse = new EditToDusIdResponse(0);
                        } else if (code.equals("OK")) {
                            editToDusIdResponse = new EditToDusIdResponse(0);
                        } else {
                            editToDusIdResponse = new EditToDusIdResponse(2);
                        }
                    } else if (code.equals("ERR_USER_INVALID_ID")) {
                        editToDusIdResponse = new EditToDusIdResponse(0);
                    } else {
                        editToDusIdResponse = new EditToDusIdResponse(3);
                    }
                }
                objB = ua.u.b(editToDusIdResponse);
            } catch (Throwable th2) {
                ua.u.a aVar2 = ua.u.f43963f;
                objB = ua.u.b(ua.v.a(th2));
            }
            if (ua.u.e(objB) == null) {
                return objB;
            }
            return new EditToDusIdResponse(0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super EditToDusIdResponse> eVar) {
            return ((C14932) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$fetchCurrentServerVersion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {486}, m = "fetchCurrentServerVersion", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14941 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14941(ab.e<? super C14941> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.fetchCurrentServerVersion(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$fillDbFromPhone$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {285, 286, 290}, m = "fillDbFromPhone", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14951 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C14951(ab.e<? super C14951> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.fillDbFromPhone(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$getToDusId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$getToDusId$2", f = "RosterManager.kt", l = {618}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lpe/m0;", "Lkotlin/Pair;", "", "", "<anonymous>", "(Lpe/m0;)Lkotlin/Pair;"}, k = 3, mv = {2, 3, 0})
    public static final class C14962 extends cb.m implements Function2 {
        final /* synthetic */ String $username;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14962(String str, ab.e<? super C14962> eVar) {
            super(2, eVar);
            this.$username = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C14962 c14962 = RosterManager.this.new C14962(this.$username, eVar);
            c14962.L$0 = obj;
            return c14962;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:31:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Pair pairA;
            m0 m0Var = (m0) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    ua.v.b(obj);
                    if (!((Boolean) RosterManager.this.getCanSend().invoke()).booleanValue()) {
                        return null;
                    }
                    RosterManager rosterManager = RosterManager.this;
                    String str = this.$username;
                    ua.u.a aVar = ua.u.f43963f;
                    XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) rosterManager.getMXMPPConnection().invoke();
                    if (xMPPTCPConnection != null) {
                        RosterGetToDusIdIQ rosterGetToDusIdIQ = new RosterGetToDusIdIQ(str, null, 0, 6, null);
                        te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, rosterGetToDusIdIQ);
                        this.L$0 = cb.l.a(m0Var);
                        this.L$1 = cb.l.a(m0Var);
                        this.L$2 = cb.l.a(xMPPTCPConnection);
                        this.L$3 = cb.l.a(rosterGetToDusIdIQ);
                        this.L$4 = cb.l.a(this);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        obj = te.j.x(hVarSendIQFlow, this);
                        if (obj == objG) {
                            return objG;
                        }
                    } else {
                        pairA = null;
                    }
                    objB = ua.u.b(pairA);
                    if (ua.u.g(objB)) {
                        return null;
                    }
                    return objB;
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                RosterGetToDusIdIQ rosterGetToDusIdIQ2 = (RosterGetToDusIdIQ) ((IQ) obj);
                if (rosterGetToDusIdIQ2 != null) {
                    pairA = ua.z.a(rosterGetToDusIdIQ2.getToDusId(), cb.b.d(rosterGetToDusIdIQ2.getMinVersionAllowed()));
                } else {
                    pairA = null;
                }
                objB = ua.u.b(pairA);
            } catch (Throwable th2) {
                ua.u.a aVar2 = ua.u.f43963f;
                objB = ua.u.b(ua.v.a(th2));
            }
            if (ua.u.g(objB)) {
                return null;
            }
            return objB;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super Pair<String, Integer>> eVar) {
            return ((C14962) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$getUserInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {618}, m = "getUserInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14971 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C14971(ab.e<? super C14971> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.getUserInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$getUsersInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {618}, m = "getUsersInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14981 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C14981(ab.e<? super C14981> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.getUsersInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$handleEmptyRosterCase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {191, 199, ComposerKt.compositionLocalMapKey, 204, 209}, m = "handleEmptyRosterCase", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14991 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C14991(ab.e<? super C14991> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.handleEmptyRosterCase(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$handleNoConflictSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {220, 221, 227, WebmConstants.MkvEbmlElement.TIMESTAMP, 233, 235, 239}, m = "handleNoConflictSync", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15001 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C15001(ab.e<? super C15001> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.handleNoConflictSync(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$handleVersionConflict$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {261, 263, 266, 267, 274, 275}, m = "handleVersionConflict", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15011 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C15011(ab.e<? super C15011> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.handleVersionConflict(0, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$loadRosterAndUsersInfo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$loadRosterAndUsersInfo$2", f = "RosterManager.kt", l = {WebmConstants.MkvEbmlElement.TRACK_ENTRY, 175}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C15022 extends cb.m implements Function2 {
        final /* synthetic */ boolean $hasContactsPermission;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15022(boolean z10, ab.e<? super C15022> eVar) {
            super(2, eVar);
            this.$hasContactsPermission = z10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return RosterManager.this.new C15022(this.$hasContactsPermission, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
        
            if (r7.loadUsersInfoParallel(r6) == r0) goto L26;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r6.L$0
                java.lang.String r0 = (java.lang.String) r0
                ua.v.b(r7)
                goto L7d
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.L$0
                java.lang.String r1 = (java.lang.String) r1
                ua.v.b(r7)
                goto L6c
            L26:
                ua.v.b(r7)
                cu.todus.android.xmpp.managers.RosterManager r7 = cu.todus.android.xmpp.managers.RosterManager.this
                lb.a r7 = r7.getCanSend()
                java.lang.Object r7 = r7.invoke()
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 != 0) goto L3e
                ua.k0 r7 = ua.k0.f43947a
                return r7
            L3e:
                cu.todus.android.xmpp.managers.RosterManager r7 = cu.todus.android.xmpp.managers.RosterManager.this
                lb.a r7 = r7.getMXMPPConnection()
                java.lang.Object r7 = r7.invoke()
                org.jivesoftware.smack.tcp.XMPPTCPConnection r7 = (org.jivesoftware.smack.tcp.XMPPTCPConnection) r7
                if (r7 == 0) goto L80
                org.jxmpp.jid.EntityFullJid r7 = r7.getUser()
                if (r7 == 0) goto L80
                java.lang.String r1 = r7.asEntityBareJidString()
                if (r1 != 0) goto L59
                goto L80
            L59:
                cu.todus.android.xmpp.managers.RosterManager r7 = cu.todus.android.xmpp.managers.RosterManager.this
                boolean r4 = r6.$hasContactsPermission
                java.lang.Object r5 = cb.l.a(r1)
                r6.L$0 = r5
                r6.label = r3
                java.lang.Object r7 = r7.syncRosterWithVersioning(r1, r4, r6)
                if (r7 != r0) goto L6c
                goto L7c
            L6c:
                cu.todus.android.xmpp.managers.RosterManager r7 = cu.todus.android.xmpp.managers.RosterManager.this
                java.lang.Object r1 = cb.l.a(r1)
                r6.L$0 = r1
                r6.label = r2
                java.lang.Object r7 = cu.todus.android.xmpp.managers.RosterManager.access$loadUsersInfoParallel(r7, r6)
                if (r7 != r0) goto L7d
            L7c:
                return r0
            L7d:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            L80:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.C15022.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C15022) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$loadUsersInfoParallel$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$loadUsersInfoParallel$2", f = "RosterManager.kt", l = {564, 565, 580}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C15032 extends cb.m implements Function2 {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        public C15032(ab.e<? super C15032> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C15032 c15032 = RosterManager.this.new C15032(eVar);
            c15032.L$0 = obj;
            return c15032;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:27:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:30:0x00c9 A[LOOP:0: B:28:0x00c3->B:30:0x00c9, LOOP_END] */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0104, code lost:
        
            if (pe.f.a(r15, r17) == r1) goto L33;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 266
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.C15032.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C15032) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$reloadUser$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$reloadUser$2", f = "RosterManager.kt", l = {FrameMetricsAggregator.EVERY_DURATION, 512, 517, 519, 520, 521}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lcu/todus/android/data/db/entity/toDus/User;", "<anonymous>", "(Lpe/m0;)Lcu/todus/android/data/db/entity/toDus/User;"}, k = 3, mv = {2, 3, 0})
    public static final class C15042 extends cb.m implements Function2 {
        final /* synthetic */ String $uid;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ RosterManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15042(String str, RosterManager rosterManager, ab.e<? super C15042> eVar) {
            super(2, eVar);
            this.$uid = str;
            this.this$0 = rosterManager;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C15042 c15042 = new C15042(this.$uid, this.this$0, eVar);
            c15042.L$0 = obj;
            return c15042;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x017c  */
        /* JADX WARN: Code duplicated, block: B:23:0x0185  */
        /* JADX WARN: Code duplicated, block: B:25:0x018b  */
        /* JADX WARN: Code duplicated, block: B:29:0x0199  */
        /* JADX WARN: Code duplicated, block: B:30:0x01a0  */
        /* JADX WARN: Code duplicated, block: B:34:0x01f8  */
        /* JADX WARN: Code duplicated, block: B:38:0x0239 A[PHI: r3 r4 r5 r6 r7 r9 r10 r11 r12 r13 r14
          0x0239: PHI (r3v15 int) = (r3v13 int), (r3v16 int) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r4v20 cu.todus.android.data.db.entity.toDus.User) = (r4v17 cu.todus.android.data.db.entity.toDus.User), (r4v22 cu.todus.android.data.db.entity.toDus.User) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r5v15 cu.todus.android.data.db.entity.toDus.User) = (r5v12 cu.todus.android.data.db.entity.toDus.User), (r5v17 cu.todus.android.data.db.entity.toDus.User) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r6v22 java.lang.String) = (r6v19 java.lang.String), (r6v25 java.lang.String) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r7v5 cu.todus.android.xmpp.managers.RosterManager) = (r7v2 cu.todus.android.xmpp.managers.RosterManager), (r7v8 cu.todus.android.xmpp.managers.RosterManager) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r9v6 cu.todus.android.data.db.entity.toDus.User) = (r9v3 cu.todus.android.data.db.entity.toDus.User), (r9v8 cu.todus.android.data.db.entity.toDus.User) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r10v8 cu.todus.android.data.db.entity.toDus.User) = (r10v5 cu.todus.android.data.db.entity.toDus.User), (r10v10 cu.todus.android.data.db.entity.toDus.User) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r11v10 pe.t0) = (r11v7 pe.t0), (r11v12 pe.t0) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r12v7 pe.t0) = (r12v4 pe.t0), (r12v9 pe.t0) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r13v7 java.lang.String) = (r13v4 java.lang.String), (r13v9 java.lang.String) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]
          0x0239: PHI (r14v5 java.lang.Object) = (r14v4 java.lang.Object), (r14v7 java.lang.Object) binds: [B:36:0x0235, B:9:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:40:0x023d  */
        /* JADX WARN: Code duplicated, block: B:43:0x027d  */
        /* JADX WARN: Code duplicated, block: B:46:0x0287  */
        /* JADX WARN: Code duplicated, block: B:50:0x0290  */
        /* JADX WARN: Code duplicated, block: B:54:0x0302  */
        /* JADX WARN: Code duplicated, block: B:59:0x0325 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x0326 A[RETURN] */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            t0 t0VarB;
            t0 t0VarB2;
            Object objL;
            String str;
            User user;
            Object objL2;
            User user2;
            String str2;
            t0 t0Var;
            t0 t0Var2;
            User user3;
            RosterManager rosterManager;
            String str3;
            boolean blocked;
            User userCopy$default;
            UserDao userDao;
            String str4;
            int i10;
            User user4;
            User user5;
            Object roomById;
            Room room;
            Object partnerById;
            RosterManager rosterManager2;
            Room room2;
            int i11;
            Partner partner;
            String alias;
            RoomDao roomDao;
            Room roomCopy$default;
            User user6;
            User user7;
            m0 m0Var = (m0) this.L$0;
            Object objG = bb.b.g();
            switch (this.label) {
                case 0:
                    ua.v.b(obj);
                    String strO = le.a0.O(this.$uid, "@im.todus.cu", "", false, 4, null);
                    t0VarB = pe.k.b(m0Var, null, null, new RosterManager$reloadUser$2$localUserDeferred$1(this.this$0, this.$uid, null), 3, null);
                    t0VarB2 = pe.k.b(m0Var, null, null, new RosterManager$reloadUser$2$serverUserDeferred$1(this.this$0, strO, null), 3, null);
                    this.L$0 = cb.l.a(m0Var);
                    this.L$1 = cb.l.a(strO);
                    this.L$2 = cb.l.a(t0VarB);
                    this.L$3 = t0VarB2;
                    this.label = 1;
                    objL = t0VarB.l(this);
                    if (objL != objG) {
                        str = strO;
                        user = (User) objL;
                        this.L$0 = cb.l.a(m0Var);
                        this.L$1 = cb.l.a(str);
                        this.L$2 = cb.l.a(t0VarB);
                        this.L$3 = cb.l.a(t0VarB2);
                        this.L$4 = user;
                        this.label = 2;
                        objL2 = t0VarB2.l(this);
                        if (objL2 != objG) {
                            user2 = user;
                            str2 = str;
                            t0Var = t0VarB;
                            t0Var2 = t0VarB2;
                            user3 = (User) objL2;
                            if (user3 != null) {
                                rosterManager = this.this$0;
                                str3 = this.$uid;
                                if (user2 != null || user3.getVersion() != user2.getVersion()) {
                                    if (user2 != null) {
                                        blocked = user2.getBlocked();
                                    } else {
                                        blocked = false;
                                    }
                                    userCopy$default = User.copy$default(user3, null, null, null, null, null, 0, null, 0, blocked, null, 767, null);
                                    userDao = rosterManager.userDao;
                                    this.L$0 = cb.l.a(m0Var);
                                    this.L$1 = cb.l.a(str2);
                                    this.L$2 = cb.l.a(t0Var);
                                    this.L$3 = cb.l.a(t0Var2);
                                    this.L$4 = cb.l.a(user2);
                                    this.L$5 = cb.l.a(user3);
                                    this.L$6 = rosterManager;
                                    this.L$7 = str3;
                                    this.L$8 = user3;
                                    this.L$9 = userCopy$default;
                                    this.I$0 = 0;
                                    this.label = 3;
                                    if (userDao.upsert(userCopy$default, this) != objG) {
                                        str4 = str3;
                                        i10 = 0;
                                        user4 = user3;
                                        user5 = user4;
                                        RoomDao roomDao2 = rosterManager.roomDao;
                                        this.L$0 = cb.l.a(m0Var);
                                        this.L$1 = cb.l.a(str2);
                                        this.L$2 = cb.l.a(t0Var);
                                        this.L$3 = cb.l.a(t0Var2);
                                        this.L$4 = cb.l.a(user2);
                                        this.L$5 = cb.l.a(user5);
                                        this.L$6 = rosterManager;
                                        this.L$7 = str4;
                                        this.L$8 = user4;
                                        this.L$9 = userCopy$default;
                                        this.I$0 = i10;
                                        this.label = 4;
                                        roomById = roomDao2.getRoomById(str4, this);
                                        if (roomById != objG) {
                                            room = (Room) roomById;
                                            if (room != null) {
                                                UserDao userDao2 = rosterManager.userDao;
                                                this.L$0 = cb.l.a(m0Var);
                                                this.L$1 = cb.l.a(str2);
                                                this.L$2 = cb.l.a(t0Var);
                                                this.L$3 = cb.l.a(t0Var2);
                                                this.L$4 = cb.l.a(user2);
                                                this.L$5 = cb.l.a(user5);
                                                this.L$6 = rosterManager;
                                                this.L$7 = user4;
                                                this.L$8 = userCopy$default;
                                                this.L$9 = room;
                                                this.I$0 = i10;
                                                this.I$1 = 0;
                                                this.label = 5;
                                                partnerById = userDao2.getPartnerById(str4, this);
                                                if (partnerById != objG) {
                                                    rosterManager2 = rosterManager;
                                                    room2 = room;
                                                    i11 = 0;
                                                    User user8 = user5;
                                                    User user9 = user2;
                                                    t0 t0Var3 = t0Var2;
                                                    t0 t0Var4 = t0Var;
                                                    String str5 = str2;
                                                    partner = (Partner) partnerById;
                                                    if (partner != null || (alias = partner.getName()) == null) {
                                                        alias = user4.getAlias();
                                                    }
                                                    String str6 = alias;
                                                    roomDao = rosterManager2.roomDao;
                                                    roomCopy$default = Room.copy$default(room2, null, str6, 0, null, null, null, 0L, 0, null, false, false, false, 4093, null);
                                                    this.L$0 = cb.l.a(m0Var);
                                                    this.L$1 = cb.l.a(str5);
                                                    this.L$2 = cb.l.a(t0Var4);
                                                    this.L$3 = cb.l.a(t0Var3);
                                                    this.L$4 = cb.l.a(user9);
                                                    this.L$5 = cb.l.a(user8);
                                                    this.L$6 = user4;
                                                    this.L$7 = userCopy$default;
                                                    this.L$8 = cb.l.a(room2);
                                                    this.L$9 = cb.l.a(str6);
                                                    this.I$0 = i10;
                                                    this.I$1 = i11;
                                                    this.label = 6;
                                                    if (roomDao.update(roomCopy$default, this) != objG) {
                                                        user6 = userCopy$default;
                                                        user7 = user4;
                                                        userCopy$default = user6;
                                                        user4 = user7;
                                                    }
                                                }
                                            }
                                            Z17CoilDecoders.Companion companion = Z17CoilDecoders.INSTANCE;
                                            companion.getInstance().clearCacheFor(user4.getPhotoUrl());
                                            companion.getInstance().clearCacheFor(user4.getPhotoThumbnail());
                                            return userCopy$default;
                                        }
                                    }
                                }
                            }
                            if (user3 == null) {
                                return user2;
                            }
                            return user3;
                        }
                    }
                    return objG;
                case 1:
                    t0VarB2 = (t0) this.L$3;
                    t0 t0Var5 = (t0) this.L$2;
                    str = (String) this.L$1;
                    ua.v.b(obj);
                    t0VarB = t0Var5;
                    objL = obj;
                    user = (User) objL;
                    this.L$0 = cb.l.a(m0Var);
                    this.L$1 = cb.l.a(str);
                    this.L$2 = cb.l.a(t0VarB);
                    this.L$3 = cb.l.a(t0VarB2);
                    this.L$4 = user;
                    this.label = 2;
                    objL2 = t0VarB2.l(this);
                    if (objL2 != objG) {
                        user2 = user;
                        str2 = str;
                        t0Var = t0VarB;
                        t0Var2 = t0VarB2;
                        user3 = (User) objL2;
                        if (user3 != null) {
                            rosterManager = this.this$0;
                            str3 = this.$uid;
                            if (user2 != null) {
                            }
                            if (user2 != null) {
                                blocked = user2.getBlocked();
                            } else {
                                blocked = false;
                            }
                            userCopy$default = User.copy$default(user3, null, null, null, null, null, 0, null, 0, blocked, null, 767, null);
                            userDao = rosterManager.userDao;
                            this.L$0 = cb.l.a(m0Var);
                            this.L$1 = cb.l.a(str2);
                            this.L$2 = cb.l.a(t0Var);
                            this.L$3 = cb.l.a(t0Var2);
                            this.L$4 = cb.l.a(user2);
                            this.L$5 = cb.l.a(user3);
                            this.L$6 = rosterManager;
                            this.L$7 = str3;
                            this.L$8 = user3;
                            this.L$9 = userCopy$default;
                            this.I$0 = 0;
                            this.label = 3;
                            if (userDao.upsert(userCopy$default, this) != objG) {
                                str4 = str3;
                                i10 = 0;
                                user4 = user3;
                                user5 = user4;
                                RoomDao roomDao3 = rosterManager.roomDao;
                                this.L$0 = cb.l.a(m0Var);
                                this.L$1 = cb.l.a(str2);
                                this.L$2 = cb.l.a(t0Var);
                                this.L$3 = cb.l.a(t0Var2);
                                this.L$4 = cb.l.a(user2);
                                this.L$5 = cb.l.a(user5);
                                this.L$6 = rosterManager;
                                this.L$7 = str4;
                                this.L$8 = user4;
                                this.L$9 = userCopy$default;
                                this.I$0 = i10;
                                this.label = 4;
                                roomById = roomDao3.getRoomById(str4, this);
                                if (roomById != objG) {
                                    room = (Room) roomById;
                                    if (room != null) {
                                        UserDao userDao3 = rosterManager.userDao;
                                        this.L$0 = cb.l.a(m0Var);
                                        this.L$1 = cb.l.a(str2);
                                        this.L$2 = cb.l.a(t0Var);
                                        this.L$3 = cb.l.a(t0Var2);
                                        this.L$4 = cb.l.a(user2);
                                        this.L$5 = cb.l.a(user5);
                                        this.L$6 = rosterManager;
                                        this.L$7 = user4;
                                        this.L$8 = userCopy$default;
                                        this.L$9 = room;
                                        this.I$0 = i10;
                                        this.I$1 = 0;
                                        this.label = 5;
                                        partnerById = userDao3.getPartnerById(str4, this);
                                        if (partnerById != objG) {
                                            rosterManager2 = rosterManager;
                                            room2 = room;
                                            i11 = 0;
                                            User user10 = user5;
                                            User user11 = user2;
                                            t0 t0Var6 = t0Var2;
                                            t0 t0Var7 = t0Var;
                                            String str7 = str2;
                                            partner = (Partner) partnerById;
                                            if (partner != null) {
                                                alias = user4.getAlias();
                                            } else {
                                                alias = user4.getAlias();
                                            }
                                            String str8 = alias;
                                            roomDao = rosterManager2.roomDao;
                                            roomCopy$default = Room.copy$default(room2, null, str8, 0, null, null, null, 0L, 0, null, false, false, false, 4093, null);
                                            this.L$0 = cb.l.a(m0Var);
                                            this.L$1 = cb.l.a(str7);
                                            this.L$2 = cb.l.a(t0Var7);
                                            this.L$3 = cb.l.a(t0Var6);
                                            this.L$4 = cb.l.a(user11);
                                            this.L$5 = cb.l.a(user10);
                                            this.L$6 = user4;
                                            this.L$7 = userCopy$default;
                                            this.L$8 = cb.l.a(room2);
                                            this.L$9 = cb.l.a(str8);
                                            this.I$0 = i10;
                                            this.I$1 = i11;
                                            this.label = 6;
                                            if (roomDao.update(roomCopy$default, this) != objG) {
                                                user6 = userCopy$default;
                                                user7 = user4;
                                                userCopy$default = user6;
                                                user4 = user7;
                                            }
                                        }
                                    }
                                    Z17CoilDecoders.Companion companion2 = Z17CoilDecoders.INSTANCE;
                                    companion2.getInstance().clearCacheFor(user4.getPhotoUrl());
                                    companion2.getInstance().clearCacheFor(user4.getPhotoThumbnail());
                                    return userCopy$default;
                                }
                            }
                            break;
                        }
                        if (user3 == null) {
                            return user2;
                        }
                        return user3;
                    }
                    return objG;
                case 2:
                    User user12 = (User) this.L$4;
                    t0 t0Var8 = (t0) this.L$3;
                    t0 t0Var9 = (t0) this.L$2;
                    String str9 = (String) this.L$1;
                    ua.v.b(obj);
                    user2 = user12;
                    t0Var2 = t0Var8;
                    t0Var = t0Var9;
                    str2 = str9;
                    objL2 = obj;
                    user3 = (User) objL2;
                    if (user3 != null) {
                        rosterManager = this.this$0;
                        str3 = this.$uid;
                        if (user2 != null) {
                            break;
                        }
                        if (user2 != null) {
                            blocked = user2.getBlocked();
                        } else {
                            blocked = false;
                        }
                        userCopy$default = User.copy$default(user3, null, null, null, null, null, 0, null, 0, blocked, null, 767, null);
                        userDao = rosterManager.userDao;
                        this.L$0 = cb.l.a(m0Var);
                        this.L$1 = cb.l.a(str2);
                        this.L$2 = cb.l.a(t0Var);
                        this.L$3 = cb.l.a(t0Var2);
                        this.L$4 = cb.l.a(user2);
                        this.L$5 = cb.l.a(user3);
                        this.L$6 = rosterManager;
                        this.L$7 = str3;
                        this.L$8 = user3;
                        this.L$9 = userCopy$default;
                        this.I$0 = 0;
                        this.label = 3;
                        if (userDao.upsert(userCopy$default, this) != objG) {
                            str4 = str3;
                            i10 = 0;
                            user4 = user3;
                            user5 = user4;
                            RoomDao roomDao4 = rosterManager.roomDao;
                            this.L$0 = cb.l.a(m0Var);
                            this.L$1 = cb.l.a(str2);
                            this.L$2 = cb.l.a(t0Var);
                            this.L$3 = cb.l.a(t0Var2);
                            this.L$4 = cb.l.a(user2);
                            this.L$5 = cb.l.a(user5);
                            this.L$6 = rosterManager;
                            this.L$7 = str4;
                            this.L$8 = user4;
                            this.L$9 = userCopy$default;
                            this.I$0 = i10;
                            this.label = 4;
                            roomById = roomDao4.getRoomById(str4, this);
                            if (roomById != objG) {
                                room = (Room) roomById;
                                if (room != null) {
                                    UserDao userDao4 = rosterManager.userDao;
                                    this.L$0 = cb.l.a(m0Var);
                                    this.L$1 = cb.l.a(str2);
                                    this.L$2 = cb.l.a(t0Var);
                                    this.L$3 = cb.l.a(t0Var2);
                                    this.L$4 = cb.l.a(user2);
                                    this.L$5 = cb.l.a(user5);
                                    this.L$6 = rosterManager;
                                    this.L$7 = user4;
                                    this.L$8 = userCopy$default;
                                    this.L$9 = room;
                                    this.I$0 = i10;
                                    this.I$1 = 0;
                                    this.label = 5;
                                    partnerById = userDao4.getPartnerById(str4, this);
                                    if (partnerById != objG) {
                                        rosterManager2 = rosterManager;
                                        room2 = room;
                                        i11 = 0;
                                        User user13 = user5;
                                        User user14 = user2;
                                        t0 t0Var10 = t0Var2;
                                        t0 t0Var11 = t0Var;
                                        String str10 = str2;
                                        partner = (Partner) partnerById;
                                        if (partner != null) {
                                            alias = user4.getAlias();
                                        } else {
                                            alias = user4.getAlias();
                                        }
                                        String str11 = alias;
                                        roomDao = rosterManager2.roomDao;
                                        roomCopy$default = Room.copy$default(room2, null, str11, 0, null, null, null, 0L, 0, null, false, false, false, 4093, null);
                                        this.L$0 = cb.l.a(m0Var);
                                        this.L$1 = cb.l.a(str10);
                                        this.L$2 = cb.l.a(t0Var11);
                                        this.L$3 = cb.l.a(t0Var10);
                                        this.L$4 = cb.l.a(user14);
                                        this.L$5 = cb.l.a(user13);
                                        this.L$6 = user4;
                                        this.L$7 = userCopy$default;
                                        this.L$8 = cb.l.a(room2);
                                        this.L$9 = cb.l.a(str11);
                                        this.I$0 = i10;
                                        this.I$1 = i11;
                                        this.label = 6;
                                        if (roomDao.update(roomCopy$default, this) != objG) {
                                            user6 = userCopy$default;
                                            user7 = user4;
                                            userCopy$default = user6;
                                            user4 = user7;
                                        }
                                    }
                                }
                                Z17CoilDecoders.Companion companion3 = Z17CoilDecoders.INSTANCE;
                                companion3.getInstance().clearCacheFor(user4.getPhotoUrl());
                                companion3.getInstance().clearCacheFor(user4.getPhotoThumbnail());
                                return userCopy$default;
                            }
                        }
                        return objG;
                    }
                    if (user3 == null) {
                        return user2;
                    }
                    return user3;
                case 3:
                    i10 = this.I$0;
                    userCopy$default = (User) this.L$9;
                    user4 = (User) this.L$8;
                    str4 = (String) this.L$7;
                    rosterManager = (RosterManager) this.L$6;
                    user5 = (User) this.L$5;
                    user2 = (User) this.L$4;
                    t0Var2 = (t0) this.L$3;
                    t0Var = (t0) this.L$2;
                    str2 = (String) this.L$1;
                    ua.v.b(obj);
                    RoomDao roomDao5 = rosterManager.roomDao;
                    this.L$0 = cb.l.a(m0Var);
                    this.L$1 = cb.l.a(str2);
                    this.L$2 = cb.l.a(t0Var);
                    this.L$3 = cb.l.a(t0Var2);
                    this.L$4 = cb.l.a(user2);
                    this.L$5 = cb.l.a(user5);
                    this.L$6 = rosterManager;
                    this.L$7 = str4;
                    this.L$8 = user4;
                    this.L$9 = userCopy$default;
                    this.I$0 = i10;
                    this.label = 4;
                    roomById = roomDao5.getRoomById(str4, this);
                    if (roomById != objG) {
                        room = (Room) roomById;
                        if (room != null) {
                            UserDao userDao5 = rosterManager.userDao;
                            this.L$0 = cb.l.a(m0Var);
                            this.L$1 = cb.l.a(str2);
                            this.L$2 = cb.l.a(t0Var);
                            this.L$3 = cb.l.a(t0Var2);
                            this.L$4 = cb.l.a(user2);
                            this.L$5 = cb.l.a(user5);
                            this.L$6 = rosterManager;
                            this.L$7 = user4;
                            this.L$8 = userCopy$default;
                            this.L$9 = room;
                            this.I$0 = i10;
                            this.I$1 = 0;
                            this.label = 5;
                            partnerById = userDao5.getPartnerById(str4, this);
                            if (partnerById != objG) {
                                rosterManager2 = rosterManager;
                                room2 = room;
                                i11 = 0;
                                User user15 = user5;
                                User user16 = user2;
                                t0 t0Var12 = t0Var2;
                                t0 t0Var13 = t0Var;
                                String str12 = str2;
                                partner = (Partner) partnerById;
                                if (partner != null) {
                                    alias = user4.getAlias();
                                } else {
                                    alias = user4.getAlias();
                                }
                                String str13 = alias;
                                roomDao = rosterManager2.roomDao;
                                roomCopy$default = Room.copy$default(room2, null, str13, 0, null, null, null, 0L, 0, null, false, false, false, 4093, null);
                                this.L$0 = cb.l.a(m0Var);
                                this.L$1 = cb.l.a(str12);
                                this.L$2 = cb.l.a(t0Var13);
                                this.L$3 = cb.l.a(t0Var12);
                                this.L$4 = cb.l.a(user16);
                                this.L$5 = cb.l.a(user15);
                                this.L$6 = user4;
                                this.L$7 = userCopy$default;
                                this.L$8 = cb.l.a(room2);
                                this.L$9 = cb.l.a(str13);
                                this.I$0 = i10;
                                this.I$1 = i11;
                                this.label = 6;
                                if (roomDao.update(roomCopy$default, this) != objG) {
                                    user6 = userCopy$default;
                                    user7 = user4;
                                    userCopy$default = user6;
                                    user4 = user7;
                                }
                            }
                        }
                        Z17CoilDecoders.Companion companion4 = Z17CoilDecoders.INSTANCE;
                        companion4.getInstance().clearCacheFor(user4.getPhotoUrl());
                        companion4.getInstance().clearCacheFor(user4.getPhotoThumbnail());
                        return userCopy$default;
                    }
                    return objG;
                case 4:
                    i10 = this.I$0;
                    userCopy$default = (User) this.L$9;
                    user4 = (User) this.L$8;
                    str4 = (String) this.L$7;
                    rosterManager = (RosterManager) this.L$6;
                    user5 = (User) this.L$5;
                    user2 = (User) this.L$4;
                    t0Var2 = (t0) this.L$3;
                    t0Var = (t0) this.L$2;
                    str2 = (String) this.L$1;
                    ua.v.b(obj);
                    roomById = obj;
                    room = (Room) roomById;
                    if (room != null) {
                        UserDao userDao6 = rosterManager.userDao;
                        this.L$0 = cb.l.a(m0Var);
                        this.L$1 = cb.l.a(str2);
                        this.L$2 = cb.l.a(t0Var);
                        this.L$3 = cb.l.a(t0Var2);
                        this.L$4 = cb.l.a(user2);
                        this.L$5 = cb.l.a(user5);
                        this.L$6 = rosterManager;
                        this.L$7 = user4;
                        this.L$8 = userCopy$default;
                        this.L$9 = room;
                        this.I$0 = i10;
                        this.I$1 = 0;
                        this.label = 5;
                        partnerById = userDao6.getPartnerById(str4, this);
                        if (partnerById != objG) {
                            rosterManager2 = rosterManager;
                            room2 = room;
                            i11 = 0;
                            User user17 = user5;
                            User user18 = user2;
                            t0 t0Var14 = t0Var2;
                            t0 t0Var15 = t0Var;
                            String str14 = str2;
                            partner = (Partner) partnerById;
                            if (partner != null) {
                                alias = user4.getAlias();
                            } else {
                                alias = user4.getAlias();
                            }
                            String str15 = alias;
                            roomDao = rosterManager2.roomDao;
                            roomCopy$default = Room.copy$default(room2, null, str15, 0, null, null, null, 0L, 0, null, false, false, false, 4093, null);
                            this.L$0 = cb.l.a(m0Var);
                            this.L$1 = cb.l.a(str14);
                            this.L$2 = cb.l.a(t0Var15);
                            this.L$3 = cb.l.a(t0Var14);
                            this.L$4 = cb.l.a(user18);
                            this.L$5 = cb.l.a(user17);
                            this.L$6 = user4;
                            this.L$7 = userCopy$default;
                            this.L$8 = cb.l.a(room2);
                            this.L$9 = cb.l.a(str15);
                            this.I$0 = i10;
                            this.I$1 = i11;
                            this.label = 6;
                            if (roomDao.update(roomCopy$default, this) != objG) {
                                user6 = userCopy$default;
                                user7 = user4;
                                userCopy$default = user6;
                                user4 = user7;
                            }
                        }
                        return objG;
                    }
                    Z17CoilDecoders.Companion companion5 = Z17CoilDecoders.INSTANCE;
                    companion5.getInstance().clearCacheFor(user4.getPhotoUrl());
                    companion5.getInstance().clearCacheFor(user4.getPhotoThumbnail());
                    return userCopy$default;
                case 5:
                    int i12 = this.I$1;
                    i10 = this.I$0;
                    Room room3 = (Room) this.L$9;
                    User user19 = (User) this.L$8;
                    User user20 = (User) this.L$7;
                    RosterManager rosterManager3 = (RosterManager) this.L$6;
                    user5 = (User) this.L$5;
                    user2 = (User) this.L$4;
                    t0Var2 = (t0) this.L$3;
                    t0Var = (t0) this.L$2;
                    str2 = (String) this.L$1;
                    ua.v.b(obj);
                    i11 = i12;
                    rosterManager2 = rosterManager3;
                    room2 = room3;
                    userCopy$default = user19;
                    user4 = user20;
                    partnerById = obj;
                    User user110 = user5;
                    User user111 = user2;
                    t0 t0Var16 = t0Var2;
                    t0 t0Var17 = t0Var;
                    String str16 = str2;
                    partner = (Partner) partnerById;
                    if (partner != null) {
                        alias = user4.getAlias();
                    } else {
                        alias = user4.getAlias();
                    }
                    String str17 = alias;
                    roomDao = rosterManager2.roomDao;
                    roomCopy$default = Room.copy$default(room2, null, str17, 0, null, null, null, 0L, 0, null, false, false, false, 4093, null);
                    this.L$0 = cb.l.a(m0Var);
                    this.L$1 = cb.l.a(str16);
                    this.L$2 = cb.l.a(t0Var17);
                    this.L$3 = cb.l.a(t0Var16);
                    this.L$4 = cb.l.a(user111);
                    this.L$5 = cb.l.a(user110);
                    this.L$6 = user4;
                    this.L$7 = userCopy$default;
                    this.L$8 = cb.l.a(room2);
                    this.L$9 = cb.l.a(str17);
                    this.I$0 = i10;
                    this.I$1 = i11;
                    this.label = 6;
                    if (roomDao.update(roomCopy$default, this) != objG) {
                        user6 = userCopy$default;
                        user7 = user4;
                        userCopy$default = user6;
                        user4 = user7;
                        Z17CoilDecoders.Companion companion6 = Z17CoilDecoders.INSTANCE;
                        companion6.getInstance().clearCacheFor(user4.getPhotoUrl());
                        companion6.getInstance().clearCacheFor(user4.getPhotoThumbnail());
                        return userCopy$default;
                    }
                    return objG;
                case 6:
                    user6 = (User) this.L$7;
                    user7 = (User) this.L$6;
                    ua.v.b(obj);
                    userCopy$default = user6;
                    user4 = user7;
                    Z17CoilDecoders.Companion companion7 = Z17CoilDecoders.INSTANCE;
                    companion7.getInstance().clearCacheFor(user4.getPhotoUrl());
                    companion7.getInstance().clearCacheFor(user4.getPhotoThumbnail());
                    return userCopy$default;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super User> eVar) {
            return ((C15042) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$syncRosterWithVersioning$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$syncRosterWithVersioning$2", f = "RosterManager.kt", l = {RectListKt.BitOffsetForFocusable, RectListKt.BitOffsetForGesturable, 70, 627, 93, 97, LocationRequestCompat.QUALITY_LOW_POWER, 105, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 121, 124, ComposerImplKt.nodeKey, 132, 141, 150, WebmConstants.MkvEbmlElement.FLAG_LACING}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C15052 extends cb.m implements Function2 {
        final /* synthetic */ boolean $hasContactsPermission;
        final /* synthetic */ String $userId;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15052(boolean z10, String str, ab.e<? super C15052> eVar) {
            super(2, eVar);
            this.$hasContactsPermission = z10;
            this.$userId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return RosterManager.this.new C15052(this.$hasContactsPermission, this.$userId, eVar);
        }

        /* JADX WARN: Code duplicated, block: B:102:0x037e A[Catch: Exception -> 0x0047, all -> 0x0550, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:118:0x0405  */
        /* JADX WARN: Code duplicated, block: B:119:0x0407 A[Catch: all -> 0x0043, Exception -> 0x0047, PHI: r0 r1 r2 r3 r4 r9 r10 r11 r12
          0x0407: PHI (r0v85 int) = (r0v82 int), (r0v89 int) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE]
          0x0407: PHI (r1v44 int) = (r1v39 int), (r1v45 int) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE]
          0x0407: PHI (r2v31 java.lang.String) = (r2v26 java.lang.String), (r2v34 java.lang.String) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE]
          0x0407: PHI (r3v46 java.util.List) = (r3v42 java.util.List), (r3v49 java.util.List) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE]
          0x0407: PHI (r4v33 java.lang.String) = (r4v29 java.lang.String), (r4v36 java.lang.String) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE]
          0x0407: PHI (r9v38 cu.todus.android.xmpp.iq.roster.RosterGetHashIQ) = (r9v34 cu.todus.android.xmpp.iq.roster.RosterGetHashIQ), (r9v41 cu.todus.android.xmpp.iq.roster.RosterGetHashIQ) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE]
          0x0407: PHI (r10v29 java.lang.String) = (r10v25 java.lang.String), (r10v32 java.lang.String) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE]
          0x0407: PHI (r11v32 java.util.List) = (r11v28 java.util.List), (r11v35 java.util.List) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE]
          0x0407: PHI (r12v17 java.lang.Object) = (r12v16 java.lang.Object), (r12v21 java.lang.Object) binds: [B:117:0x0403, B:24:0x00d8] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x0464  */
        /* JADX WARN: Code duplicated, block: B:122:0x0466  */
        /* JADX WARN: Code duplicated, block: B:138:0x050d  */
        /* JADX WARN: Code duplicated, block: B:139:0x050f  */
        /* JADX WARN: Code duplicated, block: B:143:0x0531 A[Catch: Exception -> 0x0047, all -> 0x0550, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:145:0x0549 A[Catch: Exception -> 0x0047, all -> 0x0550, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:151:0x055b A[Catch: Exception -> 0x0047, all -> 0x0550, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:153:0x05a3  */
        /* JADX WARN: Code duplicated, block: B:154:0x05a5 A[Catch: Exception -> 0x0047, all -> 0x0550, TRY_LEAVE, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:158:0x05f9 A[Catch: Exception -> 0x0047, all -> 0x0550, TRY_ENTER, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:160:0x05fd A[Catch: Exception -> 0x0047, all -> 0x0550, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:162:0x062c  */
        /* JADX WARN: Code duplicated, block: B:163:0x062e  */
        /* JADX WARN: Code duplicated, block: B:166:0x0675  */
        /* JADX WARN: Code duplicated, block: B:167:0x0677 A[Catch: Exception -> 0x0047, all -> 0x0550, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:169:0x06ab  */
        /* JADX WARN: Code duplicated, block: B:170:0x06ac  */
        /* JADX WARN: Code duplicated, block: B:174:0x0714  */
        /* JADX WARN: Code duplicated, block: B:190:0x054c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:64:0x0224  */
        /* JADX WARN: Code duplicated, block: B:67:0x0237  */
        /* JADX WARN: Code duplicated, block: B:70:0x024d  */
        /* JADX WARN: Code duplicated, block: B:71:0x024f A[Catch: Exception -> 0x0047, all -> 0x0550, PHI: r0
          0x024f: PHI (r0v34 java.lang.Object) = (r0v31 java.lang.Object), (r0v40 java.lang.Object) binds: [B:69:0x024b, B:49:0x01d7] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:74:0x0264 A[Catch: all -> 0x0043, Exception -> 0x0047, LOOP:1: B:72:0x025e->B:74:0x0264, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:79:0x0299 A[Catch: all -> 0x0043, Exception -> 0x0047, LOOP:2: B:77:0x0293->B:79:0x0299, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:83:0x02cd A[Catch: all -> 0x0043, Exception -> 0x0047, TRY_ENTER, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:85:0x02f5  */
        /* JADX WARN: Code duplicated, block: B:86:0x02f7  */
        /* JADX WARN: Code duplicated, block: B:88:0x0303  */
        /* JADX WARN: Code duplicated, block: B:90:0x0306 A[Catch: all -> 0x0043, Exception -> 0x0047, TRY_LEAVE, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:93:0x0313 A[Catch: Exception -> 0x0047, all -> 0x0550, TRY_ENTER, TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:95:0x0332  */
        /* JADX WARN: Code duplicated, block: B:96:0x0334 A[Catch: Exception -> 0x0047, all -> 0x0550, PHI: r0 r2 r4 r9 r10
          0x0334: PHI (r0v51 java.lang.String) = (r0v41 java.lang.String), (r0v54 java.lang.String) binds: [B:94:0x0330, B:45:0x01b8] A[DONT_GENERATE, DONT_INLINE]
          0x0334: PHI (r2v11 cu.todus.android.xmpp.iq.roster.RosterGetHashIQ) = (r2v4 cu.todus.android.xmpp.iq.roster.RosterGetHashIQ), (r2v14 cu.todus.android.xmpp.iq.roster.RosterGetHashIQ) binds: [B:94:0x0330, B:45:0x01b8] A[DONT_GENERATE, DONT_INLINE]
          0x0334: PHI (r4v11 java.lang.String) = (r4v7 java.lang.String), (r4v14 java.lang.String) binds: [B:94:0x0330, B:45:0x01b8] A[DONT_GENERATE, DONT_INLINE]
          0x0334: PHI (r9v17 java.util.List) = (r9v15 java.util.List), (r9v20 java.util.List) binds: [B:94:0x0330, B:45:0x01b8] A[DONT_GENERATE, DONT_INLINE]
          0x0334: PHI (r10v7 java.lang.Object) = (r10v6 java.lang.Object), (r10v11 java.lang.Object) binds: [B:94:0x0330, B:45:0x01b8] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {Exception -> 0x0047, blocks: (B:7:0x003e, B:14:0x006a, B:140:0x0515, B:141:0x052b, B:143:0x0531, B:145:0x0549, B:149:0x0554, B:151:0x055b, B:154:0x05a5, B:17:0x0091, B:132:0x04b3, B:136:0x04d3, B:20:0x00b4, B:123:0x0467, B:23:0x00d5, B:119:0x0407, B:26:0x00f8, B:113:0x03c7, B:116:0x03d1, B:29:0x011b, B:175:0x0715, B:176:0x071e, B:32:0x013c, B:171:0x06b4, B:35:0x0160, B:38:0x0181, B:164:0x062f, B:41:0x019e, B:100:0x0372, B:102:0x037e, B:105:0x0386, B:107:0x038c, B:109:0x0390, B:126:0x0478, B:128:0x047c, B:135:0x04c5, B:158:0x05f9, B:160:0x05fd, B:167:0x0677, B:44:0x01b5, B:96:0x0334, B:47:0x01cc, B:87:0x02fc, B:90:0x0306, B:93:0x0313, B:48:0x01d4, B:71:0x024f, B:72:0x025e, B:74:0x0264, B:76:0x027b, B:77:0x0293, B:79:0x0299, B:81:0x02a9, B:83:0x02cd, B:68:0x023c), top: B:187:0x000f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:98:0x0367  */
        /* JADX WARN: Code duplicated, block: B:99:0x0369  */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x05ed, code lost:
        
            if (r0.handleVersionConflict(r1, r2, r3, r4, r32) == r6) goto L173;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r33) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1908
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.C15052.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C15052) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$uploadContactsBatch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {623, 434, 436}, m = "uploadContactsBatch", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15061 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public C15061(ab.e<? super C15061> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.uploadContactsBatch(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.RosterManager$uploadIncrementalChanges$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.RosterManager", f = "RosterManager.kt", l = {411, 415}, m = "uploadIncrementalChanges", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15071 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C15071(ab.e<? super C15071> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RosterManager.this.uploadIncrementalChanges(null, this);
        }
    }

    public RosterManager(lb.a canSend, lb.a mXMPPConnection, RosterVersionManager versionManager) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(versionManager, "versionManager");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.versionManager = versionManager;
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.contactDao = companion.getInstance().getContactDao();
        this.userDao = companion.getInstance().getUserDao();
        this.userRoomJoinDao = companion.getInstance().getUserRoomJoinDao();
        this.roomDao = companion.getInstance().getRoomDao();
        this.rosterChangeDao = companion.getInstance().getRosterChangeDao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d8, code lost:
    
        if (r2.deleteByPhones(r10, r0) == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteContactsFromRosterOnline(java.util.List<java.lang.String> r10, ab.e<? super java.lang.Boolean> r11) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.deleteContactsFromRosterOnline(java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:113:0x0348 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:? A[LOOP:1: B:39:0x021f->B:117:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0225  */
    /* JADX WARN: Code duplicated, block: B:52:0x033a  */
    /* JADX WARN: Code duplicated, block: B:57:0x039b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0426  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0426 -> B:62:0x042c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x045d -> B:15:0x0075). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0463 -> B:15:0x0075). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0477 -> B:15:0x0075). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0481 -> B:15:0x0075). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x04bf -> B:83:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x04d4 -> B:15:0x0075). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x05a9 -> B:15:0x0075). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x05b4 -> B:15:0x0075). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object detectLocalChangesFromPhone(ab.e<? super java.util.List<cu.todus.android.data.db.entity.toDus.RosterChange>> r33) {
        /*
            Method dump skipped, instruction units count: 1558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.detectLocalChangesFromPhone(ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0054 A[PHI: r1 r3 r4
      0x0054: PHI (r1v10 java.lang.Object) = (r1v9 java.lang.Object), (r1v1 java.lang.Object) binds: [B:30:0x00be, B:18:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r3v5 int) = (r3v4 int), (r3v11 int) binds: [B:30:0x00be, B:18:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r4v4 java.lang.String) = (r4v3 java.lang.String), (r4v8 java.lang.String) binds: [B:30:0x00be, B:18:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:43:0x0118  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object downloadFullRoster(String str, ab.e<? super k0> eVar) {
        C14921 c14921;
        String str2;
        int i10;
        String str3;
        int iIntValue;
        int i11;
        User user;
        String str4;
        User user2;
        UserDao userDao;
        int i12;
        if (eVar instanceof C14921) {
            c14921 = (C14921) eVar;
            int i13 = c14921.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                c14921.label = i13 - Integer.MIN_VALUE;
            } else {
                c14921 = new C14921(eVar);
            }
        } else {
            c14921 = new C14921(eVar);
        }
        C14921 c14922 = c14921;
        Object byId = c14922.result;
        Object objG = bb.b.g();
        int i14 = c14922.label;
        if (i14 == 0) {
            ua.v.b(byId);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
            lb.a aVar = new lb.a() { // from class: cu.todus.android.xmpp.managers.b0
                @Override // lb.a
                public final Object invoke() {
                    return k0.f43947a;
                }
            };
            str2 = str;
            c14922.L$0 = str2;
            c14922.label = 1;
            i10 = 2;
            if (XMPPInlinesKt.recursivePagingRequest$default(anonymousClass2, 0, 10, 0L, anonymousClass3, aVar, null, c14922, 72, null) != objG) {
            }
            return objG;
        }
        if (i14 == 1) {
            String str5 = (String) c14922.L$0;
            ua.v.b(byId);
            str2 = str5;
            i10 = 2;
        } else {
            if (i14 == 2) {
                String str6 = (String) c14922.L$0;
                ua.v.b(byId);
                str3 = str6;
                iIntValue = ((Number) byId).intValue();
                UserDao userDao2 = this.userDao;
                c14922.L$0 = str3;
                c14922.I$0 = iIntValue;
                c14922.label = 3;
                byId = userDao2.getById(str3, c14922);
                if (byId != objG) {
                    i11 = iIntValue;
                    user = (User) byId;
                    if (user != null) {
                        str4 = str3;
                        user2 = new User(str4, null, null, null, null, i11, null, 0, false, null, 990, null);
                    } else {
                        str4 = str3;
                        user2 = new User(str4, null, null, null, null, i11, null, 0, false, null, 990, null);
                    }
                    userDao = this.userDao;
                    c14922.L$0 = cb.l.a(str4);
                    c14922.L$1 = cb.l.a(user2);
                    c14922.I$0 = i11;
                    c14922.label = 4;
                    if (userDao.upsert(user2, c14922) != objG) {
                        i12 = i11;
                    }
                }
                return objG;
            }
            if (i14 == 3) {
                iIntValue = c14922.I$0;
                str3 = (String) c14922.L$0;
                ua.v.b(byId);
                i11 = iIntValue;
                user = (User) byId;
                if (user != null || (user2 = User.copy$default(user, null, null, null, null, null, i11, null, 0, false, null, 991, null)) == null) {
                    str4 = str3;
                    user2 = new User(str4, null, null, null, null, i11, null, 0, false, null, 990, null);
                } else {
                    str4 = str3;
                }
                userDao = this.userDao;
                c14922.L$0 = cb.l.a(str4);
                c14922.L$1 = cb.l.a(user2);
                c14922.I$0 = i11;
                c14922.label = 4;
                if (userDao.upsert(user2, c14922) != objG) {
                    i12 = i11;
                }
                return objG;
            }
            if (i14 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i12 = c14922.I$0;
            ua.v.b(byId);
        }
        this.versionManager.updateLastSyncedVersion(i12);
        return k0.f43947a;
        c14922.L$0 = str2;
        c14922.label = i10;
        Object objFetchCurrentServerVersion = fetchCurrentServerVersion(c14922);
        if (objFetchCurrentServerVersion != objG) {
            str3 = str2;
            byId = objFetchCurrentServerVersion;
            iIntValue = ((Number) byId).intValue();
            UserDao userDao3 = this.userDao;
            c14922.L$0 = str3;
            c14922.I$0 = iIntValue;
            c14922.label = 3;
            byId = userDao3.getById(str3, c14922);
            if (byId != objG) {
                i11 = iIntValue;
                user = (User) byId;
                if (user != null) {
                    str4 = str3;
                    user2 = new User(str4, null, null, null, null, i11, null, 0, false, null, 990, null);
                } else {
                    str4 = str3;
                    user2 = new User(str4, null, null, null, null, i11, null, 0, false, null, 990, null);
                }
                userDao = this.userDao;
                c14922.L$0 = cb.l.a(str4);
                c14922.L$1 = cb.l.a(user2);
                c14922.I$0 = i11;
                c14922.label = 4;
                if (userDao.upsert(user2, c14922) != objG) {
                    i12 = i11;
                    this.versionManager.updateLastSyncedVersion(i12);
                    return k0.f43947a;
                }
            }
        }
        return objG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fetchCurrentServerVersion(ab.e<? super Integer> eVar) {
        C14941 c14941;
        EntityFullJid user;
        String strAsEntityBareJidString;
        if (eVar instanceof C14941) {
            c14941 = (C14941) eVar;
            int i10 = c14941.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14941.label = i10 - Integer.MIN_VALUE;
            } else {
                c14941 = new C14941(eVar);
            }
        } else {
            c14941 = new C14941(eVar);
        }
        Object userInfo = c14941.result;
        Object objG = bb.b.g();
        int i11 = c14941.label;
        if (i11 == 0) {
            ua.v.b(userInfo);
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection == null || (user = xMPPTCPConnection.getUser()) == null || (strAsEntityBareJidString = user.asEntityBareJidString()) == null) {
                return cb.b.d(0);
            }
            String strO = le.a0.O(strAsEntityBareJidString, "@im.todus.cu", "", false, 4, null);
            c14941.L$0 = cb.l.a(strAsEntityBareJidString);
            c14941.L$1 = cb.l.a(strO);
            c14941.label = 1;
            userInfo = getUserInfo(strO, c14941);
            if (userInfo == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(userInfo);
        }
        User user2 = (User) userInfo;
        return cb.b.d(user2 != null ? user2.getVersion() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00d3 -> B:36:0x0131). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x012e -> B:37:0x0132). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fillDbFromPhone(ab.e<? super ua.k0> r23) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.fillDbFromPhone(ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x010e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0117  */
    /* JADX WARN: Code duplicated, block: B:48:0x0131  */
    /* JADX WARN: Code duplicated, block: B:52:0x0167  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x018e, code lost:
    
        if (r1.clearSynced(r2) == r3) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleEmptyRosterCase(java.util.List<cu.todus.android.data.db.entity.toDus.Contact> r24, java.lang.String r25, ab.e<? super ua.k0> r26) {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.handleEmptyRosterCase(java.util.List, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x010b  */
    /* JADX WARN: Code duplicated, block: B:37:0x011c  */
    /* JADX WARN: Code duplicated, block: B:41:0x013e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0147  */
    /* JADX WARN: Code duplicated, block: B:48:0x0161  */
    /* JADX WARN: Code duplicated, block: B:52:0x0195  */
    /* JADX WARN: Code duplicated, block: B:56:0x01b4 A[LOOP:0: B:54:0x01ae->B:56:0x01b4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ea, code lost:
    
        if (r3.clearSynced(r4) == r5) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01e3, code lost:
    
        if (r3.markAsSynced(r9, r1, r4) == r5) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleNoConflictSync(java.util.List<cu.todus.android.data.db.entity.toDus.RosterChange> r23, java.lang.String r24, ab.e<? super ua.k0> r25) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.handleNoConflictSync(java.util.List, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x007e A[PHI: r1 r2 r3 r4 r7 r8
      0x007e: PHI (r1v7 int) = (r1v5 int), (r1v11 int) binds: [B:32:0x0110, B:15:0x006b] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r2v7 int) = (r2v5 int), (r2v8 int) binds: [B:32:0x0110, B:15:0x006b] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r3v8 java.util.List<cu.todus.android.data.db.entity.toDus.Contact>) = 
      (r3v5 java.util.List<cu.todus.android.data.db.entity.toDus.Contact>)
      (r3v11 java.util.List<cu.todus.android.data.db.entity.toDus.Contact>)
     binds: [B:32:0x0110, B:15:0x006b] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r4v14 java.lang.Object) = (r4v13 java.lang.Object), (r4v1 java.lang.Object) binds: [B:32:0x0110, B:15:0x006b] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r7v12 java.lang.String) = (r7v9 java.lang.String), (r7v15 java.lang.String) binds: [B:32:0x0110, B:15:0x006b] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r8v10 java.util.List<cu.todus.android.data.db.entity.toDus.RosterChange>) = 
      (r8v7 java.util.List<cu.todus.android.data.db.entity.toDus.RosterChange>)
      (r8v14 java.util.List<cu.todus.android.data.db.entity.toDus.RosterChange>)
     binds: [B:32:0x0110, B:15:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:37:0x0151  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ed, code lost:
    
        if (uploadContactsBatch(r4, r5) == r6) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x018f, code lost:
    
        if (r4.clearSynced(r5) == r6) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleVersionConflict(int r23, int r24, java.util.List<cu.todus.android.data.db.entity.toDus.RosterChange> r25, java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.handleVersionConflict(int, int, java.util.List, java.lang.String, ab.e):java.lang.Object");
    }

    public static /* synthetic */ Object loadRosterAndUsersInfo$default(RosterManager rosterManager, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return rosterManager.loadRosterAndUsersInfo(z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadUsersInfoParallel(ab.e<? super k0> eVar) {
        Object objE = n0.e(new C15032(null), eVar);
        return objE == bb.b.g() ? objE : k0.f43947a;
    }

    public static /* synthetic */ Object syncRosterWithVersioning$default(RosterManager rosterManager, String str, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return rosterManager.syncRosterWithVersioning(str, z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Contact> toContacts(List<RosterChange> list) {
        ArrayList<RosterChange> arrayList = new ArrayList();
        for (Object obj : list) {
            if (!kotlin.jvm.internal.y.d(((RosterChange) obj).getChangeType(), RosterChange.TYPE_DELETE)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(va.x.y(arrayList, 10));
        for (RosterChange rosterChange : arrayList) {
            String phone = rosterChange.getPhone();
            String str = rosterChange.getPhone() + "@im.todus.cu";
            String currentName = rosterChange.getCurrentName();
            if (currentName == null) {
                currentName = "";
            }
            arrayList2.add(new Contact(phone, str, currentName, null, null, Contact.WAITING, 24, null));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00db A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:14:0x004a, B:33:0x00d5, B:35:0x00db, B:37:0x00f0, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0125, B:47:0x0175, B:49:0x017b, B:50:0x018c, B:52:0x0192, B:53:0x01a2, B:57:0x01db, B:62:0x0215, B:63:0x021a, B:64:0x021b, B:65:0x0220, B:22:0x007b, B:25:0x00ae, B:32:0x00ca), top: B:70:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f0 A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:14:0x004a, B:33:0x00d5, B:35:0x00db, B:37:0x00f0, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0125, B:47:0x0175, B:49:0x017b, B:50:0x018c, B:52:0x0192, B:53:0x01a2, B:57:0x01db, B:62:0x0215, B:63:0x021a, B:64:0x021b, B:65:0x0220, B:22:0x007b, B:25:0x00ae, B:32:0x00ca), top: B:70:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0103 A[Catch: Exception -> 0x0056, LOOP:0: B:38:0x00fd->B:40:0x0103, LOOP_END, TryCatch #0 {Exception -> 0x0056, blocks: (B:14:0x004a, B:33:0x00d5, B:35:0x00db, B:37:0x00f0, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0125, B:47:0x0175, B:49:0x017b, B:50:0x018c, B:52:0x0192, B:53:0x01a2, B:57:0x01db, B:62:0x0215, B:63:0x021a, B:64:0x021b, B:65:0x0220, B:22:0x007b, B:25:0x00ae, B:32:0x00ca), top: B:70:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0125 A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:14:0x004a, B:33:0x00d5, B:35:0x00db, B:37:0x00f0, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0125, B:47:0x0175, B:49:0x017b, B:50:0x018c, B:52:0x0192, B:53:0x01a2, B:57:0x01db, B:62:0x0215, B:63:0x021a, B:64:0x021b, B:65:0x0220, B:22:0x007b, B:25:0x00ae, B:32:0x00ca), top: B:70:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:45:0x016c  */
    /* JADX WARN: Code duplicated, block: B:46:0x016e  */
    /* JADX WARN: Code duplicated, block: B:49:0x017b A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:14:0x004a, B:33:0x00d5, B:35:0x00db, B:37:0x00f0, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0125, B:47:0x0175, B:49:0x017b, B:50:0x018c, B:52:0x0192, B:53:0x01a2, B:57:0x01db, B:62:0x0215, B:63:0x021a, B:64:0x021b, B:65:0x0220, B:22:0x007b, B:25:0x00ae, B:32:0x00ca), top: B:70:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0192 A[Catch: Exception -> 0x0056, LOOP:1: B:50:0x018c->B:52:0x0192, LOOP_END, TryCatch #0 {Exception -> 0x0056, blocks: (B:14:0x004a, B:33:0x00d5, B:35:0x00db, B:37:0x00f0, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0125, B:47:0x0175, B:49:0x017b, B:50:0x018c, B:52:0x0192, B:53:0x01a2, B:57:0x01db, B:62:0x0215, B:63:0x021a, B:64:0x021b, B:65:0x0220, B:22:0x007b, B:25:0x00ae, B:32:0x00ca), top: B:70:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:56:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:60:0x020b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x020b -> B:16:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object uploadContactsBatch(java.util.List<cu.todus.android.data.db.entity.toDus.Contact> r18, ab.e<? super java.lang.Boolean> r19) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager.uploadContactsBatch(java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:49:0x014f  */
    /* JADX WARN: Code duplicated, block: B:52:0x016e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0179 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:57:0x017c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [cu.todus.android.xmpp.managers.RosterManager] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public final Object uploadIncrementalChanges(List<RosterChange> list, ab.e<? super Boolean> eVar) {
        C15071 c15071;
        List<RosterChange> list2;
        boolean zBooleanValue;
        List list3;
        List list4;
        int i10;
        int i11;
        Object objDeleteContactsFromRosterOnline;
        int i12;
        ?? r10;
        ?? r11;
        if (eVar instanceof C15071) {
            c15071 = (C15071) eVar;
            int i13 = c15071.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                c15071.label = i13 - Integer.MIN_VALUE;
            } else {
                c15071 = new C15071(eVar);
            }
        } else {
            c15071 = new C15071(eVar);
        }
        Object objUploadContactsBatch = c15071.result;
        Object objG = bb.b.g();
        int i14 = c15071.label;
        if (i14 != 0) {
            if (i14 == 1) {
                int i15 = c15071.I$1;
                list3 = (List) c15071.L$2;
                list4 = (List) c15071.L$1;
                list2 = (List) c15071.L$0;
                ua.v.b(objUploadContactsBatch);
                i11 = i15;
            } else {
                if (i14 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i12 = c15071.I$0;
                ua.v.b(objUploadContactsBatch);
            }
            boolean zBooleanValue2 = ((Boolean) objUploadContactsBatch).booleanValue();
            r11 = i12;
            r10 = zBooleanValue2;
            return cb.b.a(r11 == 0 && r10 != 0);
        }
        ua.v.b(objUploadContactsBatch);
        ArrayList<RosterChange> arrayList = new ArrayList();
        for (Object obj : list) {
            if (!kotlin.jvm.internal.y.d(((RosterChange) obj).getChangeType(), RosterChange.TYPE_DELETE)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(va.x.y(arrayList, 10));
        for (RosterChange rosterChange : arrayList) {
            String phone = rosterChange.getPhone();
            String str = rosterChange.getPhone() + "@im.todus.cu";
            String currentName = rosterChange.getCurrentName();
            if (currentName == null) {
                currentName = "";
            }
            arrayList2.add(new Contact(phone, str, currentName, null, null, Contact.WAITING, 24, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (kotlin.jvm.internal.y.d(((RosterChange) obj2).getChangeType(), RosterChange.TYPE_DELETE)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(va.x.y(arrayList3, 10));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(((RosterChange) it.next()).getPhone());
        }
        if (arrayList2.isEmpty()) {
            list2 = list;
            zBooleanValue = true;
            list3 = arrayList4;
            list4 = arrayList2;
            i10 = 1;
            r11 = zBooleanValue;
            r10 = i10;
            if (!list3.isEmpty()) {
                c15071.L$0 = cb.l.a(list2);
                c15071.L$1 = cb.l.a(list4);
                c15071.L$2 = cb.l.a(list3);
                c15071.I$0 = zBooleanValue ? 1 : 0;
                c15071.I$1 = i10 == true ? 1 : 0;
                c15071.label = 2;
                objDeleteContactsFromRosterOnline = deleteContactsFromRosterOnline(list3, c15071);
                if (objDeleteContactsFromRosterOnline != objG) {
                    i12 = zBooleanValue ? 1 : 0;
                    objUploadContactsBatch = objDeleteContactsFromRosterOnline;
                    boolean zBooleanValue3 = ((Boolean) objUploadContactsBatch).booleanValue();
                    r11 = i12;
                    r10 = zBooleanValue3;
                }
            }
            return cb.b.a(r11 == 0 && r10 != 0);
        }
        c15071.L$0 = cb.l.a(list);
        c15071.L$1 = cb.l.a(arrayList2);
        c15071.L$2 = arrayList4;
        c15071.I$0 = 1;
        c15071.I$1 = 1;
        c15071.label = 1;
        objUploadContactsBatch = uploadContactsBatch(arrayList2, c15071);
        if (objUploadContactsBatch != objG) {
            list2 = list;
            list3 = arrayList4;
            list4 = arrayList2;
            i11 = 1;
        }
        return objG;
        zBooleanValue = ((Boolean) objUploadContactsBatch).booleanValue();
        i10 = i11;
        r11 = zBooleanValue;
        r10 = i10;
        if (!list3.isEmpty()) {
            c15071.L$0 = cb.l.a(list2);
            c15071.L$1 = cb.l.a(list4);
            c15071.L$2 = cb.l.a(list3);
            c15071.I$0 = zBooleanValue ? 1 : 0;
            c15071.I$1 = i10 == true ? 1 : 0;
            c15071.label = 2;
            objDeleteContactsFromRosterOnline = deleteContactsFromRosterOnline(list3, c15071);
            if (objDeleteContactsFromRosterOnline != objG) {
                i12 = zBooleanValue ? 1 : 0;
                objUploadContactsBatch = objDeleteContactsFromRosterOnline;
                boolean zBooleanValue4 = ((Boolean) objUploadContactsBatch).booleanValue();
                r11 = i12;
                r10 = zBooleanValue4;
            }
            return objG;
        }
        return cb.b.a(r11 == 0 && r10 != 0);
    }

    public final Object editToDusId(String str, ab.e<? super EditToDusIdResponse> eVar) {
        return pe.i.g(d1.b(), new C14932(str, null), eVar);
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final Object getToDusId(String str, ab.e<? super Pair<String, Integer>> eVar) {
        return pe.i.g(d1.b(), new C14962(str, null), eVar);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getUserInfo(String str, ab.e<? super User> eVar) {
        C14971 c14971;
        Object objB;
        RosterGetUsersInfoIQ rosterGetUsersInfoIQ;
        User user;
        List<User> users;
        if (eVar instanceof C14971) {
            c14971 = (C14971) eVar;
            int i10 = c14971.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14971.label = i10 - Integer.MIN_VALUE;
            } else {
                c14971 = new C14971(eVar);
            }
        } else {
            c14971 = new C14971(eVar);
        }
        Object objX = c14971.result;
        Object objG = bb.b.g();
        int i11 = c14971.label;
        try {
            if (i11 == 0) {
                ua.v.b(objX);
                if (!((Boolean) this.canSend.invoke()).booleanValue()) {
                    return null;
                }
                ua.u.a aVar = ua.u.f43963f;
                String strO = le.a0.O(str, "@im.todus.cu", "", false, 4, null);
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    RosterGetUsersInfoIQ rosterGetUsersInfoIQ2 = new RosterGetUsersInfoIQ(va.w.g(strO), null, 2, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, rosterGetUsersInfoIQ2);
                    c14971.L$0 = cb.l.a(str);
                    c14971.L$1 = cb.l.a(this);
                    c14971.L$2 = cb.l.a(strO);
                    c14971.L$3 = cb.l.a(xMPPTCPConnection);
                    c14971.L$4 = cb.l.a(rosterGetUsersInfoIQ2);
                    c14971.L$5 = cb.l.a(c14971);
                    c14971.I$0 = 0;
                    c14971.I$1 = 0;
                    c14971.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14971);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    rosterGetUsersInfoIQ = null;
                }
                if (rosterGetUsersInfoIQ != null || (users = rosterGetUsersInfoIQ.getUsers()) == null) {
                    user = null;
                } else {
                    user = (User) g0.y0(users);
                }
                objB = ua.u.b(user);
                if (ua.u.g(objB)) {
                    return null;
                }
                return objB;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
            rosterGetUsersInfoIQ = (RosterGetUsersInfoIQ) ((IQ) objX);
            if (rosterGetUsersInfoIQ != null) {
                user = null;
            } else {
                user = null;
            }
            objB = ua.u.b(user);
        } catch (Throwable th2) {
            ua.u.a aVar2 = ua.u.f43963f;
            objB = ua.u.b(ua.v.a(th2));
        }
        if (ua.u.g(objB)) {
            return null;
        }
        return objB;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getUsersInfo(List<String> list, ab.e<? super List<User>> eVar) {
        C14981 c14981;
        Object objB;
        RosterGetUsersInfoIQ rosterGetUsersInfoIQ;
        List<User> users;
        if (eVar instanceof C14981) {
            c14981 = (C14981) eVar;
            int i10 = c14981.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14981.label = i10 - Integer.MIN_VALUE;
            } else {
                c14981 = new C14981(eVar);
            }
        } else {
            c14981 = new C14981(eVar);
        }
        Object objX = c14981.result;
        Object objG = bb.b.g();
        int i11 = c14981.label;
        try {
            if (i11 == 0) {
                ua.v.b(objX);
                if (!((Boolean) this.canSend.invoke()).booleanValue() || list.isEmpty()) {
                    return null;
                }
                ua.u.a aVar = ua.u.f43963f;
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    RosterGetUsersInfoIQ rosterGetUsersInfoIQ2 = new RosterGetUsersInfoIQ(list, null, 2, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, rosterGetUsersInfoIQ2);
                    c14981.L$0 = cb.l.a(list);
                    c14981.L$1 = cb.l.a(this);
                    c14981.L$2 = cb.l.a(xMPPTCPConnection);
                    c14981.L$3 = cb.l.a(rosterGetUsersInfoIQ2);
                    c14981.L$4 = cb.l.a(c14981);
                    c14981.I$0 = 0;
                    c14981.I$1 = 0;
                    c14981.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14981);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    rosterGetUsersInfoIQ = null;
                }
                if (rosterGetUsersInfoIQ != null || (users = rosterGetUsersInfoIQ.getUsers()) == null || users.isEmpty()) {
                    users = null;
                }
                objB = ua.u.b(users);
                if (ua.u.g(objB)) {
                    return null;
                }
                return objB;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
            rosterGetUsersInfoIQ = (RosterGetUsersInfoIQ) ((IQ) objX);
            if (rosterGetUsersInfoIQ != null) {
                users = null;
            } else {
                users = null;
            }
            objB = ua.u.b(users);
        } catch (Throwable th2) {
            ua.u.a aVar2 = ua.u.f43963f;
            objB = ua.u.b(ua.v.a(th2));
        }
        if (ua.u.g(objB)) {
            return null;
        }
        return objB;
    }

    public final Object loadRosterAndUsersInfo(boolean z10, ab.e<? super k0> eVar) {
        Object objG = pe.i.g(d1.b(), new C15022(z10, null), eVar);
        return objG == bb.b.g() ? objG : k0.f43947a;
    }

    public final Object reloadUser(String str, ab.e<? super User> eVar) {
        return pe.i.g(d1.b(), new C15042(str, this, null), eVar);
    }

    public final Object syncRosterWithVersioning(String str, boolean z10, ab.e<? super k0> eVar) {
        Object objG = pe.i.g(d1.b(), new C15052(z10, str, null), eVar);
        return objG == bb.b.g() ? objG : k0.f43947a;
    }
}
