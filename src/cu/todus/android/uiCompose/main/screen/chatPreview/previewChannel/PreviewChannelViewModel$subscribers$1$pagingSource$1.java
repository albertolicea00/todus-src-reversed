package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel;

import androidx.media3.muxer.WebmConstants;
import cu.todus.android.data.db.pojo.ChannelSubscriber;
import cu.todus.android.repositories.MainRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelViewModel$subscribers$1$pagingSource$1", f = "PreviewChannelViewModel.kt", l = {WebmConstants.MkvEbmlElement.TRACK_NUMBER}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcu/todus/android/data/db/pojo/ChannelSubscriber;", "offset", "", "limit"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class PreviewChannelViewModel$subscribers$1$pagingSource$1 extends cb.m implements Function3 {
    final /* synthetic */ String $chId;
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    int label;
    final /* synthetic */ PreviewChannelViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewChannelViewModel$subscribers$1$pagingSource$1(PreviewChannelViewModel previewChannelViewModel, String str, ab.e<? super PreviewChannelViewModel$subscribers$1$pagingSource$1> eVar) {
        super(3, eVar);
        this.this$0 = previewChannelViewModel;
        this.$chId = str;
    }

    public final Object invoke(int i10, int i11, ab.e<? super List<ChannelSubscriber>> eVar) {
        PreviewChannelViewModel$subscribers$1$pagingSource$1 previewChannelViewModel$subscribers$1$pagingSource$1 = new PreviewChannelViewModel$subscribers$1$pagingSource$1(this.this$0, this.$chId, eVar);
        previewChannelViewModel$subscribers$1$pagingSource$1.I$0 = i10;
        previewChannelViewModel$subscribers$1$pagingSource$1.I$1 = i11;
        return previewChannelViewModel$subscribers$1$pagingSource$1.invokeSuspend(ua.k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.I$0;
        int i11 = this.I$1;
        Object objG = bb.b.g();
        int i12 = this.label;
        if (i12 != 0) {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return obj;
        }
        ua.v.b(obj);
        MainRepository mainRepository = this.this$0.mainRepository;
        String str = this.$chId;
        this.I$0 = i10;
        this.I$1 = i11;
        this.label = 1;
        Object subscribersPage = mainRepository.getSubscribersPage(str, i10, i11, this);
        return subscribersPage == objG ? objG : subscribersPage;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (ab.e<? super List<ChannelSubscriber>>) obj3);
    }
}
