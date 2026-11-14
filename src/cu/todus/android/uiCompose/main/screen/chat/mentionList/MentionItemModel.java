package cu.todus.android.uiCompose.main.screen.chat.mentionList;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/mentionList/MentionItemModel;", "", "id", "", "displayName", User.COLUMN_TODUS_ID, Room.CONFIG_PICTURE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getDisplayName", "getToDusId", "getPicture", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MentionItemModel {
    public static final int $stable = 0;
    private final String displayName;
    private final String id;
    private final String picture;
    private final String toDusId;

    public MentionItemModel(String id2, String displayName, String toDusId, String picture) {
        y.i(id2, "id");
        y.i(displayName, "displayName");
        y.i(toDusId, "toDusId");
        y.i(picture, "picture");
        this.id = id2;
        this.displayName = displayName;
        this.toDusId = toDusId;
        this.picture = picture;
    }

    public static /* synthetic */ MentionItemModel copy$default(MentionItemModel mentionItemModel, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mentionItemModel.id;
        }
        if ((i10 & 2) != 0) {
            str2 = mentionItemModel.displayName;
        }
        if ((i10 & 4) != 0) {
            str3 = mentionItemModel.toDusId;
        }
        if ((i10 & 8) != 0) {
            str4 = mentionItemModel.picture;
        }
        return mentionItemModel.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getToDusId() {
        return this.toDusId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    public final MentionItemModel copy(String id2, String displayName, String toDusId, String picture) {
        y.i(id2, "id");
        y.i(displayName, "displayName");
        y.i(toDusId, "toDusId");
        y.i(picture, "picture");
        return new MentionItemModel(id2, displayName, toDusId, picture);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MentionItemModel)) {
            return false;
        }
        MentionItemModel mentionItemModel = (MentionItemModel) other;
        return y.d(this.id, mentionItemModel.id) && y.d(this.displayName, mentionItemModel.displayName) && y.d(this.toDusId, mentionItemModel.toDusId) && y.d(this.picture, mentionItemModel.picture);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getToDusId() {
        return this.toDusId;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.toDusId.hashCode()) * 31) + this.picture.hashCode();
    }

    public String toString() {
        return "MentionItemModel(id=" + this.id + ", displayName=" + this.displayName + ", toDusId=" + this.toDusId + ", picture=" + this.picture + ")";
    }
}
