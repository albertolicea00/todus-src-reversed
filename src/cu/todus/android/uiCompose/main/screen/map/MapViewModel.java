package cu.todus.android.uiCompose.main.screen.map;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cb.m;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.views.map.Z17MapMarker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/map/MapViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "roomId", "Lcu/z17/views/map/Z17MapMarker;", "z17MapMarker", "replyMsg", "Lua/k0;", "sendLocation", "(Ljava/lang/String;Lcu/z17/views/map/Z17MapMarker;Ljava/lang/String;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "getMainRepository", "()Lcu/todus/android/repositories/MainRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MapViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.map.MapViewModel$sendLocation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.map.MapViewModel$sendLocation$1", f = "MapViewModel.kt", l = {23}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        final /* synthetic */ Z17MapMarker $z17MapMarker;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Z17MapMarker z17MapMarker, String str2, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$z17MapMarker = z17MapMarker;
            this.$replyMsg = str2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return MapViewModel.this.new AnonymousClass1(this.$roomId, this.$z17MapMarker, this.$replyMsg, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = MapViewModel.this.getMainRepository();
                String str = this.$roomId;
                LocationContent locationContent = new LocationContent(this.$z17MapMarker.getLatitude(), this.$z17MapMarker.getLongitude(), 11.0d, "");
                String str2 = this.$replyMsg;
                this.label = 1;
                if (mainRepository.sendLocation(str, locationContent, str2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    public static /* synthetic */ void sendLocation$default(MapViewModel mapViewModel, String str, Z17MapMarker z17MapMarker, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        mapViewModel.sendLocation(str, z17MapMarker, str2);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final MainRepository getMainRepository() {
        return this.mainRepository;
    }

    public final void sendLocation(String roomId, Z17MapMarker z17MapMarker, String replyMsg) {
        y.i(roomId, "roomId");
        y.i(z17MapMarker, "z17MapMarker");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(roomId, z17MapMarker, replyMsg, null), 3, null);
    }
}
