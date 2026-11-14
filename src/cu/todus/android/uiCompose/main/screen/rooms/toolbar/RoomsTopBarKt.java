package cu.todus.android.uiCompose.main.screen.rooms.toolbar;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.ConnectionIndicatorKt;
import cu.todus.android.uiCompose.shared.callToolbar.CallToolbarKt;
import cu.todus.android.uiCompose.shared.inCallToolbar.InCallToolbarKt;
import cu.todus.android.uiCompose.shared.playerToolbar.PlayerToolbarKt;
import cu.todus.android.uiCompose.shared.refreshConnection.RefreshConnectionKt;
import cu.z17.singledi.SinglediException;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.xmlpull.v1.XmlPullParserException;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u001ag\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015²\u0006\u000e\u0010\u0013\u001a\u00020\u00128\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0014\u001a\u00020\u00008\n@\nX\u008a\u008e\u0002"}, d2 = {"", "isConnected", "", "avatarImage", "", "roomName", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "scrollBehavior", "Landroidx/navigation/NavHostController;", "navHostController", "updatingState", "Lkotlin/Function0;", "Lua/k0;", "menuClick", "unseenStatus", "isBigScreen", "RoomsTopBar", "(ZLjava/lang/Object;Ljava/lang/String;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/navigation/NavHostController;ZLlb/a;ZZLandroidx/compose/runtime/Composer;II)V", "", "actualMsg", "showActual", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RoomsTopBarKt {
    /* JADX WARN: Code duplicated, block: B:100:0x012b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0168  */
    /* JADX WARN: Code duplicated, block: B:106:0x0174  */
    /* JADX WARN: Code duplicated, block: B:107:0x0178  */
    /* JADX WARN: Code duplicated, block: B:110:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:119:0x0278  */
    /* JADX WARN: Code duplicated, block: B:122:0x0292  */
    /* JADX WARN: Code duplicated, block: B:124:0x029d  */
    /* JADX WARN: Code duplicated, block: B:127:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:42:0x008c  */
    /* JADX WARN: Code duplicated, block: B:43:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0099  */
    /* JADX WARN: Code duplicated, block: B:49:0x009f  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00da  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:82:0x0103  */
    /* JADX WARN: Code duplicated, block: B:83:0x0105  */
    /* JADX WARN: Code duplicated, block: B:86:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0110  */
    /* JADX WARN: Code duplicated, block: B:88:0x0112  */
    /* JADX WARN: Code duplicated, block: B:91:0x0116  */
    /* JADX WARN: Code duplicated, block: B:92:0x0119  */
    /* JADX WARN: Code duplicated, block: B:94:0x011d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0120  */
    /* JADX WARN: Code duplicated, block: B:97:0x0123  */
    @Composable
    public static final void RoomsTopBar(boolean z10, final Object avatarImage, final String roomName, TopAppBarScrollBehavior topAppBarScrollBehavior, final NavHostController navHostController, final boolean z11, final lb.a menuClick, boolean z12, boolean z13, Composer composer, final int i10, final int i11) throws XmlPullParserException, SinglediException, IOException {
        boolean z14;
        int i12;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        int i13;
        boolean z15;
        int i14;
        int i15;
        int i16;
        boolean z16;
        Composer composer2;
        final boolean z17;
        final boolean z18;
        final TopAppBarScrollBehavior topAppBarScrollBehavior3;
        final boolean z19;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z20;
        TopAppBarScrollBehavior topAppBarScrollBehavior4;
        boolean z21;
        lb.a constructor;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableIntState mutableIntState;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final MutableState mutableState;
        Object objRememberedValue4;
        int i17;
        int i18;
        int i19;
        y.i(avatarImage, "avatarImage");
        y.i(roomName, "roomName");
        y.i(navHostController, "navHostController");
        y.i(menuClick, "menuClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1564286678);
        int i20 = i11 & 1;
        if (i20 != 0) {
            i12 = i10 | 6;
            z14 = z10;
        } else if ((i10 & 6) == 0) {
            z14 = z10;
            i12 = (composerStartRestartGroup.changed(z14) ? 4 : 2) | i10;
        } else {
            z14 = z10;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(avatarImage) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(roomName) ? 256 : 128;
        }
        int i21 = i11 & 8;
        if (i21 == 0) {
            if ((i10 & 3072) == 0) {
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                i12 |= composerStartRestartGroup.changed(topAppBarScrollBehavior2) ? 2048 : 1024;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(navHostController)) {
                    i19 = 16384;
                } else {
                    i19 = 8192;
                }
                i12 |= i19;
            }
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changed(z11)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i12 |= i18;
            }
            if ((1572864 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(menuClick)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i12 |= i17;
            }
            i13 = i11 & 128;
            if (i13 != 0) {
                i12 |= 12582912;
                z15 = z12;
            } else {
                z15 = z12;
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z15)) {
                        i14 = 8388608;
                    } else {
                        i14 = 4194304;
                    }
                    i12 |= i14;
                }
            }
            i15 = i11 & 256;
            if (i15 != 0) {
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z13)) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                    i12 |= i16;
                }
                if ((i12 & 38347923) != 38347922) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                    if (i20 != 0) {
                        z20 = false;
                    } else {
                        z20 = z14;
                    }
                    if (i21 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i13 != 0) {
                        z15 = false;
                    }
                    if (i15 != 0) {
                        z21 = false;
                    } else {
                        z21 = z13;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1564286678, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsTopBar (RoomsTopBar.kt:66)");
                    }
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
                    Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = w.q(TypedValues.TransitionType.S_TO, "Esta");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final List list = (List) objRememberedValue2;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState = (MutableState) objRememberedValue3;
                    int i22 = i12;
                    final boolean z22 = z15;
                    final boolean z23 = z20;
                    composer2 = composerStartRestartGroup;
                    TopAppBarScrollBehavior topAppBarScrollBehavior5 = topAppBarScrollBehavior4;
                    Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(11881453, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RoomsTopBarKt.RoomsTopBar$lambda$0$7(navHostController, z22, mutableState, list, mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), topAppBarScrollBehavior5, false, ComposableLambdaKt.rememberComposableLambda(1762548248, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.p
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return RoomsTopBarKt.RoomsTopBar$lambda$0$8(z11, roomName, navHostController, avatarImage, z23, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), !z21, navHostController, menuClick, VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, R.drawable.menu, composerStartRestartGroup, 6), 0L, 0L, 0.0f, composer2, ((i22 >> 6) & 112) | 3078 | ((i22 << 3) & 458752) | (i22 & 3670016), 0, 1796);
                    PlayerToolbarKt.PlayerToolbar(composer2, 0);
                    InCallToolbarKt.InCallToolbar(null, composer2, 0, 1);
                    CallToolbarKt.CallToolbar(null, composer2, 0, 1);
                    RefreshConnectionKt.RefreshConnection(composer2, 0);
                    Integer numValueOf = Integer.valueOf(mutableIntState.getIntValue());
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new RoomsTopBarKt$RoomsTopBar$1$3$1(mutableState, mutableIntState, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    EffectsKt.LaunchedEffect(numValueOf, (Function2) objRememberedValue4, composer2, 0);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior5;
                    z19 = z21;
                    z18 = z23;
                    z17 = z22;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z17 = z15;
                    z18 = z14;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                    z19 = z13;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RoomsTopBarKt.RoomsTopBar$lambda$1(z18, avatarImage, roomName, topAppBarScrollBehavior3, navHostController, z11, menuClick, z17, z19, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 100663296;
            if ((i12 & 38347923) != 38347922) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                if (i20 != 0) {
                    z20 = false;
                } else {
                    z20 = z14;
                }
                if (i21 != 0) {
                    topAppBarScrollBehavior4 = null;
                } else {
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                }
                if (i13 != 0) {
                    z15 = false;
                }
                if (i15 != 0) {
                    z21 = false;
                } else {
                    z21 = z13;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1564286678, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsTopBar (RoomsTopBar.kt:66)");
                }
                Modifier.Companion companion4 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
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
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = w.q(TypedValues.TransitionType.S_TO, "Esta");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final List list2 = (List) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState = (MutableState) objRememberedValue3;
                int i23 = i12;
                final boolean z24 = z15;
                final boolean z25 = z20;
                composer2 = composerStartRestartGroup;
                TopAppBarScrollBehavior topAppBarScrollBehavior6 = topAppBarScrollBehavior4;
                Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(11881453, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RoomsTopBarKt.RoomsTopBar$lambda$0$7(navHostController, z24, mutableState, list2, mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), topAppBarScrollBehavior6, false, ComposableLambdaKt.rememberComposableLambda(1762548248, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return RoomsTopBarKt.RoomsTopBar$lambda$0$8(z11, roomName, navHostController, avatarImage, z25, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), !z21, navHostController, menuClick, VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, R.drawable.menu, composerStartRestartGroup, 6), 0L, 0L, 0.0f, composer2, ((i23 >> 6) & 112) | 3078 | ((i23 << 3) & 458752) | (i23 & 3670016), 0, 1796);
                PlayerToolbarKt.PlayerToolbar(composer2, 0);
                InCallToolbarKt.InCallToolbar(null, composer2, 0, 1);
                CallToolbarKt.CallToolbar(null, composer2, 0, 1);
                RefreshConnectionKt.RefreshConnection(composer2, 0);
                Integer numValueOf2 = Integer.valueOf(mutableIntState.getIntValue());
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new RoomsTopBarKt$RoomsTopBar$1$3$1(mutableState, mutableIntState, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                EffectsKt.LaunchedEffect(numValueOf2, (Function2) objRememberedValue4, composer2, 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                topAppBarScrollBehavior3 = topAppBarScrollBehavior6;
                z19 = z21;
                z18 = z25;
                z17 = z24;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z17 = z15;
                z18 = z14;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                z19 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RoomsTopBarKt.RoomsTopBar$lambda$1(z18, avatarImage, roomName, topAppBarScrollBehavior3, navHostController, z11, menuClick, z17, z19, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(navHostController)) {
                i19 = 16384;
            } else {
                i19 = 8192;
            }
            i12 |= i19;
        }
        if ((196608 & i10) == 0) {
            if (composerStartRestartGroup.changed(z11)) {
                i18 = 131072;
            } else {
                i18 = 65536;
            }
            i12 |= i18;
        }
        if ((1572864 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(menuClick)) {
                i17 = 1048576;
            } else {
                i17 = 524288;
            }
            i12 |= i17;
        }
        i13 = i11 & 128;
        if (i13 != 0) {
            i12 |= 12582912;
            z15 = z12;
        } else {
            z15 = z12;
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z15)) {
                    i14 = 8388608;
                } else {
                    i14 = 4194304;
                }
                i12 |= i14;
            }
        }
        i15 = i11 & 256;
        if (i15 != 0) {
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z13)) {
                    i16 = 67108864;
                } else {
                    i16 = 33554432;
                }
                i12 |= i16;
            }
            if ((i12 & 38347923) != 38347922) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                if (i20 != 0) {
                    z20 = false;
                } else {
                    z20 = z14;
                }
                if (i21 != 0) {
                    topAppBarScrollBehavior4 = null;
                } else {
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                }
                if (i13 != 0) {
                    z15 = false;
                }
                if (i15 != 0) {
                    z21 = false;
                } else {
                    z21 = z13;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1564286678, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsTopBar (RoomsTopBar.kt:66)");
                }
                Modifier.Companion companion6 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion6);
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
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy3, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion7.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion7.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion7.getSetModifier());
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = w.q(TypedValues.TransitionType.S_TO, "Esta");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final List list3 = (List) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState = (MutableState) objRememberedValue3;
                int i24 = i12;
                final boolean z26 = z15;
                final boolean z27 = z20;
                composer2 = composerStartRestartGroup;
                TopAppBarScrollBehavior topAppBarScrollBehavior7 = topAppBarScrollBehavior4;
                Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(11881453, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RoomsTopBarKt.RoomsTopBar$lambda$0$7(navHostController, z26, mutableState, list3, mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), topAppBarScrollBehavior7, false, ComposableLambdaKt.rememberComposableLambda(1762548248, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return RoomsTopBarKt.RoomsTopBar$lambda$0$8(z11, roomName, navHostController, avatarImage, z27, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), !z21, navHostController, menuClick, VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, R.drawable.menu, composerStartRestartGroup, 6), 0L, 0L, 0.0f, composer2, ((i24 >> 6) & 112) | 3078 | ((i24 << 3) & 458752) | (i24 & 3670016), 0, 1796);
                PlayerToolbarKt.PlayerToolbar(composer2, 0);
                InCallToolbarKt.InCallToolbar(null, composer2, 0, 1);
                CallToolbarKt.CallToolbar(null, composer2, 0, 1);
                RefreshConnectionKt.RefreshConnection(composer2, 0);
                Integer numValueOf3 = Integer.valueOf(mutableIntState.getIntValue());
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new RoomsTopBarKt$RoomsTopBar$1$3$1(mutableState, mutableIntState, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                EffectsKt.LaunchedEffect(numValueOf3, (Function2) objRememberedValue4, composer2, 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                topAppBarScrollBehavior3 = topAppBarScrollBehavior7;
                z19 = z21;
                z18 = z27;
                z17 = z26;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z17 = z15;
                z18 = z14;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                z19 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RoomsTopBarKt.RoomsTopBar$lambda$1(z18, avatarImage, roomName, topAppBarScrollBehavior3, navHostController, z11, menuClick, z17, z19, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 100663296;
        if ((i12 & 38347923) != 38347922) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
            if (i20 != 0) {
                z20 = false;
            } else {
                z20 = z14;
            }
            if (i21 != 0) {
                topAppBarScrollBehavior4 = null;
            } else {
                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
            }
            if (i13 != 0) {
                z15 = false;
            }
            if (i15 != 0) {
                z21 = false;
            } else {
                z21 = z13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1564286678, i12, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsTopBar (RoomsTopBar.kt:66)");
            }
            Modifier.Companion companion8 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion8);
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
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy4, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion9.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion9.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion9.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion9.getSetModifier());
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableIntState = (MutableIntState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = w.q(TypedValues.TransitionType.S_TO, "Esta");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final List list4 = (List) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState = (MutableState) objRememberedValue3;
            int i25 = i12;
            final boolean z28 = z15;
            final boolean z29 = z20;
            composer2 = composerStartRestartGroup;
            TopAppBarScrollBehavior topAppBarScrollBehavior8 = topAppBarScrollBehavior4;
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(11881453, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RoomsTopBarKt.RoomsTopBar$lambda$0$7(navHostController, z28, mutableState, list4, mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), topAppBarScrollBehavior8, false, ComposableLambdaKt.rememberComposableLambda(1762548248, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RoomsTopBarKt.RoomsTopBar$lambda$0$8(z11, roomName, navHostController, avatarImage, z29, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), !z21, navHostController, menuClick, VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, R.drawable.menu, composerStartRestartGroup, 6), 0L, 0L, 0.0f, composer2, ((i25 >> 6) & 112) | 3078 | ((i25 << 3) & 458752) | (i25 & 3670016), 0, 1796);
            PlayerToolbarKt.PlayerToolbar(composer2, 0);
            InCallToolbarKt.InCallToolbar(null, composer2, 0, 1);
            CallToolbarKt.CallToolbar(null, composer2, 0, 1);
            RefreshConnectionKt.RefreshConnection(composer2, 0);
            Integer numValueOf4 = Integer.valueOf(mutableIntState.getIntValue());
            objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new RoomsTopBarKt$RoomsTopBar$1$3$1(mutableState, mutableIntState, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(numValueOf4, (Function2) objRememberedValue4, composer2, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            topAppBarScrollBehavior3 = topAppBarScrollBehavior8;
            z19 = z21;
            z18 = z29;
            z17 = z28;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z17 = z15;
            z18 = z14;
            topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
            z19 = z13;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RoomsTopBarKt.RoomsTopBar$lambda$1(z18, avatarImage, roomName, topAppBarScrollBehavior3, navHostController, z11, menuClick, z17, z19, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean RoomsTopBar$lambda$0$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RoomsTopBar$lambda$0$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 RoomsTopBar$lambda$0$7(final NavHostController navHostController, boolean z10, MutableState mutableState, final List list, final MutableIntState mutableIntState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(11881453, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsTopBar.<anonymous>.<anonymous> (RoomsTopBar.kt:85)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 3;
            Modifier modifierClip = ClipKt.clip(companion, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.m
                    @Override // lb.a
                    public final Object invoke() {
                        return RoomsTopBarKt.RoomsTopBar$lambda$0$7$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierClip, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composer, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z10, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$RoomsTopBarKt.INSTANCE.getLambda$471693865$app_productionPFast(), composer, 1572870, 30);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(5)), composer, 6);
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, RoomsTopBar$lambda$0$5(mutableState), (Modifier) null, EnterExitTransitionKt.expandHorizontally$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), EnterExitTransitionKt.shrinkHorizontally$default(AnimationSpecKt.tween$default(XMPPTCPConnection.PacketWriter.QUEUE_SIZE, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(XMPPTCPConnection.PacketWriter.QUEUE_SIZE, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1304063840, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RoomsTopBarKt.RoomsTopBar$lambda$0$7$1$0(list, mutableIntState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 18);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "Dus", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getTitleLarge(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, FontFamilyKt.FontFamily(FontKt.m8352FontYpTlLL0$default(R.font.dosis_semibold, null, 0, 0, 14, null)), null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777179, null), materialTheme.getColorScheme(composer, i11).getPrimary(), 0, 0, composer, 48, 49);
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
    public static final k0 RoomsTopBar$lambda$0$7$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.STATUS_LIST, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 RoomsTopBar$lambda$0$7$1$0(List list, MutableIntState mutableIntState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1304063840, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RoomsTopBar.kt:118)");
        }
        String str = (String) list.get(mutableIntState.getIntValue());
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getTitleLarge(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, FontFamilyKt.FontFamily(FontKt.m8352FontYpTlLL0$default(R.font.dosis_semibold, null, 0, 0, 14, null)), null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777179, null), materialTheme.getColorScheme(composer, i11).getPrimary(), 0, 0, composer, 0, 49);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 RoomsTopBar$lambda$0$8(boolean z10, String str, final NavHostController navHostController, Object obj, boolean z11, RowScope Z17TopBar, Composer composer, int i10) {
        Composer composer2 = composer;
        y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer2.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1762548248, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsTopBar.<anonymous>.<anonymous> (RoomsTopBar.kt:148)");
            }
            if (z10) {
                composer2.startReplaceGroup(1591753706);
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20)), 0.0f, 0.0f, Dp.m8823constructorimpl(5), 0.0f, 11, null), 0.0f, 0.0f, 0L, composer, 6, 14);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(2099895690);
                composer2.endReplaceGroup();
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 15, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(10));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getBottomEnd(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierClip = ClipKt.clip(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(40)), RoundedCornerShapeKt.getCircleShape());
            boolean zChangedInstance = composer2.changedInstance(navHostController);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.r
                    @Override // lb.a
                    public final Object invoke() {
                        return RoomsTopBarKt.RoomsTopBar$lambda$0$8$0$0$0(navHostController);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierClip, false, null, null, null, (lb.a) objRememberedValue, 15, null), obj, Integer.valueOf(R.drawable.profile), null, null, 0, null, false, null, null, false, 0, composer, 0, 0, 4088);
            ConnectionIndicatorKt.ConnectingStateIndicator(z11, composer, 0);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomsTopBar$lambda$0$8$0$0$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.SETTING, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomsTopBar$lambda$1(boolean z10, Object obj, String str, TopAppBarScrollBehavior topAppBarScrollBehavior, NavHostController navHostController, boolean z11, lb.a aVar, boolean z12, boolean z13, int i10, int i11, Composer composer, int i12) throws XmlPullParserException, SinglediException, IOException {
        RoomsTopBar(z10, obj, str, topAppBarScrollBehavior, navHostController, z11, aVar, z12, z13, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
