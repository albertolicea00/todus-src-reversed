package cu.todus.android.uiCompose.main.screen.catalogue;

import cb.m;
import cu.todus.android.data.db.entity.cache.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$catalogueFiltered$1$pagingSource$1", f = "CatalogueViewModel.kt", l = {87, 88}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcu/todus/android/data/db/entity/cache/Product;", "offset", "", "limit"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class CatalogueViewModel$catalogueFiltered$1$pagingSource$1 extends m implements Function3 {
    final /* synthetic */ String $filter;
    final /* synthetic */ String $tag;
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    int label;
    final /* synthetic */ CatalogueViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CatalogueViewModel$catalogueFiltered$1$pagingSource$1(CatalogueViewModel catalogueViewModel, String str, String str2, ab.e<? super CatalogueViewModel$catalogueFiltered$1$pagingSource$1> eVar) {
        super(3, eVar);
        this.this$0 = catalogueViewModel;
        this.$tag = str;
        this.$filter = str2;
    }

    public final Object invoke(int i10, int i11, ab.e<? super List<Product>> eVar) {
        CatalogueViewModel$catalogueFiltered$1$pagingSource$1 catalogueViewModel$catalogueFiltered$1$pagingSource$1 = new CatalogueViewModel$catalogueFiltered$1$pagingSource$1(this.this$0, this.$tag, this.$filter, eVar);
        catalogueViewModel$catalogueFiltered$1$pagingSource$1.I$0 = i10;
        catalogueViewModel$catalogueFiltered$1$pagingSource$1.I$1 = i11;
        return catalogueViewModel$catalogueFiltered$1$pagingSource$1.invokeSuspend(k0.f43947a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        if (r9 == r7) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
    
        if (r9 == r7) goto L19;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            int r4 = r8.I$0
            int r5 = r8.I$1
            java.lang.Object r7 = bb.b.g()
            int r0 = r8.label
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L22
            if (r0 == r2) goto L1e
            if (r0 != r1) goto L16
            ua.v.b(r9)
            goto L66
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1e:
            ua.v.b(r9)
            goto L44
        L22:
            ua.v.b(r9)
            cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r9 = r8.this$0
            java.lang.String r9 = r9.getToDusId()
            boolean r9 = le.d0.q0(r9)
            if (r9 == 0) goto L47
            cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r9 = r8.this$0
            cu.todus.android.repositories.CatalogueRepository r9 = cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel.access$getCatalogueRepository$p(r9)
            r8.I$0 = r4
            r8.I$1 = r5
            r8.label = r2
            java.lang.Object r9 = r9.getMyProducts(r4, r5, r8)
            if (r9 != r7) goto L44
            goto L65
        L44:
            java.util.List r9 = (java.util.List) r9
            return r9
        L47:
            cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r9 = r8.this$0
            cu.todus.android.repositories.CatalogueRepository r0 = cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel.access$getCatalogueRepository$p(r9)
            r9 = r1
            java.lang.String r1 = r8.$tag
            java.lang.String r2 = r8.$filter
            cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel r3 = r8.this$0
            java.lang.String r3 = r3.getToDusId()
            r8.I$0 = r4
            r8.I$1 = r5
            r8.label = r9
            r6 = r8
            java.lang.Object r9 = r0.getOtherProductsFiltered(r1, r2, r3, r4, r5, r6)
            if (r9 != r7) goto L66
        L65:
            return r7
        L66:
            java.util.List r9 = (java.util.List) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$catalogueFiltered$1$pagingSource$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (ab.e<? super List<Product>>) obj3);
    }
}
