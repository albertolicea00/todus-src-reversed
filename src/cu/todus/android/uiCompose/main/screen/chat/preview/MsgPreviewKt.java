package cu.todus.android.uiCompose.main.screen.chat.preview;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.content.TextContentKt;
import cu.todus.android.uiCompose.shared.animations.attach.AttachContainerKt;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.utils.TextUtilsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a5\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a3\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\\\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006#²\u0006\u000e\u0010\u001b\u001a\u00020\u001a8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\u001c8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\u001c8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010 \u001a\u00020\u001f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010!\u001a\u00020\u001c8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\"\u001a\u00020\u001a8\nX\u008a\u0084\u0002"}, d2 = {"", "ownerId", "ownerAlias", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "Lkotlin/Function0;", "Lua/k0;", "onCancel", "ReplyPreview", "(Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Llb/a;Landroidx/compose/runtime/Composer;I)V", "EditPreview", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Ljava/lang/String;Ljava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "text", "onClick", "PinnedPreview", "(Ljava/lang/String;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "onLongClick", "", "Landroidx/compose/ui/graphics/Color;", "borderColors", "Landroidx/compose/runtime/Composable;", "content", "CardWithAnimatedBorder", "(Landroidx/compose/ui/Modifier;Llb/a;Llb/a;Ljava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "", "horizontalDragging", "", "isDragging", "showPreview", "", "actualMsg", "showActual", "angle", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MsgPreviewKt {
    /* JADX WARN: Code duplicated, block: B:100:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:101:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:104:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:106:0x0203  */
    /* JADX WARN: Code duplicated, block: B:109:0x0244  */
    /* JADX WARN: Code duplicated, block: B:111:0x024c  */
    /* JADX WARN: Code duplicated, block: B:114:0x025a  */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:82:0x0103  */
    /* JADX WARN: Code duplicated, block: B:85:0x0108  */
    /* JADX WARN: Code duplicated, block: B:86:0x0152  */
    /* JADX WARN: Code duplicated, block: B:89:0x015f  */
    /* JADX WARN: Code duplicated, block: B:92:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:93:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:96:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e8  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void CardWithAnimatedBorder(Modifier modifier, lb.a aVar, lb.a aVar2, List<Color> list, final Function2 content, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        int i13;
        lb.a aVar3;
        int i14;
        List<Color> list2;
        boolean z10;
        final lb.a aVar4;
        final Modifier modifier3;
        final lb.a aVar5;
        final List<Color> list3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        lb.a aVar6;
        lb.a aVar7;
        int i15;
        lb.a aVar8;
        List<Color> listQ;
        Object objRememberedValue;
        Object objRememberedValue2;
        final Brush brushM5825sweepGradientUv8p0NA$default;
        boolean z11;
        boolean z12;
        boolean z13;
        Object objRememberedValue3;
        int i16;
        kotlin.jvm.internal.y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1832005989);
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
        int i18 = i11 & 2;
        if (i18 == 0) {
            if ((i10 & 48) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(aVar) ? 32 : 16;
            }
            i13 = i11 & 4;
            if (i13 != 0) {
                if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    aVar3 = aVar2;
                    if (composerStartRestartGroup.changedInstance(aVar3)) {
                        i14 = 256;
                    } else {
                        i14 = 128;
                    }
                    i12 |= i14;
                }
                if ((i10 & 3072) == 0) {
                    if ((i11 & 8) == 0) {
                        list2 = list;
                        int i19 = composerStartRestartGroup.changedInstance(list2) ? 2048 : 1024;
                        i12 |= i19;
                    } else {
                        list2 = list;
                    }
                    i12 |= i19;
                } else {
                    list2 = list;
                }
                if ((i10 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i12 |= i16;
                }
                if ((i12 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i18 != 0) {
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.d
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            aVar6 = (lb.a) objRememberedValue2;
                        } else {
                            aVar6 = aVar;
                        }
                        if (i13 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar7 = (lb.a) objRememberedValue;
                        } else {
                            aVar7 = aVar3;
                        }
                        if ((i11 & 8) != 0) {
                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                            int i20 = MaterialTheme.$stable;
                            listQ = va.w.q(Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i20).getPrimary()), Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i20).getOnBackground()), Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i20).getSurface()), Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i20).getInversePrimary()));
                            i15 = i12 & (-7169);
                            aVar8 = aVar7;
                        } else {
                            i15 = i12;
                            aVar8 = aVar7;
                            listQ = list2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 8) != 0) {
                            i12 &= -7169;
                        }
                        modifier3 = modifier2;
                        i15 = i12;
                        aVar8 = aVar3;
                        listQ = list2;
                        aVar6 = aVar;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1832005989, i15, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.CardWithAnimatedBorder (MsgPreview.kt:333)");
                    }
                    final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("animated border transition", composerStartRestartGroup, 6, 0), 0.0f, 360.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1500, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "animated border", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                    if (listQ.isEmpty()) {
                        Brush.Companion companion = Brush.INSTANCE;
                        Color.Companion companion2 = Color.INSTANCE;
                        brushM5825sweepGradientUv8p0NA$default = Brush.Companion.m5825sweepGradientUv8p0NA$default(companion, va.w.q(Color.m5856boximpl(companion2.m5896getGray0d7_KjU()), Color.m5856boximpl(companion2.m5903getWhite0d7_KjU())), 0L, 2, (Object) null);
                    } else {
                        brushM5825sweepGradientUv8p0NA$default = Brush.Companion.m5825sweepGradientUv8p0NA$default(Brush.INSTANCE, listQ, 0L, 2, (Object) null);
                    }
                    k0 k0Var = k0.f43947a;
                    if ((i15 & 896) == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i15 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z11 | z12;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z13 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new MsgPreviewKt$CardWithAnimatedBorder$3$1(aVar8, aVar6);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    SurfaceKt.m3707SurfaceT9BRK9s(SuspendingPointerInputFilterKt.pointerInput(modifier3, k0Var, (PointerInputEventHandler) objRememberedValue3), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(20)), 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-132162582, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MsgPreviewKt.CardWithAnimatedBorder$lambda$4(stateAnimateFloat, brushM5825sweepGradientUv8p0NA$default, content, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 124);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar5 = aVar8;
                    aVar4 = aVar6;
                    list3 = listQ;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    aVar4 = aVar;
                    modifier3 = modifier2;
                    aVar5 = aVar3;
                    list3 = list2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MsgPreviewKt.CardWithAnimatedBorder$lambda$5(modifier3, aVar4, aVar5, list3, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            aVar3 = aVar2;
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    list2 = list;
                    if (composerStartRestartGroup.changedInstance(list2)) {
                    }
                    i12 |= i19;
                } else {
                    list2 = list;
                }
                i12 |= i19;
            } else {
                list2 = list;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i12 |= i16;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i18 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar6 = (lb.a) objRememberedValue2;
                    } else {
                        aVar6 = aVar;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar7 = (lb.a) objRememberedValue;
                    } else {
                        aVar7 = aVar3;
                    }
                    if ((i11 & 8) != 0) {
                        MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                        int i21 = MaterialTheme.$stable;
                        listQ = va.w.q(Color.m5856boximpl(materialTheme2.getColorScheme(composerStartRestartGroup, i21).getPrimary()), Color.m5856boximpl(materialTheme2.getColorScheme(composerStartRestartGroup, i21).getOnBackground()), Color.m5856boximpl(materialTheme2.getColorScheme(composerStartRestartGroup, i21).getSurface()), Color.m5856boximpl(materialTheme2.getColorScheme(composerStartRestartGroup, i21).getInversePrimary()));
                        i15 = i12 & (-7169);
                        aVar8 = aVar7;
                    } else {
                        i15 = i12;
                        aVar8 = aVar7;
                        listQ = list2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i18 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar6 = (lb.a) objRememberedValue2;
                    } else {
                        aVar6 = aVar;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar7 = (lb.a) objRememberedValue;
                    } else {
                        aVar7 = aVar3;
                    }
                    if ((i11 & 8) != 0) {
                        MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                        int i22 = MaterialTheme.$stable;
                        listQ = va.w.q(Color.m5856boximpl(materialTheme3.getColorScheme(composerStartRestartGroup, i22).getPrimary()), Color.m5856boximpl(materialTheme3.getColorScheme(composerStartRestartGroup, i22).getOnBackground()), Color.m5856boximpl(materialTheme3.getColorScheme(composerStartRestartGroup, i22).getSurface()), Color.m5856boximpl(materialTheme3.getColorScheme(composerStartRestartGroup, i22).getInversePrimary()));
                        i15 = i12 & (-7169);
                        aVar8 = aVar7;
                    } else {
                        i15 = i12;
                        aVar8 = aVar7;
                        listQ = list2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1832005989, i15, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.CardWithAnimatedBorder (MsgPreview.kt:333)");
                }
                final State stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("animated border transition", composerStartRestartGroup, 6, 0), 0.0f, 360.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1500, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "animated border", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                if (listQ.isEmpty()) {
                    brushM5825sweepGradientUv8p0NA$default = Brush.Companion.m5825sweepGradientUv8p0NA$default(Brush.INSTANCE, listQ, 0L, 2, (Object) null);
                } else {
                    Brush.Companion companion3 = Brush.INSTANCE;
                    Color.Companion companion4 = Color.INSTANCE;
                    brushM5825sweepGradientUv8p0NA$default = Brush.Companion.m5825sweepGradientUv8p0NA$default(companion3, va.w.q(Color.m5856boximpl(companion4.m5896getGray0d7_KjU()), Color.m5856boximpl(companion4.m5903getWhite0d7_KjU())), 0L, 2, (Object) null);
                }
                k0 k0Var2 = k0.f43947a;
                if ((i15 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i15 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = z11 | z12;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    objRememberedValue3 = new MsgPreviewKt$CardWithAnimatedBorder$3$1(aVar8, aVar6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new MsgPreviewKt$CardWithAnimatedBorder$3$1(aVar8, aVar6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                SurfaceKt.m3707SurfaceT9BRK9s(SuspendingPointerInputFilterKt.pointerInput(modifier3, k0Var2, (PointerInputEventHandler) objRememberedValue3), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(20)), 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-132162582, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgPreviewKt.CardWithAnimatedBorder$lambda$4(stateAnimateFloat2, brushM5825sweepGradientUv8p0NA$default, content, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 124);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar5 = aVar8;
                aVar4 = aVar6;
                list3 = listQ;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                aVar4 = aVar;
                modifier3 = modifier2;
                aVar5 = aVar3;
                list3 = list2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgPreviewKt.CardWithAnimatedBorder$lambda$5(modifier3, aVar4, aVar5, list3, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        i13 = i11 & 4;
        if (i13 != 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                aVar3 = aVar2;
                if (composerStartRestartGroup.changedInstance(aVar3)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
                i12 |= i14;
            }
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    list2 = list;
                    if (composerStartRestartGroup.changedInstance(list2)) {
                    }
                    i12 |= i19;
                } else {
                    list2 = list;
                }
                i12 |= i19;
            } else {
                list2 = list;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i12 |= i16;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i18 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar6 = (lb.a) objRememberedValue2;
                    } else {
                        aVar6 = aVar;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar7 = (lb.a) objRememberedValue;
                    } else {
                        aVar7 = aVar3;
                    }
                    if ((i11 & 8) != 0) {
                        MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                        int i23 = MaterialTheme.$stable;
                        listQ = va.w.q(Color.m5856boximpl(materialTheme4.getColorScheme(composerStartRestartGroup, i23).getPrimary()), Color.m5856boximpl(materialTheme4.getColorScheme(composerStartRestartGroup, i23).getOnBackground()), Color.m5856boximpl(materialTheme4.getColorScheme(composerStartRestartGroup, i23).getSurface()), Color.m5856boximpl(materialTheme4.getColorScheme(composerStartRestartGroup, i23).getInversePrimary()));
                        i15 = i12 & (-7169);
                        aVar8 = aVar7;
                    } else {
                        i15 = i12;
                        aVar8 = aVar7;
                        listQ = list2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i18 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar6 = (lb.a) objRememberedValue2;
                    } else {
                        aVar6 = aVar;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar7 = (lb.a) objRememberedValue;
                    } else {
                        aVar7 = aVar3;
                    }
                    if ((i11 & 8) != 0) {
                        MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                        int i24 = MaterialTheme.$stable;
                        listQ = va.w.q(Color.m5856boximpl(materialTheme5.getColorScheme(composerStartRestartGroup, i24).getPrimary()), Color.m5856boximpl(materialTheme5.getColorScheme(composerStartRestartGroup, i24).getOnBackground()), Color.m5856boximpl(materialTheme5.getColorScheme(composerStartRestartGroup, i24).getSurface()), Color.m5856boximpl(materialTheme5.getColorScheme(composerStartRestartGroup, i24).getInversePrimary()));
                        i15 = i12 & (-7169);
                        aVar8 = aVar7;
                    } else {
                        i15 = i12;
                        aVar8 = aVar7;
                        listQ = list2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1832005989, i15, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.CardWithAnimatedBorder (MsgPreview.kt:333)");
                }
                final State stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("animated border transition", composerStartRestartGroup, 6, 0), 0.0f, 360.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1500, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "animated border", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                if (listQ.isEmpty()) {
                    brushM5825sweepGradientUv8p0NA$default = Brush.Companion.m5825sweepGradientUv8p0NA$default(Brush.INSTANCE, listQ, 0L, 2, (Object) null);
                } else {
                    Brush.Companion companion5 = Brush.INSTANCE;
                    Color.Companion companion6 = Color.INSTANCE;
                    brushM5825sweepGradientUv8p0NA$default = Brush.Companion.m5825sweepGradientUv8p0NA$default(companion5, va.w.q(Color.m5856boximpl(companion6.m5896getGray0d7_KjU()), Color.m5856boximpl(companion6.m5903getWhite0d7_KjU())), 0L, 2, (Object) null);
                }
                k0 k0Var3 = k0.f43947a;
                if ((i15 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i15 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = z11 | z12;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    objRememberedValue3 = new MsgPreviewKt$CardWithAnimatedBorder$3$1(aVar8, aVar6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new MsgPreviewKt$CardWithAnimatedBorder$3$1(aVar8, aVar6);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                SurfaceKt.m3707SurfaceT9BRK9s(SuspendingPointerInputFilterKt.pointerInput(modifier3, k0Var3, (PointerInputEventHandler) objRememberedValue3), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(20)), 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-132162582, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgPreviewKt.CardWithAnimatedBorder$lambda$4(stateAnimateFloat3, brushM5825sweepGradientUv8p0NA$default, content, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 124);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar5 = aVar8;
                aVar4 = aVar6;
                list3 = listQ;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                aVar4 = aVar;
                modifier3 = modifier2;
                aVar5 = aVar3;
                list3 = list2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgPreviewKt.CardWithAnimatedBorder$lambda$5(modifier3, aVar4, aVar5, list3, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        aVar3 = aVar2;
        if ((i10 & 3072) == 0) {
            if ((i11 & 8) == 0) {
                list2 = list;
                if (composerStartRestartGroup.changedInstance(list2)) {
                }
                i12 |= i19;
            } else {
                list2 = list;
            }
            i12 |= i19;
        } else {
            list2 = list;
        }
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i12 |= i16;
        }
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i17 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i18 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.d
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar6 = (lb.a) objRememberedValue2;
                } else {
                    aVar6 = aVar;
                }
                if (i13 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.e
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar7 = (lb.a) objRememberedValue;
                } else {
                    aVar7 = aVar3;
                }
                if ((i11 & 8) != 0) {
                    MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                    int i25 = MaterialTheme.$stable;
                    listQ = va.w.q(Color.m5856boximpl(materialTheme6.getColorScheme(composerStartRestartGroup, i25).getPrimary()), Color.m5856boximpl(materialTheme6.getColorScheme(composerStartRestartGroup, i25).getOnBackground()), Color.m5856boximpl(materialTheme6.getColorScheme(composerStartRestartGroup, i25).getSurface()), Color.m5856boximpl(materialTheme6.getColorScheme(composerStartRestartGroup, i25).getInversePrimary()));
                    i15 = i12 & (-7169);
                    aVar8 = aVar7;
                } else {
                    i15 = i12;
                    aVar8 = aVar7;
                    listQ = list2;
                }
            } else {
                if (i17 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i18 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.d
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar6 = (lb.a) objRememberedValue2;
                } else {
                    aVar6 = aVar;
                }
                if (i13 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.e
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar7 = (lb.a) objRememberedValue;
                } else {
                    aVar7 = aVar3;
                }
                if ((i11 & 8) != 0) {
                    MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                    int i26 = MaterialTheme.$stable;
                    listQ = va.w.q(Color.m5856boximpl(materialTheme7.getColorScheme(composerStartRestartGroup, i26).getPrimary()), Color.m5856boximpl(materialTheme7.getColorScheme(composerStartRestartGroup, i26).getOnBackground()), Color.m5856boximpl(materialTheme7.getColorScheme(composerStartRestartGroup, i26).getSurface()), Color.m5856boximpl(materialTheme7.getColorScheme(composerStartRestartGroup, i26).getInversePrimary()));
                    i15 = i12 & (-7169);
                    aVar8 = aVar7;
                } else {
                    i15 = i12;
                    aVar8 = aVar7;
                    listQ = list2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1832005989, i15, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.CardWithAnimatedBorder (MsgPreview.kt:333)");
            }
            final State stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("animated border transition", composerStartRestartGroup, 6, 0), 0.0f, 360.0f, AnimationSpecKt.m1114infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1500, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "animated border", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            if (listQ.isEmpty()) {
                brushM5825sweepGradientUv8p0NA$default = Brush.Companion.m5825sweepGradientUv8p0NA$default(Brush.INSTANCE, listQ, 0L, 2, (Object) null);
            } else {
                Brush.Companion companion7 = Brush.INSTANCE;
                Color.Companion companion8 = Color.INSTANCE;
                brushM5825sweepGradientUv8p0NA$default = Brush.Companion.m5825sweepGradientUv8p0NA$default(companion7, va.w.q(Color.m5856boximpl(companion8.m5896getGray0d7_KjU()), Color.m5856boximpl(companion8.m5903getWhite0d7_KjU())), 0L, 2, (Object) null);
            }
            k0 k0Var4 = k0.f43947a;
            if ((i15 & 896) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((i15 & 112) == 32) {
                z12 = true;
            } else {
                z12 = false;
            }
            z13 = z11 | z12;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z13) {
                objRememberedValue3 = new MsgPreviewKt$CardWithAnimatedBorder$3$1(aVar8, aVar6);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new MsgPreviewKt$CardWithAnimatedBorder$3$1(aVar8, aVar6);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            SurfaceKt.m3707SurfaceT9BRK9s(SuspendingPointerInputFilterKt.pointerInput(modifier3, k0Var4, (PointerInputEventHandler) objRememberedValue3), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(20)), 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-132162582, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgPreviewKt.CardWithAnimatedBorder$lambda$4(stateAnimateFloat4, brushM5825sweepGradientUv8p0NA$default, content, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 124);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aVar5 = aVar8;
            aVar4 = aVar6;
            list3 = listQ;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            aVar4 = aVar;
            modifier3 = modifier2;
            aVar5 = aVar3;
            list3 = list2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgPreviewKt.CardWithAnimatedBorder$lambda$5(modifier3, aVar4, aVar5, list3, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float CardWithAnimatedBorder$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CardWithAnimatedBorder$lambda$4(final State state, final Brush brush, final Function2 function2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-132162582, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.CardWithAnimatedBorder.<anonymous> (MsgPreview.kt:357)");
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(ClipKt.clipToBounds(Modifier.INSTANCE), 0.0f, 1, null), Dp.m8823constructorimpl(1));
            boolean zChanged = composer.changed(state) | composer.changed(brush);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgPreviewKt.CardWithAnimatedBorder$lambda$4$0$0(state, brush, (ContentDrawScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            SurfaceKt.m3707SurfaceT9BRK9s(DrawModifierKt.drawWithContent(modifierM1725padding3ABfNKs, (Function1) objRememberedValue), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(19)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1310591749, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgPreviewKt.CardWithAnimatedBorder$lambda$4$1(function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582912, MenuKt.InTransitionDuration);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CardWithAnimatedBorder$lambda$4$0$0(State state, Brush brush, ContentDrawScope drawWithContent) {
        kotlin.jvm.internal.y.i(drawWithContent, "$this$drawWithContent");
        float fCardWithAnimatedBorder$lambda$2 = CardWithAnimatedBorder$lambda$2(state);
        long jMo6333getCenterF1C5BW0 = drawWithContent.mo6333getCenterF1C5BW0();
        DrawContext drawContext = drawWithContent.getDrawContext();
        long jMo6341getSizeNHjbRc = drawContext.mo6341getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6347rotateUv8p0NA(fCardWithAnimatedBorder$lambda$2, jMo6333getCenterF1C5BW0);
            DrawScope.CC.y(drawWithContent, brush, Float.intBitsToFloat((int) (drawWithContent.mo6334getSizeNHjbRc() >> 32)), 0L, 0.0f, null, null, BlendMode.INSTANCE.m5810getSrcIn0nO6VwU(), 60, null);
            drawContext.getCanvas().restore();
            drawContext.mo6342setSizeuvyYCjk(jMo6341getSizeNHjbRc);
            drawWithContent.drawContent();
            return k0.f43947a;
        } catch (Throwable th2) {
            drawContext.getCanvas().restore();
            drawContext.mo6342setSizeuvyYCjk(jMo6341getSizeNHjbRc);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CardWithAnimatedBorder$lambda$4$1(Function2 function2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1310591749, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.CardWithAnimatedBorder.<anonymous>.<anonymous> (MsgPreview.kt:374)");
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer, 0);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CardWithAnimatedBorder$lambda$5(Modifier modifier, lb.a aVar, lb.a aVar2, List list, Function2 function2, int i10, int i11, Composer composer, int i12) {
        CardWithAnimatedBorder(modifier, aVar, aVar2, list, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void EditPreview(final MessageWithPartnerWithReactions msg, final String ownerId, final String ownerAlias, final lb.a onCancel, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(ownerAlias, "ownerAlias");
        kotlin.jvm.internal.y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1675975651);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerId) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerAlias) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCancel) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1675975651, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.EditPreview (MsgPreview.kt:133)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxWidth$default, materialTheme.getColorScheme(composerStartRestartGroup, i12).getPrimary(), null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(7), 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i12).getSurface(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(10));
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Modifier modifierA = e3.a(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA);
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.edit_msg, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i12).getBodyMedium(), materialTheme.getColorScheme(composerStartRestartGroup, i12).getPrimary(), 1, 15, composerStartRestartGroup, 221184, 1);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, ExtensionFunsKt.toShortMsg(msg, context, ownerId, ownerAlias), null, 0L, 3, 0, composerStartRestartGroup, 24576, 45);
            composerStartRestartGroup.endNode();
            IconButtonKt.IconButton(onCancel, null, false, null, null, null, ComposableSingletons$MsgPreviewKt.INSTANCE.getLambda$1754997669$app_productionPFast(), composerStartRestartGroup, ((i11 >> 9) & 14) | 1572864, 62);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgPreviewKt.EditPreview$lambda$1(msg, ownerId, ownerAlias, onCancel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 EditPreview$lambda$1(MessageWithPartnerWithReactions messageWithPartnerWithReactions, String str, String str2, lb.a aVar, int i10, Composer composer, int i11) {
        EditPreview(messageWithPartnerWithReactions, str, str2, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PinnedPreview(final String text, lb.a aVar, final lb.a onCancel, Composer composer, final int i10) {
        int i11;
        final lb.a onClick = aVar;
        kotlin.jvm.internal.y.i(text, "text");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(446111983);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCancel) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(446111983, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.PinnedPreview (MsgPreview.kt:188)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue;
            int i12 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenWidthDp;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion3.getEmpty()) {
                objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue4;
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion3.getEmpty()) {
                objRememberedValue5 = va.w.q(context.getString(R.string.pinned_message), context.getString(R.string.click_to_go_msg), context.getString(R.string.keep_pressing_to_show_preview), context.getString(R.string.slide_to_dismiss));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final List list = (List) objRememberedValue5;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion3.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MsgPreviewKt.PinnedPreview$lambda$0$13$0(mutableFloatState, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue6), 0.0f, 1, null), Dp.m8823constructorimpl(3));
            k0 k0Var = k0.f43947a;
            boolean zChanged = composerStartRestartGroup.changed(i12) | ((i11 & 896) == 256);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue7 == companion3.getEmpty()) {
                objRememberedValue7 = new MsgPreviewKt$PinnedPreview$1$2$1(mutableState, mutableFloatState, i12, onCancel);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierM1725padding3ABfNKs, k0Var, (PointerInputEventHandler) objRememberedValue7);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion3.getEmpty()) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.p
                    @Override // lb.a
                    public final Object invoke() {
                        return MsgPreviewKt.PinnedPreview$lambda$0$15$0(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            onClick = aVar;
            CardWithAnimatedBorder(modifierPointerInput, onClick, (lb.a) objRememberedValue8, null, ComposableLambdaKt.rememberComposableLambda(1080417939, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgPreviewKt.PinnedPreview$lambda$0$16(text, list, mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i11 & 112) | 24960, 8);
            boolean zPinnedPreview$lambda$0$7 = PinnedPreview$lambda$0$7(mutableState2);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == companion3.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.r
                    @Override // lb.a
                    public final Object invoke() {
                        return MsgPreviewKt.PinnedPreview$lambda$0$17$0(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Z17DialogsKt.Z17CustomDialog(zPinnedPreview$lambda$0$7, (lb.a) objRememberedValue9, ComposableLambdaKt.rememberComposableLambda(1473955483, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MsgPreviewKt.PinnedPreview$lambda$0$18(text, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 432);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgPreviewKt.PinnedPreview$lambda$1(text, onClick, onCancel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PinnedPreview$lambda$0$13$0(MutableFloatState mutableFloatState, GraphicsLayerScope graphicsLayer) {
        kotlin.jvm.internal.y.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationX(mutableFloatState.getFloatValue());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PinnedPreview$lambda$0$15$0(MutableState mutableState) {
        PinnedPreview$lambda$0$8(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PinnedPreview$lambda$0$16(String str, final List list, final MutableIntState mutableIntState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1080417939, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.PinnedPreview.<anonymous>.<anonymous> (MsgPreview.kt:264)");
            }
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            float f10 = 2;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1726paddingVpY3zN4);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            AnimatedVisibilityKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, PinnedPreview$lambda$0$16$1(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(1000, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(1000, 0, null, 6, null), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1131039749, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MsgPreviewKt.PinnedPreview$lambda$0$16$3$0(list, mutableIntState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1600518, 18);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, TextUtilsKt.removeHtmlTags(str), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), 0L, 1, 0, composer, 24576, 41);
            composer.endNode();
            Integer numValueOf = Integer.valueOf(mutableIntState.getIntValue());
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new MsgPreviewKt$PinnedPreview$1$4$2$1(mutableState, mutableIntState, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(numValueOf, (Function2) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final boolean PinnedPreview$lambda$0$16$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PinnedPreview$lambda$0$16$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PinnedPreview$lambda$0$16$3$0(List list, MutableIntState mutableIntState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1131039749, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.PinnedPreview.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MsgPreview.kt:282)");
        }
        Object obj = list.get(mutableIntState.getIntValue());
        kotlin.jvm.internal.y.h(obj, "get(...)");
        String str = (String) obj;
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, materialTheme.getTypography(composer, i11).getBodySmall(), materialTheme.getColorScheme(composer, i11).getPrimary(), 0, 0, composer, 0, 49);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PinnedPreview$lambda$0$17$0(MutableState mutableState) {
        PinnedPreview$lambda$0$8(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PinnedPreview$lambda$0$18(String str, final lb.a it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i10 |= composer.changedInstance(it) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1473955483, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.PinnedPreview.<anonymous>.<anonymous> (MsgPreview.kt:307)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            boolean z10 = (i10 & 14) == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.i
                    @Override // lb.a
                    public final Object invoke() {
                        return MsgPreviewKt.PinnedPreview$lambda$0$18$0$0$0(it);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            AttachContainerKt.DialogToDusTopBar((lb.a) objRememberedValue, composer, 0);
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue2 == companion2.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgPreviewKt.PinnedPreview$lambda$0$18$0$1$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function2 function2 = (Function2) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion2.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MsgPreviewKt.PinnedPreview$lambda$0$18$0$2$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            TextContentKt.m9893TextContentOadGlvw(str, 0L, function2, (Function2) objRememberedValue3, 0, null, composer, 3456, 50);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PinnedPreview$lambda$0$18$0$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PinnedPreview$lambda$0$18$0$1$0(MessageAction p10, int i10) {
        kotlin.jvm.internal.y.i(p10, "p1");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PinnedPreview$lambda$0$18$0$2$0(MessageAction p10, int i10) {
        kotlin.jvm.internal.y.i(p10, "p1");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PinnedPreview$lambda$0$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PinnedPreview$lambda$0$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PinnedPreview$lambda$0$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PinnedPreview$lambda$0$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PinnedPreview$lambda$1(String str, lb.a aVar, lb.a aVar2, int i10, Composer composer, int i11) {
        PinnedPreview(str, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ReplyPreview(final String ownerId, final String ownerAlias, final MessageWithPartnerWithReactions msg, final lb.a onCancel, Composer composer, final int i10) {
        int i11;
        String userSender;
        long jColor;
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(ownerAlias, "ownerAlias");
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(851476249);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(ownerId) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerAlias) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(msg) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCancel) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851476249, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.ReplyPreview (MsgPreview.kt:69)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            User senderUser = msg.getSenderUser();
            if (senderUser == null || (userSender = senderUser.getUsername()) == null) {
                userSender = msg.getMessage().getUserSender();
            }
            boolean zD = kotlin.jvm.internal.y.d(ownerId, userSender);
            String senderAlias = zD ? ownerAlias : msg.getSenderAlias();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            if (zD) {
                composerStartRestartGroup.startReplaceGroup(-2070061344);
                jColor = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2070060848);
                composerStartRestartGroup.endReplaceGroup();
                jColor = ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(userSender));
            }
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxWidth$default, jColor, null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(7), 0.0f, 0.0f, 0.0f, 14, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifierM1729paddingqDBjuR0$default, materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i12).getSurface(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(5), Dp.m8823constructorimpl(10));
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
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
            int i13 = i11;
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Modifier modifierA = e3.a(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA);
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, senderAlias, materialTheme.getTypography(composerStartRestartGroup, i12).getBodyMedium(), ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(senderAlias)), 1, 15, composerStartRestartGroup, 221184, 1);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, ExtensionFunsKt.toShortMsg(msg, context, ownerId, ownerAlias), null, 0L, 3, 0, composerStartRestartGroup, 24576, 45);
            composerStartRestartGroup.endNode();
            IconButtonKt.IconButton(onCancel, null, false, null, null, null, ComposableSingletons$MsgPreviewKt.INSTANCE.m9907getLambda$162533231$app_productionPFast(), composerStartRestartGroup, ((i13 >> 9) & 14) | 1572864, 62);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgPreviewKt.ReplyPreview$lambda$1(ownerId, ownerAlias, msg, onCancel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReplyPreview$lambda$1(String str, String str2, MessageWithPartnerWithReactions messageWithPartnerWithReactions, lb.a aVar, int i10, Composer composer, int i11) {
        ReplyPreview(str, str2, messageWithPartnerWithReactions, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
