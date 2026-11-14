package cu.todus.android.uiCompose.main.screen.statusList;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
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
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusTextContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.uiCompose.main.screen.statusList.content.StatusImgTypeKt;
import cu.todus.android.uiCompose.main.screen.statusList.content.StatusTextTypeKt;
import cu.todus.android.uiCompose.main.screen.statusList.content.StatusVideoTypeKt;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u001ae\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u000f\u0010\u0013\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0012\u001a1\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u000f\u0010\u001c\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001c\u0010\u0012\u001a\u000f\u0010\u001d\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001d\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/data/db/pojo/content/Content;", "statusContent", "", "isMiniature", "isPlaying", "hasSound", "clearVideo", "", "squareMaxSize", "isFromOwner", "", "statusId", "Lua/k0;", "StatusItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/content/Content;ZZZZIZLjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "StatusPlaceholder", "(Landroidx/compose/runtime/Composer;I)V", "StatusPlaceholderLite", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "statusWithPartnersOrRooms", "screenWidth", "screenHeight", "StatusFeedItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;IILandroidx/compose/runtime/Composer;II)V", "StatusPreviewItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;IIZLandroidx/compose/runtime/Composer;II)V", "StatusPreviewItemPlaceholder", "StatusNotAvailable", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StatusItemKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusFeedItem(Modifier modifier, final StatusWithPartnersOrRooms statusWithPartnersOrRooms, final int i10, final int i11, Composer composer, final int i12, final int i13) {
        Modifier modifier2;
        int i14;
        final Modifier modifier3;
        Modifier modifier4;
        kotlin.jvm.internal.y.i(statusWithPartnersOrRooms, "statusWithPartnersOrRooms");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1282871586);
        int i15 = i13 & 1;
        if (i15 != 0) {
            i14 = i12 | 6;
            modifier2 = modifier;
        } else if ((i12 & 6) == 0) {
            modifier2 = modifier;
            i14 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i12;
        } else {
            modifier2 = modifier;
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(statusWithPartnersOrRooms) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(i11) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i14 & 1171) != 1170, i14 & 1)) {
            Modifier modifier5 = i15 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1282871586, i14, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusFeedItem (StatusItem.kt:171)");
            }
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            StatusPreviewItem(null, statusWithPartnersOrRooms, i10, i11, false, composerStartRestartGroup, i14 & 8176, 17);
            if (!(statusWithPartnersOrRooms.getStatus().getContent() instanceof StatusImageContent) || le.d0.q0(((StatusImageContent) statusWithPartnersOrRooms.getStatus().getContent()).getTextContent())) {
                modifier4 = modifier5;
                if (!(statusWithPartnersOrRooms.getStatus().getContent() instanceof StatusVideoContent) || le.d0.q0(((StatusVideoContent) statusWithPartnersOrRooms.getStatus().getContent()).getTextContent())) {
                    composerStartRestartGroup.startReplaceGroup(515926143);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(515640106);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(3)), ((StatusVideoContent) statusWithPartnersOrRooms.getStatus().getContent()).getTextContent(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), 0L, 2, 0, composerStartRestartGroup, 24582, 40);
                    composerStartRestartGroup.endReplaceGroup();
                }
            } else {
                composerStartRestartGroup.startReplaceGroup(515202634);
                modifier4 = modifier5;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(3)), ((StatusImageContent) statusWithPartnersOrRooms.getStatus().getContent()).getTextContent(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), 0L, 2, 0, composerStartRestartGroup, 24582, 40);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusItemKt.StatusFeedItem$lambda$1(modifier3, statusWithPartnersOrRooms, i10, i11, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusFeedItem$lambda$1(Modifier modifier, StatusWithPartnersOrRooms statusWithPartnersOrRooms, int i10, int i11, int i12, int i13, Composer composer, int i14) {
        StatusFeedItem(modifier, statusWithPartnersOrRooms, i10, i11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0122  */
    /* JADX WARN: Code duplicated, block: B:102:0x0125  */
    /* JADX WARN: Code duplicated, block: B:103:0x0127  */
    /* JADX WARN: Code duplicated, block: B:105:0x012a  */
    /* JADX WARN: Code duplicated, block: B:106:0x012c  */
    /* JADX WARN: Code duplicated, block: B:108:0x012f  */
    /* JADX WARN: Code duplicated, block: B:110:0x0132  */
    /* JADX WARN: Code duplicated, block: B:111:0x0136  */
    /* JADX WARN: Code duplicated, block: B:113:0x013a  */
    /* JADX WARN: Code duplicated, block: B:114:0x013c  */
    /* JADX WARN: Code duplicated, block: B:116:0x0140  */
    /* JADX WARN: Code duplicated, block: B:117:0x0144  */
    /* JADX WARN: Code duplicated, block: B:120:0x014c  */
    /* JADX WARN: Code duplicated, block: B:123:0x017f  */
    /* JADX WARN: Code duplicated, block: B:126:0x018b  */
    /* JADX WARN: Code duplicated, block: B:127:0x018f  */
    /* JADX WARN: Code duplicated, block: B:130:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:132:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:135:0x020c  */
    /* JADX WARN: Code duplicated, block: B:137:0x0210  */
    /* JADX WARN: Code duplicated, block: B:138:0x0240  */
    /* JADX WARN: Code duplicated, block: B:141:0x0257  */
    /* JADX WARN: Code duplicated, block: B:143:0x0263  */
    /* JADX WARN: Code duplicated, block: B:146:0x0276  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x0112  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Code duplicated, block: B:98:0x011d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x011f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusItem(Modifier modifier, final Content statusContent, final boolean z10, boolean z11, boolean z12, boolean z13, int i10, boolean z14, String str, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        boolean z15;
        int i14;
        boolean z16;
        int i15;
        int i16;
        boolean z17;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean z18;
        final int i24;
        final boolean z19;
        final Modifier modifier3;
        final boolean z20;
        final boolean z21;
        final boolean z22;
        final String str2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z23;
        boolean z24;
        int i25;
        boolean z25;
        String str3;
        lb.a constructor;
        boolean z26;
        kotlin.jvm.internal.y.i(statusContent, "statusContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(614589273);
        int i26 = i12 & 1;
        if (i26 != 0) {
            i13 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(statusContent) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        int i27 = i12 & 8;
        if (i27 == 0) {
            if ((i11 & 3072) == 0) {
                z15 = z11;
                i13 |= composerStartRestartGroup.changed(z15) ? 2048 : 1024;
            }
            i14 = i12 & 16;
            if (i14 != 0) {
                if ((i11 & 24576) == 0) {
                    z16 = z12;
                    if (composerStartRestartGroup.changed(z16)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
                    }
                    i13 |= i15;
                }
                i16 = i12 & 32;
                if (i16 != 0) {
                    if ((196608 & i11) == 0) {
                        z17 = z13;
                        if (composerStartRestartGroup.changed(z17)) {
                            i17 = 131072;
                        } else {
                            i17 = 65536;
                        }
                        i13 |= i17;
                    }
                    i18 = i12 & 64;
                    if (i18 != 0) {
                        i13 |= 1572864;
                    } else if ((i11 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i10)) {
                            i19 = 1048576;
                        } else {
                            i19 = 524288;
                        }
                        i13 |= i19;
                    }
                    i20 = i12 & 128;
                    if (i20 != 0) {
                        if ((i11 & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(z14)) {
                                i21 = 8388608;
                            } else {
                                i21 = 4194304;
                            }
                            i13 |= i21;
                        }
                        i22 = i12 & 256;
                        if (i22 != 0) {
                            if ((i11 & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(str)) {
                                    i23 = 67108864;
                                } else {
                                    i23 = 33554432;
                                }
                                i13 |= i23;
                            }
                            if ((i13 & 38347923) != 38347922) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                                if (i26 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i27 != 0) {
                                    z23 = false;
                                } else {
                                    z23 = z15;
                                }
                                if (i14 != 0) {
                                    z24 = false;
                                } else {
                                    z24 = z16;
                                }
                                if (i16 != 0) {
                                    z17 = false;
                                }
                                if (i18 != 0) {
                                    i25 = 70;
                                } else {
                                    i25 = i10;
                                }
                                if (i20 != 0) {
                                    z25 = false;
                                } else {
                                    z25 = z14;
                                }
                                if (i22 != 0) {
                                    str3 = "";
                                } else {
                                    str3 = str;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                                }
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                constructor = companion.getConstructor();
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
                                Modifier modifier5 = modifier4;
                                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
                                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                if (statusContent instanceof StatusTextContent) {
                                    composerStartRestartGroup.startReplaceGroup(954996115);
                                    StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    if (statusContent instanceof StatusImageContent) {
                                        composerStartRestartGroup.startReplaceGroup(955254500);
                                        int i28 = i13 >> 12;
                                        StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i28 & 896) | (i28 & 7168));
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (statusContent instanceof StatusVideoContent) {
                                        composerStartRestartGroup.startReplaceGroup(955563353);
                                        int i29 = i13 >> 3;
                                        int i30 = (i29 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i29) | (458752 & (i13 << 3)) | (3670016 & i13) | (i29 & 29360128);
                                        z26 = z17;
                                        StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i30);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        z26 = z17;
                                        composerStartRestartGroup.startReplaceGroup(956007707);
                                        StatusNotAvailable(composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    composerStartRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z20 = z23;
                                    z21 = z24;
                                    modifier3 = modifier5;
                                    z19 = z25;
                                    z22 = z26;
                                    i24 = i25;
                                    str2 = str3;
                                }
                                z26 = z17;
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z20 = z23;
                                z21 = z24;
                                modifier3 = modifier5;
                                z19 = z25;
                                z22 = z26;
                                i24 = i25;
                                str2 = str3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i24 = i10;
                                z19 = z14;
                                modifier3 = modifier2;
                                z20 = z15;
                                z21 = z16;
                                z22 = z17;
                                str2 = str;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i13 |= 100663296;
                        if ((i13 & 38347923) != 38347922) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                            if (i26 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i27 != 0) {
                                z23 = false;
                            } else {
                                z23 = z15;
                            }
                            if (i14 != 0) {
                                z24 = false;
                            } else {
                                z24 = z16;
                            }
                            if (i16 != 0) {
                                z17 = false;
                            }
                            if (i18 != 0) {
                                i25 = 70;
                            } else {
                                i25 = i10;
                            }
                            if (i20 != 0) {
                                z25 = false;
                            } else {
                                z25 = z14;
                            }
                            if (i22 != 0) {
                                str3 = "";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                            }
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            constructor = companion2.getConstructor();
                            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            Modifier modifier6 = modifier4;
                            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            if (statusContent instanceof StatusTextContent) {
                                composerStartRestartGroup.startReplaceGroup(954996115);
                                StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                if (statusContent instanceof StatusImageContent) {
                                    composerStartRestartGroup.startReplaceGroup(955254500);
                                    int i210 = i13 >> 12;
                                    StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i210 & 896) | (i210 & 7168));
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (statusContent instanceof StatusVideoContent) {
                                    composerStartRestartGroup.startReplaceGroup(955563353);
                                    int i211 = i13 >> 3;
                                    int i31 = (i211 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i211) | (458752 & (i13 << 3)) | (3670016 & i13) | (i211 & 29360128);
                                    z26 = z17;
                                    StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i31);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    z26 = z17;
                                    composerStartRestartGroup.startReplaceGroup(956007707);
                                    StatusNotAvailable(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z20 = z23;
                                z21 = z24;
                                modifier3 = modifier6;
                                z19 = z25;
                                z22 = z26;
                                i24 = i25;
                                str2 = str3;
                            }
                            z26 = z17;
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier6;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i24 = i10;
                            z19 = z14;
                            modifier3 = modifier2;
                            z20 = z15;
                            z21 = z16;
                            z22 = z17;
                            str2 = str;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 12582912;
                    i22 = i12 & 256;
                    if (i22 != 0) {
                        if ((i11 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i23 = 67108864;
                            } else {
                                i23 = 33554432;
                            }
                            i13 |= i23;
                        }
                        if ((i13 & 38347923) != 38347922) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                            if (i26 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i27 != 0) {
                                z23 = false;
                            } else {
                                z23 = z15;
                            }
                            if (i14 != 0) {
                                z24 = false;
                            } else {
                                z24 = z16;
                            }
                            if (i16 != 0) {
                                z17 = false;
                            }
                            if (i18 != 0) {
                                i25 = 70;
                            } else {
                                i25 = i10;
                            }
                            if (i20 != 0) {
                                z25 = false;
                            } else {
                                z25 = z14;
                            }
                            if (i22 != 0) {
                                str3 = "";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                            }
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            constructor = companion3.getConstructor();
                            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            Modifier modifier7 = modifier4;
                            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            if (statusContent instanceof StatusTextContent) {
                                composerStartRestartGroup.startReplaceGroup(954996115);
                                StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                if (statusContent instanceof StatusImageContent) {
                                    composerStartRestartGroup.startReplaceGroup(955254500);
                                    int i212 = i13 >> 12;
                                    StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i212 & 896) | (i212 & 7168));
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (statusContent instanceof StatusVideoContent) {
                                    composerStartRestartGroup.startReplaceGroup(955563353);
                                    int i213 = i13 >> 3;
                                    int i32 = (i213 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i213) | (458752 & (i13 << 3)) | (3670016 & i13) | (i213 & 29360128);
                                    z26 = z17;
                                    StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i32);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    z26 = z17;
                                    composerStartRestartGroup.startReplaceGroup(956007707);
                                    StatusNotAvailable(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z20 = z23;
                                z21 = z24;
                                modifier3 = modifier7;
                                z19 = z25;
                                z22 = z26;
                                i24 = i25;
                                str2 = str3;
                            }
                            z26 = z17;
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier7;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i24 = i10;
                            z19 = z14;
                            modifier3 = modifier2;
                            z20 = z15;
                            z21 = z16;
                            z22 = z17;
                            str2 = str;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 100663296;
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                        Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier8 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, companion4.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion4.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion4.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion4.getSetModifier());
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i214 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i214 & 896) | (i214 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i215 = i13 >> 3;
                                int i33 = (i215 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i215) | (458752 & (i13 << 3)) | (3670016 & i13) | (i215 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i33);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier8;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier8;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z17 = z13;
                i18 = i12 & 64;
                if (i18 != 0) {
                    i13 |= 1572864;
                } else if ((i11 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i10)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i13 |= i19;
                }
                i20 = i12 & 128;
                if (i20 != 0) {
                    if ((i11 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z14)) {
                            i21 = 8388608;
                        } else {
                            i21 = 4194304;
                        }
                        i13 |= i21;
                    }
                    i22 = i12 & 256;
                    if (i22 != 0) {
                        if ((i11 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i23 = 67108864;
                            } else {
                                i23 = 33554432;
                            }
                            i13 |= i23;
                        }
                        if ((i13 & 38347923) != 38347922) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                            if (i26 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i27 != 0) {
                                z23 = false;
                            } else {
                                z23 = z15;
                            }
                            if (i14 != 0) {
                                z24 = false;
                            } else {
                                z24 = z16;
                            }
                            if (i16 != 0) {
                                z17 = false;
                            }
                            if (i18 != 0) {
                                i25 = 70;
                            } else {
                                i25 = i10;
                            }
                            if (i20 != 0) {
                                z25 = false;
                            } else {
                                z25 = z14;
                            }
                            if (i22 != 0) {
                                str3 = "";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                            }
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                            constructor = companion5.getConstructor();
                            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            Modifier modifier9 = modifier4;
                            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion5.getSetModifier());
                            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                            if (statusContent instanceof StatusTextContent) {
                                composerStartRestartGroup.startReplaceGroup(954996115);
                                StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                if (statusContent instanceof StatusImageContent) {
                                    composerStartRestartGroup.startReplaceGroup(955254500);
                                    int i216 = i13 >> 12;
                                    StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i216 & 896) | (i216 & 7168));
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (statusContent instanceof StatusVideoContent) {
                                    composerStartRestartGroup.startReplaceGroup(955563353);
                                    int i217 = i13 >> 3;
                                    int i34 = (i217 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i217) | (458752 & (i13 << 3)) | (3670016 & i13) | (i217 & 29360128);
                                    z26 = z17;
                                    StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i34);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    z26 = z17;
                                    composerStartRestartGroup.startReplaceGroup(956007707);
                                    StatusNotAvailable(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z20 = z23;
                                z21 = z24;
                                modifier3 = modifier9;
                                z19 = z25;
                                z22 = z26;
                                i24 = i25;
                                str2 = str3;
                            }
                            z26 = z17;
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier9;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i24 = i10;
                            z19 = z14;
                            modifier3 = modifier2;
                            z20 = z15;
                            z21 = z16;
                            z22 = z17;
                            str2 = str;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 100663296;
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                        constructor = companion6.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier10 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, companion6.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion6.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion6.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion6.getSetModifier());
                        BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i218 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i218 & 896) | (i218 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i219 = i13 >> 3;
                                int i35 = (i219 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i219) | (458752 & (i13 << 3)) | (3670016 & i13) | (i219 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i35);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier10;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier10;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 12582912;
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                        constructor = companion7.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier11 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, companion7.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion7.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion7.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion7.getSetModifier());
                        BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i2110 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2110 & 896) | (i2110 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i2111 = i13 >> 3;
                                int i36 = (i2111 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2111) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2111 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i36);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier11;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier11;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA8 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                    constructor = companion8.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier12 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, companion8.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion8.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion8.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion8.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion8.getSetModifier());
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i2112 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2112 & 896) | (i2112 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i2113 = i13 >> 3;
                            int i37 = (i2113 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2113) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2113 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i37);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier12;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier12;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            z16 = z12;
            i16 = i12 & 32;
            if (i16 != 0) {
                if ((196608 & i11) == 0) {
                    z17 = z13;
                    if (composerStartRestartGroup.changed(z17)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i13 |= i17;
                }
                i18 = i12 & 64;
                if (i18 != 0) {
                    i13 |= 1572864;
                } else if ((i11 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i10)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i13 |= i19;
                }
                i20 = i12 & 128;
                if (i20 != 0) {
                    if ((i11 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z14)) {
                            i21 = 8388608;
                        } else {
                            i21 = 4194304;
                        }
                        i13 |= i21;
                    }
                    i22 = i12 & 256;
                    if (i22 != 0) {
                        if ((i11 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i23 = 67108864;
                            } else {
                                i23 = 33554432;
                            }
                            i13 |= i23;
                        }
                        if ((i13 & 38347923) != 38347922) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                            if (i26 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i27 != 0) {
                                z23 = false;
                            } else {
                                z23 = z15;
                            }
                            if (i14 != 0) {
                                z24 = false;
                            } else {
                                z24 = z16;
                            }
                            if (i16 != 0) {
                                z17 = false;
                            }
                            if (i18 != 0) {
                                i25 = 70;
                            } else {
                                i25 = i10;
                            }
                            if (i20 != 0) {
                                z25 = false;
                            } else {
                                z25 = z14;
                            }
                            if (i22 != 0) {
                                str3 = "";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                            }
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA9 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                            Composer composerM5176constructorimpl9 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            Modifier modifier13 = modifier4;
                            Updater.m5184setimpl(composerM5176constructorimpl9, measurePolicyMaybeCachedBoxMeasurePolicy9, companion9.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl9, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl9, Integer.valueOf(iA9), companion9.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl9, companion9.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl9, modifierMaterializeModifier9, companion9.getSetModifier());
                            BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                            if (statusContent instanceof StatusTextContent) {
                                composerStartRestartGroup.startReplaceGroup(954996115);
                                StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                if (statusContent instanceof StatusImageContent) {
                                    composerStartRestartGroup.startReplaceGroup(955254500);
                                    int i2114 = i13 >> 12;
                                    StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2114 & 896) | (i2114 & 7168));
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (statusContent instanceof StatusVideoContent) {
                                    composerStartRestartGroup.startReplaceGroup(955563353);
                                    int i2115 = i13 >> 3;
                                    int i38 = (i2115 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2115) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2115 & 29360128);
                                    z26 = z17;
                                    StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i38);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    z26 = z17;
                                    composerStartRestartGroup.startReplaceGroup(956007707);
                                    StatusNotAvailable(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z20 = z23;
                                z21 = z24;
                                modifier3 = modifier13;
                                z19 = z25;
                                z22 = z26;
                                i24 = i25;
                                str2 = str3;
                            }
                            z26 = z17;
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier13;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i24 = i10;
                            z19 = z14;
                            modifier3 = modifier2;
                            z20 = z15;
                            z21 = z16;
                            z22 = z17;
                            str2 = str;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 100663296;
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA10 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                        constructor = companion10.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl10 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier14 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl10, measurePolicyMaybeCachedBoxMeasurePolicy10, companion10.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl10, currentCompositionLocalMap10, companion10.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl10, Integer.valueOf(iA10), companion10.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl10, companion10.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl10, modifierMaterializeModifier10, companion10.getSetModifier());
                        BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i2116 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2116 & 896) | (i2116 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i2117 = i13 >> 3;
                                int i39 = (i2117 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2117) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2117 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i39);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier14;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier14;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 12582912;
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA11 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
                        constructor = companion11.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl11 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier15 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl11, measurePolicyMaybeCachedBoxMeasurePolicy11, companion11.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl11, currentCompositionLocalMap11, companion11.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl11, Integer.valueOf(iA11), companion11.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl11, companion11.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl11, modifierMaterializeModifier11, companion11.getSetModifier());
                        BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i2118 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2118 & 896) | (i2118 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i2119 = i13 >> 3;
                                int i310 = (i2119 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2119) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2119 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i310);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier15;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier15;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA12 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
                    constructor = companion12.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl12 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier16 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy12, companion12.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl12, currentCompositionLocalMap12, companion12.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl12, Integer.valueOf(iA12), companion12.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl12, companion12.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl12, modifierMaterializeModifier12, companion12.getSetModifier());
                    BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i21110 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21110 & 896) | (i21110 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i21111 = i13 >> 3;
                            int i311 = (i21111 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21111) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21111 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i311);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier16;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier16;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z17 = z13;
            i18 = i12 & 64;
            if (i18 != 0) {
                i13 |= 1572864;
            } else if ((i11 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i19 = 1048576;
                } else {
                    i19 = 524288;
                }
                i13 |= i19;
            }
            i20 = i12 & 128;
            if (i20 != 0) {
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z14)) {
                        i21 = 8388608;
                    } else {
                        i21 = 4194304;
                    }
                    i13 |= i21;
                }
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA13 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion13 = ComposeUiNode.INSTANCE;
                        constructor = companion13.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl13 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier17 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl13, measurePolicyMaybeCachedBoxMeasurePolicy13, companion13.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl13, currentCompositionLocalMap13, companion13.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl13, Integer.valueOf(iA13), companion13.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl13, companion13.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl13, modifierMaterializeModifier13, companion13.getSetModifier());
                        BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i21112 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21112 & 896) | (i21112 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i21113 = i13 >> 3;
                                int i312 = (i21113 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21113) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21113 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i312);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier17;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier17;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA14 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion14 = ComposeUiNode.INSTANCE;
                    constructor = companion14.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl14 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier18 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy14, companion14.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl14, currentCompositionLocalMap14, companion14.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl14, Integer.valueOf(iA14), companion14.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl14, companion14.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl14, modifierMaterializeModifier14, companion14.getSetModifier());
                    BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i21114 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21114 & 896) | (i21114 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i21115 = i13 >> 3;
                            int i313 = (i21115 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21115) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21115 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i313);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier18;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier18;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 12582912;
            i22 = i12 & 256;
            if (i22 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i23 = 67108864;
                    } else {
                        i23 = 33554432;
                    }
                    i13 |= i23;
                }
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA15 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion15 = ComposeUiNode.INSTANCE;
                    constructor = companion15.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl15 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier19 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl15, measurePolicyMaybeCachedBoxMeasurePolicy15, companion15.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl15, currentCompositionLocalMap15, companion15.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl15, Integer.valueOf(iA15), companion15.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl15, companion15.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl15, modifierMaterializeModifier15, companion15.getSetModifier());
                    BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i21116 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21116 & 896) | (i21116 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i21117 = i13 >> 3;
                            int i314 = (i21117 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21117) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21117 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i314);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier19;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier19;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) != 38347922) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                if (i26 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i27 != 0) {
                    z23 = false;
                } else {
                    z23 = z15;
                }
                if (i14 != 0) {
                    z24 = false;
                } else {
                    z24 = z16;
                }
                if (i16 != 0) {
                    z17 = false;
                }
                if (i18 != 0) {
                    i25 = 70;
                } else {
                    i25 = i10;
                }
                if (i20 != 0) {
                    z25 = false;
                } else {
                    z25 = z14;
                }
                if (i22 != 0) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA16 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion16 = ComposeUiNode.INSTANCE;
                constructor = companion16.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl16 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Modifier modifier110 = modifier4;
                Updater.m5184setimpl(composerM5176constructorimpl16, measurePolicyMaybeCachedBoxMeasurePolicy16, companion16.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl16, currentCompositionLocalMap16, companion16.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl16, Integer.valueOf(iA16), companion16.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl16, companion16.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl16, modifierMaterializeModifier16, companion16.getSetModifier());
                BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
                if (statusContent instanceof StatusTextContent) {
                    composerStartRestartGroup.startReplaceGroup(954996115);
                    StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (statusContent instanceof StatusImageContent) {
                        composerStartRestartGroup.startReplaceGroup(955254500);
                        int i21118 = i13 >> 12;
                        StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21118 & 896) | (i21118 & 7168));
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (statusContent instanceof StatusVideoContent) {
                        composerStartRestartGroup.startReplaceGroup(955563353);
                        int i21119 = i13 >> 3;
                        int i315 = (i21119 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21119) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21119 & 29360128);
                        z26 = z17;
                        StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i315);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z26 = z17;
                        composerStartRestartGroup.startReplaceGroup(956007707);
                        StatusNotAvailable(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier110;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                }
                z26 = z17;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z20 = z23;
                z21 = z24;
                modifier3 = modifier110;
                z19 = z25;
                z22 = z26;
                i24 = i25;
                str2 = str3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i24 = i10;
                z19 = z14;
                modifier3 = modifier2;
                z20 = z15;
                z21 = z16;
                z22 = z17;
                str2 = str;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        z15 = z11;
        i14 = i12 & 16;
        if (i14 != 0) {
            if ((i11 & 24576) == 0) {
                z16 = z12;
                if (composerStartRestartGroup.changed(z16)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
                }
                i13 |= i15;
            }
            i16 = i12 & 32;
            if (i16 != 0) {
                if ((196608 & i11) == 0) {
                    z17 = z13;
                    if (composerStartRestartGroup.changed(z17)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i13 |= i17;
                }
                i18 = i12 & 64;
                if (i18 != 0) {
                    i13 |= 1572864;
                } else if ((i11 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i10)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i13 |= i19;
                }
                i20 = i12 & 128;
                if (i20 != 0) {
                    if ((i11 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z14)) {
                            i21 = 8388608;
                        } else {
                            i21 = 4194304;
                        }
                        i13 |= i21;
                    }
                    i22 = i12 & 256;
                    if (i22 != 0) {
                        if ((i11 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i23 = 67108864;
                            } else {
                                i23 = 33554432;
                            }
                            i13 |= i23;
                        }
                        if ((i13 & 38347923) != 38347922) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                            if (i26 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i27 != 0) {
                                z23 = false;
                            } else {
                                z23 = z15;
                            }
                            if (i14 != 0) {
                                z24 = false;
                            } else {
                                z24 = z16;
                            }
                            if (i16 != 0) {
                                z17 = false;
                            }
                            if (i18 != 0) {
                                i25 = 70;
                            } else {
                                i25 = i10;
                            }
                            if (i20 != 0) {
                                z25 = false;
                            } else {
                                z25 = z14;
                            }
                            if (i22 != 0) {
                                str3 = "";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                            }
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int iA17 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                            ComposeUiNode.Companion companion17 = ComposeUiNode.INSTANCE;
                            constructor = companion17.getConstructor();
                            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM5176constructorimpl17 = Updater.m5176constructorimpl(composerStartRestartGroup);
                            Modifier modifier111 = modifier4;
                            Updater.m5184setimpl(composerM5176constructorimpl17, measurePolicyMaybeCachedBoxMeasurePolicy17, companion17.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl17, currentCompositionLocalMap17, companion17.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl17, Integer.valueOf(iA17), companion17.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl17, companion17.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl17, modifierMaterializeModifier17, companion17.getSetModifier());
                            BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
                            if (statusContent instanceof StatusTextContent) {
                                composerStartRestartGroup.startReplaceGroup(954996115);
                                StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                if (statusContent instanceof StatusImageContent) {
                                    composerStartRestartGroup.startReplaceGroup(955254500);
                                    int i211110 = i13 >> 12;
                                    StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i211110 & 896) | (i211110 & 7168));
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (statusContent instanceof StatusVideoContent) {
                                    composerStartRestartGroup.startReplaceGroup(955563353);
                                    int i211111 = i13 >> 3;
                                    int i316 = (i211111 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i211111) | (458752 & (i13 << 3)) | (3670016 & i13) | (i211111 & 29360128);
                                    z26 = z17;
                                    StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i316);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    z26 = z17;
                                    composerStartRestartGroup.startReplaceGroup(956007707);
                                    StatusNotAvailable(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z20 = z23;
                                z21 = z24;
                                modifier3 = modifier111;
                                z19 = z25;
                                z22 = z26;
                                i24 = i25;
                                str2 = str3;
                            }
                            z26 = z17;
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier111;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i24 = i10;
                            z19 = z14;
                            modifier3 = modifier2;
                            z20 = z15;
                            z21 = z16;
                            z22 = z17;
                            str2 = str;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 100663296;
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA18 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion18 = ComposeUiNode.INSTANCE;
                        constructor = companion18.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl18 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier112 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl18, measurePolicyMaybeCachedBoxMeasurePolicy18, companion18.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl18, currentCompositionLocalMap18, companion18.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl18, Integer.valueOf(iA18), companion18.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl18, companion18.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl18, modifierMaterializeModifier18, companion18.getSetModifier());
                        BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i211112 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i211112 & 896) | (i211112 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i211113 = i13 >> 3;
                                int i317 = (i211113 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i211113) | (458752 & (i13 << 3)) | (3670016 & i13) | (i211113 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i317);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier112;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier112;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 12582912;
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy19 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA19 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion19 = ComposeUiNode.INSTANCE;
                        constructor = companion19.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl19 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier113 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl19, measurePolicyMaybeCachedBoxMeasurePolicy19, companion19.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl19, currentCompositionLocalMap19, companion19.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl19, Integer.valueOf(iA19), companion19.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl19, companion19.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl19, modifierMaterializeModifier19, companion19.getSetModifier());
                        BoxScopeInstance boxScopeInstance19 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i211114 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i211114 & 896) | (i211114 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i211115 = i13 >> 3;
                                int i318 = (i211115 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i211115) | (458752 & (i13 << 3)) | (3670016 & i13) | (i211115 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i318);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier113;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier113;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA110 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion110 = ComposeUiNode.INSTANCE;
                    constructor = companion110.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl110 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier114 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl110, measurePolicyMaybeCachedBoxMeasurePolicy110, companion110.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl110, currentCompositionLocalMap110, companion110.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl110, Integer.valueOf(iA110), companion110.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl110, companion110.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl110, modifierMaterializeModifier110, companion110.getSetModifier());
                    BoxScopeInstance boxScopeInstance110 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i211116 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i211116 & 896) | (i211116 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i211117 = i13 >> 3;
                            int i319 = (i211117 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i211117) | (458752 & (i13 << 3)) | (3670016 & i13) | (i211117 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i319);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier114;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier114;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z17 = z13;
            i18 = i12 & 64;
            if (i18 != 0) {
                i13 |= 1572864;
            } else if ((i11 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i19 = 1048576;
                } else {
                    i19 = 524288;
                }
                i13 |= i19;
            }
            i20 = i12 & 128;
            if (i20 != 0) {
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z14)) {
                        i21 = 8388608;
                    } else {
                        i21 = 4194304;
                    }
                    i13 |= i21;
                }
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA111 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion111 = ComposeUiNode.INSTANCE;
                        constructor = companion111.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl111 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier115 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl111, measurePolicyMaybeCachedBoxMeasurePolicy111, companion111.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl111, currentCompositionLocalMap111, companion111.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl111, Integer.valueOf(iA111), companion111.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl111, companion111.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl111, modifierMaterializeModifier111, companion111.getSetModifier());
                        BoxScopeInstance boxScopeInstance111 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i211118 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i211118 & 896) | (i211118 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i211119 = i13 >> 3;
                                int i3110 = (i211119 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i211119) | (458752 & (i13 << 3)) | (3670016 & i13) | (i211119 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3110);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier115;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier115;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA112 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion112 = ComposeUiNode.INSTANCE;
                    constructor = companion112.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl112 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier116 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl112, measurePolicyMaybeCachedBoxMeasurePolicy112, companion112.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl112, currentCompositionLocalMap112, companion112.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl112, Integer.valueOf(iA112), companion112.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl112, companion112.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl112, modifierMaterializeModifier112, companion112.getSetModifier());
                    BoxScopeInstance boxScopeInstance112 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i2111110 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2111110 & 896) | (i2111110 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i2111111 = i13 >> 3;
                            int i3111 = (i2111111 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2111111) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2111111 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3111);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier116;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier116;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 12582912;
            i22 = i12 & 256;
            if (i22 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i23 = 67108864;
                    } else {
                        i23 = 33554432;
                    }
                    i13 |= i23;
                }
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy113 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA113 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion113 = ComposeUiNode.INSTANCE;
                    constructor = companion113.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl113 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier117 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl113, measurePolicyMaybeCachedBoxMeasurePolicy113, companion113.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl113, currentCompositionLocalMap113, companion113.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl113, Integer.valueOf(iA113), companion113.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl113, companion113.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl113, modifierMaterializeModifier113, companion113.getSetModifier());
                    BoxScopeInstance boxScopeInstance113 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i2111112 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2111112 & 896) | (i2111112 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i2111113 = i13 >> 3;
                            int i3112 = (i2111113 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2111113) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2111113 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3112);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier117;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier117;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) != 38347922) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                if (i26 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i27 != 0) {
                    z23 = false;
                } else {
                    z23 = z15;
                }
                if (i14 != 0) {
                    z24 = false;
                } else {
                    z24 = z16;
                }
                if (i16 != 0) {
                    z17 = false;
                }
                if (i18 != 0) {
                    i25 = 70;
                } else {
                    i25 = i10;
                }
                if (i20 != 0) {
                    z25 = false;
                } else {
                    z25 = z14;
                }
                if (i22 != 0) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy114 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA114 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion114 = ComposeUiNode.INSTANCE;
                constructor = companion114.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl114 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Modifier modifier118 = modifier4;
                Updater.m5184setimpl(composerM5176constructorimpl114, measurePolicyMaybeCachedBoxMeasurePolicy114, companion114.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl114, currentCompositionLocalMap114, companion114.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl114, Integer.valueOf(iA114), companion114.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl114, companion114.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl114, modifierMaterializeModifier114, companion114.getSetModifier());
                BoxScopeInstance boxScopeInstance114 = BoxScopeInstance.INSTANCE;
                if (statusContent instanceof StatusTextContent) {
                    composerStartRestartGroup.startReplaceGroup(954996115);
                    StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (statusContent instanceof StatusImageContent) {
                        composerStartRestartGroup.startReplaceGroup(955254500);
                        int i2111114 = i13 >> 12;
                        StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2111114 & 896) | (i2111114 & 7168));
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (statusContent instanceof StatusVideoContent) {
                        composerStartRestartGroup.startReplaceGroup(955563353);
                        int i2111115 = i13 >> 3;
                        int i3113 = (i2111115 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2111115) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2111115 & 29360128);
                        z26 = z17;
                        StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3113);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z26 = z17;
                        composerStartRestartGroup.startReplaceGroup(956007707);
                        StatusNotAvailable(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier118;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                }
                z26 = z17;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z20 = z23;
                z21 = z24;
                modifier3 = modifier118;
                z19 = z25;
                z22 = z26;
                i24 = i25;
                str2 = str3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i24 = i10;
                z19 = z14;
                modifier3 = modifier2;
                z20 = z15;
                z21 = z16;
                z22 = z17;
                str2 = str;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        z16 = z12;
        i16 = i12 & 32;
        if (i16 != 0) {
            if ((196608 & i11) == 0) {
                z17 = z13;
                if (composerStartRestartGroup.changed(z17)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i13 |= i17;
            }
            i18 = i12 & 64;
            if (i18 != 0) {
                i13 |= 1572864;
            } else if ((i11 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i19 = 1048576;
                } else {
                    i19 = 524288;
                }
                i13 |= i19;
            }
            i20 = i12 & 128;
            if (i20 != 0) {
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z14)) {
                        i21 = 8388608;
                    } else {
                        i21 = 4194304;
                    }
                    i13 |= i21;
                }
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                        if (i26 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i27 != 0) {
                            z23 = false;
                        } else {
                            z23 = z15;
                        }
                        if (i14 != 0) {
                            z24 = false;
                        } else {
                            z24 = z16;
                        }
                        if (i16 != 0) {
                            z17 = false;
                        }
                        if (i18 != 0) {
                            i25 = 70;
                        } else {
                            i25 = i10;
                        }
                        if (i20 != 0) {
                            z25 = false;
                        } else {
                            z25 = z14;
                        }
                        if (i22 != 0) {
                            str3 = "";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy115 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int iA115 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                        ComposeUiNode.Companion companion115 = ComposeUiNode.INSTANCE;
                        constructor = companion115.getConstructor();
                        if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl115 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Modifier modifier119 = modifier4;
                        Updater.m5184setimpl(composerM5176constructorimpl115, measurePolicyMaybeCachedBoxMeasurePolicy115, companion115.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl115, currentCompositionLocalMap115, companion115.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl115, Integer.valueOf(iA115), companion115.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl115, companion115.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl115, modifierMaterializeModifier115, companion115.getSetModifier());
                        BoxScopeInstance boxScopeInstance115 = BoxScopeInstance.INSTANCE;
                        if (statusContent instanceof StatusTextContent) {
                            composerStartRestartGroup.startReplaceGroup(954996115);
                            StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (statusContent instanceof StatusImageContent) {
                                composerStartRestartGroup.startReplaceGroup(955254500);
                                int i2111116 = i13 >> 12;
                                StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2111116 & 896) | (i2111116 & 7168));
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (statusContent instanceof StatusVideoContent) {
                                composerStartRestartGroup.startReplaceGroup(955563353);
                                int i2111117 = i13 >> 3;
                                int i3114 = (i2111117 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2111117) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2111117 & 29360128);
                                z26 = z17;
                                StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3114);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                z26 = z17;
                                composerStartRestartGroup.startReplaceGroup(956007707);
                                StatusNotAvailable(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z20 = z23;
                            z21 = z24;
                            modifier3 = modifier119;
                            z19 = z25;
                            z22 = z26;
                            i24 = i25;
                            str2 = str3;
                        }
                        z26 = z17;
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier119;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i24 = i10;
                        z19 = z14;
                        modifier3 = modifier2;
                        z20 = z15;
                        z21 = z16;
                        z22 = z17;
                        str2 = str;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy116 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA116 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion116 = ComposeUiNode.INSTANCE;
                    constructor = companion116.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl116 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier1110 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl116, measurePolicyMaybeCachedBoxMeasurePolicy116, companion116.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl116, currentCompositionLocalMap116, companion116.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl116, Integer.valueOf(iA116), companion116.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl116, companion116.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl116, modifierMaterializeModifier116, companion116.getSetModifier());
                    BoxScopeInstance boxScopeInstance116 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i2111118 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i2111118 & 896) | (i2111118 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i2111119 = i13 >> 3;
                            int i3115 = (i2111119 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i2111119) | (458752 & (i13 << 3)) | (3670016 & i13) | (i2111119 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3115);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier1110;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier1110;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 12582912;
            i22 = i12 & 256;
            if (i22 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i23 = 67108864;
                    } else {
                        i23 = 33554432;
                    }
                    i13 |= i23;
                }
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy117 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA117 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion117 = ComposeUiNode.INSTANCE;
                    constructor = companion117.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl117 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier1111 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl117, measurePolicyMaybeCachedBoxMeasurePolicy117, companion117.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl117, currentCompositionLocalMap117, companion117.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl117, Integer.valueOf(iA117), companion117.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl117, companion117.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl117, modifierMaterializeModifier117, companion117.getSetModifier());
                    BoxScopeInstance boxScopeInstance117 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i21111110 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21111110 & 896) | (i21111110 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i21111111 = i13 >> 3;
                            int i3116 = (i21111111 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21111111) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21111111 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3116);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier1111;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier1111;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) != 38347922) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                if (i26 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i27 != 0) {
                    z23 = false;
                } else {
                    z23 = z15;
                }
                if (i14 != 0) {
                    z24 = false;
                } else {
                    z24 = z16;
                }
                if (i16 != 0) {
                    z17 = false;
                }
                if (i18 != 0) {
                    i25 = 70;
                } else {
                    i25 = i10;
                }
                if (i20 != 0) {
                    z25 = false;
                } else {
                    z25 = z14;
                }
                if (i22 != 0) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy118 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA118 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion118 = ComposeUiNode.INSTANCE;
                constructor = companion118.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl118 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Modifier modifier1112 = modifier4;
                Updater.m5184setimpl(composerM5176constructorimpl118, measurePolicyMaybeCachedBoxMeasurePolicy118, companion118.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl118, currentCompositionLocalMap118, companion118.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl118, Integer.valueOf(iA118), companion118.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl118, companion118.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl118, modifierMaterializeModifier118, companion118.getSetModifier());
                BoxScopeInstance boxScopeInstance118 = BoxScopeInstance.INSTANCE;
                if (statusContent instanceof StatusTextContent) {
                    composerStartRestartGroup.startReplaceGroup(954996115);
                    StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (statusContent instanceof StatusImageContent) {
                        composerStartRestartGroup.startReplaceGroup(955254500);
                        int i21111112 = i13 >> 12;
                        StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21111112 & 896) | (i21111112 & 7168));
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (statusContent instanceof StatusVideoContent) {
                        composerStartRestartGroup.startReplaceGroup(955563353);
                        int i21111113 = i13 >> 3;
                        int i3117 = (i21111113 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21111113) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21111113 & 29360128);
                        z26 = z17;
                        StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3117);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z26 = z17;
                        composerStartRestartGroup.startReplaceGroup(956007707);
                        StatusNotAvailable(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier1112;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                }
                z26 = z17;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z20 = z23;
                z21 = z24;
                modifier3 = modifier1112;
                z19 = z25;
                z22 = z26;
                i24 = i25;
                str2 = str3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i24 = i10;
                z19 = z14;
                modifier3 = modifier2;
                z20 = z15;
                z21 = z16;
                z22 = z17;
                str2 = str;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z17 = z13;
        i18 = i12 & 64;
        if (i18 != 0) {
            i13 |= 1572864;
        } else if ((i11 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(i10)) {
                i19 = 1048576;
            } else {
                i19 = 524288;
            }
            i13 |= i19;
        }
        i20 = i12 & 128;
        if (i20 != 0) {
            if ((i11 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z14)) {
                    i21 = 8388608;
                } else {
                    i21 = 4194304;
                }
                i13 |= i21;
            }
            i22 = i12 & 256;
            if (i22 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i23 = 67108864;
                    } else {
                        i23 = 33554432;
                    }
                    i13 |= i23;
                }
                if ((i13 & 38347923) != 38347922) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                    if (i26 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i27 != 0) {
                        z23 = false;
                    } else {
                        z23 = z15;
                    }
                    if (i14 != 0) {
                        z24 = false;
                    } else {
                        z24 = z16;
                    }
                    if (i16 != 0) {
                        z17 = false;
                    }
                    if (i18 != 0) {
                        i25 = 70;
                    } else {
                        i25 = i10;
                    }
                    if (i20 != 0) {
                        z25 = false;
                    } else {
                        z25 = z14;
                    }
                    if (i22 != 0) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy119 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int iA119 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                    ComposeUiNode.Companion companion119 = ComposeUiNode.INSTANCE;
                    constructor = companion119.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl119 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Modifier modifier1113 = modifier4;
                    Updater.m5184setimpl(composerM5176constructorimpl119, measurePolicyMaybeCachedBoxMeasurePolicy119, companion119.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl119, currentCompositionLocalMap119, companion119.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl119, Integer.valueOf(iA119), companion119.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl119, companion119.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl119, modifierMaterializeModifier119, companion119.getSetModifier());
                    BoxScopeInstance boxScopeInstance119 = BoxScopeInstance.INSTANCE;
                    if (statusContent instanceof StatusTextContent) {
                        composerStartRestartGroup.startReplaceGroup(954996115);
                        StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (statusContent instanceof StatusImageContent) {
                            composerStartRestartGroup.startReplaceGroup(955254500);
                            int i21111114 = i13 >> 12;
                            StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21111114 & 896) | (i21111114 & 7168));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (statusContent instanceof StatusVideoContent) {
                            composerStartRestartGroup.startReplaceGroup(955563353);
                            int i21111115 = i13 >> 3;
                            int i3118 = (i21111115 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21111115) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21111115 & 29360128);
                            z26 = z17;
                            StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3118);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z26 = z17;
                            composerStartRestartGroup.startReplaceGroup(956007707);
                            StatusNotAvailable(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z20 = z23;
                        z21 = z24;
                        modifier3 = modifier1113;
                        z19 = z25;
                        z22 = z26;
                        i24 = i25;
                        str2 = str3;
                    }
                    z26 = z17;
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier1113;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i24 = i10;
                    z19 = z14;
                    modifier3 = modifier2;
                    z20 = z15;
                    z21 = z16;
                    z22 = z17;
                    str2 = str;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) != 38347922) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                if (i26 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i27 != 0) {
                    z23 = false;
                } else {
                    z23 = z15;
                }
                if (i14 != 0) {
                    z24 = false;
                } else {
                    z24 = z16;
                }
                if (i16 != 0) {
                    z17 = false;
                }
                if (i18 != 0) {
                    i25 = 70;
                } else {
                    i25 = i10;
                }
                if (i20 != 0) {
                    z25 = false;
                } else {
                    z25 = z14;
                }
                if (i22 != 0) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA1110 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion1110 = ComposeUiNode.INSTANCE;
                constructor = companion1110.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl1110 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Modifier modifier1114 = modifier4;
                Updater.m5184setimpl(composerM5176constructorimpl1110, measurePolicyMaybeCachedBoxMeasurePolicy1110, companion1110.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl1110, currentCompositionLocalMap1110, companion1110.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl1110, Integer.valueOf(iA1110), companion1110.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl1110, companion1110.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl1110, modifierMaterializeModifier1110, companion1110.getSetModifier());
                BoxScopeInstance boxScopeInstance1110 = BoxScopeInstance.INSTANCE;
                if (statusContent instanceof StatusTextContent) {
                    composerStartRestartGroup.startReplaceGroup(954996115);
                    StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (statusContent instanceof StatusImageContent) {
                        composerStartRestartGroup.startReplaceGroup(955254500);
                        int i21111116 = i13 >> 12;
                        StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21111116 & 896) | (i21111116 & 7168));
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (statusContent instanceof StatusVideoContent) {
                        composerStartRestartGroup.startReplaceGroup(955563353);
                        int i21111117 = i13 >> 3;
                        int i3119 = (i21111117 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21111117) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21111117 & 29360128);
                        z26 = z17;
                        StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i3119);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z26 = z17;
                        composerStartRestartGroup.startReplaceGroup(956007707);
                        StatusNotAvailable(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier1114;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                }
                z26 = z17;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z20 = z23;
                z21 = z24;
                modifier3 = modifier1114;
                z19 = z25;
                z22 = z26;
                i24 = i25;
                str2 = str3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i24 = i10;
                z19 = z14;
                modifier3 = modifier2;
                z20 = z15;
                z21 = z16;
                z22 = z17;
                str2 = str;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 12582912;
        i22 = i12 & 256;
        if (i22 != 0) {
            if ((i11 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i23 = 67108864;
                } else {
                    i23 = 33554432;
                }
                i13 |= i23;
            }
            if ((i13 & 38347923) != 38347922) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
                if (i26 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i27 != 0) {
                    z23 = false;
                } else {
                    z23 = z15;
                }
                if (i14 != 0) {
                    z24 = false;
                } else {
                    z24 = z16;
                }
                if (i16 != 0) {
                    z17 = false;
                }
                if (i18 != 0) {
                    i25 = 70;
                } else {
                    i25 = i10;
                }
                if (i20 != 0) {
                    z25 = false;
                } else {
                    z25 = z14;
                }
                if (i22 != 0) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA1111 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                ComposeUiNode.Companion companion1111 = ComposeUiNode.INSTANCE;
                constructor = companion1111.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl1111 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Modifier modifier1115 = modifier4;
                Updater.m5184setimpl(composerM5176constructorimpl1111, measurePolicyMaybeCachedBoxMeasurePolicy1111, companion1111.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl1111, currentCompositionLocalMap1111, companion1111.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl1111, Integer.valueOf(iA1111), companion1111.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl1111, companion1111.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl1111, modifierMaterializeModifier1111, companion1111.getSetModifier());
                BoxScopeInstance boxScopeInstance1111 = BoxScopeInstance.INSTANCE;
                if (statusContent instanceof StatusTextContent) {
                    composerStartRestartGroup.startReplaceGroup(954996115);
                    StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (statusContent instanceof StatusImageContent) {
                        composerStartRestartGroup.startReplaceGroup(955254500);
                        int i21111118 = i13 >> 12;
                        StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i21111118 & 896) | (i21111118 & 7168));
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (statusContent instanceof StatusVideoContent) {
                        composerStartRestartGroup.startReplaceGroup(955563353);
                        int i21111119 = i13 >> 3;
                        int i31110 = (i21111119 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i21111119) | (458752 & (i13 << 3)) | (3670016 & i13) | (i21111119 & 29360128);
                        z26 = z17;
                        StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i31110);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z26 = z17;
                        composerStartRestartGroup.startReplaceGroup(956007707);
                        StatusNotAvailable(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z20 = z23;
                    z21 = z24;
                    modifier3 = modifier1115;
                    z19 = z25;
                    z22 = z26;
                    i24 = i25;
                    str2 = str3;
                }
                z26 = z17;
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z20 = z23;
                z21 = z24;
                modifier3 = modifier1115;
                z19 = z25;
                z22 = z26;
                i24 = i25;
                str2 = str3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i24 = i10;
                z19 = z14;
                modifier3 = modifier2;
                z20 = z15;
                z21 = z16;
                z22 = z17;
                str2 = str;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 100663296;
        if ((i13 & 38347923) != 38347922) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z18, i13 & 1)) {
            if (i26 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i27 != 0) {
                z23 = false;
            } else {
                z23 = z15;
            }
            if (i14 != 0) {
                z24 = false;
            } else {
                z24 = z16;
            }
            if (i16 != 0) {
                z17 = false;
            }
            if (i18 != 0) {
                i25 = 70;
            } else {
                i25 = i10;
            }
            if (i20 != 0) {
                z25 = false;
            } else {
                z25 = z14;
            }
            if (i22 != 0) {
                str3 = "";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(614589273, i13, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusItem (StatusItem.kt:58)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA1112 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap1112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            ComposeUiNode.Companion companion1112 = ComposeUiNode.INSTANCE;
            constructor = companion1112.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl1112 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Modifier modifier1116 = modifier4;
            Updater.m5184setimpl(composerM5176constructorimpl1112, measurePolicyMaybeCachedBoxMeasurePolicy1112, companion1112.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl1112, currentCompositionLocalMap1112, companion1112.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl1112, Integer.valueOf(iA1112), companion1112.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl1112, companion1112.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl1112, modifierMaterializeModifier1112, companion1112.getSetModifier());
            BoxScopeInstance boxScopeInstance1112 = BoxScopeInstance.INSTANCE;
            if (statusContent instanceof StatusTextContent) {
                composerStartRestartGroup.startReplaceGroup(954996115);
                StatusTextTypeKt.StatusTextContentItem((StatusTextContent) statusContent, z10, i25, composerStartRestartGroup, ((i13 >> 3) & 126) | ((i13 >> 12) & 896));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (statusContent instanceof StatusImageContent) {
                    composerStartRestartGroup.startReplaceGroup(955254500);
                    int i211111110 = i13 >> 12;
                    StatusImgTypeKt.StatusImgContentItem((StatusImageContent) statusContent, z10, i25, z25, composerStartRestartGroup, ((i13 >> 3) & 126) | (i211111110 & 896) | (i211111110 & 7168));
                    composerStartRestartGroup.endReplaceGroup();
                } else if (statusContent instanceof StatusVideoContent) {
                    composerStartRestartGroup.startReplaceGroup(955563353);
                    int i211111111 = i13 >> 3;
                    int i31111 = (i211111111 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i13 >> 12) & 7168) | (57344 & i211111111) | (458752 & (i13 << 3)) | (3670016 & i13) | (i211111111 & 29360128);
                    z26 = z17;
                    StatusVideoTypeKt.StatusVideoContentItem((StatusVideoContent) statusContent, z10, z23, z25, z26, z24, i25, str3, composerStartRestartGroup, i31111);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z26 = z17;
                    composerStartRestartGroup.startReplaceGroup(956007707);
                    StatusNotAvailable(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z20 = z23;
                z21 = z24;
                modifier3 = modifier1116;
                z19 = z25;
                z22 = z26;
                i24 = i25;
                str2 = str3;
            }
            z26 = z17;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z20 = z23;
            z21 = z24;
            modifier3 = modifier1116;
            z19 = z25;
            z22 = z26;
            i24 = i25;
            str2 = str3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            i24 = i10;
            z19 = z14;
            modifier3 = modifier2;
            z20 = z15;
            z21 = z16;
            z22 = z17;
            str2 = str;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusItemKt.StatusItem$lambda$1(modifier3, statusContent, z10, z20, z21, z22, i24, z19, str2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusItem$lambda$1(Modifier modifier, Content content, boolean z10, boolean z11, boolean z12, boolean z13, int i10, boolean z14, String str, int i11, int i12, Composer composer, int i13) {
        StatusItem(modifier, content, z10, z11, z12, z13, i10, z14, str, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusNotAvailable(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(331444982);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(331444982, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusNotAvailable (StatusItem.kt:346)");
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl(20));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
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
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.incompatible_status, composerStartRestartGroup, 0), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusItemKt.StatusNotAvailable$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusNotAvailable$lambda$1(int i10, Composer composer, int i11) {
        StatusNotAvailable(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusPlaceholder(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1832159641);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1832159641, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusPlaceholder (StatusItem.kt:99)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(20), 0.0f, 2, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Z17ShimmerLoaderKt.Z17Shimmer(ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(40)), 1.0f, false, 2, null), RectangleShapeKt.getRectangleShape()), composerStartRestartGroup, 6);
            SpacerKt.Spacer(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            float f10 = 10;
            Z17ShimmerLoaderKt.Z17Shimmer(ClipKt.clip(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f10)), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            Z17ShimmerLoaderKt.Z17Shimmer(ClipKt.clip(SizeKt.m1771sizeVpY3zN4(companion, Dp.m8823constructorimpl(2), Dp.m8823constructorimpl(f10)), RectangleShapeKt.getRectangleShape()), composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusItemKt.StatusPlaceholder$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPlaceholder$lambda$1(int i10, Composer composer, int i11) {
        StatusPlaceholder(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusPlaceholderLite(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1580670837);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1580670837, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusPlaceholderLite (StatusItem.kt:131)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 10;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierClip = ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(40)), 1.0f, false, 2, null), RectangleShapeKt.getRectangleShape());
            Color.Companion companion3 = Color.INSTANCE;
            BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(modifierClip, companion3.m5893getBlue0d7_KjU(), null, 2, null), composerStartRestartGroup, 6);
            SpacerKt.Spacer(e3.a(rowScopeInstance, companion, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f10)), RoundedCornerShapeKt.getCircleShape()), companion3.m5893getBlue0d7_KjU(), null, 2, null), composerStartRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1771sizeVpY3zN4(companion, Dp.m8823constructorimpl(2), Dp.m8823constructorimpl(f10)), RectangleShapeKt.getRectangleShape()), companion3.m5893getBlue0d7_KjU(), null, 2, null), composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusItemKt.StatusPlaceholderLite$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPlaceholderLite$lambda$1(int i10, Composer composer, int i11) {
        StatusPlaceholderLite(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x009e  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:67:0x0139  */
    /* JADX WARN: Code duplicated, block: B:70:0x0145  */
    /* JADX WARN: Code duplicated, block: B:71:0x0149  */
    /* JADX WARN: Code duplicated, block: B:74:0x0187  */
    /* JADX WARN: Code duplicated, block: B:75:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:78:0x0203  */
    /* JADX WARN: Code duplicated, block: B:80:0x020d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0239  */
    /* JADX WARN: Code duplicated, block: B:84:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:87:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:88:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:91:0x0387  */
    /* JADX WARN: Code duplicated, block: B:93:0x038d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0398  */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void StatusPreviewItem(Modifier modifier, final StatusWithPartnersOrRooms statusWithPartnersOrRooms, final int i10, final int i11, boolean z10, Composer composer, final int i12, final int i13) {
        Modifier modifier2;
        int i14;
        boolean z11;
        boolean z12;
        final Modifier modifier3;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z14;
        long primary;
        lb.a constructor;
        Content content;
        Object obj;
        float f10;
        boolean z15;
        lb.a constructor2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1055572688);
        int i15 = i13 & 1;
        if (i15 != 0) {
            i14 = i12 | 6;
            modifier2 = modifier;
        } else if ((i12 & 6) == 0) {
            modifier2 = modifier;
            i14 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i12;
        } else {
            modifier2 = modifier;
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(statusWithPartnersOrRooms) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(i11) ? 2048 : 1024;
        }
        int i16 = i13 & 16;
        if (i16 == 0) {
            if ((i12 & 24576) == 0) {
                z11 = z10;
                i14 |= composerStartRestartGroup.changed(z11) ? 16384 : 8192;
            }
            if ((i14 & 9363) != 9362) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                if (i15 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i16 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1055572688, i14, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusPreviewItem (StatusItem.kt:213)");
                }
                float f11 = 15;
                Modifier modifierClip = ClipKt.clip(modifier3, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)));
                float fM8823constructorimpl = Dp.m8823constructorimpl((float) 1.5d);
                if (statusWithPartnersOrRooms.getStatus().getSeen()) {
                    composerStartRestartGroup.startReplaceGroup(793085280);
                    primary = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(793087799);
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierClip, fM8823constructorimpl, primary, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)));
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1216borderxT4_qwU);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
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
                content = statusWithPartnersOrRooms.getStatus().getContent();
                if (content instanceof StatusTextContent) {
                    composerStartRestartGroup.startReplaceGroup(-338071071);
                    StatusTextTypeKt.StatusPreviewTextContent(SizeKt.m1756heightInVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl(i10 / 3), Dp.m8823constructorimpl(i10 / 2)), (StatusTextContent) statusWithPartnersOrRooms.getStatus().getContent(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    obj = null;
                    f10 = 0.0f;
                    z15 = z14;
                } else if (content instanceof StatusImageContent) {
                    composerStartRestartGroup.startReplaceGroup(-337721329);
                    f10 = 0.0f;
                    StatusImgTypeKt.StatusPreviewImgContentItem(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl((float) (((double) i10) / 2.2d))), (StatusImageContent) statusWithPartnersOrRooms.getStatus().getContent(), ContentScale.INSTANCE.getCrop(), z14, composerStartRestartGroup, ((i14 >> 3) & 7168) | RendererCapabilities.DECODER_SUPPORT_MASK);
                    z15 = z14;
                    composerStartRestartGroup.endReplaceGroup();
                    obj = null;
                } else {
                    obj = null;
                    f10 = 0.0f;
                    z15 = z14;
                    if (content instanceof StatusVideoContent) {
                        composerStartRestartGroup.startReplaceGroup(-337295823);
                        StatusVideoTypeKt.StatusPreviewVideoContentItem(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl((float) (((double) i11) / 2.5d))), (StatusVideoContent) statusWithPartnersOrRooms.getStatus().getContent(), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-336988892);
                        StatusNotAvailable(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(boxScopeInstance.align(companion3, companion.getBottomEnd()), f10, 1, obj);
                Brush.Companion companion4 = Brush.INSTANCE;
                Color.Companion companion5 = Color.INSTANCE;
                float f12 = 5;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.background$default(modifierFillMaxWidth$default, Brush.Companion.m5827verticalGradient8A3gB4$default(companion4, va.w.q(Color.m5856boximpl(companion5.m5901getTransparent0d7_KjU()), Color.m5856boximpl(Color.m5865copywmQWz5c$default(companion5.m5892getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null))), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m8823constructorimpl(f12));
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getEnd(), companion.getCenterVertically(), composerStartRestartGroup, 54);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
                constructor2 = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, statusWithPartnersOrRooms.getRepliedName(), null, companion5.m5903getWhite0d7_KjU(), 0, 10, composerStartRestartGroup, 199680, 21);
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(f12)), composerStartRestartGroup, 6);
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(30)), statusWithPartnersOrRooms.getRepliedThumbnail(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(statusWithPartnersOrRooms.getRepliedName()))), null, null, 0, null, false, null, statusWithPartnersOrRooms.getRepliedName(), true, 0, composerStartRestartGroup, 6, 6, 2552);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z15;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return StatusItemKt.StatusPreviewItem$lambda$1(modifier3, statusWithPartnersOrRooms, i10, i11, z13, i12, i13, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i14 |= 24576;
        z11 = z10;
        if ((i14 & 9363) != 9362) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
            if (i15 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i16 != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1055572688, i14, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusPreviewItem (StatusItem.kt:213)");
            }
            float f13 = 15;
            Modifier modifierClip2 = ClipKt.clip(modifier3, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f13)));
            float fM8823constructorimpl2 = Dp.m8823constructorimpl((float) 1.5d);
            if (statusWithPartnersOrRooms.getStatus().getSeen()) {
                composerStartRestartGroup.startReplaceGroup(793085280);
                primary = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(793087799);
                primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(modifierClip2, fM8823constructorimpl2, primary, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f13)));
            Alignment.Companion companion6 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion6.getTopStart(), false);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1216borderxT4_qwU2);
            ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
            constructor = companion7.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion7.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion7.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion7.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion7.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            content = statusWithPartnersOrRooms.getStatus().getContent();
            if (content instanceof StatusTextContent) {
                composerStartRestartGroup.startReplaceGroup(-338071071);
                StatusTextTypeKt.StatusPreviewTextContent(SizeKt.m1756heightInVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl(i10 / 3), Dp.m8823constructorimpl(i10 / 2)), (StatusTextContent) statusWithPartnersOrRooms.getStatus().getContent(), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                obj = null;
                f10 = 0.0f;
                z15 = z14;
            } else if (content instanceof StatusImageContent) {
                composerStartRestartGroup.startReplaceGroup(-337721329);
                f10 = 0.0f;
                StatusImgTypeKt.StatusPreviewImgContentItem(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl((float) (((double) i10) / 2.2d))), (StatusImageContent) statusWithPartnersOrRooms.getStatus().getContent(), ContentScale.INSTANCE.getCrop(), z14, composerStartRestartGroup, ((i14 >> 3) & 7168) | RendererCapabilities.DECODER_SUPPORT_MASK);
                z15 = z14;
                composerStartRestartGroup.endReplaceGroup();
                obj = null;
            } else {
                obj = null;
                f10 = 0.0f;
                z15 = z14;
                if (content instanceof StatusVideoContent) {
                    composerStartRestartGroup.startReplaceGroup(-337295823);
                    StatusVideoTypeKt.StatusPreviewVideoContentItem(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl((float) (((double) i11) / 2.5d))), (StatusVideoContent) statusWithPartnersOrRooms.getStatus().getContent(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-336988892);
                    StatusNotAvailable(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            Modifier.Companion companion8 = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(boxScopeInstance2.align(companion8, companion6.getBottomEnd()), f10, 1, obj);
            Brush.Companion companion9 = Brush.INSTANCE;
            Color.Companion companion10 = Color.INSTANCE;
            float f14 = 5;
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.background$default(modifierFillMaxWidth$default2, Brush.Companion.m5827verticalGradient8A3gB4$default(companion9, va.w.q(Color.m5856boximpl(companion10.m5901getTransparent0d7_KjU()), Color.m5856boximpl(Color.m5865copywmQWz5c$default(companion10.m5892getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null))), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m8823constructorimpl(f14));
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getEnd(), companion6.getCenterVertically(), composerStartRestartGroup, 54);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
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
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion7.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion7.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion7.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion7.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, statusWithPartnersOrRooms.getRepliedName(), null, companion10.m5903getWhite0d7_KjU(), 0, 10, composerStartRestartGroup, 199680, 21);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion8, Dp.m8823constructorimpl(f14)), composerStartRestartGroup, 6);
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(companion8, Dp.m8823constructorimpl(30)), statusWithPartnersOrRooms.getRepliedThumbnail(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(statusWithPartnersOrRooms.getRepliedName()))), null, null, 0, null, false, null, statusWithPartnersOrRooms.getRepliedName(), true, 0, composerStartRestartGroup, 6, 6, 2552);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z15;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z13 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StatusItemKt.StatusPreviewItem$lambda$1(modifier3, statusWithPartnersOrRooms, i10, i11, z13, i12, i13, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewItem$lambda$1(Modifier modifier, StatusWithPartnersOrRooms statusWithPartnersOrRooms, int i10, int i11, boolean z10, int i12, int i13, Composer composer, int i14) {
        StatusPreviewItem(modifier, statusWithPartnersOrRooms, i10, i11, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusPreviewItemPlaceholder(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(650502260);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(650502260, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusPreviewItemPlaceholder (StatusItem.kt:301)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierClip = ClipKt.clip(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(200)), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
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
            Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), composerStartRestartGroup, 6);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Brush.Companion companion4 = Brush.INSTANCE;
            Color.Companion companion5 = Color.INSTANCE;
            BoxKt.Box(BackgroundKt.background$default(modifierFillMaxSize$default, Brush.Companion.m5819horizontalGradient8A3gB4$default(companion4, va.w.q(Color.m5856boximpl(companion5.m5903getWhite0d7_KjU()), Color.m5856boximpl(companion5.m5903getWhite0d7_KjU()), Color.m5856boximpl(companion5.m5892getBlack0d7_KjU())), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), composerStartRestartGroup, 6);
            float f10 = 10;
            Z17ShimmerLoaderKt.Z17Shimmer(PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(SizeKt.m1757heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(f10), 0.0f, 2, null), companion2.getBottomEnd()), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 7, null), composerStartRestartGroup, 0);
            Z17ShimmerLoaderKt.Z17Shimmer(ClipKt.clip(PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(30)), companion2.getBottomEnd()), Dp.m8823constructorimpl(5)), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusItemKt.StatusPreviewItemPlaceholder$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewItemPlaceholder$lambda$1(int i10, Composer composer, int i11) {
        StatusPreviewItemPlaceholder(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
