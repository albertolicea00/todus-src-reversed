package cu.z17.views.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import androidx.annotation.RequiresPermission;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleEventObserver;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.z17.views.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import org.osmdroid.views.MapView;
import ua.k0;
import zh.h;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aw\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b²\u0006\u000e\u0010\u001a\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "startLatitude", "startLongitude", "startZoom", "", "canSelectCustom", "", "centerOn", "Lcu/z17/views/map/Z17MapMarker;", "currentPoint", "", "otherPoints", "Lkotlin/Function1;", "Lua/k0;", "updateMarker", "Z17MapView", "(Landroidx/compose/ui/Modifier;DDDZLjava/lang/String;Lcu/z17/views/map/Z17MapMarker;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lorg/osmdroid/views/MapView;", "rememberMapViewWithLifecycle", "(DDDLandroidx/compose/runtime/Composer;I)Lorg/osmdroid/views/MapView;", "mapView", "Landroidx/lifecycle/LifecycleEventObserver;", "rememberMapLifecycleObserver", "(Lorg/osmdroid/views/MapView;Landroidx/compose/runtime/Composer;I)Landroidx/lifecycle/LifecycleEventObserver;", "isCentered", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17MapViewKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x0139  */
    /* JADX WARN: Code duplicated, block: B:104:0x013c  */
    /* JADX WARN: Code duplicated, block: B:106:0x013f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0145  */
    /* JADX WARN: Code duplicated, block: B:110:0x014a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0152  */
    /* JADX WARN: Code duplicated, block: B:113:0x0155  */
    /* JADX WARN: Code duplicated, block: B:114:0x0158  */
    /* JADX WARN: Code duplicated, block: B:116:0x015c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0160  */
    /* JADX WARN: Code duplicated, block: B:120:0x0169  */
    /* JADX WARN: Code duplicated, block: B:123:0x0178  */
    /* JADX WARN: Code duplicated, block: B:124:0x0184  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:130:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:133:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:136:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:141:0x0213  */
    /* JADX WARN: Code duplicated, block: B:142:0x0216  */
    /* JADX WARN: Code duplicated, block: B:145:0x0222  */
    /* JADX WARN: Code duplicated, block: B:146:0x0225  */
    /* JADX WARN: Code duplicated, block: B:149:0x023b  */
    /* JADX WARN: Code duplicated, block: B:152:0x0254  */
    /* JADX WARN: Code duplicated, block: B:156:0x025e  */
    /* JADX WARN: Code duplicated, block: B:159:0x028e  */
    /* JADX WARN: Code duplicated, block: B:161:0x0299  */
    /* JADX WARN: Code duplicated, block: B:164:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x008b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00da  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x0108  */
    /* JADX WARN: Code duplicated, block: B:90:0x010b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0115  */
    /* JADX WARN: Code duplicated, block: B:95:0x011c  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @SuppressLint({"ClickableViewAccessibility"})
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @Composable
    public static final void Z17MapView(Modifier modifier, double d10, double d11, double d12, boolean z10, String str, final Z17MapMarker z17MapMarker, final List<Z17MapMarker> otherPoints, final Function1 updateMarker, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        double d13;
        double d14;
        int i13;
        int i14;
        int i15;
        boolean z11;
        int i16;
        int i17;
        int i18;
        boolean z12;
        Composer composer2;
        final String str2;
        final boolean z13;
        final Modifier modifier3;
        final double d15;
        final double d16;
        final double d17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        double d18;
        double d19;
        double d20;
        boolean z14;
        final String str3;
        Modifier modifier5;
        int i19;
        Composer composer3;
        final MapView mapViewRememberMapViewWithLifecycle;
        final Context context;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        final ArrayList arrayList;
        Object objRememberedValue3;
        final Map map;
        boolean zChangedInstance;
        int i20;
        Object objRememberedValue4;
        boolean z15;
        boolean z16;
        boolean zChangedInstance2;
        Object objRememberedValue5;
        final boolean z17;
        int i21;
        int i22;
        int i23;
        int i24;
        y.i(otherPoints, "otherPoints");
        y.i(updateMarker, "updateMarker");
        Composer composerStartRestartGroup = composer.startRestartGroup(175950166);
        int i25 = i11 & 1;
        if (i25 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        int i26 = i11 & 2;
        if (i26 == 0) {
            if ((i10 & 48) == 0) {
                d13 = d10;
                i12 |= composerStartRestartGroup.changed(d13) ? 32 : 16;
            }
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                d14 = d11;
                if ((i11 & 4) == 0 || !composerStartRestartGroup.changed(d14)) {
                    i24 = 128;
                } else {
                    i24 = 256;
                }
                i12 |= i24;
            } else {
                d14 = d11;
            }
            i13 = i11 & 8;
            if (i13 != 0) {
                i12 |= 3072;
            } else if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changed(d12)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i12 |= i14;
            }
            i15 = i11 & 16;
            if (i15 != 0) {
                if ((i10 & 24576) == 0) {
                    z11 = z10;
                    if (composerStartRestartGroup.changed(z11)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i12 |= i16;
                }
                i17 = i11 & 32;
                if (i17 != 0) {
                    if ((196608 & i10) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i18 = 131072;
                        } else {
                            i18 = 65536;
                        }
                        i12 |= i18;
                    }
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(z17MapMarker)) {
                            i23 = 1048576;
                        } else {
                            i23 = 524288;
                        }
                        i12 |= i23;
                    }
                    if ((i10 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(otherPoints)) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                        i12 |= i22;
                    }
                    if ((i10 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(updateMarker)) {
                            i21 = 67108864;
                        } else {
                            i21 = 33554432;
                        }
                        i12 |= i21;
                    }
                    if ((i12 & 38347923) != 38347922) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i25 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i26 != 0) {
                                d18 = 22.261369d;
                            } else {
                                d18 = d13;
                            }
                            if ((i11 & 4) != 0) {
                                i12 &= -897;
                                d19 = -79.577868d;
                            } else {
                                d19 = d14;
                            }
                            if (i13 != 0) {
                                d20 = 11.0d;
                            } else {
                                d20 = d12;
                            }
                            if (i15 != 0) {
                                z11 = false;
                            }
                            if (i17 != 0) {
                                str3 = "";
                                z14 = z11;
                            } else {
                                z14 = z11;
                                str3 = str;
                            }
                            d14 = d19;
                            modifier5 = modifier4;
                            i19 = i12;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i11 & 4) != 0) {
                                i12 &= -897;
                            }
                            boolean z18 = z11;
                            composerStartRestartGroup = composerStartRestartGroup;
                            z14 = z18;
                            i19 = i12;
                            d18 = d13;
                            d20 = d12;
                            modifier5 = modifier2;
                            str3 = str;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(175950166, i19, -1, "cu.z17.views.map.Z17MapView (Z17MapView.kt:43)");
                        }
                        double d21 = d18;
                        composer3 = composerStartRestartGroup;
                        double d22 = d20;
                        double d23 = d14;
                        mapViewRememberMapViewWithLifecycle = rememberMapViewWithLifecycle(d21, d23, d22, composer3, (i19 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                        context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        objRememberedValue = composer3.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new ArrayList();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        arrayList = (ArrayList) objRememberedValue2;
                        objRememberedValue3 = composer3.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new LinkedHashMap();
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        map = (Map) objRememberedValue3;
                        zChangedInstance = composer3.changedInstance(mapViewRememberMapViewWithLifecycle);
                        i20 = i19;
                        objRememberedValue4 = composer3.rememberedValue();
                        if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function1 = (Function1) objRememberedValue4;
                        if ((i20 & 57344) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z19 = z15;
                        if ((i20 & 234881024) == 67108864) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        zChangedInstance2 = z19 | z16 | composer3.changedInstance(z17MapMarker) | composer3.changedInstance(arrayList) | ((i20 & 458752) == 131072) | composer3.changedInstance(map) | composer3.changedInstance(context) | composer3.changedInstance(otherPoints);
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                            z17 = z14;
                            Function1 function2 = new Function1() { // from class: cu.z17.views.map.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                                }
                            };
                            composer3.updateRememberedValue(function2);
                            objRememberedValue5 = function2;
                        } else {
                            z17 = z14;
                        }
                        Modifier modifier6 = modifier5;
                        AndroidView_androidKt.AndroidView(function1, modifier6, (Function1) objRememberedValue5, composer3, (i20 << 3) & 112, 0);
                        modifier3 = modifier6;
                        composer2 = composer3;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z13 = z17;
                        str2 = str3;
                        d15 = d21;
                        d16 = d23;
                        d17 = d22;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        str2 = str;
                        z13 = z11;
                        modifier3 = modifier2;
                        d15 = d13;
                        d16 = d14;
                        d17 = d12;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.map.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17MapViewKt.Z17MapView$lambda$19(modifier3, d15, d16, d17, z13, str2, z17MapMarker, otherPoints, updateMarker, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(z17MapMarker)) {
                        i23 = 1048576;
                    } else {
                        i23 = 524288;
                    }
                    i12 |= i23;
                }
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(otherPoints)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i12 |= i22;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(updateMarker)) {
                        i21 = 67108864;
                    } else {
                        i21 = 33554432;
                    }
                    i12 |= i21;
                }
                if ((i12 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i25 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i26 != 0) {
                            d18 = 22.261369d;
                        } else {
                            d18 = d13;
                        }
                        if ((i11 & 4) != 0) {
                            i12 &= -897;
                            d19 = -79.577868d;
                        } else {
                            d19 = d14;
                        }
                        if (i13 != 0) {
                            d20 = 11.0d;
                        } else {
                            d20 = d12;
                        }
                        if (i15 != 0) {
                            z11 = false;
                        }
                        if (i17 != 0) {
                            str3 = "";
                            z14 = z11;
                        } else {
                            z14 = z11;
                            str3 = str;
                        }
                        d14 = d19;
                        modifier5 = modifier4;
                        i19 = i12;
                    } else {
                        if (i25 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i26 != 0) {
                            d18 = 22.261369d;
                        } else {
                            d18 = d13;
                        }
                        if ((i11 & 4) != 0) {
                            i12 &= -897;
                            d19 = -79.577868d;
                        } else {
                            d19 = d14;
                        }
                        if (i13 != 0) {
                            d20 = 11.0d;
                        } else {
                            d20 = d12;
                        }
                        if (i15 != 0) {
                            z11 = false;
                        }
                        if (i17 != 0) {
                            str3 = "";
                            z14 = z11;
                        } else {
                            z14 = z11;
                            str3 = str;
                        }
                        d14 = d19;
                        modifier5 = modifier4;
                        i19 = i12;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175950166, i19, -1, "cu.z17.views.map.Z17MapView (Z17MapView.kt:43)");
                    }
                    double d24 = d18;
                    composer3 = composerStartRestartGroup;
                    double d25 = d20;
                    double d26 = d14;
                    mapViewRememberMapViewWithLifecycle = rememberMapViewWithLifecycle(d24, d26, d25, composer3, (i19 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                    context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    objRememberedValue = composer3.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new ArrayList();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    arrayList = (ArrayList) objRememberedValue2;
                    objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new LinkedHashMap();
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    map = (Map) objRememberedValue3;
                    zChangedInstance = composer3.changedInstance(mapViewRememberMapViewWithLifecycle);
                    i20 = i19;
                    objRememberedValue4 = composer3.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function3 = (Function1) objRememberedValue4;
                    if ((i20 & 57344) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z110 = z15;
                    if ((i20 & 234881024) == 67108864) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    zChangedInstance2 = z110 | z16 | composer3.changedInstance(z17MapMarker) | composer3.changedInstance(arrayList) | ((i20 & 458752) == 131072) | composer3.changedInstance(map) | composer3.changedInstance(context) | composer3.changedInstance(otherPoints);
                    objRememberedValue5 = composer3.rememberedValue();
                    if (zChangedInstance2) {
                        z17 = z14;
                        Function1 function4 = new Function1() { // from class: cu.z17.views.map.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                            }
                        };
                        composer3.updateRememberedValue(function4);
                        objRememberedValue5 = function4;
                    } else {
                        z17 = z14;
                        Function1 function5 = new Function1() { // from class: cu.z17.views.map.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                            }
                        };
                        composer3.updateRememberedValue(function5);
                        objRememberedValue5 = function5;
                    }
                    Modifier modifier7 = modifier5;
                    AndroidView_androidKt.AndroidView(function3, modifier7, (Function1) objRememberedValue5, composer3, (i20 << 3) & 112, 0);
                    modifier3 = modifier7;
                    composer2 = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z13 = z17;
                    str2 = str3;
                    d15 = d24;
                    d16 = d26;
                    d17 = d25;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    str2 = str;
                    z13 = z11;
                    modifier3 = modifier2;
                    d15 = d13;
                    d16 = d14;
                    d17 = d12;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.map.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17MapViewKt.Z17MapView$lambda$19(modifier3, d15, d16, d17, z13, str2, z17MapMarker, otherPoints, updateMarker, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            z11 = z10;
            i17 = i11 & 32;
            if (i17 != 0) {
                if ((196608 & i10) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i12 |= i18;
                }
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(z17MapMarker)) {
                        i23 = 1048576;
                    } else {
                        i23 = 524288;
                    }
                    i12 |= i23;
                }
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(otherPoints)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i12 |= i22;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(updateMarker)) {
                        i21 = 67108864;
                    } else {
                        i21 = 33554432;
                    }
                    i12 |= i21;
                }
                if ((i12 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i25 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i26 != 0) {
                            d18 = 22.261369d;
                        } else {
                            d18 = d13;
                        }
                        if ((i11 & 4) != 0) {
                            i12 &= -897;
                            d19 = -79.577868d;
                        } else {
                            d19 = d14;
                        }
                        if (i13 != 0) {
                            d20 = 11.0d;
                        } else {
                            d20 = d12;
                        }
                        if (i15 != 0) {
                            z11 = false;
                        }
                        if (i17 != 0) {
                            str3 = "";
                            z14 = z11;
                        } else {
                            z14 = z11;
                            str3 = str;
                        }
                        d14 = d19;
                        modifier5 = modifier4;
                        i19 = i12;
                    } else {
                        if (i25 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i26 != 0) {
                            d18 = 22.261369d;
                        } else {
                            d18 = d13;
                        }
                        if ((i11 & 4) != 0) {
                            i12 &= -897;
                            d19 = -79.577868d;
                        } else {
                            d19 = d14;
                        }
                        if (i13 != 0) {
                            d20 = 11.0d;
                        } else {
                            d20 = d12;
                        }
                        if (i15 != 0) {
                            z11 = false;
                        }
                        if (i17 != 0) {
                            str3 = "";
                            z14 = z11;
                        } else {
                            z14 = z11;
                            str3 = str;
                        }
                        d14 = d19;
                        modifier5 = modifier4;
                        i19 = i12;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175950166, i19, -1, "cu.z17.views.map.Z17MapView (Z17MapView.kt:43)");
                    }
                    double d27 = d18;
                    composer3 = composerStartRestartGroup;
                    double d28 = d20;
                    double d29 = d14;
                    mapViewRememberMapViewWithLifecycle = rememberMapViewWithLifecycle(d27, d29, d28, composer3, (i19 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                    context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    objRememberedValue = composer3.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new ArrayList();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    arrayList = (ArrayList) objRememberedValue2;
                    objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new LinkedHashMap();
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    map = (Map) objRememberedValue3;
                    zChangedInstance = composer3.changedInstance(mapViewRememberMapViewWithLifecycle);
                    i20 = i19;
                    objRememberedValue4 = composer3.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function6 = (Function1) objRememberedValue4;
                    if ((i20 & 57344) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z111 = z15;
                    if ((i20 & 234881024) == 67108864) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    zChangedInstance2 = z111 | z16 | composer3.changedInstance(z17MapMarker) | composer3.changedInstance(arrayList) | ((i20 & 458752) == 131072) | composer3.changedInstance(map) | composer3.changedInstance(context) | composer3.changedInstance(otherPoints);
                    objRememberedValue5 = composer3.rememberedValue();
                    if (zChangedInstance2) {
                        z17 = z14;
                        Function1 function7 = new Function1() { // from class: cu.z17.views.map.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                            }
                        };
                        composer3.updateRememberedValue(function7);
                        objRememberedValue5 = function7;
                    } else {
                        z17 = z14;
                        Function1 function8 = new Function1() { // from class: cu.z17.views.map.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                            }
                        };
                        composer3.updateRememberedValue(function8);
                        objRememberedValue5 = function8;
                    }
                    Modifier modifier8 = modifier5;
                    AndroidView_androidKt.AndroidView(function6, modifier8, (Function1) objRememberedValue5, composer3, (i20 << 3) & 112, 0);
                    modifier3 = modifier8;
                    composer2 = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z13 = z17;
                    str2 = str3;
                    d15 = d27;
                    d16 = d29;
                    d17 = d28;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    str2 = str;
                    z13 = z11;
                    modifier3 = modifier2;
                    d15 = d13;
                    d16 = d14;
                    d17 = d12;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.map.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17MapViewKt.Z17MapView$lambda$19(modifier3, d15, d16, d17, z13, str2, z17MapMarker, otherPoints, updateMarker, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(z17MapMarker)) {
                    i23 = 1048576;
                } else {
                    i23 = 524288;
                }
                i12 |= i23;
            }
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(otherPoints)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i12 |= i22;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(updateMarker)) {
                    i21 = 67108864;
                } else {
                    i21 = 33554432;
                }
                i12 |= i21;
            }
            if ((i12 & 38347923) != 38347922) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i25 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i26 != 0) {
                        d18 = 22.261369d;
                    } else {
                        d18 = d13;
                    }
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                        d19 = -79.577868d;
                    } else {
                        d19 = d14;
                    }
                    if (i13 != 0) {
                        d20 = 11.0d;
                    } else {
                        d20 = d12;
                    }
                    if (i15 != 0) {
                        z11 = false;
                    }
                    if (i17 != 0) {
                        str3 = "";
                        z14 = z11;
                    } else {
                        z14 = z11;
                        str3 = str;
                    }
                    d14 = d19;
                    modifier5 = modifier4;
                    i19 = i12;
                } else {
                    if (i25 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i26 != 0) {
                        d18 = 22.261369d;
                    } else {
                        d18 = d13;
                    }
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                        d19 = -79.577868d;
                    } else {
                        d19 = d14;
                    }
                    if (i13 != 0) {
                        d20 = 11.0d;
                    } else {
                        d20 = d12;
                    }
                    if (i15 != 0) {
                        z11 = false;
                    }
                    if (i17 != 0) {
                        str3 = "";
                        z14 = z11;
                    } else {
                        z14 = z11;
                        str3 = str;
                    }
                    d14 = d19;
                    modifier5 = modifier4;
                    i19 = i12;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175950166, i19, -1, "cu.z17.views.map.Z17MapView (Z17MapView.kt:43)");
                }
                double d210 = d18;
                composer3 = composerStartRestartGroup;
                double d211 = d20;
                double d212 = d14;
                mapViewRememberMapViewWithLifecycle = rememberMapViewWithLifecycle(d210, d212, d211, composer3, (i19 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composer3.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new ArrayList();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                arrayList = (ArrayList) objRememberedValue2;
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new LinkedHashMap();
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                map = (Map) objRememberedValue3;
                zChangedInstance = composer3.changedInstance(mapViewRememberMapViewWithLifecycle);
                i20 = i19;
                objRememberedValue4 = composer3.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                Function1 function9 = (Function1) objRememberedValue4;
                if ((i20 & 57344) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z112 = z15;
                if ((i20 & 234881024) == 67108864) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                zChangedInstance2 = z112 | z16 | composer3.changedInstance(z17MapMarker) | composer3.changedInstance(arrayList) | ((i20 & 458752) == 131072) | composer3.changedInstance(map) | composer3.changedInstance(context) | composer3.changedInstance(otherPoints);
                objRememberedValue5 = composer3.rememberedValue();
                if (zChangedInstance2) {
                    z17 = z14;
                    Function1 function10 = new Function1() { // from class: cu.z17.views.map.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                        }
                    };
                    composer3.updateRememberedValue(function10);
                    objRememberedValue5 = function10;
                } else {
                    z17 = z14;
                    Function1 function11 = new Function1() { // from class: cu.z17.views.map.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                        }
                    };
                    composer3.updateRememberedValue(function11);
                    objRememberedValue5 = function11;
                }
                Modifier modifier9 = modifier5;
                AndroidView_androidKt.AndroidView(function9, modifier9, (Function1) objRememberedValue5, composer3, (i20 << 3) & 112, 0);
                modifier3 = modifier9;
                composer2 = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z17;
                str2 = str3;
                d15 = d210;
                d16 = d212;
                d17 = d211;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str2 = str;
                z13 = z11;
                modifier3 = modifier2;
                d15 = d13;
                d16 = d14;
                d17 = d12;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.map.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17MapViewKt.Z17MapView$lambda$19(modifier3, d15, d16, d17, z13, str2, z17MapMarker, otherPoints, updateMarker, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        d13 = d10;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            d14 = d11;
            if ((i11 & 4) == 0) {
                i24 = 128;
            } else {
                i24 = 128;
            }
            i12 |= i24;
        } else {
            d14 = d11;
        }
        i13 = i11 & 8;
        if (i13 != 0) {
            i12 |= 3072;
        } else if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changed(d12)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i12 |= i14;
        }
        i15 = i11 & 16;
        if (i15 != 0) {
            if ((i10 & 24576) == 0) {
                z11 = z10;
                if (composerStartRestartGroup.changed(z11)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i12 |= i16;
            }
            i17 = i11 & 32;
            if (i17 != 0) {
                if ((196608 & i10) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i12 |= i18;
                }
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(z17MapMarker)) {
                        i23 = 1048576;
                    } else {
                        i23 = 524288;
                    }
                    i12 |= i23;
                }
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(otherPoints)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i12 |= i22;
                }
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(updateMarker)) {
                        i21 = 67108864;
                    } else {
                        i21 = 33554432;
                    }
                    i12 |= i21;
                }
                if ((i12 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i25 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i26 != 0) {
                            d18 = 22.261369d;
                        } else {
                            d18 = d13;
                        }
                        if ((i11 & 4) != 0) {
                            i12 &= -897;
                            d19 = -79.577868d;
                        } else {
                            d19 = d14;
                        }
                        if (i13 != 0) {
                            d20 = 11.0d;
                        } else {
                            d20 = d12;
                        }
                        if (i15 != 0) {
                            z11 = false;
                        }
                        if (i17 != 0) {
                            str3 = "";
                            z14 = z11;
                        } else {
                            z14 = z11;
                            str3 = str;
                        }
                        d14 = d19;
                        modifier5 = modifier4;
                        i19 = i12;
                    } else {
                        if (i25 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i26 != 0) {
                            d18 = 22.261369d;
                        } else {
                            d18 = d13;
                        }
                        if ((i11 & 4) != 0) {
                            i12 &= -897;
                            d19 = -79.577868d;
                        } else {
                            d19 = d14;
                        }
                        if (i13 != 0) {
                            d20 = 11.0d;
                        } else {
                            d20 = d12;
                        }
                        if (i15 != 0) {
                            z11 = false;
                        }
                        if (i17 != 0) {
                            str3 = "";
                            z14 = z11;
                        } else {
                            z14 = z11;
                            str3 = str;
                        }
                        d14 = d19;
                        modifier5 = modifier4;
                        i19 = i12;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175950166, i19, -1, "cu.z17.views.map.Z17MapView (Z17MapView.kt:43)");
                    }
                    double d213 = d18;
                    composer3 = composerStartRestartGroup;
                    double d214 = d20;
                    double d215 = d14;
                    mapViewRememberMapViewWithLifecycle = rememberMapViewWithLifecycle(d213, d215, d214, composer3, (i19 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                    context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    objRememberedValue = composer3.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new ArrayList();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    arrayList = (ArrayList) objRememberedValue2;
                    objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new LinkedHashMap();
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    map = (Map) objRememberedValue3;
                    zChangedInstance = composer3.changedInstance(mapViewRememberMapViewWithLifecycle);
                    i20 = i19;
                    objRememberedValue4 = composer3.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function12 = (Function1) objRememberedValue4;
                    if ((i20 & 57344) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z113 = z15;
                    if ((i20 & 234881024) == 67108864) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    zChangedInstance2 = z113 | z16 | composer3.changedInstance(z17MapMarker) | composer3.changedInstance(arrayList) | ((i20 & 458752) == 131072) | composer3.changedInstance(map) | composer3.changedInstance(context) | composer3.changedInstance(otherPoints);
                    objRememberedValue5 = composer3.rememberedValue();
                    if (zChangedInstance2) {
                        z17 = z14;
                        Function1 function13 = new Function1() { // from class: cu.z17.views.map.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                            }
                        };
                        composer3.updateRememberedValue(function13);
                        objRememberedValue5 = function13;
                    } else {
                        z17 = z14;
                        Function1 function14 = new Function1() { // from class: cu.z17.views.map.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                            }
                        };
                        composer3.updateRememberedValue(function14);
                        objRememberedValue5 = function14;
                    }
                    Modifier modifier10 = modifier5;
                    AndroidView_androidKt.AndroidView(function12, modifier10, (Function1) objRememberedValue5, composer3, (i20 << 3) & 112, 0);
                    modifier3 = modifier10;
                    composer2 = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z13 = z17;
                    str2 = str3;
                    d15 = d213;
                    d16 = d215;
                    d17 = d214;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    str2 = str;
                    z13 = z11;
                    modifier3 = modifier2;
                    d15 = d13;
                    d16 = d14;
                    d17 = d12;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.map.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17MapViewKt.Z17MapView$lambda$19(modifier3, d15, d16, d17, z13, str2, z17MapMarker, otherPoints, updateMarker, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(z17MapMarker)) {
                    i23 = 1048576;
                } else {
                    i23 = 524288;
                }
                i12 |= i23;
            }
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(otherPoints)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i12 |= i22;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(updateMarker)) {
                    i21 = 67108864;
                } else {
                    i21 = 33554432;
                }
                i12 |= i21;
            }
            if ((i12 & 38347923) != 38347922) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i25 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i26 != 0) {
                        d18 = 22.261369d;
                    } else {
                        d18 = d13;
                    }
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                        d19 = -79.577868d;
                    } else {
                        d19 = d14;
                    }
                    if (i13 != 0) {
                        d20 = 11.0d;
                    } else {
                        d20 = d12;
                    }
                    if (i15 != 0) {
                        z11 = false;
                    }
                    if (i17 != 0) {
                        str3 = "";
                        z14 = z11;
                    } else {
                        z14 = z11;
                        str3 = str;
                    }
                    d14 = d19;
                    modifier5 = modifier4;
                    i19 = i12;
                } else {
                    if (i25 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i26 != 0) {
                        d18 = 22.261369d;
                    } else {
                        d18 = d13;
                    }
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                        d19 = -79.577868d;
                    } else {
                        d19 = d14;
                    }
                    if (i13 != 0) {
                        d20 = 11.0d;
                    } else {
                        d20 = d12;
                    }
                    if (i15 != 0) {
                        z11 = false;
                    }
                    if (i17 != 0) {
                        str3 = "";
                        z14 = z11;
                    } else {
                        z14 = z11;
                        str3 = str;
                    }
                    d14 = d19;
                    modifier5 = modifier4;
                    i19 = i12;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175950166, i19, -1, "cu.z17.views.map.Z17MapView (Z17MapView.kt:43)");
                }
                double d216 = d18;
                composer3 = composerStartRestartGroup;
                double d217 = d20;
                double d218 = d14;
                mapViewRememberMapViewWithLifecycle = rememberMapViewWithLifecycle(d216, d218, d217, composer3, (i19 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composer3.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new ArrayList();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                arrayList = (ArrayList) objRememberedValue2;
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new LinkedHashMap();
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                map = (Map) objRememberedValue3;
                zChangedInstance = composer3.changedInstance(mapViewRememberMapViewWithLifecycle);
                i20 = i19;
                objRememberedValue4 = composer3.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                Function1 function15 = (Function1) objRememberedValue4;
                if ((i20 & 57344) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z114 = z15;
                if ((i20 & 234881024) == 67108864) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                zChangedInstance2 = z114 | z16 | composer3.changedInstance(z17MapMarker) | composer3.changedInstance(arrayList) | ((i20 & 458752) == 131072) | composer3.changedInstance(map) | composer3.changedInstance(context) | composer3.changedInstance(otherPoints);
                objRememberedValue5 = composer3.rememberedValue();
                if (zChangedInstance2) {
                    z17 = z14;
                    Function1 function16 = new Function1() { // from class: cu.z17.views.map.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                        }
                    };
                    composer3.updateRememberedValue(function16);
                    objRememberedValue5 = function16;
                } else {
                    z17 = z14;
                    Function1 function17 = new Function1() { // from class: cu.z17.views.map.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                        }
                    };
                    composer3.updateRememberedValue(function17);
                    objRememberedValue5 = function17;
                }
                Modifier modifier11 = modifier5;
                AndroidView_androidKt.AndroidView(function15, modifier11, (Function1) objRememberedValue5, composer3, (i20 << 3) & 112, 0);
                modifier3 = modifier11;
                composer2 = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z17;
                str2 = str3;
                d15 = d216;
                d16 = d218;
                d17 = d217;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str2 = str;
                z13 = z11;
                modifier3 = modifier2;
                d15 = d13;
                d16 = d14;
                d17 = d12;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.map.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17MapViewKt.Z17MapView$lambda$19(modifier3, d15, d16, d17, z13, str2, z17MapMarker, otherPoints, updateMarker, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        z11 = z10;
        i17 = i11 & 32;
        if (i17 != 0) {
            if ((196608 & i10) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i12 |= i18;
            }
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(z17MapMarker)) {
                    i23 = 1048576;
                } else {
                    i23 = 524288;
                }
                i12 |= i23;
            }
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(otherPoints)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i12 |= i22;
            }
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(updateMarker)) {
                    i21 = 67108864;
                } else {
                    i21 = 33554432;
                }
                i12 |= i21;
            }
            if ((i12 & 38347923) != 38347922) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i25 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i26 != 0) {
                        d18 = 22.261369d;
                    } else {
                        d18 = d13;
                    }
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                        d19 = -79.577868d;
                    } else {
                        d19 = d14;
                    }
                    if (i13 != 0) {
                        d20 = 11.0d;
                    } else {
                        d20 = d12;
                    }
                    if (i15 != 0) {
                        z11 = false;
                    }
                    if (i17 != 0) {
                        str3 = "";
                        z14 = z11;
                    } else {
                        z14 = z11;
                        str3 = str;
                    }
                    d14 = d19;
                    modifier5 = modifier4;
                    i19 = i12;
                } else {
                    if (i25 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i26 != 0) {
                        d18 = 22.261369d;
                    } else {
                        d18 = d13;
                    }
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                        d19 = -79.577868d;
                    } else {
                        d19 = d14;
                    }
                    if (i13 != 0) {
                        d20 = 11.0d;
                    } else {
                        d20 = d12;
                    }
                    if (i15 != 0) {
                        z11 = false;
                    }
                    if (i17 != 0) {
                        str3 = "";
                        z14 = z11;
                    } else {
                        z14 = z11;
                        str3 = str;
                    }
                    d14 = d19;
                    modifier5 = modifier4;
                    i19 = i12;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175950166, i19, -1, "cu.z17.views.map.Z17MapView (Z17MapView.kt:43)");
                }
                double d219 = d18;
                composer3 = composerStartRestartGroup;
                double d2110 = d20;
                double d2111 = d14;
                mapViewRememberMapViewWithLifecycle = rememberMapViewWithLifecycle(d219, d2111, d2110, composer3, (i19 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composer3.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new ArrayList();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                arrayList = (ArrayList) objRememberedValue2;
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new LinkedHashMap();
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                map = (Map) objRememberedValue3;
                zChangedInstance = composer3.changedInstance(mapViewRememberMapViewWithLifecycle);
                i20 = i19;
                objRememberedValue4 = composer3.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                Function1 function18 = (Function1) objRememberedValue4;
                if ((i20 & 57344) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z115 = z15;
                if ((i20 & 234881024) == 67108864) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                zChangedInstance2 = z115 | z16 | composer3.changedInstance(z17MapMarker) | composer3.changedInstance(arrayList) | ((i20 & 458752) == 131072) | composer3.changedInstance(map) | composer3.changedInstance(context) | composer3.changedInstance(otherPoints);
                objRememberedValue5 = composer3.rememberedValue();
                if (zChangedInstance2) {
                    z17 = z14;
                    Function1 function19 = new Function1() { // from class: cu.z17.views.map.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                        }
                    };
                    composer3.updateRememberedValue(function19);
                    objRememberedValue5 = function19;
                } else {
                    z17 = z14;
                    Function1 function110 = new Function1() { // from class: cu.z17.views.map.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                        }
                    };
                    composer3.updateRememberedValue(function110);
                    objRememberedValue5 = function110;
                }
                Modifier modifier12 = modifier5;
                AndroidView_androidKt.AndroidView(function18, modifier12, (Function1) objRememberedValue5, composer3, (i20 << 3) & 112, 0);
                modifier3 = modifier12;
                composer2 = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z17;
                str2 = str3;
                d15 = d219;
                d16 = d2111;
                d17 = d2110;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str2 = str;
                z13 = z11;
                modifier3 = modifier2;
                d15 = d13;
                d16 = d14;
                d17 = d12;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.map.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17MapViewKt.Z17MapView$lambda$19(modifier3, d15, d16, d17, z13, str2, z17MapMarker, otherPoints, updateMarker, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((i10 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(z17MapMarker)) {
                i23 = 1048576;
            } else {
                i23 = 524288;
            }
            i12 |= i23;
        }
        if ((i10 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(otherPoints)) {
                i22 = 8388608;
            } else {
                i22 = 4194304;
            }
            i12 |= i22;
        }
        if ((i10 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(updateMarker)) {
                i21 = 67108864;
            } else {
                i21 = 33554432;
            }
            i12 |= i21;
        }
        if ((i12 & 38347923) != 38347922) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i25 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i26 != 0) {
                    d18 = 22.261369d;
                } else {
                    d18 = d13;
                }
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                    d19 = -79.577868d;
                } else {
                    d19 = d14;
                }
                if (i13 != 0) {
                    d20 = 11.0d;
                } else {
                    d20 = d12;
                }
                if (i15 != 0) {
                    z11 = false;
                }
                if (i17 != 0) {
                    str3 = "";
                    z14 = z11;
                } else {
                    z14 = z11;
                    str3 = str;
                }
                d14 = d19;
                modifier5 = modifier4;
                i19 = i12;
            } else {
                if (i25 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i26 != 0) {
                    d18 = 22.261369d;
                } else {
                    d18 = d13;
                }
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                    d19 = -79.577868d;
                } else {
                    d19 = d14;
                }
                if (i13 != 0) {
                    d20 = 11.0d;
                } else {
                    d20 = d12;
                }
                if (i15 != 0) {
                    z11 = false;
                }
                if (i17 != 0) {
                    str3 = "";
                    z14 = z11;
                } else {
                    z14 = z11;
                    str3 = str;
                }
                d14 = d19;
                modifier5 = modifier4;
                i19 = i12;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(175950166, i19, -1, "cu.z17.views.map.Z17MapView (Z17MapView.kt:43)");
            }
            double d2112 = d18;
            composer3 = composerStartRestartGroup;
            double d2113 = d20;
            double d2114 = d14;
            mapViewRememberMapViewWithLifecycle = rememberMapViewWithLifecycle(d2112, d2114, d2113, composer3, (i19 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
            context = (Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue = composer3.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new ArrayList();
                composer3.updateRememberedValue(objRememberedValue2);
            }
            arrayList = (ArrayList) objRememberedValue2;
            objRememberedValue3 = composer3.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new LinkedHashMap();
                composer3.updateRememberedValue(objRememberedValue3);
            }
            map = (Map) objRememberedValue3;
            zChangedInstance = composer3.changedInstance(mapViewRememberMapViewWithLifecycle);
            i20 = i19;
            objRememberedValue4 = composer3.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: cu.z17.views.map.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MapViewKt.Z17MapView$lambda$14$lambda$13(mapViewRememberMapViewWithLifecycle, (Context) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            }
            Function1 function111 = (Function1) objRememberedValue4;
            if ((i20 & 57344) == 16384) {
                z15 = true;
            } else {
                z15 = false;
            }
            boolean z116 = z15;
            if ((i20 & 234881024) == 67108864) {
                z16 = true;
            } else {
                z16 = false;
            }
            zChangedInstance2 = z116 | z16 | composer3.changedInstance(z17MapMarker) | composer3.changedInstance(arrayList) | ((i20 & 458752) == 131072) | composer3.changedInstance(map) | composer3.changedInstance(context) | composer3.changedInstance(otherPoints);
            objRememberedValue5 = composer3.rememberedValue();
            if (zChangedInstance2) {
                z17 = z14;
                Function1 function112 = new Function1() { // from class: cu.z17.views.map.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                    }
                };
                composer3.updateRememberedValue(function112);
                objRememberedValue5 = function112;
            } else {
                z17 = z14;
                Function1 function113 = new Function1() { // from class: cu.z17.views.map.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17MapViewKt.Z17MapView$lambda$18$lambda$17(z17MapMarker, otherPoints, z17, updateMarker, context, arrayList, str3, map, mutableState, (MapView) obj);
                    }
                };
                composer3.updateRememberedValue(function113);
                objRememberedValue5 = function113;
            }
            Modifier modifier13 = modifier5;
            AndroidView_androidKt.AndroidView(function111, modifier13, (Function1) objRememberedValue5, composer3, (i20 << 3) & 112, 0);
            modifier3 = modifier13;
            composer2 = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z17;
            str2 = str3;
            d15 = d2112;
            d16 = d2114;
            d17 = d2113;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            str2 = str;
            z13 = z11;
            modifier3 = modifier2;
            d15 = d13;
            d16 = d14;
            d17 = d12;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.map.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17MapViewKt.Z17MapView$lambda$19(modifier3, d15, d16, d17, z13, str2, z17MapMarker, otherPoints, updateMarker, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void Z17MapView$centerMap(MapView mapView, Z17MapMarker z17MapMarker) {
        int i10;
        Location location = new Location("");
        location.setLatitude(z17MapMarker.getLatitude());
        location.setLongitude(z17MapMarker.getLongitude());
        location.setAltitude(z17MapMarker.getAltitude());
        bi.d dVar = new bi.d(location.getLatitude(), location.getLongitude(), location.getAltitude());
        if (location.getAccuracy() < 100.0f) {
            i10 = 18;
        } else if (location.getAccuracy() < 500.0f) {
            i10 = 16;
        } else {
            i10 = location.getAccuracy() < 1000.0f ? 14 : 13;
        }
        double d10 = i10;
        if (mapView.getZoomLevelDouble() < d10) {
            mapView.getController().f(dVar, Double.valueOf(d10), 1000L);
        } else {
            mapView.getController().d(dVar);
        }
    }

    private static final boolean Z17MapView$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MapView Z17MapView$lambda$14$lambda$13(MapView mapView, Context it) {
        y.i(it, "it");
        return mapView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MapView$lambda$18$lambda$17(Z17MapMarker z17MapMarker, List list, final boolean z10, final Function1 function1, Context context, ArrayList arrayList, String str, Map map, MutableState mutableState, final MapView mV) {
        y.i(mV, "mV");
        mV.getOverlays().add(new org.osmdroid.views.overlay.b(new vh.a() { // from class: cu.z17.views.map.Z17MapViewKt$Z17MapView$2$1$mReceive$1
            @Override // vh.a
            public boolean longPressHelper(bi.d p10) {
                if (!z10) {
                    return false;
                }
                if (p10 == null) {
                    return true;
                }
                MapView mapView = mV;
                Function1 function2 = function1;
                mapView.getController().d(p10);
                function2.invoke(new Z17MapMarker(ChatParams.TOSEND, p10.a(), p10.d(), p10.f(), null, null, 0, 112, null));
                return true;
            }

            @Override // vh.a
            public boolean singleTapConfirmedHelper(bi.d p10) {
                return false;
            }
        }));
        mV.invalidate();
        if (z17MapMarker != null) {
            Z17MapView$paintCurrentMarker(arrayList, str, map, mutableState, mV, z17MapMarker, context);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Z17MapMarker z17MapMarker2 = (Z17MapMarker) it.next();
            if (y.d(z17MapMarker2.getId(), ChatParams.TOSEND)) {
                Z17MapView$paintCustomMarker(arrayList, str, mutableState, mV, z17MapMarker2, context);
            } else {
                Z17MapView$paintOtherMarker(arrayList, str, mutableState, mV, z17MapMarker2, context);
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17MapView$lambda$19(Modifier modifier, double d10, double d11, double d12, boolean z10, String str, Z17MapMarker z17MapMarker, List list, Function1 function1, int i10, int i11, Composer composer, int i12) {
        Z17MapView(modifier, d10, d11, d12, z10, str, z17MapMarker, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final void Z17MapView$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void Z17MapView$paintCurrentMarker(ArrayList<org.osmdroid.views.overlay.c> arrayList, String str, Map<String, AccuracyOverlay> map, MutableState<Boolean> mutableState, final MapView mapView, final Z17MapMarker z17MapMarker, Context context) {
        Object next;
        Object obj;
        bi.d dVar = new bi.d(z17MapMarker.getLatitude(), z17MapMarker.getLongitude(), z17MapMarker.getAltitude());
        Iterator<T> it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!y.d(((org.osmdroid.views.overlay.c) next).b(), z17MapMarker.getId()));
        if (next == null) {
            org.osmdroid.views.overlay.c cVar = new org.osmdroid.views.overlay.c(mapView);
            cVar.h(z17MapMarker.getId());
            cVar.t(null);
            arrayList.add(cVar);
            int color = Color.parseColor("#2196F3");
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.location_pointer);
            if (drawable != null) {
                drawable.setTint(color);
            }
            cVar.s(drawable);
            cVar.v(dVar);
            cVar.q(0.5f, 0.5f);
            obj = cVar;
        } else {
            mapView.getOverlays().remove(next);
            ((org.osmdroid.views.overlay.c) next).v(dVar);
            obj = next;
        }
        ((org.osmdroid.views.overlay.c) obj).u(new org.osmdroid.views.overlay.c.a() { // from class: cu.z17.views.map.a
            @Override // org.osmdroid.views.overlay.c.a
            public final boolean a(org.osmdroid.views.overlay.c cVar2, MapView mapView2) {
                return Z17MapViewKt.Z17MapView$paintCurrentMarker$lambda$8(mapView, z17MapMarker, cVar2, mapView2);
            }
        });
        if (!Z17MapView$lambda$1(mutableState) && (str.length() == 0 || y.d(str, "0"))) {
            Z17MapView$centerMap(mapView, z17MapMarker);
            Z17MapView$lambda$2(mutableState, true);
        }
        if (map.get(z17MapMarker.getId()) != null) {
            mapView.getOverlays().remove(map.get(z17MapMarker.getId()));
        }
        int color2 = Color.parseColor("#1976D2");
        String id2 = z17MapMarker.getId();
        Float accuracy = z17MapMarker.getAccuracy();
        map.put(id2, new AccuracyOverlay(dVar, accuracy != null ? accuracy.floatValue() : 0.0f, color2));
        mapView.getOverlays().add(map.get(z17MapMarker.getId()));
        mapView.getOverlays().add(obj);
        mapView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17MapView$paintCurrentMarker$lambda$8(MapView mapView, Z17MapMarker z17MapMarker, org.osmdroid.views.overlay.c cVar, MapView mapView2) {
        Z17MapView$centerMap(mapView, z17MapMarker);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, org.osmdroid.views.overlay.c, org.osmdroid.views.overlay.f] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Iterable, java.util.ArrayList, java.util.ArrayList<org.osmdroid.views.overlay.c>] */
    /* JADX WARN: Type inference failed for: r7v3 */
    private static final void Z17MapView$paintCustomMarker(ArrayList<org.osmdroid.views.overlay.c> arrayList, String str, MutableState<Boolean> mutableState, MapView mapView, Z17MapMarker z17MapMarker, Context context) {
        ?? cVar;
        bi.d dVar = new bi.d(z17MapMarker.getLatitude(), z17MapMarker.getLongitude(), z17MapMarker.getAltitude());
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                cVar = 0;
                break;
            }
            cVar = it.next();
        } while (!y.d(((org.osmdroid.views.overlay.c) cVar).b(), z17MapMarker.getId()));
        if (cVar == 0) {
            cVar = new org.osmdroid.views.overlay.c(mapView);
            cVar.h(z17MapMarker.getId());
            cVar.t(null);
            arrayList.add(cVar);
        }
        int color = Color.parseColor("#000000");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.custom_location_pointer);
        if (drawable != null) {
            drawable.setTint(color);
        }
        org.osmdroid.views.overlay.c cVar2 = (org.osmdroid.views.overlay.c) cVar;
        cVar2.s(drawable);
        cVar2.v(dVar);
        cVar2.q(0.5f, 0.5f);
        if (!Z17MapView$lambda$1(mutableState) && y.d(str, z17MapMarker.getId())) {
            Z17MapView$centerMap(mapView, z17MapMarker);
            Z17MapView$lambda$2(mutableState, true);
        }
        mapView.getOverlays().add(cVar);
        mapView.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, org.osmdroid.views.overlay.c, org.osmdroid.views.overlay.f] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Iterable, java.util.ArrayList, java.util.ArrayList<org.osmdroid.views.overlay.c>] */
    /* JADX WARN: Type inference failed for: r7v3 */
    private static final void Z17MapView$paintOtherMarker(ArrayList<org.osmdroid.views.overlay.c> arrayList, String str, MutableState<Boolean> mutableState, MapView mapView, Z17MapMarker z17MapMarker, Context context) {
        ?? cVar;
        bi.d dVar = new bi.d(z17MapMarker.getLatitude(), z17MapMarker.getLongitude(), z17MapMarker.getAltitude());
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                cVar = 0;
                break;
            }
            cVar = it.next();
        } while (!y.d(((org.osmdroid.views.overlay.c) cVar).b(), z17MapMarker.getId()));
        if (cVar == 0) {
            cVar = new org.osmdroid.views.overlay.c(mapView);
            cVar.h(z17MapMarker.getId());
            cVar.t(null);
            arrayList.add(cVar);
        }
        int color = Color.parseColor("#F44336");
        Drawable drawable = ContextCompat.getDrawable(context, z17MapMarker.getIcon() != 0 ? z17MapMarker.getIcon() : R.drawable.location_pointer);
        if (drawable != null) {
            drawable.setTint(color);
        }
        org.osmdroid.views.overlay.c cVar2 = (org.osmdroid.views.overlay.c) cVar;
        cVar2.s(drawable);
        cVar2.v(dVar);
        cVar2.q(0.5f, 0.5f);
        if (!Z17MapView$lambda$1(mutableState) && y.d(str, z17MapMarker.getId())) {
            Z17MapView$centerMap(mapView, z17MapMarker);
            Z17MapView$lambda$2(mutableState, true);
        }
        mapView.getOverlays().add(cVar);
        mapView.invalidate();
    }

    @Composable
    public static final LifecycleEventObserver rememberMapLifecycleObserver(final MapView mapView, Composer composer, int i10) {
        y.i(mapView, "mapView");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1348448951, i10, -1, "cu.z17.views.map.rememberMapLifecycleObserver (Z17MapView.kt:336)");
        }
        boolean zChanged = composer.changed(mapView);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new LifecycleEventObserver() { // from class: cu.z17.views.map.b
                @Override // androidx.p001lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    Z17MapViewKt.rememberMapLifecycleObserver$lambda$26$lambda$25(mapView, lifecycleOwner, event);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        LifecycleEventObserver lifecycleEventObserver = (LifecycleEventObserver) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lifecycleEventObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rememberMapLifecycleObserver$lambda$26$lambda$25(MapView mapView, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        y.i(lifecycleOwner, "<unused var>");
        y.i(event, "event");
        int i10 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i10 == 1) {
            mapView.C();
        } else {
            if (i10 != 2) {
                return;
            }
            mapView.B();
        }
    }

    @Composable
    public static final MapView rememberMapViewWithLifecycle(double d10, double d11, double d12, Composer composer, int i10) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-451232443, i10, -1, "cu.z17.views.map.rememberMapViewWithLifecycle (Z17MapView.kt:284)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        Object obj = objRememberedValue;
        if (objRememberedValue == companion.getEmpty()) {
            MapView mapView = new MapView(context);
            mapView.setId(R.id.map);
            mapView.setTileSource(new h("OSMPublicTransport", 0, 20, 256, ".png", new String[]{"https://map.todus.cu/styles/basic-preview/"}, "© OpenStreetMap contributors"));
            mapView.getController().b(new bi.d(d10, d11, 10.0d));
            mapView.getController().g(d12);
            mapView.setMaxZoomLevel(Double.valueOf(20.0d));
            mapView.setMinZoomLevel(Double.valueOf(2.0d));
            mapView.getOverlayManager().s().n(0);
            mapView.getOverlayManager().s().o(0);
            mapView.getZoomController().q(org.osmdroid.views.a.f.NEVER);
            mapView.setScrollableAreaLimitDouble(new bi.a(85.0d, 180.0d, -85.0d, -180.0d));
            mapView.setHorizontalMapRepetitionEnabled(false);
            mapView.setVerticalMapRepetitionEnabled(false);
            mapView.N(MapView.getTileSystem().p(), MapView.getTileSystem().w(), 0);
            mapView.setMultiTouchControls(true);
            composer.updateRememberedValue(mapView);
            obj = mapView;
        }
        MapView mapView2 = (MapView) obj;
        final LifecycleEventObserver lifecycleEventObserverRememberMapLifecycleObserver = rememberMapLifecycleObserver(mapView2, composer, 0);
        final Lifecycle lifecycle = ((LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
        boolean zChangedInstance = composer.changedInstance(lifecycle) | composer.changedInstance(lifecycleEventObserverRememberMapLifecycleObserver);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: cu.z17.views.map.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Z17MapViewKt.rememberMapViewWithLifecycle$lambda$24$lambda$23(lifecycle, lifecycleEventObserverRememberMapLifecycleObserver, (DisposableEffectScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(lifecycle, (Function1) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mapView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberMapViewWithLifecycle$lambda$24$lambda$23(final Lifecycle lifecycle, final LifecycleEventObserver lifecycleEventObserver, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        lifecycle.addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: cu.z17.views.map.Z17MapViewKt$rememberMapViewWithLifecycle$lambda$24$lambda$23$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycle.removeObserver(lifecycleEventObserver);
            }
        };
    }
}
