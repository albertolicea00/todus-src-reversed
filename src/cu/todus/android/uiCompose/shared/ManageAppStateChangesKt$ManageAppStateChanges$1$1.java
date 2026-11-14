package cu.todus.android.uiCompose.shared;

import android.app.Activity;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.uiCompose.auth.AuthActivity;
import cu.todus.android.uiCompose.banned.BannedActivity;
import cu.todus.android.uiCompose.main.MainActivity;
import cu.todus.android.uiCompose.start.StartActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.r;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.shared.ManageAppStateChangesKt$ManageAppStateChanges$1$1", f = "ManageAppStateChanges.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class ManageAppStateChangesKt$ManageAppStateChanges$1$1 extends cb.m implements Function2 {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ AppStateStep $appStep;
    final /* synthetic */ List<AppStateStep> $avoidFor;
    int label;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppStateStep.values().length];
            try {
                iArr[AppStateStep.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppStateStep.NEW_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppStateStep.WAITING_VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppStateStep.WAITING_REGISTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AppStateStep.WAITING_COMPLETE_PROFILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AppStateStep.WRONG_AUTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AppStateStep.UPDATE_REQUIRED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AppStateStep.BANNED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AppStateStep.LOGIN_COMPLETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ManageAppStateChangesKt$ManageAppStateChanges$1$1(List<? extends AppStateStep> list, AppStateStep appStateStep, Activity activity, ab.e<? super ManageAppStateChangesKt$ManageAppStateChanges$1$1> eVar) {
        super(2, eVar);
        this.$avoidFor = list;
        this.$appStep = appStateStep;
        this.$activity = activity;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ManageAppStateChangesKt$ManageAppStateChanges$1$1(this.$avoidFor, this.$appStep, this.$activity, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        if (!this.$avoidFor.contains(this.$appStep)) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.$appStep.ordinal()]) {
                case 1:
                    break;
                case 2:
                    ManageAppStateChangesKt.ManageAppStateChanges$goTo(this.$activity, StartActivity.class);
                    break;
                case 3:
                    ManageAppStateChangesKt.ManageAppStateChanges$goTo(this.$activity, AuthActivity.class);
                    break;
                case 4:
                    ManageAppStateChangesKt.ManageAppStateChanges$goTo(this.$activity, AuthActivity.class);
                    break;
                case 5:
                    ManageAppStateChangesKt.ManageAppStateChanges$goTo(this.$activity, MainActivity.class);
                    break;
                case 6:
                    ManageAppStateChangesKt.ManageAppStateChanges$goTo(this.$activity, BannedActivity.class);
                    break;
                case 7:
                    ManageAppStateChangesKt.ManageAppStateChanges$goTo(this.$activity, StartActivity.class);
                    break;
                case 8:
                    ManageAppStateChangesKt.ManageAppStateChanges$goTo(this.$activity, BannedActivity.class);
                    break;
                case 9:
                    ManageAppStateChangesKt.ManageAppStateChanges$goTo(this.$activity, MainActivity.class);
                    break;
                default:
                    throw new r();
            }
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ManageAppStateChangesKt$ManageAppStateChanges$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
