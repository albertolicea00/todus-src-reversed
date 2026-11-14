package cu.todus.android.uiCompose.main.screen.chat.input;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import l0.o0;
import l0.w0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a[\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0012²\u0006\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\nX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u00020\u00108\nX\u008a\u0084\u0002"}, d2 = {"", "inputLength", "Landroidx/compose/ui/Modifier;", "modifier", "", "enableToRecord", "isRecording", "Lkotlin/Function0;", "Lua/k0;", "onClick", "record", "stopRecord", "SendBtn2", "(ILandroidx/compose/ui/Modifier;ZZLlb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "Ll0/j;", "recordingAnimationComposition", "", "scale", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatSendButtonKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SendBtn2(int i10, final Modifier modifier, final boolean z10, final boolean z11, final lb.a onClick, final lb.a record, final lb.a stopRecord, Composer composer, final int i11, final int i12) {
        int i13;
        final int i14;
        Modifier.Companion companion;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(record, "record");
        kotlin.jvm.internal.y.i(stopRecord, "stopRecord");
        Composer composerStartRestartGroup = composer.startRestartGroup(1473074367);
        int i15 = i12 & 1;
        if (i15 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(i10) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onClick) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(record) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(stopRecord) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i13) != 599186, i13 & 1)) {
            int i16 = i15 != 0 ? 0 : i10;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1473074367, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.input.SendBtn2 (ChatSendButton.kt:58)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue == companion2.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            int i17 = i13;
            p0.l lVarQ = p0.r.q(p0.n.a.a(p0.n.a.b(R.raw.recording_lottie_anim)), null, null, null, null, null, composerStartRestartGroup, 0, 62);
            p0.o oVarB = p0.p.b(new p0.q[]{p0.p.c(o0.N, new w0(ColorKt.m5920toArgb8_81llA(Color.INSTANCE.m5903getWhite0d7_KjU())), new String[]{"**"}, composerStartRestartGroup, 6)}, composerStartRestartGroup, p0.q.f40042d);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z11 ? 1.1f : 1.0f, null, 0.0f, "send_btn_scale", null, composerStartRestartGroup, 3072, 22);
            composerStartRestartGroup = composerStartRestartGroup;
            final int i18 = 65536 - i16;
            boolean z12 = (i18 > 50 || z11 || z10) ? false : true;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(modifier, Dp.m8823constructorimpl(48));
            boolean zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion2.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatSendButtonKt.SendBtn2$lambda$3$0(stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierM1769size3ABfNKs, (Function1) objRememberedValue2);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion5 = Modifier.INSTANCE;
            Modifier modifierClip = ClipKt.clip(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(companion5, Dp.m8823constructorimpl(42)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
            IndicationNodeFactory indicationNodeFactoryM3540rippleH2RKhps$default = RippleKt.m3540rippleH2RKhps$default(true, 0.0f, 0L, 6, null);
            Role roleM7766boximpl = Role.m7766boximpl(Role.INSTANCE.m7773getButtono7Vup1c());
            int i19 = i17 & 7168;
            int i20 = i16;
            boolean z13 = ((i17 & 896) == 256) | (i19 == 2048) | ((458752 & i17) == 131072);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue3 == companion2.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.u
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatSendButtonKt.SendBtn2$lambda$4$0$0(z11, z10, record);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar = (lb.a) objRememberedValue3;
            boolean z14 = (i19 == 2048) | ((3670016 & i17) == 1048576) | ((i17 & 57344) == 16384);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue4 == companion2.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.v
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatSendButtonKt.SendBtn2$lambda$4$1$0(z11, stopRecord, onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierM1244combinedClickableauXiCPI$default = ClickableKt.m1244combinedClickableauXiCPI$default(modifierClip, mutableInteractionSource, indicationNodeFactoryM3540rippleH2RKhps$default, true, "send btn", roleM7766boximpl, null, aVar, null, false, (lb.a) objRememberedValue4, TypedValues.CycleType.TYPE_PATH_ROTATE, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1244combinedClickableauXiCPI$default);
            lb.a constructor2 = companion4.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            boolean z15 = !z11 && z10;
            EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
            ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
            ComposableSingletons$ChatSendButtonKt composableSingletons$ChatSendButtonKt = ComposableSingletons$ChatSendButtonKt.INSTANCE;
            AnimatedVisibilityKt.AnimatedVisibility(z15, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, composableSingletons$ChatSendButtonKt.getLambda$714620195$app_productionPFast(), composerStartRestartGroup, 200064, 18);
            AnimatedVisibilityKt.AnimatedVisibility((z11 || z10) ? false : true, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, composableSingletons$ChatSendButtonKt.m9888getLambda$1109401766$app_productionPFast(), composerStartRestartGroup, 200064, 18);
            if (z11) {
                composerStartRestartGroup.startReplaceGroup(-164178291);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion3.getCenterVertically(), composerStartRestartGroup, 48);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion5);
                lb.a constructor3 = companion4.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                companion = companion5;
                p0.e.a(SendBtn2$lambda$1(lVarQ), e3.a(RowScopeInstance.INSTANCE, companion5, 1.0f, false, 2, null), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, oVarB, null, null, false, false, null, false, null, composerStartRestartGroup, 1572864, p0.o.f40030k << 12, 0, 4177852);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                companion = companion5;
                composerStartRestartGroup.startReplaceGroup(-163522889);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            AnimatedVisibilityKt.AnimatedVisibility(z12, OffsetKt.m1684offsetVpY3zN4(boxScopeInstance.align(companion, companion3.getTopEnd()), Dp.m8823constructorimpl(-2), Dp.m8823constructorimpl(-4)), EnterExitTransitionKt.m1026scaleInL8ZKhE$default(AnimationSpecKt.tween$default(200, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, 0L, 6, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, 0, null, 6, null), 0.0f, 2, null)), EnterExitTransitionKt.m1028scaleOutL8ZKhE$default(AnimationSpecKt.tween$default(400, 0, null, 6, null), 0.0f, 0L, 6, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(400, 0, null, 6, null), 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-1357773667, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChatSendButtonKt.SendBtn2$lambda$4$3(i18, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 199680, 16);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i14 = i20;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            i14 = i10;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatSendButtonKt.SendBtn2$lambda$5(i14, modifier, z10, z11, onClick, record, stopRecord, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final l0.j SendBtn2$lambda$1(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    private static final float SendBtn2$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendBtn2$lambda$3$0(State state, GraphicsLayerScope graphicsLayer) {
        kotlin.jvm.internal.y.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(SendBtn2$lambda$2(state));
        graphicsLayer.setScaleY(SendBtn2$lambda$2(state));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendBtn2$lambda$4$0$0(boolean z10, boolean z11, lb.a aVar) {
        if (!z10 && z11) {
            aVar.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendBtn2$lambda$4$1$0(boolean z10, lb.a aVar, lb.a aVar2) {
        if (z10) {
            aVar.invoke();
        } else {
            aVar2.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SendBtn2$lambda$4$3(int i10, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1357773667, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.input.SendBtn2.<anonymous>.<anonymous> (ChatSendButton.kt:185)");
        }
        Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(18));
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i12 = MaterialTheme.$stable;
        Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1769size3ABfNKs, materialTheme.getColorScheme(composer, i12).getBackground(), RoundedCornerShapeKt.getCircleShape());
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1204backgroundbw27NRU);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        lb.a constructor = companion.getConstructor();
        if (!defpackage.r.a(composer.getApplier())) {
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
        TextKt.m2800Text4IGK_g(String.valueOf(i10), (Modifier) null, materialTheme.getColorScheme(composer, i12).getPrimary(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 199680, 0, 131026);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendBtn2$lambda$5(int i10, Modifier modifier, boolean z10, boolean z11, lb.a aVar, lb.a aVar2, lb.a aVar3, int i11, int i12, Composer composer, int i13) {
        SendBtn2(i10, modifier, z10, z11, aVar, aVar2, aVar3, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
