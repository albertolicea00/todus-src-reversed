package cu.z17.views.permission;

import android.os.Build;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.permission.Z17PermissionRequesterKt$Z17PermissionContainer$2$1", f = "Z17PermissionRequester.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17PermissionRequesterKt$Z17PermissionContainer$2$1 extends cb.m implements Function2 {
    final /* synthetic */ PermissionsResult $actualResult;
    final /* synthetic */ c1.a $callPermissionsState;
    final /* synthetic */ c1.a $cameraPermissionsState;
    final /* synthetic */ c1.a $contactPermissionsState;
    final /* synthetic */ c1.a $locationPermissionsState;
    final /* synthetic */ c1.a $mediaPermissionsState;
    final /* synthetic */ c1.a $notificationsPermissionsState;
    final /* synthetic */ Function1 $onResult;
    final /* synthetic */ List<PermissionNeedIt> $permissions;
    final /* synthetic */ c1.a $readSmsPermissionsState;
    final /* synthetic */ c1.a $recordPermissionsState;
    final /* synthetic */ boolean $storageForApi30OrAbove;
    final /* synthetic */ c1.a $storagePermissionState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Z17PermissionRequesterKt$Z17PermissionContainer$2$1(List<? extends PermissionNeedIt> list, c1.a aVar, boolean z10, c1.a aVar2, c1.a aVar3, c1.a aVar4, c1.a aVar5, c1.a aVar6, c1.a aVar7, c1.a aVar8, c1.a aVar9, PermissionsResult permissionsResult, Function1 function1, ab.e<? super Z17PermissionRequesterKt$Z17PermissionContainer$2$1> eVar) {
        super(2, eVar);
        this.$permissions = list;
        this.$storagePermissionState = aVar;
        this.$storageForApi30OrAbove = z10;
        this.$mediaPermissionsState = aVar2;
        this.$contactPermissionsState = aVar3;
        this.$locationPermissionsState = aVar4;
        this.$readSmsPermissionsState = aVar5;
        this.$callPermissionsState = aVar6;
        this.$recordPermissionsState = aVar7;
        this.$cameraPermissionsState = aVar8;
        this.$notificationsPermissionsState = aVar9;
        this.$actualResult = permissionsResult;
        this.$onResult = function1;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new Z17PermissionRequesterKt$Z17PermissionContainer$2$1(this.$permissions, this.$storagePermissionState, this.$storageForApi30OrAbove, this.$mediaPermissionsState, this.$contactPermissionsState, this.$locationPermissionsState, this.$readSmsPermissionsState, this.$callPermissionsState, this.$recordPermissionsState, this.$cameraPermissionsState, this.$notificationsPermissionsState, this.$actualResult, this.$onResult, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        boolean z10;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        List<PermissionNeedIt> list = this.$permissions;
        c1.a aVar = this.$contactPermissionsState;
        c1.a aVar2 = this.$storagePermissionState;
        c1.a aVar3 = this.$mediaPermissionsState;
        boolean z11 = this.$storageForApi30OrAbove;
        c1.a aVar4 = this.$locationPermissionsState;
        c1.a aVar5 = this.$readSmsPermissionsState;
        c1.a aVar6 = this.$callPermissionsState;
        c1.a aVar7 = this.$recordPermissionsState;
        c1.a aVar8 = this.$cameraPermissionsState;
        c1.a aVar9 = this.$notificationsPermissionsState;
        Iterator<T> it = list.iterator();
        boolean z12 = true;
        while (true) {
            z10 = false;
            if (!it.hasNext()) {
                break;
            }
            PermissionNeedIt permissionNeedIt = (PermissionNeedIt) it.next();
            if (permissionNeedIt == PermissionNeedIt.CONTACT && !aVar.a()) {
                z12 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.STORAGE && (!aVar2.a() || !aVar3.a() || !z11)) {
                z12 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.LOCATION && !aVar4.a()) {
                z12 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.READ_SMS && !aVar5.a()) {
                z12 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.CALLS && !aVar6.a()) {
                z12 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.RECORD_AUDIO && !aVar7.a()) {
                z12 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.CAMERA && !aVar8.a()) {
                z12 = false;
            }
            if (Build.VERSION.SDK_INT >= 33 && permissionNeedIt == PermissionNeedIt.NOTIFICATIONS && !aVar9.a()) {
                z12 = false;
            }
        }
        Log.i("PERMISSIONS", "===================================");
        Log.i("PERMISSION => STORAGE: ", String.valueOf(this.$storagePermissionState.a() && this.$storageForApi30OrAbove && this.$mediaPermissionsState.a()));
        Log.i("PERMISSION => CONTACT: ", String.valueOf(this.$contactPermissionsState.a()));
        Log.i("PERMISSION => LOC: ", String.valueOf(this.$locationPermissionsState.a()));
        Log.i("PERMISSION => SMS: ", String.valueOf(this.$readSmsPermissionsState.a()));
        Log.i("PERMISSION => CALL: ", String.valueOf(this.$callPermissionsState.a()));
        Log.i("PERMISSION => REC: ", String.valueOf(this.$recordPermissionsState.a()));
        Log.i("PERMISSION => CAM: ", String.valueOf(this.$cameraPermissionsState.a()));
        int i10 = Build.VERSION.SDK_INT;
        Log.i("PERMISSION => NOT: ", String.valueOf(i10 >= 33 ? this.$notificationsPermissionsState.a() : true));
        if (this.$storagePermissionState.c() && this.$mediaPermissionsState.c()) {
            z10 = true;
        }
        Log.i("RATIONALE => STORAGE: ", String.valueOf(z10));
        Log.i("RATIONALE => CONTACT: ", String.valueOf(this.$contactPermissionsState.c()));
        Log.i("RATIONALE => LOC: ", String.valueOf(this.$locationPermissionsState.c()));
        Log.i("RATIONALE => SMS: ", String.valueOf(this.$readSmsPermissionsState.c()));
        Log.i("RATIONALE => CALL: ", String.valueOf(this.$callPermissionsState.c()));
        Log.i("RATIONALE => REC: ", String.valueOf(this.$recordPermissionsState.c()));
        Log.i("RATIONALE => CAM: ", String.valueOf(this.$cameraPermissionsState.c()));
        Log.i("RATIONALE => NOT: ", String.valueOf(i10 >= 33 ? this.$notificationsPermissionsState.c() : true));
        Log.i("PERMISSION Result: ", String.valueOf(z12));
        Integer state = this.$actualResult.getState();
        if (state == null || state.intValue() != 3) {
            if (z12) {
                this.$onResult.invoke(PermissionsResult.INSTANCE.granted());
            } else {
                this.$onResult.invoke(PermissionsResult.INSTANCE.notGranted());
            }
        }
        Log.i("PERMISSIONS", "===================================");
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((Z17PermissionRequesterKt$Z17PermissionContainer$2$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
