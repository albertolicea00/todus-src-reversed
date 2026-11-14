package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutKt;
import androidx.constraintlayout.compose.ConstraintSet;
import androidx.constraintlayout.compose.ConstraintSetScope;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.EditableJSONLayout;
import androidx.constraintlayout.compose.LayoutInformationReceiver;
import androidx.constraintlayout.compose.Measurer2;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ag\u0010\n\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "", "onMsgEntityClick", "LinksContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/pojo/content/LinkInfoContent;", "content", "LinkShowIn", "(Lcu/todus/android/data/db/pojo/content/LinkInfoContent;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LinksContentKt {
    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LinkShowIn(final LinkInfoContent content, final Function2 onMsgEntityClick, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(content, "content");
        kotlin.jvm.internal.y.i(onMsgEntityClick, "onMsgEntityClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1452064452);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(content) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onMsgEntityClick) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1452064452, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.LinkShowIn (LinksContent.kt:52)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.c1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LinksContentKt.LinkShowIn$lambda$0$0((ConstraintSetScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ConstraintSet ConstraintSet = ConstraintLayoutKt.ConstraintSet((Function1) objRememberedValue);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            boolean z10 = ((i11 & 112) == 32) | ((i11 & 14) == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.d1
                    @Override // lb.a
                    public final Object invoke() {
                        return LinksContentKt.LinkShowIn$lambda$1$0(content, onMsgEntityClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue2, 15, null), Color.m5865copywmQWz5c$default(Color.INSTANCE.m5892getBlack0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(5)), 0.0f, 1, null);
            composerStartRestartGroup.startReplaceGroup(-1998673515);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableLongState mutableLongState = (MutableLongState) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.mutableStateOf(ua.k0.f43947a, SnapshotStateKt.neverEqualPolicy());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState = (MutableState) objRememberedValue4;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Measurer2(density);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final Measurer2 measurer2 = (Measurer2) objRememberedValue5;
            final int i12 = 257;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(measurer2) | composerStartRestartGroup.changed(ConstraintSet) | composerStartRestartGroup.changed(257);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new MeasurePolicy() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$4

                    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.item.content.LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$4$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lua/k0;", "invoke", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1$1", "<anonymous>"}, k = 3, mv = {2, 3, 0})
                    public static final class AnonymousClass1 extends kotlin.jvm.internal.e0 implements Function1 {
                        final /* synthetic */ List $measurables;
                        final /* synthetic */ Measurer2 $measurer;
                        final /* synthetic */ Map $placeableMap;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(Measurer2 measurer2, List list, Map map) {
                            super(1);
                            this.$measurer = measurer2;
                            this.$measurables = list;
                            this.$placeableMap = map;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return ua.k0.f43947a;
                        }

                        public final void invoke(Placeable.PlacementScope placementScope) {
                            this.$measurer.performLayout(placementScope, this.$measurables, this.$placeableMap);
                        }
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i13) {
                        return androidx.compose.ui.layout.h.a(this, intrinsicMeasureScope, list, i13);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i13) {
                        return androidx.compose.ui.layout.h.b(this, intrinsicMeasureScope, list, i13);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo983measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j10) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        mutableState.getValue();
                        long jM9231performMeasureDjhGOtQ = measurer2.m9231performMeasureDjhGOtQ(j10, measureScope.getLayoutDirection(), ConstraintSet, list, linkedHashMap, i12);
                        return MeasureScope.CC.s(measureScope, IntSize.m8990getWidthimpl(jM9231performMeasureDjhGOtQ), IntSize.m8989getHeightimpl(jM9231performMeasureDjhGOtQ), null, new AnonymousClass1(measurer2, list, linkedHashMap), 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i13) {
                        return androidx.compose.ui.layout.h.c(this, intrinsicMeasureScope, list, i13);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i13) {
                        return androidx.compose.ui.layout.h.d(this, intrinsicMeasureScope, list, i13);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue6;
            if (ConstraintSet instanceof EditableJSONLayout) {
                ((EditableJSONLayout) ConstraintSet).setUpdateFlag(mutableLongState);
            }
            measurer2.addLayoutInformationReceiver(ConstraintSet instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) ConstraintSet : null);
            if (Float.isNaN(measurer2.getForcedScaleFactor())) {
                composerStartRestartGroup.startReplaceGroup(-1996827620);
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer2);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$7(measurer2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default, false, (Function1) objRememberedValue7, 1, null), ComposableLambdaKt.rememberComposableLambda(-207512644, true, new LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$8(mutableState, content), composerStartRestartGroup, 54), measurePolicy, composerStartRestartGroup, 48, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1997256040);
                Modifier modifierScale = ScaleKt.scale(modifierFillMaxWidth$default, measurer2.getForcedScaleFactor());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
                Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(measurer2);
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$5(measurer2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierScale, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1131308473, true, new LinksContentKt$LinkShowIn$$inlined$ConstraintLayout$6(content), composerStartRestartGroup, 54), measurePolicy, composerStartRestartGroup, 48, 0);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.e1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LinksContentKt.LinkShowIn$lambda$3(content, onMsgEntityClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LinkShowIn$lambda$0$0(ConstraintSetScope ConstraintSet) {
        kotlin.jvm.internal.y.i(ConstraintSet, "$this$ConstraintSet");
        final ConstrainedLayoutReference constrainedLayoutReferenceCreateRefFor = ConstraintSet.createRefFor(XHTMLText.IMG);
        final ConstrainedLayoutReference constrainedLayoutReferenceCreateRefFor2 = ConstraintSet.createRefFor("title");
        ConstrainedLayoutReference constrainedLayoutReferenceCreateRefFor3 = ConstraintSet.createRefFor("description");
        ConstraintSet.constrain(constrainedLayoutReferenceCreateRefFor, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.f1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinksContentKt.LinkShowIn$lambda$0$0$0((ConstrainScope) obj);
            }
        });
        ConstraintSet.constrain(constrainedLayoutReferenceCreateRefFor2, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinksContentKt.LinkShowIn$lambda$0$0$1(constrainedLayoutReferenceCreateRefFor, (ConstrainScope) obj);
            }
        });
        ConstraintSet.constrain(constrainedLayoutReferenceCreateRefFor3, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.h1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinksContentKt.LinkShowIn$lambda$0$0$2(constrainedLayoutReferenceCreateRefFor2, constrainedLayoutReferenceCreateRefFor, (ConstrainScope) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LinkShowIn$lambda$0$0$0(ConstrainScope constrain) {
        kotlin.jvm.internal.y.i(constrain, "$this$constrain");
        androidx.constraintlayout.compose.e.b(constrain.getTop(), constrain.getParent().getTop(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getStart(), constrain.getParent().getStart(), 0.0f, 0.0f, 6, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LinkShowIn$lambda$0$0$1(ConstrainedLayoutReference constrainedLayoutReference, ConstrainScope constrain) {
        kotlin.jvm.internal.y.i(constrain, "$this$constrain");
        androidx.constraintlayout.compose.e.b(constrain.getTop(), constrain.getParent().getTop(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getStart(), constrainedLayoutReference.getEnd(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getEnd(), constrain.getParent().getEnd(), 0.0f, 0.0f, 6, null);
        constrain.setWidth(Dimension.INSTANCE.getPreferredWrapContent());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LinkShowIn$lambda$0$0$2(ConstrainedLayoutReference constrainedLayoutReference, ConstrainedLayoutReference constrainedLayoutReference2, ConstrainScope constrain) {
        kotlin.jvm.internal.y.i(constrain, "$this$constrain");
        androidx.constraintlayout.compose.e.b(constrain.getTop(), constrainedLayoutReference.getBottom(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getStart(), constrainedLayoutReference2.getEnd(), 0.0f, 0.0f, 6, null);
        androidx.constraintlayout.compose.h.a(constrain.getEnd(), constrain.getParent().getEnd(), 0.0f, 0.0f, 6, null);
        constrain.setWidth(Dimension.INSTANCE.getPreferredWrapContent());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LinkShowIn$lambda$1$0(LinkInfoContent linkInfoContent, Function2 function2) {
        String url;
        LinkEntity linkEntity = linkInfoContent.getLinkEntity();
        if (linkEntity != null && (url = linkEntity.getUrl()) != null) {
            function2.invoke(MessageAction.LINK_CLICK, url);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LinkShowIn$lambda$3(LinkInfoContent linkInfoContent, Function2 function2, int i10, Composer composer, int i11) {
        LinkShowIn(linkInfoContent, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LinksContent(final MessageWithPartnerWithReactions msg, final Function2 onClick, final Function2 onLongClick, Function2 function2, Composer composer, final int i10, final int i11) {
        int i12;
        final Function2 function3;
        Function2 function4;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(808749540);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onLongClick) ? 256 : 128;
        }
        int i13 = i11 & 8;
        if (i13 != 0) {
            i12 |= 3072;
        } else if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            if (i13 != 0) {
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.i1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LinksContentKt.LinksContent$lambda$0$0((MessageAction) obj, (String) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function4 = (Function2) objRememberedValue;
            } else {
                function4 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(808749540, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.LinksContent (LinksContent.kt:32)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Iterator<T> it = msg.getAttachments().iterator();
            while (true) {
                if (!it.hasNext()) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                Attachment attachment = (Attachment) it.next();
                if (attachment.getContent().getType() == 20 && (attachment.getContent() instanceof LinkInfoContent)) {
                    Content content = attachment.getContent();
                    kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.LinkInfoContent");
                    LinkShowIn((LinkInfoContent) content, function4, composerStartRestartGroup, (i12 >> 6) & 112);
                    TextContentKt.m9893TextContentOadGlvw(msg.getMessage().getContent(), 0L, onClick, onLongClick, 0, function4, composerStartRestartGroup, ((i12 << 3) & 8064) | ((i12 << 6) & 458752), 18);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    break;
                }
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LinksContentKt.LinksContent$lambda$2(msg, onClick, onLongClick, function3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LinksContent$lambda$0$0(MessageAction messageAction, String str) {
        kotlin.jvm.internal.y.i(messageAction, "<unused var>");
        kotlin.jvm.internal.y.i(str, "<unused var>");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LinksContent$lambda$2(MessageWithPartnerWithReactions messageWithPartnerWithReactions, Function2 function2, Function2 function3, Function2 function4, int i10, int i11, Composer composer, int i12) {
        LinksContent(messageWithPartnerWithReactions, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
