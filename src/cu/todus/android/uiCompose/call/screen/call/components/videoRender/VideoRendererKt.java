package cu.todus.android.uiCompose.call.screen.call.components.videoRender;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import org.webrtc.RendererCommon;
import org.webrtc.VideoTrack;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a/\u0010\u0011\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000b2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013²\u0006\u0010\u0010\n\u001a\u0004\u0018\u00010\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lorg/webrtc/VideoTrack;", "videoTrack", "Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "sessionManager", "Lua/k0;", "VideoRenderer", "(Lorg/webrtc/VideoTrack;Landroidx/compose/ui/Modifier;Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;Landroidx/compose/runtime/Composer;II)V", "Lio/getstream/webrtc/android/ui/VideoTextureViewRenderer;", "view", "Landroidx/compose/runtime/MutableState;", "trackState", "cleanTrack", "(Lio/getstream/webrtc/android/ui/VideoTextureViewRenderer;Landroidx/compose/runtime/MutableState;)V", "track", "renderer", "setupVideo", "(Landroidx/compose/runtime/MutableState;Lorg/webrtc/VideoTrack;Lio/getstream/webrtc/android/ui/VideoTextureViewRenderer;)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class VideoRendererKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VideoRenderer(final VideoTrack videoTrack, Modifier modifier, final WebRtcSessionManagerImpl sessionManager, Composer composer, final int i10, final int i11) {
        int i12;
        final Modifier modifier2;
        y.i(videoTrack, "videoTrack");
        y.i(sessionManager, "sessionManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1950006408);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(videoTrack) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        int i13 = i11 & 2;
        if (i13 != 0) {
            i12 |= 48;
        } else if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(sessionManager) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (i13 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1950006408, i12, -1, "cu.todus.android.uiCompose.call.screen.call.components.videoRender.VideoRenderer (VideoRenderer.kt:27)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.videoRender.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VideoRendererKt.VideoRenderer$lambda$4$0(mutableState, mutableState2, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.DisposableEffect(videoTrack, (Function1) objRememberedValue3, composerStartRestartGroup, (i12 & 14) | 48);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(sessionManager) | composerStartRestartGroup.changedInstance(videoTrack);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.videoRender.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VideoRendererKt.VideoRenderer$lambda$5$0(sessionManager, mutableState, videoTrack, mutableState2, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function1 = (Function1) objRememberedValue4;
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(videoTrack);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.videoRender.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VideoRendererKt.VideoRenderer$lambda$6$0(mutableState, videoTrack, (io.getstream.webrtc.android.ui.VideoTextureViewRenderer) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            AndroidView_androidKt.AndroidView(function1, modifier3, (Function1) objRememberedValue5, composerStartRestartGroup, i12 & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.components.videoRender.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoRendererKt.VideoRenderer$lambda$7(videoTrack, modifier2, sessionManager, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.getstream.webrtc.android.ui.VideoTextureViewRenderer VideoRenderer$lambda$2(MutableState<io.getstream.webrtc.android.ui.VideoTextureViewRenderer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult VideoRenderer$lambda$4$0(final MutableState mutableState, final MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.call.screen.call.components.videoRender.VideoRendererKt$VideoRenderer$lambda$4$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                VideoRendererKt.cleanTrack(VideoRendererKt.VideoRenderer$lambda$2(mutableState2), mutableState);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.getstream.webrtc.android.ui.VideoTextureViewRenderer VideoRenderer$lambda$5$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl, MutableState mutableState, VideoTrack videoTrack, MutableState mutableState2, Context context) {
        y.i(context, "context");
        io.getstream.webrtc.android.ui.VideoTextureViewRenderer videoTextureViewRenderer = new io.getstream.webrtc.android.ui.VideoTextureViewRenderer(context, null, 2, null);
        videoTextureViewRenderer.d(webRtcSessionManagerImpl.getPeerConnectionFactory().getEglBaseContext(), new RendererCommon.RendererEvents() { // from class: cu.todus.android.uiCompose.call.screen.call.components.videoRender.VideoRendererKt$VideoRenderer$2$1$1$1
            @Override // org.webrtc.RendererCommon.RendererEvents
            public void onFirstFrameRendered() {
            }

            @Override // org.webrtc.RendererCommon.RendererEvents
            public void onFrameResolutionChanged(int p10, int p11, int p12) {
            }
        });
        videoTextureViewRenderer.setMirror(false);
        setupVideo(mutableState, videoTrack, videoTextureViewRenderer);
        mutableState2.setValue(videoTextureViewRenderer);
        return videoTextureViewRenderer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoRenderer$lambda$6$0(MutableState mutableState, VideoTrack videoTrack, io.getstream.webrtc.android.ui.VideoTextureViewRenderer v10) {
        y.i(v10, "v");
        setupVideo(mutableState, videoTrack, v10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoRenderer$lambda$7(VideoTrack videoTrack, Modifier modifier, WebRtcSessionManagerImpl webRtcSessionManagerImpl, int i10, int i11, Composer composer, int i12) {
        VideoRenderer(videoTrack, modifier, webRtcSessionManagerImpl, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cleanTrack(io.getstream.webrtc.android.ui.VideoTextureViewRenderer videoTextureViewRenderer, MutableState<VideoTrack> mutableState) {
        VideoTrack value;
        if (videoTextureViewRenderer != null && (value = mutableState.getValue()) != null) {
            value.removeSink(videoTextureViewRenderer);
        }
        mutableState.setValue(null);
    }

    private static final void setupVideo(MutableState<VideoTrack> mutableState, VideoTrack videoTrack, io.getstream.webrtc.android.ui.VideoTextureViewRenderer videoTextureViewRenderer) {
        if (y.d(mutableState.getValue(), videoTrack)) {
            return;
        }
        cleanTrack(videoTextureViewRenderer, mutableState);
        mutableState.setValue(videoTrack);
        videoTrack.addSink(videoTextureViewRenderer);
    }
}
