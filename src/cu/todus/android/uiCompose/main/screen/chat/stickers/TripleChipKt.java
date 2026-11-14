package cu.todus.android.uiCompose.main.screen.chat.stickers;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AccessTimeKt;
import androidx.compose.material.icons.outlined.EmojiEmotionsKt;
import androidx.compose.material.icons.outlined.FavoriteBorderKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a+\u0010\u0005\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "", "Lua/k0;", "onSelected", "selected", "TripleChip", "(Lkotlin/jvm/functions/Function1;ILandroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TripleChipKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TripleChip(final Function1 onSelected, int i10, Composer composer, final int i11) {
        int i12;
        long onBackground;
        long onBackground2;
        long onBackground3;
        long onBackground4;
        long onBackground5;
        long onBackground6;
        final int i13 = i10;
        kotlin.jvm.internal.y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(1691863247);
        if ((i11 & 6) == 0) {
            i12 = i11 | (composerStartRestartGroup.changedInstance(onSelected) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(i13) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1691863247, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.stickers.TripleChip (TripleChip.kt:25)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            int i14 = i12 & 14;
            boolean z10 = i14 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.i0
                    @Override // lb.a
                    public final Object invoke() {
                        return TripleChipKt.TripleChip$lambda$0$0$0(onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            float f10 = 60;
            float f11 = 30;
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.m1774width3ABfNKs(modifierM1240clickableoSLSa3U$default, Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(f11));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            float f12 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifierM1755height3ABfNKs, materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), null, 2, null), Dp.m8823constructorimpl(f12));
            float f13 = (float) 1.5d;
            float fM8823constructorimpl = Dp.m8823constructorimpl(f13);
            if (i13 == 0) {
                composerStartRestartGroup.startReplaceGroup(906815450);
                onBackground = materialTheme.getColorScheme(composerStartRestartGroup, i15).getPrimary();
            } else {
                composerStartRestartGroup.startReplaceGroup(906816703);
                onBackground = materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierM1725padding3ABfNKs, fM8823constructorimpl, onBackground, RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f11), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 6, null));
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            ImageVector accessTime = AccessTimeKt.getAccessTime(outlined);
            ColorFilter.Companion companion3 = ColorFilter.INSTANCE;
            if (i13 == 0) {
                composerStartRestartGroup.startReplaceGroup(906825114);
                onBackground2 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getPrimary();
            } else {
                composerStartRestartGroup.startReplaceGroup(906826367);
                onBackground2 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            }
            composerStartRestartGroup.endReplaceGroup();
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1216borderxT4_qwU, accessTime, null, ColorFilter.Companion.m5907tintxETnrds$default(companion3, onBackground2, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            boolean z11 = i14 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.j0
                    @Override // lb.a
                    public final Object invoke() {
                        return TripleChipKt.TripleChip$lambda$0$1$0(onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.m1755height3ABfNKs(SizeKt.m1774width3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue2, 15, null), Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(f11)), materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), null, 2, null), Dp.m8823constructorimpl(f12));
            float fM8823constructorimpl2 = Dp.m8823constructorimpl(f13);
            if (i10 == 1) {
                composerStartRestartGroup.startReplaceGroup(906839738);
                onBackground3 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getPrimary();
            } else {
                composerStartRestartGroup.startReplaceGroup(906840991);
                onBackground3 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM1217borderxT4_qwU$default = BorderKt.m1217borderxT4_qwU$default(modifierM1725padding3ABfNKs2, fM8823constructorimpl2, onBackground3, null, 4, null);
            ImageVector favoriteBorder = FavoriteBorderKt.getFavoriteBorder(outlined);
            if (i10 == 1) {
                composerStartRestartGroup.startReplaceGroup(906846746);
                onBackground4 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getPrimary();
            } else {
                composerStartRestartGroup.startReplaceGroup(906847999);
                onBackground4 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            }
            composerStartRestartGroup.endReplaceGroup();
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1217borderxT4_qwU$default, favoriteBorder, null, ColorFilter.Companion.m5907tintxETnrds$default(companion3, onBackground4, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            boolean z12 = i14 == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.k0
                    @Override // lb.a
                    public final Object invoke() {
                        return TripleChipKt.TripleChip$lambda$0$2$0(onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.m1755height3ABfNKs(SizeKt.m1774width3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue3, 15, null), Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(f11)), materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), null, 2, null), Dp.m8823constructorimpl(f12));
            float fM8823constructorimpl3 = Dp.m8823constructorimpl(f13);
            if (i10 == 2) {
                composerStartRestartGroup.startReplaceGroup(906861370);
                onBackground5 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getPrimary();
            } else {
                composerStartRestartGroup.startReplaceGroup(906862623);
                onBackground5 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(modifierM1725padding3ABfNKs3, fM8823constructorimpl3, onBackground5, RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(0.0f, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), 0.0f, 9, null));
            ImageVector emojiEmotions = EmojiEmotionsKt.getEmojiEmotions(outlined);
            if (i10 == 2) {
                composerStartRestartGroup.startReplaceGroup(906871002);
                onBackground6 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getPrimary();
            } else {
                composerStartRestartGroup.startReplaceGroup(906872255);
                onBackground6 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            }
            composerStartRestartGroup.endReplaceGroup();
            i13 = i10;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1216borderxT4_qwU2, emojiEmotions, null, ColorFilter.Companion.m5907tintxETnrds$default(companion3, onBackground6, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.stickers.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TripleChipKt.TripleChip$lambda$1(onSelected, i13, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TripleChip$lambda$0$0$0(Function1 function1) {
        function1.invoke(0);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TripleChip$lambda$0$1$0(Function1 function1) {
        function1.invoke(1);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TripleChip$lambda$0$2$0(Function1 function1) {
        function1.invoke(2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TripleChip$lambda$1(Function1 function1, int i10, int i11, Composer composer, int i12) {
        TripleChip(function1, i10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return ua.k0.f43947a;
    }
}
