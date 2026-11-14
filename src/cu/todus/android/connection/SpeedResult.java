package cu.todus.android.connection;

import db.a;
import db.b;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0011"}, d2 = {"Lcu/todus/android/connection/SpeedResult;", "", "<init>", "(Ljava/lang/String;I)V", "S_2G_GSM", "S_G_GPRS", "S_E_EDGE", "S_3G_UMTS", "S_H_HSPA", "S_HPLUS_HSPAPLUS", "S_4G_LTE", "S_4G_LTEA", "S_5G", "getQuality", "Lcu/todus/android/connection/Quality;", "getGetQuality", "()Lcu/todus/android/connection/Quality;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum SpeedResult {
    S_2G_GSM,
    S_G_GPRS,
    S_E_EDGE,
    S_3G_UMTS,
    S_H_HSPA,
    S_HPLUS_HSPAPLUS,
    S_4G_LTE,
    S_4G_LTEA,
    S_5G;

    private static final /* synthetic */ a $ENTRIES = b.a(values());

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpeedResult.values().length];
            try {
                iArr[SpeedResult.S_2G_GSM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpeedResult.S_G_GPRS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpeedResult.S_E_EDGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SpeedResult.S_3G_UMTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public final Quality getGetQuality() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? Quality.BAD_QUALITY : Quality.GOOD_QUALITY;
    }
}
