package cu.todus.android.uiCompose.main.screen.manageStickers;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.content.StickerContentKt;
import cu.z17.views.check.Z17CheckKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a=\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u000f\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "name", "", "isDownloaded", "url", "Lkotlin/Function1;", "Lua/k0;", "onSave", "StickerPackItem", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "StickerPackItemPlaceholder", "(Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StickerPackItemKt {
    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:38:0x0078  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:43:0x0085  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0098  */
    /* JADX WARN: Code duplicated, block: B:50:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:65:0x010a  */
    /* JADX WARN: Code duplicated, block: B:66:0x010e  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:75:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StickerPackItem(final String name, boolean z10, final String url, final Function1 onSave, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z11;
        int i13;
        boolean z12;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z14;
        boolean z15;
        boolean z16;
        Object objRememberedValue;
        lb.a constructor;
        Object objRememberedValue2;
        Composer.Companion companion;
        Object objRememberedValue3;
        int i14;
        int i15;
        y.i(name, "name");
        y.i(url, "url");
        y.i(onSave, "onSave");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1585615433);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(name) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        int i16 = i11 & 2;
        if (i16 == 0) {
            if ((i10 & 48) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 32 : 16;
            }
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changed(url)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i12 |= i15;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onSave)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i12 |= i14;
            }
            i13 = i12;
            if ((i13 & 1171) != 1170) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                if (i16 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1585615433, i13, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.StickerPackItem (StickerPackItem.kt:30)");
                }
                Modifier.Companion companion2 = Modifier.INSTANCE;
                if ((i13 & 7168) == 2048) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                int i17 = i13 & 112;
                z16 = z15 | (i17 == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z16 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.q
                        @Override // lb.a
                        public final Object invoke() {
                            return StickerPackItemKt.StickerPackItem$lambda$0$0(onSave, z14);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue, 15, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Z17CheckKt.Z17Check(null, z14, onSave, composerStartRestartGroup, ((i13 >> 3) & 896) | i17, 1);
                boolean z17 = z14;
                float f10 = 10;
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
                Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion2, 1.0f, false, 2, null), name, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, (i13 << 3) & 112, 56);
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(60));
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.r
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StickerPackItemKt.StickerPackItem$lambda$1$0$0((MessageAction) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function2 function2 = (Function2) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.s
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StickerPackItemKt.StickerPackItem$lambda$1$1$0((MessageAction) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup = composerStartRestartGroup;
                StickerContentKt.StickerView(modifierM1769size3ABfNKs, function2, (Function2) objRememberedValue3, a0.O(url, ".tgs", ".json", false, 4, null), composerStartRestartGroup, 438, 0);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z17;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.t
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StickerPackItemKt.StickerPackItem$lambda$2(name, z13, url, onSave, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        z11 = z10;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changed(url)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i12 |= i15;
        }
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onSave)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i12 |= i14;
        }
        i13 = i12;
        if ((i13 & 1171) != 1170) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
            if (i16 != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1585615433, i13, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.StickerPackItem (StickerPackItem.kt:30)");
            }
            Modifier.Companion companion4 = Modifier.INSTANCE;
            if ((i13 & 7168) == 2048) {
                z15 = true;
            } else {
                z15 = false;
            }
            int i18 = i13 & 112;
            z16 = z15 | (i18 == 32);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z16) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.q
                    @Override // lb.a
                    public final Object invoke() {
                        return StickerPackItemKt.StickerPackItem$lambda$0$0(onSave, z14);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.q
                    @Override // lb.a
                    public final Object invoke() {
                        return StickerPackItemKt.StickerPackItem$lambda$0$0(onSave, z14);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(companion4, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default2);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            constructor = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            Z17CheckKt.Z17Check(null, z14, onSave, composerStartRestartGroup, ((i13 >> 3) & 896) | i18, 1);
            boolean z18 = z14;
            float f11 = 10;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion4, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance2, companion4, 1.0f, false, 2, null), name, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, (i13 << 3) & 112, 56);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion4, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
            Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(60));
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.r
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StickerPackItemKt.StickerPackItem$lambda$1$0$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function2 function3 = (Function2) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.s
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StickerPackItemKt.StickerPackItem$lambda$1$1$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup = composerStartRestartGroup;
            StickerContentKt.StickerView(modifierM1769size3ABfNKs2, function3, (Function2) objRememberedValue3, a0.O(url, ".tgs", ".json", false, 4, null), composerStartRestartGroup, 438, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z18;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z13 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StickerPackItemKt.StickerPackItem$lambda$2(name, z13, url, onSave, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StickerPackItem$lambda$0$0(Function1 function1, boolean z10) {
        function1.invoke(Boolean.valueOf(!z10));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StickerPackItem$lambda$1$0$0(MessageAction messageAction, int i10) {
        y.i(messageAction, "messageAction");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StickerPackItem$lambda$1$1$0(MessageAction messageAction, int i10) {
        y.i(messageAction, "messageAction");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StickerPackItem$lambda$2(String str, boolean z10, String str2, Function1 function1, int i10, int i11, Composer composer, int i12) {
        StickerPackItem(str, z10, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StickerPackItemPlaceholder(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1051854231);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1051854231, i10, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.StickerPackItemPlaceholder (StickerPackItem.kt:57)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(20), 0.0f, 2, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.m1755height3ABfNKs(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(16)), composerStartRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            Z17ShimmerLoaderKt.Z17Shimmer(ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(60)), 1.0f, false, 2, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StickerPackItemKt.StickerPackItemPlaceholder$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StickerPackItemPlaceholder$lambda$1(int i10, Composer composer, int i11) {
        StickerPackItemPlaceholder(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
