package cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
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
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012²\u0006\f\u0010\u0011\u001a\u00020\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", UserRoomJoin.COLUMN_AFFILIATION, "userName", "userImage", "Lua/k0;", "GroupMembershipCard", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "name", "image", "Landroidx/compose/ui/graphics/Color;", "color", "affiliationName", "MemberCard-ww6aTOc", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "MemberCard", "animatedColor", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SelfMembershipKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:57:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:77:0x0143  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void GroupMembershipCard(final Modifier modifier, final String affiliation, final String userName, final String userImage, Composer composer, final int i10) {
        int i11;
        long jM10112getGrey0d7_KjU;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(affiliation, "affiliation");
        kotlin.jvm.internal.y.i(userName, "userName");
        kotlin.jvm.internal.y.i(userImage, "userImage");
        Composer composerStartRestartGroup = composer.startRestartGroup(1800980823);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(affiliation) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(userName) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(userImage) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800980823, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.GroupMembershipCard (SelfMembership.kt:43)");
            }
            switch (affiliation) {
                case "member":
                    jM10112getGrey0d7_KjU = Other.INSTANCE.m10111getGreen0d7_KjU();
                    break;
                case "none":
                    jM10112getGrey0d7_KjU = Other.INSTANCE.m10112getGrey0d7_KjU();
                    break;
                case "admin":
                    jM10112getGrey0d7_KjU = Other.INSTANCE.m10114getOrange10d7_KjU();
                    break;
                case "owner":
                    jM10112getGrey0d7_KjU = Other.INSTANCE.m10121getYellow0d7_KjU();
                    break;
                default:
                    jM10112getGrey0d7_KjU = Other.INSTANCE.m10112getGrey0d7_KjU();
                    break;
            }
            long jGroupMembershipCard$lambda$0 = GroupMembershipCard$lambda$0(SingleValueAnimationKt.m1076animateColorAsStateeuL9pac(jM10112getGrey0d7_KjU, AnimationSpecKt.tween$default(1000, 0, null, 6, null), "acimc", null, composerStartRestartGroup, 432, 8));
            String strStringResource = "";
            switch (affiliation) {
                case "member":
                    composerStartRestartGroup.startReplaceGroup(-129219205);
                    strStringResource = StringResources_androidKt.stringResource(R.string.member, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case "none":
                    composerStartRestartGroup.startReplaceGroup(289252231);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case "admin":
                    composerStartRestartGroup.startReplaceGroup(-129221862);
                    strStringResource = StringResources_androidKt.stringResource(R.string.admin, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case "owner":
                    composerStartRestartGroup.startReplaceGroup(-129224486);
                    strStringResource = StringResources_androidKt.stringResource(R.string.owner, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                default:
                    composerStartRestartGroup.startReplaceGroup(289275047);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
            }
            int i12 = i11 >> 3;
            m9918MemberCardww6aTOc(modifier, userName, userImage, jGroupMembershipCard$lambda$0, strStringResource, composerStartRestartGroup, (i11 & 14) | (i12 & 112) | (i12 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.f2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelfMembershipKt.GroupMembershipCard$lambda$1(modifier, affiliation, userName, userImage, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final long GroupMembershipCard$lambda$0(State<Color> state) {
        return state.getValue().m5876unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 GroupMembershipCard$lambda$1(Modifier modifier, String str, String str2, String str3, int i10, Composer composer, int i11) {
        GroupMembershipCard(modifier, str, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: MemberCard-ww6aTOc, reason: not valid java name */
    public static final void m9918MemberCardww6aTOc(final Modifier modifier, final String name, final String image, long j10, final String affiliationName, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        long j11;
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(name, "name");
        kotlin.jvm.internal.y.i(image, "image");
        kotlin.jvm.internal.y.i(affiliationName, "affiliationName");
        Composer composerStartRestartGroup = composer.startRestartGroup(649113441);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(name) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(image) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(j10) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(affiliationName) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 9363) != 9362, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(649113441, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.MemberCard (SelfMembership.kt:78)");
            }
            float f10 = 15;
            int i12 = i11;
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(ShadowKt.m5480shadows4CzXII$default(modifier, Dp.m8823constructorimpl(3), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)), false, 0L, 0L, 28, null), j10, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1204backgroundbw27NRU);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Alignment center = companion.getCenter();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            lb.a constructor2 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            float f11 = 10;
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m1727paddingVpY3zN4$default(companion3, 0.0f, Dp.m8823constructorimpl(f11), 1, null), 0.0f, 1, null), Dp.m8823constructorimpl(25));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.g2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SelfMembershipKt.MemberCard_ww6aTOc$lambda$0$0$0$0((DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CanvasKt.Canvas(modifierM1755height3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 54);
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(5));
            String upperCase = affiliationName.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.y.h(upperCase, "toUpperCase(...)");
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            TextStyle bodyLarge = materialTheme.getTypography(composerStartRestartGroup, i13).getBodyLarge();
            int iM8693getEnde0LSkKk = TextAlign.INSTANCE.m8693getEnde0LSkKk();
            FontWeight.Companion companion4 = FontWeight.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1725padding3ABfNKs, upperCase, TextStyle.m8271copyp1EtxEg$default(bodyLarge, 0L, 0L, companion4.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, iM8693getEnde0LSkKk, 0, 0L, null, null, null, 0, 0, null, 16744443, null), Color.INSTANCE.m5903getWhite0d7_KjU(), 1, 0, composerStartRestartGroup, 27654, 32);
            composerStartRestartGroup.endNode();
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 7, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), composerStartRestartGroup, 48);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
            lb.a constructor3 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(companion3, Dp.m8823constructorimpl(f11), 0.0f, 2, null), Dp.m8823constructorimpl(40)), image, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(name))), null, "", 0, 50, false, null, name, true, 0, composerStartRestartGroup, ((i12 >> 3) & 112) | 1597446 | ((i12 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2472);
            composer2 = composerStartRestartGroup;
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion3, 1.0f, false, 2, null), name, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer2, i13).getBodyLarge(), 0L, 0L, companion4.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 1, 0, composer2, (i12 & 112) | 24576, 40);
            j11 = j10;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(AlphaKt.alpha(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(companion3, Dp.m8823constructorimpl(f11), 0.0f, 2, null), Dp.m8823constructorimpl(50)), 0.2f), Integer.valueOf(R.drawable.icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Z17InlineUtilsKt.m10309lighterDxMtmZc(j11, 0.6f), 0, 2, null), null, null, 0, null, null, composer2, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            j11 = j10;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j12 = j11;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.h2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelfMembershipKt.MemberCard_ww6aTOc$lambda$1(modifier, name, image, j12, affiliationName, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MemberCard_ww6aTOc$lambda$0$0$0$0(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.M(Canvas, Color.m5865copywmQWz5c$default(Color.INSTANCE.m5892getBlack0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MemberCard_ww6aTOc$lambda$1(Modifier modifier, String str, String str2, long j10, String str3, int i10, Composer composer, int i11) {
        m9918MemberCardww6aTOc(modifier, str, str2, j10, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
