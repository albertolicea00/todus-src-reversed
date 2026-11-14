package cu.todus.android.data.rest.request;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/rest/request/InboxMessagesRequest;", "", "ids", "", "", "limit", "", MarkerAction.COLUMN_ROOM, "<init>", "(Ljava/util/List;ILjava/lang/String;)V", "getIds", "()Ljava/util/List;", "setIds", "(Ljava/util/List;)V", "getLimit", "()I", "setLimit", "(I)V", "getRoom", "()Ljava/lang/String;", "setRoom", "(Ljava/lang/String;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InboxMessagesRequest {
    public static final int $stable = 8;
    private List<String> ids;
    private int limit;
    private String room;

    public InboxMessagesRequest(List<String> ids, int i10, String room) {
        y.i(ids, "ids");
        y.i(room, "room");
        this.ids = ids;
        this.limit = i10;
        this.room = room;
    }

    public final List<String> getIds() {
        return this.ids;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getRoom() {
        return this.room;
    }

    public final void setIds(List<String> list) {
        y.i(list, "<set-?>");
        this.ids = list;
    }

    public final void setLimit(int i10) {
        this.limit = i10;
    }

    public final void setRoom(String str) {
        y.i(str, "<set-?>");
        this.room = str;
    }

    public /* synthetic */ InboxMessagesRequest(List list, int i10, String str, int i11, p pVar) {
        this((i11 & 1) != 0 ? w.n() : list, (i11 & 2) != 0 ? 10 : i10, str);
    }
}
