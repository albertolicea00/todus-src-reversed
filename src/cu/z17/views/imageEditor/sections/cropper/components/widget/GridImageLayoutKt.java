package cu.z17.views.imageEditor.sections.cropper.components.widget;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import defpackage.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aO\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001c\b\u0002\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a<\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "", "thumbnails", "Landroidx/compose/ui/unit/Dp;", "divider", "Lkotlin/Function1;", "Lua/k0;", "onClick", "GridImageLayout-942rkJo", "(Landroidx/compose/ui/Modifier;Ljava/util/List;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "GridImageLayout", "itemCount", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "ImageDrawLayout-942rkJo", "(Landroidx/compose/ui/Modifier;IFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ImageDrawLayout", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GridImageLayoutKt {
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:64:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:72:0x010b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0118  */
    /* JADX WARN: Code duplicated, block: B:78:0x0120  */
    /* JADX WARN: Code duplicated, block: B:81:0x012c  */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: GridImageLayout-942rkJo, reason: not valid java name */
    public static final void m10240GridImageLayout942rkJo(Modifier modifier, final List<Integer> thumbnails, float f10, Function1 function1, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        float fM8823constructorimpl;
        int i13;
        Function1 function2;
        int i14;
        boolean z10;
        final Modifier modifier3;
        final Function1 function3;
        final float f11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final Function1 function4;
        boolean z11;
        boolean zChangedInstance;
        Object objRememberedValue;
        y.i(thumbnails, "thumbnails");
        Composer composerStartRestartGroup = composer.startRestartGroup(1173849081);
        int i15 = i11 & 1;
        if (i15 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(thumbnails) ? 32 : 16;
        }
        int i16 = i11 & 4;
        if (i16 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                fM8823constructorimpl = f10;
                i12 |= composerStartRestartGroup.changed(fM8823constructorimpl) ? 256 : 128;
            }
            i13 = i11 & 8;
            if (i13 != 0) {
                if ((i10 & 3072) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 2048;
                    } else {
                        i14 = 1024;
                    }
                    i12 |= i14;
                }
                if ((i12 & 1171) != 1170) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    if (i15 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(2);
                    }
                    if (i13 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1173849081, i12, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.GridImageLayout (GridImageLayout.kt:32)");
                    }
                    if (thumbnails.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(513079465);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(514480789);
                        if ((i12 & 7168) == 2048) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        zChangedInstance = z11 | composerStartRestartGroup.changedInstance(thumbnails);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.m
                                @Override // lb.a
                                public final Object invoke() {
                                    return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$1$lambda$0(function4, thumbnails);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        m10241ImageDrawLayout942rkJo(ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null), thumbnails.size(), fM8823constructorimpl, ComposableLambdaKt.rememberComposableLambda(2130491855, true, new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.n
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$5(thumbnails, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 896) | 3072, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function3 = function2;
                }
                f11 = fM8823constructorimpl;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$6(modifier3, thumbnails, f11, function3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 3072;
            function2 = function1;
            if ((i12 & 1171) != 1170) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i16 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(2);
                }
                if (i13 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1173849081, i12, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.GridImageLayout (GridImageLayout.kt:32)");
                }
                if (thumbnails.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(514480789);
                    if ((i12 & 7168) == 2048) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zChangedInstance = z11 | composerStartRestartGroup.changedInstance(thumbnails);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.m
                            @Override // lb.a
                            public final Object invoke() {
                                return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$1$lambda$0(function4, thumbnails);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.m
                            @Override // lb.a
                            public final Object invoke() {
                                return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$1$lambda$0(function4, thumbnails);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    m10241ImageDrawLayout942rkJo(ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null), thumbnails.size(), fM8823constructorimpl, ComposableLambdaKt.rememberComposableLambda(2130491855, true, new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$5(thumbnails, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 896) | 3072, 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(513079465);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = function2;
            }
            f11 = fM8823constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$6(modifier3, thumbnails, f11, function3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        fM8823constructorimpl = f10;
        i13 = i11 & 8;
        if (i13 != 0) {
            if ((i10 & 3072) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i12 |= i14;
            }
            if ((i12 & 1171) != 1170) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i16 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(2);
                }
                if (i13 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1173849081, i12, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.GridImageLayout (GridImageLayout.kt:32)");
                }
                if (thumbnails.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(514480789);
                    if ((i12 & 7168) == 2048) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zChangedInstance = z11 | composerStartRestartGroup.changedInstance(thumbnails);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.m
                            @Override // lb.a
                            public final Object invoke() {
                                return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$1$lambda$0(function4, thumbnails);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.m
                            @Override // lb.a
                            public final Object invoke() {
                                return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$1$lambda$0(function4, thumbnails);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    m10241ImageDrawLayout942rkJo(ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null), thumbnails.size(), fM8823constructorimpl, ComposableLambdaKt.rememberComposableLambda(2130491855, true, new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$5(thumbnails, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 896) | 3072, 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(513079465);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = function2;
            }
            f11 = fM8823constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$6(modifier3, thumbnails, f11, function3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        function2 = function1;
        if ((i12 & 1171) != 1170) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            if (i15 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i16 != 0) {
                fM8823constructorimpl = Dp.m8823constructorimpl(2);
            }
            if (i13 != 0) {
                function4 = null;
            } else {
                function4 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1173849081, i12, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.GridImageLayout (GridImageLayout.kt:32)");
            }
            if (thumbnails.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(514480789);
                if ((i12 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zChangedInstance = z11 | composerStartRestartGroup.changedInstance(thumbnails);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.m
                        @Override // lb.a
                        public final Object invoke() {
                            return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$1$lambda$0(function4, thumbnails);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.m
                        @Override // lb.a
                        public final Object invoke() {
                            return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$1$lambda$0(function4, thumbnails);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                m10241ImageDrawLayout942rkJo(ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null), thumbnails.size(), fM8823constructorimpl, ComposableLambdaKt.rememberComposableLambda(2130491855, true, new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$5(thumbnails, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 896) | 3072, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(513079465);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function4;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function3 = function2;
        }
        f11 = fM8823constructorimpl;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GridImageLayoutKt.GridImageLayout_942rkJo$lambda$6(modifier3, thumbnails, f11, function3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 GridImageLayout_942rkJo$lambda$1$lambda$0(Function1 function1, List list) {
        if (function1 != null) {
            function1.invoke(list);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 GridImageLayout_942rkJo$lambda$5(List list, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2130491855, i10, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.GridImageLayout.<anonymous> (GridImageLayout.kt:44)");
            }
            int size = list.size();
            if (size < 5) {
                composer.startReplaceGroup(-1543771535);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ImageKt.Image(PainterResources_androidKt.painterResource(((Number) it.next()).intValue(), composer, 0), "Icon", (Modifier) null, (Alignment) null, ContentScale.INSTANCE.getCrop(), 0.0f, (ColorFilter) null, composer, 24624, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1543470680);
                composer.startReplaceGroup(-1296714451);
                Iterator it2 = g0.g1(list, 3).iterator();
                while (it2.hasNext()) {
                    ImageKt.Image(PainterResources_androidKt.painterResource(((Number) it2.next()).intValue(), composer, 0), "Icon", (Modifier) null, (Alignment) null, ContentScale.INSTANCE.getCrop(), 0.0f, (ColorFilter) null, composer, 24624, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
                }
                composer.endReplaceGroup();
                Alignment center = Alignment.INSTANCE.getCenter();
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                TextKt.m3848Text4IGK_g("+" + (size - 3), (Modifier) null, 0L, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 3072, 0, 131062);
                composer.endNode();
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
    public static final k0 GridImageLayout_942rkJo$lambda$6(Modifier modifier, List list, float f10, Function1 function1, int i10, int i11, Composer composer, int i12) {
        m10240GridImageLayout942rkJo(modifier, list, f10, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ImageDrawLayout-942rkJo, reason: not valid java name */
    private static final void m10241ImageDrawLayout942rkJo(Modifier modifier, final int i10, final float f10, final Function2 function2, Composer composer, final int i11, final int i12) {
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(983870674);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(f10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 1171) != 1170, i13 & 1)) {
            if (i14 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(983870674, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.widget.ImageDrawLayout (GridImageLayout.kt:80)");
            }
            int iMo1339roundToPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1339roundToPx0680j_4(f10);
            boolean zChanged = composerStartRestartGroup.changed(iMo1339roundToPx0680j_4) | ((i13 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new GridImageLayoutKt$ImageDrawLayout$measurePolicy$1$1(i10, iMo1339roundToPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int i15 = ((i13 >> 9) & 14) | ((i13 << 3) & 112);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            int i16 = ((i15 << 6) & 896) | 6;
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i16 >> 6) & 14));
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.widget.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GridImageLayoutKt.ImageDrawLayout_942rkJo$lambda$9(modifier2, i10, f10, function2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageDrawLayout_942rkJo$lambda$9(Modifier modifier, int i10, float f10, Function2 function2, int i11, int i12, Composer composer, int i13) {
        m10241ImageDrawLayout942rkJo(modifier, i10, f10, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
