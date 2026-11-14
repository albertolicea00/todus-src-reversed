package cu.todus.android.uiCompose.main.screen.linkedDevice;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.LinkedDeviceRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.xmpp.extension.event.ExtensionEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.y;
import te.b0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0003J'\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000e0\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0005\u0010\u001cR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/linkedDevice/LinkedDeviceViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lua/k0;", "getLinkedDevices", "", "url", "linkNewDevice", "(Ljava/lang/String;)V", "logoutDevice", "Lcu/todus/android/exceptions/ToDusException;", ExtensionEvent.TAG_END, "Lsb/n;", "Lkotlin/Function1;", "setError", "(Lcu/todus/android/exceptions/ToDusException;)Lsb/n;", "Landroidx/paging/PagingConfig;", "pagerConfigs", "Landroidx/paging/PagingConfig;", "Lcu/todus/android/repositories/LinkedDeviceRepository;", "linkedDeviceRepository", "Lcu/todus/android/repositories/LinkedDeviceRepository;", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/entity/toDus/LinkedDevice;", "linkedDevices", "Lte/h;", "()Lte/h;", "Lte/b0;", "actualDevice", "Lte/b0;", "getActualDevice", "()Lte/b0;", "setActualDevice", "(Lte/b0;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LinkedDeviceViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private b0 actualDevice;
    private final LinkedDeviceRepository linkedDeviceRepository;
    private final te.h linkedDevices;
    private final PagingConfig pagerConfigs;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel$getLinkedDevices$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel$getLinkedDevices$1", f = "LinkedDeviceViewModel.kt", l = {40}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return LinkedDeviceViewModel.this.new AnonymousClass1(eVar);
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
                LinkedDeviceRepository linkedDeviceRepository = LinkedDeviceViewModel.this.linkedDeviceRepository;
                this.label = 1;
                if (linkedDeviceRepository.getLinkedDevices(this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel$linkNewDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel$linkNewDevice$1", f = "LinkedDeviceViewModel.kt", l = {46, 57}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12901 extends cb.m implements Function1 {
        final /* synthetic */ String $url;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12901(String str, ab.e<? super C12901> eVar) {
            super(1, eVar);
            this.$url = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(LinkedDeviceViewModel linkedDeviceViewModel, String str) {
            linkedDeviceViewModel.linkNewDevice(str);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return LinkedDeviceViewModel.this.new C12901(this.$url, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12901) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x00ae, code lost:
        
            if (r1.saveLinkedDevice(r3, r13) == r0) goto L17;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 263
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.C12901.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel$logoutDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel$logoutDevice$1", f = "LinkedDeviceViewModel.kt", l = {76, 79}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12911 extends cb.m implements Function1 {
        Object L$0;
        int label;

        public C12911(ab.e<? super C12911> eVar) {
            super(1, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(LinkedDeviceViewModel linkedDeviceViewModel) {
            linkedDeviceViewModel.logoutDevice();
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return LinkedDeviceViewModel.this.new C12911(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12911) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x007c, code lost:
        
            if (r1.deleteLinkedDevice(r3, r12) == r0) goto L17;
         */
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
                r3 = 1
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r12.L$0
                cu.todus.android.data.wrapper.DataWrapper r0 = (cu.todus.android.data.wrapper.DataWrapper) r0
                ua.v.b(r13)
                goto Laf
            L17:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1f:
                ua.v.b(r13)
                goto L45
            L23:
                ua.v.b(r13)
                cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel r13 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.this
                cu.todus.android.repositories.LinkedDeviceRepository r13 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.access$getLinkedDeviceRepository$p(r13)
                cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel r1 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.this
                te.b0 r1 = r1.getActualDevice()
                java.lang.Object r1 = r1.getValue()
                cu.todus.android.data.db.entity.toDus.LinkedDevice r1 = (cu.todus.android.data.db.entity.toDus.LinkedDevice) r1
                java.lang.String r1 = r1.getId()
                r12.label = r3
                java.lang.Object r13 = r13.logoutDevice(r1, r12)
                if (r13 != r0) goto L45
                goto L7e
            L45:
                cu.todus.android.data.wrapper.DataWrapper r13 = (cu.todus.android.data.wrapper.DataWrapper) r13
                java.lang.Throwable r1 = r13.getThrowable()
                if (r1 != 0) goto L7f
                cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel r1 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.this
                cu.todus.android.repositories.LinkedDeviceRepository r1 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.access$getLinkedDeviceRepository$p(r1)
                cu.todus.android.data.db.entity.toDus.LinkedDevice r3 = new cu.todus.android.data.db.entity.toDus.LinkedDevice
                cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel r4 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.this
                te.b0 r4 = r4.getActualDevice()
                java.lang.Object r4 = r4.getValue()
                cu.todus.android.data.db.entity.toDus.LinkedDevice r4 = (cu.todus.android.data.db.entity.toDus.LinkedDevice) r4
                java.lang.String r4 = r4.getId()
                r10 = 30
                r11 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r9 = 0
                r3.<init>(r4, r5, r6, r7, r9, r10, r11)
                java.lang.Object r13 = cb.l.a(r13)
                r12.L$0 = r13
                r12.label = r2
                java.lang.Object r13 = r1.deleteLinkedDevice(r3, r12)
                if (r13 != r0) goto Laf
            L7e:
                return r0
            L7f:
                cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel r13 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.this
                cu.todus.android.repositories.LinkedDeviceRepository r13 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.access$getLinkedDeviceRepository$p(r13)
                kotlin.jvm.functions.Function1 r13 = r13.getSetError()
                cu.todus.android.exceptions.ToDusException r0 = new cu.todus.android.exceptions.ToDusException
                cu.todus.android.di.MainModule$Companion r1 = cu.todus.android.di.MainModule.INSTANCE
                java.lang.Object r1 = r1.getInstance()
                cu.todus.android.di.MainModule r1 = (cu.todus.android.di.MainModule) r1
                android.content.Context r1 = r1.getAppContext()
                int r2 = cu.todus.android.R.string.cant_close_session
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r2 = "getString(...)"
                kotlin.jvm.internal.y.h(r1, r2)
                cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel r2 = cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.this
                cu.todus.android.uiCompose.main.screen.linkedDevice.t r4 = new cu.todus.android.uiCompose.main.screen.linkedDevice.t
                r4.<init>()
                r0.<init>(r1, r4, r3)
                r13.invoke(r0)
            Laf:
                ua.k0 r13 = ua.k0.f43947a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.C12911.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public LinkedDeviceViewModel() {
        PagingConfig pagingConfig = new PagingConfig(30, 30, true, 70, Integer.MAX_VALUE, 0, 32, null);
        this.pagerConfigs = pagingConfig;
        this.linkedDeviceRepository = LinkedDeviceRepository.INSTANCE.getInstance();
        this.linkedDevices = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.r
            @Override // lb.a
            public final Object invoke() {
                return LinkedDeviceViewModel.linkedDevices$lambda$0(this.f26562c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
        this.actualDevice = r0.a(new LinkedDevice(null, null, null, 0L, 0, 31, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource linkedDevices$lambda$0(LinkedDeviceViewModel linkedDeviceViewModel) {
        return linkedDeviceViewModel.linkedDeviceRepository.getAllLinkedDevice();
    }

    public final b0 getActualDevice() {
        return this.actualDevice;
    }

    public final te.h getLinkedDevices() {
        return this.linkedDevices;
    }

    public final void linkNewDevice(String url) {
        y.i(url, "url");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12901(url, null), 3, null);
    }

    public final void logoutDevice() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12911(null), 3, null);
    }

    public final void setActualDevice(b0 b0Var) {
        y.i(b0Var, "<set-?>");
        this.actualDevice = b0Var;
    }

    public final sb.n setError(ToDusException e10) {
        y.i(e10, "e");
        return new o0(this.linkedDeviceRepository) { // from class: cu.todus.android.uiCompose.main.screen.linkedDevice.LinkedDeviceViewModel.setError.1
            @Override // kotlin.jvm.internal.o0, sb.n
            public Object get() {
                return ((LinkedDeviceRepository) this.receiver).getSetError();
            }
        };
    }

    /* JADX INFO: renamed from: getLinkedDevices, reason: collision with other method in class */
    public final void m9939getLinkedDevices() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
