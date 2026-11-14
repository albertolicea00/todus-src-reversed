package cu.todus.android.data.db.entity.cache;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import defpackage.l;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(tableName = BotShortcut.TABLE_NAME)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcu/todus/android/data/db/entity/cache/BotShortcut;", "", "id", "", "roomId", "", "location", "icon", "label", "description", "btnColor", "btnContent", "createAt", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()I", "getRoomId", "()Ljava/lang/String;", "getLocation", "getIcon", "getLabel", "getDescription", "getBtnColor", "getBtnContent", "getCreateAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class BotShortcut {
    public static final int $stable = 0;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_ROOM_ID = "roomId";
    public static final String LOCATION_ATTACHMENT_SELECTOR = "location_attachment_selector";
    public static final String LOCATION_HOME_FLOATING = "location_home_floating";
    public static final String TABLE_NAME = "bot_shortcut";
    private final String btnColor;
    private final String btnContent;
    private final long createAt;
    private final String description;
    private final String icon;

    @PrimaryKey
    private final int id;
    private final String label;
    private final String location;
    private final String roomId;

    public BotShortcut(int i10, String roomId, String location, String icon, String label, String description, String btnColor, String btnContent, long j10) {
        y.i(roomId, "roomId");
        y.i(location, "location");
        y.i(icon, "icon");
        y.i(label, "label");
        y.i(description, "description");
        y.i(btnColor, "btnColor");
        y.i(btnContent, "btnContent");
        this.id = i10;
        this.roomId = roomId;
        this.location = location;
        this.icon = icon;
        this.label = label;
        this.description = description;
        this.btnColor = btnColor;
        this.btnContent = btnContent;
        this.createAt = j10;
    }

    public static /* synthetic */ BotShortcut copy$default(BotShortcut botShortcut, int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = botShortcut.id;
        }
        if ((i11 & 2) != 0) {
            str = botShortcut.roomId;
        }
        if ((i11 & 4) != 0) {
            str2 = botShortcut.location;
        }
        if ((i11 & 8) != 0) {
            str3 = botShortcut.icon;
        }
        if ((i11 & 16) != 0) {
            str4 = botShortcut.label;
        }
        if ((i11 & 32) != 0) {
            str5 = botShortcut.description;
        }
        if ((i11 & 64) != 0) {
            str6 = botShortcut.btnColor;
        }
        if ((i11 & 128) != 0) {
            str7 = botShortcut.btnContent;
        }
        if ((i11 & 256) != 0) {
            j10 = botShortcut.createAt;
        }
        long j11 = j10;
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        return botShortcut.copy(i10, str, str2, str3, str10, str11, str8, str9, j11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBtnColor() {
        return this.btnColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBtnContent() {
        return this.btnContent;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getCreateAt() {
        return this.createAt;
    }

    public final BotShortcut copy(int id2, String roomId, String location, String icon, String label, String description, String btnColor, String btnContent, long createAt) {
        y.i(roomId, "roomId");
        y.i(location, "location");
        y.i(icon, "icon");
        y.i(label, "label");
        y.i(description, "description");
        y.i(btnColor, "btnColor");
        y.i(btnContent, "btnContent");
        return new BotShortcut(id2, roomId, location, icon, label, description, btnColor, btnContent, createAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BotShortcut)) {
            return false;
        }
        BotShortcut botShortcut = (BotShortcut) other;
        return this.id == botShortcut.id && y.d(this.roomId, botShortcut.roomId) && y.d(this.location, botShortcut.location) && y.d(this.icon, botShortcut.icon) && y.d(this.label, botShortcut.label) && y.d(this.description, botShortcut.description) && y.d(this.btnColor, botShortcut.btnColor) && y.d(this.btnContent, botShortcut.btnContent) && this.createAt == botShortcut.createAt;
    }

    public final String getBtnColor() {
        return this.btnColor;
    }

    public final String getBtnContent() {
        return this.btnContent;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return (((((((((((((((this.id * 31) + this.roomId.hashCode()) * 31) + this.location.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.label.hashCode()) * 31) + this.description.hashCode()) * 31) + this.btnColor.hashCode()) * 31) + this.btnContent.hashCode()) * 31) + l.a(this.createAt);
    }

    public String toString() {
        return "BotShortcut(id=" + this.id + ", roomId=" + this.roomId + ", location=" + this.location + ", icon=" + this.icon + ", label=" + this.label + ", description=" + this.description + ", btnColor=" + this.btnColor + ", btnContent=" + this.btnContent + ", createAt=" + this.createAt + ")";
    }

    public /* synthetic */ BotShortcut(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j10, int i11, p pVar) {
        this(i10, str, str2, str3, str4, str5, str6, str7, (i11 & 256) != 0 ? new Date().getTime() : j10);
    }
}
