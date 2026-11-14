package cu.z17.views.pdfViewer;

import android.graphics.pdf.PdfRenderer;
import androidx.media3.extractor.ts.TsExtractor;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.pdfViewer.Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$2$1", f = "Z17PdfViewer.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$2$1 extends m implements Function2 {
    final /* synthetic */ PdfRenderer $currentRenderer;
    final /* synthetic */ af.a $mutex;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$2$1(af.a aVar, PdfRenderer pdfRenderer, ab.e<? super Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$2$1> eVar) {
        super(2, eVar);
        this.$mutex = aVar;
        this.$currentRenderer = pdfRenderer;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$2$1(this.$mutex, this.$currentRenderer, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        af.a aVar;
        PdfRenderer pdfRenderer;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            aVar = this.$mutex;
            PdfRenderer pdfRenderer2 = this.$currentRenderer;
            this.L$0 = aVar;
            this.L$1 = pdfRenderer2;
            this.I$0 = 0;
            this.label = 1;
            if (aVar.lock(null, this) == objG) {
                return objG;
            }
            pdfRenderer = pdfRenderer2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pdfRenderer = (PdfRenderer) this.L$1;
            aVar = (af.a) this.L$0;
            v.b(obj);
        }
        if (pdfRenderer != null) {
            try {
                pdfRenderer.close();
            } finally {
                aVar.unlock(null);
            }
        }
        k0 k0Var = k0.f43947a;
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
