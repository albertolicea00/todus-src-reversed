package cu.todus.android.uiCompose.main.screen.reactSelection;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.repositories.ReactionsRepository;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;
import ua.z;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a7\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0017²\u0006\u0012\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\nX\u008a\u0084\u0002²\u0006\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\u00148\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/reactSelection/ReactionsSelectionViewModel;", "viewModel", "Lua/k0;", "ReactionsSelectionScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/reactSelection/ReactionsSelectionViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isSelected", "Lkotlin/Function0;", "onClick", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroidx/compose/ui/unit/TextUnit;", "size", "ReactionComponentForSelection-JHQioms", "(ZLlb/a;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "ReactionComponentForSelection", "", "actualReactions", "Lkotlin/Pair;", "", "selectedToChange", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReactionsSelectionScreenKt {
    /* JADX WARN: Code duplicated, block: B:37:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0079 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x009d  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:62:0x0129  */
    /* JADX WARN: Code duplicated, block: B:65:0x0135  */
    /* JADX WARN: Code duplicated, block: B:66:0x0139  */
    /* JADX WARN: Code duplicated, block: B:69:0x018d  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:73:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ReactionComponentForSelection-JHQioms, reason: not valid java name */
    public static final void m9964ReactionComponentForSelectionJHQioms(final boolean z10, final lb.a onClick, final String value, long j10, Composer composer, final int i10, final int i11) {
        int i12;
        long sp;
        boolean z11;
        final long j11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float f10;
        boolean z12;
        Object objRememberedValue;
        lb.a constructor;
        Object objRememberedValue2;
        y.i(onClick, "onClick");
        y.i(value, "value");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1165296109);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(value) ? 256 : 128;
        }
        int i13 = i11 & 8;
        if (i13 == 0) {
            if ((i10 & 3072) == 0) {
                sp = j10;
                i12 |= composerStartRestartGroup.changed(sp) ? 2048 : 1024;
            }
            if ((i12 & 1171) != 1170) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                if (i13 != 0) {
                    sp = TextUnitKt.getSp(40);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1165296109, i12, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionComponentForSelection (ReactionsSelectionScreen.kt:166)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i14 = MaterialTheme.$stable;
                long primary = materialTheme.getColorScheme(composerStartRestartGroup, i14).getPrimary();
                if (z10) {
                    f10 = 0.4f;
                } else {
                    f10 = 0.0f;
                }
                Modifier modifierClip = ClipKt.clip(BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(primary, f10, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                if ((i12 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.i
                        @Override // lb.a
                        public final Object invoke() {
                            return ReactionsSelectionScreenKt.ReactionComponentForSelection_JHQioms$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierClip, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(8));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                InlineTextContentKt.appendInlineContent$default(builder, value, null, 2, null);
                AnnotatedString annotatedString = builder.toAnnotatedString();
                TextStyle titleLarge = materialTheme.getTypography(composerStartRestartGroup, i14).getTitleLarge();
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(sp);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Map map = (Map) objRememberedValue2;
                j11 = sp;
                Z17LabelKt.m10261Z17Label3f6hBDE(companion, annotatedString, map, titleLarge, 0L, 0, 0, composerStartRestartGroup, 6, 112);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j11 = sp;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ReactionsSelectionScreenKt.ReactionComponentForSelection_JHQioms$lambda$2(z10, onClick, value, j11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        sp = j10;
        if ((i12 & 1171) != 1170) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            if (i13 != 0) {
                sp = TextUnitKt.getSp(40);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1165296109, i12, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionComponentForSelection (ReactionsSelectionScreen.kt:166)");
            }
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            long primary2 = materialTheme2.getColorScheme(composerStartRestartGroup, i15).getPrimary();
            if (z10) {
                f10 = 0.4f;
            } else {
                f10 = 0.0f;
            }
            Modifier modifierClip2 = ClipKt.clip(BackgroundKt.m1204backgroundbw27NRU(companion3, Color.m5865copywmQWz5c$default(primary2, f10, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
            if ((i12 & 112) == 32) {
                z12 = true;
            } else {
                z12 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.i
                    @Override // lb.a
                    public final Object invoke() {
                        return ReactionsSelectionScreenKt.ReactionComponentForSelection_JHQioms$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.i
                    @Override // lb.a
                    public final Object invoke() {
                        return ReactionsSelectionScreenKt.ReactionComponentForSelection_JHQioms$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierClip2, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(8));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, null);
            InlineTextContentKt.appendInlineContent$default(builder2, value, null, 2, null);
            AnnotatedString annotatedString2 = builder2.toAnnotatedString();
            TextStyle titleLarge2 = materialTheme2.getTypography(composerStartRestartGroup, i15).getTitleLarge();
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(sp);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Map map2 = (Map) objRememberedValue2;
            j11 = sp;
            Z17LabelKt.m10261Z17Label3f6hBDE(companion3, annotatedString2, map2, titleLarge2, 0L, 0, 0, composerStartRestartGroup, 6, 112);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            j11 = sp;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReactionsSelectionScreenKt.ReactionComponentForSelection_JHQioms$lambda$2(z10, onClick, value, j11, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionComponentForSelection_JHQioms$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionComponentForSelection_JHQioms$lambda$2(boolean z10, lb.a aVar, String str, long j10, int i10, int i11, Composer composer, int i12) {
        m9964ReactionComponentForSelectionJHQioms(z10, aVar, str, j10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ReactionsSelectionScreen(final NavHostController navHostController, ReactionsSelectionViewModel reactionsSelectionViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        int i13;
        final ReactionsSelectionViewModel reactionsSelectionViewModel2 = reactionsSelectionViewModel;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1509053807);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i13 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(reactionsSelectionViewModel2) : composerStartRestartGroup.changedInstance(reactionsSelectionViewModel2)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
            }
            i12 |= i13;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                reactionsSelectionViewModel2 = (ReactionsSelectionViewModel) ViewModelKt.viewModel(z0.b(ReactionsSelectionViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i14 &= -113;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1509053807, i14, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionScreen (ReactionsSelectionScreen.kt:53)");
            }
            composer2 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(653856419, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$0(navHostController, reactionsSelectionViewModel2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(337095845, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$1(reactionsSelectionViewModel2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$2(navHostController, reactionsSelectionViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ReactionsSelectionScreen$lambda$0(final NavHostController navHostController, final ReactionsSelectionViewModel reactionsSelectionViewModel, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(653856419, i10, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionScreen.<anonymous> (ReactionsSelectionScreen.kt:59)");
            }
            Function2 function2M9963getLambda$238641872$app_productionPFast = ComposableSingletons$ReactionsSelectionScreenKt.INSTANCE.m9963getLambda$238641872$app_productionPFast();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1792227867, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$0$0(reactionsSelectionViewModel, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54);
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.h
                    @Override // lb.a
                    public final Object invoke() {
                        return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$0$1$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9963getLambda$238641872$app_productionPFast, null, true, composableLambdaRememberComposableLambda, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 3462, 0, 1938);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ReactionsSelectionScreen$lambda$0$0(final ReactionsSelectionViewModel reactionsSelectionViewModel, RowScope Z17TopBar, Composer composer, int i10) {
        y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1792227867, i10, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionScreen.<anonymous>.<anonymous> (ReactionsSelectionScreen.kt:72)");
            }
            boolean zChangedInstance = composer.changedInstance(reactionsSelectionViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.g
                    @Override // lb.a
                    public final Object invoke() {
                        return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$0$0$0$0(reactionsSelectionViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, ComposableSingletons$ReactionsSelectionScreenKt.INSTANCE.m9962getLambda$1783891267$app_productionPFast(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionsSelectionScreen$lambda$0$0$0$0(ReactionsSelectionViewModel reactionsSelectionViewModel) {
        reactionsSelectionViewModel.reset();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionsSelectionScreen$lambda$0$1$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ReactionsSelectionScreen$lambda$1(final ReactionsSelectionViewModel reactionsSelectionViewModel, Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(337095845, i10, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionScreen.<anonymous> (ReactionsSelectionScreen.kt:87)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(reactionsSelectionViewModel.getReactionsSelected().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(z.a("", 0), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composer, 0, 3);
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 20;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(f10), 0.0f, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1727paddingVpY3zN4$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.selected, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceAround(), companion2.getTop(), composer, 6);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer.startReplaceGroup(-1297519106);
            final int i11 = 0;
            for (Object obj : ReactionsSelectionScreen$lambda$1$0(stateCollectAsStateWithLifecycle)) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    w.x();
                }
                final String str = (String) obj;
                boolean z10 = ReactionsSelectionScreen$lambda$1$2(mutableState).getSecond().intValue() == i11;
                boolean zChanged = composer.changed(str) | composer.changed(i11);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.k
                        @Override // lb.a
                        public final Object invoke() {
                            return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$1$4$0$0$0$0(str, i11, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                m9964ReactionComponentForSelectionJHQioms(z10, (lb.a) objRememberedValue2, str, TextUnitKt.getSp(50), composer, 3072, 0);
                i11 = i12;
            }
            composer.endReplaceGroup();
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(f10)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.todus_emoji, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0, 0, composer, 0, 57);
            GridCells.Fixed fixed = new GridCells.Fixed(8);
            boolean zChanged2 = composer.changed(stateCollectAsStateWithLifecycle) | composer.changedInstance(reactionsSelectionViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$1$4$1$0(stateCollectAsStateWithLifecycle, reactionsSelectionViewModel, mutableState, (LazyGridScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            LazyGridDslKt.LazyVerticalGrid(fixed, null, lazyGridStateRememberLazyGridState, null, false, null, null, null, false, null, (Function1) objRememberedValue3, composer, 0, 0, 1018);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final List<String> ReactionsSelectionScreen$lambda$1$0(State<? extends List<String>> state) {
        return state.getValue();
    }

    private static final Pair<String, Integer> ReactionsSelectionScreen$lambda$1$2(MutableState<Pair<String, Integer>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionsSelectionScreen$lambda$1$4$0$0$0$0(String str, int i10, MutableState mutableState) {
        mutableState.setValue(z.a(str, Integer.valueOf(i10)));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionsSelectionScreen$lambda$1$4$1$0(final State state, final ReactionsSelectionViewModel reactionsSelectionViewModel, final MutableState mutableState, LazyGridScope LazyVerticalGrid) {
        y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.CC.b(LazyVerticalGrid, ReactionsRepository.INSTANCE.getInstance().getAllReactions().size(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(((Integer) obj).intValue());
            }
        }, null, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$1$4$1$0$1(((Integer) obj).intValue());
            }
        }, ComposableLambdaKt.composableLambdaInstance(1972520800, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.e
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$1$4$1$0$2(state, reactionsSelectionViewModel, mutableState, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ReactionsSelectionScreen$lambda$1$4$1$0$1(int i10) {
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ReactionsSelectionScreen$lambda$1$4$1$0$2(final State state, final ReactionsSelectionViewModel reactionsSelectionViewModel, final MutableState mutableState, LazyGridItemScope items, int i10, Composer composer, int i11) {
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i11 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i11 & 145) != 144, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1972520800, i11, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ReactionsSelectionScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReactionsSelectionScreen.kt:141)");
            }
            final String str = ReactionsRepository.INSTANCE.getInstance().getAllReactions().get(i10);
            boolean zChanged = composer.changed(state) | composer.changed(str) | composer.changedInstance(reactionsSelectionViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.f
                    @Override // lb.a
                    public final Object invoke() {
                        return ReactionsSelectionScreenKt.ReactionsSelectionScreen$lambda$1$4$1$0$2$0$0(reactionsSelectionViewModel, str, mutableState, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            m9964ReactionComponentForSelectionJHQioms(false, (lb.a) objRememberedValue, str, TextUnitKt.getSp(35), composer, 3078, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionsSelectionScreen$lambda$1$4$1$0$2$0$0(ReactionsSelectionViewModel reactionsSelectionViewModel, String str, MutableState mutableState, State state) {
        if (ReactionsSelectionScreen$lambda$1$2(mutableState).getSecond().intValue() != -1) {
            List<String> listReactionsSelectionScreen$lambda$1$0 = ReactionsSelectionScreen$lambda$1$0(state);
            if (r.a(listReactionsSelectionScreen$lambda$1$0) && listReactionsSelectionScreen$lambda$1$0.isEmpty()) {
                reactionsSelectionViewModel.changeReaction(str, ReactionsSelectionScreen$lambda$1$2(mutableState).getSecond().intValue());
                mutableState.setValue(z.a("", -1));
            } else {
                Iterator<T> it = listReactionsSelectionScreen$lambda$1$0.iterator();
                while (it.hasNext()) {
                    if (y.d((String) it.next(), str)) {
                    }
                }
                reactionsSelectionViewModel.changeReaction(str, ReactionsSelectionScreen$lambda$1$2(mutableState).getSecond().intValue());
                mutableState.setValue(z.a("", -1));
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionsSelectionScreen$lambda$2(NavHostController navHostController, ReactionsSelectionViewModel reactionsSelectionViewModel, int i10, int i11, Composer composer, int i12) {
        ReactionsSelectionScreen(navHostController, reactionsSelectionViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
