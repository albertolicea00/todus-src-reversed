package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.pojo.Partner;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chatPreview/previewChannel/PreviewChannelAdminsParams;", "", "chId", "", "partner", "Lcu/todus/android/data/db/pojo/Partner;", "rights", "", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/Partner;Ljava/util/List;)V", "getChId", "()Ljava/lang/String;", "getPartner", "()Lcu/todus/android/data/db/pojo/Partner;", "getRights", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PreviewChannelAdminsParams {
    public static final int $stable = 0;
    private final String chId;
    private final Partner partner;
    private final List<String> rights;

    public PreviewChannelAdminsParams(String chId, Partner partner, List<String> rights) {
        kotlin.jvm.internal.y.i(chId, "chId");
        kotlin.jvm.internal.y.i(partner, "partner");
        kotlin.jvm.internal.y.i(rights, "rights");
        this.chId = chId;
        this.partner = partner;
        this.rights = rights;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreviewChannelAdminsParams copy$default(PreviewChannelAdminsParams previewChannelAdminsParams, String str, Partner partner, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = previewChannelAdminsParams.chId;
        }
        if ((i10 & 2) != 0) {
            partner = previewChannelAdminsParams.partner;
        }
        if ((i10 & 4) != 0) {
            list = previewChannelAdminsParams.rights;
        }
        return previewChannelAdminsParams.copy(str, partner, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChId() {
        return this.chId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Partner getPartner() {
        return this.partner;
    }

    public final List<String> component3() {
        return this.rights;
    }

    public final PreviewChannelAdminsParams copy(String chId, Partner partner, List<String> rights) {
        kotlin.jvm.internal.y.i(chId, "chId");
        kotlin.jvm.internal.y.i(partner, "partner");
        kotlin.jvm.internal.y.i(rights, "rights");
        return new PreviewChannelAdminsParams(chId, partner, rights);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewChannelAdminsParams)) {
            return false;
        }
        PreviewChannelAdminsParams previewChannelAdminsParams = (PreviewChannelAdminsParams) other;
        return kotlin.jvm.internal.y.d(this.chId, previewChannelAdminsParams.chId) && kotlin.jvm.internal.y.d(this.partner, previewChannelAdminsParams.partner) && kotlin.jvm.internal.y.d(this.rights, previewChannelAdminsParams.rights);
    }

    public final String getChId() {
        return this.chId;
    }

    public final Partner getPartner() {
        return this.partner;
    }

    public final List<String> getRights() {
        return this.rights;
    }

    public int hashCode() {
        return (((this.chId.hashCode() * 31) + this.partner.hashCode()) * 31) + this.rights.hashCode();
    }

    public String toString() {
        return "PreviewChannelAdminsParams(chId=" + this.chId + ", partner=" + this.partner + ", rights=" + this.rights + ")";
    }
}
