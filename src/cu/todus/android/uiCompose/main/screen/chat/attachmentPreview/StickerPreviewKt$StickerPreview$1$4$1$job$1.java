package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.StickerContent;
import cu.todus.android.data.rest.entity.StickerPack;
import cu.todus.android.repositories.StickersRepository;
import cu.z17.singledi.SinglediException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.StickerPreviewKt$StickerPreview$1$4$1$job$1", f = "StickerPreview.kt", l = {110}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class StickerPreviewKt$StickerPreview$1$4$1$job$1 extends cb.m implements Function2 {
    final /* synthetic */ Attachment $attachment;
    final /* synthetic */ SnapshotStateList<Sticker> $stickerPack;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPreviewKt$StickerPreview$1$4$1$job$1(Attachment attachment, SnapshotStateList<Sticker> snapshotStateList, ab.e<? super StickerPreviewKt$StickerPreview$1$4$1$job$1> eVar) {
        super(2, eVar);
        this.$attachment = attachment;
        this.$stickerPack = snapshotStateList;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new StickerPreviewKt$StickerPreview$1$4$1$job$1(this.$attachment, this.$stickerPack, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) throws SinglediException {
        StickerPack stickerPack;
        Object objG = bb.b.g();
        int i10 = this.label;
        int i11 = 1;
        if (i10 == 0) {
            ua.v.b(obj);
            StickersRepository singletonInitializer = StickersRepository.INSTANCE.getInstance();
            Content content = this.$attachment.getContent();
            kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.StickerContent");
            String folder = ((StickerContent) content).getFolder();
            this.label = 1;
            obj = singletonInitializer.getStickersPack(0, 1, folder, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        List list = (List) obj;
        if (list != null && (stickerPack = (StickerPack) va.g0.y0(list)) != null) {
            SnapshotStateList<Sticker> snapshotStateList = this.$stickerPack;
            List listS0 = le.d0.S0(stickerPack.getThumb(), new String[]{"."}, false, 0, 6, null);
            int count = stickerPack.getCount();
            if (1 <= count) {
                while (true) {
                    snapshotStateList.add(new Sticker(stickerPack.getName() + "/" + i11 + "." + va.g0.I0(listS0), stickerPack.getName(), i11 + "." + va.g0.I0(listS0), stickerPack.getName(), false, 0L));
                    if (i11 == count) {
                        break;
                    }
                    i11++;
                }
            }
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((StickerPreviewKt$StickerPreview$1$4$1$job$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
