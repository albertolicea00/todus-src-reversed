package cu.todus.android.uiCompose.call.screen.audio;

import android.content.Context;
import android.view.Window;
import androidx.compose.animation.core.AnimateAsStateKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.rounded.VolumeOffKt;
import androidx.compose.material.icons.automirrored.rounded.VolumeUpKt;
import androidx.compose.material.icons.rounded.CallEndKt;
import androidx.compose.material.icons.rounded.MicKt;
import androidx.compose.material.icons.rounded.MicOffKt;
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
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.text.ttml.TtmlNode;
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
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.uiCompose.call.screen.call.AudioCallViewModel;
import cu.todus.android.uiCompose.call.screen.call.CallMediaState;
import cu.todus.android.uiCompose.call.screen.call.CallSystemState;
import cu.todus.android.uiCompose.call.screen.call.components.BigCallItemKt;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.theme.Dark;
import cu.todus.android.uiCompose.theme.Light;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.webrtc.CallState;
import cu.todus.android.webrtc.ProximitySensorManager;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import te.p0;
import ua.k0;
import ua.u;
import ua.v;
import va.g0;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001ai\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a1\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a1\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0003¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u000f\u0010\u001b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u000f\u0010\u001d\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001d\u0010\u001c\u001a)\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0003¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0003¢\u0006\u0004\b!\u0010 \u001a]\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\b\b\u0002\u0010#\u001a\u00020\"H\u0003¢\u0006\u0004\b$\u0010%\u001aE\u0010,\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00152\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0003¢\u0006\u0004\b,\u0010-\u001aE\u00104\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004012\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000401H\u0003¢\u0006\u0004\b4\u00105\"\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108\"\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00108\"\u0014\u0010:\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00108\"\u0014\u0010;\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00108\"\u0014\u0010<\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00108\"\u0014\u0010=\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00108\"\u0014\u0010>\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00108\"\u0014\u0010?\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00108¨\u0006I²\u0006\f\u0010A\u001a\u00020@8\nX\u008a\u0084\u0002²\u0006\f\u0010\u000e\u001a\u00020\r8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010B\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\nX\u008a\u0084\u0002²\u0006\u000e\u0010C\u001a\u0004\u0018\u00010/8\nX\u008a\u0084\u0002²\u0006\f\u0010E\u001a\u00020D8\nX\u008a\u0084\u0002²\u0006\f\u0010F\u001a\u00020D8\nX\u008a\u0084\u0002²\u0006\f\u0010G\u001a\u00020D8\nX\u008a\u0084\u0002²\u0006\f\u0010H\u001a\u00020D8\nX\u008a\u0084\u0002²\u0006\f\u0010G\u001a\u00020D8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/call/screen/call/AudioCallViewModel;", "viewModel", "Lua/k0;", "AudioCallScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/call/screen/call/AudioCallViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/pojo/Partner;", "partner", "", "isCallStarted", "isConnected", "isRinging", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "ownerMediaState", "Lkotlin/Function0;", "onToggleMic", "onToggleSpeaker", "onEndCall", "AudioInCallContent", "(Lcu/todus/android/data/db/pojo/Partner;ZZZLcu/todus/android/uiCompose/call/screen/call/CallMediaState;Llb/a;Llb/a;Llb/a;Lcu/todus/android/uiCompose/call/screen/call/AudioCallViewModel;Landroidx/compose/runtime/Composer;I)V", "", Room.CONFIG_PICTURE, "name", "AudioAvatarWithPulse", "(Ljava/lang/String;Ljava/lang/String;ZZLandroidx/compose/runtime/Composer;II)V", "AudioAvatarWithPulseNew", "AudioWaveform", "(Landroidx/compose/runtime/Composer;I)V", "AudioWaveformNew", "label", "AudioStatusPill", "(Ljava/lang/String;ZZLandroidx/compose/runtime/Composer;II)V", "AudioStatusPillNew", "Landroidx/compose/ui/Modifier;", "modifier", "AudioCallControlBar", "(Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;ZZLlb/a;Llb/a;Llb/a;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/vector/ImageVector;", "icon", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "enabled", "isEndCall", "onClick", "AudioControlButton", "(Landroidx/compose/ui/graphics/vector/ImageVector;ZZZLjava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "", "Lcu/todus/android/webrtc/CallState;", "calls", "Lkotlin/Function1;", "acceptCall", "rejectCall", "AudioCallIncomingList", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/graphics/Color;", "AudioCallSurface", "J", "AudioCallCard", "AudioCallAccent", "AudioCallAccentWarm", "AudioCallGreen", "AudioCallRed", "AudioCallText", "AudioCallSubtext", "Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;", "state", "permissionsGranted", "currentState", "", "pulseScale", "pulseAlpha", "scale", "dotAnim", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AudioCallScreenKt {
    private static final long AudioCallAccent;
    private static final long AudioCallAccentWarm;
    private static final long AudioCallCard;
    private static final long AudioCallGreen;
    private static final long AudioCallRed;
    private static final long AudioCallSubtext;
    private static final long AudioCallSurface = Light.INSTANCE.m10101getInversePrimary0d7_KjU();
    private static final long AudioCallText;

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
        AudioCallCard = dark.m10091getBackground0d7_KjU();
        AudioCallAccent = dark.m10096getPrimary0d7_KjU();
        AudioCallAccentWarm = dark.m10092getInversePrimary0d7_KjU();
        AudioCallGreen = Other.INSTANCE.m10111getGreen0d7_KjU();
        AudioCallRed = dark.m10096getPrimary0d7_KjU();
        AudioCallText = ColorKt.Color(4287299584L);
        AudioCallSubtext = ColorKt.Color(4289864226L);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioAvatarWithPulse(String str, String str2, boolean z10, boolean z11, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z12;
        final String str3;
        final String str4;
        final boolean z13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1519731876);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        int i13 = i11 & 8;
        if (i13 != 0) {
            i12 |= 3072;
        } else if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            boolean z14 = i13 == 0 ? z11 : false;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1519731876, i12, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioAvatarWithPulse (AudioCallScreen.kt:300)");
            }
            z12 = z10;
            AudioAvatarWithPulseNew(str, str2, z12, z14, composerStartRestartGroup, i12 & 8190, 0);
            str4 = str;
            str3 = str2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z14;
        } else {
            z12 = z10;
            str3 = str2;
            str4 = str;
            composerStartRestartGroup.skipToGroupEnd();
            z13 = z11;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z15 = z12;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioAvatarWithPulse$lambda$0(str4, str3, z15, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioAvatarWithPulse$lambda$0(String str, String str2, boolean z10, boolean z11, int i10, int i11, Composer composer, int i12) {
        AudioAvatarWithPulse(str, str2, z10, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:62:0x0130  */
    /* JADX WARN: Code duplicated, block: B:65:0x013c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0140  */
    /* JADX WARN: Code duplicated, block: B:72:0x017f  */
    /* JADX WARN: Code duplicated, block: B:75:0x025e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0264  */
    /* JADX WARN: Code duplicated, block: B:80:0x026e  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioAvatarWithPulseNew(final String str, final String str2, final boolean z10, boolean z11, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z12;
        boolean z13;
        final boolean z14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z15;
        float f10;
        int i13;
        State<Float> stateAnimateFloat;
        int i14;
        State<Float> stateAnimateFloat2;
        Modifier.Companion companion;
        lb.a constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1932649096);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        int i15 = i11 & 8;
        if (i15 == 0) {
            if ((i10 & 3072) == 0) {
                z12 = z11;
                i12 |= composerStartRestartGroup.changed(z12) ? 2048 : 1024;
            }
            if ((i12 & 1171) != 1170) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i12 & 1)) {
                if (i15 != 0) {
                    z15 = false;
                } else {
                    z15 = z12;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1932649096, i12, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioAvatarWithPulseNew (AudioCallScreen.kt:306)");
                }
                InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("pulse", composerStartRestartGroup, 6, 0);
                if (z15) {
                    f10 = 1.25f;
                } else {
                    f10 = 1.18f;
                }
                float f11 = f10;
                if (z15) {
                    i13 = 700;
                } else {
                    i13 = 1000;
                }
                TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(i13, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
                RepeatMode repeatMode = RepeatMode.Reverse;
                InfiniteRepeatableSpec infiniteRepeatableSpecM1114infiniteRepeatable9IiC70o$default = AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(tweenSpecTween$default, repeatMode, 0L, 4, null);
                int i16 = InfiniteTransition.$stable;
                int i17 = InfiniteRepeatableSpec.$stable;
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 1.0f, f11, infiniteRepeatableSpecM1114infiniteRepeatable9IiC70o$default, "pulseScale", composerStartRestartGroup, i16 | 24624 | (i17 << 9), 0);
                if (z15) {
                    i14 = 700;
                } else {
                    i14 = 1000;
                }
                stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.5f, 0.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(i14, 0, null, 6, null), repeatMode, 0L, 4, null), "pulseAlpha", composerStartRestartGroup, i16 | 25008 | (i17 << 9), 0);
                Alignment center = Alignment.INSTANCE.getCenter();
                companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
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
                if (!z10 || z15) {
                    composerStartRestartGroup.startReplaceGroup(-1823401352);
                    BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(ScaleKt.scale(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(190)), AudioAvatarWithPulseNew$lambda$0(stateAnimateFloat)), Color.m5865copywmQWz5c$default(AudioCallAccent, AudioAvatarWithPulseNew$lambda$1(stateAnimateFloat2) * 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                    BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(ScaleKt.scale(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(170)), AudioAvatarWithPulseNew$lambda$0(stateAnimateFloat)), Color.m5865copywmQWz5c$default(AudioCallAccentWarm, AudioAvatarWithPulseNew$lambda$1(stateAnimateFloat2) * 0.15f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1823082300);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(BorderKt.m1218borderziNgDLE(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(145)), Dp.m8823constructorimpl((float) 2.5d), Brush.Companion.m5821linearGradientmHitzGk$default(Brush.INSTANCE, w.q(Color.m5856boximpl(AudioCallAccent), Color.m5856boximpl(AudioCallAccentWarm)), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape()), str, Integer.valueOf(R.drawable.profile), null, null, 0, null, false, null, str2, true, 0, composerStartRestartGroup, ((i12 << 3) & 112) | ((i12 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2552);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z14 = z15;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z14 = z12;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AudioCallScreenKt.AudioAvatarWithPulseNew$lambda$3(str, str2, z10, z14, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        z12 = z11;
        if ((i12 & 1171) != 1170) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z13, i12 & 1)) {
            if (i15 != 0) {
                z15 = false;
            } else {
                z15 = z12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1932649096, i12, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioAvatarWithPulseNew (AudioCallScreen.kt:306)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition("pulse", composerStartRestartGroup, 6, 0);
            if (z15) {
                f10 = 1.25f;
            } else {
                f10 = 1.18f;
            }
            float f12 = f10;
            if (z15) {
                i13 = 700;
            } else {
                i13 = 1000;
            }
            TweenSpec tweenSpecTween$default2 = AnimationSpecKt.tween$default(i13, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
            RepeatMode repeatMode2 = RepeatMode.Reverse;
            InfiniteRepeatableSpec infiniteRepeatableSpecM1114infiniteRepeatable9IiC70o$default2 = AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(tweenSpecTween$default2, repeatMode2, 0L, 4, null);
            int i18 = InfiniteTransition.$stable;
            int i19 = InfiniteRepeatableSpec.$stable;
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 1.0f, f12, infiniteRepeatableSpecM1114infiniteRepeatable9IiC70o$default2, "pulseScale", composerStartRestartGroup, i18 | 24624 | (i19 << 9), 0);
            if (z15) {
                i14 = 700;
            } else {
                i14 = 1000;
            }
            stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.5f, 0.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(i14, 0, null, 6, null), repeatMode2, 0L, 4, null), "pulseAlpha", composerStartRestartGroup, i18 | 25008 | (i19 << 9), 0);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-1823401352);
                BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(ScaleKt.scale(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(190)), AudioAvatarWithPulseNew$lambda$0(stateAnimateFloat)), Color.m5865copywmQWz5c$default(AudioCallAccent, AudioAvatarWithPulseNew$lambda$1(stateAnimateFloat2) * 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(ScaleKt.scale(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(170)), AudioAvatarWithPulseNew$lambda$0(stateAnimateFloat)), Color.m5865copywmQWz5c$default(AudioCallAccentWarm, AudioAvatarWithPulseNew$lambda$1(stateAnimateFloat2) * 0.15f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1823401352);
                BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(ScaleKt.scale(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(190)), AudioAvatarWithPulseNew$lambda$0(stateAnimateFloat)), Color.m5865copywmQWz5c$default(AudioCallAccent, AudioAvatarWithPulseNew$lambda$1(stateAnimateFloat2) * 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(ScaleKt.scale(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(170)), AudioAvatarWithPulseNew$lambda$0(stateAnimateFloat)), Color.m5865copywmQWz5c$default(AudioCallAccentWarm, AudioAvatarWithPulseNew$lambda$1(stateAnimateFloat2) * 0.15f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(BorderKt.m1218borderziNgDLE(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(145)), Dp.m8823constructorimpl((float) 2.5d), Brush.Companion.m5821linearGradientmHitzGk$default(Brush.INSTANCE, w.q(Color.m5856boximpl(AudioCallAccent), Color.m5856boximpl(AudioCallAccentWarm)), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape()), str, Integer.valueOf(R.drawable.profile), null, null, 0, null, false, null, str2, true, 0, composerStartRestartGroup, ((i12 << 3) & 112) | ((i12 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2552);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z14 = z15;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z14 = z12;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioAvatarWithPulseNew$lambda$3(str, str2, z10, z14, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float AudioAvatarWithPulseNew$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float AudioAvatarWithPulseNew$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioAvatarWithPulseNew$lambda$3(String str, String str2, boolean z10, boolean z11, int i10, int i11, Composer composer, int i12) {
        AudioAvatarWithPulseNew(str, str2, z10, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x020a  */
    /* JADX WARN: Code duplicated, block: B:103:0x0218  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:67:0x0122  */
    /* JADX WARN: Code duplicated, block: B:70:0x012e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0132  */
    /* JADX WARN: Code duplicated, block: B:74:0x0168  */
    /* JADX WARN: Code duplicated, block: B:75:0x016f  */
    /* JADX WARN: Code duplicated, block: B:78:0x017f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0181  */
    /* JADX WARN: Code duplicated, block: B:82:0x0188  */
    /* JADX WARN: Code duplicated, block: B:83:0x018a  */
    /* JADX WARN: Code duplicated, block: B:90:0x019e  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:95:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:98:0x0203  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioCallControlBar(final CallMediaState callMediaState, final boolean z10, boolean z11, lb.a aVar, final lb.a aVar2, final lb.a aVar3, Modifier modifier, Composer composer, final int i10, final int i11) {
        int i12;
        Modifier modifier2;
        int i13;
        boolean z12;
        Composer composer2;
        final boolean z13;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z14;
        lb.a constructor;
        ImageVector micOff;
        boolean z15;
        boolean z16;
        boolean z17;
        Object objRememberedValue;
        ImageVector volumeOff;
        final lb.a aVar4 = aVar;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1089974594);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(callMediaState) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(aVar4) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(aVar2) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(aVar3) ? 131072 : 65536;
        }
        int i14 = i11 & 64;
        if (i14 == 0) {
            if ((1572864 & i10) == 0) {
                modifier2 = modifier;
                i12 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
            }
            i13 = i12;
            if ((599059 & i13) != 599058) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                if ((i11 & 4) != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1089974594, i13, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioCallControlBar (AudioCallScreen.kt:458)");
                }
                Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), Color.m5865copywmQWz5c$default(Dark.INSTANCE.m10091getBackground0d7_KjU(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(12))), Dp.m8823constructorimpl(4), Dp.m8823constructorimpl(10));
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceAround(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
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
                    micOff = MicKt.getMic(Icons.Rounded.INSTANCE);
                } else {
                    micOff = MicOffKt.getMicOff(Icons.Rounded.INSTANCE);
                }
                boolean zIsMicrophoneEnabled = callMediaState.isMicrophoneEnabled();
                if ((i13 & 112) == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((i13 & 7168) == 2048) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z15 | z16;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z17 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    aVar4 = aVar;
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.audio.g
                        @Override // lb.a
                        public final Object invoke() {
                            return AudioCallScreenKt.AudioCallControlBar$lambda$0$0$0(z10, aVar4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    aVar4 = aVar;
                }
                int i15 = i13 << 3;
                AudioControlButton(micOff, zIsMicrophoneEnabled, z10, false, "", (lb.a) objRememberedValue, composerStartRestartGroup, (i15 & 896) | 27648);
                composer2 = composerStartRestartGroup;
                Modifier modifier4 = modifier2;
                AudioControlButton(CallEndKt.getCallEnd(Icons.Rounded.INSTANCE), false, true, true, "", aVar3, composer2, (i13 & 458752) | 28080);
                if (callMediaState.isSoundEnable()) {
                    volumeOff = VolumeUpKt.getVolumeUp(Icons.AutoMirrored.Rounded.INSTANCE);
                } else {
                    volumeOff = VolumeOffKt.getVolumeOff(Icons.AutoMirrored.Rounded.INSTANCE);
                }
                AudioControlButton(volumeOff, callMediaState.isSoundEnable(), true, false, "", aVar2, composer2, (i15 & 458752) | 28032);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z13 = z14;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z13 = z11;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final lb.a aVar5 = aVar4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AudioCallScreenKt.AudioCallControlBar$lambda$1(callMediaState, z10, z13, aVar5, aVar2, aVar3, modifier3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 1572864;
        modifier2 = modifier;
        i13 = i12;
        if ((599059 & i13) != 599058) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
            if ((i11 & 4) != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if (i14 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1089974594, i13, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioCallControlBar (AudioCallScreen.kt:458)");
            }
            Modifier modifierM1726paddingVpY3zN5 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), Color.m5865copywmQWz5c$default(Dark.INSTANCE.m10091getBackground0d7_KjU(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(12))), Dp.m8823constructorimpl(4), Dp.m8823constructorimpl(10));
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceAround(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN5);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            if (callMediaState.isMicrophoneEnabled()) {
                micOff = MicKt.getMic(Icons.Rounded.INSTANCE);
            } else {
                micOff = MicOffKt.getMicOff(Icons.Rounded.INSTANCE);
            }
            boolean zIsMicrophoneEnabled2 = callMediaState.isMicrophoneEnabled();
            if ((i13 & 112) == 32) {
                z15 = true;
            } else {
                z15 = false;
            }
            if ((i13 & 7168) == 2048) {
                z16 = true;
            } else {
                z16 = false;
            }
            z17 = z15 | z16;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z17) {
                aVar4 = aVar;
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.audio.g
                    @Override // lb.a
                    public final Object invoke() {
                        return AudioCallScreenKt.AudioCallControlBar$lambda$0$0$0(z10, aVar4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                aVar4 = aVar;
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.audio.g
                    @Override // lb.a
                    public final Object invoke() {
                        return AudioCallScreenKt.AudioCallControlBar$lambda$0$0$0(z10, aVar4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            int i16 = i13 << 3;
            AudioControlButton(micOff, zIsMicrophoneEnabled2, z10, false, "", (lb.a) objRememberedValue, composerStartRestartGroup, (i16 & 896) | 27648);
            composer2 = composerStartRestartGroup;
            Modifier modifier5 = modifier2;
            AudioControlButton(CallEndKt.getCallEnd(Icons.Rounded.INSTANCE), false, true, true, "", aVar3, composer2, (i13 & 458752) | 28080);
            if (callMediaState.isSoundEnable()) {
                volumeOff = VolumeUpKt.getVolumeUp(Icons.AutoMirrored.Rounded.INSTANCE);
            } else {
                volumeOff = VolumeOffKt.getVolumeOff(Icons.AutoMirrored.Rounded.INSTANCE);
            }
            AudioControlButton(volumeOff, callMediaState.isSoundEnable(), true, false, "", aVar2, composer2, (i16 & 458752) | 28032);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            z13 = z14;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z13 = z11;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final lb.a aVar6 = aVar4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioCallControlBar$lambda$1(callMediaState, z10, z13, aVar6, aVar2, aVar3, modifier3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioCallControlBar$lambda$0$0$0(boolean z10, lb.a aVar) {
        if (z10) {
            aVar.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioCallControlBar$lambda$1(CallMediaState callMediaState, boolean z10, boolean z11, lb.a aVar, lb.a aVar2, lb.a aVar3, Modifier modifier, int i10, int i11, Composer composer, int i12) {
        AudioCallControlBar(callMediaState, z10, z11, aVar, aVar2, aVar3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioCallIncomingList(final List<CallState> list, final Function1 function1, final Function1 function2, Composer composer, final int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1662482492);
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
                ComposerKt.traceEventStart(-1662482492, i11, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioCallIncomingList (AudioCallScreen.kt:566)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), AudioCallSurface, null, 2, null);
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
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.audio.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AudioCallScreenKt.AudioCallIncomingList$lambda$0$0$0(list, function1, function2, context, (LazyListScope) obj);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioCallIncomingList$lambda$1(list, function1, function2, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioCallIncomingList$lambda$0$0$0(final List list, final Function1 function1, final Function1 function2, final Context context, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        final AudioCallScreenKt$AudioCallIncomingList$lambda$0$0$0$$inlined$items$default$1 audioCallScreenKt$AudioCallIncomingList$lambda$0$0$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.audio.AudioCallScreenKt$AudioCallIncomingList$lambda$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(CallState callState) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((CallState) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1() { // from class: cu.todus.android.uiCompose.call.screen.audio.AudioCallScreenKt$AudioCallIncomingList$lambda$0$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return audioCallScreenKt$AudioCallIncomingList$lambda$0$0$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new lb.o() { // from class: cu.todus.android.uiCompose.call.screen.audio.AudioCallScreenKt$AudioCallIncomingList$lambda$0$0$0$$inlined$items$default$4
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
                composer.startReplaceGroup(1681617149);
                BigCallItemKt.BigCallItem(null, callState, function1, function2, composer, CallState.$stable << 3, 1);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (list.isEmpty()) {
            LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(232711374, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.audio.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AudioCallScreenKt.AudioCallIncomingList$lambda$0$0$0$1(context, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AudioCallIncomingList$lambda$0$0$0$1(final Context context, final LazyItemScope item, Composer composer, int i10) {
        int i11;
        y.i(item, "$this$item");
        if ((i10 & 6) == 0) {
            i11 = (composer.changed(item) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(232711374, i11, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioCallIncomingList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AudioCallScreen.kt:575)");
            }
            boolean zChangedInstance = composer.changedInstance(context) | ((i11 & 14) == 4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.audio.i
                    @Override // lb.a
                    public final Object invoke() {
                        return AudioCallScreenKt.AudioCallIncomingList$lambda$0$0$0$1$0$0(item, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue, StringResources_androidKt.stringResource(R.string.exit, composer, 0), null, true, false, false, composer, 24576, 105);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioCallIncomingList$lambda$0$0$0$1$0$0(LazyItemScope lazyItemScope, Context context) {
        try {
            u.a aVar = u.f43963f;
            Z17InlineUtilsKt.findActivity(context).finish();
            u.b(k0.f43947a);
        } catch (Throwable th2) {
            u.a aVar2 = u.f43963f;
            u.b(v.a(th2));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioCallIncomingList$lambda$1(List list, Function1 function1, Function1 function2, int i10, Composer composer, int i11) {
        AudioCallIncomingList(list, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AudioCallScreen(final NavHostController navHostController, AudioCallViewModel audioCallViewModel, Composer composer, final int i10, final int i11) {
        AudioCallViewModel audioCallViewModel2;
        int i12;
        final AudioCallViewModel audioCallViewModel3;
        final Context context;
        final MutableState mutableState;
        char c10;
        char c11;
        char c12;
        boolean z10;
        int i13;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1343427943);
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                audioCallViewModel2 = audioCallViewModel;
                if (composerStartRestartGroup.changedInstance(audioCallViewModel2)) {
                    i13 = 32;
                }
                i12 = i13 | i10;
            } else {
                audioCallViewModel2 = audioCallViewModel;
            }
            i13 = 16;
            i12 = i13 | i10;
        } else {
            audioCallViewModel2 = audioCallViewModel;
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
                audioCallViewModel2 = (AudioCallViewModel) ViewModelKt.viewModel(z0.b(AudioCallViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i12 &= -113;
            }
            int i14 = i12;
            audioCallViewModel3 = audioCallViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1343427943, i14, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioCallScreen (AudioCallScreen.kt:94)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(audioCallViewModel3.getCallSystemState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            Composer composer2 = composerStartRestartGroup;
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(audioCallViewModel3.ownerCallMediaState(), new CallMediaState(false, false, false, 7, null), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 0, 14);
            State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(audioCallViewModel3.isRinging(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
            final Context context2 = (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new ProximitySensorManager(context2);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final ProximitySensorManager proximitySensorManager = (ProximitySensorManager) objRememberedValue2;
            CallSystemState callSystemStateAudioCallScreen$lambda$0 = AudioCallScreen$lambda$0(stateCollectAsStateWithLifecycle);
            boolean zChanged = composer2.changed(stateCollectAsStateWithLifecycle) | composer2.changedInstance(audioCallViewModel3) | composer2.changedInstance(proximitySensorManager);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new AudioCallScreenKt$AudioCallScreen$1$1(audioCallViewModel3, proximitySensorManager, stateCollectAsStateWithLifecycle, null);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(callSystemStateAudioCallScreen$lambda$0, (Function2) objRememberedValue3, composer2, 0);
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composer2.changedInstance(context2) | composer2.changedInstance(proximitySensorManager);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.audio.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AudioCallScreenKt.AudioCallScreen$lambda$8$0(context2, proximitySensorManager, (DisposableEffectScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue4, composer2, 6);
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AudioCallSurface, null, 2, null);
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
            if (AudioCallScreen$lambda$4(mutableState2)) {
                composer2.startReplaceGroup(788803426);
                int i15 = WhenMappings.$EnumSwitchMapping$0[AudioCallScreen$lambda$0(stateCollectAsStateWithLifecycle).ordinal()];
                if (i15 != 1) {
                    if (i15 == 2) {
                        context = context2;
                        mutableState = mutableState2;
                        c12 = 2;
                        audioCallViewModel3 = audioCallViewModel3;
                        c11 = 1;
                        composer2.startReplaceGroup(788877485);
                        composer2.endReplaceGroup();
                    } else if (i15 == 3) {
                        context = context2;
                        mutableState = mutableState2;
                        c12 = 2;
                        audioCallViewModel3 = audioCallViewModel3;
                        c11 = 1;
                        composer2.startReplaceGroup(302544923);
                        composer2.endReplaceGroup();
                        Z17InlineUtilsKt.findActivity(context).finish();
                    } else if (i15 == 4) {
                        context = context2;
                        mutableState = mutableState2;
                        c12 = 2;
                        audioCallViewModel3 = audioCallViewModel3;
                        c11 = 1;
                        composer2.startReplaceGroup(789028796);
                        final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(audioCallViewModel3.callList().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
                        List listY0 = g0.Y0(AudioCallScreen$lambda$9$0(stateCollectAsStateWithLifecycle4));
                        boolean zChangedInstance2 = composer2.changedInstance(audioCallViewModel3);
                        Object objRememberedValue5 = composer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new AudioCallScreenKt$AudioCallScreen$3$1$1(audioCallViewModel3);
                            composer2.updateRememberedValue(objRememberedValue5);
                        }
                        Function1 function1 = (Function1) ((sb.h) objRememberedValue5);
                        boolean zChangedInstance3 = composer2.changedInstance(audioCallViewModel3) | composer2.changed(stateCollectAsStateWithLifecycle4) | composer2.changedInstance(context);
                        Object objRememberedValue6 = composer2.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.audio.c
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AudioCallScreenKt.AudioCallScreen$lambda$9$2$0(audioCallViewModel3, boxScopeInstance, stateCollectAsStateWithLifecycle4, context, (String) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue6);
                        }
                        AudioCallIncomingList(listY0, function1, (Function1) objRememberedValue6, composer2, 0);
                        composer2.endReplaceGroup();
                    } else {
                        if (i15 != 5) {
                            composer2.startReplaceGroup(302539936);
                            composer2.endReplaceGroup();
                            throw new ua.r();
                        }
                        composer2.startReplaceGroup(789649633);
                        context = context2;
                        p0 p0VarCurrentCallState = audioCallViewModel3.currentCallState();
                        if (p0VarCurrentCallState != null) {
                            composer2.startReplaceGroup(789762473);
                            mutableState = mutableState2;
                            c12 = 2;
                            context = context;
                            CallState callStateAudioCallScreen$lambda$9$3 = AudioCallScreen$lambda$9$3(FlowExtKt.collectAsStateWithLifecycle(p0VarCurrentCallState, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 0, 7));
                            if ((callStateAudioCallScreen$lambda$9$3 != null ? callStateAudioCallScreen$lambda$9$3.getPartner() : null) != null) {
                                composer2 = composer2;
                                composer2.startReplaceGroup(789990509);
                                Partner partner = callStateAudioCallScreen$lambda$9$3.getPartner();
                                y.f(partner);
                                if (callStateAudioCallScreen$lambda$9$3.getCallIsStarted()) {
                                    composer2 = composer2;
                                    z10 = true;
                                } else {
                                    composer2 = composer2;
                                    z10 = false;
                                }
                                boolean z11 = callStateAudioCallScreen$lambda$9$3.getPeersConnected();
                                boolean zD = y.d(AudioCallScreen$lambda$2(stateCollectAsStateWithLifecycle3), Boolean.TRUE);
                                CallMediaState callMediaStateAudioCallScreen$lambda$1 = AudioCallScreen$lambda$1(stateCollectAsStateWithLifecycle2);
                                boolean zChangedInstance4 = composer2.changedInstance(audioCallViewModel3);
                                Object objRememberedValue7 = composer2.rememberedValue();
                                if (zChangedInstance4 || objRememberedValue7 == companion.getEmpty()) {
                                    objRememberedValue7 = new AudioCallScreenKt$AudioCallScreen$3$3$1(audioCallViewModel3);
                                    composer2.updateRememberedValue(objRememberedValue7);
                                }
                                lb.a aVar = (lb.a) ((sb.h) objRememberedValue7);
                                boolean zChangedInstance5 = composer2.changedInstance(audioCallViewModel3);
                                Object objRememberedValue8 = composer2.rememberedValue();
                                if (zChangedInstance5 || objRememberedValue8 == companion.getEmpty()) {
                                    objRememberedValue8 = new AudioCallScreenKt$AudioCallScreen$3$4$1(audioCallViewModel3);
                                    composer2.updateRememberedValue(objRememberedValue8);
                                }
                                lb.a aVar2 = (lb.a) ((sb.h) objRememberedValue8);
                                boolean zChangedInstance6 = composer2.changedInstance(context) | composer2.changedInstance(audioCallViewModel3);
                                Object objRememberedValue9 = composer2.rememberedValue();
                                if (zChangedInstance6 || objRememberedValue9 == companion.getEmpty()) {
                                    objRememberedValue9 = new AudioCallScreenKt$AudioCallScreen$3$5$1(context, audioCallViewModel3);
                                    composer2.updateRememberedValue(objRememberedValue9);
                                }
                                c11 = 1;
                                AudioInCallContent(partner, z10, z11, zD, callMediaStateAudioCallScreen$lambda$1, aVar, aVar2, (lb.a) ((sb.h) objRememberedValue9), audioCallViewModel3, composer2, (i14 << 21) & 234881024);
                                composer2 = composer2;
                                composer2.endReplaceGroup();
                            } else {
                                composer2 = composer2;
                                composer2 = composer2;
                                c11 = 1;
                                composer2.startReplaceGroup(790730479);
                                composer2.endReplaceGroup();
                            }
                            composer2.endReplaceGroup();
                        } else {
                            mutableState = mutableState2;
                            c12 = 2;
                            audioCallViewModel3 = audioCallViewModel3;
                            c11 = 1;
                            composer2.startReplaceGroup(790752303);
                            composer2.endReplaceGroup();
                        }
                        composer2.endReplaceGroup();
                    }
                    c10 = 0;
                } else {
                    context = context2;
                    mutableState = mutableState2;
                    c11 = 1;
                    audioCallViewModel3 = audioCallViewModel3;
                    c12 = 2;
                    composer2.startReplaceGroup(302540128);
                    c10 = 0;
                    LoadingScreenKt.LoadingWall(composer2, 0);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                context = context2;
                mutableState = mutableState2;
                audioCallViewModel3 = audioCallViewModel3;
                c10 = 0;
                c11 = 1;
                c12 = 2;
                composer2.startReplaceGroup(790793967);
                composer2.endReplaceGroup();
            }
            PermissionNeedIt[] permissionNeedItArr = new PermissionNeedIt[3];
            permissionNeedItArr[c10] = PermissionNeedIt.STORAGE;
            permissionNeedItArr[c11] = PermissionNeedIt.RECORD_AUDIO;
            permissionNeedItArr[c12] = PermissionNeedIt.CALLS;
            List listQ = w.q(permissionNeedItArr);
            Object objRememberedValue10 = composer2.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.audio.d
                    @Override // lb.a
                    public final Object invoke() {
                        return AudioCallScreenKt.AudioCallScreen$lambda$9$7$0(mutableState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue10);
            }
            String packageName = context.getPackageName();
            y.h(packageName, "getPackageName(...)");
            Composer composer3 = composer2;
            Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listQ, (lb.a) objRememberedValue10, null, packageName, null, composer3, 3456, 83);
            composerStartRestartGroup = composer3;
            Boolean boolValueOf = Boolean.valueOf(AudioCallScreen$lambda$4(mutableState));
            boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(audioCallViewModel3);
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance7 || objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = new AudioCallScreenKt$AudioCallScreen$3$7$1(audioCallViewModel3, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue11, composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            audioCallViewModel3 = audioCallViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioCallScreen$lambda$10(navHostController, audioCallViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AudioCallScreen$endCall(Context context, AudioCallViewModel audioCallViewModel) {
        Z17InlineUtilsKt.findActivity(context).finish();
        audioCallViewModel.endCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallSystemState AudioCallScreen$lambda$0(State<? extends CallSystemState> state) {
        return state.getValue();
    }

    private static final CallMediaState AudioCallScreen$lambda$1(State<CallMediaState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioCallScreen$lambda$10(NavHostController navHostController, AudioCallViewModel audioCallViewModel, int i10, int i11, Composer composer, int i12) {
        AudioCallScreen(navHostController, audioCallViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final Boolean AudioCallScreen$lambda$2(State<Boolean> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AudioCallScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AudioCallScreen$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult AudioCallScreen$lambda$8$0(final Context context, final ProximitySensorManager proximitySensorManager, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.call.screen.audio.AudioCallScreenKt$AudioCallScreen$lambda$8$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Window window;
                try {
                    window = Z17InlineUtilsKt.findActivity(context).getWindow();
                } catch (Exception unused) {
                    window = null;
                }
                proximitySensorManager.cleanup(window);
            }
        };
    }

    private static final List<CallState> AudioCallScreen$lambda$9$0(State<? extends List<CallState>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioCallScreen$lambda$9$2$0(AudioCallViewModel audioCallViewModel, BoxScope boxScope, State state, Context context, String uid) {
        y.i(uid, "uid");
        audioCallViewModel.rejectCall(uid);
        if (AudioCallScreen$lambda$9$0(state).size() <= 1) {
            try {
                u.a aVar = u.f43963f;
                Z17InlineUtilsKt.findActivity(context).finish();
                u.b(k0.f43947a);
            } catch (Throwable th2) {
                u.a aVar2 = u.f43963f;
                u.b(v.a(th2));
            }
        }
        return k0.f43947a;
    }

    private static final CallState AudioCallScreen$lambda$9$3(State<CallState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioCallScreen$lambda$9$7$0(MutableState mutableState) {
        AudioCallScreen$lambda$5(mutableState, true);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioControlButton(final ImageVector imageVector, final boolean z10, final boolean z11, final boolean z12, final String str, final lb.a aVar, Composer composer, final int i10) {
        int i11;
        long jM5865copywmQWz5c$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(789322438);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(imageVector) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(z12) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(aVar) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i11) != 74898, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(789322438, i11, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioControlButton (AudioCallScreen.kt:508)");
            }
            float fM8823constructorimpl = Dp.m8823constructorimpl(52);
            float fM8823constructorimpl2 = Dp.m8823constructorimpl(22);
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(1.0f, AnimationSpecKt.tween$default(200, 0, null, 6, null), 0.0f, "s", null, composerStartRestartGroup, 3126, 20);
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_4 = Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(6));
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierClip = ClipKt.clip(ScaleKt.scale(SizeKt.m1769size3ABfNKs(companion2, fM8823constructorimpl), AudioControlButton$lambda$0(stateAnimateFloatAsState)), RoundedCornerShapeKt.getCircleShape());
            if (z12) {
                jM5865copywmQWz5c$default = AudioCallRed;
            } else {
                jM5865copywmQWz5c$default = z10 ? Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null) : Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.07f, 0.0f, 0.0f, 0.0f, 14, null);
            }
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(BackgroundKt.m1205backgroundbw27NRU$default(modifierClip, jM5865copywmQWz5c$default, null, 2, null), Dp.m8823constructorimpl((float) 1.5d), Color.m5865copywmQWz5c$default(AudioCallAccent, z11 ? 0.55f : 0.25f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            boolean z13 = (458752 & i11) == 131072;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.audio.a
                    @Override // lb.a
                    public final Object invoke() {
                        return AudioCallScreenKt.AudioControlButton$lambda$1$0$0(aVar);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierM1216borderxT4_qwU, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            long jM5903getWhite0d7_KjU = (z12 || z11) ? Color.INSTANCE.m5903getWhite0d7_KjU() : Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null);
            IconKt.m3298Iconww6aTOc(imageVector, (String) null, SizeKt.m1769size3ABfNKs(companion2, fM8823constructorimpl2), jM5903getWhite0d7_KjU, composerStartRestartGroup, (i11 & 14) | 432, 0);
            composerStartRestartGroup.endNode();
            if (str.length() > 0) {
                composerStartRestartGroup.startReplaceGroup(-2040170021);
                TextKt.m3850TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), z11 ? Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null) : Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(10), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composerStartRestartGroup, (i11 >> 12) & 14, 0, 131070);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2039821178);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioControlButton$lambda$2(imageVector, z10, z11, z12, str, aVar, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float AudioControlButton$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioControlButton$lambda$1$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioControlButton$lambda$2(ImageVector imageVector, boolean z10, boolean z11, boolean z12, String str, lb.a aVar, int i10, Composer composer, int i11) {
        AudioControlButton(imageVector, z10, z11, z12, str, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioInCallContent(final Partner partner, final boolean z10, final boolean z11, final boolean z12, final CallMediaState callMediaState, final lb.a aVar, final lb.a aVar2, final lb.a aVar3, final AudioCallViewModel audioCallViewModel, Composer composer, final int i10) {
        int i11;
        String strStringResource;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1992835567);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(partner) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(z12) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(callMediaState) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(aVar) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(aVar2) ? 1048576 : 524288;
        }
        if ((12582912 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(aVar3) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(audioCallViewModel) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 38347923) != 38347922, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1992835567, i11, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioInCallContent (AudioCallScreen.kt:230)");
            }
            Boolean boolValueOf = Boolean.valueOf(z12);
            boolean zChangedInstance = ((i11 & 7168) == 2048) | composerStartRestartGroup.changedInstance(audioCallViewModel);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new AudioCallScreenKt$AudioInCallContent$1$1(z12, audioCallViewModel, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue, composerStartRestartGroup, (i11 >> 9) & 14);
            if (!z10) {
                composerStartRestartGroup.startReplaceGroup(440454614);
                strStringResource = StringResources_androidKt.stringResource(R.string.calling_hint, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (z12) {
                composerStartRestartGroup.startReplaceGroup(440456657);
                strStringResource = StringResources_androidKt.stringResource(R.string.ringing, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (z11) {
                composerStartRestartGroup.startReplaceGroup(440458542);
                strStringResource = StringResources_androidKt.stringResource(R.string.call, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(440460345);
                strStringResource = StringResources_androidKt.stringResource(R.string.call_connecting, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(WindowInsetsPadding_androidKt.safeContentPadding(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null)), Dp.m8823constructorimpl(24), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getSpaceBetween(), centerHorizontally, composerStartRestartGroup, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Alignment.Horizontal centerHorizontally2 = companion2.getCenterHorizontally();
            float f10 = 40;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            String name = partner.getName();
            int i12 = i11;
            long j10 = AudioCallAccentWarm;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, name, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i13).getHeadlineSmall(), AudioCallText, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), j10, 0, 0, composerStartRestartGroup, 3072, 49);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(4)), composerStartRestartGroup, 6);
            String str = "@" + partner.getUser().getToDusId();
            long j11 = AudioCallSubtext;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i13).getLabelMedium(), j11, TextUnitKt.getSp(13), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), j11, 0, 0, composerStartRestartGroup, 3072, 49);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(12)), composerStartRestartGroup, 6);
            int i14 = i12 >> 3;
            int i15 = i14 & 112;
            int i16 = i14 & 896;
            AudioStatusPill(strStringResource, z11, z12, composerStartRestartGroup, i14 & 1008, 0);
            composerStartRestartGroup.endNode();
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composerStartRestartGroup, 48);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            lb.a constructor3 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            AudioAvatarWithPulse(partner.getPicture(), partner.getName(), z11, z12, composerStartRestartGroup, i12 & 8064, 0);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(28)), composerStartRestartGroup, 6);
            if (z11) {
                composerStartRestartGroup.startReplaceGroup(-310118563);
                AudioWaveform(composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1023726444);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 7, null);
            int i17 = ((i12 >> 12) & 14) | 1572864 | i15 | i16;
            int i18 = i12 >> 6;
            AudioCallControlBar(callMediaState, z11, z12, aVar, aVar2, aVar3, modifierM1729paddingqDBjuR0$default2, composerStartRestartGroup, i17 | (i18 & 7168) | (57344 & i18) | (i18 & 458752), 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioInCallContent$lambda$2(partner, z10, z11, z12, callMediaState, aVar, aVar2, aVar3, audioCallViewModel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioInCallContent$lambda$2(Partner partner, boolean z10, boolean z11, boolean z12, CallMediaState callMediaState, lb.a aVar, lb.a aVar2, lb.a aVar3, AudioCallViewModel audioCallViewModel, int i10, Composer composer, int i11) {
        AudioInCallContent(partner, z10, z11, z12, callMediaState, aVar, aVar2, aVar3, audioCallViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioStatusPill(String str, boolean z10, boolean z11, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z12;
        final String str2;
        final boolean z13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1534211956);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        int i13 = i11 & 4;
        if (i13 != 0) {
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            boolean z14 = i13 != 0 ? false : z11;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1534211956, i12, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioStatusPill (AudioCallScreen.kt:385)");
            }
            z12 = z10;
            AudioStatusPillNew(str, z12, z14, composerStartRestartGroup, i12 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0);
            str2 = str;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z14;
        } else {
            z12 = z10;
            str2 = str;
            composerStartRestartGroup.skipToGroupEnd();
            z13 = z11;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z15 = z12;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioStatusPill$lambda$0(str2, z15, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioStatusPill$lambda$0(String str, boolean z10, boolean z11, int i10, int i11, Composer composer, int i12) {
        AudioStatusPill(str, z10, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:53:0x0109  */
    /* JADX WARN: Code duplicated, block: B:54:0x011d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x011f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0133  */
    /* JADX WARN: Code duplicated, block: B:59:0x0198  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:76:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:79:0x0229  */
    /* JADX WARN: Code duplicated, block: B:81:0x022e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0230  */
    /* JADX WARN: Code duplicated, block: B:83:0x0233  */
    /* JADX WARN: Code duplicated, block: B:86:0x028a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0290  */
    /* JADX WARN: Code duplicated, block: B:91:0x029a  */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioStatusPillNew(final String str, final boolean z10, boolean z11, Composer composer, final int i10, final int i11) {
        String str2;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        final boolean z14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z15;
        int i14;
        State<Float> stateAnimateFloat;
        long jM5865copywmQWz5c$default;
        long jM5865copywmQWz5c$default2;
        lb.a constructor;
        long j10;
        float fAudioStatusPillNew$lambda$0;
        long j11;
        long j12;
        long j13;
        Composer composerStartRestartGroup = composer.startRestartGroup(304779474);
        if ((i10 & 6) == 0) {
            str2 = str;
            i12 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i10;
        } else {
            str2 = str;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        int i15 = i11 & 4;
        if (i15 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z12 = z11;
                i12 |= composerStartRestartGroup.changed(z12) ? 256 : 128;
            }
            i13 = i12;
            if ((i13 & 147) != 146) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                if (i15 != 0) {
                    z15 = false;
                } else {
                    z15 = z12;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(304779474, i13, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioStatusPillNew (AudioCallScreen.kt:391)");
                }
                InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(TtmlNode.TEXT_EMPHASIS_MARK_DOT, composerStartRestartGroup, 6, 0);
                if (z15) {
                    i14 = XMPPTCPConnection.PacketWriter.QUEUE_SIZE;
                } else {
                    i14 = TypedValues.TransitionType.TYPE_DURATION;
                }
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.4f, 1.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(i14, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), TtmlNode.TEXT_EMPHASIS_MARK_DOT, composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                Modifier.Companion companion = Modifier.INSTANCE;
                if (z15) {
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(AudioCallRed, 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
                } else if (z10) {
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(AudioCallGreen, 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5893getBlue0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(companion, jM5865copywmQWz5c$default, RoundedCornerShapeKt.RoundedCornerShape(50));
                float fM8823constructorimpl = Dp.m8823constructorimpl(1);
                if (z15) {
                    jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(AudioCallRed, 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
                } else if (z10) {
                    jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(AudioCallGreen, 0.35f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5893getBlue0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                float f10 = 6;
                Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BorderKt.m1216borderxT4_qwU(modifierM1204backgroundbw27NRU, fM8823constructorimpl, jM5865copywmQWz5c$default2, RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.m8823constructorimpl(14), Dp.m8823constructorimpl(f10));
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(f10)), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
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
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(7));
                if (z15) {
                    j10 = AudioCallRed;
                } else if (z10) {
                    j10 = AudioCallGreen;
                } else {
                    j10 = AudioCallAccentWarm;
                }
                long j14 = j10;
                if (!z15 || z10) {
                    fAudioStatusPillNew$lambda$0 = AudioStatusPillNew$lambda$0(stateAnimateFloat);
                } else {
                    fAudioStatusPillNew$lambda$0 = 1.0f;
                }
                BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(modifierM1769size3ABfNKs, Color.m5865copywmQWz5c$default(j14, fAudioStatusPillNew$lambda$0, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                j11 = AudioCallAccentWarm;
                TextStyle labelMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium();
                if (z15) {
                    j13 = AudioCallRed;
                } else {
                    if (z10) {
                        j13 = AudioCallGreen;
                    } else {
                        j12 = j11;
                    }
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, str2, TextStyle.m8271copyp1EtxEg$default(labelMedium, j12, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), j11, 0, 0, composerStartRestartGroup, ((i13 << 3) & 112) | 3072, 49);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z14 = z15;
                }
                j12 = j13;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str2, TextStyle.m8271copyp1EtxEg$default(labelMedium, j12, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), j11, 0, 0, composerStartRestartGroup, ((i13 << 3) & 112) | 3072, 49);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z14 = z15;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z14 = z12;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AudioCallScreenKt.AudioStatusPillNew$lambda$2(str, z10, z14, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z12 = z11;
        i13 = i12;
        if ((i13 & 147) != 146) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
            if (i15 != 0) {
                z15 = false;
            } else {
                z15 = z12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(304779474, i13, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioStatusPillNew (AudioCallScreen.kt:391)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(TtmlNode.TEXT_EMPHASIS_MARK_DOT, composerStartRestartGroup, 6, 0);
            if (z15) {
                i14 = XMPPTCPConnection.PacketWriter.QUEUE_SIZE;
            } else {
                i14 = TypedValues.TransitionType.TYPE_DURATION;
            }
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.4f, 1.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(i14, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), TtmlNode.TEXT_EMPHASIS_MARK_DOT, composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            if (z15) {
                jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(AudioCallRed, 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
            } else if (z10) {
                jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(AudioCallGreen, 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5893getBlue0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
            }
            Modifier modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(companion3, jM5865copywmQWz5c$default, RoundedCornerShapeKt.RoundedCornerShape(50));
            float fM8823constructorimpl2 = Dp.m8823constructorimpl(1);
            if (z15) {
                jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(AudioCallRed, 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
            } else if (z10) {
                jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(AudioCallGreen, 0.35f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(Color.INSTANCE.m5893getBlue0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
            }
            float f11 = 6;
            Modifier modifierM1726paddingVpY3zN5 = PaddingKt.m1726paddingVpY3zN4(BorderKt.m1216borderxT4_qwU(modifierM1204backgroundbw27NRU2, fM8823constructorimpl2, jM5865copywmQWz5c$default2, RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.m8823constructorimpl(14), Dp.m8823constructorimpl(f11));
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(f11)), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN5);
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
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(7));
            if (z15) {
                j10 = AudioCallRed;
            } else if (z10) {
                j10 = AudioCallGreen;
            } else {
                j10 = AudioCallAccentWarm;
            }
            long j15 = j10;
            if (z15) {
                fAudioStatusPillNew$lambda$0 = AudioStatusPillNew$lambda$0(stateAnimateFloat);
            } else {
                fAudioStatusPillNew$lambda$0 = AudioStatusPillNew$lambda$0(stateAnimateFloat);
            }
            BoxKt.Box(BackgroundKt.m1204backgroundbw27NRU(modifierM1769size3ABfNKs2, Color.m5865copywmQWz5c$default(j15, fAudioStatusPillNew$lambda$0, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            j11 = AudioCallAccentWarm;
            TextStyle labelMedium2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium();
            if (z15) {
                j13 = AudioCallRed;
            } else {
                if (z10) {
                    j13 = AudioCallGreen;
                } else {
                    j12 = j11;
                }
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str2, TextStyle.m8271copyp1EtxEg$default(labelMedium2, j12, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), j11, 0, 0, composerStartRestartGroup, ((i13 << 3) & 112) | 3072, 49);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z14 = z15;
            }
            j12 = j13;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str2, TextStyle.m8271copyp1EtxEg$default(labelMedium2, j12, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), j11, 0, 0, composerStartRestartGroup, ((i13 << 3) & 112) | 3072, 49);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z14 = z15;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z14 = z12;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioStatusPillNew$lambda$2(str, z10, z14, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float AudioStatusPillNew$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioStatusPillNew$lambda$2(String str, boolean z10, boolean z11, int i10, int i11, Composer composer, int i12) {
        AudioStatusPillNew(str, z10, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioWaveform(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1951409167);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1951409167, i10, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioWaveform (AudioCallScreen.kt:352)");
            }
            AudioWaveformNew(composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioWaveform$lambda$0(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioWaveform$lambda$0(int i10, Composer composer, int i11) {
        AudioWaveform(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AudioWaveformNew(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-720213925);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-720213925, i10, -1, "cu.todus.android.uiCompose.call.screen.audio.AudioWaveformNew (AudioCallScreen.kt:358)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("wave", composerStartRestartGroup, 6, 0);
            List listQ = w.q(0, 140, 70, 210, 100);
            composerStartRestartGroup.startReplaceGroup(-635841619);
            ArrayList arrayList = new ArrayList(x.y(listQ, 10));
            Iterator it = listQ.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                arrayList.add(InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.2f, 1.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween(600, iIntValue, EasingKt.getFastOutSlowInEasing()), RepeatMode.Reverse, 0L, 4, null), "bar" + iIntValue, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 0));
            }
            composerStartRestartGroup.endReplaceGroup();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_4 = Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(6));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
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
            composerStartRestartGroup.startReplaceGroup(1708544893);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BoxKt.Box(BackgroundKt.background$default(ClipKt.clip(SizeKt.m1755height3ABfNKs(SizeKt.m1774width3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(4)), Dp.m8823constructorimpl(32 * AudioWaveformNew$lambda$1$0$0((State) it2.next()))), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(2))), Brush.Companion.m5827verticalGradient8A3gB4$default(Brush.INSTANCE, w.q(Color.m5856boximpl(AudioCallAccent), Color.m5856boximpl(AudioCallAccentWarm)), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.audio.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioCallScreenKt.AudioWaveformNew$lambda$2(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float AudioWaveformNew$lambda$1$0$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AudioWaveformNew$lambda$2(int i10, Composer composer, int i11) {
        AudioWaveformNew(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
