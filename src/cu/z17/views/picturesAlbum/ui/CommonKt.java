package cu.z17.views.picturesAlbum.ui;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.check.Z17CheckKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.picturesAlbum.data.AlbumImage;
import cu.z17.views.picturesAlbum.theme.AlbumDimens;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aM\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/picturesAlbum/data/AlbumImage;", "albumImage", "", "multipleImagesAllowed", "isSelected", "Lkotlin/Function1;", "Lua/k0;", "onSelectedPhoto", "Landroidx/compose/ui/unit/Dp;", "size", "AlbumImageItem-HYR8e34", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/picturesAlbum/data/AlbumImage;ZZLkotlin/jvm/functions/Function1;FLandroidx/compose/runtime/Composer;II)V", "AlbumImageItem", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CommonKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0232  */
    /* JADX WARN: Code duplicated, block: B:103:0x0242  */
    /* JADX WARN: Code duplicated, block: B:104:0x0246  */
    /* JADX WARN: Code duplicated, block: B:107:0x0252  */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00da  */
    /* JADX WARN: Code duplicated, block: B:73:0x0109  */
    /* JADX WARN: Code duplicated, block: B:75:0x0112  */
    /* JADX WARN: Code duplicated, block: B:78:0x0150  */
    /* JADX WARN: Code duplicated, block: B:81:0x015c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0160  */
    /* JADX WARN: Code duplicated, block: B:87:0x018d  */
    /* JADX WARN: Code duplicated, block: B:90:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:92:0x0205  */
    /* JADX WARN: Code duplicated, block: B:97:0x0219  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: AlbumImageItem-HYR8e34, reason: not valid java name */
    public static final void m10293AlbumImageItemHYR8e34(Modifier modifier, final AlbumImage albumImage, final boolean z10, final boolean z11, final Function1 onSelectedPhoto, float f10, Composer composer, final int i10, final int i11) {
        int i12;
        float f11;
        int i13;
        boolean z12;
        Modifier modifier2;
        float f12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM10290getTenD9Ej5fM;
        int i14;
        boolean z13;
        boolean zChangedInstance;
        Object objRememberedValue;
        float f13;
        Alignment.Companion companion;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        BoxScopeInstance boxScopeInstance;
        boolean zChangedInstance2;
        Object objRememberedValue2;
        y.i(modifier, "modifier");
        y.i(albumImage, "albumImage");
        y.i(onSelectedPhoto, "onSelectedPhoto");
        Composer composerStartRestartGroup = composer.startRestartGroup(-650140344);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(albumImage) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onSelectedPhoto) ? 16384 : 8192;
        }
        int i15 = i11 & 32;
        if (i15 == 0) {
            if ((196608 & i10) == 0) {
                f11 = f10;
                i12 |= composerStartRestartGroup.changed(f11) ? 131072 : 65536;
            }
            i13 = i12;
            if ((74899 & i13) != 74898) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                if (i15 != 0) {
                    fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                } else {
                    fM10290getTenD9Ej5fM = f11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-650140344, i13, -1, "cu.z17.views.picturesAlbum.ui.AlbumImageItem (Common.kt:34)");
                }
                i14 = 57344 & i13;
                if (i14 == 16384) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                zChangedInstance = z13 | composerStartRestartGroup.changedInstance(albumImage);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.picturesAlbum.ui.b
                        @Override // lb.a
                        public final Object invoke() {
                            return CommonKt.AlbumImageItem_HYR8e34$lambda$1$lambda$0(onSelectedPhoto, albumImage);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                float f14 = fM10290getTenD9Ej5fM;
                modifier2 = modifier;
                Modifier modifierScale = ScaleKt.scale(SizeKt.m1769size3ABfNKs(ClickableKt.m1238clickableXHw0xAI$default(modifier, false, null, null, (lb.a) objRememberedValue, 7, null), f14), 1.0f);
                if (z11) {
                    f13 = 2;
                } else {
                    f13 = 0;
                }
                Modifier modifierM1217borderxT4_qwU$default = BorderKt.m1217borderxT4_qwU$default(modifierScale, Dp.m8823constructorimpl(f13), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), null, 4, null);
                companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1217borderxT4_qwU$default);
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
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                f12 = f14;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), albumImage.getUri(), null, null, ContentScale.INSTANCE.getCrop(), "image from gallery", 0, null, null, composerStartRestartGroup, 221184, 460);
                composerStartRestartGroup = composerStartRestartGroup;
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-2122362734);
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, companion.getTopEnd()), Dp.m8823constructorimpl(3));
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(albumImage) | (i14 == 16384);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommonKt.AlbumImageItem_HYR8e34$lambda$4$lambda$3$lambda$2(onSelectedPhoto, albumImage, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Z17CheckKt.Z17Check(modifierM1725padding3ABfNKs, z11, (Function1) objRememberedValue2, composerStartRestartGroup, (i13 >> 6) & 112, 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1370418860);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                modifier2 = modifier;
                composerStartRestartGroup.skipToGroupEnd();
                f12 = f11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier3 = modifier2;
                final float f15 = f12;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommonKt.AlbumImageItem_HYR8e34$lambda$5(modifier3, albumImage, z10, z11, onSelectedPhoto, f15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f11 = f10;
        i13 = i12;
        if ((74899 & i13) != 74898) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
            if (i15 != 0) {
                fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
            } else {
                fM10290getTenD9Ej5fM = f11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-650140344, i13, -1, "cu.z17.views.picturesAlbum.ui.AlbumImageItem (Common.kt:34)");
            }
            i14 = 57344 & i13;
            if (i14 == 16384) {
                z13 = true;
            } else {
                z13 = false;
            }
            zChangedInstance = z13 | composerStartRestartGroup.changedInstance(albumImage);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.picturesAlbum.ui.b
                    @Override // lb.a
                    public final Object invoke() {
                        return CommonKt.AlbumImageItem_HYR8e34$lambda$1$lambda$0(onSelectedPhoto, albumImage);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.picturesAlbum.ui.b
                    @Override // lb.a
                    public final Object invoke() {
                        return CommonKt.AlbumImageItem_HYR8e34$lambda$1$lambda$0(onSelectedPhoto, albumImage);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            float f16 = fM10290getTenD9Ej5fM;
            modifier2 = modifier;
            Modifier modifierScale2 = ScaleKt.scale(SizeKt.m1769size3ABfNKs(ClickableKt.m1238clickableXHw0xAI$default(modifier, false, null, null, (lb.a) objRememberedValue, 7, null), f16), 1.0f);
            if (z11) {
                f13 = 2;
            } else {
                f13 = 0;
            }
            Modifier modifierM1217borderxT4_qwU$default2 = BorderKt.m1217borderxT4_qwU$default(modifierScale2, Dp.m8823constructorimpl(f13), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), null, 4, null);
            companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1217borderxT4_qwU$default2);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion3.getSetModifier());
            boxScopeInstance = BoxScopeInstance.INSTANCE;
            f12 = f16;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), albumImage.getUri(), null, null, ContentScale.INSTANCE.getCrop(), "image from gallery", 0, null, null, composerStartRestartGroup, 221184, 460);
            composerStartRestartGroup = composerStartRestartGroup;
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-2122362734);
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, companion.getTopEnd()), Dp.m8823constructorimpl(3));
                zChangedInstance2 = composerStartRestartGroup.changedInstance(albumImage) | (i14 == 16384);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CommonKt.AlbumImageItem_HYR8e34$lambda$4$lambda$3$lambda$2(onSelectedPhoto, albumImage, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CommonKt.AlbumImageItem_HYR8e34$lambda$4$lambda$3$lambda$2(onSelectedPhoto, albumImage, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Z17CheckKt.Z17Check(modifierM1725padding3ABfNKs2, z11, (Function1) objRememberedValue2, composerStartRestartGroup, (i13 >> 6) & 112, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1370418860);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            modifier2 = modifier;
            composerStartRestartGroup.skipToGroupEnd();
            f12 = f11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final float f17 = f12;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonKt.AlbumImageItem_HYR8e34$lambda$5(modifier4, albumImage, z10, z11, onSelectedPhoto, f17, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AlbumImageItem_HYR8e34$lambda$1$lambda$0(Function1 function1, AlbumImage albumImage) {
        function1.invoke(albumImage);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AlbumImageItem_HYR8e34$lambda$4$lambda$3$lambda$2(Function1 function1, AlbumImage albumImage, boolean z10) {
        function1.invoke(albumImage);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AlbumImageItem_HYR8e34$lambda$5(Modifier modifier, AlbumImage albumImage, boolean z10, boolean z11, Function1 function1, float f10, int i10, int i11, Composer composer, int i12) {
        m10293AlbumImageItemHYR8e34(modifier, albumImage, z10, z11, function1, f10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
