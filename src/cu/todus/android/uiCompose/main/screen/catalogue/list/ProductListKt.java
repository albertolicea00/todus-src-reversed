package cu.todus.android.uiCompose.main.screen.catalogue.list;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridSpanKt;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.s;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.uiCompose.main.screen.catalogue.CatalogueAction;
import cu.todus.android.uiCompose.main.screen.catalogue.list.ProductListKt;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import lb.o;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ax\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\r2\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "lazyListState", "Landroidx/paging/compose/LazyPagingItems;", "Lcu/todus/android/data/db/entity/cache/Product;", "products", "", "fromOwner", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueAction;", "Lua/k0;", "onClick", "Lkotlin/Function1;", "onLongClick", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "header", "ProductList", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/paging/compose/LazyPagingItems;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ProductListKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_]]")
    public static final void ProductList(final Modifier modifier, final LazyGridState lazyListState, final LazyPagingItems<Product> products, final boolean z10, final Function2 onClick, final Function1 onLongClick, Function2 function2, Composer composer, final int i10, final int i11) {
        int i12;
        Function2 function3;
        final Function2 function4;
        y.i(modifier, "modifier");
        y.i(lazyListState, "lazyListState");
        y.i(products, "products");
        y.i(onClick, "onClick");
        y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1935440874);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(products) : composerStartRestartGroup.changedInstance(products) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 16384 : 8192;
        }
        int i13 = i11 & 64;
        if (i13 != 0) {
            i12 |= 1572864;
            function3 = function2;
        } else {
            function3 = function2;
            if ((i10 & 1572864) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
            }
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 533651) != 533650, i12 & 1)) {
            final Function2 lambda$1035467633$app_productionPFast = i13 != 0 ? ComposableSingletons$ProductListKt.INSTANCE.getLambda$1035467633$app_productionPFast() : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1935440874, i12, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductList (ProductList.kt:27)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            GridCells.Fixed fixed = new GridCells.Fixed(2);
            boolean z11 = ((3670016 & i12) == 1048576) | ((i12 & 896) == 256 || ((i12 & 512) != 0 && composerStartRestartGroup.changedInstance(products))) | ((i12 & 7168) == 2048) | ((57344 & i12) == 16384);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: o7.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProductListKt.ProductList$lambda$0$0$0(products, lambda$1035467633$app_productionPFast, z10, onClick, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function2 function5 = lambda$1035467633$app_productionPFast;
            LazyGridDslKt.LazyVerticalGrid(fixed, modifierFillMaxHeight$default, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, ((i12 << 3) & 896) | 48, 0, 1016);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function4 = function3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o7.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductListKt.ProductList$lambda$1(modifier, lazyListState, products, z10, onClick, onLongClick, function4, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductList$lambda$0$0$0(final LazyPagingItems lazyPagingItems, final Function2 function2, final boolean z10, final Function2 function3, LazyGridScope LazyVerticalGrid) {
        y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.CC.a(LazyVerticalGrid, null, new Function1() { // from class: o7.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductListKt.ProductList$lambda$0$0$0$0((LazyGridItemSpanScope) obj);
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-1871622680, true, new Function3() { // from class: o7.w
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProductListKt.ProductList$lambda$0$0$0$1(function2, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 5, null);
        LazyGridScope.CC.b(LazyVerticalGrid, lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: o7.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductListKt.ProductList$lambda$0$0$0$2((Product) obj);
            }
        }), null, LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: o7.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductListKt.ProductList$lambda$0$0$0$3((Product) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-1822882847, true, new o() { // from class: o7.z
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ProductListKt.ProductList$lambda$0$0$0$4(lazyPagingItems, z10, function3, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        LazyGridScope.CC.a(LazyVerticalGrid, null, new Function1() { // from class: o7.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductListKt.ProductList$lambda$0$0$0$5((LazyGridItemSpanScope) obj);
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-1804927151, true, new Function3() { // from class: o7.p
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProductListKt.ProductList$lambda$0$0$0$6(lazyPagingItems, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 5, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan ProductList$lambda$0$0$0$0(LazyGridItemSpanScope item) {
        y.i(item, "$this$item");
        return GridItemSpan.m1837boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 ProductList$lambda$0$0$0$1(Function2 function2, LazyGridItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1871622680, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductList.kt:36)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ProductList$lambda$0$0$0$2(Product p10) {
        y.i(p10, "p");
        return Integer.valueOf(p10.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ProductList$lambda$0$0$0$3(Product i10) {
        y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ProductList$lambda$0$0$0$4(LazyPagingItems lazyPagingItems, boolean z10, final Function2 function2, LazyGridItemScope items, int i10, Composer composer, int i11) {
        int i12;
        y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(items) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1822882847, i12, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductList.kt:44)");
            }
            final Product product = (Product) lazyPagingItems.get(i10);
            if (product != null) {
                composer.startReplaceGroup(63708737);
                Modifier modifierA = s.a(items, Modifier.INSTANCE, null, null, null, 2, null);
                boolean zChanged = composer.changed(function2) | composer.changed(product);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: o7.o
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductListKt.ProductList$lambda$0$0$0$4$0$0(function2, product);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                a aVar = (a) objRememberedValue;
                boolean zChanged2 = composer.changed(function2) | composer.changed(product);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: o7.s
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductListKt.ProductList$lambda$0$0$0$4$1$0(function2, product);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                a aVar2 = (a) objRememberedValue2;
                boolean zChanged3 = composer.changed(function2) | composer.changed(product);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new a() { // from class: o7.t
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductListKt.ProductList$lambda$0$0$0$4$2$0(function2, product);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                a aVar3 = (a) objRememberedValue3;
                boolean zChanged4 = composer.changed(function2) | composer.changed(product);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new a() { // from class: o7.u
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductListKt.ProductList$lambda$0$0$0$4$3$0(function2, product);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ProductItemKt.ProductItem(modifierA, product, z10, aVar, aVar2, aVar3, (a) objRememberedValue4, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(556269461);
                ProductItemKt.ProductPlaceholder(composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductList$lambda$0$0$0$4$0$0(Function2 function2, Product product) {
        function2.invoke(product, CatalogueAction.DETAILS);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductList$lambda$0$0$0$4$1$0(Function2 function2, Product product) {
        function2.invoke(product, CatalogueAction.SHARE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductList$lambda$0$0$0$4$2$0(Function2 function2, Product product) {
        function2.invoke(product, CatalogueAction.EDIT);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductList$lambda$0$0$0$4$3$0(Function2 function2, Product product) {
        function2.invoke(product, CatalogueAction.DELETE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan ProductList$lambda$0$0$0$5(LazyGridItemSpanScope item) {
        y.i(item, "$this$item");
        return GridItemSpan.m1837boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 ProductList$lambda$0$0$0$6(LazyPagingItems lazyPagingItems, LazyGridItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1804927151, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductList.kt:68)");
            }
            PagerStateIndicatorKt.PagerStateIndicator(null, null, null, null, lazyPagingItems, composer, LazyPagingItems.$stable << 12, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductList$lambda$1(Modifier modifier, LazyGridState lazyGridState, LazyPagingItems lazyPagingItems, boolean z10, Function2 function2, Function1 function1, Function2 function3, int i10, int i11, Composer composer, int i12) {
        ProductList(modifier, lazyGridState, lazyPagingItems, z10, function2, function1, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
