package cu.todus.android.rest.linkedDevice;

import ab.e;
import cu.todus.android.constants.Service;
import cu.todus.android.data.rest.request.LinkedDeviceLogoutRequest;
import cu.todus.android.data.rest.response.LinkedDeviceLoginResponse;
import cu.todus.android.data.rest.response.LinkedDevicesResponse;
import kotlin.Metadata;
import mi.a0;
import oi.a;
import oi.f;
import oi.o;
import oi.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0004\b\t\u0010\nJ\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/rest/linkedDevice/LinkedDeviceService;", "", "Lmi/a0;", "Lcu/todus/android/data/rest/response/LinkedDevicesResponse;", "getLinkedDevices", "(Lab/e;)Ljava/lang/Object;", "", "url", "Lcu/todus/android/data/rest/response/LinkedDeviceLoginResponse;", "linkDevice", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/rest/request/LinkedDeviceLogoutRequest;", "logoutRequest", "logoutDevice", "(Lcu/todus/android/data/rest/request/LinkedDeviceLogoutRequest;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface LinkedDeviceService {
    @f(Service.Endpoint.LINKED_DEVICES_LIST)
    Object getLinkedDevices(e<? super a0<LinkedDevicesResponse>> eVar);

    @f
    Object linkDevice(@y String str, e<? super a0<LinkedDeviceLoginResponse>> eVar);

    @o("logout")
    Object logoutDevice(@a LinkedDeviceLogoutRequest linkedDeviceLogoutRequest, e<? super a0<Object>> eVar);
}
