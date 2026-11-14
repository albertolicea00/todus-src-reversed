package cu.todus.android.uiCompose.main.screen.usersDisplay;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cb.m;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.di.MainModule;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.xmpp.XMPPUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import org.jivesoftware.smackx.blocking.element.UnblockContactsIQ;
import pe.d1;
import pe.k;
import pe.m0;
import pe.w0;
import te.b0;
import te.h;
import te.j;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000e0\r2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0011J!\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u0003J!\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u000e0\r2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u0011J!\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u000e0\r2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u0011J!\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u0011J7\u0010$\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\"¢\u0006\u0004\b$\u0010%J1\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\"¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000e0\r¢\u0006\u0004\b)\u0010*J#\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\"¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\r¢\u0006\u0004\b/\u0010*R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0017\u0010=\u001a\u00020<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020B0A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020B0E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120M0A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010DR#\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120M0E8\u0006¢\u0006\f\n\u0004\bO\u0010G\u001a\u0004\bP\u0010IR\"\u0010Q\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006W"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/usersDisplay/ContactsViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "", User.COLUMN_TODUS_ID, "Lua/k0;", "searchForPartner", "(Ljava/lang/String;)V", "filter", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/Friend;", "friendsOnDb", "(Ljava/lang/String;)Lte/h;", "Lcu/todus/android/data/db/pojo/Partner;", "usersOnDb", "", "hasContactsPermission", "isUserInitiated", "updateContactList", "(ZZ)V", "resetRefreshState", "Lcu/todus/android/data/db/pojo/RoomItemView;", "recent", "groupsAndChannels", "friendsOnDbNoHeaders", "", "roomIds", "Lcu/todus/android/domain/handlers/Send;", Service.Endpoint.LINKED_DEVICES_LIST, "Lkotlin/Function0;", "onComplete", "sendForwards", "(Ljava/util/List;Ljava/util/List;Llb/a;)V", "text", "sendNewMessage", "(Ljava/lang/String;Ljava/util/List;Llb/a;)V", "partnersBlocked", "()Lte/h;", "uid", UnblockContactsIQ.ELEMENT, "(Ljava/lang/String;Llb/a;)V", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "ownerLastStatus", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lcu/todus/android/repositories/UsersRepository;", "usersRepository", "Lcu/todus/android/repositories/UsersRepository;", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lte/b0;", "Lcu/todus/android/uiCompose/main/screen/usersDisplay/RefreshContactsState;", "_refreshState", "Lte/b0;", "Lte/p0;", "refreshState", "Lte/p0;", "getRefreshState", "()Lte/p0;", "Landroidx/paging/PagingConfig;", "contactsPagingConfig", "Landroidx/paging/PagingConfig;", "Lcu/todus/android/data/wrapper/FlowsState;", "_requestingPartner", "requestingPartner", "getRequestingPartner", "initialSyncDone", "Z", "getInitialSyncDone", "()Z", "setInitialSyncDone", "(Z)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContactsViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _refreshState;
    private b0 _requestingPartner;
    private final PagingConfig contactsPagingConfig;
    private boolean initialSyncDone;
    private final p0 refreshState;
    private final p0 requestingPartner;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();
    private final UsersRepository usersRepository = UsersRepository.INSTANCE.getInstance();
    private final StatusRepository statusRepository = StatusRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$searchForPartner$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$searchForPartner$1", f = "ContactsViewModel.kt", l = {MdtaMetadataEntry.TYPE_INDICATOR_INT32, 69}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ String $toDusId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$toDusId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ContactsViewModel.this.new AnonymousClass1(this.$toDusId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        
            if (r5 == r0) goto L17;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r4.L$0
                cu.todus.android.data.db.entity.toDus.User r0 = (cu.todus.android.data.db.entity.toDus.User) r0
                ua.v.b(r5)
                goto L66
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1e:
                ua.v.b(r5)
                goto L45
            L22:
                ua.v.b(r5)
                cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel r5 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.this
                te.b0 r5 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.access$get_requestingPartner$p(r5)
                cu.todus.android.data.wrapper.FlowsState$Companion r1 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r1 = r1.loading()
                r5.setValue(r1)
                cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel r5 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.this
                cu.todus.android.repositories.MainRepository r5 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.access$getMainRepository$p(r5)
                java.lang.String r1 = r4.$toDusId
                r4.label = r3
                java.lang.Object r5 = r5.reloadUser(r1, r4)
                if (r5 != r0) goto L45
                goto L65
            L45:
                cu.todus.android.data.db.entity.toDus.User r5 = (cu.todus.android.data.db.entity.toDus.User) r5
                if (r5 == 0) goto L8a
                cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel r1 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.this
                cu.todus.android.repositories.MainRepository r1 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.access$getMainRepository$p(r1)
                java.lang.String r3 = r5.getUid()
                te.h r1 = r1.getPartnerByIdFlow(r3)
                java.lang.Object r5 = cb.l.a(r5)
                r4.L$0 = r5
                r4.label = r2
                java.lang.Object r5 = te.j.x(r1, r4)
                if (r5 != r0) goto L66
            L65:
                return r0
            L66:
                cu.todus.android.data.db.pojo.Partner r5 = (cu.todus.android.data.db.pojo.Partner) r5
                if (r5 == 0) goto L7a
                cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel r0 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.this
                te.b0 r0 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.access$get_requestingPartner$p(r0)
                cu.todus.android.data.wrapper.FlowsState$Companion r1 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r5 = r1.success(r5)
                r0.setValue(r5)
                goto L99
            L7a:
                cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel r5 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.this
                te.b0 r5 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.access$get_requestingPartner$p(r5)
                cu.todus.android.data.wrapper.FlowsState$Companion r0 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r0 = r0.emptyData()
                r5.setValue(r0)
                goto L99
            L8a:
                cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel r5 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.this
                te.b0 r5 = cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.access$get_requestingPartner$p(r5)
                cu.todus.android.data.wrapper.FlowsState$Companion r0 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r0 = r0.emptyData()
                r5.setValue(r0)
            L99:
                ua.k0 r5 = ua.k0.f43947a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$sendForwards$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$sendForwards$1", f = "ContactsViewModel.kt", l = {TsExtractor.TS_STREAM_TYPE_AC4}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13291 extends m implements Function1 {
        final /* synthetic */ List<Send> $list;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ List<String> $roomIds;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$sendForwards$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$sendForwards$1$2", f = "ContactsViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13291(List<String> list, List<Send> list2, lb.a aVar, ab.e<? super C13291> eVar) {
            super(1, eVar);
            this.$roomIds = list;
            this.$list = list2;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ContactsViewModel.this.new C13291(this.$roomIds, this.$list, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13291) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            C13291 c13291;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ContactsViewModel.this.mainRepository;
                List<String> list = this.$roomIds;
                List<Send> list2 = this.$list;
                ArrayList arrayList = new ArrayList(x.y(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Send) it.next()).getToSend());
                }
                long time = new Date().getTime();
                this.label = 1;
                c13291 = this;
                if (mainRepository.sendForward(list, arrayList, time, c13291) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                c13291 = this;
            }
            k.d(ViewModelKt.getViewModelScope(ContactsViewModel.this), d1.c(), null, new AnonymousClass2(c13291.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$sendNewMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$sendNewMessage$1", f = "ContactsViewModel.kt", l = {PsExtractor.AUDIO_STREAM, 197}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13301 extends m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ List<String> $roomIds;
        final /* synthetic */ String $text;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ ContactsViewModel this$0;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$sendNewMessage$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$sendNewMessage$1$2", f = "ContactsViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13301(List<String> list, ContactsViewModel contactsViewModel, String str, lb.a aVar, ab.e<? super C13301> eVar) {
            super(1, eVar);
            this.$roomIds = list;
            this.this$0 = contactsViewModel;
            this.$text = str;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C13301(this.$roomIds, this.this$0, this.$text, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13301) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x006c  */
        /* JADX WARN: Code duplicated, block: B:15:0x007b  */
        /* JADX WARN: Code duplicated, block: B:18:0x00c2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x010a -> B:20:0x00cb). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 304
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel.C13301.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$unblock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$unblock$1", f = "ContactsViewModel.kt", l = {221}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13311 extends m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$unblock$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$unblock$1$1", f = "ContactsViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02601 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02601(lb.a aVar, ab.e<? super C02601> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02601(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02601) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13311(String str, lb.a aVar, ab.e<? super C13311> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ContactsViewModel.this.new C13311(this.$uid, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13311) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ContactsViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                if (mainRepository.unBlockUser(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            k.d(ViewModelKt.getViewModelScope(ContactsViewModel.this), d1.c(), null, new C02601(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$updateContactList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel$updateContactList$1", f = "ContactsViewModel.kt", l = {110}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13321 extends m implements Function1 {
        final /* synthetic */ boolean $hasContactsPermission;
        final /* synthetic */ boolean $isUserInitiated;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13321(boolean z10, boolean z11, ab.e<? super C13321> eVar) {
            super(1, eVar);
            this.$isUserInitiated = z10;
            this.$hasContactsPermission = z11;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ContactsViewModel.this.new C13321(this.$isUserInitiated, this.$hasContactsPermission, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13321) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    v.b(obj);
                    if (!ContactsViewModel.this.mainRepository.isConnected()) {
                        if (this.$isUserInitiated) {
                            ContactsViewModel.this._refreshState.setValue(new RefreshContactsState.Error("No hay conexión a internet."));
                        }
                        return k0.f43947a;
                    }
                    ContactsViewModel.this._refreshState.setValue(RefreshContactsState.Loading.INSTANCE);
                    ContactsViewModel.this.mainRepository.initRosterLoad(this.$hasContactsPermission);
                    this.label = 1;
                    if (w0.b(1000L, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
                if (ContactsViewModel.this.mainRepository.isConnected()) {
                    if (this.$isUserInitiated) {
                        ContactsViewModel.this._refreshState.setValue(new RefreshContactsState.Success("Contactos actualizados"));
                    } else {
                        ContactsViewModel.this._refreshState.setValue(RefreshContactsState.Idle.INSTANCE);
                    }
                    return k0.f43947a;
                }
                if (this.$isUserInitiated) {
                    ContactsViewModel.this._refreshState.setValue(new RefreshContactsState.Error("Se perdió la conexión durante la sincronización"));
                } else {
                    ContactsViewModel.this._refreshState.setValue(RefreshContactsState.Idle.INSTANCE);
                }
                return k0.f43947a;
            } catch (Exception e10) {
                if (this.$isUserInitiated) {
                    b0 b0Var = ContactsViewModel.this._refreshState;
                    String message = e10.getMessage();
                    if (message == null) {
                        message = "Error al sincronizar contactos";
                    }
                    b0Var.setValue(new RefreshContactsState.Error(message));
                } else {
                    ContactsViewModel.this._refreshState.setValue(RefreshContactsState.Idle.INSTANCE);
                }
            }
        }
    }

    public ContactsViewModel() {
        b0 b0VarA = r0.a(RefreshContactsState.Idle.INSTANCE);
        this._refreshState = b0VarA;
        this.refreshState = j.b(b0VarA);
        this.contactsPagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
        b0 b0VarA2 = r0.a(FlowsState.INSTANCE.notRequested());
        this._requestingPartner = b0VarA2;
        this.requestingPartner = j.b(b0VarA2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource friendsOnDb$lambda$0(ContactsViewModel contactsViewModel, String str) {
        return contactsViewModel.usersRepository.getFriends(a0.O(str, "@", "", false, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource friendsOnDbNoHeaders$lambda$0(ContactsViewModel contactsViewModel, String str) {
        return contactsViewModel.usersRepository.getFriends(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource groupsAndChannels$lambda$0(ContactsViewModel contactsViewModel, String str) {
        return contactsViewModel.roomsRepository.getGroupsAndChannels(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource partnersBlocked$lambda$0(ContactsViewModel contactsViewModel) {
        return contactsViewModel.usersRepository.getBlocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource recent$lambda$0(ContactsViewModel contactsViewModel, String str) {
        return RoomsRepository.getRooms$default(contactsViewModel.roomsRepository, str, null, false, 6, null);
    }

    public static /* synthetic */ void updateContactList$default(ContactsViewModel contactsViewModel, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        contactsViewModel.updateContactList(z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource usersOnDb$lambda$0(ContactsViewModel contactsViewModel, String str) {
        return contactsViewModel.usersRepository.getOtherUsers(a0.O(str, "@", "", false, 4, null));
    }

    public final h friendsOnDb(final String filter) {
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.c
            @Override // lb.a
            public final Object invoke() {
                return ContactsViewModel.friendsOnDb$lambda$0(this.f28070c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final h friendsOnDbNoHeaders(final String filter) {
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.a
            @Override // lb.a
            public final Object invoke() {
                return ContactsViewModel.friendsOnDbNoHeaders$lambda$0(this.f28054c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final boolean getInitialSyncDone() {
        return this.initialSyncDone;
    }

    public final p0 getRefreshState() {
        return this.refreshState;
    }

    public final p0 getRequestingPartner() {
        return this.requestingPartner;
    }

    public final h groupsAndChannels(final String filter) {
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.e
            @Override // lb.a
            public final Object invoke() {
                return ContactsViewModel.groupsAndChannels$lambda$0(this.f28073c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final h ownerLastStatus() {
        return this.statusRepository.ownerLastStatus();
    }

    public final h partnersBlocked() {
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.d
            @Override // lb.a
            public final Object invoke() {
                return ContactsViewModel.partnersBlocked$lambda$0(this.f28072c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final h recent(final String filter) {
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.f
            @Override // lb.a
            public final Object invoke() {
                return ContactsViewModel.recent$lambda$0(this.f28075c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void resetRefreshState() {
        this._refreshState.setValue(RefreshContactsState.Idle.INSTANCE);
    }

    public final void searchForPartner(String toDusId) {
        y.i(toDusId, "toDusId");
        if (XMPPUtils.INSTANCE.isUser(toDusId + "@im.todus.cu") || y.d(toDusId, owner().getToDusId())) {
            return;
        }
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(toDusId, null), 3, null);
    }

    public final void sendForwards(List<String> roomIds, List<Send> list, lb.a onComplete) {
        y.i(roomIds, "roomIds");
        y.i(list, "list");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13291(roomIds, list, onComplete, null), 3, null);
    }

    public final void sendNewMessage(String text, List<String> roomIds, lb.a onComplete) {
        y.i(text, "text");
        y.i(roomIds, "roomIds");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13301(roomIds, this, text, onComplete, null), 3, null);
    }

    public final void setInitialSyncDone(boolean z10) {
        this.initialSyncDone = z10;
    }

    public final void unblock(String uid, lb.a onComplete) {
        y.i(uid, "uid");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13311(uid, onComplete, null), 3, null);
    }

    public final void updateContactList(boolean hasContactsPermission, boolean isUserInitiated) {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13321(isUserInitiated, hasContactsPermission, null), 3, null);
    }

    public final h usersOnDb(final String filter) {
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.b
            @Override // lb.a
            public final Object invoke() {
                return ContactsViewModel.usersOnDb$lambda$0(this.f28056c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }
}
