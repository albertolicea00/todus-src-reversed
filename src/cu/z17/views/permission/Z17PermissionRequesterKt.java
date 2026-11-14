package cu.z17.views.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.BadgeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.R;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.label.Z17MarkdownLabelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a`\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00132\u0019\b\u0002\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aA\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001aM\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00022\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a`\u0010&\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0\u00132\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\b\u00152\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'¨\u0006)²\u0006\u000e\u0010(\u001a\u00020\u001f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/permission/PermissionsResult;", "initialPermissionsResult", "", "Lcu/z17/views/permission/PermissionNeedIt;", "initialPermissions", "Lkotlin/Function0;", "Lua/k0;", "onGranted", "onClose", "", "packageName", "stringContent", "Z17PermissionCheckerAndRequester", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/permission/PermissionsResult;Ljava/util/List;Llb/a;Llb/a;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "onClick", "Lcu/z17/views/permission/PermissionsRequesterState;", "permissionState", "Lkotlin/Function1;", "onResult", "Landroidx/compose/runtime/Composable;", "content", "Z17PermissionChecker", "(Landroidx/compose/ui/Modifier;Llb/a;Lcu/z17/views/permission/PermissionsRequesterState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Z17PermissionRequester", "(Lcu/z17/views/permission/PermissionsRequesterState;Llb/a;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "actualResult", "permissions", "Z17PermissionContainer", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/permission/PermissionsResult;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "", "state", "onChange", "leading", "label", "Landroidx/compose/ui/text/TextStyle;", "labelStyle", "PermissionButton", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "showRationaleDialog", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17PermissionRequesterKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0130  */
    /* JADX WARN: Code duplicated, block: B:102:0x0138  */
    /* JADX WARN: Code duplicated, block: B:105:0x0180  */
    /* JADX WARN: Code duplicated, block: B:108:0x018c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0190  */
    /* JADX WARN: Code duplicated, block: B:112:0x01af  */
    /* JADX WARN: Code duplicated, block: B:114:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:117:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:119:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:122:0x022e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0231  */
    /* JADX WARN: Code duplicated, block: B:126:0x0238  */
    /* JADX WARN: Code duplicated, block: B:128:0x0240  */
    /* JADX WARN: Code duplicated, block: B:131:0x025f  */
    /* JADX WARN: Code duplicated, block: B:133:0x0268  */
    /* JADX WARN: Code duplicated, block: B:136:0x0276  */
    /* JADX WARN: Code duplicated, block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:86:0x0106  */
    /* JADX WARN: Code duplicated, block: B:89:0x0111  */
    /* JADX WARN: Code duplicated, block: B:92:0x011b  */
    /* JADX WARN: Code duplicated, block: B:93:0x011e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0125  */
    /* JADX WARN: Code duplicated, block: B:97:0x0128  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void PermissionButton(Modifier modifier, final boolean z10, final Function1 onChange, Function2 function2, String str, TextStyle textStyle, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        int i13;
        String str2;
        int i14;
        TextStyle bodyLarge;
        boolean z11;
        final Function2 function3;
        final Modifier modifier3;
        final String str3;
        final TextStyle textStyle2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Modifier modifier5;
        int i15;
        boolean z12;
        boolean z13;
        boolean z14;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        boolean z15;
        Object objRememberedValue2;
        kotlin.jvm.internal.y.i(onChange, "onChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-547205073);
        int i16 = i11 & 1;
        if (i16 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onChange) ? 256 : 128;
        }
        int i17 = i11 & 8;
        if (i17 == 0) {
            if ((i10 & 3072) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                if ((196608 & i10) == 0) {
                    if ((i11 & 32) == 0) {
                        bodyLarge = textStyle;
                        int i18 = composerStartRestartGroup.changed(bodyLarge) ? 131072 : 65536;
                        i12 |= i18;
                    } else {
                        bodyLarge = textStyle;
                    }
                    i12 |= i18;
                } else {
                    bodyLarge = textStyle;
                }
                if ((i12 & 74899) != 74898) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i17 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i13 != 0) {
                            str2 = "";
                        }
                        if ((i11 & 32) != 0) {
                            i12 &= -458753;
                            modifier5 = modifier4;
                            bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                        } else {
                            modifier5 = modifier4;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 32) != 0) {
                            i12 &= -458753;
                        }
                        function3 = function2;
                        modifier5 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-547205073, i12, -1, "cu.z17.views.permission.PermissionButton (Z17PermissionRequester.kt:979)");
                    }
                    i15 = i12 & 896;
                    if (i15 == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if ((i12 & 112) == 32) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = z12 | z13;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z14 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.e1
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17PermissionRequesterKt.PermissionButton$lambda$84$lambda$83(onChange, z10);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifier5, false, null, null, (lb.a) objRememberedValue, 7, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1238clickableXHw0xAI$default);
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
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    if (function3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-807596815);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-807596814);
                        function3.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str4 = str2;
                    TextStyle textStyle3 = bodyLarge;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8823constructorimpl(10), 0.0f, 2, null), str4, textStyle3, 0L, 0, 0, composerStartRestartGroup, (i12 >> 9) & 1008, 56);
                    boolean z16 = !z10;
                    String strStringResource = StringResources_androidKt.stringResource(R.string.open, composerStartRestartGroup, 0);
                    if (i15 == 256) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.f1
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17PermissionRequesterKt.PermissionButton$lambda$88$lambda$87$lambda$86(onChange);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue2, strStringResource, null, false, false, z16, composerStartRestartGroup, 0, 57);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str3 = str4;
                    modifier3 = modifier5;
                    textStyle2 = textStyle3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function3 = function2;
                    modifier3 = modifier2;
                    str3 = str2;
                    textStyle2 = bodyLarge;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.g1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$89(modifier3, z10, onChange, function3, str3, textStyle2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            str2 = str;
            if ((196608 & i10) == 0) {
                if ((i11 & 32) == 0) {
                    bodyLarge = textStyle;
                    if (composerStartRestartGroup.changed(bodyLarge)) {
                    }
                    i12 |= i18;
                } else {
                    bodyLarge = textStyle;
                }
                i12 |= i18;
            } else {
                bodyLarge = textStyle;
            }
            if ((i12 & 74899) != 74898) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i16 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i17 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i13 != 0) {
                        str2 = "";
                    }
                    if ((i11 & 32) != 0) {
                        i12 &= -458753;
                        modifier5 = modifier4;
                        bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                    } else {
                        modifier5 = modifier4;
                    }
                } else {
                    if (i16 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i17 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i13 != 0) {
                        str2 = "";
                    }
                    if ((i11 & 32) != 0) {
                        i12 &= -458753;
                        modifier5 = modifier4;
                        bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                    } else {
                        modifier5 = modifier4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-547205073, i12, -1, "cu.z17.views.permission.PermissionButton (Z17PermissionRequester.kt:979)");
                }
                i15 = i12 & 896;
                if (i15 == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i12 & 112) == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z12 | z13;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.e1
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$84$lambda$83(onChange, z10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.e1
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$84$lambda$83(onChange, z10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(modifier5, false, null, null, (lb.a) objRememberedValue, 7, null);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1238clickableXHw0xAI$default2);
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
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                if (function3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-807596815);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-807596814);
                    function3.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                String str5 = str2;
                TextStyle textStyle4 = bodyLarge;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8823constructorimpl(10), 0.0f, 2, null), str5, textStyle4, 0L, 0, 0, composerStartRestartGroup, (i12 >> 9) & 1008, 56);
                boolean z17 = !z10;
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.open, composerStartRestartGroup, 0);
                if (i15 == 256) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.f1
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$88$lambda$87$lambda$86(onChange);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.f1
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$88$lambda$87$lambda$86(onChange);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue2, strStringResource2, null, false, false, z17, composerStartRestartGroup, 0, 57);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str5;
                modifier3 = modifier5;
                textStyle2 = textStyle4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function2;
                modifier3 = modifier2;
                str3 = str2;
                textStyle2 = bodyLarge;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.g1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PermissionRequesterKt.PermissionButton$lambda$89(modifier3, z10, onChange, function3, str3, textStyle2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            if ((196608 & i10) == 0) {
                if ((i11 & 32) == 0) {
                    bodyLarge = textStyle;
                    if (composerStartRestartGroup.changed(bodyLarge)) {
                    }
                    i12 |= i18;
                } else {
                    bodyLarge = textStyle;
                }
                i12 |= i18;
            } else {
                bodyLarge = textStyle;
            }
            if ((i12 & 74899) != 74898) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i16 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i17 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i13 != 0) {
                        str2 = "";
                    }
                    if ((i11 & 32) != 0) {
                        i12 &= -458753;
                        modifier5 = modifier4;
                        bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                    } else {
                        modifier5 = modifier4;
                    }
                } else {
                    if (i16 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i17 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i13 != 0) {
                        str2 = "";
                    }
                    if ((i11 & 32) != 0) {
                        i12 &= -458753;
                        modifier5 = modifier4;
                        bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                    } else {
                        modifier5 = modifier4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-547205073, i12, -1, "cu.z17.views.permission.PermissionButton (Z17PermissionRequester.kt:979)");
                }
                i15 = i12 & 896;
                if (i15 == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i12 & 112) == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z12 | z13;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.e1
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$84$lambda$83(onChange, z10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.e1
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$84$lambda$83(onChange, z10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1238clickableXHw0xAI$default3 = ClickableKt.m1238clickableXHw0xAI$default(modifier5, false, null, null, (lb.a) objRememberedValue, 7, null);
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1238clickableXHw0xAI$default3);
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
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy3, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                if (function3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-807596815);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-807596814);
                    function3.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                String str6 = str2;
                TextStyle textStyle5 = bodyLarge;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8823constructorimpl(10), 0.0f, 2, null), str6, textStyle5, 0L, 0, 0, composerStartRestartGroup, (i12 >> 9) & 1008, 56);
                boolean z18 = !z10;
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.open, composerStartRestartGroup, 0);
                if (i15 == 256) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.f1
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$88$lambda$87$lambda$86(onChange);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.f1
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.PermissionButton$lambda$88$lambda$87$lambda$86(onChange);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue2, strStringResource3, null, false, false, z18, composerStartRestartGroup, 0, 57);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str6;
                modifier3 = modifier5;
                textStyle2 = textStyle5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function2;
                modifier3 = modifier2;
                str3 = str2;
                textStyle2 = bodyLarge;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.g1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PermissionRequesterKt.PermissionButton$lambda$89(modifier3, z10, onChange, function3, str3, textStyle2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        str2 = str;
        if ((196608 & i10) == 0) {
            if ((i11 & 32) == 0) {
                bodyLarge = textStyle;
                if (composerStartRestartGroup.changed(bodyLarge)) {
                }
                i12 |= i18;
            } else {
                bodyLarge = textStyle;
            }
            i12 |= i18;
        } else {
            bodyLarge = textStyle;
        }
        if ((i12 & 74899) != 74898) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i16 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i17 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i13 != 0) {
                    str2 = "";
                }
                if ((i11 & 32) != 0) {
                    i12 &= -458753;
                    modifier5 = modifier4;
                    bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                } else {
                    modifier5 = modifier4;
                }
            } else {
                if (i16 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i17 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i13 != 0) {
                    str2 = "";
                }
                if ((i11 & 32) != 0) {
                    i12 &= -458753;
                    modifier5 = modifier4;
                    bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                } else {
                    modifier5 = modifier4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-547205073, i12, -1, "cu.z17.views.permission.PermissionButton (Z17PermissionRequester.kt:979)");
            }
            i15 = i12 & 896;
            if (i15 == 256) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((i12 & 112) == 32) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = z12 | z13;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z14) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.e1
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PermissionRequesterKt.PermissionButton$lambda$84$lambda$83(onChange, z10);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.e1
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PermissionRequesterKt.PermissionButton$lambda$84$lambda$83(onChange, z10);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1238clickableXHw0xAI$default4 = ClickableKt.m1238clickableXHw0xAI$default(modifier5, false, null, null, (lb.a) objRememberedValue, 7, null);
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1238clickableXHw0xAI$default4);
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
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy4, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            if (function3 == null) {
                composerStartRestartGroup.startReplaceGroup(-807596815);
            } else {
                composerStartRestartGroup.startReplaceGroup(-807596814);
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 9) & 14));
            }
            composerStartRestartGroup.endReplaceGroup();
            String str7 = str2;
            TextStyle textStyle6 = bodyLarge;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8823constructorimpl(10), 0.0f, 2, null), str7, textStyle6, 0L, 0, 0, composerStartRestartGroup, (i12 >> 9) & 1008, 56);
            boolean z19 = !z10;
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.open, composerStartRestartGroup, 0);
            if (i15 == 256) {
                z15 = true;
            } else {
                z15 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z15) {
                objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.f1
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PermissionRequesterKt.PermissionButton$lambda$88$lambda$87$lambda$86(onChange);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.f1
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PermissionRequesterKt.PermissionButton$lambda$88$lambda$87$lambda$86(onChange);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue2, strStringResource4, null, false, false, z19, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str7;
            modifier3 = modifier5;
            textStyle2 = textStyle6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function2;
            modifier3 = modifier2;
            str3 = str2;
            textStyle2 = bodyLarge;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PermissionRequesterKt.PermissionButton$lambda$89(modifier3, z10, onChange, function3, str3, textStyle2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PermissionButton$lambda$84$lambda$83(Function1 function1, boolean z10) {
        function1.invoke(Boolean.valueOf(!z10));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PermissionButton$lambda$88$lambda$87$lambda$86(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PermissionButton$lambda$89(Modifier modifier, boolean z10, Function1 function1, Function2 function2, String str, TextStyle textStyle, int i10, int i11, Composer composer, int i12) {
        PermissionButton(modifier, z10, function1, function2, str, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:106:0x0215  */
    /* JADX WARN: Code duplicated, block: B:108:0x021f  */
    /* JADX WARN: Code duplicated, block: B:111:0x022b  */
    /* JADX WARN: Code duplicated, block: B:114:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:47:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:72:0x0100  */
    /* JADX WARN: Code duplicated, block: B:74:0x010c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0119  */
    /* JADX WARN: Code duplicated, block: B:78:0x0120  */
    /* JADX WARN: Code duplicated, block: B:83:0x0131  */
    /* JADX WARN: Code duplicated, block: B:86:0x017d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0188  */
    /* JADX WARN: Code duplicated, block: B:91:0x0199  */
    /* JADX WARN: Code duplicated, block: B:92:0x019b  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:96:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:99:0x01e1  */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void Z17PermissionChecker(Modifier modifier, lb.a aVar, final PermissionsRequesterState permissionState, final Function1 onResult, Function3 function3, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        lb.a aVar2;
        int i13;
        Function3 function4;
        int i14;
        boolean z10;
        final Modifier modifier3;
        final lb.a aVar3;
        final Function3 function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final lb.a aVar4;
        Function3 function3RememberComposableLambda;
        c1.a aVarC;
        int i15;
        List listN;
        c1.a aVarC2;
        List listE;
        c1.a aVarC3;
        boolean zIsExternalStorageManager;
        c1.a aVarC4;
        c1.a aVarC5;
        c1.a aVarC6;
        c1.a aVarC7;
        c1.a aVarC8;
        List listN2;
        c1.a aVarC9;
        boolean z11;
        boolean z12;
        boolean z13;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i16;
        int i17;
        kotlin.jvm.internal.y.i(permissionState, "permissionState");
        kotlin.jvm.internal.y.i(onResult, "onResult");
        Composer composerStartRestartGroup = composer.startRestartGroup(943636707);
        int i18 = i11 & 1;
        if (i18 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        int i19 = i11 & 2;
        if (i19 == 0) {
            if ((i10 & 48) == 0) {
                aVar2 = aVar;
                i12 |= composerStartRestartGroup.changedInstance(aVar2) ? 32 : 16;
            }
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changed(permissionState)) {
                    i17 = 256;
                } else {
                    i17 = 128;
                }
                i12 |= i17;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onResult)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i12 |= i16;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
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
                    if (i18 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i19 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.b1
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar4 = (lb.a) objRememberedValue2;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i13 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(285409273, true, new Function3() { // from class: cu.z17.views.permission.c1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionChecker$lambda$14(permissionState, aVar4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        function3RememberComposableLambda = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(943636707, i12, -1, "cu.z17.views.permission.Z17PermissionChecker (Z17PermissionRequester.kt:289)");
                    }
                    function3RememberComposableLambda.invoke(modifier4, composerStartRestartGroup, Integer.valueOf((i12 & 14) | ((i12 >> 9) & 112)));
                    aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), null, composerStartRestartGroup, 6, 2);
                    i15 = Build.VERSION.SDK_INT;
                    if (i15 <= 30) {
                        listN = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
                    } else {
                        listN = va.w.n();
                    }
                    aVarC2 = c1.d.c(listN, null, composerStartRestartGroup, 0, 2);
                    if (i15 >= 33) {
                        listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
                    } else {
                        listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
                    }
                    aVarC3 = c1.d.c(listE, null, composerStartRestartGroup, 0, 2);
                    if (i15 >= 30) {
                        try {
                            zIsExternalStorageManager = Environment.isExternalStorageManager();
                        } catch (Exception unused) {
                            zIsExternalStorageManager = true;
                        }
                    } else {
                        zIsExternalStorageManager = true;
                    }
                    aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), null, composerStartRestartGroup, 6, 2);
                    aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), null, composerStartRestartGroup, 6, 2);
                    aVarC6 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), null, composerStartRestartGroup, 6, 2);
                    Modifier modifier5 = modifier4;
                    aVarC7 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), null, composerStartRestartGroup, 6, 2);
                    lb.a aVar5 = aVar4;
                    aVarC8 = c1.d.c(va.v.e("android.permission.CAMERA"), null, composerStartRestartGroup, 6, 2);
                    if (Build.VERSION.SDK_INT >= 33) {
                        listN2 = va.v.e("android.permission.POST_NOTIFICATIONS");
                    } else {
                        listN2 = va.w.n();
                    }
                    Function3 function6 = function3RememberComposableLambda;
                    aVarC9 = c1.d.c(listN2, null, composerStartRestartGroup, 0, 2);
                    ua.k0 k0Var = ua.k0.f43947a;
                    if ((i12 & 896) == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean zChanged = z11 | composerStartRestartGroup.changed(aVarC) | composerStartRestartGroup.changed(aVarC2) | composerStartRestartGroup.changed(aVarC3) | composerStartRestartGroup.changed(zIsExternalStorageManager) | composerStartRestartGroup.changed(aVarC4) | composerStartRestartGroup.changed(aVarC5) | composerStartRestartGroup.changed(aVarC6) | composerStartRestartGroup.changed(aVarC7) | composerStartRestartGroup.changed(aVarC8) | composerStartRestartGroup.changed(aVarC9);
                    if ((i12 & 7168) == 2048) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = zChanged | z12;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        Z17PermissionRequesterKt$Z17PermissionChecker$3$1 z17PermissionRequesterKt$Z17PermissionChecker$3$1 = new Z17PermissionRequesterKt$Z17PermissionChecker$3$1(permissionState, onResult, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                        composerStartRestartGroup.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionChecker$3$1);
                        objRememberedValue = z17PermissionRequesterKt$Z17PermissionChecker$3$1;
                    }
                    EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    function5 = function6;
                    aVar3 = aVar5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    aVar3 = aVar2;
                    function5 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.d1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17PermissionRequesterKt.Z17PermissionChecker$lambda$16(modifier3, aVar3, permissionState, onResult, function5, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            function4 = function3;
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i18 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i19 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.b1
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar4 = (lb.a) objRememberedValue2;
                } else {
                    aVar4 = aVar2;
                }
                if (i13 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(285409273, true, new Function3() { // from class: cu.z17.views.permission.c1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionChecker$lambda$14(permissionState, aVar4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    function3RememberComposableLambda = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(943636707, i12, -1, "cu.z17.views.permission.Z17PermissionChecker (Z17PermissionRequester.kt:289)");
                }
                function3RememberComposableLambda.invoke(modifier4, composerStartRestartGroup, Integer.valueOf((i12 & 14) | ((i12 >> 9) & 112)));
                aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), null, composerStartRestartGroup, 6, 2);
                i15 = Build.VERSION.SDK_INT;
                if (i15 <= 30) {
                    listN = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
                } else {
                    listN = va.w.n();
                }
                aVarC2 = c1.d.c(listN, null, composerStartRestartGroup, 0, 2);
                if (i15 >= 33) {
                    listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
                } else {
                    listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
                }
                aVarC3 = c1.d.c(listE, null, composerStartRestartGroup, 0, 2);
                if (i15 >= 30) {
                    zIsExternalStorageManager = Environment.isExternalStorageManager();
                } else {
                    zIsExternalStorageManager = true;
                }
                aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), null, composerStartRestartGroup, 6, 2);
                aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), null, composerStartRestartGroup, 6, 2);
                aVarC6 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), null, composerStartRestartGroup, 6, 2);
                Modifier modifier6 = modifier4;
                aVarC7 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), null, composerStartRestartGroup, 6, 2);
                lb.a aVar6 = aVar4;
                aVarC8 = c1.d.c(va.v.e("android.permission.CAMERA"), null, composerStartRestartGroup, 6, 2);
                if (Build.VERSION.SDK_INT >= 33) {
                    listN2 = va.v.e("android.permission.POST_NOTIFICATIONS");
                } else {
                    listN2 = va.w.n();
                }
                Function3 function7 = function3RememberComposableLambda;
                aVarC9 = c1.d.c(listN2, null, composerStartRestartGroup, 0, 2);
                ua.k0 k0Var2 = ua.k0.f43947a;
                if ((i12 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean zChanged2 = z11 | composerStartRestartGroup.changed(aVarC) | composerStartRestartGroup.changed(aVarC2) | composerStartRestartGroup.changed(aVarC3) | composerStartRestartGroup.changed(zIsExternalStorageManager) | composerStartRestartGroup.changed(aVarC4) | composerStartRestartGroup.changed(aVarC5) | composerStartRestartGroup.changed(aVarC6) | composerStartRestartGroup.changed(aVarC7) | composerStartRestartGroup.changed(aVarC8) | composerStartRestartGroup.changed(aVarC9);
                if ((i12 & 7168) == 2048) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = zChanged2 | z12;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    Z17PermissionRequesterKt$Z17PermissionChecker$3$1 z17PermissionRequesterKt$Z17PermissionChecker$3$2 = new Z17PermissionRequesterKt$Z17PermissionChecker$3$1(permissionState, onResult, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                    composerStartRestartGroup.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionChecker$3$2);
                    objRememberedValue = z17PermissionRequesterKt$Z17PermissionChecker$3$2;
                } else {
                    Z17PermissionRequesterKt$Z17PermissionChecker$3$1 z17PermissionRequesterKt$Z17PermissionChecker$3$3 = new Z17PermissionRequesterKt$Z17PermissionChecker$3$1(permissionState, onResult, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                    composerStartRestartGroup.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionChecker$3$3);
                    objRememberedValue = z17PermissionRequesterKt$Z17PermissionChecker$3$3;
                }
                EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
                function5 = function7;
                aVar3 = aVar6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                aVar3 = aVar2;
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.d1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PermissionRequesterKt.Z17PermissionChecker$lambda$16(modifier3, aVar3, permissionState, onResult, function5, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        aVar2 = aVar;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changed(permissionState)) {
                i17 = 256;
            } else {
                i17 = 128;
            }
            i12 |= i17;
        }
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onResult)) {
                i16 = 2048;
            } else {
                i16 = 1024;
            }
            i12 |= i16;
        }
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
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
                if (i18 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i19 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.b1
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar4 = (lb.a) objRememberedValue2;
                } else {
                    aVar4 = aVar2;
                }
                if (i13 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(285409273, true, new Function3() { // from class: cu.z17.views.permission.c1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionChecker$lambda$14(permissionState, aVar4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    function3RememberComposableLambda = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(943636707, i12, -1, "cu.z17.views.permission.Z17PermissionChecker (Z17PermissionRequester.kt:289)");
                }
                function3RememberComposableLambda.invoke(modifier4, composerStartRestartGroup, Integer.valueOf((i12 & 14) | ((i12 >> 9) & 112)));
                aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), null, composerStartRestartGroup, 6, 2);
                i15 = Build.VERSION.SDK_INT;
                if (i15 <= 30) {
                    listN = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
                } else {
                    listN = va.w.n();
                }
                aVarC2 = c1.d.c(listN, null, composerStartRestartGroup, 0, 2);
                if (i15 >= 33) {
                    listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
                } else {
                    listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
                }
                aVarC3 = c1.d.c(listE, null, composerStartRestartGroup, 0, 2);
                if (i15 >= 30) {
                    zIsExternalStorageManager = Environment.isExternalStorageManager();
                } else {
                    zIsExternalStorageManager = true;
                }
                aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), null, composerStartRestartGroup, 6, 2);
                aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), null, composerStartRestartGroup, 6, 2);
                aVarC6 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), null, composerStartRestartGroup, 6, 2);
                Modifier modifier7 = modifier4;
                aVarC7 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), null, composerStartRestartGroup, 6, 2);
                lb.a aVar7 = aVar4;
                aVarC8 = c1.d.c(va.v.e("android.permission.CAMERA"), null, composerStartRestartGroup, 6, 2);
                if (Build.VERSION.SDK_INT >= 33) {
                    listN2 = va.v.e("android.permission.POST_NOTIFICATIONS");
                } else {
                    listN2 = va.w.n();
                }
                Function3 function8 = function3RememberComposableLambda;
                aVarC9 = c1.d.c(listN2, null, composerStartRestartGroup, 0, 2);
                ua.k0 k0Var3 = ua.k0.f43947a;
                if ((i12 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean zChanged3 = z11 | composerStartRestartGroup.changed(aVarC) | composerStartRestartGroup.changed(aVarC2) | composerStartRestartGroup.changed(aVarC3) | composerStartRestartGroup.changed(zIsExternalStorageManager) | composerStartRestartGroup.changed(aVarC4) | composerStartRestartGroup.changed(aVarC5) | composerStartRestartGroup.changed(aVarC6) | composerStartRestartGroup.changed(aVarC7) | composerStartRestartGroup.changed(aVarC8) | composerStartRestartGroup.changed(aVarC9);
                if ((i12 & 7168) == 2048) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = zChanged3 | z12;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    Z17PermissionRequesterKt$Z17PermissionChecker$3$1 z17PermissionRequesterKt$Z17PermissionChecker$3$4 = new Z17PermissionRequesterKt$Z17PermissionChecker$3$1(permissionState, onResult, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                    composerStartRestartGroup.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionChecker$3$4);
                    objRememberedValue = z17PermissionRequesterKt$Z17PermissionChecker$3$4;
                } else {
                    Z17PermissionRequesterKt$Z17PermissionChecker$3$1 z17PermissionRequesterKt$Z17PermissionChecker$3$5 = new Z17PermissionRequesterKt$Z17PermissionChecker$3$1(permissionState, onResult, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                    composerStartRestartGroup.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionChecker$3$5);
                    objRememberedValue = z17PermissionRequesterKt$Z17PermissionChecker$3$5;
                }
                EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue, composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
                function5 = function8;
                aVar3 = aVar7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                aVar3 = aVar2;
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.d1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PermissionRequesterKt.Z17PermissionChecker$lambda$16(modifier3, aVar3, permissionState, onResult, function5, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        function4 = function3;
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            if (i18 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i19 != 0) {
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.b1
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                aVar4 = (lb.a) objRememberedValue2;
            } else {
                aVar4 = aVar2;
            }
            if (i13 != 0) {
                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(285409273, true, new Function3() { // from class: cu.z17.views.permission.c1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionChecker$lambda$14(permissionState, aVar4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
            } else {
                function3RememberComposableLambda = function4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943636707, i12, -1, "cu.z17.views.permission.Z17PermissionChecker (Z17PermissionRequester.kt:289)");
            }
            function3RememberComposableLambda.invoke(modifier4, composerStartRestartGroup, Integer.valueOf((i12 & 14) | ((i12 >> 9) & 112)));
            aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), null, composerStartRestartGroup, 6, 2);
            i15 = Build.VERSION.SDK_INT;
            if (i15 <= 30) {
                listN = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
            } else {
                listN = va.w.n();
            }
            aVarC2 = c1.d.c(listN, null, composerStartRestartGroup, 0, 2);
            if (i15 >= 33) {
                listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
            } else {
                listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
            }
            aVarC3 = c1.d.c(listE, null, composerStartRestartGroup, 0, 2);
            if (i15 >= 30) {
                zIsExternalStorageManager = Environment.isExternalStorageManager();
            } else {
                zIsExternalStorageManager = true;
            }
            aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), null, composerStartRestartGroup, 6, 2);
            aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), null, composerStartRestartGroup, 6, 2);
            aVarC6 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), null, composerStartRestartGroup, 6, 2);
            Modifier modifier8 = modifier4;
            aVarC7 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), null, composerStartRestartGroup, 6, 2);
            lb.a aVar8 = aVar4;
            aVarC8 = c1.d.c(va.v.e("android.permission.CAMERA"), null, composerStartRestartGroup, 6, 2);
            if (Build.VERSION.SDK_INT >= 33) {
                listN2 = va.v.e("android.permission.POST_NOTIFICATIONS");
            } else {
                listN2 = va.w.n();
            }
            Function3 function9 = function3RememberComposableLambda;
            aVarC9 = c1.d.c(listN2, null, composerStartRestartGroup, 0, 2);
            ua.k0 k0Var4 = ua.k0.f43947a;
            if ((i12 & 896) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean zChanged4 = z11 | composerStartRestartGroup.changed(aVarC) | composerStartRestartGroup.changed(aVarC2) | composerStartRestartGroup.changed(aVarC3) | composerStartRestartGroup.changed(zIsExternalStorageManager) | composerStartRestartGroup.changed(aVarC4) | composerStartRestartGroup.changed(aVarC5) | composerStartRestartGroup.changed(aVarC6) | composerStartRestartGroup.changed(aVarC7) | composerStartRestartGroup.changed(aVarC8) | composerStartRestartGroup.changed(aVarC9);
            if ((i12 & 7168) == 2048) {
                z12 = true;
            } else {
                z12 = false;
            }
            z13 = zChanged4 | z12;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z13) {
                Z17PermissionRequesterKt$Z17PermissionChecker$3$1 z17PermissionRequesterKt$Z17PermissionChecker$3$6 = new Z17PermissionRequesterKt$Z17PermissionChecker$3$1(permissionState, onResult, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                composerStartRestartGroup.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionChecker$3$6);
                objRememberedValue = z17PermissionRequesterKt$Z17PermissionChecker$3$6;
            } else {
                Z17PermissionRequesterKt$Z17PermissionChecker$3$1 z17PermissionRequesterKt$Z17PermissionChecker$3$7 = new Z17PermissionRequesterKt$Z17PermissionChecker$3$1(permissionState, onResult, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                composerStartRestartGroup.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionChecker$3$7);
                objRememberedValue = z17PermissionRequesterKt$Z17PermissionChecker$3$7;
            }
            EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier8;
            function5 = function9;
            aVar3 = aVar8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            aVar3 = aVar2;
            function5 = function4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PermissionRequesterKt.Z17PermissionChecker$lambda$16(modifier3, aVar3, permissionState, onResult, function5, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionChecker$lambda$14(PermissionsRequesterState permissionsRequesterState, lb.a aVar, Modifier it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(285409273, i11, -1, "cu.z17.views.permission.Z17PermissionChecker.<anonymous> (Z17PermissionRequester.kt:273)");
            }
            Integer state = permissionsRequesterState.getPermissionsResult().getState();
            if (state != null && state.intValue() == 4) {
                composer.startReplaceGroup(-1407515643);
                float f10 = 20;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(it, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i12 = MaterialTheme.$stable;
                Z17MarkdownLabelKt.Z17MarkdownLabel(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i12).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10)), StringResources_androidKt.stringResource(R.string.required_permissions_were_not_granted, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i12).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), aVar, null, composer, 0, 16);
            } else {
                composer.startReplaceGroup(-1417228439);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionChecker$lambda$16(Modifier modifier, lb.a aVar, PermissionsRequesterState permissionsRequesterState, Function1 function1, Function3 function3, int i10, int i11, Composer composer, int i12) {
        Z17PermissionChecker(modifier, aVar, permissionsRequesterState, function1, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0137  */
    /* JADX WARN: Code duplicated, block: B:102:0x013a  */
    /* JADX WARN: Code duplicated, block: B:103:0x0145  */
    /* JADX WARN: Code duplicated, block: B:106:0x0156  */
    /* JADX WARN: Code duplicated, block: B:109:0x0169  */
    /* JADX WARN: Code duplicated, block: B:112:0x0182  */
    /* JADX WARN: Code duplicated, block: B:126:0x026c  */
    /* JADX WARN: Code duplicated, block: B:129:0x0289  */
    /* JADX WARN: Code duplicated, block: B:131:0x0295  */
    /* JADX WARN: Code duplicated, block: B:134:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:135:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:140:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:143:0x0304  */
    /* JADX WARN: Code duplicated, block: B:145:0x030f  */
    /* JADX WARN: Code duplicated, block: B:148:0x035c  */
    /* JADX WARN: Code duplicated, block: B:149:0x035f  */
    /* JADX WARN: Code duplicated, block: B:152:0x0369  */
    /* JADX WARN: Code duplicated, block: B:156:0x0380  */
    /* JADX WARN: Code duplicated, block: B:159:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:161:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:162:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:165:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:169:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:172:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:173:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:176:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:178:0x0404  */
    /* JADX WARN: Code duplicated, block: B:181:0x041f  */
    /* JADX WARN: Code duplicated, block: B:184:0x042f  */
    /* JADX WARN: Code duplicated, block: B:187:0x043c  */
    /* JADX WARN: Code duplicated, block: B:190:0x044d  */
    /* JADX WARN: Code duplicated, block: B:193:0x02b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:85:0x0101 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0103  */
    /* JADX WARN: Code duplicated, block: B:87:0x0106  */
    /* JADX WARN: Code duplicated, block: B:90:0x010b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0114  */
    /* JADX WARN: Code duplicated, block: B:93:0x0117  */
    /* JADX WARN: Code duplicated, block: B:94:0x011c  */
    /* JADX WARN: Code duplicated, block: B:96:0x0120  */
    /* JADX WARN: Code duplicated, block: B:98:0x012c  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17PermissionCheckerAndRequester(Modifier modifier, PermissionsResult permissionsResult, List<? extends PermissionNeedIt> list, lb.a onGranted, lb.a aVar, final String packageName, String str, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        PermissionsResult permissionsResult2;
        int i13;
        final lb.a aVar2;
        int i14;
        int i15;
        int i16;
        boolean z10;
        final lb.a aVar3;
        final String str2;
        final Modifier modifier3;
        final PermissionsResult permissionsResult3;
        final List<? extends PermissionNeedIt> list2;
        final lb.a aVar4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        PermissionsResult permissionsResultRequest;
        List<? extends PermissionNeedIt> listN;
        lb.a aVar5;
        String str3;
        PermissionsResult permissionsResult4;
        int i17;
        List<? extends PermissionNeedIt> list3;
        lb.a aVar6;
        Object objRememberedValue;
        Object objRememberedValue2;
        Composer.Companion companion;
        final MutableState mutableState;
        Function1 function1;
        Composer composer2;
        c1.a aVarC;
        int i18;
        List listN2;
        c1.a aVarC2;
        List listE;
        c1.a aVarC3;
        boolean zIsExternalStorageManager;
        c1.a aVarC4;
        c1.a aVarC5;
        c1.a aVarC6;
        c1.a aVarC7;
        c1.a aVarC8;
        List listN3;
        lb.a aVar7;
        c1.a aVarC9;
        int i19;
        boolean z11;
        boolean z12;
        Object objRememberedValue3;
        Composer composer3;
        int i20;
        boolean z13;
        final MutableState mutableState2;
        boolean z14;
        Object objRememberedValue4;
        boolean z15;
        Object objRememberedValue5;
        Integer state;
        int i21;
        int i22;
        kotlin.jvm.internal.y.i(onGranted, "onGranted");
        kotlin.jvm.internal.y.i(packageName, "packageName");
        Composer composerStartRestartGroup = composer.startRestartGroup(1672766169);
        int i23 = i11 & 1;
        if (i23 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                permissionsResult2 = permissionsResult;
                int i24 = composerStartRestartGroup.changed(permissionsResult2) ? 32 : 16;
                i12 |= i24;
            } else {
                permissionsResult2 = permissionsResult;
            }
            i12 |= i24;
        } else {
            permissionsResult2 = permissionsResult;
        }
        int i25 = i11 & 4;
        if (i25 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onGranted)) {
                    i22 = 2048;
                } else {
                    i22 = 1024;
                }
                i12 |= i22;
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
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(packageName)) {
                        i21 = 131072;
                    } else {
                        i21 = 65536;
                    }
                    i12 |= i21;
                }
                i15 = i11 & 64;
                if (i15 != 0) {
                    i12 |= 1572864;
                } else if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i12 |= i16;
                }
                if ((i12 & 599187) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i23 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i11 & 2) != 0) {
                            permissionsResultRequest = PermissionsResult.INSTANCE.request();
                            i12 &= -113;
                        } else {
                            permissionsResultRequest = permissionsResult2;
                        }
                        if (i25 != 0) {
                            listN = va.w.n();
                        } else {
                            listN = list;
                        }
                        if (i13 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.k
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar5 = (lb.a) objRememberedValue;
                        } else {
                            aVar5 = aVar2;
                        }
                        if (i15 != 0) {
                            permissionsResult4 = permissionsResultRequest;
                            i17 = i12;
                            list3 = listN;
                            aVar6 = aVar5;
                            str3 = "";
                        } else {
                            str3 = str;
                            permissionsResult4 = permissionsResultRequest;
                            i17 = i12;
                            list3 = listN;
                            aVar6 = aVar5;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 2) != 0) {
                            i12 &= -113;
                        }
                        list3 = list;
                        str3 = str;
                        modifier4 = modifier2;
                        i17 = i12;
                        permissionsResult4 = permissionsResult2;
                        aVar6 = aVar2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1672766169, i17, -1, "cu.z17.views.permission.Z17PermissionCheckerAndRequester (Z17PermissionRequester.kt:79)");
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(permissionsResult4, false, list3, 2, null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    if (str3 != null || ((state = ((PermissionsRequesterState) mutableState.getValue()).getPermissionsResult().getState()) != null && state.intValue() == 2)) {
                        function1 = null;
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceGroup(-1131676951);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1127866555);
                        float f10 = 20;
                        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        int i26 = MaterialTheme.$stable;
                        Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i26).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(10))), Dp.m8823constructorimpl(f10));
                        composerStartRestartGroup.startReplaceGroup(1210554440);
                        String strStringResource = str3.length() == 0 ? StringResources_androidKt.stringResource(R.string.required_permissions_were_not_granted, composerStartRestartGroup, 0) : str3;
                        composerStartRestartGroup.endReplaceGroup();
                        TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i26).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
                        Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new lb.a() { // from class: cu.z17.views.permission.l
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$5$lambda$4(mutableState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function1 = null;
                        Z17MarkdownLabelKt.Z17MarkdownLabel(modifierM1725padding3ABfNKs2, strStringResource, textStyleM8271copyp1EtxEg$default, (lb.a) objRememberedValue6, null, composerStartRestartGroup, 3072, 16);
                        composer2 = composerStartRestartGroup;
                    }
                    composer2.endReplaceGroup();
                    aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), function1, composer2, 6, 2);
                    i18 = Build.VERSION.SDK_INT;
                    if (i18 <= 30) {
                        listN2 = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
                    } else {
                        listN2 = va.w.n();
                    }
                    aVarC2 = c1.d.c(listN2, function1, composer2, 0, 2);
                    if (i18 >= 33) {
                        listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
                    } else {
                        listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
                    }
                    aVarC3 = c1.d.c(listE, function1, composer2, 0, 2);
                    if (i18 >= 30) {
                        try {
                            zIsExternalStorageManager = Environment.isExternalStorageManager();
                        } catch (Exception unused) {
                            zIsExternalStorageManager = true;
                        }
                    } else {
                        zIsExternalStorageManager = true;
                    }
                    aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), function1, composer2, 6, 2);
                    aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), function1, composer2, 6, 2);
                    aVarC6 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), function1, composer2, 6, 2);
                    Modifier modifier5 = modifier4;
                    aVarC7 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), function1, composer2, 6, 2);
                    aVarC8 = c1.d.c(va.v.e("android.permission.CAMERA"), function1, composer2, 6, 2);
                    if (Build.VERSION.SDK_INT >= 33) {
                        listN3 = va.v.e("android.permission.POST_NOTIFICATIONS");
                    } else {
                        listN3 = va.w.n();
                    }
                    aVar7 = aVar6;
                    aVarC9 = c1.d.c(listN3, function1, composer2, 0, 2);
                    ua.k0 k0Var = ua.k0.f43947a;
                    boolean zChanged = composer2.changed(aVarC) | composer2.changed(aVarC2) | composer2.changed(aVarC3) | composer2.changed(zIsExternalStorageManager) | composer2.changed(aVarC4) | composer2.changed(aVarC5) | composer2.changed(aVarC6) | composer2.changed(aVarC7) | composer2.changed(aVarC8) | composer2.changed(aVarC9);
                    i19 = i17 & 7168;
                    if (i19 == 2048) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z12 = zChanged | z11;
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!z12 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        composer3 = composer2;
                        i20 = i19;
                        z13 = false;
                        mutableState2 = mutableState;
                        objRememberedValue3 = new Z17PermissionRequesterKt$Z17PermissionCheckerAndRequester$4$1(mutableState2, onGranted, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                        aVar3 = onGranted;
                        composer3.updateRememberedValue(objRememberedValue3);
                    } else {
                        mutableState2 = mutableState;
                        aVar3 = onGranted;
                        composer3 = composer2;
                        i20 = i19;
                        z13 = false;
                    }
                    EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue3, composer3, 6);
                    if (((PermissionsRequesterState) mutableState2.getValue()).getOpen()) {
                        composer3.startReplaceGroup(1210704119);
                        PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState2.getValue();
                        if ((i17 & 57344) == 16384) {
                            z14 = true;
                        } else {
                            z14 = z13;
                        }
                        objRememberedValue4 = composer3.rememberedValue();
                        if (!z14 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            aVar2 = aVar7;
                            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.permission.m
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$8$lambda$7(mutableState2, aVar2);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        } else {
                            aVar2 = aVar7;
                        }
                        lb.a aVar8 = (lb.a) objRememberedValue4;
                        if (i20 == 2048) {
                            z15 = true;
                        } else {
                            z15 = z13;
                        }
                        objRememberedValue5 = composer3.rememberedValue();
                        if (z15 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.z17.views.permission.n
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$10$lambda$9(mutableState2, aVar3, (PermissionsResult) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        Composer composer4 = composer3;
                        Z17PermissionRequester(permissionsRequesterState, aVar8, (Function1) objRememberedValue5, packageName, composer4, (i17 >> 6) & 7168);
                        composerStartRestartGroup = composer4;
                    } else {
                        composerStartRestartGroup = composer3;
                        aVar2 = aVar7;
                        composerStartRestartGroup.startReplaceGroup(-1131676951);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    permissionsResult3 = permissionsResult4;
                    list2 = list3;
                    modifier3 = modifier5;
                } else {
                    aVar3 = onGranted;
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    permissionsResult3 = permissionsResult2;
                    list2 = list;
                }
                aVar4 = aVar2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final lb.a aVar9 = aVar3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$11(modifier3, permissionsResult3, list2, aVar9, aVar4, packageName, str2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            aVar2 = aVar;
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(packageName)) {
                    i21 = 131072;
                } else {
                    i21 = 65536;
                }
                i12 |= i21;
            }
            i15 = i11 & 64;
            if (i15 != 0) {
                i12 |= 1572864;
            } else if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            }
            if ((i12 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i23 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        permissionsResultRequest = PermissionsResult.INSTANCE.request();
                        i12 &= -113;
                    } else {
                        permissionsResultRequest = permissionsResult2;
                    }
                    if (i25 != 0) {
                        listN = va.w.n();
                    } else {
                        listN = list;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar5 = (lb.a) objRememberedValue;
                    } else {
                        aVar5 = aVar2;
                    }
                    if (i15 != 0) {
                        permissionsResult4 = permissionsResultRequest;
                        i17 = i12;
                        list3 = listN;
                        aVar6 = aVar5;
                        str3 = "";
                    } else {
                        str3 = str;
                        permissionsResult4 = permissionsResultRequest;
                        i17 = i12;
                        list3 = listN;
                        aVar6 = aVar5;
                    }
                } else {
                    if (i23 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        permissionsResultRequest = PermissionsResult.INSTANCE.request();
                        i12 &= -113;
                    } else {
                        permissionsResultRequest = permissionsResult2;
                    }
                    if (i25 != 0) {
                        listN = va.w.n();
                    } else {
                        listN = list;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar5 = (lb.a) objRememberedValue;
                    } else {
                        aVar5 = aVar2;
                    }
                    if (i15 != 0) {
                        permissionsResult4 = permissionsResultRequest;
                        i17 = i12;
                        list3 = listN;
                        aVar6 = aVar5;
                        str3 = "";
                    } else {
                        str3 = str;
                        permissionsResult4 = permissionsResultRequest;
                        i17 = i12;
                        list3 = listN;
                        aVar6 = aVar5;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1672766169, i17, -1, "cu.z17.views.permission.Z17PermissionCheckerAndRequester (Z17PermissionRequester.kt:79)");
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(permissionsResult4, false, list3, 2, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                if (str3 != null) {
                    function1 = null;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-1131676951);
                } else {
                    function1 = null;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-1131676951);
                }
                composer2.endReplaceGroup();
                aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), function1, composer2, 6, 2);
                i18 = Build.VERSION.SDK_INT;
                if (i18 <= 30) {
                    listN2 = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
                } else {
                    listN2 = va.w.n();
                }
                aVarC2 = c1.d.c(listN2, function1, composer2, 0, 2);
                if (i18 >= 33) {
                    listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
                } else {
                    listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
                }
                aVarC3 = c1.d.c(listE, function1, composer2, 0, 2);
                if (i18 >= 30) {
                    zIsExternalStorageManager = Environment.isExternalStorageManager();
                } else {
                    zIsExternalStorageManager = true;
                }
                aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), function1, composer2, 6, 2);
                aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), function1, composer2, 6, 2);
                aVarC6 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), function1, composer2, 6, 2);
                Modifier modifier6 = modifier4;
                aVarC7 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), function1, composer2, 6, 2);
                aVarC8 = c1.d.c(va.v.e("android.permission.CAMERA"), function1, composer2, 6, 2);
                if (Build.VERSION.SDK_INT >= 33) {
                    listN3 = va.v.e("android.permission.POST_NOTIFICATIONS");
                } else {
                    listN3 = va.w.n();
                }
                aVar7 = aVar6;
                aVarC9 = c1.d.c(listN3, function1, composer2, 0, 2);
                ua.k0 k0Var2 = ua.k0.f43947a;
                boolean zChanged2 = composer2.changed(aVarC) | composer2.changed(aVarC2) | composer2.changed(aVarC3) | composer2.changed(zIsExternalStorageManager) | composer2.changed(aVarC4) | composer2.changed(aVarC5) | composer2.changed(aVarC6) | composer2.changed(aVarC7) | composer2.changed(aVarC8) | composer2.changed(aVarC9);
                i19 = i17 & 7168;
                if (i19 == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = zChanged2 | z11;
                objRememberedValue3 = composer2.rememberedValue();
                if (z12) {
                    composer3 = composer2;
                    i20 = i19;
                    z13 = false;
                    mutableState2 = mutableState;
                    objRememberedValue3 = new Z17PermissionRequesterKt$Z17PermissionCheckerAndRequester$4$1(mutableState2, onGranted, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                    aVar3 = onGranted;
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    composer3 = composer2;
                    i20 = i19;
                    z13 = false;
                    mutableState2 = mutableState;
                    objRememberedValue3 = new Z17PermissionRequesterKt$Z17PermissionCheckerAndRequester$4$1(mutableState2, onGranted, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                    aVar3 = onGranted;
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue3, composer3, 6);
                if (((PermissionsRequesterState) mutableState2.getValue()).getOpen()) {
                    composer3.startReplaceGroup(1210704119);
                    PermissionsRequesterState permissionsRequesterState2 = (PermissionsRequesterState) mutableState2.getValue();
                    if ((i17 & 57344) == 16384) {
                        z14 = true;
                    } else {
                        z14 = z13;
                    }
                    objRememberedValue4 = composer3.rememberedValue();
                    if (z14) {
                        aVar2 = aVar7;
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.permission.m
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$8$lambda$7(mutableState2, aVar2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        aVar2 = aVar7;
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.permission.m
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$8$lambda$7(mutableState2, aVar2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar10 = (lb.a) objRememberedValue4;
                    if (i20 == 2048) {
                        z15 = true;
                    } else {
                        z15 = z13;
                    }
                    objRememberedValue5 = composer3.rememberedValue();
                    if (z15) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.permission.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$10$lambda$9(mutableState2, aVar3, (PermissionsResult) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.permission.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$10$lambda$9(mutableState2, aVar3, (PermissionsResult) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    Composer composer5 = composer3;
                    Z17PermissionRequester(permissionsRequesterState2, aVar10, (Function1) objRememberedValue5, packageName, composer5, (i17 >> 6) & 7168);
                    composerStartRestartGroup = composer5;
                } else {
                    composerStartRestartGroup = composer3;
                    aVar2 = aVar7;
                    composerStartRestartGroup.startReplaceGroup(-1131676951);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                permissionsResult3 = permissionsResult4;
                list2 = list3;
                modifier3 = modifier6;
            } else {
                aVar3 = onGranted;
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                permissionsResult3 = permissionsResult2;
                list2 = list;
            }
            aVar4 = aVar2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final lb.a aVar11 = aVar3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$11(modifier3, permissionsResult3, list2, aVar11, aVar4, packageName, str2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onGranted)) {
                i22 = 2048;
            } else {
                i22 = 1024;
            }
            i12 |= i22;
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
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(packageName)) {
                    i21 = 131072;
                } else {
                    i21 = 65536;
                }
                i12 |= i21;
            }
            i15 = i11 & 64;
            if (i15 != 0) {
                i12 |= 1572864;
            } else if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            }
            if ((i12 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i23 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        permissionsResultRequest = PermissionsResult.INSTANCE.request();
                        i12 &= -113;
                    } else {
                        permissionsResultRequest = permissionsResult2;
                    }
                    if (i25 != 0) {
                        listN = va.w.n();
                    } else {
                        listN = list;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar5 = (lb.a) objRememberedValue;
                    } else {
                        aVar5 = aVar2;
                    }
                    if (i15 != 0) {
                        permissionsResult4 = permissionsResultRequest;
                        i17 = i12;
                        list3 = listN;
                        aVar6 = aVar5;
                        str3 = "";
                    } else {
                        str3 = str;
                        permissionsResult4 = permissionsResultRequest;
                        i17 = i12;
                        list3 = listN;
                        aVar6 = aVar5;
                    }
                } else {
                    if (i23 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        permissionsResultRequest = PermissionsResult.INSTANCE.request();
                        i12 &= -113;
                    } else {
                        permissionsResultRequest = permissionsResult2;
                    }
                    if (i25 != 0) {
                        listN = va.w.n();
                    } else {
                        listN = list;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar5 = (lb.a) objRememberedValue;
                    } else {
                        aVar5 = aVar2;
                    }
                    if (i15 != 0) {
                        permissionsResult4 = permissionsResultRequest;
                        i17 = i12;
                        list3 = listN;
                        aVar6 = aVar5;
                        str3 = "";
                    } else {
                        str3 = str;
                        permissionsResult4 = permissionsResultRequest;
                        i17 = i12;
                        list3 = listN;
                        aVar6 = aVar5;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1672766169, i17, -1, "cu.z17.views.permission.Z17PermissionCheckerAndRequester (Z17PermissionRequester.kt:79)");
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(permissionsResult4, false, list3, 2, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                if (str3 != null) {
                    function1 = null;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-1131676951);
                } else {
                    function1 = null;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-1131676951);
                }
                composer2.endReplaceGroup();
                aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), function1, composer2, 6, 2);
                i18 = Build.VERSION.SDK_INT;
                if (i18 <= 30) {
                    listN2 = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
                } else {
                    listN2 = va.w.n();
                }
                aVarC2 = c1.d.c(listN2, function1, composer2, 0, 2);
                if (i18 >= 33) {
                    listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
                } else {
                    listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
                }
                aVarC3 = c1.d.c(listE, function1, composer2, 0, 2);
                if (i18 >= 30) {
                    zIsExternalStorageManager = Environment.isExternalStorageManager();
                } else {
                    zIsExternalStorageManager = true;
                }
                aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), function1, composer2, 6, 2);
                aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), function1, composer2, 6, 2);
                aVarC6 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), function1, composer2, 6, 2);
                Modifier modifier7 = modifier4;
                aVarC7 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), function1, composer2, 6, 2);
                aVarC8 = c1.d.c(va.v.e("android.permission.CAMERA"), function1, composer2, 6, 2);
                if (Build.VERSION.SDK_INT >= 33) {
                    listN3 = va.v.e("android.permission.POST_NOTIFICATIONS");
                } else {
                    listN3 = va.w.n();
                }
                aVar7 = aVar6;
                aVarC9 = c1.d.c(listN3, function1, composer2, 0, 2);
                ua.k0 k0Var3 = ua.k0.f43947a;
                boolean zChanged3 = composer2.changed(aVarC) | composer2.changed(aVarC2) | composer2.changed(aVarC3) | composer2.changed(zIsExternalStorageManager) | composer2.changed(aVarC4) | composer2.changed(aVarC5) | composer2.changed(aVarC6) | composer2.changed(aVarC7) | composer2.changed(aVarC8) | composer2.changed(aVarC9);
                i19 = i17 & 7168;
                if (i19 == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = zChanged3 | z11;
                objRememberedValue3 = composer2.rememberedValue();
                if (z12) {
                    composer3 = composer2;
                    i20 = i19;
                    z13 = false;
                    mutableState2 = mutableState;
                    objRememberedValue3 = new Z17PermissionRequesterKt$Z17PermissionCheckerAndRequester$4$1(mutableState2, onGranted, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                    aVar3 = onGranted;
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    composer3 = composer2;
                    i20 = i19;
                    z13 = false;
                    mutableState2 = mutableState;
                    objRememberedValue3 = new Z17PermissionRequesterKt$Z17PermissionCheckerAndRequester$4$1(mutableState2, onGranted, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                    aVar3 = onGranted;
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue3, composer3, 6);
                if (((PermissionsRequesterState) mutableState2.getValue()).getOpen()) {
                    composer3.startReplaceGroup(1210704119);
                    PermissionsRequesterState permissionsRequesterState3 = (PermissionsRequesterState) mutableState2.getValue();
                    if ((i17 & 57344) == 16384) {
                        z14 = true;
                    } else {
                        z14 = z13;
                    }
                    objRememberedValue4 = composer3.rememberedValue();
                    if (z14) {
                        aVar2 = aVar7;
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.permission.m
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$8$lambda$7(mutableState2, aVar2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        aVar2 = aVar7;
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.permission.m
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$8$lambda$7(mutableState2, aVar2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    lb.a aVar12 = (lb.a) objRememberedValue4;
                    if (i20 == 2048) {
                        z15 = true;
                    } else {
                        z15 = z13;
                    }
                    objRememberedValue5 = composer3.rememberedValue();
                    if (z15) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.permission.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$10$lambda$9(mutableState2, aVar3, (PermissionsResult) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.permission.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$10$lambda$9(mutableState2, aVar3, (PermissionsResult) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    Composer composer6 = composer3;
                    Z17PermissionRequester(permissionsRequesterState3, aVar12, (Function1) objRememberedValue5, packageName, composer6, (i17 >> 6) & 7168);
                    composerStartRestartGroup = composer6;
                } else {
                    composerStartRestartGroup = composer3;
                    aVar2 = aVar7;
                    composerStartRestartGroup.startReplaceGroup(-1131676951);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                permissionsResult3 = permissionsResult4;
                list2 = list3;
                modifier3 = modifier7;
            } else {
                aVar3 = onGranted;
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                permissionsResult3 = permissionsResult2;
                list2 = list;
            }
            aVar4 = aVar2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final lb.a aVar13 = aVar3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$11(modifier3, permissionsResult3, list2, aVar13, aVar4, packageName, str2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        aVar2 = aVar;
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(packageName)) {
                i21 = 131072;
            } else {
                i21 = 65536;
            }
            i12 |= i21;
        }
        i15 = i11 & 64;
        if (i15 != 0) {
            i12 |= 1572864;
        } else if ((i10 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(str)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i12 |= i16;
        }
        if ((i12 & 599187) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i23 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 2) != 0) {
                    permissionsResultRequest = PermissionsResult.INSTANCE.request();
                    i12 &= -113;
                } else {
                    permissionsResultRequest = permissionsResult2;
                }
                if (i25 != 0) {
                    listN = va.w.n();
                } else {
                    listN = list;
                }
                if (i13 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.k
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar5 = (lb.a) objRememberedValue;
                } else {
                    aVar5 = aVar2;
                }
                if (i15 != 0) {
                    permissionsResult4 = permissionsResultRequest;
                    i17 = i12;
                    list3 = listN;
                    aVar6 = aVar5;
                    str3 = "";
                } else {
                    str3 = str;
                    permissionsResult4 = permissionsResultRequest;
                    i17 = i12;
                    list3 = listN;
                    aVar6 = aVar5;
                }
            } else {
                if (i23 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 2) != 0) {
                    permissionsResultRequest = PermissionsResult.INSTANCE.request();
                    i12 &= -113;
                } else {
                    permissionsResultRequest = permissionsResult2;
                }
                if (i25 != 0) {
                    listN = va.w.n();
                } else {
                    listN = list;
                }
                if (i13 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.k
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar5 = (lb.a) objRememberedValue;
                } else {
                    aVar5 = aVar2;
                }
                if (i15 != 0) {
                    permissionsResult4 = permissionsResultRequest;
                    i17 = i12;
                    list3 = listN;
                    aVar6 = aVar5;
                    str3 = "";
                } else {
                    str3 = str;
                    permissionsResult4 = permissionsResultRequest;
                    i17 = i12;
                    list3 = listN;
                    aVar6 = aVar5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1672766169, i17, -1, "cu.z17.views.permission.Z17PermissionCheckerAndRequester (Z17PermissionRequester.kt:79)");
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(permissionsResult4, false, list3, 2, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            if (str3 != null) {
                function1 = null;
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-1131676951);
            } else {
                function1 = null;
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-1131676951);
            }
            composer2.endReplaceGroup();
            aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), function1, composer2, 6, 2);
            i18 = Build.VERSION.SDK_INT;
            if (i18 <= 30) {
                listN2 = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
            } else {
                listN2 = va.w.n();
            }
            aVarC2 = c1.d.c(listN2, function1, composer2, 0, 2);
            if (i18 >= 33) {
                listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
            } else {
                listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
            }
            aVarC3 = c1.d.c(listE, function1, composer2, 0, 2);
            if (i18 >= 30) {
                zIsExternalStorageManager = Environment.isExternalStorageManager();
            } else {
                zIsExternalStorageManager = true;
            }
            aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), function1, composer2, 6, 2);
            aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), function1, composer2, 6, 2);
            aVarC6 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), function1, composer2, 6, 2);
            Modifier modifier8 = modifier4;
            aVarC7 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), function1, composer2, 6, 2);
            aVarC8 = c1.d.c(va.v.e("android.permission.CAMERA"), function1, composer2, 6, 2);
            if (Build.VERSION.SDK_INT >= 33) {
                listN3 = va.v.e("android.permission.POST_NOTIFICATIONS");
            } else {
                listN3 = va.w.n();
            }
            aVar7 = aVar6;
            aVarC9 = c1.d.c(listN3, function1, composer2, 0, 2);
            ua.k0 k0Var4 = ua.k0.f43947a;
            boolean zChanged4 = composer2.changed(aVarC) | composer2.changed(aVarC2) | composer2.changed(aVarC3) | composer2.changed(zIsExternalStorageManager) | composer2.changed(aVarC4) | composer2.changed(aVarC5) | composer2.changed(aVarC6) | composer2.changed(aVarC7) | composer2.changed(aVarC8) | composer2.changed(aVarC9);
            i19 = i17 & 7168;
            if (i19 == 2048) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = zChanged4 | z11;
            objRememberedValue3 = composer2.rememberedValue();
            if (z12) {
                composer3 = composer2;
                i20 = i19;
                z13 = false;
                mutableState2 = mutableState;
                objRememberedValue3 = new Z17PermissionRequesterKt$Z17PermissionCheckerAndRequester$4$1(mutableState2, onGranted, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                aVar3 = onGranted;
                composer3.updateRememberedValue(objRememberedValue3);
            } else {
                composer3 = composer2;
                i20 = i19;
                z13 = false;
                mutableState2 = mutableState;
                objRememberedValue3 = new Z17PermissionRequesterKt$Z17PermissionCheckerAndRequester$4$1(mutableState2, onGranted, aVarC, aVarC2, aVarC3, zIsExternalStorageManager, aVarC4, aVarC5, aVarC6, aVarC7, aVarC8, aVarC9, null);
                aVar3 = onGranted;
                composer3.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue3, composer3, 6);
            if (((PermissionsRequesterState) mutableState2.getValue()).getOpen()) {
                composer3.startReplaceGroup(1210704119);
                PermissionsRequesterState permissionsRequesterState4 = (PermissionsRequesterState) mutableState2.getValue();
                if ((i17 & 57344) == 16384) {
                    z14 = true;
                } else {
                    z14 = z13;
                }
                objRememberedValue4 = composer3.rememberedValue();
                if (z14) {
                    aVar2 = aVar7;
                    objRememberedValue4 = new lb.a() { // from class: cu.z17.views.permission.m
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$8$lambda$7(mutableState2, aVar2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    aVar2 = aVar7;
                    objRememberedValue4 = new lb.a() { // from class: cu.z17.views.permission.m
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$8$lambda$7(mutableState2, aVar2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                lb.a aVar14 = (lb.a) objRememberedValue4;
                if (i20 == 2048) {
                    z15 = true;
                } else {
                    z15 = z13;
                }
                objRememberedValue5 = composer3.rememberedValue();
                if (z15) {
                    objRememberedValue5 = new Function1() { // from class: cu.z17.views.permission.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$10$lambda$9(mutableState2, aVar3, (PermissionsResult) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: cu.z17.views.permission.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$10$lambda$9(mutableState2, aVar3, (PermissionsResult) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                Composer composer7 = composer3;
                Z17PermissionRequester(permissionsRequesterState4, aVar14, (Function1) objRememberedValue5, packageName, composer7, (i17 >> 6) & 7168);
                composerStartRestartGroup = composer7;
            } else {
                composerStartRestartGroup = composer3;
                aVar2 = aVar7;
                composerStartRestartGroup.startReplaceGroup(-1131676951);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
            permissionsResult3 = permissionsResult4;
            list2 = list3;
            modifier3 = modifier8;
        } else {
            aVar3 = onGranted;
            composerStartRestartGroup.skipToGroupEnd();
            str2 = str;
            modifier3 = modifier2;
            permissionsResult3 = permissionsResult2;
            list2 = list;
        }
        aVar4 = aVar2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final lb.a aVar15 = aVar3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PermissionRequesterKt.Z17PermissionCheckerAndRequester$lambda$11(modifier3, permissionsResult3, list2, aVar15, aVar4, packageName, str2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionCheckerAndRequester$lambda$10$lambda$9(MutableState mutableState, lb.a aVar, PermissionsResult it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), it, false, null, 6, null));
        Integer state = it.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
            aVar.invoke();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionCheckerAndRequester$lambda$11(Modifier modifier, PermissionsResult permissionsResult, List list, lb.a aVar, lb.a aVar2, String str, String str2, int i10, int i11, Composer composer, int i12) {
        Z17PermissionCheckerAndRequester(modifier, permissionsResult, list, aVar, aVar2, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionCheckerAndRequester$lambda$5$lambda$4(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionCheckerAndRequester$lambda$8$lambda$7(MutableState mutableState, lb.a aVar) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0290  */
    /* JADX WARN: Code duplicated, block: B:104:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:108:0x02df  */
    /* JADX WARN: Code duplicated, block: B:111:0x0325  */
    /* JADX WARN: Code duplicated, block: B:115:0x0337  */
    /* JADX WARN: Code duplicated, block: B:118:0x036b  */
    /* JADX WARN: Code duplicated, block: B:123:0x037b  */
    /* JADX WARN: Code duplicated, block: B:126:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:131:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:134:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:138:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:141:0x0433  */
    /* JADX WARN: Code duplicated, block: B:146:0x0443  */
    /* JADX WARN: Code duplicated, block: B:149:0x0471  */
    /* JADX WARN: Code duplicated, block: B:153:0x0483  */
    /* JADX WARN: Code duplicated, block: B:156:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:159:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:160:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:163:0x04df  */
    /* JADX WARN: Code duplicated, block: B:165:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:168:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:169:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:173:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:176:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:180:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:183:0x061c  */
    /* JADX WARN: Code duplicated, block: B:185:0x0623  */
    /* JADX WARN: Code duplicated, block: B:188:0x062f  */
    /* JADX WARN: Code duplicated, block: B:190:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x0080  */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x0095  */
    /* JADX WARN: Code duplicated, block: B:48:0x0097  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:72:0x0110  */
    /* JADX WARN: Code duplicated, block: B:75:0x015a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0165  */
    /* JADX WARN: Code duplicated, block: B:80:0x017a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0185  */
    /* JADX WARN: Code duplicated, block: B:84:0x01db  */
    /* JADX WARN: Code duplicated, block: B:87:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:88:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:93:0x021a  */
    /* JADX WARN: Code duplicated, block: B:96:0x027c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0287  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17PermissionContainer(Modifier modifier, final PermissionsResult actualResult, List<? extends PermissionNeedIt> list, final Function1 onResult, final String packageName, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        List<? extends PermissionNeedIt> listN;
        boolean z10;
        Composer composer2;
        final Modifier modifier3;
        final List<? extends PermissionNeedIt> list2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Context context;
        final c1.a aVarC;
        int i13;
        int i14;
        List listN2;
        c1.a aVarC2;
        List listE;
        final c1.a aVarC3;
        boolean zIsExternalStorageManager;
        final boolean z11;
        final c1.a aVar;
        final c1.a aVarC4;
        final c1.a aVarC5;
        final c1.a aVarC6;
        final c1.a aVarC7;
        List listN3;
        c1.a aVarC8;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        List<? extends PermissionNeedIt> list3;
        final c1.a aVar2;
        final List<? extends PermissionNeedIt> list4;
        final MutableState mutableState2;
        c1.a aVar3;
        final MutableState mutableState3;
        final c1.a aVar4;
        Object objRememberedValue2;
        boolean z12;
        boolean zChangedInstance;
        Object objRememberedValue3;
        c1.a aVar5;
        c1.a aVar6;
        boolean z13;
        c1.a aVar7;
        boolean z14;
        boolean z15;
        Object objRememberedValue4;
        int i15;
        int i16;
        kotlin.jvm.internal.y.i(actualResult, "actualResult");
        kotlin.jvm.internal.y.i(onResult, "onResult");
        kotlin.jvm.internal.y.i(packageName, "packageName");
        Composer composerStartRestartGroup = composer.startRestartGroup(-516241236);
        int i17 = i11 & 1;
        if (i17 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(actualResult) ? 32 : 16;
        }
        int i18 = i11 & 4;
        if (i18 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                listN = list;
                i12 |= composerStartRestartGroup.changedInstance(listN) ? 256 : 128;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onResult)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i12 |= i16;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changed(packageName)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
                }
                i12 |= i15;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i17 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i18 != 0) {
                    listN = va.w.n();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-516241236, i12, -1, "cu.z17.views.permission.Z17PermissionContainer (Z17PermissionRequester.kt:470)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), null, composerStartRestartGroup, 6, 2);
                i13 = Build.VERSION.SDK_INT;
                i14 = i12;
                if (i13 <= 30) {
                    listN2 = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
                } else {
                    listN2 = va.w.n();
                }
                aVarC2 = c1.d.c(listN2, null, composerStartRestartGroup, 0, 2);
                if (i13 >= 33) {
                    listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
                } else {
                    listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
                }
                aVarC3 = c1.d.c(listE, null, composerStartRestartGroup, 0, 2);
                if (i13 >= 30) {
                    try {
                        zIsExternalStorageManager = Environment.isExternalStorageManager();
                    } catch (Exception unused) {
                        zIsExternalStorageManager = true;
                    }
                    z11 = zIsExternalStorageManager;
                    aVar = aVarC2;
                } else {
                    aVar = aVarC2;
                    z11 = true;
                }
                aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), null, composerStartRestartGroup, 6, 2);
                aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), null, composerStartRestartGroup, 6, 2);
                c1.a aVarC9 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), null, composerStartRestartGroup, 6, 2);
                aVarC6 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), null, composerStartRestartGroup, 6, 2);
                aVarC7 = c1.d.c(va.v.e("android.permission.CAMERA"), null, composerStartRestartGroup, 6, 2);
                if (Build.VERSION.SDK_INT >= 33) {
                    listN3 = va.v.e("android.permission.POST_NOTIFICATIONS");
                } else {
                    listN3 = va.w.n();
                }
                aVarC8 = c1.d.c(listN3, null, composerStartRestartGroup, 0, 2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1727paddingVpY3zN4$default(modifier2, Dp.m8823constructorimpl(20), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Modifier modifier4 = modifier2;
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
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                list3 = listN;
                aVar2 = aVarC9;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.required_permissions, composerStartRestartGroup, 0), null, 0L, 0, 0, composerStartRestartGroup, 0, 61);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), composerStartRestartGroup, 6);
                if (list3.isEmpty()) {
                    list4 = list3;
                } else {
                    list4 = list3;
                    if (list4.contains(PermissionNeedIt.CONTACT)) {
                        composerStartRestartGroup.startReplaceGroup(-1454723744);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableState2 = mutableState;
                    }
                    if (!list4.isEmpty() || list4.contains(PermissionNeedIt.STORAGE)) {
                        composerStartRestartGroup.startReplaceGroup(-1708851957);
                        final MutableState mutableState4 = mutableState2;
                        aVar3 = aVarC3;
                        mutableState3 = mutableState4;
                        BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(95636092, true, new Function3() { // from class: cu.z17.views.permission.t0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$35(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1680438982, true, new Function3() { // from class: cu.z17.views.permission.u0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$38(aVar, aVarC3, z11, context, mutableState4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1454723744);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableState3 = mutableState2;
                        aVar3 = aVarC3;
                    }
                    if (!list4.isEmpty() || list4.contains(PermissionNeedIt.LOCATION)) {
                        composerStartRestartGroup.startReplaceGroup(-1708771178);
                        BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-944655747, true, new Function3() { // from class: cu.z17.views.permission.v0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$41(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1574236475, true, new Function3() { // from class: cu.z17.views.permission.w0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$44(aVarC4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1454723744);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (!list4.isEmpty() || list4.contains(PermissionNeedIt.READ_SMS)) {
                        composerStartRestartGroup.startReplaceGroup(-1708726772);
                        BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1984947586, true, new Function3() { // from class: cu.z17.views.permission.x0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$47(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(533944636, true, new Function3() { // from class: cu.z17.views.permission.y0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$50(aVarC5, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1454723744);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (!list4.isEmpty() || list4.contains(PermissionNeedIt.CALLS)) {
                        composerStartRestartGroup.startReplaceGroup(-1708682914);
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1269727871, true, new Function3() { // from class: cu.z17.views.permission.z0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$53(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-506347203, true, new Function3() { // from class: cu.z17.views.permission.a1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$56(aVar2, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        aVar2 = aVar2;
                        BadgeKt.BadgedBox(composableLambdaRememberComposableLambda, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 390, 2);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1454723744);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (!list4.isEmpty() || list4.contains(PermissionNeedIt.RECORD_AUDIO)) {
                        composerStartRestartGroup.startReplaceGroup(-1708639189);
                        BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(229436032, true, new Function3() { // from class: cu.z17.views.permission.i0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$59(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1546639042, true, new Function3() { // from class: cu.z17.views.permission.j0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$62(aVarC6, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1454723744);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (!list4.isEmpty() || list4.contains(PermissionNeedIt.CAMERA)) {
                        composerStartRestartGroup.startReplaceGroup(-1708595253);
                        BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-810855807, true, new Function3() { // from class: cu.z17.views.permission.k0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$65(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1708036415, true, new Function3() { // from class: cu.z17.views.permission.l0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$68(aVarC7, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1454723744);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (!list4.isEmpty() || list4.contains(PermissionNeedIt.NOTIFICATIONS)) {
                        composerStartRestartGroup.startReplaceGroup(-1708550713);
                        aVar4 = aVarC8;
                        BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1851147646, true, new Function3() { // from class: cu.z17.views.permission.m0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$71(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(667744576, true, new Function3() { // from class: cu.z17.views.permission.n0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$74(aVar4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1454723744);
                        composerStartRestartGroup.endReplaceGroup();
                        aVar4 = aVarC8;
                    }
                    boolean zZ17PermissionContainer$lambda$25 = Z17PermissionContainer$lambda$25(mutableState3);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.o0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$76$lambda$75(mutableState3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    lb.a aVar8 = (lb.a) objRememberedValue2;
                    if ((57344 & i14) == 16384) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChangedInstance = z12 | composerStartRestartGroup.changedInstance(context);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.z17.views.permission.p0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$79$lambda$78(context, packageName);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Z17DialogsKt.Z17DialogWithActions(zZ17PermissionContainer$lambda$25, aVar8, (lb.a) objRememberedValue3, null, StringResources_androidKt.stringResource(R.string.dialog_title, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.dialog_desc, composerStartRestartGroup, 0), null, null, composerStartRestartGroup, 48, 200);
                    composerStartRestartGroup.endNode();
                    Object[] objArr = {Boolean.valueOf(aVar.a()), Boolean.valueOf(z11), Boolean.valueOf(aVar3.a()), Boolean.valueOf(aVarC.a()), Boolean.valueOf(r38.a()), Boolean.valueOf(aVarC5.a()), Boolean.valueOf(aVar2.a()), Boolean.valueOf(r40.a()), Boolean.valueOf(aVarC7.a())};
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(list4) | composerStartRestartGroup.changed(aVarC);
                    aVar5 = aVar;
                    aVar6 = aVar3;
                    z13 = z11;
                    aVar7 = aVar2;
                    boolean zChanged = zChangedInstance2 | composerStartRestartGroup.changed(aVar5) | composerStartRestartGroup.changed(aVar6) | composerStartRestartGroup.changed(z13) | composerStartRestartGroup.changed(aVarC4) | composerStartRestartGroup.changed(aVarC5) | composerStartRestartGroup.changed(aVar7) | composerStartRestartGroup.changed(aVarC6) | composerStartRestartGroup.changed(aVarC7) | composerStartRestartGroup.changed(aVar4);
                    if ((i14 & 112) == 32) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    z15 = z14 | zChanged | ((i14 & 7168) == 2048);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z15 || objRememberedValue4 == companion.getEmpty()) {
                        composer2 = composerStartRestartGroup;
                        List<? extends PermissionNeedIt> list5 = list4;
                        Z17PermissionRequesterKt$Z17PermissionContainer$2$1 z17PermissionRequesterKt$Z17PermissionContainer$2$1 = new Z17PermissionRequesterKt$Z17PermissionContainer$2$1(list5, aVar5, z13, aVar6, aVarC, aVarC4, aVarC5, aVar7, aVarC6, aVarC7, aVar4, actualResult, onResult, null);
                        list4 = list5;
                        composer2.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionContainer$2$1);
                        objRememberedValue4 = z17PermissionRequesterKt$Z17PermissionContainer$2$1;
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    EffectsKt.LaunchedEffect(objArr, (Function2) objRememberedValue4, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    list2 = list4;
                    modifier3 = modifier4;
                }
                composerStartRestartGroup.startReplaceGroup(-1708897296);
                mutableState2 = mutableState;
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(1710124997, true, new Function3() { // from class: cu.z17.views.permission.h0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$29(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1397864957, true, new Function3() { // from class: cu.z17.views.permission.s0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$32(aVarC, mutableState2, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708851957);
                    final MutableState mutableState5 = mutableState2;
                    aVar3 = aVarC3;
                    mutableState3 = mutableState5;
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(95636092, true, new Function3() { // from class: cu.z17.views.permission.t0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$35(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1680438982, true, new Function3() { // from class: cu.z17.views.permission.u0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$38(aVar, aVarC3, z11, context, mutableState5, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708851957);
                    final MutableState mutableState6 = mutableState2;
                    aVar3 = aVarC3;
                    mutableState3 = mutableState6;
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(95636092, true, new Function3() { // from class: cu.z17.views.permission.t0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$35(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1680438982, true, new Function3() { // from class: cu.z17.views.permission.u0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$38(aVar, aVarC3, z11, context, mutableState6, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708771178);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-944655747, true, new Function3() { // from class: cu.z17.views.permission.v0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$41(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1574236475, true, new Function3() { // from class: cu.z17.views.permission.w0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$44(aVarC4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708771178);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-944655747, true, new Function3() { // from class: cu.z17.views.permission.v0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$41(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1574236475, true, new Function3() { // from class: cu.z17.views.permission.w0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$44(aVarC4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708726772);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1984947586, true, new Function3() { // from class: cu.z17.views.permission.x0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$47(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(533944636, true, new Function3() { // from class: cu.z17.views.permission.y0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$50(aVarC5, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708726772);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1984947586, true, new Function3() { // from class: cu.z17.views.permission.x0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$47(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(533944636, true, new Function3() { // from class: cu.z17.views.permission.y0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$50(aVarC5, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708682914);
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(1269727871, true, new Function3() { // from class: cu.z17.views.permission.z0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$53(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-506347203, true, new Function3() { // from class: cu.z17.views.permission.a1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$56(aVar2, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    aVar2 = aVar2;
                    BadgeKt.BadgedBox(composableLambdaRememberComposableLambda3, null, composableLambdaRememberComposableLambda4, composerStartRestartGroup, 390, 2);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708682914);
                    ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(1269727871, true, new Function3() { // from class: cu.z17.views.permission.z0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$53(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-506347203, true, new Function3() { // from class: cu.z17.views.permission.a1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$56(aVar2, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    aVar2 = aVar2;
                    BadgeKt.BadgedBox(composableLambdaRememberComposableLambda5, null, composableLambdaRememberComposableLambda6, composerStartRestartGroup, 390, 2);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708639189);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(229436032, true, new Function3() { // from class: cu.z17.views.permission.i0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$59(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1546639042, true, new Function3() { // from class: cu.z17.views.permission.j0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$62(aVarC6, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708639189);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(229436032, true, new Function3() { // from class: cu.z17.views.permission.i0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$59(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1546639042, true, new Function3() { // from class: cu.z17.views.permission.j0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$62(aVarC6, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708595253);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-810855807, true, new Function3() { // from class: cu.z17.views.permission.k0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$65(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1708036415, true, new Function3() { // from class: cu.z17.views.permission.l0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$68(aVarC7, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708595253);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-810855807, true, new Function3() { // from class: cu.z17.views.permission.k0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$65(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1708036415, true, new Function3() { // from class: cu.z17.views.permission.l0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$68(aVarC7, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708550713);
                    aVar4 = aVarC8;
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1851147646, true, new Function3() { // from class: cu.z17.views.permission.m0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$71(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(667744576, true, new Function3() { // from class: cu.z17.views.permission.n0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$74(aVar4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708550713);
                    aVar4 = aVarC8;
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1851147646, true, new Function3() { // from class: cu.z17.views.permission.m0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$71(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(667744576, true, new Function3() { // from class: cu.z17.views.permission.n0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$74(aVar4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                }
                boolean zZ17PermissionContainer$lambda$26 = Z17PermissionContainer$lambda$25(mutableState3);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.o0
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$76$lambda$75(mutableState3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar9 = (lb.a) objRememberedValue2;
                if ((57344 & i14) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChangedInstance = z12 | composerStartRestartGroup.changedInstance(context);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.permission.p0
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$79$lambda$78(context, packageName);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.permission.p0
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$79$lambda$78(context, packageName);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Z17DialogsKt.Z17DialogWithActions(zZ17PermissionContainer$lambda$26, aVar9, (lb.a) objRememberedValue3, null, StringResources_androidKt.stringResource(R.string.dialog_title, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.dialog_desc, composerStartRestartGroup, 0), null, null, composerStartRestartGroup, 48, 200);
                composerStartRestartGroup.endNode();
                Object[] objArr2 = {Boolean.valueOf(aVar.a()), Boolean.valueOf(z11), Boolean.valueOf(aVar3.a()), Boolean.valueOf(aVarC.a()), Boolean.valueOf(r38.a()), Boolean.valueOf(aVarC5.a()), Boolean.valueOf(aVar2.a()), Boolean.valueOf(r40.a()), Boolean.valueOf(aVarC7.a())};
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(list4) | composerStartRestartGroup.changed(aVarC);
                aVar5 = aVar;
                aVar6 = aVar3;
                z13 = z11;
                aVar7 = aVar2;
                boolean zChanged2 = zChangedInstance3 | composerStartRestartGroup.changed(aVar5) | composerStartRestartGroup.changed(aVar6) | composerStartRestartGroup.changed(z13) | composerStartRestartGroup.changed(aVarC4) | composerStartRestartGroup.changed(aVarC5) | composerStartRestartGroup.changed(aVar7) | composerStartRestartGroup.changed(aVarC6) | composerStartRestartGroup.changed(aVarC7) | composerStartRestartGroup.changed(aVar4);
                if ((i14 & 112) == 32) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                z15 = z14 | zChanged2 | ((i14 & 7168) == 2048);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    composer2 = composerStartRestartGroup;
                    List<? extends PermissionNeedIt> list6 = list4;
                    Z17PermissionRequesterKt$Z17PermissionContainer$2$1 z17PermissionRequesterKt$Z17PermissionContainer$2$2 = new Z17PermissionRequesterKt$Z17PermissionContainer$2$1(list6, aVar5, z13, aVar6, aVarC, aVarC4, aVarC5, aVar7, aVarC6, aVarC7, aVar4, actualResult, onResult, null);
                    list4 = list6;
                    composer2.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionContainer$2$2);
                    objRememberedValue4 = z17PermissionRequesterKt$Z17PermissionContainer$2$2;
                } else {
                    composer2 = composerStartRestartGroup;
                    List<? extends PermissionNeedIt> list7 = list4;
                    Z17PermissionRequesterKt$Z17PermissionContainer$2$1 z17PermissionRequesterKt$Z17PermissionContainer$2$3 = new Z17PermissionRequesterKt$Z17PermissionContainer$2$1(list7, aVar5, z13, aVar6, aVarC, aVarC4, aVarC5, aVar7, aVarC6, aVarC7, aVar4, actualResult, onResult, null);
                    list4 = list7;
                    composer2.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionContainer$2$3);
                    objRememberedValue4 = z17PermissionRequesterKt$Z17PermissionContainer$2$3;
                }
                EffectsKt.LaunchedEffect(objArr2, (Function2) objRememberedValue4, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                list2 = list4;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                list2 = listN;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.r0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$82(modifier3, actualResult, list2, onResult, packageName, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        listN = list;
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onResult)) {
                i16 = 2048;
            } else {
                i16 = 1024;
            }
            i12 |= i16;
        }
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changed(packageName)) {
                i15 = 16384;
            } else {
                i15 = 8192;
            }
            i12 |= i15;
        }
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            if (i17 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i18 != 0) {
                listN = va.w.n();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-516241236, i12, -1, "cu.z17.views.permission.Z17PermissionContainer (Z17PermissionRequester.kt:470)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            aVarC = c1.d.c(va.v.e("android.permission.READ_CONTACTS"), null, composerStartRestartGroup, 6, 2);
            i13 = Build.VERSION.SDK_INT;
            i14 = i12;
            if (i13 <= 30) {
                listN2 = va.w.q("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
            } else {
                listN2 = va.w.n();
            }
            aVarC2 = c1.d.c(listN2, null, composerStartRestartGroup, 0, 2);
            if (i13 >= 33) {
                listE = va.v.e("android.permission.READ_MEDIA_IMAGES");
            } else {
                listE = va.v.e("android.permission.READ_EXTERNAL_STORAGE");
            }
            aVarC3 = c1.d.c(listE, null, composerStartRestartGroup, 0, 2);
            if (i13 >= 30) {
                zIsExternalStorageManager = Environment.isExternalStorageManager();
                z11 = zIsExternalStorageManager;
                aVar = aVarC2;
            } else {
                aVar = aVarC2;
                z11 = true;
            }
            aVarC4 = c1.d.c(va.w.q("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), null, composerStartRestartGroup, 6, 2);
            aVarC5 = c1.d.c(va.w.q("android.permission.READ_SMS", "android.permission.RECEIVE_SMS"), null, composerStartRestartGroup, 6, 2);
            c1.a aVarC10 = c1.d.c(va.v.e("android.permission.CALL_PHONE"), null, composerStartRestartGroup, 6, 2);
            aVarC6 = c1.d.c(va.v.e("android.permission.RECORD_AUDIO"), null, composerStartRestartGroup, 6, 2);
            aVarC7 = c1.d.c(va.v.e("android.permission.CAMERA"), null, composerStartRestartGroup, 6, 2);
            if (Build.VERSION.SDK_INT >= 33) {
                listN3 = va.v.e("android.permission.POST_NOTIFICATIONS");
            } else {
                listN3 = va.w.n();
            }
            aVarC8 = c1.d.c(listN3, null, composerStartRestartGroup, 0, 2);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(PaddingKt.m1727paddingVpY3zN4$default(modifier2, Dp.m8823constructorimpl(20), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Modifier modifier5 = modifier2;
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
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            list3 = listN;
            aVar2 = aVarC10;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.required_permissions, composerStartRestartGroup, 0), null, 0L, 0, 0, composerStartRestartGroup, 0, 61);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), composerStartRestartGroup, 6);
            if (list3.isEmpty()) {
                list4 = list3;
                if (list4.contains(PermissionNeedIt.CONTACT)) {
                    composerStartRestartGroup.startReplaceGroup(-1454723744);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableState2 = mutableState;
                }
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708851957);
                    final MutableState mutableState7 = mutableState2;
                    aVar3 = aVarC3;
                    mutableState3 = mutableState7;
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(95636092, true, new Function3() { // from class: cu.z17.views.permission.t0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$35(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1680438982, true, new Function3() { // from class: cu.z17.views.permission.u0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$38(aVar, aVarC3, z11, context, mutableState7, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708851957);
                    final MutableState mutableState8 = mutableState2;
                    aVar3 = aVarC3;
                    mutableState3 = mutableState8;
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(95636092, true, new Function3() { // from class: cu.z17.views.permission.t0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$35(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1680438982, true, new Function3() { // from class: cu.z17.views.permission.u0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$38(aVar, aVarC3, z11, context, mutableState8, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708771178);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-944655747, true, new Function3() { // from class: cu.z17.views.permission.v0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$41(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1574236475, true, new Function3() { // from class: cu.z17.views.permission.w0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$44(aVarC4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708771178);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-944655747, true, new Function3() { // from class: cu.z17.views.permission.v0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$41(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1574236475, true, new Function3() { // from class: cu.z17.views.permission.w0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$44(aVarC4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708726772);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1984947586, true, new Function3() { // from class: cu.z17.views.permission.x0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$47(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(533944636, true, new Function3() { // from class: cu.z17.views.permission.y0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$50(aVarC5, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708726772);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1984947586, true, new Function3() { // from class: cu.z17.views.permission.x0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$47(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(533944636, true, new Function3() { // from class: cu.z17.views.permission.y0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$50(aVarC5, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708682914);
                    ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(1269727871, true, new Function3() { // from class: cu.z17.views.permission.z0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$53(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-506347203, true, new Function3() { // from class: cu.z17.views.permission.a1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$56(aVar2, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    aVar2 = aVar2;
                    BadgeKt.BadgedBox(composableLambdaRememberComposableLambda7, null, composableLambdaRememberComposableLambda8, composerStartRestartGroup, 390, 2);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708682914);
                    ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(1269727871, true, new Function3() { // from class: cu.z17.views.permission.z0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$53(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(-506347203, true, new Function3() { // from class: cu.z17.views.permission.a1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$56(aVar2, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    aVar2 = aVar2;
                    BadgeKt.BadgedBox(composableLambdaRememberComposableLambda9, null, composableLambdaRememberComposableLambda10, composerStartRestartGroup, 390, 2);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708639189);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(229436032, true, new Function3() { // from class: cu.z17.views.permission.i0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$59(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1546639042, true, new Function3() { // from class: cu.z17.views.permission.j0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$62(aVarC6, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708639189);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(229436032, true, new Function3() { // from class: cu.z17.views.permission.i0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$59(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1546639042, true, new Function3() { // from class: cu.z17.views.permission.j0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$62(aVarC6, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708595253);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-810855807, true, new Function3() { // from class: cu.z17.views.permission.k0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$65(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1708036415, true, new Function3() { // from class: cu.z17.views.permission.l0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$68(aVarC7, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708595253);
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-810855807, true, new Function3() { // from class: cu.z17.views.permission.k0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$65(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1708036415, true, new Function3() { // from class: cu.z17.views.permission.l0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$68(aVarC7, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (list4.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1708550713);
                    aVar4 = aVarC8;
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1851147646, true, new Function3() { // from class: cu.z17.views.permission.m0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$71(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(667744576, true, new Function3() { // from class: cu.z17.views.permission.n0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$74(aVar4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1708550713);
                    aVar4 = aVarC8;
                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1851147646, true, new Function3() { // from class: cu.z17.views.permission.m0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$71(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(667744576, true, new Function3() { // from class: cu.z17.views.permission.n0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$74(aVar4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                    composerStartRestartGroup.endReplaceGroup();
                }
                boolean zZ17PermissionContainer$lambda$27 = Z17PermissionContainer$lambda$25(mutableState3);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.o0
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$76$lambda$75(mutableState3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar10 = (lb.a) objRememberedValue2;
                if ((57344 & i14) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChangedInstance = z12 | composerStartRestartGroup.changedInstance(context);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.permission.p0
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$79$lambda$78(context, packageName);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.permission.p0
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$79$lambda$78(context, packageName);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Z17DialogsKt.Z17DialogWithActions(zZ17PermissionContainer$lambda$27, aVar10, (lb.a) objRememberedValue3, null, StringResources_androidKt.stringResource(R.string.dialog_title, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.dialog_desc, composerStartRestartGroup, 0), null, null, composerStartRestartGroup, 48, 200);
                composerStartRestartGroup.endNode();
                Object[] objArr3 = {Boolean.valueOf(aVar.a()), Boolean.valueOf(z11), Boolean.valueOf(aVar3.a()), Boolean.valueOf(aVarC.a()), Boolean.valueOf(r38.a()), Boolean.valueOf(aVarC5.a()), Boolean.valueOf(aVar2.a()), Boolean.valueOf(r40.a()), Boolean.valueOf(aVarC7.a())};
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(list4) | composerStartRestartGroup.changed(aVarC);
                aVar5 = aVar;
                aVar6 = aVar3;
                z13 = z11;
                aVar7 = aVar2;
                boolean zChanged3 = zChangedInstance4 | composerStartRestartGroup.changed(aVar5) | composerStartRestartGroup.changed(aVar6) | composerStartRestartGroup.changed(z13) | composerStartRestartGroup.changed(aVarC4) | composerStartRestartGroup.changed(aVarC5) | composerStartRestartGroup.changed(aVar7) | composerStartRestartGroup.changed(aVarC6) | composerStartRestartGroup.changed(aVarC7) | composerStartRestartGroup.changed(aVar4);
                if ((i14 & 112) == 32) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                z15 = z14 | zChanged3 | ((i14 & 7168) == 2048);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    composer2 = composerStartRestartGroup;
                    List<? extends PermissionNeedIt> list8 = list4;
                    Z17PermissionRequesterKt$Z17PermissionContainer$2$1 z17PermissionRequesterKt$Z17PermissionContainer$2$4 = new Z17PermissionRequesterKt$Z17PermissionContainer$2$1(list8, aVar5, z13, aVar6, aVarC, aVarC4, aVarC5, aVar7, aVarC6, aVarC7, aVar4, actualResult, onResult, null);
                    list4 = list8;
                    composer2.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionContainer$2$4);
                    objRememberedValue4 = z17PermissionRequesterKt$Z17PermissionContainer$2$4;
                } else {
                    composer2 = composerStartRestartGroup;
                    List<? extends PermissionNeedIt> list9 = list4;
                    Z17PermissionRequesterKt$Z17PermissionContainer$2$1 z17PermissionRequesterKt$Z17PermissionContainer$2$5 = new Z17PermissionRequesterKt$Z17PermissionContainer$2$1(list9, aVar5, z13, aVar6, aVarC, aVarC4, aVarC5, aVar7, aVarC6, aVarC7, aVar4, actualResult, onResult, null);
                    list4 = list9;
                    composer2.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionContainer$2$5);
                    objRememberedValue4 = z17PermissionRequesterKt$Z17PermissionContainer$2$5;
                }
                EffectsKt.LaunchedEffect(objArr3, (Function2) objRememberedValue4, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                list2 = list4;
                modifier3 = modifier5;
            } else {
                list4 = list3;
            }
            composerStartRestartGroup.startReplaceGroup(-1708897296);
            mutableState2 = mutableState;
            BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(1710124997, true, new Function3() { // from class: cu.z17.views.permission.h0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$29(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1397864957, true, new Function3() { // from class: cu.z17.views.permission.s0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$32(aVarC, mutableState2, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
            composerStartRestartGroup.endReplaceGroup();
            if (list4.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1708851957);
                final MutableState mutableState9 = mutableState2;
                aVar3 = aVarC3;
                mutableState3 = mutableState9;
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(95636092, true, new Function3() { // from class: cu.z17.views.permission.t0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$35(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1680438982, true, new Function3() { // from class: cu.z17.views.permission.u0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$38(aVar, aVarC3, z11, context, mutableState9, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1708851957);
                final MutableState mutableState10 = mutableState2;
                aVar3 = aVarC3;
                mutableState3 = mutableState10;
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(95636092, true, new Function3() { // from class: cu.z17.views.permission.t0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$35(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1680438982, true, new Function3() { // from class: cu.z17.views.permission.u0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$38(aVar, aVarC3, z11, context, mutableState10, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (list4.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1708771178);
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-944655747, true, new Function3() { // from class: cu.z17.views.permission.v0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$41(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1574236475, true, new Function3() { // from class: cu.z17.views.permission.w0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$44(aVarC4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1708771178);
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-944655747, true, new Function3() { // from class: cu.z17.views.permission.v0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$41(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1574236475, true, new Function3() { // from class: cu.z17.views.permission.w0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$44(aVarC4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (list4.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1708726772);
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1984947586, true, new Function3() { // from class: cu.z17.views.permission.x0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$47(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(533944636, true, new Function3() { // from class: cu.z17.views.permission.y0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$50(aVarC5, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1708726772);
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1984947586, true, new Function3() { // from class: cu.z17.views.permission.x0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$47(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(533944636, true, new Function3() { // from class: cu.z17.views.permission.y0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$50(aVarC5, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (list4.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1708682914);
                ComposableLambda composableLambdaRememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(1269727871, true, new Function3() { // from class: cu.z17.views.permission.z0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$53(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(-506347203, true, new Function3() { // from class: cu.z17.views.permission.a1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$56(aVar2, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                aVar2 = aVar2;
                BadgeKt.BadgedBox(composableLambdaRememberComposableLambda11, null, composableLambdaRememberComposableLambda12, composerStartRestartGroup, 390, 2);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1708682914);
                ComposableLambda composableLambdaRememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(1269727871, true, new Function3() { // from class: cu.z17.views.permission.z0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$53(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(-506347203, true, new Function3() { // from class: cu.z17.views.permission.a1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$56(aVar2, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                aVar2 = aVar2;
                BadgeKt.BadgedBox(composableLambdaRememberComposableLambda13, null, composableLambdaRememberComposableLambda14, composerStartRestartGroup, 390, 2);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (list4.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1708639189);
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(229436032, true, new Function3() { // from class: cu.z17.views.permission.i0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$59(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1546639042, true, new Function3() { // from class: cu.z17.views.permission.j0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$62(aVarC6, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1708639189);
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(229436032, true, new Function3() { // from class: cu.z17.views.permission.i0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$59(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1546639042, true, new Function3() { // from class: cu.z17.views.permission.j0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$62(aVarC6, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (list4.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1708595253);
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-810855807, true, new Function3() { // from class: cu.z17.views.permission.k0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$65(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1708036415, true, new Function3() { // from class: cu.z17.views.permission.l0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$68(aVarC7, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1708595253);
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-810855807, true, new Function3() { // from class: cu.z17.views.permission.k0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$65(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1708036415, true, new Function3() { // from class: cu.z17.views.permission.l0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$68(aVarC7, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (list4.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1708550713);
                aVar4 = aVarC8;
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1851147646, true, new Function3() { // from class: cu.z17.views.permission.m0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$71(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(667744576, true, new Function3() { // from class: cu.z17.views.permission.n0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$74(aVar4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1708550713);
                aVar4 = aVarC8;
                BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(-1851147646, true, new Function3() { // from class: cu.z17.views.permission.m0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$71(list4, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(667744576, true, new Function3() { // from class: cu.z17.views.permission.n0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$74(aVar4, mutableState3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
                composerStartRestartGroup.endReplaceGroup();
            }
            boolean zZ17PermissionContainer$lambda$28 = Z17PermissionContainer$lambda$25(mutableState3);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.z17.views.permission.o0
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$76$lambda$75(mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar11 = (lb.a) objRememberedValue2;
            if ((57344 & i14) == 16384) {
                z12 = true;
            } else {
                z12 = false;
            }
            zChangedInstance = z12 | composerStartRestartGroup.changedInstance(context);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue3 = new lb.a() { // from class: cu.z17.views.permission.p0
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$79$lambda$78(context, packageName);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new lb.a() { // from class: cu.z17.views.permission.p0
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$79$lambda$78(context, packageName);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Z17DialogsKt.Z17DialogWithActions(zZ17PermissionContainer$lambda$28, aVar11, (lb.a) objRememberedValue3, null, StringResources_androidKt.stringResource(R.string.dialog_title, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.dialog_desc, composerStartRestartGroup, 0), null, null, composerStartRestartGroup, 48, 200);
            composerStartRestartGroup.endNode();
            Object[] objArr4 = {Boolean.valueOf(aVar.a()), Boolean.valueOf(z11), Boolean.valueOf(aVar3.a()), Boolean.valueOf(aVarC.a()), Boolean.valueOf(r38.a()), Boolean.valueOf(aVarC5.a()), Boolean.valueOf(aVar2.a()), Boolean.valueOf(r40.a()), Boolean.valueOf(aVarC7.a())};
            boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(list4) | composerStartRestartGroup.changed(aVarC);
            aVar5 = aVar;
            aVar6 = aVar3;
            z13 = z11;
            aVar7 = aVar2;
            boolean zChanged4 = zChangedInstance5 | composerStartRestartGroup.changed(aVar5) | composerStartRestartGroup.changed(aVar6) | composerStartRestartGroup.changed(z13) | composerStartRestartGroup.changed(aVarC4) | composerStartRestartGroup.changed(aVarC5) | composerStartRestartGroup.changed(aVar7) | composerStartRestartGroup.changed(aVarC6) | composerStartRestartGroup.changed(aVarC7) | composerStartRestartGroup.changed(aVar4);
            if ((i14 & 112) == 32) {
                z14 = true;
            } else {
                z14 = false;
            }
            z15 = z14 | zChanged4 | ((i14 & 7168) == 2048);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z15) {
                composer2 = composerStartRestartGroup;
                List<? extends PermissionNeedIt> list10 = list4;
                Z17PermissionRequesterKt$Z17PermissionContainer$2$1 z17PermissionRequesterKt$Z17PermissionContainer$2$6 = new Z17PermissionRequesterKt$Z17PermissionContainer$2$1(list10, aVar5, z13, aVar6, aVarC, aVarC4, aVarC5, aVar7, aVarC6, aVarC7, aVar4, actualResult, onResult, null);
                list4 = list10;
                composer2.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionContainer$2$6);
                objRememberedValue4 = z17PermissionRequesterKt$Z17PermissionContainer$2$6;
            } else {
                composer2 = composerStartRestartGroup;
                List<? extends PermissionNeedIt> list11 = list4;
                Z17PermissionRequesterKt$Z17PermissionContainer$2$1 z17PermissionRequesterKt$Z17PermissionContainer$2$7 = new Z17PermissionRequesterKt$Z17PermissionContainer$2$1(list11, aVar5, z13, aVar6, aVarC, aVarC4, aVarC5, aVar7, aVarC6, aVarC7, aVar4, actualResult, onResult, null);
                list4 = list11;
                composer2.updateRememberedValue(z17PermissionRequesterKt$Z17PermissionContainer$2$7);
                objRememberedValue4 = z17PermissionRequesterKt$Z17PermissionContainer$2$7;
            }
            EffectsKt.LaunchedEffect(objArr4, (Function2) objRememberedValue4, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            list2 = list4;
            modifier3 = modifier5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            list2 = listN;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$82(modifier3, actualResult, list2, onResult, packageName, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean Z17PermissionContainer$lambda$25(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Z17PermissionContainer$lambda$26(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$29(List list, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1710124997, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:573)");
            }
            if (list.contains(PermissionNeedIt.CONTACT)) {
                composer.startReplaceGroup(-1542349255);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.permission.q0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$29$lambda$28$lambda$27((DrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(modifierM1769size3ABfNKs, (Function1) objRememberedValue, composer, 54);
            } else {
                composer.startReplaceGroup(-586773379);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$29$lambda$28$lambda$27(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.z(Canvas, Color.INSTANCE.m5900getRed0d7_KjU(), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$32(final c1.a aVar, final MutableState mutableState, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1397864957, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:578)");
            }
            boolean zA = aVar.a();
            String strStringResource = StringResources_androidKt.stringResource(R.string.contacts, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.permission.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$32$lambda$31$lambda$30(aVar, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PermissionButton(null, zA, (Function1) objRememberedValue, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.m10273getLambda$856282252$views_release(), strStringResource, null, composer, 3072, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$32$lambda$31$lambda$30(c1.a aVar, MutableState mutableState, boolean z10) {
        if (z10) {
            if (aVar.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar.b();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$35(List list, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(95636092, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:605)");
            }
            if (list.contains(PermissionNeedIt.STORAGE)) {
                composer.startReplaceGroup(1711974192);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.permission.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$35$lambda$34$lambda$33((DrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(modifierM1769size3ABfNKs, (Function1) objRememberedValue, composer, 54);
            } else {
                composer.startReplaceGroup(1511636710);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$35$lambda$34$lambda$33(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.z(Canvas, Color.INSTANCE.m5900getRed0d7_KjU(), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$38(final c1.a aVar, final c1.a aVar2, boolean z10, final Context context, final MutableState mutableState, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1680438982, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:610)");
            }
            boolean z11 = aVar.a() && aVar2.a() && z10;
            String strStringResource = StringResources_androidKt.stringResource(R.string.storage, composer, 0);
            boolean zChanged = composer.changed(aVar) | composer.changed(aVar2) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.permission.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$38$lambda$37$lambda$36(aVar, aVar2, context, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PermissionButton(null, z11, (Function1) objRememberedValue, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.m10274getLambda$910502293$views_release(), strStringResource, null, composer, 3072, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$38$lambda$37$lambda$36(c1.a aVar, c1.a aVar2, Context context, MutableState mutableState, boolean z10) {
        if (z10) {
            if (aVar.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar.b();
            }
            if (aVar2.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar2.b();
            }
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    if (!Environment.isExternalStorageManager()) {
                        Intent intent = new Intent();
                        intent.setAction("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                        ContextCompat.startActivity(context, intent, null);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$41(List list, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-944655747, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:656)");
            }
            if (list.contains(PermissionNeedIt.LOCATION)) {
                composer.startReplaceGroup(-1576070383);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.permission.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$41$lambda$40$lambda$39((DrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(modifierM1769size3ABfNKs, (Function1) objRememberedValue, composer, 54);
            } else {
                composer.startReplaceGroup(-1636038811);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$41$lambda$40$lambda$39(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.z(Canvas, Color.INSTANCE.m5900getRed0d7_KjU(), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$44(final c1.a aVar, final MutableState mutableState, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1574236475, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:661)");
            }
            boolean zA = aVar.a();
            String strStringResource = StringResources_androidKt.stringResource(R.string.location, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.permission.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$44$lambda$43$lambda$42(aVar, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PermissionButton(null, zA, (Function1) objRememberedValue, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.m10270getLambda$1950794132$views_release(), strStringResource, null, composer, 3072, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$44$lambda$43$lambda$42(c1.a aVar, MutableState mutableState, boolean z10) {
        if (z10) {
            if (aVar.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar.b();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$47(List list, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1984947586, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:688)");
            }
            if (list.contains(PermissionNeedIt.READ_SMS)) {
                composer.startReplaceGroup(-569147694);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.permission.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$47$lambda$46$lambda$45((DrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(modifierM1769size3ABfNKs, (Function1) objRememberedValue, composer, 54);
            } else {
                composer.startReplaceGroup(-487583420);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$47$lambda$46$lambda$45(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.z(Canvas, Color.INSTANCE.m5900getRed0d7_KjU(), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$50(final c1.a aVar, final MutableState mutableState, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(533944636, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:693)");
            }
            boolean zA = aVar.a();
            String strStringResource = StringResources_androidKt.stringResource(R.string.read_sms, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.permission.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$50$lambda$49$lambda$48(aVar, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PermissionButton(null, zA, (Function1) objRememberedValue, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.getLambda$1303881325$views_release(), strStringResource, null, composer, 3072, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$50$lambda$49$lambda$48(c1.a aVar, MutableState mutableState, boolean z10) {
        if (z10) {
            if (aVar.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar.b();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$53(List list, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1269727871, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:720)");
            }
            if (list.contains(PermissionNeedIt.CALLS)) {
                composer.startReplaceGroup(437774899);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.permission.c0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$53$lambda$52$lambda$51((DrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(modifierM1769size3ABfNKs, (Function1) objRememberedValue, composer, 54);
            } else {
                composer.startReplaceGroup(660888835);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$53$lambda$52$lambda$51(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.z(Canvas, Color.INSTANCE.m5900getRed0d7_KjU(), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$56(final c1.a aVar, final MutableState mutableState, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-506347203, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:725)");
            }
            boolean zA = aVar.a();
            String strStringResource = StringResources_androidKt.stringResource(R.string.calls, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.permission.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$56$lambda$55$lambda$54(aVar, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PermissionButton(null, zA, (Function1) objRememberedValue, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.getLambda$263589486$views_release(), strStringResource, null, composer, 3072, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$56$lambda$55$lambda$54(c1.a aVar, MutableState mutableState, boolean z10) {
        if (z10) {
            if (aVar.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar.b();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$59(List list, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(229436032, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:752)");
            }
            if (list.contains(PermissionNeedIt.RECORD_AUDIO)) {
                composer.startReplaceGroup(1444697812);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.permission.v
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$59$lambda$58$lambda$57((DrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(modifierM1769size3ABfNKs, (Function1) objRememberedValue, composer, 54);
            } else {
                composer.startReplaceGroup(1809366050);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$59$lambda$58$lambda$57(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.z(Canvas, Color.INSTANCE.m5900getRed0d7_KjU(), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$62(final c1.a aVar, final MutableState mutableState, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1546639042, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:757)");
            }
            boolean zA = aVar.a();
            String strStringResource = StringResources_androidKt.stringResource(R.string.record, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.permission.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$62$lambda$61$lambda$60(aVar, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PermissionButton(null, zA, (Function1) objRememberedValue, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.m10272getLambda$776702353$views_release(), strStringResource, null, composer, 3072, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$62$lambda$61$lambda$60(c1.a aVar, MutableState mutableState, boolean z10) {
        if (z10) {
            if (aVar.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar.b();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$65(List list, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-810855807, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:784)");
            }
            if (list.contains(PermissionNeedIt.CAMERA)) {
                composer.startReplaceGroup(-1843346987);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.permission.w
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$65$lambda$64$lambda$63((DrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(modifierM1769size3ABfNKs, (Function1) objRememberedValue, composer, 54);
            } else {
                composer.startReplaceGroup(-1337130975);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$65$lambda$64$lambda$63(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.z(Canvas, Color.INSTANCE.m5900getRed0d7_KjU(), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$68(final c1.a aVar, final MutableState mutableState, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1708036415, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:789)");
            }
            boolean zA = aVar.a();
            String strStringResource = StringResources_androidKt.stringResource(R.string.camera, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.permission.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$68$lambda$67$lambda$66(aVar, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PermissionButton(null, zA, (Function1) objRememberedValue, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.m10269getLambda$1816994192$views_release(), strStringResource, null, composer, 3072, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$68$lambda$67$lambda$66(c1.a aVar, MutableState mutableState, boolean z10) {
        if (z10) {
            if (aVar.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar.b();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$71(List list, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1851147646, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:816)");
            }
            if (list.contains(PermissionNeedIt.NOTIFICATIONS)) {
                composer.startReplaceGroup(-836424074);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8));
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.z17.views.permission.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$71$lambda$70$lambda$69((DrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(modifierM1769size3ABfNKs, (Function1) objRememberedValue, composer, 54);
            } else {
                composer.startReplaceGroup(-188674592);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$71$lambda$70$lambda$69(DrawScope Canvas) {
        kotlin.jvm.internal.y.i(Canvas, "$this$Canvas");
        DrawScope.CC.z(Canvas, Color.INSTANCE.m5900getRed0d7_KjU(), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$74(final c1.a aVar, final MutableState mutableState, BoxScope BadgedBox, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(BadgedBox, "$this$BadgedBox");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(667744576, i10, -1, "cu.z17.views.permission.Z17PermissionContainer.<anonymous>.<anonymous> (Z17PermissionRequester.kt:821)");
            }
            boolean zA = Build.VERSION.SDK_INT >= 33 ? aVar.a() : true;
            String strStringResource = StringResources_androidKt.stringResource(R.string.notifications, composer, 0);
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.z17.views.permission.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionContainer$lambda$80$lambda$74$lambda$73$lambda$72(aVar, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            PermissionButton(null, zA, (Function1) objRememberedValue, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.getLambda$1437681265$views_release(), strStringResource, null, composer, 3072, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$74$lambda$73$lambda$72(c1.a aVar, MutableState mutableState, boolean z10) {
        if (z10) {
            if (aVar.c()) {
                Z17PermissionContainer$lambda$26(mutableState, true);
            } else {
                aVar.b();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$76$lambda$75(MutableState mutableState) {
        Z17PermissionContainer$lambda$26(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$80$lambda$79$lambda$78(Context context, String str) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", str, null));
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        context.startActivity(intent);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionContainer$lambda$82(Modifier modifier, PermissionsResult permissionsResult, List list, Function1 function1, String str, int i10, int i11, Composer composer, int i12) {
        Z17PermissionContainer(modifier, permissionsResult, list, function1, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17PermissionRequester(final PermissionsRequesterState permissionState, final lb.a onClose, final Function1 onResult, final String packageName, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(permissionState, "permissionState");
        kotlin.jvm.internal.y.i(onClose, "onClose");
        kotlin.jvm.internal.y.i(onResult, "onResult");
        kotlin.jvm.internal.y.i(packageName, "packageName");
        Composer composerStartRestartGroup = composer.startRestartGroup(-445802902);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(permissionState) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onResult) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(packageName) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-445802902, i11, -1, "cu.z17.views.permission.Z17PermissionRequester (Z17PermissionRequester.kt:429)");
            }
            Z17DialogsKt.Z17CustomDialog(permissionState.getOpen(), onClose, ComposableLambdaKt.rememberComposableLambda(-1024797384, true, new Function3() { // from class: cu.z17.views.permission.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17PermissionRequesterKt.Z17PermissionRequester$lambda$22(onClose, permissionState, onResult, packageName, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.permission.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PermissionRequesterKt.Z17PermissionRequester$lambda$23(permissionState, onClose, onResult, packageName, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 Z17PermissionRequester$lambda$22(final lb.a aVar, PermissionsRequesterState permissionsRequesterState, final Function1 function1, String str, lb.a it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1024797384, i10, -1, "cu.z17.views.permission.Z17PermissionRequester.<anonymous> (Z17PermissionRequester.kt:434)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.permission.y
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17PermissionRequesterKt.Z17PermissionRequester$lambda$22$lambda$21$lambda$18$lambda$17(aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, columnScopeInstance.align(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(20), 0.0f, 2, null), companion2.getEnd()), false, null, null, ComposableSingletons$Z17PermissionRequesterKt.INSTANCE.m10271getLambda$354748021$views_release(), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            PermissionsResult permissionsResult = permissionsRequesterState.getPermissionsResult();
            List<PermissionNeedIt> permissions = permissionsRequesterState.getPermissions();
            boolean zChanged2 = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.z17.views.permission.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17PermissionRequesterKt.Z17PermissionRequester$lambda$22$lambda$21$lambda$20$lambda$19(function1, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Z17PermissionContainer(null, permissionsResult, permissions, (Function1) objRememberedValue2, str, composer, 0, 1);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionRequester$lambda$22$lambda$21$lambda$18$lambda$17(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionRequester$lambda$22$lambda$21$lambda$20$lambda$19(Function1 function1, PermissionsResult it) {
        kotlin.jvm.internal.y.i(it, "it");
        function1.invoke(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17PermissionRequester$lambda$23(PermissionsRequesterState permissionsRequesterState, lb.a aVar, Function1 function1, String str, int i10, Composer composer, int i11) {
        Z17PermissionRequester(permissionsRequesterState, aVar, function1, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
