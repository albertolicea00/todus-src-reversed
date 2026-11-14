package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lua/k0;", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$8", "<anonymous>"}, k = 3, mv = {2, 3, 0})
public final class LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$8 extends kotlin.jvm.internal.e0 implements Function2 {
    final /* synthetic */ LinkInfoContent $content$inlined;
    final /* synthetic */ MutableState $contentTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$8(MutableState mutableState, LinkInfoContent linkInfoContent) {
        super(2);
        this.$contentTracker = mutableState;
        this.$content$inlined = linkInfoContent;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(Composer composer, int i10) {
        Composer composer2 = composer;
        if ((i10 & 3) == 2 && composer2.getSkipping()) {
            composer2.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-207512644, i10, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:853)");
        }
        this.$contentTracker.setValue(ua.k0.f43947a);
        composer2.startReplaceGroup(-743123082);
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, XHTMLText.IMG);
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierLayoutId);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion3.getConstructor();
        if (!defpackage.r.a(composer2.getApplier())) {
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
        LinkEntity linkEntity = this.$content$inlined.getLinkEntity();
        String img = linkEntity != null ? linkEntity.getImg() : null;
        if (img == null) {
            composer2.startReplaceGroup(897556574);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(897556575);
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(80)), img, null, null, null, null, 0, null, null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            composer2 = composer;
            composer2.endReplaceGroup();
        }
        composer2.endNode();
        float f10 = 10;
        Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(LayoutIdKt.layoutId(companion, "title"), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null);
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
        int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1729paddingqDBjuR0$default);
        lb.a constructor2 = companion3.getConstructor();
        if (!defpackage.r.a(composer2.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(constructor2);
        } else {
            composer2.useNode();
        }
        Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
        Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
        LinkEntity linkEntity2 = this.$content$inlined.getLinkEntity();
        String title = linkEntity2 != null ? linkEntity2.getTitle() : null;
        if (title == null) {
            composer2.startReplaceGroup(-696338997);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-696338996);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleSmall(), 0L, 1, 0, composer2, 24576, 41);
            composer2.endReplaceGroup();
        }
        composer2.endNode();
        Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(LayoutIdKt.layoutId(companion, "description"), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null);
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
        int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM1729paddingqDBjuR0$default2);
        lb.a constructor3 = companion3.getConstructor();
        if (!defpackage.r.a(composer2.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(constructor3);
        } else {
            composer2.useNode();
        }
        Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
        Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
        LinkEntity linkEntity3 = this.$content$inlined.getLinkEntity();
        String description = linkEntity3 != null ? linkEntity3.getDescription() : null;
        if (description == null) {
            composer2.startReplaceGroup(-1370398218);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-1370398217);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, description, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), 0L, 3, 0, composer2, 24576, 41);
            composer.endReplaceGroup();
        }
        composer.endNode();
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
