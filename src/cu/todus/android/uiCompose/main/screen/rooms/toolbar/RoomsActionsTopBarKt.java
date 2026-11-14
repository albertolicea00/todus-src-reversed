package cu.todus.android.uiCompose.main.screen.rooms.toolbar;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.VolumeOffKt;
import androidx.compose.material.icons.automirrored.outlined.VolumeUpKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.topBar.Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aq\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "count", "Lcu/todus/android/data/db/pojo/RoomItemView;", "selected", "Lkotlin/Function0;", "Lua/k0;", "onClose", "", "canDelete", "onDelete", "Lkotlin/Function1;", "", "onChangeMuteState", "onPin", "RoomsActionsTopBar", "(Landroidx/navigation/NavHostController;ILcu/todus/android/data/db/pojo/RoomItemView;Llb/a;ZLlb/a;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RoomsActionsTopBarKt {
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:81:0x0120  */
    /* JADX WARN: Code duplicated, block: B:86:0x0130  */
    /* JADX WARN: Code duplicated, block: B:89:0x0162  */
    /* JADX WARN: Code duplicated, block: B:91:0x0168  */
    /* JADX WARN: Code duplicated, block: B:94:0x0172  */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RoomsActionsTopBar(final NavHostController navHostController, final int i10, final RoomItemView roomItemView, final lb.a onClose, final boolean z10, final lb.a onDelete, Function1 function1, final lb.a onPin, Composer composer, final int i11, final int i12) {
        int i13;
        final RoomItemView roomItemView2;
        Function1 function2;
        boolean z11;
        final Function1 function3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function1 function4;
        boolean z12;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i14;
        y.i(navHostController, "navHostController");
        y.i(onClose, "onClose");
        y.i(onDelete, "onDelete");
        y.i(onPin, "onPin");
        Composer composerStartRestartGroup = composer.startRestartGroup(1643821872);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            roomItemView2 = roomItemView;
            i13 |= composerStartRestartGroup.changed(roomItemView2) ? 256 : 128;
        } else {
            roomItemView2 = roomItemView;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onClose) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onDelete) ? 131072 : 65536;
        }
        int i15 = i12 & 64;
        if (i15 == 0) {
            if ((1572864 & i11) == 0) {
                function2 = function1;
                i13 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
            }
            if ((12582912 & i11) == 0) {
                if (composerStartRestartGroup.changedInstance(onPin)) {
                    i14 = 8388608;
                } else {
                    i14 = 4194304;
                }
                i13 |= i14;
            }
            if ((4793491 & i13) != 4793490) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                if (i15 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$0$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function4 = (Function1) objRememberedValue2;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1643821872, i13, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsActionsTopBar (RoomsActionsTopBar.kt:34)");
                }
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(48658365, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                Function1 function5 = function4;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(894875304, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$2(i10, onPin, roomItemView2, function4, z10, onDelete, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                z12 = (i13 & 7168) == 2048;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.k
                        @Override // lb.a
                        public final Object invoke() {
                            return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$3$0(onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Z17TopBarKt.m10304Z17TopBardW2gCk(composableLambdaRememberComposableLambda, null, false, composableLambdaRememberComposableLambda2, false, navHostController, (lb.a) objRememberedValue, CloseKt.getClose(Icons.Outlined.INSTANCE), 0L, 0L, Dp.m8823constructorimpl(4), composerStartRestartGroup, ((i13 << 15) & 458752) | 3078, 6, 790);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.l
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$4(navHostController, i10, roomItemView, onClose, z10, onDelete, function3, onPin, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 1572864;
        function2 = function1;
        if ((12582912 & i11) == 0) {
            if (composerStartRestartGroup.changedInstance(onPin)) {
                i14 = 8388608;
            } else {
                i14 = 4194304;
            }
            i13 |= i14;
        }
        if ((4793491 & i13) != 4793490) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
            if (i15 != 0) {
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$0$0((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function4 = (Function1) objRememberedValue2;
            } else {
                function4 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1643821872, i13, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsActionsTopBar (RoomsActionsTopBar.kt:34)");
            }
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(48658365, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$1(i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function1 function6 = function4;
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(894875304, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$2(i10, onPin, roomItemView2, function4, z10, onDelete, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            if ((i13 & 7168) == 2048) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.k
                    @Override // lb.a
                    public final Object invoke() {
                        return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$3$0(onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.k
                    @Override // lb.a
                    public final Object invoke() {
                        return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$3$0(onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(composableLambdaRememberComposableLambda3, null, false, composableLambdaRememberComposableLambda4, false, navHostController, (lb.a) objRememberedValue, CloseKt.getClose(Icons.Outlined.INSTANCE), 0L, 0L, Dp.m8823constructorimpl(4), composerStartRestartGroup, ((i13 << 15) & 458752) | 3078, 6, 790);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$4(navHostController, i10, roomItemView, onClose, z10, onDelete, function3, onPin, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomsActionsTopBar$lambda$0$0(String it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 RoomsActionsTopBar$lambda$1(int i10, Composer composer, int i11) {
        if (composer.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(48658365, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsActionsTopBar.<anonymous> (RoomsActionsTopBar.kt:36)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, String.valueOf(i10), null, 0L, 0, 0, composer, 0, 61);
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
    public static final k0 RoomsActionsTopBar$lambda$2(int i10, final lb.a aVar, final RoomItemView roomItemView, final Function1 function1, boolean z10, final lb.a aVar2, RowScope Z17TopBar, Composer composer, int i11) {
        y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i11 & 17) != 16, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(894875304, i11, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsActionsTopBar.<anonymous> (RoomsActionsTopBar.kt:38)");
            }
            if (i10 == 1) {
                composer.startReplaceGroup(368216269);
                boolean zChanged = composer.changed(aVar);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.d
                        @Override // lb.a
                        public final Object invoke() {
                            return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$2$0$0(aVar);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue, null, false, null, null, null, ComposableSingletons$RoomsActionsTopBarKt.INSTANCE.getLambda$1183857615$app_productionPFast(), composer, 1572864, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(368567034);
                composer.endReplaceGroup();
            }
            if (roomItemView == null || i10 != 1) {
                composer.startReplaceGroup(369154298);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(981723222);
                boolean zChanged2 = composer.changed(function1) | composer.changed(roomItemView);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.e
                        @Override // lb.a
                        public final Object invoke() {
                            return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$2$1$0(function1, roomItemView);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1209787208, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$2$2(roomItemView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 1572864, 62);
                composer.endReplaceGroup();
            }
            if (z10) {
                composer.startReplaceGroup(981741391);
                boolean zChanged3 = composer.changed(aVar2);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.rooms.toolbar.g
                        @Override // lb.a
                        public final Object invoke() {
                            return RoomsActionsTopBarKt.RoomsActionsTopBar$lambda$2$3$0(aVar2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, null, ComposableSingletons$RoomsActionsTopBarKt.INSTANCE.getLambda$587663255$app_productionPFast(), composer, 1572864, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(369618554);
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
    public static final k0 RoomsActionsTopBar$lambda$2$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomsActionsTopBar$lambda$2$1$0(Function1 function1, RoomItemView roomItemView) {
        function1.invoke(roomItemView.getRoom().getId());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 RoomsActionsTopBar$lambda$2$2(RoomItemView roomItemView, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1209787208, i10, -1, "cu.todus.android.uiCompose.main.screen.rooms.toolbar.RoomsActionsTopBar.<anonymous>.<anonymous> (RoomsActionsTopBar.kt:56)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), roomItemView.getRoom().isMuted() ? VolumeUpKt.getVolumeUp(Icons.AutoMirrored.Outlined.INSTANCE) : VolumeOffKt.getVolumeOff(Icons.AutoMirrored.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomsActionsTopBar$lambda$2$3$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomsActionsTopBar$lambda$3$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RoomsActionsTopBar$lambda$4(NavHostController navHostController, int i10, RoomItemView roomItemView, lb.a aVar, boolean z10, lb.a aVar2, Function1 function1, lb.a aVar3, int i11, int i12, Composer composer, int i13) {
        RoomsActionsTopBar(navHostController, i10, roomItemView, aVar, z10, aVar2, function1, aVar3, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
