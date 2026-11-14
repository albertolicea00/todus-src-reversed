package cu.todus.android.uiCompose.main.screen.joinRoom;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.BlurredEdgeTreatment;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import defpackage.l;
import defpackage.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.a0;
import ua.k0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001ac\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0019\u001a\u00020\u0018*\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e²\u0006\u0012\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/joinRoom/JoinRoomViewModel;", "viewModel", "Lua/k0;", "JoinRoomScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/joinRoom/JoinRoomViewModel;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "", "cant", "", "Landroidx/compose/ui/graphics/Color;", "colors", "width", "height", "minShapeSize", "maxShapeSize", "Landroidx/compose/ui/graphics/Shape;", "shape", "DrawShapesWithBlur", "(Landroidx/compose/ui/Modifier;ILjava/util/List;IIIILandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "", "toRadians", "(F)F", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/uiCompose/main/screen/joinRoom/JoinRoomState;", "state", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JoinRoomScreenKt {
    /* JADX WARN: Code duplicated, block: B:100:0x012e  */
    /* JADX WARN: Code duplicated, block: B:101:0x0131  */
    /* JADX WARN: Code duplicated, block: B:104:0x0136  */
    /* JADX WARN: Code duplicated, block: B:105:0x0163  */
    /* JADX WARN: Code duplicated, block: B:107:0x0167  */
    /* JADX WARN: Code duplicated, block: B:109:0x016c  */
    /* JADX WARN: Code duplicated, block: B:110:0x016f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0173  */
    /* JADX WARN: Code duplicated, block: B:114:0x0178  */
    /* JADX WARN: Code duplicated, block: B:116:0x017d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0182  */
    /* JADX WARN: Code duplicated, block: B:120:0x018d  */
    /* JADX WARN: Code duplicated, block: B:123:0x01df  */
    /* JADX WARN: Code duplicated, block: B:126:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:127:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:130:0x0229  */
    /* JADX WARN: Code duplicated, block: B:131:0x022b  */
    /* JADX WARN: Code duplicated, block: B:134:0x0238  */
    /* JADX WARN: Code duplicated, block: B:135:0x023a  */
    /* JADX WARN: Code duplicated, block: B:138:0x0243  */
    /* JADX WARN: Code duplicated, block: B:139:0x0245  */
    /* JADX WARN: Code duplicated, block: B:142:0x024d  */
    /* JADX WARN: Code duplicated, block: B:143:0x024f  */
    /* JADX WARN: Code duplicated, block: B:146:0x0259  */
    /* JADX WARN: Code duplicated, block: B:147:0x025c  */
    /* JADX WARN: Code duplicated, block: B:152:0x026e  */
    /* JADX WARN: Code duplicated, block: B:155:0x0295  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:161:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x0101  */
    /* JADX WARN: Code duplicated, block: B:87:0x0103  */
    /* JADX WARN: Code duplicated, block: B:90:0x010d  */
    /* JADX WARN: Code duplicated, block: B:99:0x012c A[DONT_INVERT] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DrawShapesWithBlur(Modifier modifier, final int i10, List<Color> list, int i11, int i12, int i13, int i14, Shape shape, Composer composer, final int i15, final int i16) {
        Modifier modifier2;
        int i17;
        int i18;
        List<Color> listQ;
        int i19;
        int i20;
        char c10;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z10;
        final int i30;
        Modifier modifier3;
        final List<Color> list2;
        final Shape shape2;
        final int i31;
        final int i32;
        final int i33;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i34;
        int i35;
        Shape rectangleShape;
        lb.a constructor;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(73878109);
        int i36 = i16 & 1;
        if (i36 != 0) {
            i17 = i15 | 6;
            modifier2 = modifier;
        } else if ((i15 & 6) == 0) {
            modifier2 = modifier;
            i17 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i15;
        } else {
            modifier2 = modifier;
            i17 = i15;
        }
        if ((i15 & 48) == 0) {
            i18 = i10;
            i17 |= composerStartRestartGroup.changed(i18) ? 32 : 16;
        } else {
            i18 = i10;
        }
        if ((i15 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i16 & 4) == 0) {
                listQ = list;
                int i37 = composerStartRestartGroup.changedInstance(listQ) ? 256 : 128;
                i17 |= i37;
            } else {
                listQ = list;
            }
            i17 |= i37;
        } else {
            listQ = list;
        }
        int i38 = i16 & 8;
        if (i38 == 0) {
            if ((i15 & 3072) == 0) {
                i19 = i11;
                i17 |= composerStartRestartGroup.changed(i19) ? 2048 : 1024;
            }
            i20 = i16 & 16;
            if (i20 != 0) {
                i17 |= 24576;
                c10 = 2;
            } else {
                c10 = 2;
                if ((i15 & 24576) != 0) {
                    if (composerStartRestartGroup.changed(i12)) {
                        i21 = 16384;
                    } else {
                        i21 = 8192;
                    }
                    i17 |= i21;
                }
            }
            i22 = i16 & 32;
            if (i22 != 0) {
                i17 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i23 = i13;
            } else {
                i23 = i13;
                if ((i15 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i23)) {
                        i24 = 131072;
                    } else {
                        i24 = 65536;
                    }
                    i17 |= i24;
                }
            }
            i25 = i16 & 64;
            if (i25 != 0) {
                i17 |= 1572864;
                i26 = i14;
            } else {
                i26 = i14;
                if ((i15 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i26)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i17 |= i27;
                }
            }
            i28 = i16 & 128;
            if (i28 != 0) {
                i17 |= 12582912;
            } else if ((i15 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i29 = 8388608;
                } else {
                    i29 = 4194304;
                }
                i17 |= i29;
            }
            if ((i17 & 4793491) != 4793490) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i15 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i36 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i16 & 4) != 0) {
                        Other other = Other.INSTANCE;
                        Color colorM5856boximpl = Color.m5856boximpl(other.m10118getRed0d7_KjU());
                        Color colorM5856boximpl2 = Color.m5856boximpl(other.m10115getOrange20d7_KjU());
                        Color colorM5856boximpl3 = Color.m5856boximpl(other.m10121getYellow0d7_KjU());
                        i34 = 1;
                        Color[] colorArr = new Color[3];
                        colorArr[0] = colorM5856boximpl;
                        colorArr[1] = colorM5856boximpl2;
                        colorArr[c10] = colorM5856boximpl3;
                        i17 &= -897;
                        listQ = w.q(colorArr);
                    } else {
                        i34 = 1;
                    }
                    if (i38 != 0) {
                        i19 = 700;
                    }
                    if (i20 != 0) {
                        i35 = 400;
                    } else {
                        i35 = i12;
                    }
                    if (i22 != 0) {
                        i23 = 300;
                    }
                    if (i25 != 0) {
                        i26 = 800;
                    }
                    if (i28 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i16 & 4) != 0) {
                        i17 &= -897;
                    }
                    i35 = i12;
                    rectangleShape = shape;
                    modifier4 = modifier2;
                    i34 = 1;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(73878109, i17, -1, "cu.todus.android.uiCompose.main.screen.joinRoom.DrawShapesWithBlur (JoinRoomScreen.kt:277)");
                }
                Modifier modifierM5427blurF8QBwvs = BlurKt.m5427blurF8QBwvs(ClipKt.clip(SizeKt.fillMaxSize$default(modifier4, 0.0f, i34, null), rectangleShape), Dp.m8823constructorimpl(28), BlurredEdgeTreatment.INSTANCE.m5437getUnboundedGoahg());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5427blurF8QBwvs);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
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
                modifier3 = modifier4;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                if ((i17 & 112) == 32) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean zChangedInstance = z11 | composerStartRestartGroup.changedInstance(listQ);
                if ((458752 & i17) == 131072) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z17 = zChangedInstance | z12;
                if ((3670016 & i17) == 1048576) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z18 = z17 | z13;
                if ((i17 & 7168) == 2048) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z19 = z18 | z14;
                if ((i17 & 57344) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z16 = z19 | z15;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z16 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final int i39 = i35;
                    final int i40 = i18;
                    final List<Color> list3 = listQ;
                    final int i41 = i23;
                    final int i42 = i19;
                    final int i43 = i26;
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return JoinRoomScreenKt.DrawShapesWithBlur$lambda$0$0$0(i40, list3, i41, i43, i42, i39, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                CanvasKt.Canvas(companion2, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                List<Color> list4 = listQ;
                shape2 = rectangleShape;
                list2 = list4;
                i30 = i35;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i30 = i12;
                modifier3 = modifier2;
                list2 = listQ;
                shape2 = shape;
            }
            i31 = i23;
            i32 = i19;
            i33 = i26;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JoinRoomScreenKt.DrawShapesWithBlur$lambda$1(modifier5, i10, list2, i32, i30, i31, i33, shape2, i15, i16, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i17 |= 3072;
        i19 = i11;
        i20 = i16 & 16;
        if (i20 != 0) {
            i17 |= 24576;
            c10 = 2;
        } else {
            c10 = 2;
            if ((i15 & 24576) != 0) {
                if (composerStartRestartGroup.changed(i12)) {
                    i21 = 16384;
                } else {
                    i21 = 8192;
                }
                i17 |= i21;
            }
        }
        i22 = i16 & 32;
        if (i22 != 0) {
            i17 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i23 = i13;
        } else {
            i23 = i13;
            if ((i15 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i23)) {
                    i24 = 131072;
                } else {
                    i24 = 65536;
                }
                i17 |= i24;
            }
        }
        i25 = i16 & 64;
        if (i25 != 0) {
            i17 |= 1572864;
            i26 = i14;
        } else {
            i26 = i14;
            if ((i15 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i26)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i17 |= i27;
            }
        }
        i28 = i16 & 128;
        if (i28 != 0) {
            i17 |= 12582912;
        } else if ((i15 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(shape)) {
                i29 = 8388608;
            } else {
                i29 = 4194304;
            }
            i17 |= i29;
        }
        if ((i17 & 4793491) != 4793490) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i17 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i15 & 1) != 0) {
                if (i36 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i16 & 4) != 0) {
                    Other other2 = Other.INSTANCE;
                    Color colorM5856boximpl4 = Color.m5856boximpl(other2.m10118getRed0d7_KjU());
                    Color colorM5856boximpl5 = Color.m5856boximpl(other2.m10115getOrange20d7_KjU());
                    Color colorM5856boximpl6 = Color.m5856boximpl(other2.m10121getYellow0d7_KjU());
                    i34 = 1;
                    Color[] colorArr2 = new Color[3];
                    colorArr2[0] = colorM5856boximpl4;
                    colorArr2[1] = colorM5856boximpl5;
                    colorArr2[c10] = colorM5856boximpl6;
                    i17 &= -897;
                    listQ = w.q(colorArr2);
                } else {
                    i34 = 1;
                }
                if (i38 != 0) {
                    i19 = 700;
                }
                if (i20 != 0) {
                    i35 = 400;
                } else {
                    i35 = i12;
                }
                if (i22 != 0) {
                    i23 = 300;
                }
                if (i25 != 0) {
                    i26 = 800;
                }
                if (i28 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
            } else {
                if (i36 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i16 & 4) != 0) {
                    Other other3 = Other.INSTANCE;
                    Color colorM5856boximpl7 = Color.m5856boximpl(other3.m10118getRed0d7_KjU());
                    Color colorM5856boximpl8 = Color.m5856boximpl(other3.m10115getOrange20d7_KjU());
                    Color colorM5856boximpl9 = Color.m5856boximpl(other3.m10121getYellow0d7_KjU());
                    i34 = 1;
                    Color[] colorArr3 = new Color[3];
                    colorArr3[0] = colorM5856boximpl7;
                    colorArr3[1] = colorM5856boximpl8;
                    colorArr3[c10] = colorM5856boximpl9;
                    i17 &= -897;
                    listQ = w.q(colorArr3);
                } else {
                    i34 = 1;
                }
                if (i38 != 0) {
                    i19 = 700;
                }
                if (i20 != 0) {
                    i35 = 400;
                } else {
                    i35 = i12;
                }
                if (i22 != 0) {
                    i23 = 300;
                }
                if (i25 != 0) {
                    i26 = 800;
                }
                if (i28 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(73878109, i17, -1, "cu.todus.android.uiCompose.main.screen.joinRoom.DrawShapesWithBlur (JoinRoomScreen.kt:277)");
            }
            Modifier modifierM5427blurF8QBwvs2 = BlurKt.m5427blurF8QBwvs(ClipKt.clip(SizeKt.fillMaxSize$default(modifier4, 0.0f, i34, null), rectangleShape), Dp.m8823constructorimpl(28), BlurredEdgeTreatment.INSTANCE.m5437getUnboundedGoahg());
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5427blurF8QBwvs2);
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
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            modifier3 = modifier4;
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            if ((i17 & 112) == 32) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean zChangedInstance2 = z11 | composerStartRestartGroup.changedInstance(listQ);
            if ((458752 & i17) == 131072) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean z110 = zChangedInstance2 | z12;
            if ((3670016 & i17) == 1048576) {
                z13 = true;
            } else {
                z13 = false;
            }
            boolean z111 = z110 | z13;
            if ((i17 & 7168) == 2048) {
                z14 = true;
            } else {
                z14 = false;
            }
            boolean z112 = z111 | z14;
            if ((i17 & 57344) == 16384) {
                z15 = true;
            } else {
                z15 = false;
            }
            z16 = z112 | z15;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z16) {
                final int i310 = i35;
                final int i44 = i18;
                final List list5 = listQ;
                final int i45 = i23;
                final int i46 = i19;
                final int i47 = i26;
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return JoinRoomScreenKt.DrawShapesWithBlur$lambda$0$0$0(i44, list5, i45, i47, i46, i310, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final int i311 = i35;
                final int i48 = i18;
                final List list6 = listQ;
                final int i49 = i23;
                final int i410 = i19;
                final int i411 = i26;
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return JoinRoomScreenKt.DrawShapesWithBlur$lambda$0$0$0(i48, list6, i49, i411, i410, i311, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CanvasKt.Canvas(companion4, (Function1) objRememberedValue, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            List<Color> list7 = listQ;
            shape2 = rectangleShape;
            list2 = list7;
            i30 = i35;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            i30 = i12;
            modifier3 = modifier2;
            list2 = listQ;
            shape2 = shape;
        }
        i31 = i23;
        i32 = i19;
        i33 = i26;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JoinRoomScreenKt.DrawShapesWithBlur$lambda$1(modifier6, i10, list2, i32, i30, i31, i33, shape2, i15, i16, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawShapesWithBlur$lambda$0$0$0(int i10, List list, int i11, int i12, int i13, int i14, DrawScope drawScope) {
        DrawScope Canvas = drawScope;
        y.i(Canvas, "$this$Canvas");
        int i15 = 0;
        while (i15 < i10) {
            pb.d.a aVar = pb.d.f40576c;
            int iH = aVar.h(0, list.size());
            final int iH2 = aVar.h(i11, i12);
            final int iH3 = aVar.h(0, i13);
            final int iH4 = aVar.h(0, i14);
            List list2 = (List) new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.j
                @Override // lb.a
                public final Object invoke() {
                    return JoinRoomScreenKt.DrawShapesWithBlur$lambda$0$0$0$0$0(iH2, iH3, iH4);
                }
            }.invoke();
            Path Path = AndroidPath_androidKt.Path();
            Path.moveTo(Float.intBitsToFloat((int) (((Offset) g0.I0(list2)).m5636unboximpl() >> 32)), Float.intBitsToFloat((int) (((Offset) g0.I0(list2)).m5636unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                long jM5636unboximpl = ((Offset) it.next()).m5636unboximpl();
                Path.lineTo(Float.intBitsToFloat((int) (jM5636unboximpl >> 32)), Float.intBitsToFloat((int) (jM5636unboximpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
            }
            Path.close();
            DrawScope.CC.I(Canvas, Path, ((Color) list.get(iH)).m5876unboximpl(), 0.0f, null, null, 0, 60, null);
            i15++;
            Canvas = drawScope;
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List DrawShapesWithBlur$lambda$0$0$0$0$0(int i10, int i11, int i12) {
        pb.d.a aVar = pb.d.f40576c;
        int iH = aVar.h(5, 12);
        float f10 = 360.0f / iH;
        int iH2 = aVar.h(0, 360);
        ArrayList arrayList = new ArrayList(iH);
        for (int i13 = 0; i13 < iH; i13++) {
            float f11 = iH2 + (i13 * f10);
            float f12 = i10 / 2.0f;
            float fCos = (((float) Math.cos(toRadians(f11))) * f12) + i11;
            arrayList.add(Offset.m5615boximpl(Offset.m5618constructorimpl((((long) Float.floatToRawIntBits((f12 * ((float) Math.sin(toRadians(f11)))) + i12)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fCos) << 32))));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 DrawShapesWithBlur$lambda$1(Modifier modifier, int i10, List list, int i11, int i12, int i13, int i14, Shape shape, int i15, int i16, Composer composer, int i17) {
        DrawShapesWithBlur(modifier, i10, list, i11, i12, i13, i14, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i15 | 1), i16);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0636  */
    /* JADX WARN: Code duplicated, block: B:115:0x0665  */
    /* JADX WARN: Code duplicated, block: B:117:0x0678  */
    /* JADX WARN: Code duplicated, block: B:119:0x068d  */
    /* JADX WARN: Code duplicated, block: B:121:0x06a0  */
    /* JADX WARN: Code duplicated, block: B:123:0x06b3  */
    /* JADX WARN: Code duplicated, block: B:124:0x06c4  */
    /* JADX WARN: Code duplicated, block: B:126:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:128:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:129:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:131:0x070e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0721  */
    /* JADX WARN: Code duplicated, block: B:134:0x0733  */
    /* JADX WARN: Code duplicated, block: B:137:0x0756  */
    /* JADX WARN: Code duplicated, block: B:138:0x0758  */
    /* JADX WARN: Code duplicated, block: B:141:0x0760  */
    /* JADX WARN: Code duplicated, block: B:143:0x0768  */
    /* JADX WARN: Code duplicated, block: B:147:0x078a  */
    /* JADX WARN: Code duplicated, block: B:149:0x07a6  */
    /* JADX WARN: Code duplicated, block: B:150:0x07b6  */
    /* JADX WARN: Code duplicated, block: B:152:0x07c2  */
    /* JADX WARN: Code duplicated, block: B:154:0x07f0  */
    /* JADX WARN: Code duplicated, block: B:156:0x07f8  */
    /* JADX WARN: Code duplicated, block: B:158:0x0892  */
    /* JADX WARN: Code duplicated, block: B:161:0x08ad  */
    /* JADX WARN: Code duplicated, block: B:162:0x08af  */
    /* JADX WARN: Code duplicated, block: B:165:0x08b7  */
    /* JADX WARN: Code duplicated, block: B:169:0x08c3  */
    /* JADX WARN: Code duplicated, block: B:172:0x08dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:60:0x0122  */
    /* JADX WARN: Code duplicated, block: B:63:0x012e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0132  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:74:0x023a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0246  */
    /* JADX WARN: Code duplicated, block: B:78:0x024a  */
    /* JADX WARN: Code duplicated, block: B:81:0x029c  */
    /* JADX WARN: Code duplicated, block: B:83:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:86:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x0306  */
    /* JADX WARN: Code duplicated, block: B:90:0x030a  */
    /* JADX WARN: Code duplicated, block: B:93:0x04d6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void JoinRoomScreen(final NavHostController navHostController, final String uid, JoinRoomViewModel joinRoomViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        JoinRoomViewModel joinRoomViewModel2;
        String str;
        final JoinRoomViewModel joinRoomViewModel3;
        int i13;
        Composer composer2;
        int i14;
        JoinRoomViewModel joinRoomViewModel4;
        Modifier.Companion companion;
        MaterialTheme materialTheme;
        int i15;
        Alignment.Companion companion2;
        ComposeUiNode.Companion companion3;
        lb.a constructor;
        BoxScopeInstance boxScopeInstance;
        final State stateCollectAsStateWithLifecycle;
        int i16;
        int i17;
        JoinRoomViewModel joinRoomViewModel5;
        JoinRoomViewModel joinRoomViewModel6;
        boolean z10;
        boolean z11;
        boolean zChangedInstance;
        Object objRememberedValue;
        JoinRoomViewModel joinRoomViewModel7;
        boolean z12;
        boolean z13;
        Object objRememberedValue2;
        JoinRoomState data;
        lb.a constructor2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        lb.a constructor3;
        float f10;
        JoinRoomState data2;
        JoinRoomState data3;
        JoinRoomState data4;
        JoinRoomState data5;
        JoinRoomState data6;
        String strStringResource;
        JoinRoomState data7;
        JoinRoomState data8;
        JoinRoomState data9;
        final JoinRoomViewModel joinRoomViewModel8;
        boolean z14;
        boolean z15;
        Object objRememberedValue4;
        JoinRoomState data10;
        int i18;
        y.i(navHostController, "navHostController");
        y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(1798504213);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(uid) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                joinRoomViewModel2 = joinRoomViewModel;
                int i19 = composerStartRestartGroup.changedInstance(joinRoomViewModel2) ? 256 : 128;
                i12 |= i19;
            } else {
                joinRoomViewModel2 = joinRoomViewModel;
            }
            i12 |= i19;
        } else {
            joinRoomViewModel2 = joinRoomViewModel;
        }
        ?? r10 = 0;
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i13 = 1;
                    composer2 = composerStartRestartGroup;
                    joinRoomViewModel2 = (JoinRoomViewModel) ViewModelKt.viewModel(z0.b(JoinRoomViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i12 &= -897;
                }
                i14 = i12;
                joinRoomViewModel4 = joinRoomViewModel2;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1798504213, i14, -1, "cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomScreen (JoinRoomScreen.kt:63)");
                }
                companion = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, i13, null);
                materialTheme = MaterialTheme.INSTANCE;
                i15 = MaterialTheme.$stable;
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, materialTheme.getColorScheme(composer2, i15).getBackground(), null, 2, null);
                companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), r10);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, r10));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default);
                companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                Composer composer3 = composer2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(joinRoomViewModel4.getRoomInfo(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer3, 0, 7);
                i16 = i13;
                i17 = i14;
                joinRoomViewModel5 = joinRoomViewModel4;
                DrawShapesWithBlur(null, 4, null, 0, 0, 0, 0, null, composer3, 48, 253);
                DrawShapesWithBlur(ScaleKt.scale(companion, -1.0f, -1.0f), 4, null, 0, 0, 0, 0, null, composer3, 48, 252);
                composerStartRestartGroup = composer3;
                if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.SUCCESS) {
                    composerStartRestartGroup.startReplaceGroup(-853036911);
                    data = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    if (data != null && data.getGoBack() == i16) {
                        navHostController.navigateUp();
                    }
                    float f11 = 100;
                    Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxSize$default(companion, 0.0f, i16, null), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 7, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, i16), false, null, false, 14, null);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getSpaceBetween(), companion2.getStart(), composerStartRestartGroup, 6);
                    int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
                    constructor2 = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(companion, Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(8), 0.0f, 0.0f, 12, null);
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(navHostController);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.e
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$1$0$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue3, modifierM1729paddingqDBjuR0$default, false, null, null, null, ComposableSingletons$JoinRoomScreenKt.INSTANCE.m9938getLambda$1187883574$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, i16, null);
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composerStartRestartGroup, 48);
                    int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                    constructor3 = companion3.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
                    Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(150));
                    JoinRoomState data11 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data11);
                    String picUrl = data11.getPicUrl();
                    ColorGenerator material = ColorGenerator.INSTANCE.getMATERIAL();
                    JoinRoomState data12 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data12);
                    long jColor = ColorKt.Color(material.getColor(data12.getName()));
                    JoinRoomState data13 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data13);
                    Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs, picUrl, Color.m5856boximpl(jColor), null, "", 0, 150, false, null, data13.getName(), true, 0, composerStartRestartGroup, 1597446, 6, 2472);
                    composerStartRestartGroup = composerStartRestartGroup;
                    JoinRoomState data14 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data14);
                    String name = data14.getName();
                    TextStyle titleMedium = materialTheme.getTypography(composerStartRestartGroup, i15).getTitleMedium();
                    TextAlign.Companion companion4 = TextAlign.INSTANCE;
                    f10 = 20;
                    Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), name, TextStyle.m8271copyp1EtxEg$default(titleMedium, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                    JoinRoomState data15 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data15);
                    Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), data15.getSubject(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                    JoinRoomState data16 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data16);
                    int cant = data16.getCant();
                    int i20 = R.plurals.member_plural;
                    JoinRoomState data17 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data17);
                    Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), cant + " " + StringResources_androidKt.pluralStringResource(i20, data17.getCant(), composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelSmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                    composerStartRestartGroup.endNode();
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    data2 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    if (data2 == null && data2.getWasError()) {
                        composerStartRestartGroup.startReplaceGroup(-850403678);
                        Modifier modifierAlign = boxScopeInstance.align(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), null, 2, null), companion2.getBottomCenter());
                        MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
                        int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
                        lb.a constructor4 = companion3.getConstructor();
                        if (!r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy3, companion3.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
                        Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), 0.0f, 1, null);
                        if (a0.U(uid, "@", false, 2, null)) {
                            composerStartRestartGroup.startReplaceGroup(1305762874);
                            i18 = R.string.cant_perform_subscribe_channel;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1305765033);
                            i18 = R.string.cant_perform_join_group;
                        }
                        String strStringResource2 = StringResources_androidKt.stringResource(i18, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(modifierFillMaxWidth$default2, strStringResource2, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10));
                        String strStringResource3 = StringResources_androidKt.stringResource(R.string.go_back, composerStartRestartGroup, 0);
                        boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(navHostController);
                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$2$0$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        Z17ButtonsKt.Z17SecondaryButton(modifierM1725padding3ABfNKs, (lb.a) objRememberedValue5, strStringResource3, null, true, false, composerStartRestartGroup, 24582, 40);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceGroup();
                        joinRoomViewModel8 = joinRoomViewModel5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-849122541);
                        Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(companion, companion2.getBottomCenter()), Dp.m8823constructorimpl(f10));
                        data3 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                        y.f(data3);
                        if (data3.isAlreadyIn()) {
                            data10 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data10);
                            if (data10.isChannel()) {
                                data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data4);
                                if (data4.isAlreadyIn()) {
                                    data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data9);
                                    if (data9.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803961955);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data5);
                                        if (data5.isAlreadyIn()) {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            } else {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                }
                                            }
                                        } else {
                                            data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data8);
                                            if (data8.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803965851);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data6);
                                                if (data6.isAlreadyIn()) {
                                                    data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                    y.f(data7);
                                                    if (data7.isChannel()) {
                                                        composerStartRestartGroup.startReplaceGroup(803971545);
                                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    } else {
                                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                        strStringResource = "";
                                                    }
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data5);
                                    if (data5.isAlreadyIn()) {
                                        data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data8);
                                        if (data8.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803965851);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                }
                            } else {
                                composerStartRestartGroup.startReplaceGroup(803958209);
                                strStringResource = StringResources_androidKt.stringResource(R.string.go_group, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data4);
                            if (data4.isAlreadyIn()) {
                                data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data9);
                                if (data9.isChannel()) {
                                    composerStartRestartGroup.startReplaceGroup(803961955);
                                    strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data5);
                                    if (data5.isAlreadyIn()) {
                                        data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data8);
                                        if (data8.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803965851);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                }
                            } else {
                                data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data5);
                                if (data5.isAlreadyIn()) {
                                    data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data8);
                                    if (data8.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803965851);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            }
                        }
                        String str2 = strStringResource;
                        joinRoomViewModel8 = joinRoomViewModel5;
                        boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(joinRoomViewModel8);
                        if ((i17 & 112) == 32) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        z15 = zChanged | z14;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z15 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Z17ButtonsKt.Z17PrimaryButton(modifierM1725padding3ABfNKs2, (lb.a) objRememberedValue4, str2, null, true, false, composerStartRestartGroup, 24576, 40);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    joinRoomViewModel6 = joinRoomViewModel8;
                } else {
                    if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.LOADING) {
                        composerStartRestartGroup.startReplaceGroup(-846453534);
                        LoadingScreenKt.LoadingWall(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        joinRoomViewModel6 = joinRoomViewModel5;
                    } else if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.ERROR) {
                        composerStartRestartGroup.startReplaceGroup(-846351637);
                        Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion, companion2.getTopStart()), Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(8), 0.0f, 0.0f, 12, null);
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$4$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        joinRoomViewModel6 = joinRoomViewModel5;
                        IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1729paddingqDBjuR0$default2, false, null, null, null, ComposableSingletons$JoinRoomScreenKt.INSTANCE.getLambda$886053660$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
                        composerStartRestartGroup = composerStartRestartGroup;
                        z11 = true;
                        z10 = false;
                        Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(companion, companion2.getCenter()), Dp.m8823constructorimpl(20)), 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.cant_find_room_info, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 0, MenuKt.InTransitionDuration);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        joinRoomViewModel6 = joinRoomViewModel5;
                        z10 = false;
                        z11 = true;
                        composerStartRestartGroup.startReplaceGroup(-845525177);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    k0 k0Var = k0.f43947a;
                    joinRoomViewModel7 = joinRoomViewModel6;
                    boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(joinRoomViewModel7);
                    if ((i17 & 112) == 32) {
                        z12 = z11;
                    } else {
                        z12 = z10;
                    }
                    z13 = zChangedInstance4 | z12;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z13 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        str = uid;
                        objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        str = uid;
                    }
                    EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    joinRoomViewModel3 = joinRoomViewModel7;
                }
                z10 = false;
                z11 = true;
                k0 k0Var2 = k0.f43947a;
                joinRoomViewModel7 = joinRoomViewModel6;
                boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(joinRoomViewModel7);
                if ((i17 & 112) == 32) {
                    z12 = z11;
                } else {
                    z12 = z10;
                }
                z13 = zChangedInstance5 | z12;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    str = uid;
                    objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    str = uid;
                    objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                joinRoomViewModel3 = joinRoomViewModel7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i14 = i12 & (-897);
                    joinRoomViewModel4 = joinRoomViewModel2;
                    r10 = 0;
                    composer2 = composerStartRestartGroup;
                    i13 = 1;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1798504213, i14, -1, "cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomScreen (JoinRoomScreen.kt:63)");
                }
                companion = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, i13, null);
                materialTheme = MaterialTheme.INSTANCE;
                i15 = MaterialTheme.$stable;
                Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default2, materialTheme.getColorScheme(composer2, i15).getBackground(), null, 2, null);
                companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), r10);
                int iA5 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, r10));
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default2);
                companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                Composer composer4 = composer2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(joinRoomViewModel4.getRoomInfo(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer4, 0, 7);
                i16 = i13;
                i17 = i14;
                joinRoomViewModel5 = joinRoomViewModel4;
                DrawShapesWithBlur(null, 4, null, 0, 0, 0, 0, null, composer4, 48, 253);
                DrawShapesWithBlur(ScaleKt.scale(companion, -1.0f, -1.0f), 4, null, 0, 0, 0, 0, null, composer4, 48, 252);
                composerStartRestartGroup = composer4;
                if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.SUCCESS) {
                    composerStartRestartGroup.startReplaceGroup(-853036911);
                    data = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    if (data != null) {
                        navHostController.navigateUp();
                    }
                    float f12 = 100;
                    Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxSize$default(companion, 0.0f, i16, null), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f12), 7, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, i16), false, null, false, 14, null);
                    Arrangement arrangement2 = Arrangement.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(arrangement2.getSpaceBetween(), companion2.getStart(), composerStartRestartGroup, 6);
                    int iA6 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default2);
                    constructor2 = companion3.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyColumnMeasurePolicy4, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion3.getSetModifier());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    Modifier modifierM1729paddingqDBjuR0$default3 = PaddingKt.m1729paddingqDBjuR0$default(companion, Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(8), 0.0f, 0.0f, 12, null);
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(navHostController);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.e
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$1$0$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.e
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$1$0$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue3, modifierM1729paddingqDBjuR0$default3, false, null, null, null, ComposableSingletons$JoinRoomScreenKt.INSTANCE.m9938getLambda$1187883574$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion, 0.0f, i16, null);
                    MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion2.getCenterHorizontally(), composerStartRestartGroup, 48);
                    int iA7 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
                    constructor3 = companion3.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyColumnMeasurePolicy5, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion3.getSetModifier());
                    Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(150));
                    JoinRoomState data18 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data18);
                    String picUrl2 = data18.getPicUrl();
                    ColorGenerator material2 = ColorGenerator.INSTANCE.getMATERIAL();
                    JoinRoomState data19 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data19);
                    long jColor2 = ColorKt.Color(material2.getColor(data19.getName()));
                    JoinRoomState data110 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data110);
                    Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs2, picUrl2, Color.m5856boximpl(jColor2), null, "", 0, 150, false, null, data110.getName(), true, 0, composerStartRestartGroup, 1597446, 6, 2472);
                    composerStartRestartGroup = composerStartRestartGroup;
                    JoinRoomState data111 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data111);
                    String name2 = data111.getName();
                    TextStyle titleMedium2 = materialTheme.getTypography(composerStartRestartGroup, i15).getTitleMedium();
                    TextAlign.Companion companion5 = TextAlign.INSTANCE;
                    f10 = 20;
                    Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), name2, TextStyle.m8271copyp1EtxEg$default(titleMedium2, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion5.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                    JoinRoomState data112 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data112);
                    Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), data112.getSubject(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion5.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                    JoinRoomState data113 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data113);
                    int cant2 = data113.getCant();
                    int i21 = R.plurals.member_plural;
                    JoinRoomState data114 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data114);
                    Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), cant2 + " " + StringResources_androidKt.pluralStringResource(i21, data114.getCant(), composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelSmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion5.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                    composerStartRestartGroup.endNode();
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f12)), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    data2 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    if (data2 == null) {
                        composerStartRestartGroup.startReplaceGroup(-849122541);
                        Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(companion, companion2.getBottomCenter()), Dp.m8823constructorimpl(f10));
                        data3 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                        y.f(data3);
                        if (data3.isAlreadyIn()) {
                            data10 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data10);
                            if (data10.isChannel()) {
                                composerStartRestartGroup.startReplaceGroup(803958209);
                                strStringResource = StringResources_androidKt.stringResource(R.string.go_group, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data4);
                                if (data4.isAlreadyIn()) {
                                    data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data9);
                                    if (data9.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803961955);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data5);
                                        if (data5.isAlreadyIn()) {
                                            data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data8);
                                            if (data8.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803965851);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data6);
                                                if (data6.isAlreadyIn()) {
                                                    data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                    y.f(data7);
                                                    if (data7.isChannel()) {
                                                        composerStartRestartGroup.startReplaceGroup(803971545);
                                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    } else {
                                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                        strStringResource = "";
                                                    }
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            }
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    }
                                } else {
                                    data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data5);
                                    if (data5.isAlreadyIn()) {
                                        data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data8);
                                        if (data8.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803965851);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                }
                            }
                        } else {
                            data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data4);
                            if (data4.isAlreadyIn()) {
                                data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data9);
                                if (data9.isChannel()) {
                                    composerStartRestartGroup.startReplaceGroup(803961955);
                                    strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data5);
                                    if (data5.isAlreadyIn()) {
                                        data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data8);
                                        if (data8.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803965851);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                }
                            } else {
                                data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data5);
                                if (data5.isAlreadyIn()) {
                                    data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data8);
                                    if (data8.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803965851);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            }
                        }
                        String str3 = strStringResource;
                        joinRoomViewModel8 = joinRoomViewModel5;
                        boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(joinRoomViewModel8);
                        if ((i17 & 112) == 32) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        z15 = zChanged2 | z14;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z15) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Z17ButtonsKt.Z17PrimaryButton(modifierM1725padding3ABfNKs3, (lb.a) objRememberedValue4, str3, null, true, false, composerStartRestartGroup, 24576, 40);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-849122541);
                        Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(companion, companion2.getBottomCenter()), Dp.m8823constructorimpl(f10));
                        data3 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                        y.f(data3);
                        if (data3.isAlreadyIn()) {
                            data10 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data10);
                            if (data10.isChannel()) {
                                composerStartRestartGroup.startReplaceGroup(803958209);
                                strStringResource = StringResources_androidKt.stringResource(R.string.go_group, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data4);
                                if (data4.isAlreadyIn()) {
                                    data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data9);
                                    if (data9.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803961955);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data5);
                                        if (data5.isAlreadyIn()) {
                                            data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data8);
                                            if (data8.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803965851);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data6);
                                                if (data6.isAlreadyIn()) {
                                                    data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                    y.f(data7);
                                                    if (data7.isChannel()) {
                                                        composerStartRestartGroup.startReplaceGroup(803971545);
                                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    } else {
                                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                        strStringResource = "";
                                                    }
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            }
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    }
                                } else {
                                    data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data5);
                                    if (data5.isAlreadyIn()) {
                                        data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data8);
                                        if (data8.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803965851);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                }
                            }
                        } else {
                            data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data4);
                            if (data4.isAlreadyIn()) {
                                data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data9);
                                if (data9.isChannel()) {
                                    composerStartRestartGroup.startReplaceGroup(803961955);
                                    strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data5);
                                    if (data5.isAlreadyIn()) {
                                        data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data8);
                                        if (data8.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803965851);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                }
                            } else {
                                data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data5);
                                if (data5.isAlreadyIn()) {
                                    data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data8);
                                    if (data8.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803965851);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            }
                        }
                        String str4 = strStringResource;
                        joinRoomViewModel8 = joinRoomViewModel5;
                        boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(joinRoomViewModel8);
                        if ((i17 & 112) == 32) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        z15 = zChanged3 | z14;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z15) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Z17ButtonsKt.Z17PrimaryButton(modifierM1725padding3ABfNKs4, (lb.a) objRememberedValue4, str4, null, true, false, composerStartRestartGroup, 24576, 40);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    joinRoomViewModel6 = joinRoomViewModel8;
                } else {
                    if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.LOADING) {
                        composerStartRestartGroup.startReplaceGroup(-846453534);
                        LoadingScreenKt.LoadingWall(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        joinRoomViewModel6 = joinRoomViewModel5;
                    } else if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.ERROR) {
                        composerStartRestartGroup.startReplaceGroup(-846351637);
                        Modifier modifierM1729paddingqDBjuR0$default4 = PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion, companion2.getTopStart()), Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(8), 0.0f, 0.0f, 12, null);
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$4$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return JoinRoomScreenKt.JoinRoomScreen$lambda$0$4$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        joinRoomViewModel6 = joinRoomViewModel5;
                        IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1729paddingqDBjuR0$default4, false, null, null, null, ComposableSingletons$JoinRoomScreenKt.INSTANCE.getLambda$886053660$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
                        composerStartRestartGroup = composerStartRestartGroup;
                        z11 = true;
                        z10 = false;
                        Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(companion, companion2.getCenter()), Dp.m8823constructorimpl(20)), 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.cant_find_room_info, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 0, MenuKt.InTransitionDuration);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        joinRoomViewModel6 = joinRoomViewModel5;
                        z10 = false;
                        z11 = true;
                        composerStartRestartGroup.startReplaceGroup(-845525177);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    k0 k0Var3 = k0.f43947a;
                    joinRoomViewModel7 = joinRoomViewModel6;
                    boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(joinRoomViewModel7);
                    if ((i17 & 112) == 32) {
                        z12 = z11;
                    } else {
                        z12 = z10;
                    }
                    z13 = zChangedInstance6 | z12;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z13) {
                        str = uid;
                        objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        str = uid;
                        objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    EffectsKt.LaunchedEffect(k0Var3, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    joinRoomViewModel3 = joinRoomViewModel7;
                }
                z10 = false;
                z11 = true;
                k0 k0Var4 = k0.f43947a;
                joinRoomViewModel7 = joinRoomViewModel6;
                boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(joinRoomViewModel7);
                if ((i17 & 112) == 32) {
                    z12 = z11;
                } else {
                    z12 = z10;
                }
                z13 = zChangedInstance7 | z12;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    str = uid;
                    objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    str = uid;
                    objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                joinRoomViewModel3 = joinRoomViewModel7;
            }
            composer2 = composerStartRestartGroup;
            i13 = 1;
            i14 = i12;
            joinRoomViewModel4 = joinRoomViewModel2;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1798504213, i14, -1, "cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomScreen (JoinRoomScreen.kt:63)");
            }
            companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion, 0.0f, i13, null);
            materialTheme = MaterialTheme.INSTANCE;
            i15 = MaterialTheme.$stable;
            Modifier modifierM1205backgroundbw27NRU$default3 = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default3, materialTheme.getColorScheme(composer2, i15).getBackground(), null, 2, null);
            companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), r10);
            int iA8 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, r10));
            CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default3);
            companion3 = ComposeUiNode.INSTANCE;
            constructor = companion3.getConstructor();
            if (!r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion3.getSetModifier());
            boxScopeInstance = BoxScopeInstance.INSTANCE;
            Composer composer5 = composer2;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(joinRoomViewModel4.getRoomInfo(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer5, 0, 7);
            i16 = i13;
            i17 = i14;
            joinRoomViewModel5 = joinRoomViewModel4;
            DrawShapesWithBlur(null, 4, null, 0, 0, 0, 0, null, composer5, 48, 253);
            DrawShapesWithBlur(ScaleKt.scale(companion, -1.0f, -1.0f), 4, null, 0, 0, 0, 0, null, composer5, 48, 252);
            composerStartRestartGroup = composer5;
            if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.SUCCESS) {
                composerStartRestartGroup.startReplaceGroup(-853036911);
                data = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                if (data != null) {
                    navHostController.navigateUp();
                }
                float f13 = 100;
                Modifier modifierVerticalScroll$default3 = ScrollKt.verticalScroll$default(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxSize$default(companion, 0.0f, i16, null), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f13), 7, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, i16), false, null, false, 14, null);
                Arrangement arrangement3 = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(arrangement3.getSpaceBetween(), companion2.getStart(), composerStartRestartGroup, 6);
                int iA9 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default3);
                constructor2 = companion3.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl9 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl9, measurePolicyColumnMeasurePolicy6, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl9, currentCompositionLocalMap9, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl9, Integer.valueOf(iA9), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl9, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl9, modifierMaterializeModifier9, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                Modifier modifierM1729paddingqDBjuR0$default5 = PaddingKt.m1729paddingqDBjuR0$default(companion, Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(8), 0.0f, 0.0f, 12, null);
                zChangedInstance2 = composerStartRestartGroup.changedInstance(navHostController);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.e
                        @Override // lb.a
                        public final Object invoke() {
                            return JoinRoomScreenKt.JoinRoomScreen$lambda$0$1$0$0(navHostController);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.e
                        @Override // lb.a
                        public final Object invoke() {
                            return JoinRoomScreenKt.JoinRoomScreen$lambda$0$1$0$0(navHostController);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue3, modifierM1729paddingqDBjuR0$default5, false, null, null, null, ComposableSingletons$JoinRoomScreenKt.INSTANCE.m9938getLambda$1187883574$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
                Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(companion, 0.0f, i16, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(arrangement3.getTop(), companion2.getCenterHorizontally(), composerStartRestartGroup, 48);
                int iA10 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
                constructor3 = companion3.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl10 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl10, measurePolicyColumnMeasurePolicy7, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl10, currentCompositionLocalMap10, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl10, Integer.valueOf(iA10), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl10, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl10, modifierMaterializeModifier10, companion3.getSetModifier());
                Modifier modifierM1769size3ABfNKs3 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(150));
                JoinRoomState data115 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                y.f(data115);
                String picUrl3 = data115.getPicUrl();
                ColorGenerator material3 = ColorGenerator.INSTANCE.getMATERIAL();
                JoinRoomState data116 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                y.f(data116);
                long jColor3 = ColorKt.Color(material3.getColor(data116.getName()));
                JoinRoomState data117 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                y.f(data117);
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs3, picUrl3, Color.m5856boximpl(jColor3), null, "", 0, 150, false, null, data117.getName(), true, 0, composerStartRestartGroup, 1597446, 6, 2472);
                composerStartRestartGroup = composerStartRestartGroup;
                JoinRoomState data118 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                y.f(data118);
                String name3 = data118.getName();
                TextStyle titleMedium3 = materialTheme.getTypography(composerStartRestartGroup, i15).getTitleMedium();
                TextAlign.Companion companion6 = TextAlign.INSTANCE;
                f10 = 20;
                Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), name3, TextStyle.m8271copyp1EtxEg$default(titleMedium3, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion6.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                JoinRoomState data119 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                y.f(data119);
                Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), data119.getSubject(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion6.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                JoinRoomState data1110 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                y.f(data1110);
                int cant3 = data1110.getCant();
                int i22 = R.plurals.member_plural;
                JoinRoomState data1111 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                y.f(data1111);
                Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), cant3 + " " + StringResources_androidKt.pluralStringResource(i22, data1111.getCant(), composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelSmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion6.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 6, MenuKt.InTransitionDuration);
                composerStartRestartGroup.endNode();
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f13)), composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                data2 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                if (data2 == null) {
                    composerStartRestartGroup.startReplaceGroup(-849122541);
                    Modifier modifierM1725padding3ABfNKs5 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(companion, companion2.getBottomCenter()), Dp.m8823constructorimpl(f10));
                    data3 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data3);
                    if (data3.isAlreadyIn()) {
                        data10 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                        y.f(data10);
                        if (data10.isChannel()) {
                            composerStartRestartGroup.startReplaceGroup(803958209);
                            strStringResource = StringResources_androidKt.stringResource(R.string.go_group, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data4);
                            if (data4.isAlreadyIn()) {
                                data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data9);
                                if (data9.isChannel()) {
                                    composerStartRestartGroup.startReplaceGroup(803961955);
                                    strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data5);
                                    if (data5.isAlreadyIn()) {
                                        data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data8);
                                        if (data8.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803965851);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                }
                            } else {
                                data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data5);
                                if (data5.isAlreadyIn()) {
                                    data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data8);
                                    if (data8.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803965851);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            }
                        }
                    } else {
                        data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                        y.f(data4);
                        if (data4.isAlreadyIn()) {
                            data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data9);
                            if (data9.isChannel()) {
                                composerStartRestartGroup.startReplaceGroup(803961955);
                                strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data5);
                                if (data5.isAlreadyIn()) {
                                    data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data8);
                                    if (data8.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803965851);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            }
                        } else {
                            data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data5);
                            if (data5.isAlreadyIn()) {
                                data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data8);
                                if (data8.isChannel()) {
                                    composerStartRestartGroup.startReplaceGroup(803965851);
                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            } else {
                                data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data6);
                                if (data6.isAlreadyIn()) {
                                    data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data7);
                                    if (data7.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803971545);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                    composerStartRestartGroup.endReplaceGroup();
                                    strStringResource = "";
                                }
                            }
                        }
                    }
                    String str5 = strStringResource;
                    joinRoomViewModel8 = joinRoomViewModel5;
                    boolean zChanged4 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(joinRoomViewModel8);
                    if ((i17 & 112) == 32) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    z15 = zChanged4 | z14;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z15) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Z17ButtonsKt.Z17PrimaryButton(modifierM1725padding3ABfNKs5, (lb.a) objRememberedValue4, str5, null, true, false, composerStartRestartGroup, 24576, 40);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-849122541);
                    Modifier modifierM1725padding3ABfNKs6 = PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(companion, companion2.getBottomCenter()), Dp.m8823constructorimpl(f10));
                    data3 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                    y.f(data3);
                    if (data3.isAlreadyIn()) {
                        data10 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                        y.f(data10);
                        if (data10.isChannel()) {
                            composerStartRestartGroup.startReplaceGroup(803958209);
                            strStringResource = StringResources_androidKt.stringResource(R.string.go_group, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data4);
                            if (data4.isAlreadyIn()) {
                                data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data9);
                                if (data9.isChannel()) {
                                    composerStartRestartGroup.startReplaceGroup(803961955);
                                    strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data5);
                                    if (data5.isAlreadyIn()) {
                                        data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data8);
                                        if (data8.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803965851);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data6);
                                            if (data6.isAlreadyIn()) {
                                                data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                                y.f(data7);
                                                if (data7.isChannel()) {
                                                    composerStartRestartGroup.startReplaceGroup(803971545);
                                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    strStringResource = "";
                                                }
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        }
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                }
                            } else {
                                data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data5);
                                if (data5.isAlreadyIn()) {
                                    data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data8);
                                    if (data8.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803965851);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            }
                        }
                    } else {
                        data4 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                        y.f(data4);
                        if (data4.isAlreadyIn()) {
                            data9 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data9);
                            if (data9.isChannel()) {
                                composerStartRestartGroup.startReplaceGroup(803961955);
                                strStringResource = StringResources_androidKt.stringResource(R.string.go_channel, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data5);
                                if (data5.isAlreadyIn()) {
                                    data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data8);
                                    if (data8.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803965851);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data6);
                                        if (data6.isAlreadyIn()) {
                                            data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                            y.f(data7);
                                            if (data7.isChannel()) {
                                                composerStartRestartGroup.startReplaceGroup(803971545);
                                                strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-846561757);
                                                composerStartRestartGroup.endReplaceGroup();
                                                strStringResource = "";
                                            }
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    }
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            }
                        } else {
                            data5 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                            y.f(data5);
                            if (data5.isAlreadyIn()) {
                                data8 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data8);
                                if (data8.isChannel()) {
                                    composerStartRestartGroup.startReplaceGroup(803965851);
                                    strStringResource = StringResources_androidKt.stringResource(R.string.join_channel, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data6);
                                    if (data6.isAlreadyIn()) {
                                        data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                        y.f(data7);
                                        if (data7.isChannel()) {
                                            composerStartRestartGroup.startReplaceGroup(803971545);
                                            strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-846561757);
                                            composerStartRestartGroup.endReplaceGroup();
                                            strStringResource = "";
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                }
                            } else {
                                data6 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                y.f(data6);
                                if (data6.isAlreadyIn()) {
                                    data7 = JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getData();
                                    y.f(data7);
                                    if (data7.isChannel()) {
                                        composerStartRestartGroup.startReplaceGroup(803971545);
                                        strStringResource = StringResources_androidKt.stringResource(R.string.join_group, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-846561757);
                                        composerStartRestartGroup.endReplaceGroup();
                                        strStringResource = "";
                                    }
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-846561757);
                                    composerStartRestartGroup.endReplaceGroup();
                                    strStringResource = "";
                                }
                            }
                        }
                    }
                    String str6 = strStringResource;
                    joinRoomViewModel8 = joinRoomViewModel5;
                    boolean zChanged5 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(joinRoomViewModel8);
                    if ((i17 & 112) == 32) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    z15 = zChanged5 | z14;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z15) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.g
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$3$0(navHostController, joinRoomViewModel8, uid, stateCollectAsStateWithLifecycle);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Z17ButtonsKt.Z17PrimaryButton(modifierM1725padding3ABfNKs6, (lb.a) objRememberedValue4, str6, null, true, false, composerStartRestartGroup, 24576, 40);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                joinRoomViewModel6 = joinRoomViewModel8;
            } else {
                if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.LOADING) {
                    composerStartRestartGroup.startReplaceGroup(-846453534);
                    LoadingScreenKt.LoadingWall(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    joinRoomViewModel6 = joinRoomViewModel5;
                } else if (JoinRoomScreen$lambda$0$0(stateCollectAsStateWithLifecycle).getStatus() == Status.ERROR) {
                    composerStartRestartGroup.startReplaceGroup(-846351637);
                    Modifier modifierM1729paddingqDBjuR0$default6 = PaddingKt.m1729paddingqDBjuR0$default(boxScopeInstance.align(companion, companion2.getTopStart()), Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(8), 0.0f, 0.0f, 12, null);
                    zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.h
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$4$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.h
                            @Override // lb.a
                            public final Object invoke() {
                                return JoinRoomScreenKt.JoinRoomScreen$lambda$0$4$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    joinRoomViewModel6 = joinRoomViewModel5;
                    IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1729paddingqDBjuR0$default6, false, null, null, null, ComposableSingletons$JoinRoomScreenKt.INSTANCE.getLambda$886053660$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
                    composerStartRestartGroup = composerStartRestartGroup;
                    z11 = true;
                    z10 = false;
                    Z17LabelKt.m10263Z17LabelWithShadowDoPahcc(SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(boxScopeInstance.align(companion, companion2.getCenter()), Dp.m8823constructorimpl(20)), 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.cant_find_room_info, composerStartRestartGroup, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i15).getLabelLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, 0L, composerStartRestartGroup, 0, MenuKt.InTransitionDuration);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    joinRoomViewModel6 = joinRoomViewModel5;
                    z10 = false;
                    z11 = true;
                    composerStartRestartGroup.startReplaceGroup(-845525177);
                    composerStartRestartGroup.endReplaceGroup();
                }
                k0 k0Var5 = k0.f43947a;
                joinRoomViewModel7 = joinRoomViewModel6;
                boolean zChangedInstance8 = composerStartRestartGroup.changedInstance(joinRoomViewModel7);
                if ((i17 & 112) == 32) {
                    z12 = z11;
                } else {
                    z12 = z10;
                }
                z13 = zChangedInstance8 | z12;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    str = uid;
                    objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    str = uid;
                    objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(k0Var5, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                joinRoomViewModel3 = joinRoomViewModel7;
            }
            z10 = false;
            z11 = true;
            k0 k0Var6 = k0.f43947a;
            joinRoomViewModel7 = joinRoomViewModel6;
            boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(joinRoomViewModel7);
            if ((i17 & 112) == 32) {
                z12 = z11;
            } else {
                z12 = z10;
            }
            z13 = zChangedInstance9 | z12;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z13) {
                str = uid;
                objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                str = uid;
                objRememberedValue2 = new JoinRoomScreenKt$JoinRoomScreen$1$5$1(joinRoomViewModel7, str, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var6, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            joinRoomViewModel3 = joinRoomViewModel7;
        } else {
            str = uid;
            composerStartRestartGroup.skipToGroupEnd();
            joinRoomViewModel3 = joinRoomViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str7 = str;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.joinRoom.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JoinRoomScreenKt.JoinRoomScreen$lambda$1(navHostController, str7, joinRoomViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final FlowsState<JoinRoomState> JoinRoomScreen$lambda$0$0(State<FlowsState<JoinRoomState>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 JoinRoomScreen$lambda$0$1$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 JoinRoomScreen$lambda$0$2$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x008a  */
    /* JADX WARN: Code duplicated, block: B:12:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:14:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:16:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:17:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:19:0x0100  */
    /* JADX WARN: Code duplicated, block: B:21:0x0113  */
    /* JADX WARN: Code duplicated, block: B:7:0x0063  */
    /* JADX WARN: Code duplicated, block: B:9:0x0077  */
    public static final k0 JoinRoomScreen$lambda$0$3$0(NavHostController navHostController, JoinRoomViewModel joinRoomViewModel, String str, State state) {
        JoinRoomState data;
        JoinRoomState data2;
        JoinRoomState data3;
        JoinRoomState data4;
        JoinRoomState data5;
        JoinRoomState data6;
        JoinRoomState data7 = JoinRoomScreen$lambda$0$0(state).getData();
        y.f(data7);
        if (data7.isAlreadyIn()) {
            JoinRoomState data8 = JoinRoomScreen$lambda$0$0(state).getData();
            y.f(data8);
            if (data8.isChannel()) {
                data = JoinRoomScreen$lambda$0$0(state).getData();
                y.f(data);
                if (data.isAlreadyIn()) {
                    data6 = JoinRoomScreen$lambda$0$0(state).getData();
                    y.f(data6);
                    if (data6.isChannel()) {
                        NavLinks navLinks = NavLinks.INSTANCE;
                        v5.f gson = joinRoomViewModel.getGson();
                        JoinRoomState data9 = JoinRoomScreen$lambda$0$0(state).getData();
                        y.f(data9);
                        String strT = gson.t(new ChatParams(data9.getId(), 2, w.n(), 0, 8, null));
                        y.h(strT, "toJson(...)");
                        NavController.navigate$default((NavController) navHostController, navLinks.goChat(2, strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
                    } else {
                        data2 = JoinRoomScreen$lambda$0$0(state).getData();
                        y.f(data2);
                        if (data2.isAlreadyIn()) {
                            data3 = JoinRoomScreen$lambda$0$0(state).getData();
                            y.f(data3);
                            if (!data3.isAlreadyIn()) {
                                data4 = JoinRoomScreen$lambda$0$0(state).getData();
                                y.f(data4);
                                if (!data4.isChannel()) {
                                    joinRoomViewModel.joinGroup(str);
                                }
                            }
                        } else {
                            data5 = JoinRoomScreen$lambda$0$0(state).getData();
                            y.f(data5);
                            if (data5.isChannel()) {
                                joinRoomViewModel.joinChannel(str);
                            } else {
                                data3 = JoinRoomScreen$lambda$0$0(state).getData();
                                y.f(data3);
                                if (!data3.isAlreadyIn()) {
                                    data4 = JoinRoomScreen$lambda$0$0(state).getData();
                                    y.f(data4);
                                    if (!data4.isChannel()) {
                                        joinRoomViewModel.joinGroup(str);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    data2 = JoinRoomScreen$lambda$0$0(state).getData();
                    y.f(data2);
                    if (data2.isAlreadyIn()) {
                        data5 = JoinRoomScreen$lambda$0$0(state).getData();
                        y.f(data5);
                        if (data5.isChannel()) {
                            joinRoomViewModel.joinChannel(str);
                        } else {
                            data3 = JoinRoomScreen$lambda$0$0(state).getData();
                            y.f(data3);
                            if (!data3.isAlreadyIn()) {
                                data4 = JoinRoomScreen$lambda$0$0(state).getData();
                                y.f(data4);
                                if (!data4.isChannel()) {
                                    joinRoomViewModel.joinGroup(str);
                                }
                            }
                        }
                    } else {
                        data3 = JoinRoomScreen$lambda$0$0(state).getData();
                        y.f(data3);
                        if (!data3.isAlreadyIn()) {
                            data4 = JoinRoomScreen$lambda$0$0(state).getData();
                            y.f(data4);
                            if (!data4.isChannel()) {
                                joinRoomViewModel.joinGroup(str);
                            }
                        }
                    }
                }
            } else {
                NavLinks navLinks2 = NavLinks.INSTANCE;
                v5.f gson2 = joinRoomViewModel.getGson();
                JoinRoomState data10 = JoinRoomScreen$lambda$0$0(state).getData();
                y.f(data10);
                String strT2 = gson2.t(new ChatParams(data10.getId(), 1, w.n(), 0, 8, null));
                y.h(strT2, "toJson(...)");
                NavController.navigate$default((NavController) navHostController, navLinks2.goChat(1, strT2), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
            }
        } else {
            data = JoinRoomScreen$lambda$0$0(state).getData();
            y.f(data);
            if (data.isAlreadyIn()) {
                data6 = JoinRoomScreen$lambda$0$0(state).getData();
                y.f(data6);
                if (data6.isChannel()) {
                    NavLinks navLinks3 = NavLinks.INSTANCE;
                    v5.f gson3 = joinRoomViewModel.getGson();
                    JoinRoomState data11 = JoinRoomScreen$lambda$0$0(state).getData();
                    y.f(data11);
                    String strT3 = gson3.t(new ChatParams(data11.getId(), 2, w.n(), 0, 8, null));
                    y.h(strT3, "toJson(...)");
                    NavController.navigate$default((NavController) navHostController, navLinks3.goChat(2, strT3), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
                } else {
                    data2 = JoinRoomScreen$lambda$0$0(state).getData();
                    y.f(data2);
                    if (data2.isAlreadyIn()) {
                        data5 = JoinRoomScreen$lambda$0$0(state).getData();
                        y.f(data5);
                        if (data5.isChannel()) {
                            joinRoomViewModel.joinChannel(str);
                        } else {
                            data3 = JoinRoomScreen$lambda$0$0(state).getData();
                            y.f(data3);
                            if (!data3.isAlreadyIn()) {
                                data4 = JoinRoomScreen$lambda$0$0(state).getData();
                                y.f(data4);
                                if (!data4.isChannel()) {
                                    joinRoomViewModel.joinGroup(str);
                                }
                            }
                        }
                    } else {
                        data3 = JoinRoomScreen$lambda$0$0(state).getData();
                        y.f(data3);
                        if (!data3.isAlreadyIn()) {
                            data4 = JoinRoomScreen$lambda$0$0(state).getData();
                            y.f(data4);
                            if (!data4.isChannel()) {
                                joinRoomViewModel.joinGroup(str);
                            }
                        }
                    }
                }
            } else {
                data2 = JoinRoomScreen$lambda$0$0(state).getData();
                y.f(data2);
                if (data2.isAlreadyIn()) {
                    data5 = JoinRoomScreen$lambda$0$0(state).getData();
                    y.f(data5);
                    if (data5.isChannel()) {
                        joinRoomViewModel.joinChannel(str);
                    } else {
                        data3 = JoinRoomScreen$lambda$0$0(state).getData();
                        y.f(data3);
                        if (!data3.isAlreadyIn()) {
                            data4 = JoinRoomScreen$lambda$0$0(state).getData();
                            y.f(data4);
                            if (!data4.isChannel()) {
                                joinRoomViewModel.joinGroup(str);
                            }
                        }
                    }
                } else {
                    data3 = JoinRoomScreen$lambda$0$0(state).getData();
                    y.f(data3);
                    if (!data3.isAlreadyIn()) {
                        data4 = JoinRoomScreen$lambda$0$0(state).getData();
                        y.f(data4);
                        if (!data4.isChannel()) {
                            joinRoomViewModel.joinGroup(str);
                        }
                    }
                }
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 JoinRoomScreen$lambda$0$4$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 JoinRoomScreen$lambda$1(NavHostController navHostController, String str, JoinRoomViewModel joinRoomViewModel, int i10, int i11, Composer composer, int i12) {
        JoinRoomScreen(navHostController, str, joinRoomViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final float toRadians(float f10) {
        return (f10 * 3.1415927f) / 180.0f;
    }
}
