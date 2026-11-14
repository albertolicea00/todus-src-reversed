package cu.todus.android.rest.linkedDevice;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import bb.b;
import cb.f;
import cb.m;
import cu.todus.android.data.rest.request.LinkedDeviceLogoutRequest;
import cu.todus.android.data.rest.response.LinkedDeviceLoginResponse;
import cu.todus.android.data.rest.response.LinkedDevicesResponse;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.rest.BaseDataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import mi.a0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcu/todus/android/rest/linkedDevice/LinkedDeviceDataSource;", "", "Lcu/todus/android/rest/linkedDevice/LinkedDeviceService;", NotificationCompat.CATEGORY_SERVICE, "Lcu/todus/android/rest/BaseDataSource;", "baseDataSource", "<init>", "(Lcu/todus/android/rest/linkedDevice/LinkedDeviceService;Lcu/todus/android/rest/BaseDataSource;)V", "Lcu/todus/android/data/wrapper/DataWrapper;", "Lcu/todus/android/data/rest/response/LinkedDevicesResponse;", "getLinkedDevices", "(Lab/e;)Ljava/lang/Object;", "", "url", "Lcu/todus/android/data/rest/response/LinkedDeviceLoginResponse;", "linkDevice", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/rest/request/LinkedDeviceLogoutRequest;", "logoutRequest", "logoutDevice", "(Lcu/todus/android/data/rest/request/LinkedDeviceLogoutRequest;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/rest/linkedDevice/LinkedDeviceService;", "Lcu/todus/android/rest/BaseDataSource;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LinkedDeviceDataSource {
    public static final int $stable = 8;
    private final BaseDataSource baseDataSource;
    private final LinkedDeviceService service;

    /* JADX INFO: renamed from: cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource$getLinkedDevices$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource$getLinkedDevices$2", f = "LinkedDeviceDataSource.kt", l = {14}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function1 {
        int label;

        public AnonymousClass2(e<? super AnonymousClass2> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return LinkedDeviceDataSource.this.new AnonymousClass2(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            LinkedDeviceService linkedDeviceService = LinkedDeviceDataSource.this.service;
            this.label = 1;
            Object linkedDevices = linkedDeviceService.getLinkedDevices(this);
            return linkedDevices == objG ? objG : linkedDevices;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource$linkDevice$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource$linkDevice$2", f = "LinkedDeviceDataSource.kt", l = {18}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11702 extends m implements Function1 {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11702(String str, e<? super C11702> eVar) {
            super(1, eVar);
            this.$url = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return LinkedDeviceDataSource.this.new C11702(this.$url, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11702) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            LinkedDeviceService linkedDeviceService = LinkedDeviceDataSource.this.service;
            String str = this.$url;
            this.label = 1;
            Object objLinkDevice = linkedDeviceService.linkDevice(str, this);
            return objLinkDevice == objG ? objG : objLinkDevice;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource$logoutDevice$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource$logoutDevice$2", f = "LinkedDeviceDataSource.kt", l = {22}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11712 extends m implements Function1 {
        final /* synthetic */ LinkedDeviceLogoutRequest $logoutRequest;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11712(LinkedDeviceLogoutRequest linkedDeviceLogoutRequest, e<? super C11712> eVar) {
            super(1, eVar);
            this.$logoutRequest = linkedDeviceLogoutRequest;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return LinkedDeviceDataSource.this.new C11712(this.$logoutRequest, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11712) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            LinkedDeviceService linkedDeviceService = LinkedDeviceDataSource.this.service;
            LinkedDeviceLogoutRequest linkedDeviceLogoutRequest = this.$logoutRequest;
            this.label = 1;
            Object objLogoutDevice = linkedDeviceService.logoutDevice(linkedDeviceLogoutRequest, this);
            return objLogoutDevice == objG ? objG : objLogoutDevice;
        }
    }

    public LinkedDeviceDataSource(LinkedDeviceService service, BaseDataSource baseDataSource) {
        y.i(service, "service");
        y.i(baseDataSource, "baseDataSource");
        this.service = service;
        this.baseDataSource = baseDataSource;
    }

    public final Object getLinkedDevices(e<? super DataWrapper<LinkedDevicesResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new AnonymousClass2(null), eVar);
    }

    public final Object linkDevice(String str, e<? super DataWrapper<LinkedDeviceLoginResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11702(str, null), eVar);
    }

    public final Object logoutDevice(LinkedDeviceLogoutRequest linkedDeviceLogoutRequest, e<? super DataWrapper<Object>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11712(linkedDeviceLogoutRequest, null), eVar);
    }
}
