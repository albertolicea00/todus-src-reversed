package cu.todus.android.data.xmpp;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Status;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0017\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcu/todus/android/data/xmpp/StatusContent;", "", "id", "", Status.COLUMN_CREATOR_ID, Status.COLUMN_REPLIED_ID, "createdAt", "", "isPublic", "", "canRespond", "contentType", Message.COLUMN_MESSAGE_ENTITIES, "content", "location", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getCreatorId", "getRepliedId", "getCreatedAt", "()J", "()Z", "getCanRespond", "getContentType", "getMessageEntities", "getContent", "getLocation", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class StatusContent {
    public static final int $stable = 0;
    private final boolean canRespond;
    private final String content;
    private final String contentType;
    private final long createdAt;
    private final String creatorId;
    private final String id;
    private final boolean isPublic;
    private final String location;
    private final String messageEntities;
    private final String repliedId;

    public StatusContent(String id2, String creatorId, String repliedId, long j10, boolean z10, boolean z11, String contentType, String messageEntities, String content, String location) {
        y.i(id2, "id");
        y.i(creatorId, "creatorId");
        y.i(repliedId, "repliedId");
        y.i(contentType, "contentType");
        y.i(messageEntities, "messageEntities");
        y.i(content, "content");
        y.i(location, "location");
        this.id = id2;
        this.creatorId = creatorId;
        this.repliedId = repliedId;
        this.createdAt = j10;
        this.isPublic = z10;
        this.canRespond = z11;
        this.contentType = contentType;
        this.messageEntities = messageEntities;
        this.content = content;
        this.location = location;
    }

    public final boolean getCanRespond() {
        return this.canRespond;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getMessageEntities() {
        return this.messageEntities;
    }

    public final String getRepliedId() {
        return this.repliedId;
    }

    /* JADX INFO: renamed from: isPublic, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    public /* synthetic */ StatusContent(String str, String str2, String str3, long j10, boolean z10, boolean z11, String str4, String str5, String str6, String str7, int i10, p pVar) {
        this(str, str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? new Date().getTime() : j10, z10, z11, str4, (i10 & 128) != 0 ? "" : str5, str6, str7);
    }
}
