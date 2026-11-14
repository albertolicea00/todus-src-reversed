package cu.todus.android.xmpp.mapper;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import cb.d;
import cb.f;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcu/todus/android/xmpp/mapper/MapperMessageToStanza;", "", "<init>", "()V", "Lcu/todus/android/data/db/entity/toDus/Message;", "message", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lorg/jivesoftware/smack/packet/Message;", "mapper", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;Lcu/todus/android/db/dao/toDus/MessageDao;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MapperMessageToStanza {
    public static final int $stable = 0;
    public static final MapperMessageToStanza INSTANCE = new MapperMessageToStanza();

    /* JADX INFO: renamed from: cu.todus.android.xmpp.mapper.MapperMessageToStanza$mapper$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.xmpp.mapper.MapperMessageToStanza", f = "MapperMessageToStanza.kt", l = {86, 103}, m = "mapper", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MapperMessageToStanza.this.mapper(null, null, null, this);
        }
    }

    private MapperMessageToStanza() {
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0145  */
    /* JADX WARN: Code duplicated, block: B:29:0x0158  */
    /* JADX WARN: Code duplicated, block: B:31:0x015c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0160  */
    /* JADX WARN: Code duplicated, block: B:35:0x0164  */
    /* JADX WARN: Code duplicated, block: B:43:0x0282  */
    /* JADX WARN: Code duplicated, block: B:46:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:49:0x0303  */
    /* JADX WARN: Code duplicated, block: B:50:0x0332  */
    /* JADX WARN: Code duplicated, block: B:53:0x0339  */
    /* JADX WARN: Code duplicated, block: B:54:0x033e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0341  */
    /* JADX WARN: Code duplicated, block: B:59:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:65:0x0417  */
    /* JADX WARN: Code duplicated, block: B:66:0x0424  */
    /* JADX WARN: Code duplicated, block: B:67:0x0485  */
    /* JADX WARN: Code duplicated, block: B:68:0x0500  */
    /* JADX WARN: Code duplicated, block: B:69:0x053a  */
    /* JADX WARN: Code duplicated, block: B:70:0x058e  */
    /* JADX WARN: Code duplicated, block: B:71:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:72:0x0650  */
    /* JADX WARN: Code duplicated, block: B:78:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:80:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:81:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x083a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x03a9 -> B:60:0x03b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0417 -> B:84:0x0875). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x0872 -> B:84:0x0875). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object mapper(cu.todus.android.data.db.entity.toDus.Message r19, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r20, cu.todus.android.db.dao.toDus.MessageDao r21, ab.e<? super org.jivesoftware.smack.packet.Message> r22) throws org.jxmpp.stringprep.XmppStringprepException {
        /*
            Method dump skipped, instruction units count: 2276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.mapper.MapperMessageToStanza.mapper(cu.todus.android.data.db.entity.toDus.Message, java.util.List, cu.todus.android.db.dao.toDus.MessageDao, ab.e):java.lang.Object");
    }
}
