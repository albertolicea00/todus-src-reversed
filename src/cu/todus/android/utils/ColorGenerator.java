package cu.todus.android.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0001R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcu/todus/android/utils/ColorGenerator;", "", "mColors", "", "", "<init>", "(Ljava/util/List;)V", "mRandom", "Ljava/util/Random;", "randomColor", "getRandomColor", "()J", "getColor", "key", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ColorGenerator {
    public static final int $stable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static ColorGenerator MATERIAL;
    private final List<Long> mColors;
    private final Random mRandom;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcu/todus/android/utils/ColorGenerator$Companion;", "", "<init>", "()V", "MATERIAL", "Lcu/todus/android/utils/ColorGenerator;", "getMATERIAL", "()Lcu/todus/android/utils/ColorGenerator;", "setMATERIAL", "(Lcu/todus/android/utils/ColorGenerator;)V", "create", "colorList", "", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final ColorGenerator create(List<Long> colorList) {
            y.i(colorList, "colorList");
            return new ColorGenerator(colorList, null);
        }

        public final ColorGenerator getMATERIAL() {
            return ColorGenerator.MATERIAL;
        }

        public final void setMATERIAL(ColorGenerator colorGenerator) {
            y.i(colorGenerator, "<set-?>");
            ColorGenerator.MATERIAL = colorGenerator;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        $stable = 8;
        MATERIAL = companion.create(w.q(4283215696L, 4294929811L, 4278236364L, 4293940549L, 4294940672L, 4293467747L));
    }

    public /* synthetic */ ColorGenerator(List list, p pVar) {
        this(list);
    }

    public final long getColor(Object key) {
        y.i(key, "key");
        return this.mColors.get(Math.abs(key.hashCode()) % this.mColors.size()).longValue();
    }

    public final long getRandomColor() {
        List<Long> list = this.mColors;
        return list.get(this.mRandom.nextInt(list.size())).longValue();
    }

    private ColorGenerator(List<Long> list) {
        this.mColors = list;
        this.mRandom = new Random(System.currentTimeMillis());
    }
}
