package cu.todus.android.uiCompose.call.screen.call;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
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
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
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
import cu.todus.android.R;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.di.MediaModule;
import cu.todus.android.uiCompose.call.screen.call.components.BigCallItemKt;
import cu.todus.android.uiCompose.call.screen.call.components.centerPlaceholder.CenterPlaceholderInCallKt;
import cu.todus.android.uiCompose.call.screen.call.components.controls.CallAction;
import cu.todus.android.uiCompose.call.screen.call.components.controls.VideoCallControlAction;
import cu.todus.android.uiCompose.call.screen.call.components.controls.VideoCallControlActionKt;
import cu.todus.android.uiCompose.call.screen.call.components.controls.VideoCallControlsKt;
import cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.FloatingVideoRendererKt;
import cu.todus.android.uiCompose.call.screen.call.components.videoRender.VideoRendererKt;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.webrtc.CallState;
import cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import org.webrtc.VideoTrack;
import te.p0;
import ua.k0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aO\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a!\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aM\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b!\u0010\"\u001a!\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0004\b&\u0010'¨\u0006-²\u0006\f\u0010$\u001a\u00020#8\nX\u008a\u0084\u0002²\u0006\f\u0010(\u001a\u00020\u001d8\nX\u008a\u0084\u0002²\u0006\u000e\u0010%\u001a\u0004\u0018\u00010\u001b8\nX\u008a\u0084\u0002²\u0006\u000e\u0010)\u001a\u00020\u001b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010*\u001a\u0004\u0018\u00010\n8\nX\u008a\u0084\u0002²\u0006\u000e\u0010,\u001a\u00020+8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/call/screen/call/CallViewModel;", "viewModel", "Lua/k0;", "CallScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/call/screen/call/CallViewModel;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "", "Lcu/todus/android/webrtc/CallState;", Service.Endpoint.LINKED_DEVICES_LIST, "Lkotlin/Function1;", "", "acceptCall", "rejectCall", "CallList", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/pojo/Partner;", "partner", "CallingView", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/Partner;Landroidx/compose/runtime/Composer;II)V", "Lorg/webrtc/VideoTrack;", "remoteVideoTrack", "localVideoTrack", "Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "sessionManager", "", "isCameraEnabled", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "withCallMediaState", "InCallView", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/Partner;Lorg/webrtc/VideoTrack;Lorg/webrtc/VideoTrack;Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;ZLcu/todus/android/uiCompose/call/screen/call/CallMediaState;Landroidx/compose/runtime/Composer;II)V", "WithCallState", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;", "state", "isRinging", "ToolBarTitle", "(Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;Ljava/lang/Boolean;Landroidx/compose/runtime/Composer;I)V", "ownerCallMediaState", "permissionsGranted", "currentCallState", "Landroidx/compose/ui/unit/IntSize;", "parentSize", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CallScreenKt {

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

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CallList(Modifier modifier, final List<CallState> list, final Function1 acceptCall, final Function1 rejectCall, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Composer composer2;
        final Modifier modifier3;
        y.i(list, "list");
        y.i(acceptCall, "acceptCall");
        y.i(rejectCall, "rejectCall");
        Composer composerStartRestartGroup = composer.startRestartGroup(406958267);
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
            i12 |= composerStartRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(acceptCall) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(rejectCall) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(406958267, i12, -1, "cu.todus.android.uiCompose.call.screen.call.CallList (CallScreen.kt:265)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | ((i12 & 896) == 256) | ((i12 & 7168) == 2048) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CallScreenKt.CallList$lambda$0$0(list, acceptCall, rejectCall, context, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifier4, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, i12 & 14, TypedValues.PositionType.TYPE_POSITION_TYPE);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallScreenKt.CallList$lambda$1(modifier3, list, acceptCall, rejectCall, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallList$lambda$0$0(final List list, final Function1 function1, final Function1 function2, final Context context, LazyListScope LazyColumn) {
        y.i(LazyColumn, "$this$LazyColumn");
        final CallScreenKt$CallList$lambda$0$0$$inlined$items$default$1 callScreenKt$CallList$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.CallScreenKt$CallList$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(CallState callState) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((CallState) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.CallScreenKt$CallList$lambda$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return callScreenKt$CallList$lambda$0$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new lb.o() { // from class: cu.todus.android.uiCompose.call.screen.call.CallScreenKt$CallList$lambda$0$0$$inlined$items$default$4
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
                composer.startReplaceGroup(-1476091614);
                BigCallItemKt.BigCallItem(null, callState, function1, function2, composer, CallState.$stable << 3, 1);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (list.isEmpty()) {
            LazyListScope.CC.m(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(186267019, true, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.call.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CallScreenKt.CallList$lambda$0$0$1(context, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CallList$lambda$0$0$1(final Context context, LazyItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(186267019, i10, -1, "cu.todus.android.uiCompose.call.screen.call.CallList.<anonymous>.<anonymous>.<anonymous> (CallScreen.kt:281)");
            }
            boolean zChangedInstance = composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.r
                    @Override // lb.a
                    public final Object invoke() {
                        return CallScreenKt.CallList$lambda$0$0$1$0$0(context);
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
    public static final k0 CallList$lambda$0$0$1$0$0(Context context) {
        try {
            Z17InlineUtilsKt.findActivity(context).finish();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallList$lambda$1(Modifier modifier, List list, Function1 function1, Function1 function2, int i10, int i11, Composer composer, int i12) {
        CallList(modifier, list, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CallScreen(final NavHostController navHostController, CallViewModel callViewModel, Composer composer, final int i10, final int i11) {
        CallViewModel callViewModel2;
        int i12;
        final CallViewModel callViewModel3;
        char c10;
        MutableState mutableState;
        final Context context;
        ab.e eVar;
        char c11;
        final MutableState mutableState2;
        final State state;
        Modifier.Companion companion;
        CallMediaState callMediaState;
        int i13;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1174052515);
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                callViewModel2 = callViewModel;
                if (composerStartRestartGroup.changedInstance(callViewModel2)) {
                    i13 = 32;
                }
                i12 = i13 | i10;
            } else {
                callViewModel2 = callViewModel;
            }
            i13 = 16;
            i12 = i13 | i10;
        } else {
            callViewModel2 = callViewModel;
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
                callViewModel2 = (CallViewModel) ViewModelKt.viewModel(z0.b(CallViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i12 &= -113;
            }
            int i14 = i12;
            CallViewModel callViewModel4 = callViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1174052515, i14, -1, "cu.todus.android.uiCompose.call.screen.call.CallScreen (CallScreen.kt:61)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(callViewModel4.getCallSystemState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(callViewModel4.ownerCallMediaState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            Composer composer2 = composerStartRestartGroup;
            Context context2 = (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(callViewModel4.isRinging(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue == companion2.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion3);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion5.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(companion3);
            Alignment.Vertical centerVertically = companion4.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer2, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierSafeContentPadding);
            lb.a constructor2 = companion5.getConstructor();
            if (!defpackage.r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ToolBarTitle(CallScreen$lambda$0(stateCollectAsStateWithLifecycle), CallScreen$lambda$2(stateCollectAsStateWithLifecycle3), composer2, 0);
            SpacerKt.Spacer(e3.a(rowScopeInstance, companion3, 1.0f, false, 2, null), composer2, 0);
            composer2.endNode();
            if (CallScreen$lambda$4(mutableState3)) {
                composer2.startReplaceGroup(1885762634);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                lb.a constructor3 = companion5.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
                int i15 = WhenMappings.$EnumSwitchMapping$0[CallScreen$lambda$0(stateCollectAsStateWithLifecycle).ordinal()];
                if (i15 == 1) {
                    c10 = 3;
                    mutableState = mutableState3;
                    callViewModel3 = callViewModel4;
                    context = context2;
                    eVar = null;
                    c11 = 2;
                    composer2.startReplaceGroup(1595813520);
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                    int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default2);
                    lb.a constructor4 = companion5.getConstructor();
                    if (!defpackage.r.a(composer2.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor4);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
                    LoadingScreenKt.LoadingWall(composer2, 0);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                    k0 k0Var = k0.f43947a;
                } else if (i15 == 2) {
                    c10 = 3;
                    mutableState = mutableState3;
                    c11 = 2;
                    callViewModel3 = callViewModel4;
                    context = context2;
                    eVar = null;
                    composer2.startReplaceGroup(1596024010);
                    composer2.endReplaceGroup();
                    k0 k0Var2 = k0.f43947a;
                } else if (i15 == 3) {
                    c10 = 3;
                    mutableState = mutableState3;
                    c11 = 2;
                    callViewModel3 = callViewModel4;
                    context = context2;
                    eVar = null;
                    composer2.startReplaceGroup(1596075005);
                    composer2.endReplaceGroup();
                    Z17InlineUtilsKt.findActivity(context).finish();
                    k0 k0Var3 = k0.f43947a;
                } else if (i15 == 4) {
                    c10 = 3;
                    mutableState = mutableState3;
                    c11 = 2;
                    callViewModel3 = callViewModel4;
                    context = context2;
                    eVar = null;
                    composer2.startReplaceGroup(1596244916);
                    final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(callViewModel3.callList().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
                    Modifier modifierSafeContentPadding2 = WindowInsetsPadding_androidKt.safeContentPadding(SizeKt.fillMaxSize$default(PaddingKt.m1727paddingVpY3zN4$default(companion3, 0.0f, Dp.m8823constructorimpl(100), 1, null), 0.0f, 1, null));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
                    int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierSafeContentPadding2);
                    lb.a constructor5 = companion5.getConstructor();
                    if (!defpackage.r.a(composer2.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor5);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion5.getSetModifier());
                    List listY0 = g0.Y0((Iterable) stateCollectAsStateWithLifecycle4.getValue());
                    boolean zChangedInstance = composer2.changedInstance(callViewModel3);
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == companion2.getEmpty()) {
                        objRememberedValue2 = new CallScreenKt$CallScreen$1$2$2$1$1(callViewModel3);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function1 = (Function1) ((sb.h) objRememberedValue2);
                    boolean zChangedInstance2 = composer2.changedInstance(callViewModel3) | composer2.changed(stateCollectAsStateWithLifecycle4) | composer2.changedInstance(context);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == companion2.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CallScreenKt.CallScreen$lambda$6$1$1$1$0(callViewModel3, stateCollectAsStateWithLifecycle4, context, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    CallList(companion3, listY0, function1, (Function1) objRememberedValue3, composer2, 6, 0);
                    composer2 = composer2;
                    composer2.endNode();
                    composer2.endReplaceGroup();
                    k0 k0Var4 = k0.f43947a;
                } else {
                    if (i15 != 5) {
                        composer2.startReplaceGroup(-1472538393);
                        composer2.endReplaceGroup();
                        throw new ua.r();
                    }
                    composer2.startReplaceGroup(1597783105);
                    p0 p0VarCurrentCallState = callViewModel4.currentCallState();
                    y.f(p0VarCurrentCallState);
                    c10 = 3;
                    mutableState = mutableState3;
                    eVar = null;
                    State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(p0VarCurrentCallState, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 0, 7);
                    WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager = callViewModel4.sessionManager();
                    y.f(webRtcSessionManagerImplSessionManager);
                    c11 = 2;
                    VideoTrack videoTrack = (VideoTrack) FlowExtKt.collectAsStateWithLifecycle(webRtcSessionManagerImplSessionManager.getRemoteVideoTrackFlow(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14).getValue();
                    WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager2 = callViewModel4.sessionManager();
                    y.f(webRtcSessionManagerImplSessionManager2);
                    VideoTrack videoTrack2 = (VideoTrack) FlowExtKt.collectAsStateWithLifecycle(webRtcSessionManagerImplSessionManager2.getLocalVideoTrackFlow(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14).getValue();
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composer2, 0);
                    int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default3);
                    lb.a constructor6 = companion5.getConstructor();
                    if (!defpackage.r.a(composer2.getApplier())) {
                        composer2 = composer2;
                        ComposablesKt.invalidApplier();
                    }
                    composer2 = composer2;
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor6);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyColumnMeasurePolicy, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion5.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    CallState callStateCallScreen$lambda$6$1$2 = CallScreen$lambda$6$1$2(stateCollectAsStateWithLifecycle5);
                    Boolean boolValueOf = callStateCallScreen$lambda$6$1$2 != null ? Boolean.valueOf(callStateCallScreen$lambda$6$1$2.getCallIsStarted()) : null;
                    if (y.d(boolValueOf, Boolean.TRUE)) {
                        composer2.startReplaceGroup(267909156);
                        Modifier modifierA = x.a(columnScopeInstance, companion3, 1.0f, false, 2, null);
                        CallState callStateCallScreen$lambda$6$1$3 = CallScreen$lambda$6$1$2(stateCollectAsStateWithLifecycle5);
                        Partner partner = callStateCallScreen$lambda$6$1$3 != null ? callStateCallScreen$lambda$6$1$3.getPartner() : null;
                        y.f(partner);
                        WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager3 = callViewModel4.sessionManager();
                        y.f(webRtcSessionManagerImplSessionManager3);
                        boolean zIsCameraEnabled = CallScreen$lambda$1(stateCollectAsStateWithLifecycle2).isCameraEnabled();
                        CallState callStateCallScreen$lambda$6$1$4 = CallScreen$lambda$6$1$2(stateCollectAsStateWithLifecycle5);
                        if (callStateCallScreen$lambda$6$1$4 == null || (callMediaState = callStateCallScreen$lambda$6$1$4.getWithCallMediaState()) == null) {
                            callMediaState = new CallMediaState(false, false, false, 7, null);
                        }
                        state = stateCollectAsStateWithLifecycle2;
                        callViewModel3 = callViewModel4;
                        InCallView(modifierA, partner, videoTrack, videoTrack2, webRtcSessionManagerImplSessionManager3, zIsCameraEnabled, callMediaState, composer2, 0, 0);
                        composer2 = composer2;
                        boolean zChanged = composer2.changed(state) | composer2.changedInstance(callViewModel3);
                        Object objRememberedValue4 = composer2.rememberedValue();
                        if (zChanged || objRememberedValue4 == companion2.getEmpty()) {
                            objRememberedValue4 = new CallScreenKt$CallScreen$1$2$3$1$1(callViewModel3, state, null);
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        EffectsKt.LaunchedEffect(videoTrack2, (Function2) objRememberedValue4, composer2, 0);
                        composer2.endReplaceGroup();
                        companion = companion3;
                    } else {
                        callViewModel3 = callViewModel4;
                        state = stateCollectAsStateWithLifecycle2;
                        if (y.d(boolValueOf, Boolean.FALSE)) {
                            composer2.startReplaceGroup(268971216);
                            Modifier modifierA2 = x.a(columnScopeInstance, companion3, 1.0f, false, 2, null);
                            companion = companion3;
                            CallState callStateCallScreen$lambda$6$1$5 = CallScreen$lambda$6$1$2(stateCollectAsStateWithLifecycle5);
                            Partner partner2 = callStateCallScreen$lambda$6$1$5 != null ? callStateCallScreen$lambda$6$1$5.getPartner() : null;
                            y.f(partner2);
                            CallingView(modifierA2, partner2, composer2, 0, 0);
                            composer2.endReplaceGroup();
                        } else {
                            companion = companion3;
                            if (boolValueOf != null) {
                                composer2.startReplaceGroup(-822643884);
                                composer2.endReplaceGroup();
                                throw new ua.r();
                            }
                            composer2.startReplaceGroup(269274334);
                            composer2.endReplaceGroup();
                        }
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    CallMediaState callMediaStateCallScreen$lambda$1 = CallScreen$lambda$1(state);
                    CallState callStateCallScreen$lambda$6$1$6 = CallScreen$lambda$6$1$2(stateCollectAsStateWithLifecycle5);
                    boolean z10 = callStateCallScreen$lambda$6$1$6 != null && callStateCallScreen$lambda$6$1$6.getPeersConnected();
                    context = context2;
                    boolean zChanged2 = composer2.changed(state) | composer2.changedInstance(callViewModel3) | composer2.changedInstance(context);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue5 == companion2.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.o
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CallScreenKt.CallScreen$lambda$6$1$3$1$0(callViewModel3, state, context, (CallAction) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    VideoCallControlsKt.VideoCallControls(modifierFillMaxWidth$default, callMediaStateCallScreen$lambda$1, null, (Function1) objRememberedValue5, z10, composer2, 6, 4);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                    k0 k0Var5 = k0.f43947a;
                }
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                c10 = 3;
                mutableState = mutableState3;
                callViewModel3 = callViewModel4;
                context = context2;
                eVar = null;
                c11 = 2;
                composer2.startReplaceGroup(-1664485813);
                composer2.endReplaceGroup();
            }
            PermissionNeedIt[] permissionNeedItArr = new PermissionNeedIt[4];
            permissionNeedItArr[0] = PermissionNeedIt.STORAGE;
            permissionNeedItArr[1] = PermissionNeedIt.CAMERA;
            permissionNeedItArr[c11] = PermissionNeedIt.RECORD_AUDIO;
            permissionNeedItArr[c10] = PermissionNeedIt.CALLS;
            List listQ = w.q(permissionNeedItArr);
            Object objRememberedValue6 = composer2.rememberedValue();
            if (objRememberedValue6 == companion2.getEmpty()) {
                mutableState2 = mutableState;
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.p
                    @Override // lb.a
                    public final Object invoke() {
                        return CallScreenKt.CallScreen$lambda$6$2$0(mutableState2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            } else {
                mutableState2 = mutableState;
            }
            lb.a aVar = (lb.a) objRememberedValue6;
            String packageName = context.getPackageName();
            y.h(packageName, "getPackageName(...)");
            Composer composer3 = composer2;
            Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester(null, null, listQ, aVar, null, packageName, null, composer3, 3456, 83);
            composerStartRestartGroup = composer3;
            Boolean boolValueOf2 = Boolean.valueOf(CallScreen$lambda$4(mutableState2));
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(callViewModel3);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue7 == companion2.getEmpty()) {
                objRememberedValue7 = new CallScreenKt$CallScreen$1$4$1(callViewModel3, mutableState2, eVar);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2) objRememberedValue7, composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            callViewModel3 = callViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallScreenKt.CallScreen$lambda$7(navHostController, callViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CallScreen$endCall(Context context, CallViewModel callViewModel) {
        Z17InlineUtilsKt.findActivity(context).finish();
        callViewModel.endCall();
    }

    private static final CallSystemState CallScreen$lambda$0(State<? extends CallSystemState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallMediaState CallScreen$lambda$1(State<CallMediaState> state) {
        return state.getValue();
    }

    private static final Boolean CallScreen$lambda$2(State<Boolean> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CallScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CallScreen$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallScreen$lambda$6$1$1$1$0(CallViewModel callViewModel, State state, Context context, String it) {
        y.i(it, "it");
        callViewModel.rejectCall(it);
        if (((List) state.getValue()).size() <= 1) {
            try {
                Z17InlineUtilsKt.findActivity(context).finish();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return k0.f43947a;
    }

    private static final CallState CallScreen$lambda$6$1$2(State<CallState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallScreen$lambda$6$1$3$1$0(CallViewModel callViewModel, State state, Context context, CallAction it) throws InterruptedException {
        y.i(it, "it");
        if (it instanceof CallAction.ToggleMicroPhone) {
            boolean z10 = !CallScreen$lambda$1(state).isMicrophoneEnabled();
            callViewModel.updateOwnerCallMediaState(CallMediaState.copy$default(CallScreen$lambda$1(state), z10, false, false, 6, null));
            WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager = callViewModel.sessionManager();
            y.f(webRtcSessionManagerImplSessionManager);
            webRtcSessionManagerImplSessionManager.enableMicrophone(z10);
        } else if (it instanceof CallAction.ToggleCamera) {
            boolean z11 = !CallScreen$lambda$1(state).isCameraEnabled();
            callViewModel.updateOwnerCallMediaState(CallMediaState.copy$default(CallScreen$lambda$1(state), false, z11, false, 5, null));
            WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager2 = callViewModel.sessionManager();
            y.f(webRtcSessionManagerImplSessionManager2);
            webRtcSessionManagerImplSessionManager2.enableCamera(z11);
        } else if (y.d(it, CallAction.FlipCamera.INSTANCE)) {
            WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager3 = callViewModel.sessionManager();
            y.f(webRtcSessionManagerImplSessionManager3);
            webRtcSessionManagerImplSessionManager3.flipCamera();
        } else {
            if (!y.d(it, CallAction.LeaveCall.INSTANCE)) {
                throw new ua.r();
            }
            CallScreen$endCall(context, callViewModel);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallScreen$lambda$6$2$0(MutableState mutableState) {
        CallScreen$lambda$5(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallScreen$lambda$7(NavHostController navHostController, CallViewModel callViewModel, int i10, int i11, Composer composer, int i12) {
        CallScreen(navHostController, callViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CallingView(Modifier modifier, final Partner partner, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        y.i(partner, "partner");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1909710004);
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
            i12 |= composerStartRestartGroup.changed(partner) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1909710004, i12, -1, "cu.todus.android.uiCompose.call.screen.call.CallingView (CallScreen.kt:301)");
            }
            modifier3 = modifier4;
            CenterPlaceholderInCallKt.CenterPlaceHolderInCall(PaddingKt.m1729paddingqDBjuR0$default(modifier4, 0.0f, Dp.m8823constructorimpl(50), 0.0f, 0.0f, 13, null), partner.getName(), partner.getUser().getToDusId(), partner.getPicture(), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallScreenKt.CallingView$lambda$0(modifier3, partner, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallingView$lambda$0(Modifier modifier, Partner partner, int i10, int i11, Composer composer, int i12) {
        CallingView(modifier, partner, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void InCallView(Modifier modifier, final Partner partner, final VideoTrack videoTrack, final VideoTrack videoTrack2, final WebRtcSessionManagerImpl sessionManager, final boolean z10, final CallMediaState withCallMediaState, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Object obj;
        int i13;
        y.i(partner, "partner");
        y.i(sessionManager, "sessionManager");
        y.i(withCallMediaState, "withCallMediaState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1544116004);
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
            i12 |= composerStartRestartGroup.changed(partner) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(videoTrack) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(videoTrack2) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(sessionManager) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i12 |= composerStartRestartGroup.changed(withCallMediaState) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i12) != 599186, i12 & 1)) {
            Modifier modifier3 = i14 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1544116004, i12, -1, "cu.todus.android.uiCompose.call.screen.call.InCallView (CallScreen.kt:319)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                long j10 = 0;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j10 << 32) | (j10 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CallScreenKt.InCallView$lambda$3$0(mutableState, (IntSize) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxSize$default, (Function1) objRememberedValue2);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
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
            if (videoTrack == null || !withCallMediaState.isCameraEnabled()) {
                composerStartRestartGroup.startReplaceGroup(-1186957660);
                obj = null;
                i13 = i12;
                CenterPlaceholderInCallKt.CenterPlaceHolderInCall(null, partner.getName(), partner.getUser().getToDusId(), partner.getPicture(), composerStartRestartGroup, 0, 1);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1187180891);
                int i15 = i12 >> 6;
                VideoRendererKt.VideoRenderer(videoTrack, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), sessionManager, composerStartRestartGroup, (i15 & 896) | (i15 & 14) | 48, 0);
                composerStartRestartGroup.endReplaceGroup();
                i13 = i12;
                obj = null;
            }
            if (videoTrack2 == null || !z10) {
                composerStartRestartGroup.startReplaceGroup(-1186206592);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1186660494);
                FloatingVideoRendererKt.m9818FloatingVideoRendererJQLjw8(sessionManager, videoTrack2, InCallView$lambda$1(mutableState), PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(0)), boxScopeInstance.align(ClipKt.clip(SizeKt.m1771sizeVpY3zN4(WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE), Dp.m8823constructorimpl(150), Dp.m8823constructorimpl(210)), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(16))), companion2.getTopEnd()), composerStartRestartGroup, ((i13 >> 12) & 14) | 3072 | ((i13 >> 6) & 112), 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            WithCallState(boxScopeInstance.align(SizeKt.m1756heightInVpY3zN4(Modifier.INSTANCE, Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(60)), companion2.getBottomCenter()), withCallMediaState, composerStartRestartGroup, (i13 >> 15) & 112, 0);
            k0 k0Var = k0.f43947a;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new CallScreenKt$InCallView$2$1$1(obj);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue3, composerStartRestartGroup, 6);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CallScreenKt.InCallView$lambda$4$1$0((DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue4, composerStartRestartGroup, 54);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CallScreenKt.InCallView$lambda$5(modifier4, partner, videoTrack, videoTrack2, sessionManager, z10, withCallMediaState, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final long InCallView$lambda$1(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m8994unboximpl();
    }

    private static final void InCallView$lambda$2(MutableState<IntSize> mutableState, long j10) {
        mutableState.setValue(IntSize.m8982boximpl(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 InCallView$lambda$3$0(MutableState mutableState, IntSize intSize) {
        InCallView$lambda$2(mutableState, intSize.m8994unboximpl());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult InCallView$lambda$4$1$0(DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.call.screen.call.CallScreenKt$InCallView$lambda$4$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                MediaModule.INSTANCE.getInstance().setCheckerActiveInCall(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 InCallView$lambda$5(Modifier modifier, Partner partner, VideoTrack videoTrack, VideoTrack videoTrack2, WebRtcSessionManagerImpl webRtcSessionManagerImpl, boolean z10, CallMediaState callMediaState, int i10, int i11, Composer composer, int i12) {
        InCallView(modifier, partner, videoTrack, videoTrack2, webRtcSessionManagerImpl, z10, callMediaState, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ToolBarTitle(final CallSystemState state, final Boolean bool, Composer composer, final int i10) {
        int i11;
        int i12;
        int i13;
        y.i(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(832190927);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(state.ordinal()) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(bool) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(832190927, i11, -1, "cu.todus.android.uiCompose.call.screen.call.ToolBarTitle (CallScreen.kt:396)");
            }
            if (WhenMappings.$EnumSwitchMapping$0[state.ordinal()] == 5) {
                composerStartRestartGroup.startReplaceGroup(1248811759);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(10));
                if (y.d(bool, Boolean.TRUE)) {
                    composerStartRestartGroup.startReplaceGroup(871571828);
                    i13 = R.string.ringing;
                } else {
                    composerStartRestartGroup.startReplaceGroup(871573239);
                    i13 = R.string.call;
                }
                String strStringResource = StringResources_androidKt.stringResource(i13, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1725padding3ABfNKs, strStringResource, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composerStartRestartGroup, 6, 56);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1249183015);
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(10));
                if (y.d(bool, Boolean.TRUE)) {
                    composerStartRestartGroup.startReplaceGroup(871583796);
                    i12 = R.string.ringing;
                } else {
                    composerStartRestartGroup.startReplaceGroup(871585215);
                    i12 = R.string.calling_hint;
                }
                String strStringResource2 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1725padding3ABfNKs2, strStringResource2, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composerStartRestartGroup, 6, 56);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallScreenKt.ToolBarTitle$lambda$0(state, bool, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ToolBarTitle$lambda$0(CallSystemState callSystemState, Boolean bool, int i10, Composer composer, int i11) {
        ToolBarTitle(callSystemState, bool, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void WithCallState(final Modifier modifier, CallMediaState withCallMediaState, Composer composer, final int i10, final int i11) {
        int i12;
        final CallMediaState callMediaState;
        y.i(withCallMediaState, "withCallMediaState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1014842877);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(withCallMediaState) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (i13 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1014842877, i12, -1, "cu.todus.android.uiCompose.call.screen.call.WithCallState (CallScreen.kt:380)");
            }
            if (withCallMediaState.isCameraEnabled() && withCallMediaState.isMicrophoneEnabled() && withCallMediaState.isSoundEnable()) {
                composerStartRestartGroup.startReplaceGroup(-908848225);
                composerStartRestartGroup.endReplaceGroup();
                callMediaState = withCallMediaState;
            } else {
                composerStartRestartGroup.startReplaceGroup(-306420967);
                Modifier modifierAlpha = AlphaKt.alpha(modifier, 0.5f);
                List<VideoCallControlAction> listBuildWithCallControlActions = VideoCallControlActionKt.buildWithCallControlActions(withCallMediaState, composerStartRestartGroup, (i12 >> 3) & 14);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CallScreenKt.WithCallState$lambda$0$0((CallAction) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                callMediaState = withCallMediaState;
                VideoCallControlsKt.VideoCallControls(modifierAlpha, callMediaState, listBuildWithCallControlActions, (Function1) objRememberedValue, false, composerStartRestartGroup, (i12 & 112) | 27648, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            callMediaState = withCallMediaState;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallScreenKt.WithCallState$lambda$1(modifier, callMediaState, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 WithCallState$lambda$0$0(CallAction it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 WithCallState$lambda$1(Modifier modifier, CallMediaState callMediaState, int i10, int i11, Composer composer, int i12) {
        WithCallState(modifier, callMediaState, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
