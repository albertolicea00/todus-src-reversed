package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.uiCompose.player.screen.PlayerScreenKt;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableKt;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableSize;
import cu.todus.android.uiCompose.shared.uploadable.UploadableKt;
import cu.todus.android.uiCompose.shared.uploadable.UploadableSize;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import cu.z17.views.videoPlayer.PlayerState;
import cu.z17.views.videoPlayer.RepeatMode;
import cu.z17.views.videoPlayer.Z17VideoPlayerKt;
import cu.z17.views.videoPlayer.trackSelector.TrackElement;
import cu.z17.views.videoPlayer.uri.VideoPlayerMediaItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0016²\u0006\u000e\u0010\u0013\u001a\u00020\u00128\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00148\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "", "fromOwner", "", Room.COLUMN_LAST_MSG, "isSecret", "Lua/k0;", "VideoPreview", "(Lcu/todus/android/data/db/entity/toDus/Attachment;ZLjava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "fileExist", "Landroid/net/Uri;", "uri", "thumbnail", "PreviewVideoShowIn", "(Landroidx/compose/ui/Modifier;ZLandroid/net/Uri;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Lcu/z17/views/videoPlayer/PlayerState;", "playerState", "Landroidx/media3/common/Player;", "player", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class VideoPreviewKt {
    /* JADX WARN: Code duplicated, block: B:104:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:109:0x030e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0326  */
    /* JADX WARN: Code duplicated, block: B:116:0x0364  */
    /* JADX WARN: Code duplicated, block: B:118:0x0368  */
    /* JADX WARN: Code duplicated, block: B:119:0x0394  */
    /* JADX WARN: Code duplicated, block: B:123:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:125:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:128:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:63:0x0122  */
    /* JADX WARN: Code duplicated, block: B:66:0x012e  */
    /* JADX WARN: Code duplicated, block: B:67:0x0132  */
    /* JADX WARN: Code duplicated, block: B:70:0x018e  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:76:0x01be  */
    /* JADX WARN: Code duplicated, block: B:79:0x0224  */
    /* JADX WARN: Code duplicated, block: B:81:0x023d  */
    /* JADX WARN: Code duplicated, block: B:82:0x024a  */
    /* JADX WARN: Code duplicated, block: B:85:0x025b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0270  */
    /* JADX WARN: Code duplicated, block: B:91:0x0285  */
    /* JADX WARN: Code duplicated, block: B:94:0x029a  */
    /* JADX WARN: Code duplicated, block: B:97:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:99:0x02d1  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PreviewVideoShowIn(Modifier modifier, final boolean z10, final Uri uri, String str, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        String str2;
        boolean z11;
        final Modifier modifier3;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        String str4;
        Modifier modifier5;
        String str5;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        Object objRememberedValue2;
        MutableState mutableState2;
        final Context context;
        lb.a constructor;
        Modifier.Companion companion2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        final MutableState mutableState3;
        boolean zChangedInstance;
        Object objRememberedValue6;
        boolean zChangedInstance2;
        Object objRememberedValue7;
        Object objRememberedValue8;
        final MutableState mutableState4;
        final MutableState mutableState5;
        Object objRememberedValue9;
        Object objRememberedValue10;
        Object objRememberedValue11;
        Object objRememberedValue12;
        Object objRememberedValue13;
        kotlin.jvm.internal.y.i(uri, "uri");
        Composer composerStartRestartGroup = composer.startRestartGroup(-908046878);
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
            i12 |= composerStartRestartGroup.changedInstance(uri) ? 256 : 128;
        }
        int i14 = i11 & 8;
        if (i14 == 0) {
            if ((i10 & 3072) == 0) {
                str2 = str;
                i12 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
            }
            if ((i12 & 1171) != 1170) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i14 != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-908046878, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.PreviewVideoShowIn (VideoPreview.kt:81)");
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-1920250555);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PlayerState(false, false, false, false, 0, 0, 0L, 0L, null, null, null, null, 4095, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    companion2 = Modifier.INSTANCE;
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                    List listE = va.v.e(new VideoPlayerMediaItem.StorageMediaItem(uri, null, null, 6, null));
                    RepeatMode repeatMode = RepeatMode.NONE;
                    PlayerState playerStatePreviewVideoShowIn$lambda$1 = PreviewVideoShowIn$lambda$1(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new VideoPreviewKt$PreviewVideoShowIn$1$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function1 = (Function1) ((sb.h) objRememberedValue3);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new VideoPreviewKt$PreviewVideoShowIn$1$2$1(mutableState, mutableState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function2 function2 = (Function2) ((sb.h) objRememberedValue4);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.u0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoPreviewKt.PreviewVideoShowIn$lambda$6$2$0(((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    modifier5 = modifier4;
                    Z17VideoPlayerKt.Z17VideoPlayer(modifierFillMaxSize$default, listE, true, true, false, false, null, 0L, 0L, repeatMode, 0.5f, function1, false, true, true, null, playerStatePreviewVideoShowIn$lambda$1, function2, (Function1) objRememberedValue5, null, 1, 0, composerStartRestartGroup, (VideoPlayerMediaItem.StorageMediaItem.$stable << 3) | 805506438, 113274294, 6, 2654672);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (PreviewVideoShowIn$lambda$1(mutableState).isPIP()) {
                        mutableState3 = mutableState2;
                        composerStartRestartGroup.startReplaceGroup(397759969);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1788336555);
                        Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                        PlayerState playerStatePreviewVideoShowIn$lambda$2 = PreviewVideoShowIn$lambda$1(mutableState);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            mutableState4 = mutableState2;
                            mutableState5 = mutableState;
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.x0
                                @Override // lb.a
                                public final Object invoke() {
                                    return VideoPreviewKt.PreviewVideoShowIn$lambda$6$3$0(mutableState5, mutableState4);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            mutableState4 = mutableState2;
                            mutableState5 = mutableState;
                        }
                        lb.a aVar = (lb.a) objRememberedValue8;
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue9 == companion.getEmpty()) {
                            objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.y0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return VideoPreviewKt.PreviewVideoShowIn$lambda$6$4$0(mutableState5, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        Function1 function3 = (Function1) objRememberedValue9;
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue10 == companion.getEmpty()) {
                            objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.z0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return VideoPreviewKt.PreviewVideoShowIn$lambda$6$5$0(mutableState4, ((Float) obj).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        Function1 function4 = (Function1) objRememberedValue10;
                        objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue11 == companion.getEmpty()) {
                            objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.a1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return VideoPreviewKt.PreviewVideoShowIn$lambda$6$6$0(mutableState5, (TrackElement) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                        }
                        Function1 function5 = (Function1) objRememberedValue11;
                        objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue12 == companion.getEmpty()) {
                            objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.b1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return VideoPreviewKt.PreviewVideoShowIn$lambda$6$7$0(mutableState5, (TrackElement) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                        }
                        Function1 function6 = (Function1) objRememberedValue12;
                        objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue13 == companion.getEmpty()) {
                            objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.c1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return VideoPreviewKt.PreviewVideoShowIn$lambda$6$8$0(mutableState5, (TrackElement) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                        }
                        mutableState3 = mutableState4;
                        PlayerScreenKt.PlayerControls(modifierFillMaxSize$default2, playerStatePreviewVideoShowIn$lambda$2, true, false, false, aVar, function3, function4, function5, function6, (Function1) objRememberedValue13, composerStartRestartGroup, 920350086, 6, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ua.k0 k0Var = ua.k0.f43947a;
                    zChangedInstance = composerStartRestartGroup.changedInstance(context);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new VideoPreviewKt$PreviewVideoShowIn$1$10$1(context, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue6, composerStartRestartGroup, 6);
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(context);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.d1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoPreviewKt.PreviewVideoShowIn$lambda$6$10$0(context, mutableState3, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                    str5 = str4;
                } else {
                    modifier5 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(-1916757506);
                    if (str4 != null || URLUtil.isHttpsUrl(str4)) {
                        str5 = str4;
                        if (str5 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1916433184);
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), str5, null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, null, composerStartRestartGroup, ((i12 >> 6) & 112) | 24582, 492);
                            str5 = str5;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1916238752);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1916687756);
                        str5 = str4;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, str5, composerStartRestartGroup, ((i12 << 15) & 234881024) | 24630, WebmConstants.MkvEbmlElement.VOID);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str5;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.e1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return VideoPreviewKt.PreviewVideoShowIn$lambda$7(modifier3, z10, uri, str3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        str2 = str;
        if ((i12 & 1171) != 1170) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            if (i13 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i14 != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-908046878, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.PreviewVideoShowIn (VideoPreview.kt:81)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-1920250555);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PlayerState(false, false, false, false, 0, 0, 0L, 0L, null, null, null, null, 4095, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                List listE2 = va.v.e(new VideoPlayerMediaItem.StorageMediaItem(uri, null, null, 6, null));
                RepeatMode repeatMode2 = RepeatMode.NONE;
                PlayerState playerStatePreviewVideoShowIn$lambda$3 = PreviewVideoShowIn$lambda$1(mutableState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new VideoPreviewKt$PreviewVideoShowIn$1$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function1 function7 = (Function1) ((sb.h) objRememberedValue3);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new VideoPreviewKt$PreviewVideoShowIn$1$2$1(mutableState, mutableState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function2 function8 = (Function2) ((sb.h) objRememberedValue4);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.u0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return VideoPreviewKt.PreviewVideoShowIn$lambda$6$2$0(((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                modifier5 = modifier4;
                Z17VideoPlayerKt.Z17VideoPlayer(modifierFillMaxSize$default3, listE2, true, true, false, false, null, 0L, 0L, repeatMode2, 0.5f, function7, false, true, true, null, playerStatePreviewVideoShowIn$lambda$3, function8, (Function1) objRememberedValue5, null, 1, 0, composerStartRestartGroup, (VideoPlayerMediaItem.StorageMediaItem.$stable << 3) | 805506438, 113274294, 6, 2654672);
                composerStartRestartGroup = composerStartRestartGroup;
                if (PreviewVideoShowIn$lambda$1(mutableState).isPIP()) {
                    composerStartRestartGroup.startReplaceGroup(-1788336555);
                    Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                    PlayerState playerStatePreviewVideoShowIn$lambda$4 = PreviewVideoShowIn$lambda$1(mutableState);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        mutableState4 = mutableState2;
                        mutableState5 = mutableState;
                        objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.x0
                            @Override // lb.a
                            public final Object invoke() {
                                return VideoPreviewKt.PreviewVideoShowIn$lambda$6$3$0(mutableState5, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        mutableState4 = mutableState2;
                        mutableState5 = mutableState;
                    }
                    lb.a aVar2 = (lb.a) objRememberedValue8;
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.y0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoPreviewKt.PreviewVideoShowIn$lambda$6$4$0(mutableState5, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    Function1 function9 = (Function1) objRememberedValue9;
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.z0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoPreviewKt.PreviewVideoShowIn$lambda$6$5$0(mutableState4, ((Float) obj).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    Function1 function10 = (Function1) objRememberedValue10;
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.a1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoPreviewKt.PreviewVideoShowIn$lambda$6$6$0(mutableState5, (TrackElement) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    Function1 function11 = (Function1) objRememberedValue11;
                    objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.b1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoPreviewKt.PreviewVideoShowIn$lambda$6$7$0(mutableState5, (TrackElement) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    }
                    Function1 function12 = (Function1) objRememberedValue12;
                    objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.c1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoPreviewKt.PreviewVideoShowIn$lambda$6$8$0(mutableState5, (TrackElement) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                    }
                    mutableState3 = mutableState4;
                    PlayerScreenKt.PlayerControls(modifierFillMaxSize$default4, playerStatePreviewVideoShowIn$lambda$4, true, false, false, aVar2, function9, function10, function11, function12, (Function1) objRememberedValue13, composerStartRestartGroup, 920350086, 6, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    mutableState3 = mutableState2;
                    composerStartRestartGroup.startReplaceGroup(397759969);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ua.k0 k0Var2 = ua.k0.f43947a;
                zChangedInstance = composerStartRestartGroup.changedInstance(context);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue6 = new VideoPreviewKt$PreviewVideoShowIn$1$10$1(context, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new VideoPreviewKt$PreviewVideoShowIn$1$10$1(context, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue6, composerStartRestartGroup, 6);
                zChangedInstance2 = composerStartRestartGroup.changedInstance(context);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.d1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return VideoPreviewKt.PreviewVideoShowIn$lambda$6$10$0(context, mutableState3, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.d1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return VideoPreviewKt.PreviewVideoShowIn$lambda$6$10$0(context, mutableState3, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                EffectsKt.DisposableEffect(k0Var2, (Function1) objRememberedValue7, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
                str5 = str4;
            } else {
                modifier5 = modifier4;
                composerStartRestartGroup.startReplaceGroup(-1916757506);
                if (str4 != null) {
                    str5 = str4;
                    if (str5 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1916433184);
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), str5, null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, null, composerStartRestartGroup, ((i12 >> 6) & 112) | 24582, 492);
                        str5 = str5;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1916238752);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else {
                    str5 = str4;
                    if (str5 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1916433184);
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), str5, null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, null, composerStartRestartGroup, ((i12 >> 6) & 112) | 24582, 492);
                        str5 = str5;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1916238752);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str5;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            str3 = str2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.e1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoPreviewKt.PreviewVideoShowIn$lambda$7(modifier3, z10, uri, str3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final PlayerState PreviewVideoShowIn$lambda$1(MutableState<PlayerState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Player PreviewVideoShowIn$lambda$4(MutableState<Player> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PreviewVideoShowIn$lambda$6$10$0(final Context context, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.VideoPreviewKt$PreviewVideoShowIn$lambda$6$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Z17InlineUtilsKt.findActivity(context).getWindow().clearFlags(128);
                Player playerPreviewVideoShowIn$lambda$4 = VideoPreviewKt.PreviewVideoShowIn$lambda$4(mutableState);
                if (playerPreviewVideoShowIn$lambda$4 != null) {
                    playerPreviewVideoShowIn$lambda$4.stop();
                }
                Player playerPreviewVideoShowIn$lambda$5 = VideoPreviewKt.PreviewVideoShowIn$lambda$4(mutableState);
                if (playerPreviewVideoShowIn$lambda$5 != null) {
                    playerPreviewVideoShowIn$lambda$5.release();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewVideoShowIn$lambda$6$2$0(boolean z10) {
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewVideoShowIn$lambda$6$3$0(MutableState mutableState, MutableState mutableState2) {
        if (PreviewVideoShowIn$lambda$1(mutableState).isPlaying()) {
            Player playerPreviewVideoShowIn$lambda$4 = PreviewVideoShowIn$lambda$4(mutableState2);
            if (playerPreviewVideoShowIn$lambda$4 != null) {
                playerPreviewVideoShowIn$lambda$4.pause();
            }
        } else if (PreviewVideoShowIn$lambda$1(mutableState).isPlaying() || PreviewVideoShowIn$lambda$1(mutableState).getPlaybackState() != 4) {
            Player playerPreviewVideoShowIn$lambda$5 = PreviewVideoShowIn$lambda$4(mutableState2);
            if (playerPreviewVideoShowIn$lambda$5 != null) {
                playerPreviewVideoShowIn$lambda$5.play();
            }
        } else {
            Player playerPreviewVideoShowIn$lambda$6 = PreviewVideoShowIn$lambda$4(mutableState2);
            if (playerPreviewVideoShowIn$lambda$6 != null) {
                playerPreviewVideoShowIn$lambda$6.seekTo(0L);
            }
            PreviewVideoShowIn$onCurrentTimeChanged(mutableState, 0L);
            Player playerPreviewVideoShowIn$lambda$7 = PreviewVideoShowIn$lambda$4(mutableState2);
            if (playerPreviewVideoShowIn$lambda$7 != null) {
                playerPreviewVideoShowIn$lambda$7.setPlayWhenReady(true);
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewVideoShowIn$lambda$6$4$0(MutableState mutableState, boolean z10) {
        PlayerState playerStatePreviewVideoShowIn$lambda$1 = PreviewVideoShowIn$lambda$1(mutableState);
        mutableState.setValue(playerStatePreviewVideoShowIn$lambda$1.copy((3583 & 1) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isFullscreen : z10, (3583 & 2) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPlaying : false, (3583 & 4) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isLoading : false, (3583 & 8) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPIP : false, (3583 & 16) != 0 ? playerStatePreviewVideoShowIn$lambda$1.playbackState : 0, (3583 & 32) != 0 ? playerStatePreviewVideoShowIn$lambda$1.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStatePreviewVideoShowIn$lambda$1.currentPosition : 0L, (3583 & 128) != 0 ? playerStatePreviewVideoShowIn$lambda$1.totalDuration : 0L, (3583 & 256) != 0 ? playerStatePreviewVideoShowIn$lambda$1.tripleTrackSave : null, (3583 & 512) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedSubsTrack : null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewVideoShowIn$lambda$6$5$0(MutableState mutableState, float f10) {
        Player playerPreviewVideoShowIn$lambda$4 = PreviewVideoShowIn$lambda$4(mutableState);
        if (playerPreviewVideoShowIn$lambda$4 != null) {
            playerPreviewVideoShowIn$lambda$4.seekTo((long) f10);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewVideoShowIn$lambda$6$6$0(MutableState mutableState, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        PlayerState playerStatePreviewVideoShowIn$lambda$1 = PreviewVideoShowIn$lambda$1(mutableState);
        mutableState.setValue(playerStatePreviewVideoShowIn$lambda$1.copy((3583 & 1) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isFullscreen : false, (3583 & 2) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPlaying : false, (3583 & 4) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isLoading : false, (3583 & 8) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPIP : false, (3583 & 16) != 0 ? playerStatePreviewVideoShowIn$lambda$1.playbackState : 0, (3583 & 32) != 0 ? playerStatePreviewVideoShowIn$lambda$1.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStatePreviewVideoShowIn$lambda$1.currentPosition : 0L, (3583 & 128) != 0 ? playerStatePreviewVideoShowIn$lambda$1.totalDuration : 0L, (3583 & 256) != 0 ? playerStatePreviewVideoShowIn$lambda$1.tripleTrackSave : null, (3583 & 512) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedVideoTrack : it, (3583 & 1024) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedSubsTrack : null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewVideoShowIn$lambda$6$7$0(MutableState mutableState, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        PlayerState playerStatePreviewVideoShowIn$lambda$1 = PreviewVideoShowIn$lambda$1(mutableState);
        mutableState.setValue(playerStatePreviewVideoShowIn$lambda$1.copy((3583 & 1) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isFullscreen : false, (3583 & 2) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPlaying : false, (3583 & 4) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isLoading : false, (3583 & 8) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPIP : false, (3583 & 16) != 0 ? playerStatePreviewVideoShowIn$lambda$1.playbackState : 0, (3583 & 32) != 0 ? playerStatePreviewVideoShowIn$lambda$1.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStatePreviewVideoShowIn$lambda$1.currentPosition : 0L, (3583 & 128) != 0 ? playerStatePreviewVideoShowIn$lambda$1.totalDuration : 0L, (3583 & 256) != 0 ? playerStatePreviewVideoShowIn$lambda$1.tripleTrackSave : null, (3583 & 512) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedAudioTrack : it, (3583 & 2048) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedSubsTrack : null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewVideoShowIn$lambda$6$8$0(MutableState mutableState, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        PlayerState playerStatePreviewVideoShowIn$lambda$1 = PreviewVideoShowIn$lambda$1(mutableState);
        mutableState.setValue(playerStatePreviewVideoShowIn$lambda$1.copy((3583 & 1) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isFullscreen : false, (3583 & 2) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPlaying : false, (3583 & 4) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isLoading : false, (3583 & 8) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPIP : false, (3583 & 16) != 0 ? playerStatePreviewVideoShowIn$lambda$1.playbackState : 0, (3583 & 32) != 0 ? playerStatePreviewVideoShowIn$lambda$1.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStatePreviewVideoShowIn$lambda$1.currentPosition : 0L, (3583 & 128) != 0 ? playerStatePreviewVideoShowIn$lambda$1.totalDuration : 0L, (3583 & 256) != 0 ? playerStatePreviewVideoShowIn$lambda$1.tripleTrackSave : null, (3583 & 512) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedSubsTrack : it));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewVideoShowIn$lambda$7(Modifier modifier, boolean z10, Uri uri, String str, int i10, int i11, Composer composer, int i12) {
        PreviewVideoShowIn(modifier, z10, uri, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewVideoShowIn$onCurrentTimeChanged(MutableState<PlayerState> mutableState, long j10) {
        PlayerState playerStatePreviewVideoShowIn$lambda$1 = PreviewVideoShowIn$lambda$1(mutableState);
        mutableState.setValue(playerStatePreviewVideoShowIn$lambda$1.copy((3583 & 1) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isFullscreen : false, (3583 & 2) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPlaying : false, (3583 & 4) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isLoading : false, (3583 & 8) != 0 ? playerStatePreviewVideoShowIn$lambda$1.isPIP : false, (3583 & 16) != 0 ? playerStatePreviewVideoShowIn$lambda$1.playbackState : 0, (3583 & 32) != 0 ? playerStatePreviewVideoShowIn$lambda$1.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStatePreviewVideoShowIn$lambda$1.currentPosition : j10, (3583 & 128) != 0 ? playerStatePreviewVideoShowIn$lambda$1.totalDuration : 0L, (3583 & 256) != 0 ? playerStatePreviewVideoShowIn$lambda$1.tripleTrackSave : null, (3583 & 512) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerStatePreviewVideoShowIn$lambda$1.selectedSubsTrack : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewVideoShowIn$updatePlayerState(MutableState<PlayerState> mutableState, MutableState<Player> mutableState2, PlayerState playerState, Player player) {
        mutableState.setValue(playerState);
        mutableState2.setValue(player);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VideoPreview(final Attachment attachment, final boolean z10, final String msgId, final boolean z11, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(attachment, "attachment");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        Composer composerStartRestartGroup = composer.startRestartGroup(1788598570);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(attachment) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(msgId) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1788598570, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.VideoPreview (VideoPreview.kt:35)");
            }
            if (!z10 || attachment.getState() == 4 || attachment.getState() == 5) {
                composerStartRestartGroup.startReplaceGroup(776508128);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                DownloadableSize downloadableSize = DownloadableSize.BIG;
                String id2 = attachment.getId();
                Content content = attachment.getContent();
                kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VideoContent");
                DownloadableKt.Downloadable(modifierFillMaxSize$default, false, downloadableSize, id2, ((VideoContent) content).getFolderPath(!z11).getSecond(), 2, (VideoContent) attachment.getContent(), null, false, null, ComposableLambdaKt.rememberComposableLambda(1725257070, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.v0
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return VideoPreviewKt.VideoPreview$lambda$1(attachment, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 197046, 6, 896);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(775960265);
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                UploadableSize uploadableSize = UploadableSize.REGULAR;
                String id3 = attachment.getId();
                Content content2 = attachment.getContent();
                kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VideoContent");
                UploadableKt.Uploadable(modifierFillMaxSize$default2, true, uploadableSize, msgId, id3, 2, (VideoContent) content2, null, false, null, ComposableLambdaKt.rememberComposableLambda(436109182, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.f1
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return VideoPreviewKt.VideoPreview$lambda$0(attachment, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i11 << 3) & 7168) | 197046, 6, 896);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.w0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoPreviewKt.VideoPreview$lambda$2(attachment, z10, msgId, z11, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 VideoPreview$lambda$0(Attachment attachment, Object unused$var$, boolean z10, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(436109182, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.VideoPreview.<anonymous> (VideoPreview.kt:48)");
        }
        PreviewVideoShowIn(null, true, Uri.parse(((VideoContent) attachment.getContent()).getPath()), ((VideoContent) attachment.getContent()).getThumbnail(), composer, 48, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 VideoPreview$lambda$1(Attachment attachment, Object unused$var$, boolean z10, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1725257070, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.VideoPreview.<anonymous> (VideoPreview.kt:66)");
        }
        PreviewVideoShowIn(null, z10 && !le.d0.q0(((VideoContent) attachment.getContent()).getPath()), Uri.parse(((VideoContent) attachment.getContent()).getPath()), ((VideoContent) attachment.getContent()).getThumbnail(), composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VideoPreview$lambda$2(Attachment attachment, boolean z10, String str, boolean z11, int i10, Composer composer, int i11) {
        VideoPreview(attachment, z10, str, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
