package cu.todus.android.uiCompose.shared.insideNotification;

import androidx.camera.video.AudioStats;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.x;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\u001a/\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0016\u0010\u0017\"\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u0014\u0010\u001c\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019\"\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019\"\u0014\u0010\u001e\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019\"\u0014\u0010\u001f\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019\"\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001b\"\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001b\"\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001b¨\u0006&²\u0006\f\u0010#\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u00020\u000f8\nX\u008a\u0084\u0002²\u0006\f\u0010%\u001a\u00020\u000f8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "quantity", "", "emoji", "", "visible", "Lua/k0;", "Particles", "(Landroidx/compose/ui/Modifier;ILjava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "", "Lcu/todus/android/uiCompose/shared/insideNotification/ParticleModel;", "calculateParticleParams", "(ILjava/lang/String;)Ljava/util/List;", "", TtmlNode.START, "stop", "fraction", "lerp", "(FFF)F", "model", "Particle", "(Lcu/todus/android/uiCompose/shared/insideNotification/ParticleModel;Landroidx/compose/runtime/Composer;I)V", "TARGET_PARTICLE_SCALE_MULTIPLIER", "F", "START_OF_ANIMATION", "I", "MIN_PARTICLE_SIZE", "MAX_PARTICLE_SIZE", "MIN_ANIMATION_DURATION", "MAX_ANIMATION_DURATION", "PARTICLE_TEXT_SIZE", "MIN_HEIGHT", "MAX_HEIGHT", "height", "alpha", "scale", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ParticlesKt {
    private static final float MAX_ANIMATION_DURATION = 700.0f;
    private static final int MAX_HEIGHT = 300;
    private static final float MAX_PARTICLE_SIZE = 2.6f;
    private static final float MIN_ANIMATION_DURATION = 400.0f;
    private static final int MIN_HEIGHT = 100;
    private static final float MIN_PARTICLE_SIZE = 1.0f;
    private static final int PARTICLE_TEXT_SIZE = 6;
    private static final int START_OF_ANIMATION = 0;
    private static final float TARGET_PARTICLE_SCALE_MULTIPLIER = 1.3f;

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void Particle(final ParticleModel particleModel, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        Object currentState;
        Object currentState2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1009834748);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(particleModel) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1009834748, i11, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particle (Particles.kt:117)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            Object obj = objRememberedValue;
            if (objRememberedValue == companion.getEmpty()) {
                MutableTransitionState mutableTransitionState = new MutableTransitionState(Float.valueOf(0.1f));
                mutableTransitionState.setTargetState$animation_core(Float.valueOf(0.0f));
                composerStartRestartGroup.updateRememberedValue(mutableTransitionState);
                obj = mutableTransitionState;
            }
            MutableTransitionState mutableTransitionState2 = (MutableTransitionState) obj;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = Float.valueOf(particleModel.getInitialScale() * TARGET_PARTICLE_SCALE_MULTIPLIER);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final float fFloatValue = ((Number) objRememberedValue2).floatValue();
            final Transition transitionUpdateTransition = TransitionKt.updateTransition(mutableTransitionState2, "particle transition", composerStartRestartGroup, MutableTransitionState.$stable | 48, 0);
            Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.shared.insideNotification.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ParticlesKt.Particle$lambda$2(particleModel, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            kotlin.jvm.internal.r rVar = kotlin.jvm.internal.r.f36628a;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(rVar);
            if (transitionUpdateTransition.isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1666827533);
                composerStartRestartGroup.endReplaceGroup();
                currentState = transitionUpdateTransition.getCurrentState();
            } else {
                composerStartRestartGroup.startReplaceGroup(1666573488);
                boolean zChanged = composerStartRestartGroup.changed(transitionUpdateTransition);
                currentState = composerStartRestartGroup.rememberedValue();
                if (zChanged || currentState == companion.getEmpty()) {
                    Snapshot.Companion companion2 = Snapshot.INSTANCE;
                    Snapshot currentThreadSnapshot = companion2.getCurrentThreadSnapshot();
                    Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable = companion2.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        Object currentState3 = transitionUpdateTransition.getCurrentState();
                        companion2.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        composerStartRestartGroup.updateRememberedValue(currentState3);
                        currentState = currentState3;
                    } catch (Throwable th2) {
                        companion2.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th2;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            float fFloatValue2 = ((Number) currentState).floatValue();
            composerStartRestartGroup.startReplaceGroup(-1286373472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286373472, 0, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particle.<anonymous> (Particles.kt:139)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf = Float.valueOf(fFloatValue2);
            boolean zChanged2 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.shared.insideNotification.ParticlesKt$Particle$$inlined$animateFloat$1
                    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Float, java.lang.Object] */
                    @Override // lb.a
                    public final Float invoke() {
                        return transitionUpdateTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            float fFloatValue3 = ((Number) ((State) objRememberedValue3).getValue()).floatValue();
            composerStartRestartGroup.startReplaceGroup(-1286373472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286373472, 0, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particle.<anonymous> (Particles.kt:139)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(fFloatValue3);
            boolean zChanged3 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.shared.insideNotification.ParticlesKt$Particle$$inlined$animateFloat$2
                    @Override // lb.a
                    public final Transition.Segment<Float> invoke() {
                        return transitionUpdateTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, fValueOf2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue4).getValue(), composerStartRestartGroup, 0), vectorConverter, "alpha animation of particle", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            Function3 function4 = new Function3() { // from class: cu.todus.android.uiCompose.shared.insideNotification.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ParticlesKt.Particle$lambda$5(particleModel, fFloatValue, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(rVar);
            if (transitionUpdateTransition.isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1666827533);
                composerStartRestartGroup.endReplaceGroup();
                currentState2 = transitionUpdateTransition.getCurrentState();
            } else {
                composerStartRestartGroup.startReplaceGroup(1666573488);
                boolean zChanged4 = composerStartRestartGroup.changed(transitionUpdateTransition);
                currentState2 = composerStartRestartGroup.rememberedValue();
                if (zChanged4 || currentState2 == companion.getEmpty()) {
                    Snapshot.Companion companion3 = Snapshot.INSTANCE;
                    Snapshot currentThreadSnapshot2 = companion3.getCurrentThreadSnapshot();
                    Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable2 = companion3.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        Object currentState4 = transitionUpdateTransition.getCurrentState();
                        companion3.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        composerStartRestartGroup.updateRememberedValue(currentState4);
                        currentState2 = currentState4;
                    } catch (Throwable th3) {
                        companion3.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th3;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            float fFloatValue4 = ((Number) currentState2).floatValue();
            composerStartRestartGroup.startReplaceGroup(-227174004);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-227174004, 0, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particle.<anonymous> (Particles.kt:151)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf3 = Float.valueOf(fFloatValue4);
            boolean zChanged5 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged5 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.shared.insideNotification.ParticlesKt$Particle$$inlined$animateFloat$3
                    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Float, java.lang.Object] */
                    @Override // lb.a
                    public final Float invoke() {
                        return transitionUpdateTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            float fFloatValue5 = ((Number) ((State) objRememberedValue5).getValue()).floatValue();
            composerStartRestartGroup.startReplaceGroup(-227174004);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-227174004, 0, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particle.<anonymous> (Particles.kt:151)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf4 = Float.valueOf(fFloatValue5);
            boolean zChanged6 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged6 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.shared.insideNotification.ParticlesKt$Particle$$inlined$animateFloat$4
                    @Override // lb.a
                    public final Transition.Segment<Float> invoke() {
                        return transitionUpdateTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            TextKt.m2800Text4IGK_g(particleModel.getEmoji(), AlphaKt.alpha(ScaleKt.scale(SizeKt.wrapContentSize$default(Modifier.INSTANCE, null, false, 3, null), Particle$lambda$7(TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, fValueOf4, (FiniteAnimationSpec) function4.invoke(((State) objRememberedValue6).getValue(), composerStartRestartGroup, 0), vectorConverter2, "scale animation of particle", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE))), Particle$lambda$4(stateCreateTransitionAnimation) - 0.3f), 0L, TextUnitKt.getSp(6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 3072, 0, 131060);
            Composer composer3 = composerStartRestartGroup;
            composer2 = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                composer2 = composer3;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.insideNotification.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ParticlesKt.Particle$lambda$8(particleModel, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final FiniteAnimationSpec Particle$lambda$2(final ParticleModel particleModel, Transition.Segment animateFloat, Composer composer, int i10) {
        y.i(animateFloat, "$this$animateFloat");
        composer.startReplaceGroup(-1869900281);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1869900281, i10, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particle.<anonymous> (Particles.kt:130)");
        }
        boolean zChanged = composer.changed(particleModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ParticlesKt.Particle$lambda$2$0$0(particleModel, (KeyframesSpec.KeyframesSpecConfig) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        KeyframesSpec keyframesSpecKeyframes = AnimationSpecKt.keyframes((Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return keyframesSpecKeyframes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Particle$lambda$2$0$0(ParticleModel particleModel, KeyframesSpec.KeyframesSpecConfig keyframes) {
        y.i(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(particleModel.getDuration());
        keyframes.at(Float.valueOf(0.1f), 0);
        Float fValueOf = Float.valueOf(1.0f);
        keyframes.at(fValueOf, (int) (particleModel.getDuration() * 0.1f));
        keyframes.at(fValueOf, (int) (particleModel.getDuration() * 0.8f));
        keyframes.at(Float.valueOf(0.0f), particleModel.getDuration());
        return k0.f43947a;
    }

    private static final float Particle$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final FiniteAnimationSpec Particle$lambda$5(final ParticleModel particleModel, final float f10, Transition.Segment animateFloat, Composer composer, int i10) {
        y.i(animateFloat, "$this$animateFloat");
        composer.startReplaceGroup(-810700813);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810700813, i10, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particle.<anonymous> (Particles.kt:143)");
        }
        boolean zChanged = composer.changed(particleModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ParticlesKt.Particle$lambda$5$0$0(particleModel, f10, (KeyframesSpec.KeyframesSpecConfig) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        KeyframesSpec keyframesSpecKeyframes = AnimationSpecKt.keyframes((Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return keyframesSpecKeyframes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Particle$lambda$5$0$0(ParticleModel particleModel, float f10, KeyframesSpec.KeyframesSpecConfig keyframes) {
        y.i(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(particleModel.getDuration());
        keyframes.at(Float.valueOf(particleModel.getInitialScale()), 0);
        keyframes.at(Float.valueOf(particleModel.getInitialScale()), (int) (particleModel.getDuration() * 0.7f));
        keyframes.at(Float.valueOf(f10), particleModel.getDuration());
        return k0.f43947a;
    }

    private static final float Particle$lambda$7(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Particle$lambda$8(ParticleModel particleModel, int i10, Composer composer, int i11) {
        Particle(particleModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Particles(final Modifier modifier, final int i10, final String emoji, boolean z10, Composer composer, final int i11) {
        int i12;
        final boolean z11;
        y.i(modifier, "modifier");
        y.i(emoji, "emoji");
        Composer composerStartRestartGroup = composer.startRestartGroup(2060146627);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(emoji) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2060146627, i12, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particles (Particles.kt:33)");
            }
            TweenSpec tweenSpecTween = AnimationSpecKt.tween(400, 300, EasingKt.getLinearEasing());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.insideNotification.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(ParticlesKt.Particles$lambda$0$0(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            AnimatedVisibilityKt.AnimatedVisibility(z10, (Modifier) null, EnterExitTransitionKt.slideInVertically(tweenSpecTween, (Function1) objRememberedValue), ExitTransition.INSTANCE.getNone(), (String) null, ComposableLambdaKt.rememberComposableLambda(851891355, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.insideNotification.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ParticlesKt.Particles$lambda$1(modifier, i10, emoji, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 9) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            z11 = z10;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z11 = z10;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.insideNotification.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ParticlesKt.Particles$lambda$2(modifier, i10, emoji, z11, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Particles$lambda$1(Modifier modifier, int i10, String str, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i11) {
        Object currentState;
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(851891355, i11, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particles.<anonymous> (Particles.kt:46)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = calculateParticleParams(i10, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        List list = (List) objRememberedValue;
        Object objRememberedValue2 = composer.rememberedValue();
        Object obj = objRememberedValue2;
        if (objRememberedValue2 == companion.getEmpty()) {
            MutableTransitionState mutableTransitionState = new MutableTransitionState(100);
            mutableTransitionState.setTargetState$animation_core(300);
            composer.updateRememberedValue(mutableTransitionState);
            obj = mutableTransitionState;
        }
        final Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) obj, "height transition", composer, MutableTransitionState.$stable | 48, 0);
        Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.shared.insideNotification.j
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return ParticlesKt.Particles$lambda$1$2((Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        };
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(x.f36632a);
        if (transitionUpdateTransition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transitionUpdateTransition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            boolean zChanged = composer.changed(transitionUpdateTransition);
            currentState = composer.rememberedValue();
            if (zChanged || currentState == companion.getEmpty()) {
                Snapshot.Companion companion2 = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion2.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion2.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    Object currentState2 = transitionUpdateTransition.getCurrentState();
                    companion2.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th2) {
                    companion2.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th2;
                }
            }
            composer.endReplaceGroup();
        }
        int iIntValue = ((Number) currentState).intValue();
        composer.startReplaceGroup(-1646649529);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1646649529, 0, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particles.<anonymous>.<anonymous> (Particles.kt:61)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Integer numValueOf = Integer.valueOf(iIntValue);
        boolean zChanged2 = composer.changed(transitionUpdateTransition);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.shared.insideNotification.ParticlesKt$Particles$lambda$1$$inlined$animateInt$1
                /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Integer, java.lang.Object] */
                @Override // lb.a
                public final Integer invoke() {
                    return transitionUpdateTransition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue3);
        }
        int iIntValue2 = ((Number) ((State) objRememberedValue3).getValue()).intValue();
        composer.startReplaceGroup(-1646649529);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1646649529, 0, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particles.<anonymous>.<anonymous> (Particles.kt:61)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Integer numValueOf2 = Integer.valueOf(iIntValue2);
        boolean zChanged3 = composer.changed(transitionUpdateTransition);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.shared.insideNotification.ParticlesKt$Particles$lambda$1$$inlined$animateInt$2
                @Override // lb.a
                public final Transition.Segment<Integer> invoke() {
                    return transitionUpdateTransition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue4);
        }
        State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, numValueOf, numValueOf2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue4).getValue(), composer, 0), vectorConverter, "height animation of particles", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(50), 7, null);
        boolean zChanged4 = composer.changed(stateCreateTransitionAnimation) | composer.changedInstance(list);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue5 == companion.getEmpty()) {
            objRememberedValue5 = new ParticlesKt$Particles$2$1$1(stateCreateTransitionAnimation, list);
            composer.updateRememberedValue(objRememberedValue5);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue5;
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1729paddingqDBjuR0$default);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion3.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
        composer.startReplaceGroup(-366576852);
        for (int i12 = 0; i12 < i10; i12++) {
            Particle((ParticleModel) list.get(i12), composer, 0);
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final FiniteAnimationSpec Particles$lambda$1$2(Transition.Segment animateInt, Composer composer, int i10) {
        y.i(animateInt, "$this$animateInt");
        composer.startReplaceGroup(1388182024);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1388182024, i10, -1, "cu.todus.android.uiCompose.shared.insideNotification.Particles.<anonymous>.<anonymous> (Particles.kt:55)");
        }
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Particles$lambda$1$4(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Particles$lambda$2(Modifier modifier, int i10, String str, boolean z10, int i11, Composer composer, int i12) {
        Particles(modifier, i10, str, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return k0.f43947a;
    }

    private static final List<ParticleModel> calculateParticleParams(int i10, String str) {
        pb.d dVarA = pb.e.a((int) System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < i10; i11++) {
            float fD = (float) dVarA.d(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
            arrayList.add(new ParticleModel(fD, (float) dVarA.d(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d), lerp(1.0f, MAX_PARTICLE_SIZE, fD), (int) lerp(400.0f, MAX_ANIMATION_DURATION, fD), str));
        }
        return arrayList;
    }

    private static final float lerp(float f10, float f11, float f12) {
        return (f10 * (1 - f12)) + (f11 * f12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Particles$lambda$0$0(int i10) {
        return i10;
    }
}
