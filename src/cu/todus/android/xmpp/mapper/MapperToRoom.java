package cu.todus.android.xmpp.mapper;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.xmpp.ChannelInfo;
import cu.todus.android.xmpp.XMPPUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import ua.z;
import va.g0;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/xmpp/mapper/MapperToRoom;", "", "<init>", "()V", "fromChannelInfoToRoom", "Lkotlin/Pair;", "Lcu/todus/android/data/db/entity/toDus/Room;", "Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "channelInfo", "Lcu/todus/android/data/xmpp/ChannelInfo;", "username", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MapperToRoom {
    public static final int $stable = 0;
    public static final MapperToRoom INSTANCE = new MapperToRoom();

    private MapperToRoom() {
    }

    public final Pair<Room, UserRoomJoin> fromChannelInfoToRoom(ChannelInfo channelInfo, String username) {
        y.i(channelInfo, "channelInfo");
        y.i(username, "username");
        XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
        return z.a(new Room(xMPPUtils.fromChannelIdToJID(channelInfo.getId()), channelInfo.getName(), 2, channelInfo.getVersion(), channelInfo.getSubject(), w0.k(z.a(Room.CONFIG_ROOM_NAME, channelInfo.getName()), z.a("subject", channelInfo.getSubject()), z.a(Room.CONFIG_AFF_COUNT, String.valueOf(channelInfo.getSubs())), z.a(Room.CONFIG_CREATED_AT, channelInfo.getCreated()), z.a(Room.CONFIG_ROLE, channelInfo.getAff()), z.a("rights", g0.G0(channelInfo.getRights(), ",", null, null, 0, null, null, 62, null)), z.a("public", String.valueOf(channelInfo.getPublic())), z.a(Room.CONFIG_PICTURE, channelInfo.getPicUrl()), z.a(Room.CONFIG_PICTURE_THUMBNAIL, channelInfo.getPictureThumbnail()), z.a(Room.CONFIG_SHARE_LINK, channelInfo.getLink())), 0L, 0, null, false, false, false, 4032, null), new UserRoomJoin(username + "@im.todus.cu", xMPPUtils.fromChannelIdToJID(channelInfo.getId()), channelInfo.getAff()));
    }
}
