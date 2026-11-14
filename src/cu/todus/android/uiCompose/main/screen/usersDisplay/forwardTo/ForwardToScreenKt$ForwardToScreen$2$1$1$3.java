package cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.navigation.NavHostController;
import cu.todus.android.data.db.pojo.RoomItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ForwardToScreenKt$ForwardToScreen$2$1$1$3 extends kotlin.jvm.internal.v implements lb.a {
    final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
    final /* synthetic */ NavHostController $navHostController;
    final /* synthetic */ MutableState<RoomItemView> $roomSelected;
    final /* synthetic */ SnapshotStateMap<String, String> $selectedList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardToScreenKt$ForwardToScreen$2$1$1$3(SnapshotStateMap<String, String> snapshotStateMap, MutableState<RoomItemView> mutableState, NavHostController navHostController, MutableState<Boolean> mutableState2) {
        super(0, y.a.class, "onCompleted", "ForwardToScreen$lambda$11$0$0$onCompleted(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Landroidx/compose/runtime/MutableState;Landroidx/navigation/NavHostController;Landroidx/compose/runtime/MutableState;)V", 0);
        this.$selectedList = snapshotStateMap;
        this.$roomSelected = mutableState;
        this.$navHostController = navHostController;
        this.$isLoading$delegate = mutableState2;
    }

    @Override // lb.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m9997invoke();
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9997invoke() {
        ForwardToScreenKt.ForwardToScreen$lambda$11$0$0$onCompleted(this.$selectedList, this.$roomSelected, this.$navHostController, this.$isLoading$delegate);
    }
}
