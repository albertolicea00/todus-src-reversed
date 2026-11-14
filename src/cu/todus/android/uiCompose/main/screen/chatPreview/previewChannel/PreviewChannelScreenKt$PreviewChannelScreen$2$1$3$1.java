package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.z17.views.form.FormItemRequest;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreenKt$PreviewChannelScreen$2$1$3$1", f = "PreviewChannelScreen.kt", l = {406}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
public final class PreviewChannelScreenKt$PreviewChannelScreen$2$1$3$1 extends cb.m implements Function1 {
    final /* synthetic */ String $deleteImageLabel;
    final /* synthetic */ List<FormItemRequest> $editorParams;
    final /* synthetic */ String $imageLabel;
    final /* synthetic */ String $informationLabel;
    final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
    final /* synthetic */ u0 $lastDeleteImageResult;
    final /* synthetic */ y0 $lastImage;
    final /* synthetic */ String $nameLabel;
    final /* synthetic */ State<Room> $preview$delegate;
    final /* synthetic */ HashMap<String, String> $updatedResult;
    Object L$0;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewChannelScreenKt$PreviewChannelScreen$2$1$3$1(HashMap<String, String> map, y0 y0Var, u0 u0Var, List<FormItemRequest> list, String str, String str2, String str3, String str4, MutableState<Boolean> mutableState, State<Room> state, ab.e<? super PreviewChannelScreenKt$PreviewChannelScreen$2$1$3$1> eVar) {
        super(1, eVar);
        this.$updatedResult = map;
        this.$lastImage = y0Var;
        this.$lastDeleteImageResult = u0Var;
        this.$editorParams = list;
        this.$imageLabel = str;
        this.$deleteImageLabel = str2;
        this.$nameLabel = str3;
        this.$informationLabel = str4;
        this.$isLoading$delegate = mutableState;
        this.$preview$delegate = state;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(ab.e<?> eVar) {
        return new PreviewChannelScreenKt$PreviewChannelScreen$2$1$3$1(this.$updatedResult, this.$lastImage, this.$lastDeleteImageResult, this.$editorParams, this.$imageLabel, this.$deleteImageLabel, this.$nameLabel, this.$informationLabel, this.$isLoading$delegate, this.$preview$delegate, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super ua.k0> eVar) {
        return ((PreviewChannelScreenKt$PreviewChannelScreen$2$1$3$1) create(eVar)).invokeSuspend(ua.k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            String str = this.$updatedResult.get("delete_image");
            if (str == null) {
                str = "";
            }
            boolean zD = kotlin.jvm.internal.y.d(str, "0");
            String str2 = this.$updatedResult.get("image");
            String str3 = str2 != null ? str2 : "";
            if (!kotlin.jvm.internal.y.d(str3, this.$lastImage.f36634c) && !le.d0.q0(str3)) {
                this.$lastImage.f36634c = str3;
            }
            u0 u0Var = this.$lastDeleteImageResult;
            if (u0Var.f36629c != zD) {
                u0Var.f36629c = zD;
                List<FormItemRequest> list = this.$editorParams;
                String str4 = this.$imageLabel;
                String str5 = str3;
                y0 y0Var = this.$lastImage;
                String str6 = this.$deleteImageLabel;
                String str7 = this.$nameLabel;
                String str8 = this.$informationLabel;
                MutableState<Boolean> mutableState = this.$isLoading$delegate;
                State<Room> state = this.$preview$delegate;
                HashMap<String, String> map = this.$updatedResult;
                this.L$0 = cb.l.a(str5);
                this.Z$0 = zD;
                this.label = 1;
                if (PreviewChannelScreenKt.PreviewChannelScreen$updateStateForDeleteImage(list, str4, y0Var, str6, str7, str8, mutableState, state, map, this) == objG) {
                    return objG;
                }
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return ua.k0.f43947a;
    }
}
