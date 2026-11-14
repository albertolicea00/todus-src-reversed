package cu.z17.views.videoEditor.sections.viewer;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.OptIn;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.ui.PlayerView;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.z17.views.videoPlayer.PlayerState;
import cu.z17.views.videoPlayer.Z17VideoPlayerKt;
import cu.z17.views.videoPlayer.cache.VideoPlayerCacheManager;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import ua.k0;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001as\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroid/net/Uri;", NewEntity.NEWS_CONFIG_SOURCE, "Lrb/b;", "", "cutPoints", "Lkotlin/Function2;", "Lcu/z17/views/videoPlayer/PlayerState;", "Landroidx/media3/common/Player;", "Lua/k0;", "updatePlayerState", "Lkotlin/Function1;", "Landroidx/media3/exoplayer/ExoPlayer;", "playerInstance", "playerState", "", "contentScale", "Viewer", "(Landroidx/compose/ui/Modifier;Landroid/net/Uri;Lrb/b;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcu/z17/views/videoPlayer/PlayerState;ILandroidx/compose/runtime/Composer;II)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ViewerKt {
    /* JADX WARN: Code duplicated, block: B:101:0x016e  */
    /* JADX WARN: Code duplicated, block: B:103:0x019d  */
    /* JADX WARN: Code duplicated, block: B:107:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:110:0x0211  */
    /* JADX WARN: Code duplicated, block: B:113:0x021d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0221  */
    /* JADX WARN: Code duplicated, block: B:117:0x0240  */
    /* JADX WARN: Code duplicated, block: B:119:0x024e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0274  */
    /* JADX WARN: Code duplicated, block: B:124:0x027a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0299  */
    /* JADX WARN: Code duplicated, block: B:128:0x029b  */
    /* JADX WARN: Code duplicated, block: B:131:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:134:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:136:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:141:0x033a  */
    /* JADX WARN: Code duplicated, block: B:143:0x0343  */
    /* JADX WARN: Code duplicated, block: B:146:0x0354  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:44:0x0086  */
    /* JADX WARN: Code duplicated, block: B:46:0x008e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0091  */
    /* JADX WARN: Code duplicated, block: B:51:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:84:0x010b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0117  */
    /* JADX WARN: Code duplicated, block: B:88:0x011a  */
    /* JADX WARN: Code duplicated, block: B:89:0x011d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0125  */
    /* JADX WARN: Code duplicated, block: B:95:0x014a  */
    /* JADX WARN: Code duplicated, block: B:98:0x015a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @OptIn(markerClass = {UnstableApi.class})
    @Composable
    public static final void Viewer(Modifier modifier, final Uri source, final rb.b cutPoints, Function2 function2, Function1 function1, final PlayerState playerState, int i10, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        Function2 function3;
        int i14;
        Function1 function4;
        int i15;
        int i16;
        int i17;
        boolean z10;
        Composer composer2;
        final int i18;
        final Modifier modifier3;
        final Function2 function5;
        final Function1 function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function2 function7;
        Function1 function8;
        int i19;
        final Context context;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        DataSource.Factory factory;
        Object objRememberedValue3;
        ExoPlayer exoPlayer;
        Object objRememberedValue4;
        PlayerView playerView;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        boolean zChangedInstance;
        Object objRememberedValue5;
        boolean z11;
        boolean z12;
        Object objRememberedValue6;
        ExoPlayer exoPlayer2;
        int i20;
        PlayerView playerView2;
        ExoPlayer.Builder audioAttributes;
        Cache cacheInstance;
        Object objRememberedValue7;
        Object objRememberedValue8;
        int i21;
        y.i(source, "source");
        y.i(cutPoints, "cutPoints");
        y.i(playerState, "playerState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-282260016);
        int i22 = i12 & 1;
        if (i22 != 0) {
            i13 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(source) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(cutPoints) ? 256 : 128;
        }
        int i23 = i12 & 8;
        if (i23 == 0) {
            if ((i11 & 3072) == 0) {
                function3 = function2;
                i13 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            i14 = i12 & 16;
            if (i14 != 0) {
                if ((i11 & 24576) == 0) {
                    function4 = function1;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
                    }
                    i13 |= i15;
                }
                if ((196608 & i11) == 0) {
                    if (composerStartRestartGroup.changed(playerState)) {
                        i21 = 131072;
                    } else {
                        i21 = 65536;
                    }
                    i13 |= i21;
                }
                i16 = i12 & 64;
                if (i16 != 0) {
                    i13 |= 1572864;
                } else if ((i11 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i10)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i13 |= i17;
                }
                if ((i13 & 599187) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.d
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ViewerKt.Viewer$lambda$1$lambda$0((PlayerState) obj, (Player) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        function7 = (Function2) objRememberedValue8;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.z17.views.videoEditor.sections.viewer.e
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ViewerKt.Viewer$lambda$3$lambda$2((ExoPlayer) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        function8 = (Function1) objRememberedValue7;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        i19 = 0;
                    } else {
                        i19 = i10;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-282260016, i13, -1, "cu.z17.views.videoEditor.sections.viewer.Viewer (Viewer.kt:43)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    y0 y0Var = new y0();
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        composerStartRestartGroup.updateRememberedValue(null);
                        objRememberedValue = null;
                    }
                    y0Var.f36634c = objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new DefaultDataSource.Factory(context);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    factory = (DataSource.Factory) objRememberedValue2;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        audioAttributes = new ExoPlayer.Builder(context).setAudioAttributes(new AudioAttributes.Builder().setContentType(3).setUsage(1).build(), false);
                        cacheInstance = VideoPlayerCacheManager.INSTANCE.createInstance(new lb.a() { // from class: cu.z17.views.videoEditor.sections.viewer.f
                            @Override // lb.a
                            public final Object invoke() {
                                return ViewerKt.Viewer$lambda$8$lambda$7$lambda$6(context);
                            }
                        }).getCacheInstance();
                        if (cacheInstance != null) {
                            CacheDataSource.Factory upstreamDataSourceFactory = new CacheDataSource.Factory().setCache(cacheInstance).setUpstreamDataSourceFactory(new DefaultDataSource.Factory(context, factory));
                            y.h(upstreamDataSourceFactory, "setUpstreamDataSourceFactory(...)");
                            audioAttributes.setMediaSourceFactory(new DefaultMediaSourceFactory(upstreamDataSourceFactory));
                        }
                        objRememberedValue3 = audioAttributes.build();
                        y.h(objRememberedValue3, "build(...)");
                        function8.invoke(objRememberedValue3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    exoPlayer = (ExoPlayer) objRememberedValue3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new PlayerView(context);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    playerView = (PlayerView) objRememberedValue4;
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    constructor = companion2.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    zChangedInstance = composerStartRestartGroup.changedInstance(playerView) | composerStartRestartGroup.changedInstance(exoPlayer);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new ViewerKt$Viewer$3$1$1(playerView, exoPlayer, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    EffectsKt.LaunchedEffect(exoPlayer, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(playerView) | composerStartRestartGroup.changedInstance(exoPlayer);
                    if ((458752 & i13) == 131072) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z12 = zChangedInstance2 | z11 | ((i13 & 7168) == 2048);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!z12 || objRememberedValue6 == companion.getEmpty()) {
                        exoPlayer2 = exoPlayer;
                        i20 = 1;
                        ViewerKt$Viewer$3$2$1 viewerKt$Viewer$3$2$1 = new ViewerKt$Viewer$3$2$1(playerView, exoPlayer2, playerState, function7, null);
                        playerView2 = playerView;
                        composerStartRestartGroup.updateRememberedValue(viewerKt$Viewer$3$2$1);
                        objRememberedValue6 = viewerKt$Viewer$3$2$1;
                    } else {
                        exoPlayer2 = exoPlayer;
                        i20 = 1;
                        playerView2 = playerView;
                    }
                    EffectsKt.LaunchedEffect(exoPlayer2, playerState, (Function2) objRememberedValue6, composerStartRestartGroup, (i13 >> 12) & 112);
                    ExoPlayer exoPlayer3 = exoPlayer2;
                    EffectsKt.LaunchedEffect(source, exoPlayer3, cutPoints, new ViewerKt$Viewer$3$3(y0Var, context, exoPlayer3, source, cutPoints, null), composerStartRestartGroup, ((i13 >> 3) & 14) | (i13 & 896));
                    Modifier modifier5 = modifier4;
                    Function1 function9 = function8;
                    composer2 = composerStartRestartGroup;
                    Z17VideoPlayerKt.VideoPlayerSurface(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i20, null), playerView2, exoPlayer3, false, false, true, false, null, z.a(16, 9), i19, -16777216, composer2, (1879048192 & (i13 << 9)) | 102460422, 6, 128);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function9;
                    function5 = function7;
                    i18 = i19;
                    modifier3 = modifier5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i18 = i10;
                    modifier3 = modifier2;
                    function5 = function3;
                    function6 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ViewerKt.Viewer$lambda$13(modifier3, source, cutPoints, function5, function6, playerState, i18, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            function4 = function1;
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changed(playerState)) {
                    i21 = 131072;
                } else {
                    i21 = 65536;
                }
                i13 |= i21;
            }
            i16 = i12 & 64;
            if (i16 != 0) {
                i13 |= 1572864;
            } else if ((i11 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i13 |= i17;
            }
            if ((i13 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.d
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ViewerKt.Viewer$lambda$1$lambda$0((PlayerState) obj, (Player) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    function7 = (Function2) objRememberedValue8;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.z17.views.videoEditor.sections.viewer.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ViewerKt.Viewer$lambda$3$lambda$2((ExoPlayer) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    function8 = (Function1) objRememberedValue7;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    i19 = 0;
                } else {
                    i19 = i10;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-282260016, i13, -1, "cu.z17.views.videoEditor.sections.viewer.Viewer (Viewer.kt:43)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                y0 y0Var2 = new y0();
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    composerStartRestartGroup.updateRememberedValue(null);
                    objRememberedValue = null;
                }
                y0Var2.f36634c = objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new DefaultDataSource.Factory(context);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                factory = (DataSource.Factory) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    audioAttributes = new ExoPlayer.Builder(context).setAudioAttributes(new AudioAttributes.Builder().setContentType(3).setUsage(1).build(), false);
                    cacheInstance = VideoPlayerCacheManager.INSTANCE.createInstance(new lb.a() { // from class: cu.z17.views.videoEditor.sections.viewer.f
                        @Override // lb.a
                        public final Object invoke() {
                            return ViewerKt.Viewer$lambda$8$lambda$7$lambda$6(context);
                        }
                    }).getCacheInstance();
                    if (cacheInstance != null) {
                        CacheDataSource.Factory upstreamDataSourceFactory2 = new CacheDataSource.Factory().setCache(cacheInstance).setUpstreamDataSourceFactory(new DefaultDataSource.Factory(context, factory));
                        y.h(upstreamDataSourceFactory2, "setUpstreamDataSourceFactory(...)");
                        audioAttributes.setMediaSourceFactory(new DefaultMediaSourceFactory(upstreamDataSourceFactory2));
                    }
                    objRememberedValue3 = audioAttributes.build();
                    y.h(objRememberedValue3, "build(...)");
                    function8.invoke(objRememberedValue3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                exoPlayer = (ExoPlayer) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new PlayerView(context);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                playerView = (PlayerView) objRememberedValue4;
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                zChangedInstance = composerStartRestartGroup.changedInstance(playerView) | composerStartRestartGroup.changedInstance(exoPlayer);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue5 = new ViewerKt$Viewer$3$1$1(playerView, exoPlayer, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new ViewerKt$Viewer$3$1$1(playerView, exoPlayer, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                EffectsKt.LaunchedEffect(exoPlayer, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(playerView) | composerStartRestartGroup.changedInstance(exoPlayer);
                if ((458752 & i13) == 131072) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = zChangedInstance3 | z11 | ((i13 & 7168) == 2048);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    exoPlayer2 = exoPlayer;
                    i20 = 1;
                    ViewerKt$Viewer$3$2$1 viewerKt$Viewer$3$2$2 = new ViewerKt$Viewer$3$2$1(playerView, exoPlayer2, playerState, function7, null);
                    playerView2 = playerView;
                    composerStartRestartGroup.updateRememberedValue(viewerKt$Viewer$3$2$2);
                    objRememberedValue6 = viewerKt$Viewer$3$2$2;
                } else {
                    exoPlayer2 = exoPlayer;
                    i20 = 1;
                    ViewerKt$Viewer$3$2$1 viewerKt$Viewer$3$2$3 = new ViewerKt$Viewer$3$2$1(playerView, exoPlayer2, playerState, function7, null);
                    playerView2 = playerView;
                    composerStartRestartGroup.updateRememberedValue(viewerKt$Viewer$3$2$3);
                    objRememberedValue6 = viewerKt$Viewer$3$2$3;
                }
                EffectsKt.LaunchedEffect(exoPlayer2, playerState, (Function2) objRememberedValue6, composerStartRestartGroup, (i13 >> 12) & 112);
                ExoPlayer exoPlayer4 = exoPlayer2;
                EffectsKt.LaunchedEffect(source, exoPlayer4, cutPoints, new ViewerKt$Viewer$3$3(y0Var2, context, exoPlayer4, source, cutPoints, null), composerStartRestartGroup, ((i13 >> 3) & 14) | (i13 & 896));
                Modifier modifier6 = modifier4;
                Function1 function10 = function8;
                composer2 = composerStartRestartGroup;
                Z17VideoPlayerKt.VideoPlayerSurface(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i20, null), playerView2, exoPlayer4, false, false, true, false, null, z.a(16, 9), i19, -16777216, composer2, (1879048192 & (i13 << 9)) | 102460422, 6, 128);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function10;
                function5 = function7;
                i18 = i19;
                modifier3 = modifier6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i18 = i10;
                modifier3 = modifier2;
                function5 = function3;
                function6 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ViewerKt.Viewer$lambda$13(modifier3, source, cutPoints, function5, function6, playerState, i18, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        function3 = function2;
        i14 = i12 & 16;
        if (i14 != 0) {
            if ((i11 & 24576) == 0) {
                function4 = function1;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
                }
                i13 |= i15;
            }
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changed(playerState)) {
                    i21 = 131072;
                } else {
                    i21 = 65536;
                }
                i13 |= i21;
            }
            i16 = i12 & 64;
            if (i16 != 0) {
                i13 |= 1572864;
            } else if ((i11 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i13 |= i17;
            }
            if ((i13 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.d
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ViewerKt.Viewer$lambda$1$lambda$0((PlayerState) obj, (Player) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    function7 = (Function2) objRememberedValue8;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.z17.views.videoEditor.sections.viewer.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ViewerKt.Viewer$lambda$3$lambda$2((ExoPlayer) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    function8 = (Function1) objRememberedValue7;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    i19 = 0;
                } else {
                    i19 = i10;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-282260016, i13, -1, "cu.z17.views.videoEditor.sections.viewer.Viewer (Viewer.kt:43)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                y0 y0Var3 = new y0();
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    composerStartRestartGroup.updateRememberedValue(null);
                    objRememberedValue = null;
                }
                y0Var3.f36634c = objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new DefaultDataSource.Factory(context);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                factory = (DataSource.Factory) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    audioAttributes = new ExoPlayer.Builder(context).setAudioAttributes(new AudioAttributes.Builder().setContentType(3).setUsage(1).build(), false);
                    cacheInstance = VideoPlayerCacheManager.INSTANCE.createInstance(new lb.a() { // from class: cu.z17.views.videoEditor.sections.viewer.f
                        @Override // lb.a
                        public final Object invoke() {
                            return ViewerKt.Viewer$lambda$8$lambda$7$lambda$6(context);
                        }
                    }).getCacheInstance();
                    if (cacheInstance != null) {
                        CacheDataSource.Factory upstreamDataSourceFactory3 = new CacheDataSource.Factory().setCache(cacheInstance).setUpstreamDataSourceFactory(new DefaultDataSource.Factory(context, factory));
                        y.h(upstreamDataSourceFactory3, "setUpstreamDataSourceFactory(...)");
                        audioAttributes.setMediaSourceFactory(new DefaultMediaSourceFactory(upstreamDataSourceFactory3));
                    }
                    objRememberedValue3 = audioAttributes.build();
                    y.h(objRememberedValue3, "build(...)");
                    function8.invoke(objRememberedValue3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                exoPlayer = (ExoPlayer) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new PlayerView(context);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                playerView = (PlayerView) objRememberedValue4;
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                constructor = companion4.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                zChangedInstance = composerStartRestartGroup.changedInstance(playerView) | composerStartRestartGroup.changedInstance(exoPlayer);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue5 = new ViewerKt$Viewer$3$1$1(playerView, exoPlayer, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new ViewerKt$Viewer$3$1$1(playerView, exoPlayer, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                EffectsKt.LaunchedEffect(exoPlayer, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(playerView) | composerStartRestartGroup.changedInstance(exoPlayer);
                if ((458752 & i13) == 131072) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = zChangedInstance4 | z11 | ((i13 & 7168) == 2048);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    exoPlayer2 = exoPlayer;
                    i20 = 1;
                    ViewerKt$Viewer$3$2$1 viewerKt$Viewer$3$2$4 = new ViewerKt$Viewer$3$2$1(playerView, exoPlayer2, playerState, function7, null);
                    playerView2 = playerView;
                    composerStartRestartGroup.updateRememberedValue(viewerKt$Viewer$3$2$4);
                    objRememberedValue6 = viewerKt$Viewer$3$2$4;
                } else {
                    exoPlayer2 = exoPlayer;
                    i20 = 1;
                    ViewerKt$Viewer$3$2$1 viewerKt$Viewer$3$2$5 = new ViewerKt$Viewer$3$2$1(playerView, exoPlayer2, playerState, function7, null);
                    playerView2 = playerView;
                    composerStartRestartGroup.updateRememberedValue(viewerKt$Viewer$3$2$5);
                    objRememberedValue6 = viewerKt$Viewer$3$2$5;
                }
                EffectsKt.LaunchedEffect(exoPlayer2, playerState, (Function2) objRememberedValue6, composerStartRestartGroup, (i13 >> 12) & 112);
                ExoPlayer exoPlayer5 = exoPlayer2;
                EffectsKt.LaunchedEffect(source, exoPlayer5, cutPoints, new ViewerKt$Viewer$3$3(y0Var3, context, exoPlayer5, source, cutPoints, null), composerStartRestartGroup, ((i13 >> 3) & 14) | (i13 & 896));
                Modifier modifier7 = modifier4;
                Function1 function11 = function8;
                composer2 = composerStartRestartGroup;
                Z17VideoPlayerKt.VideoPlayerSurface(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i20, null), playerView2, exoPlayer5, false, false, true, false, null, z.a(16, 9), i19, -16777216, composer2, (1879048192 & (i13 << 9)) | 102460422, 6, 128);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function11;
                function5 = function7;
                i18 = i19;
                modifier3 = modifier7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i18 = i10;
                modifier3 = modifier2;
                function5 = function3;
                function6 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ViewerKt.Viewer$lambda$13(modifier3, source, cutPoints, function5, function6, playerState, i18, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        function4 = function1;
        if ((196608 & i11) == 0) {
            if (composerStartRestartGroup.changed(playerState)) {
                i21 = 131072;
            } else {
                i21 = 65536;
            }
            i13 |= i21;
        }
        i16 = i12 & 64;
        if (i16 != 0) {
            i13 |= 1572864;
        } else if ((i11 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(i10)) {
                i17 = 1048576;
            } else {
                i17 = 524288;
            }
            i13 |= i17;
        }
        if ((i13 & 599187) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            if (i22 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i23 != 0) {
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ViewerKt.Viewer$lambda$1$lambda$0((PlayerState) obj, (Player) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                function7 = (Function2) objRememberedValue8;
            } else {
                function7 = function3;
            }
            if (i14 != 0) {
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.z17.views.videoEditor.sections.viewer.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ViewerKt.Viewer$lambda$3$lambda$2((ExoPlayer) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                function8 = (Function1) objRememberedValue7;
            } else {
                function8 = function4;
            }
            if (i16 != 0) {
                i19 = 0;
            } else {
                i19 = i10;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-282260016, i13, -1, "cu.z17.views.videoEditor.sections.viewer.Viewer (Viewer.kt:43)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            y0 y0Var4 = new y0();
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                composerStartRestartGroup.updateRememberedValue(null);
                objRememberedValue = null;
            }
            y0Var4.f36634c = objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new DefaultDataSource.Factory(context);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            factory = (DataSource.Factory) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                audioAttributes = new ExoPlayer.Builder(context).setAudioAttributes(new AudioAttributes.Builder().setContentType(3).setUsage(1).build(), false);
                cacheInstance = VideoPlayerCacheManager.INSTANCE.createInstance(new lb.a() { // from class: cu.z17.views.videoEditor.sections.viewer.f
                    @Override // lb.a
                    public final Object invoke() {
                        return ViewerKt.Viewer$lambda$8$lambda$7$lambda$6(context);
                    }
                }).getCacheInstance();
                if (cacheInstance != null) {
                    CacheDataSource.Factory upstreamDataSourceFactory4 = new CacheDataSource.Factory().setCache(cacheInstance).setUpstreamDataSourceFactory(new DefaultDataSource.Factory(context, factory));
                    y.h(upstreamDataSourceFactory4, "setUpstreamDataSourceFactory(...)");
                    audioAttributes.setMediaSourceFactory(new DefaultMediaSourceFactory(upstreamDataSourceFactory4));
                }
                objRememberedValue3 = audioAttributes.build();
                y.h(objRememberedValue3, "build(...)");
                function8.invoke(objRememberedValue3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            exoPlayer = (ExoPlayer) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new PlayerView(context);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            playerView = (PlayerView) objRememberedValue4;
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            constructor = companion5.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            zChangedInstance = composerStartRestartGroup.changedInstance(playerView) | composerStartRestartGroup.changedInstance(exoPlayer);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue5 = new ViewerKt$Viewer$3$1$1(playerView, exoPlayer, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new ViewerKt$Viewer$3$1$1(playerView, exoPlayer, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            EffectsKt.LaunchedEffect(exoPlayer, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
            boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(playerView) | composerStartRestartGroup.changedInstance(exoPlayer);
            if ((458752 & i13) == 131072) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = zChangedInstance5 | z11 | ((i13 & 7168) == 2048);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z12) {
                exoPlayer2 = exoPlayer;
                i20 = 1;
                ViewerKt$Viewer$3$2$1 viewerKt$Viewer$3$2$6 = new ViewerKt$Viewer$3$2$1(playerView, exoPlayer2, playerState, function7, null);
                playerView2 = playerView;
                composerStartRestartGroup.updateRememberedValue(viewerKt$Viewer$3$2$6);
                objRememberedValue6 = viewerKt$Viewer$3$2$6;
            } else {
                exoPlayer2 = exoPlayer;
                i20 = 1;
                ViewerKt$Viewer$3$2$1 viewerKt$Viewer$3$2$7 = new ViewerKt$Viewer$3$2$1(playerView, exoPlayer2, playerState, function7, null);
                playerView2 = playerView;
                composerStartRestartGroup.updateRememberedValue(viewerKt$Viewer$3$2$7);
                objRememberedValue6 = viewerKt$Viewer$3$2$7;
            }
            EffectsKt.LaunchedEffect(exoPlayer2, playerState, (Function2) objRememberedValue6, composerStartRestartGroup, (i13 >> 12) & 112);
            ExoPlayer exoPlayer6 = exoPlayer2;
            EffectsKt.LaunchedEffect(source, exoPlayer6, cutPoints, new ViewerKt$Viewer$3$3(y0Var4, context, exoPlayer6, source, cutPoints, null), composerStartRestartGroup, ((i13 >> 3) & 14) | (i13 & 896));
            Modifier modifier8 = modifier4;
            Function1 function12 = function8;
            composer2 = composerStartRestartGroup;
            Z17VideoPlayerKt.VideoPlayerSurface(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i20, null), playerView2, exoPlayer6, false, false, true, false, null, z.a(16, 9), i19, -16777216, composer2, (1879048192 & (i13 << 9)) | 102460422, 6, 128);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function12;
            function5 = function7;
            i18 = i19;
            modifier3 = modifier8;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            i18 = i10;
            modifier3 = modifier2;
            function5 = function3;
            function6 = function4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ViewerKt.Viewer$lambda$13(modifier3, source, cutPoints, function5, function6, playerState, i18, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Viewer$lambda$1$lambda$0(PlayerState playerState, Player player) {
        y.i(playerState, "<unused var>");
        y.i(player, "<unused var>");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Viewer$lambda$13(Modifier modifier, Uri uri, rb.b bVar, Function2 function2, Function1 function1, PlayerState playerState, int i10, int i11, int i12, Composer composer, int i13) {
        Viewer(modifier, uri, bVar, function2, function1, playerState, i10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Viewer$lambda$3$lambda$2(ExoPlayer exoPlayer) {
        y.i(exoPlayer, "<this>");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlayerCacheManager Viewer$lambda$8$lambda$7$lambda$6(Context context) {
        return new VideoPlayerCacheManager(context);
    }
}
