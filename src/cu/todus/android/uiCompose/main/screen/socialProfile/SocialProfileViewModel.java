package cu.todus.android.uiCompose.main.screen.socialProfile;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.pojo.Partner;
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
import kotlin.jvm.internal.y;
import pe.d1;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0014\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0016\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0018\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0018\u0010\u0017J+\u0010\u001a\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u001f\u0010\u001bR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcu/todus/android/uiCompose/main/screen/socialProfile/SocialProfileViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "", "uid", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "profileStatus", "(Ljava/lang/String;)Lte/h;", "Lkotlin/Function1;", "Lcu/todus/android/data/db/pojo/Partner;", "Lua/k0;", "onComplete", "Lkotlin/Function0;", "onError", "loadProfileData", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Llb/a;)V", "follow", "(Ljava/lang/String;Llb/a;Llb/a;)V", "unFollow", "Lcu/todus/android/data/xmpp/FollowState;", "getFollowState", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "statusId", "", "onFound", "getStatusPosition", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Landroidx/paging/PagingConfig;", "statusPagingConfig", "Landroidx/paging/PagingConfig;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SocialProfileViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final StatusRepository statusRepository = StatusRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final PagingConfig statusPagingConfig = new PagingConfig(10, 10, true, 20, Integer.MAX_VALUE, 0, 32, null);

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$follow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$follow$1", f = "SocialProfileViewModel.kt", l = {52}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$follow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$follow$1$1", f = "SocialProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02481 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02481(lb.a aVar, ab.e<? super C02481> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02481(this.$onComplete, eVar);
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
                return ((C02481) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$follow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$follow$1$2", f = "SocialProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onError.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, lb.a aVar, lb.a aVar2, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = aVar;
            this.$onError = aVar2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return SocialProfileViewModel.this.new AnonymousClass1(this.$uid, this.$onComplete, this.$onError, eVar);
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
                MainRepository mainRepository = SocialProfileViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                obj = mainRepository.follow(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            if (y.d((Boolean) obj, cb.b.a(true))) {
                pe.k.d(ViewModelKt.getViewModelScope(SocialProfileViewModel.this), d1.c(), null, new C02481(this.$onComplete, null), 2, null);
            } else {
                pe.k.d(ViewModelKt.getViewModelScope(SocialProfileViewModel.this), d1.c(), null, new AnonymousClass2(this.$onError, null), 2, null);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$getFollowState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$getFollowState$1", f = "SocialProfileViewModel.kt", l = {82}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13121 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onComplete;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$getFollowState$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$getFollowState$1$1", f = "SocialProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02491 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onComplete;
            final /* synthetic */ FollowState $response;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02491(Function1 function1, FollowState followState, ab.e<? super C02491> eVar) {
                super(2, eVar);
                this.$onComplete = function1;
                this.$response = followState;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02491(this.$onComplete, this.$response, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke(this.$response);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02491) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13121(String str, Function1 function1, ab.e<? super C13121> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return SocialProfileViewModel.this.new C13121(this.$uid, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13121) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = SocialProfileViewModel.this.mainRepository;
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
                pe.k.d(ViewModelKt.getViewModelScope(SocialProfileViewModel.this), d1.c(), null, new C02491(this.$onComplete, followState, null), 2, null);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$getStatusPosition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$getStatusPosition$1", f = "SocialProfileViewModel.kt", l = {94}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13131 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onFound;
        final /* synthetic */ String $statusId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$getStatusPosition$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$getStatusPosition$1$1", f = "SocialProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02501 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onFound;
            final /* synthetic */ Pair<Boolean, Integer> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02501(Function1 function1, Pair<Boolean, Integer> pair, ab.e<? super C02501> eVar) {
                super(2, eVar);
                this.$onFound = function1;
                this.$result = pair;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02501(this.$onFound, this.$result, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onFound.invoke(this.$result.getSecond());
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02501) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13131(String str, Function1 function1, ab.e<? super C13131> eVar) {
            super(1, eVar);
            this.$statusId = str;
            this.$onFound = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return SocialProfileViewModel.this.new C13131(this.$statusId, this.$onFound, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13131) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                StatusRepository statusRepository = SocialProfileViewModel.this.statusRepository;
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
            pe.k.d(ViewModelKt.getViewModelScope(SocialProfileViewModel.this), d1.c(), null, new C02501(this.$onFound, (Pair) obj, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$loadProfileData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$loadProfileData$1", f = "SocialProfileViewModel.kt", l = {42}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13141 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$loadProfileData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$loadProfileData$1$1", f = "SocialProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02511 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onComplete;
            final /* synthetic */ lb.a $onError;
            final /* synthetic */ Partner $possiblePartner;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02511(Partner partner, Function1 function1, lb.a aVar, ab.e<? super C02511> eVar) {
                super(2, eVar);
                this.$possiblePartner = partner;
                this.$onComplete = function1;
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02511(this.$possiblePartner, this.$onComplete, this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                Partner partner = this.$possiblePartner;
                if (partner != null) {
                    this.$onComplete.invoke(partner);
                } else {
                    this.$onError.invoke();
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02511) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13141(String str, Function1 function1, lb.a aVar, ab.e<? super C13141> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = function1;
            this.$onError = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return SocialProfileViewModel.this.new C13141(this.$uid, this.$onComplete, this.$onError, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13141) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                te.h partnerByIdFlow = SocialProfileViewModel.this.mainRepository.getPartnerByIdFlow(this.$uid);
                this.label = 1;
                obj = te.j.x(partnerByIdFlow, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(SocialProfileViewModel.this), d1.c(), null, new C02511((Partner) obj, this.$onComplete, this.$onError, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$unFollow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$unFollow$1", f = "SocialProfileViewModel.kt", l = {MdtaMetadataEntry.TYPE_INDICATOR_INT32}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13151 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$unFollow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$unFollow$1$1", f = "SocialProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02521 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02521(lb.a aVar, ab.e<? super C02521> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02521(this.$onComplete, eVar);
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
                return ((C02521) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$unFollow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileViewModel$unFollow$1$2", f = "SocialProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onError.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13151(String str, lb.a aVar, lb.a aVar2, ab.e<? super C13151> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = aVar;
            this.$onError = aVar2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return SocialProfileViewModel.this.new C13151(this.$uid, this.$onComplete, this.$onError, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13151) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = SocialProfileViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                obj = mainRepository.unFollow(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            if (y.d((Boolean) obj, cb.b.a(true))) {
                pe.k.d(ViewModelKt.getViewModelScope(SocialProfileViewModel.this), d1.c(), null, new C02521(this.$onComplete, null), 2, null);
            } else {
                pe.k.d(ViewModelKt.getViewModelScope(SocialProfileViewModel.this), d1.c(), null, new AnonymousClass2(this.$onError, null), 2, null);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource profileStatus$lambda$0(SocialProfileViewModel socialProfileViewModel, String str) {
        return socialProfileViewModel.statusRepository.profileStatus(str);
    }

    public final void follow(String uid, lb.a onComplete, lb.a onError) {
        y.i(uid, "uid");
        y.i(onComplete, "onComplete");
        y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(uid, onComplete, onError, null), 3, null);
    }

    public final void getFollowState(String uid, Function1 onComplete) {
        y.i(uid, "uid");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13121(uid, onComplete, null), 3, null);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final Owner getOwner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void getStatusPosition(String statusId, Function1 onFound) {
        y.i(statusId, "statusId");
        y.i(onFound, "onFound");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13131(statusId, onFound, null), 3, null);
    }

    public final void loadProfileData(String uid, Function1 onComplete, lb.a onError) {
        y.i(uid, "uid");
        y.i(onComplete, "onComplete");
        y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13141(uid, onComplete, onError, null), 3, null);
    }

    public final te.h profileStatus(final String uid) {
        y.i(uid, "uid");
        return CachedPagingDataKt.cachedIn(new Pager(this.statusPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.w
            @Override // lb.a
            public final Object invoke() {
                return SocialProfileViewModel.profileStatus$lambda$0(this.f27607c, uid);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void unFollow(String uid, lb.a onComplete, lb.a onError) {
        y.i(uid, "uid");
        y.i(onComplete, "onComplete");
        y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13151(uid, onComplete, onError, null), 3, null);
    }
}
