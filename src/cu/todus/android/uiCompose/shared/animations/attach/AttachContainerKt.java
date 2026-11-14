package cu.todus.android.uiCompose.shared.animations.attach;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.compose.BackHandlerKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.shared.animations.attach.AttachContainerKt;
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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aX\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a4\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\tH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "visible", "Lkotlin/Function0;", "Lua/k0;", "onClose", "canClose", "handleBack", "Landroidx/compose/runtime/Composable;", "content", "AttachContainer", "(Landroidx/compose/ui/Modifier;ZLlb/a;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AnimateContainer", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogToDusTopBar", "(Llb/a;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AttachContainerKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void AnimateContainer(Modifier modifier, final boolean z10, final Function2 content, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        boolean z11;
        final Modifier modifier3;
        y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(2090039323);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            z11 = z10;
            i12 |= composerStartRestartGroup.changed(z11) ? 32 : 16;
        } else {
            z11 = z10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2090039323, i12, -1, "cu.todus.android.uiCompose.shared.animations.attach.AnimateContainer (AttachContainer.kt:81)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new a() { // from class: m8.j
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            modifier3 = modifier4;
            AnimatedVisibilityKt.AnimatedVisibility(z11, ClickableKt.m1236clickableO2vRcR0$default(modifier4, mutableInteractionSource, null, true, "", null, (a) objRememberedValue2, 16, null), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1723003459, true, new Function3() { // from class: m8.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AttachContainerKt.AnimateContainer$lambda$2(content, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AttachContainerKt.AnimateContainer$lambda$3(modifier3, z10, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final k0 AnimateContainer$lambda$2(Function2 function2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1723003459, i10, -1, "cu.todus.android.uiCompose.shared.animations.attach.AnimateContainer.<anonymous> (AttachContainer.kt:114)");
        }
        function2.invoke(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AnimateContainer$lambda$3(Modifier modifier, boolean z10, Function2 function2, int i10, int i11, Composer composer, int i12) {
        AnimateContainer(modifier, z10, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:87:0x0165  */
    /* JADX WARN: Code duplicated, block: B:90:0x016f  */
    /* JADX WARN: Code duplicated, block: B:93:0x017c  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void AttachContainer(Modifier modifier, final boolean z10, a aVar, boolean z11, boolean z12, final Function2 content, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        a aVar2;
        int i13;
        boolean z13;
        int i14;
        int i15;
        boolean z14;
        int i16;
        int i17;
        boolean z15;
        Composer composer2;
        final Modifier modifier3;
        final a aVar3;
        final boolean z16;
        final boolean z17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final a aVar4;
        final boolean z18;
        final boolean z19;
        Object objRememberedValue;
        int i18;
        y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(437199767);
        int i19 = i11 & 1;
        if (i19 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        int i20 = i11 & 4;
        if (i20 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                aVar2 = aVar;
                i12 |= composerStartRestartGroup.changedInstance(aVar2) ? 256 : 128;
            }
            i13 = i11 & 8;
            if (i13 != 0) {
                if ((i10 & 3072) == 0) {
                    z13 = z11;
                    if (composerStartRestartGroup.changed(z13)) {
                        i14 = 2048;
                    } else {
                        i14 = 1024;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 16;
                if (i15 != 0) {
                    if ((i10 & 24576) == 0) {
                        z14 = z12;
                        if (composerStartRestartGroup.changed(z14)) {
                            i16 = 16384;
                        } else {
                            i16 = 8192;
                        }
                        i12 |= i16;
                    }
                    if ((196608 & i10) == 0) {
                        if (composerStartRestartGroup.changedInstance(content)) {
                            i18 = 131072;
                        } else {
                            i18 = 65536;
                        }
                        i12 |= i18;
                    }
                    i17 = i12;
                    if ((74899 & i17) != 74898) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z15, i17 & 1)) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i20 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new a() { // from class: m8.d
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (a) objRememberedValue;
                        } else {
                            aVar4 = aVar2;
                        }
                        if (i13 != 0) {
                            z18 = true;
                        } else {
                            z18 = z13;
                        }
                        if (i15 != 0) {
                            z19 = true;
                        } else {
                            z19 = z14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(437199767, i17, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer (AttachContainer.kt:48)");
                        }
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        int i21 = MaterialTheme.$stable;
                        z14 = z19;
                        a aVar5 = aVar4;
                        z13 = z18;
                        composer2 = composerStartRestartGroup;
                        AnimateContainer(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme.getColorScheme(composerStartRestartGroup, i21).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i21).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(3)), z10, ComposableLambdaKt.rememberComposableLambda(-249409210, true, new Function2() { // from class: m8.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AttachContainerKt.AttachContainer$lambda$1(z10, z19, aVar4, z18, content, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i17 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        aVar3 = aVar5;
                        modifier3 = modifier4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        aVar3 = aVar2;
                    }
                    Composer composer3 = composer2;
                    z16 = z13;
                    z17 = z14;
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AttachContainerKt.AttachContainer$lambda$2(modifier3, z10, aVar3, z16, z17, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 24576;
                z14 = z12;
                if ((196608 & i10) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i12 |= i18;
                }
                i17 = i12;
                if ((74899 & i17) != 74898) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z15, i17 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: m8.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i13 != 0) {
                        z18 = true;
                    } else {
                        z18 = z13;
                    }
                    if (i15 != 0) {
                        z19 = true;
                    } else {
                        z19 = z14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(437199767, i17, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer (AttachContainer.kt:48)");
                    }
                    MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                    int i22 = MaterialTheme.$stable;
                    z14 = z19;
                    a aVar6 = aVar4;
                    z13 = z18;
                    composer2 = composerStartRestartGroup;
                    AnimateContainer(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme2.getColorScheme(composerStartRestartGroup, i22).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composerStartRestartGroup, i22).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(3)), z10, ComposableLambdaKt.rememberComposableLambda(-249409210, true, new Function2() { // from class: m8.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AttachContainerKt.AttachContainer$lambda$1(z10, z19, aVar4, z18, content, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i17 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar3 = aVar6;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    aVar3 = aVar2;
                }
                Composer composer4 = composer2;
                z16 = z13;
                z17 = z14;
                scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AttachContainerKt.AttachContainer$lambda$2(modifier3, z10, aVar3, z16, z17, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 3072;
            z13 = z11;
            i15 = i11 & 16;
            if (i15 != 0) {
                if ((i10 & 24576) == 0) {
                    z14 = z12;
                    if (composerStartRestartGroup.changed(z14)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i12 |= i16;
                }
                if ((196608 & i10) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i12 |= i18;
                }
                i17 = i12;
                if ((74899 & i17) != 74898) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z15, i17 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: m8.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i13 != 0) {
                        z18 = true;
                    } else {
                        z18 = z13;
                    }
                    if (i15 != 0) {
                        z19 = true;
                    } else {
                        z19 = z14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(437199767, i17, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer (AttachContainer.kt:48)");
                    }
                    MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                    int i23 = MaterialTheme.$stable;
                    z14 = z19;
                    a aVar7 = aVar4;
                    z13 = z18;
                    composer2 = composerStartRestartGroup;
                    AnimateContainer(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme3.getColorScheme(composerStartRestartGroup, i23).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme3.getColorScheme(composerStartRestartGroup, i23).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(3)), z10, ComposableLambdaKt.rememberComposableLambda(-249409210, true, new Function2() { // from class: m8.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AttachContainerKt.AttachContainer$lambda$1(z10, z19, aVar4, z18, content, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i17 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar3 = aVar7;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    aVar3 = aVar2;
                }
                Composer composer5 = composer2;
                z16 = z13;
                z17 = z14;
                scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AttachContainerKt.AttachContainer$lambda$2(modifier3, z10, aVar3, z16, z17, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            z14 = z12;
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i12 |= i18;
            }
            i17 = i12;
            if ((74899 & i17) != 74898) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z15, i17 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: m8.d
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (i13 != 0) {
                    z18 = true;
                } else {
                    z18 = z13;
                }
                if (i15 != 0) {
                    z19 = true;
                } else {
                    z19 = z14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(437199767, i17, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer (AttachContainer.kt:48)");
                }
                MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                int i24 = MaterialTheme.$stable;
                z14 = z19;
                a aVar8 = aVar4;
                z13 = z18;
                composer2 = composerStartRestartGroup;
                AnimateContainer(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme4.getColorScheme(composerStartRestartGroup, i24).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme4.getColorScheme(composerStartRestartGroup, i24).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(3)), z10, ComposableLambdaKt.rememberComposableLambda(-249409210, true, new Function2() { // from class: m8.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AttachContainerKt.AttachContainer$lambda$1(z10, z19, aVar4, z18, content, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i17 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar3 = aVar8;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                aVar3 = aVar2;
            }
            Composer composer6 = composer2;
            z16 = z13;
            z17 = z14;
            scopeUpdateScopeEndRestartGroup = composer6.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AttachContainerKt.AttachContainer$lambda$2(modifier3, z10, aVar3, z16, z17, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        aVar2 = aVar;
        i13 = i11 & 8;
        if (i13 != 0) {
            if ((i10 & 3072) == 0) {
                z13 = z11;
                if (composerStartRestartGroup.changed(z13)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i12 |= i14;
            }
            i15 = i11 & 16;
            if (i15 != 0) {
                if ((i10 & 24576) == 0) {
                    z14 = z12;
                    if (composerStartRestartGroup.changed(z14)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i12 |= i16;
                }
                if ((196608 & i10) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i12 |= i18;
                }
                i17 = i12;
                if ((74899 & i17) != 74898) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z15, i17 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new a() { // from class: m8.d
                                @Override // lb.a
                                public final Object invoke() {
                                    return k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i13 != 0) {
                        z18 = true;
                    } else {
                        z18 = z13;
                    }
                    if (i15 != 0) {
                        z19 = true;
                    } else {
                        z19 = z14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(437199767, i17, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer (AttachContainer.kt:48)");
                    }
                    MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                    int i25 = MaterialTheme.$stable;
                    z14 = z19;
                    a aVar9 = aVar4;
                    z13 = z18;
                    composer2 = composerStartRestartGroup;
                    AnimateContainer(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme5.getColorScheme(composerStartRestartGroup, i25).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme5.getColorScheme(composerStartRestartGroup, i25).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(3)), z10, ComposableLambdaKt.rememberComposableLambda(-249409210, true, new Function2() { // from class: m8.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AttachContainerKt.AttachContainer$lambda$1(z10, z19, aVar4, z18, content, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i17 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar3 = aVar9;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    aVar3 = aVar2;
                }
                Composer composer7 = composer2;
                z16 = z13;
                z17 = z14;
                scopeUpdateScopeEndRestartGroup = composer7.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AttachContainerKt.AttachContainer$lambda$2(modifier3, z10, aVar3, z16, z17, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            z14 = z12;
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i12 |= i18;
            }
            i17 = i12;
            if ((74899 & i17) != 74898) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z15, i17 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: m8.d
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (i13 != 0) {
                    z18 = true;
                } else {
                    z18 = z13;
                }
                if (i15 != 0) {
                    z19 = true;
                } else {
                    z19 = z14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(437199767, i17, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer (AttachContainer.kt:48)");
                }
                MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                int i26 = MaterialTheme.$stable;
                z14 = z19;
                a aVar10 = aVar4;
                z13 = z18;
                composer2 = composerStartRestartGroup;
                AnimateContainer(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme6.getColorScheme(composerStartRestartGroup, i26).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme6.getColorScheme(composerStartRestartGroup, i26).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(3)), z10, ComposableLambdaKt.rememberComposableLambda(-249409210, true, new Function2() { // from class: m8.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AttachContainerKt.AttachContainer$lambda$1(z10, z19, aVar4, z18, content, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i17 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar3 = aVar10;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                aVar3 = aVar2;
            }
            Composer composer8 = composer2;
            z16 = z13;
            z17 = z14;
            scopeUpdateScopeEndRestartGroup = composer8.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AttachContainerKt.AttachContainer$lambda$2(modifier3, z10, aVar3, z16, z17, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        z13 = z11;
        i15 = i11 & 16;
        if (i15 != 0) {
            if ((i10 & 24576) == 0) {
                z14 = z12;
                if (composerStartRestartGroup.changed(z14)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i12 |= i16;
            }
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i12 |= i18;
            }
            i17 = i12;
            if ((74899 & i17) != 74898) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z15, i17 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: m8.d
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (i13 != 0) {
                    z18 = true;
                } else {
                    z18 = z13;
                }
                if (i15 != 0) {
                    z19 = true;
                } else {
                    z19 = z14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(437199767, i17, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer (AttachContainer.kt:48)");
                }
                MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                int i27 = MaterialTheme.$stable;
                z14 = z19;
                a aVar11 = aVar4;
                z13 = z18;
                composer2 = composerStartRestartGroup;
                AnimateContainer(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme7.getColorScheme(composerStartRestartGroup, i27).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme7.getColorScheme(composerStartRestartGroup, i27).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(3)), z10, ComposableLambdaKt.rememberComposableLambda(-249409210, true, new Function2() { // from class: m8.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AttachContainerKt.AttachContainer$lambda$1(z10, z19, aVar4, z18, content, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i17 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar3 = aVar11;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                aVar3 = aVar2;
            }
            Composer composer9 = composer2;
            z16 = z13;
            z17 = z14;
            scopeUpdateScopeEndRestartGroup = composer9.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AttachContainerKt.AttachContainer$lambda$2(modifier3, z10, aVar3, z16, z17, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        z14 = z12;
        if ((196608 & i10) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i18 = 131072;
            } else {
                i18 = 65536;
            }
            i12 |= i18;
        }
        i17 = i12;
        if ((74899 & i17) != 74898) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z15, i17 & 1)) {
            if (i19 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i20 != 0) {
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: m8.d
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aVar4 = (a) objRememberedValue;
            } else {
                aVar4 = aVar2;
            }
            if (i13 != 0) {
                z18 = true;
            } else {
                z18 = z13;
            }
            if (i15 != 0) {
                z19 = true;
            } else {
                z19 = z14;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(437199767, i17, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer (AttachContainer.kt:48)");
            }
            MaterialTheme materialTheme8 = MaterialTheme.INSTANCE;
            int i28 = MaterialTheme.$stable;
            z14 = z19;
            a aVar12 = aVar4;
            z13 = z18;
            composer2 = composerStartRestartGroup;
            AnimateContainer(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme8.getColorScheme(composerStartRestartGroup, i28).getBackground(), null, 2, null), Color.m5865copywmQWz5c$default(materialTheme8.getColorScheme(composerStartRestartGroup, i28).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8823constructorimpl(3)), z10, ComposableLambdaKt.rememberComposableLambda(-249409210, true, new Function2() { // from class: m8.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AttachContainerKt.AttachContainer$lambda$1(z10, z19, aVar4, z18, content, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i17 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aVar3 = aVar12;
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            aVar3 = aVar2;
        }
        Composer composer10 = composer2;
        z16 = z13;
        z17 = z14;
        scopeUpdateScopeEndRestartGroup = composer10.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AttachContainerKt.AttachContainer$lambda$2(modifier3, z10, aVar3, z16, z17, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 AttachContainer$lambda$1(boolean z10, boolean z11, final a aVar, boolean z12, Function2 function2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249409210, i10, -1, "cu.todus.android.uiCompose.shared.animations.attach.AttachContainer.<anonymous> (AttachContainer.kt:60)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (z12) {
                composer.startReplaceGroup(2043593087);
                boolean zChanged = composer.changed(aVar);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: m8.a
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachContainerKt.AttachContainer$lambda$1$0$0$0(aVar);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                DialogToDusTopBar((a) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1073059354);
                composer.endReplaceGroup();
            }
            function2.invoke(composer, 0);
            composer.endNode();
            if (z10 && z11) {
                composer.startReplaceGroup(835924539);
                boolean zChanged2 = composer.changed(aVar);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: m8.c
                        @Override // lb.a
                        public final Object invoke() {
                            return AttachContainerKt.AttachContainer$lambda$1$1$0(aVar);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                BackHandlerKt.BackHandler(false, (a) objRememberedValue2, composer, 0, 1);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(143907868);
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
    public static final k0 AttachContainer$lambda$1$0$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachContainer$lambda$1$1$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 AttachContainer$lambda$2(Modifier modifier, boolean z10, a aVar, boolean z11, boolean z12, Function2 function2, int i10, int i11, Composer composer, int i12) {
        AttachContainer(modifier, z10, aVar, z11, z12, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DialogToDusTopBar(final a onClose, Composer composer, final int i10) {
        int i11;
        y.i(onClose, "onClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(-779265912);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onClose) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-779265912, i11, -1, "cu.todus.android.uiCompose.shared.animations.attach.DialogToDusTopBar (AttachContainer.kt:121)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxWidth$default, materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground(), null, 2, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean z10 = (i11 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: m8.g
                    @Override // lb.a
                    public final Object invoke() {
                        return AttachContainerKt.DialogToDusTopBar$lambda$0$0$0(onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposableSingletons$AttachContainerKt composableSingletons$AttachContainerKt = ComposableSingletons$AttachContainerKt.INSTANCE;
            IconButtonKt.IconButton((a) objRememberedValue, null, false, null, null, null, composableSingletons$AttachContainerKt.getLambda$739750726$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "toDus", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i12).getTitleSmall(), 0L, 0L, null, null, null, FontFamilyKt.FontFamily(FontKt.m8352FontYpTlLL0$default(R.font.dosis_semibold, null, 0, 0, 14, null)), null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744415, null), materialTheme.getColorScheme(composerStartRestartGroup, i12).getPrimary(), 0, 0, composerStartRestartGroup, 48, 49);
            Modifier modifierAlpha = AlphaKt.alpha(companion, 0.0f);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new a() { // from class: m8.h
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((a) objRememberedValue2, modifierAlpha, false, null, null, null, composableSingletons$AttachContainerKt.m10078getLambda$1830987793$app_productionPFast(), composerStartRestartGroup, 1572918, 60);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m8.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AttachContainerKt.DialogToDusTopBar$lambda$1(onClose, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DialogToDusTopBar$lambda$0$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DialogToDusTopBar$lambda$1(a aVar, int i10, Composer composer, int i11) {
        DialogToDusTopBar(aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
