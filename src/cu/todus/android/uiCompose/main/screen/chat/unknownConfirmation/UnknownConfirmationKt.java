package cu.todus.android.uiCompose.main.screen.chat.unknownConfirmation;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MenuKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.chat.unknownConfirmation.UnknownConfirmationKt;
import cu.todus.android.uiCompose.shared.animations.attach.AttachContainerKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ae\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "visible", "", "type", "Lkotlin/Function0;", "Lua/k0;", "onOk", "onDismiss", "onShare", "onRejected", "UnknownConfirmation", "(Landroidx/compose/ui/Modifier;ZILlb/a;Llb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UnknownConfirmationKt {
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:83:0x0102  */
    /* JADX WARN: Code duplicated, block: B:86:0x0109  */
    /* JADX WARN: Code duplicated, block: B:89:0x013d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0144  */
    /* JADX WARN: Code duplicated, block: B:95:0x0150  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void UnknownConfirmation(Modifier modifier, final boolean z10, final int i10, final a onOk, final a onDismiss, a aVar, a aVar2, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        a aVar3;
        int i14;
        a aVar4;
        int i15;
        boolean z11;
        final a aVar5;
        final a aVar6;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final a aVar7;
        final a aVar8;
        Object objRememberedValue;
        Object objRememberedValue2;
        y.i(onOk, "onOk");
        y.i(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(1934516322);
        int i16 = i12 & 1;
        if (i16 != 0) {
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
            i13 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onOk) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onDismiss) ? 16384 : 8192;
        }
        int i17 = i12 & 32;
        if (i17 == 0) {
            if ((196608 & i11) == 0) {
                aVar3 = aVar;
                i13 |= composerStartRestartGroup.changedInstance(aVar3) ? 131072 : 65536;
            }
            i14 = i12 & 64;
            if (i14 != 0) {
                if ((1572864 & i11) == 0) {
                    aVar4 = aVar2;
                    if (composerStartRestartGroup.changedInstance(aVar4)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i13 |= i15;
                }
                if ((599187 & i13) != 599186) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i17 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new a() { // from class: v7.a
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar7 = (a) objRememberedValue2;
                    } else {
                        aVar7 = aVar3;
                    }
                    if (i14 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: v7.b
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar8 = (a) objRememberedValue;
                    } else {
                        aVar8 = aVar4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1934516322, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.unknownConfirmation.UnknownConfirmation (UnknownConfirmation.kt:30)");
                    }
                    AttachContainerKt.AttachContainer(modifier2, z10, onDismiss, true, false, ComposableLambdaKt.rememberComposableLambda(1752861454, true, new Function2() { // from class: v7.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return UnknownConfirmationKt.UnknownConfirmation$lambda$2(i10, aVar8, onOk, aVar7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 224256 | (i13 & 112) | ((i13 >> 6) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar5 = aVar7;
                    aVar6 = aVar8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    aVar5 = aVar3;
                    aVar6 = aVar4;
                }
                modifier3 = modifier2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: v7.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return UnknownConfirmationKt.UnknownConfirmation$lambda$3(modifier3, z10, i10, onOk, onDismiss, aVar5, aVar6, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 1572864;
            aVar4 = aVar2;
            if ((599187 & i13) != 599186) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i17 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new a() { // from class: v7.a
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar7 = (a) objRememberedValue2;
                } else {
                    aVar7 = aVar3;
                }
                if (i14 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: v7.b
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar8 = (a) objRememberedValue;
                } else {
                    aVar8 = aVar4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1934516322, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.unknownConfirmation.UnknownConfirmation (UnknownConfirmation.kt:30)");
                }
                AttachContainerKt.AttachContainer(modifier2, z10, onDismiss, true, false, ComposableLambdaKt.rememberComposableLambda(1752861454, true, new Function2() { // from class: v7.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return UnknownConfirmationKt.UnknownConfirmation$lambda$2(i10, aVar8, onOk, aVar7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 224256 | (i13 & 112) | ((i13 >> 6) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar5 = aVar7;
                aVar6 = aVar8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                aVar5 = aVar3;
                aVar6 = aVar4;
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: v7.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return UnknownConfirmationKt.UnknownConfirmation$lambda$3(modifier3, z10, i10, onOk, onDismiss, aVar5, aVar6, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        aVar3 = aVar;
        i14 = i12 & 64;
        if (i14 != 0) {
            if ((1572864 & i11) == 0) {
                aVar4 = aVar2;
                if (composerStartRestartGroup.changedInstance(aVar4)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i13 |= i15;
            }
            if ((599187 & i13) != 599186) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i17 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new a() { // from class: v7.a
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar7 = (a) objRememberedValue2;
                } else {
                    aVar7 = aVar3;
                }
                if (i14 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: v7.b
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar8 = (a) objRememberedValue;
                } else {
                    aVar8 = aVar4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1934516322, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.unknownConfirmation.UnknownConfirmation (UnknownConfirmation.kt:30)");
                }
                AttachContainerKt.AttachContainer(modifier2, z10, onDismiss, true, false, ComposableLambdaKt.rememberComposableLambda(1752861454, true, new Function2() { // from class: v7.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return UnknownConfirmationKt.UnknownConfirmation$lambda$2(i10, aVar8, onOk, aVar7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 224256 | (i13 & 112) | ((i13 >> 6) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar5 = aVar7;
                aVar6 = aVar8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                aVar5 = aVar3;
                aVar6 = aVar4;
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: v7.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return UnknownConfirmationKt.UnknownConfirmation$lambda$3(modifier3, z10, i10, onOk, onDismiss, aVar5, aVar6, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 1572864;
        aVar4 = aVar2;
        if ((599187 & i13) != 599186) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
            if (i16 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i17 != 0) {
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: v7.a
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                aVar7 = (a) objRememberedValue2;
            } else {
                aVar7 = aVar3;
            }
            if (i14 != 0) {
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: v7.b
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aVar8 = (a) objRememberedValue;
            } else {
                aVar8 = aVar4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1934516322, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.unknownConfirmation.UnknownConfirmation (UnknownConfirmation.kt:30)");
            }
            AttachContainerKt.AttachContainer(modifier2, z10, onDismiss, true, false, ComposableLambdaKt.rememberComposableLambda(1752861454, true, new Function2() { // from class: v7.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UnknownConfirmationKt.UnknownConfirmation$lambda$2(i10, aVar8, onOk, aVar7, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 224256 | (i13 & 112) | ((i13 >> 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aVar5 = aVar7;
            aVar6 = aVar8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            aVar5 = aVar3;
            aVar6 = aVar4;
        }
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: v7.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UnknownConfirmationKt.UnknownConfirmation$lambda$3(modifier3, z10, i10, onOk, onDismiss, aVar5, aVar6, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 UnknownConfirmation$lambda$2(int i10, a aVar, a aVar2, a aVar3, Composer composer, int i11) {
        String strStringResource;
        Composer composer2 = composer;
        if (composer2.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1752861454, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.unknownConfirmation.UnknownConfirmation.<anonymous> (UnknownConfirmation.kt:38)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
            if (!r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(10));
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            String strStringResource2 = "";
            if (i10 == 0) {
                composer2.startReplaceGroup(1217539263);
                strStringResource = StringResources_androidKt.stringResource(R.string.this_user_is_not_in_your_contacts_question, composer2, 0);
                composer2.endReplaceGroup();
            } else if (i10 == 1) {
                composer2.startReplaceGroup(1217545000);
                strStringResource = StringResources_androidKt.stringResource(R.string.stay_group_question, composer2, 0);
                composer2.endReplaceGroup();
            } else if (i10 != 2) {
                composer2.startReplaceGroup(-910517466);
                composer2.endReplaceGroup();
                strStringResource = "";
            } else {
                composer2.startReplaceGroup(1217549962);
                strStringResource = StringResources_androidKt.stringResource(R.string.stay_channel_question, composer2, 0);
                composer2.endReplaceGroup();
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1725padding3ABfNKs, strStringResource, textStyleM8271copyp1EtxEg$default, 0L, 0, 0, composer2, 6, 56);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceAround(), companion2.getCenterVertically(), composer2, 54);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default2);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (i10 == 0) {
                composer2.startReplaceGroup(-1967128546);
                strStringResource2 = StringResources_androidKt.stringResource(R.string.block, composer2, 0);
                composer2.endReplaceGroup();
            } else if (i10 == 1) {
                composer2.startReplaceGroup(-1967123587);
                strStringResource2 = StringResources_androidKt.stringResource(R.string.exit, composer2, 0);
                composer2.endReplaceGroup();
            } else if (i10 != 2) {
                composer2.startReplaceGroup(-850996630);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1967118716);
                strStringResource2 = StringResources_androidKt.stringResource(R.string.unsubscribe, composer2, 0);
                composer2.endReplaceGroup();
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(companion, aVar, strStringResource2, null, false, false, false, composer2, 6, MenuKt.InTransitionDuration);
            Z17ButtonsKt.Z17PrimaryDialogButton(companion, aVar2, StringResources_androidKt.stringResource(R.string.ok, composer2, 0), null, false, false, false, composer2, 6, MenuKt.InTransitionDuration);
            if (i10 == 0) {
                composer2.startReplaceGroup(-1967103660);
                Z17ButtonsKt.Z17PrimaryDialogButton(companion, aVar3, StringResources_androidKt.stringResource(R.string.share_number, composer2, 0), null, false, false, false, composer, 6, MenuKt.InTransitionDuration);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-850456050);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UnknownConfirmation$lambda$3(Modifier modifier, boolean z10, int i10, a aVar, a aVar2, a aVar3, a aVar4, int i11, int i12, Composer composer, int i13) {
        UnknownConfirmation(modifier, z10, i10, aVar, aVar2, aVar3, aVar4, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
