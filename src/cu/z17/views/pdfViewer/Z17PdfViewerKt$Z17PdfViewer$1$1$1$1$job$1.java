package cu.z17.views.pdfViewer;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.media3.extractor.ts.TsExtractor;
import cb.m;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.pdfViewer.Z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1", f = "Z17PdfViewer.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1 extends m implements Function2 {
    final /* synthetic */ MutableState<Pair<Integer, Bitmap>> $actualPage$delegate;
    final /* synthetic */ float $height;
    final /* synthetic */ af.a $mutex;
    final /* synthetic */ State<PdfRenderer> $renderer$delegate;
    final /* synthetic */ float $width;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1(float f10, float f11, af.a aVar, State<PdfRenderer> state, MutableState<Pair<Integer, Bitmap>> mutableState, ab.e<? super Z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1> eVar) {
        super(2, eVar);
        this.$width = f10;
        this.$height = f11;
        this.$mutex = aVar;
        this.$renderer$delegate = state;
        this.$actualPage$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        Z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1 z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1 = new Z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1(this.$width, this.$height, this.$mutex, this.$renderer$delegate, this.$actualPage$delegate, eVar);
        z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1.L$0 = obj;
        return z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmapCreateBitmap;
        af.a aVar;
        State<PdfRenderer> state;
        MutableState<Pair<Integer, Bitmap>> mutableState;
        m0 m0Var = (m0) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            bitmapCreateBitmap = Bitmap.createBitmap((int) this.$width, (int) this.$height, Bitmap.Config.ARGB_8888);
            y.h(bitmapCreateBitmap, "createBitmap(...)");
            aVar = this.$mutex;
            state = this.$renderer$delegate;
            MutableState<Pair<Integer, Bitmap>> mutableState2 = this.$actualPage$delegate;
            this.L$0 = m0Var;
            this.L$1 = bitmapCreateBitmap;
            this.L$2 = aVar;
            this.L$3 = state;
            this.L$4 = mutableState2;
            this.I$0 = 0;
            this.label = 1;
            if (aVar.lock(null, this) == objG) {
                return objG;
            }
            mutableState = mutableState2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState = (MutableState) this.L$4;
            state = (State) this.L$3;
            aVar = (af.a) this.L$2;
            bitmapCreateBitmap = (Bitmap) this.L$1;
            v.b(obj);
        }
        try {
            if (!d2.n(m0Var.getCoroutineContext())) {
                k0 k0Var = k0.f43947a;
                aVar.unlock(null);
                return k0Var;
            }
            try {
                PdfRenderer pdfRendererZ17PdfViewer$lambda$16$lambda$2 = Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$2(state);
                if (pdfRendererZ17PdfViewer$lambda$16$lambda$2 != null) {
                    PdfRenderer.Page pageOpenPage = pdfRendererZ17PdfViewer$lambda$16$lambda$2.openPage(((Number) Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$7(mutableState).getFirst()).intValue());
                    try {
                        pageOpenPage.render(bitmapCreateBitmap, null, null, 1);
                        k0 k0Var2 = k0.f43947a;
                        jb.a.a(pageOpenPage, null);
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            jb.a.a(pageOpenPage, th2);
                            throw th3;
                        }
                    }
                }
                aVar.unlock(null);
                MutableState<Pair<Integer, Bitmap>> mutableState3 = this.$actualPage$delegate;
                mutableState3.setValue(Pair.copy$default(Z17PdfViewerKt.Z17PdfViewer$lambda$16$lambda$7(mutableState3), null, bitmapCreateBitmap, 1, null));
                return k0.f43947a;
            } catch (Exception unused) {
                k0 k0Var3 = k0.f43947a;
                aVar.unlock(null);
                return k0Var3;
            }
        } catch (Throwable th4) {
            aVar.unlock(null);
            throw th4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17PdfViewerKt$Z17PdfViewer$1$1$1$1$job$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
