package cu.todus.android.uiCompose.main.screen.chat.item;

import android.content.res.Configuration;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001al\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013²\u0006\u000e\u0010\u0011\u001a\u00020\u00108\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", "Lua/k0;", "onClick", "onLongClick", "", "canDrag", "onDragged", "Landroidx/compose/ui/Alignment;", "contentAlignment", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "content", "ChatItemBox", "(Landroidx/compose/ui/Modifier;Llb/a;Llb/a;ZLlb/a;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "", "horizontalDragging", "isDragging", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MessageContainerKt {
    /* JADX WARN: Code duplicated, block: B:101:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:102:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:106:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:111:0x020d  */
    /* JADX WARN: Code duplicated, block: B:114:0x022f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0234  */
    /* JADX WARN: Code duplicated, block: B:119:0x023e  */
    /* JADX WARN: Code duplicated, block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x008c  */
    /* JADX WARN: Code duplicated, block: B:40:0x008f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:46:0x009d  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x010b  */
    /* JADX WARN: Code duplicated, block: B:76:0x012f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0143  */
    /* JADX WARN: Code duplicated, block: B:80:0x0146  */
    /* JADX WARN: Code duplicated, block: B:83:0x015b  */
    /* JADX WARN: Code duplicated, block: B:84:0x015e  */
    /* JADX WARN: Code duplicated, block: B:89:0x016d  */
    /* JADX WARN: Code duplicated, block: B:94:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:97:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:98:0x01ba  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ChatItemBox(final Modifier modifier, final lb.a onClick, final lb.a onLongClick, boolean z10, final lb.a onDragged, final Alignment contentAlignment, final Function3 content, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z11;
        int i13;
        boolean z12;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z14;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableFloatState mutableFloatState;
        int i14;
        Object objRememberedValue2;
        MutableState mutableState;
        HapticFeedback hapticFeedback;
        Object objRememberedValue3;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        Object objRememberedValue4;
        boolean z19;
        lb.a constructor;
        boolean z20;
        boolean z21;
        Object objRememberedValue5;
        int i15;
        int i16;
        int i17;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        kotlin.jvm.internal.y.i(onDragged, "onDragged");
        kotlin.jvm.internal.y.i(contentAlignment, "contentAlignment");
        kotlin.jvm.internal.y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1088232374);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onLongClick) ? 256 : 128;
        }
        int i18 = i11 & 8;
        if (i18 == 0) {
            if ((i10 & 3072) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onDragged)) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i12 |= i17;
            }
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changed(contentAlignment)) {
                    i16 = 131072;
                } else {
                    i16 = 65536;
                }
                i12 |= i16;
            }
            if ((1572864 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i12 |= i15;
            }
            i13 = i12;
            if ((599187 & i13) != 599186) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                if (i18 != 0) {
                    z14 = true;
                } else {
                    z14 = z11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1088232374, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ChatItemBox (MessageContainer.kt:28)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue;
                i14 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenWidthDp;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                hapticFeedback = (HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                z15 = z14;
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MessageContainerKt.ChatItemBox$lambda$6$0(mutableFloatState, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) objRememberedValue3);
                if ((i13 & 7168) == 2048) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean zChanged = z16 | composerStartRestartGroup.changed(i14) | composerStartRestartGroup.changedInstance(hapticFeedback);
                if ((57344 & i13) == 16384) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = zChanged | z17;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z18 || objRememberedValue4 == companion.getEmpty()) {
                    z19 = z15;
                    MessageContainerKt$ChatItemBox$2$1 messageContainerKt$ChatItemBox$2$1 = new MessageContainerKt$ChatItemBox$2$1(z19, mutableState, mutableFloatState, i14, hapticFeedback, onDragged);
                    composerStartRestartGroup.updateRememberedValue(messageContainerKt$ChatItemBox$2$1);
                    objRememberedValue4 = messageContainerKt$ChatItemBox$2$1;
                } else {
                    z19 = z15;
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierGraphicsLayer, onDragged, (PointerInputEventHandler) objRememberedValue4);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment, false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
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
                Modifier.Companion companion3 = Modifier.INSTANCE;
                if ((i13 & 896) == 256) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                z21 = z20 | ((i13 & 112) == 32);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z21 || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new MessageContainerKt$ChatItemBox$3$1$1(onLongClick, onClick);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                content.invoke(SuspendingPointerInputFilterKt.pointerInput(companion3, onClick, (PointerInputEventHandler) objRememberedValue5), composerStartRestartGroup, Integer.valueOf((i13 >> 15) & 112));
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z19;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MessageContainerKt.ChatItemBox$lambda$9(modifier, onClick, onLongClick, z13, onDragged, contentAlignment, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        z11 = z10;
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onDragged)) {
                i17 = 16384;
            } else {
                i17 = 8192;
            }
            i12 |= i17;
        }
        if ((196608 & i10) == 0) {
            if (composerStartRestartGroup.changed(contentAlignment)) {
                i16 = 131072;
            } else {
                i16 = 65536;
            }
            i12 |= i16;
        }
        if ((1572864 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i15 = 1048576;
            } else {
                i15 = 524288;
            }
            i12 |= i15;
        }
        i13 = i12;
        if ((599187 & i13) != 599186) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
            if (i18 != 0) {
                z14 = true;
            } else {
                z14 = z11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1088232374, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ChatItemBox (MessageContainer.kt:28)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableFloatState = (MutableFloatState) objRememberedValue;
            i14 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenWidthDp;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            hapticFeedback = (HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            z15 = z14;
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MessageContainerKt.ChatItemBox$lambda$6$0(mutableFloatState, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) objRememberedValue3);
            if ((i13 & 7168) == 2048) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean zChanged2 = z16 | composerStartRestartGroup.changed(i14) | composerStartRestartGroup.changedInstance(hapticFeedback);
            if ((57344 & i13) == 16384) {
                z17 = true;
            } else {
                z17 = false;
            }
            z18 = zChanged2 | z17;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z18) {
                z19 = z15;
                MessageContainerKt$ChatItemBox$2$1 messageContainerKt$ChatItemBox$2$2 = new MessageContainerKt$ChatItemBox$2$1(z19, mutableState, mutableFloatState, i14, hapticFeedback, onDragged);
                composerStartRestartGroup.updateRememberedValue(messageContainerKt$ChatItemBox$2$2);
                objRememberedValue4 = messageContainerKt$ChatItemBox$2$2;
            } else {
                z19 = z15;
                MessageContainerKt$ChatItemBox$2$1 messageContainerKt$ChatItemBox$2$3 = new MessageContainerKt$ChatItemBox$2$1(z19, mutableState, mutableFloatState, i14, hapticFeedback, onDragged);
                composerStartRestartGroup.updateRememberedValue(messageContainerKt$ChatItemBox$2$3);
                objRememberedValue4 = messageContainerKt$ChatItemBox$2$3;
            }
            Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierGraphicsLayer2, onDragged, (PointerInputEventHandler) objRememberedValue4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment, false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput2);
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
            Modifier.Companion companion5 = Modifier.INSTANCE;
            if ((i13 & 896) == 256) {
                z20 = true;
            } else {
                z20 = false;
            }
            z21 = z20 | ((i13 & 112) == 32);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z21) {
                objRememberedValue5 = new MessageContainerKt$ChatItemBox$3$1$1(onLongClick, onClick);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new MessageContainerKt$ChatItemBox$3$1$1(onLongClick, onClick);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            content.invoke(SuspendingPointerInputFilterKt.pointerInput(companion5, onClick, (PointerInputEventHandler) objRememberedValue5), composerStartRestartGroup, Integer.valueOf((i13 >> 15) & 112));
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z19;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z13 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MessageContainerKt.ChatItemBox$lambda$9(modifier, onClick, onLongClick, z13, onDragged, contentAlignment, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatItemBox$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChatItemBox$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatItemBox$lambda$6$0(MutableFloatState mutableFloatState, GraphicsLayerScope graphicsLayer) {
        kotlin.jvm.internal.y.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationX(mutableFloatState.getFloatValue());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ChatItemBox$lambda$9(Modifier modifier, lb.a aVar, lb.a aVar2, boolean z10, lb.a aVar3, Alignment alignment, Function3 function3, int i10, int i11, Composer composer, int i12) {
        ChatItemBox(modifier, aVar, aVar2, z10, aVar3, alignment, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
