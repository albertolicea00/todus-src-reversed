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
import androidx.compose.material.icons.outlined.ContactsKt;
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
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "ContactContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContactContentKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ContactContent(final MessageWithPartnerWithReactions msg, final Function2 onClick, final Function2 onLongClick, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1665504192);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onLongClick) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1665504192, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.ContactContent (ContactContent.kt:37)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z10 = ((i11 & 112) == 32) | ((i11 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ContactContentKt$ContactContent$1$1(onLongClick, onClick);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, onClick, (PointerInputEventHandler) objRememberedValue);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
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
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Iterator<T> it = msg.getAttachments().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    Attachment attachment = (Attachment) it.next();
                    if (attachment.getContent().getType() == 6 && (attachment.getContent() instanceof ContactContent)) {
                        Content content = attachment.getContent();
                        kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ContactContent");
                        objRememberedValue2 = (ContactContent) content;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        break;
                    }
                }
            }
            ContactContent contactContent = (ContactContent) objRememberedValue2;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth(companion3, 0.8f), Dp.m8823constructorimpl(60));
            Alignment.Companion companion4 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion4.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1755height3ABfNKs);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            lb.a constructor2 = companion5.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxHeight$default(companion3, 0.0f, 1, null), 1.0f, false, 2, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            float f10 = 15;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(SizeKt.fillMaxHeight$default(BackgroundKt.m1204backgroundbw27NRU(modifierAspectRatio$default, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i12).getPrimary(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 6, null)), 0.0f, 1, null), 0.2f);
            float f11 = 10;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1727paddingVpY3zN4$default(modifierFillMaxWidth, Dp.m8823constructorimpl(f11), 0.0f, 2, null), ContactsKt.getContacts(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 3072, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxHeight$default(androidx.compose.foundation.layout.e3.a(rowScopeInstance, companion3, 1.0f, false, 2, null), 0.0f, 1, null), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i12).getPrimary(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(0.0f, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 9, null)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion4.getStart(), composerStartRestartGroup, 6);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
            lb.a constructor3 = companion5.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, contactContent.getFName(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i12).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 2, 0, composerStartRestartGroup, 24624, 41);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, contactContent.getPhone(), materialTheme.getTypography(composerStartRestartGroup, i12).getLabelSmall(), 0L, 1, 0, composerStartRestartGroup, 24624, 41);
            composerStartRestartGroup.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContactContentKt.ContactContent$lambda$2(msg, onClick, onLongClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ContactContent$lambda$2(MessageWithPartnerWithReactions messageWithPartnerWithReactions, Function2 function2, Function2 function3, int i10, Composer composer, int i11) {
        ContactContent(messageWithPartnerWithReactions, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
