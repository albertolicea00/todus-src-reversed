package cu.todus.android.data.rest.request;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.a;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcu/todus/android/data/rest/request/MeRequest;", "", User.COLUMN_ALIAS, "", User.COLUMN_PHOTO_URL, "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "setAlias", "(Ljava/lang/String;)V", "getPictureUrl", "setPictureUrl", "getDescription", "setDescription", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MeRequest {
    public static final int $stable = 8;

    @a
    @c(User.COLUMN_ALIAS)
    private String alias;

    @a
    @c("description")
    private String description;

    @a
    @c(User.COLUMN_PHOTO_URL)
    private String pictureUrl;

    public MeRequest(String alias, String pictureUrl, String description) {
        y.i(alias, "alias");
        y.i(pictureUrl, "pictureUrl");
        y.i(description, "description");
        this.alias = alias;
        this.pictureUrl = pictureUrl;
        this.description = description;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getPictureUrl() {
        return this.pictureUrl;
    }

    public final void setAlias(String str) {
        y.i(str, "<set-?>");
        this.alias = str;
    }

    public final void setDescription(String str) {
        y.i(str, "<set-?>");
        this.description = str;
    }

    public final void setPictureUrl(String str) {
        y.i(str, "<set-?>");
        this.pictureUrl = str;
    }
}
