package cu.todus.android.uiCompose.main.screen.chat.deletingDialog;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.chat.deletingDialog.DeletingDialogKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a[\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "selectedListSize", "", "showDeleteDialog", "showRegularDelete", "showDeleteForEveryone", "Lkotlin/Function0;", "Lua/k0;", "onClose", "onDelete", "onDeleteToAll", "DeletingDialog", "(IZZZLlb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DeletingDialogKt {
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x008b  */
    /* JADX WARN: Code duplicated, block: B:48:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x009c  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DeletingDialog(final int i10, final boolean z10, boolean z11, final boolean z12, final a onClose, final a onDelete, final a onDeleteToAll, Composer composer, final int i11, final int i12) {
        int i13;
        boolean z13;
        final boolean z14;
        boolean z15;
        final boolean z16;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i14;
        int i15;
        int i16;
        int i17;
        y.i(onClose, "onClose");
        y.i(onDelete, "onDelete");
        y.i(onDeleteToAll, "onDeleteToAll");
        Composer composerStartRestartGroup = composer.startRestartGroup(763102718);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(i10) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        int i18 = i12 & 4;
        if (i18 == 0) {
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z13 = z11;
                i13 |= composerStartRestartGroup.changed(z13) ? 256 : 128;
            }
            if ((i11 & 3072) == 0) {
                z14 = z12;
                if (composerStartRestartGroup.changed(z14)) {
                    i17 = 2048;
                } else {
                    i17 = 1024;
                }
                i13 |= i17;
            } else {
                z14 = z12;
            }
            if ((i11 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onClose)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i13 |= i16;
            }
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changedInstance(onDelete)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i13 |= i15;
            }
            if ((1572864 & i11) == 0) {
                if (composerStartRestartGroup.changedInstance(onDeleteToAll)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i13 |= i14;
            }
            if ((599187 & i13) != 599186) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z15, i13 & 1)) {
                if (i18 != 0) {
                    z16 = true;
                } else {
                    z16 = z13;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(763102718, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.deletingDialog.DeletingDialog (DeletingDialog.kt:32)");
                }
                Z17DialogsKt.Z17CustomDialog(z10, onClose, ComposableLambdaKt.rememberComposableLambda(-1250084148, true, new Function3() { // from class: p7.a
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DeletingDialogKt.DeletingDialog$lambda$0(i10, z16, onDelete, z14, onDeleteToAll, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | ((i13 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z16 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z17 = z16;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p7.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DeletingDialogKt.DeletingDialog$lambda$1(i10, z10, z17, z12, onClose, onDelete, onDeleteToAll, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z13 = z11;
        if ((i11 & 3072) == 0) {
            z14 = z12;
            if (composerStartRestartGroup.changed(z14)) {
                i17 = 2048;
            } else {
                i17 = 1024;
            }
            i13 |= i17;
        } else {
            z14 = z12;
        }
        if ((i11 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onClose)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i13 |= i16;
        }
        if ((196608 & i11) == 0) {
            if (composerStartRestartGroup.changedInstance(onDelete)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i13 |= i15;
        }
        if ((1572864 & i11) == 0) {
            if (composerStartRestartGroup.changedInstance(onDeleteToAll)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i13 |= i14;
        }
        if ((599187 & i13) != 599186) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z15, i13 & 1)) {
            if (i18 != 0) {
                z16 = true;
            } else {
                z16 = z13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(763102718, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.deletingDialog.DeletingDialog (DeletingDialog.kt:32)");
            }
            Z17DialogsKt.Z17CustomDialog(z10, onClose, ComposableLambdaKt.rememberComposableLambda(-1250084148, true, new Function3() { // from class: p7.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DeletingDialogKt.DeletingDialog$lambda$0(i10, z16, onDelete, z14, onDeleteToAll, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | ((i13 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z16 = z13;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z18 = z16;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p7.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeletingDialogKt.DeletingDialog$lambda$1(i10, z10, z18, z12, onClose, onDelete, onDeleteToAll, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 DeletingDialog$lambda$0(int i10, boolean z10, final a aVar, boolean z11, final a aVar2, final a close, Composer composer, int i11) {
        int i12;
        y.i(close, "close");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changedInstance(close) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1250084148, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.deletingDialog.DeletingDialog.<anonymous> (DeletingDialog.kt:37)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(15));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String strPluralStringResource = StringResources_androidKt.pluralStringResource(R.plurals.are_u_going_to_eliminate_this_msgs, i10, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strPluralStringResource, materialTheme.getTypography(composer, i13).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
            float f10 = 10;
            int i14 = i12;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f10), 1, null), StringResources_androidKt.stringResource(R.string.this_action_cant_be_undone, composer, 0), materialTheme.getTypography(composer, i13).getLabelSmall(), 0L, 0, 0, composer, 6, 56);
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(ScrollKt.horizontalScroll$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null), 0.0f, Dp.m8823constructorimpl(20), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getTop(), composer, 6);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1729paddingqDBjuR0$default);
            a constructor2 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String strStringResource = StringResources_androidKt.stringResource(R.string.no, composer, 0);
            int i15 = i14 & 14;
            boolean z12 = i15 == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: p7.c
                    @Override // lb.a
                    public final Object invoke() {
                        return DeletingDialogKt.DeletingDialog$lambda$0$0$0$0$0(close);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(null, (a) objRememberedValue, strStringResource, null, false, true, false, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 89);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion);
            a constructor3 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            if (z10) {
                composer.startReplaceGroup(-1851569456);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.eliminate_for_me, composer, 0);
                boolean zChanged = composer.changed(aVar) | (i15 == 4);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: p7.d
                        @Override // lb.a
                        public final Object invoke() {
                            return DeletingDialogKt.DeletingDialog$lambda$0$0$0$1$0$0(aVar, close);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Z17ButtonsKt.Z17PrimaryDialogButton(null, (a) objRememberedValue2, strStringResource2, null, false, true, false, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 89);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1851254248);
                composer.endReplaceGroup();
            }
            if (z11) {
                composer.startReplaceGroup(-1851191597);
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.eliminate_for_everyone, composer, 0);
                boolean zChanged2 = composer.changed(aVar2) | (i15 == 4);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new a() { // from class: p7.e
                        @Override // lb.a
                        public final Object invoke() {
                            return DeletingDialogKt.DeletingDialog$lambda$0$0$0$1$1$0(aVar2, close);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Z17ButtonsKt.Z17PrimaryDialogButton(null, (a) objRememberedValue3, strStringResource3, null, false, true, false, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 89);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1850756264);
                composer.endReplaceGroup();
            }
            composer.endNode();
            composer.endNode();
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
    public static final k0 DeletingDialog$lambda$0$0$0$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeletingDialog$lambda$0$0$0$1$0$0(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeletingDialog$lambda$0$0$0$1$1$0(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DeletingDialog$lambda$1(int i10, boolean z10, boolean z11, boolean z12, a aVar, a aVar2, a aVar3, int i11, int i12, Composer composer, int i13) {
        DeletingDialog(i10, z10, z11, z12, aVar, aVar2, aVar3, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
