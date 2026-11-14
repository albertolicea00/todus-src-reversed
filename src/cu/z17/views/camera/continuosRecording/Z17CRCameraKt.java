package cu.z17.views.camera.continuosRecording;

import android.content.Context;
import android.content.res.Configuration;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PlayCircleFilledKt;
import androidx.compose.material.icons.filled.StopCircleKt;
import androidx.compose.material.icons.outlined.CameraswitchKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.camera.RecordingState;
import cu.z17.views.camera.Z17CameraModule;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001au\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u001c²\u0006\u000e\u0010\u0014\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0016\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0018\u001a\u00020\u00178\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0019\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001b\u001a\u00020\u001a8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "videoPathToSave", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcu/z17/views/camera/continuosRecording/Z17CRCameraViewModel;", "viewModel", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lua/k0;", "onClose", "Lkotlin/Function2;", "Lcu/z17/views/camera/ResultType;", "onStart", "onCameraFlip", "Z17CRCamera", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Lcu/z17/views/camera/continuosRecording/Z17CRCameraViewModel;Landroid/content/Context;Llb/a;Lkotlin/jvm/functions/Function2;Llb/a;Landroidx/compose/runtime/Composer;II)V", "", "isFrontCamera", "", "currentRecordTime", "Lcu/z17/views/camera/RecordingState;", "recordState", "isMid", "Landroidx/compose/ui/graphics/Color;", "animatedColor", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17CRCameraKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordingState.values().length];
            try {
                iArr[RecordingState.NOT_REQUESTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17CRCamera(Modifier modifier, final String videoPathToSave, LifecycleOwner lifecycleOwner, Z17CRCameraViewModel z17CRCameraViewModel, Context context, final lb.a onClose, final Function2 onStart, final lb.a onCameraFlip, Composer composer, final int i10, final int i11) {
        final Modifier modifier2;
        int i12;
        LifecycleOwner lifecycleOwner2;
        final Z17CRCameraViewModel z17CRCameraViewModel2;
        Context context2;
        Composer composer2;
        final LifecycleOwner lifecycleOwner3;
        final Context context3;
        LifecycleOwner lifecycleOwner4;
        int i13;
        Context context4;
        Modifier modifier3;
        LifecycleOwner lifecycleOwner5;
        Modifier modifier4;
        boolean z10;
        char c10;
        final LifecycleOwner lifecycleOwner6;
        State state;
        y.i(videoPathToSave, "videoPathToSave");
        y.i(onClose, "onClose");
        y.i(onStart, "onStart");
        y.i(onCameraFlip, "onCameraFlip");
        Composer composerStartRestartGroup = composer.startRestartGroup(892553098);
        int i14 = i11 & 1;
        if (i14 != 0) {
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
            i12 |= composerStartRestartGroup.changed(videoPathToSave) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                lifecycleOwner2 = lifecycleOwner;
                int i15 = composerStartRestartGroup.changedInstance(lifecycleOwner2) ? 256 : 128;
                i12 |= i15;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            i12 |= i15;
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i10 & 3072) == 0) {
            if ((i11 & 8) == 0) {
                z17CRCameraViewModel2 = z17CRCameraViewModel;
                int i16 = composerStartRestartGroup.changedInstance(z17CRCameraViewModel2) ? 2048 : 1024;
                i12 |= i16;
            } else {
                z17CRCameraViewModel2 = z17CRCameraViewModel;
            }
            i12 |= i16;
        } else {
            z17CRCameraViewModel2 = z17CRCameraViewModel;
        }
        if ((i10 & 24576) == 0) {
            context2 = context;
            i12 |= ((i11 & 16) == 0 && composerStartRestartGroup.changedInstance(context2)) ? 16384 : 8192;
        } else {
            context2 = context;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClose) ? 131072 : 65536;
        }
        if ((12582912 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onCameraFlip) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4269203 & i12) != 4269202, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier modifier5 = i14 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                    lifecycleOwner4 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                } else {
                    lifecycleOwner4 = lifecycleOwner2;
                }
                if ((i11 & 8) != 0) {
                    int i17 = i12;
                    Z17CRCameraViewModelFactory z17CRCameraViewModelFactory = new Z17CRCameraViewModelFactory(videoPathToSave);
                    int i18 = i17 & 112;
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    z17CRCameraViewModel2 = (Z17CRCameraViewModel) ViewModelKt.viewModel(z0.b(Z17CRCameraViewModel.class), current, videoPathToSave, z17CRCameraViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, (i18 << 3) & 896, 0);
                    i12 = i17 & (-7169);
                }
                if ((i11 & 16) != 0) {
                    context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i13 = i12 & (-57345);
                } else {
                    i13 = i12;
                    context4 = context2;
                }
                modifier3 = modifier5;
                lifecycleOwner5 = lifecycleOwner4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
                if ((i11 & 8) != 0) {
                    i12 &= -7169;
                }
                if ((i11 & 16) != 0) {
                    i12 &= -57345;
                }
                i13 = i12;
                lifecycleOwner5 = lifecycleOwner2;
                z17CRCameraViewModel2 = z17CRCameraViewModel2;
                context4 = context2;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892553098, i13, -1, "cu.z17.views.camera.continuosRecording.Z17CRCamera (Z17CRCamera.kt:73)");
            }
            if (Z17CameraModule.INSTANCE.getInstance().getCanUseCamera()) {
                composerStartRestartGroup.startReplaceGroup(-1249907075);
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                final Configuration configuration = (Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                Composer.Companion companion3 = Composer.INSTANCE;
                if (objRememberedValue == companion3.getEmpty()) {
                    objRememberedValue = new PreviewView(context4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final PreviewView previewView = (PreviewView) objRememberedValue;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion3.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState = (MutableState) objRememberedValue2;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion3.getEmpty()) {
                    objRememberedValue3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MutableLongState mutableLongState = (MutableLongState) objRememberedValue3;
                int i19 = i13;
                final Context context5 = context4;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(z17CRCameraViewModel2.getRecordingResult(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(previewView);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue4 == companion3.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.camera.continuosRecording.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17CRCameraKt.Z17CRCamera$lambda$31$lambda$9$lambda$8(previewView, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function1 = (Function1) objRememberedValue4;
                Modifier.Companion companion4 = Modifier.INSTANCE;
                AndroidView_androidKt.AndroidView(function1, SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null), null, composerStartRestartGroup, 48, 4);
                Modifier modifierAlign = boxScopeInstance.align(companion4, companion.getTopStart());
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(z17CRCameraViewModel2) | ((i19 & 458752) == 131072);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue5 == companion3.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.z17.views.camera.continuosRecording.c
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17CRCameraKt.Z17CRCamera$lambda$31$lambda$11$lambda$10(z17CRCameraViewModel2, onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue5, modifierAlign, false, null, ComposableSingletons$Z17CRCameraKt.INSTANCE.getLambda$564949511$views_release(), composerStartRestartGroup, 24576, 12);
                RecordingState recordingStateZ17CRCamera$lambda$31$lambda$7 = Z17CRCamera$lambda$31$lambda$7(stateCollectAsStateWithLifecycle);
                RecordingState recordingState = RecordingState.RECORDING;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(boxScopeInstance.align(companion4, recordingStateZ17CRCamera$lambda$31$lambda$7 == recordingState ? companion.getTopEnd() : companion.getBottomCenter()), 0.0f, 1, null), Dp.m8823constructorimpl(20));
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Z17CRCamera$lambda$31$lambda$7(stateCollectAsStateWithLifecycle) == recordingState ? Arrangement.INSTANCE.getEnd() : Arrangement.INSTANCE.getSpaceBetween(), companion.getCenterVertically(), composerStartRestartGroup, 48);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
                lb.a constructor2 = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Alignment.Vertical centerVertically = companion.getCenterVertically();
                float f10 = 10;
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 2, null);
                Color.Companion companion5 = Color.INSTANCE;
                float f11 = 5;
                float f12 = 3;
                Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM1727paddingVpY3zN4$default, companion5.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f12));
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
                lb.a constructor3 = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting() || !y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion3.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue6;
                long jM5900getRed0d7_KjU = !Z17CRCamera$lambda$31$lambda$26$lambda$19$lambda$13(mutableState2) ? companion5.m5900getRed0d7_KjU() : Color.m5865copywmQWz5c$default(companion5.m5900getRed0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
                TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(1000, 0, null, 6, null);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion3.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.camera.continuosRecording.Z17CRCameraKt$Z17CRCamera$1$3$1$animatedColor$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            m10135invoke8_81llA(((Color) obj).m5876unboximpl());
                            return k0.f43947a;
                        }

                        /* JADX INFO: renamed from: invoke-8_81llA, reason: not valid java name */
                        public final void m10135invoke8_81llA(long j10) {
                            MutableState<Boolean> mutableState3 = mutableState2;
                            Z17CRCameraKt.Z17CRCamera$lambda$31$lambda$26$lambda$19$lambda$14(mutableState3, !Z17CRCameraKt.Z17CRCamera$lambda$31$lambda$26$lambda$19$lambda$13(mutableState3));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                State<Color> stateM1076animateColorAsStateeuL9pac = SingleValueAnimationKt.m1076animateColorAsStateeuL9pac(jM5900getRed0d7_KjU, tweenSpecTween$default, "aci", (Function1) objRememberedValue7, composerStartRestartGroup, 3504, 0);
                if (Z17CRCamera$lambda$31$lambda$7(stateCollectAsStateWithLifecycle) == recordingState) {
                    composerStartRestartGroup.startReplaceGroup(-1353727888);
                    Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1771sizeVpY3zN4(companion4, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)), RoundedCornerShapeKt.getCircleShape()), Z17CRCamera$lambda$31$lambda$26$lambda$19$lambda$16(stateM1076animateColorAsStateeuL9pac), null, 2, null);
                    z10 = false;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
                    lb.a constructor4 = companion2.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion2.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash4 = companion2.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl4.getInserting() || !y.d(composerM5176constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion2.getSetModifier());
                    k0 k0Var = k0.f43947a;
                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion3.getEmpty()) {
                        objRememberedValue8 = new Z17CRCameraKt$Z17CRCamera$1$3$1$1$1$1(mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    c10 = 6;
                    EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue8, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                } else {
                    z10 = false;
                    c10 = 6;
                    composerStartRestartGroup.startReplaceGroup(978278543);
                }
                composerStartRestartGroup.endReplaceGroup();
                final Z17CRCameraViewModel z17CRCameraViewModel3 = z17CRCameraViewModel2;
                Modifier modifier6 = modifier3;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, Z17InlineUtilsKt.convertToMS(mutableLongState.getLongValue()), null, companion5.m5903getWhite0d7_KjU(), 0, 0, composerStartRestartGroup, 3072, 53);
                composerStartRestartGroup.endNode();
                Modifier modifierBounceClick = Z17ButtonsKt.bounceClick(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 2, null), Dp.m8823constructorimpl(35)));
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(z17CRCameraViewModel3) | composerStartRestartGroup.changedInstance(context5);
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue9 == companion3.getEmpty()) {
                    objRememberedValue9 = new lb.a() { // from class: cu.z17.views.camera.continuosRecording.d
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17CRCameraKt.Z17CRCamera$lambda$31$lambda$26$lambda$21$lambda$20(z17CRCameraViewModel3, context5, stateCollectAsStateWithLifecycle);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                boolean z11 = true;
                modifier4 = modifier6;
                LifecycleOwner lifecycleOwner7 = lifecycleOwner5;
                IconButtonKt.IconButton((lb.a) objRememberedValue9, modifierBounceClick, false, null, ComposableLambdaKt.rememberComposableLambda(90444651, true, new Function2() { // from class: cu.z17.views.camera.continuosRecording.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17CRCameraKt.Z17CRCamera$lambda$31$lambda$26$lambda$22(stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 12);
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(companion4, Dp.m8823constructorimpl(f10));
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i20 = MaterialTheme.$stable;
                Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs2, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i20).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f12));
                final PreviewView previewView2 = previewView;
                boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(z17CRCameraViewModel3) | composerStartRestartGroup.changedInstance(previewView2) | composerStartRestartGroup.changedInstance(lifecycleOwner7);
                if ((i19 & 29360128) != 8388608) {
                    z11 = false;
                }
                boolean zChangedInstance3 = zChanged2 | z11 | composerStartRestartGroup.changedInstance(context5);
                Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || objRememberedValue10 == companion3.getEmpty()) {
                    lifecycleOwner6 = lifecycleOwner7;
                    composer2 = composerStartRestartGroup;
                    context3 = context5;
                    lb.a aVar = new lb.a() { // from class: cu.z17.views.camera.continuosRecording.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17CRCameraKt.Z17CRCamera$lambda$31$lambda$26$lambda$24$lambda$23(z17CRCameraViewModel3, previewView2, lifecycleOwner6, onCameraFlip, context3, stateCollectAsStateWithLifecycle, mutableState);
                        }
                    };
                    previewView2 = previewView2;
                    state = stateCollectAsStateWithLifecycle;
                    z17CRCameraViewModel2 = z17CRCameraViewModel3;
                    composer2.updateRememberedValue(aVar);
                    objRememberedValue10 = aVar;
                } else {
                    state = stateCollectAsStateWithLifecycle;
                    context3 = context5;
                    z17CRCameraViewModel2 = z17CRCameraViewModel3;
                    lifecycleOwner6 = lifecycleOwner7;
                    composer2 = composerStartRestartGroup;
                }
                Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifierM1725padding3ABfNKs3, false, null, null, (lb.a) objRememberedValue10, 7, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierM1238clickableXHw0xAI$default);
                lb.a constructor5 = companion2.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor5);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion2.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5 = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl5.getInserting() || !y.d(composerM5176constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    composerM5176constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    composerM5176constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion2.getSetModifier());
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(25)), CameraswitchKt.getCameraswitch(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer2, i20).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer2, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composer2.endNode();
                composer2.endNode();
                k0 k0Var2 = k0.f43947a;
                boolean zChangedInstance4 = composer2.changedInstance(z17CRCameraViewModel2) | composer2.changedInstance(previewView2) | composer2.changedInstance(lifecycleOwner6) | composer2.changed(state);
                Object objRememberedValue11 = composer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue11 == companion3.getEmpty()) {
                    lifecycleOwner5 = lifecycleOwner6;
                    objRememberedValue11 = new Z17CRCameraKt$Z17CRCamera$1$4$1(z17CRCameraViewModel2, previewView2, lifecycleOwner5, state, mutableLongState, null);
                    composer2.updateRememberedValue(objRememberedValue11);
                } else {
                    lifecycleOwner5 = lifecycleOwner6;
                }
                EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue11, composer2, 6);
                boolean zChangedInstance5 = composer2.changedInstance(configuration) | composer2.changedInstance(context3);
                Object objRememberedValue12 = composer2.rememberedValue();
                if (zChangedInstance5 || objRememberedValue12 == companion3.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: cu.z17.views.camera.continuosRecording.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17CRCameraKt.Z17CRCamera$lambda$31$lambda$30$lambda$29(configuration, context3, (DisposableEffectScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                EffectsKt.DisposableEffect(k0Var2, (Function1) objRememberedValue12, composer2, 6);
                composer2.endNode();
            } else {
                composer2 = composerStartRestartGroup;
                context3 = context4;
                modifier4 = modifier3;
                z17CRCameraViewModel2 = z17CRCameraViewModel2;
                composer2.startReplaceGroup(-95704712);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
            lifecycleOwner3 = lifecycleOwner5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            lifecycleOwner3 = lifecycleOwner2;
            context3 = context2;
        }
        final Z17CRCameraViewModel z17CRCameraViewModel4 = z17CRCameraViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.camera.continuosRecording.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17CRCameraKt.Z17CRCamera$lambda$32(modifier2, videoPathToSave, lifecycleOwner3, z17CRCameraViewModel4, context3, onClose, onStart, onCameraFlip, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17CRCamera$lambda$31$lambda$11$lambda$10(Z17CRCameraViewModel z17CRCameraViewModel, lb.a aVar) throws Throwable {
        z17CRCameraViewModel.cancelRecord();
        aVar.invoke();
        return k0.f43947a;
    }

    private static final boolean Z17CRCamera$lambda$31$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17CRCamera$lambda$31$lambda$26$lambda$19$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z17CRCamera$lambda$31$lambda$26$lambda$19$lambda$14(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final long Z17CRCamera$lambda$31$lambda$26$lambda$19$lambda$16(State<Color> state) {
        return state.getValue().m5876unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17CRCamera$lambda$31$lambda$26$lambda$21$lambda$20(Z17CRCameraViewModel z17CRCameraViewModel, Context context, State state) throws Throwable {
        if (WhenMappings.$EnumSwitchMapping$0[Z17CRCamera$lambda$31$lambda$7(state).ordinal()] == 1) {
            z17CRCameraViewModel.startVideoRecord(context);
        } else {
            z17CRCameraViewModel.stopRecord();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17CRCamera$lambda$31$lambda$26$lambda$22(State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90444651, i10, -1, "cu.z17.views.camera.continuosRecording.Z17CRCamera.<anonymous>.<anonymous>.<anonymous> (Z17CRCamera.kt:180)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Z17CRCamera$lambda$31$lambda$7(state) == RecordingState.RECORDING ? StopCircleKt.getStopCircle(Icons.Filled.INSTANCE) : PlayCircleFilledKt.getPlayCircleFilled(Icons.Filled.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, ColorKt.Color(4291176488L), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17CRCamera$lambda$31$lambda$26$lambda$24$lambda$23(Z17CRCameraViewModel z17CRCameraViewModel, PreviewView previewView, LifecycleOwner lifecycleOwner, lb.a aVar, Context context, State state, MutableState mutableState) throws Throwable {
        if (Z17CRCamera$lambda$31$lambda$7(state) == RecordingState.RECORDING || Z17CRCamera$lambda$31$lambda$7(state) == RecordingState.PAUSE) {
            z17CRCameraViewModel.flip();
            z17CRCameraViewModel.stopRecord();
            if (Z17CRCamera$lambda$31$lambda$2(mutableState)) {
                Z17CameraModule.INSTANCE.getInstance().changeToBackCamera();
            } else {
                Z17CameraModule.INSTANCE.getInstance().changeToFrontCamera();
            }
            Z17CRCamera$lambda$31$lambda$3(mutableState, !Z17CRCamera$lambda$31$lambda$2(mutableState));
            z17CRCameraViewModel.showVideoCamera(previewView, lifecycleOwner);
            aVar.invoke();
            z17CRCameraViewModel.startVideoRecord(context);
        } else {
            if (Z17CRCamera$lambda$31$lambda$2(mutableState)) {
                Z17CameraModule.INSTANCE.getInstance().changeToBackCamera();
            } else {
                Z17CameraModule.INSTANCE.getInstance().changeToFrontCamera();
            }
            Z17CRCamera$lambda$31$lambda$3(mutableState, !Z17CRCamera$lambda$31$lambda$2(mutableState));
            z17CRCameraViewModel.showVideoCamera(previewView, lifecycleOwner);
        }
        return k0.f43947a;
    }

    private static final void Z17CRCamera$lambda$31$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult Z17CRCamera$lambda$31$lambda$30$lambda$29(Configuration configuration, final Context context, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        final int i10 = configuration.orientation;
        return new DisposableEffectResult() { // from class: cu.z17.views.camera.continuosRecording.Z17CRCameraKt$Z17CRCamera$lambda$31$lambda$30$lambda$29$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Z17CameraModule.INSTANCE.getInstance().getProcessCameraProvider().unbindAll();
                try {
                    Z17InlineUtilsKt.findActivity(context).setRequestedOrientation(i10);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecordingState Z17CRCamera$lambda$31$lambda$7(State<? extends RecordingState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewView Z17CRCamera$lambda$31$lambda$9$lambda$8(PreviewView previewView, Context it) {
        y.i(it, "it");
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17CRCamera$lambda$32(Modifier modifier, String str, LifecycleOwner lifecycleOwner, Z17CRCameraViewModel z17CRCameraViewModel, Context context, lb.a aVar, Function2 function2, lb.a aVar2, int i10, int i11, Composer composer, int i12) {
        Z17CRCamera(modifier, str, lifecycleOwner, z17CRCameraViewModel, context, aVar, function2, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
