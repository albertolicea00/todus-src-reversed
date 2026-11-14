package cu.todus.android.uiCompose.main.screen.rooms;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.muxer.WebmConstants;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms__PagingDataTransformsKt;
import androidx.paging.PagingSource;
import cb.l;
import cb.m;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.repositories.BotShortcutRepository;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.xmpp.ConnectionState;
import cu.z17.singledi.SinglediException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.k;
import pe.m0;
import te.b0;
import te.h;
import te.i;
import te.p0;
import ua.k0;
import ua.v;
import v5.f;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u0018J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u0003J\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b \u0010\u0018J\u0013\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0006¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\n0\t2\u0006\u0010$\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J)\u0010*\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00112\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130(¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060\t¢\u0006\u0004\b,\u0010\u001bJ/\u0010.\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00112\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00130-¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0011¢\u0006\u0004\b1\u0010\u0018R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0017\u00109\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010\u001bR#\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\bO\u0010M\u001a\u0004\bP\u0010\u001bR#\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\bQ\u0010M\u001a\u0004\bR\u0010\u001bR\u0014\u0010S\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010KR#\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\bT\u0010M\u001a\u0004\bU\u0010\u001bR\u0016\u0010V\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006¢\u0006\f\n\u0004\bX\u0010M\u001a\u0004\bY\u0010\u001b¨\u0006Z"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/rooms/RoomViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "requestedOn", "", "", "types", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/RoomItemView;", Room.TABLE_NAME, "(ZLjava/util/List;)Lte/h;", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "", "arr", "Lua/k0;", "clearHistoryFromRooms", "(Ljava/util/List;)V", "roomId", "togglePin", "(Ljava/lang/String;)V", "toggleMute", "isConnected", "()Lte/h;", "forceReconnect", "Lte/p0;", "mXMPPDataSourceDataState", "()Lte/p0;", "changeMuteValue", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "getHomeBotShortcuts", "()Ljava/util/List;", "filter", "Lcu/todus/android/data/db/pojo/Friend;", "friendsOnDbNoHeaders", "(Ljava/lang/String;)Lte/h;", "Lkotlin/Function1;", "onFound", "goOnUnreadPosition", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getRoomsWithStatusUnseen", "Lkotlin/Function2;", "searchForStatus", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "id", "setUnknownRoomAsAccepted", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lcu/todus/android/repositories/BotShortcutRepository;", "botShortcutRepository", "Lcu/todus/android/repositories/BotShortcutRepository;", "Lcu/todus/android/repositories/UsersRepository;", "usersRepository", "Lcu/todus/android/repositories/UsersRepository;", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Lcu/todus/android/di/PreferencesModule;", "preferencesModule", "Lcu/todus/android/di/PreferencesModule;", "Landroidx/paging/PagingConfig;", "roomsPagingConfigs", "Landroidx/paging/PagingConfig;", "requestMode", "Lte/h;", "getRequestMode", "secretRooms", "getSecretRooms", "mutedRooms", "getMutedRooms", "contactsPagingConfig", "requestRooms", "getRequestRooms", "isSearching", "Z", "requestRoomCount", "getRequestRoomCount", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RoomViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final BotShortcutRepository botShortcutRepository;
    private final PagingConfig contactsPagingConfig;
    private final f gson;
    private boolean isSearching;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final h mutedRooms;
    private final PreferencesModule preferencesModule;
    private final h requestMode;
    private final h requestRoomCount;
    private final h requestRooms;
    private final PagingConfig roomsPagingConfigs;
    private final RoomsRepository roomsRepository;
    private final h secretRooms;
    private final StatusRepository statusRepository;
    private final UsersRepository usersRepository;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$changeMuteValue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$changeMuteValue$1", f = "RoomViewModel.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_DURATION}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return RoomViewModel.this.new AnonymousClass1(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = RoomViewModel.this.roomsRepository;
                String str = this.$roomId;
                this.label = 1;
                if (roomsRepository.changeMuteValue(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$clearHistoryFromRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$clearHistoryFromRooms$1", f = "RoomViewModel.kt", l = {81}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13011 extends m implements Function1 {
        final /* synthetic */ List<String> $arr;
        Object L$0;
        int label;
        final /* synthetic */ RoomViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13011(List<String> list, RoomViewModel roomViewModel, ab.e<? super C13011> eVar) {
            super(1, eVar);
            this.$arr = list;
            this.this$0 = roomViewModel;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C13011(this.$arr, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13011) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                List<String> list = this.$arr;
                ArrayList arrayList = new ArrayList(x.y(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next());
                }
                RoomsRepository roomsRepository = this.this$0.roomsRepository;
                this.L$0 = l.a(arrayList);
                this.label = 1;
                if (roomsRepository.clearHistoryFromRooms(arrayList, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$goOnUnreadPosition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$goOnUnreadPosition$1", f = "RoomViewModel.kt", l = {210}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13021 extends m implements Function1 {
        final /* synthetic */ Function1 $onFound;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$goOnUnreadPosition$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$goOnUnreadPosition$1$1", f = "RoomViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02431 extends m implements Function2 {
            final /* synthetic */ int $indexUnread;
            final /* synthetic */ Function1 $onFound;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02431(int i10, Function1 function1, ab.e<? super C02431> eVar) {
                super(2, eVar);
                this.$indexUnread = i10;
                this.$onFound = function1;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02431(this.$indexUnread, this.$onFound, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                int i10 = this.$indexUnread;
                if (i10 > 0) {
                    this.$onFound.invoke(cb.b.d(i10));
                } else {
                    this.$onFound.invoke(cb.b.d(0));
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02431) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13021(String str, Function1 function1, ab.e<? super C13021> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$onFound = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return RoomViewModel.this.new C13021(this.$roomId, this.$onFound, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13021) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = RoomViewModel.this.mainRepository;
                String str = this.$roomId;
                this.label = 1;
                obj = mainRepository.getFirstUnreadPosition(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            k.d(ViewModelKt.getViewModelScope(RoomViewModel.this), d1.c(), null, new C02431(((Number) obj).intValue() - 3, this.$onFound, null), 2, null);
            RoomViewModel.this.isSearching = false;
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$searchForStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$searchForStatus$1", f = "RoomViewModel.kt", l = {229}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13031 extends m implements Function1 {
        final /* synthetic */ Function2 $onFound;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$searchForStatus$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$searchForStatus$1$1", f = "RoomViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02441 extends m implements Function2 {
            final /* synthetic */ Function2 $onFound;
            final /* synthetic */ Pair<Integer, String> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02441(Function2 function2, Pair<Integer, String> pair, ab.e<? super C02441> eVar) {
                super(2, eVar);
                this.$onFound = function2;
                this.$result = pair;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02441(this.$onFound, this.$result, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                Function2 function2 = this.$onFound;
                Integer first = this.$result.getFirst();
                y.f(first);
                String second = this.$result.getSecond();
                y.f(second);
                function2.invoke(first, second);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02441) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13031(String str, Function2 function2, ab.e<? super C13031> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$onFound = function2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return RoomViewModel.this.new C13031(this.$roomId, this.$onFound, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13031) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                StatusRepository statusRepository = RoomViewModel.this.statusRepository;
                String str = this.$roomId;
                this.label = 1;
                obj = statusRepository.getLastStatusPosition(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            Pair pair = (Pair) obj;
            if (pair.getFirst() != null && pair.getSecond() != null) {
                k.d(ViewModelKt.getViewModelScope(RoomViewModel.this), d1.c(), null, new C02441(this.$onFound, pair, null), 2, null);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$setUnknownRoomAsAccepted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$setUnknownRoomAsAccepted$1", f = "RoomViewModel.kt", l = {243}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13041 extends m implements Function1 {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13041(String str, ab.e<? super C13041> eVar) {
            super(1, eVar);
            this.$id = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return RoomViewModel.this.new C13041(this.$id, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13041) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = RoomViewModel.this.roomsRepository;
                String str = this.$id;
                this.label = 1;
                if (roomsRepository.setUnknownState(str, Room.UR_ACCEPTED, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$toggleMute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$toggleMute$1", f = "RoomViewModel.kt", l = {93}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13051 extends m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13051(String str, ab.e<? super C13051> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return RoomViewModel.this.new C13051(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13051) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = RoomViewModel.this.roomsRepository;
                String str = this.$roomId;
                this.label = 1;
                if (roomsRepository.changeMuteValue(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$togglePin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$togglePin$1", f = "RoomViewModel.kt", l = {87}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13061 extends m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13061(String str, ab.e<? super C13061> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return RoomViewModel.this.new C13061(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13061) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = RoomViewModel.this.roomsRepository;
                String str = this.$roomId;
                this.label = 1;
                if (roomsRepository.togglePin(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    public RoomViewModel() throws SinglediException {
        RoomsRepository singletonInitializer = RoomsRepository.INSTANCE.getInstance();
        this.roomsRepository = singletonInitializer;
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        this.botShortcutRepository = BotShortcutRepository.INSTANCE.getInstance();
        this.usersRepository = UsersRepository.INSTANCE.getInstance();
        this.statusRepository = StatusRepository.INSTANCE.getInstance();
        PreferencesModule singletonInitializer2 = PreferencesModule.INSTANCE.getInstance();
        this.preferencesModule = singletonInitializer2;
        PagingConfig pagingConfig = new PagingConfig(10, 10, true, 20, Integer.MAX_VALUE, 0, 32, null);
        this.roomsPagingConfigs = pagingConfig;
        this.requestMode = singletonInitializer2.getRequestModeFlow();
        final h flow = new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.a
            @Override // lb.a
            public final Object invoke() {
                return RoomViewModel.secretRooms$lambda$0(this.f27020c);
            }
        }, 2, null).getFlow();
        this.secretRooms = CachedPagingDataKt.cachedIn(new h() { // from class: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ RoomViewModel this$0;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$1$2", f = "RoomViewModel.kt", l = {50}, m = "emit", v = 2)
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

                public AnonymousClass2(i iVar, RoomViewModel roomViewModel) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = roomViewModel;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
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
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        PagingData map = PagingDataTransforms__PagingDataTransformsKt.map((PagingData) obj, new RoomViewModel$secretRooms$2$1(this.this$0, null));
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(map, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, ab.e eVar) {
                Object objCollect = flow.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        }, ViewModelKt.getViewModelScope(this));
        final h flow2 = new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.b
            @Override // lb.a
            public final Object invoke() {
                return RoomViewModel.mutedRooms$lambda$0(this.f27021c);
            }
        }, 2, null).getFlow();
        this.mutedRooms = CachedPagingDataKt.cachedIn(new h() { // from class: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$2

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ RoomViewModel this$0;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$2$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$2$2", f = "RoomViewModel.kt", l = {50}, m = "emit", v = 2)
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

                public AnonymousClass2(i iVar, RoomViewModel roomViewModel) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = roomViewModel;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
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
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        PagingData map = PagingDataTransforms__PagingDataTransformsKt.map((PagingData) obj, new RoomViewModel$mutedRooms$2$1(this.this$0, null));
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(map, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, ab.e eVar) {
                Object objCollect = flow2.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        }, ViewModelKt.getViewModelScope(this));
        this.contactsPagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
        final h flow3 = new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.c
            @Override // lb.a
            public final Object invoke() {
                return RoomViewModel.requestRooms$lambda$0(this.f27022c);
            }
        }, 2, null).getFlow();
        this.requestRooms = CachedPagingDataKt.cachedIn(new h() { // from class: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$3

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ RoomViewModel this$0;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$3$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$special$$inlined$map$3$2", f = "RoomViewModel.kt", l = {50}, m = "emit", v = 2)
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

                public AnonymousClass2(i iVar, RoomViewModel roomViewModel) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = roomViewModel;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
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
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        PagingData map = PagingDataTransforms__PagingDataTransformsKt.map((PagingData) obj, new RoomViewModel$requestRooms$2$1(this.this$0, null));
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(map, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, ab.e eVar) {
                Object objCollect = flow3.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        }, ViewModelKt.getViewModelScope(this));
        this.requestRoomCount = singletonInitializer.requestRoomCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource friendsOnDbNoHeaders$lambda$0(RoomViewModel roomViewModel, String str) {
        return roomViewModel.usersRepository.getFriends(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource mutedRooms$lambda$0(RoomViewModel roomViewModel) {
        return roomViewModel.roomsRepository.getMutedRooms("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource requestRooms$lambda$0(RoomViewModel roomViewModel) {
        return roomViewModel.roomsRepository.getRequestRooms("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource rooms$lambda$0(RoomViewModel roomViewModel, List list, boolean z10) {
        return RoomsRepository.getRooms$default(roomViewModel.roomsRepository, null, list, z10, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource secretRooms$lambda$0(RoomViewModel roomViewModel) {
        return roomViewModel.roomsRepository.getSecretRooms("");
    }

    public final void changeMuteValue(String roomId) {
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(roomId, null), 3, null);
    }

    public final void clearHistoryFromRooms(List<String> arr) {
        y.i(arr, "arr");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13011(arr, this, null), 3, null);
    }

    public final void forceReconnect() {
        this.mainRepository.forceReconnect();
    }

    public final h friendsOnDbNoHeaders(final String filter) {
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.e
            @Override // lb.a
            public final Object invoke() {
                return RoomViewModel.friendsOnDbNoHeaders$lambda$0(this.f27026c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final f getGson() {
        return this.gson;
    }

    public final List<BotShortcut> getHomeBotShortcuts() {
        return this.botShortcutRepository.getHomeShortcuts();
    }

    public final h getMutedRooms() {
        return this.mutedRooms;
    }

    public final Owner getOwner() {
        return (Owner) this.roomsRepository.getOwner().invoke();
    }

    public final h getRequestMode() {
        return this.requestMode;
    }

    public final h getRequestRoomCount() {
        return this.requestRoomCount;
    }

    public final h getRequestRooms() {
        return this.requestRooms;
    }

    public final h getRoomsWithStatusUnseen() {
        return this.statusRepository.getRoomsWithStatusUnseen();
    }

    public final h getSecretRooms() {
        return this.secretRooms;
    }

    public final void goOnUnreadPosition(String roomId, Function1 onFound) {
        y.i(roomId, "roomId");
        y.i(onFound, "onFound");
        if (this.isSearching) {
            return;
        }
        this.isSearching = true;
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13021(roomId, onFound, null), 3, null);
    }

    public final h isConnected() {
        final b0 connectionState = this.mainRepository.getConnectionState();
        return new h() { // from class: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$isConnected$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$isConnected$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$isConnected$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$isConnected$$inlined$map$1$2", f = "RoomViewModel.kt", l = {50}, m = "emit", v = 2)
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

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
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
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        Boolean boolA = cb.b.a(((ConnectionState) obj) == ConnectionState.CONNECTED);
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(boolA, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, ab.e eVar) {
                Object objCollect = connectionState.collect(new AnonymousClass2(iVar), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
    }

    public final p0 mXMPPDataSourceDataState() {
        return this.mainRepository.mXMPPDataSourceDataState();
    }

    public final h rooms(final boolean requestedOn, final List<Integer> types) {
        y.i(types, "types");
        final h flow = new Pager(this.roomsPagingConfigs, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.d
            @Override // lb.a
            public final Object invoke() {
                return RoomViewModel.rooms$lambda$0(this.f27023c, types, requestedOn);
            }
        }, 2, null).getFlow();
        return CachedPagingDataKt.cachedIn(new h() { // from class: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$rooms$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$rooms$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ RoomViewModel this$0;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$rooms$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$rooms$$inlined$map$1$2", f = "RoomViewModel.kt", l = {50}, m = "emit", v = 2)
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

                public AnonymousClass2(i iVar, RoomViewModel roomViewModel) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = roomViewModel;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
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
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        v.b(obj2);
                        i iVar = this.$this_unsafeFlow;
                        PagingData map = PagingDataTransforms__PagingDataTransformsKt.map((PagingData) obj, new RoomViewModel$rooms$2$1(this.this$0, null));
                        anonymousClass1.L$0 = l.a(obj);
                        anonymousClass1.L$1 = l.a(anonymousClass1);
                        anonymousClass1.L$2 = l.a(obj);
                        anonymousClass1.L$3 = l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(map, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(i iVar, ab.e eVar) {
                Object objCollect = flow.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        }, ViewModelKt.getViewModelScope(this));
    }

    public final void searchForStatus(String roomId, Function2 onFound) {
        y.i(roomId, "roomId");
        y.i(onFound, "onFound");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13031(roomId, onFound, null), 3, null);
    }

    public final void setUnknownRoomAsAccepted(String id2) {
        y.i(id2, "id");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13041(id2, null), 3, null);
    }

    public final void toggleMute(String roomId) {
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13051(roomId, null), 3, null);
    }

    public final void togglePin(String roomId) {
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13061(roomId, null), 3, null);
    }
}
