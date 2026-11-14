package cu.z17.views.videoEditor.sections.cutter;

import androidx.compose.runtime.MutableState;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.videoEditor.sections.cutter.CutterTopBarKt$CutterTopBar$1$6$1", f = "CutterTopBar.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class CutterTopBarKt$CutterTopBar$1$6$1 extends m implements Function2 {
    final /* synthetic */ rb.b $cutPoints;
    final /* synthetic */ long $forceCrop;
    final /* synthetic */ Function1 $onCutPointsChange;
    final /* synthetic */ MutableState<rb.b> $previewsCutPoints$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CutterTopBarKt$CutterTopBar$1$6$1(rb.b bVar, long j10, Function1 function1, MutableState<rb.b> mutableState, ab.e<? super CutterTopBarKt$CutterTopBar$1$6$1> eVar) {
        super(2, eVar);
        this.$cutPoints = bVar;
        this.$forceCrop = j10;
        this.$onCutPointsChange = function1;
        this.$previewsCutPoints$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new CutterTopBarKt$CutterTopBar$1$6$1(this.$cutPoints, this.$forceCrop, this.$onCutPointsChange, this.$previewsCutPoints$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        float fFloatValue = ((Number) this.$cutPoints.getStart()).floatValue() + this.$forceCrop;
        if (((Number) this.$cutPoints.getEndInclusive()).floatValue() > fFloatValue) {
            this.$previewsCutPoints$delegate.setValue(rb.j.b(((Number) this.$cutPoints.getStart()).floatValue(), fFloatValue));
            this.$onCutPointsChange.invoke(CutterTopBarKt.CutterTopBar$lambda$1(this.$previewsCutPoints$delegate));
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((CutterTopBarKt$CutterTopBar$1$6$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
