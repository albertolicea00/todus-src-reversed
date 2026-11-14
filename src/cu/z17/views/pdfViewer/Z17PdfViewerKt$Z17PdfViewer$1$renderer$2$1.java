package cu.z17.views.pdfViewer;

import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.compose.runtime.ProduceStateScope;
import androidx.core.net.UriKt;
import cb.m;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.d1;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.pdfViewer.Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1", f = "Z17PdfViewer.kt", l = {48}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/compose/runtime/ProduceStateScope;", "Landroid/graphics/pdf/PdfRenderer;", "Lua/k0;", "<anonymous>", "(Landroidx/compose/runtime/ProduceStateScope;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1 extends m implements Function2 {
    final /* synthetic */ af.a $mutex;
    final /* synthetic */ m0 $rendererScope;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: cu.z17.views.pdfViewer.Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.pdfViewer.Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$1", f = "Z17PdfViewer.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ ProduceStateScope<PdfRenderer> $$this$produceState;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Uri uri, ProduceStateScope<PdfRenderer> produceStateScope, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$uri = uri;
            this.$$this$produceState = produceStateScope;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.$uri, this.$$this$produceState, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws FileNotFoundException {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            this.$$this$produceState.setValue(new PdfRenderer(ParcelFileDescriptor.open(UriKt.toFile(this.$uri), 268435456)));
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1(m0 m0Var, Uri uri, af.a aVar, ab.e<? super Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1> eVar) {
        super(2, eVar);
        this.$rendererScope = m0Var;
        this.$uri = uri;
        this.$mutex = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final k0 invokeSuspend$lambda$0(ProduceStateScope produceStateScope, m0 m0Var, af.a aVar) {
        pe.k.d(m0Var, d1.b(), null, new Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1$2$1(aVar, (PdfRenderer) produceStateScope.getValue(), null), 2, null);
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1 z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1 = new Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1(this.$rendererScope, this.$uri, this.$mutex, eVar);
        z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1.L$0 = obj;
        return z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProduceStateScope<PdfRenderer> produceStateScope, ab.e<? super k0> eVar) {
        return ((Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1) create(produceStateScope, eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        final ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            pe.k.d(this.$rendererScope, d1.b(), null, new AnonymousClass1(this.$uri, produceStateScope, null), 2, null);
            final m0 m0Var = this.$rendererScope;
            final af.a aVar = this.$mutex;
            lb.a aVar2 = new lb.a() { // from class: cu.z17.views.pdfViewer.l
                @Override // lb.a
                public final Object invoke() {
                    return Z17PdfViewerKt$Z17PdfViewer$1$renderer$2$1.invokeSuspend$lambda$0(produceStateScope, m0Var, aVar);
                }
            };
            this.L$0 = cb.l.a(produceStateScope);
            this.label = 1;
            if (produceStateScope.awaitDispose(aVar2, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        throw new ua.j();
    }
}
