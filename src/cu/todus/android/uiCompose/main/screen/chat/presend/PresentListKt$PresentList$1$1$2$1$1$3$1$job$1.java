package cu.todus.android.uiCompose.main.screen.chat.presend;

import android.net.Uri;
import androidx.compose.runtime.MutableState;
import cb.f;
import cb.m;
import cu.todus.android.utils.ThumbnailGenerator;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$1$1$2$1$1$3$1$job$1", f = "PresentList.kt", l = {145}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class PresentListKt$PresentList$1$1$2$1$1$3$1$job$1 extends m implements Function2 {
    final /* synthetic */ MutableState<String> $thumbnailPath$delegate;
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PresentListKt$PresentList$1$1$2$1$1$3$1$job$1(Uri uri, MutableState<String> mutableState, ab.e<? super PresentListKt$PresentList$1$1$2$1$1$3$1$job$1> eVar) {
        super(2, eVar);
        this.$uri = uri;
        this.$thumbnailPath$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new PresentListKt$PresentList$1$1$2$1$1$3$1$job$1(this.$uri, this.$thumbnailPath$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            ThumbnailGenerator thumbnailGenerator = ThumbnailGenerator.INSTANCE;
            String path = this.$uri.getPath();
            if (path == null) {
                path = "/";
            }
            String path2 = Uri.fromFile(new File(path)).getPath();
            String str = path2 != null ? path2 : "/";
            this.label = 1;
            obj = thumbnailGenerator.generateVideoThumbnailInFile(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        File file = (File) obj;
        this.$thumbnailPath$delegate.setValue(file != null ? file.getPath() : null);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((PresentListKt$PresentList$1$1$2$1$1$3$1$job$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
