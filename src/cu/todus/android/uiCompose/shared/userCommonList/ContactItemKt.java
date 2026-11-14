package cu.todus.android.uiCompose.shared.userCommonList;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckCircleOutlineKt;
import androidx.compose.material.icons.outlined.RadioButtonUncheckedKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.R;
import cu.todus.android.uiCompose.shared.userCommonList.ContactItemKt;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aK\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a9\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u000f\u0010\u0010\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", XHTMLText.IMG, "name", "tag", "Lkotlin/Function0;", "Lua/k0;", "onClick", "onLongClick", "ContactItem", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "UnknownContactItem", "(Ljava/lang/String;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "", "isSelected", "SelectionContactItem", "(Ljava/lang/String;Ljava/lang/String;ZLlb/a;Landroidx/compose/runtime/Composer;II)V", "ContactPlaceholder", "(Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContactItemKt {
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x0144  */
    /* JADX WARN: Code duplicated, block: B:84:0x0150  */
    /* JADX WARN: Code duplicated, block: B:85:0x0154  */
    /* JADX WARN: Code duplicated, block: B:88:0x0230  */
    /* JADX WARN: Code duplicated, block: B:90:0x023a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0248  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ContactItem(String str, String str2, String str3, final a onClick, a aVar, Composer composer, final int i10, final int i11) {
        String str4;
        int i12;
        String str5;
        int i13;
        String str6;
        int i14;
        int i15;
        a aVar2;
        int i16;
        int i17;
        boolean z10;
        Composer composer2;
        final String str7;
        final String str8;
        final String str9;
        final a aVar3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str10;
        String str11;
        String str12;
        a aVar4;
        a constructor;
        Object objRememberedValue;
        int i18;
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(310202816);
        int i19 = i11 & 1;
        if (i19 != 0) {
            i12 = i10 | 6;
            str4 = str;
        } else if ((i10 & 6) == 0) {
            str4 = str;
            i12 = (composerStartRestartGroup.changed(str4) ? 4 : 2) | i10;
        } else {
            str4 = str;
            i12 = i10;
        }
        int i20 = i11 & 2;
        if (i20 == 0) {
            if ((i10 & 48) == 0) {
                str5 = str2;
                i12 |= composerStartRestartGroup.changed(str5) ? 32 : 16;
            }
            i13 = i11 & 4;
            if (i13 != 0) {
                if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    str6 = str3;
                    if (composerStartRestartGroup.changed(str6)) {
                        i14 = 256;
                    } else {
                        i14 = 128;
                    }
                    i12 |= i14;
                }
                if ((i10 & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClick)) {
                        i18 = 2048;
                    } else {
                        i18 = 1024;
                    }
                    i12 |= i18;
                }
                i15 = i11 & 16;
                if (i15 != 0) {
                    if ((i10 & 24576) == 0) {
                        aVar2 = aVar;
                        if (composerStartRestartGroup.changedInstance(aVar2)) {
                            i16 = 16384;
                        } else {
                            i16 = 8192;
                        }
                        i12 |= i16;
                    }
                    i17 = i12;
                    if ((i17 & 9363) != 9362) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
                        if (i19 != 0) {
                            str10 = "";
                        } else {
                            str10 = str4;
                        }
                        if (i20 != 0) {
                            str11 = "";
                        } else {
                            str11 = str5;
                        }
                        if (i13 != 0) {
                            str12 = "";
                        } else {
                            str12 = str6;
                        }
                        if (i15 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new a() { // from class: w8.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (a) objRememberedValue;
                        } else {
                            aVar4 = aVar2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(310202816, i17, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactItem (ContactItem.kt:42)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        String str13 = str11;
                        a aVar5 = aVar4;
                        float f10 = 10;
                        Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f10));
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                        int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        constructor = companion2.getConstructor();
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
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), Dp.m8823constructorimpl(40));
                        Color colorM5856boximpl = Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str13)));
                        int i21 = ((i17 << 3) & 112) | 1597446 | ((i17 << 24) & C.ENCODING_PCM_DOUBLE);
                        String str14 = str10;
                        Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs, str14, colorM5856boximpl, null, "", 0, 50, false, null, str13, true, 0, composerStartRestartGroup, i21, 6, 2472);
                        Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        int i22 = MaterialTheme.$stable;
                        composer2 = composerStartRestartGroup;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA, str13, materialTheme.getTypography(composerStartRestartGroup, i22).getBodyLarge(), 0L, 1, 0, composer2, (i17 & 112) | 24576, 40);
                        String str15 = str12;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(null, str15, materialTheme.getTypography(composer2, i22).getLabelSmall(), 0L, 1, 0, composer2, ((i17 >> 3) & 112) | 24576, 41);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str9 = str15;
                        str7 = str14;
                        str8 = str13;
                        aVar3 = aVar5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        str7 = str4;
                        str8 = str5;
                        str9 = str6;
                        aVar3 = aVar2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.d
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ContactItemKt.ContactItem$lambda$2(str7, str8, str9, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 24576;
                aVar2 = aVar;
                i17 = i12;
                if ((i17 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
                    if (i19 != 0) {
                        str10 = "";
                    } else {
                        str10 = str4;
                    }
                    if (i20 != 0) {
                        str11 = "";
                    } else {
                        str11 = str5;
                    }
                    if (i13 != 0) {
                        str12 = "";
                    } else {
                        str12 = str6;
                    }
                    if (i15 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: w8.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(310202816, i17, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactItem (ContactItem.kt:42)");
                    }
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    String str16 = str11;
                    a aVar6 = aVar4;
                    float f11 = 10;
                    Modifier modifierM1726paddingVpY3zN5 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f11));
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                    int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN5);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    constructor = companion4.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion3, 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null), Dp.m8823constructorimpl(40));
                    Color colorM5856boximpl2 = Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str16)));
                    int i23 = ((i17 << 3) & 112) | 1597446 | ((i17 << 24) & C.ENCODING_PCM_DOUBLE);
                    String str17 = str10;
                    Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs2, str17, colorM5856boximpl2, null, "", 0, 50, false, null, str16, true, 0, composerStartRestartGroup, i23, 6, 2472);
                    Modifier modifierA2 = e3.a(rowScopeInstance2, companion3, 1.0f, false, 2, null);
                    MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                    int i24 = MaterialTheme.$stable;
                    composer2 = composerStartRestartGroup;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA2, str16, materialTheme2.getTypography(composerStartRestartGroup, i24).getBodyLarge(), 0L, 1, 0, composer2, (i17 & 112) | 24576, 40);
                    String str18 = str12;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, str18, materialTheme2.getTypography(composer2, i24).getLabelSmall(), 0L, 1, 0, composer2, ((i17 >> 3) & 112) | 24576, 41);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str9 = str18;
                    str7 = str17;
                    str8 = str16;
                    aVar3 = aVar6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    str7 = str4;
                    str8 = str5;
                    str9 = str6;
                    aVar3 = aVar2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ContactItemKt.ContactItem$lambda$2(str7, str8, str9, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            str6 = str3;
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onClick)) {
                    i18 = 2048;
                } else {
                    i18 = 1024;
                }
                i12 |= i18;
            }
            i15 = i11 & 16;
            if (i15 != 0) {
                if ((i10 & 24576) == 0) {
                    aVar2 = aVar;
                    if (composerStartRestartGroup.changedInstance(aVar2)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i12 |= i16;
                }
                i17 = i12;
                if ((i17 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
                    if (i19 != 0) {
                        str10 = "";
                    } else {
                        str10 = str4;
                    }
                    if (i20 != 0) {
                        str11 = "";
                    } else {
                        str11 = str5;
                    }
                    if (i13 != 0) {
                        str12 = "";
                    } else {
                        str12 = str6;
                    }
                    if (i15 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: w8.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(310202816, i17, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactItem (ContactItem.kt:42)");
                    }
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    String str19 = str11;
                    a aVar7 = aVar4;
                    float f12 = 10;
                    Modifier modifierM1726paddingVpY3zN6 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion5, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f12));
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                    int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN6);
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
                    Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy3, companion6.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion6.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion6.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion6.getSetModifier());
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    Modifier modifierM1769size3ABfNKs3 = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion5, 0.0f, 0.0f, Dp.m8823constructorimpl(f12), 0.0f, 11, null), Dp.m8823constructorimpl(40));
                    Color colorM5856boximpl3 = Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str19)));
                    int i25 = ((i17 << 3) & 112) | 1597446 | ((i17 << 24) & C.ENCODING_PCM_DOUBLE);
                    String str110 = str10;
                    Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs3, str110, colorM5856boximpl3, null, "", 0, 50, false, null, str19, true, 0, composerStartRestartGroup, i25, 6, 2472);
                    Modifier modifierA3 = e3.a(rowScopeInstance3, companion5, 1.0f, false, 2, null);
                    MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                    int i26 = MaterialTheme.$stable;
                    composer2 = composerStartRestartGroup;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA3, str19, materialTheme3.getTypography(composerStartRestartGroup, i26).getBodyLarge(), 0L, 1, 0, composer2, (i17 & 112) | 24576, 40);
                    String str111 = str12;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, str111, materialTheme3.getTypography(composer2, i26).getLabelSmall(), 0L, 1, 0, composer2, ((i17 >> 3) & 112) | 24576, 41);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str9 = str111;
                    str7 = str110;
                    str8 = str19;
                    aVar3 = aVar7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    str7 = str4;
                    str8 = str5;
                    str9 = str6;
                    aVar3 = aVar2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ContactItemKt.ContactItem$lambda$2(str7, str8, str9, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            aVar2 = aVar;
            i17 = i12;
            if ((i17 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
                if (i19 != 0) {
                    str10 = "";
                } else {
                    str10 = str4;
                }
                if (i20 != 0) {
                    str11 = "";
                } else {
                    str11 = str5;
                }
                if (i13 != 0) {
                    str12 = "";
                } else {
                    str12 = str6;
                }
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: w8.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(310202816, i17, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactItem (ContactItem.kt:42)");
                }
                Modifier.Companion companion7 = Modifier.INSTANCE;
                String str112 = str11;
                a aVar8 = aVar4;
                float f13 = 10;
                Modifier modifierM1726paddingVpY3zN7 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion7, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f13));
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN7);
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                constructor = companion8.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy4, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion8.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion8.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion8.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion8.getSetModifier());
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                Modifier modifierM1769size3ABfNKs4 = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion7, 0.0f, 0.0f, Dp.m8823constructorimpl(f13), 0.0f, 11, null), Dp.m8823constructorimpl(40));
                Color colorM5856boximpl4 = Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str112)));
                int i27 = ((i17 << 3) & 112) | 1597446 | ((i17 << 24) & C.ENCODING_PCM_DOUBLE);
                String str113 = str10;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs4, str113, colorM5856boximpl4, null, "", 0, 50, false, null, str112, true, 0, composerStartRestartGroup, i27, 6, 2472);
                Modifier modifierA4 = e3.a(rowScopeInstance4, companion7, 1.0f, false, 2, null);
                MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                int i28 = MaterialTheme.$stable;
                composer2 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA4, str112, materialTheme4.getTypography(composerStartRestartGroup, i28).getBodyLarge(), 0L, 1, 0, composer2, (i17 & 112) | 24576, 40);
                String str114 = str12;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str114, materialTheme4.getTypography(composer2, i28).getLabelSmall(), 0L, 1, 0, composer2, ((i17 >> 3) & 112) | 24576, 41);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str9 = str114;
                str7 = str113;
                str8 = str112;
                aVar3 = aVar8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str7 = str4;
                str8 = str5;
                str9 = str6;
                aVar3 = aVar2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ContactItemKt.ContactItem$lambda$2(str7, str8, str9, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        str5 = str2;
        i13 = i11 & 4;
        if (i13 != 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                str6 = str3;
                if (composerStartRestartGroup.changed(str6)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
                i12 |= i14;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onClick)) {
                    i18 = 2048;
                } else {
                    i18 = 1024;
                }
                i12 |= i18;
            }
            i15 = i11 & 16;
            if (i15 != 0) {
                if ((i10 & 24576) == 0) {
                    aVar2 = aVar;
                    if (composerStartRestartGroup.changedInstance(aVar2)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i12 |= i16;
                }
                i17 = i12;
                if ((i17 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
                    if (i19 != 0) {
                        str10 = "";
                    } else {
                        str10 = str4;
                    }
                    if (i20 != 0) {
                        str11 = "";
                    } else {
                        str11 = str5;
                    }
                    if (i13 != 0) {
                        str12 = "";
                    } else {
                        str12 = str6;
                    }
                    if (i15 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: w8.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(310202816, i17, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactItem (ContactItem.kt:42)");
                    }
                    Modifier.Companion companion9 = Modifier.INSTANCE;
                    String str115 = str11;
                    a aVar9 = aVar4;
                    float f14 = 10;
                    Modifier modifierM1726paddingVpY3zN8 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion9, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f14));
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                    int iA5 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN8);
                    ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                    constructor = companion10.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy5, companion10.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion10.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion10.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion10.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion10.getSetModifier());
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    Modifier modifierM1769size3ABfNKs5 = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion9, 0.0f, 0.0f, Dp.m8823constructorimpl(f14), 0.0f, 11, null), Dp.m8823constructorimpl(40));
                    Color colorM5856boximpl5 = Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str115)));
                    int i29 = ((i17 << 3) & 112) | 1597446 | ((i17 << 24) & C.ENCODING_PCM_DOUBLE);
                    String str116 = str10;
                    Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs5, str116, colorM5856boximpl5, null, "", 0, 50, false, null, str115, true, 0, composerStartRestartGroup, i29, 6, 2472);
                    Modifier modifierA5 = e3.a(rowScopeInstance5, companion9, 1.0f, false, 2, null);
                    MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                    int i210 = MaterialTheme.$stable;
                    composer2 = composerStartRestartGroup;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA5, str115, materialTheme5.getTypography(composerStartRestartGroup, i210).getBodyLarge(), 0L, 1, 0, composer2, (i17 & 112) | 24576, 40);
                    String str117 = str12;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, str117, materialTheme5.getTypography(composer2, i210).getLabelSmall(), 0L, 1, 0, composer2, ((i17 >> 3) & 112) | 24576, 41);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str9 = str117;
                    str7 = str116;
                    str8 = str115;
                    aVar3 = aVar9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    str7 = str4;
                    str8 = str5;
                    str9 = str6;
                    aVar3 = aVar2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ContactItemKt.ContactItem$lambda$2(str7, str8, str9, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            aVar2 = aVar;
            i17 = i12;
            if ((i17 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
                if (i19 != 0) {
                    str10 = "";
                } else {
                    str10 = str4;
                }
                if (i20 != 0) {
                    str11 = "";
                } else {
                    str11 = str5;
                }
                if (i13 != 0) {
                    str12 = "";
                } else {
                    str12 = str6;
                }
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: w8.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(310202816, i17, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactItem (ContactItem.kt:42)");
                }
                Modifier.Companion companion11 = Modifier.INSTANCE;
                String str118 = str11;
                a aVar10 = aVar4;
                float f15 = 10;
                Modifier modifierM1726paddingVpY3zN9 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion11, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f15));
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA6 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN9);
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
                Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyRowMeasurePolicy6, companion12.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion12.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion12.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion12.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion12.getSetModifier());
                RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                Modifier modifierM1769size3ABfNKs6 = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion11, 0.0f, 0.0f, Dp.m8823constructorimpl(f15), 0.0f, 11, null), Dp.m8823constructorimpl(40));
                Color colorM5856boximpl6 = Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str118)));
                int i211 = ((i17 << 3) & 112) | 1597446 | ((i17 << 24) & C.ENCODING_PCM_DOUBLE);
                String str119 = str10;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs6, str119, colorM5856boximpl6, null, "", 0, 50, false, null, str118, true, 0, composerStartRestartGroup, i211, 6, 2472);
                Modifier modifierA6 = e3.a(rowScopeInstance6, companion11, 1.0f, false, 2, null);
                MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                int i212 = MaterialTheme.$stable;
                composer2 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA6, str118, materialTheme6.getTypography(composerStartRestartGroup, i212).getBodyLarge(), 0L, 1, 0, composer2, (i17 & 112) | 24576, 40);
                String str1110 = str12;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str1110, materialTheme6.getTypography(composer2, i212).getLabelSmall(), 0L, 1, 0, composer2, ((i17 >> 3) & 112) | 24576, 41);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str9 = str1110;
                str7 = str119;
                str8 = str118;
                aVar3 = aVar10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str7 = str4;
                str8 = str5;
                str9 = str6;
                aVar3 = aVar2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ContactItemKt.ContactItem$lambda$2(str7, str8, str9, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        str6 = str3;
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onClick)) {
                i18 = 2048;
            } else {
                i18 = 1024;
            }
            i12 |= i18;
        }
        i15 = i11 & 16;
        if (i15 != 0) {
            if ((i10 & 24576) == 0) {
                aVar2 = aVar;
                if (composerStartRestartGroup.changedInstance(aVar2)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i12 |= i16;
            }
            i17 = i12;
            if ((i17 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
                if (i19 != 0) {
                    str10 = "";
                } else {
                    str10 = str4;
                }
                if (i20 != 0) {
                    str11 = "";
                } else {
                    str11 = str5;
                }
                if (i13 != 0) {
                    str12 = "";
                } else {
                    str12 = str6;
                }
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: w8.c
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(310202816, i17, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactItem (ContactItem.kt:42)");
                }
                Modifier.Companion companion13 = Modifier.INSTANCE;
                String str1111 = str11;
                a aVar11 = aVar4;
                float f16 = 10;
                Modifier modifierM1726paddingVpY3zN10 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion13, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f16));
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA7 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN10);
                ComposeUiNode.Companion companion14 = ComposeUiNode.INSTANCE;
                constructor = companion14.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyRowMeasurePolicy7, companion14.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion14.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion14.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion14.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion14.getSetModifier());
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                Modifier modifierM1769size3ABfNKs7 = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion13, 0.0f, 0.0f, Dp.m8823constructorimpl(f16), 0.0f, 11, null), Dp.m8823constructorimpl(40));
                Color colorM5856boximpl7 = Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str1111)));
                int i213 = ((i17 << 3) & 112) | 1597446 | ((i17 << 24) & C.ENCODING_PCM_DOUBLE);
                String str1112 = str10;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs7, str1112, colorM5856boximpl7, null, "", 0, 50, false, null, str1111, true, 0, composerStartRestartGroup, i213, 6, 2472);
                Modifier modifierA7 = e3.a(rowScopeInstance7, companion13, 1.0f, false, 2, null);
                MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                int i214 = MaterialTheme.$stable;
                composer2 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA7, str1111, materialTheme7.getTypography(composerStartRestartGroup, i214).getBodyLarge(), 0L, 1, 0, composer2, (i17 & 112) | 24576, 40);
                String str1113 = str12;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str1113, materialTheme7.getTypography(composer2, i214).getLabelSmall(), 0L, 1, 0, composer2, ((i17 >> 3) & 112) | 24576, 41);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str9 = str1113;
                str7 = str1112;
                str8 = str1111;
                aVar3 = aVar11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str7 = str4;
                str8 = str5;
                str9 = str6;
                aVar3 = aVar2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ContactItemKt.ContactItem$lambda$2(str7, str8, str9, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        aVar2 = aVar;
        i17 = i12;
        if ((i17 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
            if (i19 != 0) {
                str10 = "";
            } else {
                str10 = str4;
            }
            if (i20 != 0) {
                str11 = "";
            } else {
                str11 = str5;
            }
            if (i13 != 0) {
                str12 = "";
            } else {
                str12 = str6;
            }
            if (i15 != 0) {
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: w8.c
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aVar4 = (a) objRememberedValue;
            } else {
                aVar4 = aVar2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(310202816, i17, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactItem (ContactItem.kt:42)");
            }
            Modifier.Companion companion15 = Modifier.INSTANCE;
            String str1114 = str11;
            a aVar12 = aVar4;
            float f17 = 10;
            Modifier modifierM1726paddingVpY3zN11 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion15, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f17));
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA8 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN11);
            ComposeUiNode.Companion companion16 = ComposeUiNode.INSTANCE;
            constructor = companion16.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyRowMeasurePolicy8, companion16.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion16.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion16.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion16.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion16.getSetModifier());
            RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
            Modifier modifierM1769size3ABfNKs8 = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion15, 0.0f, 0.0f, Dp.m8823constructorimpl(f17), 0.0f, 11, null), Dp.m8823constructorimpl(40));
            Color colorM5856boximpl8 = Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str1114)));
            int i215 = ((i17 << 3) & 112) | 1597446 | ((i17 << 24) & C.ENCODING_PCM_DOUBLE);
            String str1115 = str10;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs8, str1115, colorM5856boximpl8, null, "", 0, 50, false, null, str1114, true, 0, composerStartRestartGroup, i215, 6, 2472);
            Modifier modifierA8 = e3.a(rowScopeInstance8, companion15, 1.0f, false, 2, null);
            MaterialTheme materialTheme8 = MaterialTheme.INSTANCE;
            int i216 = MaterialTheme.$stable;
            composer2 = composerStartRestartGroup;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA8, str1114, materialTheme8.getTypography(composerStartRestartGroup, i216).getBodyLarge(), 0L, 1, 0, composer2, (i17 & 112) | 24576, 40);
            String str1116 = str12;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str1116, materialTheme8.getTypography(composer2, i216).getLabelSmall(), 0L, 1, 0, composer2, ((i17 >> 3) & 112) | 24576, 41);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str9 = str1116;
            str7 = str1115;
            str8 = str1114;
            aVar3 = aVar12;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            str7 = str4;
            str8 = str5;
            str9 = str6;
            aVar3 = aVar2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContactItemKt.ContactItem$lambda$2(str7, str8, str9, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ContactItem$lambda$2(String str, String str2, String str3, a aVar, a aVar2, int i10, int i11, Composer composer, int i12) {
        ContactItem(str, str2, str3, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ContactPlaceholder(Composer composer, final int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1033140965);
        if (composerStartRestartGroup.shouldExecute(i10 != 0, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1033140965, i10, -1, "cu.todus.android.uiCompose.shared.userCommonList.ContactPlaceholder (ContactItem.kt:172)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(20), 0.0f, 2, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Z17ShimmerLoaderKt.Z17Shimmer(ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(40)), 1.0f, false, 2, null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.m1755height3ABfNKs(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(16)), composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContactItemKt.ContactPlaceholder$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ContactPlaceholder$lambda$1(int i10, Composer composer, int i11) {
        ContactPlaceholder(composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x010c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0118  */
    /* JADX WARN: Code duplicated, block: B:68:0x011c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0150  */
    /* JADX WARN: Code duplicated, block: B:72:0x0155  */
    /* JADX WARN: Code duplicated, block: B:75:0x0236  */
    /* JADX WARN: Code duplicated, block: B:77:0x023b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0247  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SelectionContactItem(String str, String str2, final boolean z10, final a onClick, Composer composer, final int i10, final int i11) {
        String str3;
        int i12;
        String str4;
        boolean z11;
        Composer composer2;
        final String str5;
        final String str6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str7;
        boolean z12;
        Object objRememberedValue;
        a constructor;
        Icons.Outlined outlined;
        ImageVector radioButtonUnchecked;
        int i13;
        int i14;
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1666431147);
        int i15 = i11 & 1;
        if (i15 != 0) {
            i12 = i10 | 6;
            str3 = str;
        } else if ((i10 & 6) == 0) {
            str3 = str;
            i12 = (composerStartRestartGroup.changed(str3) ? 4 : 2) | i10;
        } else {
            str3 = str;
            i12 = i10;
        }
        int i16 = i11 & 2;
        if (i16 == 0) {
            if ((i10 & 48) == 0) {
                str4 = str2;
                i12 |= composerStartRestartGroup.changed(str4) ? 32 : 16;
            }
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changed(z10)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
                i12 |= i14;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onClick)) {
                    i13 = 2048;
                } else {
                    i13 = 1024;
                }
                i12 |= i13;
            }
            if ((i12 & 1171) != 1170) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                if (i15 != 0) {
                    str3 = "";
                }
                if (i16 != 0) {
                    str7 = "";
                } else {
                    str7 = str4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1666431147, i12, -1, "cu.todus.android.uiCompose.shared.userCommonList.SelectionContactItem (ContactItem.kt:131)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                z12 = (i12 & 7168) == 2048;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: w8.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ContactItemKt.SelectionContactItem$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (a) objRememberedValue, 15, null), Dp.m8823constructorimpl(20));
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                outlined = Icons.Outlined.INSTANCE;
                if (z10) {
                    radioButtonUnchecked = CheckCircleOutlineKt.getCheckCircleOutline(outlined);
                } else {
                    radioButtonUnchecked = RadioButtonUncheckedKt.getRadioButtonUnchecked(outlined);
                }
                float f10 = 10;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24)), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
                ColorFilter.Companion companion3 = ColorFilter.INSTANCE;
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i17 = MaterialTheme.$stable;
                int i18 = i12;
                String str8 = str3;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1729paddingqDBjuR0$default, radioButtonUnchecked, null, ColorFilter.Companion.m5907tintxETnrds$default(companion3, materialTheme.getColorScheme(composerStartRestartGroup, i17).getPrimary(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                String str9 = str7;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), Dp.m8823constructorimpl(40)), str8, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str7))), null, "", 0, 50, false, null, str9, true, 0, composerStartRestartGroup, ((i18 << 3) & 112) | 1597446 | ((i18 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2472);
                str5 = str8;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str9, materialTheme.getTypography(composerStartRestartGroup, i17).getBodyLarge(), 0L, 1, 0, composerStartRestartGroup, (i18 & 112) | 24576, 41);
                composer2 = composerStartRestartGroup;
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str6 = str9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str5 = str3;
                str6 = str4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ContactItemKt.SelectionContactItem$lambda$2(str5, str6, z10, onClick, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        str4 = str2;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changed(z10)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onClick)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        if ((i12 & 1171) != 1170) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            if (i15 != 0) {
                str3 = "";
            }
            if (i16 != 0) {
                str7 = "";
            } else {
                str7 = str4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1666431147, i12, -1, "cu.todus.android.uiCompose.shared.userCommonList.SelectionContactItem (ContactItem.kt:131)");
            }
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
            if ((i12 & 7168) == 2048) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12) {
                objRememberedValue = new a() { // from class: w8.g
                    @Override // lb.a
                    public final Object invoke() {
                        return ContactItemKt.SelectionContactItem$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new a() { // from class: w8.g
                    @Override // lb.a
                    public final Object invoke() {
                        return ContactItemKt.SelectionContactItem$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default2, false, null, null, null, (a) objRememberedValue, 15, null), Dp.m8823constructorimpl(20));
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
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
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            outlined = Icons.Outlined.INSTANCE;
            if (z10) {
                radioButtonUnchecked = CheckCircleOutlineKt.getCheckCircleOutline(outlined);
            } else {
                radioButtonUnchecked = RadioButtonUncheckedKt.getRadioButtonUnchecked(outlined);
            }
            float f11 = 10;
            Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(24)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null);
            ColorFilter.Companion companion6 = ColorFilter.INSTANCE;
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i19 = MaterialTheme.$stable;
            int i110 = i12;
            String str10 = str3;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1729paddingqDBjuR0$default2, radioButtonUnchecked, null, ColorFilter.Companion.m5907tintxETnrds$default(companion6, materialTheme2.getColorScheme(composerStartRestartGroup, i19).getPrimary(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            String str11 = str7;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion4, 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null), Dp.m8823constructorimpl(40)), str10, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(str7))), null, "", 0, 50, false, null, str11, true, 0, composerStartRestartGroup, ((i110 << 3) & 112) | 1597446 | ((i110 << 24) & C.ENCODING_PCM_DOUBLE), 6, 2472);
            str5 = str10;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str11, materialTheme2.getTypography(composerStartRestartGroup, i19).getBodyLarge(), 0L, 1, 0, composerStartRestartGroup, (i110 & 112) | 24576, 41);
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str6 = str11;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            str5 = str3;
            str6 = str4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContactItemKt.SelectionContactItem$lambda$2(str5, str6, z10, onClick, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SelectionContactItem$lambda$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SelectionContactItem$lambda$2(String str, String str2, boolean z10, a aVar, int i10, int i11, Composer composer, int i12) {
        SelectionContactItem(str, str2, z10, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0087  */
    /* JADX WARN: Code duplicated, block: B:46:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x009a  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:55:0x010b  */
    /* JADX WARN: Code duplicated, block: B:56:0x010f  */
    /* JADX WARN: Code duplicated, block: B:59:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:61:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:64:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void UnknownContactItem(String str, final a onClick, a aVar, Composer composer, final int i10, final int i11) {
        String str2;
        int i12;
        a aVar2;
        int i13;
        boolean z10;
        Composer composer2;
        final String str3;
        final a aVar3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str4;
        a aVar4;
        a constructor;
        Object objRememberedValue;
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2019182510);
        int i14 = i11 & 1;
        if (i14 != 0) {
            i12 = i10 | 6;
            str2 = str;
        } else if ((i10 & 6) == 0) {
            str2 = str;
            i12 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i10;
        } else {
            str2 = str;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i15 = i11 & 4;
        if (i15 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                aVar2 = aVar;
                i12 |= composerStartRestartGroup.changedInstance(aVar2) ? 256 : 128;
            }
            i13 = i12;
            if ((i13 & 147) != 146) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i14 != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: w8.e
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2019182510, i13, -1, "cu.todus.android.uiCompose.shared.userCommonList.UnknownContactItem (ContactItem.kt:90)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                a aVar5 = aVar4;
                float f10 = 10;
                Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f10));
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), Dp.m8823constructorimpl(40)), Integer.valueOf(R.drawable.profile), null, null, "", 0, 50, false, null, null, false, 0, composerStartRestartGroup, 1597446, 0, 4012);
                composer2 = composerStartRestartGroup;
                Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
                String strStringResource = StringResources_androidKt.stringResource(R.string.unknown, composer2, 0);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i16 = MaterialTheme.$stable;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA, strStringResource, materialTheme.getTypography(composer2, i16).getBodyLarge(), 0L, 1, 0, composer2, 24576, 40);
                String str5 = str4;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, str5, materialTheme.getTypography(composer2, i16).getLabelSmall(), 0L, 1, 0, composer2, ((i13 << 3) & 112) | 24576, 41);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str5;
                aVar3 = aVar5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str3 = str2;
                aVar3 = aVar2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ContactItemKt.UnknownContactItem$lambda$2(str3, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        aVar2 = aVar;
        i13 = i12;
        if ((i13 & 147) != 146) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            if (i14 != 0) {
                str4 = "";
            } else {
                str4 = str2;
            }
            if (i15 != 0) {
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: w8.e
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aVar4 = (a) objRememberedValue;
            } else {
                aVar4 = aVar2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2019182510, i13, -1, "cu.todus.android.uiCompose.shared.userCommonList.UnknownContactItem (ContactItem.kt:90)");
            }
            Modifier.Companion companion3 = Modifier.INSTANCE;
            a aVar6 = aVar4;
            float f11 = 10;
            Modifier modifierM1726paddingVpY3zN5 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1250combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), false, null, null, null, aVar4, null, false, null, onClick, 239, null), Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f11));
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN5);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            constructor = companion4.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion3, 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null), Dp.m8823constructorimpl(40)), Integer.valueOf(R.drawable.profile), null, null, "", 0, 50, false, null, null, false, 0, composerStartRestartGroup, 1597446, 0, 4012);
            composer2 = composerStartRestartGroup;
            Modifier modifierA2 = e3.a(rowScopeInstance2, companion3, 1.0f, false, 2, null);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.unknown, composer2, 0);
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i17 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierA2, strStringResource2, materialTheme2.getTypography(composer2, i17).getBodyLarge(), 0L, 1, 0, composer2, 24576, 40);
            String str6 = str4;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str6, materialTheme2.getTypography(composer2, i17).getLabelSmall(), 0L, 1, 0, composer2, ((i13 << 3) & 112) | 24576, 41);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str6;
            aVar3 = aVar6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            str3 = str2;
            aVar3 = aVar2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: w8.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContactItemKt.UnknownContactItem$lambda$2(str3, onClick, aVar3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UnknownContactItem$lambda$2(String str, a aVar, a aVar2, int i10, int i11, Composer composer, int i12) {
        UnknownContactItem(str, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
