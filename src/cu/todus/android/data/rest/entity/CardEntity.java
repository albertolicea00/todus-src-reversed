package cu.todus.android.data.rest.entity;

import androidx.annotation.Keep;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.common.Scopes;
import cu.todus.android.data.db.entity.toDus.Reaction;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcu/todus/android/data/rest/entity/CardEntity;", "", Reaction.COLUMN_ENTITY, "", "info", "Lcu/todus/android/data/rest/entity/Info;", Scopes.PROFILE, "uid", "username", "subscribed", "", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/rest/entity/Info;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getEntity", "()Ljava/lang/String;", "getInfo", "()Lcu/todus/android/data/rest/entity/Info;", "getProfile", "getUid", "getUsername", "getSubscribed", "()Z", "setSubscribed", "(Z)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CardEntity {
    public static final int $stable = 8;
    private final String entity;
    private final Info info;
    private final String profile;
    private boolean subscribed;
    private final String uid;
    private final String username;

    public CardEntity(String entity, Info info, String profile, String uid, String username, boolean z10) {
        y.i(entity, "entity");
        y.i(info, "info");
        y.i(profile, "profile");
        y.i(uid, "uid");
        y.i(username, "username");
        this.entity = entity;
        this.info = info;
        this.profile = profile;
        this.uid = uid;
        this.username = username;
        this.subscribed = z10;
    }

    public final String getEntity() {
        return this.entity;
    }

    public final Info getInfo() {
        return this.info;
    }

    public final String getProfile() {
        return this.profile;
    }

    public final boolean getSubscribed() {
        return this.subscribed;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setSubscribed(boolean z10) {
        this.subscribed = z10;
    }
}
