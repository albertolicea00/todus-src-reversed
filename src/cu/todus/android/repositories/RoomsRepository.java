package cu.todus.android.repositories;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.MessageWithAttachments;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.data.db.pojo.RoomMember;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.db.dao.toDus.UserDao;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.rest.certified.CertifiedInfoDataSource;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatScreenState;
import cu.todus.android.xmpp.XMPPUtils;
import cu.z17.singledi.SingletonInitializer;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J)\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0015\u0010\u000bJ=\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010!J#\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b#\u0010!J#\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b$\u0010!J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b%\u0010\u000bJ\u0018\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b'\u0010\u000bJ \u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b+\u0010\u000bJ\u001e\u0010-\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0086@¢\u0006\u0004\b-\u0010.J\u0018\u0010/\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b/\u0010\u000bJ\u0010\u00100\u001a\u00020\tH\u0086@¢\u0006\u0004\b0\u00101J!\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002020\u001c2\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b3\u0010!J \u00105\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b5\u0010*J#\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b6\u0010!J\"\u00108\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b8\u0010*J\u0013\u00109\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f¢\u0006\u0004\b9\u0010:J'\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\u0006\u0010;\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b<\u0010\u0011J \u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b>\u0010*J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017H\u0086@¢\u0006\u0004\b?\u00101J\u001e\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\bA\u0010\u000bJ\u001a\u0010B\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\bB\u0010\u000bJ!\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020C0\u001c2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bD\u0010!J!\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bE\u0010FR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010G\u001a\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006Z"}, d2 = {"Lcu/todus/android/repositories/RoomsRepository;", "", "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Llb/a;)V", "", "roomId", "Lua/k0;", "createRoomIfNeed", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "userId", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "previewsChatState", "Lte/h;", "userChatState", "(Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;)Lte/h;", "cardId", "cardChatState", "groupChannelChatState", "togglePin", "filter", "", "", "types", "", "requestedOn", "Landroidx/paging/PagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "getRooms", "(Ljava/lang/String;Ljava/util/List;Z)Landroidx/paging/PagingSource;", "getSecretRooms", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "getMutedRooms", "getRequestRooms", "getGroupsAndChannels", "clearAndDeleteRoom", "uid", "changeMuteValue", "path", "setRoomBackground", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getUnreadCount", "arr", "clearHistoryFromRooms", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "changeSecretState", "cleanSecretRooms", "(Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "getMsgsByFilterForPaging", Room.COLUMN_LAST_MSG, "getMsgPosition", "getOPenRooms", "newState", "setUnknownState", "requestRoomCount", "()Lte/h;", "id", "chatState", "input", "updateDraftState", "getAllForSaves", "Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "getAllByRoomForSave", "getAffiliationOnRoom", "Lcu/todus/android/data/db/pojo/RoomMember;", "getMembers", "groupMemberIds", "(Ljava/lang/String;)Lte/h;", "Llb/a;", "getOwner", "()Llb/a;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "userRoomJoinDao", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Lcu/todus/android/db/dao/toDus/UserDao;", "userDao", "Lcu/todus/android/db/dao/toDus/UserDao;", "Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "certifiedInfoDataSource", "Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RoomsRepository {
    private final CertifiedInfoDataSource certifiedInfoDataSource;
    private final MessageDao messageDao;
    private final lb.a owner;
    private final RoomDao roomDao;
    private final UserDao userDao;
    private final UserRoomJoinDao userRoomJoinDao;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/RoomsRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/RoomsRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<RoomsRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$changeMuteValue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {74, 76, 79}, m = "changeMuteValue", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.changeMuteValue(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$changeSecretState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {147, 149, 152}, m = "changeSecretState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11301 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11301(ab.e<? super C11301> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.changeSecretState(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$cleanSecretRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {157, WebmConstants.MkvEbmlElement.BLOCK_GROUP}, m = "cleanSecretRooms", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11311 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C11311(ab.e<? super C11311> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.cleanSecretRooms(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$clearAndDeleteRoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {68, 70}, m = "clearAndDeleteRoom", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11321 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11321(ab.e<? super C11321> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.clearAndDeleteRoom(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$clearHistoryFromRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {137, TsExtractor.TS_STREAM_TYPE_DTS_UHD}, m = "clearHistoryFromRooms", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11331 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C11331(ab.e<? super C11331> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.clearHistoryFromRooms(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$createRoomIfNeed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 107, 123}, m = "createRoomIfNeed", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11341 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11341(ab.e<? super C11341> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.createRoomIfNeed(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$getUnreadCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {98}, m = "getUnreadCount", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11351 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11351(ab.e<? super C11351> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.getUnreadCount(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$setRoomBackground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {84, 86, TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m = "setRoomBackground", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11361 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11361(ab.e<? super C11361> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.setRoomBackground(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$setUnknownState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {182, 184, WebmConstants.MkvEbmlElement.CUE_POINT}, m = "setUnknownState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11371 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11371(ab.e<? super C11371> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.setUnknownState(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$updateDraftState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.RoomsRepository", f = "RoomsRepository.kt", l = {356, 358}, m = "updateDraftState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11381 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11381(ab.e<? super C11381> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomsRepository.this.updateDraftState(null, null, this);
        }
    }

    public RoomsRepository(lb.a owner) {
        kotlin.jvm.internal.y.i(owner, "owner");
        this.owner = owner;
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.roomDao = companion.getInstance().getRoomDao();
        this.userRoomJoinDao = companion.getInstance().getUserRoomJoinDao();
        this.messageDao = companion.getInstance().getMessageDao();
        this.userDao = companion.getInstance().getUserDao();
        this.certifiedInfoDataSource = RetrofitModule.INSTANCE.getInstance().getCertifiedInfoDataSource();
    }

    private final te.h cardChatState(final String cardId, final ChatScreenState previewsChatState) {
        final te.h roomByIdFlow = this.roomDao.getRoomByIdFlow(cardId);
        return new te.h() { // from class: cu.todus.android.repositories.RoomsRepository$cardChatState$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$cardChatState$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ String $cardId$inlined;
                final /* synthetic */ ChatScreenState $previewsChatState$inlined;
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ RoomsRepository this$0;

                /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$cardChatState$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.repositories.RoomsRepository$cardChatState$$inlined$map$1$2", f = "RoomsRepository.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, 50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar, RoomsRepository roomsRepository, String str, ChatScreenState chatScreenState) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = roomsRepository;
                    this.$cardId$inlined = str;
                    this.$previewsChatState$inlined = chatScreenState;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0017  */
                /* JADX WARN: Code restructure failed: missing block: B:58:0x02d3, code lost:
                
                    if (r1.emit(r13, r2) == r3) goto L59;
                 */
                @Override // te.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r34, ab.e r35) {
                    /*
                        Method dump skipped, instruction units count: 729
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository$cardChatState$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, ab.e):java.lang.Object");
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = roomByIdFlow.collect(new AnonymousClass2(iVar, this, cardId, previewsChatState), eVar);
                return objCollect == bb.b.g() ? objCollect : ua.k0.f43947a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x0095  */
    /* JADX WARN: Code duplicated, block: B:33:0x0097  */
    /* JADX WARN: Code duplicated, block: B:35:0x009d  */
    /* JADX WARN: Code duplicated, block: B:36:0x009f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
    
        if (r2 == r4) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0123, code lost:
    
        if (r2.insertIfNeedIgnore(r7, r3) == r4) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createRoomIfNeed(java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.createRoomIfNeed(java.lang.String, ab.e):java.lang.Object");
    }

    public static /* synthetic */ PagingSource getGroupsAndChannels$default(RoomsRepository roomsRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return roomsRepository.getGroupsAndChannels(str);
    }

    public static /* synthetic */ PagingSource getMutedRooms$default(RoomsRepository roomsRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return roomsRepository.getMutedRooms(str);
    }

    public static /* synthetic */ PagingSource getOPenRooms$default(RoomsRepository roomsRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return roomsRepository.getOPenRooms(str);
    }

    public static /* synthetic */ PagingSource getRequestRooms$default(RoomsRepository roomsRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return roomsRepository.getRequestRooms(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagingSource getRooms$default(RoomsRepository roomsRepository, String str, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            list = va.w.q(0, 1, 2, 3);
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return roomsRepository.getRooms(str, list, z10);
    }

    public static /* synthetic */ PagingSource getSecretRooms$default(RoomsRepository roomsRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return roomsRepository.getSecretRooms(str);
    }

    private final te.h groupChannelChatState(final String roomId, final ChatScreenState previewsChatState) {
        final te.h roomByIdFlow = this.roomDao.getRoomByIdFlow(roomId);
        return new te.h() { // from class: cu.todus.android.repositories.RoomsRepository$groupChannelChatState$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$groupChannelChatState$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ ChatScreenState $previewsChatState$inlined;
                final /* synthetic */ String $roomId$inlined;
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ RoomsRepository this$0;

                /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$groupChannelChatState$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.repositories.RoomsRepository$groupChannelChatState$$inlined$map$1$2", f = "RoomsRepository.kt", l = {RectListKt.BitOffsetForGesturable, 69, TsExtractor.TS_SYNC_BYTE, 50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
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
                    Object L$8;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar, ChatScreenState chatScreenState, RoomsRepository roomsRepository, String str) {
                    this.$this_unsafeFlow = iVar;
                    this.$previewsChatState$inlined = chatScreenState;
                    this.this$0 = roomsRepository;
                    this.$roomId$inlined = str;
                }

                /* JADX WARN: Code duplicated, block: B:74:0x0284  */
                /* JADX WARN: Code duplicated, block: B:77:0x029a  */
                /* JADX WARN: Code duplicated, block: B:79:0x02a1  */
                /* JADX WARN: Code duplicated, block: B:7:0x0017  */
                /* JADX WARN: Code duplicated, block: B:87:0x02f3  */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x033c, code lost:
                
                    if (r11.emit(r9, r2) == r3) goto L91;
                 */
                @Override // te.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r38, ab.e r39) {
                    /*
                        Method dump skipped, instruction units count: 834
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository$groupChannelChatState$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, ab.e):java.lang.Object");
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = roomByIdFlow.collect(new AnonymousClass2(iVar, previewsChatState, this, roomId), eVar);
                return objCollect == bb.b.g() ? objCollect : ua.k0.f43947a;
            }
        };
    }

    public static /* synthetic */ Object setUnknownState$default(RoomsRepository roomsRepository, String str, String str2, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "new";
        }
        return roomsRepository.setUnknownState(str, str2, eVar);
    }

    private final te.h userChatState(String userId, final ChatScreenState previewsChatState) {
        final te.h partnerByIdFlow = this.userDao.getPartnerByIdFlow(userId);
        return new te.h() { // from class: cu.todus.android.repositories.RoomsRepository$userChatState$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$userChatState$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ ChatScreenState $previewsChatState$inlined;
                final /* synthetic */ te.i $this_unsafeFlow;

                /* JADX INFO: renamed from: cu.todus.android.repositories.RoomsRepository$userChatState$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.repositories.RoomsRepository$userChatState$$inlined$map$1$2", f = "RoomsRepository.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar, ChatScreenState chatScreenState) {
                    this.$this_unsafeFlow = iVar;
                    this.$previewsChatState$inlined = chatScreenState;
                }

                /* JADX WARN: Code duplicated, block: B:40:0x00b3  */
                /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
                /* JADX WARN: Code duplicated, block: B:46:0x00ce  */
                /* JADX WARN: Code duplicated, block: B:49:0x00d9  */
                /* JADX WARN: Code duplicated, block: B:52:0x00e2  */
                /* JADX WARN: Code duplicated, block: B:55:0x00f2  */
                /* JADX WARN: Code duplicated, block: B:59:0x00fc  */
                /* JADX WARN: Code duplicated, block: B:62:0x0106  */
                /* JADX WARN: Code duplicated, block: B:70:0x011c  */
                /* JADX WARN: Code duplicated, block: B:74:0x0126  */
                /* JADX WARN: Code duplicated, block: B:7:0x0017  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
                    Contact contact;
                    String str;
                    Room room;
                    boolean z10;
                    Room room2;
                    String str2;
                    Room room3;
                    String str3;
                    Room room4;
                    String str4;
                    String draft;
                    String unknownState;
                    String background;
                    String phone;
                    String background2;
                    String unknownState2;
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
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        ua.v.b(obj2);
                        te.i iVar = this.$this_unsafeFlow;
                        Partner partner = (Partner) obj;
                        ChatScreenState chatScreenState = null;
                        if (partner != null) {
                            ChatScreenState chatScreenState2 = this.$previewsChatState$inlined;
                            if (kotlin.jvm.internal.y.d(chatScreenState2 != null ? chatScreenState2.getName() : null, partner.getName()) && kotlin.jvm.internal.y.d(this.$previewsChatState$inlined.getImage(), partner.getThumbnailPicture()) && kotlin.jvm.internal.y.d(this.$previewsChatState$inlined.getDescription(), partner.getBio())) {
                                String backgroundPath = this.$previewsChatState$inlined.getBackgroundPath();
                                Room room5 = partner.getRoom();
                                if (room5 == null || (background2 = room5.getBackground()) == null) {
                                    background2 = "";
                                }
                                if (kotlin.jvm.internal.y.d(backgroundPath, background2)) {
                                    String unknownUserState = this.$previewsChatState$inlined.getUnknownUserState();
                                    Room room6 = partner.getRoom();
                                    if (room6 == null || (unknownState2 = room6.getUnknownState()) == null) {
                                        unknownState2 = "";
                                    }
                                    if (!kotlin.jvm.internal.y.d(unknownUserState, unknownState2)) {
                                        String id2 = partner.getId();
                                        String name = partner.getName();
                                        String thumbnailPicture = partner.getThumbnailPicture();
                                        contact = partner.getContact();
                                        if (contact != null) {
                                            str = "";
                                        } else {
                                            str = "";
                                        }
                                        String bio = partner.getBio();
                                        room = partner.getRoom();
                                        if (room == null) {
                                            z10 = false;
                                        } else {
                                            z10 = false;
                                        }
                                        String toDusId = partner.getUser().getToDusId();
                                        room2 = partner.getRoom();
                                        if (room2 != null) {
                                            str2 = "";
                                        } else {
                                            str2 = "";
                                        }
                                        room3 = partner.getRoom();
                                        str3 = "new";
                                        if (room3 != null) {
                                            str3 = unknownState;
                                        }
                                        String str5 = str3;
                                        room4 = partner.getRoom();
                                        if (room4 != null) {
                                            str4 = "";
                                        } else {
                                            str4 = "";
                                        }
                                        chatScreenState = new ChatScreenState(id2, name, thumbnailPicture, 0, str, bio, null, false, false, null, z10, toDusId, str2, str5, null, null, str4, 50112, null);
                                    }
                                } else {
                                    String id3 = partner.getId();
                                    String name2 = partner.getName();
                                    String thumbnailPicture2 = partner.getThumbnailPicture();
                                    contact = partner.getContact();
                                    if (contact != null) {
                                        str = "";
                                    } else {
                                        str = "";
                                    }
                                    String bio2 = partner.getBio();
                                    room = partner.getRoom();
                                    if (room == null) {
                                        z10 = false;
                                    } else {
                                        z10 = false;
                                    }
                                    String toDusId2 = partner.getUser().getToDusId();
                                    room2 = partner.getRoom();
                                    if (room2 != null) {
                                        str2 = "";
                                    } else {
                                        str2 = "";
                                    }
                                    room3 = partner.getRoom();
                                    str3 = "new";
                                    if (room3 != null) {
                                        str3 = unknownState;
                                    }
                                    String str6 = str3;
                                    room4 = partner.getRoom();
                                    if (room4 != null) {
                                        str4 = "";
                                    } else {
                                        str4 = "";
                                    }
                                    chatScreenState = new ChatScreenState(id3, name2, thumbnailPicture2, 0, str, bio2, null, false, false, null, z10, toDusId2, str2, str6, null, null, str4, 50112, null);
                                }
                            } else {
                                String id4 = partner.getId();
                                String name3 = partner.getName();
                                String thumbnailPicture3 = partner.getThumbnailPicture();
                                contact = partner.getContact();
                                if (contact != null || (phone = contact.getPhone()) == null) {
                                    str = "";
                                } else {
                                    str = phone;
                                }
                                String bio3 = partner.getBio();
                                room = partner.getRoom();
                                if (room == null && room.getSecret()) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                String toDusId3 = partner.getUser().getToDusId();
                                room2 = partner.getRoom();
                                if (room2 != null || (background = room2.getBackground()) == null) {
                                    str2 = "";
                                } else {
                                    str2 = background;
                                }
                                room3 = partner.getRoom();
                                str3 = "new";
                                if (room3 != null && (unknownState = room3.getUnknownState()) != null && !le.d0.q0(unknownState)) {
                                    str3 = unknownState;
                                }
                                String str7 = str3;
                                room4 = partner.getRoom();
                                if (room4 != null || (draft = room4.getDraft()) == null) {
                                    str4 = "";
                                } else {
                                    str4 = draft;
                                }
                                chatScreenState = new ChatScreenState(id4, name3, thumbnailPicture3, 0, str, bio3, null, false, false, null, z10, toDusId3, str2, str7, null, null, str4, 50112, null);
                            }
                        }
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(chatScreenState, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ua.v.b(obj2);
                    }
                    return ua.k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = partnerByIdFlow.collect(new AnonymousClass2(iVar, previewsChatState), eVar);
                return objCollect == bb.b.g() ? objCollect : ua.k0.f43947a;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b9, code lost:
    
        if (r2.update(r5, r3) == r4) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object changeMuteValue(java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            boolean r3 = r2 instanceof cu.todus.android.repositories.RoomsRepository.AnonymousClass1
            if (r3 == 0) goto L19
            r3 = r2
            cu.todus.android.repositories.RoomsRepository$changeMuteValue$1 r3 = (cu.todus.android.repositories.RoomsRepository.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            cu.todus.android.repositories.RoomsRepository$changeMuteValue$1 r3 = new cu.todus.android.repositories.RoomsRepository$changeMuteValue$1
            r3.<init>(r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = bb.b.g()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L5a
            if (r5 == r8) goto L52
            if (r5 == r7) goto L4a
            if (r5 != r6) goto L42
            java.lang.Object r1 = r3.L$2
            cu.todus.android.data.db.entity.toDus.Room r1 = (cu.todus.android.data.db.entity.toDus.Room) r1
            java.lang.Object r1 = r3.L$1
            cu.todus.android.data.db.entity.toDus.Room r1 = (cu.todus.android.data.db.entity.toDus.Room) r1
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            ua.v.b(r2)
            goto Lbc
        L42:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L4a:
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            ua.v.b(r2)
            goto L79
        L52:
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            ua.v.b(r2)
            goto L68
        L5a:
            ua.v.b(r2)
            r3.L$0 = r1
            r3.label = r8
            java.lang.Object r2 = r0.createRoomIfNeed(r1, r3)
            if (r2 != r4) goto L68
            goto Lbb
        L68:
            cu.todus.android.db.dao.toDus.RoomDao r2 = r0.roomDao
            java.lang.Object r5 = cb.l.a(r1)
            r3.L$0 = r5
            r3.label = r7
            java.lang.Object r2 = r2.getRoomById(r1, r3)
            if (r2 != r4) goto L79
            goto Lbb
        L79:
            r9 = r2
            cu.todus.android.data.db.entity.toDus.Room r9 = (cu.todus.android.data.db.entity.toDus.Room) r9
            if (r9 == 0) goto Lbc
            cu.todus.android.db.dao.toDus.RoomDao r2 = r0.roomDao
            boolean r5 = r9.isMuted()
            r22 = r5 ^ 1
            r23 = 2047(0x7ff, float:2.868E-42)
            r24 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            cu.todus.android.data.db.entity.toDus.Room r5 = cu.todus.android.data.db.entity.toDus.Room.copy$default(r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24)
            java.lang.Object r1 = cb.l.a(r1)
            r3.L$0 = r1
            java.lang.Object r1 = cb.l.a(r9)
            r3.L$1 = r1
            java.lang.Object r1 = cb.l.a(r9)
            r3.L$2 = r1
            r1 = 0
            r3.I$0 = r1
            r3.label = r6
            java.lang.Object r1 = r2.update(r5, r3)
            if (r1 != r4) goto Lbc
        Lbb:
            return r4
        Lbc:
            ua.k0 r1 = ua.k0.f43947a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.changeMuteValue(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b9, code lost:
    
        if (r2.update(r5, r3) == r4) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object changeSecretState(java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            boolean r3 = r2 instanceof cu.todus.android.repositories.RoomsRepository.C11301
            if (r3 == 0) goto L19
            r3 = r2
            cu.todus.android.repositories.RoomsRepository$changeSecretState$1 r3 = (cu.todus.android.repositories.RoomsRepository.C11301) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            cu.todus.android.repositories.RoomsRepository$changeSecretState$1 r3 = new cu.todus.android.repositories.RoomsRepository$changeSecretState$1
            r3.<init>(r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = bb.b.g()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L5a
            if (r5 == r8) goto L52
            if (r5 == r7) goto L4a
            if (r5 != r6) goto L42
            java.lang.Object r1 = r3.L$2
            cu.todus.android.data.db.entity.toDus.Room r1 = (cu.todus.android.data.db.entity.toDus.Room) r1
            java.lang.Object r1 = r3.L$1
            cu.todus.android.data.db.entity.toDus.Room r1 = (cu.todus.android.data.db.entity.toDus.Room) r1
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            ua.v.b(r2)
            goto Lbc
        L42:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L4a:
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            ua.v.b(r2)
            goto L79
        L52:
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            ua.v.b(r2)
            goto L68
        L5a:
            ua.v.b(r2)
            r3.L$0 = r1
            r3.label = r8
            java.lang.Object r2 = r0.createRoomIfNeed(r1, r3)
            if (r2 != r4) goto L68
            goto Lbb
        L68:
            cu.todus.android.db.dao.toDus.RoomDao r2 = r0.roomDao
            java.lang.Object r5 = cb.l.a(r1)
            r3.L$0 = r5
            r3.label = r7
            java.lang.Object r2 = r2.getRoomById(r1, r3)
            if (r2 != r4) goto L79
            goto Lbb
        L79:
            r9 = r2
            cu.todus.android.data.db.entity.toDus.Room r9 = (cu.todus.android.data.db.entity.toDus.Room) r9
            if (r9 == 0) goto Lbc
            cu.todus.android.db.dao.toDus.RoomDao r2 = r0.roomDao
            boolean r5 = r9.getSecret()
            r21 = r5 ^ 1
            r23 = 3071(0xbff, float:4.303E-42)
            r24 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            cu.todus.android.data.db.entity.toDus.Room r5 = cu.todus.android.data.db.entity.toDus.Room.copy$default(r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24)
            java.lang.Object r1 = cb.l.a(r1)
            r3.L$0 = r1
            java.lang.Object r1 = cb.l.a(r9)
            r3.L$1 = r1
            java.lang.Object r1 = cb.l.a(r9)
            r3.L$2 = r1
            r1 = 0
            r3.I$0 = r1
            r3.label = r6
            java.lang.Object r1 = r2.update(r5, r3)
            if (r1 != r4) goto Lbc
        Lbb:
            return r4
        Lbc:
            ua.k0 r1 = ua.k0.f43947a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.changeSecretState(java.lang.String, ab.e):java.lang.Object");
    }

    public final te.h chatState(String id2, ChatScreenState previewsChatState) throws Exception {
        kotlin.jvm.internal.y.i(id2, "id");
        XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
        if (xMPPUtils.isUser(id2)) {
            return userChatState(id2, previewsChatState);
        }
        if (xMPPUtils.isCard(id2)) {
            return cardChatState(id2, previewsChatState);
        }
        if (xMPPUtils.isMUC(id2)) {
            return groupChannelChatState(id2, previewsChatState);
        }
        if (xMPPUtils.isChannel(id2)) {
            return groupChannelChatState(id2, previewsChatState);
        }
        throw new Exception("INVALID CHAT TYPE");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    /* JADX WARN: Code duplicated, block: B:28:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:? A[LOOP:0: B:20:0x0063->B:30:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if (r12 == r1) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cleanSecretRooms(ab.e<? super ua.k0> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof cu.todus.android.repositories.RoomsRepository.C11311
            if (r0 == 0) goto L13
            r0 = r12
            cu.todus.android.repositories.RoomsRepository$cleanSecretRooms$1 r0 = (cu.todus.android.repositories.RoomsRepository.C11311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.RoomsRepository$cleanSecretRooms$1 r0 = new cu.todus.android.repositories.RoomsRepository$cleanSecretRooms$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L47
            if (r2 != r4) goto L3f
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$4
            cu.todus.android.data.db.entity.toDus.Room r5 = (cu.todus.android.data.db.entity.toDus.Room) r5
            java.lang.Object r5 = r0.L$2
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.L$1
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.lang.Object r7 = r0.L$0
            java.util.List r7 = (java.util.List) r7
            ua.v.b(r12)
            goto L63
        L3f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L47:
            ua.v.b(r12)
            goto L59
        L4b:
            ua.v.b(r12)
            cu.todus.android.db.dao.toDus.RoomDao r12 = r11.roomDao
            r0.label = r5
            java.lang.Object r12 = r12.getSecretRooms(r0)
            if (r12 != r1) goto L59
            goto L9a
        L59:
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r2 = r12.iterator()
            r6 = r12
            r7 = r6
            r5 = r2
            r2 = r3
        L63:
            boolean r12 = r5.hasNext()
            if (r12 == 0) goto L9b
            java.lang.Object r12 = r5.next()
            r8 = r12
            cu.todus.android.data.db.entity.toDus.Room r8 = (cu.todus.android.data.db.entity.toDus.Room) r8
            java.lang.String r9 = r8.getId()
            java.lang.Object r10 = cb.l.a(r7)
            r0.L$0 = r10
            java.lang.Object r10 = cb.l.a(r6)
            r0.L$1 = r10
            r0.L$2 = r5
            java.lang.Object r12 = cb.l.a(r12)
            r0.L$3 = r12
            java.lang.Object r12 = cb.l.a(r8)
            r0.L$4 = r12
            r0.I$0 = r2
            r0.I$1 = r3
            r0.label = r4
            java.lang.Object r12 = r11.clearAndDeleteRoom(r9, r0)
            if (r12 != r1) goto L63
        L9a:
            return r1
        L9b:
            ua.k0 r12 = ua.k0.f43947a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.cleanSecretRooms(ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
    
        if (r2.delete(r6, r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearAndDeleteRoom(java.lang.String r6, ab.e<? super ua.k0> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cu.todus.android.repositories.RoomsRepository.C11321
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.repositories.RoomsRepository$clearAndDeleteRoom$1 r0 = (cu.todus.android.repositories.RoomsRepository.C11321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.RoomsRepository$clearAndDeleteRoom$1 r0 = new cu.todus.android.repositories.RoomsRepository$clearAndDeleteRoom$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            ua.v.b(r7)
            goto L7d
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$1
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            ua.v.b(r7)
            r7 = r6
            r6 = r2
            goto L66
        L4a:
            ua.v.b(r7)
            java.lang.String[] r7 = new java.lang.String[]{r6}
            java.util.ArrayList r7 = va.w.g(r7)
            r0.L$0 = r6
            java.lang.Object r2 = cb.l.a(r7)
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r2 = r5.clearHistoryFromRooms(r7, r0)
            if (r2 != r1) goto L66
            goto L7c
        L66:
            cu.todus.android.db.dao.toDus.RoomDao r2 = r5.roomDao
            java.lang.Object r4 = cb.l.a(r6)
            r0.L$0 = r4
            java.lang.Object r7 = cb.l.a(r7)
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r2.delete(r6, r0)
            if (r6 != r1) goto L7d
        L7c:
            return r1
        L7d:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.clearAndDeleteRoom(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0078  */
    /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:28:0x00df  */
    /* JADX WARN: Code duplicated, block: B:33:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:? A[LOOP:0: B:17:0x0072->B:35:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00df -> B:29:0x00e0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object clearHistoryFromRooms(java.util.List<java.lang.String> r13, ab.e<? super ua.k0> r14) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.clearHistoryFromRooms(java.util.List, ab.e):java.lang.Object");
    }

    public final Object getAffiliationOnRoom(String str, ab.e<? super String> eVar) {
        return this.userRoomJoinDao.getAffiliationByRoom(str, ((Owner) this.owner.invoke()).getNameWithDomain(), eVar);
    }

    public final Object getAllByRoomForSave(String str, ab.e<? super List<MessageWithAttachments>> eVar) {
        return this.messageDao.getAllByRoomForSave(str, eVar);
    }

    public final Object getAllForSaves(ab.e<? super List<RoomItemView>> eVar) {
        return this.roomDao.getAllForSaves(eVar);
    }

    public final PagingSource<Integer, RoomItemView> getGroupsAndChannels(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.roomDao.getAllGroupsAndChannels(filter);
    }

    public final PagingSource<Integer, RoomMember> getMembers(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return this.userRoomJoinDao.roomMembers(roomId, ((Owner) this.owner.invoke()).getNameWithDomain());
    }

    public final Object getMsgPosition(String str, String str2, ab.e<? super Integer> eVar) {
        return this.messageDao.getMsgPosition(str, str2, eVar);
    }

    public final PagingSource<Integer, MessageWithPartnerWithRoomWithReactions> getMsgsByFilterForPaging(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.messageDao.getAllWithFilter(filter);
    }

    public final PagingSource<Integer, RoomItemView> getMutedRooms(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.roomDao.getMutedRooms(filter);
    }

    public final PagingSource<Integer, RoomItemView> getOPenRooms(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.roomDao.getOpenRooms(filter);
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public final PagingSource<Integer, RoomItemView> getRequestRooms(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.roomDao.getRequestRooms(filter);
    }

    public final PagingSource<Integer, RoomItemView> getRooms(String filter, List<Integer> types, boolean requestedOn) {
        kotlin.jvm.internal.y.i(filter, "filter");
        kotlin.jvm.internal.y.i(types, "types");
        return requestedOn ? this.roomDao.getAllRoomsWithRequestModeOn(filter, types) : this.roomDao.getAllRooms(filter, types);
    }

    public final PagingSource<Integer, RoomItemView> getSecretRooms(String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.roomDao.getSecretRooms(filter);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getUnreadCount(String str, ab.e<? super Integer> eVar) {
        C11351 c11351;
        if (eVar instanceof C11351) {
            c11351 = (C11351) eVar;
            int i10 = c11351.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11351.label = i10 - Integer.MIN_VALUE;
            } else {
                c11351 = new C11351(eVar);
            }
        } else {
            c11351 = new C11351(eVar);
        }
        Object objUnreadMessageByRoom = c11351.result;
        Object objG = bb.b.g();
        int i11 = c11351.label;
        if (i11 == 0) {
            ua.v.b(objUnreadMessageByRoom);
            MessageDao messageDao = this.messageDao;
            String nameWithDomain = ((Owner) this.owner.invoke()).getNameWithDomain();
            c11351.L$0 = cb.l.a(str);
            c11351.label = 1;
            objUnreadMessageByRoom = messageDao.unreadMessageByRoom(str, nameWithDomain, c11351);
            if (objUnreadMessageByRoom == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objUnreadMessageByRoom);
        }
        return cb.b.d(((List) objUnreadMessageByRoom).size());
    }

    public final te.h groupMemberIds(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return this.userRoomJoinDao.groupMemberIds(roomId);
    }

    public final te.h requestRoomCount() {
        return this.roomDao.getRequestRoomsCount();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0096  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e1, code lost:
    
        if (r2.update(r8, r3) == r4) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setRoomBackground(java.lang.String r25, java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.setRoomBackground(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0098  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e3, code lost:
    
        if (r2.update(r8, r3) == r4) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setUnknownState(java.lang.String r25, java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.setUnknownState(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    public final Object togglePin(String str, ab.e<? super ua.k0> eVar) {
        Object obj = this.roomDao.togglePin(str, eVar);
        return obj == bb.b.g() ? obj : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c4, code lost:
    
        if (r1.update(r8, r2) == r3) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateDraftState(java.lang.String r25, java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.RoomsRepository.updateDraftState(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }
}
