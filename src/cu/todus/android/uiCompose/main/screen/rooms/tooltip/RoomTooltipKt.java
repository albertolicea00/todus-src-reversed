package cu.todus.android.uiCompose.main.screen.rooms.tooltip;

import android.graphics.Color;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.LinkKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.todus.android.uiCompose.main.screen.rooms.tooltip.RoomTooltipKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.theme.Light;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "searchNumber", "", "Lcu/todus/android/data/rest/entity/NewEntity;", NavLinks.NEWS, "Lkotlin/Function0;", "Lua/k0;", "onClick", "RoomTooltip", "(Landroidx/compose/ui/Modifier;ILjava/util/List;Llb/a;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RoomTooltipKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RoomTooltip(final Modifier modifier, final int i10, final List<NewEntity> news, final a onClick, Composer composer, final int i11) {
        int i12;
        Composer composer2;
        y.i(modifier, "modifier");
        y.i(news, "news");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(231074768);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(news) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(231074768, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.tooltip.RoomTooltip (RoomTooltip.kt:34)");
            }
            if (i10 >= news.size() || g0.z0(news, i10) == null) {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-881939918);
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-883907085);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
                boolean z10 = (i12 & 7168) == 2048;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: e8.a
                        @Override // lb.a
                        public final Object invoke() {
                            return RoomTooltipKt.RoomTooltip$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (a) objRememberedValue, 15, null), Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(5));
                float f10 = 15;
                RoundedCornerShape roundedCornerShapeM2016RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(0), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10));
                CardDefaults cardDefaults = CardDefaults.INSTANCE;
                String color = news.get(i10).getColor();
                if (color == null) {
                    color = "#FFF2C5";
                }
                composer2 = composerStartRestartGroup;
                CardKt.Card(modifierM1726paddingVpY3zN4, roundedCornerShapeM2016RoundedCornerShapea9UjIt4, cardDefaults.m2922cardColorsro_MJ88(ColorKt.Color(Color.parseColor(color)), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(859184413, true, new Function3() { // from class: e8.b
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return RoomTooltipKt.RoomTooltip$lambda$1(news, i10, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: e8.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RoomTooltipKt.RoomTooltip$lambda$2(modifier, i10, news, onClick, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomTooltip$lambda$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 RoomTooltip$lambda$1(List list, int i10, ColumnScope Card, Composer composer, int i11) {
        Modifier.Companion companion;
        int i12;
        float f10;
        Composer composer2;
        y.i(Card, "$this$Card");
        if (composer.shouldExecute((i11 & 17) != 16, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(859184413, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.tooltip.RoomTooltip.<anonymous> (RoomTooltip.kt:57)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f11 = 10;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1726paddingVpY3zN4(companion2, Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(f11)), 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composer, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String authorImage = ((NewEntity) list.get(i10)).getAuthorImage();
            if (authorImage == null) {
                composer.startReplaceGroup(-978642461);
                composer.endReplaceGroup();
                companion = companion2;
                f10 = f11;
                i12 = 16;
                composer2 = composer;
            } else {
                composer.startReplaceGroup(-978642460);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(40));
                String color = ((NewEntity) list.get(i10)).getColor();
                if (color == null) {
                    color = "#FFF2C5";
                }
                companion = companion2;
                i12 = 16;
                f10 = f11;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs, authorImage, androidx.compose.ui.graphics.Color.m5856boximpl(ColorKt.Color(Color.parseColor(color))), null, null, 0, null, false, null, null, false, 0, composer, 6, 0, 4088);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            Modifier.Companion companion4 = companion;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance, companion4, 1.0f, false, 2, null), Dp.m8823constructorimpl(f10), 0.0f, 2, null);
            String reduced = ((NewEntity) list.get(i10)).getReduced();
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleSmall(), 0L, TextUnitKt.getSp(i12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null);
            Light light = Light.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default, reduced, textStyleM8271copyp1EtxEg$default, light.m10102getOnBackground0d7_KjU(), 0, 0, composer, 3072, 48);
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(24)), LinkKt.getLink(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, light.m10102getOnBackground0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 RoomTooltip$lambda$2(Modifier modifier, int i10, List list, a aVar, int i11, Composer composer, int i12) {
        RoomTooltip(modifier, i10, list, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return k0.f43947a;
    }
}
