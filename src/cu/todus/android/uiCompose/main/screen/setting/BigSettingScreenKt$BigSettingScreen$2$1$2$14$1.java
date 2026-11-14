package cu.todus.android.uiCompose.main.screen.setting;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class BigSettingScreenKt$BigSettingScreen$2$1$2$14$1 extends kotlin.jvm.internal.v implements Function1 {
    public BigSettingScreenKt$BigSettingScreen$2$1$2$14$1(Object obj) {
        super(1, obj, SettingViewModel.class, "changeSentryState", "changeSentryState(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return ua.k0.f43947a;
    }

    public final void invoke(boolean z10) {
        ((SettingViewModel) this.receiver).changeSentryState(z10);
    }
}
