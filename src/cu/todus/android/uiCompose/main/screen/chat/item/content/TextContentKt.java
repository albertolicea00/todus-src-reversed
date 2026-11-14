package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.utils.TextUtilsKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17ClickableLabelClickType;
import cu.z17.views.label.Z17ClickableLabelKt;
import cu.z17.views.label.Z17MarkdownLabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a{\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\b\b\u0002\u0010\n\u001a\u00020\u00062\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0004H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0011²\u0006\u000e\u0010\u0010\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002"}, d2 = {"", "msgContent", "Landroidx/compose/ui/graphics/Color;", "color", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "maxPossibleLines", "onMsgEntityClick", "TextContent-OadGlvw", "(Ljava/lang/String;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextContent", "", "fullSize", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TextContentKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Z17ClickableLabelClickType.values().length];
            try {
                iArr[Z17ClickableLabelClickType.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Z17ClickableLabelClickType.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Z17ClickableLabelClickType.TAG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Z17ClickableLabelClickType.MENTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Z17ClickableLabelClickType.COMMAND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:110:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:140:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:141:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:144:0x0318  */
    /* JADX WARN: Code duplicated, block: B:145:0x031b  */
    /* JADX WARN: Code duplicated, block: B:148:0x0322  */
    /* JADX WARN: Code duplicated, block: B:150:0x0328  */
    /* JADX WARN: Code duplicated, block: B:154:0x0339  */
    /* JADX WARN: Code duplicated, block: B:157:0x0341  */
    /* JADX WARN: Code duplicated, block: B:161:0x034b  */
    /* JADX WARN: Code duplicated, block: B:165:0x036c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0382  */
    /* JADX WARN: Code duplicated, block: B:169:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:172:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:174:0x03be  */
    /* JADX WARN: Code duplicated, block: B:177:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x008b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0096  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:83:0x010d  */
    /* JADX WARN: Code duplicated, block: B:86:0x011a  */
    /* JADX WARN: Code duplicated, block: B:89:0x0152  */
    /* JADX WARN: Code duplicated, block: B:92:0x015e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0162  */
    /* JADX WARN: Code duplicated, block: B:96:0x019e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: TextContent-OadGlvw, reason: not valid java name */
    public static final void m9893TextContentOadGlvw(final String msgContent, long j10, final Function2 onClick, final Function2 onLongClick, int i10, Function2 function2, Composer composer, final int i11, final int i12) {
        int i13;
        long j11;
        int i14;
        int i15;
        Function2 function3;
        int i16;
        boolean z10;
        final Function2 function4;
        final long j12;
        final Function2 function5;
        final int i17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long onBackground;
        final Function2 function6;
        int i18;
        Object objRememberedValue;
        int i19;
        Modifier.Companion companion;
        lb.a constructor;
        Object objRememberedValue2;
        Composer.Companion companion2;
        MutableState mutableState;
        MutableState mutableState2;
        int i20;
        Function2 function7;
        Composer composer2;
        int i21;
        float fM8823constructorimpl;
        boolean z11;
        Object objRememberedValue3;
        boolean z12;
        Object objRememberedValue4;
        Object objRememberedValue5;
        boolean z13;
        kotlin.jvm.internal.y.i(msgContent, "msgContent");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1578350524);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(msgContent) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            j11 = j10;
            i13 |= ((i12 & 2) == 0 && composerStartRestartGroup.changed(j11)) ? 32 : 16;
        } else {
            j11 = j10;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onLongClick) ? 2048 : 1024;
        }
        int i22 = i12 & 16;
        if (i22 == 0) {
            if ((i11 & 24576) == 0) {
                i14 = i10;
                i13 |= composerStartRestartGroup.changed(i14) ? 16384 : 8192;
            }
            i15 = i12 & 32;
            if (i15 != 0) {
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3 = function2;
            } else {
                function3 = function2;
                if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i13 |= i16;
                }
            }
            if ((i13 & 74899) != 74898) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i12 & 2) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -113;
                    } else {
                        onBackground = j11;
                    }
                    if (i22 != 0) {
                        i14 = 16;
                    }
                    if (i15 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.l2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TextContentKt.TextContent_OadGlvw$lambda$0$0((MessageAction) obj, (String) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function6 = (Function2) objRememberedValue;
                    } else {
                        function6 = function3;
                    }
                    i18 = i13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i12 & 2) != 0) {
                        i13 &= -113;
                    }
                    i18 = i13;
                    onBackground = j11;
                    function6 = function3;
                }
                i19 = i14;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1578350524, i18, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.TextContent (TextContent.kt:32)");
                }
                companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (objRememberedValue2 == companion2.getEmpty()) {
                    if (msgContent.length() >= i19 * 40 || le.d0.y0(msgContent).size() < i19) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z13), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                if (!TextUtilsKt.hasHtml(msgContent) || TextUtilsKt.hasLatex(msgContent) || TextUtilsKt.hasMarkdown(msgContent)) {
                    mutableState2 = mutableState;
                    i20 = i19;
                    function7 = function6;
                    composer2 = composerStartRestartGroup;
                    i21 = 0;
                    composer2.startReplaceGroup(1871477487);
                    float fM8823constructorimpl2 = Dp.m8823constructorimpl(0);
                    if (TextContent_OadGlvw$lambda$1$1(mutableState2)) {
                        fM8823constructorimpl = Dp.INSTANCE.m8843getUnspecifiedD9Ej5fM();
                    } else {
                        fM8823constructorimpl = Dp.m8823constructorimpl(250);
                    }
                    Modifier modifierM1756heightInVpY3zN4 = SizeKt.m1756heightInVpY3zN4(companion, fM8823constructorimpl2, fM8823constructorimpl);
                    TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), onBackground, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                    if ((i18 & 896) == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue3 = composer2.rememberedValue();
                    if (z11 || objRememberedValue3 == companion2.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.m2
                            @Override // lb.a
                            public final Object invoke() {
                                return TextContentKt.TextContent_OadGlvw$lambda$1$3$0(onClick);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    lb.a aVar = (lb.a) objRememberedValue3;
                    z12 = (i18 & 7168) == 2048;
                    objRememberedValue4 = composer2.rememberedValue();
                    if (!z12 || objRememberedValue4 == companion2.getEmpty()) {
                        function4 = onLongClick;
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.n2
                            @Override // lb.a
                            public final Object invoke() {
                                return TextContentKt.TextContent_OadGlvw$lambda$1$4$0(function4);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        function4 = onLongClick;
                    }
                    Z17MarkdownLabelKt.Z17MarkdownLabel(modifierM1756heightInVpY3zN4, msgContent, textStyleM8271copyp1EtxEg$default, aVar, (lb.a) objRememberedValue4, composer2, (i18 << 3) & 112, 0);
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1872099719);
                    TextStyle textStyleM8271copyp1EtxEg$default2 = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), onBackground, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                    int i23 = TextContent_OadGlvw$lambda$1$1(mutableState) ? Integer.MAX_VALUE : 12;
                    boolean z14 = ((458752 & i18) == 131072) | ((i18 & 896) == 256);
                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z14 || objRememberedValue6 == companion2.getEmpty()) {
                        objRememberedValue6 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.o2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextContentKt.TextContent_OadGlvw$lambda$1$5$0(function6, onClick, (Z17ClickableLabelClickType) obj, (String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function2 function8 = (Function2) objRememberedValue6;
                    z12 = (i18 & 7168) == 2048;
                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (z12 || objRememberedValue7 == companion2.getEmpty()) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.p2
                            @Override // lb.a
                            public final Object invoke() {
                                return TextContentKt.TextContent_OadGlvw$lambda$1$6$0(onLongClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    i20 = i19;
                    composer2 = composerStartRestartGroup;
                    function7 = function6;
                    mutableState2 = mutableState;
                    i21 = 0;
                    Z17ClickableLabelKt.m10257Z17ClickableLabel0nDMI0(null, textStyleM8271copyp1EtxEg$default2, msgContent, function8, (lb.a) objRememberedValue7, i23, 0, 0L, 0L, composer2, (i18 << 6) & 896, 449);
                    composer2.endReplaceGroup();
                    function4 = onLongClick;
                }
                if (TextContent_OadGlvw$lambda$1$1(mutableState2)) {
                    composerStartRestartGroup = composer2;
                    composerStartRestartGroup.startReplaceGroup(1873741076);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1873519085);
                    String strStringResource = StringResources_androidKt.stringResource(R.string.show_more, composer2, i21);
                    objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == companion2.getEmpty()) {
                        final MutableState mutableState3 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.q2
                            @Override // lb.a
                            public final Object invoke() {
                                return TextContentKt.TextContent_OadGlvw$lambda$1$7$0(mutableState3);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup = composer2;
                    Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue5, strStringResource, null, false, true, false, composerStartRestartGroup, 196656, 89);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i17 = i20;
                j12 = onBackground;
                function5 = function7;
            } else {
                function4 = onLongClick;
                composerStartRestartGroup.skipToGroupEnd();
                j12 = j11;
                function5 = function3;
                i17 = i14;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function2 function9 = function4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.r2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextContentKt.TextContent_OadGlvw$lambda$2(msgContent, j12, onClick, function9, i17, function5, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        i14 = i10;
        i15 = i12 & 32;
        if (i15 != 0) {
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function2;
        } else {
            function3 = function2;
            if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 131072;
                } else {
                    i16 = 65536;
                }
                i13 |= i16;
            }
        }
        if ((i13 & 74899) != 74898) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) != 0) {
                if ((i12 & 2) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i13 &= -113;
                } else {
                    onBackground = j11;
                }
                if (i22 != 0) {
                    i14 = 16;
                }
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.l2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextContentKt.TextContent_OadGlvw$lambda$0$0((MessageAction) obj, (String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function6 = (Function2) objRememberedValue;
                } else {
                    function6 = function3;
                }
                i18 = i13;
            } else {
                if ((i12 & 2) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i13 &= -113;
                } else {
                    onBackground = j11;
                }
                if (i22 != 0) {
                    i14 = 16;
                }
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.l2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextContentKt.TextContent_OadGlvw$lambda$0$0((MessageAction) obj, (String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function6 = (Function2) objRememberedValue;
                } else {
                    function6 = function3;
                }
                i18 = i13;
            }
            i19 = i14;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1578350524, i18, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.TextContent (TextContent.kt:32)");
            }
            companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion2 = Composer.INSTANCE;
            if (objRememberedValue2 == companion2.getEmpty()) {
                if (msgContent.length() >= i19 * 40) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z13), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            if (TextUtilsKt.hasHtml(msgContent)) {
                mutableState2 = mutableState;
                i20 = i19;
                function7 = function6;
                composer2 = composerStartRestartGroup;
                i21 = 0;
                composer2.startReplaceGroup(1871477487);
                float fM8823constructorimpl3 = Dp.m8823constructorimpl(0);
                if (TextContent_OadGlvw$lambda$1$1(mutableState2)) {
                    fM8823constructorimpl = Dp.INSTANCE.m8843getUnspecifiedD9Ej5fM();
                } else {
                    fM8823constructorimpl = Dp.m8823constructorimpl(250);
                }
                Modifier modifierM1756heightInVpY3zN5 = SizeKt.m1756heightInVpY3zN4(companion, fM8823constructorimpl3, fM8823constructorimpl);
                TextStyle textStyleM8271copyp1EtxEg$default3 = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), onBackground, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                if ((i18 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue3 = composer2.rememberedValue();
                if (z11) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.m2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$3$0(onClick);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.m2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$3$0(onClick);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                lb.a aVar2 = (lb.a) objRememberedValue3;
                if ((i18 & 7168) == 2048) {
                }
                objRememberedValue4 = composer2.rememberedValue();
                if (z12) {
                    function4 = onLongClick;
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.n2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$4$0(function4);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    function4 = onLongClick;
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.n2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$4$0(function4);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                Z17MarkdownLabelKt.Z17MarkdownLabel(modifierM1756heightInVpY3zN5, msgContent, textStyleM8271copyp1EtxEg$default3, aVar2, (lb.a) objRememberedValue4, composer2, (i18 << 3) & 112, 0);
                composer2.endReplaceGroup();
            } else {
                mutableState2 = mutableState;
                i20 = i19;
                function7 = function6;
                composer2 = composerStartRestartGroup;
                i21 = 0;
                composer2.startReplaceGroup(1871477487);
                float fM8823constructorimpl4 = Dp.m8823constructorimpl(0);
                if (TextContent_OadGlvw$lambda$1$1(mutableState2)) {
                    fM8823constructorimpl = Dp.INSTANCE.m8843getUnspecifiedD9Ej5fM();
                } else {
                    fM8823constructorimpl = Dp.m8823constructorimpl(250);
                }
                Modifier modifierM1756heightInVpY3zN6 = SizeKt.m1756heightInVpY3zN4(companion, fM8823constructorimpl4, fM8823constructorimpl);
                TextStyle textStyleM8271copyp1EtxEg$default4 = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), onBackground, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                if ((i18 & 896) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue3 = composer2.rememberedValue();
                if (z11) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.m2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$3$0(onClick);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.m2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$3$0(onClick);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                lb.a aVar3 = (lb.a) objRememberedValue3;
                if ((i18 & 7168) == 2048) {
                }
                objRememberedValue4 = composer2.rememberedValue();
                if (z12) {
                    function4 = onLongClick;
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.n2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$4$0(function4);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    function4 = onLongClick;
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.n2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$4$0(function4);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                Z17MarkdownLabelKt.Z17MarkdownLabel(modifierM1756heightInVpY3zN6, msgContent, textStyleM8271copyp1EtxEg$default4, aVar3, (lb.a) objRememberedValue4, composer2, (i18 << 3) & 112, 0);
                composer2.endReplaceGroup();
            }
            if (TextContent_OadGlvw$lambda$1$1(mutableState2)) {
                composer2.startReplaceGroup(1873519085);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.show_more, composer2, i21);
                objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == companion2.getEmpty()) {
                    final MutableState mutableState4 = mutableState2;
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.q2
                        @Override // lb.a
                        public final Object invoke() {
                            return TextContentKt.TextContent_OadGlvw$lambda$1$7$0(mutableState4);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup = composer2;
                Z17ButtonsKt.Z17PrimaryDialogButton(null, (lb.a) objRememberedValue5, strStringResource2, null, false, true, false, composerStartRestartGroup, 196656, 89);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup = composer2;
                composerStartRestartGroup.startReplaceGroup(1873741076);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i17 = i20;
            j12 = onBackground;
            function5 = function7;
        } else {
            function4 = onLongClick;
            composerStartRestartGroup.skipToGroupEnd();
            j12 = j11;
            function5 = function3;
            i17 = i14;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2 function10 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.r2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextContentKt.TextContent_OadGlvw$lambda$2(msgContent, j12, onClick, function10, i17, function5, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TextContent_OadGlvw$lambda$0$0(MessageAction messageAction, String str) {
        kotlin.jvm.internal.y.i(messageAction, "<unused var>");
        kotlin.jvm.internal.y.i(str, "<unused var>");
        return ua.k0.f43947a;
    }

    private static final boolean TextContent_OadGlvw$lambda$1$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TextContent_OadGlvw$lambda$1$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TextContent_OadGlvw$lambda$1$3$0(Function2 function2) {
        function2.invoke(MessageAction.REGULAR_CLICK, 0);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TextContent_OadGlvw$lambda$1$4$0(Function2 function2) {
        function2.invoke(MessageAction.REGULAR_LONG_CLICK, 0);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TextContent_OadGlvw$lambda$1$5$0(Function2 function2, Function2 function3, Z17ClickableLabelClickType type, String value) {
        kotlin.jvm.internal.y.i(type, "type");
        kotlin.jvm.internal.y.i(value, "value");
        int i10 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i10 == 1) {
            function2.invoke(MessageAction.LINK_CLICK, value);
        } else if (i10 == 2) {
            function2.invoke(MessageAction.NUMBER_CLICK, value);
        } else if (i10 == 3) {
            function2.invoke(MessageAction.TAG_CLICK, value);
        } else if (i10 == 4) {
            function2.invoke(MessageAction.MENTION_CLICK, value);
        } else if (i10 != 5) {
            function3.invoke(MessageAction.REGULAR_CLICK, 0);
        } else {
            function2.invoke(MessageAction.COMMAND_CLICK, value);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TextContent_OadGlvw$lambda$1$6$0(Function2 function2) {
        function2.invoke(MessageAction.REGULAR_LONG_CLICK, 0);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TextContent_OadGlvw$lambda$1$7$0(MutableState mutableState) {
        TextContent_OadGlvw$lambda$1$2(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TextContent_OadGlvw$lambda$2(String str, long j10, Function2 function2, Function2 function3, int i10, Function2 function4, int i11, int i12, Composer composer, int i13) {
        m9893TextContentOadGlvw(str, j10, function2, function3, i10, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return ua.k0.f43947a;
    }
}
