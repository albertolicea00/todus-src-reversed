package cu.todus.android.uiCompose.intentReceiver.screen.sendTo;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.d1;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\rJ!\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\rJ?\u0010\u001a\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u0003J\u0015\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\t¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Lcu/todus/android/uiCompose/intentReceiver/screen/sendTo/SendToViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "", "filter", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "recent", "(Ljava/lang/String;)Lte/h;", "groupsAndChannels", "Lcu/todus/android/data/db/pojo/Friend;", "friendsOnDbNoHeaders", "", "roomIds", "Lcu/todus/android/domain/handlers/Send;", Service.Endpoint.LINKED_DEVICES_LIST, "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lua/k0;", "onComplete", "sendTo", "(Ljava/util/List;Ljava/util/List;Landroid/content/Context;Llb/a;)V", "updateContactList", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "ownerLastStatus", "()Lte/h;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lcu/todus/android/repositories/UsersRepository;", "usersRepository", "Lcu/todus/android/repositories/UsersRepository;", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Landroidx/paging/PagingConfig;", "contactsPagingConfig", "Landroidx/paging/PagingConfig;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SendToViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();
    private final UsersRepository usersRepository = UsersRepository.INSTANCE.getInstance();
    private final StatusRepository statusRepository = StatusRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final PagingConfig contactsPagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToViewModel$sendTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToViewModel$sendTo$1", f = "SendToViewModel.kt", l = {57}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<Send> $list;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ List<String> $roomIds;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToViewModel$sendTo$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToViewModel$sendTo$1$1", f = "SendToViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02141 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02141(lb.a aVar, ab.e<? super C02141> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02141(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02141) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, List<Send> list2, Context context, lb.a aVar, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$roomIds = list;
            this.$list = list2;
            this.$context = context;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return SendToViewModel.this.new AnonymousClass1(this.$roomIds, this.$list, this.$context, this.$onComplete, eVar);
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
                ua.v.b(obj);
                MainRepository mainRepository = SendToViewModel.this.mainRepository;
                List<String> list = this.$roomIds;
                List<Send> list2 = this.$list;
                Context context = this.$context;
                this.label = 1;
                if (mainRepository.sendFromIntent(list, list2, context, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(SendToViewModel.this), d1.c(), null, new C02141(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource friendsOnDbNoHeaders$lambda$0(SendToViewModel sendToViewModel, String str) {
        return sendToViewModel.usersRepository.getFriends(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource groupsAndChannels$lambda$0(SendToViewModel sendToViewModel, String str) {
        return sendToViewModel.roomsRepository.getGroupsAndChannels(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource recent$lambda$0(SendToViewModel sendToViewModel, String str) {
        return RoomsRepository.getRooms$default(sendToViewModel.roomsRepository, str, null, false, 6, null);
    }

    public final te.h friendsOnDbNoHeaders(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.a0
            @Override // lb.a
            public final Object invoke() {
                return SendToViewModel.friendsOnDbNoHeaders$lambda$0(this.f21380c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final te.h groupsAndChannels(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.c0
            @Override // lb.a
            public final Object invoke() {
                return SendToViewModel.groupsAndChannels$lambda$0(this.f21384c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final te.h ownerLastStatus() {
        return this.statusRepository.ownerLastStatus();
    }

    public final te.h recent(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.b0
            @Override // lb.a
            public final Object invoke() {
                return SendToViewModel.recent$lambda$0(this.f21382c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void sendTo(List<String> roomIds, List<Send> list, Context context, lb.a onComplete) {
        kotlin.jvm.internal.y.i(roomIds, "roomIds");
        kotlin.jvm.internal.y.i(list, "list");
        kotlin.jvm.internal.y.i(context, "context");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(roomIds, list, context, onComplete, null), 3, null);
    }

    public final void updateContactList() {
        MainRepository.initRosterLoad$default(this.mainRepository, false, 1, null);
    }
}
