package cu.todus.android.rest.sticker;

import ab.e;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.proto.ApiProto;
import kotlin.Metadata;
import mi.a0;
import oi.f;
import oi.s;
import oi.t;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0003\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0004\b\t\u0010\nJ \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/rest/sticker/StickerService;", "", "", "offset", "limit", "", NavLinks.SEARCH, "Lmi/a0;", "Lcu/todus/proto/ApiProto$GetPacksResp;", "packs", "(IILjava/lang/String;Lab/e;)Ljava/lang/Object;", Sticker.COLUMN_PACK_NAME, "Lcu/todus/proto/ApiProto$GetPackInfoResp;", "packInfo", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StickerService {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    @f(Service.Endpoint.PACK_INFO)
    Object packInfo(@s("pack_name") String str, e<? super a0<ApiProto.GetPackInfoResp>> eVar);

    @f(Service.Endpoint.PACKS)
    Object packs(@s("offset") int i10, @s("limit") int i11, @t("title") String str, e<? super a0<ApiProto.GetPacksResp>> eVar);
}
