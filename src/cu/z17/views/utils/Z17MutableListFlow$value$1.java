package cu.z17.views.utils;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import te.b0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.utils.Z17MutableListFlow$value$1", f = "Z17MutableListFlow.kt", l = {10}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lte/i;", "", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17MutableListFlow$value$1 extends cb.m implements Function2 {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Z17MutableListFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17MutableListFlow$value$1(Z17MutableListFlow<T> z17MutableListFlow, ab.e<? super Z17MutableListFlow$value$1> eVar) {
        super(2, eVar);
        this.this$0 = z17MutableListFlow;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        Z17MutableListFlow$value$1 z17MutableListFlow$value$1 = new Z17MutableListFlow$value$1(this.this$0, eVar);
        z17MutableListFlow$value$1.L$0 = obj;
        return z17MutableListFlow$value$1;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        final te.i iVar = (te.i) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            b0 b0Var = ((Z17MutableListFlow) this.this$0).mutableList;
            te.i iVar2 = new te.i() { // from class: cu.z17.views.utils.Z17MutableListFlow$value$1.1
                @Override // te.i
                public /* bridge */ /* synthetic */ Object emit(Object obj2, ab.e eVar) {
                    return emit((List) obj2, (ab.e<? super k0>) eVar);
                }

                public final Object emit(List<? extends T> list, ab.e<? super k0> eVar) {
                    Object objEmit = iVar.emit(list, eVar);
                    return objEmit == bb.b.g() ? objEmit : k0.f43947a;
                }
            };
            this.L$0 = cb.l.a(iVar);
            this.label = 1;
            if (b0Var.collect(iVar2, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        throw new ua.j();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(te.i iVar, ab.e<? super k0> eVar) {
        return ((Z17MutableListFlow$value$1) create(iVar, eVar)).invokeSuspend(k0.f43947a);
    }
}
