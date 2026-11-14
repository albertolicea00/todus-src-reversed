package cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.pojo.FollowPartner;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0014\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006*"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusPreview/authorsDetail/AuthorsDetailData;", "", "areTheSame", "", Status.COLUMN_CREATOR_ID, "", "creatorImage", "creatorName", "creatorToDusId", Status.COLUMN_REPLIED_ID, "repliedImage", "repliedName", "repliedToDusId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAreTheSame", "()Z", "getCreatorId", "()Ljava/lang/String;", "getCreatorImage", "getCreatorName", "getCreatorToDusId", "getRepliedId", "getRepliedImage", "getRepliedName", "getRepliedToDusId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AuthorsDetailData {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean areTheSame;
    private final String creatorId;
    private final String creatorImage;
    private final String creatorName;
    private final String creatorToDusId;
    private final String repliedId;
    private final String repliedImage;
    private final String repliedName;
    private final String repliedToDusId;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusPreview/authorsDetail/AuthorsDetailData$Companion;", "", "<init>", "()V", "convert", "Lcu/todus/android/uiCompose/main/screen/statusPreview/authorsDetail/AuthorsDetailData;", "statusWithPartnersOrRooms", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "followPartner", "Lcu/todus/android/data/db/pojo/FollowPartner;", "partner", "Lcu/todus/android/data/db/pojo/Partner;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final AuthorsDetailData convert(StatusWithPartnersOrRooms statusWithPartnersOrRooms) {
            y.i(statusWithPartnersOrRooms, "statusWithPartnersOrRooms");
            return new AuthorsDetailData(y.d(statusWithPartnersOrRooms.getStatus().getCreatorId(), statusWithPartnersOrRooms.getStatus().getRepliedId()), statusWithPartnersOrRooms.getStatus().getCreatorId(), statusWithPartnersOrRooms.getCreatorImage(), statusWithPartnersOrRooms.getCreatorName(), statusWithPartnersOrRooms.getCreatorToDusId(), statusWithPartnersOrRooms.getRepliedId(), statusWithPartnersOrRooms.getRepliedPicture(), statusWithPartnersOrRooms.getRepliedName(), statusWithPartnersOrRooms.getRepliedIdToDusId());
        }

        private Companion() {
        }

        public final AuthorsDetailData convert(FollowPartner followPartner) {
            y.i(followPartner, "followPartner");
            return new AuthorsDetailData(true, followPartner.getId(), followPartner.getPicture(), followPartner.getName(), followPartner.getToDusId(), followPartner.getId(), followPartner.getPicture(), followPartner.getName(), followPartner.getToDusId());
        }

        public final AuthorsDetailData convert(Partner partner) {
            y.i(partner, "partner");
            return new AuthorsDetailData(true, partner.getId(), partner.getPicture(), partner.getName(), partner.getUser().getToDusId(), partner.getId(), partner.getPicture(), partner.getName(), partner.getUser().getToDusId());
        }
    }

    public AuthorsDetailData(boolean z10, String creatorId, String creatorImage, String creatorName, String creatorToDusId, String repliedId, String repliedImage, String repliedName, String repliedToDusId) {
        y.i(creatorId, "creatorId");
        y.i(creatorImage, "creatorImage");
        y.i(creatorName, "creatorName");
        y.i(creatorToDusId, "creatorToDusId");
        y.i(repliedId, "repliedId");
        y.i(repliedImage, "repliedImage");
        y.i(repliedName, "repliedName");
        y.i(repliedToDusId, "repliedToDusId");
        this.areTheSame = z10;
        this.creatorId = creatorId;
        this.creatorImage = creatorImage;
        this.creatorName = creatorName;
        this.creatorToDusId = creatorToDusId;
        this.repliedId = repliedId;
        this.repliedImage = repliedImage;
        this.repliedName = repliedName;
        this.repliedToDusId = repliedToDusId;
    }

    public static /* synthetic */ AuthorsDetailData copy$default(AuthorsDetailData authorsDetailData, boolean z10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = authorsDetailData.areTheSame;
        }
        if ((i10 & 2) != 0) {
            str = authorsDetailData.creatorId;
        }
        if ((i10 & 4) != 0) {
            str2 = authorsDetailData.creatorImage;
        }
        if ((i10 & 8) != 0) {
            str3 = authorsDetailData.creatorName;
        }
        if ((i10 & 16) != 0) {
            str4 = authorsDetailData.creatorToDusId;
        }
        if ((i10 & 32) != 0) {
            str5 = authorsDetailData.repliedId;
        }
        if ((i10 & 64) != 0) {
            str6 = authorsDetailData.repliedImage;
        }
        if ((i10 & 128) != 0) {
            str7 = authorsDetailData.repliedName;
        }
        if ((i10 & 256) != 0) {
            str8 = authorsDetailData.repliedToDusId;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        String str13 = str4;
        String str14 = str2;
        return authorsDetailData.copy(z10, str, str14, str3, str13, str11, str12, str9, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAreTheSame() {
        return this.areTheSame;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatorId() {
        return this.creatorId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreatorImage() {
        return this.creatorImage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreatorName() {
        return this.creatorName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCreatorToDusId() {
        return this.creatorToDusId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRepliedId() {
        return this.repliedId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRepliedImage() {
        return this.repliedImage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getRepliedName() {
        return this.repliedName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getRepliedToDusId() {
        return this.repliedToDusId;
    }

    public final AuthorsDetailData copy(boolean areTheSame, String creatorId, String creatorImage, String creatorName, String creatorToDusId, String repliedId, String repliedImage, String repliedName, String repliedToDusId) {
        y.i(creatorId, "creatorId");
        y.i(creatorImage, "creatorImage");
        y.i(creatorName, "creatorName");
        y.i(creatorToDusId, "creatorToDusId");
        y.i(repliedId, "repliedId");
        y.i(repliedImage, "repliedImage");
        y.i(repliedName, "repliedName");
        y.i(repliedToDusId, "repliedToDusId");
        return new AuthorsDetailData(areTheSame, creatorId, creatorImage, creatorName, creatorToDusId, repliedId, repliedImage, repliedName, repliedToDusId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthorsDetailData)) {
            return false;
        }
        AuthorsDetailData authorsDetailData = (AuthorsDetailData) other;
        return this.areTheSame == authorsDetailData.areTheSame && y.d(this.creatorId, authorsDetailData.creatorId) && y.d(this.creatorImage, authorsDetailData.creatorImage) && y.d(this.creatorName, authorsDetailData.creatorName) && y.d(this.creatorToDusId, authorsDetailData.creatorToDusId) && y.d(this.repliedId, authorsDetailData.repliedId) && y.d(this.repliedImage, authorsDetailData.repliedImage) && y.d(this.repliedName, authorsDetailData.repliedName) && y.d(this.repliedToDusId, authorsDetailData.repliedToDusId);
    }

    public final boolean getAreTheSame() {
        return this.areTheSame;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final String getCreatorImage() {
        return this.creatorImage;
    }

    public final String getCreatorName() {
        return this.creatorName;
    }

    public final String getCreatorToDusId() {
        return this.creatorToDusId;
    }

    public final String getRepliedId() {
        return this.repliedId;
    }

    public final String getRepliedImage() {
        return this.repliedImage;
    }

    public final String getRepliedName() {
        return this.repliedName;
    }

    public final String getRepliedToDusId() {
        return this.repliedToDusId;
    }

    public int hashCode() {
        return (((((((((((((((r.a(this.areTheSame) * 31) + this.creatorId.hashCode()) * 31) + this.creatorImage.hashCode()) * 31) + this.creatorName.hashCode()) * 31) + this.creatorToDusId.hashCode()) * 31) + this.repliedId.hashCode()) * 31) + this.repliedImage.hashCode()) * 31) + this.repliedName.hashCode()) * 31) + this.repliedToDusId.hashCode();
    }

    public String toString() {
        return "AuthorsDetailData(areTheSame=" + this.areTheSame + ", creatorId=" + this.creatorId + ", creatorImage=" + this.creatorImage + ", creatorName=" + this.creatorName + ", creatorToDusId=" + this.creatorToDusId + ", repliedId=" + this.repliedId + ", repliedImage=" + this.repliedImage + ", repliedName=" + this.repliedName + ", repliedToDusId=" + this.repliedToDusId + ")";
    }
}
