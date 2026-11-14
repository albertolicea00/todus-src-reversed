package cu.todus.android.location;

import ab.e;
import android.location.Location;
import bb.b;
import cb.f;
import cb.m;
import cu.todus.android.utils.CoroutineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import re.u;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.location.LocationDataSource$getCurrentPosition$1$2$onLocationChanged$1", f = "LocationDataSource.kt", l = {133}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class LocationDataSource$getCurrentPosition$1$2$onLocationChanged$1 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ Location $location;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationDataSource$getCurrentPosition$1$2$onLocationChanged$1(u uVar, Location location, e<? super LocationDataSource$getCurrentPosition$1$2$onLocationChanged$1> eVar) {
        super(2, eVar);
        this.$$this$callbackFlow = uVar;
        this.$location = location;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new LocationDataSource$getCurrentPosition$1$2$onLocationChanged$1(this.$$this$callbackFlow, this.$location, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            u uVar = this.$$this$callbackFlow;
            Location location = this.$location;
            this.label = 1;
            if (CoroutineUtilsKt.sendWithPrecautions(uVar, location, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        LocationDataSource.C10111.invokeSuspend$close(this.$$this$callbackFlow);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((LocationDataSource$getCurrentPosition$1$2$onLocationChanged$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
