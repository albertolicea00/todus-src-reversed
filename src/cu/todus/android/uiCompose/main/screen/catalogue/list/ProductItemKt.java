package cu.todus.android.uiCompose.main.screen.catalogue.list;

import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.uiCompose.main.screen.catalogue.list.ProductItemKt;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a_\u0010\f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u000f\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a;\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/data/db/entity/cache/Product;", "product", "", "fromOwner", "Lkotlin/Function0;", "Lua/k0;", "onRequestDetails", "onRequestShare", "onRequestEdit", "onRequestDelete", "ProductItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/entity/cache/Product;ZLlb/a;Llb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "ProductPlaceholder", "(Landroidx/compose/runtime/Composer;I)V", "", "tag", "isSelected", "onClick", "ProductTagItem", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLlb/a;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ProductItemKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ProductItem(final Modifier modifier, final Product product, final boolean z10, final a onRequestDetails, final a onRequestShare, final a onRequestEdit, final a onRequestDelete, Composer composer, final int i10) {
        int i11;
        y.i(modifier, "modifier");
        y.i(product, "product");
        y.i(onRequestDetails, "onRequestDetails");
        y.i(onRequestShare, "onRequestShare");
        y.i(onRequestEdit, "onRequestEdit");
        y.i(onRequestDelete, "onRequestDelete");
        Composer composerStartRestartGroup = composer.startRestartGroup(61909436);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(product) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onRequestDetails) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onRequestShare) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onRequestEdit) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onRequestDelete) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 599187) != 599186, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(61909436, i11, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductItem (ProductItem.kt:51)");
            }
            int i12 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            float f10 = 3;
            float f11 = 15;
            Modifier modifierM5480shadows4CzXII$default = ShadowKt.m5480shadows4CzXII$default(PaddingKt.m1726paddingVpY3zN4(modifier, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(6)), Dp.m8823constructorimpl(1), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)), false, 0L, 0L, 28, null);
            int i13 = i11 & 7168;
            boolean z11 = i13 == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: o7.e
                    @Override // lb.a
                    public final Object invoke() {
                        return ProductItemKt.ProductItem$lambda$0$0(onRequestDetails);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierClip = ClipKt.clip(ClickableKt.m1240clickableoSLSa3U$default(modifierM5480shadows4CzXII$default, false, null, null, null, (a) objRememberedValue, 15, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composerStartRestartGroup, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            int i14 = i11;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(i12 / 5)), product.getPictureUrl(), Integer.valueOf(R.drawable.bag_cart), null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composerStartRestartGroup, 24576, 488);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion3, materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), null, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composerStartRestartGroup, 0);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
            a constructor2 = companion2.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), centerVertically, composerStartRestartGroup, 54);
            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            a constructor3 = companion2.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            float f12 = 10;
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(RowScopeInstance.INSTANCE, PaddingKt.m1727paddingVpY3zN4$default(companion3, Dp.m8823constructorimpl(f12), 0.0f, 2, null), 1.0f, false, 2, null), product.getName(), materialTheme.getTypography(composerStartRestartGroup, i15).getBodyMedium(), 0L, 1, 0, composerStartRestartGroup, 24576, 40);
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1729paddingqDBjuR0$default(companion3, 0.0f, 0.0f, Dp.m8823constructorimpl(f12), 0.0f, 11, null), Other.INSTANCE.m10121getYellow0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8))), Dp.m8823constructorimpl(f10)), "$" + product.getPrice(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getBodyMedium(), Color.INSTANCE.m5892getBlack0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), 0L, 0, 8, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
            composerStartRestartGroup.endNode();
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-39175565);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getSpaceAround(), companion.getCenterVertically(), composerStartRestartGroup, 54);
                int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                a constructor4 = companion2.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion2.getSetModifier());
                boolean z12 = (i14 & 57344) == 16384;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: o7.f
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductItemKt.ProductItem$lambda$1$0$1$0$0(onRequestShare);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposableSingletons$ProductItemKt composableSingletons$ProductItemKt = ComposableSingletons$ProductItemKt.INSTANCE;
                IconButtonKt.IconButton((a) objRememberedValue2, null, false, null, null, null, composableSingletons$ProductItemKt.m9845getLambda$2147322427$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                boolean z13 = (i14 & 458752) == 131072;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z13 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new a() { // from class: o7.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductItemKt.ProductItem$lambda$1$0$1$1$0(onRequestEdit);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                IconButtonKt.IconButton((a) objRememberedValue3, null, false, null, null, null, composableSingletons$ProductItemKt.m9844getLambda$1912907204$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                boolean z14 = (i14 & 3670016) == 1048576;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z14 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new a() { // from class: o7.h
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductItemKt.ProductItem$lambda$1$0$1$2$0(onRequestDelete);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                IconButtonKt.IconButton((a) objRememberedValue4, null, false, null, null, null, composableSingletons$ProductItemKt.m9846getLambda$690304579$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-37435876);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion3, Dp.m8823constructorimpl(5));
                String strStringResource = StringResources_androidKt.stringResource(R.string.details, composerStartRestartGroup, 0);
                boolean z15 = i13 == 2048;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z15 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new a() { // from class: o7.i
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductItemKt.ProductItem$lambda$1$0$2$0(onRequestDetails);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Z17ButtonsKt.Z17SecondaryDialogButton(modifierM1725padding3ABfNKs, (a) objRememberedValue5, strStringResource, null, true, false, false, composerStartRestartGroup, 24582, LocationRequestCompat.QUALITY_LOW_POWER);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o7.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductItemKt.ProductItem$lambda$2(modifier, product, z10, onRequestDetails, onRequestShare, onRequestEdit, onRequestDelete, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductItem$lambda$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductItem$lambda$1$0$1$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductItem$lambda$1$0$1$1$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductItem$lambda$1$0$1$2$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductItem$lambda$1$0$2$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductItem$lambda$2(Modifier modifier, Product product, boolean z10, a aVar, a aVar2, a aVar3, a aVar4, int i10, Composer composer, int i11) {
        ProductItem(modifier, product, z10, aVar, aVar2, aVar3, aVar4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ProductPlaceholder(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2022514976);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2022514976, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductPlaceholder (ProductItem.kt:156)");
            }
            int i11 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(companion, Dp.m8823constructorimpl(3), Dp.m8823constructorimpl(6));
            float fM8823constructorimpl = Dp.m8823constructorimpl(1);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            float f10 = 15;
            Modifier modifierClip = ClipKt.clip(BorderKt.m1216borderxT4_qwU(modifierM1726paddingVpY3zN4, fM8823constructorimpl, materialTheme.getColorScheme(composerStartRestartGroup, i12).getOnBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Z17ShimmerLoaderKt.Z17Shimmer(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(i11 / 3)), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(95), 7, null), composerStartRestartGroup, 0);
            Modifier modifierAlign = boxScopeInstance.align(companion, companion2.getBottomCenter());
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(50)), Integer.valueOf(R.drawable.triangle), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground(), 0, 2, null), ContentScale.INSTANCE.getFillBounds(), null, 0, null, null, composerStartRestartGroup, 24582, 484);
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground(), null, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
            a constructor3 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            float f11 = 10;
            float f12 = 20;
            Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.m1774width3ABfNKs(SizeKt.m1755height3ABfNKs(OffsetKt.m1685offsetVpY3zN4$default(columnScopeInstance.align(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null), companion2.getEnd()), 0.0f, Dp.m8823constructorimpl(-Dp.m8823constructorimpl(f12)), 1, null), Dp.m8823constructorimpl(f12)), Dp.m8823constructorimpl(70)), composerStartRestartGroup, 0);
            Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.fillMaxWidth$default(SizeKt.m1755height3ABfNKs(OffsetKt.m1685offsetVpY3zN4$default(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f11), 0.0f, 2, null), 0.0f, Dp.m8823constructorimpl(-Dp.m8823constructorimpl(18)), 1, null), Dp.m8823constructorimpl(f12)), 0.0f, 1, null), composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o7.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductItemKt.ProductPlaceholder$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductPlaceholder$lambda$1(int i10, Composer composer, int i11) {
        ProductPlaceholder(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:76:0x0145  */
    /* JADX WARN: Code duplicated, block: B:79:0x014c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0158  */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ProductTagItem(Modifier modifier, final String tag, boolean z10, a aVar, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        boolean z11;
        int i13;
        final a aVar2;
        int i14;
        boolean z12;
        final Modifier modifier3;
        final boolean z13;
        final a aVar3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z14;
        boolean z15;
        Object objRememberedValue;
        Modifier modifierM1204backgroundbw27NRU;
        Object objRememberedValue2;
        y.i(tag, "tag");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1214598908);
        int i15 = i11 & 1;
        if (i15 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(tag) ? 32 : 16;
        }
        int i16 = i11 & 4;
        if (i16 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
            }
            i13 = i11 & 8;
            if (i13 != 0) {
                if ((i10 & 3072) == 0) {
                    aVar2 = aVar;
                    if (composerStartRestartGroup.changedInstance(aVar2)) {
                        i14 = 2048;
                    } else {
                        i14 = 1024;
                    }
                    i12 |= i14;
                }
                if ((i12 & 1171) != 1170) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                    if (i15 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i16 != 0) {
                        z14 = false;
                    } else {
                        z14 = z11;
                    }
                    if (i13 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new a() { // from class: o7.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar2 = (a) objRememberedValue2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1214598908, i12, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductTagItem (ProductItem.kt:219)");
                    }
                    float f10 = 3;
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(modifier4, Dp.m8823constructorimpl(f10));
                    z15 = (i12 & 7168) == 2048;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: o7.l
                            @Override // lb.a
                            public final Object invoke() {
                                return ProductItemKt.ProductTagItem$lambda$1$0(aVar2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs, false, null, null, null, (a) objRememberedValue, 15, null);
                    modifierM1204backgroundbw27NRU = Modifier.INSTANCE;
                    if (!z14) {
                        modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1204backgroundbw27NRU, Color.m5865copywmQWz5c$default(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(tag)), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8)));
                    }
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(modifierM1240clickableoSLSa3U$default.then(modifierM1204backgroundbw27NRU), Dp.m8823constructorimpl(f10)), tag, null, 0L, 0, 0, composerStartRestartGroup, i12 & 112, 60);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z13 = z14;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z13 = z11;
                }
                aVar3 = aVar2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o7.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProductItemKt.ProductTagItem$lambda$2(modifier3, tag, z13, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 3072;
            aVar2 = aVar;
            if ((i12 & 1171) != 1170) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i16 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (i13 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new a() { // from class: o7.k
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar2 = (a) objRememberedValue2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1214598908, i12, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductTagItem (ProductItem.kt:219)");
                }
                float f11 = 3;
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(modifier4, Dp.m8823constructorimpl(f11));
                if ((i12 & 7168) == 2048) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue = new a() { // from class: o7.l
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductItemKt.ProductTagItem$lambda$1$0(aVar2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new a() { // from class: o7.l
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductItemKt.ProductTagItem$lambda$1$0(aVar2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs2, false, null, null, null, (a) objRememberedValue, 15, null);
                modifierM1204backgroundbw27NRU = Modifier.INSTANCE;
                if (!z14) {
                    modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1204backgroundbw27NRU, Color.m5865copywmQWz5c$default(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(tag)), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8)));
                }
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(modifierM1240clickableoSLSa3U$default2.then(modifierM1204backgroundbw27NRU), Dp.m8823constructorimpl(f11)), tag, null, 0L, 0, 0, composerStartRestartGroup, i12 & 112, 60);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z13 = z14;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z13 = z11;
            }
            aVar3 = aVar2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o7.m
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProductItemKt.ProductTagItem$lambda$2(modifier3, tag, z13, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z11 = z10;
        i13 = i11 & 8;
        if (i13 != 0) {
            if ((i10 & 3072) == 0) {
                aVar2 = aVar;
                if (composerStartRestartGroup.changedInstance(aVar2)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i12 |= i14;
            }
            if ((i12 & 1171) != 1170) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i16 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (i13 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new a() { // from class: o7.k
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar2 = (a) objRememberedValue2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1214598908, i12, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductTagItem (ProductItem.kt:219)");
                }
                float f12 = 3;
                Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(modifier4, Dp.m8823constructorimpl(f12));
                if ((i12 & 7168) == 2048) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue = new a() { // from class: o7.l
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductItemKt.ProductTagItem$lambda$1$0(aVar2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new a() { // from class: o7.l
                        @Override // lb.a
                        public final Object invoke() {
                            return ProductItemKt.ProductTagItem$lambda$1$0(aVar2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default3 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs3, false, null, null, null, (a) objRememberedValue, 15, null);
                modifierM1204backgroundbw27NRU = Modifier.INSTANCE;
                if (!z14) {
                    modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1204backgroundbw27NRU, Color.m5865copywmQWz5c$default(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(tag)), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8)));
                }
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(modifierM1240clickableoSLSa3U$default3.then(modifierM1204backgroundbw27NRU), Dp.m8823constructorimpl(f12)), tag, null, 0L, 0, 0, composerStartRestartGroup, i12 & 112, 60);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z13 = z14;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z13 = z11;
            }
            aVar3 = aVar2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o7.m
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProductItemKt.ProductTagItem$lambda$2(modifier3, tag, z13, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        aVar2 = aVar;
        if ((i12 & 1171) != 1170) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            if (i15 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i16 != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if (i13 != 0) {
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: o7.k
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                aVar2 = (a) objRememberedValue2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1214598908, i12, -1, "cu.todus.android.uiCompose.main.screen.catalogue.list.ProductTagItem (ProductItem.kt:219)");
            }
            float f13 = 3;
            Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(modifier4, Dp.m8823constructorimpl(f13));
            if ((i12 & 7168) == 2048) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z15) {
                objRememberedValue = new a() { // from class: o7.l
                    @Override // lb.a
                    public final Object invoke() {
                        return ProductItemKt.ProductTagItem$lambda$1$0(aVar2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new a() { // from class: o7.l
                    @Override // lb.a
                    public final Object invoke() {
                        return ProductItemKt.ProductTagItem$lambda$1$0(aVar2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default4 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs4, false, null, null, null, (a) objRememberedValue, 15, null);
            modifierM1204backgroundbw27NRU = Modifier.INSTANCE;
            if (!z14) {
                modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1204backgroundbw27NRU, Color.m5865copywmQWz5c$default(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(tag)), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(8)));
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(modifierM1240clickableoSLSa3U$default4.then(modifierM1204backgroundbw27NRU), Dp.m8823constructorimpl(f13)), tag, null, 0L, 0, 0, composerStartRestartGroup, i12 & 112, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z13 = z14;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z13 = z11;
        }
        aVar3 = aVar2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o7.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductItemKt.ProductTagItem$lambda$2(modifier3, tag, z13, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductTagItem$lambda$1$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ProductTagItem$lambda$2(Modifier modifier, String str, boolean z10, a aVar, int i10, int i11, Composer composer, int i12) {
        ProductTagItem(modifier, str, z10, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
