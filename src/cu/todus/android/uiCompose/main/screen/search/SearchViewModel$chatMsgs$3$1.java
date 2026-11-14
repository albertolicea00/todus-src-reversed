package cu.todus.android.uiCompose.main.screen.search;

import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.info.RoomBannerPayload;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$3$1", f = "SearchViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "m", "m2"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class SearchViewModel$chatMsgs$3$1 extends cb.m implements Function3 {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public SearchViewModel$chatMsgs$3$1(ab.e<? super SearchViewModel$chatMsgs$3$1> eVar) {
        super(3, eVar);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions2, ab.e<? super MessageWithPartnerWithRoomWithReactions> eVar) {
        SearchViewModel$chatMsgs$3$1 searchViewModel$chatMsgs$3$1 = new SearchViewModel$chatMsgs$3$1(eVar);
        searchViewModel$chatMsgs$3$1.L$0 = messageWithPartnerWithRoomWithReactions;
        searchViewModel$chatMsgs$3$1.L$1 = messageWithPartnerWithRoomWithReactions2;
        return searchViewModel$chatMsgs$3$1.invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Room senderRoom;
        Room senderRoom2;
        MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions = (MessageWithPartnerWithRoomWithReactions) this.L$0;
        MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions2 = (MessageWithPartnerWithRoomWithReactions) this.L$1;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (((messageWithPartnerWithRoomWithReactions == null || (senderRoom2 = messageWithPartnerWithRoomWithReactions.getSenderRoom()) == null) ? null : senderRoom2.getId()) != null) {
            if (((messageWithPartnerWithRoomWithReactions2 == null || (senderRoom = messageWithPartnerWithRoomWithReactions2.getSenderRoom()) == null) ? null : senderRoom.getId()) != null && !kotlin.jvm.internal.y.d(messageWithPartnerWithRoomWithReactions.getSenderRoom().getId(), messageWithPartnerWithRoomWithReactions2.getSenderRoom().getId())) {
                String string = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string, "toString(...)");
                return new MessageWithPartnerWithRoomWithReactions(new Message(le.a0.O(string, "-", "", false, 4, null), "", "", "", 0L, 3, new RoomBannerPayload(messageWithPartnerWithRoomWithReactions.getRoomName(), messageWithPartnerWithRoomWithReactions.getSenderRoom().getId()), null, null, 400, null), null, null, null, null, null, 62, null);
            }
        }
        return null;
    }
}
