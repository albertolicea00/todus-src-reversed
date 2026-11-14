package cu.z17.views.label;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.view.GravityCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.utils.Z17Markown;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001aK\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "text", "Landroidx/compose/ui/text/TextStyle;", "style", "Lkotlin/Function0;", "Lua/k0;", "onClick", "onLongClick", "Z17MarkdownLabel", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "", "sp", "Landroid/content/Context;", "context", "", "spToPx", "(ILandroid/content/Context;)F", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17MarkdownLabelKt {
    /* JADX WARN: Code duplicated, block: B:100:0x013f  */
    /* JADX WARN: Code duplicated, block: B:103:0x014a  */
    /* JADX WARN: Code duplicated, block: B:104:0x014d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0156  */
    /* JADX WARN: Code duplicated, block: B:108:0x0159  */
    /* JADX WARN: Code duplicated, block: B:111:0x0162  */
    /* JADX WARN: Code duplicated, block: B:113:0x016a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0178  */
    /* JADX WARN: Code duplicated, block: B:119:0x0180  */
    /* JADX WARN: Code duplicated, block: B:121:0x0188  */
    /* JADX WARN: Code duplicated, block: B:124:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:84:0x0108  */
    /* JADX WARN: Code duplicated, block: B:88:0x011d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0129  */
    /* JADX WARN: Code duplicated, block: B:93:0x012f  */
    /* JADX WARN: Code duplicated, block: B:99:0x013c  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Z17MarkdownLabel(Modifier modifier, final String text, TextStyle textStyle, lb.a aVar, lb.a aVar2, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        TextStyle textStyle2;
        lb.a aVar3;
        int i13;
        final lb.a aVar4;
        int i14;
        boolean z10;
        final Modifier modifier3;
        final TextStyle bodyMedium;
        final lb.a aVar5;
        final lb.a aVar6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i15;
        boolean z11;
        boolean z12;
        int i16;
        boolean z13;
        boolean z14;
        Object objRememberedValue3;
        boolean z15;
        Object objRememberedValue4;
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(195154050);
        int i17 = i11 & 1;
        if (i17 != 0) {
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
            i12 |= composerStartRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                textStyle2 = textStyle;
                int i18 = composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                i12 |= i18;
            } else {
                textStyle2 = textStyle;
            }
            i12 |= i18;
        } else {
            textStyle2 = textStyle;
        }
        int i19 = i11 & 8;
        if (i19 == 0) {
            if ((i10 & 3072) == 0) {
                aVar3 = aVar;
                i12 |= composerStartRestartGroup.changedInstance(aVar3) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    aVar4 = aVar2;
                    if (composerStartRestartGroup.changedInstance(aVar4)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                if ((i12 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i11 & 4) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i12 &= -897;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if (i19 != 0) {
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new lb.a() { // from class: cu.z17.views.label.d0
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            aVar3 = (lb.a) objRememberedValue2;
                        }
                        if (i13 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.label.e0
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (lb.a) objRememberedValue;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 4) != 0) {
                            i12 &= -897;
                        }
                        modifier4 = modifier2;
                        bodyMedium = textStyle2;
                    }
                    i15 = i12;
                    aVar5 = aVar3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(195154050, i15, -1, "cu.z17.views.label.Z17MarkdownLabel (Z17MarkdownLabel.kt:22)");
                    }
                    boolean z16 = (((i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 && composerStartRestartGroup.changed(bodyMedium)) || (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                    if ((i15 & 7168) == 2048) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z17 = z16 | z11;
                    if ((57344 & i15) == 16384) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z18 = z17 | z12;
                    i16 = i15 & 112;
                    if (i16 == 32) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = z18 | z13;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z14 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.f0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8(bodyMedium, text, aVar5, aVar4, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function1 = (Function1) objRememberedValue3;
                    z15 = i16 == 32;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.label.g0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$11$lambda$10(text, (TextView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Modifier modifier5 = modifier4;
                    AndroidView_androidKt.AndroidView(function1, modifier5, (Function1) objRememberedValue4, composerStartRestartGroup, (i15 << 3) & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    bodyMedium = textStyle2;
                    aVar5 = aVar3;
                }
                aVar6 = aVar4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$12(modifier3, text, bodyMedium, aVar5, aVar6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            aVar4 = aVar2;
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 4) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i12 &= -897;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i19 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.label.d0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar3 = (lb.a) objRememberedValue2;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.e0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    }
                } else {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 4) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i12 &= -897;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i19 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.label.d0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar3 = (lb.a) objRememberedValue2;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.e0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    }
                }
                i15 = i12;
                aVar5 = aVar3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(195154050, i15, -1, "cu.z17.views.label.Z17MarkdownLabel (Z17MarkdownLabel.kt:22)");
                }
                if (((i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
                }
                if ((i15 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z19 = z16 | z11;
                if ((57344 & i15) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z110 = z19 | z12;
                i16 = i15 & 112;
                if (i16 == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z110 | z13;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.f0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8(bodyMedium, text, aVar5, aVar4, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.f0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8(bodyMedium, text, aVar5, aVar4, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function1 function2 = (Function1) objRememberedValue3;
                if (i16 == 32) {
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.label.g0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$11$lambda$10(text, (TextView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.label.g0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$11$lambda$10(text, (TextView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Modifier modifier6 = modifier4;
                AndroidView_androidKt.AndroidView(function2, modifier6, (Function1) objRememberedValue4, composerStartRestartGroup, (i15 << 3) & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                bodyMedium = textStyle2;
                aVar5 = aVar3;
            }
            aVar6 = aVar4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$12(modifier3, text, bodyMedium, aVar5, aVar6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        aVar3 = aVar;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                aVar4 = aVar2;
                if (composerStartRestartGroup.changedInstance(aVar4)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 4) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i12 &= -897;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i19 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.label.d0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar3 = (lb.a) objRememberedValue2;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.e0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    }
                } else {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 4) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i12 &= -897;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i19 != 0) {
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.z17.views.label.d0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        aVar3 = (lb.a) objRememberedValue2;
                    }
                    if (i13 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.e0
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    }
                }
                i15 = i12;
                aVar5 = aVar3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(195154050, i15, -1, "cu.z17.views.label.Z17MarkdownLabel (Z17MarkdownLabel.kt:22)");
                }
                if (((i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
                }
                if ((i15 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z111 = z16 | z11;
                if ((57344 & i15) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z112 = z111 | z12;
                i16 = i15 & 112;
                if (i16 == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z112 | z13;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.f0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8(bodyMedium, text, aVar5, aVar4, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.f0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8(bodyMedium, text, aVar5, aVar4, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function1 function3 = (Function1) objRememberedValue3;
                if (i16 == 32) {
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.label.g0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$11$lambda$10(text, (TextView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.label.g0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$11$lambda$10(text, (TextView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Modifier modifier7 = modifier4;
                AndroidView_androidKt.AndroidView(function3, modifier7, (Function1) objRememberedValue4, composerStartRestartGroup, (i15 << 3) & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                bodyMedium = textStyle2;
                aVar5 = aVar3;
            }
            aVar6 = aVar4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$12(modifier3, text, bodyMedium, aVar5, aVar6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        aVar4 = aVar2;
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i17 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 4) != 0) {
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    i12 &= -897;
                } else {
                    bodyMedium = textStyle2;
                }
                if (i19 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.z17.views.label.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar3 = (lb.a) objRememberedValue2;
                }
                if (i13 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.label.e0
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (lb.a) objRememberedValue;
                }
            } else {
                if (i17 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 4) != 0) {
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    i12 &= -897;
                } else {
                    bodyMedium = textStyle2;
                }
                if (i19 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.z17.views.label.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    aVar3 = (lb.a) objRememberedValue2;
                }
                if (i13 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.label.e0
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (lb.a) objRememberedValue;
                }
            }
            i15 = i12;
            aVar5 = aVar3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(195154050, i15, -1, "cu.z17.views.label.Z17MarkdownLabel (Z17MarkdownLabel.kt:22)");
            }
            if (((i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
            }
            if ((i15 & 7168) == 2048) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z113 = z16 | z11;
            if ((57344 & i15) == 16384) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean z114 = z113 | z12;
            i16 = i15 & 112;
            if (i16 == 32) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = z114 | z13;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z14) {
                objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8(bodyMedium, text, aVar5, aVar4, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8(bodyMedium, text, aVar5, aVar4, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function4 = (Function1) objRememberedValue3;
            if (i16 == 32) {
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z15) {
                objRememberedValue4 = new Function1() { // from class: cu.z17.views.label.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$11$lambda$10(text, (TextView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: cu.z17.views.label.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$11$lambda$10(text, (TextView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifier8 = modifier4;
            AndroidView_androidKt.AndroidView(function4, modifier8, (Function1) objRememberedValue4, composerStartRestartGroup, (i15 << 3) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            bodyMedium = textStyle2;
            aVar5 = aVar3;
        }
        aVar6 = aVar4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$12(modifier3, text, bodyMedium, aVar5, aVar6, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17MarkdownLabel$lambda$11$lambda$10(String str, TextView it) {
        kotlin.jvm.internal.y.i(it, "it");
        Z17Markown.INSTANCE.getInstance().getMarkwon().b(it, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17MarkdownLabel$lambda$12(Modifier modifier, String str, TextStyle textStyle, lb.a aVar, lb.a aVar2, int i10, int i11, Composer composer, int i12) {
        Z17MarkdownLabel(modifier, str, textStyle, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView Z17MarkdownLabel$lambda$9$lambda$8(TextStyle textStyle, String str, final lb.a aVar, final lb.a aVar2, final Context c10) {
        int i10;
        kotlin.jvm.internal.y.i(c10, "c");
        float fSpToPx = spToPx((int) Math.max((TextUnit.m9013getValueimpl(textStyle.m8297getLineHeightXSAIIZE()) - TextUnit.m9013getValueimpl(textStyle.m8289getFontSizeXSAIIZE())) - 3.0f, 0.0f), c10);
        int iM8299getTextAligne0LSkKk = textStyle.m8299getTextAligne0LSkKk();
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m8688equalsimpl0(iM8299getTextAligne0LSkKk, companion.m8692getCentere0LSkKk())) {
            i10 = 17;
        } else {
            i10 = TextAlign.m8688equalsimpl0(iM8299getTextAligne0LSkKk, companion.m8693getEnde0LSkKk()) ? GravityCompat.END : GravityCompat.START;
        }
        TextView textView = new TextView(c10);
        textView.setTextSize(TextUnit.m9013getValueimpl(textStyle.m8289getFontSizeXSAIIZE()));
        textView.setLineSpacing(fSpToPx, 1.0f);
        textView.setTextColor(ColorKt.m5920toArgb8_81llA(textStyle.m8288getColor0d7_KjU()));
        textView.setGravity(i10);
        textView.setOnClickListener(new View.OnClickListener() { // from class: cu.z17.views.label.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aVar.invoke();
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.z17.views.label.j0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8$lambda$6$lambda$5(aVar2, view);
            }
        });
        Z17Markown.INSTANCE.createInstance(new lb.a() { // from class: cu.z17.views.label.k0
            @Override // lb.a
            public final Object invoke() {
                return Z17MarkdownLabelKt.Z17MarkdownLabel$lambda$9$lambda$8$lambda$7(c10);
            }
        }).getMarkwon().b(textView, str);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17MarkdownLabel$lambda$9$lambda$8$lambda$6$lambda$5(lb.a aVar, View view) {
        aVar.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Z17Markown Z17MarkdownLabel$lambda$9$lambda$8$lambda$7(Context context) {
        return new Z17Markown(context);
    }

    public static final float spToPx(int i10, Context context) {
        kotlin.jvm.internal.y.i(context, "context");
        return TypedValue.applyDimension(2, i10, context.getResources().getDisplayMetrics());
    }
}
