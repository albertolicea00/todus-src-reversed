package cu.todus.android.uiCompose.main.screen.chat.refresh;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.uiCompose.main.screen.chat.refresh.RefreshKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "isRefreshing", "", "currentDistance", "threshold", "Lua/k0;", "Refresh", "(Landroidx/compose/ui/Modifier;ZFFLandroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RefreshKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Refresh(Modifier modifier, final boolean z10, final float f10, final float f11, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-748488719);
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
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(f10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(f11) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-748488719, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.refresh.Refresh (Refresh.kt:23)");
            }
            final long onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
            float f12 = f10 / f11;
            final float f13 = f12 < 1.0f ? f12 : 1.0f;
            AnimatedVisibilityKt.AnimatedVisibility(z10 || f12 > 0.0f, SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1301192905, true, new Function3() { // from class: t7.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RefreshKt.Refresh$lambda$0(z10, onBackground, f13, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t7.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RefreshKt.Refresh$lambda$1(modifier3, z10, f10, f11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Refresh$lambda$0(boolean z10, final long j10, float f10, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1301192905, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.refresh.Refresh.<anonymous> (Refresh.kt:36)");
        }
        if (z10) {
            composer.startReplaceGroup(1758028214);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zChanged = composer.changed(j10);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: t7.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RefreshKt.Refresh$lambda$0$0$0(j10, (ContentDrawScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(DrawModifierKt.drawWithContent(modifierFillMaxWidth$default, (Function1) objRememberedValue), Dp.m8823constructorimpl(60));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1755height3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, Dp.m8823constructorimpl(2), Dp.m8823constructorimpl(25), 0L, composer, 432, 9);
            composer.endNode();
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1758485929);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zChanged2 = composer.changed(j10);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: t7.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RefreshKt.Refresh$lambda$0$2$0(j10, (ContentDrawScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            float f11 = 60;
            Modifier modifierM1755height3ABfNKs2 = SizeKt.m1755height3ABfNKs(DrawModifierKt.drawWithContent(modifierFillMaxWidth$default2, (Function1) objRememberedValue2), Dp.m8823constructorimpl(f11 - ((1 - f10) * f11)));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1755height3ABfNKs2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor2 = companion2.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Z17SimpleCircleLoaderKt.m10264Z17CircleProgressLoadergZXFtk(null, f10, Dp.m8823constructorimpl(2), Dp.m8823constructorimpl(25), 0L, composer, 3456, 17);
            composer.endNode();
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Refresh$lambda$0$0$0(long j10, ContentDrawScope drawWithContent) {
        y.i(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        DrawScope.CC.M(drawWithContent, Color.m5865copywmQWz5c$default(j10, 0.05f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, 126, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Refresh$lambda$0$2$0(long j10, ContentDrawScope drawWithContent) {
        y.i(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        DrawScope.CC.M(drawWithContent, Color.m5865copywmQWz5c$default(j10, 0.05f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, 126, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Refresh$lambda$1(Modifier modifier, boolean z10, float f10, float f11, int i10, int i11, Composer composer, int i12) {
        Refresh(modifier, z10, f10, f11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
