package cu.todus.android.uiCompose.main.screen.searchUser;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/searchUser/SearchUserParams;", "", User.COLUMN_TODUS_ID, "", "redirect", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToDusId", "()Ljava/lang/String;", "getRedirect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SearchUserParams {
    public static final int $stable = 0;
    public static final String GO_CHAT_PROFILE = "chat-profile";
    public static final String GO_SOCIAL_PROFILE = "social-profile";
    private final String redirect;
    private final String toDusId;

    public SearchUserParams(String toDusId, String redirect) {
        y.i(toDusId, "toDusId");
        y.i(redirect, "redirect");
        this.toDusId = toDusId;
        this.redirect = redirect;
    }

    public static /* synthetic */ SearchUserParams copy$default(SearchUserParams searchUserParams, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = searchUserParams.toDusId;
        }
        if ((i10 & 2) != 0) {
            str2 = searchUserParams.redirect;
        }
        return searchUserParams.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToDusId() {
        return this.toDusId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRedirect() {
        return this.redirect;
    }

    public final SearchUserParams copy(String toDusId, String redirect) {
        y.i(toDusId, "toDusId");
        y.i(redirect, "redirect");
        return new SearchUserParams(toDusId, redirect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchUserParams)) {
            return false;
        }
        SearchUserParams searchUserParams = (SearchUserParams) other;
        return y.d(this.toDusId, searchUserParams.toDusId) && y.d(this.redirect, searchUserParams.redirect);
    }

    public final String getRedirect() {
        return this.redirect;
    }

    public final String getToDusId() {
        return this.toDusId;
    }

    public int hashCode() {
        return (this.toDusId.hashCode() * 31) + this.redirect.hashCode();
    }

    public String toString() {
        return "SearchUserParams(toDusId=" + this.toDusId + ", redirect=" + this.redirect + ")";
    }
}
