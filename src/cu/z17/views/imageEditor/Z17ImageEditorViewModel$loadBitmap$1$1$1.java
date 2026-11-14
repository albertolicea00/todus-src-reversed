package cu.z17.views.imageEditor;

import android.graphics.Bitmap;
import android.os.Build;
import cu.z17.compress.UtilKt;
import cu.z17.views.camera.Z17CameraModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorViewModel$loadBitmap$1$1$1", f = "Z17ImageEditorViewModel.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17ImageEditorViewModel$loadBitmap$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ y0 $b;
    final /* synthetic */ boolean $firstCompression;
    final /* synthetic */ String $imagePathToSave;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17ImageEditorViewModel$loadBitmap$1$1$1(String str, y0 y0Var, boolean z10, ab.e<? super Z17ImageEditorViewModel$loadBitmap$1$1$1> eVar) {
        super(2, eVar);
        this.$imagePathToSave = str;
        this.$b = y0Var;
        this.$firstCompression = z10;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new Z17ImageEditorViewModel$loadBitmap$1$1$1(this.$imagePathToSave, this.$b, this.$firstCompression, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) throws IOException {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        File file = new File(this.$imagePathToSave);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Bitmap bitmap = (Bitmap) this.$b.f36634c;
        Bitmap.CompressFormat defaultFormat = Z17CameraModule.INSTANCE.getInstance().getDefaultFormat();
        if (defaultFormat == null) {
            defaultFormat = Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP;
        }
        bitmap.compress(defaultFormat, this.$firstCompression ? 50 : 90, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        this.$b.f36634c = UtilKt.loadBitmap(file);
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((Z17ImageEditorViewModel$loadBitmap$1$1$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
