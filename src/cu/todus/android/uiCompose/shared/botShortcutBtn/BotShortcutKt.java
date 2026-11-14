package cu.todus.android.uiCompose.shared.botShortcutBtn;

import android.graphics.Color;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.SubdirectoryArrowRightKt;
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
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.uiCompose.shared.botShortcutBtn.BotShortcutKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "botShortcut", "Lkotlin/Function0;", "Lua/k0;", "onClick", "BotShortcutBtn", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/entity/cache/BotShortcut;Llb/a;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BotShortcutKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BotShortcutBtn(Modifier modifier, final BotShortcut botShortcut, final a onClick, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Composer composer2;
        final Modifier modifier3;
        boolean z10;
        Modifier modifier4;
        Composer composer3;
        Composer composer4;
        y.i(botShortcut, "botShortcut");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1093444348);
        int i13 = i11 & 1;
        if (i13 != 0) {
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
            i12 |= composerStartRestartGroup.changed(botShortcut) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            Modifier modifier5 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1093444348, i12, -1, "cu.todus.android.uiCompose.shared.botShortcutBtn.BotShortcutBtn (BotShortcut.kt:29)");
            }
            if (y.d(botShortcut.getLocation(), BotShortcut.LOCATION_HOME_FLOATING)) {
                composerStartRestartGroup.startReplaceGroup(1466976294);
                z10 = (i12 & 896) == 256;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: o8.a
                        @Override // lb.a
                        public final Object invoke() {
                            return BotShortcutKt.BotShortcutBtn$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifier5, false, null, null, null, (a) objRememberedValue, 15, null);
                Modifier modifier6 = modifier5;
                Modifier modifierM5480shadows4CzXII$default = ShadowKt.m5480shadows4CzXII$default(modifierM1240clickableoSLSa3U$default, Dp.m8823constructorimpl(2), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)), false, 0L, 0L, 28, null);
                String btnColor = botShortcut.getBtnColor();
                float f10 = 8;
                Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM5480shadows4CzXII$default, ColorKt.Color(Color.parseColor(d0.q0(btnColor) ? "#e53935" : btnColor)), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), Dp.m8823constructorimpl(16), Dp.m8823constructorimpl(f10));
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                if (d0.q0(botShortcut.getIcon())) {
                    composer4 = composerStartRestartGroup;
                    composer4.startReplaceGroup(-1328684577);
                    composer4.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-181416836);
                    composer4 = composerStartRestartGroup;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), botShortcut.getIcon(), SubdirectoryArrowRightKt.getSubdirectoryArrowRight(Icons.Outlined.INSTANCE), null, null, null, 0, null, null, composer4, 6, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    composer4.endReplaceGroup();
                }
                Composer composer5 = composer4;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, botShortcut.getLabel(), null, androidx.compose.ui.graphics.Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 10, composer5, 199680, 21);
                composer5.endNode();
                composer5.endReplaceGroup();
                modifier4 = modifier6;
                composer2 = composer5;
            } else {
                Modifier modifier7 = modifier5;
                composerStartRestartGroup.startReplaceGroup(-1767257249);
                z10 = (i12 & 896) == 256;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z10 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: o8.b
                        @Override // lb.a
                        public final Object invoke() {
                            return BotShortcutKt.BotShortcutBtn$lambda$3$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(modifier7, false, null, null, null, (a) objRememberedValue2, 15, null);
                modifier4 = modifier7;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
                int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default2);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                if (d0.q0(botShortcut.getIcon())) {
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(-356488234);
                    composer3.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(542672224);
                    Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30));
                    String btnColor2 = botShortcut.getBtnColor();
                    composer3 = composerStartRestartGroup;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1769size3ABfNKs, ColorKt.Color(Color.parseColor(d0.q0(btnColor2) ? "#e53935" : btnColor2)), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(2)), botShortcut.getIcon(), SubdirectoryArrowRightKt.getSubdirectoryArrowRight(Icons.Outlined.INSTANCE), null, null, null, 0, null, null, composer3, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    composer3.endReplaceGroup();
                }
                Composer composer6 = composer3;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, botShortcut.getLabel(), null, 0L, 0, 10, composer6, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 29);
                composer2 = composer6;
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: o8.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BotShortcutKt.BotShortcutBtn$lambda$5(modifier3, botShortcut, onClick, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BotShortcutBtn$lambda$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BotShortcutBtn$lambda$3$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BotShortcutBtn$lambda$5(Modifier modifier, BotShortcut botShortcut, a aVar, int i10, int i11, Composer composer, int i12) {
        BotShortcutBtn(modifier, botShortcut, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
