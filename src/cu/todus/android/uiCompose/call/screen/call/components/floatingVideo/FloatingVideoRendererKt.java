package cu.todus.android.uiCompose.call.screen.call.components.floatingVideo;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import cu.todus.android.uiCompose.call.screen.call.components.videoRender.VideoRendererKt;
import cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import org.webrtc.VideoTrack;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a7\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014¨\u0006\u001c²\u0006\u000e\u0010\u0018\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0019\u001a\u00020\u00118\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\u00118\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0012\u001a\u00020\u001b8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "sessionManager", "Lorg/webrtc/VideoTrack;", "videoTrack", "Landroidx/compose/ui/unit/IntSize;", "parentBounds", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", "Landroidx/compose/ui/Modifier;", "modifier", "Lua/k0;", "FloatingVideoRenderer-JQ-Ljw8", "(Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;Lorg/webrtc/VideoTrack;JLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FloatingVideoRenderer", "floatingVideoSize", "Landroidx/compose/ui/unit/Density;", "density", "", "offset", "calculateHorizontalOffsetBounds-7QRZqkg", "(JLandroidx/compose/foundation/layout/PaddingValues;JLandroidx/compose/ui/unit/Density;F)F", "calculateHorizontalOffsetBounds", "calculateVerticalOffsetBounds-7QRZqkg", "calculateVerticalOffsetBounds", "videoSize", "offsetX", "offsetY", "Landroidx/compose/ui/geometry/Offset;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FloatingVideoRendererKt {
    /* JADX WARN: Code duplicated, block: B:100:0x029c  */
    /* JADX WARN: Code duplicated, block: B:103:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x008d  */
    /* JADX WARN: Code duplicated, block: B:45:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x009a  */
    /* JADX WARN: Code duplicated, block: B:50:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:59:0x00de  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:65:0x0154  */
    /* JADX WARN: Code duplicated, block: B:70:0x017f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0199  */
    /* JADX WARN: Code duplicated, block: B:74:0x019b  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:83:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:88:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:91:0x0226  */
    /* JADX WARN: Code duplicated, block: B:94:0x0232  */
    /* JADX WARN: Code duplicated, block: B:95:0x0236  */
    /* JADX WARN: Code duplicated, block: B:98:0x0297  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: FloatingVideoRenderer-JQ-Ljw8, reason: not valid java name */
    public static final void m9818FloatingVideoRendererJQLjw8(final WebRtcSessionManagerImpl sessionManager, final VideoTrack videoTrack, final long j10, final PaddingValues paddingValues, Modifier modifier, Composer composer, final int i10, final int i11) {
        int i12;
        Modifier modifier2;
        boolean z10;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        Object objRememberedValue2;
        MutableState mutableState2;
        Object objRememberedValue3;
        MutableState mutableState3;
        final State<Offset> stateM1109animateOffsetAsState7362WCg;
        Density density;
        Object objRememberedValue4;
        float fMo1345toPx0680j_4;
        boolean zChanged;
        Object objRememberedValue5;
        boolean z11;
        boolean z12;
        boolean zChanged2;
        Object floatingVideoRendererKt$FloatingVideoRenderer$3$1;
        final MutableState mutableState4;
        Modifier modifier5;
        Object obj;
        Object objRememberedValue6;
        lb.a constructor;
        Float fValueOf = Float.valueOf(0.0f);
        y.i(sessionManager, "sessionManager");
        y.i(videoTrack, "videoTrack");
        y.i(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(1298567147);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(sessionManager) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(videoTrack) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        int i13 = i11 & 16;
        if (i13 == 0) {
            if ((i10 & 24576) == 0) {
                modifier2 = modifier;
                i12 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1298567147, i12, -1, "cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.FloatingVideoRenderer (FloatingVideoRenderer.kt:47)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    long j11 = 0;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j11 << 32) | (j11 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState3 = (MutableState) objRememberedValue3;
                stateM1109animateOffsetAsState7362WCg = AnimateAsStateKt.m1109animateOffsetAsState7362WCg(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(FloatingVideoRenderer_JQ_Ljw8$lambda$4(mutableState2))) << 32) | (((long) Float.floatToRawIntBits(FloatingVideoRenderer_JQ_Ljw8$lambda$7(mutableState3))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), null, null, null, composerStartRestartGroup, 0, 14);
                composer2 = composerStartRestartGroup;
                density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                Integer numValueOf = Integer.valueOf((int) (j10 >> 32));
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new FloatingVideoRendererKt$FloatingVideoRenderer$1$1(mutableState2, mutableState3, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                EffectsKt.LaunchedEffect(numValueOf, (Function2) objRememberedValue4, composer2, 0);
                fMo1345toPx0680j_4 = density.mo1345toPx0680j_4(Dp.m8823constructorimpl(16));
                Modifier.Companion companion2 = Modifier.INSTANCE;
                zChanged = composer2.changed(stateM1109animateOffsetAsState7362WCg);
                objRememberedValue5 = composer2.rememberedValue();
                if (zChanged || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$12$0(stateM1109animateOffsetAsState7362WCg, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                Modifier modifierOffset = OffsetKt.offset(companion2, (Function1) objRememberedValue5);
                IntSize intSizeM8982boximpl = IntSize.m8982boximpl(j10);
                if ((i12 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z13 = z11;
                if ((i12 & 7168) == 2048) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChanged2 = z13 | z12 | composer2.changed(density) | composer2.changed(fMo1345toPx0680j_4);
                Object objRememberedValue7 = composer2.rememberedValue();
                if (!zChanged2 || objRememberedValue7 == companion.getEmpty()) {
                    mutableState4 = mutableState;
                    modifier5 = modifier4;
                    obj = null;
                    floatingVideoRendererKt$FloatingVideoRenderer$3$1 = new FloatingVideoRendererKt$FloatingVideoRenderer$3$1(j10, paddingValues, density, fMo1345toPx0680j_4, mutableState2, mutableState4, mutableState3);
                    composer2.updateRememberedValue(floatingVideoRendererKt$FloatingVideoRenderer$3$1);
                } else {
                    floatingVideoRendererKt$FloatingVideoRenderer$3$1 = objRememberedValue7;
                    modifier5 = modifier4;
                    obj = null;
                    mutableState4 = mutableState;
                }
                Modifier modifierThen = SuspendingPointerInputFilterKt.pointerInput(modifierOffset, intSizeM8982boximpl, (PointerInputEventHandler) floatingVideoRendererKt$FloatingVideoRenderer$3$1).then(modifier5);
                objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$14$0(mutableState4, (LayoutCoordinates) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierThen, (Function1) objRememberedValue6);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                VideoRendererKt.VideoRenderer(videoTrack, ClipKt.clip(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(14))), sessionManager, composer2, (14 & (i12 >> 3)) | ((i12 << 6) & 896), 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$16(sessionManager, videoTrack, j10, paddingValues, modifier3, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        modifier2 = modifier;
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            if (i13 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1298567147, i12, -1, "cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.FloatingVideoRenderer (FloatingVideoRenderer.kt:47)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                long j12 = 0;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8982boximpl(IntSize.m8985constructorimpl((j12 << 32) | (j12 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState3 = (MutableState) objRememberedValue3;
            stateM1109animateOffsetAsState7362WCg = AnimateAsStateKt.m1109animateOffsetAsState7362WCg(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(FloatingVideoRenderer_JQ_Ljw8$lambda$4(mutableState2))) << 32) | (((long) Float.floatToRawIntBits(FloatingVideoRenderer_JQ_Ljw8$lambda$7(mutableState3))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), null, null, null, composerStartRestartGroup, 0, 14);
            composer2 = composerStartRestartGroup;
            density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            Integer numValueOf2 = Integer.valueOf((int) (j10 >> 32));
            objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new FloatingVideoRendererKt$FloatingVideoRenderer$1$1(mutableState2, mutableState3, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(numValueOf2, (Function2) objRememberedValue4, composer2, 0);
            fMo1345toPx0680j_4 = density.mo1345toPx0680j_4(Dp.m8823constructorimpl(16));
            Modifier.Companion companion4 = Modifier.INSTANCE;
            zChanged = composer2.changed(stateM1109animateOffsetAsState7362WCg);
            objRememberedValue5 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$12$0(stateM1109animateOffsetAsState7362WCg, (Density) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$12$0(stateM1109animateOffsetAsState7362WCg, (Density) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            }
            Modifier modifierOffset2 = OffsetKt.offset(companion4, (Function1) objRememberedValue5);
            IntSize intSizeM8982boximpl2 = IntSize.m8982boximpl(j10);
            if ((i12 & 896) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z14 = z11;
            if ((i12 & 7168) == 2048) {
                z12 = true;
            } else {
                z12 = false;
            }
            zChanged2 = z14 | z12 | composer2.changed(density) | composer2.changed(fMo1345toPx0680j_4);
            Object objRememberedValue8 = composer2.rememberedValue();
            if (zChanged2) {
                mutableState4 = mutableState;
                modifier5 = modifier4;
                obj = null;
                floatingVideoRendererKt$FloatingVideoRenderer$3$1 = new FloatingVideoRendererKt$FloatingVideoRenderer$3$1(j10, paddingValues, density, fMo1345toPx0680j_4, mutableState2, mutableState4, mutableState3);
                composer2.updateRememberedValue(floatingVideoRendererKt$FloatingVideoRenderer$3$1);
            } else {
                mutableState4 = mutableState;
                modifier5 = modifier4;
                obj = null;
                floatingVideoRendererKt$FloatingVideoRenderer$3$1 = new FloatingVideoRendererKt$FloatingVideoRenderer$3$1(j10, paddingValues, density, fMo1345toPx0680j_4, mutableState2, mutableState4, mutableState3);
                composer2.updateRememberedValue(floatingVideoRendererKt$FloatingVideoRenderer$3$1);
            }
            Modifier modifierThen2 = SuspendingPointerInputFilterKt.pointerInput(modifierOffset2, intSizeM8982boximpl2, (PointerInputEventHandler) floatingVideoRendererKt$FloatingVideoRenderer$3$1).then(modifier5);
            objRememberedValue6 = composer2.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$14$0(mutableState4, (LayoutCoordinates) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            }
            Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierThen2, (Function1) objRememberedValue6);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned2);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            constructor = companion5.getConstructor();
            if (!r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            VideoRendererKt.VideoRenderer(videoTrack, ClipKt.clip(SizeKt.fillMaxSize$default(companion4, 0.0f, 1, obj), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(14))), sessionManager, composer2, (14 & (i12 >> 3)) | ((i12 << 6) & 896), 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$16(sessionManager, videoTrack, j10, paddingValues, modifier3, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long FloatingVideoRenderer_JQ_Ljw8$lambda$1(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m8994unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset FloatingVideoRenderer_JQ_Ljw8$lambda$12$0(State state, Density offset) {
        y.i(offset, "$this$offset");
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (FloatingVideoRenderer_JQ_Ljw8$lambda$9(state) >> 32));
        return IntOffset.m8938boximpl(IntOffset.m8941constructorimpl((((long) ((int) Float.intBitsToFloat((int) (FloatingVideoRenderer_JQ_Ljw8$lambda$9(state) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) iIntBitsToFloat) << 32)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FloatingVideoRenderer_JQ_Ljw8$lambda$14$0(MutableState mutableState, LayoutCoordinates it) {
        y.i(it, "it");
        FloatingVideoRenderer_JQ_Ljw8$lambda$2(mutableState, it.mo7202getSizeYbymL2g());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FloatingVideoRenderer_JQ_Ljw8$lambda$16(WebRtcSessionManagerImpl webRtcSessionManagerImpl, VideoTrack videoTrack, long j10, PaddingValues paddingValues, Modifier modifier, int i10, int i11, Composer composer, int i12) {
        m9818FloatingVideoRendererJQLjw8(webRtcSessionManagerImpl, videoTrack, j10, paddingValues, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final void FloatingVideoRenderer_JQ_Ljw8$lambda$2(MutableState<IntSize> mutableState, long j10) {
        mutableState.setValue(IntSize.m8982boximpl(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float FloatingVideoRenderer_JQ_Ljw8$lambda$4(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FloatingVideoRenderer_JQ_Ljw8$lambda$5(MutableState<Float> mutableState, float f10) {
        mutableState.setValue(Float.valueOf(f10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float FloatingVideoRenderer_JQ_Ljw8$lambda$7(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FloatingVideoRenderer_JQ_Ljw8$lambda$8(MutableState<Float> mutableState, float f10) {
        mutableState.setValue(Float.valueOf(f10));
    }

    private static final long FloatingVideoRenderer_JQ_Ljw8$lambda$9(State<Offset> state) {
        return state.getValue().m5636unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHorizontalOffsetBounds-7QRZqkg, reason: not valid java name */
    public static final float m9821calculateHorizontalOffsetBounds7QRZqkg(long j10, PaddingValues paddingValues, long j11, Density density, float f10) {
        return ((((int) (j10 >> 32)) - density.mo1345toPx0680j_4(paddingValues.mo1676calculateRightPaddingu2uoSUM(LayoutDirection.Ltr))) - ((int) (j11 >> 32))) - f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateVerticalOffsetBounds-7QRZqkg, reason: not valid java name */
    public static final float m9822calculateVerticalOffsetBounds7QRZqkg(long j10, PaddingValues paddingValues, long j11, Density density, float f10) {
        return ((((int) (j10 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - density.mo1345toPx0680j_4(paddingValues.getBottom())) - ((int) (j11 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) - f10;
    }
}
