package cu.z17.views.permission;

import android.os.Build;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.permission.Z17PermissionRequesterKt$Z17PermissionChecker$3$1", f = "Z17PermissionRequester.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17PermissionRequesterKt$Z17PermissionChecker$3$1 extends cb.m implements Function2 {
    final /* synthetic */ c1.a $callPermissionsState;
    final /* synthetic */ c1.a $cameraPermissionsState;
    final /* synthetic */ c1.a $contactPermissionsState;
    final /* synthetic */ c1.a $locationPermissionsState;
    final /* synthetic */ c1.a $mediaPermissionsState;
    final /* synthetic */ c1.a $notificationsPermissionsState;
    final /* synthetic */ Function1 $onResult;
    final /* synthetic */ PermissionsRequesterState $permissionState;
    final /* synthetic */ c1.a $readSmsPermissionsState;
    final /* synthetic */ c1.a $recordPermissionsState;
    final /* synthetic */ boolean $storageForApi30OrAbove;
    final /* synthetic */ c1.a $storagePermissionState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17PermissionRequesterKt$Z17PermissionChecker$3$1(PermissionsRequesterState permissionsRequesterState, Function1 function1, c1.a aVar, c1.a aVar2, c1.a aVar3, boolean z10, c1.a aVar4, c1.a aVar5, c1.a aVar6, c1.a aVar7, c1.a aVar8, c1.a aVar9, ab.e<? super Z17PermissionRequesterKt$Z17PermissionChecker$3$1> eVar) {
        super(2, eVar);
        this.$permissionState = permissionsRequesterState;
        this.$onResult = function1;
        this.$contactPermissionsState = aVar;
        this.$storagePermissionState = aVar2;
        this.$mediaPermissionsState = aVar3;
        this.$storageForApi30OrAbove = z10;
        this.$locationPermissionsState = aVar4;
        this.$readSmsPermissionsState = aVar5;
        this.$callPermissionsState = aVar6;
        this.$recordPermissionsState = aVar7;
        this.$cameraPermissionsState = aVar8;
        this.$notificationsPermissionsState = aVar9;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new Z17PermissionRequesterKt$Z17PermissionChecker$3$1(this.$permissionState, this.$onResult, this.$contactPermissionsState, this.$storagePermissionState, this.$mediaPermissionsState, this.$storageForApi30OrAbove, this.$locationPermissionsState, this.$readSmsPermissionsState, this.$callPermissionsState, this.$recordPermissionsState, this.$cameraPermissionsState, this.$notificationsPermissionsState, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        List<PermissionNeedIt> permissions = this.$permissionState.getPermissions();
        c1.a aVar = this.$contactPermissionsState;
        c1.a aVar2 = this.$storagePermissionState;
        c1.a aVar3 = this.$mediaPermissionsState;
        boolean z10 = this.$storageForApi30OrAbove;
        c1.a aVar4 = this.$locationPermissionsState;
        c1.a aVar5 = this.$readSmsPermissionsState;
        c1.a aVar6 = this.$callPermissionsState;
        c1.a aVar7 = this.$recordPermissionsState;
        c1.a aVar8 = this.$cameraPermissionsState;
        c1.a aVar9 = this.$notificationsPermissionsState;
        boolean z11 = true;
        for (PermissionNeedIt permissionNeedIt : permissions) {
            if (permissionNeedIt == PermissionNeedIt.CONTACT && !aVar.a()) {
                z11 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.STORAGE && (!aVar2.a() || !aVar3.a() || !z10)) {
                z11 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.LOCATION && !aVar4.a()) {
                z11 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.READ_SMS && !aVar5.a()) {
                z11 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.CALLS && !aVar6.a()) {
                z11 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.RECORD_AUDIO && !aVar7.a()) {
                z11 = false;
            }
            if (permissionNeedIt == PermissionNeedIt.CAMERA && !aVar8.a()) {
                z11 = false;
            }
            if (Build.VERSION.SDK_INT >= 33 && permissionNeedIt == PermissionNeedIt.NOTIFICATIONS && !aVar9.a()) {
                z11 = false;
            }
        }
        if (z11) {
            this.$onResult.invoke(PermissionsResult.INSTANCE.granted());
        } else {
            this.$onResult.invoke(PermissionsResult.INSTANCE.notGranted());
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((Z17PermissionRequesterKt$Z17PermissionChecker$3$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
