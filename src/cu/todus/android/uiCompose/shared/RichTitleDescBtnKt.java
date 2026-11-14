package cu.todus.android.uiCompose.shared;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.main.screen.chat.item.content.TextContentKt;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001aC\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"", "image", "", "title", "content", "Lkotlin/Function0;", "Lua/k0;", "onClick", "RichTitleDescBtn", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/graphics/Color;", "color", "TitleDescBtn-uDo3WH8", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;JLlb/a;Landroidx/compose/runtime/Composer;II)V", "TitleDescBtn", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RichTitleDescBtnKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageAction.values().length];
            try {
                iArr[MessageAction.MENTION_CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageAction.TAG_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageAction.NUMBER_CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageAction.LINK_CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Composable
    public static final void RichTitleDescBtn(final Object image, final String title, final String content, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        y.i(image, "image");
        y.i(title, "title");
        y.i(content, "content");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-241109313);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(image) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(title) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-241109313, i11, -1, "cu.todus.android.uiCompose.shared.RichTitleDescBtn (RichTitleDescBtn.kt:23)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z10 = (i11 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.f
                    @Override // lb.a
                    public final Object invoke() {
                        return RichTitleDescBtnKt.RichTitleDescBtn$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            lb.a constructor2 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24));
            ColorFilter.Companion companion4 = ColorFilter.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            int i13 = i11;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, image, null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i12).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i11 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(16));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            lb.a constructor3 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
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
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i12).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, i13 & 112, 57);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue2 == companion5.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.shared.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RichTitleDescBtnKt.RichTitleDescBtn$lambda$1$1$0$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function2 function2 = (Function2) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion5.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: cu.todus.android.uiCompose.shared.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RichTitleDescBtnKt.RichTitleDescBtn$lambda$1$1$1$0((MessageAction) obj, ((Integer) obj2).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function2 function3 = (Function2) objRememberedValue3;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion5.getEmpty()) {
                objRememberedValue4 = new Function2() { // from class: cu.todus.android.uiCompose.shared.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RichTitleDescBtnKt.RichTitleDescBtn$lambda$1$1$2$0(context, (MessageAction) obj, (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            TextContentKt.m9893TextContentOadGlvw(content, 0L, function2, function3, 0, (Function2) objRememberedValue4, composerStartRestartGroup, ((i13 >> 6) & 14) | 3456, 18);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RichTitleDescBtnKt.RichTitleDescBtn$lambda$2(image, title, content, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RichTitleDescBtn$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RichTitleDescBtn$lambda$1$1$0$0(MessageAction p10, int i10) {
        y.i(p10, "p1");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RichTitleDescBtn$lambda$1$1$1$0(MessageAction p10, int i10) {
        y.i(p10, "p1");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RichTitleDescBtn$lambda$1$1$2$0(Context context, MessageAction messageAction, String value) {
        y.i(messageAction, "messageAction");
        y.i(value, "value");
        if (WhenMappings.$EnumSwitchMapping$0[messageAction.ordinal()] == 4) {
            IntentUtil.INSTANCE.showWeb(context, value);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RichTitleDescBtn$lambda$2(Object obj, String str, String str2, lb.a aVar, int i10, Composer composer, int i11) {
        RichTitleDescBtn(obj, str, str2, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0299  */
    /* JADX WARN: Code duplicated, block: B:105:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:106:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:109:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:110:0x031f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0337  */
    /* JADX WARN: Code duplicated, block: B:115:0x033f  */
    /* JADX WARN: Code duplicated, block: B:118:0x034b  */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5 A[PHI: r2 r5 r8
      0x00b5: PHI (r2v23 int) = (r2v11 int), (r2v9 int), (r2v24 int) binds: [B:69:0x00d0, B:61:0x00b1, B:62:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x00b5: PHI (r5v17 java.lang.String) = (r5v3 java.lang.String), (r5v2 java.lang.String), (r5v2 java.lang.String) binds: [B:69:0x00d0, B:61:0x00b1, B:62:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x00b5: PHI (r8v17 long) = (r8v3 long), (r8v1 long), (r8v1 long) binds: [B:69:0x00d0, B:61:0x00b1, B:62:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00de  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:79:0x0103  */
    /* JADX WARN: Code duplicated, block: B:80:0x0105  */
    /* JADX WARN: Code duplicated, block: B:83:0x010c  */
    /* JADX WARN: Code duplicated, block: B:85:0x0114  */
    /* JADX WARN: Code duplicated, block: B:88:0x0176  */
    /* JADX WARN: Code duplicated, block: B:91:0x0182  */
    /* JADX WARN: Code duplicated, block: B:92:0x0186  */
    /* JADX WARN: Code duplicated, block: B:95:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:98:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:99:0x01ec  */
    @Composable
    /* JADX INFO: renamed from: TitleDescBtn-uDo3WH8, reason: not valid java name */
    public static final void m10077TitleDescBtnuDo3WH8(final Object image, final String title, String str, long j10, lb.a aVar, Composer composer, final int i10, final int i11) {
        int i12;
        String str2;
        long onBackground;
        int i13;
        lb.a aVar2;
        int i14;
        boolean z10;
        final String str3;
        final long j11;
        final lb.a aVar3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        String str4;
        final lb.a aVar4;
        long j12;
        boolean z11;
        Object objRememberedValue2;
        lb.a constructor;
        lb.a constructor2;
        int i15;
        String str5;
        lb.a constructor3;
        MaterialTheme materialTheme;
        int i16;
        String str6;
        int i17;
        y.i(image, "image");
        y.i(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-651304614);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(image) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(title) ? 32 : 16;
        }
        int i18 = i11 & 4;
        if (i18 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                str2 = str;
                i12 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
            }
            if ((i10 & 3072) == 0) {
                onBackground = j10;
                if ((i11 & 8) == 0 || !composerStartRestartGroup.changed(onBackground)) {
                    i17 = 1024;
                } else {
                    i17 = 2048;
                }
                i12 |= i17;
            } else {
                onBackground = j10;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    aVar2 = aVar;
                    if (composerStartRestartGroup.changedInstance(aVar2)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                if ((i12 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i18 != 0) {
                            str2 = "";
                        }
                        if ((i11 & 8) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i12 &= -7169;
                        }
                        if (i13 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            str4 = str2;
                            aVar4 = (lb.a) objRememberedValue;
                            j12 = onBackground;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-651304614, i12, -1, "cu.todus.android.uiCompose.shared.TitleDescBtn (RichTitleDescBtn.kt:86)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        if ((57344 & i12) == 16384) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue2, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        Alignment.Vertical centerVertically = companion2.getCenterVertically();
                        Arrangement arrangement = Arrangement.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
                        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                        constructor = companion3.getConstructor();
                        if (!r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
                        int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor2 = companion3.getConstructor();
                        if (!r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        i15 = i12;
                        str5 = str4;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), image, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, j12, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i12 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                        composerStartRestartGroup.endNode();
                        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(16));
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
                        int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
                        constructor3 = companion3.getConstructor();
                        if (!r.a(composerStartRestartGroup.getApplier())) {
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
                        materialTheme = MaterialTheme.INSTANCE;
                        i16 = MaterialTheme.$stable;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i16).getBodyLarge(), j12, 0, 0, composerStartRestartGroup, i15 & 7280, 49);
                        if (d0.q0(str5)) {
                            str6 = str5;
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.startReplaceGroup(1237380834);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1425385794);
                            str6 = str5;
                            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str6, null, materialTheme.getColorScheme(composerStartRestartGroup, i16).getTertiary(), 0, 0, composerStartRestartGroup, (i15 >> 3) & 112, 53);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str3 = str6;
                        aVar3 = aVar4;
                        j11 = j12;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 8) != 0) {
                            i12 &= -7169;
                        }
                    }
                    str4 = str2;
                    j12 = onBackground;
                    aVar4 = aVar2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-651304614, i12, -1, "cu.todus.android.uiCompose.shared.TitleDescBtn (RichTitleDescBtn.kt:86)");
                    }
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    if ((57344 & i12) == 16384) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                            @Override // lb.a
                            public final Object invoke() {
                                return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                            @Override // lb.a
                            public final Object invoke() {
                                return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion4, false, null, null, null, (lb.a) objRememberedValue2, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
                    Alignment.Companion companion5 = Alignment.INSTANCE;
                    Alignment.Vertical centerVertically2 = companion5.getCenterVertically();
                    Arrangement arrangement2 = Arrangement.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement2.getStart(), centerVertically2, composerStartRestartGroup, 48);
                    int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default2);
                    ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                    constructor = companion6.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion6.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion6.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion6.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion6.getSetModifier());
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getCenter(), false);
                    int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
                    constructor2 = companion6.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy2, companion6.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion6.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion6.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion6.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion6.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    i15 = i12;
                    str5 = str4;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion4, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), image, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, j12, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i12 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    composerStartRestartGroup.endNode();
                    Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(companion4, Dp.m8823constructorimpl(16));
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion5.getStart(), composerStartRestartGroup, 0);
                    int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
                    constructor3 = companion6.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyColumnMeasurePolicy2, companion6.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion6.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion6.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion6.getSetModifier());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    materialTheme = MaterialTheme.INSTANCE;
                    i16 = MaterialTheme.$stable;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i16).getBodyLarge(), j12, 0, 0, composerStartRestartGroup, i15 & 7280, 49);
                    if (d0.q0(str5)) {
                        composerStartRestartGroup.startReplaceGroup(1425385794);
                        str6 = str5;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(null, str6, null, materialTheme.getColorScheme(composerStartRestartGroup, i16).getTertiary(), 0, 0, composerStartRestartGroup, (i15 >> 3) & 112, 53);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        str6 = str5;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.startReplaceGroup(1237380834);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str3 = str6;
                    aVar3 = aVar4;
                    j11 = j12;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    str3 = str2;
                    j11 = onBackground;
                    aVar3 = aVar2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$3(image, title, str3, j11, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            aVar2 = aVar;
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    }
                    if ((i11 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i12 &= -7169;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        str4 = str2;
                        aVar4 = (lb.a) objRememberedValue;
                        j12 = onBackground;
                    } else {
                        str4 = str2;
                        j12 = onBackground;
                        aVar4 = aVar2;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    }
                    if ((i11 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i12 &= -7169;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        str4 = str2;
                        aVar4 = (lb.a) objRememberedValue;
                        j12 = onBackground;
                    } else {
                        str4 = str2;
                        j12 = onBackground;
                        aVar4 = aVar2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-651304614, i12, -1, "cu.todus.android.uiCompose.shared.TitleDescBtn (RichTitleDescBtn.kt:86)");
                }
                Modifier.Companion companion7 = Modifier.INSTANCE;
                if ((57344 & i12) == 16384) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                        @Override // lb.a
                        public final Object invoke() {
                            return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                        @Override // lb.a
                        public final Object invoke() {
                            return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1727paddingVpY3zN4$default3 = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion7, false, null, null, null, (lb.a) objRememberedValue2, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
                Alignment.Companion companion8 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically3 = companion8.getCenterVertically();
                Arrangement arrangement3 = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement3.getStart(), centerVertically3, composerStartRestartGroup, 48);
                int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default3);
                ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                constructor = companion9.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyRowMeasurePolicy3, companion9.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion9.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion9.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion9.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion9.getSetModifier());
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion8.getCenter(), false);
                int iA8 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion7);
                constructor2 = companion9.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy3, companion9.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion9.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion9.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion9.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion9.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                i15 = i12;
                str5 = str4;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion7, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), image, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, j12, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i12 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composerStartRestartGroup.endNode();
                Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(companion7, Dp.m8823constructorimpl(16));
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement3.getTop(), companion8.getStart(), composerStartRestartGroup, 0);
                int iA9 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs3);
                constructor3 = companion9.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl9 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl9, measurePolicyColumnMeasurePolicy3, companion9.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl9, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl9, Integer.valueOf(iA9), companion9.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl9, companion9.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl9, modifierMaterializeModifier9, companion9.getSetModifier());
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                materialTheme = MaterialTheme.INSTANCE;
                i16 = MaterialTheme.$stable;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i16).getBodyLarge(), j12, 0, 0, composerStartRestartGroup, i15 & 7280, 49);
                if (d0.q0(str5)) {
                    composerStartRestartGroup.startReplaceGroup(1425385794);
                    str6 = str5;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, str6, null, materialTheme.getColorScheme(composerStartRestartGroup, i16).getTertiary(), 0, 0, composerStartRestartGroup, (i15 >> 3) & 112, 53);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    str6 = str5;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(1237380834);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str6;
                aVar3 = aVar4;
                j11 = j12;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str3 = str2;
                j11 = onBackground;
                aVar3 = aVar2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$3(image, title, str3, j11, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        str2 = str;
        if ((i10 & 3072) == 0) {
            onBackground = j10;
            if ((i11 & 8) == 0) {
                i17 = 1024;
            } else {
                i17 = 1024;
            }
            i12 |= i17;
        } else {
            onBackground = j10;
        }
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                aVar2 = aVar;
                if (composerStartRestartGroup.changedInstance(aVar2)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    }
                    if ((i11 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i12 &= -7169;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        str4 = str2;
                        aVar4 = (lb.a) objRememberedValue;
                        j12 = onBackground;
                    } else {
                        str4 = str2;
                        j12 = onBackground;
                        aVar4 = aVar2;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    }
                    if ((i11 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i12 &= -7169;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        str4 = str2;
                        aVar4 = (lb.a) objRememberedValue;
                        j12 = onBackground;
                    } else {
                        str4 = str2;
                        j12 = onBackground;
                        aVar4 = aVar2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-651304614, i12, -1, "cu.todus.android.uiCompose.shared.TitleDescBtn (RichTitleDescBtn.kt:86)");
                }
                Modifier.Companion companion10 = Modifier.INSTANCE;
                if ((57344 & i12) == 16384) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                        @Override // lb.a
                        public final Object invoke() {
                            return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                        @Override // lb.a
                        public final Object invoke() {
                            return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1727paddingVpY3zN4$default4 = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion10, false, null, null, null, (lb.a) objRememberedValue2, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
                Alignment.Companion companion11 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically4 = companion11.getCenterVertically();
                Arrangement arrangement4 = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement4.getStart(), centerVertically4, composerStartRestartGroup, 48);
                int iA10 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default4);
                ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
                constructor = companion12.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl10 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl10, measurePolicyRowMeasurePolicy4, companion12.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl10, currentCompositionLocalMap10, companion12.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl10, Integer.valueOf(iA10), companion12.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl10, companion12.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl10, modifierMaterializeModifier10, companion12.getSetModifier());
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion11.getCenter(), false);
                int iA11 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion10);
                constructor2 = companion12.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl11 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl11, measurePolicyMaybeCachedBoxMeasurePolicy4, companion12.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl11, currentCompositionLocalMap11, companion12.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl11, Integer.valueOf(iA11), companion12.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl11, companion12.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl11, modifierMaterializeModifier11, companion12.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                i15 = i12;
                str5 = str4;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion10, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), image, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, j12, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i12 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composerStartRestartGroup.endNode();
                Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(companion10, Dp.m8823constructorimpl(16));
                MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(arrangement4.getTop(), companion11.getStart(), composerStartRestartGroup, 0);
                int iA12 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs4);
                constructor3 = companion12.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl12 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl12, measurePolicyColumnMeasurePolicy4, companion12.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl12, currentCompositionLocalMap12, companion12.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl12, Integer.valueOf(iA12), companion12.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl12, companion12.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl12, modifierMaterializeModifier12, companion12.getSetModifier());
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                materialTheme = MaterialTheme.INSTANCE;
                i16 = MaterialTheme.$stable;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i16).getBodyLarge(), j12, 0, 0, composerStartRestartGroup, i15 & 7280, 49);
                if (d0.q0(str5)) {
                    composerStartRestartGroup.startReplaceGroup(1425385794);
                    str6 = str5;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, str6, null, materialTheme.getColorScheme(composerStartRestartGroup, i16).getTertiary(), 0, 0, composerStartRestartGroup, (i15 >> 3) & 112, 53);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    str6 = str5;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(1237380834);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str6;
                aVar3 = aVar4;
                j11 = j12;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str3 = str2;
                j11 = onBackground;
                aVar3 = aVar2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$3(image, title, str3, j11, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        aVar2 = aVar;
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i18 != 0) {
                    str2 = "";
                }
                if ((i11 & 8) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i12 &= -7169;
                }
                if (i13 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    str4 = str2;
                    aVar4 = (lb.a) objRememberedValue;
                    j12 = onBackground;
                } else {
                    str4 = str2;
                    j12 = onBackground;
                    aVar4 = aVar2;
                }
            } else {
                if (i18 != 0) {
                    str2 = "";
                }
                if ((i11 & 8) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i12 &= -7169;
                }
                if (i13 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    str4 = str2;
                    aVar4 = (lb.a) objRememberedValue;
                    j12 = onBackground;
                } else {
                    str4 = str2;
                    j12 = onBackground;
                    aVar4 = aVar2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-651304614, i12, -1, "cu.todus.android.uiCompose.shared.TitleDescBtn (RichTitleDescBtn.kt:86)");
            }
            Modifier.Companion companion13 = Modifier.INSTANCE;
            if ((57344 & i12) == 16384) {
                z11 = true;
            } else {
                z11 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                    @Override // lb.a
                    public final Object invoke() {
                        return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.d
                    @Override // lb.a
                    public final Object invoke() {
                        return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$1$0(aVar4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1727paddingVpY3zN4$default5 = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion13, false, null, null, null, (lb.a) objRememberedValue2, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
            Alignment.Companion companion14 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically5 = companion14.getCenterVertically();
            Arrangement arrangement5 = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement5.getStart(), centerVertically5, composerStartRestartGroup, 48);
            int iA13 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default5);
            ComposeUiNode.Companion companion15 = ComposeUiNode.INSTANCE;
            constructor = companion15.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl13 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl13, measurePolicyRowMeasurePolicy5, companion15.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl13, currentCompositionLocalMap13, companion15.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl13, Integer.valueOf(iA13), companion15.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl13, companion15.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl13, modifierMaterializeModifier13, companion15.getSetModifier());
            RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion14.getCenter(), false);
            int iA14 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion13);
            constructor2 = companion15.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl14 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy5, companion15.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl14, currentCompositionLocalMap14, companion15.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl14, Integer.valueOf(iA14), companion15.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl14, companion15.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl14, modifierMaterializeModifier14, companion15.getSetModifier());
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            i15 = i12;
            str5 = str4;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion13, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24)), image, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, j12, 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i12 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup.endNode();
            Modifier modifierM1725padding3ABfNKs5 = PaddingKt.m1725padding3ABfNKs(companion13, Dp.m8823constructorimpl(16));
            MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(arrangement5.getTop(), companion14.getStart(), composerStartRestartGroup, 0);
            int iA15 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs5);
            constructor3 = companion15.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl15 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl15, measurePolicyColumnMeasurePolicy5, companion15.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl15, currentCompositionLocalMap15, companion15.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl15, Integer.valueOf(iA15), companion15.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl15, companion15.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl15, modifierMaterializeModifier15, companion15.getSetModifier());
            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
            materialTheme = MaterialTheme.INSTANCE;
            i16 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i16).getBodyLarge(), j12, 0, 0, composerStartRestartGroup, i15 & 7280, 49);
            if (d0.q0(str5)) {
                composerStartRestartGroup.startReplaceGroup(1425385794);
                str6 = str5;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str6, null, materialTheme.getColorScheme(composerStartRestartGroup, i16).getTertiary(), 0, 0, composerStartRestartGroup, (i15 >> 3) & 112, 53);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                str6 = str5;
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(1237380834);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str6;
            aVar3 = aVar4;
            j11 = j12;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            str3 = str2;
            j11 = onBackground;
            aVar3 = aVar2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RichTitleDescBtnKt.TitleDescBtn_uDo3WH8$lambda$3(image, title, str3, j11, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TitleDescBtn_uDo3WH8$lambda$1$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TitleDescBtn_uDo3WH8$lambda$3(Object obj, String str, String str2, long j10, lb.a aVar, int i10, int i11, Composer composer, int i12) {
        m10077TitleDescBtnuDo3WH8(obj, str, str2, j10, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
