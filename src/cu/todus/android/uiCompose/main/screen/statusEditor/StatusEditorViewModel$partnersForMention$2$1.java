package cu.todus.android.uiCompose.main.screen.statusEditor;

import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.uiCompose.main.screen.chat.mentionList.MentionItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorViewModel$partnersForMention$2$1", f = "StatusEditorViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/uiCompose/main/screen/chat/mentionList/MentionItemModel;", "mwp", "Lcu/todus/android/data/db/pojo/Partner;"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class StatusEditorViewModel$partnersForMention$2$1 extends cb.m implements Function2 {
    /* synthetic */ Object L$0;
    int label;

    public StatusEditorViewModel$partnersForMention$2$1(ab.e<? super StatusEditorViewModel$partnersForMention$2$1> eVar) {
        super(2, eVar);
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        StatusEditorViewModel$partnersForMention$2$1 statusEditorViewModel$partnersForMention$2$1 = new StatusEditorViewModel$partnersForMention$2$1(eVar);
        statusEditorViewModel$partnersForMention$2$1.L$0 = obj;
        return statusEditorViewModel$partnersForMention$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Partner partner, ab.e<? super MentionItemModel> eVar) {
        return ((StatusEditorViewModel$partnersForMention$2$1) create(partner, eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Partner partner = (Partner) this.L$0;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        return new MentionItemModel(partner.getId(), partner.getName(), partner.getUser().getToDusId(), partner.getThumbnailPicture());
    }
}
