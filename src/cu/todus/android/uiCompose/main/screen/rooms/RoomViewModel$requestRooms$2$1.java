package cu.todus.android.uiCompose.main.screen.rooms;

import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.repositories.RoomsRepository;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;
import ua.v;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.uiCompose.main.screen.rooms.RoomViewModel$requestRooms$2$1", f = "RoomViewModel.kt", l = {190}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/pojo/RoomItemView;", "riv"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class RoomViewModel$requestRooms$2$1 extends m implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RoomViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomViewModel$requestRooms$2$1(RoomViewModel roomViewModel, ab.e<? super RoomViewModel$requestRooms$2$1> eVar) {
        super(2, eVar);
        this.this$0 = roomViewModel;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        RoomViewModel$requestRooms$2$1 roomViewModel$requestRooms$2$1 = new RoomViewModel$requestRooms$2$1(this.this$0, eVar);
        roomViewModel$requestRooms$2$1.L$0 = obj;
        return roomViewModel$requestRooms$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(RoomItemView roomItemView, ab.e<? super RoomItemView> eVar) {
        return ((RoomViewModel$requestRooms$2$1) create(roomItemView, eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Message message;
        Object unreadCount;
        RoomItemView roomItemView = (RoomItemView) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            MessageWithPartnerWithReactions lastMessage = roomItemView.getLastMessage();
            if (lastMessage != null && (message = lastMessage.getMessage()) != null && message.getState() == 2) {
                User senderUser = roomItemView.getLastMessage().getSenderUser();
                if (!y.d(senderUser != null ? senderUser.getUid() : null, this.this$0.getOwner().getNameWithDomain())) {
                    RoomsRepository roomsRepository = this.this$0.roomsRepository;
                    String id2 = roomItemView.getRoom().getId();
                    this.L$0 = roomItemView;
                    this.label = 1;
                    unreadCount = roomsRepository.getUnreadCount(id2, this);
                    if (unreadCount == objG) {
                        return objG;
                    }
                }
            }
            return roomItemView;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        unreadCount = obj;
        int iIntValue = ((Number) unreadCount).intValue();
        Room room = roomItemView.getRoom();
        Map mapA = w0.A(roomItemView.getRoom().getConfig());
        mapA.put(Room.CONFIG_UNREAD_COUNT, String.valueOf(iIntValue));
        k0 k0Var = k0.f43947a;
        return RoomItemView.copy$default(roomItemView, Room.copy$default(room, null, null, 0, null, null, mapA, 0L, 0, null, false, false, false, 4063, null), null, null, null, 14, null);
    }
}
