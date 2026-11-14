package cu.todus.android.data.db.pojo.info;

import androidx.compose.runtime.Immutable;
import cu.todus.android.utils.DateFormatter;
import defpackage.l;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcu/todus/android/data/db/pojo/info/DatePayload;", "Lcu/todus/android/data/db/pojo/info/MessagePayload;", "date", "", "<init>", "(J)V", "getDate", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DatePayload extends MessagePayload {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long date;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcu/todus/android/data/db/pojo/info/DatePayload$Companion;", "", "<init>", "()V", "generateMsgId", "", "date", "", "roomId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final String generateMsgId(long date, String roomId) {
            y.i(roomId, "roomId");
            String lowerCase = d0.q1(DateFormatter.INSTANCE.format(new Date(date), DateFormatter.Template.STRING_DAY_MONTH_YEAR) + roomId).toString().toLowerCase(Locale.ROOT);
            y.h(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }

        private Companion() {
        }
    }

    public DatePayload(long j10) {
        super(MessagePayload.TYPE.DATE_PAYLOAD);
        this.date = j10;
    }

    public static /* synthetic */ DatePayload copy$default(DatePayload datePayload, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = datePayload.date;
        }
        return datePayload.copy(j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    public final DatePayload copy(long date) {
        return new DatePayload(date);
    }

    @Override // cu.todus.android.data.db.pojo.info.MessagePayload
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DatePayload) && this.date == ((DatePayload) other).date;
    }

    public final long getDate() {
        return this.date;
    }

    @Override // cu.todus.android.data.db.pojo.info.MessagePayload
    public int hashCode() {
        return l.a(this.date);
    }

    public String toString() {
        return "DatePayload(date=" + this.date + ")";
    }
}
