package cu.todus.android.uiCompose.main.screen.statusList.content;

import android.webkit.URLUtil;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.WebmConstants;
import c3.h0;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.uiCompose.theme.Other;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import ua.k0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/data/db/pojo/content/statusContent/StatusImageContent;", "statusContent", "", "isMiniature", "", "squareMaxSize", "isFromOwner", "Lua/k0;", "StatusImgContentItem", "(Lcu/todus/android/data/db/pojo/content/statusContent/StatusImageContent;ZIZLandroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "StatusPreviewImgContentItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/content/statusContent/StatusImageContent;Landroidx/compose/ui/layout/ContentScale;ZLandroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StatusImgTypeKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusImgContentItem(final StatusImageContent statusContent, final boolean z10, final int i10, final boolean z11, Composer composer, final int i11) {
        int i12;
        boolean z12;
        y.i(statusContent, "statusContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-116961285);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(statusContent) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            z12 = z11;
            i12 |= composerStartRestartGroup.changed(z12) ? 2048 : 1024;
        } else {
            z12 = z11;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-116961285, i12, -1, "cu.todus.android.uiCompose.main.screen.statusList.content.StatusImgContentItem (StatusImgType.kt:28)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-1174985724);
                Modifier.Companion companion = Modifier.INSTANCE;
                float f10 = i10;
                Modifier modifierM1774width3ABfNKs = SizeKt.m1774width3ABfNKs(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(f10));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1774width3ABfNKs);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                StatusPreviewImgContentItem(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), statusContent, ContentScale.INSTANCE.getCrop(), z12, composerStartRestartGroup, (i12 & 7168) | ((i12 << 3) & 112) | 390);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1174508200);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
                Brush.Companion companion4 = Brush.INSTANCE;
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                Modifier modifierBackground$default = BackgroundKt.background$default(modifierFillMaxSize$default, Brush.Companion.m5827verticalGradient8A3gB4$default(companion4, w.q(Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i13).getBackground()), Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i13).getOnBackground())), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                lb.a constructor2 = companion5.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(AlphaKt.alpha(companion3, 0.2f), 0.0f, 1, null);
                ContentScale.Companion companion6 = ContentScale.INSTANCE;
                int i14 = ((i12 << 3) & 112) | 390 | (i12 & 7168);
                StatusPreviewImgContentItem(modifierFillMaxSize$default2, statusContent, companion6.getCrop(), z11, composerStartRestartGroup, i14);
                BoxKt.Box(BlurKt.m5428blurF8QBwvs$default(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i13).getBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(10), null, 2, null), composerStartRestartGroup, 0);
                StatusPreviewImgContentItem(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), statusContent, companion6.getFillWidth(), z11, composerStartRestartGroup, i14);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.content.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusImgTypeKt.StatusImgContentItem$lambda$2(statusContent, z10, i10, z11, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusImgContentItem$lambda$2(StatusImageContent statusImageContent, boolean z10, int i10, boolean z11, int i11, Composer composer, int i12) {
        StatusImgContentItem(statusImageContent, z10, i10, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return k0.f43947a;
    }

    @Composable
    public static final void StatusPreviewImgContentItem(final Modifier modifier, final StatusImageContent statusContent, final ContentScale contentScale, final boolean z10, Composer composer, final int i10) {
        int i11;
        y.i(modifier, "modifier");
        y.i(statusContent, "statusContent");
        y.i(contentScale, "contentScale");
        Composer composerStartRestartGroup = composer.startRestartGroup(-399537798);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(statusContent) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(contentScale) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399537798, i11, -1, "cu.todus.android.uiCompose.main.screen.statusList.content.StatusPreviewImgContentItem (StatusImgType.kt:90)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                h0 otherArr = Other.INSTANCE.getOtherArr();
                y.h(otherArr, "<get-otherArr>(...)");
                Object objX0 = g0.X0(otherArr, pb.d.f40576c);
                y.h(objX0, "random(...)");
                objRememberedValue = Color.m5856boximpl(Color.m5865copywmQWz5c$default(((Color) objX0).m5876unboximpl(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            long jM5876unboximpl = ((Color) objRememberedValue).m5876unboximpl();
            String url = statusContent.getUrl();
            if (d0.q0(url)) {
                url = statusContent.getPath();
            }
            if (d0.q0(url)) {
                composerStartRestartGroup.startReplaceGroup(-1275839267);
                if (URLUtil.isHttpsUrl(statusContent.getThumbnail())) {
                    composerStartRestartGroup.startReplaceGroup(-1275530321);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), statusContent.getThumbnail(), null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, null, composerStartRestartGroup, 24582, 492);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1275775314);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, statusContent.getThumbnail(), composerStartRestartGroup, 24630, WebmConstants.MkvEbmlElement.VOID);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1275316204);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier, z10 ? statusContent.getPath() : statusContent.getUrl(), Color.m5856boximpl(jM5876unboximpl), null, contentScale, null, 0, null, null, composerStartRestartGroup, (i11 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i11 << 6) & 57344), 488);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.content.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusImgTypeKt.StatusPreviewImgContentItem$lambda$2(modifier, statusContent, contentScale, z10, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusPreviewImgContentItem$lambda$2(Modifier modifier, StatusImageContent statusImageContent, ContentScale contentScale, boolean z10, int i10, Composer composer, int i11) {
        StatusPreviewImgContentItem(modifier, statusImageContent, contentScale, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
