package cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.TextEditorKt;
import cu.todus.android.uiCompose.theme.TypeKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import defpackage.l;
import defpackage.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import lb.o;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u001ag\u0010\f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022$\u0010\t\u001a \u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a1\u0010\u0011\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a1\u0010\u0013\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u001b²\u0006\u000e\u0010\u0014\u001a\u00020\u00008\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0016\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0018\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0019\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002"}, d2 = {"", "initialValue", "", "Landroidx/compose/ui/graphics/Color;", "colors", "invertedColors", "Lkotlin/Function4;", "", "Lua/k0;", "onCreate", "Lkotlin/Function0;", "onCancel", "TextEditor", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Llb/o;Llb/a;Landroidx/compose/runtime/Composer;I)V", "fonts", "Lkotlin/Function1;", "onSelected", "FontSelector", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ColorSelector", "textValue", "", "textColorInverted", "fontSelected", "backgroundSelected", "showTypoSelector", "showBackgroundColorSelector", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TextEditorKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ColorSelector(final List<Color> colors, final Function1 onSelected, Composer composer, final int i10) {
        int i11;
        y.i(colors, "colors");
        y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1292257915);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(colors) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onSelected) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1292257915, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.ColorSelector (TextEditor.kt:319)");
            }
            float f10 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(f10)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f10));
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(colors) | ((i11 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: h8.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextEditorKt.ColorSelector$lambda$0$0(colors, onSelected, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyRow(modifierM1725padding3ABfNKs, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h8.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditorKt.ColorSelector$lambda$1(colors, onSelected, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ColorSelector$lambda$0$0(final List list, final Function1 function1, LazyListScope LazyRow) {
        y.i(LazyRow, "$this$LazyRow");
        LazyListScope.CC.o(LazyRow, list.size(), new Function1() { // from class: h8.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextEditorKt.ColorSelector$lambda$0$0$0(list, ((Integer) obj).intValue());
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(129987161, true, new o() { // from class: h8.r
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TextEditorKt.ColorSelector$lambda$0$0$1(function1, list, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ColorSelector$lambda$0$0$0(List list, int i10) {
        return Integer.valueOf(Color.m5873hashCodeimpl(((Color) list.get(i10)).m5876unboximpl()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ColorSelector$lambda$0$0$1(final Function1 function1, final List list, LazyItemScope items, final int i10, Composer composer, int i11) {
        int i12;
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(129987161, i12, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.ColorSelector.<anonymous>.<anonymous>.<anonymous> (TextEditor.kt:333)");
            }
            float f10 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(f10)), Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10));
            boolean zChanged = composer.changed(function1) | ((i12 & 112) == 32);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: h8.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return TextEditorKt.ColorSelector$lambda$0$0$1$0$0(function1, i10);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((a) objRememberedValue, modifierM1725padding3ABfNKs, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-2040307589, true, new Function2() { // from class: h8.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditorKt.ColorSelector$lambda$0$0$1$1(list, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ColorSelector$lambda$0$0$1$0$0(Function1 function1, int i10) {
        function1.invoke(Integer.valueOf(i10));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ColorSelector$lambda$0$0$1$1(List list, int i10, Composer composer, int i11) {
        if (composer.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2040307589, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.ColorSelector.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TextEditor.kt:345)");
            }
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), Color.m5856boximpl(((Color) list.get(i10)).m5876unboximpl()), null, null, null, 0, null, false, null, null, false, 0, composer, 6, 0, 4092);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ColorSelector$lambda$1(List list, Function1 function1, int i10, Composer composer, int i11) {
        ColorSelector(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void FontSelector(final List<Integer> fonts, final Function1 onSelected, Composer composer, final int i10) {
        int i11;
        y.i(fonts, "fonts");
        y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(1353999373);
        if ((i10 & 48) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onSelected) ? 32 : 16) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 17) != 16, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1353999373, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.FontSelector (TextEditor.kt:277)");
            }
            float f10 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(f10)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f10));
            boolean z10 = (i11 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: h8.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextEditorKt.FontSelector$lambda$0$0(onSelected, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyRow(modifierM1725padding3ABfNKs, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h8.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditorKt.FontSelector$lambda$1(fonts, onSelected, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FontSelector$lambda$0$0(final Function1 function1, LazyListScope LazyRow) {
        y.i(LazyRow, "$this$LazyRow");
        LazyListScope.CC.o(LazyRow, TypeKt.getStatusFonts().size(), new Function1() { // from class: h8.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextEditorKt.FontSelector$lambda$0$0$0(((Integer) obj).intValue());
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-124142407, true, new o() { // from class: h8.u
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TextEditorKt.FontSelector$lambda$0$0$1(function1, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FontSelector$lambda$0$0$0(int i10) {
        return Integer.valueOf(TypeKt.getStatusFonts().get(i10).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 FontSelector$lambda$0$0$1(final Function1 function1, LazyItemScope items, final int i10, Composer composer, int i11) {
        int i12;
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-124142407, i12, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.FontSelector.<anonymous>.<anonymous>.<anonymous> (TextEditor.kt:291)");
            }
            float f10 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(f10)), Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10));
            boolean zChanged = composer.changed(function1) | ((i12 & 112) == 32);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: h8.p
                    @Override // lb.a
                    public final Object invoke() {
                        return TextEditorKt.FontSelector$lambda$0$0$1$0$0(function1, i10);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((a) objRememberedValue, modifierM1725padding3ABfNKs, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(2022605399, true, new Function2() { // from class: h8.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditorKt.FontSelector$lambda$0$0$1$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FontSelector$lambda$0$0$1$0$0(Function1 function1, int i10) {
        function1.invoke(Integer.valueOf(i10));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 FontSelector$lambda$0$0$1$1(int i10, Composer composer, int i11) {
        if (composer.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2022605399, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.FontSelector.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TextEditor.kt:303)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "Tt", TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), 0L, 0L, null, null, null, FontFamilyKt.FontFamily(FontKt.m8352FontYpTlLL0$default(TypeKt.getStatusFonts().get(i10).intValue(), null, 0, 0, 14, null)), null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777183, null), 0L, 0, 0, composer, 48, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FontSelector$lambda$1(List list, Function1 function1, int i10, Composer composer, int i11) {
        FontSelector(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextEditor(final String initialValue, final List<Color> list, final List<Color> invertedColors, final o onCreate, final a onCancel, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        final List<Color> colors = list;
        y.i(initialValue, "initialValue");
        y.i(colors, "colors");
        y.i(invertedColors, "invertedColors");
        y.i(onCreate, "onCreate");
        y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1785256073);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(initialValue) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(colors) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(invertedColors) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCreate) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1785256073, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.TextEditor (TextEditor.kt:61)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialValue, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue4;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue5;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue6;
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue7;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), colors.get(mutableIntState2.getIntValue()).m5876unboximpl(), null, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical center = arrangement.getCenter();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, companion3.getCenterHorizontally(), composerStartRestartGroup, 54);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            float f10 = 3;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), Color.m5865copywmQWz5c$default(invertedColors.get(mutableIntState2.getIntValue()).m5876unboximpl(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10));
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = new a() { // from class: h8.f
                    @Override // lb.a
                    public final Object invoke() {
                        return TextEditorKt.TextEditor$lambda$19$0$0$0(mutableState4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposableSingletons$TextEditorKt composableSingletons$TextEditorKt = ComposableSingletons$TextEditorKt.INSTANCE;
            IconButtonKt.IconButton((a) objRememberedValue8, modifierM1725padding3ABfNKs, false, null, null, null, composableSingletons$TextEditorKt.m9988getLambda$1516086273$app_productionPFast(), composerStartRestartGroup, 1572870, 60);
            float f11 = 5;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), Color.m5865copywmQWz5c$default(invertedColors.get(mutableIntState2.getIntValue()).m5876unboximpl(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10));
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new a() { // from class: h8.g
                    @Override // lb.a
                    public final Object invoke() {
                        return TextEditorKt.TextEditor$lambda$19$0$1$0(mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            IconButtonKt.IconButton((a) objRememberedValue9, modifierM1725padding3ABfNKs2, false, null, null, null, composableSingletons$TextEditorKt.getLambda$824330792$app_productionPFast(), composerStartRestartGroup, 1572870, 60);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
            Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), Color.m5865copywmQWz5c$default(invertedColors.get(mutableIntState2.getIntValue()).m5876unboximpl(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10));
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new a() { // from class: h8.h
                    @Override // lb.a
                    public final Object invoke() {
                        return TextEditorKt.TextEditor$lambda$19$0$2$0(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            IconButtonKt.IconButton((a) objRememberedValue10, modifierM1725padding3ABfNKs3, false, null, null, null, composableSingletons$TextEditorKt.m9989getLambda$1673186041$app_productionPFast(), composerStartRestartGroup, 1572870, 60);
            colors = list;
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, !d0.q0(TextEditor$lambda$1(mutableState)), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1282145915, true, new Function3() { // from class: h8.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextEditorKt.TextEditor$lambda$19$0$3(onCreate, list, mutableState, mutableState2, mutableIntState2, mutableIntState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572870, 30);
            composerStartRestartGroup.endNode();
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            String strTextEditor$lambda$1 = TextEditor$lambda$1(mutableState);
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), !TextEditor$lambda$4(mutableState2) ? Color.INSTANCE.m5892getBlack0d7_KjU() : Color.INSTANCE.m5903getWhite0d7_KjU(), 0L, null, null, null, FontFamilyKt.FontFamily(FontKt.m8352FontYpTlLL0$default(TypeKt.getStatusFonts().get(mutableIntState.getIntValue()).intValue(), null, 0, 0, 14, null)), null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744414, null);
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue11 == companion.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: h8.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextEditorKt.TextEditor$lambda$19$1$0(mutableState, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            BasicTextFieldKt.BasicTextField(strTextEditor$lambda$1, (Function1) objRememberedValue11, modifierVerticalScroll$default, false, false, textStyleM8271copyp1EtxEg$default, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (VisualTransformation) null, (Function1) null, mutableInteractionSource, (Brush) null, (Function3) ComposableLambdaKt.rememberComposableLambda(2078842148, true, new Function3() { // from class: h8.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextEditorKt.TextEditor$lambda$19$2(mutableInteractionSource, mutableState, mutableIntState, mutableState2, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 199680, 24536);
            composer2 = composerStartRestartGroup;
            if (TextEditor$lambda$14(mutableState3)) {
                composer2.startReplaceGroup(455388830);
                Alignment topCenter = companion3.getTopCenter();
                Object objRememberedValue12 = composer2.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new a() { // from class: h8.l
                        @Override // lb.a
                        public final Object invoke() {
                            return TextEditorKt.TextEditor$lambda$19$3$0(mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                AndroidPopup_androidKt.m9081PopupK5zGePQ(topCenter, 0L, (a) objRememberedValue12, null, ComposableLambdaKt.rememberComposableLambda(1283592425, true, new Function2() { // from class: h8.m
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextEditorKt.TextEditor$lambda$19$4(mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, 24966, 10);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1232425729);
                composer2.endReplaceGroup();
            }
            if (TextEditor$lambda$17(mutableState4)) {
                composer2.startReplaceGroup(455400702);
                Alignment topCenter2 = companion3.getTopCenter();
                Object objRememberedValue13 = composer2.rememberedValue();
                if (objRememberedValue13 == companion.getEmpty()) {
                    objRememberedValue13 = new a() { // from class: h8.c0
                        @Override // lb.a
                        public final Object invoke() {
                            return TextEditorKt.TextEditor$lambda$19$5$0(mutableState4);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                }
                Composer composer3 = composer2;
                AndroidPopup_androidKt.m9081PopupK5zGePQ(topCenter2, 0L, (a) objRememberedValue13, null, ComposableLambdaKt.rememberComposableLambda(-587537070, true, new Function2() { // from class: h8.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextEditorKt.TextEditor$lambda$19$6(colors, mutableIntState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer3, 24966, 10);
                composer2 = composer3;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1232793761);
                composer2.endReplaceGroup();
            }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h8.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditorKt.TextEditor$lambda$20(initialValue, colors, invertedColors, onCreate, onCancel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String TextEditor$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean TextEditor$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TextEditor$lambda$15(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean TextEditor$lambda$17(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TextEditor$lambda$18(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$0$0$0(MutableState mutableState) {
        TextEditor$lambda$18(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$0$1$0(MutableState mutableState) {
        TextEditor$lambda$15(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$0$2$0(MutableState mutableState) {
        TextEditor$lambda$5(mutableState, !TextEditor$lambda$4(mutableState));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 TextEditor$lambda$19$0$3(final o oVar, final List list, final MutableState mutableState, final MutableState mutableState2, final MutableIntState mutableIntState, final MutableIntState mutableIntState2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1282145915, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.TextEditor.<anonymous>.<anonymous>.<anonymous> (TextEditor.kt:161)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(25)), composer, 6);
        boolean zChanged = composer.changed(oVar) | composer.changedInstance(list);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            a aVar = new a() { // from class: h8.e
                @Override // lb.a
                public final Object invoke() {
                    return TextEditorKt.TextEditor$lambda$19$0$3$0$0$0(oVar, list, mutableState, mutableState2, mutableIntState, mutableIntState2);
                }
            };
            composer.updateRememberedValue(aVar);
            objRememberedValue = aVar;
        }
        IconButtonKt.IconButton((a) objRememberedValue, null, false, null, null, null, ComposableSingletons$TextEditorKt.INSTANCE.getLambda$1247733699$app_productionPFast(), composer, 1572864, 62);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$0$3$0$0$0(o oVar, List list, MutableState mutableState, MutableState mutableState2, MutableIntState mutableIntState, MutableIntState mutableIntState2) {
        oVar.invoke(TextEditor$lambda$1(mutableState), Integer.valueOf(Color.m5873hashCodeimpl(TextEditor$lambda$4(mutableState2) ? Color.INSTANCE.m5903getWhite0d7_KjU() : Color.INSTANCE.m5892getBlack0d7_KjU())), Integer.valueOf(Color.m5873hashCodeimpl(((Color) list.get(mutableIntState.getIntValue())).m5876unboximpl())), Integer.valueOf(mutableIntState2.getIntValue()));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$1$0(MutableState mutableState, String it) {
        y.i(it, "it");
        if (it.length() < 512) {
            mutableState.setValue(it);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final k0 TextEditor$lambda$19$2(MutableInteractionSource mutableInteractionSource, MutableState mutableState, final MutableIntState mutableIntState, final MutableState mutableState2, Function2 innerTextField, Composer composer, int i10) {
        int i11;
        y.i(innerTextField, "innerTextField");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(innerTextField) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078842148, i11, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.TextEditor.<anonymous>.<anonymous> (TextEditor.kt:206)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String strTextEditor$lambda$1 = TextEditor$lambda$1(mutableState);
            VisualTransformation none = VisualTransformation.INSTANCE.getNone();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-473866660, true, new Function2() { // from class: h8.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditorKt.TextEditor$lambda$19$2$0(mutableIntState, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            Shape shape = textFieldDefaults.getShape(composer, 6);
            Color.Companion companion = Color.INSTANCE;
            textFieldDefaults.DecorationBox(strTextEditor$lambda$1, innerTextField, true, false, none, mutableInteractionSource, false, null, composableLambdaRememberComposableLambda, null, null, null, null, null, shape, textFieldDefaults.m3830colors0hiis_0(0L, 0L, 0L, 0L, companion.m5901getTransparent0d7_KjU(), companion.m5901getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, null, companion.m5901getTransparent0d7_KjU(), companion.m5901getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 221184, 432, 0, 0, 3072, 2147477455, 4095), null, null, composer, ((i11 << 3) & 112) | 920350080, 100666806, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
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
    public static final k0 TextEditor$lambda$19$2$0(MutableIntState mutableIntState, MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473866660, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.TextEditor.<anonymous>.<anonymous>.<anonymous> (TextEditor.kt:216)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(5)), 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.whats_on_your_mind, composer, 0), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0L, null, null, null, FontFamilyKt.FontFamily(FontKt.m8352FontYpTlLL0$default(TypeKt.getStatusFonts().get(mutableIntState.getIntValue()).intValue(), null, 0, 0, 14, null)), null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744415, null), Color.m5865copywmQWz5c$default(!TextEditor$lambda$4(mutableState) ? Color.INSTANCE.m5892getBlack0d7_KjU() : Color.INSTANCE.m5903getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0, 0, composer, 6, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$3$0(MutableState mutableState) {
        TextEditor$lambda$15(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 TextEditor$lambda$19$4(final MutableIntState mutableIntState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1283592425, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.TextEditor.<anonymous>.<anonymous> (TextEditor.kt:258)");
            }
            List<Integer> statusFonts = TypeKt.getStatusFonts();
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: h8.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextEditorKt.TextEditor$lambda$19$4$0$0(mutableIntState, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            FontSelector(statusFonts, (Function1) objRememberedValue, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$4$0$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$5$0(MutableState mutableState) {
        TextEditor$lambda$18(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 TextEditor$lambda$19$6(List list, final MutableIntState mutableIntState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-587537070, i10, -1, "cu.todus.android.uiCompose.main.screen.statusEditor.pages.textEditor.TextEditor.<anonymous>.<anonymous> (TextEditor.kt:271)");
            }
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: h8.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextEditorKt.TextEditor$lambda$19$6$0$0(mutableIntState, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ColorSelector(list, (Function1) objRememberedValue, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$19$6$0$0(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TextEditor$lambda$20(String str, List list, List list2, o oVar, a aVar, int i10, Composer composer, int i11) {
        TextEditor(str, list, list2, oVar, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    private static final boolean TextEditor$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TextEditor$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }
}
