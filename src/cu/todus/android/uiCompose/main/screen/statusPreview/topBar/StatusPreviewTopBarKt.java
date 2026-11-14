package cu.todus.android.uiCompose.main.screen.statusPreview.topBar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.VolumeMuteKt;
import androidx.compose.material.icons.automirrored.outlined.VolumeUpKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.uiCompose.main.screen.statusPreview.topBar.StatusPreviewTopBarKt;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.DateFormatter;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0091\u0001\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", Status.COLUMN_CREATOR_ID, "creatorName", "creatorImage", Status.COLUMN_REPLIED_ID, "repliedName", "repliedImage", "", "createAt", "", "reactions", Product.EXTRA_VIEWS, "", "fromOwner", "Lkotlin/Function0;", "Lua/k0;", "onBack", "hasSound", "changeSound", "onClickForDetails", "StatusPreviewTopBar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIZLlb/a;ZLlb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StatusPreviewTopBarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusPreviewTopBar(final String creatorId, final String creatorName, final String creatorImage, final String repliedId, final String repliedName, final String repliedImage, final long j10, final int i10, final int i11, final boolean z10, final a onBack, boolean z11, final a changeSound, final a onClickForDetails, Composer composer, final int i12, final int i13) {
        int i14;
        int i15;
        Composer composer2;
        final boolean z12;
        y.i(creatorId, "creatorId");
        y.i(creatorName, "creatorName");
        y.i(creatorImage, "creatorImage");
        y.i(repliedId, "repliedId");
        y.i(repliedName, "repliedName");
        y.i(repliedImage, "repliedImage");
        y.i(onBack, "onBack");
        y.i(changeSound, "changeSound");
        y.i(onClickForDetails, "onClickForDetails");
        Composer composerStartRestartGroup = composer.startRestartGroup(967439991);
        if ((i12 & 6) == 0) {
            i14 = i12 | (composerStartRestartGroup.changed(creatorId) ? 4 : 2);
        } else {
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(creatorName) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changed(creatorImage) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(repliedId) ? 2048 : 1024;
        }
        if ((i12 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changed(repliedName) ? 16384 : 8192;
        }
        if ((196608 & i12) == 0) {
            i14 |= composerStartRestartGroup.changed(repliedImage) ? 131072 : 65536;
        }
        if ((i12 & 1572864) == 0) {
            i14 |= composerStartRestartGroup.changed(j10) ? 1048576 : 524288;
        }
        int i16 = i14;
        if ((i13 & 6) == 0) {
            i15 = i13 | (composerStartRestartGroup.changedInstance(onBack) ? 4 : 2);
        } else {
            i15 = i13;
        }
        if ((i13 & 48) == 0) {
            i15 |= composerStartRestartGroup.changed(z11) ? 32 : 16;
        }
        if ((i13 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(changeSound) ? 256 : 128;
        }
        if ((i13 & 3072) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onClickForDetails) ? 2048 : 1024;
        }
        int i17 = i15;
        if (composerStartRestartGroup.shouldExecute(((i16 & 599187) == 599186 && (i17 & 1171) == 1170) ? false : true, i16 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(967439991, i16, i17, "cu.todus.android.uiCompose.main.screen.statusPreview.topBar.StatusPreviewTopBar (StatusPreviewTopBar.kt:55)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            Brush.Companion companion2 = Brush.INSTANCE;
            Color.Companion companion3 = Color.INSTANCE;
            float f10 = 5;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.background$default(modifierFillMaxWidth$default, Brush.Companion.m5827verticalGradient8A3gB4$default(companion2, w.q(Color.m5856boximpl(Color.m5865copywmQWz5c$default(companion3.m5892getBlack0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5856boximpl(companion3.m5901getTransparent0d7_KjU())), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m8823constructorimpl(f10));
            Alignment.Companion companion4 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion4.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            a constructor = companion5.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            IconButtonKt.IconButton(onBack, PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), false, null, null, null, ComposableSingletons$StatusPreviewTopBarKt.INSTANCE.m9995getLambda$2087634567$app_productionPFast(), composerStartRestartGroup, (i17 & 14) | 1572912, 60);
            Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
            boolean z13 = (i17 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: j8.b
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusPreviewTopBarKt.StatusPreviewTopBar$lambda$0$0$0(onClickForDetails);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierA, false, null, null, null, (a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getEnd(), companion4.getCenterVertically(), composerStartRestartGroup, 54);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
            a constructor2 = companion5.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getEnd(), composerStartRestartGroup, 48);
            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            a constructor3 = companion5.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i18 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, repliedName, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i18).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), companion3.m5903getWhite0d7_KjU(), 0, 20, composerStartRestartGroup, ((i16 >> 9) & 112) | 199680, 17);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, DateFormatter.INSTANCE.prettyFormatter(new Date(j10)), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i18).getLabelSmall(), 0L, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), companion3.m5903getWhite0d7_KjU(), 0, 0, composerStartRestartGroup, 3072, 49);
            composerStartRestartGroup.endNode();
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            a constructor4 = companion5.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(40)), Dp.m8823constructorimpl(f10));
            ColorGenerator.Companion companion6 = ColorGenerator.INSTANCE;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1725padding3ABfNKs2, repliedImage, Color.m5856boximpl(ColorKt.Color(companion6.getMATERIAL().getColor(repliedName))), null, null, 0, null, false, null, repliedName, true, 0, composerStartRestartGroup, ((i16 >> 12) & 112) | 6 | ((i16 << 15) & C.ENCODING_PCM_DOUBLE), 6, 2552);
            Composer composer3 = composerStartRestartGroup;
            if (y.d(repliedId, creatorId)) {
                composer3.startReplaceGroup(472962557);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(430879974);
                float f11 = 2;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(boxScopeInstance.align(OffsetKt.m1684offsetVpY3zN4(companion, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11)), companion4.getBottomEnd()), Dp.m8823constructorimpl(20)), creatorImage, Color.m5856boximpl(ColorKt.Color(companion6.getMATERIAL().getColor(creatorName))), null, null, 0, null, false, null, creatorName, true, 0, composer3, ((i16 >> 3) & 112) | ((i16 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2552);
                composer3 = composer3;
                composer3.endReplaceGroup();
            }
            composer3.endNode();
            z12 = z11;
            Composer composer4 = composer3;
            IconButtonKt.IconButton(changeSound, null, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1340785571, true, new Function2() { // from class: j8.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusPreviewTopBarKt.StatusPreviewTopBar$lambda$0$1$2(z12, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), composer4, ((i17 >> 6) & 14) | 1572864, 62);
            composer2 = composer4;
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            z12 = z11;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: j8.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusPreviewTopBarKt.StatusPreviewTopBar$lambda$1(creatorId, creatorName, creatorImage, repliedId, repliedName, repliedImage, j10, i10, i11, z10, onBack, z12, changeSound, onClickForDetails, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusPreviewTopBar$lambda$0$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusPreviewTopBar$lambda$0$1$2(boolean z10, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1340785571, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.topBar.StatusPreviewTopBar.<anonymous>.<anonymous>.<anonymous> (StatusPreviewTopBar.kt:139)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), z10 ? VolumeUpKt.getVolumeUp(Icons.AutoMirrored.Outlined.INSTANCE) : VolumeMuteKt.getVolumeMute(Icons.AutoMirrored.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusPreviewTopBar$lambda$1(String str, String str2, String str3, String str4, String str5, String str6, long j10, int i10, int i11, boolean z10, a aVar, boolean z11, a aVar2, a aVar3, int i12, int i13, Composer composer, int i14) {
        StatusPreviewTopBar(str, str2, str3, str4, str5, str6, j10, i10, i11, z10, aVar, z11, aVar2, aVar3, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), RecomposeScopeImplKt.updateChangedFlags(i13));
        return k0.f43947a;
    }
}
