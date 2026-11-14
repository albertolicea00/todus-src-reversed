package cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.xmpp.FollowState;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import defpackage.l;
import defpackage.r;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001ac\u0010\u000b\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001au\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0007H\u0003¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015²\u0006\u0010\u0010\u0014\u001a\u0004\u0018\u00010\b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusPreview/authorsDetail/AuthorsDetailData;", "authorsDetailData", "Lkotlin/Function0;", "Lua/k0;", "onClose", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "Lcu/todus/android/data/xmpp/FollowState;", "requestState", "navigateToProfile", "AuthorsDetailDialog", "(Lcu/todus/android/uiCompose/main/screen/statusPreview/authorsDetail/AuthorsDetailData;Llb/a;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "label", "authorId", "authorName", "authorImage", "position", "AuthorDetailCard", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "authorState", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AuthorsDetailDialogKt {
    /* JADX WARN: Code duplicated, block: B:100:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:103:0x021f  */
    /* JADX WARN: Code duplicated, block: B:106:0x022b  */
    /* JADX WARN: Code duplicated, block: B:107:0x022f  */
    /* JADX WARN: Code duplicated, block: B:110:0x0306  */
    /* JADX WARN: Code duplicated, block: B:113:0x0312  */
    /* JADX WARN: Code duplicated, block: B:114:0x0316  */
    /* JADX WARN: Code duplicated, block: B:117:0x034a  */
    /* JADX WARN: Code duplicated, block: B:118:0x034c  */
    /* JADX WARN: Code duplicated, block: B:121:0x0405  */
    /* JADX WARN: Code duplicated, block: B:122:0x0407  */
    /* JADX WARN: Code duplicated, block: B:125:0x040e  */
    /* JADX WARN: Code duplicated, block: B:126:0x0410  */
    /* JADX WARN: Code duplicated, block: B:133:0x0423  */
    /* JADX WARN: Code duplicated, block: B:136:0x043c  */
    /* JADX WARN: Code duplicated, block: B:137:0x043e  */
    /* JADX WARN: Code duplicated, block: B:140:0x0481  */
    /* JADX WARN: Code duplicated, block: B:141:0x0483  */
    /* JADX WARN: Code duplicated, block: B:143:0x0486  */
    /* JADX WARN: Code duplicated, block: B:150:0x0498  */
    /* JADX WARN: Code duplicated, block: B:153:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:155:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:158:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:81:0x0101  */
    /* JADX WARN: Code duplicated, block: B:84:0x010a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0122  */
    /* JADX WARN: Code duplicated, block: B:89:0x0135  */
    /* JADX WARN: Code duplicated, block: B:92:0x0193  */
    /* JADX WARN: Code duplicated, block: B:95:0x019f  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:99:0x01df  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void AuthorDetailCard(final String str, final String str2, final String str3, final String str4, final Function2 function2, String str5, final Function1 function1, Composer composer, final int i10, final int i11) {
        int i12;
        String str6;
        int i13;
        int i14;
        boolean z10;
        Composer composer2;
        final String str7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str8;
        int iHashCode;
        RoundedCornerShape roundedCornerShapeM2016RoundedCornerShapea9UjIt4;
        lb.a constructor;
        Object objRememberedValue;
        Composer.Companion companion;
        Object obj;
        final MutableState mutableState;
        lb.a constructor2;
        int i15;
        boolean z11;
        lb.a constructor3;
        boolean z12;
        boolean z13;
        int i16;
        boolean z14;
        boolean z15;
        Object objRememberedValue2;
        FiniteAnimationSpec finiteAnimationSpec;
        boolean z16;
        boolean z17;
        boolean z18;
        Object objRememberedValue3;
        int i17;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1502343621);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(str3) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(str4) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        int i18 = i11 & 32;
        if (i18 == 0) {
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                str6 = str5;
                i12 |= composerStartRestartGroup.changed(str6) ? 131072 : 65536;
            }
            i13 = i12;
            if ((1572864 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i14 = i13 | i17;
            } else {
                i14 = i13;
            }
            if ((i14 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                if (i18 != 0) {
                    str8 = "full";
                } else {
                    str8 = str6;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1502343621, i14, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorDetailCard (AuthorsDetailDialog.kt:93)");
                }
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ColorGenerator.Companion companion3 = ColorGenerator.INSTANCE;
                long jColor = ColorKt.Color(companion3.getMATERIAL().getColor(str3));
                iHashCode = str8.hashCode();
                if (iHashCode != -1383228885) {
                    if (iHashCode != 115029) {
                        roundedCornerShapeM2016RoundedCornerShapea9UjIt4 = (iHashCode != 3154575 && str8.equals("full")) ? RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)) : RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(0));
                    } else if (!str8.equals("top")) {
                        float f10 = 15;
                        float f11 = 0;
                        roundedCornerShapeM2016RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11));
                    }
                } else if (!str8.equals("bottom")) {
                    float f12 = 0;
                    float f13 = 15;
                    roundedCornerShapeM2016RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(f13));
                }
                float f14 = 10;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion2, jColor, roundedCornerShapeM2016RoundedCornerShapea9UjIt4), Dp.m8823constructorimpl(f14)), 0.0f, 1, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion4 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion4.getStart(), composerStartRestartGroup, 0);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                constructor = companion5.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    obj = null;
                }
                mutableState = (MutableState) objRememberedValue;
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, obj);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getCenterVertically(), composerStartRestartGroup, 48);
                int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                constructor2 = companion5.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                String str9 = str8;
                i15 = i14;
                z11 = false;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(OffsetKt.m1685offsetVpY3zN4$default(companion2, 0.0f, Dp.m8823constructorimpl(f14), 1, null), Dp.m8823constructorimpl(70)), 0.0f, 0.0f, Dp.m8823constructorimpl(f14), 0.0f, 11, null), str4, Color.m5856boximpl(Z17InlineUtilsKt.m10307darkerDxMtmZc(ColorKt.Color(companion3.getMATERIAL().getColor(str3)), 0.2f)), null, null, 0, null, false, null, str3, true, 0, composerStartRestartGroup, ((i14 >> 6) & 112) | 6 | ((i14 << 21) & C.ENCODING_PCM_DOUBLE), 6, 2552);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composerStartRestartGroup, 0);
                int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                constructor3 = companion5.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
                if (AuthorDetailCard$lambda$0$1(mutableState) != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z12, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-260187421, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.c
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return AuthorsDetailDialogKt.AuthorDetailCard$lambda$0$3$0$0(mutableState, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572870, 30);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i19 = MaterialTheme.$stable;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, materialTheme.getTypography(composerStartRestartGroup, i19).getLabelSmall(), 0L, 0, 0, composerStartRestartGroup, (i15 << 3) & 112, 57);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str3, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i19).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 25, composerStartRestartGroup, ((i15 >> 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
                composer2 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(5)), composer2, 6);
                composer2.endNode();
                k0 k0Var = k0.f43947a;
                if ((i15 & 57344) == 16384) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                i16 = i15 & 112;
                if (i16 == 32) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                z15 = z14 | z13;
                objRememberedValue2 = composer2.rememberedValue();
                if (!z15 || objRememberedValue2 == companion.getEmpty()) {
                    finiteAnimationSpec = null;
                    objRememberedValue2 = new AuthorsDetailDialogKt$AuthorDetailCard$1$1$2$1(function2, str2, mutableState, null);
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    finiteAnimationSpec = null;
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composer2, 6);
                composer2.endNode();
                if (AuthorDetailCard$lambda$0$1(mutableState) != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z16, (Modifier) null, EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec, 0.0f, 3, finiteAnimationSpec), EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec, 0.0f, 3, finiteAnimationSpec), (String) null, ComposableLambdaKt.rememberComposableLambda(-2034539767, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.d
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return AuthorsDetailDialogKt.AuthorDetailCard$lambda$0$4(mutableState, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, 1600518, 18);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f14)), composer2, 6);
                String strStringResource = StringResources_androidKt.stringResource(R.string.social_profile, composer2, 0);
                if ((i15 & 3670016) == 1048576) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (i16 == 32) {
                    z11 = true;
                }
                z18 = z11 | z17;
                objRememberedValue3 = composer2.rememberedValue();
                if (z18 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.e
                        @Override // lb.a
                        public final Object invoke() {
                            return AuthorsDetailDialogKt.AuthorDetailCard$lambda$0$5$0(function1, str2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue3, strStringResource, null, true, false, false, composer2, 24576, 105);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str7 = str9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str7 = str6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return AuthorsDetailDialogKt.AuthorDetailCard$lambda$1(str, str2, str3, str4, function2, str7, function1, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        str6 = str5;
        i13 = i12;
        if ((1572864 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i17 = 1048576;
            } else {
                i17 = 524288;
            }
            i14 = i13 | i17;
        } else {
            i14 = i13;
        }
        if ((i14 & 599187) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
            if (i18 != 0) {
                str8 = "full";
            } else {
                str8 = str6;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1502343621, i14, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorDetailCard (AuthorsDetailDialog.kt:93)");
            }
            Modifier.Companion companion6 = Modifier.INSTANCE;
            ColorGenerator.Companion companion7 = ColorGenerator.INSTANCE;
            long jColor2 = ColorKt.Color(companion7.getMATERIAL().getColor(str3));
            iHashCode = str8.hashCode();
            if (iHashCode != -1383228885) {
                if (iHashCode != 115029) {
                    if (iHashCode != 3154575) {
                    }
                } else if (!str8.equals("top")) {
                    float f15 = 15;
                    float f16 = 0;
                    roundedCornerShapeM2016RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f15), Dp.m8823constructorimpl(f15), Dp.m8823constructorimpl(f16), Dp.m8823constructorimpl(f16));
                }
            } else if (!str8.equals("bottom")) {
                float f17 = 0;
                float f18 = 15;
                roundedCornerShapeM2016RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f17), Dp.m8823constructorimpl(f17), Dp.m8823constructorimpl(f18), Dp.m8823constructorimpl(f18));
            }
            float f19 = 10;
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion6, jColor2, roundedCornerShapeM2016RoundedCornerShapea9UjIt4), Dp.m8823constructorimpl(f19)), 0.0f, 1, null);
            Arrangement arrangement2 = Arrangement.INSTANCE;
            Arrangement.Vertical top2 = arrangement2.getTop();
            Alignment.Companion companion8 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(top2, companion8.getStart(), composerStartRestartGroup, 0);
            int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
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
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy3, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion9.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                obj = null;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                obj = null;
            }
            mutableState = (MutableState) objRememberedValue;
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, obj);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion8.getCenterVertically(), composerStartRestartGroup, 48);
            int iA5 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
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
            Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy2, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion9.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            String str10 = str8;
            i15 = i14;
            z11 = false;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(OffsetKt.m1685offsetVpY3zN4$default(companion6, 0.0f, Dp.m8823constructorimpl(f19), 1, null), Dp.m8823constructorimpl(70)), 0.0f, 0.0f, Dp.m8823constructorimpl(f19), 0.0f, 11, null), str4, Color.m5856boximpl(Z17InlineUtilsKt.m10307darkerDxMtmZc(ColorKt.Color(companion7.getMATERIAL().getColor(str3)), 0.2f)), null, null, 0, null, false, null, str3, true, 0, composerStartRestartGroup, ((i14 >> 6) & 112) | 6 | ((i14 << 21) & C.ENCODING_PCM_DOUBLE), 6, 2552);
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion8.getStart(), composerStartRestartGroup, 0);
            int iA6 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion6);
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
            Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyColumnMeasurePolicy4, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion9.getSetModifier());
            if (AuthorDetailCard$lambda$0$1(mutableState) != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance2, z12, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-260187421, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AuthorsDetailDialogKt.AuthorDetailCard$lambda$0$3$0$0(mutableState, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572870, 30);
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i110 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, materialTheme2.getTypography(composerStartRestartGroup, i110).getLabelSmall(), 0L, 0, 0, composerStartRestartGroup, (i15 << 3) & 112, 57);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str3, TextStyle.m8271copyp1EtxEg$default(materialTheme2.getTypography(composerStartRestartGroup, i110).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 25, composerStartRestartGroup, ((i15 >> 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
            composer2 = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(5)), composer2, 6);
            composer2.endNode();
            k0 k0Var2 = k0.f43947a;
            if ((i15 & 57344) == 16384) {
                z13 = true;
            } else {
                z13 = false;
            }
            i16 = i15 & 112;
            if (i16 == 32) {
                z14 = true;
            } else {
                z14 = false;
            }
            z15 = z14 | z13;
            objRememberedValue2 = composer2.rememberedValue();
            if (z15) {
                finiteAnimationSpec = null;
                objRememberedValue2 = new AuthorsDetailDialogKt$AuthorDetailCard$1$1$2$1(function2, str2, mutableState, null);
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                finiteAnimationSpec = null;
                objRememberedValue2 = new AuthorsDetailDialogKt$AuthorDetailCard$1$1$2$1(function2, str2, mutableState, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue2, composer2, 6);
            composer2.endNode();
            if (AuthorDetailCard$lambda$0$1(mutableState) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance2, z16, (Modifier) null, EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec, 0.0f, 3, finiteAnimationSpec), EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec, 0.0f, 3, finiteAnimationSpec), (String) null, ComposableLambdaKt.rememberComposableLambda(-2034539767, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AuthorsDetailDialogKt.AuthorDetailCard$lambda$0$4(mutableState, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer2, 54), composer2, 1600518, 18);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f19)), composer2, 6);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.social_profile, composer2, 0);
            if ((i15 & 3670016) == 1048576) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (i16 == 32) {
                z11 = true;
            }
            z18 = z11 | z17;
            objRememberedValue3 = composer2.rememberedValue();
            if (z18) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.e
                    @Override // lb.a
                    public final Object invoke() {
                        return AuthorsDetailDialogKt.AuthorDetailCard$lambda$0$5$0(function1, str2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.e
                    @Override // lb.a
                    public final Object invoke() {
                        return AuthorsDetailDialogKt.AuthorDetailCard$lambda$0$5$0(function1, str2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(null, (lb.a) objRememberedValue3, strStringResource2, null, true, false, false, composer2, 24576, 105);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str7 = str10;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            str7 = str6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return AuthorsDetailDialogKt.AuthorDetailCard$lambda$1(str, str2, str3, str4, function2, str7, function1, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final FollowState AuthorDetailCard$lambda$0$1(MutableState<FollowState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AuthorDetailCard$lambda$0$3$0$0(MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        Composer composer2;
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-260187421, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorDetailCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AuthorsDetailDialog.kt:149)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getEnd(), Alignment.INSTANCE.getCenterVertically(), composer, 54);
        int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        lb.a constructor = companion.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        FollowState followStateAuthorDetailCard$lambda$0$1 = AuthorDetailCard$lambda$0$1(mutableState);
        if (followStateAuthorDetailCard$lambda$0$1 == null || !followStateAuthorDetailCard$lambda$0$1.isFollowingU()) {
            composer2 = composer;
            composer2.startReplaceGroup(1370915003);
            composer2.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1618351121);
            composer2 = composer;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.is_following_u, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), 0L, 0, 0, composer2, 0, 57);
            composer2.endReplaceGroup();
        }
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AuthorDetailCard$lambda$0$4(MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2034539767, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorDetailCard.<anonymous>.<anonymous> (AuthorsDetailDialog.kt:189)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.HorizontalOrVertical center = arrangement.getCenter();
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, companion2.getTop(), composer, 6);
        int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion3.getConstructor();
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
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composer, 48);
        int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
        lb.a constructor2 = companion3.getConstructor();
        if (!r.a(composer.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
        Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        FollowState followStateAuthorDetailCard$lambda$0$1 = AuthorDetailCard$lambda$0$1(mutableState);
        String strLikeCounterFormat = NumberInlineFunctionsKt.likeCounterFormat(followStateAuthorDetailCard$lambda$0$1 != null ? followStateAuthorDetailCard$lambda$0$1.getFollowersCount() : 0);
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, strLikeCounterFormat, materialTheme.getTypography(composer, i11).getTitleSmall(), 0L, 0, 10, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
        String strStringResource = StringResources_androidKt.stringResource(R.string.followers, composer, 0);
        Locale locale = Locale.ROOT;
        String lowerCase = strStringResource.toLowerCase(locale);
        y.h(lowerCase, "toLowerCase(...)");
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, lowerCase, null, 0L, 0, 0, composer, 0, 61);
        composer.endNode();
        SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(15)), composer, 6);
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composer, 48);
        int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion);
        lb.a constructor3 = companion3.getConstructor();
        if (!r.a(composer.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer);
        Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
        FollowState followStateAuthorDetailCard$lambda$0$2 = AuthorDetailCard$lambda$0$1(mutableState);
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, NumberInlineFunctionsKt.likeCounterFormat(followStateAuthorDetailCard$lambda$0$2 != null ? followStateAuthorDetailCard$lambda$0$2.getFollowingCount() : 0), materialTheme.getTypography(composer, i11).getTitleSmall(), 0L, 0, 10, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
        String lowerCase2 = StringResources_androidKt.stringResource(R.string.following, composer, 0).toLowerCase(locale);
        y.h(lowerCase2, "toLowerCase(...)");
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, lowerCase2, null, 0L, 0, 0, composer, 0, 61);
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AuthorDetailCard$lambda$0$5$0(Function1 function1, String str) {
        function1.invoke(str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AuthorDetailCard$lambda$1(String str, String str2, String str3, String str4, Function2 function2, String str5, Function1 function1, int i10, int i11, Composer composer, int i12) {
        AuthorDetailCard(str, str2, str3, str4, function2, str5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AuthorsDetailDialog(final AuthorsDetailData authorsDetailData, final lb.a onClose, final Function2 requestState, final Function1 navigateToProfile, Composer composer, final int i10) {
        int i11;
        y.i(onClose, "onClose");
        y.i(requestState, "requestState");
        y.i(navigateToProfile, "navigateToProfile");
        Composer composerStartRestartGroup = composer.startRestartGroup(-275181934);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(authorsDetailData) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(requestState) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(navigateToProfile) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-275181934, i11, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorsDetailDialog (AuthorsDetailDialog.kt:46)");
            }
            Z17DialogsKt.Z17CustomDialog(authorsDetailData != null, onClose, ComposableLambdaKt.rememberComposableLambda(473404768, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthorsDetailDialogKt.AuthorsDetailDialog$lambda$0(authorsDetailData, requestState, navigateToProfile, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i11 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorsDetailDialogKt.AuthorsDetailDialog$lambda$1(authorsDetailData, onClose, requestState, navigateToProfile, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AuthorsDetailDialog$lambda$0(AuthorsDetailData authorsDetailData, Function2 function2, final Function1 function1, final lb.a it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(473404768, i11, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorsDetailDialog.<anonymous> (AuthorsDetailDialog.kt:51)");
            }
            if (authorsDetailData == null) {
                composer.startReplaceGroup(-1471088871);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1471088870);
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                String strStringResource = StringResources_androidKt.stringResource(R.string.created_by, composer, 0);
                int i12 = i11;
                String creatorId = authorsDetailData.getCreatorId();
                String creatorName = authorsDetailData.getCreatorName();
                String creatorImage = authorsDetailData.getCreatorImage();
                String str = authorsDetailData.getAreTheSame() ? "full" : "top";
                int i13 = i12 & 14;
                boolean zChanged = (i13 == 4) | composer.changed(function1);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AuthorsDetailDialogKt.AuthorsDetailDialog$lambda$0$0$0$0$0(it, function1, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                AuthorDetailCard(strStringResource, creatorId, creatorName, creatorImage, function2, str, (Function1) objRememberedValue, composer, 0, 0);
                if (authorsDetailData.getAreTheSame()) {
                    composer.startReplaceGroup(-562104914);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(674586667);
                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.shared_by, composer, 0);
                    String repliedId = authorsDetailData.getRepliedId();
                    String repliedName = authorsDetailData.getRepliedName();
                    String repliedImage = authorsDetailData.getRepliedImage();
                    boolean zChanged2 = composer.changed(function1) | (i13 == 4);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AuthorsDetailDialogKt.AuthorsDetailDialog$lambda$0$0$0$1$0(it, function1, (String) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    AuthorDetailCard(strStringResource2, repliedId, repliedName, repliedImage, function2, "bottom", (Function1) objRememberedValue2, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
                    composer.endReplaceGroup();
                }
                composer.endNode();
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
    public static final k0 AuthorsDetailDialog$lambda$0$0$0$0$0(lb.a aVar, Function1 function1, String it) {
        y.i(it, "it");
        aVar.invoke();
        function1.invoke(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AuthorsDetailDialog$lambda$0$0$0$1$0(lb.a aVar, Function1 function1, String it) {
        y.i(it, "it");
        aVar.invoke();
        function1.invoke(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AuthorsDetailDialog$lambda$1(AuthorsDetailData authorsDetailData, lb.a aVar, Function2 function2, Function1 function1, int i10, Composer composer, int i11) {
        AuthorsDetailDialog(authorsDetailData, aVar, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
