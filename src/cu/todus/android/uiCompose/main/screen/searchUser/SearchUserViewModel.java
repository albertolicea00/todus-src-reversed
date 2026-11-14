package cu.todus.android.uiCompose.main.screen.searchUser;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cb.m;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import le.d0;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/searchUser/SearchUserViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "", User.COLUMN_TODUS_ID, "Lkotlin/Function1;", "Lua/k0;", "onFound", "Lkotlin/Function0;", "onNotFound", "searchUser", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Llb/a;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchUserViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1", f = "SearchUserViewModel.kt", l = {25, 30}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ Function1 $onFound;
        final /* synthetic */ lb.a $onNotFound;
        final /* synthetic */ String $toDusId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1$1", f = "SearchUserViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02451 extends m implements Function2 {
            final /* synthetic */ lb.a $onNotFound;
            final /* synthetic */ String $toDusId;
            int label;
            final /* synthetic */ SearchUserViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02451(SearchUserViewModel searchUserViewModel, String str, lb.a aVar, ab.e<? super C02451> eVar) {
                super(2, eVar);
                this.this$0 = searchUserViewModel;
                this.$toDusId = str;
                this.$onNotFound = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02451(this.this$0, this.$toDusId, this.$onNotFound, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                if (y.d(this.this$0.getOwner().getToDusId(), this.$toDusId)) {
                    this.$onNotFound.invoke();
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02451) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1$2", f = "SearchUserViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends m implements Function2 {
            final /* synthetic */ Function1 $onFound;
            final /* synthetic */ lb.a $onNotFound;
            final /* synthetic */ y0 $user;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(y0 y0Var, Function1 function1, lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$user = y0Var;
                this.$onFound = function1;
                this.$onNotFound = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$user, this.$onFound, this.$onNotFound, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                User user = (User) this.$user.f36634c;
                if ((user != null ? user.getUid() : null) == null || d0.q0(((User) this.$user.f36634c).getUid())) {
                    this.$onNotFound.invoke();
                } else {
                    this.$onFound.invoke(((User) this.$user.f36634c).getUid());
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, lb.a aVar, Function1 function1, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$toDusId = str;
            this.$onNotFound = aVar;
            this.$onFound = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return SearchUserViewModel.this.new AnonymousClass1(this.$toDusId, this.$onNotFound, this.$onFound, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
        
            if (pe.w0.b(1000, r12) == r0) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0097 -> B:24:0x009a). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r12.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L22
                if (r1 != r2) goto L1a
                int r1 = r12.I$0
                java.lang.Object r5 = r12.L$0
                kotlin.jvm.internal.y0 r5 = (kotlin.jvm.internal.y0) r5
                ua.v.b(r13)
                goto L9a
            L1a:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L22:
                java.lang.Object r1 = r12.L$1
                kotlin.jvm.internal.y0 r1 = (kotlin.jvm.internal.y0) r1
                java.lang.Object r5 = r12.L$0
                kotlin.jvm.internal.y0 r5 = (kotlin.jvm.internal.y0) r5
                ua.v.b(r13)
                goto L67
            L2e:
                ua.v.b(r13)
                cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel r13 = cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel.this
                pe.m0 r5 = androidx.p001lifecycle.ViewModelKt.getViewModelScope(r13)
                pe.k2 r6 = pe.d1.c()
                cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1$1 r8 = new cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1$1
                cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel r13 = cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel.this
                java.lang.String r1 = r12.$toDusId
                lb.a r7 = r12.$onNotFound
                r8.<init>(r13, r1, r7, r3)
                r9 = 2
                r10 = 0
                r7 = 0
                pe.i.d(r5, r6, r7, r8, r9, r10)
                kotlin.jvm.internal.y0 r1 = new kotlin.jvm.internal.y0
                r1.<init>()
                cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel r13 = cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel.this
                cu.todus.android.repositories.MainRepository r13 = cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel.access$getMainRepository$p(r13)
                java.lang.String r5 = r12.$toDusId
                r12.L$0 = r1
                r12.L$1 = r1
                r12.label = r4
                java.lang.Object r13 = r13.getUserOrReload(r5, r12)
                if (r13 != r0) goto L66
                goto L99
            L66:
                r5 = r1
            L67:
                r1.f36634c = r13
                java.lang.Object r13 = r5.f36634c
                if (r13 != 0) goto L9c
                r13 = 0
                r1 = r13
            L6f:
                cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel r13 = cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel.this
                cu.todus.android.repositories.MainRepository r13 = cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel.access$getMainRepository$p(r13)
                te.b0 r13 = r13.getConnectionState()
                java.lang.Object r13 = r13.getValue()
                cu.todus.android.xmpp.ConnectionState r13 = (cu.todus.android.xmpp.ConnectionState) r13
                boolean r13 = r13.isConnected()
                if (r13 != 0) goto L9c
                r13 = 10
                if (r1 >= r13) goto L9c
                r12.L$0 = r5
                r12.L$1 = r3
                r12.I$0 = r1
                r12.label = r2
                r6 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r13 = pe.w0.b(r6, r12)
                if (r13 != r0) goto L9a
            L99:
                return r0
            L9a:
                int r1 = r1 + r4
                goto L6f
            L9c:
                cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel r13 = cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel.this
                pe.m0 r6 = androidx.p001lifecycle.ViewModelKt.getViewModelScope(r13)
                pe.k2 r7 = pe.d1.c()
                cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1$2 r9 = new cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel$searchUser$1$2
                kotlin.jvm.functions.Function1 r13 = r12.$onFound
                lb.a r0 = r12.$onNotFound
                r9.<init>(r5, r13, r0, r3)
                r10 = 2
                r11 = 0
                r8 = 0
                pe.i.d(r6, r7, r8, r9, r10, r11)
                ua.k0 r13 = ua.k0.f43947a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.searchUser.SearchUserViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final Owner getOwner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void searchUser(String toDusId, Function1 onFound, lb.a onNotFound) {
        y.i(toDusId, "toDusId");
        y.i(onFound, "onFound");
        y.i(onNotFound, "onNotFound");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(toDusId, onNotFound, onFound, null), 3, null);
    }
}
