package cu.todus.android.uiCompose.main.screen.catalogue;

import androidx.media3.muxer.WebmConstants;
import cb.m;
import cu.todus.android.data.db.entity.cache.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$catalogue$1$pagingSource$1", f = "CatalogueViewModel.kt", l = {WebmConstants.MAX_META_SEEK_SIZE, 73}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcu/todus/android/data/db/entity/cache/Product;", "offset", "", "limit"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class CatalogueViewModel$catalogue$1$pagingSource$1 extends m implements Function3 {
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    int label;
    final /* synthetic */ CatalogueViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CatalogueViewModel$catalogue$1$pagingSource$1(CatalogueViewModel catalogueViewModel, ab.e<? super CatalogueViewModel$catalogue$1$pagingSource$1> eVar) {
        super(3, eVar);
        this.this$0 = catalogueViewModel;
    }

    public final Object invoke(int i10, int i11, ab.e<? super List<Product>> eVar) {
        CatalogueViewModel$catalogue$1$pagingSource$1 catalogueViewModel$catalogue$1$pagingSource$1 = new CatalogueViewModel$catalogue$1$pagingSource$1(this.this$0, eVar);
        catalogueViewModel$catalogue$1$pagingSource$1.I$0 = i10;
        catalogueViewModel$catalogue$1$pagingSource$1.I$1 = i11;
        return catalogueViewModel$catalogue$1$pagingSource$1.invokeSuspend(k0.f43947a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        if (r7 == r2) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005d, code lost:
    
        if (r7 == r2) goto L19;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = r6.I$0
            int r1 = r6.I$1
            java.lang.Object r2 = bb.b.g()
            int r3 = r6.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L22
            if (r3 == r5) goto L1e
            if (r3 != r4) goto L16
            ua.v.b(r7)
            goto L60
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            ua.v.b(r7)
            goto L44
        L22:
            ua.v.b(r7)
            cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r7 = r6.this$0
            java.lang.String r7 = r7.getToDusId()
            boolean r7 = le.d0.q0(r7)
            if (r7 == 0) goto L47
            cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r7 = r6.this$0
            cu.todus.android.repositories.CatalogueRepository r7 = cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel.access$getCatalogueRepository$p(r7)
            r6.I$0 = r0
            r6.I$1 = r1
            r6.label = r5
            java.lang.Object r7 = r7.getMyProducts(r0, r1, r6)
            if (r7 != r2) goto L44
            goto L5f
        L44:
            java.util.List r7 = (java.util.List) r7
            return r7
        L47:
            cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r7 = r6.this$0
            cu.todus.android.repositories.CatalogueRepository r7 = cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel.access$getCatalogueRepository$p(r7)
            cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r3 = r6.this$0
            java.lang.String r3 = r3.getToDusId()
            r6.I$0 = r0
            r6.I$1 = r1
            r6.label = r4
            java.lang.Object r7 = r7.getOtherProducts(r3, r0, r1, r6)
            if (r7 != r2) goto L60
        L5f:
            return r2
        L60:
            java.util.List r7 = (java.util.List) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$catalogue$1$pagingSource$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (ab.e<? super List<Product>>) obj3);
    }
}
