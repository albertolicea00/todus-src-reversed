package cu.z17.views.imageEditor.sections.cropper.components.widget;

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
import va.g0;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class GridImageLayoutKt$ImageDrawLayout$measurePolicy$1$1 implements MeasurePolicy {
    final /* synthetic */ int $itemCount;
    final /* synthetic */ int $spacePx;

    public GridImageLayoutKt$ImageDrawLayout$measurePolicy$1$1(int i10, int i11) {
        this.$itemCount = i10;
        this.$spacePx = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 measure_3p2s80s$lambda$5(int i10, List list, int i11, Placeable.PlacementScope layout) {
        y.i(layout, "$this$layout");
        if (i10 == 1) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Placeable.PlacementScope.placeRelative$default(layout, (Placeable) it.next(), 0, 0, 0.0f, 4, null);
            }
        } else if (i10 != 2) {
            int width = 0;
            int height = 0;
            int i12 = 0;
            for (Object obj : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    w.x();
                }
                Placeable placeable = (Placeable) obj;
                Placeable.PlacementScope.placeRelative$default(layout, placeable, width, height, 0.0f, 4, null);
                int i14 = i12 % 2;
                width = i14 == 0 ? width + placeable.getWidth() + i11 : 0;
                if (i14 == 1) {
                    height += placeable.getHeight() + i11;
                }
                i12 = i13;
            }
        } else {
            Iterator it2 = list.iterator();
            int width2 = 0;
            while (it2.hasNext()) {
                Placeable placeable2 = (Placeable) it2.next();
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, width2, 0, 0.0f, 4, null);
                width2 += placeable2.getWidth() + i11;
            }
        }
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10) {
        return androidx.compose.ui.layout.h.a(this, intrinsicMeasureScope, list, i10);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10) {
        return androidx.compose.ui.layout.h.b(this, intrinsicMeasureScope, list, i10);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo983measure3p2s80s(MeasureScope MeasurePolicy, List<? extends Measurable> measurables, long j10) {
        long jM8798fixedJhjzzOo;
        final List listW0;
        y.i(MeasurePolicy, "$this$MeasurePolicy");
        y.i(measurables, "measurables");
        int i10 = this.$itemCount;
        if (i10 != 1) {
            jM8798fixedJhjzzOo = i10 != 2 ? Constraints.INSTANCE.m8798fixedJhjzzOo((Constraints.m8788getMaxWidthimpl(j10) / 2) - (this.$spacePx / 2), (Constraints.m8787getMaxHeightimpl(j10) / 2) - (this.$spacePx / 2)) : Constraints.INSTANCE.m8798fixedJhjzzOo((Constraints.m8788getMaxWidthimpl(j10) / 2) - (this.$spacePx / 2), Constraints.m8787getMaxHeightimpl(j10));
        } else {
            jM8798fixedJhjzzOo = j10;
        }
        if (measurables.size() != 3) {
            listW0 = new ArrayList(x.y(measurables, 10));
            Iterator<T> it = measurables.iterator();
            while (it.hasNext()) {
                listW0.add(((Measurable) it.next()).mo7200measureBRTryo0(jM8798fixedJhjzzOo));
            }
        } else {
            List listG1 = g0.g1(measurables, 2);
            ArrayList arrayList = new ArrayList(x.y(listG1, 10));
            Iterator it2 = listG1.iterator();
            while (it2.hasNext()) {
                arrayList.add(((Measurable) it2.next()).mo7200measureBRTryo0(jM8798fixedJhjzzOo));
            }
            listW0 = g0.W0(arrayList, ((Measurable) g0.I0(measurables)).mo7200measureBRTryo0(Constraints.INSTANCE.m8798fixedJhjzzOo(Constraints.m8788getMaxWidthimpl(j10), (Constraints.m8787getMaxHeightimpl(j10) / 2) - this.$spacePx)));
        }
        int iM8788getMaxWidthimpl = Constraints.m8788getMaxWidthimpl(j10);
        int iM8787getMaxHeightimpl = Constraints.m8787getMaxHeightimpl(j10);
        final int i11 = this.$itemCount;
        final int i12 = this.$spacePx;
        return MeasureScope.CC.s(MeasurePolicy, iM8788getMaxWidthimpl, iM8787getMaxHeightimpl, null, new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GridImageLayoutKt$ImageDrawLayout$measurePolicy$1$1.measure_3p2s80s$lambda$5(i11, listW0, i12, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10) {
        return androidx.compose.ui.layout.h.c(this, intrinsicMeasureScope, list, i10);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10) {
        return androidx.compose.ui.layout.h.d(this, intrinsicMeasureScope, list, i10);
    }
}
