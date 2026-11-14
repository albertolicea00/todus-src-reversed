package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CallEndKt;
import androidx.compose.material.icons.outlined.CallKt;
import androidx.compose.material.icons.outlined.VideocamKt;
import androidx.compose.material.icons.outlined.VideocamOffKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.utils.Base64Util;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aU\u0010\n\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "", "ownerId", "CallContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CallContentKt {
    /* JADX WARN: Code duplicated, block: B:100:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:101:0x02e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:103:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:106:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:109:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:110:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:115:0x03f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:117:0x03f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:119:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:122:0x0460  */
    /* JADX WARN: Code duplicated, block: B:128:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:131:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:133:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:136:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:139:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:52:0x010d  */
    /* JADX WARN: Code duplicated, block: B:55:0x011b  */
    /* JADX WARN: Code duplicated, block: B:73:0x0197 A[Catch: Exception -> 0x01a2, TRY_LEAVE, TryCatch #0 {Exception -> 0x01a2, blocks: (B:64:0x0159, B:66:0x0166, B:71:0x017e, B:73:0x0197, B:68:0x016d, B:70:0x0179), top: B:139:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:79:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:90:0x022b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0237  */
    /* JADX WARN: Code duplicated, block: B:94:0x023b  */
    /* JADX WARN: Code duplicated, block: B:99:0x02d7 A[DONT_INVERT] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CallContent(final MessageWithPartnerWithReactions msg, final Function2 onClick, final Function2 onLongClick, String str, Composer composer, final int i10, final int i11) {
        int i12;
        String str2;
        boolean z10;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str4;
        Object objRememberedValue;
        Composer.Companion companion;
        lb.a constructor;
        Object objRememberedValue2;
        CallContent callContent;
        Object objRememberedValue3;
        boolean zD;
        List listS0;
        boolean zBooleanValue;
        Object objRememberedValue4;
        Composer.Companion companion2;
        boolean zBooleanValue2;
        lb.a constructor2;
        ImageVector call;
        lb.a constructor3;
        int i13;
        Object objRememberedValue5;
        boolean zD2;
        boolean z11;
        boolean z12;
        Iterator<T> it;
        Attachment attachment;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(106416105);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i14 = i11 & 8;
        if (i14 == 0) {
            if ((i10 & 3072) == 0) {
                str2 = str;
                i12 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
            }
            if ((i12 & 1043) != 1042) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i14 != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(106416105, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.CallContent (CallContent.kt:45)");
                }
                Modifier.Companion companion3 = Modifier.INSTANCE;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = CallContentKt$CallContent$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion3, onClick, (PointerInputEventHandler) objRememberedValue);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
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
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    it = msg.getAttachments().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        attachment = (Attachment) it.next();
                        if (attachment.getContent().getType() != 32 && (attachment.getContent() instanceof CallContent)) {
                            Content content = attachment.getContent();
                            kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.CallContent");
                            objRememberedValue2 = (CallContent) content;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            break;
                        }
                    }
                }
                callContent = (CallContent) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    try {
                        if (!le.a0.U(callContent.getState(), "CALL", false, 2, null) || (strDecodedMessage$default = Base64Util.decodedMessage$default(Base64Util.INSTANCE, callContent.getState(), 0, 2, null)) == null) {
                        }
                        listS0 = le.d0.S0(strDecodedMessage$default, new String[]{" "}, false, 0, 6, null);
                        if (listS0.size() > 2) {
                            zD = kotlin.jvm.internal.y.d(listS0.get(2), "1");
                        } else {
                            zD = false;
                        }
                    } catch (Exception unused) {
                    }
                    objRememberedValue3 = Boolean.valueOf(zD);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                zBooleanValue = ((Boolean) objRememberedValue3).booleanValue();
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (objRememberedValue4 == companion2.getEmpty()) {
                    zD2 = kotlin.jvm.internal.y.d(callContent.getUserId(), str4);
                    if (callContent.getStartTime() == -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (zD2 && z11) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = Boolean.valueOf(z12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                zBooleanValue2 = ((Boolean) objRememberedValue4).booleanValue();
                Modifier.Companion companion5 = Modifier.INSTANCE;
                Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth(companion5, 0.7f), Dp.m8823constructorimpl(60));
                Alignment.Companion companion6 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion6.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1755height3ABfNKs);
                ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                constructor2 = companion7.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion7.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion7.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion7.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion7.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxHeight$default(companion5, 0.0f, 1, null), 1.0f, false, 2, null);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i15 = MaterialTheme.$stable;
                float f10 = 15;
                float f11 = 10;
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth(SizeKt.fillMaxHeight$default(BackgroundKt.m1204backgroundbw27NRU(modifierAspectRatio$default, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i15).getPrimary(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 6, null)), 0.0f, 1, null), 0.2f), Dp.m8823constructorimpl(f11), 0.0f, 2, null);
                if (!zBooleanValue2 && zBooleanValue) {
                    call = VideocamOffKt.getVideocamOff(Icons.Outlined.INSTANCE);
                } else if (zBooleanValue2) {
                    call = CallEndKt.getCallEnd(Icons.Outlined.INSTANCE);
                } else if (zBooleanValue) {
                    call = VideocamKt.getVideocam(Icons.Outlined.INSTANCE);
                } else {
                    call = CallKt.getCall(Icons.Outlined.INSTANCE);
                }
                String str5 = str4;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1727paddingVpY3zN4$default, call, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 3072, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composerStartRestartGroup = composerStartRestartGroup;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxHeight$default(androidx.compose.foundation.layout.e3.a(rowScopeInstance, companion5, 1.0f, false, 2, null), 0.0f, 1, null), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i15).getPrimary(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(0.0f, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 9, null)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion6.getStart(), composerStartRestartGroup, 6);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
                constructor3 = companion7.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion7.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion7.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion7.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                if (!zBooleanValue2 && zBooleanValue) {
                    i13 = R.string.missed_video_call;
                } else if (zBooleanValue2) {
                    i13 = R.string.missed_call;
                } else if (zBooleanValue) {
                    i13 = R.string.video_call;
                } else {
                    i13 = R.string.call;
                }
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(i13, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    objRememberedValue5 = Long.valueOf(callContent.getEndTime() - callContent.getStartTime());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                long jLongValue = ((Number) objRememberedValue5).longValue();
                if (callContent.getEndTime() > 0 || callContent.getStartTime() <= 0) {
                    composerStartRestartGroup.startReplaceGroup(811066745);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(810803431);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(companion5, companion6.getEnd()), NumberInlineFunctionsKt.humanDuration(jLongValue), materialTheme.getTypography(composerStartRestartGroup, i15).getLabelSmall(), 0L, 0, 0, composerStartRestartGroup, 0, 56);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CallContentKt.CallContent$lambda$2(msg, onClick, onLongClick, str3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        str2 = str;
        if ((i12 & 1043) != 1042) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            if (i14 != 0) {
                str4 = "";
            } else {
                str4 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(106416105, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.CallContent (CallContent.kt:45)");
            }
            Modifier.Companion companion8 = Modifier.INSTANCE;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = CallContentKt$CallContent$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(companion8, onClick, (PointerInputEventHandler) objRememberedValue);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput2);
            ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
            constructor = companion9.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion9.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                it = msg.getAttachments().iterator();
                while (true) {
                    if (it.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    attachment = (Attachment) it.next();
                    if (attachment.getContent().getType() != 32) {
                    }
                }
            }
            callContent = (CallContent) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                String strDecodedMessage$default = !le.a0.U(callContent.getState(), "CALL", false, 2, null) ? callContent.getState() : callContent.getState();
                listS0 = le.d0.S0(strDecodedMessage$default, new String[]{" "}, false, 0, 6, null);
                if (listS0.size() > 2) {
                    zD = kotlin.jvm.internal.y.d(listS0.get(2), "1");
                } else {
                    zD = false;
                }
                objRememberedValue3 = Boolean.valueOf(zD);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            zBooleanValue = ((Boolean) objRememberedValue3).booleanValue();
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            companion2 = Composer.INSTANCE;
            if (objRememberedValue4 == companion2.getEmpty()) {
                zD2 = kotlin.jvm.internal.y.d(callContent.getUserId(), str4);
                if (callContent.getStartTime() == -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (zD2) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = Boolean.valueOf(z12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            zBooleanValue2 = ((Boolean) objRememberedValue4).booleanValue();
            Modifier.Companion companion10 = Modifier.INSTANCE;
            Modifier modifierM1755height3ABfNKs2 = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth(companion10, 0.7f), Dp.m8823constructorimpl(60));
            Alignment.Companion companion11 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically2 = companion11.getCenterVertically();
            Arrangement arrangement2 = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement2.getStart(), centerVertically2, composerStartRestartGroup, 48);
            int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1755height3ABfNKs2);
            ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
            constructor2 = companion12.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy2, companion12.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion12.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion12.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion12.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion12.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            Modifier modifierAspectRatio$default2 = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxHeight$default(companion10, 0.0f, 1, null), 1.0f, false, 2, null);
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i16 = MaterialTheme.$stable;
            float f12 = 15;
            float f13 = 10;
            Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth(SizeKt.fillMaxHeight$default(BackgroundKt.m1204backgroundbw27NRU(modifierAspectRatio$default2, Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composerStartRestartGroup, i16).getPrimary(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f12), 0.0f, 0.0f, Dp.m8823constructorimpl(f12), 6, null)), 0.0f, 1, null), 0.2f), Dp.m8823constructorimpl(f13), 0.0f, 2, null);
            if (!zBooleanValue2) {
                if (zBooleanValue2) {
                    call = CallEndKt.getCallEnd(Icons.Outlined.INSTANCE);
                } else if (zBooleanValue) {
                    call = VideocamKt.getVideocam(Icons.Outlined.INSTANCE);
                } else {
                    call = CallKt.getCall(Icons.Outlined.INSTANCE);
                }
            } else if (zBooleanValue2) {
                call = CallEndKt.getCallEnd(Icons.Outlined.INSTANCE);
            } else if (zBooleanValue) {
                call = VideocamKt.getVideocam(Icons.Outlined.INSTANCE);
            } else {
                call = CallKt.getCall(Icons.Outlined.INSTANCE);
            }
            String str6 = str4;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1727paddingVpY3zN4$default2, call, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 3072, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxHeight$default(androidx.compose.foundation.layout.e3.a(rowScopeInstance2, companion10, 1.0f, false, 2, null), 0.0f, 1, null), Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composerStartRestartGroup, i16).getPrimary(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(0.0f, Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f12), 0.0f, 9, null)), 0.0f, 0.0f, Dp.m8823constructorimpl(f13), 0.0f, 11, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getCenter(), companion11.getStart(), composerStartRestartGroup, 6);
            int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default2);
            constructor3 = companion12.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyColumnMeasurePolicy2, companion12.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion12.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion12.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion12.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion12.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            if (!zBooleanValue2) {
                if (zBooleanValue2) {
                    i13 = R.string.missed_call;
                } else if (zBooleanValue) {
                    i13 = R.string.video_call;
                } else {
                    i13 = R.string.call;
                }
            } else if (zBooleanValue2) {
                i13 = R.string.missed_call;
            } else if (zBooleanValue) {
                i13 = R.string.video_call;
            } else {
                i13 = R.string.call;
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(i13, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme2.getTypography(composerStartRestartGroup, i16).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion2.getEmpty()) {
                objRememberedValue5 = Long.valueOf(callContent.getEndTime() - callContent.getStartTime());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            long jLongValue2 = ((Number) objRememberedValue5).longValue();
            if (callContent.getEndTime() > 0) {
                composerStartRestartGroup.startReplaceGroup(811066745);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(811066745);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            str3 = str2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallContentKt.CallContent$lambda$2(msg, onClick, onLongClick, str3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CallContent$lambda$2(MessageWithPartnerWithReactions messageWithPartnerWithReactions, Function2 function2, Function2 function3, String str, int i10, int i11, Composer composer, int i12) {
        CallContent(messageWithPartnerWithReactions, function2, function3, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
