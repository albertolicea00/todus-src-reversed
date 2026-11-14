package cu.todus.android.uiCompose.call.screen.call.components.controls;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.uiCompose.call.screen.call.CallMediaState;
import defpackage.l;
import defpackage.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.o;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aK\u0010\r\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "ownerCallMediaState", "", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/VideoCallControlAction;", "actions", "Lkotlin/Function1;", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "Lua/k0;", "onCallAction", "", "isConnected", "VideoCallControls", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;Ljava/util/List;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class VideoCallControlsKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VideoCallControls(final Modifier modifier, final CallMediaState ownerCallMediaState, List<VideoCallControlAction> list, final Function1 onCallAction, final boolean z10, Composer composer, final int i10, final int i11) {
        int i12;
        List<VideoCallControlAction> listBuildDefaultCallControlActions;
        Composer composer2;
        final List<VideoCallControlAction> list2;
        Shape shapeM2017RoundedCornerShapea9UjIt4$default;
        y.i(modifier, "modifier");
        y.i(ownerCallMediaState, "ownerCallMediaState");
        y.i(onCallAction, "onCallAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(2026904431);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(ownerCallMediaState) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                listBuildDefaultCallControlActions = list;
                int i13 = composerStartRestartGroup.changedInstance(listBuildDefaultCallControlActions) ? 256 : 128;
                i12 |= i13;
            } else {
                listBuildDefaultCallControlActions = list;
            }
            i12 |= i13;
        } else {
            listBuildDefaultCallControlActions = list;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onCallAction) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            } else if ((i11 & 4) != 0) {
                listBuildDefaultCallControlActions = VideoCallControlActionKt.buildDefaultCallControlActions(ownerCallMediaState, composerStartRestartGroup, (i12 >> 3) & 14);
                i12 &= -897;
            }
            final List<VideoCallControlAction> list3 = listBuildDefaultCallControlActions;
            int i14 = i12;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2026904431, i14, -1, "cu.todus.android.uiCompose.call.screen.call.components.controls.VideoCallControls (VideoCallControls.kt:37)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            float fM8823constructorimpl = Dp.m8823constructorimpl((float) 0.5d);
            long jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
            if (z10) {
                shapeM2017RoundedCornerShapea9UjIt4$default = RectangleShapeKt.getRectangleShape();
            } else {
                float f10 = 15;
                shapeM2017RoundedCornerShapea9UjIt4$default = RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 12, null);
            }
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierFillMaxWidth$default, fM8823constructorimpl, jM5865copywmQWz5c$default, shapeM2017RoundedCornerShapea9UjIt4$default);
            float f11 = 12;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(modifierM1216borderxT4_qwU, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, Dp.m8823constructorimpl(f11), 5, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            boolean zChangedInstance = ((57344 & i14) == 16384) | composerStartRestartGroup.changedInstance(list3) | ((i14 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.controls.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VideoCallControlsKt.VideoCallControls$lambda$0$0(list3, z10, onCallAction, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyRow(modifierM1729paddingqDBjuR0$default, null, null, false, spaceEvenly, centerVertically, null, false, null, (Function1) objRememberedValue, composer2, 221184, 462);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            list2 = list3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            list2 = listBuildDefaultCallControlActions;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.components.controls.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCallControlsKt.VideoCallControls$lambda$1(modifier, ownerCallMediaState, list2, onCallAction, z10, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoCallControls$lambda$0$0(final List list, final boolean z10, final Function1 function1, LazyListScope LazyRow) {
        y.i(LazyRow, "$this$LazyRow");
        final VideoCallControlsKt$VideoCallControls$lambda$0$0$$inlined$items$default$1 videoCallControlsKt$VideoCallControls$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.controls.VideoCallControlsKt$VideoCallControls$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(VideoCallControlAction videoCallControlAction) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((VideoCallControlAction) obj);
            }
        };
        LazyRow.items(list.size(), null, new Function1() { // from class: cu.todus.android.uiCompose.call.screen.call.components.controls.VideoCallControlsKt$VideoCallControls$lambda$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return videoCallControlsKt$VideoCallControls$lambda$0$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new o() { // from class: cu.todus.android.uiCompose.call.screen.call.components.controls.VideoCallControlsKt$VideoCallControls$lambda$0$0$$inlined$items$default$4
            @Override // lb.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return k0.f43947a;
            }

            @Composable
            public final void invoke(LazyItemScope lazyItemScope, int i10, Composer composer, int i11) {
                int i12;
                if ((i11 & 6) == 0) {
                    i12 = i11 | (composer.changed(lazyItemScope) ? 4 : 2);
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
                final VideoCallControlAction videoCallControlAction = (VideoCallControlAction) list.get(i10);
                composer.startReplaceGroup(1717227047);
                if (z10 || y.d(videoCallControlAction.getCallAction(), CallAction.LeaveCall.INSTANCE)) {
                    composer.startReplaceGroup(1717286628);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(56)), RoundedCornerShapeKt.getCircleShape()), Color.m5865copywmQWz5c$default(videoCallControlAction.m9815getBackground0d7_KjU(), (z10 || y.d(videoCallControlAction.getCallAction(), CallAction.LeaveCall.INSTANCE)) ? 1.0f : 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                    int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1205backgroundbw27NRU$default);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    lb.a constructor = companion3.getConstructor();
                    if (!r.a(composer.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                    Modifier modifierAlign = BoxScopeInstance.INSTANCE.align(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(10)), companion2.getCenter());
                    boolean zChanged = composer.changed(z10) | composer.changedInstance(videoCallControlAction) | composer.changed(function1);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        final boolean z11 = z10;
                        final Function1 function2 = function1;
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.components.controls.VideoCallControlsKt$VideoCallControls$1$1$1$1$1$1
                            @Override // lb.a
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m9817invoke();
                                return k0.f43947a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m9817invoke() {
                                if (z11 || y.d(videoCallControlAction.getCallAction(), CallAction.LeaveCall.INSTANCE)) {
                                    function2.invoke(videoCallControlAction.getCallAction());
                                }
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    IconKt.m2670Iconww6aTOc(videoCallControlAction.getIcon(), (String) null, ClickableKt.m1240clickableoSLSa3U$default(modifierAlign, false, null, null, null, (lb.a) objRememberedValue, 15, null), videoCallControlAction.m9816getIconTint0d7_KjU(), composer, Painter.$stable | 48, 0);
                    composer.endNode();
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1718268770);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 VideoCallControls$lambda$1(Modifier modifier, CallMediaState callMediaState, List list, Function1 function1, boolean z10, int i10, int i11, Composer composer, int i12) {
        VideoCallControls(modifier, callMediaState, list, function1, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
