package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcu/todus/android/data/db/pojo/ChannelSubscriber;", "Lcu/todus/android/data/db/pojo/UserCommon;", "index", "", "userRoomJoin", "Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "partner", "Lcu/todus/android/data/db/pojo/Partner;", "<init>", "(ILcu/todus/android/data/db/entity/toDus/UserRoomJoin;Lcu/todus/android/data/db/pojo/Partner;)V", "getIndex", "()I", "getUserRoomJoin", "()Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "getPartner", "()Lcu/todus/android/data/db/pojo/Partner;", "exists", "", "getId", "", "getName", "getPicture", "getThumbnailPicture", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ChannelSubscriber implements UserCommon {
    public static final int $stable = 0;
    private final int index;
    private final Partner partner;
    private final UserRoomJoin userRoomJoin;

    public ChannelSubscriber(int i10, UserRoomJoin userRoomJoin, Partner partner) {
        y.i(userRoomJoin, "userRoomJoin");
        y.i(partner, "partner");
        this.index = i10;
        this.userRoomJoin = userRoomJoin;
        this.partner = partner;
    }

    public static /* synthetic */ ChannelSubscriber copy$default(ChannelSubscriber channelSubscriber, int i10, UserRoomJoin userRoomJoin, Partner partner, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = channelSubscriber.index;
        }
        if ((i11 & 2) != 0) {
            userRoomJoin = channelSubscriber.userRoomJoin;
        }
        if ((i11 & 4) != 0) {
            partner = channelSubscriber.partner;
        }
        return channelSubscriber.copy(i10, userRoomJoin, partner);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UserRoomJoin getUserRoomJoin() {
        return this.userRoomJoin;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Partner getPartner() {
        return this.partner;
    }

    public final ChannelSubscriber copy(int index, UserRoomJoin userRoomJoin, Partner partner) {
        y.i(userRoomJoin, "userRoomJoin");
        y.i(partner, "partner");
        return new ChannelSubscriber(index, userRoomJoin, partner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelSubscriber)) {
            return false;
        }
        ChannelSubscriber channelSubscriber = (ChannelSubscriber) other;
        return this.index == channelSubscriber.index && y.d(this.userRoomJoin, channelSubscriber.userRoomJoin) && y.d(this.partner, channelSubscriber.partner);
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public boolean exists() {
        return true;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getId() {
        return this.partner.getUser().getUid();
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getName() {
        String phone;
        if (this.partner.getContact() != null && !d0.q0(this.partner.getContact().getFName())) {
            return this.partner.getContact().getFName();
        }
        if (this.partner.getUser().getAlias().length() > 0) {
            return this.partner.getUser().getAlias();
        }
        Contact contact = this.partner.getContact();
        return (contact == null || (phone = contact.getPhone()) == null) ? "~" : phone;
    }

    public final Partner getPartner() {
        return this.partner;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getPicture() {
        return this.partner.getUser().getPhotoUrl();
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getThumbnailPicture() {
        String photoThumbnail = this.partner.getUser().getPhotoThumbnail();
        return d0.q0(photoThumbnail) ? this.partner.getUser().getPhotoUrl() : photoThumbnail;
    }

    public final UserRoomJoin getUserRoomJoin() {
        return this.userRoomJoin;
    }

    public int hashCode() {
        return (((this.index * 31) + this.userRoomJoin.hashCode()) * 31) + this.partner.hashCode();
    }

    public String toString() {
        return "ChannelSubscriber(index=" + this.index + ", userRoomJoin=" + this.userRoomJoin + ", partner=" + this.partner + ")";
    }

    public /* synthetic */ ChannelSubscriber(int i10, UserRoomJoin userRoomJoin, Partner partner, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0 : i10, userRoomJoin, partner);
    }
}
