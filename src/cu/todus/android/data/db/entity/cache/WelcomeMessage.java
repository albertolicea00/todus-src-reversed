package cu.todus.android.data.db.entity.cache;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(tableName = WelcomeMessage.TABLE_NAME)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcu/todus/android/data/db/entity/cache/WelcomeMessage;", "", "id", "", "title", "", "text", "image", "url", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getText", "getImage", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WelcomeMessage {
    public static final int $stable = 0;
    public static final String COLUMN_ID = "id";
    public static final String TABLE_NAME = "welcome_message";

    @PrimaryKey
    private final int id;
    private final String image;
    private final String text;
    private final String title;
    private final String url;

    public WelcomeMessage(int i10, String title, String text, String image, String url) {
        y.i(title, "title");
        y.i(text, "text");
        y.i(image, "image");
        y.i(url, "url");
        this.id = i10;
        this.title = title;
        this.text = text;
        this.image = image;
        this.url = url;
    }

    public static /* synthetic */ WelcomeMessage copy$default(WelcomeMessage welcomeMessage, int i10, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = welcomeMessage.id;
        }
        if ((i11 & 2) != 0) {
            str = welcomeMessage.title;
        }
        if ((i11 & 4) != 0) {
            str2 = welcomeMessage.text;
        }
        if ((i11 & 8) != 0) {
            str3 = welcomeMessage.image;
        }
        if ((i11 & 16) != 0) {
            str4 = welcomeMessage.url;
        }
        String str5 = str4;
        String str6 = str2;
        return welcomeMessage.copy(i10, str, str6, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final WelcomeMessage copy(int id2, String title, String text, String image, String url) {
        y.i(title, "title");
        y.i(text, "text");
        y.i(image, "image");
        y.i(url, "url");
        return new WelcomeMessage(id2, title, text, image, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WelcomeMessage)) {
            return false;
        }
        WelcomeMessage welcomeMessage = (WelcomeMessage) other;
        return this.id == welcomeMessage.id && y.d(this.title, welcomeMessage.title) && y.d(this.text, welcomeMessage.text) && y.d(this.image, welcomeMessage.image) && y.d(this.url, welcomeMessage.url);
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.title.hashCode()) * 31) + this.text.hashCode()) * 31) + this.image.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "WelcomeMessage(id=" + this.id + ", title=" + this.title + ", text=" + this.text + ", image=" + this.image + ", url=" + this.url + ")";
    }
}
