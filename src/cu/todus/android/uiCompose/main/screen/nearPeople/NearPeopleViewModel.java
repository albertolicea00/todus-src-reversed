package cu.todus.android.uiCompose.main.screen.nearPeople;

import android.location.Location;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.location.LocationDataSource;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.pagingSource.ResultPagingSource;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\u0003J\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R#\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001e0!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/nearPeople/NearPeopleViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Landroid/location/Location;", "currentPosition", "()Landroid/location/Location;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "Lua/k0;", "loadNearStatus", "", "newValue", "changeNearState", "(Z)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Landroidx/paging/PagingConfig;", "nearPagingConfig", "Landroidx/paging/PagingConfig;", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/NearPartner;", "nearPeople", "Lte/h;", "getNearPeople", "()Lte/h;", "Lte/b0;", "Lcu/todus/android/data/wrapper/FlowsState;", "_nearActive", "Lte/b0;", "Lte/p0;", "nearActive", "Lte/p0;", "getNearActive", "()Lte/p0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NearPeopleViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _nearActive;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final p0 nearActive;
    private final PagingConfig nearPagingConfig;
    private final te.h nearPeople;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleViewModel$changeNearState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleViewModel$changeNearState$1", f = "NearPeopleViewModel.kt", l = {74, 80, TypedValues.TYPE_TARGET}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ boolean $newValue;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$newValue = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(NearPeopleViewModel nearPeopleViewModel) {
            nearPeopleViewModel.changeNearState(true);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return NearPeopleViewModel.this.new AnonymousClass1(this.$newValue, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0054  */
        /* JADX WARN: Code duplicated, block: B:21:0x005c  */
        /* JADX WARN: Code duplicated, block: B:25:0x0093  */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
        
            if (r13 == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00d2, code lost:
        
            if (r13 == r0) goto L28;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleViewModel$loadNearStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleViewModel$loadNearStatus$1", f = "NearPeopleViewModel.kt", l = {58}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12951 extends cb.m implements Function1 {
        int label;

        public C12951(ab.e<? super C12951> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return NearPeopleViewModel.this.new C12951(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12951) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                NearPeopleViewModel.this._nearActive.setValue(FlowsState.INSTANCE.loading());
                MainRepository mainRepository = NearPeopleViewModel.this.mainRepository;
                this.label = 1;
                obj = mainRepository.getNearStatus(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                NearPeopleViewModel.this._nearActive.setValue(FlowsState.INSTANCE.success(bool));
            } else {
                NearPeopleViewModel.this._nearActive.setValue(FlowsState.INSTANCE.error("", cb.b.a(false)));
            }
            return k0.f43947a;
        }
    }

    public NearPeopleViewModel() {
        PagingConfig pagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
        this.nearPagingConfig = pagingConfig;
        this.nearPeople = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.nearPeople.p
            @Override // lb.a
            public final Object invoke() {
                return NearPeopleViewModel.nearPeople$lambda$0(this.f26681c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
        b0 b0VarA = r0.a(FlowsState.INSTANCE.notRequested());
        this._nearActive = b0VarA;
        this.nearActive = te.j.b(b0VarA);
        loadNearStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Location currentPosition() {
        return LocationDataSource.INSTANCE.getInstance().currentLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource nearPeople$lambda$0(NearPeopleViewModel nearPeopleViewModel) {
        return new ResultPagingSource(new NearPeopleViewModel$nearPeople$1$pagingSource$1(nearPeopleViewModel, null), nearPeopleViewModel.nearPagingConfig.pageSize);
    }

    public final void changeNearState(boolean newValue) {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(newValue, null), 3, null);
    }

    public final p0 getNearActive() {
        return this.nearActive;
    }

    public final te.h getNearPeople() {
        return this.nearPeople;
    }

    public final void loadNearStatus() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12951(null), 3, null);
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }
}
