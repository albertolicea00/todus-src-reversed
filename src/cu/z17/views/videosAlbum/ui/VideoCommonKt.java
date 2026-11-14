package cu.z17.views.videosAlbum.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.VideoFileKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.check.Z17CheckKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.picturesAlbum.theme.AlbumDimens;
import cu.z17.views.utils.Z17InlineUtilsKt;
import cu.z17.views.videosAlbum.data.VideoAlbum;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aa\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/videosAlbum/data/VideoAlbum;", "videoAlbum", "", "multipleImagesAllowed", "isSelected", "Lkotlin/Function1;", "Lua/k0;", "onSelected", "Landroidx/compose/ui/unit/Dp;", "size", "", "onRequestRealPath", "AlbumVideoItem-PfoAEA0", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/videosAlbum/data/VideoAlbum;ZZLkotlin/jvm/functions/Function1;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AlbumVideoItem", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VideoCommonKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0234  */
    /* JADX WARN: Code duplicated, block: B:103:0x0256  */
    /* JADX WARN: Code duplicated, block: B:106:0x0269  */
    /* JADX WARN: Code duplicated, block: B:107:0x026e  */
    /* JADX WARN: Code duplicated, block: B:110:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:111:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:114:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:72:0x010a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0113  */
    /* JADX WARN: Code duplicated, block: B:77:0x0157  */
    /* JADX WARN: Code duplicated, block: B:80:0x0163  */
    /* JADX WARN: Code duplicated, block: B:81:0x0167  */
    /* JADX WARN: Code duplicated, block: B:86:0x0196  */
    /* JADX WARN: Code duplicated, block: B:89:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:92:0x0206  */
    /* JADX WARN: Code duplicated, block: B:95:0x0222  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: AlbumVideoItem-PfoAEA0, reason: not valid java name */
    public static final void m10324AlbumVideoItemPfoAEA0(Modifier modifier, final VideoAlbum videoAlbum, final boolean z10, final boolean z11, final Function1 onSelected, float f10, final Function1 onRequestRealPath, Composer composer, final int i10, final int i11) {
        int i12;
        float f11;
        boolean z12;
        Modifier modifier2;
        Composer composer2;
        float f12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM10290getTenD9Ej5fM;
        int i13;
        boolean z13;
        boolean zChangedInstance;
        Object objRememberedValue;
        int i14;
        float fM8823constructorimpl;
        Alignment.Companion companion;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        BoxScopeInstance boxScopeInstance;
        Object objRememberedValue2;
        Composer.Companion companion2;
        Composer composer3;
        Long duration;
        long jLongValue;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        y.i(modifier, "modifier");
        y.i(videoAlbum, "videoAlbum");
        y.i(onSelected, "onSelected");
        y.i(onRequestRealPath, "onRequestRealPath");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2021301069);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(videoAlbum) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onSelected) ? 16384 : 8192;
        }
        int i15 = i11 & 32;
        if (i15 == 0) {
            if ((196608 & i10) == 0) {
                f11 = f10;
                i12 |= composerStartRestartGroup.changed(f11) ? 131072 : 65536;
            }
            if ((74899 & i12) != 74898) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i15 != 0) {
                    fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                } else {
                    fM10290getTenD9Ej5fM = f11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2021301069, i12, -1, "cu.z17.views.videosAlbum.ui.AlbumVideoItem (VideoCommon.kt:46)");
                }
                i13 = 57344 & i12;
                if (i13 == 16384) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                zChangedInstance = z13 | composerStartRestartGroup.changedInstance(videoAlbum);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.videosAlbum.ui.b
                        @Override // lb.a
                        public final Object invoke() {
                            return VideoCommonKt.AlbumVideoItem_PfoAEA0$lambda$1$lambda$0(onSelected, videoAlbum);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                i14 = i12;
                float f13 = fM10290getTenD9Ej5fM;
                modifier2 = modifier;
                Modifier modifierScale = ScaleKt.scale(SizeKt.m1769size3ABfNKs(ClickableKt.m1238clickableXHw0xAI$default(modifier, false, null, null, (lb.a) objRememberedValue, 7, null), f13), 1.0f);
                if (z11) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(2);
                } else {
                    fM8823constructorimpl = Dp.m8823constructorimpl(0);
                }
                float f14 = fM8823constructorimpl;
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i16 = MaterialTheme.$stable;
                Modifier modifierM1217borderxT4_qwU$default = BorderKt.m1217borderxT4_qwU$default(modifierScale, f14, materialTheme.getColorScheme(composerStartRestartGroup, i16).getSurface(), null, 4, null);
                companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1217borderxT4_qwU$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                f12 = f13;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), videoAlbum.getThumbnail(), VideoFileKt.getVideoFile(Icons.INSTANCE.getDefault()), null, ContentScale.INSTANCE.getCrop(), "video from gallery", 0, null, null, composerStartRestartGroup, 221184, 456);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(1701503212);
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, companion.getTopEnd()), Dp.m8823constructorimpl(3));
                    zChangedInstance2 = (i13 == 16384) | composerStartRestartGroup.changedInstance(videoAlbum);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == companion2.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.videosAlbum.ui.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return VideoCommonKt.AlbumVideoItem_PfoAEA0$lambda$4$lambda$3$lambda$2(onSelected, videoAlbum, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composer3 = composerStartRestartGroup;
                    Z17CheckKt.Z17Check(modifierM1725padding3ABfNKs, z11, (Function1) objRememberedValue3, composer3, (i14 >> 6) & 112, 0);
                } else {
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(1204530901);
                }
                composer3.endReplaceGroup();
                duration = videoAlbum.getDuration();
                if (duration != null) {
                    jLongValue = duration.longValue();
                } else {
                    jLongValue = 0;
                }
                String strConvertToMS = Z17InlineUtilsKt.convertToMS(jLongValue / 1000);
                float f15 = 3;
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, companion.getBottomStart()), Dp.m8823constructorimpl(f15));
                Color.Companion companion4 = Color.INSTANCE;
                float f16 = 5;
                Composer composer4 = composer3;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs2, companion4.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f16))), Dp.m8823constructorimpl(f16), Dp.m8823constructorimpl(f15)), strConvertToMS, materialTheme.getTypography(composer3, i16).getBodySmall(), companion4.m5903getWhite0d7_KjU(), 0, 0, composer4, 3072, 48);
                composer2 = composer4;
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                modifier2 = modifier;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f12 = f11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier3 = modifier2;
                final float f17 = f12;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videosAlbum.ui.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return VideoCommonKt.AlbumVideoItem_PfoAEA0$lambda$5(modifier3, videoAlbum, z10, z11, onSelected, f17, onRequestRealPath, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f11 = f10;
        if ((74899 & i12) != 74898) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            if (i15 != 0) {
                fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
            } else {
                fM10290getTenD9Ej5fM = f11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2021301069, i12, -1, "cu.z17.views.videosAlbum.ui.AlbumVideoItem (VideoCommon.kt:46)");
            }
            i13 = 57344 & i12;
            if (i13 == 16384) {
                z13 = true;
            } else {
                z13 = false;
            }
            zChangedInstance = z13 | composerStartRestartGroup.changedInstance(videoAlbum);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.videosAlbum.ui.b
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCommonKt.AlbumVideoItem_PfoAEA0$lambda$1$lambda$0(onSelected, videoAlbum);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.videosAlbum.ui.b
                    @Override // lb.a
                    public final Object invoke() {
                        return VideoCommonKt.AlbumVideoItem_PfoAEA0$lambda$1$lambda$0(onSelected, videoAlbum);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            i14 = i12;
            float f18 = fM10290getTenD9Ej5fM;
            modifier2 = modifier;
            Modifier modifierScale2 = ScaleKt.scale(SizeKt.m1769size3ABfNKs(ClickableKt.m1238clickableXHw0xAI$default(modifier, false, null, null, (lb.a) objRememberedValue, 7, null), f18), 1.0f);
            if (z11) {
                fM8823constructorimpl = Dp.m8823constructorimpl(2);
            } else {
                fM8823constructorimpl = Dp.m8823constructorimpl(0);
            }
            float f19 = fM8823constructorimpl;
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i17 = MaterialTheme.$stable;
            Modifier modifierM1217borderxT4_qwU$default2 = BorderKt.m1217borderxT4_qwU$default(modifierScale2, f19, materialTheme2.getColorScheme(composerStartRestartGroup, i17).getSurface(), null, 4, null);
            companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1217borderxT4_qwU$default2);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            constructor = companion5.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion5.getSetModifier());
            boxScopeInstance = BoxScopeInstance.INSTANCE;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion2 = Composer.INSTANCE;
            if (objRememberedValue2 == companion2.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            f12 = f18;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), videoAlbum.getThumbnail(), VideoFileKt.getVideoFile(Icons.INSTANCE.getDefault()), null, ContentScale.INSTANCE.getCrop(), "video from gallery", 0, null, null, composerStartRestartGroup, 221184, 456);
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(1701503212);
                Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, companion.getTopEnd()), Dp.m8823constructorimpl(3));
                zChangedInstance2 = (i13 == 16384) | composerStartRestartGroup.changedInstance(videoAlbum);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.videosAlbum.ui.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return VideoCommonKt.AlbumVideoItem_PfoAEA0$lambda$4$lambda$3$lambda$2(onSelected, videoAlbum, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.videosAlbum.ui.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return VideoCommonKt.AlbumVideoItem_PfoAEA0$lambda$4$lambda$3$lambda$2(onSelected, videoAlbum, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composer3 = composerStartRestartGroup;
                Z17CheckKt.Z17Check(modifierM1725padding3ABfNKs3, z11, (Function1) objRememberedValue3, composer3, (i14 >> 6) & 112, 0);
            } else {
                composer3 = composerStartRestartGroup;
                composer3.startReplaceGroup(1204530901);
            }
            composer3.endReplaceGroup();
            duration = videoAlbum.getDuration();
            if (duration != null) {
                jLongValue = duration.longValue();
            } else {
                jLongValue = 0;
            }
            String strConvertToMS2 = Z17InlineUtilsKt.convertToMS(jLongValue / 1000);
            float f110 = 3;
            Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, companion.getBottomStart()), Dp.m8823constructorimpl(f110));
            Color.Companion companion6 = Color.INSTANCE;
            float f111 = 5;
            Composer composer5 = composer3;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs4, companion6.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f111))), Dp.m8823constructorimpl(f111), Dp.m8823constructorimpl(f110)), strConvertToMS2, materialTheme2.getTypography(composer3, i17).getBodySmall(), companion6.m5903getWhite0d7_KjU(), 0, 0, composer5, 3072, 48);
            composer2 = composer5;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            modifier2 = modifier;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            f12 = f11;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final float f112 = f12;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videosAlbum.ui.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoCommonKt.AlbumVideoItem_PfoAEA0$lambda$5(modifier4, videoAlbum, z10, z11, onSelected, f112, onRequestRealPath, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AlbumVideoItem_PfoAEA0$lambda$1$lambda$0(Function1 function1, VideoAlbum videoAlbum) {
        function1.invoke(videoAlbum);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AlbumVideoItem_PfoAEA0$lambda$4$lambda$3$lambda$2(Function1 function1, VideoAlbum videoAlbum, boolean z10) {
        function1.invoke(videoAlbum);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AlbumVideoItem_PfoAEA0$lambda$5(Modifier modifier, VideoAlbum videoAlbum, boolean z10, boolean z11, Function1 function1, float f10, Function1 function2, int i10, int i11, Composer composer, int i12) {
        m10324AlbumVideoItemPfoAEA0(modifier, videoAlbum, z10, z11, function1, f10, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
