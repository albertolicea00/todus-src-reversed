package cu.todus.android.repositories;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import cu.todus.android.data.rest.request.LinkedDeviceLogoutRequest;
import cu.todus.android.data.rest.response.LinkedDeviceLoginResponse;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.db.dao.toDus.LinkedDeviceDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0006\u0010\u0010\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0011\u0010\u000fJ\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0004\b\u001a\u0010\u001bR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcu/todus/android/repositories/LinkedDeviceRepository;", "", "Lkotlin/Function1;", "Lcu/todus/android/exceptions/ToDusException;", "Lua/k0;", "setError", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getLinkedDevices", "(Lab/e;)Ljava/lang/Object;", "", "url", "Lcu/todus/android/data/wrapper/DataWrapper;", "Lcu/todus/android/data/rest/response/LinkedDeviceLoginResponse;", "linkDevice", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "sessionId", "logoutDevice", "Lcu/todus/android/data/db/entity/toDus/LinkedDevice;", "linkedDevice", "", "saveLinkedDevice", "(Lcu/todus/android/data/db/entity/toDus/LinkedDevice;Lab/e;)Ljava/lang/Object;", "deleteLinkedDevice", "Landroidx/paging/PagingSource;", "", "getAllLinkedDevice", "()Landroidx/paging/PagingSource;", "Lkotlin/jvm/functions/Function1;", "getSetError", "()Lkotlin/jvm/functions/Function1;", "Lcu/todus/android/rest/linkedDevice/LinkedDeviceDataSource;", "linkedDeviceDataSource", "Lcu/todus/android/rest/linkedDevice/LinkedDeviceDataSource;", "Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "linkedDeviceDao", "Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LinkedDeviceRepository {
    private final LinkedDeviceDao linkedDeviceDao;
    private final LinkedDeviceDataSource linkedDeviceDataSource;
    private final Function1 setError;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/LinkedDeviceRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/LinkedDeviceRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<LinkedDeviceRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.LinkedDeviceRepository$getLinkedDevices$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.LinkedDeviceRepository", f = "LinkedDeviceRepository.kt", l = {24, 27, 28}, m = "getLinkedDevices", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LinkedDeviceRepository.this.getLinkedDevices(this);
        }
    }

    public LinkedDeviceRepository(Function1 setError) {
        kotlin.jvm.internal.y.i(setError, "setError");
        this.setError = setError;
        this.linkedDeviceDataSource = RetrofitModule.INSTANCE.getInstance().getLinkedDeviceDataSource();
        this.linkedDeviceDao = DatabaseModule.INSTANCE.getInstance().getLinkedDeviceDao();
    }

    public final Object deleteLinkedDevice(LinkedDevice linkedDevice, ab.e<? super ua.k0> eVar) {
        Object objDelete = this.linkedDeviceDao.delete(linkedDevice, eVar);
        return objDelete == bb.b.g() ? objDelete : ua.k0.f43947a;
    }

    public final PagingSource<Integer, LinkedDevice> getAllLinkedDevice() {
        return this.linkedDeviceDao.getAll();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        if (r7.insert(r4, r0) == r1) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getLinkedDevices(ab.e<? super ua.k0> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cu.todus.android.repositories.LinkedDeviceRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.repositories.LinkedDeviceRepository$getLinkedDevices$1 r0 = (cu.todus.android.repositories.LinkedDeviceRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.LinkedDeviceRepository$getLinkedDevices$1 r0 = new cu.todus.android.repositories.LinkedDeviceRepository$getLinkedDevices$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L43
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.L$0
            cu.todus.android.data.wrapper.DataWrapper r0 = (cu.todus.android.data.wrapper.DataWrapper) r0
            ua.v.b(r7)
            goto L86
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3b:
            java.lang.Object r2 = r0.L$0
            cu.todus.android.data.wrapper.DataWrapper r2 = (cu.todus.android.data.wrapper.DataWrapper) r2
            ua.v.b(r7)
            goto L6b
        L43:
            ua.v.b(r7)
            goto L55
        L47:
            ua.v.b(r7)
            cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource r7 = r6.linkedDeviceDataSource
            r0.label = r5
            java.lang.Object r7 = r7.getLinkedDevices(r0)
            if (r7 != r1) goto L55
            goto L85
        L55:
            r2 = r7
            cu.todus.android.data.wrapper.DataWrapper r2 = (cu.todus.android.data.wrapper.DataWrapper) r2
            java.lang.Object r7 = r2.getResponseBody()
            if (r7 == 0) goto L89
            cu.todus.android.db.dao.toDus.LinkedDeviceDao r7 = r6.linkedDeviceDao
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.cleanTable(r0)
            if (r7 != r1) goto L6b
            goto L85
        L6b:
            cu.todus.android.db.dao.toDus.LinkedDeviceDao r7 = r6.linkedDeviceDao
            java.lang.Object r4 = r2.getResponseBody()
            cu.todus.android.data.rest.response.LinkedDevicesResponse r4 = (cu.todus.android.data.rest.response.LinkedDevicesResponse) r4
            java.util.List r4 = r4.getSessions()
            java.lang.Object r2 = cb.l.a(r2)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.insert(r4, r0)
            if (r7 != r1) goto L86
        L85:
            return r1
        L86:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        L89:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.LinkedDeviceRepository.getLinkedDevices(ab.e):java.lang.Object");
    }

    public final Function1 getSetError() {
        return this.setError;
    }

    public final Object linkDevice(String str, ab.e<? super DataWrapper<LinkedDeviceLoginResponse>> eVar) {
        return this.linkedDeviceDataSource.linkDevice(str, eVar);
    }

    public final Object logoutDevice(String str, ab.e<? super DataWrapper<Object>> eVar) {
        return this.linkedDeviceDataSource.logoutDevice(new LinkedDeviceLogoutRequest(str), eVar);
    }

    public final Object saveLinkedDevice(LinkedDevice linkedDevice, ab.e<? super Long> eVar) {
        return this.linkedDeviceDao.insert(linkedDevice, eVar);
    }
}
