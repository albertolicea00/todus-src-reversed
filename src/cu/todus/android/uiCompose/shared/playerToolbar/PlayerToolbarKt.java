package cu.todus.android.uiCompose.shared.playerToolbar;

import ab.i;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.PauseKt;
import androidx.compose.material.icons.outlined.PlayArrowKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.di.MediaModule;
import cu.todus.android.media.player.MediaPlayerData;
import cu.todus.android.media.player.MediaPlayerStatus;
import cu.todus.android.uiCompose.shared.playerToolbar.PlayerToolbarKt;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.z17.singledi.SinglediException;
import cu.z17.views.label.Z17LabelKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import rb.b;
import rb.j;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0005²\u0006\u000e\u0010\u0004\u001a\u00020\u00038\n@\nX\u008a\u008e\u0002"}, d2 = {"Lua/k0;", "PlayerToolbar", "(Landroidx/compose/runtime/Composer;I)V", "", "sliderPosition", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PlayerToolbarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PlayerToolbar(Composer composer, final int i10) throws SinglediException {
        Composer composerStartRestartGroup = composer.startRestartGroup(-198812381);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-198812381, i10, -1, "cu.todus.android.uiCompose.shared.playerToolbar.PlayerToolbar (PlayerToolbar.kt:47)");
            }
            MediaModule mediaModuleRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (mediaModuleRememberedValue == companion.getEmpty()) {
                mediaModuleRememberedValue = MediaModule.INSTANCE.getInstance();
                composerStartRestartGroup.updateRememberedValue(mediaModuleRememberedValue);
            }
            final MediaModule mediaModule = (MediaModule) mediaModuleRememberedValue;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(mediaModule.getActualPlaying(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(mediaModule.getPlayerStatus(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(mediaModule.getActualPlayingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(((Number) stateCollectAsStateWithLifecycle3.getValue()).intValue());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue2;
            mutableFloatState.setFloatValue(((Number) stateCollectAsStateWithLifecycle3.getValue()).intValue());
            AnimatedVisibilityKt.AnimatedVisibility(stateCollectAsStateWithLifecycle.getValue() != null, (Modifier) null, EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-307437061, true, new Function3() { // from class: u8.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PlayerToolbarKt.PlayerToolbar$lambda$5(stateCollectAsStateWithLifecycle2, mediaModule, stateCollectAsStateWithLifecycle, mutableInteractionSource, stateCollectAsStateWithLifecycle3, mutableFloatState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: u8.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlayerToolbarKt.PlayerToolbar$lambda$6(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PlayerToolbar$lambda$5(final State state, final MediaModule mediaModule, State state2, final MutableInteractionSource mutableInteractionSource, State state3, final MutableFloatState mutableFloatState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        String name;
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-307437061, i10, -1, "cu.todus.android.uiCompose.shared.playerToolbar.PlayerToolbar.<anonymous> (PlayerToolbar.kt:89)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        float f10 = 15;
        float f11 = 10;
        float f12 = 20;
        Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(companion, materialTheme.getColorScheme(composer, i11).getOnBackground(), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(0.0f, 0.0f, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 3, null)), Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f11));
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
        int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1726paddingVpY3zN4);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        a constructor = companion3.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
        int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
        a constructor2 = companion3.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getCenterVertically(), composer, 54);
        int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion);
        a constructor3 = companion3.getConstructor();
        if (!r.a(composer.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer);
        Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        boolean zChanged = composer.changed(state) | composer.changedInstance(mediaModule);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: u8.d
                @Override // lb.a
                public final Object invoke() {
                    return PlayerToolbarKt.PlayerToolbar$lambda$5$0$0$0$0$0(state, mediaModule);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((a) objRememberedValue, SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f12)), false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-804269447, true, new Function2() { // from class: u8.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlayerToolbarKt.PlayerToolbar$lambda$5$0$0$0$1(state, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, 1572912, 60);
        Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m8823constructorimpl(f11), 0.0f, 2, null);
        MediaPlayerData mediaPlayerData = (MediaPlayerData) state2.getValue();
        if (mediaPlayerData == null || (name = mediaPlayerData.getName()) == null) {
            name = "Audio";
        }
        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default, name, null, materialTheme.getColorScheme(composer, i11).getBackground(), 1, 0, composer, 24576, 36);
        boolean zChangedInstance = composer.changedInstance(mediaModule);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new a() { // from class: u8.f
                @Override // lb.a
                public final Object invoke() {
                    return PlayerToolbarKt.PlayerToolbar$lambda$5$0$0$0$2$0(mediaModule);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        IconButtonKt.IconButton((a) objRememberedValue2, SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f12)), false, null, null, null, ComposableSingletons$PlayerToolbarKt.INSTANCE.m10089getLambda$238085072$app_productionPFast(), composer, 1572912, 60);
        composer.endNode();
        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer, 48);
        int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion);
        a constructor4 = companion3.getConstructor();
        if (!r.a(composer.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor4);
        } else {
            composer.useNode();
        }
        Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer);
        Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
        Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 0.0f, 13, null), Dp.m8823constructorimpl(f10));
        float floatValue = mutableFloatState.getFloatValue();
        b bVarB = j.b(0.0f, mediaModule.getActualPlayingDuration());
        Object objRememberedValue3 = composer.rememberedValue();
        Composer.Companion companion4 = Composer.INSTANCE;
        if (objRememberedValue3 == companion4.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: u8.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlayerToolbarKt.PlayerToolbar$lambda$5$0$0$1$0$0(mutableFloatState, ((Float) obj).floatValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function1 function1 = (Function1) objRememberedValue3;
        boolean zChangedInstance2 = composer.changedInstance(mediaModule);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue4 == companion4.getEmpty()) {
            objRememberedValue4 = new a() { // from class: u8.h
                @Override // lb.a
                public final Object invoke() {
                    return PlayerToolbarKt.PlayerToolbar$lambda$5$0$0$1$1$0(mediaModule, mutableFloatState);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        SliderKt.Slider(floatValue, function1, modifierM1755height3ABfNKs, false, (a) objRememberedValue4, null, mutableInteractionSource, 0, ComposableLambdaKt.rememberComposableLambda(-777408498, true, new Function3() { // from class: u8.i
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PlayerToolbarKt.PlayerToolbar$lambda$5$0$0$1$2(mutableInteractionSource, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), null, bVarB, composer, 102236208, 0, 680);
        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1729paddingqDBjuR0$default(companion, Dp.m8823constructorimpl(f11), 0.0f, 0.0f, 0.0f, 14, null), NumberInlineFunctionsKt.humanDuration(((Number) state3.getValue()).intValue()), null, materialTheme.getColorScheme(composer, i11).getBackground(), 1, 0, composer, 24582, 36);
        composer.endNode();
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PlayerToolbar$lambda$5$0$0$0$0$0(State state, MediaModule mediaModule) {
        if (state.getValue() == MediaPlayerStatus.PLAYING) {
            mediaModule.pausePlaying();
        } else {
            mediaModule.playPlaying();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PlayerToolbar$lambda$5$0$0$0$1(State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-804269447, i10, -1, "cu.todus.android.uiCompose.shared.playerToolbar.PlayerToolbar.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlayerToolbar.kt:111)");
            }
            IconKt.m3298Iconww6aTOc(state.getValue() == MediaPlayerStatus.PLAYING ? PauseKt.getPause(Icons.Outlined.INSTANCE) : PlayArrowKt.getPlayArrow(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PlayerToolbar$lambda$5$0$0$0$2$0(MediaModule mediaModule) {
        mediaModule.stopPlaying();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PlayerToolbar$lambda$5$0$0$1$0$0(MutableFloatState mutableFloatState, float f10) {
        mutableFloatState.setFloatValue(f10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PlayerToolbar$lambda$5$0$0$1$1$0(MediaModule mediaModule, MutableFloatState mutableFloatState) {
        mediaModule.setMediaPlayerPosition((int) mutableFloatState.getFloatValue());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PlayerToolbar$lambda$5$0$0$1$2(MutableInteractionSource mutableInteractionSource, SliderState it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777408498, i10, -1, "cu.todus.android.uiCompose.shared.playerToolbar.PlayerToolbar.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlayerToolbar.kt:157)");
            }
            float f10 = 20;
            SliderDefaults.INSTANCE.m3655Thumb9LiSoMs(mutableInteractionSource, null, null, false, DpKt.m8845DpSizeYgX7TsA(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)), composer, 221190, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PlayerToolbar$lambda$6(int i10, Composer composer, int i11) throws SinglediException {
        PlayerToolbar(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
