package cu.todus.android.uiCompose.main.screen.statusList;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.xmpp.FollowState;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.d1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0004\b\f\u0010\nJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0003J!\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00072\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00072\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0014J+\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\r0\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000f2\u001e\u0010\u001e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b0\u001c\u0012\u0004\u0012\u00020\r0\u0016¢\u0006\u0004\b\u001f\u0010\u001aR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R#\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110\u00078\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\nR\u0014\u00101\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010-¨\u00062"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusList/StatusListViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "Lte/h;", "", "statusCount", "()Lte/h;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "ownerLastStatus", "Lua/k0;", "updateClosed", "", "uid", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/FollowPartner;", "followers", "(Ljava/lang/String;)Lte/h;", "following", "Lkotlin/Function1;", "Lcu/todus/android/data/xmpp/FollowState;", "onComplete", "getFollowState", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "statusId", "Lkotlin/Pair;", "", "onFound", "getStatusPosition", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Landroidx/paging/PagingConfig;", "statusPagingConfig", "Landroidx/paging/PagingConfig;", "otherStatus", "Lte/h;", "getOtherStatus", "followPagingConfig", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusListViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final PagingConfig followPagingConfig;
    private final te.h otherStatus;
    private final PagingConfig statusPagingConfig;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final StatusRepository statusRepository = StatusRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$1", f = "StatusListViewModel.kt", l = {98, 99}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
            return StatusListViewModel.this.new AnonymousClass1(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001e  */
        /* JADX WARN: Code duplicated, block: B:14:0x002d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0036 -> B:11:0x001e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L1b
            Lf:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L17:
                ua.v.b(r7)
                goto L2d
            L1b:
                ua.v.b(r7)
            L1e:
                cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel r7 = cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel.this
                cu.todus.android.repositories.StatusRepository r7 = cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel.access$getStatusRepository$p(r7)
                r6.label = r3
                java.lang.Object r7 = r7.remove48HStatuses(r6)
                if (r7 != r0) goto L2d
                goto L38
            L2d:
                r6.label = r2
                r4 = 60000(0xea60, double:2.9644E-319)
                java.lang.Object r7 = pe.w0.b(r4, r6)
                if (r7 != r0) goto L1e
            L38:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$getFollowState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$getFollowState$1", f = "StatusListViewModel.kt", l = {75}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13211 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onComplete;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$getFollowState$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$getFollowState$1$1", f = "StatusListViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02561 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onComplete;
            final /* synthetic */ FollowState $response;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02561(Function1 function1, FollowState followState, ab.e<? super C02561> eVar) {
                super(2, eVar);
                this.$onComplete = function1;
                this.$response = followState;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02561(this.$onComplete, this.$response, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke(this.$response);
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02561) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13211(String str, Function1 function1, ab.e<? super C13211> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = function1;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return StatusListViewModel.this.new C13211(this.$uid, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13211) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = StatusListViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                obj = mainRepository.followState(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            FollowState followState = (FollowState) obj;
            if (followState != null) {
                pe.k.d(ViewModelKt.getViewModelScope(StatusListViewModel.this), d1.c(), null, new C02561(this.$onComplete, followState, null), 2, null);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$getStatusPosition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$getStatusPosition$1", f = "StatusListViewModel.kt", l = {87}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13221 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onFound;
        final /* synthetic */ String $statusId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$getStatusPosition$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$getStatusPosition$1$1", f = "StatusListViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02571 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onFound;
            final /* synthetic */ Pair<Boolean, Integer> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02571(Function1 function1, Pair<Boolean, Integer> pair, ab.e<? super C02571> eVar) {
                super(2, eVar);
                this.$onFound = function1;
                this.$result = pair;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02571(this.$onFound, this.$result, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onFound.invoke(this.$result);
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02571) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13221(String str, Function1 function1, ab.e<? super C13221> eVar) {
            super(1, eVar);
            this.$statusId = str;
            this.$onFound = function1;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return StatusListViewModel.this.new C13221(this.$statusId, this.$onFound, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13221) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                StatusRepository statusRepository = StatusListViewModel.this.statusRepository;
                String str = this.$statusId;
                this.label = 1;
                obj = statusRepository.getPositionById(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(StatusListViewModel.this), d1.c(), null, new C02571(this.$onFound, (Pair) obj, null), 2, null);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$updateClosed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.StatusListViewModel$updateClosed$1", f = "StatusListViewModel.kt", l = {45}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13231 extends cb.m implements Function1 {
        int label;

        public C13231(ab.e<? super C13231> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return StatusListViewModel.this.new C13231(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13231) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                StatusRepository statusRepository = StatusListViewModel.this.statusRepository;
                this.label = 1;
                if (statusRepository.setAsClosed(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    public StatusListViewModel() {
        PagingConfig pagingConfig = new PagingConfig(10, 10, true, 20, Integer.MAX_VALUE, 0, 32, null);
        this.statusPagingConfig = pagingConfig;
        this.otherStatus = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.s0
            @Override // lb.a
            public final Object invoke() {
                return StatusListViewModel.otherStatus$lambda$0(this.f27851c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
        this.followPagingConfig = new PagingConfig(15, 15, true, 30, Integer.MAX_VALUE, 0, 32, null);
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource followers$lambda$0(String str) {
        return new FollowersPagingSource(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource following$lambda$0(String str) {
        return new FollowingPagingSource(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource otherStatus$lambda$0(StatusListViewModel statusListViewModel) {
        return statusListViewModel.statusRepository.otherStatus();
    }

    public final te.h followers(final String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return CachedPagingDataKt.cachedIn(new Pager(this.followPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.u0
            @Override // lb.a
            public final Object invoke() {
                return StatusListViewModel.followers$lambda$0(uid);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final te.h following(final String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return CachedPagingDataKt.cachedIn(new Pager(this.followPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.t0
            @Override // lb.a
            public final Object invoke() {
                return StatusListViewModel.following$lambda$0(uid);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void getFollowState(String uid, Function1 onComplete) {
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13211(uid, onComplete, null), 3, null);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final te.h getOtherStatus() {
        return this.otherStatus;
    }

    public final void getStatusPosition(String statusId, Function1 onFound) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        kotlin.jvm.internal.y.i(onFound, "onFound");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13221(statusId, onFound, null), 3, null);
    }

    public final Owner owner() {
        return (Owner) this.statusRepository.getOwner().invoke();
    }

    public final te.h ownerLastStatus() {
        return this.statusRepository.ownerLastStatus();
    }

    public final te.h statusCount() {
        return this.statusRepository.otherStatusCount();
    }

    public final void updateClosed() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13231(null), 3, null);
    }
}
