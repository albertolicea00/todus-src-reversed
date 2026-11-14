package cu.todus.android.uiCompose.main.screen.chat.input;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.MoodKt;
import androidx.compose.material.icons.outlined.AttachFileKt;
import androidx.compose.material.icons.outlined.CameraAltKt;
import androidx.compose.material.icons.outlined.KeyboardAltKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.R;
import cu.todus.android.uiCompose.theme.Other;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.e1;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a©\u0001\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u000f\u0010\u001b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006%²\u0006\f\u0010\u001d\u001a\u00020\u000f8\nX\u008a\u0084\u0002²\u0006\f\u0010\u001f\u001a\u00020\u001e8\nX\u008a\u0084\u0002²\u0006\u000e\u0010 \u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010!\u001a\u00020\u00058\nX\u008a\u0084\u0002²\u0006\u000e\u0010\"\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010$\u001a\u00020#8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "", "Lua/k0;", "onMessageSend", "Lkotlin/Function0;", "onStartAudioRecord", "onAudioRecorded", "onAudioCanceled", "onAttachedClicked", "onStickerClicked", "onImageOpen", "", "isPickingFiles", "", "actualRecorderTime", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "stickerKeyboardOpen", "ChatInput", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;ZJLandroidx/compose/ui/focus/FocusRequester;ZLandroidx/compose/runtime/Composer;III)V", "empty", "ChatTextField", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/focus/FocusRequester;Llb/a;ZLandroidx/compose/runtime/Composer;II)V", "RecordIndicator", "(Landroidx/compose/runtime/Composer;I)V", "isInputEmpty", "", "inputLength", "isRecording", "formattedTime", "isMid", "Landroidx/compose/ui/graphics/Color;", "animatedColor", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatInputKt {

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.input.ChatInputKt$ChatTextField$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "innerTextField", "<anonymous>", "(Llb/a;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 implements TextFieldDecorator {
        final /* synthetic */ lb.a $empty;

        public AnonymousClass1(lb.a aVar) {
            this.$empty = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 Decoration$lambda$1(AnonymousClass1 anonymousClass1, Function2 function2, int i10, Composer composer, int i11) {
            anonymousClass1.Decoration(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
            return k0.f43947a;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        @Composable
        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
        public final void Decoration(final Function2 innerTextField, Composer composer, final int i10) {
            int i11;
            kotlin.jvm.internal.y.i(innerTextField, "innerTextField");
            Composer composerStartRestartGroup = composer.startRestartGroup(-314998682);
            if ((i10 & 6) == 0) {
                i11 = (composerStartRestartGroup.changedInstance(innerTextField) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 48) == 0) {
                i11 |= composerStartRestartGroup.changed(this) ? 32 : 16;
            }
            int i12 = i11;
            if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-314998682, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.input.ChatTextField.<no name provided>.Decoration (ChatInput.kt:355)");
                }
                Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(Modifier.INSTANCE, Dp.m8823constructorimpl(4), Dp.m8823constructorimpl(12));
                Alignment centerStart = Alignment.INSTANCE.getCenterStart();
                lb.a aVar = this.$empty;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                lb.a constructor = companion.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (((Boolean) aVar.invoke()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(885251462);
                    String strStringResource = StringResources_androidKt.stringResource(R.string.message_hint, composerStartRestartGroup, 0);
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i13 = MaterialTheme.$stable;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, materialTheme.getTypography(composerStartRestartGroup, i13).getBodyLarge(), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i13).getOnBackground(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0, 0, composerStartRestartGroup, 0, 49);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(885543606);
                    composerStartRestartGroup.endReplaceGroup();
                }
                innerTextField.invoke(composerStartRestartGroup, Integer.valueOf(i12 & 14));
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.s
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatInputKt.AnonymousClass1.Decoration$lambda$1(this.f24787c, innerTextField, i10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"UnrememberedMutableState"})
    public static final void ChatInput(final TextFieldState state, Modifier modifier, final Function1 onMessageSend, final lb.a onStartAudioRecord, final lb.a onAudioRecorded, final lb.a onAudioCanceled, final lb.a onAttachedClicked, final lb.a onStickerClicked, final lb.a onImageOpen, final boolean z10, long j10, final FocusRequester focusRequester, final boolean z11, Composer composer, final int i10, final int i11, final int i12) {
        int i13;
        int i14;
        final long j11;
        Composer composer2;
        Object obj;
        int i15;
        Composer composer3;
        final MutableState mutableState;
        final lb.a aVar;
        kotlin.jvm.internal.y.i(state, "state");
        kotlin.jvm.internal.y.i(onMessageSend, "onMessageSend");
        kotlin.jvm.internal.y.i(onStartAudioRecord, "onStartAudioRecord");
        kotlin.jvm.internal.y.i(onAudioRecorded, "onAudioRecorded");
        kotlin.jvm.internal.y.i(onAudioCanceled, "onAudioCanceled");
        kotlin.jvm.internal.y.i(onAttachedClicked, "onAttachedClicked");
        kotlin.jvm.internal.y.i(onStickerClicked, "onStickerClicked");
        kotlin.jvm.internal.y.i(onImageOpen, "onImageOpen");
        kotlin.jvm.internal.y.i(focusRequester, "focusRequester");
        Composer composerStartRestartGroup = composer.startRestartGroup(1040257607);
        if ((i10 & 6) == 0) {
            i13 = i10 | (composerStartRestartGroup.changed(state) ? 4 : 2);
        } else {
            i13 = i10;
        }
        int i16 = i12 & 2;
        if (i16 != 0) {
            i13 |= 48;
        } else if ((i10 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onMessageSend) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onStartAudioRecord) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onAudioRecorded) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onAudioCanceled) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onAttachedClicked) ? 1048576 : 524288;
        }
        if ((12582912 & i10) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onStickerClicked) ? 8388608 : 4194304;
        }
        if ((100663296 & i10) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onImageOpen) ? 67108864 : 33554432;
        }
        if ((805306368 & i10) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i17 = i13;
        if ((i11 & 6) == 0) {
            i14 = i11 | (composerStartRestartGroup.changed(j10) ? 4 : 2);
        } else {
            i14 = i11;
        }
        if ((i11 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(focusRequester) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        int i18 = i14;
        if (composerStartRestartGroup.shouldExecute(((i17 & 306783379) == 306783378 && (i18 & 147) == 146) ? false : true, i17 & 1)) {
            Modifier modifier2 = i16 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1040257607, i17, i18, "cu.todus.android.uiCompose.main.screen.chat.input.ChatInput (ChatInput.kt:82)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.n
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(ChatInputKt.ChatInput$lambda$0$0(state));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final State state2 = (State) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.d
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(ChatInputKt.ChatInput$lambda$2$0(state));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            State state3 = (State) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue3 = mutableStateMutableStateOf$default;
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                obj = null;
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.v.e(PermissionNeedIt.RECORD_AUDIO), 1, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                obj = null;
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue4;
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            float f10 = 8;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, obj), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Modifier modifier3 = modifier2;
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
            Modifier.Companion companion4 = Modifier.INSTANCE;
            float f11 = 24;
            float f12 = 4;
            Modifier modifierM1726paddingVpY3zN5 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(ShadowKt.m5480shadows4CzXII$default(SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), Dp.m8823constructorimpl(2), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)), false, 0L, 0L, 28, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f12));
            Alignment.Vertical bottom = companion2.getBottom();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getEnd(), bottom, composerStartRestartGroup, 54);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN5);
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            int i19 = (i17 >> 15) & 896;
            IconButtonKt.InputOption(null, (ChatInput$lambda$5(mutableState2) || z11) ? false : true, onStickerClicked, MoodKt.getMood(Icons.INSTANCE.getDefault()), composerStartRestartGroup, i19, 1);
            boolean z12 = !ChatInput$lambda$5(mutableState2) && z11;
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            IconButtonKt.InputOption(null, z12, onStickerClicked, KeyboardAltKt.getKeyboardAlt(outlined), composerStartRestartGroup, i19, 1);
            composerStartRestartGroup.endNode();
            j11 = j10;
            modifier = modifier3;
            CrossfadeKt.Crossfade(Boolean.valueOf(ChatInput$lambda$5(mutableState2)), e3.a(rowScopeInstance, companion4, 1.0f, false, 2, null), AnimationSpecKt.tween$default(300, 0, null, 6, null), "input_record_crossfade", ComposableLambdaKt.rememberComposableLambda(-148752770, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ChatInputKt.ChatInput$lambda$8$0$1(state, focusRequester, z11, onAudioCanceled, mutableState2, state2, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 28032, 0);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.m1613spacedBy0680j_4(Dp.m8823constructorimpl(f12)), companion2.getBottom(), composerStartRestartGroup, 54);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
            lb.a constructor4 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            IconButtonKt.InputOption(null, ChatInput$lambda$1(state2) && !ChatInput$lambda$5(mutableState2), onAttachedClicked, AttachFileKt.getAttachFile(outlined), composerStartRestartGroup, (i17 >> 12) & 896, 1);
            IconButtonKt.InputOption(null, ChatInput$lambda$1(state2) && !ChatInput$lambda$5(mutableState2), onImageOpen, CameraAltKt.getCameraAlt(outlined), composerStartRestartGroup, (i17 >> 18) & 896, 1);
            IconButtonKt.InputOptionAnimateVisibility(null, ChatInput$lambda$5(mutableState2), ComposableLambdaKt.rememberComposableLambda(-1199531370, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ChatInputKt.ChatInput$lambda$8$0$2$0(j11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            boolean z13 = ChatInput$lambda$1(state2) && !z10;
            int iChatInput$lambda$3 = ChatInput$lambda$3(state3);
            boolean zChatInput$lambda$5 = ChatInput$lambda$5(mutableState2);
            int i20 = 57344 & i17;
            boolean z14 = (i20 == 16384) | ((1879048192 & i17) == 536870912) | ((i17 & 896) == 256) | ((i17 & 14) == 4);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue5 == companion.getEmpty()) {
                i15 = i20;
                composer3 = composerStartRestartGroup;
                mutableState = mutableState2;
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.g
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatInputKt.ChatInput$lambda$8$0$2$1$0(z10, onMessageSend, state, mutableState, onAudioRecorded, state2);
                    }
                };
                aVar = onAudioRecorded;
                composer3.updateRememberedValue(aVar2);
                objRememberedValue5 = aVar2;
            } else {
                aVar = onAudioRecorded;
                i15 = i20;
                composer3 = composerStartRestartGroup;
                mutableState = mutableState2;
            }
            lb.a aVar3 = (lb.a) objRememberedValue5;
            boolean z15 = (i15 == 16384) | ((i17 & 7168) == 2048);
            Object objRememberedValue6 = composer3.rememberedValue();
            if (z15 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.h
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatInputKt.ChatInput$lambda$8$0$2$2$0(mutableState, mutableState3, onStartAudioRecord, aVar);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue6);
            }
            lb.a aVar4 = (lb.a) objRememberedValue6;
            boolean z16 = i15 == 16384;
            Object objRememberedValue7 = composer3.rememberedValue();
            if (z16 || objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.o
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatInputKt.ChatInput$lambda$8$0$2$3$0(aVar, mutableState);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue7);
            }
            Composer composer4 = composer3;
            ChatSendButtonKt.SendBtn2(iChatInput$lambda$3, companion4, z13, zChatInput$lambda$5, aVar3, aVar4, (lb.a) objRememberedValue7, composer4, 48, 0);
            composer4.endNode();
            composer4.endNode();
            composer4.endNode();
            PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState3.getValue();
            Object objRememberedValue8 = composer4.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.p
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                composer4.updateRememberedValue(objRememberedValue8);
            }
            lb.a aVar5 = (lb.a) objRememberedValue8;
            Object objRememberedValue9 = composer4.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatInputKt.ChatInput$lambda$10$0(mutableState3, (PermissionsResult) obj2);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue9);
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar5, permissionsRequesterState, (Function1) objRememberedValue9, ComposableSingletons$ChatInputKt.INSTANCE.getLambda$1661362343$app_productionPFast(), composer4, 27696, 1);
            composer2 = composer4;
            PermissionsRequesterState permissionsRequesterState2 = (PermissionsRequesterState) mutableState3.getValue();
            String packageName = context.getPackageName();
            kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
            Object objRememberedValue10 = composer2.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.r
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatInputKt.ChatInput$lambda$11$0(mutableState3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue10);
            }
            lb.a aVar6 = (lb.a) objRememberedValue10;
            Object objRememberedValue11 = composer2.rememberedValue();
            if (objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatInputKt.ChatInput$lambda$12$0(mutableState3, (PermissionsResult) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue11);
            }
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState2, aVar6, (Function1) objRememberedValue11, packageName, composer2, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            j11 = j10;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        final Modifier modifier4 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j12 = j11;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ChatInputKt.ChatInput$lambda$13(state, modifier4, onMessageSend, onStartAudioRecord, onAudioRecorded, onAudioCanceled, onAttachedClicked, onStickerClicked, onImageOpen, z10, j12, focusRequester, z11, i10, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final void ChatInput$cancelRecord(lb.a aVar, MutableState<Boolean> mutableState) {
        ChatInput$lambda$6(mutableState, false);
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatInput$lambda$0$0(TextFieldState textFieldState) {
        return le.d0.q0(textFieldState.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatInput$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatInput$lambda$10$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatInput$lambda$11$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatInput$lambda$12$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatInput$lambda$13(TextFieldState textFieldState, Modifier modifier, Function1 function1, lb.a aVar, lb.a aVar2, lb.a aVar3, lb.a aVar4, lb.a aVar5, lb.a aVar6, boolean z10, long j10, FocusRequester focusRequester, boolean z11, int i10, int i11, int i12, Composer composer, int i13) {
        ChatInput(textFieldState, modifier, function1, aVar, aVar2, aVar3, aVar4, aVar5, aVar6, z10, j10, focusRequester, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ChatInput$lambda$2$0(TextFieldState textFieldState) {
        return textFieldState.getText().length();
    }

    private static final int ChatInput$lambda$3(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final boolean ChatInput$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatInput$lambda$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatInput$lambda$8$0$1(TextFieldState textFieldState, FocusRequester focusRequester, boolean z10, final lb.a aVar, final MutableState mutableState, final State state, boolean z11, Composer composer, int i10) {
        int i11;
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(z11) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-148752770, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.input.ChatInput.<anonymous>.<anonymous>.<anonymous> (ChatInput.kt:168)");
            }
            if (z11) {
                composer.startReplaceGroup(912575744);
                Modifier.Companion companion = Modifier.INSTANCE;
                float f10 = 4;
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.m1754defaultMinSizeVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(48), 1, null), Dp.m8823constructorimpl(f10), 0.0f, 2, null);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer, 48);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1727paddingVpY3zN4$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                RecordIndicator(composer, 0);
                Modifier modifierClip = ClipKt.clip(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(26)), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(12)));
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i12 = MaterialTheme.$stable;
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierClip, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i12).getError(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                boolean zChanged = composer.changed(aVar);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.l
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatInputKt.ChatInput$lambda$8$0$1$0$0$0(aVar, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(ClickableKt.m1240clickableoSLSa3U$default(modifierM1205backgroundbw27NRU$default, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(10), 0.0f, 2, null);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.m1613spacedBy0680j_4(Dp.m8823constructorimpl(f10)), companion2.getCenterVertically(), composer, 54);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1727paddingVpY3zN4$default2);
                lb.a constructor2 = companion3.getConstructor();
                if (!defpackage.r.a(composer.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(14)), CloseKt.getClose(Icons.INSTANCE.getDefault()), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer, i12).getError(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.cancel, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i12).getLabelSmall(), 0L, 0L, FontWeight.INSTANCE.getMedium(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), materialTheme.getColorScheme(composer, i12).getError(), 0, 0, composer, 0, 49);
                composer.endNode();
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(914217287);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.m
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(ChatInputKt.ChatInput$lambda$1(state));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ChatTextField(textFieldState, modifierFillMaxWidth$default, focusRequester, (lb.a) objRememberedValue2, z10, composer, 3120, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatInput$lambda$8$0$1$0$0$0(lb.a aVar, MutableState mutableState) {
        ChatInput$cancelRecord(aVar, mutableState);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatInput$lambda$8$0$2$0(final long j10, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1199531370, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.input.ChatInput.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatInput.kt:237)");
            }
            boolean zChanged = composer.changed(j10);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.k
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatInputKt.ChatInput$lambda$8$0$2$0$0$0(j10);
                    }
                });
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(48)), Alignment.INSTANCE.getCenterVertically(), false, 2, null), 0.0f, 0.0f, Dp.m8823constructorimpl(8), 0.0f, 11, null);
            String strChatInput$lambda$8$0$2$0$1 = ChatInput$lambda$8$0$2$0$1((State) objRememberedValue);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1729paddingqDBjuR0$default, strChatInput$lambda$8$0$2$0$1, materialTheme.getTypography(composer, i11).getBodyLarge(), materialTheme.getColorScheme(composer, i11).getPrimary(), 0, 0, composer, 6, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ChatInput$lambda$8$0$2$0$0$0(long j10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(j10);
        long seconds = timeUnit.toSeconds(j10) - TimeUnit.MINUTES.toSeconds(minutes);
        e1 e1Var = e1.f36604a;
        String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
        kotlin.jvm.internal.y.h(str, "format(...)");
        return str;
    }

    private static final String ChatInput$lambda$8$0$2$0$1(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatInput$lambda$8$0$2$1$0(boolean z10, Function1 function1, TextFieldState textFieldState, MutableState mutableState, lb.a aVar, State state) {
        if (ChatInput$lambda$5(mutableState)) {
            ChatInput$stopRecord(aVar, mutableState);
        } else if (!ChatInput$lambda$1(state) || z10) {
            function1.invoke(textFieldState.getText().toString());
            TextFieldStateKt.clearText(textFieldState);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatInput$lambda$8$0$2$2$0(MutableState mutableState, MutableState mutableState2, lb.a aVar, lb.a aVar2) {
        if (!ChatInput$lambda$5(mutableState)) {
            ChatInput$startRecord(mutableState2, aVar, aVar2, mutableState);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatInput$lambda$8$0$2$3$0(lb.a aVar, MutableState mutableState) {
        ChatInput$stopRecord(aVar, mutableState);
        return k0.f43947a;
    }

    private static final void ChatInput$startRecord(MutableState<PermissionsRequesterState> mutableState, lb.a aVar, lb.a aVar2, MutableState<Boolean> mutableState2) {
        Integer state = mutableState.getValue().getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            ChatInput$lambda$6(mutableState2, true);
            aVar.invoke();
        } else {
            ChatInput$stopRecord(aVar2, mutableState2);
            mutableState.setValue(PermissionsRequesterState.copy$default(mutableState.getValue(), null, true, null, 5, null));
        }
    }

    private static final void ChatInput$stopRecord(lb.a aVar, MutableState<Boolean> mutableState) {
        aVar.invoke();
        ChatInput$lambda$6(mutableState, false);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:26:0x005a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0092  */
    /* JADX WARN: Code duplicated, block: B:50:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0166  */
    /* JADX WARN: Code duplicated, block: B:58:0x016c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0176  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ChatTextField(final TextFieldState state, Modifier modifier, final FocusRequester focusRequester, final lb.a empty, final boolean z10, Composer composer, final int i10, final int i11) {
        int i12;
        Modifier modifier2;
        boolean z11;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i13;
        int i14;
        int i15;
        kotlin.jvm.internal.y.i(state, "state");
        kotlin.jvm.internal.y.i(focusRequester, "focusRequester");
        kotlin.jvm.internal.y.i(empty, "empty");
        Composer composerStartRestartGroup = composer.startRestartGroup(2054359005);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        int i16 = i11 & 2;
        if (i16 == 0) {
            if ((i10 & 48) == 0) {
                modifier2 = modifier;
                i12 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i12 |= i15;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(empty)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i12 |= i14;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changed(z10)) {
                    i13 = 16384;
                } else {
                    i13 = 8192;
                }
                i12 |= i13;
            }
            if ((i12 & 9363) != 9362) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                if (i16 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2054359005, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.input.ChatTextField (ChatInput.kt:338)");
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1754defaultMinSizeVpY3zN4$default(FocusRequesterModifierKt.focusRequester(modifier4, focusRequester), 0.0f, Dp.m8823constructorimpl(48), 1, null), 0.0f, 1, null);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i17 = MaterialTheme.$stable;
                Modifier modifier5 = modifier4;
                BasicTextFieldKt.BasicTextField(state, modifierFillMaxWidth$default, !z10, false, InputTransformationKt.maxLength(InputTransformation.INSTANCE, 65536), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i17).getBodyLarge(), materialTheme.getColorScheme(composerStartRestartGroup, i17).getOnBackground(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), KeyboardOptions.m2080copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8478getSentencesIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 126, (Object) null), (KeyboardActionHandler) null, (TextFieldLineLimits) new TextFieldLineLimits.MultiLine(0, 3, 1, null), (Function2) null, (MutableInteractionSource) null, (Brush) new SolidColor(ColorKt.Color(4278225275L), null), (OutputTransformation) null, (TextFieldDecorator) new AnonymousClass1(empty), (ScrollState) null, composerStartRestartGroup, (i12 & 14) | 100687872, 48, 22152);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatInputKt.ChatTextField$lambda$0(state, modifier3, focusRequester, empty, z10, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        modifier2 = modifier;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changed(focusRequester)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i12 |= i15;
        }
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(empty)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i12 |= i14;
        }
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changed(z10)) {
                i13 = 16384;
            } else {
                i13 = 8192;
            }
            i12 |= i13;
        }
        if ((i12 & 9363) != 9362) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            if (i16 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054359005, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.input.ChatTextField (ChatInput.kt:338)");
            }
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(SizeKt.m1754defaultMinSizeVpY3zN4$default(FocusRequesterModifierKt.focusRequester(modifier4, focusRequester), 0.0f, Dp.m8823constructorimpl(48), 1, null), 0.0f, 1, null);
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i18 = MaterialTheme.$stable;
            Modifier modifier6 = modifier4;
            BasicTextFieldKt.BasicTextField(state, modifierFillMaxWidth$default2, !z10, false, InputTransformationKt.maxLength(InputTransformation.INSTANCE, 65536), TextStyle.m8271copyp1EtxEg$default(materialTheme2.getTypography(composerStartRestartGroup, i18).getBodyLarge(), materialTheme2.getColorScheme(composerStartRestartGroup, i18).getOnBackground(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), KeyboardOptions.m2080copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8478getSentencesIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 126, (Object) null), (KeyboardActionHandler) null, (TextFieldLineLimits) new TextFieldLineLimits.MultiLine(0, 3, 1, null), (Function2) null, (MutableInteractionSource) null, (Brush) new SolidColor(ColorKt.Color(4278225275L), null), (OutputTransformation) null, (TextFieldDecorator) new AnonymousClass1(empty), (ScrollState) null, composerStartRestartGroup, (i12 & 14) | 100687872, 48, 22152);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatInputKt.ChatTextField$lambda$0(state, modifier3, focusRequester, empty, z10, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatTextField$lambda$0(TextFieldState textFieldState, Modifier modifier, FocusRequester focusRequester, lb.a aVar, boolean z10, int i10, int i11, Composer composer, int i12) {
        ChatTextField(textFieldState, modifier, focusRequester, aVar, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RecordIndicator(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-738499009);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-738499009, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.input.RecordIndicator (ChatInput.kt:373)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            long jM10118getRed0d7_KjU = !RecordIndicator$lambda$1(mutableState) ? Other.INSTANCE.m10118getRed0d7_KjU() : Other.INSTANCE.m10119getRedVariant0d7_KjU();
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(XMPPTCPConnection.PacketWriter.QUEUE_SIZE, 0, null, 6, null);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.ChatInputKt$RecordIndicator$animatedColor$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m9887invoke8_81llA(((Color) obj).m5876unboximpl());
                        return k0.f43947a;
                    }

                    /* JADX INFO: renamed from: invoke-8_81llA, reason: not valid java name */
                    public final void m9887invoke8_81llA(long j10) {
                        MutableState<Boolean> mutableState2 = mutableState;
                        ChatInputKt.RecordIndicator$lambda$2(mutableState2, !ChatInputKt.RecordIndicator$lambda$1(mutableState2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final State<Color> stateM1076animateColorAsStateeuL9pac = SingleValueAnimationKt.m1076animateColorAsStateeuL9pac(jM10118getRed0d7_KjU, tweenSpecTween$default, "aci", (Function1) objRememberedValue2, composerStartRestartGroup, 3504, 0);
            float f10 = 15;
            Modifier modifierM1771sizeVpY3zN4 = SizeKt.m1771sizeVpY3zN4(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8823constructorimpl(10), 0.0f, Dp.m8823constructorimpl(5), 0.0f, 10, null), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10));
            boolean zChanged = composerStartRestartGroup.changed(stateM1076animateColorAsStateeuL9pac);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatInputKt.RecordIndicator$lambda$5$0(stateM1076animateColorAsStateeuL9pac, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierDrawBehind = DrawModifierKt.drawBehind(modifierM1771sizeVpY3zN4, (Function1) objRememberedValue3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawBehind);
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
            k0 k0Var = k0.f43947a;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new ChatInputKt$RecordIndicator$2$1$1(mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue4, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.input.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatInputKt.RecordIndicator$lambda$7(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RecordIndicator$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecordIndicator$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final long RecordIndicator$lambda$4(State<Color> state) {
        return state.getValue().m5876unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RecordIndicator$lambda$5$0(State state, DrawScope drawBehind) {
        kotlin.jvm.internal.y.i(drawBehind, "$this$drawBehind");
        DrawScope.CC.z(drawBehind, RecordIndicator$lambda$4(state), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RecordIndicator$lambda$7(int i10, Composer composer, int i11) {
        RecordIndicator(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
