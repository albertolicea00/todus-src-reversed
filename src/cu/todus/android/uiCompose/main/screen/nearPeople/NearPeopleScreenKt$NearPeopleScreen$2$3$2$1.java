package cu.todus.android.uiCompose.main.screen.nearPeople;

import kotlin.Metadata;
import kotlin.jvm.internal.v;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class NearPeopleScreenKt$NearPeopleScreen$2$3$2$1 extends v implements lb.a {
    public NearPeopleScreenKt$NearPeopleScreen$2$3$2$1(Object obj) {
        super(0, obj, NearPeopleViewModel.class, "loadNearStatus", "loadNearStatus()V", 0);
    }

    @Override // lb.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m9947invoke();
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9947invoke() {
        ((NearPeopleViewModel) this.receiver).loadNearStatus();
    }
}
