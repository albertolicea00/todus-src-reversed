package cu.todus.android.xmpp.mapper;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcu/todus/android/xmpp/mapper/MapperMarkersToStanza;", "", "<init>", "()V", "mapper", "Lorg/jivesoftware/smack/packet/Message;", "roomId", "", "markers", "", "Lcu/todus/android/data/db/entity/toDus/MarkerAction;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MapperMarkersToStanza {
    public static final int $stable = 0;
    public static final MapperMarkersToStanza INSTANCE = new MapperMarkersToStanza();

    private MapperMarkersToStanza() {
    }

    public final Message mapper(String roomId, List<MarkerAction> markers) throws XmppStringprepException {
        Jid jidBareFrom;
        y.i(roomId, "roomId");
        y.i(markers, "markers");
        Message message = new Message();
        message.setStanzaId(UUID.randomUUID().toString());
        try {
            jidBareFrom = JidCreate.fullFromOrThrowUnchecked(roomId);
        } catch (Exception unused) {
            jidBareFrom = JidCreate.bareFrom(roomId);
        }
        message.setTo(jidBareFrom);
        if (d0.a0(roomId, Service.Config.SERVER_NAME_MUC, false, 2, null)) {
            message.setType(Message.Type.groupchat);
        } else {
            message.setType(Message.Type.chat);
        }
        for (MarkerAction markerAction : markers) {
            int marker = markerAction.getMarker();
            if (marker == 1) {
                message.addExtension(new ChatMarkersElements.ReceivedExtension(markerAction.getMsg()));
            } else if (marker == 2) {
                message.addExtension(new ChatMarkersElements.DisplayedExtension(markerAction.getMsg()));
            } else if (marker == 3) {
                message.addExtension(new ChatMarkersElements.AcknowledgedExtension(markerAction.getMsg()));
            }
        }
        return message;
    }
}
