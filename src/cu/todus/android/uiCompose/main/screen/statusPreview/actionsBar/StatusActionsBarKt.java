package cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShape;
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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.repositories.ReactionsRepository;
import cu.todus.android.uiCompose.main.screen.chat.item.ReactionsKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBarKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import le.d0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008b\u0001\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a!\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001f²\u0006\u000e\u0010\u001a\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001c\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\f\u0010\u001e\u001a\u00020\u001d8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "fromOwner", "canRespond", "", "viewsCount", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "actualReaction", "Lkotlin/Function1;", "", "Lua/k0;", "onReacted", "onRespond", "Lkotlin/Function0;", "onOpenViews", "onEditReactSelection", "onMoreClicked", "StatusActionsBar", "(Landroidx/compose/ui/Modifier;ZZILcu/todus/android/data/db/entity/toDus/Reaction;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Llb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroidx/compose/ui/unit/TextUnit;", "size", "ReactionItem-KmRG4DE", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "ReactionItem", "text", "showReaction", "canSendRespond", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StatusActionsBarKt {
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x0097  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00be  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ReactionItem-KmRG4DE, reason: not valid java name */
    public static final void m9994ReactionItemKmRG4DE(final String value, long j10, Composer composer, final int i10, final int i11) {
        int i12;
        long j11;
        boolean z10;
        final long j12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long sp;
        AnnotatedString.Builder builder;
        Object objRememberedValue;
        y.i(value, "value");
        Composer composerStartRestartGroup = composer.startRestartGroup(460371953);
        if ((i10 & 6) == 0) {
            i12 = i10 | (composerStartRestartGroup.changed(value) ? 4 : 2);
        } else {
            i12 = i10;
        }
        int i13 = i11 & 2;
        if (i13 == 0) {
            if ((i10 & 48) == 0) {
                j11 = j10;
                i12 |= composerStartRestartGroup.changed(j11) ? 32 : 16;
            }
            if ((i12 & 19) != 18) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i13 != 0) {
                    sp = TextUnitKt.getSp(25);
                } else {
                    sp = j11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(460371953, i12, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.ReactionItem (StatusActionsBar.kt:247)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                builder = new AnnotatedString.Builder(0, 1, null);
                if (y.d(value, "🗑️")) {
                    builder.append("🗑️");
                } else {
                    InlineTextContentKt.appendInlineContent$default(builder, value, null, 2, null);
                }
                AnnotatedString annotatedString = builder.toAnnotatedString();
                TextStyle titleLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge();
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(sp);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Z17LabelKt.m10261Z17Label3f6hBDE(companion, annotatedString, (Map) objRememberedValue, titleLarge, 0L, 0, 0, composerStartRestartGroup, 6, 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j12 = sp;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j12 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: i8.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StatusActionsBarKt.ReactionItem_KmRG4DE$lambda$2(value, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        j11 = j10;
        if ((i12 & 19) != 18) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            if (i13 != 0) {
                sp = TextUnitKt.getSp(25);
            } else {
                sp = j11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(460371953, i12, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.ReactionItem (StatusActionsBar.kt:247)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            builder = new AnnotatedString.Builder(0, 1, null);
            if (y.d(value, "🗑️")) {
                builder.append("🗑️");
            } else {
                InlineTextContentKt.appendInlineContent$default(builder, value, null, 2, null);
            }
            AnnotatedString annotatedString2 = builder.toAnnotatedString();
            TextStyle titleLarge2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge();
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = ReactionsRepository.INSTANCE.getInstance().m9802inlineContentR2X_6o(sp);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Z17LabelKt.m10261Z17Label3f6hBDE(companion2, annotatedString2, (Map) objRememberedValue, titleLarge2, 0L, 0, 0, composerStartRestartGroup, 6, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j12 = sp;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            j12 = j11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: i8.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusActionsBarKt.ReactionItem_KmRG4DE$lambda$2(value, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ReactionItem_KmRG4DE$lambda$2(String str, long j10, int i10, int i11, Composer composer, int i12) {
        m9994ReactionItemKmRG4DE(str, j10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusActionsBar(final Modifier modifier, final boolean z10, final boolean z11, final int i10, final Reaction reaction, final Function1 onReacted, final Function1 onRespond, final a onOpenViews, final a onEditReactSelection, final a onMoreClicked, Composer composer, final int i11) {
        int i12;
        int i13;
        Composer composer2;
        char c10;
        int i14;
        SnapshotMutationPolicy snapshotMutationPolicy;
        final MutableState mutableState;
        final MutableState mutableState2;
        ComposableLambda composableLambda;
        Composer composer3;
        y.i(modifier, "modifier");
        y.i(onReacted, "onReacted");
        y.i(onRespond, "onRespond");
        y.i(onOpenViews, "onOpenViews");
        y.i(onEditReactSelection, "onEditReactSelection");
        y.i(onMoreClicked, "onMoreClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1872502958);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(reaction) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onReacted) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onRespond) ? 1048576 : 524288;
        }
        if ((12582912 & i11) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onOpenViews) ? 8388608 : 4194304;
        }
        if ((100663296 & i11) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onEditReactSelection) ? 67108864 : 33554432;
        }
        int i15 = i12;
        if ((805306368 & i11) == 0) {
            i13 = i15 | (composerStartRestartGroup.changedInstance(onMoreClicked) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456);
        } else {
            i13 = i15;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 306783379) != 306783378, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                c10 = 0;
                ComposerKt.traceEventStart(-1872502958, i13, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBar (StatusActionsBar.kt:61)");
            } else {
                c10 = 0;
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-700005112);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
                Brush.Companion companion = Brush.INSTANCE;
                Color.Companion companion2 = Color.INSTANCE;
                Color colorM5856boximpl = Color.m5856boximpl(companion2.m5901getTransparent0d7_KjU());
                Color colorM5856boximpl2 = Color.m5856boximpl(Color.m5865copywmQWz5c$default(companion2.m5892getBlack0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                Color[] colorArr = new Color[2];
                colorArr[c10] = colorM5856boximpl;
                colorArr[1] = colorM5856boximpl2;
                Modifier modifierBackground$default = BackgroundKt.background$default(modifierFillMaxWidth$default, Brush.Companion.m5827verticalGradient8A3gB4$default(companion, w.q(colorArr), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                Alignment.Companion companion3 = Alignment.INSTANCE;
                boolean z12 = c10;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), z12);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, z12 ? 1 : 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                a constructor = companion4.getConstructor();
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
                int i16 = i13;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (i10 > 0) {
                    composerStartRestartGroup.startReplaceGroup(-546459764);
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i17 = MaterialTheme.$stable;
                    float f10 = 15;
                    Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(BackgroundKt.m1204backgroundbw27NRU(companion5, materialTheme.getColorScheme(composerStartRestartGroup, i17).getBackground(), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 12, null)), Dp.m8823constructorimpl(20), 0.0f, 2, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), companion3.getCenterVertically(), composerStartRestartGroup, 54);
                    int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
                    a constructor2 = companion4.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    boolean z13 = (i16 & 29360128) == 8388608;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: i8.d
                            @Override // lb.a
                            public final Object invoke() {
                                return StatusActionsBarKt.StatusActionsBar$lambda$0$0$0$0(onOpenViews);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Z17LabelKt.m10262Z17LabelfWhpE4E(ClickableKt.m1240clickableoSLSa3U$default(companion5, false, null, null, null, (a) objRememberedValue, 15, null), StringResources_androidKt.pluralStringResource(R.plurals.views, i10, composerStartRestartGroup, (i16 >> 6) & 112) + " " + i10, materialTheme.getTypography(composerStartRestartGroup, i17).getTitleSmall(), 0L, 0, 0, composerStartRestartGroup, 0, 56);
                    composer3 = composerStartRestartGroup;
                    composer3.endNode();
                    composer3.endReplaceGroup();
                } else {
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(-545563151);
                    composer3.endReplaceGroup();
                }
                composer3.endNode();
                composer3.endReplaceGroup();
                composer2 = composer3;
            } else {
                int i18 = i13;
                composerStartRestartGroup.startReplaceGroup(-698436574);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                Composer.Companion companion6 = Composer.INSTANCE;
                if (objRememberedValue2 == companion6.getEmpty()) {
                    i14 = 2;
                    snapshotMutationPolicy = null;
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    i14 = 2;
                    snapshotMutationPolicy = null;
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue2;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion6.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, snapshotMutationPolicy, i14, snapshotMutationPolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MutableState mutableState4 = (MutableState) objRememberedValue3;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion6.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(new a() { // from class: i8.e
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(StatusActionsBarKt.StatusActionsBar$lambda$7$0(mutableState3));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                State state = (State) objRememberedValue4;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion6.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new FocusRequester(), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                MutableState mutableState5 = (MutableState) objRememberedValue5;
                Brush.Companion companion7 = Brush.INSTANCE;
                Color.Companion companion8 = Color.INSTANCE;
                composer2 = composerStartRestartGroup;
                Modifier modifierBackground$default2 = BackgroundKt.background$default(modifier, Brush.Companion.m5827verticalGradient8A3gB4$default(companion7, w.q(Color.m5856boximpl(companion8.m5901getTransparent0d7_KjU()), Color.m5856boximpl(Color.m5865copywmQWz5c$default(companion8.m5892getBlack0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null))), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                float f11 = 10;
                float fM8823constructorimpl = Dp.m8823constructorimpl(f11);
                float fM8823constructorimpl2 = Dp.m8823constructorimpl(f11);
                float f12 = 5;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(modifierBackground$default2, fM8823constructorimpl2, 0.0f, fM8823constructorimpl, Dp.m8823constructorimpl(f12), 2, null);
                Alignment.Companion companion9 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion9.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer2, 48);
                int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM1729paddingqDBjuR0$default);
                ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                a constructor3 = companion10.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion10.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion10.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion10.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion10.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion10.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                if (z11) {
                    composer2.startReplaceGroup(75488615);
                    Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(e3.a(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), StatusActionsBar$lambda$10(mutableState5));
                    String strStatusActionsBar$lambda$2 = StatusActionsBar$lambda$2(mutableState3);
                    String strStringResource = StringResources_androidKt.stringResource(R.string.comment, composer2, 0);
                    TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), companion8.m5892getBlack0d7_KjU(), 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null);
                    long jM5903getWhite0d7_KjU = companion8.m5903getWhite0d7_KjU();
                    RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                    if (StatusActionsBar$lambda$8(state)) {
                        composer2.startReplaceGroup(76976336);
                        mutableState2 = mutableState3;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2097800841, true, new Function2() { // from class: i8.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StatusActionsBarKt.StatusActionsBar$lambda$11$0(onRespond, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54);
                        composer2.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda;
                    } else {
                        mutableState2 = mutableState3;
                        composer2.startReplaceGroup(77728147);
                        composer2.endReplaceGroup();
                        composableLambda = null;
                    }
                    long jM5901getTransparent0d7_KjU = companion8.m5901getTransparent0d7_KjU();
                    Object objRememberedValue6 = composer2.rememberedValue();
                    if (objRememberedValue6 == companion6.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: i8.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return StatusActionsBarKt.StatusActionsBar$lambda$11$1$0(mutableState2, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    mutableState = mutableState4;
                    Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFocusRequester, strStatusActionsBar$lambda$2, 0, 0, strStringResource, null, (Function1) objRememberedValue6, ComposableLambdaKt.rememberComposableLambda(-567748988, true, new Function2() { // from class: i8.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusActionsBarKt.StatusActionsBar$lambda$11$2(mutableState, reaction, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composableLambda, 0, 0, 0L, 0L, jM5901getTransparent0d7_KjU, 0L, jM5903getWhite0d7_KjU, textStyleM8271copyp1EtxEg$default, false, circleShape, false, composer2, 14155776, 199680, 679468);
                    composer2.endReplaceGroup();
                } else {
                    mutableState = mutableState4;
                    composer2.startReplaceGroup(-1660055792);
                    Modifier.Companion companion11 = Modifier.INSTANCE;
                    Modifier modifierA = e3.a(rowScopeInstance2, companion11, 1.0f, false, 2, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion9.getTop(), composer2, 0);
                    int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierA);
                    a constructor4 = companion10.getConstructor();
                    if (!r.a(composer2.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor4);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer2);
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy3, companion10.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion10.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion10.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion10.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion10.getSetModifier());
                    Object objRememberedValue7 = composer2.rememberedValue();
                    if (objRememberedValue7 == companion6.getEmpty()) {
                        objRememberedValue7 = new a() { // from class: i8.i
                            @Override // lb.a
                            public final Object invoke() {
                                return StatusActionsBarKt.StatusActionsBar$lambda$11$3$0$0(mutableState);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    IconButtonKt.IconButton((a) objRememberedValue7, PaddingKt.m1727paddingVpY3zN4$default(companion11, Dp.m8823constructorimpl(2), 0.0f, 2, null), false, null, null, null, ComposableLambdaKt.rememberComposableLambda(1632111844, true, new Function2() { // from class: i8.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusActionsBarKt.StatusActionsBar$lambda$11$3$1(reaction, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, 1572918, 60);
                    BoxKt.Box(e3.a(rowScopeInstance2, SizeKt.m1755height3ABfNKs(companion11, Dp.m8823constructorimpl(0)), 1.0f, false, 2, null), composer2, 0);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8823constructorimpl(f12), 0.0f, 0.0f, 13, null);
                boolean z14 = (i18 & C.ENCODING_PCM_DOUBLE) == 536870912;
                Object objRememberedValue8 = composer2.rememberedValue();
                if (z14 || objRememberedValue8 == companion6.getEmpty()) {
                    objRememberedValue8 = new a() { // from class: i8.o
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusActionsBarKt.StatusActionsBar$lambda$11$4$0(onMoreClicked);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                IconButtonKt.IconButton((a) objRememberedValue8, modifierM1729paddingqDBjuR0$default2, false, null, null, null, ComposableSingletons$StatusActionsBarKt.INSTANCE.m9992getLambda$1603795348$app_productionPFast(), composer2, 1572912, 60);
                if (StatusActionsBar$lambda$5(mutableState)) {
                    composer2.startReplaceGroup(79384974);
                    long jM8941constructorimpl = IntOffset.m8941constructorimpl((((long) 0) << 32) | (((long) (-150)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    Alignment bottomStart = companion9.getBottomStart();
                    Object objRememberedValue9 = composer2.rememberedValue();
                    if (objRememberedValue9 == companion6.getEmpty()) {
                        objRememberedValue9 = new a() { // from class: i8.p
                            @Override // lb.a
                            public final Object invoke() {
                                return StatusActionsBarKt.StatusActionsBar$lambda$11$5$0(mutableState);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    AndroidPopup_androidKt.m9081PopupK5zGePQ(bottomStart, jM8941constructorimpl, (a) objRememberedValue9, null, ComposableLambdaKt.rememberComposableLambda(-1349136677, true, new Function2() { // from class: i8.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusActionsBarKt.StatusActionsBar$lambda$11$6(reaction, onReacted, onEditReactSelection, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, 25014, 8);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(79978872);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: i8.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusActionsBarKt.StatusActionsBar$lambda$12(modifier, z10, z11, i10, reaction, onReacted, onRespond, onOpenViews, onEditReactSelection, onMoreClicked, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusActionsBar$lambda$0$0$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    private static final FocusRequester StatusActionsBar$lambda$10(MutableState<FocusRequester> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusActionsBar$lambda$11$0(final Function1 function1, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2097800841, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBar.<anonymous>.<anonymous> (StatusActionsBar.kt:166)");
            }
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: i8.j
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusActionsBarKt.StatusActionsBar$lambda$11$0$0$0(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((a) objRememberedValue, PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(2), 0.0f, 2, null), false, null, null, null, ComposableSingletons$StatusActionsBarKt.INSTANCE.m9993getLambda$179465575$app_productionPFast(), composer, 1572912, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusActionsBar$lambda$11$0$0$0(Function1 function1, MutableState mutableState) {
        function1.invoke(StatusActionsBar$lambda$2(mutableState));
        mutableState.setValue("");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusActionsBar$lambda$11$1$0(MutableState mutableState, String it) {
        y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusActionsBar$lambda$11$2(final MutableState mutableState, final Reaction reaction, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-567748988, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBar.<anonymous>.<anonymous> (StatusActionsBar.kt:148)");
            }
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: i8.k
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusActionsBarKt.StatusActionsBar$lambda$11$2$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((a) objRememberedValue, PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(2), 0.0f, 2, null), false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-44789338, true, new Function2() { // from class: i8.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusActionsBarKt.StatusActionsBar$lambda$11$2$1(reaction, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusActionsBar$lambda$11$2$0$0(MutableState mutableState) {
        StatusActionsBar$lambda$6(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusActionsBar$lambda$11$2$1(Reaction reaction, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-44789338, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBar.<anonymous>.<anonymous>.<anonymous> (StatusActionsBar.kt:155)");
            }
            if (reaction == null || d0.q0(reaction.getReactionContent())) {
                composer.startReplaceGroup(-92876296);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), Integer.valueOf(R.drawable.heart_icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-92866670);
                m9994ReactionItemKmRG4DE(reaction.getReactionContent(), 0L, composer, 0, 2);
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
    public static final k0 StatusActionsBar$lambda$11$3$0$0(MutableState mutableState) {
        StatusActionsBar$lambda$6(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusActionsBar$lambda$11$3$1(Reaction reaction, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1632111844, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBar.<anonymous>.<anonymous>.<anonymous> (StatusActionsBar.kt:196)");
            }
            if (reaction == null || d0.q0(reaction.getReactionContent())) {
                composer.startReplaceGroup(796423358);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), Integer.valueOf(R.drawable.heart_icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(796433104);
                m9994ReactionItemKmRG4DE(reaction.getReactionContent(), 0L, composer, 0, 2);
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
    public static final k0 StatusActionsBar$lambda$11$4$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusActionsBar$lambda$11$5$0(MutableState mutableState) {
        StatusActionsBar$lambda$6(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusActionsBar$lambda$11$6(Reaction reaction, final Function1 function1, a aVar, final MutableState mutableState, Composer composer, int i10) {
        String reactionContent;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1349136677, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBar.<anonymous>.<anonymous> (StatusActionsBar.kt:233)");
            }
            if (reaction == null || (reactionContent = reaction.getReactionContent()) == null) {
                reactionContent = "";
            }
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: i8.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusActionsBarKt.StatusActionsBar$lambda$11$6$0$0(function1, mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ReactionsKt.ReactionsColumn((Function1) objRememberedValue, aVar, reactionContent, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusActionsBar$lambda$11$6$0$0(Function1 function1, MutableState mutableState, String it) {
        y.i(it, "it");
        StatusActionsBar$lambda$6(mutableState, false);
        function1.invoke(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusActionsBar$lambda$12(Modifier modifier, boolean z10, boolean z11, int i10, Reaction reaction, Function1 function1, Function1 function2, a aVar, a aVar2, a aVar3, int i11, Composer composer, int i12) {
        StatusActionsBar(modifier, z10, z11, i10, reaction, function1, function2, aVar, aVar2, aVar3, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return k0.f43947a;
    }

    private static final String StatusActionsBar$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean StatusActionsBar$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StatusActionsBar$lambda$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StatusActionsBar$lambda$7$0(MutableState mutableState) {
        return !d0.q0(StatusActionsBar$lambda$2(mutableState));
    }

    private static final boolean StatusActionsBar$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
