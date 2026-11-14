package cu.todus.android.uiCompose.main.screen.chat.item;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.repositories.ReactionsRepository;
import cu.z17.views.label.Z17LabelKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a9\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\t\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\b\u001a5\u0010\u000e\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011²\u0006\u000e\u0010\u0010\u001a\u00020\f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0010\u001a\u00020\f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function1;", "", "Lua/k0;", "onReacted", "Lkotlin/Function0;", "onEditReactSelection", "actualReacted", "ReactionsRow", "(Lkotlin/jvm/functions/Function1;Llb/a;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ReactionsColumn", "onClick", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "isSelected", "ReactionItem", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "visible", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReactionsKt {
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:64:0x0110  */
    /* JADX WARN: Code duplicated, block: B:67:0x013a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0140  */
    /* JADX WARN: Code duplicated, block: B:72:0x014a  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void ReactionItem(final Function1 function1, final String str, boolean z10, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z11;
        boolean z12;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        Object objRememberedValue;
        float f10;
        AnnotatedString.Builder builder;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1549250310);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i13 = i11 & 4;
        if (i13 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
            }
            if ((i12 & 147) != 146) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i13 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1549250310, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ReactionItem (Reactions.kt:151)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                if ((i12 & 14) == 4) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((i12 & 112) == 32) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z15 | z16;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z17 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.h0
                        @Override // lb.a
                        public final Object invoke() {
                            return ReactionsKt.ReactionItem$lambda$0$0(function1, str);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i14 = MaterialTheme.$stable;
                long onBackground = materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground();
                if (z14) {
                    f10 = 0.3f;
                } else {
                    f10 = 0.0f;
                }
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1240clickableoSLSa3U$default, Color.m5865copywmQWz5c$default(onBackground, f10, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(2));
                builder = new AnnotatedString.Builder(0, 1, null);
                if (kotlin.jvm.internal.y.d(str, "🗑️")) {
                    builder.append("🗑️");
                } else {
                    InlineTextContentKt.appendInlineContent$default(builder, str, null, 2, null);
                }
                AnnotatedString annotatedString = builder.toAnnotatedString();
                TextStyle titleLarge = materialTheme.getTypography(composerStartRestartGroup, i14).getTitleLarge();
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(TextUnitKt.getSp(40));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Z17LabelKt.m10261Z17Label3f6hBDE(modifierM1725padding3ABfNKs, annotatedString, (Map) objRememberedValue2, titleLarge, 0L, 0, 0, composerStartRestartGroup, 0, 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z14;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.i0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ReactionsKt.ReactionItem$lambda$3(function1, str, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z11 = z10;
        if ((i12 & 147) != 146) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            if (i13 != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1549250310, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ReactionItem (Reactions.kt:151)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            if ((i12 & 14) == 4) {
                z15 = true;
            } else {
                z15 = false;
            }
            if ((i12 & 112) == 32) {
                z16 = true;
            } else {
                z16 = false;
            }
            z17 = z15 | z16;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z17) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return ReactionsKt.ReactionItem$lambda$0$0(function1, str);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return ReactionsKt.ReactionItem$lambda$0$0(function1, str);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            long onBackground2 = materialTheme2.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            if (z14) {
                f10 = 0.3f;
            } else {
                f10 = 0.0f;
            }
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1240clickableoSLSa3U$default2, Color.m5865copywmQWz5c$default(onBackground2, f10, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(2));
            builder = new AnnotatedString.Builder(0, 1, null);
            if (kotlin.jvm.internal.y.d(str, "🗑️")) {
                builder.append("🗑️");
            } else {
                InlineTextContentKt.appendInlineContent$default(builder, str, null, 2, null);
            }
            AnnotatedString annotatedString2 = builder.toAnnotatedString();
            TextStyle titleLarge2 = materialTheme2.getTypography(composerStartRestartGroup, i15).getTitleLarge();
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(TextUnitKt.getSp(40));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Z17LabelKt.m10261Z17Label3f6hBDE(modifierM1725padding3ABfNKs2, annotatedString2, (Map) objRememberedValue2, titleLarge2, 0L, 0, 0, composerStartRestartGroup, 0, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z14;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z13 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReactionsKt.ReactionItem$lambda$3(function1, str, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReactionItem$lambda$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReactionItem$lambda$3(Function1 function1, String str, boolean z10, int i10, int i11, Composer composer, int i12) {
        ReactionItem(function1, str, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ReactionsColumn(final Function1 onReacted, final lb.a onEditReactSelection, final String actualReacted, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(onReacted, "onReacted");
        kotlin.jvm.internal.y.i(onEditReactSelection, "onEditReactSelection");
        kotlin.jvm.internal.y.i(actualReacted, "actualReacted");
        Composer composerStartRestartGroup = composer.startRestartGroup(1098089194);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onReacted) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onEditReactSelection) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(actualReacted) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1098089194, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ReactionsColumn (Reactions.kt:98)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ua.k0 k0Var = ua.k0.f43947a;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new ReactionsKt$ReactionsColumn$1$1(mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
            AnimatedVisibilityKt.AnimatedVisibility(ReactionsColumn$lambda$1(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1998085870, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReactionsKt.ReactionsColumn$lambda$4(onEditReactSelection, actualReacted, onReacted, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReactionsKt.ReactionsColumn$lambda$5(onReacted, onEditReactSelection, actualReacted, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ReactionsColumn$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReactionsColumn$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ReactionsColumn$lambda$4(lb.a aVar, final String str, final Function1 function1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1998085870, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ReactionsColumn.<anonymous> (Reactions.kt:113)");
        }
        float f10 = 5;
        float f11 = 15;
        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(ShadowKt.m5480shadows4CzXII$default(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(2), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)), false, 0L, 0L, 28, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f10));
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1725padding3ABfNKs);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        lb.a constructor = companion.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composer2.startReplaceGroup(-1493544495);
        for (String str2 : ReactionsRepository.INSTANCE.getInstance().getActualReactions()) {
            boolean zChanged = composer2.changed(str) | composer2.changed(function1);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReactionsKt.ReactionsColumn$lambda$4$0$0$0$0(str, function1, (String) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ReactionItem((Function1) objRememberedValue, str2, kotlin.jvm.internal.y.d(str2, str), composer2, 0, 0);
            composer2 = composer;
        }
        composer.endReplaceGroup();
        IconButtonKt.IconButton(aVar, SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), false, null, null, null, ComposableSingletons$ReactionsKt.INSTANCE.m9889getLambda$774186242$app_productionPFast(), composer, 1572912, 60);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReactionsColumn$lambda$4$0$0$0$0(String str, Function1 function1, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        if (kotlin.jvm.internal.y.d(it, str)) {
            function1.invoke("");
        } else {
            function1.invoke(it);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReactionsColumn$lambda$5(Function1 function1, lb.a aVar, String str, int i10, Composer composer, int i11) {
        ReactionsColumn(function1, aVar, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ReactionsRow(final Function1 onReacted, final lb.a onEditReactSelection, final String actualReacted, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(onReacted, "onReacted");
        kotlin.jvm.internal.y.i(onEditReactSelection, "onEditReactSelection");
        kotlin.jvm.internal.y.i(actualReacted, "actualReacted");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1807943522);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onReacted) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onEditReactSelection) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(actualReacted) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1807943522, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ReactionsRow (Reactions.kt:40)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ua.k0 k0Var = ua.k0.f43947a;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new ReactionsKt$ReactionsRow$1$1(mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
            AnimatedVisibilityKt.AnimatedVisibility(ReactionsRow$lambda$1(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(841075574, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.e0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReactionsKt.ReactionsRow$lambda$4(onEditReactSelection, actualReacted, onReacted, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReactionsKt.ReactionsRow$lambda$5(onReacted, onEditReactSelection, actualReacted, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ReactionsRow$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReactionsRow$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ReactionsRow$lambda$4(lb.a aVar, final String str, final Function1 function1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(841075574, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.item.ReactionsRow.<anonymous> (Reactions.kt:55)");
        }
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        float f10 = 5;
        float f11 = 15;
        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(ShadowKt.m5480shadows4CzXII$default(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(2), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11)), false, 0L, 0L, 28, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f10));
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1725padding3ABfNKs);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        lb.a constructor = companion.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composer2.startReplaceGroup(198291919);
        for (String str2 : ReactionsRepository.INSTANCE.getInstance().getActualReactions()) {
            boolean zChanged = composer2.changed(str) | composer2.changed(function1);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReactionsKt.ReactionsRow$lambda$4$0$0$0$0(str, function1, (String) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ReactionItem((Function1) objRememberedValue, str2, kotlin.jvm.internal.y.d(str2, str), composer2, 0, 0);
            composer2 = composer;
        }
        composer.endReplaceGroup();
        IconButtonKt.IconButton(aVar, SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(40)), false, null, null, null, ComposableSingletons$ReactionsKt.INSTANCE.m9890getLambda$825373448$app_productionPFast(), composer, 1572912, 60);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReactionsRow$lambda$4$0$0$0$0(String str, Function1 function1, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        if (kotlin.jvm.internal.y.d(it, str)) {
            function1.invoke("");
        } else {
            function1.invoke(it);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ReactionsRow$lambda$5(Function1 function1, lb.a aVar, String str, int i10, Composer composer, int i11) {
        ReactionsRow(function1, aVar, str, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
