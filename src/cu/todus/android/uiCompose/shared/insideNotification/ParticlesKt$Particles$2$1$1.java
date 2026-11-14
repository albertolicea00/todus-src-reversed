package cu.todus.android.uiCompose.shared.insideNotification;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import ua.k0;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ParticlesKt$Particles$2$1$1 implements MeasurePolicy {
    final /* synthetic */ State<Integer> $height$delegate;
    final /* synthetic */ List<ParticleModel> $particles;

    public ParticlesKt$Particles$2$1$1(State<Integer> state, List<ParticleModel> list) {
        this.$height$delegate = state;
        this.$particles = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 measure_3p2s80s$lambda$1(List list, List list2, long j10, State state, Placeable.PlacementScope layout) {
        y.i(layout, "$this$layout");
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                w.x();
            }
            ParticleModel particleModel = (ParticleModel) list2.get(i10);
            Placeable.PlacementScope.placeRelative$default(layout, (Placeable) obj, ((int) (particleModel.getHorizontalFraction() * Constraints.m8788getMaxWidthimpl(j10))) - (Constraints.m8788getMaxWidthimpl(j10) / 2), ((int) (particleModel.getVerticalFraction() * ParticlesKt.Particles$lambda$1$4(state))) - (ParticlesKt.Particles$lambda$1$4(state) / 2), 0.0f, 4, null);
            i10 = i11;
        }
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* bridge */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10) {
        return androidx.compose.ui.layout.h.a(this, intrinsicMeasureScope, list, i10);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* bridge */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10) {
        return androidx.compose.ui.layout.h.b(this, intrinsicMeasureScope, list, i10);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo983measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, final long j10) {
        y.i(Layout, "$this$Layout");
        y.i(measurables, "measurables");
        final ArrayList arrayList = new ArrayList(x.y(measurables, 10));
        Iterator<T> it = measurables.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo7200measureBRTryo0(j10));
        }
        int iM8788getMaxWidthimpl = Constraints.m8788getMaxWidthimpl(j10);
        int iParticles$lambda$1$4 = ParticlesKt.Particles$lambda$1$4(this.$height$delegate);
        final List<ParticleModel> list = this.$particles;
        final State<Integer> state = this.$height$delegate;
        return MeasureScope.CC.s(Layout, iM8788getMaxWidthimpl, iParticles$lambda$1$4, null, new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ParticlesKt$Particles$2$1$1.measure_3p2s80s$lambda$1(arrayList, list, j10, state, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* bridge */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10) {
        return androidx.compose.ui.layout.h.c(this, intrinsicMeasureScope, list, i10);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* bridge */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10) {
        return androidx.compose.ui.layout.h.d(this, intrinsicMeasureScope, list, i10);
    }
}
