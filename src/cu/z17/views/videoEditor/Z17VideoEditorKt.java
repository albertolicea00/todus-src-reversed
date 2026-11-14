package cu.z17.views.videoEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.OptIn;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.x;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.compose.BackHandlerKt;
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
import cu.todus.android.data.rest.entity.NewEntity;
import cu.z17.views.imageEditor.Z17EditorState;
import cu.z17.views.imageEditor.Z17ImageEditorKt;
import cu.z17.views.imageEditor.sections.EditorAnimateVisibilityKt;
import cu.z17.views.videoEditor.sections.cutter.CutterBottomBarKt;
import cu.z17.views.videoEditor.sections.cutter.CutterTopBarKt;
import cu.z17.views.videoEditor.sections.viewer.ViewerKt;
import cu.z17.views.videoEditor.sections.viewer.ViewerTopBarKt;
import cu.z17.views.videoPlayer.PlayerState;
import cu.z17.views.videoPlayer.controller.ControllerUiKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a{\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006#²\u0006\u000e\u0010\u0014\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u00020\u00168\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\nX\u008a\u0084\u0002²\u0006\f\u0010\u001b\u001a\u00020\b8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\u001c8\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\n@\nX\u008a\u008e\u0002²\u0006\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", NewEntity.NEWS_CONFIG_SOURCE, "", TypedValues.TransitionType.S_DURATION, "videoPathToSave", "Lkotlin/Function1;", "", "Lua/k0;", "onViewState", "Lkotlin/Function0;", "onError", "onEdited", "Lcu/z17/views/videoEditor/VideoEditorViewModel;", "viewModel", "Lcu/z17/views/videoEditor/VideoEditorConfigurations;", "configs", "Z17VideoEditor", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JLjava/lang/String;Lkotlin/jvm/functions/Function1;Llb/a;Lkotlin/jvm/functions/Function1;Lcu/z17/views/videoEditor/VideoEditorViewModel;Lcu/z17/views/videoEditor/VideoEditorConfigurations;Landroidx/compose/runtime/Composer;II)V", "currentSource", "currentDuration", "Lcu/z17/views/imageEditor/Z17EditorState;", "currentState", "", "Landroid/graphics/Bitmap;", "thumbnails", "isOnView", "Lcu/z17/views/videoPlayer/PlayerState;", "playerState", "Landroidx/media3/common/Player;", "player", "Lrb/b;", "", "cutPoints", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17VideoEditorKt {
    /* JADX WARN: Code duplicated, block: B:114:0x01af  */
    /* JADX WARN: Code duplicated, block: B:117:0x01de  */
    /* JADX WARN: Code duplicated, block: B:120:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:126:0x021b  */
    /* JADX WARN: Code duplicated, block: B:129:0x024a  */
    /* JADX WARN: Code duplicated, block: B:132:0x0260  */
    /* JADX WARN: Code duplicated, block: B:135:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:138:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:139:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:142:0x0303  */
    /* JADX WARN: Code duplicated, block: B:145:0x0319  */
    /* JADX WARN: Code duplicated, block: B:148:0x035e  */
    /* JADX WARN: Code duplicated, block: B:151:0x036a  */
    /* JADX WARN: Code duplicated, block: B:152:0x036e  */
    /* JADX WARN: Code duplicated, block: B:157:0x039d  */
    /* JADX WARN: Code duplicated, block: B:162:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:167:0x0439  */
    /* JADX WARN: Code duplicated, block: B:170:0x0475  */
    /* JADX WARN: Code duplicated, block: B:173:0x0481  */
    /* JADX WARN: Code duplicated, block: B:174:0x0485  */
    /* JADX WARN: Code duplicated, block: B:179:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:182:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:185:0x0500  */
    /* JADX WARN: Code duplicated, block: B:187:0x050e  */
    /* JADX WARN: Code duplicated, block: B:192:0x054a  */
    /* JADX WARN: Code duplicated, block: B:195:0x0560  */
    /* JADX WARN: Code duplicated, block: B:199:0x0576  */
    /* JADX WARN: Code duplicated, block: B:202:0x0589  */
    /* JADX WARN: Code duplicated, block: B:205:0x059e  */
    /* JADX WARN: Code duplicated, block: B:206:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:209:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:210:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:217:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:220:0x05df  */
    /* JADX WARN: Code duplicated, block: B:221:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:225:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:232:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:235:0x061a  */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v6, types: [boolean, int] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @OptIn(markerClass = {UnstableApi.class})
    @Composable
    public static final void Z17VideoEditor(Modifier modifier, final String str, final long j10, final String videoPathToSave, Function1 function1, final lb.a onError, final Function1 onEdited, VideoEditorViewModel videoEditorViewModel, VideoEditorConfigurations videoEditorConfigurations, Composer composer, final int i10, final int i11) {
        final Modifier modifier2;
        int i12;
        int i13;
        VideoEditorViewModel videoEditorViewModel2;
        VideoEditorConfigurations videoEditorConfigurations2;
        Composer composer2;
        final VideoEditorConfigurations videoEditorConfigurations3;
        final VideoEditorViewModel videoEditorViewModel3;
        boolean z10;
        int i14;
        Modifier modifier3;
        VideoEditorViewModel videoEditorViewModel4;
        ?? r10;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        final MutableLongState mutableLongState;
        int i15;
        final State stateCollectAsStateWithLifecycle;
        Object objRememberedValue3;
        State state;
        Object objRememberedValue4;
        int i16;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Object objRememberedValue5;
        Object objRememberedValue6;
        int currentCompositeKeyHash2;
        lb.a constructor2;
        Composer composerM5176constructorimpl2;
        Function2 setCompositeKeyHash2;
        final VideoEditorViewModel videoEditorViewModel5;
        final VideoEditorConfigurations videoEditorConfigurations4;
        boolean zChanged;
        Object objRememberedValue7;
        boolean zChanged2;
        Object objRememberedValue8;
        int currentCompositeKeyHash3;
        lb.a constructor3;
        Composer composerM5176constructorimpl3;
        Function2 setCompositeKeyHash3;
        Object objRememberedValue9;
        boolean zChanged3;
        Object objRememberedValue10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Object objRememberedValue11;
        boolean z15;
        boolean z16;
        Object objRememberedValue12;
        VideoEditorConfigurations videoEditorConfigurations5;
        boolean zChangedInstance;
        Object objRememberedValue13;
        boolean z17;
        String source = str;
        Function1 onViewState = function1;
        y.i(source, "source");
        y.i(videoPathToSave, "videoPathToSave");
        y.i(onViewState, "onViewState");
        y.i(onError, "onError");
        y.i(onEdited, "onEdited");
        Composer composerStartRestartGroup = composer.startRestartGroup(381363770);
        int i17 = i11 & 1;
        if (i17 != 0) {
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
            i12 |= composerStartRestartGroup.changed(source) ? 32 : 16;
        }
        int i18 = i12;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 = i18 | (composerStartRestartGroup.changed(j10) ? 256 : 128);
        } else {
            i13 = i18;
        }
        if ((i10 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(videoPathToSave) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onViewState) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onError) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onEdited) ? 1048576 : 524288;
        }
        if ((12582912 & i10) == 0) {
            if ((i11 & 128) == 0) {
                videoEditorViewModel2 = videoEditorViewModel;
                int i19 = composerStartRestartGroup.changedInstance(videoEditorViewModel2) ? 8388608 : 4194304;
                i13 |= i19;
            } else {
                videoEditorViewModel2 = videoEditorViewModel;
            }
            i13 |= i19;
        } else {
            videoEditorViewModel2 = videoEditorViewModel;
        }
        int i20 = i11 & 256;
        if (i20 != 0) {
            i13 |= 100663296;
            videoEditorConfigurations2 = videoEditorConfigurations;
        } else {
            videoEditorConfigurations2 = videoEditorConfigurations;
            if ((i10 & 100663296) == 0) {
                i13 |= composerStartRestartGroup.changed(videoEditorConfigurations2) ? 67108864 : 33554432;
            }
        }
        int i21 = i13;
        if (composerStartRestartGroup.shouldExecute((i21 & 38347923) != 38347922, i21 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier modifier4 = i17 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i11 & 128) != 0) {
                    int i22 = i21 & 112;
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    z10 = false;
                    i21 &= -29360129;
                    videoEditorViewModel2 = (VideoEditorViewModel) ViewModelKt.viewModel(z0.b(VideoEditorViewModel.class), current, source, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, (i22 << 3) & 896, 0);
                } else {
                    z10 = false;
                }
                if (i20 != 0) {
                    videoEditorViewModel4 = videoEditorViewModel2;
                    i14 = i21;
                    modifier3 = modifier4;
                    videoEditorConfigurations2 = new VideoEditorConfigurations(false, false, 0L, 7, null);
                    r10 = z10;
                } else {
                    i14 = i21;
                    modifier3 = modifier4;
                    z17 = z10;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(381363770, i14, -1, "cu.z17.views.videoEditor.Z17VideoEditor (Z17VideoEditor.kt:50)");
                }
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), r10);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r10);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(source, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotLongStateKt.mutableLongStateOf(j10);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableLongState = (MutableLongState) objRememberedValue2;
                i15 = i14;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(videoEditorViewModel4.getCurrentState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(videoEditorViewModel4.getThumbnails().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.videoEditor.o
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$9$lambda$8(stateCollectAsStateWithLifecycle));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                state = (State) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    i16 = 2;
                    snapshotMutationPolicy = null;
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PlayerState(false, false, false, false, 0, 0, 0L, 0L, null, null, null, null, 4095, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    i16 = 2;
                    snapshotMutationPolicy = null;
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(snapshotMutationPolicy, snapshotMutationPolicy, i16, snapshotMutationPolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(rb.j.b(0.0f, mutableLongState.getLongValue()), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue6;
                Modifier.Companion companion4 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion4, 0.0f, 1, snapshotMutationPolicy);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Uri uriFromFile = Uri.fromFile(new File(Z17VideoEditor$lambda$54$lambda$1(mutableState)));
                composer2 = composerStartRestartGroup;
                videoEditorViewModel5 = videoEditorViewModel4;
                Modifier modifier5 = modifier3;
                videoEditorConfigurations4 = videoEditorConfigurations2;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-139233490, true, new Function3() { // from class: cu.z17.views.videoEditor.q
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$25(str, videoEditorViewModel5, j10, onEdited, videoEditorConfigurations4, mutableState, mutableState3, mutableState4, (Uri) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                zChanged = composer2.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue7 = composer2.rememberedValue();
                if (zChanged || objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.z17.views.videoEditor.r
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$27$lambda$26(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(uriFromFile, composableLambdaRememberComposableLambda, (lb.a) objRememberedValue7, composer2, 48);
                Uri uriFromFile2 = Uri.fromFile(new File(str));
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-8174121, true, new Function3() { // from class: cu.z17.views.videoEditor.s
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$30(videoEditorConfigurations4, mutableState4, mutableLongState, stateCollectAsStateWithLifecycle2, mutableState3, (Uri) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                zChanged2 = composer2.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue8 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new lb.a() { // from class: cu.z17.views.videoEditor.t
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$32$lambda$31(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(uriFromFile2, composableLambdaRememberComposableLambda2, (lb.a) objRememberedValue8, composer2, 48);
                Modifier modifierA = x.a(columnScopeInstance, companion4, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierA);
                constructor3 = companion3.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl3.getInserting() || !y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
                Uri uriFromFile3 = Uri.fromFile(new File(str));
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(857297896, true, new Function3() { // from class: cu.z17.views.videoEditor.b
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$39$lambda$36(mutableState4, mutableState2, mutableState3, (Uri) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                objRememberedValue9 = composer2.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new lb.a() { // from class: cu.z17.views.videoEditor.c
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$39$lambda$38$lambda$37());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(uriFromFile3, composableLambdaRememberComposableLambda3, (lb.a) objRememberedValue9, composer2, 432);
                if (Z17VideoEditor$lambda$54$lambda$6(stateCollectAsStateWithLifecycle) == Z17EditorState.LOADING) {
                    composer2.startReplaceGroup(-1465026055);
                    Z17ImageEditorKt.Loading(composer2, 0);
                } else {
                    composer2.startReplaceGroup(-1471494422);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                Uri uriFromFile4 = Uri.fromFile(new File(str));
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(862647478, true, new Function3() { // from class: cu.z17.views.videoEditor.d
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$46(videoEditorViewModel5, context, videoPathToSave, onEdited, mutableState4, mutableLongState, mutableState, (Uri) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                zChanged3 = composer2.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue10 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.z17.views.videoEditor.e
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$48$lambda$47(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                EditorAnimateVisibilityKt.EditorAnimateVisibility(uriFromFile4, composableLambdaRememberComposableLambda4, (lb.a) objRememberedValue10, composer2, 48);
                composer2.endNode();
                if (Z17VideoEditor$lambda$54$lambda$10(state)) {
                    z11 = true;
                    composer2.startReplaceGroup(1703586350);
                } else {
                    composer2.startReplaceGroup(1856331051);
                    zChangedInstance = composer2.changedInstance(videoEditorViewModel5);
                    objRememberedValue13 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = new lb.a() { // from class: cu.z17.views.videoEditor.f
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$51$lambda$50(videoEditorViewModel5);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue13);
                    }
                    z11 = true;
                    BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue13, composer2, 0, 1);
                }
                composer2.endReplaceGroup();
                Z17EditorState z17EditorStateZ17VideoEditor$lambda$54$lambda$6 = Z17VideoEditor$lambda$54$lambda$6(stateCollectAsStateWithLifecycle);
                if ((i15 & 57344) == 16384) {
                    z12 = z11;
                } else {
                    z12 = false;
                }
                boolean zChanged4 = z12 | composer2.changed(stateCollectAsStateWithLifecycle);
                if ((i15 & 458752) == 131072) {
                    z13 = z11;
                } else {
                    z13 = false;
                }
                z14 = zChanged4 | z13;
                objRememberedValue11 = composer2.rememberedValue();
                if (!z14 || objRememberedValue11 == companion.getEmpty()) {
                    onViewState = function1;
                    objRememberedValue11 = new Z17VideoEditorKt$Z17VideoEditor$1$3$1(onViewState, onError, stateCollectAsStateWithLifecycle, null);
                    composer2.updateRememberedValue(objRememberedValue11);
                } else {
                    onViewState = function1;
                }
                EffectsKt.LaunchedEffect(z17EditorStateZ17VideoEditor$lambda$54$lambda$6, (Function2) objRememberedValue11, composer2, 0);
                k0 k0Var = k0.f43947a;
                boolean zChangedInstance2 = composer2.changedInstance(videoEditorViewModel5);
                if ((i15 & 112) == 32) {
                    z15 = z11;
                } else {
                    z15 = false;
                }
                boolean z18 = zChangedInstance2 | z15;
                if ((i15 & 234881024) != 67108864) {
                    z11 = false;
                }
                z16 = z18 | z11;
                objRememberedValue12 = composer2.rememberedValue();
                if (!z16 || objRememberedValue12 == companion.getEmpty()) {
                    videoEditorConfigurations5 = videoEditorConfigurations4;
                    Z17VideoEditorKt$Z17VideoEditor$1$4$1 z17VideoEditorKt$Z17VideoEditor$1$4$1 = new Z17VideoEditorKt$Z17VideoEditor$1$4$1(videoEditorViewModel5, str, mutableLongState, videoEditorConfigurations5, null);
                    composer2.updateRememberedValue(z17VideoEditorKt$Z17VideoEditor$1$4$1);
                    objRememberedValue12 = z17VideoEditorKt$Z17VideoEditor$1$4$1;
                } else {
                    videoEditorConfigurations5 = videoEditorConfigurations4;
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue12, composer2, 6);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                videoEditorViewModel3 = videoEditorViewModel5;
                videoEditorConfigurations3 = videoEditorConfigurations5;
                modifier2 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 128) != 0) {
                    i21 &= -29360129;
                }
                modifier3 = modifier2;
                source = source;
                z17 = false;
                i14 = i21;
            }
            videoEditorViewModel4 = videoEditorViewModel2;
            r10 = z17;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(381363770, i14, -1, "cu.z17.views.videoEditor.Z17VideoEditor (Z17VideoEditor.kt:50)");
            }
            Alignment.Companion companion5 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getTopStart(), r10);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r10);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion6.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion6.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion6.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(source, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotLongStateKt.mutableLongStateOf(j10);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableLongState = (MutableLongState) objRememberedValue2;
            i15 = i14;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(videoEditorViewModel4.getCurrentState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(videoEditorViewModel4.getThumbnails().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.videoEditor.o
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$9$lambda$8(stateCollectAsStateWithLifecycle));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            state = (State) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                i16 = 2;
                snapshotMutationPolicy = null;
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PlayerState(false, false, false, false, 0, 0, 0L, 0L, null, null, null, null, 4095, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                i16 = 2;
                snapshotMutationPolicy = null;
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(snapshotMutationPolicy, snapshotMutationPolicy, i16, snapshotMutationPolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue5;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(rb.j.b(0.0f, mutableLongState.getLongValue()), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue6;
            Modifier.Companion companion7 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion7, 0.0f, 1, snapshotMutationPolicy);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion5.getStart(), composerStartRestartGroup, 0);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
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
            composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion6.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap5, companion6.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion6.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting()) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier5, companion6.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            Uri uriFromFile5 = Uri.fromFile(new File(Z17VideoEditor$lambda$54$lambda$1(mutableState5)));
            composer2 = composerStartRestartGroup;
            videoEditorViewModel5 = videoEditorViewModel4;
            Modifier modifier6 = modifier3;
            videoEditorConfigurations4 = videoEditorConfigurations2;
            ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-139233490, true, new Function3() { // from class: cu.z17.views.videoEditor.q
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$25(str, videoEditorViewModel5, j10, onEdited, videoEditorConfigurations4, mutableState5, mutableState7, mutableState8, (Uri) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            zChanged = composer2.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue7 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue7 = new lb.a() { // from class: cu.z17.views.videoEditor.r
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$27$lambda$26(stateCollectAsStateWithLifecycle));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new lb.a() { // from class: cu.z17.views.videoEditor.r
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$27$lambda$26(stateCollectAsStateWithLifecycle));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(uriFromFile5, composableLambdaRememberComposableLambda5, (lb.a) objRememberedValue7, composer2, 48);
            Uri uriFromFile6 = Uri.fromFile(new File(str));
            ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-8174121, true, new Function3() { // from class: cu.z17.views.videoEditor.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$30(videoEditorConfigurations4, mutableState8, mutableLongState, stateCollectAsStateWithLifecycle3, mutableState7, (Uri) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            zChanged2 = composer2.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue8 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue8 = new lb.a() { // from class: cu.z17.views.videoEditor.t
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$32$lambda$31(stateCollectAsStateWithLifecycle));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new lb.a() { // from class: cu.z17.views.videoEditor.t
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$32$lambda$31(stateCollectAsStateWithLifecycle));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue8);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(uriFromFile6, composableLambdaRememberComposableLambda6, (lb.a) objRememberedValue8, composer2, 48);
            Modifier modifierA2 = x.a(columnScopeInstance2, companion7, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getTopStart(), false);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierA2);
            constructor3 = companion6.getConstructor();
            if (!defpackage.r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy4, companion6.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = companion6.getSetCompositeKeyHash();
            if (composerM5176constructorimpl3.getInserting()) {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier6, companion6.getSetModifier());
            Uri uriFromFile7 = Uri.fromFile(new File(str));
            ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(857297896, true, new Function3() { // from class: cu.z17.views.videoEditor.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$39$lambda$36(mutableState8, mutableState6, mutableState7, (Uri) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            objRememberedValue9 = composer2.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.z17.views.videoEditor.c
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$39$lambda$38$lambda$37());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(uriFromFile7, composableLambdaRememberComposableLambda7, (lb.a) objRememberedValue9, composer2, 432);
            if (Z17VideoEditor$lambda$54$lambda$6(stateCollectAsStateWithLifecycle) == Z17EditorState.LOADING) {
                composer2.startReplaceGroup(-1465026055);
                Z17ImageEditorKt.Loading(composer2, 0);
            } else {
                composer2.startReplaceGroup(-1471494422);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            Uri uriFromFile8 = Uri.fromFile(new File(str));
            ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(862647478, true, new Function3() { // from class: cu.z17.views.videoEditor.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$46(videoEditorViewModel5, context2, videoPathToSave, onEdited, mutableState8, mutableLongState, mutableState5, (Uri) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            zChanged3 = composer2.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue10 = composer2.rememberedValue();
            if (zChanged3) {
                objRememberedValue10 = new lb.a() { // from class: cu.z17.views.videoEditor.e
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$48$lambda$47(stateCollectAsStateWithLifecycle));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new lb.a() { // from class: cu.z17.views.videoEditor.e
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$48$lambda$47(stateCollectAsStateWithLifecycle));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue10);
            }
            EditorAnimateVisibilityKt.EditorAnimateVisibility(uriFromFile8, composableLambdaRememberComposableLambda8, (lb.a) objRememberedValue10, composer2, 48);
            composer2.endNode();
            if (Z17VideoEditor$lambda$54$lambda$10(state)) {
                composer2.startReplaceGroup(1856331051);
                zChangedInstance = composer2.changedInstance(videoEditorViewModel5);
                objRememberedValue13 = composer2.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue13 = new lb.a() { // from class: cu.z17.views.videoEditor.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$51$lambda$50(videoEditorViewModel5);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                } else {
                    objRememberedValue13 = new lb.a() { // from class: cu.z17.views.videoEditor.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$51$lambda$50(videoEditorViewModel5);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                }
                z11 = true;
                BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue13, composer2, 0, 1);
            } else {
                z11 = true;
                composer2.startReplaceGroup(1703586350);
            }
            composer2.endReplaceGroup();
            Z17EditorState z17EditorStateZ17VideoEditor$lambda$54$lambda$7 = Z17VideoEditor$lambda$54$lambda$6(stateCollectAsStateWithLifecycle);
            if ((i15 & 57344) == 16384) {
                z12 = z11;
            } else {
                z12 = false;
            }
            boolean zChanged5 = z12 | composer2.changed(stateCollectAsStateWithLifecycle);
            if ((i15 & 458752) == 131072) {
                z13 = z11;
            } else {
                z13 = false;
            }
            z14 = zChanged5 | z13;
            objRememberedValue11 = composer2.rememberedValue();
            if (z14) {
                onViewState = function1;
                objRememberedValue11 = new Z17VideoEditorKt$Z17VideoEditor$1$3$1(onViewState, onError, stateCollectAsStateWithLifecycle, null);
                composer2.updateRememberedValue(objRememberedValue11);
            } else {
                onViewState = function1;
                objRememberedValue11 = new Z17VideoEditorKt$Z17VideoEditor$1$3$1(onViewState, onError, stateCollectAsStateWithLifecycle, null);
                composer2.updateRememberedValue(objRememberedValue11);
            }
            EffectsKt.LaunchedEffect(z17EditorStateZ17VideoEditor$lambda$54$lambda$7, (Function2) objRememberedValue11, composer2, 0);
            k0 k0Var2 = k0.f43947a;
            boolean zChangedInstance3 = composer2.changedInstance(videoEditorViewModel5);
            if ((i15 & 112) == 32) {
                z15 = z11;
            } else {
                z15 = false;
            }
            boolean z19 = zChangedInstance3 | z15;
            if ((i15 & 234881024) != 67108864) {
                z11 = false;
            }
            z16 = z19 | z11;
            objRememberedValue12 = composer2.rememberedValue();
            if (z16) {
                videoEditorConfigurations5 = videoEditorConfigurations4;
                Z17VideoEditorKt$Z17VideoEditor$1$4$1 z17VideoEditorKt$Z17VideoEditor$1$4$2 = new Z17VideoEditorKt$Z17VideoEditor$1$4$1(videoEditorViewModel5, str, mutableLongState, videoEditorConfigurations5, null);
                composer2.updateRememberedValue(z17VideoEditorKt$Z17VideoEditor$1$4$2);
                objRememberedValue12 = z17VideoEditorKt$Z17VideoEditor$1$4$2;
            } else {
                videoEditorConfigurations5 = videoEditorConfigurations4;
                Z17VideoEditorKt$Z17VideoEditor$1$4$1 z17VideoEditorKt$Z17VideoEditor$1$4$3 = new Z17VideoEditorKt$Z17VideoEditor$1$4$1(videoEditorViewModel5, str, mutableLongState, videoEditorConfigurations5, null);
                composer2.updateRememberedValue(z17VideoEditorKt$Z17VideoEditor$1$4$3);
                objRememberedValue12 = z17VideoEditorKt$Z17VideoEditor$1$4$3;
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue12, composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            videoEditorViewModel3 = videoEditorViewModel5;
            videoEditorConfigurations3 = videoEditorConfigurations5;
            modifier2 = modifier6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            videoEditorConfigurations3 = videoEditorConfigurations2;
            videoEditorViewModel3 = videoEditorViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function2 = onViewState;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videoEditor.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$55(modifier2, str, j10, videoPathToSave, function2, onError, onEdited, videoEditorViewModel3, videoEditorConfigurations3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String Z17VideoEditor$lambda$54$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean Z17VideoEditor$lambda$54$lambda$10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final PlayerState Z17VideoEditor$lambda$54$lambda$12(MutableState<PlayerState> mutableState) {
        return mutableState.getValue();
    }

    private static final Player Z17VideoEditor$lambda$54$lambda$15(MutableState<Player> mutableState) {
        return mutableState.getValue();
    }

    private static final rb.b Z17VideoEditor$lambda$54$lambda$18(MutableState<rb.b> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$25(final String str, final VideoEditorViewModel videoEditorViewModel, final long j10, final Function1 function1, VideoEditorConfigurations videoEditorConfigurations, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Uri it, Composer composer, int i10) {
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-139233490, i10, -1, "cu.z17.views.videoEditor.Z17VideoEditor.<anonymous>.<anonymous>.<anonymous> (Z17VideoEditor.kt:94)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        boolean z10 = !y.d(Z17VideoEditor$lambda$54$lambda$1(mutableState), str);
        boolean zChangedInstance = composer.changedInstance(videoEditorViewModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.videoEditor.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$25$lambda$21$lambda$20(videoEditorViewModel, mutableState2, (Z17EditorState) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function2 = (Function1) objRememberedValue;
        boolean zChanged = composer.changed(j10) | composer.changedInstance(videoEditorViewModel) | composer.changed(str) | composer.changed(function1);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            lb.a aVar = new lb.a() { // from class: cu.z17.views.videoEditor.h
                @Override // lb.a
                public final Object invoke() {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$25$lambda$24$lambda$23(j10, videoEditorViewModel, mutableState3, mutableState, str, function1);
                }
            };
            composer.updateRememberedValue(aVar);
            objRememberedValue2 = aVar;
        }
        ViewerTopBarKt.ViewerTopBar(modifierSafeContentPadding, z10, function2, (lb.a) objRememberedValue2, videoEditorConfigurations, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$25$lambda$21$lambda$20(VideoEditorViewModel videoEditorViewModel, MutableState mutableState, Z17EditorState it) {
        y.i(it, "it");
        videoEditorViewModel.requestState(it);
        Player playerZ17VideoEditor$lambda$54$lambda$15 = Z17VideoEditor$lambda$54$lambda$15(mutableState);
        if (playerZ17VideoEditor$lambda$54$lambda$15 != null) {
            playerZ17VideoEditor$lambda$54$lambda$15.pause();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$25$lambda$24$lambda$23(long j10, final VideoEditorViewModel videoEditorViewModel, MutableState mutableState, final MutableState mutableState2, final String str, final Function1 function1) {
        mutableState.setValue(rb.j.b(0.0f, j10));
        videoEditorViewModel.cancelChanges(Z17VideoEditor$lambda$54$lambda$1(mutableState2), new lb.a() { // from class: cu.z17.views.videoEditor.l
            @Override // lb.a
            public final Object invoke() {
                return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$25$lambda$24$lambda$23$lambda$22(str, function1, videoEditorViewModel, mutableState2);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$25$lambda$24$lambda$23$lambda$22(String str, Function1 function1, VideoEditorViewModel videoEditorViewModel, MutableState mutableState) {
        mutableState.setValue(str);
        function1.invoke(Boolean.FALSE);
        videoEditorViewModel.requestState(Z17EditorState.VIEW);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17VideoEditor$lambda$54$lambda$49$lambda$27$lambda$26(State state) {
        return Z17VideoEditor$lambda$54$lambda$6(state) == Z17EditorState.VIEW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$30(VideoEditorConfigurations videoEditorConfigurations, final MutableState mutableState, MutableLongState mutableLongState, State state, final MutableState mutableState2, Uri it, Composer composer, int i10) {
        Composer composer2;
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-8174121, i10, -1, "cu.z17.views.videoEditor.Z17VideoEditor.<anonymous>.<anonymous>.<anonymous> (Z17VideoEditor.kt:119)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        rb.b bVarZ17VideoEditor$lambda$54$lambda$18 = Z17VideoEditor$lambda$54$lambda$18(mutableState);
        float longValue = mutableLongState.getLongValue();
        List<Bitmap> listZ17VideoEditor$lambda$54$lambda$7 = Z17VideoEditor$lambda$54$lambda$7(state);
        long forceCrop = videoEditorConfigurations.getForceCrop();
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: cu.z17.views.videoEditor.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$30$lambda$29$lambda$28(mutableState, mutableState2, (rb.b) obj);
                }
            };
            composer2 = composer;
            composer2.updateRememberedValue(objRememberedValue);
        } else {
            composer2 = composer;
        }
        CutterTopBarKt.CutterTopBar(modifierSafeContentPadding, forceCrop, bVarZ17VideoEditor$lambda$54$lambda$18, longValue, listZ17VideoEditor$lambda$54$lambda$7, (Function1) objRememberedValue, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$30$lambda$29$lambda$28(MutableState mutableState, MutableState mutableState2, rb.b it) {
        y.i(it, "it");
        mutableState.setValue(it);
        Player playerZ17VideoEditor$lambda$54$lambda$15 = Z17VideoEditor$lambda$54$lambda$15(mutableState2);
        if (playerZ17VideoEditor$lambda$54$lambda$15 != null) {
            playerZ17VideoEditor$lambda$54$lambda$15.pause();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17VideoEditor$lambda$54$lambda$49$lambda$32$lambda$31(State state) {
        return Z17VideoEditor$lambda$54$lambda$6(state) == Z17EditorState.CROP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$39$lambda$36(MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Uri it, Composer composer, int i10) {
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(857297896, i10, -1, "cu.z17.views.videoEditor.Z17VideoEditor.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Z17VideoEditor.kt:145)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
        rb.b bVarZ17VideoEditor$lambda$54$lambda$18 = Z17VideoEditor$lambda$54$lambda$18(mutableState);
        PlayerState playerStateZ17VideoEditor$lambda$54$lambda$12 = Z17VideoEditor$lambda$54$lambda$12(mutableState2);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion2 = Composer.INSTANCE;
        if (objRememberedValue == companion2.getEmpty()) {
            objRememberedValue = new Z17VideoEditorKt$Z17VideoEditor$1$1$5$1$1$1(mutableState2, mutableState3);
            composer.updateRememberedValue(objRememberedValue);
        }
        ViewerKt.Viewer(modifierFillMaxSize$default, it, bVarZ17VideoEditor$lambda$54$lambda$18, (Function2) objRememberedValue, null, playerStateZ17VideoEditor$lambda$54$lambda$12, 0, composer, ((i10 << 3) & 112) | 3078, 80);
        Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
        PlayerState playerStateZ17VideoEditor$lambda$54$lambda$13 = Z17VideoEditor$lambda$54$lambda$12(mutableState2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion2.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.videoEditor.a
                @Override // lb.a
                public final Object invoke() {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$39$lambda$36$lambda$35$lambda$34(mutableState2, mutableState3);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ControllerUiKt.PlayerControls(modifierFillMaxSize$default2, playerStateZ17VideoEditor$lambda$54$lambda$13, (lb.a) objRememberedValue2, composer, 390, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$39$lambda$36$lambda$35$lambda$34(MutableState mutableState, MutableState mutableState2) {
        if (Z17VideoEditor$lambda$54$lambda$12(mutableState).isPlaying()) {
            Player playerZ17VideoEditor$lambda$54$lambda$15 = Z17VideoEditor$lambda$54$lambda$15(mutableState2);
            if (playerZ17VideoEditor$lambda$54$lambda$15 != null) {
                playerZ17VideoEditor$lambda$54$lambda$15.pause();
            }
        } else if (Z17VideoEditor$lambda$54$lambda$12(mutableState).isPlaying() || Z17VideoEditor$lambda$54$lambda$12(mutableState).getPlaybackState() != 4) {
            Player playerZ17VideoEditor$lambda$54$lambda$16 = Z17VideoEditor$lambda$54$lambda$15(mutableState2);
            if (playerZ17VideoEditor$lambda$54$lambda$16 != null) {
                playerZ17VideoEditor$lambda$54$lambda$16.play();
            }
        } else {
            Player playerZ17VideoEditor$lambda$54$lambda$17 = Z17VideoEditor$lambda$54$lambda$15(mutableState2);
            if (playerZ17VideoEditor$lambda$54$lambda$17 != null) {
                playerZ17VideoEditor$lambda$54$lambda$17.seekTo(0L);
            }
            Player playerZ17VideoEditor$lambda$54$lambda$18 = Z17VideoEditor$lambda$54$lambda$15(mutableState2);
            if (playerZ17VideoEditor$lambda$54$lambda$18 != null) {
                playerZ17VideoEditor$lambda$54$lambda$18.setPlayWhenReady(true);
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17VideoEditor$lambda$54$lambda$49$lambda$39$lambda$38$lambda$37() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$46(final VideoEditorViewModel videoEditorViewModel, final Context context, final String str, final Function1 function1, final MutableState mutableState, final MutableLongState mutableLongState, final MutableState mutableState2, final Uri it, Composer composer, int i10) {
        Object obj;
        y.i(it, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(862647478, i10, -1, "cu.z17.views.videoEditor.Z17VideoEditor.<anonymous>.<anonymous>.<anonymous> (Z17VideoEditor.kt:190)");
        }
        Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(Modifier.INSTANCE);
        boolean zChangedInstance = composer.changedInstance(videoEditorViewModel) | composer.changedInstance(it) | composer.changedInstance(context) | composer.changed(str) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            obj = new lb.a() { // from class: cu.z17.views.videoEditor.j
                @Override // lb.a
                public final Object invoke() {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$46$lambda$43$lambda$42(videoEditorViewModel, it, context, str, mutableState, function1, mutableLongState, mutableState2);
                }
            };
            composer.updateRememberedValue(obj);
        } else {
            obj = objRememberedValue;
        }
        lb.a aVar = (lb.a) obj;
        boolean zChangedInstance2 = composer.changedInstance(videoEditorViewModel);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.videoEditor.k
                @Override // lb.a
                public final Object invoke() {
                    return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$46$lambda$45$lambda$44(videoEditorViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        CutterBottomBarKt.CutterBottomBar(modifierSafeContentPadding, aVar, (lb.a) objRememberedValue2, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$46$lambda$43$lambda$42(final VideoEditorViewModel videoEditorViewModel, Uri uri, Context context, final String str, MutableState mutableState, final Function1 function1, final MutableLongState mutableLongState, final MutableState mutableState2) {
        videoEditorViewModel.saveVideo(uri, context, str, (long) ((Number) Z17VideoEditor$lambda$54$lambda$18(mutableState).getStart()).floatValue(), (long) ((Number) Z17VideoEditor$lambda$54$lambda$18(mutableState).getEndInclusive()).floatValue(), new Function1() { // from class: cu.z17.views.videoEditor.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$46$lambda$43$lambda$42$lambda$40(str, videoEditorViewModel, function1, mutableLongState, mutableState2, ((Long) obj).longValue());
            }
        }, new lb.a() { // from class: cu.z17.views.videoEditor.n
            @Override // lb.a
            public final Object invoke() {
                return Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$49$lambda$46$lambda$43$lambda$42$lambda$41(videoEditorViewModel);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$46$lambda$43$lambda$42$lambda$40(String str, VideoEditorViewModel videoEditorViewModel, Function1 function1, MutableLongState mutableLongState, MutableState mutableState, long j10) {
        mutableLongState.setLongValue(j10);
        mutableState.setValue(str);
        videoEditorViewModel.requestState(Z17EditorState.VIEW);
        function1.invoke(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$46$lambda$43$lambda$42$lambda$41(VideoEditorViewModel videoEditorViewModel) {
        videoEditorViewModel.requestState(Z17EditorState.ERROR);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$49$lambda$46$lambda$45$lambda$44(VideoEditorViewModel videoEditorViewModel) {
        videoEditorViewModel.requestState(Z17EditorState.VIEW);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17VideoEditor$lambda$54$lambda$49$lambda$48$lambda$47(State state) {
        return Z17VideoEditor$lambda$54$lambda$6(state) == Z17EditorState.CROP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$54$lambda$51$lambda$50(VideoEditorViewModel videoEditorViewModel) {
        videoEditorViewModel.requestState(Z17EditorState.VIEW);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Z17EditorState Z17VideoEditor$lambda$54$lambda$6(State<? extends Z17EditorState> state) {
        return state.getValue();
    }

    private static final List<Bitmap> Z17VideoEditor$lambda$54$lambda$7(State<? extends List<Bitmap>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17VideoEditor$lambda$54$lambda$9$lambda$8(State state) {
        return Z17VideoEditor$lambda$54$lambda$6(state) == Z17EditorState.VIEW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z17VideoEditor$lambda$54$updatePlayerState(MutableState<PlayerState> mutableState, MutableState<Player> mutableState2, PlayerState playerState, Player player) {
        mutableState.setValue(playerState);
        mutableState2.setValue(player);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17VideoEditor$lambda$55(Modifier modifier, String str, long j10, String str2, Function1 function1, lb.a aVar, Function1 function2, VideoEditorViewModel videoEditorViewModel, VideoEditorConfigurations videoEditorConfigurations, int i10, int i11, Composer composer, int i12) {
        Z17VideoEditor(modifier, str, j10, str2, function1, aVar, function2, videoEditorViewModel, videoEditorConfigurations, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
