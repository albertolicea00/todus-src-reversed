package cu.todus.android.utils;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\f"}, d2 = {"Lcu/todus/android/utils/Scale;", "", "<init>", "(Ljava/lang/String;I)V", "SCALE1x1", "SCALE4x3", "SCALE16x9", "SCALE9x16", "vector", "Lkotlin/Pair;", "", "scale", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum Scale {
    SCALE1x1 { // from class: cu.todus.android.utils.Scale.SCALE1x1
        @Override // cu.todus.android.utils.Scale
        public Pair<Integer, Integer> scale() {
            return z.a(1, 1);
        }

        @Override // cu.todus.android.utils.Scale
        public Pair<Integer, Integer> vector() {
            return z.a(200, 200);
        }
    },
    SCALE4x3 { // from class: cu.todus.android.utils.Scale.SCALE4x3
        @Override // cu.todus.android.utils.Scale
        public Pair<Integer, Integer> scale() {
            return z.a(4, 3);
        }

        @Override // cu.todus.android.utils.Scale
        public Pair<Integer, Integer> vector() {
            return z.a(200, 180);
        }
    },
    SCALE16x9 { // from class: cu.todus.android.utils.Scale.SCALE16x9
        @Override // cu.todus.android.utils.Scale
        public Pair<Integer, Integer> scale() {
            return z.a(16, 9);
        }

        @Override // cu.todus.android.utils.Scale
        public Pair<Integer, Integer> vector() {
            return z.a(220, 140);
        }
    },
    SCALE9x16 { // from class: cu.todus.android.utils.Scale.SCALE9x16
        @Override // cu.todus.android.utils.Scale
        public Pair<Integer, Integer> scale() {
            return z.a(9, 16);
        }

        @Override // cu.todus.android.utils.Scale
        public Pair<Integer, Integer> vector() {
            return z.a(140, 220);
        }
    };

    private static final /* synthetic */ db.a $ENTRIES = db.b.a(values());

    /* synthetic */ Scale(p pVar) {
        this();
    }

    public static db.a getEntries() {
        return $ENTRIES;
    }

    public abstract Pair<Integer, Integer> scale();

    public abstract Pair<Integer, Integer> vector();
}
