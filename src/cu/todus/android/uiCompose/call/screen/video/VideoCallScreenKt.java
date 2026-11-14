package cu.todus.android.uiCompose.call.screen.video;

import android.content.Context;
import android.view.Window;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.CallEndKt;
import androidx.compose.material.icons.rounded.FlipCameraAndroidKt;
import androidx.compose.material.icons.rounded.MicKt;
import androidx.compose.material.icons.rounded.MicOffKt;
import androidx.compose.material.icons.rounded.VideocamKt;
import androidx.compose.material.icons.rounded.VideocamOffKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.muxer.MuxerUtil;
import androidx.media3.muxer.WebmConstants;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.di.MediaModule;
import cu.todus.android.uiCompose.call.screen.call.CallMediaState;
import cu.todus.android.uiCompose.call.screen.call.CallSystemState;
import cu.todus.android.uiCompose.call.screen.call.VideoCallViewModel;
import cu.todus.android.uiCompose.call.screen.call.components.BigCallItemKt;
import cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.FloatingVideoRendererKt;
import cu.todus.android.uiCompose.call.screen.call.components.videoRender.VideoRendererKt;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.theme.Dark;
import cu.todus.android.uiCompose.theme.Light;
import cu.todus.android.webrtc.CallState;
import cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import org.webrtc.VideoTrack;
import te.p0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aË\u0001\u0010\u001d\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u000f\u0010\u001f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b!\u0010\"\u001a/\u0010%\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010$\u001a\u00020#H\u0003¢\u0006\u0004\b%\u0010&\u001aa\u0010'\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010$\u001a\u00020#H\u0003¢\u0006\u0004\b'\u0010(\u001aG\u00101\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020\t2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0003¢\u0006\u0004\b1\u00102\u001a\u001f\u00103\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0003¢\u0006\u0004\b3\u00104\u001aE\u0010;\u001a\u00020\u00042\f\u00107\u001a\b\u0012\u0004\u0012\u000206052\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0004082\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000408H\u0003¢\u0006\u0004\b;\u0010<\"\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?\"\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010?\"\u0014\u0010A\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010?\"\u0014\u0010B\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010?\"\u0014\u0010C\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010?\"\u0014\u0010D\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010?\"\u0014\u0010E\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010?\"\u0014\u0010F\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010?\"\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006S²\u0006\f\u0010K\u001a\u00020J8\nX\u008a\u0084\u0002²\u0006\f\u0010\r\u001a\u00020\f8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u000b\u001a\u0004\u0018\u00010\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010L\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u00107\u001a\b\u0012\u0004\u0012\u000206058\nX\u008a\u0084\u0002²\u0006\u000e\u0010M\u001a\u0004\u0018\u0001068\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\nX\u008a\u0084\u0002²\u0006\u000e\u0010N\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010P\u001a\u00020O8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010R\u001a\u00020Q8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/call/screen/call/VideoCallViewModel;", "viewModel", "Lua/k0;", "VideoCallScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/call/screen/call/VideoCallViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/pojo/Partner;", "partner", "", "isConnected", "isRinging", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "ownerMediaState", "Lorg/webrtc/VideoTrack;", "remoteVideoTrack", "localVideoTrack", "Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "sessionManager", "withCallMediaState", "Lkotlin/Function0;", "onToggleMic", "onToggleCamera", "onFlipCamera", "onEndCall", "onStartRingNew", "onStopRingNew", "onEnableCameraAutoNew", "onEnableSpeaker", "VideoInCallContent", "(Lcu/todus/android/data/db/pojo/Partner;ZZLcu/todus/android/uiCompose/call/screen/call/CallMediaState;Lorg/webrtc/VideoTrack;Lorg/webrtc/VideoTrack;Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;III)V", "VideoScrim", "(Landroidx/compose/runtime/Composer;I)V", "VideoPlaceholderBackground", "(Lcu/todus/android/data/db/pojo/Partner;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "VideoTopBar", "(Lcu/todus/android/data/db/pojo/Partner;ZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "VideoControlsBar", "(Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;ZLlb/a;Llb/a;Llb/a;Llb/a;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/vector/ImageVector;", "icon", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "enabled", "", "label", "isEndCall", "onClick", "VideoControlButton", "(Landroidx/compose/ui/graphics/vector/ImageVector;ZZLjava/lang/String;ZLlb/a;Landroidx/compose/runtime/Composer;II)V", "PartnerMediaStateBar", "(Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "", "Lcu/todus/android/webrtc/CallState;", "calls", "Lkotlin/Function1;", "acceptCall", "rejectCall", "VideoCallIncomingList", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/graphics/Color;", "VideoBg", "J", "VideoControlsBg", "VideoAccent", "VideoAccentAlt", "VideoRed", "VideoText", "VideoSubtext", "VideoDisabled", "Landroidx/compose/ui/graphics/Brush;", "ControlsBarGradient", "Landroidx/compose/ui/graphics/Brush;", "Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;", "state", "permissionsGranted", "currentState", "controlsVisible", "Landroidx/compose/ui/unit/IntSize;", "parentSize", "", "dotAnim", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class VideoCallScreenKt {
    private static final Brush ControlsBarGradient;
    private static final long VideoAccent;
    private static final long VideoAccentAlt;
    private static final long VideoBg;
    private static final long VideoControlsBg;
    private static final long VideoDisabled;
    private static final long VideoRed;
    private static final long VideoSubtext;
    private static final long VideoText;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallSystemState.values().length];
            try {
                iArr[CallSystemState.STARTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CallSystemState.WAITING_PERMISSIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CallSystemState.EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CallSystemState.CALL_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CallSystemState.IN_CALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Dark dark = Dark.INSTANCE;
        VideoBg = dark.m10091getBackground0d7_KjU();
        VideoControlsBg = Color.m5865copywmQWz5c$default(dark.m10091getBackground0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        VideoAccent = Light.INSTANCE.m10101getInversePrimary0d7_KjU();
        VideoAccentAlt = dark.m10092getInversePrimary0d7_KjU();
        VideoRed = dark.m10096getPrimary0d7_KjU();
        VideoText = dark.m10093getOnBackground0d7_KjU();
        VideoSubtext = Color.m5865copywmQWz5c$default(dark.m10099getTertiary0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null);
        VideoDisabled = Color.m5865copywmQWz5c$default(dark.m10097getSecondary0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        ControlsBarGradient = Brush.Companion.m5827verticalGradient8A3gB4$default(Brush.INSTANCE, va.w.q(Color.m5856boximpl(Color.INSTANCE.m5901getTransparent0d7_KjU()), Color.m5856boximpl(Color.m5865copywmQWz5c$default(dark.m10091getBackground0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null))), 0.0f, 0.0f, 0, 14, (Object) null);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void PartnerMediaStateBar(final CallMediaState callMediaState, final Modifier modifier, Composer composer, final int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1168492150);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(callMediaState) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1168492150, i11, -1, "cu.todus.android.uiCompose.call.screen.video.PartnerMediaStateBar (VideoCallScreen.kt:601)");
            }
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifier, VideoControlsBg, RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.m8823constructorimpl(14), Dp.m8823constructorimpl(7));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(10)), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (callMediaState.isMicrophoneEnabled()) {
                composerStartRestartGroup.startReplaceGroup(-1764400132);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1764631082);
                IconKt.m3298Iconww6aTOc(MicOffKt.getMicOff(Icons.Rounded.INSTANCE), (String) null, SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(16)), VideoSubtext, composerStartRestartGroup, 3504, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (callMediaState.isCameraEnabled()) {
                composerStartRestartGroup.startReplaceGroup(-1764093604);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1764329359);
                IconKt.m3298Iconww6aTOc(VideocamOffKt.getVideocamOff(Icons.Rounded.INSTANCE), (String) null, SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(16)), VideoSubtext, composerStartRestartGroup, 3504, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallScreenKt.PartnerMediaStateBar$lambda$1(callMediaState, modifier, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PartnerMediaStateBar$lambda$1(CallMediaState callMediaState, Modifier modifier, int i10, Composer composer, int i11) {
        PartnerMediaStateBar(callMediaState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void VideoCallIncomingList(final List<CallState> list, final Function1 function1, final Function1 function2, Composer composer, final int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2111392097);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2111392097, i11, -1, "cu.todus.android.uiCompose.call.screen.video.VideoCallIncomingList (VideoCallScreen.kt:629)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), VideoBg, null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(companion);
            boolean zChangedInstance = ((i11 & 112) == 32) | composerStartRestartGroup.changedInstance(list) | ((i11 & 896) == 256) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VideoCallScreenKt.VideoCallIncomingList$lambda$0$0$0(list, function1, function2, context, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyColumn(modifierSafeContentPadding, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_POSITION_TYPE);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallScreenKt.VideoCallIncomingList$lambda$1(list, function1, function2, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoCallIncomingList$lambda$0$0$0(final List list, final Function1 function1, final Function1 function2, final Context context, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        final VideoCallScreenKt$VideoCallIncomingList$lambda$0$0$0$$inlined$items$default$1 videoCallScreenKt$VideoCallIncomingList$lambda$0$0$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.VideoCallScreenKt$VideoCallIncomingList$lambda$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(CallState callState) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((CallState) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.VideoCallScreenKt$VideoCallIncomingList$lambda$0$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return videoCallScreenKt$VideoCallIncomingList$lambda$0$0$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new lb.o() { // from class: cu.todus.android.uiCompose.call.screen.video.VideoCallScreenKt$VideoCallIncomingList$lambda$0$0$0$$inlined$items$default$4
            @Override // lb.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return k0.f43947a;
            }

            @Composable
            public final void invoke(LazyItemScope lazyItemScope, int i10, Composer composer, int i11) {
                int i12;
                if ((i11 & 6) == 0) {
                    i12 = (composer.changed(lazyItemScope) ? 4 : 2) | i11;
                } else {
                    i12 = i11;
                }
                if ((i11 & 48) == 0) {
                    i12 |= composer.changed(i10) ? 32 : 16;
                }
                if (!composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i12, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                CallState callState = (CallState) list.get(i10);
                composer.startReplaceGroup(-1551232958);
                BigCallItemKt.BigCallItem(null, callState, function1, function2, composer, CallState.$stable << 3, 1);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (list.isEmpty()) {
            LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-216198231, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.z
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return VideoCallScreenKt.VideoCallIncomingList$lambda$0$0$0$1(context, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 VideoCallIncomingList$lambda$0$0$0$1(final Context context, final LazyItemScope item, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(item, "$this$item");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(item) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-216198231, i11, -1, "cu.todus.android.uiCompose.call.screen.video.VideoCallIncomingList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCallScreen.kt:638)");
            }
            float f10 = 12;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1726paddingVpY3zN4(Modifier.INSTANCE, Dp.m8823constructorimpl(24), Dp.m8823constructorimpl(f10)), 0.0f, 1, null);
            ButtonColors buttonColorsM2902buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2902buttonColorsro_MJ88(VideoAccent, Color.INSTANCE.m5903getWhite0d7_KjU(), 0L, 0L, composer, (ButtonDefaults.$stable << 12) | 54, 12);
            RoundedCornerShape roundedCornerShapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10));
            boolean zChangedInstance = ((i11 & 14) == 4) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.l
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCallScreenKt.VideoCallIncomingList$lambda$0$0$0$1$0$0(item, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ButtonKt.Button((lb.a) objRememberedValue, modifierFillMaxWidth$default, false, roundedCornerShapeM2015RoundedCornerShape0680j_4, buttonColorsM2902buttonColorsro_MJ88, null, null, null, null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9823getLambda$2002292295$app_productionPFast(), composer, 805306416, 484);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoCallIncomingList$lambda$0$0$0$1$0$0(LazyItemScope lazyItemScope, Context context) {
        try {
            ua.u.a aVar = ua.u.f43963f;
            Z17InlineUtilsKt.findActivity(context).finish();
            ua.u.b(k0.f43947a);
        } catch (Throwable th2) {
            ua.u.a aVar2 = ua.u.f43963f;
            ua.u.b(ua.v.a(th2));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoCallIncomingList$lambda$1(List list, Function1 function1, Function1 function2, int i10, Composer composer, int i11) {
        VideoCallIncomingList(list, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0305  */
    /* JADX WARN: Code duplicated, block: B:115:0x0323  */
    /* JADX WARN: Code duplicated, block: B:120:0x0341  */
    /* JADX WARN: Code duplicated, block: B:125:0x035f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VideoCallScreen(final NavHostController navHostController, VideoCallViewModel videoCallViewModel, Composer composer, final int i10, final int i11) {
        VideoCallViewModel videoCallViewModel2;
        int i12;
        final VideoCallViewModel videoCallViewModel3;
        char c10;
        char c11;
        final Context context;
        char c12;
        int i13;
        boolean z10;
        boolean z11;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue2;
        boolean zChangedInstance3;
        Object objRememberedValue3;
        boolean zChangedInstance4;
        Object objRememberedValue4;
        int i14;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1357812079);
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                videoCallViewModel2 = videoCallViewModel;
                if (composerStartRestartGroup.changedInstance(videoCallViewModel2)) {
                    i14 = 32;
                }
                i12 = i10 | i14;
            } else {
                videoCallViewModel2 = videoCallViewModel;
            }
            i14 = 16;
            i12 = i10 | i14;
        } else {
            videoCallViewModel2 = videoCallViewModel;
            i12 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 17) != 16, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                videoCallViewModel2 = (VideoCallViewModel) ViewModelKt.viewModel(z0.b(VideoCallViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i12 &= -113;
            }
            int i15 = i12;
            VideoCallViewModel videoCallViewModel4 = videoCallViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1357812079, i15, -1, "cu.todus.android.uiCompose.call.screen.video.VideoCallScreen (VideoCallScreen.kt:111)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(videoCallViewModel4.getCallSystemState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            Composer composer2 = composerStartRestartGroup;
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(videoCallViewModel4.ownerCallMediaState(), new CallMediaState(false, false, false, 7, null), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 0, 14);
            State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(videoCallViewModel4.isRinging(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
            final Context context2 = (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue5 = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState = (MutableState) objRememberedValue5;
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance5 = composer2.changedInstance(context2);
            Object objRememberedValue6 = composer2.rememberedValue();
            if (zChangedInstance5 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VideoCallScreenKt.VideoCallScreen$lambda$6$0(context2, (DisposableEffectScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            }
            EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue6, composer2, 6);
            CallSystemState callSystemStateVideoCallScreen$lambda$0 = VideoCallScreen$lambda$0(stateCollectAsStateWithLifecycle);
            boolean zChanged = composer2.changed(stateCollectAsStateWithLifecycle) | composer2.changedInstance(videoCallViewModel4);
            Object objRememberedValue7 = composer2.rememberedValue();
            if (zChanged || objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new VideoCallScreenKt$VideoCallScreen$2$1(videoCallViewModel4, stateCollectAsStateWithLifecycle, null);
                composer2.updateRememberedValue(objRememberedValue7);
            }
            EffectsKt.LaunchedEffect(callSystemStateVideoCallScreen$lambda$0, (Function2) objRememberedValue7, composer2, 0);
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), VideoBg, null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            final BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (VideoCallScreen$lambda$4(mutableState)) {
                composer2.startReplaceGroup(-1371896130);
                int i16 = WhenMappings.$EnumSwitchMapping$0[VideoCallScreen$lambda$0(stateCollectAsStateWithLifecycle).ordinal()];
                if (i16 == 1) {
                    c10 = 2;
                    c11 = 3;
                    context = context2;
                    videoCallViewModel3 = videoCallViewModel4;
                    c12 = 1;
                    i13 = 0;
                    composer2.startReplaceGroup(2033954486);
                    LoadingScreenKt.LoadingWall(composer2, 0);
                    composer2.endReplaceGroup();
                } else if (i16 == 2) {
                    c10 = 2;
                    c11 = 3;
                    context = context2;
                    videoCallViewModel3 = videoCallViewModel4;
                    c12 = 1;
                    i13 = 0;
                    composer2.startReplaceGroup(-1371852265);
                    composer2.endReplaceGroup();
                } else if (i16 == 3) {
                    c10 = 2;
                    c11 = 3;
                    context = context2;
                    videoCallViewModel3 = videoCallViewModel4;
                    c12 = 1;
                    i13 = 0;
                    composer2.startReplaceGroup(2033959281);
                    composer2.endReplaceGroup();
                    Z17InlineUtilsKt.findActivity(context).finish();
                } else if (i16 == 4) {
                    c10 = 2;
                    c11 = 3;
                    context = context2;
                    c12 = 1;
                    i13 = 0;
                    composer2.startReplaceGroup(-1371700954);
                    final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(videoCallViewModel4.callList().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
                    List listY0 = va.g0.Y0(VideoCallScreen$lambda$8$0(stateCollectAsStateWithLifecycle4));
                    videoCallViewModel3 = videoCallViewModel4;
                    boolean zChangedInstance6 = composer2.changedInstance(videoCallViewModel3);
                    Object objRememberedValue8 = composer2.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new VideoCallScreenKt$VideoCallScreen$3$1$1(videoCallViewModel3);
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function1 = (Function1) ((sb.h) objRememberedValue8);
                    boolean zChangedInstance7 = composer2.changedInstance(videoCallViewModel3) | composer2.changed(stateCollectAsStateWithLifecycle4) | composer2.changedInstance(context);
                    Object objRememberedValue9 = composer2.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.v
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoCallScreenKt.VideoCallScreen$lambda$8$2$0(videoCallViewModel3, boxScopeInstance, stateCollectAsStateWithLifecycle4, context, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    VideoCallIncomingList(listY0, function1, (Function1) objRememberedValue9, composer2, 0);
                    composer2.endReplaceGroup();
                } else {
                    if (i16 != 5) {
                        composer2.startReplaceGroup(2033955268);
                        composer2.endReplaceGroup();
                        throw new ua.r();
                    }
                    composer2.startReplaceGroup(-1371049923);
                    p0 p0VarCurrentCallState = videoCallViewModel4.currentCallState();
                    WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager = videoCallViewModel4.sessionManager();
                    if (p0VarCurrentCallState == null || webRtcSessionManagerImplSessionManager == null) {
                        c10 = 2;
                        c11 = 3;
                        context = context2;
                        videoCallViewModel4 = videoCallViewModel4;
                        c12 = 1;
                        i13 = 0;
                        composer2.startReplaceGroup(-1369011239);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-1370854437);
                        c10 = 2;
                        c11 = 3;
                        State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(p0VarCurrentCallState, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 0, 7);
                        State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(webRtcSessionManagerImplSessionManager.getRemoteVideoTrackFlow(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
                        State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(webRtcSessionManagerImplSessionManager.getLocalVideoTrackFlow(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
                        CallState callStateVideoCallScreen$lambda$8$3 = VideoCallScreen$lambda$8$3(stateCollectAsStateWithLifecycle5);
                        if ((callStateVideoCallScreen$lambda$8$3 != null ? callStateVideoCallScreen$lambda$8$3.getPartner() : null) != null) {
                            composer2 = composer2;
                            composer2.startReplaceGroup(-1370323686);
                            Partner partner = callStateVideoCallScreen$lambda$8$3.getPartner();
                            if (callStateVideoCallScreen$lambda$8$3.getPeersConnected()) {
                                composer2 = composer2;
                                z10 = true;
                            } else {
                                composer2 = composer2;
                                z10 = false;
                            }
                            boolean zD = kotlin.jvm.internal.y.d(VideoCallScreen$lambda$2(stateCollectAsStateWithLifecycle3), Boolean.TRUE);
                            CallMediaState callMediaStateVideoCallScreen$lambda$1 = VideoCallScreen$lambda$1(stateCollectAsStateWithLifecycle2);
                            VideoTrack videoTrackVideoCallScreen$lambda$8$4 = VideoCallScreen$lambda$8$4(stateCollectAsStateWithLifecycle6);
                            VideoTrack videoTrackVideoCallScreen$lambda$8$5 = VideoCallScreen$lambda$8$5(stateCollectAsStateWithLifecycle7);
                            CallMediaState withCallMediaState = callStateVideoCallScreen$lambda$8$3.getWithCallMediaState();
                            boolean zChangedInstance8 = composer2.changedInstance(videoCallViewModel4);
                            Object objRememberedValue10 = composer2.rememberedValue();
                            if (zChangedInstance8 || objRememberedValue10 == companion.getEmpty()) {
                                objRememberedValue10 = new VideoCallScreenKt$VideoCallScreen$3$3$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue10);
                            }
                            lb.a aVar = (lb.a) ((sb.h) objRememberedValue10);
                            boolean zChangedInstance9 = composer2.changedInstance(videoCallViewModel4);
                            Object objRememberedValue11 = composer2.rememberedValue();
                            if (zChangedInstance9 || objRememberedValue11 == companion.getEmpty()) {
                                objRememberedValue11 = new VideoCallScreenKt$VideoCallScreen$3$4$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue11);
                            }
                            lb.a aVar2 = (lb.a) ((sb.h) objRememberedValue11);
                            boolean zChangedInstance10 = composer2.changedInstance(videoCallViewModel4);
                            Object objRememberedValue12 = composer2.rememberedValue();
                            if (zChangedInstance10 || objRememberedValue12 == companion.getEmpty()) {
                                objRememberedValue12 = new VideoCallScreenKt$VideoCallScreen$3$5$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue12);
                            }
                            lb.a aVar3 = (lb.a) ((sb.h) objRememberedValue12);
                            boolean zChangedInstance11 = composer2.changedInstance(context2) | composer2.changedInstance(videoCallViewModel4);
                            Object objRememberedValue13 = composer2.rememberedValue();
                            if (zChangedInstance11) {
                                z11 = z10;
                            } else {
                                z11 = z10;
                                if (objRememberedValue13 == companion.getEmpty()) {
                                }
                                lb.a aVar4 = (lb.a) ((sb.h) objRememberedValue13);
                                zChangedInstance = composer2.changedInstance(videoCallViewModel4);
                                objRememberedValue = composer2.rememberedValue();
                                if (zChangedInstance || objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = new VideoCallScreenKt$VideoCallScreen$3$7$1(videoCallViewModel4);
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                lb.a aVar5 = (lb.a) ((sb.h) objRememberedValue);
                                zChangedInstance2 = composer2.changedInstance(videoCallViewModel4);
                                objRememberedValue2 = composer2.rememberedValue();
                                if (zChangedInstance2 || objRememberedValue2 == companion.getEmpty()) {
                                    objRememberedValue2 = new VideoCallScreenKt$VideoCallScreen$3$8$1(videoCallViewModel4);
                                    composer2.updateRememberedValue(objRememberedValue2);
                                }
                                lb.a aVar6 = (lb.a) ((sb.h) objRememberedValue2);
                                zChangedInstance3 = composer2.changedInstance(videoCallViewModel4);
                                objRememberedValue3 = composer2.rememberedValue();
                                if (zChangedInstance3 || objRememberedValue3 == companion.getEmpty()) {
                                    objRememberedValue3 = new VideoCallScreenKt$VideoCallScreen$3$9$1(videoCallViewModel4);
                                    composer2.updateRememberedValue(objRememberedValue3);
                                }
                                lb.a aVar7 = (lb.a) ((sb.h) objRememberedValue3);
                                zChangedInstance4 = composer2.changedInstance(videoCallViewModel4);
                                objRememberedValue4 = composer2.rememberedValue();
                                if (zChangedInstance4 || objRememberedValue4 == companion.getEmpty()) {
                                    objRememberedValue4 = new VideoCallScreenKt$VideoCallScreen$3$10$1(videoCallViewModel4);
                                    composer2.updateRememberedValue(objRememberedValue4);
                                }
                                context = context2;
                                i13 = 0;
                                c12 = 1;
                                VideoInCallContent(partner, z11, zD, callMediaStateVideoCallScreen$lambda$1, videoTrackVideoCallScreen$lambda$8$4, videoTrackVideoCallScreen$lambda$8$5, webRtcSessionManagerImplSessionManager, withCallMediaState, aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, (lb.a) ((sb.h) objRememberedValue4), composer2, 0, 0, 0);
                                composer2 = composer2;
                                composer2.endReplaceGroup();
                            }
                            objRememberedValue13 = new VideoCallScreenKt$VideoCallScreen$3$6$1(context2, videoCallViewModel4);
                            composer2.updateRememberedValue(objRememberedValue13);
                            lb.a aVar8 = (lb.a) ((sb.h) objRememberedValue13);
                            zChangedInstance = composer2.changedInstance(videoCallViewModel4);
                            objRememberedValue = composer2.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new VideoCallScreenKt$VideoCallScreen$3$7$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new VideoCallScreenKt$VideoCallScreen$3$7$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            lb.a aVar9 = (lb.a) ((sb.h) objRememberedValue);
                            zChangedInstance2 = composer2.changedInstance(videoCallViewModel4);
                            objRememberedValue2 = composer2.rememberedValue();
                            if (zChangedInstance2) {
                                objRememberedValue2 = new VideoCallScreenKt$VideoCallScreen$3$8$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new VideoCallScreenKt$VideoCallScreen$3$8$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue2);
                            }
                            lb.a aVar10 = (lb.a) ((sb.h) objRememberedValue2);
                            zChangedInstance3 = composer2.changedInstance(videoCallViewModel4);
                            objRememberedValue3 = composer2.rememberedValue();
                            if (zChangedInstance3) {
                                objRememberedValue3 = new VideoCallScreenKt$VideoCallScreen$3$9$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new VideoCallScreenKt$VideoCallScreen$3$9$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue3);
                            }
                            lb.a aVar11 = (lb.a) ((sb.h) objRememberedValue3);
                            zChangedInstance4 = composer2.changedInstance(videoCallViewModel4);
                            objRememberedValue4 = composer2.rememberedValue();
                            if (zChangedInstance4) {
                                objRememberedValue4 = new VideoCallScreenKt$VideoCallScreen$3$10$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new VideoCallScreenKt$VideoCallScreen$3$10$1(videoCallViewModel4);
                                composer2.updateRememberedValue(objRememberedValue4);
                            }
                            context = context2;
                            i13 = 0;
                            c12 = 1;
                            VideoInCallContent(partner, z11, zD, callMediaStateVideoCallScreen$lambda$1, videoTrackVideoCallScreen$lambda$8$4, videoTrackVideoCallScreen$lambda$8$5, webRtcSessionManagerImplSessionManager, withCallMediaState, aVar, aVar2, aVar3, aVar8, aVar9, aVar10, aVar11, (lb.a) ((sb.h) objRememberedValue4), composer2, 0, 0, 0);
                            composer2 = composer2;
                            composer2.endReplaceGroup();
                        } else {
                            composer2 = composer2;
                            composer2 = composer2;
                            context = context2;
                            i13 = 0;
                            c12 = 1;
                            composer2.startReplaceGroup(-1369033063);
                            composer2.endReplaceGroup();
                        }
                        composer2.endReplaceGroup();
                    }
                    composer2.endReplaceGroup();
                    videoCallViewModel3 = videoCallViewModel4;
                }
                composer2.endReplaceGroup();
            } else {
                mutableState = mutableState;
                c10 = 2;
                c11 = 3;
                context = context2;
                videoCallViewModel3 = videoCallViewModel4;
                c12 = 1;
                i13 = 0;
                composer2.startReplaceGroup(-1368969575);
                composer2.endReplaceGroup();
            }
            PermissionNeedIt[] permissionNeedItArr = new PermissionNeedIt[4];
            permissionNeedItArr[i13] = PermissionNeedIt.STORAGE;
            permissionNeedItArr[c12] = PermissionNeedIt.CAMERA;
            permissionNeedItArr[c10] = PermissionNeedIt.RECORD_AUDIO;
            permissionNeedItArr[c11] = PermissionNeedIt.CALLS;
            List listQ = va.w.q(permissionNeedItArr);
            Object objRememberedValue14 = composer2.rememberedValue();
            if (objRememberedValue14 == companion.getEmpty()) {
                objRememberedValue14 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.w
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCallScreenKt.VideoCallScreen$lambda$8$14$0(mutableState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue14);
            }
            String packageName = context.getPackageName();
            kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
            Composer composer3 = composer2;
            Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listQ, (lb.a) objRememberedValue14, null, packageName, null, composer3, 3456, 83);
            composerStartRestartGroup = composer3;
            Boolean boolValueOf = Boolean.valueOf(VideoCallScreen$lambda$4(mutableState));
            boolean zChangedInstance12 = composerStartRestartGroup.changedInstance(videoCallViewModel3);
            Object objRememberedValue15 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance12 || objRememberedValue15 == companion.getEmpty()) {
                objRememberedValue15 = new VideoCallScreenKt$VideoCallScreen$3$12$1(videoCallViewModel3, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue15, composerStartRestartGroup, i13);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            videoCallViewModel3 = videoCallViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallScreenKt.VideoCallScreen$lambda$9(navHostController, videoCallViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoCallScreen$endCall(Context context, VideoCallViewModel videoCallViewModel) {
        Z17InlineUtilsKt.findActivity(context).finish();
        videoCallViewModel.endCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallSystemState VideoCallScreen$lambda$0(State<? extends CallSystemState> state) {
        return state.getValue();
    }

    private static final CallMediaState VideoCallScreen$lambda$1(State<CallMediaState> state) {
        return state.getValue();
    }

    private static final Boolean VideoCallScreen$lambda$2(State<Boolean> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoCallScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VideoCallScreen$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult VideoCallScreen$lambda$6$0(Context context, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        final Window window = Z17InlineUtilsKt.findActivity(context).getWindow();
        window.addFlags(128);
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.call.screen.video.VideoCallScreenKt$VideoCallScreen$lambda$6$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                window.clearFlags(128);
            }
        };
    }

    private static final List<CallState> VideoCallScreen$lambda$8$0(State<? extends List<CallState>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoCallScreen$lambda$8$14$0(MutableState mutableState) {
        VideoCallScreen$lambda$5(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoCallScreen$lambda$8$2$0(VideoCallViewModel videoCallViewModel, BoxScope boxScope, State state, Context context, String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        videoCallViewModel.rejectCall(uid);
        if (VideoCallScreen$lambda$8$0(state).size() <= 1) {
            try {
                ua.u.a aVar = ua.u.f43963f;
                Z17InlineUtilsKt.findActivity(context).finish();
                ua.u.b(k0.f43947a);
            } catch (Throwable th2) {
                ua.u.a aVar2 = ua.u.f43963f;
                ua.u.b(ua.v.a(th2));
            }
        }
        return k0.f43947a;
    }

    private static final CallState VideoCallScreen$lambda$8$3(State<CallState> state) {
        return state.getValue();
    }

    private static final VideoTrack VideoCallScreen$lambda$8$4(State<? extends VideoTrack> state) {
        return state.getValue();
    }

    private static final VideoTrack VideoCallScreen$lambda$8$5(State<? extends VideoTrack> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoCallScreen$lambda$9(NavHostController navHostController, VideoCallViewModel videoCallViewModel, int i10, int i11, Composer composer, int i12) {
        VideoCallScreen(navHostController, videoCallViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x028a  */
    /* JADX WARN: Code duplicated, block: B:108:0x029e  */
    /* JADX WARN: Code duplicated, block: B:110:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:112:0x033d  */
    /* JADX WARN: Code duplicated, block: B:115:0x034f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0353  */
    /* JADX WARN: Code duplicated, block: B:119:0x035d  */
    /* JADX WARN: Code duplicated, block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:67:0x0100  */
    /* JADX WARN: Code duplicated, block: B:68:0x0104  */
    /* JADX WARN: Code duplicated, block: B:71:0x0142  */
    /* JADX WARN: Code duplicated, block: B:73:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x0149  */
    /* JADX WARN: Code duplicated, block: B:75:0x0161  */
    /* JADX WARN: Code duplicated, block: B:78:0x018e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0194  */
    /* JADX WARN: Code duplicated, block: B:83:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:84:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:92:0x0209  */
    /* JADX WARN: Code duplicated, block: B:95:0x0215  */
    /* JADX WARN: Code duplicated, block: B:96:0x0219  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void VideoControlButton(final ImageVector imageVector, final boolean z10, final boolean z11, final String str, boolean z12, final lb.a aVar, Composer composer, final int i10, final int i11) {
        int i12;
        String str2;
        boolean z13;
        boolean z14;
        final boolean z15;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        lb.a constructor;
        long jM5865copywmQWz5c$default;
        float f10;
        boolean z16;
        Object objRememberedValue;
        lb.a constructor2;
        long jM5865copywmQWz5c$default2;
        long jM5865copywmQWz5c$default3;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(1567288771);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(imageVector) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            str2 = str;
            i12 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
        } else {
            str2 = str;
        }
        int i15 = i11 & 16;
        if (i15 == 0) {
            if ((i10 & 24576) == 0) {
                z13 = z12;
                i12 |= composerStartRestartGroup.changed(z13) ? 16384 : 8192;
            }
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i12 |= i14;
            }
            if ((74899 & i12) != 74898) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                if (i15 != 0) {
                    z15 = false;
                } else {
                    z15 = z13;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1567288771, i12, -1, "cu.todus.android.uiCompose.call.screen.video.VideoControlButton (VideoCallScreen.kt:548)");
                }
                float fM8823constructorimpl = Dp.m8823constructorimpl(52);
                float fM8823constructorimpl2 = Dp.m8823constructorimpl(22);
                Alignment.Companion companion = Alignment.INSTANCE;
                Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_4 = Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(6));
                Modifier.Companion companion2 = Modifier.INSTANCE;
                i13 = i12;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierClip = ClipKt.clip(SizeKt.m1769size3ABfNKs(companion2, fM8823constructorimpl), RoundedCornerShapeKt.getCircleShape());
                if (z15) {
                    jM5865copywmQWz5c$default = VideoRed;
                } else if (z10) {
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.07f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierClip, jM5865copywmQWz5c$default, null, 2, null);
                float fM8823constructorimpl3 = Dp.m8823constructorimpl((float) 1.5d);
                long j10 = VideoAccent;
                if (z11) {
                    f10 = 0.55f;
                } else {
                    f10 = 0.25f;
                }
                Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierM1205backgroundbw27NRU$default, fM8823constructorimpl3, Color.m5865copywmQWz5c$default(j10, f10, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                if ((i13 & 458752) == 131072) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z16 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.i
                        @Override // lb.a
                        public final Object invoke() {
                            return VideoCallScreenKt.VideoControlButton$lambda$0$0$0(aVar);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierM1216borderxT4_qwU, false, null, null, null, (lb.a) objRememberedValue, 15, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
                constructor2 = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                jM5865copywmQWz5c$default2 = (z15 && !z11) ? Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null) : Color.INSTANCE.m5903getWhite0d7_KjU();
                IconKt.m3298Iconww6aTOc(imageVector, (String) null, SizeKt.m1769size3ABfNKs(companion2, fM8823constructorimpl2), jM5865copywmQWz5c$default2, composerStartRestartGroup, (i13 & 14) | 432, 0);
                composerStartRestartGroup.endNode();
                if (str2.length() > 0) {
                    composerStartRestartGroup.startReplaceGroup(-1288711367);
                    TextStyle labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                    if (z11) {
                        jM5865copywmQWz5c$default3 = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM5865copywmQWz5c$default3 = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    TextKt.m3850TextNvy7gAk(str2, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8271copyp1EtxEg$default(labelSmall, jM5865copywmQWz5c$default3, TextUnitKt.getSp(10), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composerStartRestartGroup, (i13 >> 9) & 14, 0, 131070);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1288388471);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z15 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return VideoCallScreenKt.VideoControlButton$lambda$1(imageVector, z10, z11, str, z15, aVar, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        z13 = z12;
        if ((196608 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(aVar)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i12 |= i14;
        }
        if ((74899 & i12) != 74898) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
            if (i15 != 0) {
                z15 = false;
            } else {
                z15 = z13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1567288771, i12, -1, "cu.todus.android.uiCompose.call.screen.video.VideoControlButton (VideoCallScreen.kt:548)");
            }
            float fM8823constructorimpl4 = Dp.m8823constructorimpl(52);
            float fM8823constructorimpl5 = Dp.m8823constructorimpl(22);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally2 = companion4.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_5 = Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(6));
            Modifier.Companion companion5 = Modifier.INSTANCE;
            i13 = i12;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_5, centerHorizontally2, composerStartRestartGroup, 54);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion5);
            ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
            constructor = companion6.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion6.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion6.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion6.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion6.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            Modifier modifierClip2 = ClipKt.clip(SizeKt.m1769size3ABfNKs(companion5, fM8823constructorimpl4), RoundedCornerShapeKt.getCircleShape());
            if (z15) {
                jM5865copywmQWz5c$default = VideoRed;
            } else if (z10) {
                jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.07f, 0.0f, 0.0f, 0.0f, 14, null);
            }
            Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(modifierClip2, jM5865copywmQWz5c$default, null, 2, null);
            float fM8823constructorimpl6 = Dp.m8823constructorimpl((float) 1.5d);
            long j11 = VideoAccent;
            if (z11) {
                f10 = 0.55f;
            } else {
                f10 = 0.25f;
            }
            Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(modifierM1205backgroundbw27NRU$default2, fM8823constructorimpl6, Color.m5865copywmQWz5c$default(j11, f10, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            if ((i13 & 458752) == 131072) {
                z16 = true;
            } else {
                z16 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z16) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.i
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCallScreenKt.VideoControlButton$lambda$0$0$0(aVar);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.i
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCallScreenKt.VideoControlButton$lambda$0$0$0(aVar);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1216borderxT4_qwU2, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default2);
            constructor2 = companion6.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, companion6.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion6.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion6.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion6.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (z15) {
                jM5865copywmQWz5c$default2 = Color.INSTANCE.m5903getWhite0d7_KjU();
            }
            IconKt.m3298Iconww6aTOc(imageVector, (String) null, SizeKt.m1769size3ABfNKs(companion5, fM8823constructorimpl5), jM5865copywmQWz5c$default2, composerStartRestartGroup, (i13 & 14) | 432, 0);
            composerStartRestartGroup.endNode();
            if (str2.length() > 0) {
                composerStartRestartGroup.startReplaceGroup(-1288711367);
                TextStyle labelSmall2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                if (z11) {
                    jM5865copywmQWz5c$default3 = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM5865copywmQWz5c$default3 = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                TextKt.m3850TextNvy7gAk(str2, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8271copyp1EtxEg$default(labelSmall2, jM5865copywmQWz5c$default3, TextUnitKt.getSp(10), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composerStartRestartGroup, (i13 >> 9) & 14, 0, 131070);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1288388471);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z15 = z13;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallScreenKt.VideoControlButton$lambda$1(imageVector, z10, z11, str, z15, aVar, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoControlButton$lambda$0$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoControlButton$lambda$1(ImageVector imageVector, boolean z10, boolean z11, String str, boolean z12, lb.a aVar, int i10, int i11, Composer composer, int i12) {
        VideoControlButton(imageVector, z10, z11, str, z12, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void VideoControlsBar(final CallMediaState callMediaState, final boolean z10, final lb.a aVar, final lb.a aVar2, final lb.a aVar3, final lb.a aVar4, Modifier modifier, Composer composer, final int i10, final int i11) {
        int i12;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(269554594);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(callMediaState) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(aVar) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(aVar2) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(aVar3) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(aVar4) ? 131072 : 65536;
        }
        int i13 = i11 & 64;
        if (i13 != 0) {
            i12 |= 1572864;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i10 & 1572864) == 0) {
                i12 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
            }
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 599187) != 599186, i12 & 1)) {
            Modifier modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(269554594, i12, -1, "cu.todus.android.uiCompose.call.screen.video.VideoControlsBar (VideoCallScreen.kt:499)");
            }
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Color.m5865copywmQWz5c$default(Dark.INSTANCE.m10091getBackground0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(12))), Dp.m8823constructorimpl(4), Dp.m8823constructorimpl(10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceAround(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ImageVector mic = callMediaState.isMicrophoneEnabled() ? MicKt.getMic(Icons.Rounded.INSTANCE) : MicOffKt.getMicOff(Icons.Rounded.INSTANCE);
            boolean zIsMicrophoneEnabled = callMediaState.isMicrophoneEnabled();
            int i14 = i12 & 112;
            boolean z11 = (i14 == 32) | ((i12 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.q
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCallScreenKt.VideoControlsBar$lambda$0$0$0(z10, aVar);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            int i15 = ((i12 << 3) & 896) | 3072;
            int i16 = i12;
            Modifier modifier4 = modifier3;
            VideoControlButton(mic, zIsMicrophoneEnabled, z10, "", false, (lb.a) objRememberedValue, composerStartRestartGroup, i15, 16);
            ImageVector videocam = callMediaState.isCameraEnabled() ? VideocamKt.getVideocam(Icons.Rounded.INSTANCE) : VideocamOffKt.getVideocamOff(Icons.Rounded.INSTANCE);
            boolean zIsCameraEnabled = callMediaState.isCameraEnabled();
            boolean z12 = ((i16 & 7168) == 2048) | (i14 == 32);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.r
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCallScreenKt.VideoControlsBar$lambda$0$1$0(z10, aVar2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            VideoControlButton(videocam, zIsCameraEnabled, z10, "", false, (lb.a) objRememberedValue2, composerStartRestartGroup, i15, 16);
            Icons.Rounded rounded = Icons.Rounded.INSTANCE;
            VideoControlButton(CallEndKt.getCallEnd(rounded), false, true, "", true, aVar4, composerStartRestartGroup, (458752 & i16) | 28080, 0);
            ImageVector flipCameraAndroid = FlipCameraAndroidKt.getFlipCameraAndroid(rounded);
            boolean zIsCameraEnabled2 = callMediaState.isCameraEnabled();
            boolean z13 = z10 && callMediaState.isCameraEnabled();
            boolean z14 = ((i16 & 14) == 4) | (i14 == 32) | ((i16 & 57344) == 16384);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.s
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCallScreenKt.VideoControlsBar$lambda$0$2$0(z10, callMediaState, aVar3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            VideoControlButton(flipCameraAndroid, zIsCameraEnabled2, z13, "", false, (lb.a) objRememberedValue3, composerStartRestartGroup, 3072, 16);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallScreenKt.VideoControlsBar$lambda$1(callMediaState, z10, aVar, aVar2, aVar3, aVar4, modifier2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoControlsBar$lambda$0$0$0(boolean z10, lb.a aVar) {
        if (z10) {
            aVar.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoControlsBar$lambda$0$1$0(boolean z10, lb.a aVar) {
        if (z10) {
            aVar.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoControlsBar$lambda$0$2$0(boolean z10, CallMediaState callMediaState, lb.a aVar) {
        if (z10 && callMediaState.isCameraEnabled()) {
            aVar.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoControlsBar$lambda$1(CallMediaState callMediaState, boolean z10, lb.a aVar, lb.a aVar2, lb.a aVar3, lb.a aVar4, Modifier modifier, int i10, int i11, Composer composer, int i12) {
        VideoControlsBar(callMediaState, z10, aVar, aVar2, aVar3, aVar4, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0123  */
    /* JADX WARN: Code duplicated, block: B:103:0x012a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0130  */
    /* JADX WARN: Code duplicated, block: B:107:0x0138  */
    /* JADX WARN: Code duplicated, block: B:108:0x013b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0143  */
    /* JADX WARN: Code duplicated, block: B:114:0x014a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0150  */
    /* JADX WARN: Code duplicated, block: B:118:0x0158  */
    /* JADX WARN: Code duplicated, block: B:122:0x0163  */
    /* JADX WARN: Code duplicated, block: B:123:0x0168  */
    /* JADX WARN: Code duplicated, block: B:125:0x016e  */
    /* JADX WARN: Code duplicated, block: B:127:0x0174  */
    /* JADX WARN: Code duplicated, block: B:128:0x0177  */
    /* JADX WARN: Code duplicated, block: B:132:0x0187  */
    /* JADX WARN: Code duplicated, block: B:136:0x0193  */
    /* JADX WARN: Code duplicated, block: B:139:0x019c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x019e  */
    /* JADX WARN: Code duplicated, block: B:142:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:156:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:158:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:160:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:162:0x0208  */
    /* JADX WARN: Code duplicated, block: B:165:0x0210  */
    /* JADX WARN: Code duplicated, block: B:168:0x0225  */
    /* JADX WARN: Code duplicated, block: B:171:0x023c  */
    /* JADX WARN: Code duplicated, block: B:172:0x025e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0279  */
    /* JADX WARN: Code duplicated, block: B:177:0x027f  */
    /* JADX WARN: Code duplicated, block: B:180:0x0297  */
    /* JADX WARN: Code duplicated, block: B:181:0x0299  */
    /* JADX WARN: Code duplicated, block: B:184:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:185:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:188:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:189:0x02af  */
    /* JADX WARN: Code duplicated, block: B:192:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:194:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:197:0x02da  */
    /* JADX WARN: Code duplicated, block: B:198:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:201:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:202:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:205:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:207:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:210:0x0313  */
    /* JADX WARN: Code duplicated, block: B:211:0x0315  */
    /* JADX WARN: Code duplicated, block: B:214:0x031e  */
    /* JADX WARN: Code duplicated, block: B:215:0x0320  */
    /* JADX WARN: Code duplicated, block: B:218:0x032b  */
    /* JADX WARN: Code duplicated, block: B:219:0x032d  */
    /* JADX WARN: Code duplicated, block: B:222:0x0335  */
    /* JADX WARN: Code duplicated, block: B:226:0x033f  */
    /* JADX WARN: Code duplicated, block: B:229:0x035f  */
    /* JADX WARN: Code duplicated, block: B:230:0x0361  */
    /* JADX WARN: Code duplicated, block: B:233:0x0368  */
    /* JADX WARN: Code duplicated, block: B:237:0x0371  */
    /* JADX WARN: Code duplicated, block: B:240:0x0391  */
    /* JADX WARN: Code duplicated, block: B:243:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:246:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:249:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:250:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:253:0x0426 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:255:0x045e  */
    /* JADX WARN: Code duplicated, block: B:258:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:261:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:264:0x0521  */
    /* JADX WARN: Code duplicated, block: B:268:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:271:0x05d0  */
    /* JADX WARN: Code duplicated, block: B:275:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:278:0x062f  */
    /* JADX WARN: Code duplicated, block: B:281:0x0656  */
    /* JADX WARN: Code duplicated, block: B:284:0x069f  */
    /* JADX WARN: Code duplicated, block: B:287:0x06ba  */
    /* JADX WARN: Code duplicated, block: B:290:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:292:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:295:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:297:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void VideoInCallContent(final Partner partner, final boolean z10, final boolean z11, final CallMediaState callMediaState, final VideoTrack videoTrack, final VideoTrack videoTrack2, final WebRtcSessionManagerImpl webRtcSessionManagerImpl, CallMediaState callMediaState2, final lb.a aVar, final lb.a aVar2, final lb.a aVar3, final lb.a aVar4, lb.a aVar5, lb.a aVar6, lb.a aVar7, lb.a aVar8, Composer composer, final int i10, final int i11, final int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z12;
        CallMediaState callMediaState3;
        final lb.a aVar9;
        final lb.a aVar10;
        final lb.a aVar11;
        final lb.a aVar12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        lb.a aVar13;
        lb.a aVar14;
        lb.a aVar15;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        Object objRememberedValue2;
        final MutableState mutableState2;
        final Context context;
        k0 k0Var;
        boolean zChangedInstance;
        Object objRememberedValue3;
        boolean z13;
        boolean z14;
        int i22;
        boolean z15;
        boolean z16;
        Object objRememberedValue4;
        int i23;
        boolean z17;
        boolean z18;
        boolean z19;
        Object objRememberedValue5;
        boolean z20;
        int i24;
        boolean z21;
        boolean z22;
        boolean z23;
        Object objRememberedValue6;
        lb.a aVar16;
        boolean z24;
        Object objRememberedValue7;
        Object obj;
        Modifier.Companion companion2;
        Object objRememberedValue8;
        Object objRememberedValue9;
        Alignment.Companion companion3;
        lb.a constructor;
        BoxScopeInstance boxScopeInstance;
        k0 k0Var2;
        int i25;
        int i26;
        float f10;
        Object objRememberedValue10;
        Object objRememberedValue11;
        int i27;
        Composer composer2;
        Object objRememberedValue12;
        Object objRememberedValue13;
        Object objRememberedValue14;
        Object objRememberedValue15;
        Object objRememberedValue16;
        Object objRememberedValue17;
        Object objRememberedValue18;
        Object objRememberedValue19;
        Composer composerStartRestartGroup = composer.startRestartGroup(-844261653);
        if ((i10 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(partner) ? 4 : 2) | i10;
        } else {
            i13 = i10;
        }
        if ((i10 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(callMediaState) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(videoTrack) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(videoTrack2) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(webRtcSessionManagerImpl) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i13 |= composerStartRestartGroup.changed(callMediaState2) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(aVar) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(aVar2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i11 & 6) == 0) {
            i14 = i11 | (composerStartRestartGroup.changedInstance(aVar3) ? 4 : 2);
        } else {
            i14 = i11;
        }
        if ((i11 & 48) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(aVar4) ? 32 : 16;
        }
        int i28 = i14;
        int i29 = i12 & 4096;
        if (i29 == 0) {
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i28 |= composerStartRestartGroup.changedInstance(aVar5) ? 256 : 128;
            }
            i15 = i12 & 8192;
            if (i15 != 0) {
                i16 = i15;
                if ((i11 & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar6)) {
                        i17 = 2048;
                    } else {
                        i17 = 1024;
                    }
                    i28 |= i17;
                }
                i18 = i12 & 16384;
                if (i18 != 0) {
                    i19 = i18;
                    if ((i11 & 24576) == 0) {
                        i28 |= composerStartRestartGroup.changedInstance(aVar7) ? 16384 : 8192;
                    }
                    i20 = i12 & 32768;
                    if (i20 != 0) {
                        i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar8)) {
                            i21 = 131072;
                        } else {
                            i21 = 65536;
                        }
                        i28 |= i21;
                    }
                    if ((i13 & 306783379) == 306783378 || (74899 & i28) != 74898) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                        if (i29 != 0) {
                            objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                            }
                            aVar13 = (lb.a) objRememberedValue19;
                        } else {
                            aVar13 = aVar5;
                        }
                        if (i16 != 0) {
                            objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.e0
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                            }
                            aVar10 = (lb.a) objRememberedValue18;
                        } else {
                            aVar10 = aVar6;
                        }
                        if (i19 != 0) {
                            objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.f0
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                            }
                            aVar14 = (lb.a) objRememberedValue17;
                        } else {
                            aVar14 = aVar7;
                        }
                        if (i20 != 0) {
                            objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.g0
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                            }
                            aVar15 = (lb.a) objRememberedValue16;
                        } else {
                            aVar15 = aVar8;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-844261653, i13, i28, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent (VideoCallScreen.kt:227)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            long j10 = 0;
                            MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j10 << 32) | (j10 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                            objRememberedValue2 = mutableStateMutableStateOf$default;
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        k0Var = k0.f43947a;
                        zChangedInstance = composerStartRestartGroup.changedInstance(context);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                        Boolean boolValueOf = Boolean.valueOf(z11);
                        if ((i13 & 896) == 256) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean z25 = z13;
                        if ((i28 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z26 = z25 | z14;
                        i22 = i28;
                        if ((i28 & 7168) == 2048) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        z16 = z15 | z26;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z16 || objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue4, composerStartRestartGroup, (i13 >> 6) & 14);
                        Boolean boolValueOf2 = Boolean.valueOf(z10);
                        i23 = i13 & 112;
                        if (i23 == 32) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        lb.a aVar17 = aVar13;
                        if ((i22 & 458752) == 131072) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        z19 = z18 | z17;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (z19 || objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        int i30 = (i13 >> 3) & 14;
                        EffectsKt.LaunchedEffect(boolValueOf2, (Function2) objRememberedValue5, composerStartRestartGroup, i30);
                        Boolean boolValueOf3 = Boolean.valueOf(z10);
                        if (i23 == 32) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        i24 = i13;
                        if ((i13 & 7168) == 2048) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        boolean z27 = z21 | z20;
                        if ((i22 & 57344) == 16384) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                        z23 = z27 | z22;
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!z23 || objRememberedValue6 == companion.getEmpty()) {
                            aVar16 = aVar14;
                            objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            aVar16 = aVar14;
                        }
                        EffectsKt.LaunchedEffect(boolValueOf3, (Function2) objRememberedValue6, composerStartRestartGroup, i30);
                        Boolean boolValueOf4 = Boolean.valueOf(VideoInCallContent$lambda$5(mutableState));
                        Boolean boolValueOf5 = Boolean.valueOf(z10);
                        if (i23 == 32) {
                            z24 = true;
                        } else {
                            z24 = false;
                        }
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (!z24 || objRememberedValue7 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        } else {
                            obj = null;
                        }
                        EffectsKt.LaunchedEffect(boolValueOf4, boolValueOf5, (Function2) objRememberedValue7, composerStartRestartGroup, i23);
                        companion2 = Modifier.INSTANCE;
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return VideoCallScreenKt.VideoInCallContent$lambda$15$0(mutableState2, (IntSize) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default, (Function1) objRememberedValue8);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue9 == companion.getEmpty()) {
                            objRememberedValue9 = new VideoCallScreenKt$VideoInCallContent$11$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierOnSizeChanged, k0Var, (PointerInputEventHandler) objRememberedValue9);
                        companion3 = Alignment.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
                        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                        constructor = companion4.getConstructor();
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
                        lb.a aVar18 = aVar16;
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                        boxScopeInstance = BoxScopeInstance.INSTANCE;
                        if (videoTrack == null && z10) {
                            composerStartRestartGroup.startReplaceGroup(-84781749);
                            int i31 = i24 >> 12;
                            k0Var2 = k0Var;
                            i25 = i24;
                            i26 = 0;
                            f10 = 0.0f;
                            VideoRendererKt.VideoRenderer(videoTrack, SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), webRtcSessionManagerImpl, composerStartRestartGroup, (i31 & 896) | (i31 & 14) | 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            k0Var2 = k0Var;
                            i25 = i24;
                            i26 = 0;
                            f10 = 0.0f;
                            composerStartRestartGroup.startReplaceGroup(-84583380);
                            VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        AnimatedVisibilityKt.AnimatedVisibility(VideoInCallContent$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, i26, null, 6, null), f10, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, i26, null, 6, null), f10, 2, null), (String) null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9824getLambda$359242039$app_productionPFast(), composerStartRestartGroup, 200064, 18);
                        boolean zVideoInCallContent$lambda$5 = VideoInCallContent$lambda$5(mutableState);
                        Modifier modifierAlign = boxScopeInstance.align(companion2, companion3.getTopCenter());
                        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == companion.getEmpty()) {
                            objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.e
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$0$0(((Integer) obj2).intValue()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        EnterTransition enterTransitionPlus = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default, (Function1) objRememberedValue10).plus(EnterExitTransitionKt.fadeIn$default(null, f10, 3, null));
                        TweenSpec tweenSpecTween$default2 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                        objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue11 == companion.getEmpty()) {
                            objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.f
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$1$0(((Integer) obj2).intValue()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                        }
                        AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$5, modifierAlign, enterTransitionPlus, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default2, (Function1) objRememberedValue11).plus(EnterExitTransitionKt.fadeOut$default(null, f10, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2105889088, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.g
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$17$2(partner, z10, z11, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                        if (videoTrack2 == null && callMediaState.isCameraEnabled() && z10) {
                            composerStartRestartGroup.startReplaceGroup(-83649722);
                            float f11 = 16;
                            i27 = 220;
                            composer2 = composerStartRestartGroup;
                            FloatingVideoRendererKt.m9818FloatingVideoRendererJQLjw8(webRtcSessionManagerImpl, videoTrack2, VideoInCallContent$lambda$8(mutableState2), PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(i26)), boxScopeInstance.align(BorderKt.m1216borderxT4_qwU(SizeKt.m1771sizeVpY3zN4(PaddingKt.m1729paddingqDBjuR0$default(WindowInsetsPadding_androidKt.safeContentPadding(companion2), 0.0f, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), 0.0f, 9, null), Dp.m8823constructorimpl(110), Dp.m8823constructorimpl(WebmConstants.MkvEbmlElement.FLAG_LACING)), Dp.m8823constructorimpl(2), Color.m5865copywmQWz5c$default(VideoAccent, 0.75f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(14))), companion3.getTopEnd()), composer2, ((i25 >> 18) & 14) | 3072 | ((i25 >> 12) & 112), 0);
                            composer2.endReplaceGroup();
                        } else {
                            i27 = 220;
                            composer2 = composerStartRestartGroup;
                            composer2.startReplaceGroup(-82983439);
                            composer2.endReplaceGroup();
                        }
                        if (callMediaState2.isCameraEnabled() || !callMediaState2.isMicrophoneEnabled()) {
                            composer2.startReplaceGroup(-82883774);
                            callMediaState3 = callMediaState2;
                            PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-82684847);
                            composer2.endReplaceGroup();
                            callMediaState3 = callMediaState2;
                        }
                        boolean zVideoInCallContent$lambda$6 = VideoInCallContent$lambda$5(mutableState);
                        Modifier modifierAlign2 = boxScopeInstance.align(companion2, companion3.getBottomCenter());
                        TweenSpec tweenSpecTween$default3 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                        objRememberedValue12 = composer2.rememberedValue();
                        if (objRememberedValue12 == companion.getEmpty()) {
                            objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$3$0(((Integer) obj2).intValue()));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue12);
                        }
                        EnterTransition enterTransitionPlus2 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default3, (Function1) objRememberedValue12).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        TweenSpec tweenSpecTween$default4 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                        objRememberedValue13 = composer2.rememberedValue();
                        if (objRememberedValue13 == companion.getEmpty()) {
                            objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.y
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$4$0(((Integer) obj2).intValue()));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue13);
                        }
                        Composer composer3 = composer2;
                        AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$6, modifierAlign2, enterTransitionPlus2, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default4, (Function1) objRememberedValue13).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1647253569, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$17$5(callMediaState, z10, aVar, aVar2, aVar3, aVar4, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composer2, 54), composer3, 200064, 16);
                        composerStartRestartGroup = composer3;
                        objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue14 == companion.getEmpty()) {
                            objRememberedValue14 = new VideoCallScreenKt$VideoInCallContent$12$7$1(null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                        }
                        k0 k0Var3 = k0Var2;
                        EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue14, composerStartRestartGroup, 6);
                        objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue15 == companion.getEmpty()) {
                            objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.c0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return VideoCallScreenKt.VideoInCallContent$lambda$17$7$0((DisposableEffectScope) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                        }
                        EffectsKt.DisposableEffect(k0Var3, (Function1) objRememberedValue15, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        aVar9 = aVar17;
                        aVar11 = aVar18;
                        aVar12 = aVar15;
                    } else {
                        callMediaState3 = callMediaState2;
                        composerStartRestartGroup.skipToGroupEnd();
                        aVar9 = aVar5;
                        aVar10 = aVar6;
                        aVar11 = aVar7;
                        aVar12 = aVar8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final CallMediaState callMediaState4 = callMediaState3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.d0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$18(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState4, aVar, aVar2, aVar3, aVar4, aVar9, aVar10, aVar11, aVar12, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i28 |= 24576;
                i19 = i18;
                i20 = i12 & 32768;
                if (i20 != 0) {
                    i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar8)) {
                        i21 = 131072;
                    } else {
                        i21 = 65536;
                    }
                    i28 |= i21;
                }
                if ((i13 & 306783379) == 306783378) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                    if (i29 != 0) {
                        objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                        }
                        aVar13 = (lb.a) objRememberedValue19;
                    } else {
                        aVar13 = aVar5;
                    }
                    if (i16 != 0) {
                        objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.e0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                        }
                        aVar10 = (lb.a) objRememberedValue18;
                    } else {
                        aVar10 = aVar6;
                    }
                    if (i19 != 0) {
                        objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.f0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                        }
                        aVar14 = (lb.a) objRememberedValue17;
                    } else {
                        aVar14 = aVar7;
                    }
                    if (i20 != 0) {
                        objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.g0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                        }
                        aVar15 = (lb.a) objRememberedValue16;
                    } else {
                        aVar15 = aVar8;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-844261653, i13, i28, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent (VideoCallScreen.kt:227)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        long j11 = 0;
                        MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j11 << 32) | (j11 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                        objRememberedValue2 = mutableStateMutableStateOf$default2;
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    k0Var = k0.f43947a;
                    zChangedInstance = composerStartRestartGroup.changedInstance(context);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                    Boolean boolValueOf6 = Boolean.valueOf(z11);
                    if ((i13 & 896) == 256) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean z28 = z13;
                    if ((i28 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z29 = z28 | z14;
                    i22 = i28;
                    if ((i28 & 7168) == 2048) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    z16 = z15 | z29;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf6, (Function2) objRememberedValue4, composerStartRestartGroup, (i13 >> 6) & 14);
                    Boolean boolValueOf7 = Boolean.valueOf(z10);
                    i23 = i13 & 112;
                    if (i23 == 32) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    lb.a aVar19 = aVar13;
                    if ((i22 & 458752) == 131072) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    z19 = z18 | z17;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z19) {
                        objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    int i32 = (i13 >> 3) & 14;
                    EffectsKt.LaunchedEffect(boolValueOf7, (Function2) objRememberedValue5, composerStartRestartGroup, i32);
                    Boolean boolValueOf8 = Boolean.valueOf(z10);
                    if (i23 == 32) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    i24 = i13;
                    if ((i13 & 7168) == 2048) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    boolean z210 = z21 | z20;
                    if ((i22 & 57344) == 16384) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z23 = z210 | z22;
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z23) {
                        aVar16 = aVar14;
                        objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        aVar16 = aVar14;
                        objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf8, (Function2) objRememberedValue6, composerStartRestartGroup, i32);
                    Boolean boolValueOf9 = Boolean.valueOf(VideoInCallContent$lambda$5(mutableState));
                    Boolean boolValueOf10 = Boolean.valueOf(z10);
                    if (i23 == 32) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (z24) {
                        obj = null;
                        objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        obj = null;
                        objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf9, boolValueOf10, (Function2) objRememberedValue7, composerStartRestartGroup, i23);
                    companion2 = Modifier.INSTANCE;
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$15$0(mutableState2, (IntSize) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Modifier modifierOnSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default2, (Function1) objRememberedValue8);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new VideoCallScreenKt$VideoInCallContent$11$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierOnSizeChanged2, k0Var, (PointerInputEventHandler) objRememberedValue9);
                    companion3 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput2);
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
                    lb.a aVar110 = aVar16;
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    if (videoTrack == null) {
                        k0Var2 = k0Var;
                        i25 = i24;
                        i26 = 0;
                        f10 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-84583380);
                        VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        k0Var2 = k0Var;
                        i25 = i24;
                        i26 = 0;
                        f10 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-84583380);
                        VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(VideoInCallContent$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, i26, null, 6, null), f10, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, i26, null, 6, null), f10, 2, null), (String) null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9824getLambda$359242039$app_productionPFast(), composerStartRestartGroup, 200064, 18);
                    boolean zVideoInCallContent$lambda$7 = VideoInCallContent$lambda$5(mutableState);
                    Modifier modifierAlign3 = boxScopeInstance.align(companion2, companion3.getTopCenter());
                    TweenSpec tweenSpecTween$default5 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$0$0(((Integer) obj2).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    EnterTransition enterTransitionPlus3 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default5, (Function1) objRememberedValue10).plus(EnterExitTransitionKt.fadeIn$default(null, f10, 3, null));
                    TweenSpec tweenSpecTween$default6 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$1$0(((Integer) obj2).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$7, modifierAlign3, enterTransitionPlus3, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default6, (Function1) objRememberedValue11).plus(EnterExitTransitionKt.fadeOut$default(null, f10, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2105889088, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.g
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$2(partner, z10, z11, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                    if (videoTrack2 == null) {
                        i27 = 220;
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceGroup(-82983439);
                        composer2.endReplaceGroup();
                    } else {
                        i27 = 220;
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceGroup(-82983439);
                        composer2.endReplaceGroup();
                    }
                    if (callMediaState2.isCameraEnabled()) {
                        composer2.startReplaceGroup(-82883774);
                        callMediaState3 = callMediaState2;
                        PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-82883774);
                        callMediaState3 = callMediaState2;
                        PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                        composer2.endReplaceGroup();
                    }
                    boolean zVideoInCallContent$lambda$8 = VideoInCallContent$lambda$5(mutableState);
                    Modifier modifierAlign4 = boxScopeInstance.align(companion2, companion3.getBottomCenter());
                    TweenSpec tweenSpecTween$default7 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                    objRememberedValue12 = composer2.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$3$0(((Integer) obj2).intValue()));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue12);
                    }
                    EnterTransition enterTransitionPlus4 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default7, (Function1) objRememberedValue12).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    TweenSpec tweenSpecTween$default8 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                    objRememberedValue13 = composer2.rememberedValue();
                    if (objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.y
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$4$0(((Integer) obj2).intValue()));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue13);
                    }
                    Composer composer4 = composer2;
                    AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$8, modifierAlign4, enterTransitionPlus4, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default8, (Function1) objRememberedValue13).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1647253569, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$5(callMediaState, z10, aVar, aVar2, aVar3, aVar4, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer4, 200064, 16);
                    composerStartRestartGroup = composer4;
                    objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue14 == companion.getEmpty()) {
                        objRememberedValue14 = new VideoCallScreenKt$VideoInCallContent$12$7$1(null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                    }
                    k0 k0Var4 = k0Var2;
                    EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue14, composerStartRestartGroup, 6);
                    objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue15 == companion.getEmpty()) {
                        objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.c0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$17$7$0((DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                    }
                    EffectsKt.DisposableEffect(k0Var4, (Function1) objRememberedValue15, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar9 = aVar19;
                    aVar11 = aVar110;
                    aVar12 = aVar15;
                } else {
                    callMediaState3 = callMediaState2;
                    composerStartRestartGroup.skipToGroupEnd();
                    aVar9 = aVar5;
                    aVar10 = aVar6;
                    aVar11 = aVar7;
                    aVar12 = aVar8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final CallMediaState callMediaState5 = callMediaState3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.d0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$18(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState5, aVar, aVar2, aVar3, aVar4, aVar9, aVar10, aVar11, aVar12, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i28 |= 3072;
            i16 = i15;
            i18 = i12 & 16384;
            if (i18 != 0) {
                i19 = i18;
                if ((i11 & 24576) == 0) {
                    i28 |= composerStartRestartGroup.changedInstance(aVar7) ? 16384 : 8192;
                }
                i20 = i12 & 32768;
                if (i20 != 0) {
                    i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar8)) {
                        i21 = 131072;
                    } else {
                        i21 = 65536;
                    }
                    i28 |= i21;
                }
                if ((i13 & 306783379) == 306783378) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                    if (i29 != 0) {
                        objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                        }
                        aVar13 = (lb.a) objRememberedValue19;
                    } else {
                        aVar13 = aVar5;
                    }
                    if (i16 != 0) {
                        objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.e0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                        }
                        aVar10 = (lb.a) objRememberedValue18;
                    } else {
                        aVar10 = aVar6;
                    }
                    if (i19 != 0) {
                        objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.f0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                        }
                        aVar14 = (lb.a) objRememberedValue17;
                    } else {
                        aVar14 = aVar7;
                    }
                    if (i20 != 0) {
                        objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.g0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                        }
                        aVar15 = (lb.a) objRememberedValue16;
                    } else {
                        aVar15 = aVar8;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-844261653, i13, i28, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent (VideoCallScreen.kt:227)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        long j12 = 0;
                        MutableState mutableStateMutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j12 << 32) | (j12 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default3);
                        objRememberedValue2 = mutableStateMutableStateOf$default3;
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    k0Var = k0.f43947a;
                    zChangedInstance = composerStartRestartGroup.changedInstance(context);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                    Boolean boolValueOf11 = Boolean.valueOf(z11);
                    if ((i13 & 896) == 256) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean z211 = z13;
                    if ((i28 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z212 = z211 | z14;
                    i22 = i28;
                    if ((i28 & 7168) == 2048) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    z16 = z15 | z212;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf11, (Function2) objRememberedValue4, composerStartRestartGroup, (i13 >> 6) & 14);
                    Boolean boolValueOf12 = Boolean.valueOf(z10);
                    i23 = i13 & 112;
                    if (i23 == 32) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    lb.a aVar111 = aVar13;
                    if ((i22 & 458752) == 131072) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    z19 = z18 | z17;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z19) {
                        objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    int i33 = (i13 >> 3) & 14;
                    EffectsKt.LaunchedEffect(boolValueOf12, (Function2) objRememberedValue5, composerStartRestartGroup, i33);
                    Boolean boolValueOf13 = Boolean.valueOf(z10);
                    if (i23 == 32) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    i24 = i13;
                    if ((i13 & 7168) == 2048) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    boolean z213 = z21 | z20;
                    if ((i22 & 57344) == 16384) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z23 = z213 | z22;
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z23) {
                        aVar16 = aVar14;
                        objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        aVar16 = aVar14;
                        objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf13, (Function2) objRememberedValue6, composerStartRestartGroup, i33);
                    Boolean boolValueOf14 = Boolean.valueOf(VideoInCallContent$lambda$5(mutableState));
                    Boolean boolValueOf15 = Boolean.valueOf(z10);
                    if (i23 == 32) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (z24) {
                        obj = null;
                        objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        obj = null;
                        objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf14, boolValueOf15, (Function2) objRememberedValue7, composerStartRestartGroup, i23);
                    companion2 = Modifier.INSTANCE;
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$15$0(mutableState2, (IntSize) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Modifier modifierOnSizeChanged3 = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default3, (Function1) objRememberedValue8);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new VideoCallScreenKt$VideoInCallContent$11$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    Modifier modifierPointerInput3 = SuspendingPointerInputFilterKt.pointerInput(modifierOnSizeChanged3, k0Var, (PointerInputEventHandler) objRememberedValue9);
                    companion3 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput3);
                    ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                    constructor = companion6.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    lb.a aVar112 = aVar16;
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion6.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion6.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion6.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion6.getSetModifier());
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    if (videoTrack == null) {
                        k0Var2 = k0Var;
                        i25 = i24;
                        i26 = 0;
                        f10 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-84583380);
                        VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        k0Var2 = k0Var;
                        i25 = i24;
                        i26 = 0;
                        f10 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-84583380);
                        VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(VideoInCallContent$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, i26, null, 6, null), f10, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, i26, null, 6, null), f10, 2, null), (String) null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9824getLambda$359242039$app_productionPFast(), composerStartRestartGroup, 200064, 18);
                    boolean zVideoInCallContent$lambda$9 = VideoInCallContent$lambda$5(mutableState);
                    Modifier modifierAlign5 = boxScopeInstance.align(companion2, companion3.getTopCenter());
                    TweenSpec tweenSpecTween$default9 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$0$0(((Integer) obj2).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    EnterTransition enterTransitionPlus5 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default9, (Function1) objRememberedValue10).plus(EnterExitTransitionKt.fadeIn$default(null, f10, 3, null));
                    TweenSpec tweenSpecTween$default10 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$1$0(((Integer) obj2).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$9, modifierAlign5, enterTransitionPlus5, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default10, (Function1) objRememberedValue11).plus(EnterExitTransitionKt.fadeOut$default(null, f10, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2105889088, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.g
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$2(partner, z10, z11, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                    if (videoTrack2 == null) {
                        i27 = 220;
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceGroup(-82983439);
                        composer2.endReplaceGroup();
                    } else {
                        i27 = 220;
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceGroup(-82983439);
                        composer2.endReplaceGroup();
                    }
                    if (callMediaState2.isCameraEnabled()) {
                        composer2.startReplaceGroup(-82883774);
                        callMediaState3 = callMediaState2;
                        PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-82883774);
                        callMediaState3 = callMediaState2;
                        PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                        composer2.endReplaceGroup();
                    }
                    boolean zVideoInCallContent$lambda$10 = VideoInCallContent$lambda$5(mutableState);
                    Modifier modifierAlign6 = boxScopeInstance.align(companion2, companion3.getBottomCenter());
                    TweenSpec tweenSpecTween$default11 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                    objRememberedValue12 = composer2.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$3$0(((Integer) obj2).intValue()));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue12);
                    }
                    EnterTransition enterTransitionPlus6 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default11, (Function1) objRememberedValue12).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    TweenSpec tweenSpecTween$default12 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                    objRememberedValue13 = composer2.rememberedValue();
                    if (objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.y
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$4$0(((Integer) obj2).intValue()));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue13);
                    }
                    Composer composer5 = composer2;
                    AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$10, modifierAlign6, enterTransitionPlus6, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default12, (Function1) objRememberedValue13).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1647253569, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$5(callMediaState, z10, aVar, aVar2, aVar3, aVar4, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer5, 200064, 16);
                    composerStartRestartGroup = composer5;
                    objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue14 == companion.getEmpty()) {
                        objRememberedValue14 = new VideoCallScreenKt$VideoInCallContent$12$7$1(null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                    }
                    k0 k0Var5 = k0Var2;
                    EffectsKt.LaunchedEffect(k0Var5, (Function2) objRememberedValue14, composerStartRestartGroup, 6);
                    objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue15 == companion.getEmpty()) {
                        objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.c0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$17$7$0((DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                    }
                    EffectsKt.DisposableEffect(k0Var5, (Function1) objRememberedValue15, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar9 = aVar111;
                    aVar11 = aVar112;
                    aVar12 = aVar15;
                } else {
                    callMediaState3 = callMediaState2;
                    composerStartRestartGroup.skipToGroupEnd();
                    aVar9 = aVar5;
                    aVar10 = aVar6;
                    aVar11 = aVar7;
                    aVar12 = aVar8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final CallMediaState callMediaState6 = callMediaState3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.d0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$18(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState6, aVar, aVar2, aVar3, aVar4, aVar9, aVar10, aVar11, aVar12, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i28 |= 24576;
            i19 = i18;
            i20 = i12 & 32768;
            if (i20 != 0) {
                i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar8)) {
                    i21 = 131072;
                } else {
                    i21 = 65536;
                }
                i28 |= i21;
            }
            if ((i13 & 306783379) == 306783378) {
                z12 = true;
            } else {
                z12 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                if (i29 != 0) {
                    objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                    }
                    aVar13 = (lb.a) objRememberedValue19;
                } else {
                    aVar13 = aVar5;
                }
                if (i16 != 0) {
                    objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.e0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                    }
                    aVar10 = (lb.a) objRememberedValue18;
                } else {
                    aVar10 = aVar6;
                }
                if (i19 != 0) {
                    objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.f0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                    }
                    aVar14 = (lb.a) objRememberedValue17;
                } else {
                    aVar14 = aVar7;
                }
                if (i20 != 0) {
                    objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.g0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                    }
                    aVar15 = (lb.a) objRememberedValue16;
                } else {
                    aVar15 = aVar8;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-844261653, i13, i28, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent (VideoCallScreen.kt:227)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    long j13 = 0;
                    MutableState mutableStateMutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j13 << 32) | (j13 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default4);
                    objRememberedValue2 = mutableStateMutableStateOf$default4;
                }
                mutableState2 = (MutableState) objRememberedValue2;
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                k0Var = k0.f43947a;
                zChangedInstance = composerStartRestartGroup.changedInstance(context);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                Boolean boolValueOf16 = Boolean.valueOf(z11);
                if ((i13 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z214 = z13;
                if ((i28 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z215 = z214 | z14;
                i22 = i28;
                if ((i28 & 7168) == 2048) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z16 = z15 | z215;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                EffectsKt.LaunchedEffect(boolValueOf16, (Function2) objRememberedValue4, composerStartRestartGroup, (i13 >> 6) & 14);
                Boolean boolValueOf17 = Boolean.valueOf(z10);
                i23 = i13 & 112;
                if (i23 == 32) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                lb.a aVar113 = aVar13;
                if ((i22 & 458752) == 131072) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                z19 = z18 | z17;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z19) {
                    objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                int i34 = (i13 >> 3) & 14;
                EffectsKt.LaunchedEffect(boolValueOf17, (Function2) objRememberedValue5, composerStartRestartGroup, i34);
                Boolean boolValueOf18 = Boolean.valueOf(z10);
                if (i23 == 32) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                i24 = i13;
                if ((i13 & 7168) == 2048) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                boolean z216 = z21 | z20;
                if ((i22 & 57344) == 16384) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                z23 = z216 | z22;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z23) {
                    aVar16 = aVar14;
                    objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    aVar16 = aVar14;
                    objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(boolValueOf18, (Function2) objRememberedValue6, composerStartRestartGroup, i34);
                Boolean boolValueOf19 = Boolean.valueOf(VideoInCallContent$lambda$5(mutableState));
                Boolean boolValueOf110 = Boolean.valueOf(z10);
                if (i23 == 32) {
                    z24 = true;
                } else {
                    z24 = false;
                }
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (z24) {
                    obj = null;
                    objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    obj = null;
                    objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                EffectsKt.LaunchedEffect(boolValueOf19, boolValueOf110, (Function2) objRememberedValue7, composerStartRestartGroup, i23);
                companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$15$0(mutableState2, (IntSize) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                Modifier modifierOnSizeChanged4 = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default4, (Function1) objRememberedValue8);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new VideoCallScreenKt$VideoInCallContent$11$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                Modifier modifierPointerInput4 = SuspendingPointerInputFilterKt.pointerInput(modifierOnSizeChanged4, k0Var, (PointerInputEventHandler) objRememberedValue9);
                companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput4);
                ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                constructor = companion7.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                lb.a aVar114 = aVar16;
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion7.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion7.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion7.getSetModifier());
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (videoTrack == null) {
                    k0Var2 = k0Var;
                    i25 = i24;
                    i26 = 0;
                    f10 = 0.0f;
                    composerStartRestartGroup.startReplaceGroup(-84583380);
                    VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    k0Var2 = k0Var;
                    i25 = i24;
                    i26 = 0;
                    f10 = 0.0f;
                    composerStartRestartGroup.startReplaceGroup(-84583380);
                    VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                    composerStartRestartGroup.endReplaceGroup();
                }
                AnimatedVisibilityKt.AnimatedVisibility(VideoInCallContent$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, i26, null, 6, null), f10, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, i26, null, 6, null), f10, 2, null), (String) null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9824getLambda$359242039$app_productionPFast(), composerStartRestartGroup, 200064, 18);
                boolean zVideoInCallContent$lambda$11 = VideoInCallContent$lambda$5(mutableState);
                Modifier modifierAlign7 = boxScopeInstance.align(companion2, companion3.getTopCenter());
                TweenSpec tweenSpecTween$default13 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$0$0(((Integer) obj2).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                EnterTransition enterTransitionPlus7 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default13, (Function1) objRememberedValue10).plus(EnterExitTransitionKt.fadeIn$default(null, f10, 3, null));
                TweenSpec tweenSpecTween$default14 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$1$0(((Integer) obj2).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$11, modifierAlign7, enterTransitionPlus7, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default14, (Function1) objRememberedValue11).plus(EnterExitTransitionKt.fadeOut$default(null, f10, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2105889088, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$17$2(partner, z10, z11, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                if (videoTrack2 == null) {
                    i27 = 220;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-82983439);
                    composer2.endReplaceGroup();
                } else {
                    i27 = 220;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-82983439);
                    composer2.endReplaceGroup();
                }
                if (callMediaState2.isCameraEnabled()) {
                    composer2.startReplaceGroup(-82883774);
                    callMediaState3 = callMediaState2;
                    PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-82883774);
                    callMediaState3 = callMediaState2;
                    PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                    composer2.endReplaceGroup();
                }
                boolean zVideoInCallContent$lambda$12 = VideoInCallContent$lambda$5(mutableState);
                Modifier modifierAlign8 = boxScopeInstance.align(companion2, companion3.getBottomCenter());
                TweenSpec tweenSpecTween$default15 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                objRememberedValue12 = composer2.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$3$0(((Integer) obj2).intValue()));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                EnterTransition enterTransitionPlus8 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default15, (Function1) objRememberedValue12).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                TweenSpec tweenSpecTween$default16 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                objRememberedValue13 = composer2.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$4$0(((Integer) obj2).intValue()));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                }
                Composer composer6 = composer2;
                AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$12, modifierAlign8, enterTransitionPlus8, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default16, (Function1) objRememberedValue13).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1647253569, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$17$5(callMediaState, z10, aVar, aVar2, aVar3, aVar4, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer6, 200064, 16);
                composerStartRestartGroup = composer6;
                objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = new VideoCallScreenKt$VideoInCallContent$12$7$1(null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                }
                k0 k0Var6 = k0Var2;
                EffectsKt.LaunchedEffect(k0Var6, (Function2) objRememberedValue14, composerStartRestartGroup, 6);
                objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue15 == companion.getEmpty()) {
                    objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.c0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$7$0((DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                }
                EffectsKt.DisposableEffect(k0Var6, (Function1) objRememberedValue15, composerStartRestartGroup, 54);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar9 = aVar113;
                aVar11 = aVar114;
                aVar12 = aVar15;
            } else {
                callMediaState3 = callMediaState2;
                composerStartRestartGroup.skipToGroupEnd();
                aVar9 = aVar5;
                aVar10 = aVar6;
                aVar11 = aVar7;
                aVar12 = aVar8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final CallMediaState callMediaState7 = callMediaState3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$18(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState7, aVar, aVar2, aVar3, aVar4, aVar9, aVar10, aVar11, aVar12, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i28 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        i15 = i12 & 8192;
        if (i15 != 0) {
            i16 = i15;
            if ((i11 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar6)) {
                    i17 = 2048;
                } else {
                    i17 = 1024;
                }
                i28 |= i17;
            }
            i18 = i12 & 16384;
            if (i18 != 0) {
                i19 = i18;
                if ((i11 & 24576) == 0) {
                    i28 |= composerStartRestartGroup.changedInstance(aVar7) ? 16384 : 8192;
                }
                i20 = i12 & 32768;
                if (i20 != 0) {
                    i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar8)) {
                        i21 = 131072;
                    } else {
                        i21 = 65536;
                    }
                    i28 |= i21;
                }
                if ((i13 & 306783379) == 306783378) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                    if (i29 != 0) {
                        objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                        }
                        aVar13 = (lb.a) objRememberedValue19;
                    } else {
                        aVar13 = aVar5;
                    }
                    if (i16 != 0) {
                        objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.e0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                        }
                        aVar10 = (lb.a) objRememberedValue18;
                    } else {
                        aVar10 = aVar6;
                    }
                    if (i19 != 0) {
                        objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.f0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                        }
                        aVar14 = (lb.a) objRememberedValue17;
                    } else {
                        aVar14 = aVar7;
                    }
                    if (i20 != 0) {
                        objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.g0
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                        }
                        aVar15 = (lb.a) objRememberedValue16;
                    } else {
                        aVar15 = aVar8;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-844261653, i13, i28, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent (VideoCallScreen.kt:227)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        long j14 = 0;
                        MutableState mutableStateMutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j14 << 32) | (j14 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default5);
                        objRememberedValue2 = mutableStateMutableStateOf$default5;
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    k0Var = k0.f43947a;
                    zChangedInstance = composerStartRestartGroup.changedInstance(context);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                    Boolean boolValueOf111 = Boolean.valueOf(z11);
                    if ((i13 & 896) == 256) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean z217 = z13;
                    if ((i28 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z218 = z217 | z14;
                    i22 = i28;
                    if ((i28 & 7168) == 2048) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    z16 = z15 | z218;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf111, (Function2) objRememberedValue4, composerStartRestartGroup, (i13 >> 6) & 14);
                    Boolean boolValueOf112 = Boolean.valueOf(z10);
                    i23 = i13 & 112;
                    if (i23 == 32) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    lb.a aVar115 = aVar13;
                    if ((i22 & 458752) == 131072) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    z19 = z18 | z17;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z19) {
                        objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    int i35 = (i13 >> 3) & 14;
                    EffectsKt.LaunchedEffect(boolValueOf112, (Function2) objRememberedValue5, composerStartRestartGroup, i35);
                    Boolean boolValueOf113 = Boolean.valueOf(z10);
                    if (i23 == 32) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    i24 = i13;
                    if ((i13 & 7168) == 2048) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    boolean z219 = z21 | z20;
                    if ((i22 & 57344) == 16384) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z23 = z219 | z22;
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z23) {
                        aVar16 = aVar14;
                        objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        aVar16 = aVar14;
                        objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf113, (Function2) objRememberedValue6, composerStartRestartGroup, i35);
                    Boolean boolValueOf114 = Boolean.valueOf(VideoInCallContent$lambda$5(mutableState));
                    Boolean boolValueOf115 = Boolean.valueOf(z10);
                    if (i23 == 32) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (z24) {
                        obj = null;
                        objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        obj = null;
                        objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    EffectsKt.LaunchedEffect(boolValueOf114, boolValueOf115, (Function2) objRememberedValue7, composerStartRestartGroup, i23);
                    companion2 = Modifier.INSTANCE;
                    Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$15$0(mutableState2, (IntSize) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Modifier modifierOnSizeChanged5 = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default5, (Function1) objRememberedValue8);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new VideoCallScreenKt$VideoInCallContent$11$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    Modifier modifierPointerInput5 = SuspendingPointerInputFilterKt.pointerInput(modifierOnSizeChanged5, k0Var, (PointerInputEventHandler) objRememberedValue9);
                    companion3 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput5);
                    ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                    constructor = companion8.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    lb.a aVar116 = aVar16;
                    Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, companion8.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion8.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion8.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion8.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion8.getSetModifier());
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    if (videoTrack == null) {
                        k0Var2 = k0Var;
                        i25 = i24;
                        i26 = 0;
                        f10 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-84583380);
                        VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        k0Var2 = k0Var;
                        i25 = i24;
                        i26 = 0;
                        f10 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-84583380);
                        VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(VideoInCallContent$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, i26, null, 6, null), f10, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, i26, null, 6, null), f10, 2, null), (String) null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9824getLambda$359242039$app_productionPFast(), composerStartRestartGroup, 200064, 18);
                    boolean zVideoInCallContent$lambda$13 = VideoInCallContent$lambda$5(mutableState);
                    Modifier modifierAlign9 = boxScopeInstance.align(companion2, companion3.getTopCenter());
                    TweenSpec tweenSpecTween$default17 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$0$0(((Integer) obj2).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    EnterTransition enterTransitionPlus9 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default17, (Function1) objRememberedValue10).plus(EnterExitTransitionKt.fadeIn$default(null, f10, 3, null));
                    TweenSpec tweenSpecTween$default18 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$1$0(((Integer) obj2).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$13, modifierAlign9, enterTransitionPlus9, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default18, (Function1) objRememberedValue11).plus(EnterExitTransitionKt.fadeOut$default(null, f10, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2105889088, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.g
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$2(partner, z10, z11, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                    if (videoTrack2 == null) {
                        i27 = 220;
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceGroup(-82983439);
                        composer2.endReplaceGroup();
                    } else {
                        i27 = 220;
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceGroup(-82983439);
                        composer2.endReplaceGroup();
                    }
                    if (callMediaState2.isCameraEnabled()) {
                        composer2.startReplaceGroup(-82883774);
                        callMediaState3 = callMediaState2;
                        PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-82883774);
                        callMediaState3 = callMediaState2;
                        PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                        composer2.endReplaceGroup();
                    }
                    boolean zVideoInCallContent$lambda$14 = VideoInCallContent$lambda$5(mutableState);
                    Modifier modifierAlign10 = boxScopeInstance.align(companion2, companion3.getBottomCenter());
                    TweenSpec tweenSpecTween$default19 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                    objRememberedValue12 = composer2.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$3$0(((Integer) obj2).intValue()));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue12);
                    }
                    EnterTransition enterTransitionPlus10 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default19, (Function1) objRememberedValue12).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    TweenSpec tweenSpecTween$default110 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                    objRememberedValue13 = composer2.rememberedValue();
                    if (objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.y
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$4$0(((Integer) obj2).intValue()));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue13);
                    }
                    Composer composer7 = composer2;
                    AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$14, modifierAlign10, enterTransitionPlus10, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default110, (Function1) objRememberedValue13).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1647253569, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$5(callMediaState, z10, aVar, aVar2, aVar3, aVar4, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer7, 200064, 16);
                    composerStartRestartGroup = composer7;
                    objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue14 == companion.getEmpty()) {
                        objRememberedValue14 = new VideoCallScreenKt$VideoInCallContent$12$7$1(null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                    }
                    k0 k0Var7 = k0Var2;
                    EffectsKt.LaunchedEffect(k0Var7, (Function2) objRememberedValue14, composerStartRestartGroup, 6);
                    objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue15 == companion.getEmpty()) {
                        objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.c0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoCallScreenKt.VideoInCallContent$lambda$17$7$0((DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                    }
                    EffectsKt.DisposableEffect(k0Var7, (Function1) objRememberedValue15, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar9 = aVar115;
                    aVar11 = aVar116;
                    aVar12 = aVar15;
                } else {
                    callMediaState3 = callMediaState2;
                    composerStartRestartGroup.skipToGroupEnd();
                    aVar9 = aVar5;
                    aVar10 = aVar6;
                    aVar11 = aVar7;
                    aVar12 = aVar8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final CallMediaState callMediaState8 = callMediaState3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.d0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$18(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState8, aVar, aVar2, aVar3, aVar4, aVar9, aVar10, aVar11, aVar12, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i28 |= 24576;
            i19 = i18;
            i20 = i12 & 32768;
            if (i20 != 0) {
                i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar8)) {
                    i21 = 131072;
                } else {
                    i21 = 65536;
                }
                i28 |= i21;
            }
            if ((i13 & 306783379) == 306783378) {
                z12 = true;
            } else {
                z12 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                if (i29 != 0) {
                    objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                    }
                    aVar13 = (lb.a) objRememberedValue19;
                } else {
                    aVar13 = aVar5;
                }
                if (i16 != 0) {
                    objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.e0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                    }
                    aVar10 = (lb.a) objRememberedValue18;
                } else {
                    aVar10 = aVar6;
                }
                if (i19 != 0) {
                    objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.f0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                    }
                    aVar14 = (lb.a) objRememberedValue17;
                } else {
                    aVar14 = aVar7;
                }
                if (i20 != 0) {
                    objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.g0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                    }
                    aVar15 = (lb.a) objRememberedValue16;
                } else {
                    aVar15 = aVar8;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-844261653, i13, i28, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent (VideoCallScreen.kt:227)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    long j15 = 0;
                    MutableState mutableStateMutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j15 << 32) | (j15 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default6);
                    objRememberedValue2 = mutableStateMutableStateOf$default6;
                }
                mutableState2 = (MutableState) objRememberedValue2;
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                k0Var = k0.f43947a;
                zChangedInstance = composerStartRestartGroup.changedInstance(context);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                Boolean boolValueOf116 = Boolean.valueOf(z11);
                if ((i13 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z2110 = z13;
                if ((i28 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z2111 = z2110 | z14;
                i22 = i28;
                if ((i28 & 7168) == 2048) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z16 = z15 | z2111;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                EffectsKt.LaunchedEffect(boolValueOf116, (Function2) objRememberedValue4, composerStartRestartGroup, (i13 >> 6) & 14);
                Boolean boolValueOf117 = Boolean.valueOf(z10);
                i23 = i13 & 112;
                if (i23 == 32) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                lb.a aVar117 = aVar13;
                if ((i22 & 458752) == 131072) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                z19 = z18 | z17;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z19) {
                    objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                int i36 = (i13 >> 3) & 14;
                EffectsKt.LaunchedEffect(boolValueOf117, (Function2) objRememberedValue5, composerStartRestartGroup, i36);
                Boolean boolValueOf118 = Boolean.valueOf(z10);
                if (i23 == 32) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                i24 = i13;
                if ((i13 & 7168) == 2048) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                boolean z2112 = z21 | z20;
                if ((i22 & 57344) == 16384) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                z23 = z2112 | z22;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z23) {
                    aVar16 = aVar14;
                    objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    aVar16 = aVar14;
                    objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(boolValueOf118, (Function2) objRememberedValue6, composerStartRestartGroup, i36);
                Boolean boolValueOf119 = Boolean.valueOf(VideoInCallContent$lambda$5(mutableState));
                Boolean boolValueOf1110 = Boolean.valueOf(z10);
                if (i23 == 32) {
                    z24 = true;
                } else {
                    z24 = false;
                }
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (z24) {
                    obj = null;
                    objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    obj = null;
                    objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                EffectsKt.LaunchedEffect(boolValueOf119, boolValueOf1110, (Function2) objRememberedValue7, composerStartRestartGroup, i23);
                companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$15$0(mutableState2, (IntSize) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                Modifier modifierOnSizeChanged6 = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default6, (Function1) objRememberedValue8);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new VideoCallScreenKt$VideoInCallContent$11$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                Modifier modifierPointerInput6 = SuspendingPointerInputFilterKt.pointerInput(modifierOnSizeChanged6, k0Var, (PointerInputEventHandler) objRememberedValue9);
                companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput6);
                ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                constructor = companion9.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
                lb.a aVar118 = aVar16;
                Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, companion9.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion9.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion9.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion9.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion9.getSetModifier());
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (videoTrack == null) {
                    k0Var2 = k0Var;
                    i25 = i24;
                    i26 = 0;
                    f10 = 0.0f;
                    composerStartRestartGroup.startReplaceGroup(-84583380);
                    VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    k0Var2 = k0Var;
                    i25 = i24;
                    i26 = 0;
                    f10 = 0.0f;
                    composerStartRestartGroup.startReplaceGroup(-84583380);
                    VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                    composerStartRestartGroup.endReplaceGroup();
                }
                AnimatedVisibilityKt.AnimatedVisibility(VideoInCallContent$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, i26, null, 6, null), f10, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, i26, null, 6, null), f10, 2, null), (String) null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9824getLambda$359242039$app_productionPFast(), composerStartRestartGroup, 200064, 18);
                boolean zVideoInCallContent$lambda$15 = VideoInCallContent$lambda$5(mutableState);
                Modifier modifierAlign11 = boxScopeInstance.align(companion2, companion3.getTopCenter());
                TweenSpec tweenSpecTween$default111 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$0$0(((Integer) obj2).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                EnterTransition enterTransitionPlus11 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default111, (Function1) objRememberedValue10).plus(EnterExitTransitionKt.fadeIn$default(null, f10, 3, null));
                TweenSpec tweenSpecTween$default112 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$1$0(((Integer) obj2).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$15, modifierAlign11, enterTransitionPlus11, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default112, (Function1) objRememberedValue11).plus(EnterExitTransitionKt.fadeOut$default(null, f10, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2105889088, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$17$2(partner, z10, z11, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                if (videoTrack2 == null) {
                    i27 = 220;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-82983439);
                    composer2.endReplaceGroup();
                } else {
                    i27 = 220;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-82983439);
                    composer2.endReplaceGroup();
                }
                if (callMediaState2.isCameraEnabled()) {
                    composer2.startReplaceGroup(-82883774);
                    callMediaState3 = callMediaState2;
                    PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-82883774);
                    callMediaState3 = callMediaState2;
                    PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                    composer2.endReplaceGroup();
                }
                boolean zVideoInCallContent$lambda$16 = VideoInCallContent$lambda$5(mutableState);
                Modifier modifierAlign12 = boxScopeInstance.align(companion2, companion3.getBottomCenter());
                TweenSpec tweenSpecTween$default113 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                objRememberedValue12 = composer2.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$3$0(((Integer) obj2).intValue()));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                EnterTransition enterTransitionPlus12 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default113, (Function1) objRememberedValue12).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                TweenSpec tweenSpecTween$default114 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                objRememberedValue13 = composer2.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$4$0(((Integer) obj2).intValue()));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                }
                Composer composer8 = composer2;
                AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$16, modifierAlign12, enterTransitionPlus12, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default114, (Function1) objRememberedValue13).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1647253569, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$17$5(callMediaState, z10, aVar, aVar2, aVar3, aVar4, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer8, 200064, 16);
                composerStartRestartGroup = composer8;
                objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = new VideoCallScreenKt$VideoInCallContent$12$7$1(null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                }
                k0 k0Var8 = k0Var2;
                EffectsKt.LaunchedEffect(k0Var8, (Function2) objRememberedValue14, composerStartRestartGroup, 6);
                objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue15 == companion.getEmpty()) {
                    objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.c0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$7$0((DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                }
                EffectsKt.DisposableEffect(k0Var8, (Function1) objRememberedValue15, composerStartRestartGroup, 54);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar9 = aVar117;
                aVar11 = aVar118;
                aVar12 = aVar15;
            } else {
                callMediaState3 = callMediaState2;
                composerStartRestartGroup.skipToGroupEnd();
                aVar9 = aVar5;
                aVar10 = aVar6;
                aVar11 = aVar7;
                aVar12 = aVar8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final CallMediaState callMediaState9 = callMediaState3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$18(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState9, aVar, aVar2, aVar3, aVar4, aVar9, aVar10, aVar11, aVar12, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i28 |= 3072;
        i16 = i15;
        i18 = i12 & 16384;
        if (i18 != 0) {
            i19 = i18;
            if ((i11 & 24576) == 0) {
                i28 |= composerStartRestartGroup.changedInstance(aVar7) ? 16384 : 8192;
            }
            i20 = i12 & 32768;
            if (i20 != 0) {
                i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar8)) {
                    i21 = 131072;
                } else {
                    i21 = 65536;
                }
                i28 |= i21;
            }
            if ((i13 & 306783379) == 306783378) {
                z12 = true;
            } else {
                z12 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                if (i29 != 0) {
                    objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                    }
                    aVar13 = (lb.a) objRememberedValue19;
                } else {
                    aVar13 = aVar5;
                }
                if (i16 != 0) {
                    objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.e0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                    }
                    aVar10 = (lb.a) objRememberedValue18;
                } else {
                    aVar10 = aVar6;
                }
                if (i19 != 0) {
                    objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.f0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                    }
                    aVar14 = (lb.a) objRememberedValue17;
                } else {
                    aVar14 = aVar7;
                }
                if (i20 != 0) {
                    objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.g0
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                    }
                    aVar15 = (lb.a) objRememberedValue16;
                } else {
                    aVar15 = aVar8;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-844261653, i13, i28, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent (VideoCallScreen.kt:227)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    long j16 = 0;
                    MutableState mutableStateMutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j16 << 32) | (j16 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default7);
                    objRememberedValue2 = mutableStateMutableStateOf$default7;
                }
                mutableState2 = (MutableState) objRememberedValue2;
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                k0Var = k0.f43947a;
                zChangedInstance = composerStartRestartGroup.changedInstance(context);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                Boolean boolValueOf1111 = Boolean.valueOf(z11);
                if ((i13 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z2113 = z13;
                if ((i28 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z2114 = z2113 | z14;
                i22 = i28;
                if ((i28 & 7168) == 2048) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z16 = z15 | z2114;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                EffectsKt.LaunchedEffect(boolValueOf1111, (Function2) objRememberedValue4, composerStartRestartGroup, (i13 >> 6) & 14);
                Boolean boolValueOf1112 = Boolean.valueOf(z10);
                i23 = i13 & 112;
                if (i23 == 32) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                lb.a aVar119 = aVar13;
                if ((i22 & 458752) == 131072) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                z19 = z18 | z17;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z19) {
                    objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                int i37 = (i13 >> 3) & 14;
                EffectsKt.LaunchedEffect(boolValueOf1112, (Function2) objRememberedValue5, composerStartRestartGroup, i37);
                Boolean boolValueOf1113 = Boolean.valueOf(z10);
                if (i23 == 32) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                i24 = i13;
                if ((i13 & 7168) == 2048) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                boolean z2115 = z21 | z20;
                if ((i22 & 57344) == 16384) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                z23 = z2115 | z22;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z23) {
                    aVar16 = aVar14;
                    objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    aVar16 = aVar14;
                    objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(boolValueOf1113, (Function2) objRememberedValue6, composerStartRestartGroup, i37);
                Boolean boolValueOf1114 = Boolean.valueOf(VideoInCallContent$lambda$5(mutableState));
                Boolean boolValueOf1115 = Boolean.valueOf(z10);
                if (i23 == 32) {
                    z24 = true;
                } else {
                    z24 = false;
                }
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (z24) {
                    obj = null;
                    objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    obj = null;
                    objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                EffectsKt.LaunchedEffect(boolValueOf1114, boolValueOf1115, (Function2) objRememberedValue7, composerStartRestartGroup, i23);
                companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$15$0(mutableState2, (IntSize) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                Modifier modifierOnSizeChanged7 = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default7, (Function1) objRememberedValue8);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new VideoCallScreenKt$VideoInCallContent$11$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                Modifier modifierPointerInput7 = SuspendingPointerInputFilterKt.pointerInput(modifierOnSizeChanged7, k0Var, (PointerInputEventHandler) objRememberedValue9);
                companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput7);
                ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                constructor = companion10.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
                lb.a aVar1110 = aVar16;
                Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, companion10.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion10.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion10.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion10.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion10.getSetModifier());
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (videoTrack == null) {
                    k0Var2 = k0Var;
                    i25 = i24;
                    i26 = 0;
                    f10 = 0.0f;
                    composerStartRestartGroup.startReplaceGroup(-84583380);
                    VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    k0Var2 = k0Var;
                    i25 = i24;
                    i26 = 0;
                    f10 = 0.0f;
                    composerStartRestartGroup.startReplaceGroup(-84583380);
                    VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                    composerStartRestartGroup.endReplaceGroup();
                }
                AnimatedVisibilityKt.AnimatedVisibility(VideoInCallContent$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, i26, null, 6, null), f10, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, i26, null, 6, null), f10, 2, null), (String) null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9824getLambda$359242039$app_productionPFast(), composerStartRestartGroup, 200064, 18);
                boolean zVideoInCallContent$lambda$17 = VideoInCallContent$lambda$5(mutableState);
                Modifier modifierAlign13 = boxScopeInstance.align(companion2, companion3.getTopCenter());
                TweenSpec tweenSpecTween$default115 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$0$0(((Integer) obj2).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                EnterTransition enterTransitionPlus13 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default115, (Function1) objRememberedValue10).plus(EnterExitTransitionKt.fadeIn$default(null, f10, 3, null));
                TweenSpec tweenSpecTween$default116 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$1$0(((Integer) obj2).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$17, modifierAlign13, enterTransitionPlus13, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default116, (Function1) objRememberedValue11).plus(EnterExitTransitionKt.fadeOut$default(null, f10, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2105889088, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$17$2(partner, z10, z11, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                if (videoTrack2 == null) {
                    i27 = 220;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-82983439);
                    composer2.endReplaceGroup();
                } else {
                    i27 = 220;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-82983439);
                    composer2.endReplaceGroup();
                }
                if (callMediaState2.isCameraEnabled()) {
                    composer2.startReplaceGroup(-82883774);
                    callMediaState3 = callMediaState2;
                    PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-82883774);
                    callMediaState3 = callMediaState2;
                    PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                    composer2.endReplaceGroup();
                }
                boolean zVideoInCallContent$lambda$18 = VideoInCallContent$lambda$5(mutableState);
                Modifier modifierAlign14 = boxScopeInstance.align(companion2, companion3.getBottomCenter());
                TweenSpec tweenSpecTween$default117 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                objRememberedValue12 = composer2.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$3$0(((Integer) obj2).intValue()));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                EnterTransition enterTransitionPlus14 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default117, (Function1) objRememberedValue12).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                TweenSpec tweenSpecTween$default118 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
                objRememberedValue13 = composer2.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$4$0(((Integer) obj2).intValue()));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                }
                Composer composer9 = composer2;
                AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$18, modifierAlign14, enterTransitionPlus14, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default118, (Function1) objRememberedValue13).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1647253569, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$17$5(callMediaState, z10, aVar, aVar2, aVar3, aVar4, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer9, 200064, 16);
                composerStartRestartGroup = composer9;
                objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue14 == companion.getEmpty()) {
                    objRememberedValue14 = new VideoCallScreenKt$VideoInCallContent$12$7$1(null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                }
                k0 k0Var9 = k0Var2;
                EffectsKt.LaunchedEffect(k0Var9, (Function2) objRememberedValue14, composerStartRestartGroup, 6);
                objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue15 == companion.getEmpty()) {
                    objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.c0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoCallScreenKt.VideoInCallContent$lambda$17$7$0((DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                }
                EffectsKt.DisposableEffect(k0Var9, (Function1) objRememberedValue15, composerStartRestartGroup, 54);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar9 = aVar119;
                aVar11 = aVar1110;
                aVar12 = aVar15;
            } else {
                callMediaState3 = callMediaState2;
                composerStartRestartGroup.skipToGroupEnd();
                aVar9 = aVar5;
                aVar10 = aVar6;
                aVar11 = aVar7;
                aVar12 = aVar8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final CallMediaState callMediaState10 = callMediaState3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$18(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState10, aVar, aVar2, aVar3, aVar4, aVar9, aVar10, aVar11, aVar12, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i28 |= 24576;
        i19 = i18;
        i20 = i12 & 32768;
        if (i20 != 0) {
            i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(aVar8)) {
                i21 = 131072;
            } else {
                i21 = 65536;
            }
            i28 |= i21;
        }
        if ((i13 & 306783379) == 306783378) {
            z12 = true;
        } else {
            z12 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
            if (i29 != 0) {
                objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue19 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.c
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                }
                aVar13 = (lb.a) objRememberedValue19;
            } else {
                aVar13 = aVar5;
            }
            if (i16 != 0) {
                objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue18 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.e0
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                }
                aVar10 = (lb.a) objRememberedValue18;
            } else {
                aVar10 = aVar6;
            }
            if (i19 != 0) {
                objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.f0
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                }
                aVar14 = (lb.a) objRememberedValue17;
            } else {
                aVar14 = aVar7;
            }
            if (i20 != 0) {
                objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.video.g0
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                }
                aVar15 = (lb.a) objRememberedValue16;
            } else {
                aVar15 = aVar8;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-844261653, i13, i28, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent (VideoCallScreen.kt:227)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                long j17 = 0;
                MutableState mutableStateMutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j17 << 32) | (j17 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default8);
                objRememberedValue2 = mutableStateMutableStateOf$default8;
            }
            mutableState2 = (MutableState) objRememberedValue2;
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            k0Var = k0.f43947a;
            zChangedInstance = composerStartRestartGroup.changedInstance(context);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$10$0(context, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
            Boolean boolValueOf1116 = Boolean.valueOf(z11);
            if ((i13 & 896) == 256) {
                z13 = true;
            } else {
                z13 = false;
            }
            boolean z2116 = z13;
            if ((i28 & 896) == 256) {
                z14 = true;
            } else {
                z14 = false;
            }
            boolean z2117 = z2116 | z14;
            i22 = i28;
            if ((i28 & 7168) == 2048) {
                z15 = true;
            } else {
                z15 = false;
            }
            z16 = z15 | z2117;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z16) {
                objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new VideoCallScreenKt$VideoInCallContent$6$1(z11, aVar13, aVar10, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(boolValueOf1116, (Function2) objRememberedValue4, composerStartRestartGroup, (i13 >> 6) & 14);
            Boolean boolValueOf1117 = Boolean.valueOf(z10);
            i23 = i13 & 112;
            if (i23 == 32) {
                z17 = true;
            } else {
                z17 = false;
            }
            lb.a aVar1111 = aVar13;
            if ((i22 & 458752) == 131072) {
                z18 = true;
            } else {
                z18 = false;
            }
            z19 = z18 | z17;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z19) {
                objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new VideoCallScreenKt$VideoInCallContent$7$1(z10, aVar15, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            int i38 = (i13 >> 3) & 14;
            EffectsKt.LaunchedEffect(boolValueOf1117, (Function2) objRememberedValue5, composerStartRestartGroup, i38);
            Boolean boolValueOf1118 = Boolean.valueOf(z10);
            if (i23 == 32) {
                z20 = true;
            } else {
                z20 = false;
            }
            i24 = i13;
            if ((i13 & 7168) == 2048) {
                z21 = true;
            } else {
                z21 = false;
            }
            boolean z2118 = z21 | z20;
            if ((i22 & 57344) == 16384) {
                z22 = true;
            } else {
                z22 = false;
            }
            z23 = z2118 | z22;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z23) {
                aVar16 = aVar14;
                objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                aVar16 = aVar14;
                objRememberedValue6 = new VideoCallScreenKt$VideoInCallContent$8$1(z10, callMediaState, aVar16, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            EffectsKt.LaunchedEffect(boolValueOf1118, (Function2) objRememberedValue6, composerStartRestartGroup, i38);
            Boolean boolValueOf1119 = Boolean.valueOf(VideoInCallContent$lambda$5(mutableState));
            Boolean boolValueOf11110 = Boolean.valueOf(z10);
            if (i23 == 32) {
                z24 = true;
            } else {
                z24 = false;
            }
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (z24) {
                obj = null;
                objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                obj = null;
                objRememberedValue7 = new VideoCallScreenKt$VideoInCallContent$9$1(z10, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            EffectsKt.LaunchedEffect(boolValueOf1119, boolValueOf11110, (Function2) objRememberedValue7, composerStartRestartGroup, i23);
            companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$15$0(mutableState2, (IntSize) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            Modifier modifierOnSizeChanged8 = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default8, (Function1) objRememberedValue8);
            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new VideoCallScreenKt$VideoInCallContent$11$1(mutableState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Modifier modifierPointerInput8 = SuspendingPointerInputFilterKt.pointerInput(modifierOnSizeChanged8, k0Var, (PointerInputEventHandler) objRememberedValue9);
            companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int iA8 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput8);
            ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
            constructor = companion11.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
            lb.a aVar1112 = aVar16;
            Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, companion11.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion11.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion11.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion11.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion11.getSetModifier());
            boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (videoTrack == null) {
                k0Var2 = k0Var;
                i25 = i24;
                i26 = 0;
                f10 = 0.0f;
                composerStartRestartGroup.startReplaceGroup(-84583380);
                VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                k0Var2 = k0Var;
                i25 = i24;
                i26 = 0;
                f10 = 0.0f;
                composerStartRestartGroup.startReplaceGroup(-84583380);
                VideoPlaceholderBackground(partner, composerStartRestartGroup, i25 & 14);
                composerStartRestartGroup.endReplaceGroup();
            }
            AnimatedVisibilityKt.AnimatedVisibility(VideoInCallContent$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, i26, null, 6, null), f10, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, i26, null, 6, null), f10, 2, null), (String) null, ComposableSingletons$VideoCallScreenKt.INSTANCE.m9824getLambda$359242039$app_productionPFast(), composerStartRestartGroup, 200064, 18);
            boolean zVideoInCallContent$lambda$19 = VideoInCallContent$lambda$5(mutableState);
            Modifier modifierAlign15 = boxScopeInstance.align(companion2, companion3.getTopCenter());
            TweenSpec tweenSpecTween$default119 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$0$0(((Integer) obj2).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            EnterTransition enterTransitionPlus15 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default119, (Function1) objRememberedValue10).plus(EnterExitTransitionKt.fadeIn$default(null, f10, 3, null));
            TweenSpec tweenSpecTween$default1110 = AnimationSpecKt.tween$default(220, i26, null, 6, null);
            objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$1$0(((Integer) obj2).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$19, modifierAlign15, enterTransitionPlus15, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default1110, (Function1) objRememberedValue11).plus(EnterExitTransitionKt.fadeOut$default(null, f10, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2105889088, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return VideoCallScreenKt.VideoInCallContent$lambda$17$2(partner, z10, z11, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
            if (videoTrack2 == null) {
                i27 = 220;
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-82983439);
                composer2.endReplaceGroup();
            } else {
                i27 = 220;
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-82983439);
                composer2.endReplaceGroup();
            }
            if (callMediaState2.isCameraEnabled()) {
                composer2.startReplaceGroup(-82883774);
                callMediaState3 = callMediaState2;
                PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-82883774);
                callMediaState3 = callMediaState2;
                PartnerMediaStateBar(callMediaState3, PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion2, companion3.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(MenuKt.InTransitionDuration), 7, null), composer2, (i25 >> 21) & 14);
                composer2.endReplaceGroup();
            }
            boolean zVideoInCallContent$lambda$110 = VideoInCallContent$lambda$5(mutableState);
            Modifier modifierAlign16 = boxScopeInstance.align(companion2, companion3.getBottomCenter());
            TweenSpec tweenSpecTween$default1111 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
            objRememberedValue12 = composer2.rememberedValue();
            if (objRememberedValue12 == companion.getEmpty()) {
                objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$3$0(((Integer) obj2).intValue()));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue12);
            }
            EnterTransition enterTransitionPlus16 = EnterExitTransitionKt.slideInVertically(tweenSpecTween$default1111, (Function1) objRememberedValue12).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
            TweenSpec tweenSpecTween$default1112 = AnimationSpecKt.tween$default(i27, i26, null, 6, null);
            objRememberedValue13 = composer2.rememberedValue();
            if (objRememberedValue13 == companion.getEmpty()) {
                objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Integer.valueOf(VideoCallScreenKt.VideoInCallContent$lambda$17$4$0(((Integer) obj2).intValue()));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue13);
            }
            Composer composer10 = composer2;
            AnimatedVisibilityKt.AnimatedVisibility(zVideoInCallContent$lambda$110, modifierAlign16, enterTransitionPlus16, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default1112, (Function1) objRememberedValue13).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1647253569, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return VideoCallScreenKt.VideoInCallContent$lambda$17$5(callMediaState, z10, aVar, aVar2, aVar3, aVar4, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer2, 54), composer10, 200064, 16);
            composerStartRestartGroup = composer10;
            objRememberedValue14 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue14 == companion.getEmpty()) {
                objRememberedValue14 = new VideoCallScreenKt$VideoInCallContent$12$7$1(null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
            }
            k0 k0Var10 = k0Var2;
            EffectsKt.LaunchedEffect(k0Var10, (Function2) objRememberedValue14, composerStartRestartGroup, 6);
            objRememberedValue15 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue15 == companion.getEmpty()) {
                objRememberedValue15 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return VideoCallScreenKt.VideoInCallContent$lambda$17$7$0((DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
            }
            EffectsKt.DisposableEffect(k0Var10, (Function1) objRememberedValue15, composerStartRestartGroup, 54);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aVar9 = aVar1111;
            aVar11 = aVar1112;
            aVar12 = aVar15;
        } else {
            callMediaState3 = callMediaState2;
            composerStartRestartGroup.skipToGroupEnd();
            aVar9 = aVar5;
            aVar10 = aVar6;
            aVar11 = aVar7;
            aVar12 = aVar8;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final CallMediaState callMediaState11 = callMediaState3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return VideoCallScreenKt.VideoInCallContent$lambda$18(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState11, aVar, aVar2, aVar3, aVar4, aVar9, aVar10, aVar11, aVar12, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult VideoInCallContent$lambda$10$0(Context context, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        Z17InlineUtilsKt.findActivity(context).getWindow().addFlags(128);
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.call.screen.video.VideoCallScreenKt$VideoInCallContent$lambda$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoInCallContent$lambda$15$0(MutableState mutableState, IntSize intSize) {
        VideoInCallContent$lambda$9(mutableState, intSize.m8994unboximpl());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VideoInCallContent$lambda$17$0$0(int i10) {
        return -i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VideoInCallContent$lambda$17$1$0(int i10) {
        return -i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 VideoInCallContent$lambda$17$2(Partner partner, boolean z10, boolean z11, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2105889088, i10, -1, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent.<anonymous>.<anonymous> (VideoCallScreen.kt:300)");
        }
        VideoTopBar(partner, z10, z11, PaddingKt.m1726paddingVpY3zN4(WindowInsetsPadding_androidKt.safeContentPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null)), Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(12)), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 VideoInCallContent$lambda$17$5(CallMediaState callMediaState, boolean z10, lb.a aVar, lb.a aVar2, lb.a aVar3, lb.a aVar4, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1647253569, i10, -1, "cu.todus.android.uiCompose.call.screen.video.VideoInCallContent.<anonymous>.<anonymous> (VideoCallScreen.kt:341)");
        }
        float f10 = 24;
        VideoControlsBar(callMediaState, z10, aVar, aVar2, aVar3, aVar4, PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl(f10), 0.0f, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(32), 2, null), composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult VideoInCallContent$lambda$17$7$0(DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.call.screen.video.VideoCallScreenKt$VideoInCallContent$lambda$17$7$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                MediaModule.Companion companion = MediaModule.INSTANCE;
                companion.getInstance().setCheckerActiveInCall(false);
                companion.getInstance().setVideoCallActive(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoInCallContent$lambda$18(Partner partner, boolean z10, boolean z11, CallMediaState callMediaState, VideoTrack videoTrack, VideoTrack videoTrack2, WebRtcSessionManagerImpl webRtcSessionManagerImpl, CallMediaState callMediaState2, lb.a aVar, lb.a aVar2, lb.a aVar3, lb.a aVar4, lb.a aVar5, lb.a aVar6, lb.a aVar7, lb.a aVar8, int i10, int i11, int i12, Composer composer, int i13) {
        VideoInCallContent(partner, z10, z11, callMediaState, videoTrack, videoTrack2, webRtcSessionManagerImpl, callMediaState2, aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoInCallContent$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoInCallContent$lambda$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final long VideoInCallContent$lambda$8(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m8994unboximpl();
    }

    private static final void VideoInCallContent$lambda$9(MutableState<IntSize> mutableState, long j10) {
        mutableState.setValue(IntSize.m8982boximpl(j10));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void VideoPlaceholderBackground(final Partner partner, Composer composer, final int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(120030658);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(partner) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(120030658, i11, -1, "cu.todus.android.uiCompose.call.screen.video.VideoPlaceholderBackground (VideoCallScreen.kt:386)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierBackground$default = BackgroundKt.background$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Brush.Companion.m5823radialGradientP_VxKs$default(Brush.INSTANCE, va.w.q(Color.m5856boximpl(ColorKt.Color(4280158216L)), Color.m5856boximpl(ColorKt.Color(4278715396L))), 0L, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(MenuKt.InTransitionDuration)), partner.getPicture(), Integer.valueOf(R.drawable.profile), null, null, 0, null, false, null, partner.getName(), true, 0, composerStartRestartGroup, 6, 6, 2552);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallScreenKt.VideoPlaceholderBackground$lambda$1(partner, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoPlaceholderBackground$lambda$1(Partner partner, int i10, Composer composer, int i11) {
        VideoPlaceholderBackground(partner, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VideoScrim(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1461193315);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1461193315, i10, -1, "cu.todus.android.uiCompose.call.screen.video.VideoScrim (VideoCallScreen.kt:368)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierBackground$default = BackgroundKt.background$default(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(WebmConstants.MkvEbmlElement.BLOCK_GROUP)), Brush.Companion.m5827verticalGradient8A3gB4$default(Brush.INSTANCE, va.w.q(Color.m5856boximpl(ColorKt.Color(3423077380L)), Color.m5856boximpl(Color.INSTANCE.m5901getTransparent0d7_KjU())), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.endNode();
            Modifier modifierBackground$default2 = BackgroundKt.background$default(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(200)), ControlsBarGradient, null, 0.0f, 6, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getBottomCenter(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default2);
            lb.a constructor2 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallScreenKt.VideoScrim$lambda$2(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoScrim$lambda$2(int i10, Composer composer, int i11) {
        VideoScrim(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void VideoTopBar(final Partner partner, final boolean z10, final boolean z11, final Modifier modifier, Composer composer, final int i10) {
        Partner partner2;
        int i11;
        Composer composer2;
        String strStringResource;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1447663954);
        if ((i10 & 6) == 0) {
            partner2 = partner;
            i11 = (composerStartRestartGroup.changed(partner2) ? 4 : 2) | i10;
        } else {
            partner2 = partner;
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1447663954, i11, -1, "cu.todus.android.uiCompose.call.screen.video.VideoTopBar (VideoCallScreen.kt:404)");
            }
            if (z11) {
                composerStartRestartGroup.startReplaceGroup(364348910);
                strStringResource = StringResources_androidKt.stringResource(R.string.ringing, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (z10) {
                composerStartRestartGroup.startReplaceGroup(364350699);
                strStringResource = StringResources_androidKt.stringResource(R.string.call, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(364352403);
                strStringResource = StringResources_androidKt.stringResource(R.string.calling_hint, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(TtmlNode.TEXT_EMPHASIS_MARK_DOT, composerStartRestartGroup, 6, 0), 0.4f, 1.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(TypedValues.TransitionType.TYPE_DURATION, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "", composerStartRestartGroup, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 25008, 0);
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Color.m5865copywmQWz5c$default(Dark.INSTANCE.m10091getBackground0d7_KjU(), 0.92f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(12))), Dp.m8823constructorimpl(4), Dp.m8823constructorimpl(8));
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
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
            String picture = partner2.getPicture();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(38));
            float fM8823constructorimpl = Dp.m8823constructorimpl((float) 1.5d);
            long j10 = VideoAccent;
            String str = strStringResource;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(BorderKt.m1216borderxT4_qwU(modifierM1769size3ABfNKs, fM8823constructorimpl, Color.m5865copywmQWz5c$default(j10, 0.55f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), picture, Integer.valueOf(R.drawable.profile), null, null, 0, null, false, null, partner.getName(), true, 0, composerStartRestartGroup, 0, 6, 2552);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            Modifier modifierA = e3.a(rowScopeInstance, companion3, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composerStartRestartGroup, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA);
            lb.a constructor2 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String name = partner.getName();
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            TextKt.m3850TextNvy7gAk(name, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i12).getBodyMedium(), Color.INSTANCE.m5903getWhite0d7_KjU(), 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 0, 0, 131070);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.m1613spacedBy0680j_4(Dp.m8823constructorimpl(5)), companion.getCenterVertically(), composerStartRestartGroup, 54);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            lb.a constructor3 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(6)), Color.m5865copywmQWz5c$default(z10 ? j10 : VideoSubtext, z10 ? VideoTopBar$lambda$0(stateAnimateFloat) : 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            TextKt.m3850TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i12).getLabelSmall(), z10 ? j10 : VideoSubtext, TextUnitKt.getSp(11), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, 0, 0, 131070);
            composer2.endNode();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.video.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallScreenKt.VideoTopBar$lambda$2(partner, z10, z11, modifier, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float VideoTopBar$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoTopBar$lambda$2(Partner partner, boolean z10, boolean z11, Modifier modifier, int i10, Composer composer, int i11) {
        VideoTopBar(partner, z10, z11, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VideoInCallContent$lambda$17$3$0(int i10) {
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VideoInCallContent$lambda$17$4$0(int i10) {
        return i10;
    }
}
