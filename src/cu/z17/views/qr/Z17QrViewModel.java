package cu.z17.views.qr;

import android.graphics.Bitmap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelKt;
import cb.l;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.k;
import pe.m0;
import pe.w0;
import te.b0;
import te.j;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcu/z17/views/qr/Z17QrViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "", "content", "", "primaryColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Lua/k0;", "loadContent", "(Ljava/lang/String;II)V", "Lte/b0;", "Landroid/graphics/Bitmap;", "_qrResult", "Lte/b0;", "Lte/p0;", "qrResult", "Lte/p0;", "getQrResult", "()Lte/p0;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17QrViewModel extends ViewModel {
    public static final int $stable = 8;
    private final b0 _qrResult;
    private final p0 qrResult;

    /* JADX INFO: renamed from: cu.z17.views.qr.Z17QrViewModel$loadContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.qr.Z17QrViewModel$loadContent$1", f = "Z17QrViewModel.kt", l = {34}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ int $backgroundColor;
        final /* synthetic */ String $content;
        final /* synthetic */ int $primaryColor;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Z17QrViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, int i10, int i11, Z17QrViewModel z17QrViewModel, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$content = str;
            this.$primaryColor = i10;
            this.$backgroundColor = i11;
            this.this$0 = z17QrViewModel;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.$content, this.$primaryColor, this.$backgroundColor, this.this$0, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Bitmap bitmap;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                w6.b bVar = new w6.b();
                g6.b bVarA = bVar.a(this.$content, a6.a.QR_CODE, 512, 512);
                int iO = bVarA.o();
                int iK = bVarA.k();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iO, iK, Bitmap.Config.RGB_565);
                y.h(bitmapCreateBitmap, "createBitmap(...)");
                for (int i11 = 0; i11 < iO; i11++) {
                    for (int i12 = 0; i12 < iK; i12++) {
                        bitmapCreateBitmap.setPixel(i11, i12, bVarA.g(i11, i12) ? this.$primaryColor : this.$backgroundColor);
                    }
                }
                this.L$0 = l.a(bVar);
                this.L$1 = l.a(bVarA);
                this.L$2 = bitmapCreateBitmap;
                this.I$0 = iO;
                this.I$1 = iK;
                this.label = 1;
                if (w0.b(1000L, this) == objG) {
                    return objG;
                }
                bitmap = bitmapCreateBitmap;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bitmap = (Bitmap) this.L$2;
                v.b(obj);
            }
            this.this$0._qrResult.setValue(bitmap);
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public Z17QrViewModel() {
        b0 b0VarA = r0.a(null);
        this._qrResult = b0VarA;
        this.qrResult = j.b(b0VarA);
    }

    public static /* synthetic */ void loadContent$default(Z17QrViewModel z17QrViewModel, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = -1;
        }
        z17QrViewModel.loadContent(str, i10, i11);
    }

    public final p0 getQrResult() {
        return this.qrResult;
    }

    public final void loadContent(String content, int primaryColor, int backgroundColor) {
        y.i(content, "content");
        k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(content, primaryColor, backgroundColor, this, null), 3, null);
    }
}
