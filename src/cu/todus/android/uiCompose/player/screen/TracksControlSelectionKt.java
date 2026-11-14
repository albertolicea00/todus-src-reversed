package cu.todus.android.uiCompose.player.screen;

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
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.videoPlayer.trackSelector.TrackElement;
import cu.z17.views.videoPlayer.trackSelector.TripleTrackSave;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001aq\u0010\u000b\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a;\u0010\u0019\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a5\u0010!\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0007¢\u0006\u0004\b!\u0010\"\"\u0014\u0010#\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010%\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010$\"\u0014\u0010&\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010$\"\u0014\u0010'\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010$¨\u0006)²\u0006\u000e\u0010(\u001a\u00020\u00118\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcu/z17/views/videoPlayer/trackSelector/TrackElement;", "selectedVideoTrack", "selectedAudioTrack", "selectedSubsTrack", "Lcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;", "tripleTrackSave", "Lkotlin/Function1;", "Lua/k0;", "onSelectedVideoTrack", "onSelectedAudioTrack", "onSelectedSubsTrack", "TrackSelectionMenu", "(Lcu/z17/views/videoPlayer/trackSelector/TrackElement;Lcu/z17/views/videoPlayer/trackSelector/TrackElement;Lcu/z17/views/videoPlayer/trackSelector/TrackElement;Lcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "", "showVideoTracks", "showAudioTracks", "showSubsTracks", "", "onPageSelected", "MenuPage", "(ZZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "selectedTrack", "", "tracks", "onSelected", "ElementSelectorPage", "(Lcu/z17/views/videoPlayer/trackSelector/TrackElement;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "", "label", "isSelected", "isLast", "Lkotlin/Function0;", "onClick", "TrackItem", "(Ljava/lang/String;ZZLlb/a;Landroidx/compose/runtime/Composer;I)V", "MENU_PAGE", "I", "VIDEO_TRACK_PAGE", "AUDIO_TRACK_PAGE", "SUBS_TRACK_PAGE", "actualPage", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TracksControlSelectionKt {
    public static final int AUDIO_TRACK_PAGE = 2;
    public static final int MENU_PAGE = 0;
    public static final int SUBS_TRACK_PAGE = 3;
    public static final int VIDEO_TRACK_PAGE = 1;

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ElementSelectorPage(final TrackElement trackElement, final List<TrackElement> tracks, final Function1 onSelected, Composer composer, final int i10) {
        kotlin.jvm.internal.y.i(tracks, "tracks");
        kotlin.jvm.internal.y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1645841574);
        int i11 = (i10 & 6) == 0 ? (composerStartRestartGroup.changed(trackElement) ? 4 : 2) | i10 : i10;
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(tracks) ? 32 : 16;
        }
        int i12 = 256;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelected) ? 256 : 128;
        }
        int i13 = i11;
        if (composerStartRestartGroup.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1645841574, i13, -1, "cu.todus.android.uiCompose.player.screen.ElementSelectorPage (TracksControlSelection.kt:156)");
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
            composerStartRestartGroup.startReplaceGroup(-869308814);
            int i14 = 0;
            for (Object obj : tracks) {
                int i15 = i14 + 1;
                if (i14 < 0) {
                    va.w.x();
                }
                final TrackElement trackElement2 = (TrackElement) obj;
                String trackStringData = trackElement2.getTrackStringData();
                boolean zD = kotlin.jvm.internal.y.d(trackElement != null ? trackElement.getTrackStringData() : null, trackElement2.getTrackStringData());
                boolean z10 = i14 == tracks.size() - 1;
                boolean zChanged = ((i13 & 896) == i12) | composerStartRestartGroup.changed(trackElement2);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.n0
                        @Override // lb.a
                        public final Object invoke() {
                            return TracksControlSelectionKt.ElementSelectorPage$lambda$0$0$0$0(onSelected, trackElement2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                TrackItem(trackStringData, zD, z10, (lb.a) objRememberedValue, composerStartRestartGroup, 0);
                i14 = i15;
                i12 = 256;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.player.screen.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TracksControlSelectionKt.ElementSelectorPage$lambda$1(trackElement, tracks, onSelected, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ElementSelectorPage$lambda$0$0$0$0(Function1 function1, TrackElement trackElement) {
        function1.invoke(trackElement);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ElementSelectorPage$lambda$1(TrackElement trackElement, List list, Function1 function1, int i10, Composer composer, int i11) {
        ElementSelectorPage(trackElement, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v2 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final void MenuPage(boolean r18, boolean r19, boolean r20, kotlin.jvm.functions.Function1 r21, androidx.compose.runtime.Composer r22, int r23) {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.player.screen.TracksControlSelectionKt.MenuPage(boolean, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MenuPage$lambda$0$0$0(Function1 function1) {
        function1.invoke(1);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MenuPage$lambda$0$1$0(Function1 function1) {
        function1.invoke(2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MenuPage$lambda$0$2$0(Function1 function1) {
        function1.invoke(3);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 MenuPage$lambda$1(boolean z10, boolean z11, boolean z12, Function1 function1, int i10, Composer composer, int i11) {
        MenuPage(z10, z11, z12, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TrackItem(final String label, final boolean z10, final boolean z11, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        long background;
        kotlin.jvm.internal.y.i(label, "label");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2138118009);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(label) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2138118009, i11, -1, "cu.todus.android.uiCompose.player.screen.TrackItem (TracksControlSelection.kt:171)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z12 = (i11 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.l0
                    @Override // lb.a
                    public final Object invoke() {
                        return TracksControlSelectionKt.TrackItem$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(3));
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-1737027815);
                background = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1737025711);
                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierM1725padding3ABfNKs, background, null, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
            composer2 = composerStartRestartGroup;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(5)), label, null, 0L, 0, 0, composer2, ((i11 << 3) & 112) | 6, 60);
            if (z11) {
                composer2.startReplaceGroup(-1339138491);
            } else {
                composer2.startReplaceGroup(926632720);
                DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer2, 0, 7);
                composer2 = composer2;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.player.screen.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TracksControlSelectionKt.TrackItem$lambda$2(label, z10, z11, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TrackItem$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TrackItem$lambda$2(String str, boolean z10, boolean z11, lb.a aVar, int i10, Composer composer, int i11) {
        TrackItem(str, z10, z11, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TrackSelectionMenu(final TrackElement trackElement, final TrackElement trackElement2, final TrackElement trackElement3, final TripleTrackSave tripleTrackSave, final Function1 onSelectedVideoTrack, final Function1 onSelectedAudioTrack, final Function1 onSelectedSubsTrack, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(tripleTrackSave, "tripleTrackSave");
        kotlin.jvm.internal.y.i(onSelectedVideoTrack, "onSelectedVideoTrack");
        kotlin.jvm.internal.y.i(onSelectedAudioTrack, "onSelectedAudioTrack");
        kotlin.jvm.internal.y.i(onSelectedSubsTrack, "onSelectedSubsTrack");
        Composer composerStartRestartGroup = composer.startRestartGroup(543150660);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(trackElement) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(trackElement2) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(trackElement3) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(tripleTrackSave) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelectedVideoTrack) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelectedAudioTrack) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelectedSubsTrack) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i11) != 599186, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(543150660, i11, -1, "cu.todus.android.uiCompose.player.screen.TrackSelectionMenu (TracksControlSelection.kt:42)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            float f10 = 10;
            int i12 = i11;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(f10)), 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int intValue = mutableIntState.getIntValue();
            if (intValue == 0) {
                composerStartRestartGroup.startReplaceGroup(862860566);
                boolean z10 = !tripleTrackSave.getVideoTracks().isEmpty();
                boolean z11 = !tripleTrackSave.getAudioTracks().isEmpty();
                boolean z12 = !tripleTrackSave.getSubsTracks().isEmpty();
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TracksControlSelectionKt.TrackSelectionMenu$lambda$3$0$0(mutableIntState, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                MenuPage(z10, z11, z12, (Function1) objRememberedValue2, composerStartRestartGroup, 3072);
                composerStartRestartGroup.endReplaceGroup();
            } else if (intValue == 1) {
                composerStartRestartGroup.startReplaceGroup(863285762);
                List<TrackElement> videoTracks = tripleTrackSave.getVideoTracks();
                boolean z13 = (57344 & i12) == 16384;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z13 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.q0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TracksControlSelectionKt.TrackSelectionMenu$lambda$3$1$0(onSelectedVideoTrack, (TrackElement) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ElementSelectorPage(trackElement, videoTracks, (Function1) objRememberedValue3, composerStartRestartGroup, i12 & 14);
                composerStartRestartGroup.endReplaceGroup();
            } else if (intValue == 2) {
                composerStartRestartGroup.startReplaceGroup(863607170);
                List<TrackElement> audioTracks = tripleTrackSave.getAudioTracks();
                boolean z14 = (458752 & i12) == 131072;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z14 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.f0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TracksControlSelectionKt.TrackSelectionMenu$lambda$3$2$0(onSelectedAudioTrack, (TrackElement) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ElementSelectorPage(trackElement2, audioTracks, (Function1) objRememberedValue4, composerStartRestartGroup, (i12 >> 3) & 14);
                composerStartRestartGroup.endReplaceGroup();
            } else if (intValue != 3) {
                composerStartRestartGroup.startReplaceGroup(864213220);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(863927493);
                List<TrackElement> subsTracks = tripleTrackSave.getSubsTracks();
                boolean z15 = (3670016 & i12) == 1048576;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z15 || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.g0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TracksControlSelectionKt.TrackSelectionMenu$lambda$3$3$0(onSelectedSubsTrack, (TrackElement) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ElementSelectorPage(trackElement3, subsTracks, (Function1) objRememberedValue5, composerStartRestartGroup, (i12 >> 6) & 14);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.player.screen.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TracksControlSelectionKt.TrackSelectionMenu$lambda$4(trackElement, trackElement2, trackElement3, tripleTrackSave, onSelectedVideoTrack, onSelectedAudioTrack, onSelectedSubsTrack, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TrackSelectionMenu$lambda$3$0$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TrackSelectionMenu$lambda$3$1$0(Function1 function1, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        function1.invoke(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TrackSelectionMenu$lambda$3$2$0(Function1 function1, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        function1.invoke(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TrackSelectionMenu$lambda$3$3$0(Function1 function1, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        function1.invoke(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TrackSelectionMenu$lambda$4(TrackElement trackElement, TrackElement trackElement2, TrackElement trackElement3, TripleTrackSave tripleTrackSave, Function1 function1, Function1 function2, Function1 function3, int i10, Composer composer, int i11) {
        TrackSelectionMenu(trackElement, trackElement2, trackElement3, tripleTrackSave, function1, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
